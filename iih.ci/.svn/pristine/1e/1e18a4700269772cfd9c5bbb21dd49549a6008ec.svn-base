package iih.ci.diag.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.s.CiDiUtils;
import iih.ci.diag.s.bp.qry.getLastCiDiagsQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取保外诊断明细
 * 
 * @author HUMS
 *
 */
public class GetHpjudgetpCiDiagItemsBP {

	public CiDiagItemDO[] exec(String id_en) throws BizException {

		getLastCiDiagsQry qry = new getLastCiDiagsQry(id_en);
		CiDiagDO[] cidiag = (CiDiagDO[]) AppFwUtil.getDORstWithDao(qry, CiDiagDO.class);
		if (cidiag != null && cidiag.length > 0) {
			String sql = " ";
			for (CiDiagDO item : cidiag) {
				// 补充诊断+最后的诊断（都是签署的）
				if (item.getSd_ditp() == ICiDictCodeConst.SD_SUPPLY) {
					sql += "'" + item.getId_di() + "',";
				} else {
					sql += "'" + item.getId_di() + "',";
					break;
				}
			}
			sql = sql.substring(0, sql.lastIndexOf(","));
			String sql2 = "a1.id_di in (" + sql + ") and eu_hpbeyond='1'";
			CiDiagItemDO[] rtn = CiDiUtils.getICiDiagItemDORService().find(sql2, "a1.id_di", FBoolean.FALSE);
			return rtn;
		}
		return null;

	}
}
