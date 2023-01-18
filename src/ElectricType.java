public abstract class ElectricType extends Pokemon{
    private double charge;
    private boolean usedSpecial;

    public ElectricType() {
        this.charge = 0;
        this.usedSpecial = false;
        setType(ELECTRIC_TYPE);
    }

    public boolean useAttack (int index, Pokemon target) {
        boolean valid = false;
        index--;
        if (getAttacks()[index].getCost() > getAttackPoints()) {
            System.out.println("Not enough Attack Points!");
        } else {
            int damage = getAttacks()[index].calculateDamage();
            damage = damage + ((int) (damage * charge));
            if (checkStandbyAttackBuff()) {
                useStandbyAttackBuff(damage);
            }
            System.out.println(getName() + " used " + getAttacks()[index].getName() + " and dealt " + damage + " damage to the enemy " + target.getName() + "!");
            target.takeDamage(damage);
            setAttackPoints(getAttackPoints() - getAttacks()[index].getCost());
            valid = true;
        }
        return valid;
    }

    public void useSpecialMove (Pokemon target) {
        if (!usedSpecial) {
            setHealthPoints(getMaxHealth());
            setAttackPoints(getMaxAttackPoints());
            this.usedSpecial = true;
        }
    }

    public String printSpecialMove () {
        String output = "";
        if (!usedSpecial) {
            output += "Fully restore HP and Attack Points, can only be used once!";
        } else {
            output += "Cannot be used anymore.";
        }
        return output;
    }
}
