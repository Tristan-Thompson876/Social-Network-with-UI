package p2;

import java.util.ArrayList;

import p1.enums.FeedAlgorithm;
import p1.enums.PostAudience;
import p1.enums.PostType;
import p1.enums.ReactionType;

public class Socials {

	/* is immutable instance data, i.e., once set cannot be changed */
	private String name;
	private User user;

	/* is mutable instance data */
	protected User whoIsLoggedIn = null;
	private FeedAlgorithm feedSort;
	private ArrayList<Post> posts = new ArrayList<Post>();
	//private ArrayList<Integer> posts = new ArrayList<Integer>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<String> dnames = new ArrayList<String>();

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
		if (post.getID() == pstID) {
				posts.remove(post);
				System.out.println("Post with pstID " + pstID + "was removed successfully.");
				//return; 
			}
			System.out.println("Post with pstID " + pstID + "was not found");
		}
	}

	public boolean searchForSocialsPost(int pstID) {
		for (Post post : posts) {
			if (post.getID() == pstID) {
				return true;
			}
		}
		return false;
	}

	public String whoOwnsSocialsPost(int pstID) {
		for (Post post : posts) {
			if (post.getID() == pstID) {
				return "Owner found";
			}
		}
		return "Owner not found";
	}

	public ArrayList<Integer> getAllSocialsPosts() {
		ArrayList<Integer> postIDs = new ArrayList<Integer>();
		for (Post post : posts) {
            postIDs.add(post.getID());
        }
        return postIDs;
	}
	
	public User getUser(){
		return user;
	}

	public ArrayList<Post> getPosts(){
		return posts;
	}

	public User getWhoIsLoggedIn() {
        return whoIsLoggedIn;
    }

	public void addNewSocialsUser(String name, String password) {
		User u = new User(name, password);
		users.add(u);
	}

	public void removeSocialsUser(String name) {
		if(isSocialsUser(name)){
			users.remove(name);
		}
	}

	/**
	 * whoIsLoggedIn should be null before a new user tries to login
	 * 
	 * if login successful update whoIsLoggedIn with user and return true else
	 * return false
	 * 
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean login(String username, String password) {
		for(User u : users){
			if(u.getUname().equals(username) && u.getPassword().equals(password)){
				whoIsLoggedIn = u;
				return true;
			}
		}
		return false;
	}

	public void logout() {
		whoIsLoggedIn = null;
	}

	/////////////////////////////////////////////////////////
	public boolean isSocialsUser(String name) {
		for(User u : users){
			if(u.getUname().equals(name)){
				return true;
			}
		}
		return false;
	}

	public ArrayList<String> getAllSocialsUsers() {
		//ArrayList<String> dnames = new ArrayList<String>();
		for(User u : users){
			String aname = u.getUname();
			dnames.add(aname);

		}
		return dnames;
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
		if (whoIsLoggedIn != null) {
			posts.add(whoIsLoggedIn.addNewPostu(type, sharedWith, contents));
		}		
	}
	//

	/* whoIsLoggedIn deletes a post they own */
	public boolean deletePost(int pstID)  {
        if (whoIsLoggedIn != null) {
            if (whoIsLoggedIn.isPostOwner(pstID)) {
                whoIsLoggedIn.deletePost(pstID);
                removeSocialsPost(pstID);
                return true;
            }
        }
        return false;
    }


	/* whoIsLoggedIn reacts to post, they should not be the owner of the post */
	public boolean reactToPost(String pstID, ReactionType vote) {
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.reactToPost(pstID,whoIsLoggedIn.toString().split("/")[0], vote);
        }
        return false;
    }

	/* whoIsLoggedIn unreacts to post, they should not be the owner of the post */
	public boolean unreactToPost(String pstID)  {
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.unreactToPost(pstID);
        }
        return false;
    }

	/* whoIsLoggedIn becomes a subscriber of another user */
	public boolean subscribe(String name) {
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.subscribe(name);
        }
        return false;
    }

	/* whoIsLoggedIn unsubscribes from another user */
	public boolean unsubscribe(String name){
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.unsubscribe(name);
        }
        return false;
    }

	/* whoIsLoggedIn restricts user with name */
	public boolean restrict(String name)  {
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.restrict(name);
        }
        return false;
    }

	/* whoIsLoggedIn unrestricts user with name */
	public boolean unrestrict(String name) {
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.unrestrict(name);
        }
        return false;
    }

	/* checks if name is a subscriber of whoIsLoggedIn */
	public boolean isASubscriber(String name)  {
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.isASubscriber(name);
        }
        return false;
    }

	/* check if whoIsLoggedIn is a subscriber of user with name */
	public boolean isSubscribedTo(String name) {
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.isSubscribedTo(name);
        }
        return false;
    }

	/* checks if whoIsLoggedIn has restricted user with name */
	public boolean isRestricted(String name) {
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.isRestricted(name);
        }
        return false;
    }

	/* checks if user with name has access to post with pstID of whoIsLoggedIn */
	public boolean hasAccesstoPost(String name, int pstID)  {
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.hasAccesstoPost(name, pstID);
        }
        return false;
    }

	/* checks if whoIsLoggedIn is owner of post with pstID */
	public boolean isPostOwner(int pstID)  {
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.isPostOwner(pstID);
        }
        return false;
    }

	/* returns the subscribers that have access to whoIsLoggedIn post with pstID */
	public ArrayList<String> subscribersWithAccessToPost(int pstID){
        if (whoIsLoggedIn != null) {
            return whoIsLoggedIn.subscribersWithAccessToPost(pstID);
        }
        return new ArrayList<String>();
    }

	/* displays post with pstID */
	public void displayPost(int pstID) {
        for (User u : users) {
            if (u.isPostOwner(pstID)) {
                u.displayPost(pstID);
                break;
            }
        }
    }

	@Override
	public String toString(){
        return "Socials Name: " + name + "\nSocials Feed Sort: " + feedSort +
               "\nAll Socials Users: " + getAllSocialsUsers() +
               "\nAll Socials Posts: " + getAllSocialsPosts();
    }

}
