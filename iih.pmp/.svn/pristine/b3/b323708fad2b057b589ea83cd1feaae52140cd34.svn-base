package iih.pmp.pay.cmbc.bill.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.pmp.pay.billcheckrst.d.BillCheckRstDO;
import iih.pmp.pay.billcheckrst.i.IBillcheckrstCudService;
import iih.pmp.pay.billcheckrst.i.IBillcheckrstRService;
import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.channelbill.i.IChannelbillRService;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.ordqryrstdto.d.BillQryReqDTO;
import iih.pmp.pay.ordqryrstdto.d.BillQryRstDTO;
import iih.pmp.pay.ordqryrstdto.d.CmbcBillTypeEnum;
import iih.pmp.pay.ordreqdto.d.CmbcSceneEnum;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.wxpay.cmbc.Config;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class CmbcBillFeeQryExcutorBP {

	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public BillCheckRstDO[] exec(BillQryReqDTO[] dtos,String billtype) throws BizException {
		if(dtos==null||dtos.length==0)return null;
		IChannelbillRService _rservice=ServiceFinder.find(IChannelbillRService.class);
		IChannelbillitemRService _itemrrservice=ServiceFinder.find(IChannelbillitemRService.class);
		IBillcheckrstRService _rstservice=ServiceFinder.find(IBillcheckrstRService.class);
		IBillcheckrstCudService _rstcudservice=ServiceFinder.find(IBillcheckrstCudService.class);
		String mechno= Config.getProperty("merchantNo");
		List<BillCheckRstDO> rntlist=new ArrayList<>();
		List<BillCheckRstDO> dellist=new ArrayList<>();
		for (BillQryReqDTO b : dtos) {
			if(!billtype.equals(b.getBill_type())||!PmpPayConst.CMBC_CHANNEL_CODE.equals(b.getSd_chl()))continue;
			 String dt=pmputils.getTransDate(b.getDt_bill(), "yyyy-MM-dd");
			 String dtend=pmputils.getTransDate(b.getDt_bill().getDateAfter(1), "yyyy-MM-dd");
			 String filter=" dt_bill='"+dt+"' and bill_type='"+b.getBill_type()+"' and sd_chl='"+b.getSd_chl()+"'";
			 ChannelBillDO[] chbls=_rservice.find(filter, "", FBoolean.FALSE);
			 if(chbls==null||chbls.length==0||chbls.length>1)continue;
			 String itemf=" id_channel_bill='"+chbls[0].getId_channel_bill()+"' and appid='"+mechno+"'";
			 ChlBillItemDO[] items=_itemrrservice.find(itemf, "", FBoolean.FALSE);
			 if(items==null||items.length==0)continue;
			 FDouble sump_chl=new FDouble(0);
			 FDouble sumr_chl=new FDouble(0);
			 FDouble nump_chl=new FDouble(0);
			 FDouble numr_chl=new FDouble(0);
			 for (ChlBillItemDO t : items) {
				if("SUCCESS".equals(t.getTrade_status())) {
					sump_chl=sump_chl.add(t.getTotal_fee());
					nump_chl=nump_chl.add(1);
				}else if("REFUND".equals(t.getTrade_status())) {					
					sumr_chl=sumr_chl.add(t.getRefund_fee());
					numr_chl=numr_chl.add(1);
				}
			}
			 FDouble sump=new FDouble(0);
			 FDouble sumr=new FDouble(0);
			 FDouble nump=new FDouble(0);
			 FDouble numr=new FDouble(0);
			 TradeDO[] ts=pmputils.getTradeRService().find("dt_req>='"+dt+"' and dt_req<'"+dtend+"'  and (trade_status=1 or trade_status=4) and  Sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"'  and tradetype in("+pmputils.getCmbcSence(billtype)+")", "", FBoolean.FALSE);
			 for (TradeDO t : ts) {
				if(TradeStatusEnum.PAY_SUCCESS.equals(t.getTrade_status())) {
					sump=sump.add(t.getAmount());
					nump=nump.add(1);
				}else if(TradeStatusEnum.REFUND_SUCCESS.equals(t.getTrade_status())) {
					sumr=sumr.add(t.getAmount());
					numr=numr.add(1);
				}
			}
			
			 BillCheckRstDO rst=new BillCheckRstDO();
			 rst.setDt_bill(b.getDt_bill());
			 rst.setBill_type(b.getBill_type());
			 rst.setSd_chl(b.getSd_chl());
			 rst.setId_chl(PmpPayConst.getUdiID(PmpPayConst.CMBC_CHANNEL_CODE,PmpPayConst.CHANNEL_DOCLIST_ID));
			 rst.setChl_fee_paid(sump_chl);
			 rst.setChl_fee_refund(sumr_chl.multiply(-1));
			 rst.setChl_total_fee(sump_chl.add(sumr_chl));
			 rst.setChl_num_paid(nump_chl);
			 rst.setChl_num_refund(numr_chl);
			 rst.setFee_paid(sump);
			 rst.setFee_refund(sumr);
			 rst.setTotal_fee(sump.sub(sumr));
			 rst.setNum_paid(nump);
			 rst.setNum_refund(numr);
			 rst.setStatus(DOStatus.NEW);
			 rntlist.add(rst);
			 String rstfilter=" Dt_bill='"+dt+"' and sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"' and Bill_type='"+billtype+"'";
			 BillCheckRstDO[] cdos=_rstservice.find(rstfilter, "", FBoolean.FALSE);
			 if(cdos!=null&&cdos.length>0)
				 dellist.addAll(Arrays.asList(cdos));
		}
		_rstcudservice.delete(dellist.toArray(new BillCheckRstDO[0]));
		return _rstcudservice.save(rntlist.toArray(new BillCheckRstDO[0]));

	}
	
	
}
