package iih.bd.srv.medsrv.refs;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class OrPrinterRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	// 01:拼音码,10:五笔码,11:五笔码和拼音码,默认使用拼音码
	private String sd_inputmethod = "";
	// 0 医保适应症医保限制条件提示信息 ，1 医保适应症 院内限制提示信息 ，2 医保适应症 医保限制+院内限制 信息
	private String sd_hpinfomode = "";
	// 匹配模式，1左匹配，2右匹配，3全匹配
	private String matchModel = "";
	//
	private String eu_srvtp = "";

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "Printer"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "Id_printer" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "打印机" };
	}

	@Override
	public String getPkFieldCode() {
		return "Id_printer";
	}

	@Override
	public String getRefCodeField() {
		return "Id_printer";
	}

	@Override
	public String getRefNameField() {
		return "Printer";
	}
	@Override
	public RefResultSet getRefData() {
	
		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
		// 可用的打印机列表(字符串数组)
		PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		List<List<Object>> allPrinters= new ArrayList<>();
		for (PrintService printService2 : printService) {
			List<Object> printerList = new ArrayList<>();
			printerList.add(printService2.getName());
			allPrinters.add(printerList);
		}
		RefResultSet result = new RefResultSet();
		result.setData(allPrinters);
		if (allPrinters != null) {
			result.setTotalCount(allPrinters.size());
		}

		return result;
	}
	 public RefResultSet getRefData(PaginationInfo pg) {
		 PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
			// 可用的打印机列表(字符串数组)
			PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
			List<List<Object>> allPrinters= new ArrayList<>();
			for (PrintService printService2 : printService) {
				List<Object> printerList = new ArrayList<>();
				printerList.add(printService2.getName());
				allPrinters.add(printerList);
			}
			RefResultSet result = new RefResultSet();
			result.setData(allPrinters);
			if (allPrinters != null) {
				result.setTotalCount(allPrinters.size());
			}

			 if(pg != null && pg.getPageIndex() != 0) {
					if (allPrinters != null) {
						result.setTotalCount(allPrinters.size());
						allPrinters= new ArrayList<>();
						result.setData(allPrinters);
					};
			 }
			return result;
	 }
	public RefResultSet filterRefPks(String[] filterPks) {
		return null;
	}
	
}
