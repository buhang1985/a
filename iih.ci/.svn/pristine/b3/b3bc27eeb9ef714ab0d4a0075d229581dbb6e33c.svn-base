package iih.ci.ord.s.ems.op.orderv1.bp.ope;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;
import iih.ci.ord.s.ems.op.orderv1.bp.copy.OrderBaseCopyBP;
import iih.ci.ord.s.ems.op.orderv1.bp.copy.OrderCopyFactory;
import iih.ci.ord.s.ems.op.orderv1.bp.qry.GetCiOrderDOs4CopyQry;

/**
 * 医嘱复制逻辑
 * @author Young
 *
 */
public class OrderCopyOperateBP implements IOrderOperateBP {

	@Override
	public OrderRstDTO exec(String[] idors, CiEnContextDTO ciEnContextDTO,
			FMap2 extension) throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();

		String strIdors = "";
		for (String idor : idors) {
			strIdors += ",'" + idor + "'";
		}
		strIdors = strIdors.substring(1);
		
		// 获得医嘱集合
		ITransQry qry = new GetCiOrderDOs4CopyQry(strIdors);
		CiOrderDO[] ciors = (CiOrderDO[]) AppFwUtil.getDORstWithDao(qry, CiOrderDO.class);

		if (ciors == null || ciors.length < 1) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		OrderCopyFactory factory = new OrderCopyFactory();
		Map<String, List<String>> mapIdors = factory.getMapIdors(ciors);
		for (String key : mapIdors.keySet()) {
			OrderBaseCopyBP bp = factory.getOrderCopyBP(key);
			bp.copy(mapIdors.get(key).toArray(new String[] {}));
		}

		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}

}
