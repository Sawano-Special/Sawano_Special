package sql_setting;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DTO.DTO;

public class sql_edit {

    public static  void sql_edit() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sawano_special");
        EntityManager em = emf.createEntityManager();

        try {

            // 該当のIDのメッセージ1件のみをデータベースから取得
            int id=1;   //ここに変更するidを入力
            DTO d = em.find(DTO.class, id);
            //DTO d2 = em.find(DTO.class, 2);

            if (d != null) {
                // 新しいの設定
                d.setSpeed(2);
                d.setDefence(1);
                d.setFinish_ward("最強のたつのりさまだ");
                d.setHp(1);
                //d2.setSpeed(2000);
                //d2.setDefence(1500);
                //d2.setFinish_ward("どうも、ミスタードラゴンズの立浪です。");
                //d2.setHp(10000);
                // 変更をコミット
                em.getTransaction().commit();
                System.out.println("データの更新が完了しました。");
            } else {
                System.out.println("ID " + id + " のデータが見つかりません。");
            }


        } catch (Exception e) {
            if (em.getTransaction() != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
