package iih.pmp.pay.bill.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.pmp.pay.bill.d.CheckBillParamDTO;
import iih.pmp.pay.bill.d.FailedTableEnum;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.billcheckexception.d.CheckTradeStatus;
import iih.pmp.pay.billcheckexception.i.IBillcheckexceptionCudService;
import iih.pmp.pay.billcheckexception.i.IBillcheckexceptionRService;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.BillCheckAppUtils;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GenerateCheckExceptionBP {
	
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public void Exec(FDate begin,FDate end) throws BizException{
		this.execpaid2();
		this.execrefund2();
		this.execrevoke2();
		this.execPayFail(begin, end);
		this.execRefundFail(begin, end);
		this.excOrdPayfail();
	}
	//第三方交易表查询的字段
	private final String _basesqla = "  a.trade_status atrade_status, a.Id_channel_bill_item, a.refund_fee, a.mch_refund_no,"
			+ " a.mch_trade_no,a.total_fee,a.check_rst,a.id_chl,a.sd_chl,a.tradetime, ";
	//交易表查询的字段
	private final String _basesqlb = "b.id_trade,b.amount,b.dt_req,b.trade_status,"
			+ "b.check_rst as tcheck_rst,b.ord_no bord_no ";
	//订单表查询的字段
	private final String _basesqlc ="c.id_ord,c.ord_no,c.check_rst ackeckrst,c.amount camount,c.ord_status   ";

   //支付成功时，校验第三方数据与本地数据
	private final String _basesql1 = " select "+_basesqla+_basesqlb+","+_basesqlc+
			" from pmp_chlbillitem a left join pmp_trade b on a.mch_trade_no=b.trade_no left join pmp_ord c on b.id_ord=c.id_ord ";
	//退款成功时，校验第三方数据与本地数据
	private final String _basesql2 = " select "+_basesqla+_basesqlb+" "
			+ " from pmp_chlbillitem a left join pmp_trade b on a.mch_refund_no=b.trade_no ";
	//撤销成功时，校验第三方数据和本地数据
	private final String _basesql3 = " select "+_basesqla+_basesqlb+
			"  from pmp_chlbillitem a left join pmp_trade b on a.mch_trade_no=b.trade_no ";
	
	//交易表中已支付，但是第三方后台没有记录的数据
		private final String _basesql4="  trade_no not in(select mch_trade_no from pmp_chlbillitem where trade_status='SUCCESS') and trade_status=1"+" and Sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"'";
		//交易表中已退款，但是第三方后台没有记录的数据
		private final String _basesql5="   trade_no not in(select mch_refund_no from pmp_chlbillitem where trade_status='REFUND') and trade_status=4"+" and Sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"'";
		//订单表中交易成功，但是交易表中没有对应的记录
		private final String _basesql6="   id_ord not in(select id_ord from pmp_trade where trade_status=1) and ord_status=1 and sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"'";
	IBillcheckexceptionRService _rservice = ServiceFinder
			.find(IBillcheckexceptionRService.class);
	IBillcheckexceptionCudService _cudservice = ServiceFinder
			.find(IBillcheckexceptionCudService.class);
	
	public List<CheckBillParamDTO> getpaiddata() throws BizException{
      DAFacade da = new DAFacade();
		
		return (List<CheckBillParamDTO>) da.execQuery(_basesql1
				+ " where a.trade_status='SUCCESS'"+" and a.sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"'", new BeanListHandler(CheckBillParamDTO.class));
	}
	public List<CheckBillParamDTO> getpaiddata(FDate begin, FDate end) throws BizException{
	      DAFacade da = new DAFacade();			
			return (List<CheckBillParamDTO>) da.execQuery(_basesql1
					+ " where a.trade_status='SUCCESS'"+" and a.sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"' "+ " and "
							+ BillCheckAppUtils.getTimeSpanSql(begin, end, "a."+ChlBillItemDO.TRADETIME), new BeanListHandler(CheckBillParamDTO.class));
		}
	
public void execpaid2() throws BizException {
		

		List<String> tradenolist = new ArrayList<String>();
        List<String>revokelist=new ArrayList<String>();
        HashMap<String,CheckBillParamDTO>revokemap=new HashMap<String, CheckBillParamDTO>();
		List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();		
		List<CheckBillParamDTO>rst=this.getpaiddata();
		if (rst != null&&rst.size()>0) {
			for (CheckBillParamDTO p : rst) {
				tradenolist.add(p.getMch_trade_no());
				if(p.getId_trade()!=null){
					boolean istaequal = pmputils.isDoubleEq(p.getTotal_fee().toDouble(),
							p.getAmount().toDouble());
					if (!istaequal) {
						// 生成异常数据
						BillCheckExceptionDO b1 = null;
						p.setIs_amaout_ckecked(FBoolean.FALSE);
						p.setIs_status_checked(FBoolean.FALSE);
						p.setFailed_table(FailedTableEnum.TRADE);
						p.setTrade_type(CheckTradeStatus.PAY);
						b1=this.createExceptionDO(p);
						exclist.add(b1);
					} else if (p.getTrade_status() != TradeStatusEnum.PAY_SUCCESS&&p.getTrade_status()!=TradeStatusEnum.TURN_REFUND) {
						// 生成异常数据
						if(p.getTrade_status()==TradeStatusEnum.REVOKED){
							revokelist.add(p.getMch_trade_no());
							revokemap.put(p.getMch_trade_no(), p);
							continue;
						}

						BillCheckExceptionDO b1 = null;
						p.setIs_amaout_ckecked(FBoolean.TRUE);
						p.setIs_status_checked(FBoolean.FALSE);
						p.setFailed_table(FailedTableEnum.TRADE);
						p.setTrade_type(CheckTradeStatus.PAY);
						b1=this.createExceptionDO(p);
						exclist.add(b1);
					}
					
					if (p.getId_ord() != null) {
						boolean isordequal = pmputils.isDoubleEq(
								p.getTotal_fee().toDouble(), p.getCamount().toDouble());
						if (!isordequal) {
							// 生成异常数据
							BillCheckExceptionDO b1 = null;
							p.setIs_amaout_ckecked(FBoolean.FALSE);
							p.setIs_status_checked(FBoolean.FALSE);
							p.setFailed_table(FailedTableEnum.ORDER);
							p.setTrade_type(CheckTradeStatus.PAY);
							b1=this.createExceptionDO(p);
							exclist.add(b1);
						} else if (p.getOrd_status() != OrdStatusEnum.PAID&&p.getTrade_status()!=TradeStatusEnum.TURN_REFUND) {
							// 生成异常数据
							BillCheckExceptionDO b1 = null;
							p.setIs_amaout_ckecked(FBoolean.TRUE);
							p.setIs_status_checked(FBoolean.FALSE);
							p.setFailed_table(FailedTableEnum.ORDER);
							p.setTrade_type(CheckTradeStatus.PAY);
							b1=this.createExceptionDO(p);
							exclist.add(b1);
						}
					} else {
						// 交易表单边数据
						BillCheckExceptionDO b1 = null;
						p.setIs_amaout_ckecked(FBoolean.FALSE);
						p.setIs_status_checked(FBoolean.FALSE);
						p.setFailed_table(FailedTableEnum.TRADE);
						p.setTrade_type(CheckTradeStatus.PAY);
						b1=this.createExceptionDO(p);
						exclist.add(b1);
					}
				} else {
					// 渠道表单边数据
					BillCheckExceptionDO b1 = null;
					p.setIs_amaout_ckecked(FBoolean.FALSE);
					p.setIs_status_checked(FBoolean.FALSE);
					p.setFailed_table(FailedTableEnum.CHLBILLITEM);
					p.setTrade_type(CheckTradeStatus.PAY);
					b1=this.createExceptionDO(p);
					exclist.add(b1);
				}
			}
			
			if(revokelist.size()>0)
			this.HandleRevokedData2(exclist, revokelist, revokemap);

			// 删除旧数据
			if(tradenolist.size()>0)
			_cudservice.delete(_rservice.find(
					" trade_no in(" + this.getCondition(tradenolist)
							+ ") and Trade_type=" + CheckTradeStatus.PAY, "",
					FBoolean.FALSE));
			_cudservice.save(exclist.toArray(new BillCheckExceptionDO[0]));
		}
	}
	

	private String getCondition(List<String> rst) {
		StringBuilder sb = new StringBuilder();
		for (String s : rst) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append("'" + s + "'");
		}
		return sb.toString();
	}

	
	
	private void HandleRevokedData2(List<BillCheckExceptionDO> exclist,List<String>tralist,HashMap<String, CheckBillParamDTO> m) throws BizException{
		 IChannelbillitemRService _itemrservice=ServiceFinder.find(IChannelbillitemRService.class);
		 ChlBillItemDO[] items=_itemrservice.find(ChlBillItemDO.MCH_TRADE_NO+" in ("+this.getCondition(tralist)+") and trade_status='REVOKED'", "", FBoolean.FALSE);
		 Map<String,ChlBillItemDO> chlm=this.getBillMap(items);
		 for (String s : tralist) {
			 CheckBillParamDTO p=m.get(s);
			if(!chlm.containsKey(s)){
			
			BillCheckExceptionDO b1 = null;
			p.setIs_amaout_ckecked(FBoolean.TRUE);
			p.setIs_status_checked(FBoolean.FALSE);
			p.setFailed_table(FailedTableEnum.TRADE);
			p.setTrade_type(CheckTradeStatus.PAY);
			b1=this.createExceptionDO(p);
			exclist.add(b1);
			}
		}
	}
	private Map<String,ChlBillItemDO> getBillMap(ChlBillItemDO[] items){
		Map<String,ChlBillItemDO>m=new HashMap<>();
		for (ChlBillItemDO o : items) {
			m.put(o.getMch_trade_no(), o);
		}
		return m;
	}
	
	//CheckBillParamDTO
	
	private BillCheckExceptionDO createExceptionDO(CheckBillParamDTO dto) {
		BillCheckExceptionDO newdata = new BillCheckExceptionDO();
		newdata.setId_billitem(dto.getId_channel_bill_item());
		newdata.setId_trade(dto.getId_trade());
		newdata.setId_ord(dto.getId_ord());
		newdata.setTrade_no(dto.getMch_trade_no());
		newdata.setDt_req(dto.getDt_req());
		newdata.setOrd_no(dto.getOrd_no()==null?dto.getBord_no():dto.getOrd_no());
       newdata.setId_chl(dto.getId_chl());
       newdata.setSd_chl(dto.getSd_chl());
		newdata.setFailed_table(dto.getFailed_table());
		newdata.setIs_amaout_ckecked(dto.getIs_amaout_ckecked());
		newdata.setIs_status_checked(dto.getIs_status_checked());
		newdata.setCheckresult(this.getcheckrst(dto));
		newdata.setTrade_type(dto.getTrade_type());
		newdata.setRefund_trade_no(dto.getMch_refund_no());
		newdata.setTradetime(dto.getTradetime());
		newdata.setStatus(DOStatus.NEW);
		return newdata;
	}
	
	private Integer getcheckrst(CheckBillParamDTO dto){
		if(FailedTableEnum.CHLBILLITEM.equals(dto.getFailed_table())){
			return dto.getCheck_rst();
		}else if(FailedTableEnum.ORDER.equals(dto.getFailed_table())){
			return dto.getAckeckrst();
		}else if(FailedTableEnum.TRADE.equals(dto.getFailed_table())){
			return dto.getTcheck_rst();
		}
		return null;
	}

	public void execrefund2() throws BizException {

		List<String> tradenolist = new ArrayList<String>();
		List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();
		DAFacade da = new DAFacade();		
		List<CheckBillParamDTO>rst=(List<CheckBillParamDTO>) da.execQuery(_basesql2
				+ " where a.trade_status='REFUND'"+" and a.sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"'", new BeanListHandler(CheckBillParamDTO.class));
		if (rst != null&&rst.size()>0) {
			for (CheckBillParamDTO p : rst) {
				tradenolist.add(p.getMch_refund_no());
				if(p.getId_trade()!=null){
					boolean istaequal = pmputils.isDoubleEq(p.getRefund_fee().toDouble(),
							p.getAmount().toDouble());
					if (!istaequal) {
						// 生成异常数据
						BillCheckExceptionDO b1 = null;
						p.setIs_amaout_ckecked(FBoolean.FALSE);
						p.setIs_status_checked(FBoolean.FALSE);
						p.setFailed_table(FailedTableEnum.TRADE);
						p.setTrade_type(CheckTradeStatus.REFUND);
						b1=this.createExceptionDO(p);
						exclist.add(b1);
					} else if (p.getTrade_status() != TradeStatusEnum.REFUND_SUCCESS) {
						// 生成异常数据
						
						BillCheckExceptionDO b1 = null;
						p.setIs_amaout_ckecked(FBoolean.TRUE);
						p.setIs_status_checked(FBoolean.FALSE);
						p.setFailed_table(FailedTableEnum.TRADE);
						p.setTrade_type(CheckTradeStatus.REFUND);
						b1=this.createExceptionDO(p);
						exclist.add(b1);
					}
				}else{
					// 渠道表单边数据

					BillCheckExceptionDO b1 = null;
					p.setIs_amaout_ckecked(FBoolean.FALSE);
					p.setIs_status_checked(FBoolean.FALSE);
					p.setFailed_table(FailedTableEnum.CHLBILLITEM);
					p.setTrade_type(CheckTradeStatus.REFUND);
					b1=this.createExceptionDO(p);
					exclist.add(b1);
				}
			}		
			// 删除旧数据
			if(tradenolist.size()>0)
			_cudservice.delete(_rservice.find(
					" refund_trade_no in(" + this.getCondition(tradenolist)
							+ ") and Trade_type=" + CheckTradeStatus.REFUND,
					"", FBoolean.FALSE));
			_cudservice.save(exclist.toArray(new BillCheckExceptionDO[0]));
		}
	}

	public void execrevoke2() throws BizException {

		List<String> tradenolist = new ArrayList<String>();
		List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();
		DAFacade da = new DAFacade();

		List<CheckBillParamDTO>rst=(List<CheckBillParamDTO>) da.execQuery(_basesql3
				+ " where a.trade_status='REVOKED'"+" and a.Sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"'", new BeanListHandler(CheckBillParamDTO.class));
		if (rst != null&&rst.size()>0) {
			for (CheckBillParamDTO p : rst) {
				if(p.getId_trade()!=null){
					boolean istaequal = pmputils.isDoubleEq(p.getRefund_fee().toDouble(),
							p.getAmount().toDouble());
					if (!istaequal) {
						// 生成异常数据
	
						BillCheckExceptionDO b1 = null;
						p.setIs_amaout_ckecked(FBoolean.FALSE);
						p.setIs_status_checked(FBoolean.FALSE);
						p.setFailed_table(FailedTableEnum.TRADE);
						p.setTrade_type(CheckTradeStatus.REVOKE);
						b1=this.createExceptionDO(p);
						exclist.add(b1);
					} else if (p.getTrade_status() != TradeStatusEnum.REVOKED) {
						// 生成异常数据
						BillCheckExceptionDO b1 = null;
						p.setIs_amaout_ckecked(FBoolean.TRUE);
						p.setIs_status_checked(FBoolean.FALSE);
						p.setFailed_table(FailedTableEnum.TRADE);
						p.setTrade_type(CheckTradeStatus.REVOKE);
						b1=this.createExceptionDO(p);
						exclist.add(b1);
					}

				}else{
					BillCheckExceptionDO b1 = null;
					p.setIs_amaout_ckecked(FBoolean.FALSE);
					p.setIs_status_checked(FBoolean.FALSE);
					p.setFailed_table(FailedTableEnum.CHLBILLITEM);
					p.setTrade_type(CheckTradeStatus.REVOKE);
					b1=this.createExceptionDO(p);
					exclist.add(b1);
				}
				}
			
		
			// 删除旧数据
			if(tradenolist.size()>0)
			_cudservice.delete(_rservice.find(
					" trade_no in(" + this.getCondition(tradenolist)
							+ ") and Trade_type=" + CheckTradeStatus.REFUND,
					"", FBoolean.FALSE));
			_cudservice.save(exclist.toArray(new BillCheckExceptionDO[0]));
		}
	}	
	
	public void execPayFail(FDate begin,FDate end) throws BizException{
		List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();
		List<String> tradenolist = new ArrayList<String>();
		String sql=_basesql4+" and "+BillCheckAppUtils.getTimeSpanSql(begin, end, TradeDO.DT_REQ);
		TradeDO[] items=pmputils.getTradeRService().find(sql, "", FBoolean.FALSE);
		for (TradeDO t : items) {
			tradenolist.add(t.getTrade_no());
			BillCheckExceptionDO b1=this.createExceptionDO(t, CheckTradeStatus.PAYFAIL);
			exclist.add(b1);
		}
		// 删除旧数据
		if(tradenolist.size()>0)
					_cudservice.delete(_rservice.find(
							" trade_no in(" + this.getCondition(tradenolist)
									+ ") and Trade_type=" + CheckTradeStatus.PAYFAIL, "",
							FBoolean.FALSE));
					_cudservice.save(exclist.toArray(new BillCheckExceptionDO[0]));
	}
	
	public void execRefundFail(FDate begin,FDate end) throws BizException{
		List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();
		List<String> tradenolist = new ArrayList<String>();
		String sql=_basesql5+" and "+BillCheckAppUtils.getTimeSpanSql(begin, end, TradeDO.DT_REQ);
		TradeDO[] items=pmputils.getTradeRService().find(sql, "", FBoolean.FALSE);
        for (TradeDO t : items) {
        	tradenolist.add(t.getTrade_no());
        	BillCheckExceptionDO b1=this.createExceptionDO(t, CheckTradeStatus.REFUNDFAIL);
        	exclist.add(b1);
		}
     // 删除旧数据
        if(tradenolist.size()>0)
		_cudservice.delete(_rservice.find(
				" refund_trade_no in(" + this.getCondition(tradenolist)
						+ ") and Trade_type=" + CheckTradeStatus.REFUNDFAIL, "",
				FBoolean.FALSE));
		_cudservice.save(exclist.toArray(new BillCheckExceptionDO[0]));
	}

	
	
	public void excOrdPayfail() throws BizException{
		List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();
		List<String> ordnolist = new ArrayList<String>();
		OrdDO[] items=pmputils.getOrdRService().find(_basesql6, "", FBoolean.FALSE);
		for (OrdDO o : items) {

			ordnolist.add(o.getId_ord());
        	BillCheckExceptionDO b1=this.createExceptionDO(o);
        			exclist.add(b1);
		}
		
		 // 删除旧数据
		if(ordnolist.size()>0)
		_cudservice.delete(_rservice.find(
				" id_ord in(" + this.getCondition(ordnolist)
						+ ") and Trade_type=" + CheckTradeStatus.ORDPAYFAIL, "",
				FBoolean.FALSE));
		_cudservice.save(exclist.toArray(new BillCheckExceptionDO[0]));
	}

	
	private BillCheckExceptionDO createExceptionDO(OrdDO dto) {
		BillCheckExceptionDO newdata = new BillCheckExceptionDO();
		newdata.setId_billitem(null);
		newdata.setId_trade(null);
		newdata.setId_ord(dto.getId_ord());
		newdata.setTrade_no(null);
		newdata.setDt_req(dto.getDt_ord());
		newdata.setOrd_no(dto.getOrd_no());
       newdata.setId_chl(dto.getId_chl());
       newdata.setSd_chl(dto.getSd_chl());
		newdata.setFailed_table(FailedTableEnum.ORDER);
		newdata.setIs_amaout_ckecked(FBoolean.FALSE);
		newdata.setIs_status_checked(FBoolean.FALSE);
		newdata.setCheckresult(dto.getCheck_rst());
		newdata.setTrade_type(CheckTradeStatus.ORDPAYFAIL);
		newdata.setRefund_trade_no(null);
		newdata.setTradetime(dto.getDt_ord());
		newdata.setStatus(DOStatus.NEW);
		return newdata;
	}
	
	private BillCheckExceptionDO createExceptionDO(TradeDO dto,int chs) {
		BillCheckExceptionDO newdata = new BillCheckExceptionDO();
		newdata.setId_billitem(null);
		newdata.setId_trade(dto.getId_trade());
		newdata.setId_ord(dto.getId_ord());
		newdata.setTrade_no(chs==CheckTradeStatus.PAYFAIL?dto.getTrade_no():dto.getTrade_no_rel());
		newdata.setDt_req(dto.getDt_req());
		newdata.setOrd_no(dto.getOrd_no());
       newdata.setId_chl(dto.getId_chl());
       newdata.setSd_chl(dto.getSd_chl());
		newdata.setFailed_table(FailedTableEnum.TRADE);
		newdata.setIs_amaout_ckecked(FBoolean.FALSE);
		newdata.setIs_status_checked(FBoolean.FALSE);
		newdata.setCheckresult(dto.getCheck_rst());
		newdata.setTrade_type(CheckTradeStatus.PAYFAIL);
		newdata.setRefund_trade_no(chs==CheckTradeStatus.PAYFAIL?null:dto.getTrade_no());
		newdata.setTradetime(dto.getDt_req());
		newdata.setStatus(DOStatus.NEW);
		return newdata;
	}
	
}
