package iih.nm.net.examchkpl.refs;

import iih.nm.com.ref.ComRefGridModel;
import iih.nm.net.examchkpl.d.ExamChkPlDO;
import xap.mw.coreitf.i.IBaseDO;

public class ExamChkPlRefModel extends ComRefGridModel{

	@Override
	public  String[] getShowFieldCode() {
		return new String[]{ExamChkPlDO.NAME};	
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{ExamChkPlDO.ID_EXAM_CHK_PL};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[]{"考核计划"};
	}
	
	@Override
	public String getRefCodeField() {
		return null;
	}

	@Override
	public String getRefNameField() {
		return ExamChkPlDO.NAME;
	}
	
	@Override
	public IBaseDO getBaseDO() {
		return new ExamChkPlDO();
	}

	
}
