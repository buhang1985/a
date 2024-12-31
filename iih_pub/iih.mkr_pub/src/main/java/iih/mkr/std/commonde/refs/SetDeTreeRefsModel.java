package iih.mkr.std.commonde.refs;

import java.util.List;

import iih.mkr.std.commonde.d.DataElementDO;
import iih.mkr.std.commonde.d.desc.DataElementDODesc;
import iih.mkr.std.dedg.d.DeDataGrpDO;
import iih.mkr.std.dedg.d.desc.DeDataGrpDODesc;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefTreeGridModel;

public class SetDeTreeRefsModel extends RefTreeGridModel {

	// 列表

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { DataElementDO.CODE, DataElementDO.NAME };
	}

	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DataElementDO.ID_DE, DataElementDO.FIELDNAME };
	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { DataElementDO.CODE, DataElementDO.NAME, DataElementDO.PYCODE, DataElementDO.WBCODE, DataElementDO.MNECODE };
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return DataElementDODesc.TABLE_NAME;
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return DataElementDO.ID_DE;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return DataElementDO.CODE;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return DataElementDO.NAME;
	}

	/**
	 * 右表和左树连接的字段
	 */
	@Override
	public String getDocJoinField() {
		return DataElementDO.DEF1;
	}

	/**
	 * 右表SQL
	 * 
	 * @return
	 */
	@Override
	public String getRefSql() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                               ");
		sqlStr.append(" bd_de.code,                                          ");
		sqlStr.append(" bd_de.name,                                          ");
		sqlStr.append(" bd_de.id_de,                                         ");
		sqlStr.append(" dgde.id_dg as def1                                   ");
		sqlStr.append(" from bd_dg_de dgde                                   ");
		sqlStr.append(" left join bd_de bd_de on dgde.id_de = bd_de.id_de    ");
		String id_set = this.getClassJoinValue();
		sqlStr.append(" where dgde.id_dg = '" + id_set + "'");
		List<String> wherePart = this.getWherePart();
		for (String where : wherePart) {
			sqlStr.append(" and " + where);
		}
		sqlStr.append(" order by bd_de.code asc                              ");
		return sqlStr.toString();
	}

	// 树

	/**
	 * 分类表名
	 */
	@Override
	public String getClassTableName() {
		return DeDataGrpDODesc.TABLE_NAME;
	}

	/**
	 * 分类字段名数组
	 */
	@Override
	public String[] getClassFieldCode() {
		return new String[] { DeDataGrpDO.CODE, DeDataGrpDO.NAME, DeDataGrpDO.ID_DG, DeDataGrpDO.ID_PARENT };
	}

	/**
	 * 分类名称字段
	 */
	@Override
	public String getClassRefNameField() {
		return DeDataGrpDO.NAME;
	}

	/**
	 * 分类编码字段
	 */
	@Override
	public String getClassRefCodeField() {
		return DeDataGrpDO.CODE;
	}

	/**
	 * 分类主键字段
	 */
	@Override
	public String getClassPkFieldCode() {
		return DeDataGrpDO.ID_DG;
	}

	/**
	 * 左树中，与右表连接的字段
	 */
	@Override
	public String getClassJoinField() {
		return DeDataGrpDO.ID_DG;
	}

	/**
	 * 父子键树结构：子字段。左树右表中，用于描述左分类的树结构。
	 */
	@Override
	public String getChildField() {
		return DeDataGrpDO.ID_DG;
	}

	/**
	 * 父子键树结构：父字段。左树右表中，用于描述左分类的树结构。
	 */
	@Override
	public String getFatherField() {
		return DeDataGrpDO.ID_PARENT;
	}

	/**
	 * 返回分类数据查询过滤条件数组
	 */
	@Override
	public String[] getClassWherePart() {
		return new String[] { "ds = 0" };
	}

	/**
	 * 返回分类数据查询排序条件
	 */
	@Override
	public String[] getClassOrderPart() {
		return new String[] { DeDataGrpDO.CODE, DeDataGrpDO.NAME };
	}

	/**
	 * 左树SQL
	 * 
	 * @return
	 */
	@Override
	public String getClassRefSql() {
		String id_set = (String) this.getExtendAttributeValue("id_set");
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                         ");
		sqlStr.append(" bddg.code,                                                     ");
		sqlStr.append(" bddg.name,                                                     ");
		sqlStr.append(" bddg.id_dg,                                                    ");
		sqlStr.append(" bddg.id_parent                                                 ");
		sqlStr.append(" from bd_dg bddg                                                ");
		sqlStr.append(" where 1=1                                                      ");
		if (!StringUtil.isEmptyWithTrim(id_set)) {
			sqlStr.append(" and bddg.innercode like                                    ");
			sqlStr.append(" (                                                          ");
			sqlStr.append("   select dg.innercode||'%'                                 ");
			sqlStr.append("   from bd_set_dg setdg                                     ");
			sqlStr.append("   inner join bd_set bdset on bdset.id_set = setdg.id_set   ");
			sqlStr.append("   inner join bd_dg dg on dg.id_dg = setdg.id_dg            ");
			sqlStr.append("   where bdset.id_set='" + id_set + "'                      ");
			sqlStr.append(" )and nvl(bddg.innercode,'~') <> '~'                        ");
			sqlStr.append(" order by code asc;                                         ");
		}
		return sqlStr.toString();
	}
}
