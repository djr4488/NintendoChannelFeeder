package com.djr4488.wiichannelfeeder.forecastchannel.service.darksky;

import com.djr4488.wiichannelfeeder.errorhandling.ErrorHandlingCallback;
import org.slf4j.Logger;
import retrofit2.Response;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import java.io.IOException;

@ApplicationScoped
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DarkskyCallback implements ErrorHandlingCallback<DarkskyResponse> {
    @Inject
    private Logger log;
    @Resource(name = "jms/ForecastJMSConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(name = "jms/ForecastJMSQueue")
    private Queue forecastQueue;
    @Inject
    private Event<Response<DarkskyResponse>> darkskyResponseEvent;

    public DarkskyCallback() {}

    @Override
    public void success(Response<DarkskyResponse> response) {
        log.debug("success() firing event for response:{} and body:{}", response, response.body());
        darkskyResponseEvent.fire(response);
//        Connection connection = null;
//        Session session = null;
//        try {
//            connection = connectionFactory.createConnection();
//            connection.start();
//            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
//            MessageProducer messageProducer = session.createProducer(forecastQueue);
//            messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
//            ObjectMessage message = session.createObjectMessage(response.body());
//            messageProducer.send(message);
//        } catch (Exception ex) {
//            log.error("success() failed sending message", ex);
//        } finally {
//            try {
//                if (null != session) {
//                    session.close();
//                }
//                if (null != connection) {
//                    connection.close();
//                }
//            } catch (Exception ex) {
//
//            }
//        }
    }

    @Override
    public void unauthenticated(Response<?> response) {
        log.debug("unauthenticated() response:{}", response);
    }

    @Override
    public void clientError(Response<?> response) {
        log.debug("clientError() response:{}", response);
    }

    @Override
    public void serverError(Response<?> response) {
        log.debug("serverError() response:{}", response);
    }

    @Override
    public void networkError(IOException e) {
        log.error("networkError() ", e);
    }

    @Override
    public void unexpectedError(Throwable t) {
        log.error("unexpectedError() ", t);
    }
}
