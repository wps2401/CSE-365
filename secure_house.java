//William Schuhmann
//1215016803
//CSE 365 - Assignment 2 - Part 2

import java.util.Scanner;
import java.util.ArrayList;

public class secure_house{
public static void main(String[] args)
{
	Scanner scan = new Scanner(System.in);

	ArrayList<String> keys = new ArrayList<String>();	//Creates keys ArrayList
	ArrayList<String> inHouse = new ArrayList<String>();	//Creates inHouse ArrayList

	//Declarations
	int Counter = 0;
	String owner = args[0];
	String command = "";
	String person = "";
	String keyName = "";
	String testPerson = "";
	boolean doorOpen = false;
	
	for(int i = 1; i < args.length; i++)
	{
		keys.add(args[i]);
	}

	BigLoop:while(scan.hasNextLine() == true && !command.equals("EXIT"))
	{
		command = scan.next();

	//Switch Statement Menu
	switch(command)
	{
		case "INSERT" :
			scan.next();
			person = scan.next();
			keyName = scan.next();
			System.out.println("KEY " + keyName + " INSERTED BY " + person);
			break;
		case "TURN" :
			if(keys.contains(keyName))
			{
				System.out.println("SUCCESS " + person + " TURNS KEY " + keyName);
				doorOpen = true;
			}
			else if (keyName.equals("POLICE_SECRET_KEY"))
			{
				System.out.println("SUCCESS " + person + " TURNS KEY " + keyName);
				doorOpen = true;
			}	
			else if (keyName.equals("FIREFIGHTER_SECRET_KEY"))
			{
				System.out.println("SUCCESS " + person + " TURNS KEY " + keyName);
				doorOpen = true;
			}		
			else{
				System.out.println("FAILURE " + person + " UNABLE TO TURN KEY " + keyName);
				//System.out.println("ACCESS DENIED");
			}
			break;
		case "ENTER" :
			if(doorOpen == true && inHouse.contains(person) == false)
			{
				System.out.println("ACCESS ALLOWED");
				inHouse.add(person);
				Counter += 1;
				doorOpen = false; 
			}else{
				System.out.println("ACCESS DENIED");
			}
			break;
		case "WHO'S" :
			if (Counter == 0 )
			{
				System.out.println("NOBODY HOME");
			}
			else{
				for(int i = 0; i < inHouse.size(); i++){
					if(i == inHouse.size() - 1){
						System.out.println(inHouse.get(i));
					}else{
					System.out.print(inHouse.get(i) + ", ");
					}
				}
			}
			break;
		case "CHANGE" :

			scan.next();
			testPerson = scan.next();

			if(testPerson.equals(owner) && inHouse.contains(owner))
			{
				keys.clear();	//Clears keys ArrayList
				while(scan.hasNextLine() == true)
				{
						keys.add(scan.next());
				}
			//	keys.add("FIREFIGHTER_SECRET_KEY");
				System.out.println("OK");
			}
			else { 
				System.out.println("ACCESS DENIED");
			}
			break; 
		case "LEAVE" :
			if(inHouse.contains(person))
			{
				inHouse.remove(person);		//Removed person from inHouse ArrayList
				System.out.println("OK");
				Counter -= 1;
			}	
		//	else{
		//		System.out.println(person + " NOT HERE");
		//	}
			break;
  
		case "EXIT":
   			break BigLoop;
  
		default:	
			//System.out.println("Error");
}
}
}
}