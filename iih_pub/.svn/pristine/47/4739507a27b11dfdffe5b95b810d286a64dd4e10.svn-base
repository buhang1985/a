package iih.sc.scbd.scheduleca.refs;


import java.util.ArrayList;
import java.util.List;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import xap.sys.appfw.refinfo.RefGridModel;

/**排班分类参照模型
 * @author ccj
 *
 */
public class SccaRefModel  extends RefGridModel  {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{ScheduleCADO.CODE,ScheduleCADO.NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{ScheduleCADO.ID_SCCA,ScheduleCADO.ID_SCTP,ScheduleCADO.SD_SCTP};
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
		return ScheduleCADO.ID_SCCA;
	}

	@Override
	public String getRefCodeField() {
		return ScheduleCADO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ScheduleCADO.NAME;
	}

	@Override
	public String getTableName() {
		return new ScheduleCADO().getTableName();
	}
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> whereParts = new ArrayList<String>();
		whereParts.addAll(super.getWherePart());
		//增加集团管控
		whereParts.add(ScGroupControlUtils.getGroupControlFitler(new ScheduleCADO(), false));
		return whereParts;
	}
}
