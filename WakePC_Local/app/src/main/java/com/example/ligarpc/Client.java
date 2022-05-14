package com.example.ligarpc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class Client {

    DatagramSocket client;
    String ip;
    int port;

    Client(String ip, int port){

        if(ip == null)
            ip = "127.0.0.1";

        this.ip = ip;
        this.port = port;

        connect();
    }


    private void connect(){

        try {
            client = new DatagramSocket();
            //client.setBroadcast(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void send(byte[] msg){

        if(msg == null)
            return;

        InetAddress addr = null;

        try {
            addr = InetAddress.getByName(this.ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        DatagramPacket packet = new DatagramPacket(msg, msg.length, addr, this.port);

        try{
            client.send(packet);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /*
    public String receive(){

        String recv = new String();

        try{
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            recv += input.readLine();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return recv;

    }

     */

    public void sendUDPByte(byte[] msg){

        send(msg);
        //String res = receive();
        client.close();

        return;
    }

}
