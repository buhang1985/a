package iih.mp.mpbd.patvstagt.refs;

import iih.mp.mpbd.patvstagt.d.PatVsTagtDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PatVsTagtRefModel  extends RefGridModel{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode(){
		return new String[] { PatVsTagtDO.CODE, PatVsTagtDO.NAME, PatVsTagtDO.NAME_SHORT };
	}
	@Override
	public String[] getHiddenFieldCode(){
		return new String[]{PatVsTagtDO.ID_VS_TAGT};
	}
	@Override
	public String[] getShowFieldName(){
		return new String[] { "编码", "名称", "简称" };
	}
	@Override
	public String getPkFieldCode(){
		return PatVsTagtDO.ID_VS_TAGT;
	}
	@Override
	public String getTableName(){
		return new PatVsTagtDO().getTableName();
	}
	@Override
	public String getRefCodeField(){
		return PatVsTagtDO.CODE;
	}
	@Override
	public String getRefNameField(){
		return PatVsTagtDO.NAME_SHORT;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{PatVsTagtDO.CODE,PatVsTagtDO.NAME};
	}
}
