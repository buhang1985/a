package iih.nm.nit.nitpracgrp.refs;

import iih.nm.nit.nitpracgrp.d.NitPracgrpDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NitPracGrpRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{NitPracgrpDO.CODE,NitPracgrpDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[]{"小组编号","小组名称"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{NitPracgrpDO.ID_PRACGRP};
	}
	
	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return NitPracgrpDO.ID_PRACGRP;
	}
	
	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return NitPracgrpDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return NitPracgrpDO.NAME;
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new NitPracgrpDO().getTableName();
	}
	
	@Override
	public String[] getBlurFields() {
		// TODO Auto-generated method stub
		return super.getBlurFields();
	}
}
