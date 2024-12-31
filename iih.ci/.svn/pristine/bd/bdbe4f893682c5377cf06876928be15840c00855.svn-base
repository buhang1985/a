package iih.ci.ord.s.bp.order.sign.pre;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.preop.imp.dto.TsOrIpOrAggDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 预住院医嘱自动签署时属性赋值
 * 
 * @author mkp
 *
 */
public class UpdatePreIpOrderSignStateBP {
	
	public void exec(CiEnContextDTO ctx, CiOrderDO[] orders, OrderOperateDTO arg) throws BizException {
		FDateTime dtNow = CiOrdAppUtils.getServerDateTime();
		String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		String id_emp_sign = CiOrdAppUtils.getEnvContext().getUserId();
		
		// 签署人，根据参数判断
		FBoolean param = ParamsetQryUtil.getParaBoolean(id_org, "CIOR0805");
		
		for (CiOrderDO order : orders) {
			if (param != null && !param.booleanValue()) {
				FMap2 signMap = arg.getExtension();
				if (signMap.containsKey(order.getId_or())) {
					TsOrIpOrAggDTO dto = (TsOrIpOrAggDTO) signMap.get(order.getId_or());
					if (dto != null && dto.getTsOrDO().getId_emp_sign() != null ) {
						id_emp_sign = dto.getTsOrDO().getId_emp_sign();
					}
				}
			}
			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
			order.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
			order.setFg_sign(new FBoolean(true));
			order.setDt_sign(dtNow);
			order.setId_dep_sign(ctx.getId_dep_en());
			order.setId_emp_or(id_emp_sign);
			order.setId_emp_sign(id_emp_sign);
			order.setStatus(DOStatus.UPDATED);
		}
		
		// 保存
		CiOrdAppUtils.getOrService().update(orders);
	}
}
