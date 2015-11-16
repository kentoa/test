
public class PrimalityTest {
	
	void NaiveTest(String s){
		int n = Integer.parseInt(s), i = 2;
		boolean flag = true;
		
		if(n == 2){
		}
		else if(n <= 1){	
			flag = false;
		}
		else{
			while(flag && i < n){
				if(n%i == 0){
					flag = false;
				}
				i++;
			}
		}
		
		if(flag == true){
			System.out.println(s + " is a prime number.");
		}
		else{
			System.out.println(s + " is not a prime number.");
		}
		
	}	
	
	
	public static void main(String[] args){
		PrimalityTest ptest = new PrimalityTest();
		ptest.NaiveTest(args[0]);
	}
}
