package mx.gob.nayatit.model;

import java.io.Serializable;

/**
 * Object with the information of producer.
 * @author Ricardo Lopez
 */
public class Producer implements Serializable {
    private String name;
    private Integer quota;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name='" + name + '\'' +
                ", quota=" + quota +
                '}';
    }
}
