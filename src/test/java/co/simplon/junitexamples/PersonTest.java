package co.simplon.junitexamples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test class for Person class")
class PersonTest {

    @Test
    @DisplayName("Test for constructor exception")
    void shouldConstructorThrowIllegalArgumentExceptionWhithNullParams() {
	// () -> new Person(null, null)
	// is an anomymous function (aka lambda expression)
	// similar to "arrow functions" in JavaScript
	// functional programming approach: the "what", not the "how"
	assertThrows(IllegalArgumentException.class,
		() -> new Person(null, null));
    }

    @Test
    void shouldConstructorReturnsWithNonNullParams() {
	Person actual = new Person("Super", "Snippet");
	assertNotNull(actual);
	checkInvariantsAfterConstructorAndToString(actual, "Super", "Snippet");
    }

    @Test
    void shouldGetFirstNameReturnsSameAsInit() {
	Person person = new Person("Super", "Snippet");
	String actual = person.getFirstName();
	assertEquals("Super", actual);
    }

    @Test
    void shouldGetFirstNameReturnsNotSameAsInit() {
	Person person = new Person("super", "Snippet");
	String actual = person.getFirstName();
	assertNotEquals("SUPER", actual);
    }

    @Test
    void shouldGetLastNameReturnsSameAsInit() {
	Person person = new Person("Super", "Snippet");
	String actual = person.getLastName();
	assertEquals("Snippet", actual);
    }

    @Test
    void shouldGetLastNameReturnsNotSameAsInit() {
	Person person = new Person("Super", "snippet");
	String actual = person.getLastName();
	assertNotEquals("SNIPPET", actual);
    }

    @Test
    void shouldGetFullNameReturnsSameAsInit() {
	Person person = new Person("Super", "Snippet");
	String actual = person.getFullName();
	assertEquals("Super Snippet", actual);
    }

    @Test
    void shouldGetFullNameReturnsNotSameAsInit() {
	Person person = new Person("Super", "Snippet");
	String actual = person.getFullName();
	assertNotEquals("SUPER SNIPPET", actual);
    }

    @Test
    void shouldToStringReturnsNotNull() {
	Person person = new Person("Super", "Snippet");
	String actual = person.toString();
	assertNotNull(actual);
	// Verify invariants after each test (method invoked on object under
	// test)
	checkInvariantsAfterConstructorAndToString(person, "Super", "Snippet");
	// Previous version:
//	boolean checked = checkInvariantsAfterConstructorAndToString(person,
//		"Super", "Snippet");
//	assertTrue(checked, "Invariant violation");
    }

    /**
     * Same checks after constructor and toString calls.
     * <p>
     * Checks each invariant with an assertion and contextual message to spot
     * the violation.
     * 
     * @param person            the actual person under test
     * @param expectedFirstName the expected person's first name
     * @param expectedLastName  the expected person's last name
     */
    private static void checkInvariantsAfterConstructorAndToString(
	    Person person, String expectedFirstName, String expectedLastName) {
	String actualFirstName = person.getFirstName();
	assertEquals(expectedFirstName, actualFirstName,
		"First name invariant violation");
	String actualLastName = person.getLastName();
	assertEquals(expectedLastName, actualLastName,
		"Last name invariant violation");
	String actualFullName = person.getFullName();
	assertEquals(expectedFirstName + " " + expectedLastName, actualFullName,
		"Full name invariant violation");
//	return person.getFirstName().equals(expectedFirstName)
//		&& person.getLastName().equals(expectedLastName)
//		&& person.getFullName()
//			.equals(expectedFirstName + " " + expectedLastName);
    }

}
