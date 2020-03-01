package com.supero.tasklist.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.supero.tasklist.model.Usuario;

public class Teste {
	
	private static EntityManager em;
	 
    public static void main(String[] args) {
 
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("TasklistFactory");
        em = emf.createEntityManager();
 
        createEmployee(1, "Ravi", "Raj", "Textile");
        createEmployee(2, "Amit", "Raj", "IT");
        createEmployee(3, "Nitish", "Kumar", "Marketing");
 
    }
 
    private static void createEmployee(int id, String firstName,
            String lastName, String dept) {
        em.getTransaction().begin();
        Usuario emp = new Usuario();
        emp.setEmail("marcelomauricio@hotmail.com");
        em.persist(emp);
        em.getTransaction().commit();
    }

}
