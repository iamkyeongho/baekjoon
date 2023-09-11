package algorithm.a17103;

import java.util.Scanner;

public class decimals 
{
	public int MAX = 1000000;
	boolean[] decimal = new boolean [MAX+1]; 
	Scanner input = new Scanner(System.in);
	
	// 100만까지 미리 소수인 애들 다 구해버림. 소수면 true 소수가 아니면 false
	public void isDecimal()
	{
		decimal[0] = true; decimal[1] = true; 
		for(int n= 2; n <= Math.sqrt(MAX); n++)
		{
			for(int i = n; i < n+1; i++)
			{	
				if((n%i == 0)&&!(decimal[n]))
				{
					int j = 2;
					while(n * j <= MAX)
						{
							if((n*j <= MAX)&&(n*j != 2)&&!decimal[n*j])
							{
								decimal[n*j] = true;
							}
							j++;
						}
				}
			}
		}
	}
	
	public int split(int n)
	{
		int sum = 0;
		for(int i = 2; i <= n-i; i++)
		{
			if((n == i+(n-i))&&!(decimal[i])&&!(decimal[n-i]))
			{
				sum++;
			}
		}
		
		return sum;
	}
	
	public void play()
	{
		int IN;
		isDecimal();
		while(true){
			IN = input.nextInt();
			if((IN >=1)&&(IN <=100))
			{
				break;
			}else
				System.out.println("1 <= N <= 100 으로 다시 적어주세요");
				continue;
		}
		int [] N = new int [IN];
		for (int i = 0; i < IN; i++)
		{
			N[i] = input.nextInt();
		}
		for (int i = 0; i < IN; i++)
		{
			if ((N[i] % 2 == 0) && (N[i] <= MAX))
			{
				System.out.println(split(N[i]));
			}
		}
	}
	public static void main(String[] args) {
		decimals m = new decimals();
		m.play();
	}
}
