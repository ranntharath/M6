import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
class Product{
    private int code;
    private String name;
    private float price;

    public Product(){
        code = 0;
        name = null;
        price = 0.0f;
    }
    public Product(int code, String name, float price){
        this.code = code;
        this.name = name;
        this.price = price;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product Code  : "); code= sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Product Name  : ");  name = sc.nextLine();
        System.out.print("Enter Product Price : "); price = sc.nextFloat();
    }
    public void output(){
        System.out.println(code + "\t" +name+ "\t" + price+" $");
    }

    public float getPrice() {
        return price;
    }
}

public class ProductMain {

    static void inputAll(Product[] pro, int n){
        for (int i = 0; i < n ; i++) {
            System.out.println("enter product :"+i+1);
            Product product = new Product();
            product.input();
            pro[i] = product;
        }
    }
    static void outputAll(Product[] pro, int n){
        for (int i = 0; i < n; i++) {
            pro[i].output();
        }
    }
    static float totalPrice(Product[] pro, int n){
        float total = 0;
        for (int i = 0; i < n; i++) {
            total+= pro[i].getPrice();
        }

        return total;
    }
    static Product maxPrice(Product[] pro, int n){
        Product maxproduct = new Product();
        for (int i = 0; i < n; i++) {
            if (pro[i].getPrice() > maxproduct.getPrice()){
                maxproduct = pro[i];
            }
        }
        return maxproduct;

    }
    static void sort(Product[] pro,int n){
        Product product;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n ; j++) {
                if (pro[i].getPrice() > pro[j].getPrice()) {
                    product = pro[i];
                    pro[i] = pro[j];
                    pro[j] = product;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of products : ");
        int n = scanner.nextInt();
        Product[] product = new Product[n];
//        input
        inputAll(product,n);
//        output
        outputAll(product,n);
//        total
        System.out.println("total price : "+totalPrice(product,n));
//        max price
        System.out.print("max price : ");
        maxPrice(product,n).output();
//        sort by price
        sort(product,n);
        outputAll(product,n);

    }
}