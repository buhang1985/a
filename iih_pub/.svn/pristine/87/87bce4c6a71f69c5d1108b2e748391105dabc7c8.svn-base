package iih.nm.nqm.nmnqmsuper.refs;

import iih.nm.nqm.nmnqmsuper.d.NmNqmSuperItmDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmNqmSuperItemModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{NmNqmSuperItmDO.CODE,NmNqmSuperItmDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","名称"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{NmNqmSuperItmDO.ID_NQM_SUPER_ITM};
	}
	
	@Override
	public String getPkFieldCode() {
		return NmNqmSuperItmDO.ID_NQM_SUPER_ITM;
	}
	
	@Override
	public String getRefCodeField() {
		return NmNqmSuperItmDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return NmNqmSuperItmDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new NmNqmSuperItmDO().getTableName();
	}
	
	@Override
	public String[] getBlurFields() {
		return super.getBlurFields();
	}
}
