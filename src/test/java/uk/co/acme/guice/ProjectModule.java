package uk.co.acme.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import uk.co.acme.context.Context;
import uk.co.acme.dao.RequestDataDao;
import uk.co.acme.dao.RequestDataDaoJson;

public final class ProjectModule extends AbstractModule {
    @Override
    public void configure() {
        try {
            bind(Context.class).in(Singleton.class);
            bind(RequestDataDao.class).to(RequestDataDaoJson.class).in(Singleton.class);
        } catch (Exception e) {
            addError(e.getMessage());
        }
    }
}
