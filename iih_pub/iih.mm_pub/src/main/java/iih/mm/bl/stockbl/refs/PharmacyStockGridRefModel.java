package iih.mm.bl.stockbl.refs;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.utils.BdEnvContextUtil;
import iih.mm.bl.stockbl.d.StockBlDO;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.orgfw.dept.d.DeptDO;

public class PharmacyStockGridRefModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return (new String[] { "code", "name", "stock", "mmpkguname" });
	}

	@Override
	public String[] getHiddenFieldCode() {
		return (new String[] { "id_pharmacystockkey", "id_dep" });
	}

	@Override
	public String[] getShowFieldName() {
		return (new String[] { "编码", "药房", "结存", "单位" });
	}

	@Override
	public String getPkFieldCode() {
		return "id_pharmacystockkey";
	}

	@Override
	public String getRefCodeField() {
		return "code";
	}

	@Override
	public String getRefNameField() {
		return "name";
	}

	@Override
	public String getTableName() {
		return "dep";
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "name","code","pycode","wbcode","mnecode" };
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
				if (wherePart.contains("dep.id_pharmacystockkey")) {
					wherePart = wherePart.replace("dep.id_pharmacystockkey", "mmbl.id_pharmacystockkey");
				}
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

	private String getBaseSql() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT DEP.CODE, ");
		sb.append(" 	   DEP.NAME, ");
		sb.append(" 	   MMBL.STOCK, ");
		sb.append(" 	   MMBL.MMPKGUNAME, ");
		sb.append("        ID_PHARMACYSTOCKKEY, ");
		sb.append(" 	   DEP.ID_DEP, ");
		sb.append(" 	   DEP.PYCODE, ");
		sb.append(" 	   DEP.WBCODE, ");
		sb.append(" 	   DEP.MNECODE ");
		sb.append(" FROM BD_DEP DEP");
		sb.append(" INNER JOIN BD_WH WH ");
		sb.append(" ON DEP.ID_DEP = WH.ID_DEP_BELONG ");
		sb.append(" INNER JOIN ("+ getSumStock() +") MMBL ");
		sb.append(" ON MMBL.ID_WH = WH.ID_WH ");
		return sb.toString();
	}

	private String getSumStock() {
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new StockBlDO(), "BL");
		String idmm = (String) this.getExtendAttributeValue("Id_mm");
		String idMmpkgu = (String) this.getExtendAttributeValue("Id_mmpkgu");
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT BL.ID_WH || BL.ID_MM AS ID_PHARMACYSTOCKKEY, ");
		sb.append("  BL.ID_WH,BL.ID_MM,MMPKGU.MMPKGUNAME, ");
		sb.append("  SUM(BL.QUAN_USABLE/MMPKGU.FACTOR) AS STOCK ");
		sb.append(" FROM MM_BL BL ");
		sb.append(" INNER JOIN BD_MM_PKGU MMPKGU ");
		sb.append(" ON MMPKGU.ID_MMPKGU = BL.ID_UNIT_PKGBASE ");
		sb.append(" WHERE BL.DS = 0 AND BL.FG_STOP = 'N' ");
		sb.append(" and nvl(BL.fg_stop_chgpri, 'N') = 'N' ");
		sb.append(" and nvl(BL.fg_expired, 'N') = 'N' ");
		sb.append(" and nvl(BL.fg_close, 'N') = 'N' ");
		sb.append(String.format(" AND %s ", BdModeWherePart));
		if (StringUtils.isNotEmpty(idmm)) {
			String wherePart = String.format(" AND BL.ID_MM = '%s'", idmm);
			sb.append(wherePart);
		}
		sb.append(" GROUP BY BL.ID_MM,BL.ID_WH,MMPKGU.MMPKGUNAME ");
		return sb.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DeptDO(), "DEP");
		stringBuilder.append(String.format(" AND %s ", BdModeWherePart));

		String wherePartStr = (String) this.getExtendAttributeValue("WherePart");
		if (StringUtils.isNotEmpty(wherePartStr)) {
			stringBuilder.append(" and ");
			stringBuilder.append(wherePartStr);
		}
		return stringBuilder.toString();
	}
	
	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" DEP.PYCODE ");
		return stringBuilder.toString();
	}
}
