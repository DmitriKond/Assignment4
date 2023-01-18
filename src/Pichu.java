public class Pichu extends ElectricType {

    private static final int PICHU_MAX_HP = 40;
    private static final int PICHU_STARTING_AP = 22;
    private static final int PICHU_MAX_AP = 30;
    private static final int PIKACHU_MAX_HP = 50;
    private static final int PIKACHU_MAX_AP = 40;
    private static final int RAICHU_MAX_HP = 160;
    private static final int RAICHU_MAX_AP = 80;

    private static final int QUICK_ATTACK_MIN_DAMAGE = 10;
    private static final int QUICK_ATTACK_MAX_DAMAGE = 10;
    private static final int QUICK_ATTACK_COST = 5;
    private static final int ELECTRO_BALL_MIN_DAMAGE = 30;
    private static final int ELECTRO_BALL_MAX_DAMAGE = 40;
    private static final int ELECTRO_BALL_COST = 10;
    private static final int ELECTRIC_SURFER_MIN_DAMAGE = 20;
    private static final int ELECTRIC_SURFER_MAX_DAMAGE = 120;
    private static final int ELECTRIC_SURFER_COST = 60;

    public Pichu () {
        setName("Pichu");
        setHealthPoints(PICHU_MAX_HP);
        setMaxHealth(PICHU_MAX_HP);
        setAttackPoints(PICHU_STARTING_AP);
        setMaxAttackPoints(PICHU_MAX_AP);
        Attack quickAttack = new Attack("Quick Attack", QUICK_ATTACK_MIN_DAMAGE, QUICK_ATTACK_MAX_DAMAGE, QUICK_ATTACK_COST);
        addAttack(quickAttack);
    }

    public boolean evolve() {
        boolean result = false;
        if (getLevel() == STARTING_LEVEL) {
            if (canEvolve()) {
                setName("Pikachu");
                setMaxHealth(PIKACHU_MAX_HP);
                setMaxAttackPoints(PIKACHU_MAX_AP);
                Attack newAttack = new Attack("Electro Ball", ELECTRO_BALL_MIN_DAMAGE, ELECTRO_BALL_MAX_DAMAGE, ELECTRO_BALL_COST);
                addAttack(newAttack);
                increaseLevel();
                result = true;
            }
            if (getLevel() > STARTING_LEVEL && getLevel() < MAX_LEVEL) {
                if (canEvolve()) {
                    setName("Raichu");
                    setMaxHealth(RAICHU_MAX_HP);
                    setMaxAttackPoints(RAICHU_MAX_AP);
                    Attack newAttack = new Attack("Electric Surfer", ELECTRIC_SURFER_MIN_DAMAGE, ELECTRIC_SURFER_MAX_DAMAGE, ELECTRIC_SURFER_COST);
                    addAttack(newAttack);
                    increaseLevel();
                    result = true;
                }
            }
        }
        return result;
    }
}
