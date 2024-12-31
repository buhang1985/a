package iih.bl.cc.s.bp;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 检查是否存在预交金数据
 * @author LIM
 * @since 2017-6-26
 */
public class GetCheckBlPrePatInfoBP {
	/**
	 * 检查是否存在预交金数据
	 * @param id_user
	 * @param id_org
	 * @param sd_cctp
	 * @param end_time
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String id_user, String id_org,String sd_cctp,FDateTime end_time) throws BizException{
		IBlpaypatRService payService = ServiceFinder.find(IBlpaypatRService.class);
		StringBuffer sb = new StringBuffer();
		if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp)){//门诊预交金
			sb.append(" a0.SD_PAYTP = '").append(IBlDictCodeConst.SD_PAYTP_OPPREPAY).append("'");
		}else if(IBlDictCodeConst.SD_CCTP_ZYYJJ.equals(sd_cctp)){//住院
			sb.append(" a0.SD_PAYTP = '").append(IBlDictCodeConst.SD_PAYTP_IPPREPAY).append("'");
		}
		sb.append(" and a0.FG_CC = 'N'")
		  .append(" and a0.ID_EMP_PAY = '").append(id_user).append("'")
//		  .append(" and a0.ID_ORG = '").append(id_org).append("'")
		  .append(" and a0.DT_PAY < '").append(end_time).append("'");
		BlPrePayPatDO[] patDOArr = payService.find(sb.toString(), null, FBoolean.FALSE);
		if(patDOArr != null && patDOArr.length > 0){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}	
}
