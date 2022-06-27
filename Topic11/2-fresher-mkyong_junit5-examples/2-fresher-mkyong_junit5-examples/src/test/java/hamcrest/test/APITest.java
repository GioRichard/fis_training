package hamcrest.test;

import org.testng.annotations.Test;

public class APITest {
    @Test
    void demosInstanceOfTest() {

        //assertThat(Long.valueOf(1), instanceOf(Integer.class));
        // shortcut for instanceOf
        assertThat(Integer.valueOf(1), isA(Integer.class));
    }
    @Test
    public void given2Strings_whenEqual_thenCorrect() {
        String a = "foo";
        String b = "FOO";
        assertThat(a, equalToIgnoringCase(b));
    }

    @Test
    public void givenBean_whenHasValue_thenCorrect() {
        Person person = new Person("Baeldung", "25");
        assertThat(person, hasProperty("name"));
    }

}
