package test;

import javax.persistence.EntityManager;

import DTO.DTO;
import utils.DBUtils;

public class exp {
    public static String exp(int id) {
        EntityManager em = DBUtils.createEntityManager();
        id = 1; //ここに変更するidを入力
        DTO d = em.find(DTO.class, id);
        int level = d.getLevel();
        int attack_value = d.getAttack_value();
        int speed = d.getSpeed();
        int hp = d.getHp();
        int max_hp = d.getMax_hp();
        int exp = d.getExp();
        int exp2 = 0;



        // 新しいの設定
            // 該当のIDのメッセージ1件のみをデータベースから取得
            if (exp >= 10) {
                level += 1;
                attack_value += 5;
                speed += 3;
                hp += 5;
                max_hp += 5;

                exp -= 10;
                d.setAttack_value(attack_value);
                d.setLevel(level);
                d.setHp(max_hp);
                d.setSpeed(speed);
                d.setMax_hp(max_hp);
                d.setExp(exp);

                // 変更をコミット
                em.getTransaction().begin();
                em.getTransaction().commit();
                return "やったぁ！レベルが上がったよ！";
            }else {
                d.setAttack_value(attack_value);
                d.setLevel(level);
                d.setHp(max_hp);
                d.setSpeed(speed);
                d.setMax_hp(max_hp);
                d.setExp(exp);

                // 変更をコミット
                em.getTransaction().begin();
                em.getTransaction().commit();
                exp2 = 10-exp;
                return "次のレベルまで残り経験値"+exp2;
            }
    }
}