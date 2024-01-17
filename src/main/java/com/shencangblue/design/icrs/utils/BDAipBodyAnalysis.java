package com.shencangblue.design.icrs.utils;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import com.shencangblue.design.icrs.model.SdkParameter;
import org.json.JSONObject;

import java.util.HashMap;

public class BDAipBodyAnalysis {

    // 初始化一个AipBodyAnalysis
    private static final AipBodyAnalysis client = new AipBodyAnalysis(
            "47001562",
            "HfOy80Tx3Aq65GuSTuFF2NTO",
            "HZsKbjgNrl3XmCpCAhelfgkqdKnSznVV");

    BDAipBodyAnalysis(){
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }

    public static AipBodyAnalysis getClient() {
        return client;
    }

    // 可选：设置网络连接参数


        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
//        String path = "test.jpg";
//        JSONObject res = client.bodyAnalysis(path, new HashMap<String, String>());
//        System.out.println(res.toString(2));


}
