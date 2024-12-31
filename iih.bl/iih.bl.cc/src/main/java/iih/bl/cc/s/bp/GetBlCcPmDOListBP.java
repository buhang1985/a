package iih.bl.cc.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cc.blcc.d.BlCcPmDO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 预交金付款方式
 * @author LIM
 * @since 2017-06-26
 */
public class GetBlCcPmDOListBP {
	/**
	 * 预交金付款方式
	 * @param id_user
	 * @param id_org
	 * @param sd_cctp
	 * @param end_time
	 * @param map
	 * @throws BizException
	 */
	public void exec(String id_user, String id_org, String sd_cctp, FDateTime end_time,Map<String,BlCcPmDO> map) throws BizException{
		IBlpaypatRService service = ServiceFinder.find(IBlpaypatRService.class);
		List<String> paytpSdList = new ArrayList<String>();
		if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊（患者）
			paytpSdList.add(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
		}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_ZYYJJ.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			paytpSdList.add(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
			paytpSdList.add(IBlDictCodeConst.SD_PAYTP_IPPREPAYSTTRANSFER);
		}
		StringBuffer sb = new StringBuffer();
		//sb.append(" a0.SD_PAYTP = '").append(sd_paytp).append("'")
		sb.append(SqlUtils.getInSqlByIds(" a0.SD_PAYTP", paytpSdList))
		  .append(" and a0.id_emp_pay = '").append(id_user).append("'")
//		  .append(" and a0.id_org = '").append(id_org).append("'")
		  .append(" and a0.fg_cc = 'N'")
		  .append(" and a0.dt_pay < '").append(end_time).append("'");
		BlPrePayPatDO[] patDOArr = service.find(sb.toString(), null, FBoolean.FALSE);
		if(patDOArr != null){
			for(BlPrePayPatDO patDO : patDOArr){
				if(map.get(patDO.getId_pm()) == null){
					BlCcPmDO blccPmDO = new BlCcPmDO();
					blccPmDO.setId_org(id_org);
					blccPmDO.setId_pm(patDO.getId_pm());
					blccPmDO.setCode(patDO.getPaymodecode());
					blccPmDO.setName(patDO.getPaymodename());
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
