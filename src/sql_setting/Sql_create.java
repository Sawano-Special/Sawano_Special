package sql_setting;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sql_create {

    public static  void sql_create() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sawano_special");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            //以下に新しいHEROを作成
            //例 >> DTO d = new DTO("名前", レベル（int), 攻撃力(int));
            //public DTO(String name, int level, int defence, int speed, String finish_ward, int attack_value, int hp)
            /*DTO tatsu = new DTO("立浪",100,3000);
            DTO koki= new DTO("sawanokoki",100,110000);
            //ここで入れれば入る

            em.persist(tatsu);
            em.persist(koki);
            em.getTransaction().commit();*/
            System.out.println("登録が完了しました。");
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
