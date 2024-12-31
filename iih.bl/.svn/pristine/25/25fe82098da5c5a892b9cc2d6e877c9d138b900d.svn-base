package iih.bl.cc.s.bp;

import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 结账更新预交金BP
 * @author LIM
 *
 */
public class UpdatePrePayPatBP {
	/**
	 * 预交金表(BL_PREPAY_PAT)中结账标志为已结账
	 * @param id_user 操作员id
	 * @param id_cc 结账id
	 * @param end_time 结账日期
	 * @param sd_paytpList 患者收付款类型
	 * @throws BizException
	 * @author LIM
	 */
	public void exec(String id_user,String id_cc,FDateTime end_time,List<String> sd_paytpList) throws BizException{
		StringBuilder paySql = new StringBuilder();
		//患者收付款类型
		String sd_paytp=SqlUtils.getInSqlByBigIds("a0.SD_PAYTP", sd_paytpList.toArray(new String[sd_paytpList.size()]));
		paySql.append(sd_paytp);
		paySql.append(" and a0.FG_CC = 'N'");
		paySql.append(" and a0.ID_EMP_PAY = '").append(id_user).append("'");
		paySql.append(" and a0.DT_PAY < '").append(end_time).append("'");
		IBlpaypatRService payRService = ServiceFinder.find(IBlpaypatRService.class);
		IBlpaypatCudService payCService = ServiceFinder.find(IBlpaypatCudService.class);
		BlPrePayPatDO[] blPrePayPatDOArr = payRService.find(paySql.toString(), null, FBoolean.FALSE);
		if(blPrePayPatDOArr != null && blPrePayPatDOArr.length > 0){
			for(BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr){
				blPrePayPatDO.setId_cc(id_cc);
				blPrePayPatDO.setFg_cc(FBoolean.TRUE);
				blPrePayPatDO.setStatus(DOStatus.UPDATED);
			}
			payCService.save(blPrePayPatDOArr);				
		}
	}
}
