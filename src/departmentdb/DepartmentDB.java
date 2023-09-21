/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package departmentdb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;

/**
 *
 * @author pinpin
 */
public class DepartmentDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Department d1 = new Department();
//        d1.setDepartmentid(1);
//        d1.setName("IT");
//        Department d2 = new Department();
//        d2.setDepartmentid(2);
//        d2.setName("HR");
//        persist(d1);
//        persist(d2);
//        
//        Employee e1 = new Employee();
//        e1.setDepartmentid(d1);
//        e1.setEmployeeid(1);
//        e1.setJob("Network Admin");
//        e1.setName("John");
//        e1.setSalary(56789);
//        persist(e1);
//        Employee e2 = new Employee();
//        e2.setDepartmentid(d2);
//        e2.setEmployeeid(1);
//        e2.setJob("HR Manager");
//        e2.setName("Marry");
//        e2.setSalary(46789);
//        persist(e2);
//        Employee e3 = new Employee();
//        e3.setDepartmentid(d1);
//        e3.setEmployeeid(1);
//        e3.setJob("Programmer");
//        e3.setName("Henry");
//        e3.setSalary(67890);
//        persist(e3);
//        Employee e4 = new Employee();
//        e4.setDepartmentid(d2);
//        e4.setEmployeeid(1);
//        e4.setJob("HR recuiter");
//        e4.setName("Clark");
//        e4.setSalary(36789);
//        persist(e4);
        
    }
    
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    
    
}
