package logic;


import forStudent.Stand;
import forStudent.StandUser;


public class GameHandle {
	public static StandUser playerStandUser;
	public static Stand playerStand;
	
	public static StandUser enemyStandUser;
	public static Stand enemyStand;
	
	public static void GameController() {
		playerStandUser.setCurrentHp(playerStandUser.getMaxHp());
		enemyStandUser.setCurrentHp(enemyStandUser.getMaxHp());
		//boolean isInPlayerTurn = ( Math.random() > 0.5f  );  
		boolean isInPlayerTurn = true;
		int command = 0 ;
		int enemycommand = 1;
		while (playerStandUser.getCurrentHp() > 0 && enemyStandUser.getCurrentHp() > 0) {
			StandUser Attacker , Defender;
			Stand StandAttacker , StandDefender;
			if(isInPlayerTurn) {	
				Attacker = playerStandUser;
				Defender = enemyStandUser;
				StandAttacker = playerStand;
				StandDefender = enemyStand;	
				command = PlayerCommand();
			}
			else {
				Attacker = enemyStandUser;
				Defender = playerStandUser;
				StandAttacker = enemyStand;
				StandDefender = playerStand;
				command = enemycommand;
				enemycommand += 1;
				if(enemycommand >= 4) enemycommand = 1;
			}
			Attacker.setGuard(false);
			switch (command) {
			case 1:
				int damage = Attacker.doDamage(Defender);
				//int damage = DamageCalculate(Attacker, Defender,StandAttacker, StandDefender);
				System.out.println(Attacker.getName() + " Attack " + Defender.getName());
				//Attack(Defender , damage);
				System.out.println(Defender.getName() + " Take " + damage + " damage / " + Defender.getCurrentHp() + " HP left");
				if(Defender.isGuard()) {
					System.out.println(Defender.getName() + " Charge his Stand");
					StandDefender.increaseCharge(2);
				}					
				else {
					StandAttacker.increaseCharge(1);
				}
				
				break;
			case 2:
				Attacker.setGuard(true);
				System.out.println(Attacker.getName() + " Guard ");
				break;
			case 3:
				if(StandAttacker.getMaxChargeTurn() <= StandAttacker.getCurrentChargeTurn()) {
					System.out.println(StandAttacker.getQuote());
					System.out.println(StandAttacker.getName() + " is Activated!!");
					StandAttacker.setIsActive(true);
					isInPlayerTurn = !isInPlayerTurn;
				}
				else {
					System.out.println("OH NO!!!, "+ Attacker.getName() +" stand is not ready, nothing happens");
				}
			}
			if(StandAttacker.IsActive()) {
				StandAttacker.decreaseCharge(2);
				if(StandAttacker.getCurrentChargeTurn() <= 0) {
					StandAttacker.setIsActive(false);
				}
			}

			
			isInPlayerTurn = !isInPlayerTurn;
		}
		if(playerStandUser.getCurrentHp() <= 0) {
			System.out.println("****************************");
			System.out.println("YOU LOSE");
			System.out.println("****************************");
		}
		if(enemyStandUser.getCurrentHp() <= 0) {
			System.out.println("****************************");
			System.out.println("YOU WIN");
			System.out.println("****************************");
		}
		System.out.println("Return to menu");
		playerStandUser.setCurrentHp(playerStandUser.getMaxHp());
		enemyStandUser.setCurrentHp(enemyStandUser.getMaxHp());
		
	}
	
	private static int PlayerCommand () {
		System.out.println("****************************");
		System.out.println("1) Attack");
		System.out.println("2) Guard");
		System.out.println("3) Use Stand ( "+ playerStand.getCurrentChargeTurn() + " / " + playerStand.getMaxChargeTurn()+ " )");
		System.out.println("****************************");
		System.out.print("What to do? : ");
		int command = main.kb.nextInt();
		main.kb.nextLine(); // handle error
		return command;
	}

	public static void resetCharacter() {
		playerStandUser = null;
		enemyStandUser = null;
		playerStand = null;
		enemyStand = null;
	}
}
