package week3;

import java.util.Scanner;

class Transaction{
	int Accnumber;
	int amt;
	char credit_debit;
	String date;
	//add after credit or debit
	Transaction(int a,int at,char cd,String d)
	{
		Accnumber=a;
	    //System.out.println("ano:"+Accno);
		amt=at;
		credit_debit=cd;
		date=d;
	}
	
	//display based on date
	static void datetransaction(Transaction t[],int n)
	{
		for(int i=0;i<n;i++)
		{
			int credit=0,debit=0;
			if(t[i].credit_debit=='c')//initializing 1st occurence of date
			{
				credit=t[i].amt;
				debit=0;
			}
			
			else if(t[i].credit_debit=='d')
			{
				debit=t[i].amt;
				credit=0;
			}
			
			for(int j=i+1;j<n;j++)//for repetitions
			{
				if((t[i].date).equals(t[j].date))
				{
					if(t[j].credit_debit=='c')
					{
						credit+=t[j].amt;
					}
					else if(t[j].credit_debit=='d')
					{
						debit+=t[j].amt;
					}
					t[j].credit_debit='t';
					
				}
			}
			if(t[i].credit_debit!='t')
			{
		    System.out.println("On "+t[i].date+":");
		    System.out.println("Total credit:"+credit);
		    System.out.println("Total debit:"+debit);
			}
			
		}
	}
	//•	Display the transaction
	//history of a particular account number.
	static void account_history(Transaction t[],int n)
	{
		Scanner s=new Scanner(System.in);
	    System.out.println("Enter account number for transaction history:");
	    int account=s.nextInt();
		for(int i=0;i<n;i++)
		{
			if(t[i].Accnumber==account)
			{
			    System.out.println("On"+t[i].date+":");
			    System.out.println("Rs "+t[i].amt+" transacted on "+t[i].credit_debit);
			    
			}
		}
	}
	//•	Display all the credit details and debit details separately in the ascending order of the amount. 

	
	static void credit_debit_details(Transaction t[],int n)
	{
		Transaction credit[]=new Transaction[n];
		Transaction debit[]=new Transaction[n];
		int cnt1=0,cnt2=0;
		Transaction temp;
		//sort
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(t[i].amt>t[j].amt)
				{
					temp=t[i];
					t[i]=t[j];
					t[j]=temp;
				}
			}
		}
		//separate into 2 lists
		for(int i=0;i<n;i++)
		{
			if(t[i].credit_debit=='c')
			{
				credit[cnt1++]=t[i];
			}
			if(t[i].credit_debit=='d')
			{
				debit[cnt2++]=t[i];
			}
		}
		
		//displayed separately
	    System.out.println("Credit sorted by Amount ");
		for(int i=0;i<cnt1;i++)
		{

			    System.out.println("Total credit:"+credit[i].amt);
			    System.out.println("On "+credit[i].date+":"+"by account number "+credit[i].Accnumber);

		}
		
	    System.out.println("Debit sorted by Amount ");
		for(int i=0;i<cnt2;i++)
		{

			    System.out.println("Total debit:"+debit[i].amt);
			    System.out.println("On "+debit[i].date+":"+"by account number "+debit[i].Accnumber);

		}
	}

	
	
}

 class Account{
	int Accno;
	String Name;
	int Balance;
	static int cnt=20100;
	
	Account(String namez)
	{
		Accno=cnt++;
	    System.out.println("ano:"+Accno);
		Balance=1000;
		Name=namez;
	}
	

}

public class l3p1account {
//    void creditordebit()
//    {
//	    System.out.println("Enter credit or debit(c/d): ");
//	    
//
//    }
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
	    System.out.println("Enter number of accounts N: ");
		int n=s.nextInt();
	    Account a[]=new Account[n];
	    for(int i=0;i<n;i++)
	    {
		    System.out.println("Enter name: ");
			String namez=s.next();
	    	a[i]=new Account(namez);
	    }
	    System.out.println();
	    System.out.println("Details of creation:");
	    for(int i=0;i<n;i++)
	    {

		    System.out.println("name:"+a[i].Name);
		    System.out.println("ano:"+a[i].Accno);
		    System.out.println("bal:"+a[i].Balance);


	    }
	    
	    System.out.println("Enter number of transactions:");
	    int trans=s.nextInt();
	    Transaction t[]=new Transaction[trans];

	    for(int i=0;i<trans;i++)//loop for no of transaction
			 {
    		System.out.println("Transaction number"+(i+1)+":");

	    		System.out.println("Enter accno: ");
				int acn=s.nextInt();
		    	//a[i]=new Account(namez);

			    System.out.println("Enter date: ");
				String date=s.next();
				int amz=0;
			    int z=0;
			    char cd='c';//dummy
			    while(z<1)//incase less than 1000
			    {
				    System.out.println("Enter credit or debit: ");
				    cd=s.next().charAt(0);
				    System.out.println("Enter amount: ");
					 amz=s.nextInt();
					//if()
					int temp=0;
					for(int j=0;j<n;j++)//retrieve accno frm bank
					{
						if(a[j].Accno==acn)//get that acc no
						{
							temp=a[j].Balance;
							break;
						}
					}
					if(cd=='d' && temp-amz<1000)
					{
					    System.out.println("Amount on debit decreases below min balance.Please enter a valid amount ");
					}
					//add exit condn,fn call with parameters,other for loop for n transactions,reduce while loop
					else {
						z+=1;
						for(int j=0;j<n;j++)//update accno frm bank
						{
							if(a[j].Accno==acn && cd=='d')//upadte that acc no
							{
								a[j].Balance-=amz;
								break;
							}
							
							if(a[j].Accno==acn && cd=='c')//update that acc no
							{
								a[j].Balance+=amz;
								break;
							}
						}
					}
			    }
				t[i]=new Transaction(acn,amz,cd,date);
		    }

	    System.out.println();
		Transaction.account_history(t,trans);
	    System.out.println();
		Transaction.credit_debit_details(t,trans);
	    System.out.println();
	    System.out.println("Based on date: \n");
		Transaction.datetransaction(t,trans);


	}
}
