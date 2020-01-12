package com.cinema.mvc.export;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;

import com.lowagie.text.pdf.PdfWriter;

public interface PdfExport {
	boolean buildPdfDocument(HttpServletResponse response, String fileName);

}
