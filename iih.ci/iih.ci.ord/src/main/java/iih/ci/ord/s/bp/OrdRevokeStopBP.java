package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 医嘱停止撤回操作
 * 
 * @author zhangwq
 *
 */
public class OrdRevokeStopBP {

	public FBoolean exec(String[] id_ors) throws BizException {
		if(CiOrdUtils.isEmpty(id_ors)){
			return FBoolean.FALSE;
		}
		CiOrderDO[] orderList = CiOrdAppUtils.getOrQryService().findByBIds(id_ors,
				FBoolean.FALSE);
		if(CiOrdUtils.isEmpty(orderList)){
			return FBoolean.FALSE;
		}
		String NULL_DATE = "2099-01-01 00:00:00";
		for (CiOrderDO order : orderList) {
			//停止、未停止确认、未作废、未完成的可以停止撤回
            if (order.getFg_stop() != null && !order.getFg_stop().booleanValue() 
            		&& order.getFg_chk_stop() != null && !order.getFg_chk_stop().booleanValue() 
            		&& order.getFg_canc() != null && !order.getFg_canc().booleanValue()
            		&& order.getSd_su_or() != ICiDictCodeConst.SD_SU_FINISH)
            {
				order.setDt_end(new FDateTime(NULL_DATE));
				order.setFg_stop(FBoolean.FALSE);
				order.setId_emp_stop(null);
				order.setId_dep_stop(null);
            }else{
            	throw new BizException("医嘱状态已发生变化，请刷新界面重试！");
            }
				
		}
		CiOrdAppUtils.getOrService().update(orderList);
		//执行域响应停止操作
		CiOrdAppUtils.getIResponseOrderHandelService().responseOrStop(id_ors);
		return FBoolean.TRUE;
	}
}
