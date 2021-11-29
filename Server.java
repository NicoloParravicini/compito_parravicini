package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;
    Socket msocket;
    BufferedReader in;
    DataOutputStream out;
    public Socket attendi() {
        try {
            //creo il server 
            System.out.println("Server in esecuzione..");
            server = new ServerSocket(1122);

            //accetto eventuale connessione da parte del client
            msocket = server.accept();
            System.out.println("Client connesso con successo! ");

            //chiudo la connessione per evitare altre connessioni
            server.close();

            //inizializzo gli stream per consentire la comunicazione
            out = new DataOutputStream(msocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(msocket.getInputStream()));

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }
        return msocket;
    }


    public void calcola(){
        try{
            double x;
            double y;
            double risultato=0;

            //leggo la scelta e in base a quella eseguo le operazioni
            int scelta = in.read();

            //accetto prima i numeri
            x = in.read();
            y = in.read();
            

            switch (scelta){
                case 1:
                    System.out.println("Scelta: "+scelta);
                    //somma
                    risultato = x+y;
                    case 2:
                    System.out.println("Scelta: "+scelta);
                    //sottrazione
                    if(x > y)
                    risultato = x-y;

                    case 3:
                    System.out.println("Scelta: "+scelta);
                    //divisione
                    if(x > y)
                    risultato = x/y;
                    case 4:
                    System.out.println("Scelta: "+scelta);
                    //moltiplicazione
                    risultato = x*y;


            }
            System.out.println("Risultato: "+risultato);

        }catch (Exception e){

        }
    }


    public static void main(String args[]) {
        Server myServer = new Server();
        myServer.attendi();
        myServer.calcola();
    }
}

