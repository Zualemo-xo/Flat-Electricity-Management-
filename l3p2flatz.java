package week3;

import java.util.Random;
import java.util.Scanner;

class flat
{
	String flatno;
	int ebno;
	String owner;
	int prev;
	int curr;
	double amt;
    Scanner s = new Scanner(System.in);
	flat()
	{
		System.out.println("Enter flatno:");
		flatno=s.next();
		System.out.println("Enter ownername:");
		owner=s.next();
		System.out.println("Enter prev current unit:");
		prev=s.nextInt();
		System.out.println("Enter present current unit:");
		curr=s.nextInt();
        Random rand = new Random(); 
		ebno=10000 + rand.nextInt(10000);
		curr=curr-prev;
		if(curr<100)
		{
			amt+=100;
		}
		else if(curr>100 && curr<500)
		{
			amt=amt+(curr-100)*2.5;
		}
		else if(curr>500 && curr<1000)
		{
			amt=amt+(curr-500)*5.0;
		}
		else if(curr>1000)
		{
			amt=amt+(curr-1000)*7.5;
		}
	}
	//•	Display the flat and owner details who paid maximum and minimum EB charges.
	   static void maxmin(flat f[],int n)
	   {
		   //double maxz=0,minz=0;
		   flat temp;
		   //flat gmin;
		    for(int i=0;i<n;i++)
		    {

		    	for(int j=i+1;j<n;j++)
		    	{
				if(f[i].amt>f[j].amt)
				{
					temp=f[i];
					f[i]=f[j];
					f[j]=temp;
				}
		    	}
		    }
			System.out.println("Min amt owner details:");
			f[0].display();
			//System.out.println(gmax.flatno);
			//System.out.println(owner);
			//System.out.println(ebno);
			System.out.println("Max amt owner details:");
			f[n-1].display();
	   }
	
	
	void display()
	{
		System.out.println("Amt:"+amt);
		System.out.println(flatno);
		System.out.println(owner);
		System.out.println(ebno);

	}
	
	//•	Display the average amount paid by all flats in each floor. 
	static void average(flat f[],int n)
	{
		double avgamount[]=new double[2*n];
		int count[]=new int[2*n];
		int maxfloor=0;
		for(int i=0;i<n;i++)
		{
			//System.out.println(f[i].flatno);
			//extraction of floor
			String temp=f[i].flatno.substring(0,1);
			int floor=Integer.parseInt(temp); 
			//using floor
			avgamount[floor]+=f[i].amt;
			count[floor]++;
			if(floor>maxfloor)
			{
				maxfloor=floor;
			}
		}			
		for(int i=0;i<maxfloor+1;i++)
		{
			avgamount[i]/=count[i];
			System.out.println("Average amount in floor "+i+" is:"+avgamount[i]);
		}
	}
	//•	Display the Flat number, 
	//EB amount along with the meter number in the ascending order of the meter number.
	static void ascending(flat f[],int n)
	{
		flat temp;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(f[i].ebno>f[j].ebno)
				{
					temp=f[i];
					f[i]=f[j];
					f[j]=temp;
				}
			}
		}
		System.out.println("Details in asc order of eb number:");
	    for(int i=0;i<n;i++)
	    {
			System.out.println(i+")"+f[i].ebno);	    
			System.out.println(f[i].flatno);
			System.out.println(f[i].owner);
			System.out.println(f[i].amt);	    
		}
	}
}

public class l3p2flatz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner s = new Scanner(System.in);
		System.out.println("Enter n -the number of flats:");
		int n=s.nextInt();
	    flat f[]=new flat[n];
	    for(int i=0;i<n;i++)
	    {
		    f[i]=new flat();

	    }
	    flat.maxmin(f,n);
	    flat.average(f,n);
	    flat.ascending(f,n);

	}

}
