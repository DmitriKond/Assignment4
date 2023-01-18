public class Electabuzz extends ElectricType {

    private static final int ELECTABUZZ_MAX_HP = 30;
    private static final int ELECTABUZZ_STARTING_AP = 75;
    private static final int ELECTABUZZ_MAX_AP = 100;
    private static final int ELECTIVIRE_MAX_HP = 35;
    private static final int ELECTIVIRE_MAX_AP = 120;

    private static final int THUNDER_MIN_DAMAGE = 40;
    private static final int THUNDER_MAX_DAMAGE = 50;
    private static final int THUNDER_COST = 60;
    private static final int THUNDER_PUNCH_MIN_DAMAGE = 50;
    private static final int THUNDER_PUNCH_MAX_DAMAGE = 120;
    private static final int THUNDER_PUNCH_COST = 80;

    public Electabuzz () {
        setName("Electabuzz");
        setHealthPoints(ELECTABUZZ_MAX_HP);
        setMaxHealth(ELECTABUZZ_MAX_HP);
        setAttackPoints(ELECTABUZZ_STARTING_AP);
        setMaxAttackPoints(ELECTABUZZ_MAX_AP);
        Attack startingAttack = new Attack("Thunder", THUNDER_MIN_DAMAGE, THUNDER_MAX_DAMAGE, THUNDER_COST);
        addAttack(startingAttack);
    }

    public boolean evolve() {
        boolean result = false;
        if (getLevel() == STARTING_LEVEL) {
            if (canEvolve()) {
                setName("Electivire");
                setMaxHealth(ELECTIVIRE_MAX_HP);
                setMaxAttackPoints(ELECTIVIRE_MAX_AP);
                Attack newAttack = new Attack("Flame Tail", THUNDER_PUNCH_MIN_DAMAGE, THUNDER_PUNCH_MAX_DAMAGE, THUNDER_PUNCH_COST);
                addAttack(newAttack);
                result = true;
            }
        }
        return result;
    }
}
