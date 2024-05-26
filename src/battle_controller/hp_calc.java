package battle_controller;

public class hp_calc {

	public static int enemy_hp_calc(int damage, int hp) {
            hp-=damage;
            System.out.println("hero_hp_calcを完了しました。");
        return hp;
    }

}