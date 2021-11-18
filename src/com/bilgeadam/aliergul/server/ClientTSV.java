package com.bilgeadam.aliergul.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.bilgeadam.aliergul.dto.DtoArtist;

public class ClientTSV {
	
	public DtoArtist requestArtistSearch(String s) {
		PortInfo port = new PortInfo();
		DtoArtist obj = null;
		try (Socket socket = new Socket(port.getIdAdress(), port.getPort())) {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			out.writeUTF(s);
			if (!MyServer.EXIT.equals(s)) {
				obj = (DtoArtist) input.readObject();
			}
			
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Server a bağlanamadı. hata: " + e.getMessage());
			return null;
		}
		return obj;
	}
}
