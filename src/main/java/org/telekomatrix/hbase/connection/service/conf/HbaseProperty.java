package org.telekomatrix.hbase.connection.service.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

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
	
}
