package forStudent;




import logic.main;

public class StandUser extends Character/*  Fill Here  */{
	

	//Fill Remaining Fields here
	int maxHp;
	int currentHp;	
		
	// End of filling area
	
	private boolean isGuard = false;
	private Stand stand = null;

	//Filling Constructor below
	public StandUser(String name,int hp, String quote, int strength,int defense) {
		super(name,quote,strength,defense);
		this.maxHp = hp;
		this.setCurrentHp(hp);
		if (this.maxHp < 1 && this.currentHp < 1) {
			this.maxHp = 1;
			this.setCurrentHp(1);
		}
	}	
		
	// End of Filling Constructor area

		
	//Complete the takeDamage Method below.
	public int takeDamage(int damage) {
		int TotalDefense;
		if(stand == null) {
			 TotalDefense = this.getDefense()/*StandUser defense stat*/;
		}
		else {
			 TotalDefense = this.getDefense()/*StandUser defense stat*/ + (stand.IsActive()?stand.getDefense()/*Stand defense stat*/:0);
		}
		//Fill code below
		if (this.isGuard) {
			damage -= 2*TotalDefense;
		} else {
			damage -= TotalDefense;
		}
		if (damage < 0) {
			damage = 0;
		}
		this.setCurrentHp(this.getCurrentHp()-damage);
		return damage;
		//End of Fill Code area 

	}

	//Complete doDamage Methods below.
	public int doDamage(StandUser target) {
		return target.takeDamage(this.getStrength()/*StandUser strength stat*/ + (stand.IsActive()?stand.getStrength()/*Stand strength stat*/:0));
	}
	
	public int getMaxHp() {
		return maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int hp) {
		if(hp < 0) {
			this.currentHp = 0;
		}
		else
			this.currentHp = hp;
	}
	
	public boolean isGuard() {
		return isGuard;
	}
	public void setGuard(boolean isGuard) {
		this.isGuard = isGuard;
	}
	
	public void setStand(Stand stand) {
		this.stand = stand;
	}
	

	public void printShowStat() {
		System.out.println("***************************");
		System.out.println(this.getName());
		System.out.println("\"" + this.getQuote()+ "\"" );
		System.out.println("HP = " + this.getMaxHp() );
		System.out.println("Strength = " + this.getStrength() );
		System.out.println("Defense  = " + this.getDefense() );
		System.out.println("***************************");
	}
	
	public StandUser selectStandUser() {
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
	
	
	

