package com.djr4488.wiichannelfeeder.newschannel.service;

import org.slf4j.Logger;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.File;

/**
 * Service which will be used to schedule when to check for updated news and create the static files
 * to be served by the NewsFeederApi
 */
@Startup
@Singleton
public class NewsFeederService {
	@Inject
	private Logger log;

	/**
	 * Run daily at 3am call out to some news service and create the news.bin.* files is ultimately the goal here
	 * Right now, just log.
	 */
	@Schedule(second="0", minute="0", hour="3")
	public void getUpdatededNews() {
		log.info("getUpdatedNews() started");
		log.info("getUpdatedNews() completed");
	}

	/**
	 * Don't really care about the region the caller is from at this point, but might in the future.  Right now
	 * lets just send a news file.  My guess is RSA signatures are done on a region by region basis.
	 */
	public File getNewsFile(String file) {
		//for now just return existing files
		log.debug("getNewsFile() file:{}", file);
		return new File("c:/app/wiichannels/news/"+file);
	}
}
