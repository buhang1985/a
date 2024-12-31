package iih.nm.net.examqu.refs;

import iih.nm.net.examqu.d.ExamQuAnsDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class ExamQuAnsRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		
		return new String[] { ExamQuAnsDO.CONTENT,ExamQuAnsDO.CODE};
	}

	@Override
	public String[] getShowFieldName() {
	
		return new String[] { "答案内容","答案编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ExamQuAnsDO.ID_QU_ANS};
	}

	@Override
	public String getPkFieldCode() {
		return ExamQuAnsDO.ID_QU_ANS;
	}


	@Override
	public String getRefNameField() {
		return ExamQuAnsDO.CONTENT;
	}

	@Override
	public String getTableName() {
		return new ExamQuAnsDO().getTableName();
	}
}
