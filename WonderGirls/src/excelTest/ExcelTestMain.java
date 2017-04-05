package excelTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import sqliteTest.DataInfo;

public final class ExcelTestMain {
	
	/**
	 *  Excel파일에 Write
	 * 
	 * @param file
	 * @param data
	 * @throws Exception
	 */
	public final static void simpleExcelWrite(
			File file
			, List<DataVO> dto_list
			, String[] members
			, String[] cell_headers
			, int[] cell_widths) throws Exception {
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		try {

			workbook = Workbook.createWorkbook(file); // 지정된 파일명 경로로 워크북 즉 엑셀파일을 만듭니다.
			workbook.createSheet("Sheet", 0); // 지정한 워크북에 싯트를 만듭니다. "Sheet" 가 싯트명이 됩니다.
			sheet = workbook.getSheet(0); // 시트를 가져옵니다.

			WritableCellFormat cellFormat = new WritableCellFormat(); // 셀의 스타일을 지정하기 위한 부분입니다.
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN); // 셀의 스타일을 지정합니다. 테두리에 라인그리는거에요

			// 빙글빙글 돌리면서 엑셀에 데이터를 작성합니다.
//			for (int row = 0; row < data.length; row++) {
//				for (int col = 0; col < data[0].length; col++) {
//					Label label = new jxl.write.Label(col, row, (String) data[row][col], cellFormat);
//					sheet.addCell(label);
//				}
//			}
			
			int i = 0;

			// 헤더 생성부
			for (String header : cell_headers) {
				sheet.setColumnView(i, cell_widths[i]);
				Label label = new Label(i++, 0, header);
				sheet.addCell(label);
			}
			
			// 헤더 하위 데이터 생성부
			int j = 0;

			ArrayList<HashMap<String, Object>> memList = new ArrayList<>();
			for (DataVO dto : dto_list) {
				getMemberFields(memList, dto, true);
			}
			
			for (HashMap<String, Object> mem : memList) {
				i = 0;
				j++;
				for (String member : members) {
					Label label = new Label(i++, j,
							mem.get(member) != null ? mem
									.get(member).toString() : "");
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
	
	/**
	 *  VO값 가져오기
	 * @param dto VO객체
	 * @param isMemberLowerCase 키값을 모조리 소문자로하는가 여부
	 * @return
	 * @throws Exception
	 */
	public static void getMemberFields(ArrayList<HashMap<String, Object>> members, DataVO dto, boolean isMemberLowerCase) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		
		System.out.println("getMemberFields");
		if (dto != null) {
			Class c = dto.getClass();
			Method[] methods = c.getMethods();

			System.out.println("----------------------------------------------");
			for (int i = 0; i < methods.length; i++) {
				String methodName = methods[i].getName();

				if ((methodName.equals("getClass"))
						|| (!methodName.subSequence(0, 3).equals("get")))
					continue;
				String fieldName = methodName.substring(3);
				Object fieldValue = methods[i].invoke(dto, new Object[0]);
				
				System.out.println(String.format("fieldName: %s / fieldValue: %s", fieldName, fieldValue));

				if (isMemberLowerCase) {
					fieldName = fieldName.toLowerCase();
				}

				map.put(fieldName, fieldValue);
			}
			members.add(map);
			System.out.println("----------------------------------------------");

		}
	}
	
	public static void main(String[] args) {
		
		/*
		String[][] data = new String[][] { 
				{ "COL1", "COL2", "COL3", "COL4" },
				{ "DATA11", "DATA12", "DATA13", "DATA14" },
				{ "DATA21", "DATA22", "DATA23", "DATA24" },
				{ "DATA31", "DATA32", "DATA33", "DATA34" },
				{ "DATA41", "DATA42", "DATA43", "DATA44" },
				{ "DATA51", "DATA52", "DATA53", "DATA54" }
		};
		*/
		
		/*
		ArrayList<DataInfo> list = new ArrayList<>();
		
		list.add(new DataInfo(123, "namae", "BC123"));
		list.add(new DataInfo(111, "namae1", "BC111"));
		list.add(new DataInfo(222, "namae2", "BC222"));
		list.add(new DataInfo(333, "namae3", "BC333"));
		list.add(new DataInfo(444, "namae4", "BC444"));
		
		String[] members = {"id", "name", "book_code"};
		String[] cell_headers = {"아이디", "이름", "책코드"};
		int[] cell_width = {50, 60, 60};
		*/
		
		ArrayList<DataVO> list = new ArrayList<>();
		
		list.add(new HumanVO("123", "홍길동", 10));
		list.add(new HumanVO("456", "길라임", 15));
		list.add(new HumanVO("789", "장보리", 12));
		
		String[] members = {"jumin", "name", "age"};
		String[] cell_headers = {"주민번호", "이름", "나이"};
		int[] cell_width = {50, 60, 30};

		try {
			simpleExcelWrite(new File("D:/test.xls"), list, members, cell_headers, cell_width);
			
			simpleExcelRead(new File("D:/test.xls"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//[출처] 자바<JAVA> JXL 이용하여 엑셀에 쓰기 초간단 예제|작성자 달빛 
	} 

}
