package iih.sc.scp.scplan.refs;


import java.util.ArrayList;
import java.util.List;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**计划参照模型
 * @author ccj
 * 
 */
public class ScplanRefModel  extends RefGridModel  {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{ScPlanDO.CODE,ScPlanDO.NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{ScPlanDO.ID_SCPL,ScPlanDO.ID_DEPPARAM};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","名称"};
	}


	/* 
	 *  拼音、五笔、助记码 过滤
	 */
	@Override
	public String[] getBlurFields() {
		return new String[]{"pycode","wbcode","instr","code","name"};
	}

	@Override
	public String getPkFieldCode() {
		return ScPlanDO.ID_SCPL;
	}

	@Override
	public String getRefCodeField() {
		return ScPlanDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ScPlanDO.NAME;
	}

	@Override
	public String getTableName() {
		return new ScPlanDO().getTableName();
	}
	
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();
		whereParts.addAll(super.getWherePart());
		//增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new ScPlanDO(), false));
		return whereParts;
	}
	@Override
	public List<String> getOrderPart() {
		// TODO Auto-generated method stub
		List<String > str = super.getOrderPart();
		if(!str.contains(ScPlanDO.CODE))
		str.add(ScPlanDO.CODE);
		return str;
	}
}
