package p1.enums;

public enum FeedAlgorithm {

	Popular("Popularity score, highest first"), Newest("Newest first!"), Oldest("Oldest first!");

	private String description;

	FeedAlgorithm(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
