package org.pfry;

import org.apache.activemq.camel.component.ActiveMQComponent;
import javax.enterprise.inject.*;
import javax.enterprise.context.*;
import javax.inject.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producers {
 
    @Produces
    @Named("myjms")
    @ApplicationScoped
    ActiveMQComponent getActiveMQComponent() {
        ActiveMQComponent component = new ActiveMQComponent();
        component.setConnectionFactory(new ActiveMQConnectionFactory("failover://tcp://broker-amq-tcp.amq-demo.svc.cluster.local:61616"));
        component.setUserName("amq-demo-user");
        component.setPassword("password");
        return component;
    }
}
