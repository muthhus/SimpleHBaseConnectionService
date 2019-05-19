package org.telekomatrix.hbase.connection.service.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix="habse.conf.zk")
public class HbaseProperty {
	
	@Value(value="${hbase.conf.zk.host}")
	private String host;
	
	@Value(value="${hbase.conf.zk.port}")
	private String port;
	
	@Value(value="${hbase.conf.zk.znode.parent}")
	private String zkNode;
	
	@Value(value="${hbase.conf.zk.rootDir}")
	private String rootDir;
	
	@Value(value="${hbase.conf.zk.master.port}")
	private String masterPort;
	
	@Value(value="${hbase.conf.zk.master.data}")
	private String hbaseData;
	
	@Value(value="${hbase.conf.zk.maxClientCnxns}")
	private String maxClientCnxns;
	
	@Bean
	public String getZkDetails() {
		return this.host;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getRootDir() {
		return rootDir;
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	public String getMasterPort() {
		return masterPort;
	}

	public void setMasterPort(String masterPort) {
		this.masterPort = masterPort;
	}

	public String getMaxClientCnxns() {
		return maxClientCnxns;
	}

	public void setMaxClientCnxns(String maxClientCnxns) {
		this.maxClientCnxns = maxClientCnxns;
	}

	public String getHbaseData() {
		return hbaseData;
	}

	public void setHbaseData(String hbaseData) {
		this.hbaseData = hbaseData;
	}

	public String getZkNode() {
		return zkNode;
	}

	public void setZkNode(String zkNode) {
		this.zkNode = zkNode;
	}
	
	
	
	
}
