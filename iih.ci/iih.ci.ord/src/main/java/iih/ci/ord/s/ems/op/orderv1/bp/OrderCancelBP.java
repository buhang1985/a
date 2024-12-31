package iih.ci.ord.s.ems.op.orderv1.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.itf.bp.IOrderCancelBP;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;
import iih.ci.ord.s.ems.op.orderv1.bp.ope.OrderCancelOperateBP;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱作废操作
 * 
 * @author Young
 *
 */
public class OrderCancelBP implements IOrderCancelBP {

	private IOrderOperateBP cancelBP = new OrderCancelOperateBP();

	@Override
	public OrderRstDTO cancel(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		FArrayList paramList = arg.getDocument();// 获取医嘱ID集合
		FMap2 extension = arg.getExtension();// 获取前台医嘱状态集合
		if (paramList != null && paramList.size() > 0 && extension != null) {
			String strIdors = "";
			for (Object obj : paramList) {
				if (CiOrdUtils.isEmpty(obj))
					continue;
				strIdors += ",'" + obj.toString() + "'";
			}

			List<String> lstIdors = new ArrayList<String>();
			// 查询当前医嘱状态集合
			FMap mapOrStatus = OrderUtils.getOrderStatus(strIdors.substring(1));
			if (mapOrStatus == null || mapOrStatus.size() <= 0) {
				FMap2 scene = new FMap2();
				scene.put("checkResult", STR_ERROR_ORSTATUS);
				rstDTO.setExtension(scene);
				rstDTO.setIsSuccess(FBoolean.FALSE);
				return rstDTO;
			}
			
			for (String key : extension.keySet()) {
				@SuppressWarnings("unchecked")
				Map<String, Object> map = (Map<String, Object>) mapOrStatus.get(key);
				// 对比医嘱状态是否改变
				if (map == null || !extension.get(key).toString().equals(map.get("sd_su_or").toString())) {
					FMap2 scene = new FMap2();
					scene.put("checkResult", STR_ERROR_ORSTATUS);
					rstDTO.setExtension(scene);
					rstDTO.setIsSuccess(FBoolean.FALSE);
					return rstDTO;
				}
				// 获取非开立状态的医嘱
				if (!ICiDictCodeConst.SD_SU_OPEN.equals(extension.get(key).toString())) {
					lstIdors.add(key);
				}
			}

			return cancelBP.exec(lstIdors.toArray(new String[] {}), ctx, arg.getExtension());
		}

		rstDTO.setIsSuccess(FBoolean.FALSE);
		return rstDTO;
	}
}
