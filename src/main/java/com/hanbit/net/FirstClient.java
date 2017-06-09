package com.hanbit.net;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;

public class FirstClient {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		NetClient client = vertx.createNetClient();
		
		client.connect(80, "hanbitedu.co.kr", event -> {
			if (event.succeeded()) {
				System.out.println("접속 성공");
				
				NetSocket socket = event.result();
				
				socket.handler(result -> {
					System.out.println(result);
					System.exit(0);
				});
				
				socket.write(".");
			}
			else {
				System.out.println("접속 실패");
			}
		});
	}
	
}
