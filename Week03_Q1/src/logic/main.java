package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import forStudent.Stand;
import forStudent.StandUser;


public class main {
	public static List<StandUser> StandUserList = new ArrayList<>();
	public static List<Stand> standList = new ArrayList<>();
	public static int playerSelectedStandUser = 0;
	public static int playerSelectedStand = 0;
	public static Scanner kb = new Scanner(System.in);

	
	public static void main(String[] args) {
		// This method handle main menu
		addinitialRoster();
		while (true) {
			GameHandle.resetCharacter();
			printMain();
			System.out.print("Select a program to do : ");
			int command = kb.nextInt();
			kb.nextLine(); // handle error
			switch (command) {
			case 1:
				System.out.println("---------------------------");
				singlePlayerMode();
				System.out.println("---------------------------");
				break;
			case 2:
				System.out.println("---------------------------");
				addCharacter();
				System.out.println("---------------------------");
				break;
			case 3:
				System.out.println("NIGERUNDAYO");
				System.exit(0);
			default:
				System.out.println("Invalid input!!");
			}

		}
		
		
		

	}
	
	public static boolean singlePlayerMode() {	
		if(StandUserList.size() == 0 || standList.size() == 0 ) {
			System.out.println("OH NOOO!!!! There are no one here");
			System.out.println("Please go to 2. Character Customization and add at least one character");
			return false;
		}
		playerSelectedStandUser = -1;
		playerSelectedStand = -1;
		try {
			
			while (GameHandle.playerStandUser == null) {
				showStandUserList();
				System.out.print("Player - Choose your StandUser : " );
				int selectPlayerStandUser = kb.nextInt();
				if(selectPlayerStandUser == StandUserList.size()+ 1) return false;
				GameHandle.playerStandUser = StandUserList.get(selectPlayerStandUser - 1).selectStandUser();
				playerSelectedStandUser = selectPlayerStandUser;
			}
			while (GameHandle.playerStand == null) {
				showStandList();
				System.out.print("Player : Choose your Stand : ");
				int selectPlayerStand = kb.nextInt();
				if(selectPlayerStand == standList.size() + 1) return false;
				GameHandle.playerStand = standList.get(selectPlayerStand - 1).selectStand();
				GameHandle.playerStandUser.setStand(GameHandle.playerStand);
				playerSelectedStand = selectPlayerStand;
			}
			while (GameHandle.enemyStandUser == null) {
				showStandUserList();
				System.out.print("Enemy : Choose your StandUser : ");
				int selectEnemyStandUser = kb.nextInt();
				if(selectEnemyStandUser == playerSelectedStandUser ) {
					System.out.println("OH NO!!, This StandUser has already been chosen!!");
				}
				else {
					if(selectEnemyStandUser == StandUserList.size()+ 1) return false;
					GameHandle.enemyStandUser = StandUserList.get(selectEnemyStandUser - 1).selectStandUser();
				}
				
			}
			while (GameHandle.enemyStand == null) {
				showStandList();
				System.out.print("Enemy : Choose your Stand : ");
				int selectEnemyStand = kb.nextInt();
				if(selectEnemyStand == playerSelectedStand ) {
					System.out.println("OH NO!!, This Stand has already been chosen!!");
				}
				else {
					if(selectEnemyStand == standList.size()+ 1) return false;
					GameHandle.enemyStand = standList.get(selectEnemyStand - 1).selectStand();	
					GameHandle.enemyStandUser.setStand(GameHandle.enemyStand);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Invalid input!!");
			e.printStackTrace();
			return false;
		}
		System.out.println("****************************");
		System.out.println("OKAY, OPEN THE GAME");
		System.out.println("****************************");
		GameHandle.GameController();
		return true;
	}
	
	public static void printMain() {
		System.out.println("*********** StandUser Bizzare Fighter ************");
		System.out.println("MAIN MENU");
		System.out.println("===== 1. Single Player");
		System.out.println("===== 2. Add Character");
		System.out.println("===== 3. Quit");
	}
	
	public static boolean showStandUserList() {
		if(StandUserList.size() == 0 || standList.size() == 0 ) {
			System.out.println("OH NOOO!!!! There are no one here");
			return false;
		}
		for (int i = 0; i < StandUserList.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + StandUserList.get(i).getName());
		}
		System.out.println("[" + (StandUserList.size() + 1) + "] " + "- BACK TO MENU");
		return true;
	}
	
	public static boolean showStandList() {
		if(standList.size() == 0 || standList.size() == 0 ) {
			System.out.println("OH NOOO!!!! There are no one here");
			return false;
		}
		for (int i = 0; i < standList.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + standList.get(i).getName());
		}
		System.out.println("[" + (standList.size() + 1) + "] " + "- BACK TO MENU");
		return true;
	}
	
	public static void addCharacter() {
		System.out.println("***********  Add Character  ************");
		System.out.println("What would you like to add?");
		System.out.println("===== 1. StandUser");
		System.out.println("===== 2. Stand");
		System.out.println("===== 3. Exit");
		System.out.print("===================");
		int command = kb.nextInt();
		kb.nextLine(); // handle error
		switch (command) {
		case 1:
			System.out.println("---------------------------");
			addStandUserHandle();
			System.out.println("---------------------------");
			break;
		case 2:
			System.out.println("---------------------------");
			addStandHandle();
			System.out.println("---------------------------");
			break;
		case 3:
			System.out.println("NIGERUNDAYO");
			break;
		default:
			System.out.println("Invalid input!!");
		}
	}
	
	
	public static boolean addStandUserHandle() {
		System.out.println("***********  Add StandUser  ************");
		try {
			System.out.print("StandUser Name : ");
			String name = kb.nextLine();
			System.out.print("StandUser Quote : ");
			String quote = kb.nextLine();
			System.out.print("StandUser Hp : ");
			int hp = kb.nextInt();
			kb.nextLine(); // handle error
			System.out.print("StandUser Strength : ");
			int strength = kb.nextInt();
			kb.nextLine(); // handle error
			System.out.print("StandUser Defense : ");
			int defense = kb.nextInt();
			kb.nextLine(); // handle error
			StandUserList.add(new StandUser(name, hp, quote,strength, defense));
			System.out.println("The StandUser named " + name + " join the fight!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static boolean addStandHandle() {
		System.out.println("***********  Add Stand  ************");
		try {
			System.out.print("Stand Name : ");
			String name = kb.nextLine();
			System.out.print("Stand Quote : ");
			String quote = kb.nextLine();
			System.out.print("Stand Strength : ");
			int strength = kb.nextInt();
			kb.nextLine(); // handle error
			System.out.print("Stand Defense : ");
			int defense = kb.nextInt();
			kb.nextLine(); // handle error
			System.out.print("Stand Charge Turn : ");
			int chargeTurn = kb.nextInt();
			kb.nextLine(); // handle error
			standList.add(new Stand(name, quote,strength, defense, chargeTurn));
			System.out.println("The Stand named " + name + " has been Discovered!");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static void addinitialRoster() {
		StandUserList.add(new StandUser("Jotaro Kujo", 500, "Yare Yare Daze", 70, 20));
		StandUserList.add(new StandUser("DIO", 600, "WRYYYYYYYYYYYY", 60, 20));
		standList.add(new Stand("Star Platinum", "ORA!!!",40, 15, 4));
		standList.add(new Stand("The WORLD", "MUDA!!!",50, 5, 6));
	}
	
}

