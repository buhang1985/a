package iih.sc.scbd.screleaserule.refs;


import java.util.ArrayList;
import java.util.List;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.screleaserule.d.ScReleaseRuleDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**排班释放规则参照模型
 * @author yzh
 * 
 */
public class ScreleaseruleRefModel  extends RefGridModel  {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{ScReleaseRuleDO.CODE,ScReleaseRuleDO.NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{ScReleaseRuleDO.ID_RELEASE_RULE,ScReleaseRuleDO.ID_SCCA};
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
		return ScReleaseRuleDO.ID_RELEASE_RULE;
	}

	@Override
	public String getRefCodeField() {
		return ScReleaseRuleDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ScReleaseRuleDO.NAME;
	}

	@Override
	public String getTableName() {
		return new ScReleaseRuleDO().getTableName();
	}
	
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();
		whereParts.addAll(super.getWherePart());
		//增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new ScReleaseRuleDO(), false));
		return whereParts;
	}
	@Override
	public List<String> getOrderPart() {
		// TODO Auto-generated method stub
		List<String > str = super.getOrderPart();
		if(!str.contains(ScReleaseRuleDO.CODE))
		str.add(ScReleaseRuleDO.CODE);
		return str;
	}
}
