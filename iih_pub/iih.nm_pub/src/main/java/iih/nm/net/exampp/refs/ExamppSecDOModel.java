package iih.nm.net.exampp.refs;

import iih.nm.com.ref.ComRefGridModel;
import iih.nm.net.exampp.d.ExamppSecDO;
import xap.mw.coreitf.i.IBaseDO;

public class ExamppSecDOModel extends ComRefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ExamppSecDO.NAME,ExamppSecDO.CODE};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "段落名称","段落编码" };
	}

	public String getRefCodeField() {
		return ExamppSecDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return ExamppSecDO.NAME;
	}

	@Override
	public IBaseDO getBaseDO() {
		return new ExamppSecDO();
	}

}
