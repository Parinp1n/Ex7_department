/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package departmentdb;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;

/**
 *
 * @author pinpin
 */
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Employee;
import model.Department;

public class DepartmentReport {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        
            List<Employee> emps = (List<Employee>) em.createNamedQuery("Employee.findAll").getResultList();

            System.out.println("All employee (by ID)");
            for (Employee emp : emps) {
                System.out.println("---------------------------");
                System.out.println("ID: " + emp.getEmployeeid());
                System.out.println("Name: " + emp.getName());
                System.out.println("Job: " + emp.getJob());
                System.out.println("Salary: " + emp.getSalary());

                Department dep = emp.getDepartmentid();
                if (dep != null) {
                    System.out.println("Department: " + dep.getName());
                }
            }

            List<Department> departments = (List<Department>) em.createNamedQuery("Department.findAll").getResultList();
            
            System.out.println("---------------------------");
            System.out.println("All employee (by Department)");

            for (Department dep : departments) {
                System.out.println("---------------------------");
                System.out.println("Department ID: " + dep.getDepartmentid()+" Department Name: " + dep.getName());

                for (Employee emp : emps) {
                    Department empDepartment = emp.getDepartmentid();
                    if (empDepartment != null && empDepartment.equals(dep)) {
                        System.out.println("---------------------------");
                        System.out.println("ID: " + emp.getEmployeeid());
                        System.out.println("Name: " + emp.getName());
                        System.out.println("Job: " + emp.getJob());
                        System.out.println("Salary: " + emp.getSalary());
                    }
                }
            } 
            em.close();
            emf.close();
        }
    }    

