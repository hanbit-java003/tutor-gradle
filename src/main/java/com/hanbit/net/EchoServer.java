package com.hanbit.net;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetServer;

public class EchoServer {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		NetServer server = vertx.createNetServer();
		
		server.connectHandler(client -> {
			client.handler(request -> {
				if ("ip".equals(request.toString())) {
					client.write(client.remoteAddress().host());
				}
				else {
					client.write(request + " 라고 입력하셨네요.");
				}
				client.close();
			});
		}).listen(8000);
	}
	
}
