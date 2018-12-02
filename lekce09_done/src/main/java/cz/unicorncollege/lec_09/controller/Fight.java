package cz.unicorncollege.lec_09.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import cz.unicorncollege.lec_09.entity.Dragon;
import cz.unicorncollege.lec_09.entity.Hero;

public class Fight extends Base{

	List<Hero> heroesList;

	Dragon cloud;

	public static void main(String[] argv) {
		Fight b = new Fight();
		b.run();
	}

	public void run() {
		try {
			init();
			em.getTransaction().begin();
			
			while (cloud.getHeadCount() > 0 && !heroesList.isEmpty()) {
				ListIterator<Hero> i = heroesList.listIterator();
				while (i.hasNext() && cloud.getHeadCount() > 0) {
					Hero h = i.next();
					int dice = (int) Math.round(Math.random() * 5) + 1;
					switch (dice) {
					case 1:
						cloud.slashDragonsHead();
						System.out.println("Dragon was slashed, one head is off, remains:" + cloud.getHeadCount());
						if (cloud.getHeadCount() == 0) {
							System.out.println("Dragon was killed, congrats to heroes.");
							em.remove(cloud);
							h.setKilledDragonsCount(h.getKilledDragonsCount() + 1);
						}
						break;
					case 6:
						System.out.println("Hero " + h.getNickName() + " has died.");
						em.remove(h);
						i.remove();
						break;
					default:
						System.out.println("Dragon and hero " + h.getNickName() + " -> no winner!");
						break;
					}
				}
			}
			em.getTransaction().commit();

			if (heroesList == null || heroesList.isEmpty()) {
				System.out.println("All heroes have died, Dragon is the Winner. Let's try it again..");
			}
		} catch (Exception e) {
			if(em.getTransaction() != null && em.getTransaction().isActive())
				em.getTransaction().rollback();
			
			System.out.println("Something went wrong");
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	public void init() {
		cloud = em.find(Dragon.class, "Cloud");
		if (cloud == null) {
			cloud = new Dragon();
			cloud.setName("Cloud");
			cloud.setHeadCount(7);
			Calendar cal = Calendar.getInstance();
			cal.set(1839, 3, 15);
			cloud.setBirthDate(cal.getTime());
			cloud.setAgressionNumber(4.7);
			
			em.getTransaction().begin();
			em.persist(cloud);
			em.getTransaction().commit();
		}

		Hero stupidJohn;
		Hero breaveBajaja;

		Query heroName = em.createQuery(
				"SELECT h FROM Hero h WHERE h.nickName = :nickName");
		try {
			heroName.setParameter("nickName", "Stupid John");
			stupidJohn = (Hero) heroName.getSingleResult();
		} catch (NoResultException e) {
			stupidJohn = null;
		}

		if (stupidJohn == null) {
			stupidJohn = new Hero();
			stupidJohn.setHasHorse(false);
			stupidJohn.setNickName("Stupid John");
			stupidJohn.setKilledDragonsCount(0);
			
			em.getTransaction().begin();
			em.persist(stupidJohn);
			em.getTransaction().commit();
		}

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Hero> query = cb.createQuery(Hero.class);
		Root<Hero> qHero = query.from(Hero.class);
		query.where(cb.equal(qHero.get("nickName"), "Bajaja"));
		List<Hero> bajajove = em.createQuery(query).getResultList();

		if (!bajajove.isEmpty()) {
			breaveBajaja = (Hero) bajajove.get(0);
		} else {
			breaveBajaja = new Hero();
			breaveBajaja.setHasHorse(true);
			breaveBajaja.setNickName("Bajaja");
			breaveBajaja.setKilledDragonsCount(2);
			
			em.getTransaction().begin();
			em.persist(stupidJohn);
			em.persist(breaveBajaja);
			em.getTransaction().commit();
		}

		heroesList = new ArrayList<Hero>();
		heroesList.add(stupidJohn);
		heroesList.add(breaveBajaja);

	}
}
