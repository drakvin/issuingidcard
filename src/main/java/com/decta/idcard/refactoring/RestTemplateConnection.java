package com.decta.idcard.refactoring;

public class RestTemplateConnection implements Connection {
    private RestTemplate restTemplate = new RestTemplate();


    @Override
    public RpcResponse exchange(RpcRequest request, String method) {
       return restTemplate.url("https://server.host.lv/client").method(method).body(request).execute();

    }
}