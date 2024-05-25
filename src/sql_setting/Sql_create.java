package sql_setting;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DTO.DTO;
import DTO.enemy;

public class Sql_create {

    public static  void sql_create() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sawano_special");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            //以下に新しいHEROを作成
            //例 >> DTO d = new DTO("名前", レベル（int), 攻撃力(int));
            //public DTO(String name, int level, int defence, int speed, String finish_ward, int attack_value, int hp)
            DTO tatsu = new DTO("立浪",100,1500,2000,"doumo",3000,10000,100000);
            DTO sawano = new DTO("sawanokoki",100,100,200,"sawano",110000,33,100000);
            //enemy ikemen = new enemy("ikemen",20,30,"惚れさせてやんよ",2,70);
            //ここで入れれば入る

            em.persist(tatsu);
            em.persist(sawano);
            //em.persist(ikemen);
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
