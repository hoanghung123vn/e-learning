package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import bean.ReadQuestion;
import dao.ReadQuestionDao;
import dao.impl.ReadQuestionDaoImpl;

public class FileHelper {
	public static String uploadFile(String dir, HttpServletRequest request) {
		String message = "";
		ServletContext context = request.getServletContext();
		final String Address = context.getRealPath(dir);
		//final String Address = "F://";
		final int MaxMemorySize = 1024 * 1024 * 3; //3MB
		final int MaxRequestSize = 1024 * 1024 * 50; //50 MB
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (!isMultipart)
		{
			message = "Thiếu multipart/form-data trong form";
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// Set factory constraints
		factory.setSizeThreshold(MaxMemorySize);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// Set overall request size constraint
		upload.setSizeMax(MaxRequestSize);
		try 
		{
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);
			
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			
			while (iter.hasNext()) 
			{
			    FileItem item = iter.next();

			    if (!item.isFormField()) 
			    {
			    	 String fileName = item.getName();
			    	 
			    	 //pathFile: vị trí mà chúng ta muốn upload file vào
			    	 //gửi cho server
			    	 
			    	String pathFile = Address + File.separator + fileName;
			    	 
			    	File uploadedFile = new File(pathFile);
			    	
			    	
			    	boolean kt = uploadedFile.exists();
			    	 
			    	try 
			    	{
			    		
			    		if (kt == true)
			    		{
			    					    
			    			message = "file tồn tại. Yêu cầu chọn file khác";
			    		}
			    		else
			    		{		    			
			    			item.write(uploadedFile);					    			
			    			message="Success";
			    		}
						
						
					} 
			    	catch (Exception e) 
			    	{ 		
			    		message = e.getMessage();
					}   	 
			    } 
			    else 
			    {
			    	message = "thêm file thất bại";
			    }
			}
			
		} 
		catch (FileUploadException e) 
		{
			message = e.getMessage();
		}
		return message;
	}
	
	public static String readExcelFile(String dir, HttpServletRequest request, int exerciseId) {
		String test = "";
		ServletContext context = request.getServletContext();
		final String Address = context.getRealPath(dir);
	
	
		final int MaxMemorySize = 1024 * 1024 * 3; //3MB
		final int MaxRequestSize = 1024 * 1024 * 50; //50 MB
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (!isMultipart)
		{
			test = "Thiếu multipart/form-data trong form";
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		
		// Set factory constraints
		factory.setSizeThreshold(MaxMemorySize);

		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		
		// Set overall request size constraint
		upload.setSizeMax(MaxRequestSize);
		
		
		
		try 
		{
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);
			
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			
			while (iter.hasNext()) 
			{
			    FileItem item = iter.next();

			    if (!item.isFormField()) 
			    {
			    	 String fileName = item.getName();
			    	 
			    	 //pathFile: vị trí mà chúng ta muốn upload file vào
			    	 //gửi cho server
			    	String pathFile = Address + File.separator + fileName;
			    	 
			    	File uploadedFile = new File(pathFile);
			    	
			    	
			    	boolean kt = uploadedFile.exists();
			    	 
			    	try 
			    	{
			    		
			    		if (kt == true)
			    		{
			    					    
			    			test = "file tồn tại. Yêu cầu chọn file khác";
			    		}
			    		else
			    		{		    			
			    			item.write(uploadedFile);
			    			try
			    			{
			    				addReadQuestionsFromExcel(pathFile, exerciseId);
			    			}
			    			catch(NullPointerException e)
			    			{
			    				test = e.getMessage();
			    			}
			    			test="Success";
			    		}
					} 
			    	catch (Exception e) 
			    	{ 		
			    		test = e.getMessage();
					}   	 
			    } 
			    else 
			    {
			    	test = "thêm file thất bại";
			    }
			}
			
		} 
		catch (FileUploadException e) 
		{
			test = e.getMessage();
		}
		
		return test;
	}
	
	private static void addReadQuestionsFromExcel(String filePath, int exerciseId) {
		ReadQuestionDao readQuestionDao = new ReadQuestionDaoImpl();
		FileInputStream inp;
		try 
		{
			inp = new FileInputStream(filePath);
			HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(inp));
			
			Sheet sheet = wb.getSheetAt(0);
			
			
			
			for (int i=1; i<=sheet.getLastRowNum();i++)
			{
				Row row = sheet.getRow(i);
				
				int num = (int) row.getCell(0).getNumericCellValue();			
				String paragraph = row.getCell(1).getStringCellValue();						
				String question = row.getCell(2).getStringCellValue();
				String option1 = row.getCell(3).getStringCellValue();
				String option2 = row.getCell(4).getStringCellValue();
				String option3 = row.getCell(5).getStringCellValue();
				String option4 = row.getCell(6).getStringCellValue();
				String correctanswer = row.getCell(7).getStringCellValue();
				
				ReadQuestion ex = new ReadQuestion();
				
				ex.setNo(num);
				ex.setParagraph(paragraph);
				ex.setQuestion(question);
				ex.setOption1(option1);
				ex.setOption2(option2);
				ex.setOption3(option3);
				ex.setOption4(option4);
				ex.setCorrect(correctanswer);
				ex.setExerciseId(exerciseId);
				readQuestionDao.save(ex);
			}
			
			wb.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
			
		}
	}
}
