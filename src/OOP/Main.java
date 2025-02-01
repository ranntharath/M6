package OOP;

import java.util.Scanner;

class Person{
    private int id;
    private String name;
    private String sex;
    Scanner scanner = new Scanner(System.in);
    public Person(){}

    public Person(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    public void inputPerson(){

        System.out.print("Enter ID : "); id = scanner.nextInt();
        System.out.print("Enter Name : "); scanner.nextLine(); name = scanner.nextLine();
        System.out.print("Enter Sex : "); sex = scanner.next();
    }
    public void outputPerson(){
        System.out.print(id+ "\t"+name+"\t"+sex);
    }

    public int getId() {
        return id;
    }

}
class Student extends Person{
    private double average;

    public Student(){}

    public Student(int id, String name, String sex, double average) {
        super(id, name, sex);
        this.average = average;
    }
    public void inputStudent(){
        super.inputPerson();
        System.out.print("Enter Average : "); average = scanner.nextDouble();
    }
    public void outputStudent(){
        super.outputPerson();
        System.out.print("\t"+average);
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
public class Main {
    static void inputAll(Student[] stu, int n){
        for (int i = 0; i < n ; i++) {
            System.out.println("enter student :"+(i+1));
            Student student = new Student();
            student.inputStudent();
            stu[i] = student;
        }
    }
    static void outputAll(Student[] stu, int n){
        System.out.println("ID\tName\tSex\tAverage");
        for (int i = 0; i < n; i++) {
            stu[i].outputStudent();
            System.out.println();
        }
    }
    static Student maxAverage(Student[] stu, int n){
        Student max = new Student();
        for (int i = 0; i < n; i++) {
            if (stu[i].getAverage() > max.getAverage()){
                max = stu[i];
            }
        }
        return max;
    }
    static int search(Student[] stu, int n){
        boolean isFound = false;
        int index = 0;
        System.out.print("\nEnter id you want to update average : ");
        int search = new Scanner(System.in).nextInt();
        for (int i = 0; i < n; i++) {
            if(stu[i].getId() == search){
                isFound = true;
                index = i;
                break;
            }
        }
        if (!isFound) return 0;
        else return index;
    }
    static void sort(Student[] stu, int n){
        Student temp;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n ; j++) {
                if (stu[i].getAverage() > stu[j].getAverage()) {
                    temp = stu[i];
                    stu[i] = stu[j];
                    stu[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter number of Student : ");
        int n = new Scanner(System.in).nextInt();

        Student[] students = new Student[n];
//        input
        System.out.print("===== Enter All Students Info =====");
        inputAll(students,n);
//        output
        outputAll(students,n);
//        max average
        System.out.println("==================================");
        System.out.println("max average");
        maxAverage(students,n).outputStudent();

//        search and update average
        System.out.println("===========    update  ==========");
        int index = search(students,n);
        if(index !=0){
            students[index].setAverage(50);
            outputAll(students,n);
        }else {
            System.out.println("id not found");
        }
//        sort
        System.out.println("===========    sort  ==========");
        sort(students,n);
        outputAll(students,n);
    }
}
