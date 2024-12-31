package iih.nm.nqm.nmnqmcstmpl.ref;

import iih.nm.nqm.nmnqmcstmpl.d.NmnqmcstmplDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmNqmCsTmplRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{NmnqmcstmplDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"名称"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{NmnqmcstmplDO.ID_NQM_TMPL};
	}
	
	@Override
	public String getPkFieldCode() {
		return NmnqmcstmplDO.ID_NQM_TMPL;
	}
	
	@Override
	public String getRefCodeField() {
		return NmnqmcstmplDO.ID_NQM_TMPL;
	}
	
	@Override
	public String getRefNameField() {
		return NmnqmcstmplDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new NmnqmcstmplDO().getTableName();
	}
	
	@Override
	public String[] getBlurFields() {
		return super.getBlurFields();
	}
}
