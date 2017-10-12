package com.epayments.config;

import java.io.IOException;
import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.*;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;

import com.mongodb.MongoClient;

/**
 * The type Data base config.
 */
@Configuration
public class DataBaseConfig {

	private static final String DB_URL = "localhost";
	private static final String MONGO_DB_NAME = "embeded_db";

    /**
     * Mongo template mongo template.
     *
     * @return the mongo template
     *
     * @throws IOException the io exception
     */
    @Bean
	public MongoTemplate mongoTemplate() throws IOException {
		EmbeddedMongoFactoryBean mongo = new EmbeddedMongoFactoryBean();
		mongo.setBindIp(DB_URL);
		MongoClient mongoClient = mongo.getObject();
		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
		return mongoTemplate;
	}

	/*@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(jedisConanectionFactory());
		return template;
	}

	@Bean
	JedisConnectionFactory jedisConanectionFactory() {
		JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
		jedisConFactory.setHostName(DB_URL);
		jedisConFactory.setPort(6379);
		return jedisConFactory;
	}*/
}