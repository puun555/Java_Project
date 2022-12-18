/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpz;

/**
 *
 * @author sahad
 */
public class Constant {
    public static class Direction{
        public static final int LEFT=0;
        public static final int UP=1;
        public static final int RIGHT=2;
        public static final int DOWN=3;
    }
    public static class Tiles{
        public static final int GRASS_TILE=0;
        public static final int WATER_TILE=1;
        public static final int ROAD_TILE=2;
        public static final int WALL_TILE=3;
        public static final int DOOR_TILE=4;
        public static final int TOWER_TILE=5;
    }
    public static class Enemies{
        public static final int NORMAL=0;
        public static final int TANKY=1;
        public static final int THIEFT=2;
        public static final int BOSS=3;
        public static double GetSpeed(int type){
            switch(type){
                case NORMAL:
                    return .5;
                case TANKY:
                    return .3;
                case THIEFT:
                    return .7;
                case BOSS:
                    return .5;
            }
            return 0;
        }
        public static int GetHealth(int type){
            switch(type){
                case NORMAL:
                    return 100;
                case TANKY:
                    return 200;
                case THIEFT:
                    return 70;
                case BOSS:
                    return 500;
            }
            return 0;
        }
    }
    public static class Mages{
        public static final int WIND=0;
        public static final int ICE=1;
        public static final int EARTH=2;
        public static final int FIRE=3;
        public static String GetNameMage(int mageTowerType){
            switch(mageTowerType){
                case ICE:
                    return "Ice Mage";
                case EARTH:
                    return "Earth Mage";
                case WIND:
                    return "Wind Mage";
                case FIRE:
                    return "Fire Mage";
            }
            return "";
        }
        public static int GetCostMage(int mageTowerType){
            switch(mageTowerType){
                case ICE:
                    return 200;
                case EARTH:
                    return 300;
                case WIND:
                    return 100;
                case FIRE:
                    return 500;
            }
            return 0;
        }
        public static double GetDamageMage(int mageTowerType){
            switch(mageTowerType){
                case ICE:
                    return 40;
                case EARTH:
                    return 200;
                case WIND:
                    return 50;
                case FIRE:
                    return 100;
            }
            return 0;
        }
        public static double GetRangeMage(int mageTowerType){
            switch(mageTowerType){
                case ICE:
                    return 70;
                case EARTH:
                    return 70;
                case WIND:
                    return 100;
                case FIRE:
                    return 100;
            }
            return 0;
        }
        public static double GetCooldownMage(int mageTowerType){
            switch(mageTowerType){
                case ICE:
                    return 10;
                case EARTH:
                    return 10;
                case WIND:
                    return 10;
                case FIRE:
                    return 10;
            }
            return 0;
        }
    }
    public static class Projectiles{
        public static final int WIND_SPELL=0;
        public static final int ICE_SPELL=1;
        public static final int EARTH_SPELL=2;
        public static final int FIRE_SPELL=3;
        public static float GetSpeed(int mageTowerType){
            switch(mageTowerType){
                case ICE_SPELL:
                    return 2;
                case EARTH_SPELL:
                    return 1;
                case WIND_SPELL:
                    return 4;
                case FIRE_SPELL:
                    return 3;
            }
            return 0;
        }
    }
}
