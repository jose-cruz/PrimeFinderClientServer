import java.io.*;
import java.net.*;
import java.util.ArrayList;

//Server end of the program.
public class Server {
	
	//Main method of the server, it instantiates the Server class and runs it. 
	public static void main(String[] args) throws Exception{
		
		Server SERVER = new Server();
		SERVER.run();
		
	}


	//Run method of server class.
	public static void run() throws Exception{
		
		ServerSocket SRVSOCK = new ServerSocket(5555); //Setting up the Port where the server will communicate
		Socket SOCK= SRVSOCK.accept();
		InputStreamReader IR = new InputStreamReader(SOCK.getInputStream());
		BufferedReader BR = new BufferedReader(IR);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		String MESSAGE = BR.readLine(); //Getting the message with the number. 
		
		/*
		 * If the message is not empty, we check for the prime numbers that are lower
		 * than the number in the message, add them to a list of primes and then send
		 * the message back to the client.
		 */
		if (MESSAGE != null){
			
			int INT_MESSAGE = Integer.parseInt(MESSAGE);
			for (int i = 0; i <= INT_MESSAGE; i++){
				
				if(isPrime(i)){
					primes.add(i);
				}
			}
			System.out.println(primes.toString());
			PrintStream PS = new PrintStream(SOCK.getOutputStream());
			PS.println("From the server all primes less than equal to 20\n" + primes.toString());
			
		}
		
	}
	
	//Method to check if a number is prime.
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}	
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	

}