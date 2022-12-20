/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import enemy.Enemy;
import events.Wave;
import java.util.ArrayList;
import java.util.Arrays;
import scenes.Playing;

/**
 *
 * @author sahad
 */
public class WaveManager {
    private ArrayList<Wave> waves = new ArrayList<>();
    private Playing playing;
    private int spawnTickLimit = 30 * 2;
    private int spawnTick = spawnTickLimit;
    private int waveTickLimit = 60 * 10;
    private int waveTick =0;
    private int enemyIndex,waveIndex;
    private boolean waveStartTimer ;
    private boolean waveTimerOver ;
    public WaveManager(Playing playing){
        this.playing = playing;
        createWaves();
    }
    public void update(){
        if(spawnTick < spawnTickLimit){
            spawnTick++;
        }
        if(waveStartTimer){
            waveTick++;
            if(waveTick >= waveTickLimit){
                waveTimerOver = true;
                if(waveTimerOver){
                    playing.getGameBar().giveGold(15);
                }
            }
        }
    }
    public void incraseWaveIndex(){
        waveIndex++;
        waveTick =0;
        waveTimerOver = false;
        waveStartTimer = false;
    }
    public void increaseEnemyHpEveryTwoWave(Enemy e) {
        // Check if the wave index is divisible by 2
        if (waveIndex % 2 == 0 && waveIndex != 0) {
            // Increase the enemy's HP by 35%
            this.HP *= 1.35;
        }
    }
     public boolean isWaveTimerOver() {
        return waveTimerOver;
    }
    public int getNextEnemy(){
        spawnTick = 0;
        return waves.get(waveIndex).getEnemyList().get(enemyIndex++);
    }
    public ArrayList<Wave> getWaves() {
        return waves;
    }

    private void createWaves() {
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0))));
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,2,0,2,0,2,2))));
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,2,0,2,0,2,0,2,0,2,0,2))));
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,2,0,2,0,2,0,2,0,2,0,2,1,1,1,1,1,1,1,1,1,1))));
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,2,0,2,0,2,0,2,0,2,0,2,0,1,2,1,2,1,1,1,1,1,1,1,1))));
    }
    public boolean isTimeForNewEnemies() {
        return spawnTick >= spawnTickLimit;
    }
    public boolean isThereMoreEnemyInWave(){
        return enemyIndex < waves.get(waveIndex).getEnemyList().size();
    }

    public boolean isThereMoreWaves() {
        return waveIndex <= waves.size();
    }

    public void startTimer() {
        waveStartTimer =  true;
    }

    public void resetEnemyIndex() {
        enemyIndex = 0;
    }
    public int getWaveIndex(){
        return waveIndex;
    }
    public float getTimeLeft(){
        float timeLeft = waveTickLimit - waveTick;
        return timeLeft / 60.0f;
    }

    public boolean isWaveTimerStarted() {
        return this.waveStartTimer;
    }
    public boolean isWaveIndexDivideByTwo(){
        return this.waveIndex / 2 == 0;
    }

    

   
   
}
