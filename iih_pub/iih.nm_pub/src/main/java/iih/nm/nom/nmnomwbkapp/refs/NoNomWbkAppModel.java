package iih.nm.nom.nmnomwbkapp.refs;

import iih.nm.nom.nmnomwbkapp.d.NmNomWbkAppDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NoNomWbkAppModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{NmNomWbkAppDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[]{"手册名称"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{NmNomWbkAppDO.ID_NOM_WBK_APP};
	}
	
	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return NmNomWbkAppDO.ID_NOM_WBK_APP;
	}
	
    @Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return NmNomWbkAppDO.ID_NOM_WBK_APP;
	}
	
	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return NmNomWbkAppDO.NAME;
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new NmNomWbkAppDO().getTableName();
	}
	
	@Override
	public String[] getBlurFields() {
		// TODO Auto-generated method stub
		return super.getBlurFields();
	}
}
