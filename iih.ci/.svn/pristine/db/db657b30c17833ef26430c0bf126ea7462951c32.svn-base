package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消作废
 * @author zhangwq
 *
 */
public class RevertCancelBP {
	public String exec(String[] id_ors) throws BizException{
		if(CiOrdUtils.isEmpty(id_ors)){
			return "没有可操作的数据！";
		}
		ICiorderMDORService orderService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] orderList = orderService.findByBIds(id_ors, FBoolean.FALSE);
		for (CiOrderDO order : orderList) {
			//已作废、未作废确认的医嘱，可以撤回
            if (order.getFg_canc() != null && order.getFg_canc().booleanValue() 
            		&& order.getFg_chk_canc() != null && !order.getFg_chk_canc().booleanValue())
            {
            	order.setFg_canc(FBoolean.FALSE);
            	order.setFg_uncancelable(FBoolean.FALSE);
            	order.setId_emp_canc(null);
				order.setId_dep_canc(null);
				order.setDt_canc(null);
				order.setSd_su_or(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
            }else{
            	return "医嘱状态已发生变化，请刷新界面重试！";
            }
				
		}
		CiOrdAppUtils.getOrService().update(orderList);
		return null;
	}
}
