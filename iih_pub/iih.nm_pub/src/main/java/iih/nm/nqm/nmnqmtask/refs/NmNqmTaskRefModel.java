package iih.nm.nqm.nmnqmtask.refs;

import iih.nm.nqm.nmnqmtask.d.NmNqmTaskDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmNqmTaskRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmNqmTaskDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmNqmTaskDO.ID_NQM_TASK };
	}

	@Override
	public String getPkFieldCode() {
		return NmNqmTaskDO.ID_NQM_TASK;
	}

	// @Override
	// public String getRefCodeField() {
	// return NmNqmCsDO.CODE;
	// }

	@Override
	public String getRefNameField() {
		return NmNqmTaskDO.NAME;
	}

	@Override
	public String getTableName() {
		return new NmNqmTaskDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return super.getBlurFields();
	}
}
