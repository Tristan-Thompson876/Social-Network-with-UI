package p2;

import java.util.ArrayList;

import p1.enums.PostAudience;

public class TextPost extends Post {
	// immutable instance data
	private ArrayList<Content> contents;

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
		return "TBD";
	}

	public void display() {
	}
}
