package p2;

import java.util.ArrayList;

import p1.enums.PostAudience;
import p1.enums.PostType;
import p1.enums.ReactionType;

public class User {

	// immutable instance data
	private String username;
	private String password;
	private PostType postType;

	// mutable instance data
	// there should be no overlap between subscribers and restricted
	// however, an overlap between subscribed and restricted is OK
	private ArrayList<String> subscribers = new ArrayList<String>(), subscribed = new ArrayList<String>(),
			restricted = new ArrayList<String>();
	private ArrayList<Post> posts = new ArrayList<Post>();
	private PostAudience sharedWith;
	private Post post;
    private Content content;


	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	//////////////////////////////Getters
    public String getUname(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public PostType getPostType(){
        return postType;
    }
	
	//////////////////////////////Setters
    public void setUname(String uname){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setPostType(PostType postType){
        this.postType = postType;
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

	/**
     * method to react to a post
     * @param pstID
     * @param vote
     */
	public void reactToPost(String pstID, ReactionType vote) {
        for(Post p : posts){
            if(p.getID() == Integer.parseInt(pstID)){
                String username = p.getUsername().getUname();  
                p.addReaction(username, vote);
            }
        }
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

	/**
     * 
     * @param name
     * @return boolean
     */
	public boolean isASubscriber(String name) {
        for(String sub: subscribers){
            if(sub == name){
                return true;
            }
        }
		return false;
	}

	/**
     * 
     * @param name
     * @return boolean
     */
	public boolean isSubscribedTo(String name) {
		for(String sub: subscribed){
            if(sub == name){
                return true;
            }
        }
		return false;
	}

	/**
     * 
     * @param name
     * @return boolean
     */
	public boolean isRestricted(String name) {
		for(String sub: restricted){
            if(sub == name){
                return true;
            }
        }
		return false;
	}

	/**
     * 
     * @param name
     * @param pstID
     * @return boolean
     */
	public boolean hasAccesstoPost(String name, int pstID) {
        for (Post p : posts) {
            if (p.getID() == pstID) {
                PostAudience audience = p.getSharedWith();
    
                switch (audience) {
                    case Private:
                        return p.getUsername().getUname().equals(name);
    
                    case Public:
                        return true;
    
                    case Subscribers:
                        return isASubscriber(name);
    
                    default:
                        return false;
                }
            }
        }
        return false;
    }

	public boolean isPostOwner(int pstID) {
        for(Post p: posts){
            if(p.getID() == pstID){
                return true;
            }
        }
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
