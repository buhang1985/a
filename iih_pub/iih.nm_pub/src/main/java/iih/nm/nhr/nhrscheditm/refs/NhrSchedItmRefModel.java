package iih.nm.nhr.nhrscheditm.refs;


import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 排班明细参照，用于替班筛选数据
 * @author Administrator
 *
 */
public class NhrSchedItmRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;
//
//	@Override
//	public String[] getShowFieldCode() {
//
//		return new String[] { NhrSchedItmDO.NAME_NHR_SI };
//	}
//
//	@Override
//	public String[] getHiddenFieldCode() {
//		return new String[] { NhrSchedItmDO.ID_NHR_SI };
//	}
//
//	@Override
//	public String[] getShowFieldName() {
//		return new String[] { "排班班次" };
//	}
//
//	@Override
//	public String getPkFieldCode() {
//		return NhrSchedItmDO.ID_NHR_SCHED_ITM;
//	}
//
//	@Override
//	public String getRefCodeField() {
//		return NhrSchedItmDO.ID_NHR_SCHED_ITM;
//	}
//
//	@Override
//	public String getRefNameField() {
//		return NhrSchedItmDO.NAME_NHR_SI;
//	}
//
//	@Override
//	public String getRefSql() {
//
//		StringBuffer refSql = new StringBuffer();
//
//		refSql.append("    select																						");
//		refSql.append("    	NM_NHR_SCHED_ITMS.NAME_NHR_SI,                                                               ");
//		refSql.append("    	NM_NHR_SCHED_ITMS.ID_NHR_SI,                                                                  ");
//		refSql.append("    	NM_NHR_SCHED_ITMS.ID_NUR,                                                                     ");
//		refSql.append("    	NM_NHR_SCHED_ITMS.DT_SCHED_DATE                                                              ");
//		refSql.append("    from                                                                                         ");
//		refSql.append("    	(select                                                                                     ");
//		refSql.append("           nhrsi.name as name_nhr_si,                                                            ");
//		refSql.append("           nhrscheditm.id_nhr_si,                                                                ");
//		refSql.append("           nhrsched.id_nur,                                                                      ");
//		refSql.append("           nhrsched.dt_sched_date                                                                ");
//		refSql.append("    	from  NM_NHR_SCHED_ITM nhrscheditm                                                          ");
//		refSql.append("    	inner join NM_NHR_SCHED nhrsched on nhrsched.id_nhr_sched=nhrscheditm.id_nhr_sched          ");
//		refSql.append("    	left join NM_NHR_SI nhrsi on nhrsi.id_nhr_si=nhrscheditm.id_nhr_si                          ");
//		refSql.append("    ) NM_NHR_SCHED_ITMS           															    ");
//		refSql.append("    where 1=1															                        ");
//		                                                                      
//		List<String> whereList = this.getWherePart();
//		if (whereList.size() > 0) {
//			for (String where : this.getWherePart()) {
//				refSql.append(" And (").append(where).append(") ");
//			}
//		}
//			
//		return refSql.toString();
//	}
//
//	@Override
//	public String getTableName() {
//		return new NhrSchedItmDO().getTableName();
//	}
}
