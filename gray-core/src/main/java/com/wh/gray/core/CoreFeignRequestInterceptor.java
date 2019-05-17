package com.wh.gray.core;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author goofly
 * @E-mail 709233178@qq.com
 * @date 2019/1/21
 */
public class CoreFeignRequestInterceptor implements RequestInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(CoreHttpRequestInterceptor.class);

	@Override
	public void apply(RequestTemplate template) {
        String hystrixVer = CoreHeaderInterceptor.version.get();
        logger.info("====>fegin version:{} ",hystrixVer);
        
		template.header(CoreHeaderInterceptor.HEADER_VERSION, hystrixVer);
	}

}