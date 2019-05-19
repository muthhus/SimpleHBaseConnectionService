package org.telekomatrix.hbase.connection.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telekomatrix.hbase.connection.service.conf.HbaseConf;
import org.telekomatrix.hbase.connection.service.repo.CustomerRepository;

@Service
public class CustomerInfoImpl implements CustomerRepository {
	
	private HbaseConf hbaseConf;
	
	@Autowired
	public CustomerInfoImpl(HbaseConf hbaseConf) {
		this.hbaseConf = hbaseConf;
	}

	@Override
	public Table getTable() throws IOException {
//		Admin admin = hbaseConf.geHbasetConnection().getAdmin();
//		HTableDescriptor tableName = new HTableDescriptor(TableName.valueOf("customerInfo"));
		Configuration conf = HBaseConfiguration.create();
		conf.set(HConstants.ZOOKEEPER_QUORUM, "localhost");
		conf.set(HConstants.ZOOKEEPER_CLIENT_PORT, "2181");
		conf.set(HConstants.ZOOKEEPER_ZNODE_PARENT, "/hbase-unsecure");
        Connection connection = ConnectionFactory.createConnection(conf);
		Table table = connection.getTable(TableName.valueOf("customerInfo"));
		return table;
	}

	@Override
	public void saveCustomer() throws NoSuchAlgorithmException, IOException {
		
		Put put =new Put(getUUIDgenerator());

        put.addColumn(Bytes.toBytes("customer"), Bytes.toBytes("firstName"), Bytes.toBytes("Muthu"));
        put.addColumn(Bytes.toBytes("customer"),Bytes.toBytes("lastName"),Bytes.toBytes("Sundaram"));
        put.addColumn(Bytes.toBytes("customer"),Bytes.toBytes("role"),Bytes.toBytes("CTO"));
        put.addColumn(Bytes.toBytes("customer"),Bytes.toBytes("age"),Bytes.toBytes("23"));
        
        getTable().put(put);
	}
	
	private byte[] getUUIDgenerator() throws NoSuchAlgorithmException {
		MessageDigest salt = MessageDigest.getInstance("SHA-256");
		try {
			salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] digest = salt.digest();
		return digest;
	}

}
