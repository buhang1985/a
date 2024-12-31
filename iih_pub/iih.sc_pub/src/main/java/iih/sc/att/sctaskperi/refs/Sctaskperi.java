package iih.sc.att.sctaskperi.refs;
import java.util.ArrayList;
import java.util.List;

import iih.sc.att.sctaskperi.d.SctaskperiDO;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**考勤区间定义参照模型
 * @author ccj
 *
 */
public class Sctaskperi extends RefGridModel{
	@Override
	public String[] getShowFieldCode() {
		return new String[]{SctaskperiDO.NAME};
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{SctaskperiDO.ID_SCTASKPERI,SctaskperiDO.D_B,SctaskperiDO.D_E};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"考勤区间名称"};
	}
	@Override
	public String getPkFieldCode() {
		return SctaskperiDO.ID_SCTASKPERI;
	}
	@Override
	public String getRefNameField() {
		return SctaskperiDO.NAME;
	}
	@Override
	public String getTableName() {
		return new SctaskperiDO().getTableName();
	}
	
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();

		//增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new SctaskperiDO(), new SctaskperiDO().getTableName()));
		whereParts.addAll(super.getWherePart());
		return whereParts;
	}
	/* 
	 *  拼音、五笔、助记码 过滤
	 */
	@Override
	public String[] getBlurFields() {
		return new String[]{"pycode","wbcode","mnecode"};
	}
}
