package iih.nm.net.exampp.refs;

import iih.nm.com.ref.ComRefGridModel;
import iih.nm.net.exampp.d.ExamppDO;
import xap.mw.coreitf.i.IBaseDO;

public class ExamppDOModel extends ComRefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ExamppDO.NAME,ExamppDO.CODE};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "试卷名称","试卷编码" };
	}

	@Override
	public String getRefCodeField() {
		return ExamppDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return ExamppDO.NAME;
	}

	@Override
	public IBaseDO getBaseDO() {
		return new ExamppDO();
	}

}
