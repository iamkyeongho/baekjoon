package algorithm.a1157;

import java.util.Scanner;

public class Main 
{
	// 알파벳 문자 갯수를 저장할 정수형 배열
	public int[] count = new int[26];
	
	// 입력받은 문자열을 저장할 변수
	public String string = "";
	
	// 최대 갯수가 있는 배열의 인덱스
	public int maxIndex = 0;
	
	// 최대 갯수가 있는 배열 인덱스의 값
	public int maxValue = 0;
	
	
	// 배열 초기화 함수
	public void initCount()
	{
		for (int i = 0; i<26; i++)
			count[0] = 0;
	}
	
	// 문자열을 입력받는 함수
	public void inputString(Scanner _input)
	{
		do 
		{
			string = _input.nextLine();
			if (string.length() <= 1000000 || string.length() > 0)
			{
				// 입력받은 문자열을 모두 대문자로 변환.
				string = string.toUpperCase();
				break;
			}				
		}while (true);
	}
	
	// 0 ~ 25까지 (a~z)까지 최대 갯수가 있는 인덱스를 찾는 함수
	public void findMaxChar()
	{
		for (int i = 0; i<26;i++)
		{
			if (count[i] == 0) continue;
			if (maxValue < count[i])
			{
				maxValue = count[i];
				maxIndex = i;
			}
		}
	}
	
	// 최대 갯수가 하나 이상인지 찾는 함수, 1개 이상일 경우 ? 출력
	public int hasDoubleMaxChar()
	{
		int maxCount = 0;
		for (int i = 0; i<26; i++)
		{
			if (count[i] == 0) continue;
			if (maxValue == count[i])
			{
				maxCount++;
			}
		}
		return maxCount;
	}
	
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Main ex = new Main();
		ex.initCount();
		ex.inputString(input);
		
		// 입력받은 문자열의 문자 갯수만큼 반복.
		for (int i=0; i<ex.string.length(); i++)
		{
			// 문자하나씩 비교함. a~z일 때만 해당 문자배열 인덱스의 값을 ++ 한다.
			// 인덱스는 'A' 가 0번임.
			if (ex.string.charAt(i) >= 'A' && ex.string.charAt(i) <= 'Z')
			{
				int index = ex.string.charAt(i)-'A';
				ex.count[index]++;				
			}
		}	
		// 최대 갯수가 있는 문자열을 찾는다.
		ex.findMaxChar();
		// 최대 갯수가 하나면 해당 문자만 출력.
		if (ex.hasDoubleMaxChar() == 1)
			System.out.println(String.format("%s", (char)('A'+ex.maxIndex)));
		// 그렇지 않으면 ? 출력.
		else
			System.out.println("?");			
	}
}
