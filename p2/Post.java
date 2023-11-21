package p2;

import java.util.ArrayList;

import p1.enums.PostAudience;
import p1.enums.ReactionType;

public abstract class Post implements Comparable<Post> {

	private static ArrayList<Integer> postIDs = new ArrayList<Integer>();

	// immutable instance data
	private int postID;
	private PostAudience sharedWith = PostAudience.Public;


	// mutable instance data
	private int popularityScore = 0;
	private Reaction upvote = new Reaction(ReactionType.Upvote);
	private Reaction downvote = new Reaction(ReactionType.Downvote);
	private ArrayList<Content> contents = new ArrayList<Content>();
	private ArrayList<String> reactedUsers = new ArrayList<>();

	public Post() {
		assignPostID();
	}

	public Post(PostAudience sharedWith) {
		this.sharedWith = sharedWith;
		assignPostID();
	}

	private void assignPostID() {
		postID = getUniqueID();
		postIDs.add(postID);
	}

	private void updatePopularityScore() {
	}

	/**
	 * add a reaction with the name of reactor to post
 	 */
	  public void addReaction(String name, ReactionType type) {
		// a user can only react once to a post
        if (!reactedUsers.contains(name)) {
            
            //Reaction reaction = new Reaction(type);
			if(type == ReactionType.Upvote){
            	reactedUsers.add(name);
			}
            
        } else {
            System.out.println(name + "already reacted");
        
        }
    }

	/**
	 * removes a reaction
	 * @param name 
	 */
	public void removeReaction(String name) {
		if(reactedUsers.contains(name)){
			reactedUsers.remove(name);

		}
		else{
			System.out.println(name + "have not reacted");
		}
	}

	/**
	 * 
	 * @param name
	 * @return boolean
	 */
	public boolean alreadyReacted(String name) {
		if (!reactedUsers.contains(name)) {
			return false;
		}
		else{
			return false;
		}

	}

	public PostAudience getSharedWith() {
		return sharedWith;
	}

	public int getPopularityScore() {
		return popularityScore;
	}

	public int getID() {
		return postID;
	}

	private int getUniqueID() {
		// get a random integer greater than 0 that has is not already in the postIDs
		// and return it.
		return 0;
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public int compareTo(Post otherPost) {
		return 0;
	}

	public abstract void display();

}
