package test;

import java.util.HashMap;
import java.util.Map;

public class CharacterInfo {
    private static final Map<String, Character> characters = new HashMap<>();

    static {
        characters.put("1", new Character("勇者", "エルドリス帝国に所属する勇者は、数々の敵を倒してきた実績を持つ伝説の戦士だ。彼の実力はオールラウンダーであり、攻撃、防御、スピードのどれを取っても一流。戦場では冷静な判断力と高い戦術眼で仲間を導き、常に勝利へと導いてきた。パーティのリーダーとしての信頼も厚く、その存在は仲間にとって心強い支えとなっている。エルドリス帝国の未来を守るため、勇者は今日も戦い続ける。", "/hero_inf/hero.png"));
        characters.put("2", new Character("魔法使い", "エルドリス帝国は存続の危機に直面している。その希望の光として、一級魔法使いの弟子である若き魔法使いがいる。将来有望とされる彼女は、まだ潜在能力の全てを発揮できていないが、その圧倒的な攻撃力で敵を圧倒する。HPとスピードは低めだが、その一撃の威力は計り知れない。国の未来を背負う彼女の成長に、周囲は大きな期待を寄せている。エルドリス帝国の運命は、彼女の手に託されているのだ。", "/hero_inf/hero1.png"));
        characters.put("3", new Character("剣士", "エルドリス帝国に所属する剣士は、職人気質で日々の厳しい訓練を怠らない。その結果、彼の足さばきは一級品となり、戦場ではその驚異的なスピードで敵を翻弄する。剣の腕も確かで、迅速な動きと正確な一撃で数多くの敵を討ち取ってきた。彼の努力は決して表には出ないが、その実力はエルドリス帝国の中でも随一。常に自己を磨き続ける剣士の姿勢は、同胞からも敵からも尊敬されている。", "/hero_inf/hero2.jpg"));
    }

    public static Character getCharacter(String id) {
        return characters.get(id);
    }

    public static class Character {
        private String name;
        private String description;
        private String imagePath;

        public Character(String name, String description, String imagePath) {
            this.name = name;
            this.description = description;
            this.imagePath = imagePath;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getImagePath() {
            return imagePath;
        }
    }
}