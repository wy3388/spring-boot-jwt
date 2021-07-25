package com.github.jwt.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    public static String JWT_HEADER = "Authorization";

    public static String JWT_PREFIX = "Bearer ";

    /**
     * 拦截的url
     */
    private String url;
    /**
     * jwt秘钥
     */
    private String key;
    /**
     * 过期时间
     */
    private Long exp;

    /**
     * 白名单
     */
    private List<String> whiteList;

    /**
     * 显示错误
     */
    private Boolean showError;

    public Boolean getShowError() {
        return showError;
    }

    public void setShowError(Boolean showError) {
        this.showError = showError;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public List<String> getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(List<String> whiteList) {
        this.whiteList = whiteList;
    }

    @Override
    public String toString() {
        return "JwtConfig{" +
                "url='" + url + '\'' +
                ", key='" + key + '\'' +
                ", exp=" + exp +
                ", whiteList=" + whiteList +
                ", showError=" + showError +
                '}';
    }
}
