package p1.enums;

public enum ReactionType {

	Upvote("Approves"), Downvote("Disapproved");

	private String description;

	ReactionType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
