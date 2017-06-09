package com.hanbit.net;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;

public class EchoClient {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		NetClient client = vertx.createNetClient();
		
		client.connect(8000, "localhost", server -> {
			if (server.succeeded()) {
				NetSocket socket = server.result();
				socket.handler(response -> {
					System.out.println("응답: " + response);
					System.exit(0);
				});
				socket.write("ip");
			}
			else {
				System.out.println("접속 실패");
				System.exit(0);
			}
		});
	}
	
}
