package p2;

import java.util.ArrayList;

import p1.enums.ReactionType;
/**
 * Represents a reaction to a post in a social media context.
 * This class handles the type of reaction and tracks users who have reacted.
 */
public class Reaction {
	// immutable instance data
	private ReactionType type;

	// mutable instance data
	private ArrayList<String> reactors = new ArrayList<String>();
     /**
     * Constructor to create a new Reaction instance.
     * 
     * @param type The type of reaction (like, dislike, etc.).
     */
	public Reaction(ReactionType type) {
		this.type = type;
	}

	public ReactionType getType() {
		return type;
	}

	/**
     * Adds a reactor to this reaction if they have not already reacted.
     *
     * @param name The name of the user reacting.
     */
	public void addReactor(String name) {
		// duplicates not allowed
		if (!reactors.contains(name)) {
            reactors.add(name);
        }
	}

	/**
     * Removes a reactor from this reaction.
     *
     * @param name The name of the user whose reaction is to be removed.
     */
    public void removeReactor(String name) {
        if (reactors.contains(name)) {
            reactors.remove(name);
        }
    }

	/**
     * Checks if a user has already reacted.
     *
     * @param name The name of the user to check.
     * @return True if the user has already reacted, otherwise false.
     */
    public boolean alreadyReacted(String name) {
        return reactors.contains(name);
    }

	/**
     * Returns the count of reactors.
     *
     * @return The number of users who have reacted.
     */
	public int getCount() {
		return reactors.size();
	}

	/**
     * Returns a string representation of the reactors.
     *
     * @return A string containing the names of all the reactors, separated by commas.
     */
    public String getReactors() {
        return String.join(", ", reactors);
    }

	/**
     * Returns a string representation of this Reaction.
     *
     * @return A string that includes the type of reaction and the list of reactors.
     */
    @Override
    public String toString() {
        return "Reaction{" +
            "type=" + type +
            ", reactors=" + getReactors() +
            '}';
    }

}
