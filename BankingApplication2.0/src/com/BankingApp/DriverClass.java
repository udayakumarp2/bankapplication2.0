package com.BankingApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DriverClass {
	public static void main(String[] args) {
		System.out.println("Please create a username with only letters");
        Scanner getsUserName = new Scanner(System.in);
        String var1 = getsUserName.nextLine();
        System.out.println("Please create an id with numbers");
        Scanner getsUserPassword = new Scanner(System.in);
        int var2 = getsUserPassword.nextInt();
        
        
        System.out.println(var1 + " is acceptable");
        System.out.println(var2 + " is acceptable");
        
        String path = "src/com/BankingApp/data.txt";
        String content = "\n"+var1+var2;
        
        try {
        //specify the file we want to write to
        File file = new File(path);
        
        //checking first to see if the file exists, creating it if it doesn't
        if(!file.exists()) {
                file.createNewFile();
		
		
	}
        // our FileWriter has an optional argument which specifies if it's appending to the file
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write(content);
        System.out.println("Your information has been saved!");
        bw.close();
    
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BankAccount obj1 = new BankAccount(var1,var2);
		obj1.showMenu();

    }
}

class BankAccount {
	int balance;
	int previousTransaction;
	String customerName;
	int customerId;
	
	BankAccount(String cname,int cid)
	{
	 customerName = cname;
	 customerId = cid;
	}
	

	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
		}

	}

	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction -= amount;
		}
	}

	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited:" + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
		}
		else
		{
        System.out.println("No transaction occured");
	}
	}
	void showMenu() {
		
		char option='\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome "+customerName);
		System.out.println("Your ID is "+customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous transaction");
		System.out.println("E. Exit");
		
		do
		{
			System.out.println("------------------------------------------------------");
            System.out.println("Enter an option");
			System.out.println("------------------------------------------------------");
		    option = scanner.next().charAt(0);
		    System.out.println("\n");
		    
		    switch(option)
		    {
		    case 'A':
		    	System.out.println("--------------------------------------");
		    	System.out.println("Balance = "+balance);
		    	System.out.println("---------------------------------------");
		    	System.out.println("\n");
		    	break;
		    case 'B':
		    	System.out.println("----------------------------------");
		    	System.out.println("Enter an amount to deposit:");
		    	System.out.println("----------------------------------");
		    	int amount = scanner.nextInt();
		    	deposit(amount);
		    	System.out.println("\n");
		    	break;
		    case 'C':
		    	System.out.println("------------------------------------");
		    	System.out.println("Enter an amount to withdraw:");
		    	System.out.println("------------------------------------");
		    	int amount2 = scanner.nextInt();
		    	withdraw(amount2);
		    	System.out.println("\n");
		    	break;
		    case 'D':
		        System.out.println("---------------------------------------");
		        getPreviousTransaction();
		        System.out.println("--------------------------------------");
		        System.out.println("\n");
		        break;
		        
		    case 'E':
		    	System.out.println("*******************************");
		    	break;
		        
		        default:
		        	System.out.println("Invalid Option!!. Please enter again");
		        	break;
		    }
		}while(option != 'E');
		
		System.out.println("ThankYou for using our services");
	}


}
