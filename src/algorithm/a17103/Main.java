package algorithm.a17103;

import java.util.Scanner;

public class Main 
{
    public static final int MAX = 1000000;
    public static final int LIMIT = 100;
    public static boolean[] primeNumbers = new boolean[MAX + 1];

    // 100만까지 소수를 구함. 소수면 true, 아니면 false
 	public void	loadPrimeNumbers()
 	{
 		primeNumbers[0] = true; 
 		primeNumbers[1] = true; 
 		for(int n= 2; n <= Math.sqrt(MAX); n++)
 		{
 			for(int i = n; i < n+1; i++)
 			{	
 				if((n%i == 0)&&!(primeNumbers[n]))
 				{
 					int j = 2;
 					while(n * j <= MAX)
					{
						if((n*j <= MAX)&&(n*j != 2)&&!primeNumbers[n*j])
						{
							primeNumbers[n*j] = true;
						}
						j++;
					}
 				}
 			}
 		}
 	}
 	
 	// n을 소수로 쪼개서 합이 n이 되는 것을 찾는 함수.
 	public int splitNumber(int n)
	{
		int sum = 0;
		for(int i = 2; i <= n-i; i++)
		{
			if((n == i+(n-i))&&!(primeNumbers[i])&&!(primeNumbers[n-i]))
			{
				sum++;
			}
		}
		
		return sum;
	}

	// 숫자 갯수를 입력받는 함수
	public int inputCount(Scanner _input)
	{		
		do 
		{
			//System.out.print("Enter a number (1 <= N <= 100): ");
			int count = _input.nextInt();
			if (count >= 1 && count <= 100)
			{
				return count;
			}
		}while (true);
	}
	
	// 숫자를 입력 받아 소수의 합이 n이되는 경우의 수가 몇개인지 찾는 함수.
    public void execute(int _count, Scanner _input) 
    {
       
        int[] N = new int[_count];
        for (int i = 0; i < _count; i++) 
        {
            N[i] = _input.nextInt();
        }

        for (int i = 0; i < _count; i++) 
        {
            if (N[i] % 2 == 0 && N[i] <= MAX) 
            {
                System.out.println(splitNumber(N[i]));
            }
        }
      
    }

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
    	Main ex = new Main();
    	ex.loadPrimeNumbers();
    	int count = ex.inputCount(input);    	
    	ex.execute(count, input);
    }
}