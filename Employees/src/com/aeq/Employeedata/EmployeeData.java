package com.aeq.Employeedata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeData {
	void display(){
		//System.out.println("");
		//System.out.println("");
		Configuration cfg = new Configuration();

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();		
		List am = session.createQuery("FROM EmployeeModel").list(); 
		System.out.println("Id:    FirstName:   LastName:     Salary: "); 
		for (Iterator iterator = am.iterator(); iterator.hasNext();){
		   EmployeeModel model = (EmployeeModel) iterator.next(); 
		  
		   System.out.println(model.getId()+"      " + model.getFirstName()+"    "+model.getLastName()+"   "+model.getSalary()); 
		}
		session.close();
		
	}
	
	
public static void main(String[] args) throws NumberFormatException, IOException {
	
	EmployeeData admin=new EmployeeData();
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml"); 

	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	Transaction tx = null;
	//admin.display();
	EmployeeModel p=new EmployeeModel();
	
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

System.out.println("1.Add 2.Delete 3.Update 4.View");
System.out.println("Enter Option:-");
int option=Integer.parseInt(br.readLine());
switch (option)
{
case 1:
	 
     
	System.out.println("Enter id:-");
	int id=Integer.parseInt(br.readLine());
	System.out.println("Enter the  Firstname:-");
	String fName=br.readLine();
	System.out.println("Enter the Lastname:-");
	String lName=br.readLine();
	System.out.println("Enter the salary");
	int sal=Integer.parseInt(br.readLine());
	p.setId(id);
	p.setFirstName(fName);
	p.setLastName(lName);
	p.setSalary(sal);
	tx = session.beginTransaction();
	session.save(p);
	System.out.println("Id and Name saved successfully.....!!");
	//admin.display();

	tx.commit();
	break;
case 2:
	System.out.println("Enter delete id:-");
	int deleteid=Integer.parseInt(br.readLine());
	p.setId(deleteid);
	tx = session.beginTransaction();
	session.delete(p);
	System.out.println("Id deleted successfully.....!!");
//	admin.display();

	tx.commit();
	
	break;
	
case 3:
	System.out.println("Enter id:-");
	int updateid=Integer.parseInt(br.readLine());
	System.out.println("Enter update Firstname:-");
	String ufname=br.readLine();
	System.out.println("Enter update Lastname:-");
	String ulname=br.readLine();
	System.out.println("Enter id:-");
	int usal=Integer.parseInt(br.readLine());
	p.setId(updateid);
	p.setFirstName(ufname);
	p.setLastName(ulname);
	p.setSalary(usal);
	tx = session.beginTransaction();
	session.update(p);
	System.out.println("Name updated successfully.....!!");
	//admin.display();

	tx.commit();
	
	break;
case 4:
	 List am3 = session.createQuery("FROM AdminModel").list(); 
     for (Iterator iterator = am3.iterator(); iterator.hasNext();){
        EmployeeModel model1 = (EmployeeModel) iterator.next(); 
        System.out.println("Id: " + model1.getId()+"   FirstName: " + model1.getFirstName()+" LastName: " +model1.getLastName()+"  Salary: "+model1.getSalary()); 
     }
     
	break;
	}

session.close();
factory.close();


}
}
