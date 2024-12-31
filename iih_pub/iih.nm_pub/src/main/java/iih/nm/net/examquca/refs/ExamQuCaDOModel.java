package iih.nm.net.examquca.refs;

import iih.nm.com.ref.ComRefGridModel;
import iih.nm.net.examquca.d.ExamQuCaDO;
import xap.mw.coreitf.i.IBaseDO;

public class ExamQuCaDOModel extends ComRefGridModel {
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] {  ExamQuCaDO.NAME, ExamQuCaDO.CODE};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "类别名称", "类别编码" };
	}

	@Override
	public String getRefCodeField() {
		return ExamQuCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ExamQuCaDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { ExamQuCaDO.ID_QU_CA, ExamQuCaDO.NAME,ExamQuCaDO.CODE, ExamQuCaDO.PYCODE, ExamQuCaDO.WBCODE, ExamQuCaDO.MNCODE };
	}

	@Override
	public IBaseDO getBaseDO() {
		return new ExamQuCaDO();
	}


}
