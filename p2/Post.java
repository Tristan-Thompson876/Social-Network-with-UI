package p2;

import java.util.ArrayList;

import p1.enums.PostAudience;
import p1.enums.PostType;
import p1.enums.ReactionType;

public abstract class Post implements Comparable<Post> {

	private static ArrayList<Integer> postIDs = new ArrayList<Integer>();

	private static int postscount = 0;
	// immutable instance data
	private int postID = ++postscount;
	private PostType postType = PostType.Text;
	private PostAudience sharedWith = PostAudience.Public;


	// mutable instance data
	private int popularityScore = 0;
	private Reaction upvote = new Reaction(ReactionType.Upvote);
	private Reaction downvote = new Reaction(ReactionType.Downvote);
	private ArrayList<Content> contents = new ArrayList<Content>();
	private ArrayList<String> reactedUsers = new ArrayList<>();
	private String content;
	private User username;

	public Post() {
		assignPostID();
	} 

	public Post(PostAudience sharedWith) {
		this.sharedWith = sharedWith;
	}

	public Post(PostAudience sharedWith, String content) {
		this.sharedWith = sharedWith;
		this.content = content;

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

	/**
	 * 
	 * @return
	*/
	public User getUsername(){
		return username;
	}

	public PostAudience getSharedWith() {
		return sharedWith;
	}

	public int getPopularityScore() {
		return popularityScore;
	}

	public String getContent() {
		System.out.println(content);
        if (this instanceof TextPost) {
			// If it's a TextPost, concatenate the contents
			TextPost textPost = (TextPost) this;
			StringBuilder contentBuilder = new StringBuilder();
			for (Content contentItem : textPost.getContents()) {
				contentBuilder.append(contentItem).append(System.lineSeparator());
			}
			System.out.println(contentBuilder.toString());
			return contentBuilder.toString();
		} else if (this instanceof ExternalLinkPost) {
			// If it's an ExternalLinkPost, return the URL directly
			ExternalLinkPost linkPost = (ExternalLinkPost) this;
			System.out.println("External Link: " + linkPost.getContent());
			return "External Link: " + linkPost.getContent();
		} else {
			// For other types of posts, return the content directly
			System.out.println(content);
			return content;
		}
    }


	public int getID() {
		return postID;
	}

	private int getUniqueID() {
		// get a random integer greater than 0 that has is not already in the postIDs
		// and return it.
		return 0;
	}
	/**
	 * Post Id setter
	 */
	public void setPostID(int pstID){
		this.postID = pstID;
	}
	/**
	 * Sharedwith setter
	 */
	public void setSharedWith(PostAudience sharedWith){
		this.sharedWith = sharedWith;
	}
	/**
	 * Post Type setter
	 */
	public void setPostType(PostType postType){
		this.postType = postType;
	}
	/**
	 * Content setter
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * 
	 * @param name
	 */
	public void setUname(User name){
		this.username = name;
	}

	@Override
	public String toString() {
		       // Implement logic for the string representation of the post
      return "Post ID: " + postID + "\nShared with: " + sharedWith + "\nPopularity Score: " + popularityScore;
			}

	@Override
	public int compareTo(Post otherPost)  {
        // Implement logic for comparing posts based on popularity score
        return Integer.compare(otherPost.getPopularityScore(), this.getPopularityScore());
    }

	public abstract void display();

	public PostType getPostType() {
		return postType;
	}

}
