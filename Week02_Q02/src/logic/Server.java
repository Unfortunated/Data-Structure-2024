package logic;

import java.util.ArrayList;

public class Server {
	private String name;
	private User owner;
	private ArrayList<Channel> channelList;
	private ArrayList<User> memberList;
	
	public Server(String name, User owner, TemplateType template) {
		this.channelList = new ArrayList<Channel>();
		this.memberList = new ArrayList<User>();
		this.owner = owner;
		this.addUser(owner);
		this.setName(name);
		switch (template) {
			case BASIC : 
				addChannel(owner,"general");
				break;
			case GAMING :
				addChannel(owner,"gaming");
				break;
			case STUDY :
				addChannel(owner,"homework-help");
				break;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isBlank()) {
			name = this.owner.getName() + " home";
		} 
		this.name = name;
	}

	public User getOwner() {
		return this.owner;
	}

	public ArrayList<Channel> getChannelList() {
		return channelList;
	}

	public ArrayList<User> getMemberList() {
		return memberList;
	}
	
	public boolean isMemberInServer(User userToCheck) {
		if (memberList.contains(userToCheck)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Channel addChannel(User user, String channelName) {
		if (user.equals(this.owner)) {
			Channel cn = new Channel(channelName);
			this.channelList.add(cn);
			return cn;
		} else {
			return null;
		}
	}
	
	public User addUser (User user) {
		if (this.isMemberInServer(user)) {
			return null;
		} else {
			this.memberList.add(user);
			user.addJoinedServersList(this);
			return user;
		}
	}
	
	public boolean kickUser(User kicker, User kicked) throws Exception {
		if (!kicker.equals(this.owner)) {
			throw new Exception();
		} else if (kicker.equals(this.owner) && (!this.isMemberInServer(kicked) || kicker.equals(kicked))) {
			return false;
		} else {
			kicked.getJoinedServersList().remove(this);
			this.memberList.remove(kicked);
			return true;
		}
	}
	
}
