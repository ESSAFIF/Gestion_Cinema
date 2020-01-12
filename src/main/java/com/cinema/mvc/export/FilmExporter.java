package com.cinema.mvc.export;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.axis.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

@Component("filmExporter")
public class FilmExporter implements FileExporter {
	
	@Autowired
	private FilmService filmService;
	
	private static final String FILE_NAME = "Films List";
	

	@Override
	public boolean exportDataToExcel(HttpServletResponse response, String fileName, String encodage) {
		if (StringUtils.isEmpty(fileName)) {
			fileName = FILE_NAME;
		}
		if (StringUtils.isEmpty(encodage)) {
			encodage = ApplicationConstants.DEFAULT_ENCODAGE;
		}
		response.setContentType(ApplicationConstants.EXCEL_CONTENT_TYPE);
		response.setHeader(ApplicationConstants.CONTENET_DISPOSITION, "attachment; filename=" + fileName + ".xls");
		WorkbookSettings workbookSettings = new WorkbookSettings();
		workbookSettings.setEncoding(encodage);
		
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream(), workbookSettings);
			WritableSheet sheet = workbook.createSheet(fileName, 0);
			
			/**
			 * Sheet Header
			 */
			Label labelCode = new Label(0, 0, ApplicationConstants.CODE_FILM);
			labelCode.setCellFeatures(new WritableCellFeatures());
			labelCode.getCellFeatures().setComment("");
			sheet.addCell(labelCode);
			
			Label labelTITLE= new Label(1, 0, ApplicationConstants.TITLE);
			labelTITLE.setCellFeatures(new WritableCellFeatures());
			labelTITLE.getCellFeatures().setComment("");
			sheet.addCell(labelTITLE);
			
			Label labelKIND = new Label(2, 0, ApplicationConstants.KIND);
			labelKIND.setCellFeatures(new WritableCellFeatures());
			labelKIND.getCellFeatures().setComment("");
			sheet.addCell(labelKIND);
			
			Label labelYEAR = new Label(3, 0, ApplicationConstants.YEAR);
			labelYEAR.setCellFeatures(new WritableCellFeatures());
			labelYEAR.getCellFeatures().setComment("");
			sheet.addCell(labelYEAR);
			
			Label labelPHOTO = new Label(4, 0, ApplicationConstants.PHOTO);
			labelPHOTO.setCellFeatures(new WritableCellFeatures());
			labelPHOTO.getCellFeatures().setComment("");
			sheet.addCell(labelPHOTO);
			
			Label labelDIRECTOR = new Label(5, 0, ApplicationConstants.DIRECTOR);
			labelDIRECTOR.setCellFeatures(new WritableCellFeatures());
			labelDIRECTOR.getCellFeatures().setComment("");
			sheet.addCell(labelDIRECTOR);

			
			int currentRow = 1;
			List<Film> films = filmService.findAll();
			if (films != null && !films.isEmpty()) {
				/**
				 * Writing in the sheet
				 */
				for (Film film : films) {
					sheet.addCell(new Label(0, currentRow, film.getIdString()));
					sheet.addCell(new Label(1, currentRow, film.getTitle()));
					sheet.addCell(new Label(2, currentRow, film.getKind()));
					sheet.addCell(new Label(3, currentRow, film.getYString()));
					sheet.addCell(new Label(4, currentRow, film.getPhoto()));
					sheet.addCell(new Label(5, currentRow, film.getIndividual().getName()));
					currentRow++;
				}
				CellView cellView = new CellView();
				cellView.setAutosize(true);
				cellView.setSize(250);
				sheet.setColumnView(0, cellView);
				sheet.setColumnView(1, cellView);
				sheet.setColumnView(2, cellView);
				sheet.setColumnView(3, cellView);
				sheet.setColumnView(4, cellView);
				sheet.setColumnView(5, cellView);
				/**
				 * write to exce sheet
				 */
				workbook.write();
				/**
				 * Closing the workbook
				 */
				workbook.close();
				
				response.getOutputStream().flush();
				response.getOutputStream().close();
				
				
				
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


}
