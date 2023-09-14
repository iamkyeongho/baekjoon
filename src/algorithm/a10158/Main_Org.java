package algorithm.a10158;

import java.util.Scanner;

public class Main_Org {

    public static final long MAX_POS = 40000;
    public static final long MIN_POS = 2;
    public static final long MAX_TIME = 200000000;
    public static final long MIN_TIME = 1;
    
    protected long w;
    protected long h;
    protected long p;
    protected long q;
    protected long t;

    protected int xdir = 1;
    protected int ydir = 1;
    
    public void inputMaxPosition(Scanner _input) throws Exception
    {
    	String str = _input.nextLine();
    	w = Integer.parseInt(str.split(" ")[0]);
		h = Integer.parseInt(str.split(" ")[1]);
		if (w < MIN_POS || w > MAX_POS)
			throw new Exception(String.format("%d와 %d사이의 자연수를 입력해주세요!", MIN_POS, MAX_POS));
		if (h < MIN_POS || h > MAX_POS)
			throw new Exception(String.format("%d와 %d사이의 자연수를 입력해주세요!", MIN_POS, MAX_POS));
    }
    public void inputCurrPosition(Scanner _input) throws Exception
    {
    	String str = _input.nextLine();
    	p = Integer.parseInt(str.split(" ")[0]);
		q = Integer.parseInt(str.split(" ")[1]);
		if (p <= 0 || p >= w)
			throw new Exception(String.format("%d와 %d사이의 자연수를 입력해주세요!", 0, w));
		if (q <= 0 || q >= h)
			throw new Exception(String.format("%d와 %d사이의 자연수를 입력해주세요!", 0, h));
    }   
    public void inputTime(Scanner _input) throws Exception
    {
    	t = _input.nextLong();
		if (t < MIN_TIME || t > MAX_TIME)
			throw new Exception(String.format("%d와 %d사이의 자연수를 입력해주세요!", 0, w));
    }   
    public void checkXDirection()
    {
    	if (p == w)
    	{
    		xdir = -1;
    		return;
    	}
    	if (p == 0)
    	{
    		xdir = 1;
    		return;
    	}    	
    }
    public void checkYDirection()
    {
    	if (q == h)
    	{
    		ydir = -1;
    		return;
    	}
    	if (q == 0)
    	{
    		ydir = 1;
    		return;
    	}    	
    }
    public void move()
    {
    	checkXDirection();
    	checkYDirection();
    	p = p + xdir;
    	q = q + ydir;    }
    
    public void execute()
    {
    	for (int i = 0; i < t; i++)
    		move();    	
    }
    
	public static void main(String[] args) throws Exception 
	{
		Scanner input = new Scanner(System.in);
		try
		{
			Main_Org ex = new Main_Org();
			ex.inputMaxPosition(input);
			ex.inputCurrPosition(input);
			ex.inputTime(input);
			ex.execute();
			System.out.println(String.format("%d %d", ex.p, ex.q));
		}
		catch (Exception err)
		{
			System.out.println(err.getMessage());
		}
		finally
		{
			if (input != null)
				input.close();
		}
	}
}
