package util;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;

/**
 * 表格工具类
 */
public class ExcelUtil {

   

    /**
     * 将数据导出到xlsx文件中
     *
     * @param list 记录list
     * @param resp 文件输出通道
     * @return 状态
     */
    public static void writeXLSX(String fileName,List<String[]> list, HttpServletResponse response) {
        try {
            OutputStream out = response.getOutputStream();
            int columnCount = list.get(0).length;
            int rowCount = list.size();
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();
            XSSFRow row;
            String[] temp;
            for (int i = 0; i < rowCount; i++) {
                row = sheet.createRow(i);
                temp = list.get(i);
                for (int j =0 ;j<columnCount;j++) {
                	row.createCell(j).setCellValue(temp[j]);
                }
            }
            if (out != null) {
                response.setHeader("Content-disposition", "attachment; filename="+fileName+".xlsx");
                workbook.write(out);
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
