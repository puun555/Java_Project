package scenes;

import static helpz.Constant.Tiles.GRASS_TILE;
import static helpz.Constant.Tiles.TOWER_TILE;
import java.awt.Graphics;

import helpz.LevelBuild;
import helpz.LoadSave;
import helpz.Utilz;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import main.Game;
import managers.DecorationManager;
import managers.EnemyManager;
import managers.MageTowerManager;
import managers.ProjectileManager;
import managers.TileManager;
import objects.MageTower;
import ui.InGameBar;


public class Playing extends GameScene implements SceneMethods {
    private int[][] lvl,arrayDecoration;
    private TileManager tileManager;
    private InGameBar gameBar;
    private EnemyManager enemyManager;
    private DecorationManager decorationManager;
    private MageTowerManager mageTowerManager;
    private MageTower selectedTower;
    private ProjectileManager projectileManager;
    private int mouseX,mouseY;
    public Playing(Game game) {
        super(game);
        lvl = LevelBuild.getLevelData();
        arrayDecoration = LevelBuild.getLevelDecoration();
        tileManager = new TileManager();
        gameBar = new InGameBar(0,640,672,180,this);
        decorationManager = new DecorationManager();
        mageTowerManager = new MageTowerManager(this);
        enemyManager = new EnemyManager(this);
        projectileManager = new ProjectileManager(this);
        //LoadSave.readFile();
        saveLevel();
        loadLevel();
         
    }
    public void createLevel(){
        LoadSave.CreateLevel("new Level", Utilz.TwoDTo1DArr(lvl));
    }
       
    public void update(){
        mageTowerManager.update();
        enemyManager.update();
        projectileManager.update();
        updateTick();
    }
    private void saveLevel(){
        LoadSave.SaveLevel("new Level", lvl);
    }
    
    private void loadLevel() {
        lvl = LoadSave.GetLevelData("new Level");
    }
   
    @Override
    public void render(Graphics g) {
        drawLevel(g);
        drawDecoration(g);
        gameBar.draw(g);
        drawHoverTile(g);
        enemyManager.draw(g);
        mageTowerManager.draw(g);
        drawSelectedTower(g);
        projectileManager.draw(g);
    }
    
    private void drawSelectedTower(Graphics g) {
        if(selectedTower != null){
            g.drawImage(mageTowerManager.getMageSprite()[selectedTower.getTowerType()], mouseX, mouseY-28,32,48, null);
            
        }
    }
    
    private void drawHoverTile(Graphics g){
        g.setColor(Color.WHITE);
        if(selectedTower != null){
            if(canPlaceTower(mouseX,mouseY)){
                g.setColor(Color.GREEN);
            }else{
                g.setColor(Color.RED);
            }
        }
        
        g.drawRect(mouseX, mouseY, 32, 32);
    }
    
    public void setSelectedTower(MageTower selectedTower) {
        this.selectedTower = selectedTower;
    }
    public void drawLevel(Graphics g){
        for (int y = 0; y < lvl.length; y++) {
            for (int x = 0; x < lvl[y].length; x++) {
                int id = lvl[y][x];
                if(isAnimation(id)){
                    g.drawImage(getSprite(id,animationIndex),  x * 32, y * 32, null);
                }else{
                    g.drawImage(getSprite(id), x * 32, y * 32, null);
                }
                
            }
        }
    }
    private void drawDecoration(Graphics g) {
         for (int y = 0; y < arrayDecoration.length; y++) {
            for (int x = 0; x < arrayDecoration[y].length; x++) {
                int id = arrayDecoration[y][x];
                    g.drawImage(getTree(id), x * 32, y * 32,null);
            }
        }
    }
    private BufferedImage getTree(int spriteID) {
	return game.getDecorationManager().getTree(spriteID);
    }
    private BufferedImage getSprite(int spriteID) {
	return game.getTileManager().getSprite(spriteID);
    }
    private BufferedImage getSprite(int spriteID, int animationIndex) {
	return game.getTileManager().getAniSprite(spriteID, animationIndex);
    }
   
    @Override
    public void mouseClicked(int x, int y) {
        if(y >= 640){
            gameBar.mouseClicked(x,y);
        }
        else{
            if(selectedTower != null){
                if(canPlaceTower(mouseX,mouseY)){
                    if(getPosTower(mouseX,mouseY) == null){
                        mageTowerManager.addTower(selectedTower,mouseX,mouseY);
                        gameBar.setMageInfro(selectedTower);
                        selectedTower = null;
                    }else{
                        System.out.println("You can not place tower as same position");
                    }
                gameBar.setMageInfro(null);
                }
            }
            else{
                MageTower mt = getPosTower(mouseX,mouseY);
                gameBar.displayMageInfro(mt);
            }
        }
    }
    private MageTower getPosTower(int x, int y) {
        return mageTowerManager.getPosTower(x,y);
    }
    private boolean canPlaceTower(int x,int y) {
        int id = lvl[y/32][x/32];
        int tileType = game.getTileManager().getTile(id).getTileType();
        return tileType == GRASS_TILE;
    }

    @Override
    public void mouseMove(int x, int y) {
        if(y >= 640){
            gameBar.mouseMove(x,y);
            mouseX = (x/32) * 32;
        }else{
            mouseX = (x/32) * 32;
            mouseY = (y/32) * 32;
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if(y >= 640){
            gameBar.mousePressed(x,y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
         gameBar.mouseReleased(x,y);
        
    }

    private boolean isAnimation(int spriteID) {
        return game.getTileManager().isSpriteAnimation(spriteID);
    }
    public int getTileType(int x, int y){
        int xCord = x/32;
        int yCord = y/32;
        if(xCord < 0 || xCord > 19){
            return 0;
        }if(yCord < 0 || yCord > 19){
            return 0;
        }
        int id = lvl[y/32][x/32];
        return game.getTileManager().getTile(id).getTileType();
    }

    public MageTowerManager getMageTowerManager() {
        return mageTowerManager;
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            selectedTower = null;
            gameBar.setMageInfro(null);
        }
    }

    public EnemyManager getEnemyManager() {
        return enemyManager;
    }
    
    

    

    

    

    

    
    

    

    

    
}