package p2;

import java.util.ArrayList;

import p1.enums.FeedAlgorithm;
import p1.enums.PostAudience;
import p1.enums.PostType;
import p1.enums.ReactionType;

public class Socials {

	/* is immutable instance data, i.e., once set cannot be changed */
	private String name;

	/* is mutable instance data */
	private User whoIsLoggedIn = null;
	private FeedAlgorithm feedSort;
	private ArrayList<Integer> posts = new ArrayList<Integer>();
	private ArrayList<User> users = new ArrayList<User>();

	public Socials(String name) {
		this.name = name;
		this.feedSort = FeedAlgorithm.Popular;
	}

	public Socials(String name, FeedAlgorithm feedSort) {
		super();
		this.name = name;
		this.feedSort = feedSort;
	}

	private void addNewSocialsPost(int pstID) {

	}

	public void removeSocialsPost(int pstID) {
		for (Post post : posts) {
			if (post.getPostId() == pstID) {
				posts.remove(post);
				System.out.println("Post with pstID " + pstID + "was removed successfully.");
				//return; 
			}
			System.out.println("Post with pstID " + pstID + "was not found");
		}
	}

	public boolean searchForSocialsPost(int pstID) {
		for (Post post : posts) {
			if (post.getPostId() == pstID) {
				return true;
			}
		}
		return false;
	}

	public String whoOwnsSocialsPost(int pstID) {
		for (Post post : posts) {
			if (post.getPostId() == pstID) {
				return "Owner found";
			}
		}
		return "Owner not found";
	}

	public ArrayList<Integer> getAllSocialsPosts() {
		return new ArrayList<Integer>();
	}

	public void addNewUser(String name, String password) {
		User u = new User(name, password, null);
		users.add(u);
	}

	public void removeUser(String name) {
		if(isSocialsUser(name)){
			users.remove(name);
		}
	}

	public boolean login(String username, String password) {

		/*
		 * whoIsLoggedIn should be null before a new user tries to login
		 * 
		 * if login successful update whoIsLoggedIn with user and return true else
		 * return false
		 * 
		 * 
		 */

		return false;

	}

	public void logout() {
		whoIsLoggedIn = null;
	}

	public boolean isSocialsUser(String name) {
		return false;
	}

	public ArrayList<String> getAllSocialsUsers() {
		return new ArrayList<String>();
	}

	public ArrayList<Integer> getSocialsUserFeed(String name) {
		return new ArrayList<Integer>();
	}

	public String getSocialsName() {
		return name;
	}

	public FeedAlgorithm getSocialsFeedSort() {
		return feedSort;
	}

	public void updateSocialsFeedSort(FeedAlgorithm feedSort) {
		this.feedSort = feedSort;
	}

	/* whoIsLoggedIn adds a new post */
	public void addNewPost(PostType type, PostAudience sharedWith, String... contents) {
		posts.add(whoIsLoggedIn.addNewPost(type, sharedWith, contents));
	}

	/* whoIsLoggedIn deletes a post they own */
	public boolean deletePost(int pstID) {
		return false;
	}

	/* whoIsLoggedIn reacts to post, they should not be the owner of the post */
	public boolean reactToPost(String pstID, ReactionType vote) {
		return false;
	}

	/* whoIsLoggedIn unreacts to post, they should not be the owner of the post */
	public boolean unreactToPost(String pstID) {
		return false;
	}

	/* whoIsLoggedIn becomes a subscriber of another user */
	public boolean subscribe(String name) {
		return false;
	}

	/* whoIsLoggedIn unsubscribes from another user */
	public boolean unsubscribe(String name) {
		return false;
	}

	/* whoIsLoggedIn restricts user with name */
	public boolean restrict(String name) {
		return false;
	}

	/* whoIsLoggedIn unrestricts user with name */
	public boolean unrestrict(String name) {
		return false;
	}

	/* checks if name is a subscriber of whoIsLoggedIn */
	public boolean isASubscriber(String name) {
		return false;
	}

	/* check if whoIsLoggedIn is a subscriber of user with name */
	public boolean isSubscribedTo(String name) {
		return false;
	}

	/* checks if whoIsLoggedIn has restricted user with name */
	public boolean isRestricted(String name) {
		return false;
	}

	/* checks if user with name has access to post with pstID of whoIsLoggedIn */
	public boolean hasAccesstoPost(String name, int pstID) {
		return false;
	}

	/* checks if whoIsLoggedIn is owner of post with pstID */
	public boolean isPostOwner(int pstID) {
		return false;
	}

	/* returns the subscribers that have access to whoIsLoggedIn post with pstID */
	public ArrayList<String> subscribersWithAccessToPost(int pstID) {
		return new ArrayList<String>();
	}

	/* displays post with pstID */
	public void displayPost(int pstID) {
	}

	@Override
	public String toString() {
		return "TBD";
	}

}