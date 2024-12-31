package iih.sc.scbd.schedulesrv.refs;

import iih.sc.pub.ScGroupControlUtils;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefTreeModel;
import xap.sys.permfw.pub.EnvContextUtil;

public class ScheduleSrvTreeRefModel extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ScheduleSrvDO.CODE, ScheduleSrvDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ScheduleSrvDO.ID_SCSRV, ScheduleSrvDO.ID_PARENT, ScheduleSrvDO.NOTE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return ScheduleSrvDO.ID_SCSRV;
	}

	@Override
	public String getFatherField() {
		return ScheduleSrvDO.ID_PARENT;
	}

	@Override
	public String getRefCodeField() {
		return ScheduleSrvDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ScheduleSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return new ScheduleSrvDO().getTableName();
	}
	
	/**
	 * 重写条件
	 */
	@Override
	public List<String> getWherePart() {
		List<String> listWhereParts = new ArrayList<String>();
		listWhereParts.addAll(super.getWherePart());
		//增加集团管控
		listWhereParts.add(ScGroupControlUtils.getGroupControlFitler(new ScheduleSrvDO(), false));
		return listWhereParts;
	}

	@Override
	public List<String> getOrderPart() {
		List<String> orderpart = super.getOrderPart();
		orderpart.add(ScheduleSrvDO.CODE);
		return orderpart;
	}

	/*
	 * 拼音、五笔、助记码 过滤
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { "pycode", "wbcode", "mnecode", "code", "name" };
	}
}
