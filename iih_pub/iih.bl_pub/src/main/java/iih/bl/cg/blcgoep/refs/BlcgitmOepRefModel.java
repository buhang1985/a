package iih.bl.cg.blcgoep.refs;

import xap.sys.appfw.refinfo.RefGridModel;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;

public class BlcgitmOepRefModel extends RefGridModel{

	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{BlCgItmOepDO.AMT_STD};
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{BlCgItmOepDO.ID_CGITMOEP};
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[]{"标准金额"};
	}

	@Override
	public String[] getBlurFields() {
		// TODO Auto-generated method stub
		return super.getBlurFields();
	}

	@Override
	public String getRefTitle() {
		// TODO Auto-generated method stub
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return BlCgItmOepDO.ID_CGITMOEP;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return BlCgItmOepDO.AMT_STD;
	}

	

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new BlCgItmOepDO().getTableName();
	}
	
	
}
