/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package list;


interface DiscountRate{
    public double getServiceMemberDiscount();
    public double getProductMemberDiscount();
}
class Customer implements DiscountRate{
    public String customerType;
    public String customerName;
    @Override
    public double getServiceMemberDiscount(){
        if(this.customerType.equalsIgnoreCase("Premium")){
             return 10;
        }
        else if(this.customerType.equalsIgnoreCase("Gold")){
            return 15;
        }
        else if(this.customerType.equalsIgnoreCase("Silver")){
            return 10;
        }
        else{
            return 0;
        }
    }

    @Override
    public double getProductMemberDiscount() {
        if(this.customerType.equalsIgnoreCase("Premium")){
             return 10;
        }
        else if(this.customerType.equalsIgnoreCase("Gold")){
            return 15;
        }
        else if(this.customerType.equalsIgnoreCase("Silver")){
            return 10;
        }
        else{
            return 0;
        }
    }

    public Customer(String customerName , String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    public String getCustomerName(){
        return this.customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public String getCustomerType(){
        return this.customerType;
    }
    public void setCustomerType(String customerType){
        this.customerType = customerType;
    }
}
class Sale {
    public Customer customer;
    public String date;
    public double serviceExpense;
    public double productExpense;
    
    public Sale(Customer customer,String Date){
        this.customer = customer;
        this.date     = date;
    }
    public String getDate(){
        return this.date;
    }
    public double getServiceExpense(){
        return this.serviceExpense;
    }
    public void setServiceExpense(double serviceExpense){
        this.serviceExpense = serviceExpense;
    }
    public double getProductExpense(){
        return this.productExpense;
    }
    public void setProductExpense(double productExpense){
        this.productExpense = productExpense;
    }
    public double getTotalExpense(){
        return  this.getProductExpense() - (this.getProductExpense() * this.customer.getProductMemberDiscount())/100
               +this.serviceExpense - (this.customer.getServiceMemberDiscount())/100;
    }
    public void getInfo(){
        System.out.println("Customer Name   = "+ customer.customerName);
        System.out.println("Service Expense = "+ getServiceExpense());
        System.out.println("Discount        = "+ customer.getServiceMemberDiscount());
        System.out.println("Product Expense = "+ getProductExpense());
        System.out.println("Discount        = "+ customer.getProductMemberDiscount());
        System.out.println("Total Expense   = "+ getTotalExpense());
    }
}

public class List {
    public static void main(String[] args) {
        
        Customer c1 = new Customer("Sovisal","Normal");
        Customer c2 = new Customer("Sokchea","Premium");
        Customer c3 = new Customer("Sokpov","Gold");
        Customer c4 = new Customer("Vitou","Silver");

        Sale sale_c1 = new Sale(c1,"2024-02-11");
        Sale sale_c2 = new Sale(c2,"2024-02-12");
        Sale sale_c3 = new Sale(c3,"2024-02-13");
        Sale sale_c4 = new Sale(c4,"2024-02-14");

        sale_c1.setProductExpense(100);
        sale_c1.setServiceExpense(100);
        sale_c1.getInfo();

        sale_c2.setProductExpense(100);
        sale_c2.setServiceExpense(100);
        sale_c2.getInfo();

        sale_c3.setProductExpense(100);
        sale_c3.setServiceExpense(100);
        sale_c3.getInfo();

        sale_c4.setProductExpense(100);
        sale_c4.setServiceExpense(100);
        sale_c4.getInfo();

    }
    
}
