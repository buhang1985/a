package iih.mp.mpbd.patvstagt.refs;

import iih.mp.mpbd.patvstagt.d.PatVsTagtDO;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PatVsTagtFunReModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PatVsTagtDO.CODE, PatVsTagtDO.NAME,PatVsTagtDO.NAME_SHORT };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PatVsTagtDO.ID_VS_TAGT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称","简称" };
	}

	@Override
	public String getPkFieldCode() {
		return PatVsTagtDO.ID_VS_TAGT;
	}

	@Override
	public String getTableName() {
		return new PatVsTagtDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return PatVsTagtDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PatVsTagtDO.NAME_SHORT;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { PatVsTagtDO.CODE, PatVsTagtDO.NAME };
	}

	@Override
	public String getRefSql() {
		StringBuffer str = new StringBuffer();
		str.append(" select mp_vs_tagt.code, mp_vs_tagt.name,mp_vs_tagt.name_short, mp_vs_tagt.id_vs_tagt				");
		str.append(" from mp_vs_tagt mp_vs_tagt           																");
		str.append(" inner join mp_vs_tagt_fun mp_vs_tagt_fun on mp_vs_tagt_fun.id_vs_tagt = mp_vs_tagt.id_vs_tagt      ");
		str.append(" where mp_vs_tagt_fun.fg_active = 'Y'            													");
		if (!ArrayUtil.isEmptyNoNull(this.getWherePart().toArray(new String[0]))) {
			for (String where : this.getWherePart()) {
				str.append(" and " + where);
			}
		}
		str.append(" order by mp_vs_tagt_fun.sortno asc																	");
		return str.toString();
	}

}
