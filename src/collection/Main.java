package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee{
    private int id;
    private String name;
    private char sex;
    private float salary;

    public Employee(){}
    public Employee(int i, String n, char s, float sa){
        id = i;
        name = n;
        sex = s;
        salary= sa;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id : "); id = sc.nextInt();
        System.out.print("Enter Name : "); sc.nextLine(); name = sc.nextLine();
        System.out.print("Enter sex : "); sex = sc.next().charAt(0);
        System.out.print("Enter Salary "); salary = sc.nextFloat();
    }
    public void output(){
        String st="";
        st = st + id + "\t" + name + "\t" + sex + "\t" + salary;
        System.out.println(st);
    }

    public int getId() {
        return id;
    }

    public float getSalary() {
        return salary;
    }
}
public class Main {
    public static void inputAll(ArrayList<Employee> emp,int n){
        for (int i = 0; i < n; i++) {
            Employee employee = new Employee();
            employee.input();
            emp.add(employee);
        }
    }
    public static void outputAll(ArrayList<Employee> emp){
        System.out.println("id\tName\tSex\tSalary");
        for (int i = 0; i < emp.size(); i++) {
            emp.get(i).output();
        }
    }
    public static void sort(ArrayList<Employee> emp) {
        int n = emp.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (emp.get(i).getSalary() > emp.get(j).getSalary()) {
                    // Find the index of the minimum price
                    Employee temp = emp.get(i);
                    emp.set(i, emp.get(j));
                    emp.set(j, temp);
                }
            }
            // Swap products[i] with the found minimum element

        }
    }
    public static int searchById(ArrayList<Employee> emp, int searchedId){
        int index = -1;

        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i).getId()==searchedId){
                return index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<Employee>();
        System.out.print("Enter Number Of Employee : ");
        int n = sc.nextInt();
        //input
        System.out.println("Input All");
        inputAll(employees,n);

        //output
        outputAll(employees);

        System.out.print("Enter id to remove : "); int idRemove = sc.nextInt();
        int returnId = searchById(employees,idRemove);
        if (returnId==-1)
            System.out.println("Not found");
        else
            employees.remove(returnId);
        outputAll(employees);

        //sort
        System.out.println("sorted");
        sort(employees);
        outputAll(employees);
    }
}
