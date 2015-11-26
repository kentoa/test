
public class MillerRabinTest {
	 
    // kは判定サイクル数で, kが大きいほど素数判定が正確になり, 速度は低下する.
    boolean isPrime(int n, int k){// nが素数ならtrue, nが合成数ならfalseを返す.
    	
    	if(n == 2) return true;
        if(n == 1 || n % 2 == 0) return false;
        
        // n-1を2のべき乗で割って2^s*dの形式に変形
        int d = n - 1;
        int s = 0;
        
        while(d % 2 == 0){
            d = d / 2;
            s++;
        }
        
        for(int i = 0; i < k; i++){ // 判定サイクル
            boolean isPP = false;
            int a = (int)(Math.round((n - 2) * Math.random()) + 1); // 1からn-1の範囲から整数aをランダムに選ぶ
            int r = modPow(a, d, n); // a^d mod n が1もしくはn-1なら, nはprobably prime
            
            if(r == 1 || r == n - 1) isPP = true;
       
            for(int j = 0; j < s; j++){ // r^2 mod n が-1なら、nはprobably prime
                r = modPow(r, 2, n);
                if(r == n - 1) isPP = true;
            }  
            if(!isPP) return false; // 上記のどちらにも当てはまらない場合, nはcomposite
        }
        return true;
    }

    
    int modPow(long x, int k, int m){ // べき剰余の計算
        if(k == 0){
            return 1;
        }
        
        if(k % 2 == 0){
            return modPow(x * x % m, k / 2, m);
        }else{
            return (int)(modPow(x, k - 1, m) * x % m);
        }
    }
    
    public static void main(String[] args){
    	MillerRabinTest mr =new MillerRabinTest();
    	boolean bool = mr.isPrime(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    	System.out.println(bool);
    }
}
