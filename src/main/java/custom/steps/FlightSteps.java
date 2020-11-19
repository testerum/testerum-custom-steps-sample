package custom.steps;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testerum_api.testerum_steps_api.annotations.steps.Param;
import com.testerum_api.testerum_steps_api.annotations.steps.When;
import com.testerum_api.testerum_steps_api.services.TesterumServiceLocator;
import com.testerum_api.testerum_steps_api.test_context.logger.TesterumLogger;
import com.testerum_api.testerum_steps_api.test_context.test_vars.TestVariables;
import custom.flight_model.FlightDetails;
import custom.flight_model.FlightOfferResponse;
import custom.flight_model.FlightSearchRequest;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FlightSteps {
    public static final MediaType APPLICATION_JSON = MediaType.parse("application/json; charset=utf-8");

    private final TesterumLogger logger = TesterumServiceLocator.getTesterumLogger();
    private final TestVariables testVariables = TesterumServiceLocator.getTestVariables();

    private final ObjectMapper mapper = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();

    @When(value = "I search for the flight <<flightDetails>>",
        description = "Search and selects the best flight based on the provided details.")
    public void searchAndSelectTheBestFlightOffer(@Param FlightDetails flightDetails) throws Exception {

        List<FlightOfferResponse> flightOffers = attemptFlightSelection(flightDetails);
        FlightOfferResponse bestFlightOffer = flightOffers.get(0);

        if (bestFlightOffer != null) {
            logger.info("Selected flight number: " + bestFlightOffer);
            testVariables.set("BEST_FLIGHT_OFFER", bestFlightOffer);
        }
    }

    private List<FlightOfferResponse> attemptFlightSelection(FlightDetails flightDetails)throws Exception {

        String requestBody = getFlightSearchRequestAsJson(flightDetails);

        Request request = new Request.Builder()
            .url(flightDetails.context.baseUrl + "/flights/offers")
            .header("Authentication", "Basic " + flightDetails.context.accessToken)
            .post(RequestBody.create(
                APPLICATION_JSON,
                requestBody
            ))
            .build();

        try (Response response = client.newCall(request).execute()) {
            return mapper.readValue(response.body().string(), new TypeReference<List<FlightOfferResponse>>() {});
        }
    }

    private String getFlightSearchRequestAsJson(FlightDetails flightDetails) throws Exception {
        FlightSearchRequest request = new FlightSearchRequest(
            flightDetails.departure,
            flightDetails.destination,
            flightDetails.bookingDate
        );
        return mapper.writeValueAsString(request);
    }
}
