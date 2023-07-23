package com.example.demo.ustils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.demo.repository.dto.IssuesDto;

public class ExcelFileExporter {
	public static ByteArrayInputStream contactListToExcelFile(List<IssuesDto> issuesDtos) {
		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Issues");

			Row row = sheet.createRow(0);
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

			// Creating header
			Cell cell = row.createCell(0);
			cell.setCellValue("ស្ថានភាព");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(1);
			cell.setCellValue("អាទិភាព");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(2);
			cell.setCellValue("ប្រធានបទ");
			cell.setCellStyle(headerCellStyle);

			cell = row.createCell(3);
			cell.setCellValue("អ្នកស្នើសុំ");
			cell.setCellStyle(headerCellStyle);
			
			cell = row.createCell(4);
			cell.setCellValue("ប្រភេទសំណើរ");
			cell.setCellStyle(headerCellStyle);
			
			cell = row.createCell(5);
			cell.setCellValue("ប្រភេទសំណើររង");
			cell.setCellStyle(headerCellStyle);
			
			cell = row.createCell(6);
			cell.setCellValue("%រួចរាល់");
			cell.setCellStyle(headerCellStyle);
			
			cell = row.createCell(7);
			cell.setCellValue("បានធ្វើបច្ចុប្បន្នភាព");
			cell.setCellStyle(headerCellStyle);

			CellStyle style = workbook.createCellStyle();

//			Font font = workbook.createFont();
//			font.setColor(IndexedColors.RED.getIndex());
//			cell.setCellStyle(style);
//			style.setFont(font);

			// Creating data rows for each customer
			for (int i = 0; i < issuesDtos.size(); i++) {
				Row dataRow = sheet.createRow(i + 1);
				
				
				dataRow.createCell(0).setCellValue( getIssueTp(issuesDtos.get(i).getIss_status()));
				dataRow.createCell(1).setCellValue(getPrioritySt(issuesDtos.get(i).getIss_priority()) );
				dataRow.createCell(2).setCellValue(issuesDtos.get(i).getIss_nm());
				dataRow.createCell(3).setCellValue(issuesDtos.get(i).getUsersDetailDto().getUser_nm_kh());
				dataRow.createCell(4).setCellValue(issuesDtos.get(i).getCategoryDto().getCategory_nm());
				dataRow.createCell(5).setCellValue(issuesDtos.get(i).getSubCategoryDto().getSub_category_nm());
				dataRow.createCell(6).setCellValue(issuesDtos.get(i).getIss_done() +"%");
				dataRow.createCell(7).setCellValue(issuesDtos.get(i).getUpdated_date());
				
				cell.setCellStyle(style);

			}
			// Making size of column auto resize to fit with data
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
			sheet.autoSizeColumn(4);
			sheet.autoSizeColumn(5);
			sheet.autoSizeColumn(6);
			sheet.autoSizeColumn(7);
			

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);
			return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	public static String getIssueTp(String issueSt) {
		String issueTp = "";
		if("1".equals(issueSt)) {
			issueTp = "សំណើថ្មី";
		}else if("2".equals(issueSt)) {
			issueTp = "ទទួលសំណើ";
		}else if("3".equals(issueSt)) {
			issueTp = "កំពុងដោះស្រាយ";
		}else if("4".equals(issueSt)) {
			issueTp = "បានដោះស្រាយ";
		}else if("5".equals(issueSt)) {
			issueTp = "ឆ្លើយតបសំណើ";
		}else if("6".equals(issueSt)) {
			issueTp = "បិទបញ្ចប់សំណើ";
		}
		return issueTp;
	}
	
	public static String getPrioritySt(String priorityTp) {
		String priority ="";
		
		if("1".equals(priorityTp)) {
			priority = "ធម្មតា";
		}else if("2".equals(priorityTp)) {
			priority = "ខ្ពស់";
		}else if("3".equals(priorityTp)) {
			priority = "បន្ទាន់";
		}
		
		return priority;
	}
	
	
	
}


