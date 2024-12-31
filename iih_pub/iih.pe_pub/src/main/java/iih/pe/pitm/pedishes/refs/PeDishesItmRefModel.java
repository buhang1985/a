package iih.pe.pitm.pedishes.refs;

import iih.pe.pitm.pedishes.d.PeDishesItmDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeDishesItmRefModel extends RefGridModel {

	/**
	 * 体检食物菜单内容参照
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {

		return new String[] { PeDishesItmDO.NAME_COMP, PeDishesItmDO.CODE_COMP };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "名称", "编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PeDishesItmDO.ID_PEDISHESITM};
	}

	@Override
	public String getPkFieldCode() {
		return PeDishesItmDO.ID_PEDISHESITM;
	}
	
	@Override
	public String getRefCodeField() {
		return PeDishesItmDO.CODE_COMP;
	}

	@Override
	public String getRefNameField() {
		return PeDishesItmDO.NAME_COMP;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { PeDishesItmDO.CODE_COMP, PeDishesItmDO.NAME_COMP};
	}
	
	@Override
	public String getTableName() {
		return new PeDishesItmDO().getTableName();
	}
	
	/*@Override
	public String getRefSql() {	
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append("select pe_or_pecorpbinfo.name,  pe_or_pecorpbinfo.code, pe_or_pecorpbinfo.id_cust, pe_or_pecorpbinfo.id_pecorpbinfo from pe_or_pecorpbinfo pe_or_pecorpbinfo ");
		SqlStr.append(" inner join pe_apt_pecorpappt apt on pe_or_pecorpbinfo.id_pecorpbinfo =apt.id_pecorpbinfo ");
		SqlStr.append(" inner join pe_or_pecorpcharge c on apt.ID_PECORPAPPT =c.ID_PECORPAPPT ");
		SqlStr.append(" WHERE 1 = 1 ");	
		SqlStr.append(" and c.fg_charged = 'N' ");	
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				SqlStr.append(" And (").append(where).append(") ");
			}
		}

		return SqlStr.toString();
	}*/

	/*@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		listWhereParts.add(PeEnvContextUtil.processEnvContext(new PeDishesDO(), " pe_or_pecorpbinfo "));
		return listWhereParts;
	}*/
	
}
