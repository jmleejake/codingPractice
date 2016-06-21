package excelTest;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import sqliteTest.DataInfo;
// EUNOK TEST 
public class OfficeUtil {
	public static ByteArrayOutputStream getExcel(List<DataInfo> dto_list,
			String[] members, String[] cell_headers, int[] cell_widths) throws Exception {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		WritableWorkbook workbook = Workbook.createWorkbook(bos);
		try {
			WritableSheet sheet = workbook.createSheet("Sheet1", 0); // 111 jmleejake

			int i = 0;

			for (String header : cell_headers) {
				sheet.setColumnView(i, cell_widths[i]);
				Label label = new Label(i++, 0, header);
				sheet.addCell(label);
			}

			int j = 0;

			for (DataInfo dto : dto_list) {
				i = 0;
				j++;

				HashMap memberFields = getMemberFields(dto, true);

				for (String member : members) {
					Label label = new Label(i++, j,
							memberFields.get(member) != null ? memberFields
									.get(member).toString() : "");
					sheet.addCell(label);
				}

			}

			workbook.write();
			workbook.close();
			
			System.out.println("Success to create Excel file");
			System.out.println("Excel size = " + bos.size() + " KB");

		} catch (Exception e) {
			throw new Exception(
					"Failed to create Excel file");
		} finally {
			if (bos != null) {
				bos.close();
			}
		}

		return bos;
	}
	
	public static HashMap<String, Object> getMemberFields(DataInfo dto, boolean isMemberLowerCase) throws Exception {
		HashMap members = new HashMap();

		if (dto != null) {
			Class c = dto.getClass();
			Method[] methods = c.getMethods();

			for (int i = 0; i < methods.length; i++) {
				String methodName = methods[i].getName();

				if ((methodName.equals("getClass"))
						|| (!methodName.subSequence(0, 3).equals("get")))
					continue;
				String fieldName = methodName.substring(3);
				Object fieldValue = methods[i].invoke(dto, new Object[0]);

				if (isMemberLowerCase) {
					fieldName = fieldName.toLowerCase();
				}

				members.put(fieldName, fieldValue);
			}

		}

		return members;
	}
}
