package logic;

import java.util.ArrayList;

public class Database {
	private ArrayList<Player> playerList;
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public ArrayList<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(ArrayList<Region> regionList) {
		this.regionList = regionList;
	}

	private ArrayList<Region> regionList;
	
	public Database() {
		this.playerList = new ArrayList<Player>();
		this.regionList = new ArrayList<Region>();
	}
	
	public Database(ArrayList<Player> playerList, ArrayList<Region> regionList) {
		this.playerList = playerList;
		this.regionList = regionList;
	}
	
	public Player addPlayer(String name, Region region) throws Exception {
		for (Player player : playerList) {
			if (player.getName().equals(name)) {
				throw new Exception();
			}
		}
		Player a = new Player(name);
		this.playerList.add(a);
		region.addPlayerToRegion(a);
		return a;
	}
	
	public boolean addRegion(String name) {
		for (Region region : regionList) {
			if (region.getName().equals(name)) {
				return false;
			}
		}
		Region a = new Region(name);
		this.regionList.add(a);
		return true;
	}
	
	public Region getRegionByName(String name) {
		for (Region region : regionList) {
			if (region.getName().equals(name)) {
				return region;
			}
		}
		return null;
	}
	
	public void addQuest(Player author, Region region, String name, String description) {
		Quest q = new Quest(author,region,name,description);
		region.addQuestToRegion(q);
	}
	
}
