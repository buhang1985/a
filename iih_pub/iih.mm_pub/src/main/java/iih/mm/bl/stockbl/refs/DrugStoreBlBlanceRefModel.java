package iih.mm.bl.stockbl.refs;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseService;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefGridModel;

public class DrugStoreBlBlanceRefModel extends RefGridModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "name_wh", "name_srv", "name_mm", "name_fac", "spec", "batch", "date_expi", "name_pkgu", "pri_sa",
				"pri_act", "quan_stock", "code_mm" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "仓库名称", "通用名", "药品名称", "生产厂商", "规格", "批次", "有效期", "单位", "售价", "进价", "结存数量", "药品编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_bl" };
	}

	@Override
	public String getPkFieldCode() {
		return "id_bl";
	}

	@Override
	public String getRefCodeField() {
		return "name_wh";
	}

	@Override
	public String getRefNameField() {
		return "name_mm";
	}

	@Override
	public String getTableName() {
		return "storebl";
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "code_mm", "name_srv", "name_mm", "pycode_mm", "wbcode_mm", "mnecode_mm" };
	}

	@Override
	public String getRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();

		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();

		try {
			if (StringUtils.isNotEmpty(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (StringUtils.isNotEmpty(orderPart)) {
				this.getOrderPart().add(orderPart);
			}

			String baseSql = getBaseSql();
			sqlBuilder.append(baseSql);

			List<String> wherePartList = this.getWherePart();
			if (wherePartList != null && wherePartList.size() > 0) {
				wherePart = StringUtils.join(wherePartList, " and ");
				sqlBuilder.append(" where ");
				sqlBuilder.append(wherePart);
			}

			List<String> orderPartList = this.getOrderPart();
			if (orderPartList != null && orderPartList.size() > 0) {
				orderPart = StringUtils.join(orderPartList, " and ");
				sqlBuilder.append(" order by ");
				sqlBuilder.append(orderPart);
			}

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
		}

		return sqlBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT name_wh,");
		sqlBuilder.append("name_mm,");
		sqlBuilder.append("name_srv,");
		sqlBuilder.append("name_fac,");
		sqlBuilder.append("spec,");
		sqlBuilder.append("batch,");
		sqlBuilder.append("date_expi,");
		sqlBuilder.append("name_pkgu,");
		sqlBuilder.append("pri_sa,");
		sqlBuilder.append("pri_act,");
		sqlBuilder.append("quan_stock,");
		sqlBuilder.append("code_mm,");
		sqlBuilder.append("id_bl,");
		sqlBuilder.append("pycode_mm,");
		sqlBuilder.append("wbcode_mm,");
		sqlBuilder.append("mnecode_mm,");
		sqlBuilder.append("id_wh ");
		sqlBuilder.append("FROM ");
		sqlBuilder.append("(SELECT mmbl.id_bl,");
		sqlBuilder.append("wh.name AS name_wh,");
		sqlBuilder.append("mm.name AS name_mm,");
		sqlBuilder.append("srv.name AS name_srv, ");
		sqlBuilder.append("fac.name AS name_fac,");
		sqlBuilder.append("mm.spec AS spec,");
		sqlBuilder.append("MMBL.BATCH AS BATCH,");
		sqlBuilder.append("MMBL.DATE_EXPI AS date_expi,");
		sqlBuilder.append("pkgu.name AS name_pkgu,");
		sqlBuilder.append("ROUND(MMBL.PRI_SA,2) AS pri_sa,");
		sqlBuilder.append("ROUND(MMBL.PRI_ACT,2) AS pri_act,");
		sqlBuilder.append("ROUND(MMBL.QUAN_STOCKACT,2) AS quan_stock,");
		sqlBuilder.append("mm.code AS code_mm,");
		sqlBuilder.append("MM.PYCODE AS pycode_mm,");
		sqlBuilder.append("MM.WBCODE AS wbcode_mm,");
		sqlBuilder.append("MM.MNECODE AS mnecode_mm, ");
		sqlBuilder.append("WH.ID_WH AS ID_WH ");
		sqlBuilder.append("FROM V_MM_BL_QUERY mmbl ");
		sqlBuilder.append("INNER JOIN bd_wh wh ");
		sqlBuilder.append("ON wh.id_wh = mmbl.id_wh ");
		sqlBuilder.append("INNER JOIN bd_mm mm ");
		sqlBuilder.append("ON mm.id_mm = mmbl.id_mm ");
		sqlBuilder.append("inner join bd_srv srv ");
		sqlBuilder.append("on mm.id_srv = srv.id_srv ");
		sqlBuilder.append("INNER JOIN bd_sup fac ");
		sqlBuilder.append("ON fac.id_sup = mmbl.id_sup ");
		sqlBuilder.append("INNER JOIN BD_MM_PKGU mmpkgu ");
		sqlBuilder.append("ON MMPKGU.ID_MMPKGU = MMBL.ID_UNIT_PKGACT ");
		sqlBuilder.append("INNER JOIN bd_measdoc pkgu ");
		sqlBuilder.append("ON pkgu.id_measdoc = MMPKGU.ID_UNIT_PKG ");
		sqlBuilder.append("WHERE ROUND(MMBL.QUAN_STOCKACT,2) >= 0");
		sqlBuilder.append(") storebl ");
		return sqlBuilder.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder("1 = 1");

		String whId = (String) this.getExtendAttributeValue("Id_wh");
		String wherePartStr = (String) this.getExtendAttributeValue("WherePart");

		if (StringUtils.isEmpty(whId)) {
			// 仓库为空时，尝试根据当前科室获取仓库
			whId = findWhIdByContextDep();
		}

		if (StringUtils.isNotEmpty(whId)) {
			// 过滤为指定仓库
			String wherePart = String.format(" and id_wh = '%s'", whId);
			stringBuilder.append(wherePart);
		} else {
			stringBuilder.append(" and 1 = 2");
		}

		if (StringUtils.isNotEmpty(wherePartStr)) {
			stringBuilder.append(" and ");
			stringBuilder.append(wherePartStr);
		}

		return stringBuilder.toString();
	}

	/**
	 * 根据当前科室获取仓库主键
	 * 
	 * @return
	 */
	private String findWhIdByContextDep() {
		try {
			String depId = Context.get().getDeptId();
			IWarehouseService warehouseService = ServiceFinder.find(IWarehouseService.class);
			WarehouseDO warehouseDO = warehouseService.findOwerWhByDepId(depId, FBoolean.TRUE);
			return warehouseDO.getId_wh();
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("pycode_mm");
		return stringBuilder.toString();
	}
}
