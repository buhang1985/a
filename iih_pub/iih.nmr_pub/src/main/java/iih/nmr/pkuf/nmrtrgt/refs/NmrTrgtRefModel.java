package iih.nmr.pkuf.nmrtrgt.refs;

import iih.nmr.pkuf.nmrfactor.d.NRMFactorDO;
import iih.nmr.pkuf.nmrtrgt.d.NmrTrgtDO;
import iih.nmr.pkuf.nmrtrgt.d.desc.NmrTrgtDODesc;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

public class NmrTrgtRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {

		return new String[] { "code", "name" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] {"id_nmr_trgt"};
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "编码", "目标名称" };
	}
	
	@Override
	public String getPkFieldCode() {
		return "id_nmr_trgt";
	}

	@Override
	public String getRefCodeField() {

		return NmrTrgtDO.CODE;
	}

	@Override
	public String getRefNameField() {

		return NmrTrgtDO.NAME;
	}

	@Override
	public String getTableName() {
		return NmrTrgtDODesc.TABLE_NAME;
	}

	@Override
	public String getRefSql() {
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append("   select                                                                                         ");
		SqlStr.append("   distinct nmr_trgt.code,                                                                        ");
		SqlStr.append("   nmr_trgt.name as name_trgt ,                                                                   ");
		SqlStr.append("   dttrgt.id_nmr_trgt                                                                             ");
		SqlStr.append("   from NMR_DI_TRGT dttrgt                                                                        ");
		SqlStr.append("   left join NMR_TRGT nmr_trgt on dttrgt.id_nmr_trgt = nmr_trgt.id_nmr_trgt                       ");
		SqlStr.append("   left join NMR_DI dt on dttrgt.id_nmr_di = dt.id_nmr_di                                         ");
		SqlStr.append("   where 1=1                                                                                      ");
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
		return new String[]{"name","code"};
	}
}
