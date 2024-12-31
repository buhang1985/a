package iih.bd.srv.doctorprint.ref;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 * @code 获取本地控制面板上的所有打印机名称
 * @author LiYue
 * @date 2019年7月22日,下午5:48:36
 */
public class CiPrinterRefModel {

	
	public List<String> getRefSql() {

		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.PNG;
		//可用的打印机列表(字符串数组)
		PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		ArrayList<String> printerNameList = new ArrayList<>();
		for (PrintService pri : printService) {
			printerNameList.add(pri.getName());
		}
		return printerNameList;
	}
	
	public static void main(String[] args) {
		CiPrinterRefModel a = new CiPrinterRefModel();
		a.getRefSql();
	}
}
