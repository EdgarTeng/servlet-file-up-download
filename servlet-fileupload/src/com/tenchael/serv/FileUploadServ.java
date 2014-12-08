package com.tenchael.serv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.tenchael.file.util.FileUtil;
import com.tenchael.file.util.PostForm;

/**
 * Servlet implementation class FileServ
 */
@WebServlet(description = "a servlet for file upload ", urlPatterns = { "/FileServ" })
public class FileUploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String basePath = "E:/test/";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		p("调用FileUploadServ:doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		p("调用FileUploadServ:doPost");
		request.setCharacterEncoding("UTF-8");
		PostForm form = new PostForm(request);
		Set<String> fieldSet = form.getParamKeys();
		for (String key : fieldSet) {
			p(key + ": " + form.getParam(key));
		}
		Collection<FileItem> fileItems = form.getFileItems();
		for (FileItem item : fileItems) {
			p("开始保存文件[" + item.getName() + "]...");
			InputStream in = item.getInputStream();
			File file = new File(basePath + item.getName());
			OutputStream out = new FileOutputStream(file);
			FileUtil.readAndWrite(in, out);
			out.close();
		}

		p("所有文件都已保存在:" + basePath);
	}

	private void p(Object obj) {
		System.out.println(obj);
	}

}
