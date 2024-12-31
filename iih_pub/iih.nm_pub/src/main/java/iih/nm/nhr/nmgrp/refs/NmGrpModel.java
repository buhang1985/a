package iih.nm.nhr.nmgrp.refs;

import iih.nm.nhr.nmgrp.d.NmGrpDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmGrpModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{NmGrpDO.CODE,NmGrpDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[]{"小组编号","小组名称"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{NmGrpDO.ID_NM_GRP};
	}
	
	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return NmGrpDO.ID_NM_GRP;
	}
	
	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return NmGrpDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return NmGrpDO.NAME;
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new NmGrpDO().getTableName();
	}
	
	@Override
	public String[] getBlurFields() {
		// TODO Auto-generated method stub
		return super.getBlurFields();
	}
}
