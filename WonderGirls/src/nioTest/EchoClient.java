package nioTest;

import java.io.*;
import java.net.*;

class EchoClient
{
	public static void main(String[] args) throws IOException
	{
		Socket sock = null;
		try
		{
			sock = new Socket("127.0.0.1", 9999);
			System.out.println(sock + ": �����");
			OutputStream toServer = sock.getOutputStream();
			InputStream fromServer = sock.getInputStream();
			byte[] buf = new byte[1024];
			int count;
			while ((count = System.in.read(buf)) != -1)
			{
				toServer.write(buf, 0, count);
				count = fromServer.read(buf);
				System.out.write(buf, 0, count);
			}
			toServer.close();
			while ((count = fromServer.read(buf)) != -1)
				System.out.write(buf, 0, count);
			System.out.close();
			System.out.println(sock + ": ���� ����");
		}
		catch (IOException ex)
		{
			System.out.println("���� ���� (" + ex + ")");
		}
		finally
		{
			try
			{
				if (sock != null)
					sock.close();
			}
			catch (IOException ex)
			{
			}
		}
	}
}
