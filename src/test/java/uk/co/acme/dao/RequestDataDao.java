package uk.co.acme.dao;

import uk.co.acme.model.RequestDataModel;

public interface RequestDataDao {

    RequestDataModel getTestDataByName(String name) throws Throwable;
}
