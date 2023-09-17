package algorithm.a1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class donghyuk 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int crain_num = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int [] crain_weight = new int[crain_num]; 
		for(int i = 0; i < crain_num; i++)
		{
			crain_weight[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crain_weight);
		
		st = new StringTokenizer(bf.readLine());
		int box_num = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		int []box_weight = new int[box_num];		
		for(int i = 0; i < box_num; i++)
		{
			box_weight[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(box_weight);
		
		int result = 0;		
		if (crain_weight[crain_num-1] < box_weight[box_num-1]) 
		{
			result = -1;
			System.out.println(result);
			return;
		}
		
		boolean [] BoxCheck = new boolean[box_num];
		int count = box_num;
		while(count > 0)
		{		
			int boxIndex = box_num - 1;
			for(int i=crain_num-1; i >=0;)
			{
				if (boxIndex < 0) 
				{
					break;
				}
				else if(!BoxCheck[boxIndex] &&
						crain_weight[i] >= box_weight[boxIndex])			
				{
					i--;
					count--;
					BoxCheck[boxIndex] = true;
				}
				boxIndex--;
			} 
			result++;;
		}
		
		System.out.println(result);
	}
}
