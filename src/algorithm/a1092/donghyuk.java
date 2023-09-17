package algorithm.a1092;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class donghyuk {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int crain_num = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine());
		Integer [] crain_weight = new Integer[crain_num+1]; 		
		for(int i = 1; i <= crain_num; i++)
		{
			crain_weight[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crain_weight, 1, crain_num, Collections.reverseOrder());
		
		st = new StringTokenizer(bf.readLine());
		int box_num = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());
		Integer []box_weight = new Integer[box_num+1];		
		for(int i = 1; i <= box_num; i++)
		{
			box_weight[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(box_weight, 1, box_num, Collections.reverseOrder());
		
		int squen = 1;
		int max=1;
		int result = 0;
		boolean  IsMove = true;
		for(int i = 1; i <= box_num; i++)
		{
			squen = (squen <= crain_num) ? squen: (crain_weight[squen-1] < box_weight[i]) ? squen : max; 
			for(int j = squen; j <= crain_num; j++)
			{
				if(crain_weight[j] >= box_weight[i])
				{
					result =((crain_num == squen)||(box_num==i)||(crain_num == j))? result+1 : result;
					squen = j+1;
					break;
				}
				else if(box_weight[i] > crain_weight[crain_num])
				{
					IsMove =false;
					break;
				}
				else
				{
					max = j+1;
				}
			}
			if(!IsMove) 
			{
				result = -1;
				break;
			}
		}
		System.out.print(result);
	}
}
