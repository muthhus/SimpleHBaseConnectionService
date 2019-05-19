package org.telekomatrix.hbase.connection.service.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.HConstants;

@Configuration
@EnableConfigurationProperties(HbaseProperty.class)
public class HbaseConf {

	private HbaseProperty hbaseProperty;
	private Configuration configuration;
	private Connection connection;
	
	@Autowired
	public HbaseConf(HbaseProperty hbaseProperty) {
		this.hbaseProperty = hbaseProperty;
	}
	
	@Bean
	public Connection geHbasetConnection() throws IOException {
		org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
		configuration.set(HConstants.ZOOKEEPER_QUORUM, hbaseProperty.getHost());
		configuration.set(HConstants.ZOOKEEPER_CLIENT_PORT, hbaseProperty.getPort());
		configuration.set(HConstants.ZOOKEEPER_ZNODE_PARENT, hbaseProperty.getZkNode());
		
		connection = ConnectionFactory.createConnection(configuration);
		return connection;
		
	}
}
