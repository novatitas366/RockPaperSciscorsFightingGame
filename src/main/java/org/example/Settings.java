package org.example;

public class Settings {
    
        private String aiDifficulty;
        private int menuSpeed;
        private int basicAttackDamage;
        private int defaultHealth;

        public Settings(String aiDifficulty, int menuSpeed, int basicAttackDamage, int defaultHealth){
            this.aiDifficulty = aiDifficulty;
            this.menuSpeed = menuSpeed;
            this.basicAttackDamage = basicAttackDamage;
            this.defaultHealth = defaultHealth;
        
    }

    public String getAiDifficulty() {
        return aiDifficulty;
    }
    public int getBasicAttackDamage() {
        return basicAttackDamage;
    }
    public int getDefaultHealth() {
        return defaultHealth;
    }
    public int getMenuSpeed() {
        return menuSpeed;
    }

    public void changeAiDifficulty(int num) {
        switch (num) {
            case 1:
                aiDifficulty = "easy";
                break;
            case 2:
                aiDifficulty = "medium";
                break;
            default:
                break;
        }
    }
    public void changeMenuSpeed(int num){
        menuSpeed = num;
    }
    public void changeDefalthHealth(int num){
        defaultHealth = num;
    }
    public void changeDefaultDamage(int num){
        basicAttackDamage = num;
    }
    
}
