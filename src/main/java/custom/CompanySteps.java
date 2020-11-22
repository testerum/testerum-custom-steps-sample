package custom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.testerum_api.testerum_steps_api.annotations.steps.Param;
import com.testerum_api.testerum_steps_api.annotations.steps.When;
import com.testerum_api.testerum_steps_api.services.TesterumServiceLocator;
import com.testerum_api.testerum_steps_api.test_context.logger.TesterumLogger;
import com.testerum_api.testerum_steps_api.test_context.test_vars.TestVariables;
import custom.company_model.Company;
import custom.company_model.Person;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;

public class CompanySteps {

    private final TesterumLogger logger = TesterumServiceLocator.getTesterumLogger();
    private final TestVariables testVariables = TesterumServiceLocator.getTestVariables();

    ObjectMapper objectMapper = new ObjectMapper()
        .enable(INDENT_OUTPUT)
        .registerModule(new JavaTimeModule());;

    @When(value = "I create a company <<companyDetails>>",
          description = "Add the company in the Testerum context:\n"
            + " - **COMPANY_OBJECT** variable contains the company as an object\n"
            + " - **COMPANY_JSON_STRING** variable contains the company as an serialized JSON String")
    public Person searchAndSelectTheBestFlightOffer(
        @Param(description = "The Company to be added in the context") Company company
    ) throws JsonProcessingException {

        String companyJson = objectMapper.writeValueAsString(company);

        logger.info(companyJson);
        testVariables.set("COMPANY_OBJECT", company);
        testVariables.set("COMPANY_JSON_STRING", companyJson);

        new Settings().logMySetting();

        return null;
    }
}
