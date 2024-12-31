package iih.pmp.pay.custom.bill.bp;

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
import iih.pmp.pay.custom.bp.PmpPayBP;
import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.trade.d.BillChekRst;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;

public class PmpGenExceptDOBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	IPmpDataconvert dataconvert;
//	String mechno= Config.getProperty("merchantNo");
	//第三方交易表查询的字段
		private final String _basesqla = "  a.trade_status atrade_status, a.Id_channel_bill_item, a.refund_fee, a.mch_refund_no,"
				+ " a.mch_trade_no,a.total_fee,a.check_rst,a.id_chl,a.sd_chl,a.tradetime,a.channeltradeno,a.banktradeno, a.bill_type,";
		//交易表查询的字段
		private final String _basesqlb = "b.id_trade,b.amount,b.dt_req,b.trade_status,"
				+ "b.check_rst as tcheck_rst,b.ord_no bord_no,b.trade_no ";
		//订单表查询的字段
		private final String _basesqlc ="c.id_ord,c.ord_no,c.check_rst ackeckrst,c.amount camount,c.ord_status   ";
		
		//支付成功时，校验第三方数据与本地数据
		private final String _basesql1 = " select "+_basesqla+_basesqlb+","+_basesqlc+
				" from pmp_chlbillitem a left join pmp_trade b on a.banktradeno=b.banktradeno left join pmp_ord c on b.id_ord=c.id_ord ";

		IBillcheckexceptionRService _rservice = ServiceFinder
				.find(IBillcheckexceptionRService.class);
		IBillcheckexceptionCudService _cudservice = ServiceFinder
				.find(IBillcheckexceptionCudService.class);
		PmpPayBP paybp;
		public PmpGenExceptDOBP(IPmpSdk pay1,IPmpDataconvert dataconvert1) {
			paybp=new PmpPayBP(pay1,dataconvert1);
			dataconvert=dataconvert1;
		}
		public void getchlno(ChlBillItemDO chl) throws BizException{
		     
		      TradeDO[] ts=pmputils.getTradeRService().find(pmputils.getTimeSpanSql("dt_req", chl.getTradetime().getDate())+"  and (trade_status=1 or trade_status=4) and  ((Banktradeno is null )or Banktradeno='~') and  Sd_chl='"+chl.getSd_chl()+"'", "", FBoolean.FALSE);
		      updateBankTradeNO(ts);
		}
		
		private void updateBankTradeNO(TradeDO[] ts) throws BizException {
			if(ts!=null) {
		    	  StringBuilder sb=new StringBuilder();
		    	  Map<String,TradeDO> tramap=new HashMap<>();
		    	  for (TradeDO t : ts) {
		    		  if(sb.length()==0) {
		    			  sb.append("'"+t.getId_ord()+"'");
		    		  }else {
		    			  sb.append(",'"+t.getId_ord()+"'");
		    		  }
		    		  if(t.getTrade_status()==TradeStatusEnum.PAY_SUCCESS) {
		    			  tramap.put(t.getTrade_no(), t);
		    		  }
		    	  }
		    	  Map<String,OrdDO> map=new HashMap<>();
		    	  if(sb.length()>0) {
		    		  OrdDO[] ords=pmputils.getOrdRService().find(" id_ord in ("+sb.toString()+")", "", FBoolean.FALSE);
		    		  if(ords!=null&&ords.length>0) {
		    			  for (OrdDO o : ords) {
		    				  
		    				  map.put(o.getId_ord(), o);
		    			  }
		    		  }
		    	  }
		    	  for (TradeDO t : ts) {
		    		  Map<String, String> r=null;
		    		  if(PmpPayConst.TRADE_DIRECT_PAY==t.getEu_direct())
		    		  {
		    			 if(map.containsKey(t.getId_ord())) {
		    				 r = paybp.doquery(t, map.get(t.getId_ord()));
		    				 if(r!=null)
		    				 r=dataconvert.RefundQueryRntConvert(r);
		    			 }
		    		  }
		    		  if(PmpPayConst.TRADE_DIRECT_REFUND==t.getEu_direct())
		    		  {
		    			  if(map.containsKey(t.getId_ord())) {
		    				  //需要调整
			    				 r=paybp.dorefundquery(t, map.get(t.getId_ord()),tramap.get(t.getTrade_no_rel()));
			    				 if(r!=null)
			    				 r=dataconvert.QueryRntConvert(r);
			    			 }
		    		  }
//		    			  r = paybp.orderQuery((t.getSd_ord()), t.getTrade_no());
		    		  if (r != null) {
		    				if(PmpPayConst.PMP_SUCCESS.equals(r.get(PmpPayConst.PMP_RESULT))&&PmpPayConst.PMP_SUCCESS.equals(r.get(PmpPayConst.PMP_TRADE_STATUS))) {
		    				  t.setBanktradeno(r.get(PmpPayConst.PMP_TRADE_NO));
		    				  t.setStatus(DOStatus.UPDATED);
		    					}
		    				  
		    		  }
				}
		    	  pmputils.getTradeCUDService().save(ts);
		      }
		}
		
		public void billcheck(ChlBillItemDO chl) throws BizException {
			if(chl==null)return ;
			this.getRepeatBillBankTradeNo(chl);
			String filter=pmputils.getTimeSpanSql("tradetime", chl.getTradetime().getDate())+"  and sd_chl='"+chl.getSd_chl()+"'";
			_cudservice.delete(_rservice.find(filter, "",
					FBoolean.FALSE));
			getchlno(chl);
			exePayFail( chl);//交易表支付单边账
			exeRefundFail(chl);//交易表退款单边账
			execpaid2( chl);
		}
		
		
		public List<CheckBillParamDTO> getdata(ChlBillItemDO chl) throws BizException{
		      DAFacade da = new DAFacade();
				return (List<CheckBillParamDTO>) da.execQuery(_basesql1
						+ " where  a.sd_chl='"+chl.getSd_chl()+"' and "+pmputils.getTimeSpanSql("a.tradetime", chl.getTradetime().getDate())+" ", new BeanListHandler(CheckBillParamDTO.class));
			}
		
		
		
		
		public void execpaid2(ChlBillItemDO chl) throws BizException {
			List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();	
			TradeDO[] items=this.getRepeatBankTradeNo(chl);

			if(items!=null&&items.length>0) {
				for (TradeDO tradeDO : items) {
					BillCheckExceptionDO bc=this.createRepeatExceptionDO(tradeDO);
					exclist.add(bc);
				}
			}
			List<String> tradenolist = new ArrayList<String>();
			List<String> mchlist = new ArrayList<String>();
			List<CheckBillParamDTO>rst=this.getdata(chl);
			if (rst != null&&rst.size()>0) {
				for (CheckBillParamDTO p : rst) {					
					if(p.getId_trade()!=null){
						tradenolist.add(p.getTrade_no());
						boolean istaequal=false;
						if(p.getAtrade_status().equals("REFUND")) {
							FDouble fee=p.getRefund_fee();
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
						if(!p.getAtrade_status().equals("SUCCESS")&&!p.getAtrade_status().equals("REFUND")) {
//							if(p.getTrade_status() == TradeStatusEnum.PAY_SUCCESS||p.getTrade_status()==TradeStatusEnum.REFUND_SUCCESS) {
								//对账单中已撤回数据，程序中不允许撤回，所以撤回数据都属于异常数据
								BillCheckExceptionDO b1 = null;
								p.setIs_amaout_ckecked(FBoolean.FALSE);
								p.setIs_status_checked(FBoolean.FALSE);
								p.setFailed_table(FailedTableEnum.TRADE);
								p.setTrade_type(CheckTradeStatus.REVOKE);
								b1=this.createExceptionDO(p,chl);
								exclist.add(b1);
//							}
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
					mchlist.add(p.getBanktradeno());
				}
				}
				
				// 删除旧数据
				if(tradenolist.size()>0||mchlist.size()>0) {
					String c1=null;
					String c2=null;
					String sql=null;
					if(mchlist.size()>0) {
						c1=" banktradeno in(" + this.getCondition(mchlist)+ ")";
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
		private BillCheckExceptionDO createExceptionDO(CheckBillParamDTO dto,ChlBillItemDO chl) {
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
			newdata.setBill_type(dto.getBill_type());
			newdata.setStatus(DOStatus.NEW);
			newdata.setBanktradeno(dto.getBanktradeno());
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
		
		private void exePayFail(ChlBillItemDO chl) throws BizException {
			List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();
			List<String> tradenolist = new ArrayList<String>();
			String sql="  (Banktradeno) not in(select Banktradeno from pmp_chlbillitem where trade_status='SUCCESS' and "+pmputils.getTimeSpanSql("tradetime", chl.getTradetime().getDate())+" and sd_chl='"+chl.getSd_chl()+"') and trade_status=1"+" and Sd_chl='"+chl.getSd_chl()+"' ";
		    sql=sql+" and "+pmputils.getTimeSpanSql("dt_req", chl.getTradetime().getDate());;
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
		
		private void exeRefundFail(ChlBillItemDO chl) throws BizException {
			List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();
			List<String> tradenolist = new ArrayList<String>();
			String sql="  (Banktradeno) not in(select Banktradeno from pmp_chlbillitem where trade_status='REFUND' and "+pmputils.getTimeSpanSql("tradetime", chl.getTradetime().getDate())+" and sd_chl='"+chl.getSd_chl()+"' ) and trade_status=4"+" and Sd_chl='"+chl.getSd_chl()+"' ";
		    sql=sql+" and "+pmputils.getTimeSpanSql("dt_req", chl.getTradetime().getDate());
		    TradeDO[] items=pmputils.getTradeRService().find(sql, "", FBoolean.FALSE);
		    for (TradeDO t : items) {
				tradenolist.add(t.getTrade_no());
				BillCheckExceptionDO b1=this.createExceptionDO(t, CheckTradeStatus.REFUNDFAIL,chl);
				exclist.add(b1);
			}
			// 删除旧数据
			if(tradenolist.size()>0)
						_cudservice.delete(_rservice.find(
								" trade_no in(" + this.getCondition(tradenolist)
										+ ") and Trade_type=" + CheckTradeStatus.REFUNDFAIL, "",
								FBoolean.FALSE));
						_cudservice.save(exclist.toArray(new BillCheckExceptionDO[0]));
		}
		
		private BillCheckExceptionDO createExceptionDO(TradeDO dto,int chs,ChlBillItemDO chl) {
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
			newdata.setBanktradeno(dto.getBanktradeno());
			return newdata;
		}
		
		private BillCheckExceptionDO createRepeatExceptionDO(TradeDO dto) {
			BillCheckExceptionDO newdata = new BillCheckExceptionDO();
			newdata.setId_billitem(null);
			newdata.setId_trade(dto.getId_trade());
			newdata.setId_ord(dto.getId_ord());
			newdata.setTrade_no(dto.getTrade_no());
			newdata.setDt_req(dto.getDt_req());
			newdata.setOrd_no(dto.getOrd_no());
	        newdata.setId_chl(dto.getId_chl());
	        newdata.setSd_chl(dto.getSd_chl());
			newdata.setFailed_table(FailedTableEnum.TRADE);
			newdata.setIs_amaout_ckecked(FBoolean.FALSE);
			newdata.setIs_status_checked(FBoolean.FALSE);
			newdata.setCheckresult(dto.getCheck_rst());
			newdata.setTrade_type(CheckTradeStatus.TRADEREPEAT);
			newdata.setRefund_trade_no(dto.getTrade_no());
			newdata.setTradetime(dto.getDt_req());
//			newdata.setBill_type(chl.getBill_type());
			newdata.setStatus(DOStatus.NEW);
			newdata.setBanktradeno(dto.getBanktradeno());
			return newdata;
		}
		 private void getRepeatBillBankTradeNo(ChlBillItemDO chl) throws BizException{
			 String sql=" select a.banktradeno from ( select count(banktradeno) c,banktradeno from pmp_chlbillitem where banktradeno in ( select banktradeno from pmp_chlbillitem where sd_chl='"+chl.getSd_chl()+"' and "+pmputils.getTimeSpanSql("tradetime", chl.getTradetime().getDate())+")  group by banktradeno) a where a.c>1";
        	 DAFacade da = new DAFacade();
        	 Object result= da.execQuery(sql, new MapListHandler());
        /*	 if(result!=null){
     			List<HashMap<String, Object>> b=(List<HashMap<String, Object>>)result;
     			if(b.size()>0) {
     	//			throw new BizException("对账单存在重复数据！请重新生成对账但数据！");
     				}
     			}*/
		 }
        private TradeDO[] getRepeatBankTradeNo(ChlBillItemDO chl) throws BizException {
        	
        	TradeDO[] items=this.getRepeatTrade(chl);
//        	this.updateBankTradeNO(items);
        	
        	 return items;
        	 
        }
        private TradeDO[] getRepeatTrade(ChlBillItemDO chl) throws BizException {
        	String sql=" select a.banktradeno from ( select count(banktradeno) c,banktradeno from pmp_trade where banktradeno in ( select banktradeno from pmp_chlbillitem where sd_chl='"+chl.getSd_chl()+"' and "+pmputils.getTimeSpanSql("tradetime", chl.getTradetime().getDate())+")  group by banktradeno) a where a.c>1";
       	 DAFacade da = new DAFacade();
       	 Object result= da.execQuery(sql, new MapListHandler());
       	 if(result!=null){
    			List<HashMap<String, Object>> b=(List<HashMap<String, Object>>)result;
    			if(b.size()>0) {
    				StringBuilder sb=new StringBuilder();
    				for (HashMap<String, Object> m : b) {
						if(sb.length()==0) {
							sb.append("'"+m.get("banktradeno")+"'");
						}else {
							sb.append(",'"+m.get("banktradeno")+"'");
						}
					}
    				 TradeDO[] items=pmputils.getTradeRService().find("banktradeno in("+sb.toString()+")", "", FBoolean.FALSE);
    				 return items;
    			}
       	 }
       	 return null;
        }

}
