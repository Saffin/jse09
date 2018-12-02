package cz.unicorncollege.lec_09.controller;

import java.util.List;

import cz.unicorncollege.lec_09.entity.Castle;
import cz.unicorncollege.lec_09.entity.Room;

public class Ownership extends Base{

	public static void main(String[] argv) {
		Ownership v = new Ownership();
		try {
			v.run();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	private void run() {
		saveCastle1();
		saveCastle2();
		
		// najdete a vypiste vsechny pokoje hradu Zvon a jejich pocet
		Castle h1 = (Castle) em.createQuery("SELECT c FROM Castle c WHERE c.name='Zvon'").getSingleResult();
		System.out.println("Pocet pokoju v hotelu Zvon (" + h1.getRooms().size()+"):");
		for (Room p : h1.getRooms()) 
			System.out.println("  - " + p);
		
		// v pokoji 123A zmente pocet luzek na 4
		Room r = (Room) em.createQuery("SELECT r FROM Room r WHERE r.number='123A'").getSingleResult();
		if (r != null){
			r.setBedCount(4);
			em.getTransaction().begin();
			em.persist(r);
			em.getTransaction().commit();
		}
				
		// smazte vsechny hrady a pokoje z DB
		em.getTransaction().begin();
		em.createQuery("DELETE FROM Room").executeUpdate();
		em.createQuery("DELETE FROM Castle").executeUpdate();
		em.getTransaction().commit();
				
		//  vypsat celkovy pocet pokoju
		List<Room> rl = (List<Room>) em.createQuery("SELECT r FROM Room r").getResultList();
		System.out.println("Pocet pokoju po smazani je: " + rl.size());
		
	}

	private void saveCastle1() {
		// vytvorte zaznam pro hrad se jmenem Zvon, ktery ma 3 pokoje: 123A (2), 432A (8), 322B (10)
		Castle h = new Castle();
		h.setName("Zvon");

		Room p1 = new Room();
		p1.setNumber("123A");
		p1.setBedCount(2);

		Room p2 = new Room();
		p2.setNumber("432A");
		p2.setBedCount(8);
		
		Room p3 = new Room();
		p2.setNumber("322B");
		p2.setBedCount(10);

		h.getRooms().add(p1);
		h.getRooms().add(p2);
		h.getRooms().add(p3);

		em.getTransaction().begin();
		em.persist(h);
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
	}

	private void saveCastle2() {
		// vytvorte zaznam pro hrad se jmenem Grand, ktery ma 2 pokoje: 108B (2), 322B (8)
		Castle h = new Castle();
		h.setName("Grand");

		Room p1 = new Room();
		p1.setNumber("108B");
		p1.setBedCount(2);

		Room p2 = new Room();
		p2.setNumber("322B");
		p2.setBedCount(8);

		p1.setCastle(h);
		p2.setCastle(h);

		em.getTransaction().begin();
		em.persist(h);
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
	}

}
