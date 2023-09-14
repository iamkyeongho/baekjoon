package algorithm.a10158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_For 
{
	public static void main(String[] args) throws Exception 
	{		
		// 입력시간을 최적화하기 위해 bufferedreader와 stringtokenizer를 사용한다.
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());	    
	    int w = Integer.parseInt(tokenizer.nextToken());
	    int h = Integer.parseInt(tokenizer.nextToken());
	    
	    tokenizer = new StringTokenizer(reader.readLine());
	    int p = Integer.parseInt(tokenizer.nextToken());
	    int q = Integer.parseInt(tokenizer.nextToken());
	    
	    long t = Long.parseLong(reader.readLine());
	
	    // 속도를 빠르게 하기 위해 if 문보다는 3항 연산을 한다.
	    // 3항 연산이 메모리를 더 사용하지만 속도는 if 문보다 빠르다.
		int xdir = (t/w)%2==0?1:-1;  // 짝수면 +, 홀수면 -
		int ydir = (t/h)%2==0?1:-1;  // 짝수면 +, 홀수면 -
		
		long x = (xdir>0)?t%w:w-t%w;  // t시간동안 w구간을 반복한 후의 x위치->여기서 계산시작.
		long y = (ydir>0)?t%h:h-t%h;  // t시간동안 h구간을 반복한 후의 y위치->여기서 계산시작.
		 
		// x방향으로의 이동
		for (int i = 0; i < p; i++)
		{	  
			xdir = (x==w)?-1:(x==0)?1:xdir;  // w또는0이면 방향전환함.
	    	x += xdir;
		}
		// y방향으로의 이동
		for (int i = 0; i < q; i++)
		{
			ydir = (y==h)?-1:(y==0)?1:ydir;  // h또는0이면 방향전환함.
	    	y += ydir;    
		}
		StringBuilder result = new StringBuilder();  // 출력 속도를 빠르게 하기 위해 문자열 + 문자열 보다는
		result.append(x).append(" ").append(y);		 // stringbuilder 클래스 사용.
		System.out.println(result);		
	}
}
