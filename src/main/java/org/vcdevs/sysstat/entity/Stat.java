package org.vcdevs.sysstat.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stat")
public class Stat {

    @Id
    private String id;

    private String host;

    private long timestamp;

    private String counter;

    private String value;


    public Stat() {
    }

    public Stat(String host, long timestamp, String counter, String value) {
        this.host = host;
        this.timestamp = timestamp;
        this.counter = counter;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(host)
                .append(timestamp)
                .append(counter)
                .append(value).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Stat)) {
            return false;
        }
        Stat that = (Stat) obj;
        return new EqualsBuilder()
                .append(this.id, that.id)
                .append(this.host, that.host)
                .append(this.timestamp, this.timestamp)
                .append(this.counter, that.counter)
                .append(this.value, that.value).isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("host", getHost())
                .append("timestamp", getTimestamp())
                .append("counter", getCounter())
                .append("value", getValue())
                .toString();
    }

}
