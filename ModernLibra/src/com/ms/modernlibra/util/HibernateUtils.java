package com.ms.modernlibra.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

//this class is used to create session factory object.
public class HibernateUtils {

	private final static SessionFactory factory;

	static {
		try {
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			factory = configuration.buildSessionFactory(builder.build());
		} catch (Throwable e) {
			System.err.println("Failed to create session factory object" + e);
			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getFactoryObject() {
		return factory;
	}
}
