package p2;

import java.util.ArrayList;

import p1.enums.PostAudience;

public class ExternalLinkPost extends Post {
    private ArrayList<Content> url;

    public ExternalLinkPost(PostAudience sharedWith, String url) {
        super(sharedWith);
        this.url = new ArrayList<>();
        addContents(url);
    }

    private void addContents(String... contents) {
		for (String u : contents)
			this.url.add(new Content(u));
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

	/*public String getUrl() {
		return url;
	}*/
}