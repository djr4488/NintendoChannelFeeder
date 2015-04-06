package com.djr4488.wiichannelfeeder.newschannel.service;

import org.slf4j.Logger;
import javax.ejb.Schedule;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;

/**
 * Created by IMac on 3/31/2015.
 */
@ApplicationScoped
public class NewsFeederService {
	@Inject
	private Logger log;

	@Schedule(second="0", minute="0", hour="3")
	public void getUpdatededNews() {
		log.info("getUpdatedNews() started");
		log.info("getUpdatedNews() completed");
	}

	/**
	 * Don't really care about the "region" so much as will probably only use one news provider anyway
	 */
	public File getNewsFile(String file) {
		//for now just return existing files
		log.debug("getNewsFile() file:{}", file);
		return new File("c:/app/wiichannels/news/"+file);
	}
}
