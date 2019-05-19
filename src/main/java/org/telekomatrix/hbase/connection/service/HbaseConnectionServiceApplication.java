package org.telekomatrix.hbase.connection.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telekomatrix.hbase.connection.service.conf.HbaseConf;
import org.telekomatrix.hbase.connection.service.impl.CustomerInfoImpl;

@SpringBootApplication
public class HbaseConnectionServiceApplication implements CommandLineRunner{
	
	private DataSource dataSource;

	private HbaseConf hbaseConf;
	
	@Autowired
	private CustomerInfoImpl customerImpl;
	
	public static void main(String[] args) {
		SpringApplication.run(HbaseConnectionServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerImpl = new CustomerInfoImpl(hbaseConf);
		customerImpl.saveCustomer();
		
	}

}
