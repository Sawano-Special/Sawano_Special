package sql_setting;

import javax.persistence.EntityManager;

import DTO.DTO;
import utils.DBUtils;

public class sql_edit {

    public static void sql_edit() {
        EntityManager em = DBUtils.createEntityManager();

        try {

            // 該当のIDのメッセージ1件のみをデータベースから取得
            int id = 1; //ここに変更するidを入力
            DTO d = em.find(DTO.class, id);
            DTO d2 = em.find(DTO.class, 2);

            // 新しいの設定
            d2.setSpeed(200);
            d2.setDefence(100);
            d2.setFinish_ward("sawanoです。");
            d2.setHp(33);
            d.setSpeed(2000);
            d.setDefence(1500);
            d.setFinish_ward("どうも、ミスタードラゴンズの立浪です。");
            d.setHp(10000);
            // 変更をコミット
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("データの更新が完了しました");

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
