package uk.co.acme.hooks;

import cucumber.api.java.Before;
import io.magentys.cinnamon.conf.Env;
import io.restassured.response.Response;
import uk.co.acme.apiservices.ApiService;
import uk.co.acme.context.Context;
import uk.co.acme.dao.RequestDataDao;
import uk.co.acme.model.RequestDataModel;
import uk.co.acme.model.SuccessRespMsgDataModel;

import javax.inject.Inject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Hooks {

    private final Env env;
    private final ApiService apiService;
    private final Context context;
    private final RequestDataDao requestDataDao;

    @Inject
    public Hooks(final Env env, final ApiService apiService,
                 final Context context, final RequestDataDao requestDataDao) {
        this.env = env;
        this.apiService = apiService;
        this.context = context;
        this.requestDataDao = requestDataDao;
    }

    @Before("@createUser")
    public void createUser() throws Throwable {
        RequestDataModel data = requestDataDao.getTestDataByName("createUser");
        Response response = apiService.createUser(env.config.getString("base-url"), data.getPayload());
        assertThat("User cannot be created. Status code is not as expected.", String.valueOf(response.getStatusCode()), equalTo(data.getExpectedResponseCode()));
        context.setMemberId(response.body().as(SuccessRespMsgDataModel.class).getMemberId());
    }
}
