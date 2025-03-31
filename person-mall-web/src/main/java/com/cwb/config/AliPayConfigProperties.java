package com.cwb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "alipay",ignoreInvalidFields = true)
public class AliPayConfigProperties {
    // 「沙箱环境」应用ID - 您的APPID，收款账号既是你的APPID对应支付宝账号。获取地址；https://open.alipay.com/develop/sandbox/app
    private  String app_id = "9021000143684540";
    // 「沙箱环境」商户私钥，你的PKCS8格式RSA2私钥 -【秘钥工具】所创建的公户私钥
    private  String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCTgNCLfwvatZlBqaewdbT5RBqCZi1UfVsHTnfSO90yEs+slrMANcG6GtKUG/95R3hy6KWl6UzWM0/vIDFkfLcBnbWjbG8Cz+ishyppd+4qX650TFJRrsv/NpCwCXEQ+T73ULqKnmasY02E4ukMWHKrIMssWU27+MizUzmBd5x6HXJm1BZq5VWRpSCIBHBcEkLgGKvHG+4yLCDPFQwcJxLK7HDvpZ3z/8ml7QUbxm3ZdhOB1RBJIa7mWnZPrrrgEA+y2aBVVKjXdx4bYBGRItoVlPpmCRV5dI66QgNB2SvuxnI8BiBt1uWt6ECHMCQbZvnvj6Oye2dHuXpUtD7PHpdtAgMBAAECggEAP6dlV+25teaMfrOyNAp30OI89m0VvtJiCCMqvkUrTcKkcHyQPtT0B1Yv7c6vTy0yo5QWeCTYDdAS/MTNy+muKDpg+md++J20cU/bU6x30T19UZ7mH23phveLNQy+CG8nZx8lgVCeSmKIP4KUw8kfow4B39+iFi5knk6aEG8HzgJiPt/CJ+cGlrDndEUppcNSykB4hZAkU63DkqkoazkH+5fPyNLONmzzlO2/y/DvwY/Tf5kIrQ26O/LrLgD4DUmQkt9lavqh1ZPe4bygunMVUv33O62Gyaeyts1kNUM5AnUyZ1wt8ImcxW7Lj4UrQraeVSvuNKNEqeaQ8ayn+CG1WQKBgQDbLpWplcv0hL0yDBPiNaf1+VZc2QsRwglWusst67ftQRj1WV+jeW/q7bV0qVRop7+FZygml9W1BrnsVG3cMIDE8LcCix4ovOaliZyMNyE/sinIe3t7jJlYlf6qBTlZze4pHkZ+TkeZ3xcNqqrPE04dND+qR/f0moUyx0vczkENIwKBgQCsR9lTlM2l77W2IsG9m9fWx9hZ6xvnt9MRnrfx4doy+8nuB+cpX50V3RTjwvsQz+Lc0qxnSwbvqomcIXyFIEG9BeDcu2LBfcYI5KU/cdT/lepehrTBMul5PxK//FglpGHYb4jN8fF6H/8neLXS9bkog62ll50f+D/uMR7LuFP6LwKBgH8M6Notp9UsYJMzJw94NM1DZAlcEquPg2RP0Njki3AuzO3jiam0CejvM8DVKsWjf0QwALkmSE2wAXP5mNkLEImYUy1ZQPkyTqxkMWehyVcnykqZMYHzhSwxfjZF4vGoikYxc4FhlOWfyLg2Vt7D/QK2t7TYFOYn78/4cIQk1tZrAoGBAJxC0wE3f8vZf5TDM706RGxgeYEdegMTvdNGhgtT0mjZ7k8DRg1F1yJEk7T+XmDiXh/yykMqTxFFOmmuCdZp6pZ7ZXhwUmO0I9JfKO9B3XMxVBIG1p5CAnhh2CzgwkbqMYFxsMEziNY/fVwc5baCAD6aKP+AZBjiP4JZdVhMSYcrAoGANoQn/x4pPTmX+FFJIxBx6iFXPFCstABcuzwvneUmvAS6HPICmEsZvLfFZvTm/PDnyj27RI3viMDxjgEjNcOTvLt/aDicIWjjKl8Y+d/k8f/QvmzP365xzBnwVk3xh1F8dyy1bDV+QrJjTi8E9XuNWrS4PkA7LaNQA60veKWA1eI=";
    // 「沙箱环境」支付宝公钥 -【秘钥填写】后提供给你的支付宝公钥
    private  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmWXXp1C3A2GVxKAKH54pl13avtS+sD5E7Nx0RuX7mnaGByANrvGpmZcYxrEBa18frgkPPOdREs6TC5iir4aguE3b8rAsnPLO1BSyoyIZtVR1Y4G6O4q7dw6I1iKEQTsmz0h1R3qVA0aUYqOgYTQ8ejzJGAh2dMMb2YSo8xeIhJi1/BPuO7mli182iEHQ7iXKm6fViTLyPfYBRJOBP7+sI/fyOW38WyQGJlrYOvH44wnI9iDbBsNMmM/h82SYJFloWANq0wtfnHj93iuNr7x8AE0FV7JFB39ZtX563trH+gKtXFJ3L0sDEcPUnXeXGSKps/cz2X3QEXeiif9ZsDapbwIDAQAB";
    // 「沙箱环境」服务器异步通知回调地址
    private  String notify_url = "http://jasper123.natapp1.cc/alipay/alipay_notify_url";
    // 「沙箱环境」页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    private  String return_url = "http://localhost:8080/#/";
    // 「沙箱环境」
    private  String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    // 签名方式
    private  String sign_type = "RSA2";
    // 字符编码格式
    private  String charset = "utf-8";
    // 传输格式
    private String format = "json";


}
