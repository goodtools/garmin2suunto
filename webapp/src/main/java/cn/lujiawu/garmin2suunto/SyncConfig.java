package cn.lujiawu.garmin2suunto;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("sync")
@Configuration
@ToString
@Data
public class SyncConfig {

    private String garminUserName;

    private String garminPasswd;

    private String suuntoUserName;

    private String suuntoUserKey;

    public boolean validate(){
        return !StringUtils.isAnyBlank(garminPasswd,garminUserName,suuntoUserKey,suuntoUserName);
    }

}
