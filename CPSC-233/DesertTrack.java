import java.util.Random;
public class DesertTrack extends Track
{

    private Sports [] aTrack;
    private Random aGenerator = new Random();
    private int Count = 0;
    public int overCount = 0;
    public int sportsloc = 0;

    Sports aSports = new Sports();

    public DesertTrack()
    {
	int c;
	aTrack = new Sports[SIZE];
	for(c = 0; c < SIZE; c++)
	    aTrack[c] = null;

    }

    public int normalMove()
    {
	if(Count != 0)
	    {
		setLocation(null,Count);
	    }
	setLocation(null, sportsloc);
	Count = Count + 3;
	setLocation(aSports, Count + sportsloc);
	return aSports.normalMove();
	    
    }

    public int heatMove()
    {
	if(Count != 0)
	    {
		setLocation(null,Count);
	    }
	Count = Count + 3;
	setLocation(aSports,Count + sportsloc);
	return aSports.heatMove();
    }

    
    public boolean generateHeat()
    {
	int randomInt = aGenerator.nextInt(100) + 1;
	if (randomInt <= 10)
	    {
		overCount = 1;
		return true;
	    }
	return false;
    }

    public void locationHack(int num)
    {
        if(Count != 0)
            {
                setLocation(null,Count);

            }
        sportsloc = num;
        setLocation(aSports,sportsloc);
    }

}
