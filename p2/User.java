package p2;

import java.util.ArrayList;

import p1.enums.PostAudience;
import p1.enums.PostType;
import p1.enums.ReactionType;

public class User {

	// immutable instance data
	private String username;
	private String password;

	// mutable instance data
	// there should be no overlap between subscribers and restricted
	// however, an overlap between subscribed and restricted is OK
	private ArrayList<String> subscribers = new ArrayList<String>(), subscribed = new ArrayList<String>(),
			restricted = new ArrayList<String>();
	private ArrayList<Post> posts = new ArrayList<Post>();

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean login(String uname, String pword) {
		return false;
	}

	public int addNewPost(PostType type, PostAudience sharedWith, String... contents) {
		return 0;
	}

	public boolean deletePost(int pstID) {
		return false;
	}

	public boolean reactToPost(String pstID, ReactionType vote) {
		return false;
	}

	public boolean unreactToPost(String pstID) {
		return false;
	}

	public boolean subscribe(String name) {
		return false;
	}

	public boolean unsubscribe(String name) {
		return false;
	}

	public boolean restrict(String name) {
		return false;
	}

	public boolean unrestrict(String name) {
		return false;
	}

	public boolean isASubscriber(String name) {
		return false;
	}

	public boolean isSubscribedTo(String name) {
		return false;
	}

	public boolean isRestricted(String name) {
		return false;
	}

	public boolean hasAccesstoPost(String name, int pstID) {
		return false;
	}

	public boolean isPostOwner(int pstID) {
		return false;
	}

	public ArrayList<String> subscribersWithAccessToPost(int pstID) {
		return new ArrayList<String>();
	}

	public Boolean isUser(String name) {
		return username.equals(name);
	}

	public void displayPost(int pstID) {
	}

	@Override
	public String toString() {
		return "TBD";
	}

}
