package com.dayuxiaoyu.api.util;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * @author zyp
 * @version 1.0
 * @time 2017/7/24 17/32
 */
public class PropertiesUtil {

    public static PropertiesConfiguration rabbitConfig;

    public static PropertiesConfiguration smsConfig;

    public static PropertiesConfiguration influxDbConfig;

    public static PropertiesConfiguration gitlabConfig;

    public static PropertiesConfiguration gatewayConfig;

    public static PropertiesConfiguration owlConfig;

    static {
        Configurations configurations = new Configurations();
        try {
            rabbitConfig = configurations.properties("conf/custom/env/rabbit.properties");
            smsConfig = configurations.properties("conf/custom/env/sms.properties");
            influxDbConfig = configurations.properties("conf/custom/env/influxdb.properties");
            gitlabConfig = configurations.properties("conf/custom/env/gitlab.properties");
            gatewayConfig = configurations.properties("conf/custom/env/gateway.properties");
            owlConfig = configurations.properties("conf/custom/env/owl.properties");
        } catch (ConfigurationException e) {
            rabbitConfig = new PropertiesConfiguration();
            e.printStackTrace();
        }
    }

}
