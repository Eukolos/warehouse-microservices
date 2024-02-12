package com.istanify.warehouse.configuration.kafka.properties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka.topics.waybill-record")
public class WaybillRecordTopicProperties {
    private String topicName;
    private int partitionCount;
    private short replicationFactor;
    private String retentionInMs;

    public WaybillRecordTopicProperties() {
    }
    public WaybillRecordTopicProperties(String topicName, int partitionCount, short replicationFactor, String retentionInMs) {
        this.topicName = topicName;
        this.partitionCount = partitionCount;
        this.replicationFactor = replicationFactor;
        this.retentionInMs = retentionInMs;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getPartitionCount() {
        return partitionCount;
    }

    public void setPartitionCount(int partitionCount) {
        this.partitionCount = partitionCount;
    }

    public short getReplicationFactor() {
        return replicationFactor;
    }

    public void setReplicationFactor(short replicationFactor) {
        this.replicationFactor = replicationFactor;
    }

    public String getRetentionInMs() {
        return retentionInMs;
    }

    public void setRetentionInMs(String retentionInMs) {
        this.retentionInMs = retentionInMs;
    }
}