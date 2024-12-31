package iih.bl.cg.listener;

import iih.bl.cg.listener.bp.GetOutDepCgPatListBP;
import iih.bl.cg.s.bp.ip.IpOrdChargeBP;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.TransDeptOrCheckListener;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDateTime;

/**
 * 转科记账监听器
 * 记录护理费、持续医嘱费用
 * @author yankan
 * @since 2017-10-22
 *
 */
public class TransDepChargeListener extends TransDeptOrCheckListener{
	@Override
	protected void doYourActionAfterOrCheck(CiOrderDO[] ors)
			throws BizException {
		if(ArrayUtil.isEmpty(ors))
			return;
		FDateTime cgEndTime = ors[0].getDt_chk();//计费时间点为核对时间
		GetOutDepCgPatListBP getPatBP = new GetOutDepCgPatListBP();
		List<String> patIdList = getPatBP.exec(ors);
		if(ListUtil.isEmpty(patIdList)){
			return;
		}
		IpOrdChargeBP ordChargeBP = new IpOrdChargeBP();
		for(String patId : patIdList){
			ordChargeBP.exec(patId, cgEndTime);
		}		
	}
}
