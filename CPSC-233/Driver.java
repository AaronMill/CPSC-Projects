/*
  Author:  James Tam
  Version: April 1, 2013

  Starting execution point.

*/


public class Driver
{
    public static void main(String [] args)
    {
	System.out.println("Last Name: Mill");
	System.out.println("First Name: Aaron");
	System.out.println("Student ID: 10119311");
	System.out.println("Tutorial Section: 04");
	GameController aController = new GameController();
	aController.start();
    }
}