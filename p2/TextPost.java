package p2;

import java.util.ArrayList;

import p1.enums.PostAudience;

public class TextPost extends Post {
	// immutable instance data
	//private ArrayList<Content> contents;
	private ArrayList<Content> contents = new ArrayList<>();

	public TextPost(PostAudience sharedWith, String... contents) {
		super(sharedWith);
		addContents(contents);
	}

	private void addContents(String... contents) {
		for (String c : contents)
			this.contents.add(new Content(c));
	}

	@Override
	public String toString() {
		StringBuilder postContentsBuilder = new StringBuilder();
		for (Content contentItem : contents) {
			postContentsBuilder.append(contentItem).append(System.lineSeparator());
		}
	
		return "TextPost Details: {" +
				"ID=" + getID() +
				", Shared With=" + getSharedWith() +
				", Popularity Score=" + getPopularityScore() +
				", Post Contents:\n" + postContentsBuilder.toString() +
				'}';
	}
	

	@Override
    public void display() {
        // Implement display logic using the toString method
        System.out.println(toString());
    }
}
