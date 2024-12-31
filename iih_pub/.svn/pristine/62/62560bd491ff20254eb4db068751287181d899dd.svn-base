package iih.sc.scbd.scapptrule.refs;

import java.util.ArrayList;
import java.util.List;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.scapptrule.d.ScapptruleDO;
import xap.sys.appfw.refinfo.RefGridModel;


/**排班预约规则参照模型
 * @author ccj
 *
 */
public class ScruleRefModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ScapptruleDO.CODE, ScapptruleDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ScapptruleDO.ID_APPTRU, ScapptruleDO.SD_SCHRULE};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
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
		return ScapptruleDO.ID_APPTRU;
	}

	@Override
	public String getRefCodeField() {
		return ScapptruleDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ScapptruleDO.NAME;
	}

	@Override
	public String getTableName() {
		return new ScapptruleDO().getTableName();
	}
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();
		whereParts.addAll(super.getWherePart());
		//增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new ScapptruleDO(), false));
		return whereParts;
	}
	@Override
	public List<String> getOrderPart() {
		List<String> orderpart = super.getOrderPart();
		orderpart.add(ScapptruleDO.CODE);
		return orderpart;
	}

}

