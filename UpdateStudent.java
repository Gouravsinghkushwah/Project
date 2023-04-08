package test;
import java.sql.*;
import java.util.*;
public class UpdateStudent {
	static Scanner sc = new Scanner(System.in);
	
	static String rno,Sbranch, grade,Sname,Shno,Ssname,Scity,Sstate,Spincode,Smid,Spno;
	static int totm;
	static int HM,TM,SM,MM,PM,CM;
	static float per;
public static void main(String[] args) {
	int a=10;
	System.out.println("Sample : 0884DD1810RR");
	System.out.println("DD : (CE,EE,EC)\nRR : two digits roll number.");
	System.out.println("----------------");
try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:orcl","gourav","gourav");
    	CallableStatement cs = con.prepareCall("{call StuDetails50(?,?,?,?,?,?,?,?,?,?,?,?,?)}");

//		PreparedStatement stm  = con.prepareStatement("select * from )
		//0884EE181020
//
//		System.out.println(rno.substring(0,4).equals("0884"));
//		System.out.println(rno.substring(4,6).equals("EE"));
//		System.out.println(rno.substring(6,10).equals("1810"));
//		System.out.println(rno.substring(10).equals("20"));
//		 System.out.println("=======================");
//		String s = rno.charAt(10)+""+rno.charAt(11);
		  
//		System.out.println((rno.substring(10)!="NaN"));
	do {
			System.out.println("Enter your Rno : ");
			  rno = sc.nextLine();
			  
//			  System.out.println(rno);
		if(rno.length()==12)
		{
			if(rno.substring(0,4).equals("0884")) // University code
			    if(rno.substring(4,6).equalsIgnoreCase("CS") || rno.substring(4,6).equalsIgnoreCase("EC") || rno.substring(4,6).equalsIgnoreCase("EE"))  // Source Code
				    if(rno.substring(6,10).equals("1810"))  // College Code
				      if(rno.substring(10)!="NaN")
				    	  a=0;
//				         System.out.println("Fine");
				         else System.out.println("WRONG");
				    else System.out.println("Wrong College Code");
			    else System.out.println("Wrong Subject");
			else System.out.println("Wrong University code");
				    
			
			
		}
		else System.err.println("Wrong RollNumber");
		}while(a!=0);
		
		//----------------------
    	String s = rno.charAt(4)+""+rno.charAt(5);
//		System.out.println("===="+s);
		System.out.println("Enter Your Name : ");
	    Sname = sc.nextLine();
	    int b=0;
		do {
			if(b==10)System.err.println("Wrong Branch Code!!!!");
		System.out.println("Enter Branch (CE,EE,EC) : ");
        Sbranch = sc.nextLine();	
        if(Sbranch.equals(s))
        {
        	a=10;
        	
        }
        else b=10;
		}while(a!=10);
		
		System.out.println("Enter StreetNo : ");
		Ssname = sc.nextLine();
		
		System.out.println("Enter City : ");
		Scity = sc.nextLine();
		
		System.out.println("Enter State : ");
		Sstate = sc.nextLine();
		
		System.out.println("Enter Pincode : ");
		Spincode = sc.nextLine();
		
		System.out.println("Enter Mailid : ");
		Smid = sc.nextLine();
		
		System.out.println("Enter Phono : ");
		Shno = sc.nextLine();
		
		System.out.println("========== Enter Marks ============");
		do {
		System.out.println(" Hindi : ");
		  HM = sc.nextInt();
		}while(HM>100 || HM<0);
		
		do {
		System.out.println(" Telugu : ");
		  TM = sc.nextInt();
		}while(TM>100 || TM<0);
		do {
		System.out.println(" Sanskrit : ");
		  SM = sc.nextInt();
		}while(SM>100 || SM<0);
		
		do {
		System.out.println(" Math : ");
		  MM = sc.nextInt();
		}while(MM>100 || MM<0);
		
		do {
		System.out.println(" Physics : ");
		  PM = sc.nextInt();
		}while(PM>100 || PM<0);
		
		do {
		System.out.println(" Chemistry : ");
		  CM = sc.nextInt();
		}while(CM>100 || CM<0);
		
		 
		totm = HM+TM+SM+MM+PM+CM;
		per = totm/6.0f;
        if( HM<33 || TM <33 || SM<33 || PM<33 || MM<33 || CM<33)
        grade = "fail"; 
        else if(per>80) grade ="A";
		else if(per>60)grade="B";
		else if(per>40)grade="C";
		else if(per>=33)grade="D";
		else grade="fail";
        
		cs.setString(1, rno);
		cs.setString(2, Sname);
		cs.setString(3, Sbranch);
		cs.setString(4,Ssname);
		cs.setString(5,Shno);
		cs.setString(6, Scity);
		cs.setString(7, Sstate);
		cs.setString(8, Spincode);
		cs.setString(9,Smid);
		cs.setString(10,Spno);
		cs.setDouble(11,totm);
		cs.setDouble(12,per);
		cs.setString(13, grade);
		cs.execute();
        
         System.out.println("Data Inserted Sussefully.....");
		
		//System.out.println(rno);
		
	} catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
}
