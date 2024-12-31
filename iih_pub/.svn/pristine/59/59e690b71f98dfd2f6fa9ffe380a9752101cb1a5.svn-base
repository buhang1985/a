package iih.nmr.pkuf.nmrfactor.refs;

import iih.nmr.pkuf.nmrfactor.d.NRMFactorDO;
import iih.nmr.pkuf.nmrfactor.d.desc.NRMFactorDODesc;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class NRMFactorRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {

//		return new String[] { "id_nmr_factor", "name_factor", "id_nmr_di" };
		

		return new String[] {"code","name" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return new String[] {"id_nmr_factor"};
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "编码", "因素名称" };
	}

	@Override
	public String getPkFieldCode() {
		return "id_nmr_factor";
	}
	
	@Override
	public String getRefCodeField() {
		
		return NRMFactorDO.CODE;
	}
	

	@Override
	public String getRefNameField() {

		return NRMFactorDO.NAME;
	}

	@Override
	public String getTableName() {
		return NRMFactorDODesc.TABLE_NAME ;
	}

	@Override
	public String getRefSql() {
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append("   select                                                                                          ");
		SqlStr.append("   distinct nmr_factor.code,                                                                       ");
		SqlStr.append("   nmr_factor.name as name_factor,                                                                 ");
		SqlStr.append("   dtfactor.id_nmr_factor                                                                          ");
		SqlStr.append("   from NMR_DI_FACTOR dtfactor                                                                     ");
		SqlStr.append("   left join NMR_FACTOR nmr_factor on dtfactor.id_nmr_factor = nmr_factor.id_nmr_factor            ");
		SqlStr.append("   left join NMR_DI dt on dtfactor.id_nmr_di = dt.id_nmr_di                                        ");
		SqlStr.append("   where 1=1                                                                          			  ");		
		StringBuilder sb = new StringBuilder(SqlStr);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
		return sb.toString();		
	}

	@Override
	public String[] getBlurFields() {
		return new String[]{"name","code"};
	}
}

