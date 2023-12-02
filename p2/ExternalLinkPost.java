package p2;

import java.util.ArrayList;
import p1.enums.PostAudience;

/**
 * Represents an external link post in a social media context.
 * This class extends the generic Post class to specialize in handling URLs.
 */
public class ExternalLinkPost extends Post {
    // Field for storing URLs
    private ArrayList<Content> url;

    /**
     * Constructor to create an ExternalLinkPost instance.
     * 
     * @param sharedWith The audience with whom the post is shared.
     * @param url The URL to be included in the post.
     */
    public ExternalLinkPost(PostAudience sharedWith, String url) {
        super(sharedWith);
        this.url = new ArrayList<>();
        addContents(url);
    }

    /**
     * Adds URL contents to the post.
     * 
     * @param contents Variable number of URL contents to be added to the post.
     */
    private void addContents(String... contents) {
        for (String u : contents)
            this.url.add(new Content(u));
    }

    /**
     * Provides a string representation of the ExternalLinkPost.
     * 
     * @return A string describing the ExternalLinkPost, including its ID and URL.
     */
    @Override
    public String toString() {
        return "ExternalLinkPost{ID=" + getID() + ", URL=" + url + "}";
    }

    /**
     * Displays the external link post, including its details.
     */
    @Override
    public void display() {
        // Implement display logic for ExternalLinkPost
        System.out.println("Displaying External Link Post:");
        System.out.println(toString());
        // Additional display logic can be added here
    }

    // Uncomment and add JavaDoc if needed
    /*public String getUrl() {
        return url;
    }*/
}
