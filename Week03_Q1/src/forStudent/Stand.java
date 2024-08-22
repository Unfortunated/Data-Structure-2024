package forStudent;

import logic.main;

public class Stand extends Character/*  Fill Here  */{
	

	private int maxChargeTurn;
	private int currentChargeTurn;
	private boolean isActive = false;

	//Todo: Fill Constructor below
	public Stand(String name, String quote, int strength, int defense, int maxChargeTurn) {
		super(name,quote,strength,defense);
		if (maxChargeTurn < 1) {
			this.maxChargeTurn = 1;
		} else {
			this.maxChargeTurn = maxChargeTurn;
		}
			this.currentChargeTurn = 0;
	}
	
	
	//End of FIll Constructor area 

	
	public int getMaxChargeTurn() {
		return maxChargeTurn;
	}

	public int getCurrentChargeTurn() {
		return currentChargeTurn;
	}
	public void increaseCharge(int i) {
		this.currentChargeTurn += i;
		if(currentChargeTurn > maxChargeTurn) {
			this.currentChargeTurn = maxChargeTurn;
		}
	}
	public void decreaseCharge(int i) {
		this.currentChargeTurn -= i;
		if(currentChargeTurn < 0) {
			this.currentChargeTurn = 0;
		}
	}
	
	public boolean IsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void printShowStat() {
		System.out.println("***************************");
		System.out.println(this.getName());
		System.out.println("\"" + this.getQuote()+ "\"" );
		System.out.println("Strength = " + this.getStrength() );
		System.out.println("Defense  = " + this.getDefense() );
		System.out.println("Charge Turn  = " + this.getMaxChargeTurn() );
		System.out.println("Active Turn  = " + (this.getMaxChargeTurn()/2 ));
		System.out.println("***************************");
	}
	
	public Stand selectStand() {
		printShowStat();
		main.kb.nextLine();
		System.out.println("Are you sure ? (Y/N) :");
		String special = main.kb.nextLine().trim().toLowerCase();
		boolean isSelected = special.equals("y") ? true : false ;
		if(isSelected)
			return this;
		else
			return null;
	}
	





}
