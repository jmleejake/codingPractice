package nioTest;

import java.nio.channels.*;
import java.nio.ByteBuffer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.util.Set;
import java.util.Iterator;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.CharBuffer;

public class NIOServer implements Runnable
{
	// � ä���� � IO�� �� �� �ִ��� �˷��ִ� Ŭ����(Selector)
	Selector selector;
	int port = 9999;
	// �ѱ� ���ۿ�
	Charset charset = Charset.forName("UTF-8");
	CharsetEncoder encoder = charset.newEncoder();
	
	public NIOServer() throws IOException
	{
		// Selector�� ���� �մϴ�.
		selector = Selector.open();
		// ServerSocket�� �����ϴ� ServerSocketChannel�� ����, ���� ���ε��� �ȵ�
		ServerSocketChannel channel = ServerSocketChannel.open();
		// ���� ���� ����
		ServerSocket socket = channel.socket();
		SocketAddress addr = new InetSocketAddress(port);
		// ������ �ش� ��Ʈ�� ���ε�
		socket.bind(addr);
		// Non-Blocking ���·� ����
		channel.configureBlocking(false);
		// ���ε��� ServerSocketChannel�� Selector�� ��� �մϴ�.
		channel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("---- Client�� ������ ��ٸ��ϴ�... ----");
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public void run()
	{
		// SocketChannel�� ������ �̸� ����� �Ӵϴ�.
		int socketOps = SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE;
		ByteBuffer buff = null;
		try
		{
			// ������ ��������ä�ο� ���� accept ���� �϶� �˷��޶�� selector�� ��� ��Ų ��
			// �̺�Ʈ�� �Ͼ�� ���� ��ٸ��ϴ�. ���ο� Ŭ���̾�Ʈ�� �����ϸ� seletor��
			// �̸� ��� �ߴ� SeerverSocketChannel�� �̺�Ʈ�� �߻������Ƿ� select �޼ҵ忡��
			// 1�� �����ݴϴ�. �� Selector�� ������ �̺�Ʈ�� �ִٸ�
			while (selector.select() > 0)
			{
				// ���� selector�� ��ϵ� ä�ο� ������ �󳪶� ���� �Ǵ� ��� �� ä�ε��� SelectionKey��
				// Set�� �߰� �մϴ�. �Ʒ������� ���õ� ä�ε��� Ű�� ����ϴ�. �� �ش� IO�� ���� �����
				// ���� ä���� Ű�� ��� �̴ϴ�.
				Set keys = selector.selectedKeys();
				Iterator iter = keys.iterator();
				while (iter.hasNext())
				{
					SelectionKey selected = (SelectionKey) iter.next();
					// ���� ó���ϴ� SelectionKey�� Set���� ���� �մϴ�.
					iter.remove();
					// channel()�� ���� �ϰ� �ִ� ����(�б�, ����)�� ���� �ľ��� �ϱ� ���� �̴ϴ�.
					SelectableChannel channel = selected.channel();
					if (channel instanceof ServerSocketChannel)
					{
						// ServerSocketChannel�̶�� accept()�� ȣ���ؼ�
						// ���� ��û�� �ؿ� ���� ���ϰ� ���� �� �� �ִ� SocketChannel�� ����ϴ�.
						ServerSocketChannel serverChannel = (ServerSocketChannel) channel;
						SocketChannel socketChannel = serverChannel.accept();
						// �������� ServerSocketChannel�� Non-Blocking IO�� ���� �Ǿ�
						// �ֽ��ϴ�.
						// �̰��� ���� ������ ��� ���ŷ ���� �ʰ� �ٷ� null�� �����Ƿ�
						// üƮ �ؾ� �մϴ�.
						if (socketChannel == null)
						{
							System.out.println("## null server socket");
							continue;
						}
						System.out.println("## socket accepted : " + socketChannel);
						// ����� ������ ���ŷ �����̹Ƿ� Non-Blocking IO ���·� ���� �մϴ�.
						socketChannel.configureBlocking(false);
						// ���� ä���� Selector�� ���
						socketChannel.register(selector, socketOps);
					}
					else
					{
						// �Ϲ� ���� ä���� ��� �ش� ä���� ����.
						SocketChannel socketChannel = (SocketChannel) channel;
						buff = ByteBuffer.allocate(100);
						// ���� ä���� �ൿ�� �˻��ؼ� �׿� �����ϴ� �۾��� ��
						if (selected.isConnectable())
						{
							System.out.println("Client���� ���� ���� OK~");
							if (socketChannel.isConnectionPending())
							{
								System.out.println("Client���� ���� ������ ������ ���Դϴ�~");
								socketChannel.finishConnect();
							}
						}
						// �б� ��û �̶��
						else if (selected.isReadable())
						{
							StringBuffer str = new StringBuffer();
							// ���� ä�η� �����͸� �о� ���Դϴ�.
							try
							{
								// read�� ������ buffer���� print�ϴµ� �� �ѱ����� +2���� �𸣰���
								str.append("socketChannel read: " + socketChannel.read(buff) + "\n");
								socketChannel.read(buff);
								// �����Ͱ� �ִٸ�
								if (buff.position() != 0)
								{
									buff.clear();
									System.out.print("Ŭ���̾�Ʈ�� ���޵� ���� : ");
									// Non-Blocking Mode�̹Ƿ� �����Ͱ� ��� ���޵ɶ� ���� ��ٸ�
									str.append("from client msg: ");
									
									char var = 0;
									
									while (buff.hasRemaining())
									{
										//str.append("print char buffer get: " + (char) buff.get() + "\n");
										var = (char) buff.get();
										System.out.print(var);
										str.append(var); //���۾��� ������ �ѱ��� �ѱ��� while�� ���ư��� print��
									}
									str.append("\n");
									buff.clear();
									System.out.println();
									// ���Ⱑ ���� �ϴٸ�
									if (selected.isWritable())
									{
//										String str = "�̰� �������� ���� ������...";
										// �ѱ� ���ڵ�
										str.append("this msg is from server!! \n");
										socketChannel.write(encoder.encode(CharBuffer.wrap(str + "")));
										System.out.println("������ ������ ���� : " + str);
									}
								}
							}
							catch (IOException ioe)
							{
								ioe.printStackTrace();
								socketChannel.finishConnect();
								socketChannel.close();
							}
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		NIOServer s = new NIOServer();
		new Thread(s).start();
	}
}
