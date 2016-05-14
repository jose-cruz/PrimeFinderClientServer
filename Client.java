import java.io.*;
import java.net.*;
import java.util.Scanner;

//Client end of the program. 
public class Client {
	
	//Declaring the main method, it will instantiate the Client class, and run it.  
	public static void main(String[] args) throws Exception{
		
		Client CLIENT = new Client();
		CLIENT.run();
		
	}
	
	//Run method of the Client class. 
	public void run() throws Exception{
		
		Socket SOCK = new Socket("localhost",5555); //Setting up the host and port for the Socket
		PrintStream PS = new PrintStream(SOCK.getOutputStream());
		System.out.println("Enter your number:");
		Scanner S = new Scanner(System.in);
		int INT_MESSAGE = S.nextInt();
		PS.println(INT_MESSAGE); // Sending the message containing the number. 
		
		InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
		BufferedReader BR = new BufferedReader(IR);
		
		//Printing out the message back from the server.
		String MESSAGE_1 = BR.readLine();
		String MESSAGE_2 = BR.readLine();
		System.out.println(MESSAGE_1);
		System.out.println(MESSAGE_2);
		
	}

}
