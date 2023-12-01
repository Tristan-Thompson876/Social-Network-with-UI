package p2;

/**
 * class Content
 */
public class Content {
    private String data;

    /**
     * Constructor for Content
     * @param data
     */
    public Content(String data) {
        this.data = data;
    }

    /**
     * 
     * @return String data
     */
    public String getData() {
        return data;
    }

    /**
     * 
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Info:" + data + '\'';
    }
}

