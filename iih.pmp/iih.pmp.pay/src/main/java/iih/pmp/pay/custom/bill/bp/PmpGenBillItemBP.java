package iih.pmp.pay.custom.bill.bp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemCudService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存对账单明细到本地数据库
 * 
 * @author li_cheng
 *
 */
public class PmpGenBillItemBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	IPmpSdk pay;
	IPmpDataconvert dataconvert;

	public PmpGenBillItemBP(IPmpSdk pay1,IPmpDataconvert dataconvert1) {

		pay = pay1;
		dataconvert = dataconvert1;
	}

	public void GenerateBillItem(BillCheckExceptionDO dto) throws BizException {

		if (!PmpPayAppUtils.getCurrentChl().equals(dto.getSd_chl()))
			return;
		IChannelbillitemCudService _itemservice = ServiceFinder.find(IChannelbillitemCudService.class);
		IChannelbillitemRService _itemrrservice = ServiceFinder.find(IChannelbillitemRService.class);
		List<Map<String, Object>> plist = dataconvert.getBillItemParam(dto.getDt_req().getDate());
		if (plist != null && plist.size() > 0) {
			List<ChlBillItemDO> itemlist=new ArrayList<ChlBillItemDO>();
			for (int j = 0; j < plist.size(); j++) {
				String[] rst = pay.getBillContent(plist.get(j));
				if (rst != null && rst.length > 0) {
					List<ChlBillItemDO> items = new ArrayList<ChlBillItemDO>();
					if(rst.length==0)continue;
					for (int i = 0; i < rst.length; i++) {
						if(pmputils.isStrEmpty(rst[i]))continue;
						ChlBillItemDO o = dataconvert.str2BillItem(rst[i],dto.getSd_chl(),dto.getDt_req().getDate(),plist.get(j));
						if(o!=null) {
						o.setStatus(DOStatus.NEW);
						items.add(o);
						}
					}		
					itemlist.addAll(items);
				}
			}
			
			ChlBillItemDO[] rnt = _itemrrservice.find(" Sd_chl='" + dto.getSd_chl() + "' and (("
					+ pmputils.getTimeSpanSql("tradetime", dto.getDt_req().getDate())
					+ ") or tradetime is null) ", "", FBoolean.FALSE);
			_itemservice.delete(rnt);
			_itemservice.save(itemlist.toArray(new ChlBillItemDO[0]));
		}
	}
}
