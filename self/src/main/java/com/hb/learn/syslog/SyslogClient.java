package com.hb.learn.syslog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

/**
 * @ClassName SyslogClient @Description TODO @Author huangbo @Mail refusers@163.com @Date 2023/6/27
 * 23:50 @Version 1.0
 */
public class SyslogClient {
  static String serverHost = "192.168.5.141";
  static int serverPort = 514;
  static String keystorePath = "C:\\Users\\huangbo\\Desktop\\server.jks";
  static String keystorePassword = "123456";

  public static void main(String[] args) {

    //sendByUDP();

    sendBySSL();
  }

  private static void sendBySSL() {
    try {
      // Load the keystore
      KeyStore keystore = KeyStore.getInstance("JKS");
      keystore.load(new FileInputStream(keystorePath), keystorePassword.toCharArray());

      // Create the KeyManagerFactory and initialize it with the keystore
      KeyManagerFactory kmf =
          KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
      kmf.init(keystore, keystorePassword.toCharArray());

      // Create the TrustManagerFactory and initialize it with the keystore
      TrustManagerFactory tmf =
          TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      tmf.init(keystore);

      // Create the SSLContext and initialize it with the KeyManagerFactory and TrustManagerFactory
      SSLContext sslContext = SSLContext.getInstance("TLS");
      sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

      // Create the SSLSocketFactory
      SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

      // Create the SSL socket and connect to the server
      Socket socket = sslSocketFactory.createSocket(serverHost, serverPort);

      // Write syslog message to the socket
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      writer.write("TCP+SSL Syslog message to be sent");
      writer.newLine();
      writer.flush();

      // Read response from the server (if needed)
      BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String response = reader.readLine();
      System.out.println("Server response: " + response);

      // Close the socket
      socket.close();
    } catch (Exception ex) {
      ex.printStackTrace();
      Logger.getLogger(SyslogClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static void sendByUDP() {
    try {
      // Create the UDP socket
      DatagramSocket socket = new DatagramSocket();

      // Prepare the syslog message
      String message = "UDP Syslog message to be sent";
      byte[] data = message.getBytes();

      // Get the server IP address
      InetAddress serverAddress = InetAddress.getByName(serverHost);

      // Create the UDP packet with the syslog message and server address
      DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);

      // Send the packet to the server
      socket.send(packet);

      // Close the socket
      socket.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
