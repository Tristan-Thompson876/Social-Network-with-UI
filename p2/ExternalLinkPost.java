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

    public boolean urlIsValid() {
        try {
            new URL(url.toString()).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    public boolean urlExists() {
        try {
            URL urlchk = new URL(url.toString());
            HttpURLConnection huc = (HttpURLConnection) urlchk.openConnection();
            return huc.getResponseCode() == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            return false;
        }
    }

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

        JFrame f = createDisplayFrame(jep);
        f.setVisible(true);
    }

    private JFrame createDisplayFrame(JEditorPane jep) {
        JScrollPane scrollPane = new JScrollPane(jep);
        JFrame f = new JFrame("Post: " + getID());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(scrollPane);
        f.setPreferredSize(new Dimension(500, 300));
        f.pack();
        return f;
    }

	public String getUrl() {
		return null;
	}
}