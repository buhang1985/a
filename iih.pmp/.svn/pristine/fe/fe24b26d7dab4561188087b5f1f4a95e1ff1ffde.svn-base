package iih.pmp.pay.bill.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.channelbill.i.IChannelbillRService;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemCudService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.udi.PmpPayConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class AlipayGenerateBillItemBP {
	
	public void exec() throws BizException {
		
		IChannelbillRService _rservice = ServiceFinder.find(IChannelbillRService.class);
		ChannelBillDO[] chls = _rservice.find(" id_chl='" + PmpPayConst.getUdiID(PmpPayConst.ALIPAY_CHANNEL_CODE, PmpPayConst.CHANNEL_DOCLIST_ID) + "'", "", FBoolean.FALSE);
		
		for (int i = 0; i < chls.length; i++) {
			ChannelBillDO bill = chls[i];
			String billdata = bill.getBill_content();
			if (StringUtil.isEmpty(billdata))
				continue;
			List<HashMap<String, String>> mrnt = parseCsv(billdata);
			List<ChlBillItemDO> itemlist = new ArrayList<>();
			if ("Y".equals(bill.getIs_checked()))
				continue;
			for (int j = 1; j < mrnt.size(); j++) {
				ChlBillItemDO b = new ChlBillItemDO();
				HashMap<String, String> d = mrnt.get(j);
				b.setTradetime(new FDateTime(d.get("创建时间")));
				b.setChanneltradeno(d.get("支付宝交易号"));
				b.setMch_trade_no(d.get("商户订单号"));
				b.setTotal_fee(new FDouble(Double.parseDouble(d.get("订单金额（元）"))));
				b.setMch_refund_no(d.get("退款批次号/请求号"));
				b.setProduct_name(d.get("商品名称"));
				b.setId_chl(bill.getId_chl());
				b.setId_channel_bill(bill.getId_channel_bill());
				b.setSd_chl(bill.getSd_chl());
				b.setStatus(DOStatus.NEW);
				itemlist.add(b);
			}
			
			 IChannelbillitemCudService _itemservice = ServiceFinder.find(IChannelbillitemCudService.class);
			 IChannelbillitemRService _itemrservice = ServiceFinder.find(IChannelbillitemRService.class);
			 _itemservice.delete(_itemrservice.find(" Id_channel_bill= '" + bill.getId_channel_bill() + "'", "", FBoolean.FALSE));
			 _itemservice.save(itemlist.toArray(new ChlBillItemDO[0]));
		}
	}
	
	private List<HashMap<String, String>> parseCsv(String csv) {
		
		List<HashMap<String, String>> r = new ArrayList<HashMap<String, String>>();
		String[] a = csv.split("\\|");
		if (a.length == 10)
			return null;
		int k = a.length - 10;
		String[] header = a[5].split(",");
		for (int i = 6; i < 6 + k; i++) {
			HashMap<String, String> c = new HashMap<String, String>();
			String[] t = a[i].split(",");
			if (t.length != header.length) {
				List<String> u = new ArrayList<>();
				for (String e : t) {
					u.add(e);
				}
				u.add("");
				t = u.toArray(new String[0]);
			}
			for (int j = 0; j < header.length; j++) {
				c.put(header[j], t[j]);
			}
			r.add(c);
		}
		
		return r;
	}
}
