package com.decta.idcard.refactoring;

public class RestTemplate {
    public RestTemplate url(String s) {
        return this;
    }

    public RestTemplate body(RpcRequest request) {
        return this;
    }

    public RestTemplate method(String get) {
        return this;
    }

    public RpcResponse execute() {
        return new RpcResponse();
    }
}
