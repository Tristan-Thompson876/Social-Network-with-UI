# Social-Network-with-UI

to be implemented
# post.java     
    public String toString()

# socials.java 
    public boolean deletePost(int pstID)
	public boolean reactToPost(String pstID, ReactionType vote)
	public boolean unreactToPost(String pstID)
	public boolean subscribe(String name)
	public boolean unsubscribe(String name)
	public boolean restrict(String name)
	public boolean unrestrict(String name) 
	public boolean isASubscriber(String name)
	public boolean isSubscribedTo(String name) 
	public boolean isRestricted(String name) 
	public boolean hasAccesstoPost(String name, int pstID)
	public boolean isPostOwner(int pstID)
	public ArrayList<String> subscribersWithAccessToPost(int pstID)
	public void displayPost(int pstID)
	public String toString() 
	
# TextPost.java
    public String toString()

# User.java
    public boolean unreactToPost(String pstID)
	public boolean subscribe(String name)
	public boolean unsubscribe(String name)
	public boolean restrict(String name)
	public boolean unrestrict(String name)
    public void displayPost(int pstID)
	public String toString()

# Profile.java