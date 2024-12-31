package iih.ci.ord.s.ems.op.orderv1.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.itf.bp.IOrderDeleteRevertBP;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;
import iih.ci.ord.s.ems.op.orderv1.bp.ope.OrderDeleteOperateBP;
import iih.ci.ord.s.ems.op.orderv1.bp.ope.OrderRevertOperateBP;
import iih.ci.ord.s.ems.utils.OrderUtils;

/**
 * 医嘱删除撤回操作
 * 
 * @author Young
 *
 */
public class OrderDeleteRevertBP implements IOrderDeleteRevertBP {

	private IOrderOperateBP deleteBP = new OrderDeleteOperateBP();
	private IOrderOperateBP revertBP = new OrderRevertOperateBP();
	@Override
	public OrderRstDTO deleterevert(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		FArrayList paramList = arg.getDocument();//获取医嘱ID集合
		FMap2 extension = arg.getExtension();//获取前台医嘱状态集合
		if (paramList != null && paramList.size() > 0 && extension != null) {
			String strIdors = "";
			for (Object obj : paramList) {
				if (CiOrdUtils.isEmpty(obj))
					continue;
				strIdors += ",'" + obj.toString() + "'";
			}
			
			List<String> lstIdorsDel = new ArrayList<String>();
			List<String> lstIdorsRev = new ArrayList<String>();
			//查询当前医嘱状态集合
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
				//对比医嘱状态是否改变
				if(map == null || !map.get("sd_su_or").toString().equals(extension.get(key).toString())){
					FMap2 scene = new FMap2();
					scene.put("checkResult", STR_ERROR_ORSTATUS);
					rstDTO.setExtension(scene);
					rstDTO.setIsSuccess(FBoolean.FALSE);
					return rstDTO;
				}
				
				if (ICiDictCodeConst.SD_SU_OPEN.equals(extension.get(key).toString())) {
					lstIdorsDel.add(key);//获取开立状态的医嘱集合，医嘱删除
				} else {
					lstIdorsRev.add(key);//获取非开立状态的医嘱集合，医嘱撤回
				}
			}
			
			boolean rtn = false;
			if (lstIdorsDel.size() > 0) {
				rstDTO = deleteBP.exec(lstIdorsDel.toArray(new String[] {}), ctx, arg.getExtension());
				rtn = rstDTO.getIsSuccess().booleanValue();
			}
			if (lstIdorsRev.size() > 0) {
				rstDTO = revertBP.exec(lstIdorsRev.toArray(new String[] {}), ctx, arg.getExtension());
				rtn = rtn && rstDTO.getIsSuccess().booleanValue();
			}

			rstDTO.setIsSuccess(new FBoolean(rtn));
		}
		
		rstDTO.setIsSuccess(FBoolean.FALSE);
		return rstDTO;
	}

}
