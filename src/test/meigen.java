package test;

public class meigen {

    public String meigen_damage(String name, int damage) {
        String meigen;
        meigen = name+"は"+damage+"を与えた！！";
        return meigen;
        }

    public String meigen_attack(String name) {
        String meigen;
        meigen = name+"の攻撃だ";
        return meigen;
        }

    public String meigen_battle_start(String enemy_name, int stage) {
        String meigen;
        meigen = stage+"ステージのボス、"+enemy_name+"との決戦だ！！";
        return meigen;
        }

    public String meigen_stay(String name) {
        String meigen;
        meigen = name+"は何をする？";
        return meigen;
        }

    public String meigen_battle_finish(String hero_name, String enemy_name) {
        String meigen;
        meigen = hero_name+"は"+enemy_name+"に勝利した！！";
        return meigen;
    }


}