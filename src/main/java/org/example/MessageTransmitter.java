package org.example;

import java.io.*;
import java.net.Socket;

public class MessageTransmitter extends Socket {
    String myname;
    public void setMyname(String myname){
        this.myname=myname;
    }

    public void sendMessage(String text) throws IOException {
        //OutputStream (클라이언트에서 서버로 메세지를 전송)
        OutputStream out = super.getOutputStream();
        PrintWriter pr = new PrintWriter(out, true);

        pr.println(myname+": "+text);

        //InputStream (서버가 보낸 메세지를 읽어옴)
        InputStream input = super.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(input));

        System.out.println(br.readLine()); //서버로부터 온 메세지 확인
    }
}
