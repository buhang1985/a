package iih.sc.att.sctaskca.refs;

import java.util.ArrayList;
import java.util.List;

import iih.sc.att.sctaskca.d.ScTaskCaDO;
import iih.sc.att.sctaskperi.d.SctaskperiDO;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**考勤类型分类参照模型
 * @author ccj
 *
 */
public class SctaskcaRefModes extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{ScTaskCaDO.NAME,ScTaskCaDO.CODE};
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{ScTaskCaDO.ID_SCTASKCA};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"考勤分类名称","编码"};
	}
	@Override
	public String getPkFieldCode() {
		return ScTaskCaDO.ID_SCTASKCA;
	}
	@Override
	public String getRefCodeField() {
		return ScTaskCaDO.CODE;
	}
	@Override
	public String getRefNameField() {
		return ScTaskCaDO.NAME;
	}
	@Override
	public String getTableName() {
		return new ScTaskCaDO().getTableName();
	}
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();
		whereParts.addAll(super.getWherePart());
		//增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new ScTaskCaDO(), new ScTaskCaDO().getTableName()));
		return whereParts;
	}
	/* 
	/* 
	 *  拼音、五笔、助记码 过滤
	 */
	@Override
	public String[] getBlurFields() {
		return new String[]{"pycode","wbcode","instr"};
	}
}
