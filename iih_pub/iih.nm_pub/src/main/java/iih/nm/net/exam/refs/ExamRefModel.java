package iih.nm.net.exam.refs;

import iih.bd.bc.udi.pub.INmNurDictCodeConst;
import iih.nm.net.exam.d.ExamDO;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.refinfo.RefGridModel;

public class ExamRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {

		return new String[] { ExamDO.NAME, ExamDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {

		return new String[] { "考试名称", "考试编码" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ExamDO.ID_EXAM };
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
		return "exam";
	}

	@Override
	public String getRefSql() {

		String id_emp = (String) this.getExtendAttributeValue("Id_emp");// 考试人员
		Integer exam_pattern = (Integer) this.getExtendAttributeValue("Exam_pattern");// 在线考试模式

		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                   ");
		sqlStr.append(" exam.name,                                               ");
		sqlStr.append(" exam.code,                                               ");
		sqlStr.append(" exam.id_exam                                             ");
		sqlStr.append(" from nm_exam_app examapp                                 ");
		sqlStr.append(" inner join nm_exam exam on exam.id_exam=examapp.id_exam  ");
		sqlStr.append(" where 1=1                                                ");

		sqlStr.append(" and examapp.sd_status in ('"+ INmNurDictCodeConst.SD_EXAM_TEST_BEFORE+"','"+INmNurDictCodeConst.SD_EXAM_TEST_DURING+"')");
		// 待增加管控

		if (!StringUtil.isEmptyWithTrim(id_emp)) {
			sqlStr.append(" and examapp.id_emp='" + id_emp + "'");
		}

		if (exam_pattern !=null) {
			switch (exam_pattern) {
			case 1:
				// 时间限制
				String nowDateStr = new FDateTime().toString();
				sqlStr.append(" and exam.dt_plan>='" + nowDateStr + "' and (to_date(exam.dt_plan,'yyyy-mm-dd hh24:mi:ss')+ exam.duration/(24*60))<=to_date('" + nowDateStr + "','yyyy-mm-dd hh24:mi:ss')");
				break;
			default:
				break;
			}
		}
		if (this.getWherePart() != null && this.getWherePart().size() > 0) {
			for (String whereStr : this.getWherePart()) {
				sqlStr.append(" and (" + whereStr + ")");
			}
		}

		return sqlStr.toString();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { ExamDO.CODE, ExamDO.NAME };
	}
}
