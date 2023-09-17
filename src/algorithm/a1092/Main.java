package algorithm.a1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException 
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		// 크레인 갯수
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int crain_num = Integer.parseInt(st.nextToken());
		
		// 크레인별 무게제한
		st = new StringTokenizer(bf.readLine());		
		ArrayList<Integer> crain_weight = new ArrayList<Integer>(); 			
		for(int i = 0; i < crain_num; i++)
		{
			crain_weight.add(Integer.parseInt(st.nextToken()));
		}		

		// 박스의 갯수
		st = new StringTokenizer(bf.readLine());
		int box_num = Integer.parseInt(st.nextToken());

		// 박스의 무게
		st = new StringTokenizer(bf.readLine());		
		ArrayList<Integer> box_weight = new ArrayList<Integer>();			
		for(int i = 0; i < box_num; i++)
		{
			box_weight.add(Integer.parseInt(st.nextToken()));
		}			
		
		// 내림차순으로 크레인무게 정렬
		Collections.sort(crain_weight, Collections.reverseOrder());		
		// 내림차순으로 박스무게 정렬
		Collections.sort(box_weight, Collections.reverseOrder());	

		// 가장 큰 크레인이 가장 큰 박스를 옮기지 못하면 -1
		if (crain_weight.get(0) < box_weight.get(0))
		{
			System.out.println(-1);
			return;
		}
		
		// 옮긴 시간 초기화
		int result = 0;

		// 박스가 없을때까지 반복
		while(!box_weight.isEmpty())
		{
			// 박스 순서 초기화.
			int boxIndex = 0;
			for (int i=0; i<crain_weight.size();)	// 크레인 갯수만큼 반복
			{
				// 박스 순서가 전체 박스 갯수와 동일하면 for loop 탈출.
				if (boxIndex == box_weight.size()) 
				{
					break;
				}
				// 크레인 허용무게보다 박스 무게가 작거나 같으면 박스 무게 삭제.
				// 위치는 boxIndex
				else if (crain_weight.get(i) >= box_weight.get(boxIndex))
				{
					box_weight.remove(boxIndex);
					// 크레인이 사용되었으니 i++
					i++;
				}
				else
				{
					// 다음박스로 이동한다.
					boxIndex++;
				}
			}
			// 모든 크레인이 박스를 이동시켰으니 result++, 1분 증가시킨다.
			result++;		
		}
		// 결과 출력.
		System.out.println(result);
	}
}
