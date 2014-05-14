import java.util.Scanner;
public class GameController
{
    private Scanner in;
    private boolean done;
    private SUV aSUV;
    private Sports aSports;
    private ArcticTrack aArcticTrack;
    private DesertTrack aDesertTrack;
  

    public GameController()
    {
	in = new Scanner(System.in);
	done = false; 
	aSUV = new SUV();
	aSports = new Sports();
	aArcticTrack = new ArcticTrack();
	aDesertTrack = new DesertTrack();
	
    }

    public void displaySUV()
    {
	System.out.println("Please select an SUV option");
	System.out.println("(a)ll wheel drive mode");
	System.out.println("(d)rive normally");
	System.out.println("(q)uit Simulation");
	System.out.print("Selection: ");
    }

    public void processSUV (char selection)
    {
	System.out.println();
	switch(selection)
	    {
	    case 'a':
		System.out.println("Entering AWD Mode");
		aArcticTrack.awdMove();
		break;
	    
		
	    case 'd':
		System.out.println("Drive normally");
		aArcticTrack.normalMove();
		break;

	    case 'q':
		System.out.println("quitting simulation");
		System.out.println("It is a Draw!");
		System.exit(0);
		break;

	    case 'c':
		break;

	    default:
		System.out.println("Please enter 'a', 'd' or 'q'");
	    }
	System.out.println();
    }

    public void displaySports()
    {
	System.out.println("Please Select a Sports Car Option");
	System.out.println("(d)rive normally");
	System.out.println("(q)uit simulation");
	System.out.println("Selection: ");
    }
    
    public void processSports (char altSelect)
    {
	System.out.println();
	switch(altSelect)
	    {
	    case 'd' :
		if(aDesertTrack.overCount == 1)
		    {
			aDesertTrack.heatMove();
		    }
		System.out.println("Drive normally");
		aDesertTrack.normalMove();
		break;

	    case 'q' :
		System.out.println("quitting simulation");
		System.out.println("It is a Draw!");
		System.exit(0);
		break;

	    case 'c':
                break;

	    default:
		System.out.println("Please enter 'd' or 'q'");
	    }
	System.out.println();
    }
    public void displayCheat()
    {
	System.out.println("(a). create a blizzard for the arctic track");
	System.out.println("(b). change the location of the SUV");
	System.out.println("(c). change fuel of SUV");
	System.out.println("(d). create a heat wave for the desert track");
	System.out.println("(e). chage location of the Sports Car");
	System.out.println("(f). change fuel of sports car");
    }
    public void Cheat (char selection)
    {
	System.out.println();
	switch(selection)
	    {
	    case 'a':
		aArcticTrack.blizzCount = 1;
		break;

	    case 'b':
		System.out.println("Enter a number from 1-24 for the location");
		String line = in.nextLine();
		int RealNum = Integer.parseInt(line);
		aArcticTrack.locationHack(RealNum);
		break;
		
	    case 'c':
		System.out.println("Enter the amount of fuel to be consumed");
		String gasline = in.nextLine();
		int gasNum = Integer.parseInt(gasline);
		aSUV.consumeFuel(gasNum);
		break;
		
	    case 'd':
		aDesertTrack.overCount = 1;
		break;
	    case 'e':
		System.out.println("Enter a number from 1-24 for the location");
                line = in.nextLine();
                RealNum = Integer.parseInt(line);
                aDesertTrack.locationHack(RealNum);
                break;
	    case 'f':
		System.out.println("Enter the amount of fuel to be consumed");
                gasline = in.nextLine();
                gasNum = Integer.parseInt(gasline);
                aSports.consumeFuel(gasNum);
                break;
		
	    default:
		System.out.println("Please enter something");
	    }
	System.out.println();
    }
		
    public void start ()
    {
	System.out.println("Welcome to SportsCar vs. SUV Racing!!!!");
	final int FIRST = 0;
	String line = null;
	char selection = ' ';
	while (done == false)
	    {
		aArcticTrack.display();
		aDesertTrack.display();
		displaySUV();
		line = in.nextLine();
		selection = line.charAt(FIRST);
		processSUV(selection);
		if(selection == 'c')
		    {
			displayCheat();
			line = in.nextLine();
			selection = line.charAt(FIRST);
			Cheat(selection);
		    }
		aArcticTrack.generateBlizz();
		if(aArcticTrack.isWon())
		    {
			System.out.println("the SUV wins!, it's a miracle!");
			System.exit(0);
		    }
		displaySports();
		line = in.nextLine();
		selection = line.charAt(FIRST);
		processSports(selection);
		if(selection == 'c')
                    {
                        displayCheat();
                        line = in.nextLine();
                        selection = line.charAt(FIRST);
                        Cheat(selection);
                    }
		aDesertTrack.generateHeat();
		if(aDesertTrack.isWon())
                    {
                        System.out.println("the sports car wins!");
                        System.exit(0);
                    }
		if(aSUV.isEmpty())
		    {
			System.out.println("SUV out of gas! sports car wins.");
			System.exit(0);
		    }
		if(aSports.isEmpty())
		    {
			System.out.println("Sports car out of gas! SUV wins.");
			System.exit(0);
		    }
	    }
    }
}
