package iih.ci.ord.s.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.pub.listener.AbstractOrStopCheckListener;
import iih.ci.ord.s.bp.OrConfirmBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱停止确认后，相关护嘱的停止确认操作
 * 
 * @author zhanwq
 *
 */
public class NurOrderStopListener extends AbstractOrStopCheckListener {

	/**
	 * 护嘱医嘱停止确认操作
	 */
	@Override
	protected void doYourActionAfterOrStopCheck(CiOrderDO[] ors) throws BizException {
		this.handle(ors);
	}

	/**
	 * 护嘱医嘱停止确认逻辑调用
	 * 
	 * @param ors
	 * @throws BizException
	 */
	private void handle(CiOrderDO[] orders) throws BizException {
		List<String> id_ors = new ArrayList<String>();
		Map<String,CiOrderDO> docOrdersMap = new HashMap<String,CiOrderDO>();
		for (CiOrderDO ci : orders) {
			id_ors.add(ci.getId_or());
			docOrdersMap.put(ci.getId_or(), ci);
		}
		// 查询相关的护嘱
		ICiorderMDORService rService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] nurOrders = rService.findByAttrValStrings(CiOrderDO.ID_OR_REL, id_ors.toArray(new String[0]));
		if(nurOrders==null || nurOrders.length == 0){
			return;
		}
		List<CiOrderDO> isCanStop = new ArrayList<CiOrderDO>();
		//将原医嘱的停止时间、停止人、停止科室、停止确认人、停止确认科室，赋值给被停止的护嘱
		for (int i = nurOrders.length - 1; i >= 0; i--) {
			//已经作废的医嘱，不进行停止确认,未核对的医嘱不进行停止确认
			if(FBoolean.FALSE.equals(nurOrders[i].getFg_chk()) || nurOrders[i].getFg_canc().booleanValue()){
				continue;
			}
			if (ICiDictCodeConst.SD_ORDSRCFUN_NUR.equals(nurOrders[i].getSd_orsrcfun())) {
				CiOrderDO nurItem = nurOrders[i];
				if(docOrdersMap.containsKey(nurItem.getId_or_rel())){
					CiOrderDO docItem = docOrdersMap.get(nurItem.getId_or_rel());
					if(FBoolean.FALSE.equals(nurItem.getFg_stop())){
						if(nurItem.getDt_effe().compareTo(docItem.getDt_end())>=0){
							nurItem.setDt_end(nurItem.getDt_effe());
						}else
						{
							nurItem.setDt_end(docItem.getDt_end());
						}
						//将赋值后的结束时间与医嘱的dt_last_mp（最后执行时间）进行比较，如果dt_last_mp>=dt_end,将dt_last_mp赋值给dt_end
						if(nurItem.getDt_last_mp()!=null&&nurItem.getDt_last_mp().compareTo(nurItem.getDt_end())>=0){
							nurItem.setDt_end(nurItem.getDt_last_mp());
						}
						nurItem.setId_emp_stop(docItem.getId_emp_chk_stop());
						nurItem.setId_dep_stop(docItem.getId_dep_stop());
					}
					nurItem.setId_dep_chk_stop(docItem.getId_dep_chk_stop());
					nurItem.setId_emp_chk_stop(docItem.getId_emp_chk_stop());
					// 跟关联医嘱一样
					nurItem.setDt_chk_stop(docItem.getDt_chk_stop());
				}
				isCanStop.add(nurItem);
			}
		}
		if (isCanStop.size() > 0) {
			// 调用护嘱确认
			OrConfirmBP orConfirmBP = new OrConfirmBP();
			orConfirmBP.runNurOrderStopConfirm(isCanStop.toArray(new CiOrderDO[0]));
		}
	}
}
