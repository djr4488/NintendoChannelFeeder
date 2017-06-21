package com.djr4488.wiichannelfeeder.forecastchannel;

import com.djr4488.wiichannelfeeder.forecastchannel.service.darksky.DarkskyResponse;
import com.djr4488.wiichannelfeeder.forecastchannel.service.forecaststore.ForecastStoreService;
import org.slf4j.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination",
                propertyValue = "jms/ForecastJMSQueue"),
        @ActivationConfigProperty(propertyName = "maxSessions", propertyValue = "1")
})
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ForecastListener implements MessageListener {
    @Inject
    private Logger log;
    @Inject
    private ForecastStoreService forecastStoreService;
    public void onMessage(Message message) {
        try {
            DarkskyResponse darkskyResponse = (DarkskyResponse)((ObjectMessage)message).getObject();
            //forecastStoreService.saveForecastForLocation(darkskyResponse, null, null);
        } catch (Exception ex) {
            log.error("onMessage() ", ex);
        }
    }
}
