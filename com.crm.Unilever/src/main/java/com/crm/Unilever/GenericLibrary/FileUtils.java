package com.crm.Unilever.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils {

	public String readDataFromProperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream(ipathConstants.filepath);
	    Properties p=new Properties();
	    p.load(fis);
	    String data = p.getProperty(key);
	    return data;
	}
	
	public String readDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(ipathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	return data;
	
	}
	
}
