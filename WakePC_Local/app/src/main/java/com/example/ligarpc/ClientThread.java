package com.example.ligarpc;
import android.widget.Toast;

public class ClientThread extends Thread{

    Client cl;
    MainActivity context;

    ClientThread(MainActivity context){
        this.context = context;
    }

    private void printMessage(String msg){
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void run(){

        cl = new Client("192.168.0.3", 9);
        Wake wake = new Wake();

        byte[] magicpacket = wake.getMagicPacket();
        cl.sendUDPByte(magicpacket);

        //String res = cl.MakeRequest(null);

        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                printMessage(magicpacket.toString());
            }
        });
    }

}
