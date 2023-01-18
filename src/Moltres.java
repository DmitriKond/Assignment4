public class Moltres extends FireType {

    private static final int MOLTRES_MAX_HP = 120;
    private static final int MOLTRES_STARTING_AP = 45;
    private static final int MOLTRES_MAX_AP = 60;


    private static final int ASSISTING_HEATER_MIN_DAMAGE = 10;
    private static final int ASSISTING_HEATER_MAX_DAMAGE = 60;
    private static final int ASSISTING_HEATER_COST = 30;
    private static final int FIRE_WING_MIN_DAMAGE = 30;
    private static final int FIRE_WING_MAX_DAMAGE = 30;
    private static final int FIRE_WING_COST = 30;

    public Moltres() {
        setName("Moltres");
        setHealthPoints(MOLTRES_MAX_HP);
        setMaxHealth(MOLTRES_MAX_HP);
        setAttackPoints(MOLTRES_STARTING_AP);
        setMaxAttackPoints(MOLTRES_MAX_AP);
        Attack startingAttack1 = new Attack("Assisting Heater", ASSISTING_HEATER_MIN_DAMAGE, ASSISTING_HEATER_MAX_DAMAGE, ASSISTING_HEATER_COST);
        addAttack(startingAttack1);
        Attack startingAttack2 = new Attack("Fire Wing", FIRE_WING_MIN_DAMAGE, FIRE_WING_MAX_DAMAGE, FIRE_WING_COST);
        addAttack(startingAttack2);
    }

    public boolean evolve () {
        return false;
    }
}
