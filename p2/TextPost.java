package p2;

import java.util.ArrayList;
import p1.enums.PostAudience;

/**
 * Represents a text post in a social media application.
 * This class extends the Post class and specializes in handling text content.
 */
public class TextPost extends Post {
    
    /** Stores the contents of the text post. */
    private ArrayList<Content> contents;

    /**
     * Constructs a new TextPost with specified audience and content.
     * 
     * @param sharedWith The audience with whom the post is shared.
     * @param contents The variable number of text contents to be included in the post.
     */
    public TextPost(PostAudience sharedWith, String... contents) {
        super(sharedWith);
        this.contents = new ArrayList<>();
        addContents(contents);
    }

    /**
     * Adds multiple text contents to the post.
     * 
     * @param contents The variable number of text contents to be added.
     */
    private void addContents(String... contents) {
        this.contents = new ArrayList<>();
        System.out.println("it got added");
        for (String c : contents)
            this.contents.add(new Content(c));
    }

    /**
     * Returns the list of contents of the text post.
     * 
     * @return A list of Content objects representing the contents of the post.
     */
    public ArrayList<Content> getContents(){
        return contents;
    }

    /**
     * Provides a string representation of the text post, including its details.
     * 
     * @return A string describing the text post.
     */
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
                "}";
    }
    
    /**
     * Displays the text post by printing its details.
     */
    @Override
    public void display() {
        System.out.println(toString());
    }
}
