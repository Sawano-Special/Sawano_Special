package sql_setting;
import javax.persistence.EntityManager;

import DTO.enemy;
import utils.DBUtils;

public class hp_calc2 {

	public static int enemy_hp_calc(int id, int damage) {
        EntityManager em = DBUtils.createEntityManager();
        enemy d = em.find(enemy.class, id);

        try {
            //enemy d = em.find(enemy.class, id);

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
