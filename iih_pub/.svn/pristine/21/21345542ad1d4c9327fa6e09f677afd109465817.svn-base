package iih.nm.nqm.nqmtaskca.refs;

import iih.nm.nqm.nqmtaskca.d.NqmTaskCaDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmNqmTaskCaRefModel extends RefGridModel{

	@Override
	public String[] getShowFieldCode() {
		return new String[]{NqmTaskCaDO.CODE,NqmTaskCaDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"任务类型编码","任务类型"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{NqmTaskCaDO.ID_NQM_TASK_CA};
	}
	
	@Override
	public String getPkFieldCode() {
		return NqmTaskCaDO.ID_NQM_TASK_CA;
	}
	
	@Override
	public String getRefCodeField() {
		return NqmTaskCaDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return NqmTaskCaDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new NqmTaskCaDO().getTableName();
	}
	
	@Override
	public String[] getBlurFields() {
		return super.getBlurFields();
	}
}
