package iih.ci.ord.s.ems.mdsstation.order.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ap.i.ICiapspecantirecordCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医技医生站作废操作
 * @author zhagnwq
 *
 */
public class MdsCancelBP {
	public CiOrderDO[] exec(CiOrderDO[] orders) throws BizException{
		if(orders != null && orders.length >0){
			for (CiOrderDO ciOrderDO : orders) {
				ciOrderDO.setId_su_or(ICiDictCodeConst.SD_SU_ID_CANCEL);
				ciOrderDO.setSd_su_or(iih.bd.bc.udi.pub.ICiDictCodeConst.SD_SU_CANCEL);
				ciOrderDO.setFg_canc(new FBoolean(true));
				ciOrderDO.setDt_canc(CiOrdAppUtils.getServerDateTime());
				ciOrderDO.setId_dep_canc(Context.get().getDeptId());
				ciOrderDO.setId_emp_canc(Context.get().getStuffId());	
				ciOrderDO.setStatus(DOStatus.UPDATED);
			}
			orders = CiOrdAppUtils.getOrService().update(orders);
			if(orders !=null && orders.length>0){
				List<String> id_ors = new ArrayList<String>();
				for (CiOrderDO order : orders) {
					id_ors.add(order.getId_or());
				}
				clearData(id_ors.toArray(new String[0]));
				//执行域响应医嘱作废操作
				CiOrdAppUtils.getIResponseOrderHandelService().responseOrInvalid(id_ors.toArray(new String[0]));
				return orders;
			}
		}
		return null;
	}
	/**
	 * 清除数据
	 * @param id_ors
	 * @throws BizException 
	 */
	protected void clearData(String[] id_ors) throws BizException{
		ICiprintExtService service = ServiceFinder.find(ICiprintExtService.class);
		service.DeleteAppLisData(id_ors);
		service.DeleteAppRisData(id_ors);
		service.DeleteAppPathgyData(id_ors);
		ICiapspecantirecordCudService recordService = ServiceFinder.find(ICiapspecantirecordCudService.class);
		recordService.deleteByIdOrs(id_ors);
	}
}
