package iih.pmp.pay.cmbc.bill.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.pmp.pay.bill.d.CheckBillParamDTO;
import iih.pmp.pay.bill.d.FailedTableEnum;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.billcheckexception.d.CheckTradeStatus;
import iih.pmp.pay.billcheckexception.i.IBillcheckexceptionCudService;
import iih.pmp.pay.billcheckexception.i.IBillcheckexceptionRService;
import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.cmbc.s.bp.CmbcPayBP;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.trade.d.BillChekRst;
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
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class CmbcGenExcDOBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	String mechno= Config.getProperty("merchantNo");
	//第三方交易表查询的字段
		private final String _basesqla = "  a.trade_status atrade_status, a.Id_channel_bill_item, a.refund_fee, a.mch_refund_no,"
				+ " a.mch_trade_no,a.total_fee,a.check_rst,a.id_chl,a.sd_chl,a.tradetime,a.channeltradeno, ";
		//交易表查询的字段
		private final String _basesqlb = "b.id_trade,b.amount,b.dt_req,b.trade_status,"
				+ "b.check_rst as tcheck_rst,b.ord_no bord_no,b.trade_no ";
		//订单表查询的字段
		private final String _basesqlc ="c.id_ord,c.ord_no,c.check_rst ackeckrst,c.amount camount,c.ord_status   ";
		
		//支付成功时，校验第三方数据与本地数据
		private final String _basesql1 = " select "+_basesqla+_basesqlb+","+_basesqlc+
				" from pmp_chlbillitem a left join pmp_trade b on a.banktradeno=b.banktradeno left join pmp_ord c on b.id_ord=c.id_ord ";
//		//退款成功时，校验第三方数据与本地数据
//		private final String _basesql2 = " select "+_basesqla+_basesqlb+" "
//				+ " from pmp_chlbillitem a left join pmp_trade b on a.channeltradeno=b.trade_no_chl ";
		
//		//交易表中已支付，但是第三方后台没有记录的数据
//		private final String _basesql4="  (sd_ord) not in(select mch_trade_no from pmp_chlbillitem where trade_status='SUCCESS') and trade_status=1"+" and Sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"' and tradetype='"+CmbcSceneEnum.WXSCAN+"'";
//		//交易表中已退款，但是第三方后台没有记录的数据
//		private final String _basesql5="   (sd_ord) not in(select mch_refund_no from pmp_chlbillitem where trade_status='REFUND') and trade_status=4"+" and Sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"'  and tradetype='"+CmbcSceneEnum.WXSCAN+"'";
//		//订单表中交易成功，但是交易表中没有对应的记录
//		private final String _basesql6="   id_ord not in(select id_ord from pmp_trade where trade_status=1) and ord_status=1 and sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"'";
		IBillcheckexceptionRService _rservice = ServiceFinder
				.find(IBillcheckexceptionRService.class);
		IBillcheckexceptionCudService _cudservice = ServiceFinder
				.find(IBillcheckexceptionCudService.class);
		CmbcPayBP paybp=new CmbcPayBP();
		public void getchlno(ChannelBillDO chl) throws BizException{
		     
		      String start=pmputils.getTransDate(chl.getDt_bill(), "yyyy-MM-dd");
		      String end=pmputils.getTransDate(chl.getDt_bill().getDateAfter(1), "yyyy-MM-dd");
		      TradeDO[] ts=pmputils.getTradeRService().find("dt_req>='"+start+"' and dt_req<'"+end+"'  and (trade_status=1 or trade_status=4) and  ((Banktradeno is null )or Banktradeno='~') and  Sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"'  and tradetype='"+pmputils.getCmbcSence(chl.getBill_type())+"'", "", FBoolean.FALSE);
		      if(ts!=null) {
		    	  for (TradeDO t : ts) {
		    		  Map<String, String> r = paybp.orderQuery((t.getSd_ord()), t.getTrade_no());
		    		  if (r != null
		    					&& "S".equals(r
		    							.get("gateReturnType"))) {
		    			  String trade_state = r.get("tradeStatus");
		    			  if("S".equals(trade_state)) {
		    				  t.setBanktradeno(r.get("bankTradeNo"));
		    				  t.setStatus(DOStatus.UPDATED);
		    			  }
		    				  
		    		  }
				}
		    	  pmputils.getTradeCUDService().save(ts);
		      }
		}
		
		public void billcheck(ChannelBillDO chl) throws BizException {
			if(chl==null)return ;
		    String start=pmputils.getTransDate(chl.getDt_bill(), "yyyy-MM-dd");
		    String end=pmputils.getTransDate(chl.getDt_bill().getDateAfter(1), "yyyy-MM-dd");
			String filter=" Bill_type='"+chl.getBill_type()+"' and tradetime>='"+start+"' and tradetime<'"+end+"' and sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"'";
			_cudservice.delete(_rservice.find(filter, "",
					FBoolean.FALSE));
			getchlno(chl);
			exePayFail( chl);//交易表支付单边账
			exeRefundFail(chl);//交易表退款单边账
			execpaid2( chl);
		}
		
		
		public List<CheckBillParamDTO> getdata(ChannelBillDO chl) throws BizException{
		      DAFacade da = new DAFacade();
				return (List<CheckBillParamDTO>) da.execQuery(_basesql1
						+ " where  a.sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"' and a.Id_channel_bill='"+chl.getId_channel_bill()+"' and a.appid='"+mechno+"'", new BeanListHandler(CheckBillParamDTO.class));
			}
		
		public void execpaid2(ChannelBillDO chl) throws BizException {
			List<String> tradenolist = new ArrayList<String>();
			List<String> mchlist = new ArrayList<String>();
			List<CheckBillParamDTO>rst=this.getdata(chl);
			List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();	
			if (rst != null&&rst.size()>0) {
				for (CheckBillParamDTO p : rst) {
					
					if(p.getId_trade()!=null){
						tradenolist.add(p.getTrade_no());
						boolean istaequal=false;
						if(p.getAtrade_status().equals("REFUND")) {
							FDouble fee=p.getRefund_fee().multiply(-1);
							istaequal = pmputils.isDoubleEq(fee.toDouble(),
									p.getAmount().toDouble());
						}else if(p.getAtrade_status().equals("SUCCESS")) {
							istaequal = pmputils.isDoubleEq(p.getTotal_fee().toDouble(),
									p.getAmount().toDouble());
						}

						if (!istaequal) {
							// 生成异常数据
							BillCheckExceptionDO b1 = null;
							p.setIs_amaout_ckecked(FBoolean.FALSE);
							p.setIs_status_checked(FBoolean.FALSE);
							p.setFailed_table(FailedTableEnum.TRADE);
							
							if(p.getAtrade_status().equals("REFUND")) {
								p.setTrade_type(CheckTradeStatus.REFUND);
							}else if(p.getAtrade_status().equals("SUCCESS")) {
								p.setTrade_type(CheckTradeStatus.PAY);
							}
							b1=this.createExceptionDO(p,chl);
							exclist.add(b1);
						} else if ((p.getTrade_status() != TradeStatusEnum.PAY_SUCCESS&&p.getAtrade_status().equals("SUCCESS"))||(p.getTrade_status()!=TradeStatusEnum.REFUND_SUCCESS&&p.getAtrade_status().equals("REFUND"))) {
							// 生成异常数据
							BillCheckExceptionDO b1 = null;
							p.setIs_amaout_ckecked(FBoolean.TRUE);
							p.setIs_status_checked(FBoolean.FALSE);
							p.setFailed_table(FailedTableEnum.TRADE);
							if(p.getAtrade_status().equals("REFUND")) {
								p.setTrade_type(CheckTradeStatus.REFUND);
							}else if(p.getAtrade_status().equals("SUCCESS")) {
								p.setTrade_type(CheckTradeStatus.PAY);
							}
							b1=this.createExceptionDO(p,chl);
							exclist.add(b1);
						}
						
						if (p.getId_ord() != null&&p.getAtrade_status().equals("SUCCESS")) {
							boolean isordequal = pmputils.isDoubleEq(
									p.getTotal_fee().toDouble(), p.getCamount().toDouble());
							if (!isordequal) {
								// 生成异常数据
								BillCheckExceptionDO b1 = null;
								p.setIs_amaout_ckecked(FBoolean.FALSE);
								p.setIs_status_checked(FBoolean.FALSE);
								p.setFailed_table(FailedTableEnum.ORDER);
								if(p.getAtrade_status().equals("REFUND")) {
									p.setTrade_type(CheckTradeStatus.REFUND);
								}else if(p.getAtrade_status().equals("SUCCESS")) {
									p.setTrade_type(CheckTradeStatus.PAY);
								}
								b1=this.createExceptionDO(p,chl);
								exclist.add(b1);
							} else if (p.getOrd_status() != OrdStatusEnum.PAID&&p.getTrade_status()!=TradeStatusEnum.TURN_REFUND) {
								// 生成异常数据
								BillCheckExceptionDO b1 = null;
								p.setIs_amaout_ckecked(FBoolean.TRUE);
								p.setIs_status_checked(FBoolean.FALSE);
								p.setFailed_table(FailedTableEnum.ORDER);
								if(p.getAtrade_status().equals("REFUND")) {
									p.setTrade_type(CheckTradeStatus.REFUND);
								}else if(p.getAtrade_status().equals("SUCCESS")) {
									p.setTrade_type(CheckTradeStatus.PAY);
								}
								b1=this.createExceptionDO(p,chl);
								exclist.add(b1);
							}
						} else if(p.getId_ord()==null){
							// 交易表单边数据
							BillCheckExceptionDO b1 = null;
							p.setIs_amaout_ckecked(FBoolean.FALSE);
							p.setIs_status_checked(FBoolean.FALSE);
							p.setFailed_table(FailedTableEnum.TRADE);
							if(p.getAtrade_status().equals("REFUND")) {
								p.setTrade_type(CheckTradeStatus.REFUND);
							}else if(p.getAtrade_status().equals("SUCCESS")) {
								p.setTrade_type(CheckTradeStatus.PAY);
							}
							b1=this.createExceptionDO(p,chl);
							exclist.add(b1);
						}
						
				} else {
					// 渠道表单边数据
					BillCheckExceptionDO b1 = null;
					p.setIs_amaout_ckecked(FBoolean.FALSE);
					p.setIs_status_checked(FBoolean.FALSE);
					p.setFailed_table(FailedTableEnum.CHLBILLITEM);
					p.setCheck_rst(BillChekRst.CHL_ONESIDEBILL);
					if(p.getAtrade_status().equals("REFUND")) {
						p.setTrade_type(CheckTradeStatus.REFUND);
					}else if(p.getAtrade_status().equals("SUCCESS")) {
						p.setTrade_type(CheckTradeStatus.PAY);
					}
					b1=this.createExceptionDO(p,chl);
					exclist.add(b1);
					mchlist.add(p.getMch_trade_no());
				}
				}
				
				// 删除旧数据
				if(tradenolist.size()>0||mchlist.size()>0) {
					String c1=null;
					String c2=null;
					String sql=null;
					if(mchlist.size()>0) {
						c1=" Mchno in(" + this.getCondition(mchlist)+ ")";
						sql=c1;
					}
					if(tradenolist.size()>0) {
						c2=" trade_no in ("+this.getCondition(tradenolist) +")";
						if(c1!=null) {
							sql=c1+" or "+c2;
						}else {
							sql=c2;
						}
					}
					_cudservice.delete(_rservice.find(sql, "",
							FBoolean.FALSE));
				}
				
				_cudservice.save(exclist.toArray(new BillCheckExceptionDO[0]));
		}
		}
		private BillCheckExceptionDO createExceptionDO(CheckBillParamDTO dto,ChannelBillDO chl) {
			BillCheckExceptionDO newdata = new BillCheckExceptionDO();
			newdata.setId_billitem(dto.getId_channel_bill_item());
			newdata.setId_trade(dto.getId_trade());
			newdata.setId_ord(dto.getId_ord());
			newdata.setTrade_no(dto.getTrade_no());
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
			newdata.setMchno(dto.getMch_trade_no());
			newdata.setBill_type(chl.getBill_type());
			newdata.setStatus(DOStatus.NEW);
			return newdata;
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
		
		private void exePayFail(ChannelBillDO chl) throws BizException {
			List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();
			List<String> tradenolist = new ArrayList<String>();
			String start=pmputils.getTransDate(chl.getDt_bill(), "yyyy-MM-dd");
		    String end=pmputils.getTransDate(chl.getDt_bill().getDateAfter(1), "yyyy-MM-dd");
			String sql="  (sd_ord) not in(select mch_trade_no from pmp_chlbillitem where trade_status='SUCCESS' and Id_channel_bill='"+chl.getId_channel_bill()+"' and appid='"+mechno+"') and trade_status=1"+" and Sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"' and tradetype='"+pmputils.getCmbcSence(chl.getBill_type())+"'";
		    sql=sql+" and dt_req>='"+start+"' and dt_req<'"+end+"'";
		    TradeDO[] items=pmputils.getTradeRService().find(sql, "", FBoolean.FALSE);
		    for (TradeDO t : items) {
				tradenolist.add(t.getTrade_no());
				BillCheckExceptionDO b1=this.createExceptionDO(t, CheckTradeStatus.PAYFAIL,chl);
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
		
		private void exeRefundFail(ChannelBillDO chl) throws BizException {
			List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();
			List<String> tradenolist = new ArrayList<String>();
			String start=pmputils.getTransDate(chl.getDt_bill(), "yyyy-MM-dd");
		    String end=pmputils.getTransDate(chl.getDt_bill().getDateAfter(1), "yyyy-MM-dd");
			String sql="  (sd_ord) not in(select mch_trade_no from pmp_chlbillitem where trade_status='REFUND' and Id_channel_bill='"+chl.getId_channel_bill()+"' and appid='"+mechno+"') and trade_status=4"+" and Sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"' and tradetype='"+pmputils.getCmbcSence(chl.getBill_type())+"'";
		    sql=sql+" and dt_req>='"+start+"' and dt_req<'"+end+"'";
		    TradeDO[] items=pmputils.getTradeRService().find(sql, "", FBoolean.FALSE);
		    for (TradeDO t : items) {
				tradenolist.add(t.getTrade_no());
				BillCheckExceptionDO b1=this.createExceptionDO(t, CheckTradeStatus.PAYFAIL,chl);
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
		
		private BillCheckExceptionDO createExceptionDO(TradeDO dto,int chs,ChannelBillDO chl) {
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
			newdata.setBill_type(chl.getBill_type());
			newdata.setStatus(DOStatus.NEW);
			return newdata;
		}
	
}
