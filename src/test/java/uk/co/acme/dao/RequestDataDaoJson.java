package uk.co.acme.dao;

import com.google.gson.Gson;
import uk.co.acme.model.RequestDataModel;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RequestDataDaoJson implements RequestDataDao {

    public RequestDataModel[] getAllFromJson() throws Throwable {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/test_data/request-data.json"));
        RequestDataModel[] models = gson.fromJson(reader, RequestDataModel[].class);
        return models;
    }

    public RequestDataModel getTestDataByName(String name) throws Throwable {
        RequestDataModel result = null;
        RequestDataModel[] models = getAllFromJson();
        for (RequestDataModel model: models) {
            if (name.equals(model.getName())) {
                result = model;
            }
        }
        return result;
    }

}
