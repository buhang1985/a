package iih.pe.pitm.penarraterecipe.refs;

import iih.pe.pitm.penarraterecipe.d.PeNarrateRecipeDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class PeNarrateRecipeRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{PeNarrateRecipeDO.CODE,PeNarrateRecipeDO.NAME,PeNarrateRecipeDO.PRESCRIPTION};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{PeNarrateRecipeDO.ID_PENARRATERECIPE};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","名称","处方内容"};
	}
	
	@Override
	public String getPkFieldCode() {
		return PeNarrateRecipeDO.ID_PENARRATERECIPE;
	}
	
	@Override
	public String getRefCodeField() {
		return PeNarrateRecipeDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return PeNarrateRecipeDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new PeNarrateRecipeDO().getTableName();
	}

}
