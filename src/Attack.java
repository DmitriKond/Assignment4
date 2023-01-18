import java.util.Random;

public class Attack {
    private String name;
    private int minDamage;
    private int maxDamage;
    private int cost;

    public Attack (String name, int minDamage, int maxDamage, int cost) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.cost = cost;
    }

    public int calculateDamage () {
        Random random = new Random();
        int result = 0;
        if (this.minDamage == this.maxDamage) {
            result = this.maxDamage;
        } else {
            result = random.nextInt(this.minDamage, this.maxDamage);
        }
        return result;
    }

    public String getName () {
        return this.name;
    }

    public int getCost () {
        return this.cost;
    }

    public String toString () {
        String output = "";
        output += this.name + ": ";
        if (this.minDamage == this.maxDamage) {
            output += this.maxDamage + " damage.";
        } else {
            output += this.minDamage + "-" + this.maxDamage + " damage.";
        }
        output += " Costs " + this.cost + " Attack Points.";
        return output;
    }
}
