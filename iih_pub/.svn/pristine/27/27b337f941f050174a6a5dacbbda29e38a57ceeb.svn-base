package iih.bl.inc.blincoep.refs;

import xap.sys.appfw.refinfo.RefGridModel;

import java.util.List;

import iih.bl.inc.blincoep.d.BlIncOepDO;
/**
 * 门急诊发票(显示更多信息)
 * @author HanJQ
 */
public class RefBlincoepModel extends RefGridModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{"code_incpkg","incno","amt","createdtime","name_pat","name_psn"};
	}
	@Override
	public String[] getShowFieldName() {
		return new String[]{"票据包","发票号码","发票金额","创建时间","患者姓名","收款员"};
	}
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{"id_incoep","id_pat","id_psndoc"};
	}
	
	@Override
	public String getPkFieldCode() {
		return "id_incoep";
	}
	@Override
	public String getRefCodeField() {
		return "incno";
	}
	@Override
	public String getRefNameField() {		
		return "incno";
	}
	
	@Override
	public String getTableName() {
		return new BlIncOepDO().getTableName();
	}
	
	/**
	 * 默认查询条件
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { "code_incpkg", "incno", "name_pat"};
	}
	
	@Override
	public String getRefSql() {		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("SELECT ");
		
		sqlSb.append("	nvl(incoep.CODE_INCPKG,'已删除') code_incpkg, ");
		sqlSb.append("	nvl(incoep.INCNO,'未打印(' || incoep.AMT || ')') incno, ");
		sqlSb.append("	incoep.amt,	incoep.CREATEDTIME createdtime, ");
		sqlSb.append("	 pat.name name_pat, ");
		sqlSb.append("	psn.name name_psn, ");
		sqlSb.append("	incoep.id_incoep,incoep.id_pat ,psn.id_psndoc ");
		sqlSb.append("FROM	BL_INC_OEP incoep ");
		sqlSb.append("LEFT JOIN pi_pat pat on PAT.id_pat = incoep.id_pat ");
		sqlSb.append("LEFT JOIN BD_PSNDOC psn ON psn.id_psndoc = incoep.id_emp_inc ");
		sqlSb.append("WHERE incoep.DS = 0 AND incoep.FG_CANC = 'N' ");
		sqlSb.append("ORDER BY incoep.CODE_INCPKG , nvl(incoep.INCNO,'未打印(' || incoep.AMT || ')') ");
		String sql = "select * from (" + sqlSb.toString() + ") stpat where 1=1 ";
		sqlSb = new StringBuilder(sql);
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sqlSb.append(" And (").append(where).append(") ");
			}
		}

		return sqlSb.toString();		
	}
}
