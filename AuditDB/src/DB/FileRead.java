package DB;

/**
 * Created by Kaligoer on 20/10/2017.
 */

import java.io.*;
public class FileRead extends File{

	public FileRead(String parent, String child) {
		super(parent, child);
	}

	public static String getFileRead(File f){
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
			StringWriter out = new StringWriter();
			int b;
			while ((b = in.read()) != -1)
				out.write(b);
			out.flush();
			out.close();
			in.close();

			return out.toString();
		}
		catch (IOException ie) {
			ie.printStackTrace();
		}
		return null;
	}

	public static String getFileRead(String f){
		try {
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
			StringWriter out = new StringWriter();
			int b;
			while ((b = in.read()) != -1)
				out.write(b);
			out.flush();
			out.close();
			in.close();

			return out.toString();
		}
		catch (IOException ie) {
			ie.printStackTrace();
		}
		return null;
	}
	public void setFileRead(File f){

	}
}