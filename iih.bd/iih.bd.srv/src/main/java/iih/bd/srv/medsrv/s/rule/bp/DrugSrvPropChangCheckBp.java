package iih.bd.srv.medsrv.s.rule.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医疗服务属性变更检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DrugSrvPropChangCheckBp {

	public void exec(MedSrvDO oldMedSrv, MedSrvDO newMedSrv) throws BizException {
		if (oldMedSrv == null || newMedSrv == null || StringUtils.isBlank(oldMedSrv.getSd_srvtp())
				|| StringUtils.isBlank(newMedSrv.getSd_srvtp())
				|| !newMedSrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)
				|| !oldMedSrv.getSd_srvtp().equals(newMedSrv.getSd_srvtp())) {
			// 不是药品服务
			return;
		}

		checkMedUnit(oldMedSrv, newMedSrv);
	}

	/**
	 * 检查药品通用名(默认计量单位)医学单位
	 * 
	 * @param oldMedSrv
	 * @param newMedSrv
	 * @param hasReviewedHpComp
	 * @throws BizException
	 */
	private void checkMedUnit(MedSrvDO oldMedSrv, MedSrvDO newMedSrv) throws BizException {
		String oldMedUnit = oldMedSrv.getId_unit_med();
		String newMedUnit = newMedSrv.getId_unit_med();
		if ((StringUtils.isBlank(oldMedUnit) && StringUtils.isNotBlank(newMedUnit))
				|| (StringUtils.isNotBlank(oldMedUnit) && StringUtils.isBlank(newMedUnit))
				|| (StringUtils.isNotBlank(oldMedUnit) && StringUtils.isNotBlank(newMedUnit)
						&& !oldMedUnit.equals(newMedUnit))) {
			// 药品通用名(默认计量单位)医学单位有变化
			boolean hasStock = hasStockBySrvId(newMedSrv.getId_srv());
			if (hasStock) {
				String msg = String.format("药品通用名\"%s\"(%s)已存在库存信息，不允许修改默认计量单位。", newMedSrv.getName(),
						newMedSrv.getCode());
				throw new BizException(msg);
			}
		}
	}

	/**
	 * 判断指定药品通用名是否已存在库存
	 * 
	 * @param id_srv 药品通用名主键
	 * @return
	 * @throws BizException
	 */
	private boolean hasStockBySrvId(String id_srv) throws BizException {

		// 1.期初
		String sql = "SELECT COUNT(1) FROM mm_ini_itm iniitm INNER JOIN bd_mm mm ON mm.id_mm = iniitm.id_mm WHERE iniitm.ds = 0 AND mm.ds = 0 AND mm.id_srv = ?";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_srv);

		DAFacade daFacade = new DAFacade();
		int count = (int) daFacade.execQuery(sql, sqlParam, new ColumnHandler());
		if (count > 0) {
			return true;
		}

		// 2.入库
		sql = "SELECT COUNT(1) FROM mm_in_itm initm INNER JOIN bd_mm mm ON mm.id_mm = initm.id_mm WHERE initm.ds = 0 AND mm.ds = 0 AND mm.id_srv = ?";
		count = (int) daFacade.execQuery(sql, sqlParam, new ColumnHandler());
		if (count > 0) {
			return true;
		}

		// 3.结存
		sql = "SELECT COUNT(1) FROM MM_BL mmbl INNER JOIN bd_mm mm ON mm.id_mm = mmbl.id_mm WHERE mmbl.ds = 0 AND mm.ds = 0 AND mm.id_srv = ?";
		count = (int) daFacade.execQuery(sql, sqlParam, new ColumnHandler());
		if (count > 0) {
			return true;
		}
		return false;
	}
}
