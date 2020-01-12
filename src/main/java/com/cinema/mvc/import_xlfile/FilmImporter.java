package com.cinema.mvc.import_xlfile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.dao.entities.Individual;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component("filmImporter")
public class FilmImporter implements FileImporter {
	
	@Override
	public  List<Person> ReadExcel(){
		  ArrayList<Person> persons = new ArrayList<>();
	         try
	          {
	              FileInputStream file = new FileInputStream(new File("C:/wamp64/www/phpCurl/out/out.xlsperson.xls"));

	              //Create Workbook instance holding reference to .xlsx file
	              XSSFWorkbook workbook = new XSSFWorkbook(file);

	              //Get first/desired sheet from the workbook
	              XSSFSheet sheet = workbook.getSheetAt(0);

	    //I've Header and I'm ignoring header for that I've +1 in loop
	              for(int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
	            	  Person e= new Person();
	                  Row ro=sheet.getRow(i);
	                  for(int j=ro.getFirstCellNum();j<=ro.getLastCellNum();j++){
	                      Cell ce = ro.getCell(j);
	                    if(j==0){  
	                        //If you have Header in text It'll throw exception because it won't get NumericValue
	                        e.setId(ce.getNumericCellValue());
	                    }
	                    if(j==1){
	                        e.setFirstName(ce.getStringCellValue());
	                    }
	                    if(j==2){
	                        e.setLastName(ce.getStringCellValue());
	                    }    
	                  }
	                  persons.add(e);
	                  
	              }
	              for(Person emp: persons){
	                  System.out.println("ID:"+emp.getId()+" firstName:"+emp.getFirstName());
	              }
	              file.close();
	          } 
	          catch (Exception e) 
	          {
	              e.printStackTrace();
	          }
			return persons;
	}
	
}