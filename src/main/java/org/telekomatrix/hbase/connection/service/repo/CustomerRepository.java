package org.telekomatrix.hbase.connection.service.repo;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.hadoop.hbase.client.Table;

public interface CustomerRepository {

	public Table getTable() throws IOException;
	public void saveCustomer() throws NoSuchAlgorithmException, IOException;
}
