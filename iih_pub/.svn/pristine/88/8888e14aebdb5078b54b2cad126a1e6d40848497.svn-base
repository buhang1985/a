package iih.sc.att.sctaskpl.refs;

import java.util.List;

import iih.bd.srv.emreditor.d.EmrEditorDO;
import iih.sc.att.sctaskpl.d.ScTaskPlDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 考勤排班部门计划参照模型
 * 
 * @author ccj
 *
 */
public class ScTaskpl extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { ScTaskPlDO.NAME, ScTaskPlDO.CODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ScTaskPlDO.ID_TASKPL };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "考勤计划类名称", "编码" };
	}

	@Override
	public String getPkFieldCode() {
		return ScTaskPlDO.ID_TASKPL;
	}

	@Override
	public String getRefCodeField() {
		return ScTaskPlDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return EmrEditorDO.NAME;
	}

	@Override
	public String getTableName() {
		return new ScTaskPlDO().getTableName();
	}

	/*
	 * 拼音、五笔、助记码 过滤
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { "pycode", "wbcode", "mnecode" };
	}

	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = super.getOrderPart();
		orderPart.add(ScTaskPlDO.CODE);
		return orderPart;
	}

}
