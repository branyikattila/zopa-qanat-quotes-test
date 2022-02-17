package uk.co.acme.stepdefs;

import cucumber.api.java.en.When;

import cucumber.api.java.en.Then;
import io.magentys.cinnamon.conf.Env;
import io.restassured.response.Response;
import uk.co.acme.apiservices.ApiService;
import uk.co.acme.context.Context;
import uk.co.acme.dao.RequestDataDao;
import uk.co.acme.model.QuoteResponseDataModel;
import uk.co.acme.model.RequestDataModel;
import uk.co.acme.utils.Utils;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class StepDefs {

    private final ApiService apiService;
    private final Env env;
    private final RequestDataDao requestDataDao;
    private final Context context;
    private final Utils utils;

    @Inject
    public StepDefs(final ApiService apiService,
                    final Env env, final RequestDataDao requestDataDao,
                    final Context context, final Utils utils) {
        this.apiService = apiService;
        this.env = env;
        this.requestDataDao = requestDataDao;
        this.context = context;
        this.utils = utils;
    }

    @When("I request a loan for {string} user with valid value")
    public void i_request_a_loan_for_user_with_valid_value(String userType) throws Throwable {
        Response response = apiService.getQuote(env.config.getString("base-url"), context.getMemberId(),
                requestDataDao.getTestDataByName("validQuote").getPayload());
        context.setResponseCode(response.getStatusCode());
        context.setResponse(response);
    }

    @When("I request a loan for {string} user")
    public void i_request_a_loan_for_user(String name) throws Throwable {
        RequestDataModel data = requestDataDao.getTestDataByName(name);
        Response response = apiService.getMember(env.config.getString("base-url"), data.getMemberId());
        context.setResponseCode(response.statusCode());
        context.setResponse(response);
    }

    @When("I request a loan for {string} user with data")
    public void i_request_a_loan_for_user_with_data(String userType) throws Throwable {
        Response response = apiService.getQuote(env.config.getString("base-url"), context.getMemberId(),
                requestDataDao.getTestDataByName(userType).getPayload());
        context.setResponseCode(response.getStatusCode());
        context.setResponse(response);
    }

    @Then("I should receive a non existing user message")
    public void i_should_receive_a_non_existing_user_message() throws Throwable {
        assertThat("The response code is not what expected.", String.valueOf(context.getResponseCode()),
                equalTo(requestDataDao.getTestDataByName("nonExisting").getExpectedResponseCode()));
        assertThat("The response message is not what expected.", utils.formatInput(context.getResponse().getBody().print()),
                equalTo(requestDataDao.getTestDataByName("nonExisting").getExpectedFailMsg()));
    }

    @Then("I should receive a decision that the loan is offered")
    public void i_should_receive_a_decision_that_the_loan_is_offered() throws Throwable {
        QuoteResponseDataModel result = context.getResponse().as(QuoteResponseDataModel.class);
        QuoteResponseDataModel reference = requestDataDao.getTestDataByName("validQuote").getExpectedResponseMsg();
        assertThat("The response code is not what expected.",
                String.valueOf(context.getResponseCode()),
                equalTo(requestDataDao.getTestDataByName("validQuote").getExpectedResponseCode()));
        assertThat("Quote offered field shows invalid data.",
                result.getQuoteOffered(), equalTo(true));
        assertThat("Amount to borrow in response shows invalid number.",
                result.getAmountToBorrow(), equalTo(reference.getAmountToBorrow()));
        assertThat("Interest rate in response is not right.",
                result.getInterestRate(), equalTo(reference.getInterestRate()));
        assertThat("Term length is response is not valid",
                result.getTermLength(), equalTo(reference.getTermLength()));
        assertThat("Members full name is showing wrong in response",
                result.getMembersFullName(), equalTo(reference.getMembersFullName()));
        }

    @Then("I should receive an message about loan is not offered")
    public void i_should_receive_an_message_about_loan_is_not_offered() throws Throwable {
        RequestDataModel reference = requestDataDao.getTestDataByName("invalidQuote");
        assertThat("Response code was not 400.", String.valueOf(context.getResponseCode()), equalTo(reference.getExpectedResponseCode()));
        assertThat("Response message is not what expected.", utils.formatInput(context.getResponse().print()),
                equalTo(reference.getExpectedFailMsg()));

    }
}