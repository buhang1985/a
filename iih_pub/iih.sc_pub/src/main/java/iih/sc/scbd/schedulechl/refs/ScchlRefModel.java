package iih.sc.scbd.schedulechl.refs;

import java.util.ArrayList;
import java.util.List;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import xap.mw.core.utils.ListUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**排班渠道参照模型
 * @author ccj
 *
 */
public class ScchlRefModel extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{SchedulechlDO.CODE,SchedulechlDO.NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{SchedulechlDO.ID_SCCHL};
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
		return new String[]{"pycode","wbcode","mnecode","code","name"};
	}

	@Override
	public String getPkFieldCode() {
		return SchedulechlDO.ID_SCCHL;
	}

	@Override
	public String getRefCodeField() {
		return SchedulechlDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return SchedulechlDO.NAME;
	}
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();
		whereParts.addAll(super.getWherePart());
		//增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new SchedulechlDO(), false));
		return whereParts;
	}
	/**
	 * 增加排序，以编码排序
	 */
	@Override
	public List<String> getOrderPart() {
		List<String> list = super.getOrderPart();
		if(ListUtil.isEmpty(list))
			list = new ArrayList<>();
		list.add(SchedulechlDO.CODE);
		return list;
	}
	@Override
	public String getTableName() {
		return new SchedulechlDO().getTableName();
	}
}
