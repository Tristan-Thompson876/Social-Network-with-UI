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
	// immutable instance data
	private Content url;

	public ExternalLinkPost(PostAudience sharedWith, String url) {
		// assumes url is valid, i.e., getUrlHTMLContents and display won't throw a
		// MalformedURLException nor an IOException respectively
		super(sharedWith);
		this.url = new Content(url);
	}

	@Override
	public String toString() {
		return "TBD";
	}

	// can be used to test if a URL format is valid
	// from https://www.baeldung.com/java-validate-url
	public boolean urlIsValid() {
		try {
			new URL(url.toString()).toURI();
			return true;
		} catch (MalformedURLException | URISyntaxException e) {
			return false;
		}
	}

	// can be used to test if a URL exists
	// from https://www.baeldung.com/java-check-url-exists
	public boolean urlExists() {
		try {
			URL urlchk = new URL(url.toString());
			HttpURLConnection huc = (HttpURLConnection) urlchk.openConnection();
			return huc.getResponseCode() == HttpURLConnection.HTTP_OK;
		} catch (IOException e) {
			return false;
		}
	}

	// from
	// https://stackoverflow.com/questions/54054653/how-do-i-draw-a-full-webpage-using-java-swing
	@Override
	public void display() {
		JEditorPane jep = new JEditorPane();
		jep.setEditable(false);

		try {
			jep.setPage(url.toString());
		} catch (IOException e) {
			jep.setContentType("text/html");
			jep.setText("<html>Could not load</html>");
		}

		JScrollPane scrollPane = new JScrollPane(jep);
		JFrame f = new JFrame("Post: " + getID());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(scrollPane);
		f.setPreferredSize(new Dimension(500, 300));
		f.pack();
		f.setVisible(true);
	}

	// testing the URL methods
	public static void main(String[] args) {
		ExternalLinkPost elp;

		elp = new ExternalLinkPost(PostAudience.Public, "://www.jovatpoint.com/URL-class");
		if (elp.urlIsValid())
			if (elp.urlExists())
				elp.display();
			else
				System.out.println("URL does not exist");
		else
			System.out.println("URL invalid");

		elp = new ExternalLinkPost(PostAudience.Public, "https://www.jovatpoint.com/URL-class");
		if (elp.urlIsValid())
			if (elp.urlExists())
				elp.display();
			else
				System.out.println("URL does not exist");
		else
			System.out.println("URL invalid");

		elp = new ExternalLinkPost(PostAudience.Public, "https://www.javatpoint.com/URL-class");

		if (elp.urlIsValid() && elp.urlExists())
			elp.display();

	}

    public String getUrl() {
        return null;
    }

}
