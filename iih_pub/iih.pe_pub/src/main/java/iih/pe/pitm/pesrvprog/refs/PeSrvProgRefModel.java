package iih.pe.pitm.pesrvprog.refs;

import iih.pe.pitm.pesrvprog.d.PeSrvProgDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeSrvProgRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{PeSrvProgDO.CODE,PeSrvProgDO.NAME};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{PeSrvProgDO.ID_PESRVPROG};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","名称"};
	}
	
	@Override
	public String getPkFieldCode() {
		return PeSrvProgDO.ID_PESRVPROG;
	}
	
	@Override
	public String getRefCodeField() {
		return PeSrvProgDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return PeSrvProgDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new PeSrvProgDO().getTableName();
	}

}
