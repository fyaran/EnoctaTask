package enocta.testbase;

import enocta.pages.n11PageElements;

public class PageInitializer extends BaseClass{
	
	public static n11PageElements n11Page; 
	
	
	public static void initialize()
	{
		n11Page = new n11PageElements();
	}

}
