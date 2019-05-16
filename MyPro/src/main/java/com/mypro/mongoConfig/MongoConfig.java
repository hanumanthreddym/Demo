package com.mypro.mongoConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.MongoClient;

public class MongoConfig extends AbstractMongoConfiguration {

	String host = "localhost";
	String database = "users";

	@Override
	public MongoClient mongoClient() {

		return new MongoClient(host);
	}

	@Override
	protected String getDatabaseName() {

		return database;
	} 

	@Bean
	public GridFsTemplate getGridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());

	}

}
