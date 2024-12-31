package iih.sc.scbd.scheduleres.refs;

import java.util.ArrayList;
import java.util.List;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 排班资源参照模型
 * 
 * @author ccj
 *
 */
public class ScresRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ScheduleResDO.CODE, ScheduleResDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ScheduleResDO.ID_SCRES };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	/*
	 * 拼音、五笔、助记码 过滤
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { "pycode", "wbcode", "mnecode", "code", "name" };
	}

	@Override
	public String getPkFieldCode() {
		return ScheduleResDO.ID_SCRES;
	}

	@Override
	public String getRefCodeField() {
		return ScheduleResDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ScheduleResDO.NAME;
	}

	@Override
	public String getTableName() {
		return new ScheduleResDO().getTableName();
	}

	@Override
	public List<String> getWherePart() {
		List<String> wherePart = super.getWherePart();
		if (wherePart==null) {
			wherePart=new ArrayList<String>();
		}
		//增加集团管控
		wherePart.add(ScGroupControlUtils.getGroupControlFitler(new ScheduleResDO(), false));
		wherePart.add(ScheduleResDO.FG_ACTIVE+"='Y'");
		return wherePart;
	}
	@Override
	public List<String> getOrderPart() {
		 List<String> orderList=   super.getOrderPart();
		 orderList.add(ScheduleResDO.CODE);
		 return orderList;
	}
}
