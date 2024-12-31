package iih.nm.nhr.institutabatch.refs;

import iih.nm.nhr.institutabatch.d.NmStuOrgDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmStuOrgModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{NmStuOrgDO.NAME, NmStuOrgDO.ID_STU_ORG};
	}
	
	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[]{"机构名称","机构id"};
	}
	
	@Override 
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{NmStuOrgDO.CODE};
	}
	
	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return NmStuOrgDO.ID_STU_ORG;
	}
	
	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return NmStuOrgDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return NmStuOrgDO.NAME;
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new NmStuOrgDO().getTableName();
	}
	
	@Override
	public String[] getBlurFields() {
		// TODO Auto-generated method stub
		return super.getBlurFields();
	}
}
