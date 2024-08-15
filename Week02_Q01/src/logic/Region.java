package logic;
import java.util.ArrayList;

public class Region {
	private String name;
	private ArrayList<Player> playerList;
	private ArrayList<Quest> questList;
	
	public Region(String name) {
		this.setName(name);
		this.playerList = new ArrayList<Player>();
		this.questList = new ArrayList<Quest>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		if (name.isBlank()) {
			this.name = "Nowhere";
		} else {
			this.name = name;
		}
	}
	
	public ArrayList<Player> getPlayerList() {
		return this.playerList;
	}
	
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
	
	public ArrayList<Quest> getQuestList() {
		return this.questList;
	}
	
	public void setQuestList(ArrayList<Quest> questList) {
		this.questList = questList;
	}
	
	public int getPlayerCount() {
		return this.playerList.size();
	}
	
	public double getRegionRank() {
		int totalRank = 0;
		for (Player player : playerList) {
			totalRank += player.getRank();
		}
		double averageRank = (double) totalRank/getPlayerCount();
		return Math.round(averageRank*100.0)/100.0;
	}
	
	public ArrayList<Quest> getAvailableQuests(Player player) {
		ArrayList<Quest> result = new ArrayList<Quest>();
		for (Quest q : questList) {
			if (q.getStatus() == Status.AVAILABLE && !q.getAuthor().equals(player)) {
				result.add(q);
			}
		}
		return result;
	}
	
	public void addPlayerToRegion(Player p) {
		playerList.add(p);
	}
	
	public void addQuestToRegion(Quest q) {
		questList.add(q);
	}
}