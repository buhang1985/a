package iih.bd.cmp.marplan.refs;

import iih.bd.cmp.marplan.d.BdCmpMarPlanDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 
* @ClassName: BdMarPlanStdModel  
* @Description: 营销方案标准参照
* @author xy.zhou
* @date 2019年3月22日
 */
public class BdMarPlanStdModel extends RefGridModel{

	 
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{BdCmpMarPlanDO.NAME, BdCmpMarPlanDO.CODE};
	}
	
	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[]{"方案名称","方案编码"};
	}
	
	@Override 
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{BdCmpMarPlanDO.ID_MARPLAN};
	}
	
	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return BdCmpMarPlanDO.ID_MARPLAN;
	}
	
	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return BdCmpMarPlanDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return BdCmpMarPlanDO.NAME;
	}
	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new BdCmpMarPlanDO().getTableName();
	}
	@Override
	public String[] getBlurFields() {
		// TODO Auto-generated method stub
		return super.getBlurFields();
	}
}
