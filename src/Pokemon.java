import java.util.Random;

public abstract class Pokemon {
    private String name;
    private int type;
    private int level;
    private int healthPoints;
    private int maxHealth;
    private int attackPoints;
    private int maxAttackPoints;
    private Attack[] attacks = new Attack[1];
    private boolean standbyAttackBuff = false;

    public static final int STARTING_LEVEL = 1;
    public static final int MAX_LEVEL = 3;
    private static final int KICK_MIN_DAMAGE = 3;
    private static final int KICK_MAX_DAMAGE = 10;
    private static final int KICK_COST = 0;
    public static final int FIRE_TYPE = 101;
    private static final int POST_TURN_DAMAGE_MIN = 3;
    private static final int POST_TURN_DAMAGE_MAX = 10;
    public static final int ELECTRIC_TYPE = 202;

    private static final int LEVEL_2_EVOLUTION_HP_COST = 20;
    private static final int LEVEL_2_EVOLUTION_AP_COST = 25;
    private static final int LEVEL_3_EVOLUTION_HP_COST = 30;
    private static final int LEVEL_3_EVOLUTION_AP_COST = 40;

    private static final int STANDBY_MIN_HP_RESTORE = 5;
    private static final int STANDBY_MAX_HP_RESTORE = 30;
    private static final int STANDBY_MIN_AP_RESTORE = 0;
    private static final int STANDBY_MAX_AP_RESTORE = 40;

    public Pokemon () {
        this.level = STARTING_LEVEL;
        this.attacks[0] = new Attack("Kick", KICK_MIN_DAMAGE, KICK_MAX_DAMAGE, KICK_COST);
    }

    public abstract boolean useAttack (int index, Pokemon target);

    protected void useRandomAttack (Pokemon target) {
        Random random = new Random();
        int index = random.nextInt(this.attacks.length) + 1;
        useAttack(index, target);
        index = random.nextInt(this.attacks.length) + 1;
        useAttack(index, target);
        this.healthPoints /= 2;
        this.attackPoints = 0;
    }

    public void printAttacks () {
        for (int i = 0; i < this.attacks.length; i++) {
            System.out.println((i + 1) + ". " + this.attacks[i].toString());
        }
    }

    public boolean attackIsTripled () {
        boolean result = false;
        if (standbyAttackBuff) {
            result = true;
        }
        return result;
    }

    protected void takeDamage (int amount) {
        this.healthPoints -= amount;
    }

    public void loseHealthAfterTurn () {
        Random random = new Random();
        if (this.type == FIRE_TYPE) {
            int num = random.nextInt(1, 4);
            if (num == 1) {
                num = random.nextInt(POST_TURN_DAMAGE_MIN, POST_TURN_DAMAGE_MAX);
                this.healthPoints -= num;
                System.out.println(this.name + " has taken " + num + " damage from burning up!");
            }
        }
    }

    public boolean hasFainted () {
        boolean result = false;
        if (this.healthPoints <= 0) {
            result = true;
        }
        return result;
    }

    public void standby () {
        Random random = new Random();
        int buff = random.nextInt(3) + 1;
        switch (buff) {
            case 1 -> {
                int num = random.nextInt(STANDBY_MIN_HP_RESTORE, STANDBY_MAX_HP_RESTORE);
                restoreHealth(num);
                System.out.println(this.name + " restored " + num + " HP!");
            }
            case 2 -> {
                int num = random.nextInt(STANDBY_MIN_AP_RESTORE, STANDBY_MAX_AP_RESTORE);
                restoreAttackPoints(num);
                System.out.println(this.name + " restored " + num + " Attack Point(s)!");
            }
            case 3 -> {
                this.standbyAttackBuff = true;
                System.out.println(this.name + " has charged up! Attack power will be tripled next turn!");
            }
        }
    }

    private void restoreHealth (int amount) {
        if (amount >= this.maxHealth - this.healthPoints) {
            this.healthPoints = this.maxHealth;
            System.out.println("HP maxed out!");
        } else {
            this.healthPoints += amount;
        }
    }

    private void restoreAttackPoints (int amount) {
        if (amount >= this.maxAttackPoints - this.attackPoints) {
            this.attackPoints = this.maxAttackPoints;
            System.out.println("Attack Points maxed out!");
        } else {
            this.attackPoints += amount;
        }
    }

    public abstract boolean evolve ();

    public boolean canEvolve () {
        boolean result = false;
        if (this.level == STARTING_LEVEL) {
            if (this.healthPoints > LEVEL_2_EVOLUTION_HP_COST && this.attackPoints > LEVEL_2_EVOLUTION_AP_COST) {
                result = true;
            }
        } else if (this.level < MAX_LEVEL) {
            if (this.healthPoints > LEVEL_3_EVOLUTION_HP_COST && this.attackPoints > LEVEL_3_EVOLUTION_AP_COST) {
                result = true;
            }
        }
        return result;
    }

    public String printEvolutionRequirement () {
        String output = "";
        if (this.level == STARTING_LEVEL) {
            output += "Lose " + LEVEL_2_EVOLUTION_HP_COST + " HP and " + LEVEL_2_EVOLUTION_AP_COST + " Attack Points to evolve to the next level.";
        } else if (this.level > STARTING_LEVEL && this.level < MAX_LEVEL) {
            output += "Lose" + LEVEL_3_EVOLUTION_HP_COST + " HP and " + LEVEL_3_EVOLUTION_AP_COST + " Attack Points to evolve to the next level.";
        } else if (this.level == MAX_LEVEL) {
            output += "Cannot evolve further!";
        }
        return output;
    }

    public abstract void useSpecialMove (Pokemon target);

    public abstract String printSpecialMove ();

    public String toString () {
        String output = "";
        output += this.name + ", Level " + this.level + " " + getPrintableType() + " Pokemon" + "\n";
        output += "HP: " + this.healthPoints + "/" + this.maxHealth + "\n";
        output += "Attack Points: " + this.attackPoints + "/" + this.maxAttackPoints + "\n";
        return output;
    }

    public String getName () {
        return this.name;
    }

    public int getLevel () {
        return this.level;
    }

    public String getPrintableType () {
        String output = "";
        if (this.type == FIRE_TYPE) {
            output += "Fire";
        } else if (this.type == ELECTRIC_TYPE) {
            output += "Electric";
        }
        return output;
    }

    public int getHealth () {
        return this.healthPoints;
    }

    public int getMaxHealth () {
        return this.maxHealth;
    }

    public int getAttackPoints () {
        return this.attackPoints;
    }

    public int getMaxAttackPoints () {
        return this.maxAttackPoints;
    }

    public Attack[] getAttacks () {
        return this.attacks;
    }

    protected void setName (String name) {
        this.name = name;
    }

    protected void setType (int type) {
        this.type = type;
    }

    protected void increaseLevel () {
        this.level++;
    }

    protected void setHealthPoints (int toSet) {
        this.healthPoints = toSet;
    }

    protected void setMaxHealth (int toSet) {
        this.maxHealth = toSet;
    }

    protected void setAttackPoints (int toSet) {
        this.attackPoints = toSet;
    }

    protected void setMaxAttackPoints (int toSet) {
        this.maxAttackPoints = toSet;
    }

    protected boolean checkStandbyAttackBuff () {
        return this.standbyAttackBuff;
    }

    protected int useStandbyAttackBuff (int damage) {
        damage = damage * 3;
        this.standbyAttackBuff = false;
        return damage;
    }

    protected void addAttack (Attack toAdd) {
        Attack[] temp = new Attack[this.attacks.length + 1];
        for (int i = 0; i < this.attacks.length; i++) {
            temp[i] = attacks[i];
        }
        temp[temp.length - 1] = toAdd;
        this.attacks = temp;
    }
}
