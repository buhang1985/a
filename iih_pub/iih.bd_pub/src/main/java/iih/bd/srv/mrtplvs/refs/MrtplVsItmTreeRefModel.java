package iih.bd.srv.mrtplvs.refs;

import iih.bd.srv.mrtplvs.d.BdMrtplVsItmDO;
import iih.bd.srv.mrtplvs.d.desc.BdMrtplVsItmDODesc;

import java.util.List;

import xap.sys.appfw.refinfo.RefTreeModel;

public class MrtplVsItmTreeRefModel extends RefTreeModel {

	private static final long serialVersionUID = 1L;

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] {"名称" };
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdMrtplVsItmDO.NAME };
	}

	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdMrtplVsItmDO.ID_MRTPL_VS_ITM, BdMrtplVsItmDO.ID_MRTPL_VS, BdMrtplVsItmDO.ID_DATAORIGIN };
	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { BdMrtplVsItmDO.NAME };
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return BdMrtplVsItmDODesc.TABLE_NAME;
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return BdMrtplVsItmDO.ID_MRTPL_VS_ITM;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return BdMrtplVsItmDO.NAME;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return BdMrtplVsItmDO.NAME;
	}

	/**
	 * 父子键树结构：子字段
	 */
	@Override
	public String getChildField() {
		return BdMrtplVsItmDO.ID_MRTPL_VS_ITM;
	}

	/**
	 * 父子键树结构：父字段
	 */
	@Override
	public String getFatherField() {
		return BdMrtplVsItmDO.ID_MRTPL_VS;
	}

	@Override
	public String getRefSql() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select									");
		sqlStr.append(" bd_mrtpl_vs_itm.name,                    ");
		sqlStr.append(" bd_mrtpl_vs_itm.id_mrtpl_vs_itm,        ");
		sqlStr.append(" bd_mrtpl_vs_itm.id_mrtpl_vs,            ");
		sqlStr.append(" bd_mrtpl_vs_itm.id_dataorigin          ");
		//sqlStr.append(" bd_mrtpl_vs_itm.code                    ");
		sqlStr.append(" from                                    ");
		sqlStr.append(" (                                       ");
		sqlStr.append("   (                                     ");
		sqlStr.append("     SELECT                              ");
		sqlStr.append("     vs.id_mrtpl_vs  id_mrtpl_vs_itm,    ");
		sqlStr.append("     vs.code,                            ");
		sqlStr.append("     vs.name,                          	");
		sqlStr.append("     null as id_mrtpl_vs,                ");
		sqlStr.append("     vs.sortno,                          ");
		sqlStr.append("     null as id_dataorigin               ");
		sqlStr.append("     FROM bd_mrtpl_vs vs                 ");
		sqlStr.append("   )                                     ");
		sqlStr.append("   UNION                                 ");
		sqlStr.append("   (                                     ");
		sqlStr.append("     SELECT                              ");
		sqlStr.append("     bd_mrtpl_vs_itm.id_mrtpl_vs_itm,    ");
		sqlStr.append("     bd_mrtpl_vs_itm.code,               ");
		sqlStr.append("     bd_mrtpl_vs_itm.name,               ");
		sqlStr.append("     bd_mrtpl_vs_itm.id_mrtpl_vs,        ");
		sqlStr.append("     bd_mrtpl_vs_itm.sortno,             ");
		sqlStr.append("     bd_mrtpl_vs_itm.id_dataorigin       ");
		sqlStr.append("     FROM bd_mrtpl_vs_itm                ");
		sqlStr.append("   )              			            ");
		sqlStr.append(" )bd_mrtpl_vs_itm                        ");
		sqlStr.append(" where 1 = 1                             ");
		List<String> wherePartList = this.getWherePart();
		if (wherePartList != null && wherePartList.size() > 0) {
			for (String wherePart : wherePartList) {
				sqlStr.append(" and " + wherePart);
			}
		}
		List<String> orderByList = this.getOrderPart();
		sqlStr.append(" order by bd_mrtpl_vs_itm.code asc,bd_mrtpl_vs_itm.sortno asc ");
		if (orderByList != null && orderByList.size() > 0) {
			for (String orderby : orderByList) {
				sqlStr.append("," + orderby);
			}
		}
		return sqlStr.toString();
	}
}
