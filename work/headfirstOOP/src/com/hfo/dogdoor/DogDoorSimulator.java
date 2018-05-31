package com.hfo.dogdoor;

public class DogDoorSimulator {

	public static void main(String[] args) {

		DogDoor door = new DogDoor();
		Remote remote = new Remote(door);
		System.out.println("Fido barks to go outside...");
		System.out.println("...so Gina grabs the remote control.");
		remote.pressButton();
		
		System.out.println("\nFido has gone outside...");
		//remote.pressButton();
		
		System.out.println("\nFido's all done...");
		//remote.pressButton();
		
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("...but he's stuck outside!");
		System.out.println("Fido scratches at the door");
		System.out.println("...so Gina grabs the remote control.");
		remote.pressButton();
		System.out.println("\nFido's back inside...");
		//remote.pressButton();
	}

}
