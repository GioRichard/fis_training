package hamcrest.test;

import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class TaxCalculatorTest {
    private TaxCalculator taxCalculator = new TaxCalculator();

    @Test
    public void shouldCalculateWithRounding() throws Exception {
        BigDecimal actual = taxCalculator.calculate(BigDecimal.valueOf(10), false);
        //JUnit assert
        assertEquals(BigDecimal.valueOf(1.8).setScale(2, RoundingMode.HALF_UP), actual);

        //Hamcrest matcher
        assertThat(actual, is(equalTo(BigDecimal.valueOf(1.8).setScale(2, RoundingMode.HALF_UP))));
    }

    @Test
    public void shouldGetAvailableTaxes() throws Exception {
        List<String> actual = TaxCalculator.AVAILABLE_TAXES;
        //JUnit assertions
        assertEquals(Arrays.asList("KDV", "OTV", "MTV"), actual);
        assertTrue(actual.contains("KDV"));
        assertTrue(!actual.contains("KDM"));
        assertEquals(3, actual.size());

        //Hamcrest matcher
        assertThat(actual, containsInAnyOrder("KDV", "OTV", "MTV"));
        assertThat(actual, not(contains("KDV", "MTV", "OTV")));
        assertThat(actual, contains("KDV", "OTV", "MTV"));
        assertThat(actual, hasItems("KDV", "OTV"));
        assertThat(actual, hasItem("MTV"));
        assertThat(actual, hasSize(3));
        assertThat(actual, instanceOf(List.class));
        assertThat(actual, everyItem(notNullValue(String.class)));
        assertThat(actual, everyItem(not(isEmptyOrNullString())));
    }

    @Test
    public void shouldGetTaxRate() throws Exception {
        BigDecimal actual = TaxCalculator.DEFAULT_TAX_RATE;
        //JUnit assert
        assertTrue(actual.compareTo(BigDecimal.valueOf(20)) < 0);
        assertEquals(BigDecimal.valueOf(18), actual);

        //Hamcrest matcher
        assertThat(actual, closeTo(BigDecimal.valueOf(18), BigDecimal.valueOf(0)));
        assertThat(actual, comparesEqualTo(BigDecimal.valueOf(18.000)));
        assertThat(actual, is(lessThan(BigDecimal.valueOf(20))));
    }

    @Test
    public void test() {

        List<Integer> num = Arrays.asList(99,123,45,148,33);

        assertThat( num, hasSize(5));
        assertThat( num, hasItems(99,45));

        assertThat( num, everyItem(greaterThan(20)));
        assertThat( num, everyItem(greaterThanOrEqualTo(33)));
        assertThat( num, everyItem(lessThan(150)));
    }

    @Test
    void demosInstanceOfTest() {

        //assertThat(Long.valueOf(1), instanceOf(Integer.class));
        // shortcut for instanceOf
        assertThat(Integer.valueOf(1), isA(Integer.class));
    }

    @Test
    void demoHamcrest() {
        boolean a = true;
        boolean b = true;

        assertThat(a, equalTo(b));
        assertThat(a, is(equalTo(b)));
        assertThat(a, is(b));
    }

    @Test
    void listShouldInitiallyBeEmpty() {
        List<Integer> list = Arrays.asList(5, 2, 4);

        assertThat(list, hasSize(3));

        // ensure the order is correct
        assertThat(list, contains(5, 2, 4));

        assertThat(list, containsInAnyOrder(2, 4, 5));

        assertThat(list, everyItem(greaterThan(1)));

    }

    @Test
    public void testCombine() {
        List<Integer> list = new ArrayList<>();
        assertThat(list, both(hasSize(1)).and(contains(42)));
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

    @Test
    public void givenBean_whenHasCorrectValue_thenCorrect() {
        Person person = new Person("Baeldung", "New York");
        assertThat(person, hasProperty("address", equalTo("New York")));
    }

    @Test
    public void givenCollection_whenEmpty_thenCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    @Test
    public void givenAList_whenChecksSize_thenCorrect() {
        List<String> hamcrestMatchers = Arrays.asList(
                "collections", "beans", "text", "number");
        assertThat(hamcrestMatchers, hasSize(4));
    }

    @Test
    public void givenArray_whenChecksSize_thenCorrect() {
        String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
        assertThat(hamcrestMatchers, arrayWithSize(4));
    }

    @Test
    public void givenAListAndValues_whenChecksListForGivenValues_thenCorrect() {
        List<String> hamcrestMatchers = Arrays.asList(
                "collections", "beans", "text", "number");
        assertThat(hamcrestMatchers,
                containsInAnyOrder("beans", "text", "collections", "number"));
    }

    @Test
    public void givenAListAndValues_whenChecksListForGivenValuesWithOrder_thenCorrect() {
        List<String> hamcrestMatchers = Arrays.asList(
                "collections", "beans", "text", "number");
        assertThat(hamcrestMatchers,
                contains("collections", "beans", "text", "number"));
    }

    @Test
    public void givenArrayAndValue_whenValueFoundInArray_thenCorrect() {
        String[] hamcrestMatchers = { "collections", "beans", "text", "number" };

        assertThat(hamcrestMatchers, hasItemInArray("text"));
        assertThat("text", isOneOf(hamcrestMatchers));

        String[] array = new String[] { "collections", "beans", "text",
                "number" };
        assertThat("beans", isIn(array));

        assertThat(hamcrestMatchers,
                arrayContainingInAnyOrder("beans", "collections", "number",
                        "text"));

        assertThat(hamcrestMatchers,
                arrayContaining("collections", "beans", "text", "number"));
    }

    @Test
    public void givenMapAndKey_whenKeyFoundInMap_thenCorrect() {
        Map<String, String> map = new HashMap<>();
        map.put("blogname", "baeldung");

        assertThat(map, hasKey("blogname"));
        assertThat(map, hasValue("baeldung"));
        assertThat(map, hasEntry("blogname", "baeldung"));

        assertThat(1, greaterThan(0));
        assertThat(5, greaterThanOrEqualTo(5));
        assertThat(-1, lessThan(0));
        assertThat(-1, lessThanOrEqualTo(5));
        assertThat(1.2, closeTo(1, 0.5));
    }

    @Test
    public void givenString_whenEmpty_thenCorrect() {
        String str = "";
        assertThat(str, isEmptyString());

        str = null;
        assertThat(str, isEmptyOrNullString());

        String str1 = "text";
        String str2 = " text ";
        assertThat(str1, equalToIgnoringWhiteSpace(str2));

        str = "calligraphy";
        assertThat(str, stringContainsInOrder(Arrays.asList("call", "graph")));

        String a = "foo";
        String b = "FOO";
        assertThat(a, equalToIgnoringCase(b));
    }


}