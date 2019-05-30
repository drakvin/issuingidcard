package com.decta.idcard.refactoring;

public interface Connection {

 RpcResponse exchange(RpcRequest request, String method);

}