package fr.company.demo.android.util;



public class ApplicationContext
{
    
	public static  boolean UPDATE_IS_ALREADY_CHECKED = false;

	private static ApplicationContext instance = null;
    
	
    private ApplicationContext()
    {
        instance = this;
  
    }

    public static ApplicationContext getInstance()
    {
        if (null == instance)
        {
            instance = new ApplicationContext();
        }
        
         return instance;
    }
}