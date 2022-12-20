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
    private int waveTickLimit = 60 * 15;
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
            }
        }
    }
    public void incraseWaveIndex(){
        waveIndex++;
        waveTick =0;
        waveTimerOver = false;
        waveStartTimer = false;
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
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,2,0,2,0,2,0,2,0))));
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2))));
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1))));
        waves.add(new Wave(new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1))));
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
