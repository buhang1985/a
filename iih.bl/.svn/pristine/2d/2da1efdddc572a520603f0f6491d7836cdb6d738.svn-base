package iih.bl.cc.s.bp;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlCcPmDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 结算收退款
 * @author LIM
 * @since 2017-06-26
 */
public class SetBlccDOAmtStinfoBP {
	/**
	 * 结算收退款
	 * @param id_user
	 * @param id_org
	 * @param sd_cctp
	 * @param end_time
	 * @param blccDO
	 * @param map
	 * @throws BizException
	 */
	public void exec(String id_user, String id_org, String sd_cctp, FDateTime end_time, BlCcDO blccDO,Map<String,BlCcPmDO> map) throws BizException{
		//结算
		StringBuffer sf = new StringBuffer();
		sf.append(" a0.FG_CC = 'N'")
		  .append(" and a0.ID_EMP_PAY = '").append(id_user).append("'")
//		  .append(" and a0.ID_ORG = '").append(id_org).append("'")
		  .append(" and a0.DT_PAY < '").append(end_time).append("'");
		FDouble amt_st = new FDouble(0); // 结算_收款
		FDouble amt_st_ret = new FDouble(0);//结算_退款
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊（患者）
			IBlpaypatoepRService oepService = ServiceFinder.find(IBlpaypatoepRService.class);
			BlpaypatoepAggDO[] oepAggDOArr = oepService.find(sf.toString(), null, FBoolean.FALSE);
			if(oepAggDOArr != null){
				for(BlpaypatoepAggDO aggDO : oepAggDOArr){
					if(aggDO.getParentDO().getAmt() == null){
						throw new BizException("门诊结算收退款费用异常，结账失败！");
					}		
					
					if(BookRtnDirectEnum.CHARGE == aggDO.getParentDO().getEu_direct()){
						for(BlPayItmPatOepDO blPayItemDO : aggDO.getBlPayItmPatOepDO()){
							//唐婵懿增加：实收（退）付款段标志取值为true参与计算
							if(blPayItemDO.getFg_realpay()!=null && !blPayItemDO.getFg_realpay().booleanValue())
							{
								continue; //不计算非真实交易
							}
							if(IBdPripmCodeConst.CODE_PRI_PM_CHECK.equals(blPayItemDO.getSd_pm())){
								if(blccDO.getChqcn() == null){
									blccDO.setChqcn(1);//支票张数
									blccDO.setChqnos(blPayItemDO.getPaymodenode());//支票号
								}else{
									blccDO.setChqcn(blccDO.getChqcn() + 1);//支票张数
									blccDO.setChqnos(blccDO.getChqnos() + "," + blPayItemDO.getPaymodenode());//支票号
								}
							}
						}
					}
					if(aggDO.getBlPayItmPatOepDO() != null && aggDO.getBlPayItmPatOepDO().length > 0){
						for(BlPayItmPatOepDO patDO : aggDO.getBlPayItmPatOepDO()){
							if(patDO.getAmt() == null){
								throw new BizException("门诊结算收退款明细费用异常，结账失败！");
							}
							//唐婵懿增加：实收（退）付款段标志取值为true参与计算
							if(patDO.getFg_realpay()!=null  && !patDO.getFg_realpay().booleanValue())
							{
								continue; //不计算非真实交易
							}

							if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
								amt_st = amt_st.add(patDO.getAmt());
							}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
								amt_st_ret = amt_st_ret.add(patDO.getAmt());
							}
							if(patDO.getId_pm() == null || patDO.getId_pm().isEmpty() || "~".equals(patDO.getId_pm())){
								throw new BizException("收付款方式为空，请检查数据");
							}
							if(map.get(patDO.getId_pm()) == null){
								BlCcPmDO blccPmDO = new BlCcPmDO();
								blccPmDO.setId_org(id_org);
								blccPmDO.setId_pm(patDO.getId_pm());
								blccPmDO.setCode(patDO.getPm_code());
								blccPmDO.setName(patDO.getPm_name());
								if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
									blccPmDO.setAmt(patDO.getAmt());
									blccPmDO.setCn_amt(1);
								}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
									blccPmDO.setAmt_return(patDO.getAmt());
									blccPmDO.setCn_amtreturn(1);
								}
								blccPmDO.setStatus(DOStatus.NEW);
								map.put(patDO.getId_pm(), blccPmDO);
							}else{
								BlCcPmDO blccPmDO = map.get(patDO.getId_pm());
								if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
									FDouble amt = blccPmDO.getAmt();
									if(amt == null) amt = new FDouble(0);
									blccPmDO.setAmt(amt.add(patDO.getAmt()));
									if(String.valueOf(blccPmDO.getCn_amt()).compareTo("null")==0 || String.valueOf(blccPmDO.getCn_amt()).trim().compareTo("") ==0)
									{
										blccPmDO.setCn_amt(1);
									}
									else
									{
										blccPmDO.setCn_amt(blccPmDO.getCn_amt() + 1);
									}
								}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
									FDouble amt_return = blccPmDO.getAmt_return();
									if(amt_return == null) amt_return = new FDouble(0);
									blccPmDO.setAmt_return(amt_return.add(patDO.getAmt()));
									if(blccPmDO.getCn_amtreturn() == null){
										blccPmDO.setCn_amtreturn(1);
									}else{
										blccPmDO.setCn_amtreturn(blccPmDO.getCn_amtreturn() + 1);
									}
								}
							}
						}
					}
				}
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)|| IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			IBlpaypatipRService ipService = ServiceFinder.find(IBlpaypatipRService.class);
			BlpaypatipAggDO[] ipAggDOArr = ipService.find(sf.toString(), null, FBoolean.FALSE);
			if(ipAggDOArr != null){
				for(BlpaypatipAggDO aggDO : ipAggDOArr){
					if(aggDO.getParentDO().getAmt() == null){
						throw new BizException("住院结算收退款费用异常，结账失败！");
					}
					if(BookRtnDirectEnum.CHARGE == aggDO.getParentDO().getEu_direct()){//收费
						amt_st = amt_st.add(aggDO.getParentDO().getAmt());
					}else if(BookRtnDirectEnum.RETURNS == aggDO.getParentDO().getEu_direct()){//退费
						amt_st_ret = amt_st_ret.add(aggDO.getParentDO().getAmt());
					}
					if(BookRtnDirectEnum.CHARGE == aggDO.getParentDO().getEu_direct()){
						for(BlPayItmPatIpDO blPayItemDO : aggDO.getBlPayItmPatIpDO()){
							if(IBdPripmCodeConst.CODE_PRI_PM_CHECK.equals(blPayItemDO.getSd_pm())){
								if(blccDO.getChqcn() == null){
									blccDO.setChqcn(1);//支票张数
									blccDO.setChqnos(blPayItemDO.getPaymodenode());//支票号
								}else{
									blccDO.setChqcn(blccDO.getChqcn() + 1);//支票张数
									blccDO.setChqnos(blccDO.getChqnos() + "," + blPayItemDO.getPaymodenode());//支票号
								}
							}
						}
					}
					if(aggDO.getBlPayItmPatIpDO() != null && aggDO.getBlPayItmPatIpDO().length > 0){
						for(BlPayItmPatIpDO patDO : aggDO.getBlPayItmPatIpDO()){
							if(aggDO.getParentDO().getAmt() == null){
								throw new BizException("住院结算收退款明细费用异常，结账失败！");
							}
							if(map.get(patDO.getId_pm()) == null){
								BlCcPmDO blccPmDO = new BlCcPmDO();
								blccPmDO.setId_org(id_org);
								blccPmDO.setId_pm(patDO.getId_pm());
								blccPmDO.setCode(patDO.getPm_code());
								blccPmDO.setName(patDO.getPm_name());
								if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
									blccPmDO.setAmt(patDO.getAmt());
									blccPmDO.setCn_amt(1);
								}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
									blccPmDO.setAmt_return(patDO.getAmt());
									blccPmDO.setCn_amtreturn(1);
								}
								blccPmDO.setStatus(DOStatus.NEW);
								map.put(patDO.getId_pm(), blccPmDO);
							}else{
								BlCcPmDO blccPmDO = map.get(patDO.getId_pm());
								if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
									FDouble amt = blccPmDO.getAmt();
									if(amt == null) amt = new FDouble(0);
									blccPmDO.setAmt(amt.add(patDO.getAmt()));
									if(String.valueOf(blccPmDO.getCn_amt()).compareTo("null")==0 || String.valueOf(blccPmDO.getCn_amt()).trim().compareTo("") ==0)
									{
										blccPmDO.setCn_amt(1);
									}
									else
									{
										blccPmDO.setCn_amt(blccPmDO.getCn_amt() + 1);
									}
								}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
									FDouble amt_return = blccPmDO.getAmt_return();
									if(amt_return == null) amt_return = new FDouble(0);
									blccPmDO.setAmt_return(amt_return.add(patDO.getAmt()));
									if(blccPmDO.getCn_amtreturn() == null){
										blccPmDO.setCn_amtreturn(1);
									}else{
										blccPmDO.setCn_amtreturn(blccPmDO.getCn_amtreturn() + 1);
									}
								}
							}
						}
					}
				}
			}
		}

		blccDO.setAmt_st(amt_st);//结算_收款
		blccDO.setAmt_st_ret(amt_st_ret);//结算_退款
	}	
}
