package iih.bl.cc.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 住院、门诊预交金
 * @author LIM
 * @since 2017-06-26
 */
public class SetBlccDOPayInfoBP {

	/**
	 * 住院、门诊预交金
	 * @param id_user
	 * @param id_org
	 * @param sd_cctp
	 * @param end_time
	 * @param blccDO
	 * @throws BizException
	 */
	public void exec(String id_user, String id_org, String sd_cctp, FDateTime end_time, BlCcDO blccDO) throws BizException{
		//住院、门诊预交金
		FDouble amt_pvprepay = new FDouble(0);//住院押金_收款
		FDouble amt_pvprepay_ret = new FDouble(0);//住院押金_退款
		FDouble amt_entprepay = new FDouble(0);//患者预交金_收款
		FDouble amt_entprepay_ret = new FDouble(0);//患者预交金_退款
		StringBuffer incnos_pvprepay = new StringBuffer();//住院押金收据使用号码串
		StringBuffer incnos_pvprepay_ret = new StringBuffer();//住院押金收据收回号码串
		Integer inccn_pvprepay = 0;//住院押金收据发出张数
		Integer inccn_pvprepay_ret = 0;//住院押金收据收回张数
		IBlpaypatRService blPayService = ServiceFinder.find(IBlpaypatRService.class);
		StringBuilder bf = new StringBuilder();
		bf.append(" a0.FG_CC = 'N'")
		  .append(" and a0.id_emp_pay = '").append(id_user).append("'")
		  .append(" and a0.DT_PAY < '").append(end_time).append("'");
		BlPrePayPatDO[] blPrePayArr = null;
		if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊预交金
			bf.append(" and a0.SD_PAYTP = '").append(IBlDictCodeConst.SD_PAYTP_OPPREPAY).append("'");
			blPrePayArr = blPayService.find(bf.toString(), null, FBoolean.FALSE);
			if(blPrePayArr != null){
				for(BlPrePayPatDO blPrePayPatDO:blPrePayArr){
					if(blPrePayPatDO.getAmt() == null){
						throw new BizException("门诊预交金数据错误，结账失败！");
					}
					if(BookRtnDirectEnum.CHARGE == blPrePayPatDO.getEu_direct()){//收费
						amt_entprepay = amt_entprepay.add(blPrePayPatDO.getAmt());
					}else if(BookRtnDirectEnum.RETURNS == blPrePayPatDO.getEu_direct()){//退费
						amt_entprepay_ret = amt_entprepay_ret.add(blPrePayPatDO.getAmt());
					}
				}
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYYJJ.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			//住院预交金需要加结转金额-hanjq-2018.11.15日
			List<String> paytpSdList = new ArrayList<String>();
			paytpSdList.add(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
			paytpSdList.add(IBlDictCodeConst.SD_PAYTP_IPPREPAYSTTRANSFER);
			bf.append(SqlUtils.getInSqlByIds(" AND a0.SD_PAYTP", paytpSdList));
			blPrePayArr = blPayService.find(bf.toString(), null, FBoolean.FALSE);
			if(blPrePayArr != null){
				for(BlPrePayPatDO blPrePayPatDO:blPrePayArr){
					if(blPrePayPatDO.getAmt() == null){
						throw new BizException("住院预交金数据错误，结账失败！");
					}
					if(BookRtnDirectEnum.CHARGE == blPrePayPatDO.getEu_direct()){//收费
						amt_pvprepay = amt_pvprepay.add(blPrePayPatDO.getAmt());
						if(blPrePayPatDO.getCode_rep() == null){
							continue;
						}
						if(incnos_pvprepay.length() != 0){
							incnos_pvprepay.append(",");
						}
						incnos_pvprepay.append(blPrePayPatDO.getCode_rep());
						inccn_pvprepay++;
					}else if(BookRtnDirectEnum.RETURNS == blPrePayPatDO.getEu_direct()){//退费
						amt_pvprepay_ret = amt_pvprepay_ret.add(blPrePayPatDO.getAmt());
						if(blPrePayPatDO.getCode_rep() == null){
							continue;
						}
						if(incnos_pvprepay_ret.length() != 0){
							incnos_pvprepay_ret.append(",");
						}
						incnos_pvprepay_ret.append(blPrePayPatDO.getCode_rep());
						inccn_pvprepay_ret++;
					}
				}
			}
		}
		//计算支票数据
		if(blPrePayArr != null){
			for(BlPrePayPatDO blPrePayPatDO:blPrePayArr){
				if(BookRtnDirectEnum.CHARGE.equals(blPrePayPatDO.getEu_direct()) &&
						IBdPripmCodeConst.CODE_PRI_PM_CHECK.equals(blPrePayPatDO.getSd_pm())){
					if(blccDO.getChqcn() == null){
						blccDO.setChqcn(1);//支票张数
						blccDO.setChqnos(blPrePayPatDO.getPaymodenode());//支票号
					}else{
						blccDO.setChqcn(blccDO.getChqcn() + 1);//支票张数
						blccDO.setChqnos(blccDO.getChqnos() + "," + blPrePayPatDO.getPaymodenode());//支票号
					}
				}
			}
		}

		blccDO.setAmt_pvprepay(amt_pvprepay);//住院押金_收款
		blccDO.setAmt_pvprepay_ret(amt_pvprepay_ret);//住院押金_退款
		blccDO.setAmt_entprepay(amt_entprepay);//患者预交金_收款
		blccDO.setAmt_entprepay_ret(amt_entprepay_ret);//患者预交金_退款
		blccDO.setIncnos_pvprepay(incnos_pvprepay.toString());//住院押金收据使用号码串
		blccDO.setIncnos_pvprepay_ret(incnos_pvprepay_ret.toString());//住院押金收据收回号码串
		blccDO.setInccn_pvprepay(inccn_pvprepay);//住院押金收据发出张数
		blccDO.setInccn_pvprepay_ret(inccn_pvprepay_ret);//住院押金收据收回张数
	}	
}
