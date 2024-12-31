package iih.nm.net.examtrapl.refs;

import iih.nm.net.examtrapl.d.ExamtraplDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 培训计划参照
 * 
 * @author hehaochen
 *
 */

public class ExamtraplModel extends RefGridModel{
	
	@Override
	public String[] getShowFieldCode() {

		return new String[] { ExamtraplDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {

		return new String[] { "培训计划课程名称" };
	}
	
	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { ExamtraplDO.ID_EXAM_TRAPL };
	}
	
	@Override
	public String getPkFieldCode() {

		return ExamtraplDO.ID_EXAM_TRAPL;
	}

	@Override
	public String getRefNameField() {

		return ExamtraplDO.NAME;
	}
	
	@Override
	public String getTableName() {

		return new ExamtraplDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {

		return super.getBlurFields();
	}

}
