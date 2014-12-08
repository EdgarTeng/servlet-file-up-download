package com.tenchael.serv;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUpload;

import com.tenchael.file.util.FileUtil;

/**
 * Servlet implementation class FileDownloadServ
 */
@WebServlet(description = "a servlet for file downloading", urlPatterns = { "/FileDownloadServ" })
public class FileDownloadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map<String, String> map = new HashMap<String, String>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileDownloadServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		p("调用FileDownloadServ:doGet方法");
		map.put("1001", "E:/test/0001.png");
		map.put("1002", "E:/test/Architectural Styles and the Design of Network-based Software Architectures.pdf");
		map.put("1003", "E:/test/岑文初：淘宝开放平台架构设计与实践.pdf");
		String fid = request.getParameter("fid");
		String path = map.get(fid);
		File file = new File(path);
		InputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		FileUtil.readAndWrite(in, out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		p("调用FileDownloadServ:doPost方法");
	}

	private void p(Object obj) {
		System.out.println(obj);
	}

}
