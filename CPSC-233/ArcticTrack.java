import java.util.Random;
public class ArcticTrack extends Track
{

    private SUV [] aTrack;
    private Random aGenerator = new Random();
    private int NormCount = 0;
    public int blizzCount = 0;
    public int locationhack = 0;

    SUV aSUV = new SUV();

    // Creates the arctic track and all elements
    public ArcticTrack()
    {
	int c;
	aTrack = new SUV[SIZE];
	for(c = 0; c < SIZE; c++)
	    aTrack[c] = null;
    }

    public int normalMove()
    {
	if(NormCount != 0)
	    {
		setLocation(null,NormCount);
	    
	    }
	setLocation(null,locationhack);
	if(blizzCount == 1)
	    {
		System.out.println("A blizzard has occured and you are stuck");
		setLocation(aSUV,NormCount + locationhack);
		return aSUV.failMove();
	    }
	else
	    {
	NormCount = NormCount + 2;
        setLocation(aSUV,NormCount + locationhack);
        return aSUV.move();
	    }
    }

    public int awdMove()
    {
	if(NormCount != 0)
	    {
		setLocation(null,NormCount);
	     
	    }
	setLocation(null,locationhack);
	if(blizzCount == 1)
	    {
		System.out.println("a blizzard has occured but the awd suv keeps moving!");
	    }
	NormCount = NormCount + 1;
	setLocation(aSUV,NormCount + locationhack);
	return aSUV.awdMove();
	    
    }
     
    public boolean generateBlizz()
    {
	int randomInt = aGenerator.nextInt(100) + 1;
	if (randomInt <= 10)
	    {
		blizzCount = 1;
		return true;
	    }
	return false;
  
    }
    public void locationHack(int num)
    {
	if(NormCount != 0)
            {
                setLocation(null,NormCount);

            }
	locationhack = num;
	setLocation(aSUV,locationhack);
    }
    
        
}