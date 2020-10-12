package custom.company_model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Company {

    private final String name;
    private final List<Person> employees;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Company(@JsonProperty("name") String name,
                   @JsonProperty("employees") List<Person> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<Person> getEmployees() {
        return employees;
    }
}
