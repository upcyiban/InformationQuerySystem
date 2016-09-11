package com.lihuanyu.informationquerysystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by developmet on 2016/9/11.
 */
@Component
public class Config {

    @Value("${yibanoauth.informationquerysystem.redirect}")
    public String redirect_uri;


    @Value("${yibanoauth.informationquerysystem.APPID}")
    public String appid;

    @Value("${yibanoauth.informationquerysystem.APPkey}")
    public String appkey;

    @Value("${app.data}")
    public String data;


}
