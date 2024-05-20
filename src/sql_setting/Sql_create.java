package sql_setting;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DTO.DTO;

public class Sql_create {

    public static  void sql_create() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sawano_special");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            //以下に新しいHEROを作成
            //例 >> DTO d = new DTO("名前", レベル（int), 攻撃力(int));
            DTO tatsu = new DTO("tatsunori",1,3);

            em.persist(tatsu);
            em.getTransaction().commit();
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