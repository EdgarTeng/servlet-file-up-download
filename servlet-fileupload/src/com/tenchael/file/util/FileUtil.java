package com.tenchael.file.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 
 * @author tzz1002@gmail.com
 *
 */
public class FileUtil {
	/**
	 * read from inputStream and write to outputStream
	 * @param in Inputstream
	 * @param out OutputStream
	 * @throws IOException
	 */
	public static void readAndWrite(InputStream in, OutputStream out)
			throws IOException {
		int bufferSize = 8192;
		byte[] buf = new byte[bufferSize];
		while (true) {
			int read = 0;
			if (in != null) {
				read = in.read(buf);
			}
			if (read == -1) {
				break;
			}
			out.write(buf, 0, read);
		}
		out.flush();
	}
}
