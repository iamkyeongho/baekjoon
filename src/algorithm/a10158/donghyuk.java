package algorithm.a10158;

import java.util.Scanner;

public class donghyuk 
{
	Scanner in = new Scanner(System.in);
	
	long w,h,q,p,t; // 2억 초까지라 안정적인 실행을 위해 long으로 지정 

	public void in()
	{
		try 		
		{
			String str = in.nextLine();
			w = Integer.parseInt(str.split(" ")[0]);
			h = Integer.parseInt(str.split(" ")[1]);
			str = in.nextLine();
			p = Integer.parseInt(str.split(" ")[0]);
			q = Integer.parseInt(str.split(" ")[1]);
			t = in.nextLong(); // 시간
		}
		catch(Exception e)
		{
			System.out.print("정수로 입력 하셔야 됩니다");
		}
		System.out.print(play(w,p)+" "+play(h,q));
	}
	
	public long play(long x,long y)
	{
		long trans = 1; 
		long count; // 개미 위치를 이동 시켜주는 변수
		// 시간을 더했을 때 범위를 초과 헀을 경우
		if((y+t) > x){
			long i = t; 
			while(i > 0) // i(시간)를 다 소비 할 때까지 반복
			{
				// 개미의 지점과 시간을 더했을 때 범위를 초과 헀을 경우 count 변수에 범위에서 개미 위치를 빼서 저장
				if(trans*(y+i) > x){
					count = x-y;
				}else{
					if(i > x) {
						// 만약 시간이 범위 보다 클 경우. 아직 시간이 많이 남아 있으므로 count에 x를 저장 
						count = trans*x;
					}else // 시간이 범위보다 더 적은 경우. 시간이 얼마 남지 않았으니 그대로 i를 저장
						count = trans*i;
				}
				if((count > 0)){
					// count가 양수로 되어있으면 빼주고 음수면 더해줌
					i = i - count;
				}else {
					i = i + count;
				}
				// count는 양수 혹은 음수가 되어서 개미 위치를 이동
				y = y + count;
				trans = trans * -1;
			}
		}else{ // 개미 위치값과 시간을 더 해도 범위가 초과되지 않으면 그냥 더해줌
			y = y+t;
		}
		return y;
	}
	
	public static void main(String[] args) {
		donghyuk dh = new donghyuk();
		dh.in();
	}
}

