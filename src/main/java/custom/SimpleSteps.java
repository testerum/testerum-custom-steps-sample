package custom;

import com.testerum_api.testerum_steps_api.annotations.steps.Given;
import com.testerum_api.testerum_steps_api.annotations.steps.Param;
import com.testerum_api.testerum_steps_api.services.TesterumServiceLocator;
import com.testerum_api.testerum_steps_api.test_context.logger.TesterumLogger;
import com.testerum_api.testerum_steps_api.test_context.test_vars.TestVariables;

public class SimpleSteps {
    private final TesterumLogger logger = TesterumServiceLocator.getTesterumLogger();
    private final TestVariables testVariables = TesterumServiceLocator.getTestVariables();

    @Given(value = "I am logged in with with the role <<roleName>>",
           description = "Add a ROLE variable with the provided role as a value in the Testerum variables context.")
    public void login(@Param(description = "Param description") String roleName) {
        logger.info("Login with the role " + roleName);
        testVariables.set("ROLE", roleName);
    }
}
