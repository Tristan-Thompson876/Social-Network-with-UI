package p1.enums;

public enum PostType {

	Text("Text"), ExtrenalLink("External URL");

	private String description;

	PostType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
