package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Product{
    private int code;
    private String name;
    private float price;

    public Product(){}
    public Product(int code,String name,float price){
        this.code = code;
        this.name = name;
        this.price = price;
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Code : "); code = sc.nextInt();
        System.out.print("Enter Name : "); sc.nextLine(); name = sc.nextLine();
        System.out.print("Enter Price : "); price = sc.nextFloat();

    }
    public int getCode() {
        return code;
    }
    public float getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
public class ArrayListDemo {
    public static void inputAll(ArrayList<Product> pro,int n){
        for (int i = 0; i < n; i++) {
            Product product = new Product();
            product.input();
            pro.add(product);
        }
    }
    public static void updatePro(ArrayList<Product> pro){
        boolean isFound = false;
        System.out.print("Enter Code to search : ");
        int searchedCode = new Scanner(System.in).nextInt();
        for (int i = 0; i < pro.size(); i++) {
            if (pro.get(i).getCode()==searchedCode){
                System.out.println("Update Product : ");
                Product product = new Product();
                product.input();
                pro.set(i,product);
                isFound = true;
            }
        }
        if(!isFound) System.out.println("product not found");
    }
    public static void sort(List<Product> products) {
        int n = products.size();
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {
                if (products.get(i).getPrice() > products.get(j).getPrice()) {
                     // Find the index of the minimum price
                    Product temp = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, temp);
                }
            }
            // Swap products[i] with the found minimum element

        }
    }
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<Product>();
        System.out.println("Enter number of product : ");
        int n = new Scanner(System.in).nextInt();
        //input
        inputAll(products,n);
        products.forEach(System.out::println);

        //update
        updatePro(products);
        products.forEach(System.out::println);

        //sort
        products.stream().sorted(Comparator.comparing(Product::getPrice)).forEach(System.out::println);
//        sort(products);
//        products.forEach(System.out::println);

    }
}
