package test;

public class meigen {

    public String meigen_hero_damage(String hero_name, int damage) {
        String meigen;
        meigen = hero_name+"は"+damage+"ダメージを与えた！！";
        return meigen;
        }

    public String meigen_enemy_damage(String enemy_name, int damage) {
        String meigen;
        meigen =  enemy_name +"に"+damage+"ダメージをくらった！！";
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

    public String meigen_battle_finish2(String enemy_name, String hero_name) {
        String meigen;
        meigen = hero_name+"は"+enemy_name+"に敗北した・・";
        return meigen;
    }

    public static String[] stageselect1() {
        String[] meigen = new String[15];
        meigen[0] = "やぁ！";
        meigen[1] = "澤野の世界へようこそ！";
        meigen[2] = "この世界はさわのスペシャルといって悪の魔神、";
        meigen[3] = "かっちゃんとたつのーりが支配する悪い世界なんだ！";
        meigen[4] = "そんな悪の魔神を倒すべく3人の戦士を紹介しよう！";
        meigen[5] = "1人目はたつなみ！";
        meigen[6] = "彼はミスタードラゴンズの1人で、ドラゴンズのリーダーなんだ！";
        meigen[7] = "2人目は細川！";
        meigen[8] = "中日ドラゴンズの期待のホープだ！";
        meigen[9] = "そして3人目は...";
        meigen[10] = "さわの！君自身だ！";
        meigen[11] = "君は2人の戦士とともに、悪を倒してもらう！";
        meigen[12] = "モテモテの未来もそう遠くないだろう！";
        meigen[13] = "ステージ1から順にボスを倒し、世界の平和を取り戻してくれ！";
        meigen[14] = "さわのこうき！頼んだぞ！";
        return meigen;
    }


}
