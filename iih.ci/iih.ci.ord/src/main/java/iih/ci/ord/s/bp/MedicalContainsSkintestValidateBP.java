package iih.ci.ord.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 校验是否存在关联的用药医嘱
 * 
 * @author mkp
 *
 */
public class MedicalContainsSkintestValidateBP {
	
	/**
	 * 校验是否存在关联的用药医嘱
	 * 如果存在返回相应的用药医嘱
	 * 
	 * @param orders 待判断医嘱对象
	 * @return
	 * @throws BizException 
	 */
	public CiOrderDO[] exec(CiOrderDO[] orders) throws BizException {
		// 参数校验，组装
		StringBuilder idors = new StringBuilder();
		for (CiOrderDO cior : orders) {
			// 如果是皮试类型
			if (cior.getFg_skintest().booleanValue()) {
				idors.append(",'")
					.append(cior.getId_or())
					.append("'");
			}
		}
		if (idors.length() <= 0)
			return null;
		
		// 查询
		StringBuilder sql = new StringBuilder();
		sql.append(" select ord.id_or id_or from ci_order ord ")
		   .append(" left join ci_or_srv orsrv on ord.id_or = orsrv.id_or")
		   .append(" where ord.fg_canc='N' and ord.fg_sign = 'Y'")
		   .append(" and orsrv.sd_reltp = '" + IBdSrvDictCodeConst.SD_RELORDTYPE_SKIN + "' ")
		   .append(" and orsrv.id_or_rel in (" + idors.toString().substring(1) +") ");
		
		@SuppressWarnings("unchecked")
		List<String> rst = (List<String>) new DAFacade()
				.execQuery(sql.toString(), null, new ColumnListHandler("id_or"));
		
		// 如果为空，直接返回
		if (rst == null || rst.size() == 0) {
			return null;
		}
		
		// 获得医嘱集合
		CiOrderDO[] ciors = CiOrdAppUtils.getOrQryService().findByBIds(rst.toArray(new String[rst.size()]),
						FBoolean.FALSE);
		
		return ciors;
	}
}
