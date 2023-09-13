package algorithm.a10158;

import java.util.Scanner;

public class Main {

    //public static final long MAX_POS = 40000;
    //public static final long MIN_POS = 2;
    //public static final long MAX_TIME = 200000000;
    //public static final long MIN_TIME = 1;
    
    public static long w;
    public static long h;
    public static long p;
    public static long q;
    public static long t;
    public static long x;
    public static long y;

    public static int xdir;
    public static int ydir;
    
    public static void checkXDirection()
    {
    	if (x == w)
    	{
    		xdir = -1;
    		return;
    	}
    	if (x == 0)
    	{
    		xdir = 1;
    		return;
    	}    	
    }
    public static void checkYDirection()
    {
    	if (y == h)
    	{
    		ydir = -1;
    		return;
    	}
    	if (y == 0)
    	{
    		ydir = 1;
    		return;
    	}    	
    }
	public static void main(String[] args) throws Exception 
	{
		Scanner input = new Scanner(System.in);
		w = input.nextLong();
		h = input.nextLong();
		p = input.nextLong();
		q = input.nextLong();
		t = input.nextLong();

		long x_start = t%w;
		long y_start = t%h;
		
		xdir = (t/w)%2>0?-1:1;  // 짝수면 +, 홀수면 -
		ydir = (t/h)%2>0?-1:1;  // 짝수면 +, 홀수면 -
		
		if (xdir > 0)
			x = x_start;
		else
			x = w - x_start;
		
		if (ydir > 0)
			y = y_start;
		else
			y = h - y_start;
		
		for (int i = 0; i < p; i++)
		{
	    	checkXDirection();
	    	x = x + xdir;
		}
		for (int i = 0; i < q; i++)
		{
			checkYDirection();
	    	y = y + ydir;    
		}
					
		System.out.println(String.format("%d %d", x, y));		
	}
}
