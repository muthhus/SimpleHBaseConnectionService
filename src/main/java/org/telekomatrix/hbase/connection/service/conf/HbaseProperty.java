package org.telekomatrix.hbase.connection.service.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="habse.conf.zk")
public class HbaseProperty {
	
	@Value(value="${hbase.conf.zk.host}")
	private String host;
	
	@Value(value="${hbase.conf.zk.port}")
	private String port;
	
	@Value(value="${hbase.conf.zk.znode.parent}")
	private String zkNode;


	public String getZkNode() {
		return zkNode;
	}

	public void setZkNode(String zkNode) {
		this.zkNode = zkNode;
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
	
	
}
