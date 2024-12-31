package iih.mkr.std.commonde.refs;

import java.util.List;

import ca.krasnay.sqlbuilder.SelectBuilder;
import iih.mkr.std.commonde.d.DataElementDO;
import iih.mkr.utils.MkrEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 数据集参照模型
 * 
 * @author yy.zhao_2018年3月13日14:35:22
 *
 */
public class DeNmrNuRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DataElementDO.CODE, DataElementDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DataElementDO.ID_DE, DataElementDO.FIELDNAME,
				 };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DataElementDO.CODE,DataElementDO.NAME,};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DataElementDO.ID_DE;
	}

	@Override
	public String getTableName() {
		return new DataElementDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return DataElementDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return DataElementDO.NAME;
	}

	@Override
	public String getRefSql() {

		StringBuffer sqlStr = new StringBuffer();
		
		sqlStr.append("   select distinct bd_de.code,bd_de.name,bd_de.id_de,bd_de.fieldname from bd_de bd_de    ");
		sqlStr.append("   left join bd_dg_de dgde on bd_de.id_de = dgde.id_de              ");
		sqlStr.append("   left join bd_dg bddg on  bddg.id_dg=dgde.id_dg                  ");
		sqlStr.append("   left join bd_set_dg setdg on bddg.id_parent  = setdg.id_dg      ");
		sqlStr.append("   where 1=1                      ");

		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : whereList) {
				sqlStr.append(" and (").append(where).append(") ");
			}
		}

		List<String> orderList = this.getOrderPart();
		if (orderList.size() > 0) {
			sqlStr.append(" order by ");
			for (int i = 0; i < orderList.size(); i++) {
				String order = orderList.get(i);
				sqlStr.append((i == 0 ? "" : ",") + order);
			}
		}
		return sqlStr.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		String BdModeWherePart = MkrEnvContextUtil.processEnvContext(
				new DataElementDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", DataElementDO.CODE));
		return stringBuilder.toString();
	}
}
