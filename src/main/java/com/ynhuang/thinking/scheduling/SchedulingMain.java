package com.ynhuang.thinking.scheduling;

import com.zaxxer.hikari.HikariPoolMXBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author YuHuang
 */
//@Component
public class SchedulingMain {

    @Scheduled(fixedRate = 500)
    public void HikariMonitor() throws MalformedObjectNameException {

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName poolName = new ObjectName("com.zaxxer.hikari:type=Pool (ynhuang)");
        HikariPoolMXBean poolProxy = JMX.newMXBeanProxy(mBeanServer, poolName, HikariPoolMXBean.class);

        if(poolProxy == null) {
            System.out.println("Hikari not initialized,please wait...");
        }else {
            System.out.println("HikariPoolState = "
                    + "Active=[" + String.valueOf(poolProxy.getActiveConnections() + "] "
                    + "Idle=[" + String.valueOf(poolProxy.getIdleConnections() + "] "
                    + "Wait=["+poolProxy.getThreadsAwaitingConnection()+"] "
                    + "Total=["+poolProxy.getTotalConnections()+"]")));
        }
    }
}
