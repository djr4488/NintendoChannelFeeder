package com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore;

import org.slf4j.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by djr4488 on 6/9/17.
 */
@ApplicationScoped
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ForecastStoreService {
    @PersistenceContext(unitName = "forecast_persistence")
    private EntityManager em;
    @Inject
    private Logger log;
    
    public void saveForecastForLocation(Location location) {
        em.persist(location);
    }
}
