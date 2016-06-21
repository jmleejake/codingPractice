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
	 *  Excel���Ͽ� Write
	 * 
	 * @param file
	 * @param data
	 * @throws Exception
	 */
	public final static void simpleExcelWrite(File file, String data[][]) throws Exception {
		WritableWorkbook workbook = null; //dddd 123
		WritableSheet sheet = null;

		try {

			workbook = Workbook.createWorkbook(file); // ������ ���ϸ� ��η� ��ũ�� �� ���������� ����ϴ�.
			workbook.createSheet("Sheet", 0); // ������ ��ũ�Ͽ� ��Ʈ�� ����ϴ�. "Sheet" �� ��Ʈ���� �˴ϴ�.
			sheet = workbook.getSheet(0); // ��Ʈ�� �����ɴϴ�.

			WritableCellFormat cellFormat = new WritableCellFormat(); // ���� ��Ÿ���� �����ϱ� ���� �κ��Դϴ�.
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN); // ���� ��Ÿ���� �����մϴ�. �׵θ��� ���α׸��°ſ���

			// ���ۺ��� �����鼭 ������ �����͸� �ۼ��մϴ�.
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
		//[��ó] �ڹ�<JAVA> JXL �̿��Ͽ� ������ ���� �ʰ��� ����|�ۼ��� �޺�
	}
	
	/**
	 *  Excel���� Read
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
			workbook = Workbook.getWorkbook(targetFile); // �����ϴ� �������� ��θ� ����
			sheet = workbook.getSheet(0); // ù��° ��Ʈ�� �����մϴ�.

			int rowCount = sheet.getRows(); // �� �ο���� �����ɴϴ�.
			int colCount = sheet.getColumns(); // �� ���� ���� �����ɴϴ�.

			if (rowCount <= 0) {
				throw new Exception("Read �� �����Ͱ� ������ �������� �ʽ��ϴ�.");
			}

			data = new String[rowCount][colCount];

			// ���������͸� �迭�� ����
			for (int i = 0; i < rowCount; i++) {
				for (int k = 0; k < colCount; k++) {
					Cell cell = sheet.getCell(k, i); // �ش���ġ�� ���� �������� �κ��Դϴ�.
					if (cell == null)
						continue;
					data[i][k] = cell.getContents(); // ������ ���� ���� ������ �� ������(���ڿ�)�� �������� �κ��Դϴ�.
				}
			}

			// ������ ���� �׽�Ʈ
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
		// [��ó] �ڹ�<JAVA> JXL�̿��Ͽ� ���� �б� �ʰ��� ����|�ۼ��� �޺�
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
		//[��ó] �ڹ�<JAVA> JXL �̿��Ͽ� ������ ���� �ʰ��� ����|�ۼ��� �޺�
	} 

}
