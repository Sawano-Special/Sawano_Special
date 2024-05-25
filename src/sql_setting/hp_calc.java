package sql_setting;
import javax.persistence.EntityManager;

import DTO.DTO;
import utils.DBUtils;

public class hp_calc {

	public static int hero_hp_calc(int id, int damage) {
        EntityManager em = DBUtils.createEntityManager();
        DTO d = em.find(DTO.class, id);

        try {
            //DTO d = em.find(DTO.class, id);

            int hp = d.getHp();
            hp-=damage;
            d.setHp(hp);
            em.getTransaction().begin();
            em.getTransaction().commit();
            System.out.println("hero_hp_calcを完了しました。");


        } catch (Exception e) {
            if (em.getTransaction() != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();

        }
        int hp2 = d.getHp();
        return hp2;
    }

}
