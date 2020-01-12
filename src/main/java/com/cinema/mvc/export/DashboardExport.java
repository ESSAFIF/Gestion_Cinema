package com.cinema.mvc.export;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.cinema.mvc.dao.entities.Film;
import com.cinema.mvc.service.FilmService;

import com.cinema.mvc.utils.ApplicationConstants;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("dashExporter")
public class DashboardExport implements PdfExport {
	
	@Autowired
	private FilmService filmService;
	
	private static final String FILE_NAME = "Films List";
	

	@Override
	public boolean buildPdfDocument(HttpServletResponse response, String fileName ) {
		if (StringUtils.isEmpty(fileName)) {
			fileName = FILE_NAME;
		}
	       Document  doc =new Document(PageSize.A4);
		response.setContentType(ApplicationConstants.EXCEL_CONTENT_TYPE);
		response.setHeader(ApplicationConstants.CONTENET_DISPOSITION, "attachment; filename=" + fileName + ".pdf");
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		try {
			ServletOutputStream out = response.getOutputStream();
	        PdfPTable table = new PdfPTable(6);

	        
	        
			table.addCell("NumFilm");
			
			table.addCell("Title");

			table.addCell("Kind");
		
			table.addCell("Year");
	
			table.addCell("Photo");
			
	
			table.addCell("Director");

			List<Film> films = filmService.findAll();
			if (films != null && !films.isEmpty()) {
				/**
				 * Writing in the sheet
				 */
				for (Film film : films) {
					table.addCell(film.getIdString());
					table.addCell(film.getTitle());
					table.addCell( film.getKind());
					table.addCell( film.getYString());
					table.addCell(film.getPhoto());
					table.addCell(film.getIndividual().getName());
			
				}
			
				  
		            PdfWriter.getInstance(doc, bout);
		            doc.open();
			        doc.add(table);
			            
			        doc.close();
              
		            bout.writeTo(out);


			}	
					
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}		
		


}
