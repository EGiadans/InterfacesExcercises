/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankbranches;
    import java.util.*;
/**
 *
 * @author Eduardo
 */
public class Bank {
    private ArrayList <Branch> branches; //Attributes

    public Bank() {
        this.branches= new ArrayList<>(); //Constructor
    }
    
    public boolean addBranch(Branch branch){ //Method for adding a branch with validation
        if (findBranch(branch.getName())==-1){
            branches.add(branch);
            System.out.println("Branch correctly added");
            return true;
        }
        System.out.println("Branch already exists");
        return false;
    }
    
    public int findBranch(String name){ //Helper for locating the index (or inexistence)
        for(int i=0; i<branches.size();i++){ //of a branch 
            if (branches.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public boolean addCustomer(String bName, String cName, double trans){
        int position=findBranch(bName); //Adds a customer given its data, and the
        //Customer cust;                //name of the desired branch
        if (position!=-1){
            branches.get(position).addCustomer(cName,trans);
            
            System.out.println("Customer successfuly added to the specified branch");
            return true;
        }else{
            System.out.println(/*branch couldnt be found*/"Customer not added");
            return false;
        }
    }
    
    public boolean addTransaction(String bName, String cName, double amount){
        int position=findBranch(bName); //Add a transaction for a given Customer
        if (position!=-1){
            branches.get(position).addTransaction(cName, amount);
            System.out.println("Transaction done");
            return true;
        }else{
            System.out.println("Failed transaction");
            return false;
        }
    }
    
    public void showCustomers(String bName){ //Show the whole Customer list 
        int position = findBranch(bName); //and their transactions
        if (position==-1){
            System.out.println("That branch does not exist");
        }else{
            for (Customer tempCustomers:branches.get(position).getCustomers()){
                System.out.println(tempCustomers.toString());
                System.out.println(tempCustomers.getTransactions().toString());
            }
        }
    }
    
    /*public void showTransactions(String bName){
        int position = findBranch(bName);
        if (position==-1){
            System.out.println("That branch does not exist");
        }else{
            for (Customer tempCustomers:branches.get(position).getCustomers().getTransactions()){
    }
    */
}
