package com.djr4488.wiichannelfeeder.newschannel;

import com.djr4488.wiichannelfeeder.newschannel.controller.NewsFeederApi;
import com.djr4488.wiichannelfeeder.newschannel.exceptionmapper.NewsFeederExceptionMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * djr4488
 * application to feed data to Wii starved News Channel
 *
 */
@ApplicationScoped
@ApplicationPath("v2")
public class NewsFeederApp extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		return new HashSet<>(Arrays.asList(NewsFeederApi.class, NewsFeederExceptionMapper.class));
	}
}
