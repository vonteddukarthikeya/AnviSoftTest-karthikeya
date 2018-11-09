package Maven.AnviSoftTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// For Excel common method
public class ExcelAPI 
{

	public FileInputStream fis=null;
	public FileOutputStream fos=null;
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	String xfilePath;
	
	public ExcelAPI(String xfilePath) throws Exception 
	{
		this.xfilePath=xfilePath;
		fis=new FileInputStream(xfilePath);
		workbook=new XSSFWorkbook(fis);
		fis.close();
	}

	public int getRowCount(String sheetName)
	{
		sheet= workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum()+1;
		return rowCount;
	}
	
	public int columnCount(String sheetName)
	{
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(0);
		int colCount = row.getLastCellNum();
		return colCount;
	}
	
	
//Reading cell data from Excel by using Column Name
	public String getCellData(String sheetName,String colName,int rowNum)
	{
		try
		{
			int colNum=-1;
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum=i;
			}
			
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			
			if(cell.getCellTypeEnum()==CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA)
			{
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					DateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
					Date date=cell.getDateCellValue();
					cellValue=dt.format(date);	
				}
				return cellValue;
			}
			else if(cell.getCellTypeEnum()==CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "No matching value";
		}
		
		
	}
		

}
