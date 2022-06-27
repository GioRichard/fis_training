package hamcrest.test;

public class Person {
    private String name;
    private String address;

    public Person(String personName, String personAddress) {
        name = personName;
        address = personAddress;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
