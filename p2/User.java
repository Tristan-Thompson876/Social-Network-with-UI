package p2;

import java.util.ArrayList;

import p1.enums.PostAudience;
import p1.enums.PostType;
import p1.enums.ReactionType;

/**
 * Represents a user in a social media platform.
 * This class manages user details, posts, and interactions with other users.
 */
public class User {

	// immutable instance data
	private String username;
	private String password;
	private PostType postType;

	// mutable instance data
	// there should be no overlap between subscribers and restricted
	// however, an overlap between subscribed and restricted is OK
	private ArrayList<String> subscribers = new ArrayList<String>(), subscribed = new ArrayList<String>(), restricted = new ArrayList<String>();
	private ArrayList<Post> posts = new ArrayList<Post>();
	private PostAudience sharedWith;
	//private Post post;
    //private Content content;


	/**
     * Constructs a new User with a username and password.
     * 
     * @param username The username of the user.
     * @param password The password of the user.
     */
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

    /**
     * Attempts to log in the user with the given username and password.
     * 
     * @param uname The username to log in with.
     * @param pword The password to log in with.
     * @return True if the login credentials match, false otherwise.
     */
	public boolean login(String uname, String pword) {
        return username.equals(uname) && password.equals(pword);
	}
    private static int postCounter = 0;

    private int generatePostId() {
        return ++postCounter;
    }
/**
     * Adds a new post of specified type and audience by the user.
     * 
     * @param type The type of the post.
     * @param sharedWith The audience with whom the post is shared.
     * @param contents The content of the post.
     * @return The newly created Post object.
     */
    public Post addNewPostu(PostType type, PostAudience sharedWith, String[] contents) {
        if (!isLoggedIn()) {
            System.out.println("User is not logged in. Cannot add a new post.");
            return null;
        }
    
        Post newPost = null;
    
        int postId = generatePostId();
    
        if (type == PostType.Text) {
            newPost = new TextPost(sharedWith, contents);
        } else if (type == PostType.ExternalLink) {
            newPost = new ExternalLinkPost(sharedWith, contents[0]);
        }
    
        if (newPost != null) {
            newPost.setPostID(postId);
            // updatePostAccess(newPost);
            
            posts.add(newPost);
    
            return newPost;
        }
    
        return null;
        
    }

	/*public int addNewPost(PostType type, PostAudience sharedWith, String... contents) {
        
        
        if (type == PostType.Text) {
            newPost = new TextPost(sharedWith, contents);
        }else if (type == PostType.ExternalLink) {
            newPost = new ExternalLinkPost(sharedWith, contents[0]);
            
        posts.add(newPost);
   
        } else {
            System.out.println("invalid post");
        }
        
    
        return newPost.getID();
	}
    */

	public boolean deletePost(int pstID) {
		return false;
	}

	/**
     * method to react to a post
     * @param pstID
     * @param vote
     */
	public boolean reactToPost(String pstID, String reactor, ReactionType vote) {
        for(Post p : posts){
            if(p.getID() == Integer.parseInt(pstID)){
                String username = p.getUsername().getUname();  
                p.addReaction(username, vote);
                return true;
            }
        }
        return false;
	}
/**
     * Removes a reaction from a post.
     * 
     * @param pstID The ID of the post to remove the reaction from.
     * @return True if the unreaction was successful, false otherwise.
     */
	public boolean unreactToPost(String pstID) {
        for (Post p : this.posts) {
            if (p.getID() == Integer.parseInt(pstID)) {
                p.removeReaction(this.username);
                return true;
            }
        }
        return false;
    }
 /**
     * Subscribes the user to another user's posts.
     * 
     * @param name The username of the user to subscribe to.
     * @return True if the subscription was successful, false otherwise.
     */
	public boolean subscribe(String name){
        this.subscribers.add(name);
        this.subscribed.add(name);
        return true;
    }
/**
     * Unsubscribes the user from another user's posts.
     * 
     * @param name The username of the user to unsubscribe from.
     * @return True if the unsubscription was successful, false otherwise.
     */
	public boolean unsubscribe(String name){
        this.subscribers.remove(name);
        return true;
    }
 /**
     * Restricts a specific user from accessing the user's posts.
     * 
     * @param name The username of the user to restrict.
     * @return True if the restriction was successful, false otherwise.
     */
	public boolean restrict(String name)  {
        this.subscribers.remove(name);
        return true;
    }
/**
     * Unrestricts a specific user, allowing access to the user's posts.
     * 
     * @param name The username of the user to unrestrict.
     * @return True if the unrestriction was successful, false otherwise.
     */
	public boolean unrestrict(String name){
        this.restricted.remove(name);
        return true;
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

    private boolean isLoggedIn() {
        return password != null && !password.isEmpty();
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

	public void displayPost(int pstID)  {
        for (Post p : posts) {
            if (p.getID() == pstID) {
                p.display();
                break;
            }
        }
    }

	@Override
	public String toString() {
        return username + "/" + password + "/" + subscribers + "/" + subscribed + "/" + restricted + "/" + posts;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

}
