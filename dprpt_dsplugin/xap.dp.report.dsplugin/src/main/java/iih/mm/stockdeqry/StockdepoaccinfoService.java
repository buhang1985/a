package iih.mm.stockdeqry;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.utils.StringUtil;

public class StockdepoaccinfoService {
	
	public List<StockDepoAccView> getDataList(String id_wh,String id_mm,String date_busi,String date_busiend) throws Exception{
		if(StringUtil.isEmpty(id_mm) || StringUtil.isEmpty(id_wh) ||"".equals(date_busi)||"".equals(date_busiend)||date_busi.equals(null)||date_busiend.equals(null)){			
			return null;
		}
		StockdepoaccinfoBp bp = new StockdepoaccinfoBp();
		List<StockDepoAccView> list = new ArrayList<StockDepoAccView>();
		List<StockDepoAccView>  mminiList = bp.getMmIniresult(id_wh,id_mm,date_busi,date_busiend);
		List<StockDepoAccView>  accList = bp.getAccresult(id_wh,id_mm,date_busi,date_busiend);
		if (mminiList != null && mminiList.size() >0 ) {
			list.addAll(mminiList);
		}
		if (accList != null && accList.size() >0 ) {
			bp.exec(accList,date_busi);
			list.addAll(accList);
		} else {
			StockDepoAccView busiDateAccView = bp.getBusiDateResult(id_wh,id_mm,date_busi,date_busiend);
			list.add(busiDateAccView);
		}
		return list;
	}
}
