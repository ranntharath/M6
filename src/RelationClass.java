class Parents {
    String name ;
    String gender ;
    byte age;
    Parents(){}
    Parents(String name, String gender, byte age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    void displayInfo(){
        System.out.println("Name is : "+name);
        System.out.println("Gender is : "+gender);
        System.out.println("Age is : "+age);
    }
}

class Worker extends Parents {
    String workerID;
    String company;
    float wage, hour;

    // private constructor -> singleton pattern
    Worker(){}
    Worker(String name, String gender, byte age , String workerID, String company, float hour, float wage ){
        super(name, gender, age);
        this.workerID = workerID;
        this.company = company;
        this.wage = wage;
        this.hour = hour;
    }

    // override the method in child class.
    void displayInfo(){
        System.out.println("Worker ID : "+workerID);
        super.displayInfo();// DRY , name , gender, age!!!
        System.out.println("Company Name : "+company);
        System.out.println("Working hours: "+ hour);
        System.out.println("Wage : "+wage);
        System.out.println("Monthly Income: "+(wage*hour)+"$");

    }
}

public class RelationClass {
    public static void main(String[] args) {
        Worker worker1 = new Worker("James bond","male",(byte)26,"ID0001","Pizza Company",100f, 25f);

        worker1.displayInfo();
    }
}

