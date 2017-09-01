package com.Scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Genric.BasePage;
import com.Genric.Excel;
import com.Pages.CarInsurance;

public class CarInsuranceScript  extends BasePage
{
	@Test
	public void verifySucessLogin() throws InterruptedException
	{
		String path="./Exceldata/Excel.xlsx";
		String sheet="Sheet1";
		
		
		int rowcount = Excel.getExcelRowCount(path, sheet);
		System.out.println(rowcount);
		for(int i=0;i<=rowcount;i++)
		{
			    Reporter.log("ValidLoginScript Execution started......",true);
		
				CarInsurance lp=new CarInsurance(driver);
				lp.Clickquote();
				
				
				String text = Excel.getExcelCellValue(path, sheet, i, 0);
				String text1=Excel.getExcelCellValue(path, sheet, i, 1);
				String text2=Excel.getExcelCellValue(path, sheet, i, 2);
				String text3=Excel.getExcelCellValue(path, sheet, i, 3);
				String text4=Excel.getExcelCellValue(path, sheet, i, 4);
				String text5=Excel.getExcelCellValue(path, sheet, i, 5);
				String selectcar=Excel.getExcelCellValue(path, sheet, i, 6);
				System.out.println(selectcar);
				lp.FindCar(text, text1, text2, text3, text4, text5);
				
				
				lp.selectyourcar(selectcar);
				
				
				String carfinanced=Excel.getExcelCellValue(path, sheet, i, 7);
				String carprimilaryused=Excel.getExcelCellValue(path, sheet, i, 8);
				String kilometersused=Excel.getExcelCellValue(path, sheet, i, 9);
				
				lp.driverdetails(carfinanced, carprimilaryused, kilometersused);
				
				String text7=Excel.getExcelCellValue(path, sheet, i, 10);
				lp.getmyquote(text7);
				
				Reporter.log("ValidLoginScript Execution Ended.....",true);
		
	       }
	}
}
