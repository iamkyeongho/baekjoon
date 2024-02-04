package algorithm.a10986;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception 
	{		
		// 입력시간을 최적화하기 위해 bufferedreader와 stringtokenizer를 사용한다.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());	    
	    int n = Integer.parseInt(tokenizer.nextToken());
	    int m = Integer.parseInt(tokenizer.nextToken());
	    
	    int a[] = new int[n];
	    int s[] = new int[n];
	    int result = 0;
	    
	    tokenizer = new StringTokenizer(reader.readLine());
	    for (int i = 0; i<n; i++)
	    {
	    	a[i] = Integer.parseInt(tokenizer.nextToken());
	    	s[i] = a[i] % m;
	    	if (s[i] == 0)
	    		result = result + 1;
	    }
	    
	    
	    System.out.println(result);
	}

	public static int nCr(int n, int r)
	{
		int result = Main.factorial(n) / (Main.factorial(r)*(Main.factorial(n-r)));
		return result;
	}
	
	public static int factorial(int n)
	{
		if (n == 1)			
			return 1;
		return n * Main.factorial(n-1);
	}
}
