package database;

public class LazySingleton {
	
	private static final LazySingleton instance = new LazySingleton();

    private LazySingleton()
    {
        System.out.println("Construction du Singleton au premier appel");
    }

    public static LazySingleton getInstance() 
    {
        return instance;
    }

    @Override
    public String toString()
    {
       return String.format("Je suis le LazySingleton : %s", super.toString());
    }

}
