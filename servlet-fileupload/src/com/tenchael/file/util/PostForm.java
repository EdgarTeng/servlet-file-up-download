package com.tenchael.file.util;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 
 * @author tzz1002@gmail.com
 *
 */
public class PostForm {
	private Map<String, String> formFieldMap = new HashMap<String, String>();
	private Map<String, FileItem> fileMap = new HashMap<String, FileItem>();

	/**
	 * Constructor method
	 * @param request
	 */
	public PostForm(HttpServletRequest request) {
		super();
		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// Configure a repository (to ensure a secure temp location is used)
			ServletContext servletContext = request.getServletContext();
			File repository = (File) servletContext
					.getAttribute("javax.servlet.context.tempdir");
			factory.setRepository(repository);

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			// upload.setHeaderEncoding("UTF-8");

			// Parse the request
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}

			// Process the uploaded items
			for (FileItem item : items) {
				if (item.isFormField()) {
					// processFormField
					String name = item.getFieldName();
					String value = item.getString();
					formFieldMap.put(name, value);
				} else {
					// processUploadedFile
					fileMap.put(item.getFieldName(), item);
				}
			}
		}
	}

	public String getParam(String name) {
		return formFieldMap.get(name);
	}

	public Set<String> getParamKeys() {
		return formFieldMap.keySet();
	}

	public FileItem getFileItem(String name) {
		return fileMap.get(name);
	}

	public Set<String> getFileItemKeys() {
		return fileMap.keySet();
	}

	public Collection<FileItem> getFileItems() {
		return fileMap.values();
	}

	public static String getSuffix(String contentType) {
		return contentType.substring(contentType.indexOf("/") + 1,
				contentType.length());
	}

}
