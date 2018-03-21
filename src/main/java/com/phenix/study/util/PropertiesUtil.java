package com.phenix.study.util;

import com.phenix.study.exception.BusinessException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties properties = new Properties();
    public static List<String> configFile = Arrays.asList(
            "server_config.properties", "sys_config.properties");

    static {
        try {
            for (String fileName : configFile) {
                InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
                properties.load(in);
            }
        }catch (IOException e) {
            throw new BusinessException("读取配置文件错误");
        }
    }
    public static String getValue(String key) {
        return properties.getProperty(key, "");
    }
}
