package p2;

import java.awt.Dimension;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import p1.enums.PostAudience;

public class ExternalLinkPost extends Post {
    private Content url; // immutable instance data

    public ExternalLinkPost(PostAudience sharedWith, String url) {
        super(sharedWith);
        this.url = new Content(url);
    }

    @Override
    public String toString() {
        return "ExternalLinkPost{ID=" + getID() + ", URL=" + url + "}";
    }


    @Override
    public void display() {
        // Implement display logic for ExternalLinkPost
        System.out.println("Displaying External Link Post:");
        System.out.println(toString());
        // Add additional logic for displaying the URL in your GUI
    }

	public String getUrl() {
		return null;
	}
}