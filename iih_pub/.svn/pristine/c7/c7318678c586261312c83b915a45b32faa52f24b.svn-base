package iih.nm.nqm.nmnqmcs.refs;

import iih.nm.nqm.nmnqmcs.d.NmNqmCsDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmNqmCsRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{NmNqmCsDO.CODE,NmNqmCsDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","名称"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{NmNqmCsDO.ID_NQM_CS,NmNqmCsDO.FPY,NmNqmCsDO.SCORE};
	}
	
	@Override
	public String getPkFieldCode() {
		return NmNqmCsDO.ID_NQM_CS;
	}
	
	@Override
	public String getRefCodeField() {
		return NmNqmCsDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return NmNqmCsDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new NmNqmCsDO().getTableName();
	}
	
	@Override
	public String[] getBlurFields() {
		return super.getBlurFields();
	}
}
