public class SUV extends Car
{
    public static final int STARTING_FUEL = 50;
    public static final int CONSUMPTION_RATE = 3;
    public static final int AWD_DISTANCE = 1;

    public SUV()
    {
	super();
	setAppearance('V');
	getFuel();
	setFuel(STARTING_FUEL);
   
    }
    public int failMove()
    {
	consumeFuel(CONSUMPTION_RATE);
	System.out.println("Current fuel: " + getFuel());
	System.out.println("Fuel use: " + CONSUMPTION_RATE);
	System.out.println("Distance traveled: " + 0);
	return 0;
    }

    public int awdMove()
    {
	consumeFuel(CONSUMPTION_RATE);
	System.out.println("Current fuel: " + getFuel());
	System.out.println("Fuel use: " + CONSUMPTION_RATE);
	System.out.println("Distance traveled: " + AWD_DISTANCE);
	return AWD_DISTANCE;

    }


}

