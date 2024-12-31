package iih.mkr.std.commonde.refs;

import java.util.List;

import iih.mkr.std.commonde.d.DataElementDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 公共数据元参照模型
 * 
 * @author yy.zhao
 *
 */
public class DeSetRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3371122101739592875L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DataElementDO.CODE, DataElementDO.NAME, DataElementDO.FIELDNAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DataElementDO.ID_DE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "FIELDNAME" };
	}

	@Override
	public String getTableName() {
		return new DataElementDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DataElementDO.CODE, DataElementDO.WBCODE, DataElementDO.PYCODE, DataElementDO.NAME,
				DataElementDO.MNECODE };
	}

	@Override
	public String getPkFieldCode() {
		return DataElementDO.ID_DE;
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
		String idSet = (String) this.getExtendAttributeValue("id_set");
		String wherePart = BuildWherePart();

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select* from (                                                               ");
		stringBuilder.append(
				" select bdde.code,bdde.name as name,bdde.fieldname,bdde.id_de,bdset.id_set,bdde.Wbcode,bdde.Pycode,bdde.Mnecode from bd_de bdde                                                               ");
		stringBuilder.append(
				" inner join bd_dg_de dgde on dgde.id_de = bdde.id_de                                         ");
		stringBuilder.append(
				" inner join bd_dg bddg on bddg.id_dg = dgde.id_dg                                            ");
		stringBuilder.append(
				" inner join bd_set_dg setdg on  setdg.id_dg = bddg.id_dg or setdg.id_dg = bddg.id_parent     ");
		stringBuilder.append(
				" inner join bd_set bdset on bdset.id_set = setdg.id_set                           ) bd_de     ");
		stringBuilder.append(" where 1=1                  ");

		if (wherePart != null && !"".equals(wherePart)) {
			this.getWherePart().add(wherePart);
		}
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {

			for (String where : whereList) {
				stringBuilder.append(" and ").append(where).append(" ");
			}
		}

		List<String> orderList = this.getOrderPart();
		if (orderList.size() > 0) {
			stringBuilder.append(" order by ");
			for (int i = 0; i < orderList.size(); i++) {
				String order = orderList.get(i);
				stringBuilder.append((i == 0 ? "" : ",") + order);
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		String id_set = (String) this.getExtendAttributeValue("id_set");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" bd_de.id_set = '" + id_set + "'");
		return stringBuilder.toString();
	}
}
