package iih.sc.sch.reg.refs;

import java.util.List;

import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.refinfo.RefGridModel;

public class ResPeriodRefModel extends RefGridModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3817036729353459479L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{"Period","Remain","Total"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{"Id_ticks"};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[]{"时间段","剩余号源","总号数"};
	}

	@Override
	public String getPkFieldCode() {
		return "Id_ticks";
	}

	@Override
	public String getRefCodeField() {
		return "Period";
	}

	@Override
	public String getRefNameField() {
		return "Period";
	}

	@Override
	public String getRefSql() {
		String schid = (String)this.getExtendAttributeValue("schid");
		String chlid = (String)this.getExtendAttributeValue("chlid");
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT PERIOD,REMAIN,TOTAL,ID_TICKS FROM(");
		sqlBuilder.append("	SELECT TRIM(T_B) ||'-'|| TRIM(T_E) AS PERIOD,");
		sqlBuilder.append("	(ISNULL(QUECN_APPT,0)-ISNULL(QUECN_USED,0)) AS REMAIN,");
		sqlBuilder.append("	ISNULL(QUECN_APPT,0) AS TOTAL,ID_TICKS");
		sqlBuilder.append("	FROM SC_TICKS SC_TICKS	");	
		sqlBuilder.append(" WHERE (ISNULL(QUECN_APPT,0) -  ISNULL(QUECN_USED,0))>0 ");//开放数-已使用数
		if(!StringUtil.isEmptyWithTrim(schid)
				&& !StringUtil.isEmptyWithTrim(chlid)){
			sqlBuilder.append("AND ID_TICKS IN ");	
			sqlBuilder.append("(SELECT DISTINCT TK.ID_TICKS ");
			sqlBuilder.append("FROM SC_TICK TK ");
			sqlBuilder.append("WHERE TK.ID_SCH = '"+ schid +"' ");
			sqlBuilder.append("AND TK.EU_USED = '" + EuUseState.WY + "' ");
			sqlBuilder.append("AND TK.FG_ACTIVE = '" + FBoolean.TRUE + "'");
			sqlBuilder.append("AND ((NVL(TK.IDS_SCCHL, '~') <> '~' AND TK.IDS_SCCHL LIKE '%" + chlid + "%') OR (NVL(TK.IDS_SCCHL, '~') = '~')) ");
			sqlBuilder.append("AND TK.EU_USESCOPE = '" + EuUseScope.APT + "') ");       
		}
		sqlBuilder.append(" ORDER BY to_number(code)");//开始时间排序
		sqlBuilder.append(") SC_TICKS");
		List<String> whereList = this.getWherePart();
		if (!ListUtil.isEmpty(whereList)) {
			sqlBuilder.append(" WHERE 1=1 ");
			for (String where : this.getWherePart()) {
				sqlBuilder.append(" AND (").append(where).append(") ");
			}
		}		
		return sqlBuilder.toString();
	}
	@Override
	public String[] getBlurFields() {
		return new String[]{"Period"};
	}

	@Override
	public String getTableName() {
		return "sc_ticks";
	}	
}
