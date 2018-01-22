package project_filament;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldata {
	XSSFWorkbook wb;
	XSSFSheet sheet_veri;
	
	/**
	 * Set a excel sheet.
	 **/
	public Exceldata(String excelpath){
		// TODO Auto-generated constructor stub
		try{
			File src = new File(excelpath);
			FileInputStream fis=new FileInputStream(src);
			wb = new XSSFWorkbook(fis);		
		}catch(Exception e){
			System.out.println("Error is:"+e);
		}
	}

	/**
	 *  Get number of rows
	 **/
	public int getTotalRow(int sheetNo){
		sheet_veri = wb.getSheetAt(sheetNo);
		int data = sheet_veri.getLastRowNum();
		return data;		
	}
	
	/**
	 * Get data from sheet 
	 * 
	 **/
	public String getData(int sheetNo, int noOfRow, int cellNo){
		
		sheet_veri= wb.getSheetAt(sheetNo);
		Row row = sheet_veri.getRow(noOfRow);
		String data= null;
		if (row == null) {
	         // There is no data in this row, handle as needed
	      } else {
	    	  Cell cell = row.getCell(cellNo);	    	  
	    	  	if (cell == null) {
		    		  data="";
		            } else {
		            	cell.setCellType(Cell.CELL_TYPE_STRING);
		               data = sheet_veri.getRow(noOfRow).getCell(cellNo).getStringCellValue();
		            }  
	      }
		return data;
		
	}
	/**
	 * Write a excel sheet 
	 **/
	public String writeData(){
		File src = new File("C:\\Users\\jayesh\\workspace4\\project_filament\\browser\\chromedriver.exe");
		sheet_veri.getRow(3).createCell(3).setCellValue("Pass");
		FileOutputStream set_excel = null;
		try {
			set_excel = new FileOutputStream(src);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			wb.write(set_excel);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
