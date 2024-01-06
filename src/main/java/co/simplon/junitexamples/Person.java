package co.simplon.junitexamples;

/**
 * This class represents a simplified (abstracted) person from the real life.
 * <p>
 * A class designed by contract. Class contract clauses (class invariants):
 * <ul>
 * <li>Firstname is never {@code null} and guarantees the original case
 * <li>Lastname is never {@code null} and cannot change once initialized, and
 * guarantees the original case
 * </ul>
 * Preconditions are documented at constructor and methods level.
 */
public class Person {

    private String firstName; // should be final (Damla advice!)

    private final String lastName;

    /**
     * Construct a new person with given arguments.
     * <p>
     * The newly created person is insured to have an unmodifiable lastname.
     * 
     * @param firstName a first name, not {@code null}
     * @param lastName  a last name, not {@code null}
     * 
     * @throws IllegalArgumentException if any of the argument is {@code null}
     */
    public Person(String firstName, String lastName) {
	if (firstName == null || lastName == null) {
	    throw new IllegalArgumentException();
	}
	this.firstName = firstName;
	this.lastName = lastName;
    }

    /**
     * Returns the person first name.
     * 
     * @return the person first name, never {@code null}
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * Returns the person last name.
     * 
     * @return the person last name, never {@code null}
     */
    public String getLastName() {
	return lastName;
    }

    /**
     * Returns the person full name.
     * <p>
     * The result is the concatenation of the first name, a whitespace character
     * and the last name.
     * 
     * @return the person full name, never {@code null}
     */
    public String getFullName() {
	return firstName + " " + lastName;
    }

    /**
     * Returns a string representation of this person.
     * 
     * @return a string representation of this person; never {@code null}
     */
    @Override
    public String toString() {
	// Very Bad Practice (just a side-effect example)
	firstName = firstName.toUpperCase();
	return String.format("{firstName=%s, lastName=%s}", firstName,
		lastName);
    }

}
