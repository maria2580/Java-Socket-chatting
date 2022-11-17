package org.example;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MessageReceiver extends ServerSocket {
    String myname;
    ArrayList<Socket> socketUsers;
    class acceptThread extends Thread{


    }

    public MessageReceiver(int port, int backlog, InetAddress bindAddr) throws IOException {
        super(port, backlog, bindAddr);
        socketUsers=new ArrayList<>();
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public void run() throws IOException {

        System.out.println("socket : " + super.getLocalPort() + "으로 서버가 열렸습니다.");


        for (int i=0; i<socketUsers.size();i++){

            //InputStream (클라이언트가 보낸것을 서버로 받음)
            InputStream input = socketUsers.get(i).getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(input));

            System.out.println(br.readLine()); //클라이언트에서 온 메시지를 확인

            //OutPutStream(서버에서 클라이언트에게 메세지를 보여줄)
            OutputStream out = socketUsers.get(i).getOutputStream();
            PrintWriter pr = new PrintWriter(out,true);

            pr.println(this.myname+"와 연결이 되었습니다.");
        }
    }
}

