package algorithm.a10158;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main 
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
	
	    long x = (p + t)%(2*w);
	    long y = (q + t)%(2*h);
	    
	    x = w - Math.abs(w-x);
	    y = h - Math.abs(h-y);
	    
	    StringBuilder result = new StringBuilder();  // 출력 속도를 빠르게 하기 위해 문자열 + 문자열 보다는
		result.append(x).append(" ").append(y);		 // stringbuilder 클래스 사용.
		System.out.println(result);		
	}
}
