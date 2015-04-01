package com.djr4488.wiichannelfeeder.cdi;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: djr4488
 * Date: 1/6/14
 * Time: 9:04 AM
 */
@ApplicationScoped
public class LoggerProducer {
	private static final Logger log = LoggerFactory.getLogger(LoggerProducer.class);

	public LoggerProducer() {
	}

	@PostConstruct
	private void loadConfiguration() {
		LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(context);
			context.reset();
			configurator.doConfigure("/app/channels/conf/logback.xml");
		} catch (JoranException je) {
			// StatusPrinter will handle this
		}
		StatusPrinter.printInCaseOfErrorsOrWarnings(context);
	}


	@Produces
	public Logger getLogger(InjectionPoint ip) {
		Class<?> injectingClass = ip.getMember().getDeclaringClass();
		log.debug("getLogger() injectingClass:{}", injectingClass.getName());
		return LoggerFactory.getLogger(injectingClass);
	}
}