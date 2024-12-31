package iih.nm.net.examqu.refs;

import iih.nm.net.examqu.d.ExamQuDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class ExamQuDOModel extends RefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { ExamQuDO.CONTENT,ExamQuDO.ID_QU};
	}

	@Override
	public String[] getShowFieldName() {
	
		return new String[] { "试题内容","试题id" };
	}

	@Override
	public String[] getHiddenFieldCode() {

		return null;
	}

	@Override
	public String getPkFieldCode() {

		return ExamQuDO.ID_QU;
	}


	@Override
	public String getRefNameField() {
		return ExamQuDO.CONTENT;
	}

	@Override
	public String getTableName() {
		return new ExamQuDO().getTableName();
	}
}
