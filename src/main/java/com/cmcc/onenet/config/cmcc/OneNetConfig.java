package com.cmcc.onenet.config.cmcc;

import com.cmcc.onenet.Launch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 中国移动OneNet平台基本配置
 *
 * @author wannengjia@gmail.com
 */
@ConfigurationProperties(prefix = "cmcc.onenet")
@Component
public class OneNetConfig {
    private static final Logger logger = LoggerFactory.getLogger(OneNetConfig.class);
    /**
     * 设备ID
     */
    private String deviceId;
    /**
     * APIKEY
     */
    private String apiKey;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String toString() {
        return "OneNet{" +
                "deviceId='" + deviceId + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }

    @PostConstruct
    public void init() {
        logger.debug("读取ONENET基础配置");
        logger.debug(this.toString());
    }
}

