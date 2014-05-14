public class Sports extends Car
{
    public static final int STARTING_FUEL = 30;
    public static final int STANDARD_DISTANCE = 3;
    public static final int OVERHEAT_RATE = CONSUMPTION_RATE*2;

    public Sports()
    {
	super();
	setAppearance('p');
	getFuel();
	setFuel(STARTING_FUEL);
	
    }
    public int normalMove()
    {
	consumeFuel(CONSUMPTION_RATE);
	System.out.println("Current fuel: " + getFuel());
	System.out.println("Fuel use: " + CONSUMPTION_RATE);
	System.out.println("Distance traveled: " + STANDARD_DISTANCE);
	return STANDARD_DISTANCE;
    }
    
    public int heatMove()
    {
	consumeFuel(OVERHEAT_RATE);
	System.out.println("Current fuel: " + getFuel());
	System.out.println("Fuel use: " + OVERHEAT_RATE);
	System.out.println("Distance traveled: " + STANDARD_DISTANCE);
	return STANDARD_DISTANCE;
    }
    
}