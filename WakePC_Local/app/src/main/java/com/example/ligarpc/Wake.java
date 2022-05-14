package com.example.ligarpc;


public class Wake {

    byte[] magicPacket;
    byte[] MACAddress;

    public Wake(){
        magicPacket = new byte[102];
        MACAddress = new byte[6];

        // my mac: e0:d5:5e:a1:4a:7b
        MACAddress[0] = (byte) 0xE0;
        MACAddress[1] = (byte) 0xD5;
        MACAddress[2] = (byte) 0x5E;
        MACAddress[3] = (byte) 0xA1;
        MACAddress[4] = (byte) 0x4A;
        MACAddress[5] = (byte) 0x7B;

        setUpMagicPacket();
    }

    private void setUpMagicPacket(){

        // fill with null
        for(int i = 0; i < 6; i++){
            magicPacket[i] = (byte) 0xFF;
        }

        // fill the rest with mac address
        for(int i = 6; i < magicPacket.length; i++){
            magicPacket[i] = MACAddress[i%6];
        }

    }

    public byte[] getMagicPacket(){
        return magicPacket;
    }

}
