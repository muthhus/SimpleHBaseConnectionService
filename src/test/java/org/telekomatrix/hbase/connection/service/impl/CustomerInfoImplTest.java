package org.telekomatrix.hbase.connection.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Table;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnit44Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.telekomatrix.hbase.connection.service.conf.HbaseConf;

@RunWith(MockitoJUnit44Runner.class)
public class CustomerInfoImplTest {
	
	@Autowired
	private HbaseConf hbaseConf;
	private CustomerInfoImpl customerInfoImpl;
	private Table table;
	
	@Before
	public void init() throws IOException {
		customerInfoImpl = mock(CustomerInfoImpl.class);
		table = mock(Table.class);
		
	}
	
	@Test
	public void testSaveCustomerInformation()throws NoSuchAlgorithmException, IOException{
		doNothing().when(customerInfoImpl).saveCustomer();
		customerInfoImpl.saveCustomer();
		verify(customerInfoImpl, times(1)).saveCustomer();
	}
	
	@Test
	public void testGetTable() throws IOException {
		when(customerInfoImpl.getTable()).thenReturn(table);
		customerInfoImpl.getTable();
		verify(customerInfoImpl, times(1)).getTable();
	}
	
	
	private Table getTableName() throws IOException {
		Admin admin = hbaseConf.geHbasetConnection().getAdmin();
		Table table11 = hbaseConf.geHbasetConnection().getTable(TableName.valueOf("customerInfo"));
		return table11;
	}
}
