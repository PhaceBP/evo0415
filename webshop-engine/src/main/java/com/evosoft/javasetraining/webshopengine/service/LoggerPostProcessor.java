package com.evosoft.javasetraining.webshopengine.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LoggerPostProcessor implements BeanPostProcessor {

	private final Map<Class<?>, Logger> LOGGER_CACHE = new HashMap<Class<?>, Logger>();

	private Logger LOGGER = LoggerFactory.getLogger(LoggerPostProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		Field[] fields = bean.getClass().getDeclaredFields();

		for (Field f : fields) {

			if (f.getAnnotation(Log.class) != null) {

				LOGGER.debug("Log annotation found, trying to inject Logger instance " + "bean class: {}",
						bean.getClass());

				Logger logger = LOGGER_CACHE.get(bean.getClass());

				if (logger == null) {
					logger = LoggerFactory.getLogger(bean.getClass());
					LOGGER_CACHE.put(bean.getClass(), logger);
				}
				f.setAccessible(true);
				try {
					f.set(bean, logger);
					LOGGER.debug("Log successfully injected to, trying to {}", bean.getClass());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					LOGGER.error(e.getMessage());
					throw new IllegalStateException(e);
				}
			}
		}

		return bean;
	}

}
