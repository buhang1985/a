package iih.nmr.pkuf.nmrmea.refs;

import iih.nmr.pkuf.nmrmea.d.NmrMeaDO;
import iih.nmr.pkuf.nmrmea.d.desc.NmrMeaDODesc;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

public class NmrMeaRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {

		return new String[] { "code", "name" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { "id_nmr_mea" };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "编码", "目标名称" };
	}

	@Override
	public String getPkFieldCode() {
		return "id_nmr_mea";
	}

	@Override
	public String getRefCodeField() {

		return NmrMeaDO.CODE;
	}

	@Override
	public String getRefNameField() {

		return NmrMeaDO.NAME;
	}

	@Override
	public String getTableName() {
		return NmrMeaDODesc.TABLE_NAME;
	}

	@Override
	public String getRefSql() {
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append("   select                                                                                           ");
		SqlStr.append("   distinct nmr_mea.code,                                                                           ");
		SqlStr.append("   nmr_mea.name as name_mea,                                                                        ");
		SqlStr.append("   dtmea.id_nmr_mea                                                                                 ");
		SqlStr.append("   from NMR_DI_MEA dtmea                                                                            ");
		SqlStr.append("   left join NMR_MEA nmr_mea on dtmea.id_nmr_mea = nmr_mea.id_nmr_mea                               ");
		SqlStr.append("   left join NMR_DI dt on dtmea.id_nmr_di = dt.id_nmr_di                                            ");
		SqlStr.append("   where 1=1                                                                                        ");
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				SqlStr.append(" And (").append(where).append(") ");
			}
		}

		return SqlStr.toString();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "name", "code" };
	}
}
