package sql_setting;

import javax.persistence.EntityManager;
import DTO.enemy;

import DTO.DTO;
import utils.DBUtils;

public class sql_edit {

    public static void sql_edit() {
        EntityManager em = DBUtils.createEntityManager();

        try {

            // 該当のIDのメッセージ1件のみをデータベースから取得
            int id = 1; //ここに変更するidを入力
            //DTO d = em.find(DTO.class, id);
            enemy e = em.find(enemy.class, id);

            // 新しいの設定
            e.setSpeed(200);
            //e.setDefence(100);
            e.setFinish_ward("sawanoです。");
            e.setHp(5000);
//            d.setSpeed(2000);
//            d.setDefence(1500);
//            d.setFinish_ward("どうも、ミスタードラゴンズの立浪です。");
//            d.setHp(10000);
            // 変更をコミット
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("データの更新が完了しました.");

        } catch (Exception e) {
            if (em.getTransaction() != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
