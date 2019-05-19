package org.telekomatrix.hbase.connection.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
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
		Admin admin = hbaseConf.geHbasetConnection().getAdmin();
		Table table = hbaseConf.geHbasetConnection().getTable(TableName.valueOf("customerInfo"));
		return table;
	}

	@Override
	public void saveCustomer() throws NoSuchAlgorithmException, IOException {
		
		Put put =new Put(getUUIDgenerator());

        put.addColumn(Bytes.toBytes("customer"), Bytes.toBytes("firstName"), Bytes.toBytes("Bharati"));
        put.addColumn(Bytes.toBytes("customer"),Bytes.toBytes("lastName"),Bytes.toBytes("Kannamma"));
        put.addColumn(Bytes.toBytes("customer"),Bytes.toBytes("role"),Bytes.toBytes("Test"));
        put.addColumn(Bytes.toBytes("customer"),Bytes.toBytes("age"),Bytes.toBytes("23"));
        
        getTable().put(put);
	}
	
	private byte[] getUUIDgenerator() throws NoSuchAlgorithmException {
		MessageDigest salt = MessageDigest.getInstance("SHA-256");
		try {
			salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] digest = salt.digest();
		return digest;
	}

}
