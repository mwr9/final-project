package SevenBlog;


import java.io.IOException;

import java.io.PrintWriter;
import java.io.File;
import java.util.*;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.commons.io.output.*;



/**
 * Servlet implementation class StyleFileSubmit
 */
@WebServlet("/StyleFileSubmit")

public class StyleFileSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private boolean isMultipart;
	   private String filePath, tmpFilePath;
	   private int maxFileSize = 5 * 1024 * 1024; // 5Mb
	   private int maxMemSize = 4 * 1024;
	   private File fullFile = null;
	   

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StyleFileSubmit() {
        super();
        // TODO Auto-generated constructor stub      
    }
    
    public void init( ){
        // the location where theme file uploads are to be stored
       
        ServletContext servletContext = getServletContext();
        filePath = servletContext.getInitParameter("css\themes");
            
        // the temp location where large uploads are to be stored
        tmpFilePath = getServletContext().getInitParameter("tmp-location");
     }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		throw new ServletException("Servlet " + getClass( ).getName( ) + " does not accept the GET method. Use POST method.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession currSession = request.getSession(); // will create a new one if it didn't exist
		String sessionId = currSession.getId();
		File sessionFolder = new File(filePath, sessionId);
		
		String tmpFileName = "";
		String fileExt = "";
		
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter( );
	      
	      if( !isMultipart ){
	    	 out.println("<!DOCTYPE html>"); 
	         out.println("<html>");
	         out.println("<head>");
	         out.println("<title>File upload</title>");  
	         out.println("</head>");
	         out.println("<body>");
	         out.println("<p>No file uploaded</p>"); 
	         out.println("</body>");
	         out.println("</html>");
	         return;
	      }
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File(tmpFilePath));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );

	      try{ 
	      // Parse the request to get file items.
	      List<FileItem> fileItems = upload.parseRequest(request);
		
	      // Process the uploaded file items
	      Iterator<FileItem> i = fileItems.iterator();

	      out.println("<!DOCTYPE html>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>File upload</title>");  
	      out.println("</head>");
	      out.println("<body>");   
	      
	     
		if(!sessionFolder.exists()) { // && currSession.isNew() 
			if(!sessionFolder.mkdirs()) {					
				out.println("Unable to create user directory " + sessionFolder);
				out.println("</body>");
				out.println("</html>");
				return;
			}
		} else {
			out.println("Found user directory " + sessionFolder);
		}
	      
	      while ( i.hasNext () ) 
	      {
	         FileItem fi = (FileItem)i.next();
	         if ( !fi.isFormField () )	
	         {
	            // Get the necessary file parameters of the uploaded file
	           
	        	String fileName = fi.getName();
		        fileExt = fileName.substring(fileName.lastIndexOf(".")); 	        	
	        	
	        			            
		        // Error checking
	        	if(fi.getSize() > maxFileSize) {
	        		out.println("The file exceeds the maximum upload file size of " + maxFileSize);
	        	} else if (!(fileExt.endsWith("css") || fileExt.endsWith("js"))) {
	        		out.println("The file extension (" + fileExt + ") is not one of .css, or .js. Not uploading.");
	        	} else { // file is of correct size and extension
	            
		            // Write the file
	        		tmpFileName = makeTmpFileName(fileExt, sessionFolder);		           
		            fullFile = new File(sessionFolder, tmpFileName + fileExt);		            
		            
		            fi.write( fullFile ) ;
		            out.println("Original name of Uploaded File: " + fileName + "<br>");
		            out.println("Uploaded directory: " + sessionFolder + "<br>");
		            out.println("Output file: " + fullFile.getAbsolutePath() + "<br>");
		            
		            break; // found the first file selected for upload, quit the loop since we're only processing a single file upload
	        	   	}
	        	 }
	      }
	   }catch(Exception ex) {
	       System.out.println(ex);
	   }	   
	     
	      
	   // fullFile path is null unless the file uploaded was acceptable
	   if(fullFile != null) {
		   String servletRootParent = new File(getServletContext().getRealPath("/")).getParent();
		   String styleFolderPath = sessionFolder.getAbsolutePath(); // user session folder
		   styleFolderPath = styleFolderPath.substring(servletRootParent.length()); // remove everything before /servlet-name
		   styleFolderPath = styleFolderPath.replace(File.separator, "/"); // make URL slashes
		   
		 		  		  	   
	   }
		
	   // finish off the html page
	   
	   out.println("</body>");
	   out.println("</html>");
	   
	}
	
	private String makeTmpFileName(String ext, File folder) throws IOException {
		File tmpFile = File.createTempFile("full-", ext, folder);
        
        String tmpFileName = tmpFile.getName().substring("full-".length());
        tmpFile.delete();
        tmpFile = null;
        
        tmpFileName = tmpFileName.substring(0, tmpFileName.lastIndexOf(ext));
        return tmpFileName;
	}
	
	
	
		
}