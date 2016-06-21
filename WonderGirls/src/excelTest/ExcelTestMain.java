package excelTest;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public final class ExcelTestMain {
	
	/**
	 *  Excel파일에 Write
	 * 
	 * @param file
	 * @param data
	 * @throws Exception
	 */
	public final static void simpleExcelWrite(File file, String data[][]) throws Exception {
		WritableWorkbook workbook = null; //dddd 123
		WritableSheet sheet = null;

		try {

			workbook = Workbook.createWorkbook(file); // 지정된 파일명 경로로 워크북 즉 엑셀파일을 만듭니다.
			workbook.createSheet("Sheet", 0); // 지정한 워크북에 싯트를 만듭니다. "Sheet" 가 싯트명이 됩니다.
			sheet = workbook.getSheet(0); // 시트를 가져옵니다.

			WritableCellFormat cellFormat = new WritableCellFormat(); // 셀의 스타일을 지정하기 위한 부분입니다.
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN); // 셀의 스타일을 지정합니다. 테두리에 라인그리는거에요

			// 빙글빙글 돌리면서 엑셀에 데이터를 작성합니다.
			for (int row = 0; row < data.length; row++) {
				for (int col = 0; col < data[0].length; col++) {
					Label label = new jxl.write.Label(col, row, (String) data[row][col], cellFormat);
					sheet.addCell(label);
				}
			}

			workbook.write();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (workbook != null)
					workbook.close();
			} catch (WriteException e) {
				// e.printStackTrace();
			} catch (IOException e) {
				// e.printStackTrace();
			}
		} 
		//[출처] 자바<JAVA> JXL 이용하여 엑셀에 쓰기 초간단 예제|작성자 달빛
	}
	
	/**
	 *  Excel파일 Read
	 * 
	 * @param targetFile
	 * @return
	 * @throws Exception
	 */
	public final static String[][] simpleExcelRead(File targetFile)
			throws Exception {

		Workbook workbook = null;
		Sheet sheet = null;

		String[][] data = null;

		try {
			workbook = Workbook.getWorkbook(targetFile); // 존재하는 엑셀파일 경로를 지정
			sheet = workbook.getSheet(0); // 첫번째 시트를 지정합니다.

			int rowCount = sheet.getRows(); // 총 로우수를 가져옵니다.
			int colCount = sheet.getColumns(); // 총 열의 수를 가져옵니다.

			if (rowCount <= 0) {
				throw new Exception("Read 할 데이터가 엑셀에 존재하지 않습니다.");
			}

			data = new String[rowCount][colCount];

			// 엑셀데이터를 배열에 저장
			for (int i = 0; i < rowCount; i++) {
				for (int k = 0; k < colCount; k++) {
					Cell cell = sheet.getCell(k, i); // 해당위치의 셀을 가져오는 부분입니다.
					if (cell == null)
						continue;
					data[i][k] = cell.getContents(); // 가져온 셀의 실제 콘텐츠 즉 데이터(문자열)를 가져오는 부분입니다.
				}
			}

			// 데이터 검증 테스트
			for (int r = 0; r < data.length; r++) {
				for (int c = 0; c < data[0].length; c++) {
					System.out.print("data ["+r+"]["+c+"] : "+data[r][c] + " ");
				}
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (workbook != null)
					workbook.close();
			} catch (Exception e) {
			}
		}

		return data;
		// [출처] 자바<JAVA> JXL이용하여 엑셀 읽기 초간단 예제|작성자 달빛
	}
	
	public static void main(String[] args) {
		
		String[][] data = new String[][] { 
				{ "COL1", "COL2", "COL3", "COL4" },
				{ "DATA11", "DATA12", "DATA13", "DATA14" },
				{ "DATA21", "DATA22", "DATA23", "DATA24" },
				{ "DATA31", "DATA32", "DATA33", "DATA34" },
				{ "DATA41", "DATA42", "DATA43", "DATA44" },
				{ "DATA51", "DATA52", "DATA53", "DATA54" }
				};

		try {
			simpleExcelWrite(new File("D:/test.xls"), data);
			
			simpleExcelRead(new File("D:/test.xls"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//[출처] 자바<JAVA> JXL 이용하여 엑셀에 쓰기 초간단 예제|작성자 달빛
	} 

}
