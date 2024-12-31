package iih.en.pv.outpatient.refs;

import java.util.List;

import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.d.desc.OutpatientDODesc;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 患者就诊次数参照
 * @author ly 2017/05/12
 *
 */
public class EnOpTimesRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { OutpatientDO.TIMES_OP };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { OutpatientDO.ID_OUTPATIENT };
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] { "就诊次数" };
	}
	
	@Override
	public String getPkFieldCode() {
		return OutpatientDO.ID_OUTPATIENT;
	}

	@Override
	public String getRefCodeField() {
		return OutpatientDO.TIMES_OP;
	}
	
	@Override
	public String getRefNameField() {
		return OutpatientDO.TIMES_OP;
	}

	@Override
	public String getTableName() {
		return "ent_op";
	}
	
	@Override
	public String getRefSql() {
		
		String patId = (String) this.getExtendAttributeValue("id_pat");//患者id
		
		String sql = "select entop.times_op times_op,"
				+ "entop.id_outpatient id_outpatient "
				+ "from en_ent_op entop "
				+ "inner join en_ent ent "
				+ "on entop.id_ent = ent.id_ent "
				+ "and ent.fg_acptvalid = 'Y' "
				+ "and ent.fg_canc = 'N' ";
		
		// where part
		if(!StringUtil.isEmpty(patId)){
			sql += "where ent.id_pat = '" + patId + "'";
		}
		
		//order part
		sql += " order by entop.times_op desc ";
		
		sql = "select * from ( " + sql + " ) ent_op where 1= 1 ";
		
		StringBuilder sqlBuilder = new StringBuilder(sql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sqlBuilder.append(" and (").append(where).append(") ");
			}
		}
		
		return sqlBuilder.toString();
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { OutpatientDO.TIMES_OP };
	}
}
