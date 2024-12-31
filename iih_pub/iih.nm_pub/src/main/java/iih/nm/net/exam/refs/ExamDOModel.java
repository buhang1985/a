package iih.nm.net.exam.refs;

import iih.nm.net.exam.d.ExamDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class ExamDOModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { ExamDO.NAME,ExamDO.ID_EXAM};
	}

	@Override
	public String[] getShowFieldName() {
	
		return new String[] { "考试名称","考试id" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return null;
	}

	@Override
	public String getPkFieldCode() {

		return ExamDO.ID_EXAM;
	}


	@Override
	public String getRefNameField() {
		return ExamDO.NAME;
	}

	@Override
	public String getTableName() {
		return new ExamDO().getTableName();
	}
}
