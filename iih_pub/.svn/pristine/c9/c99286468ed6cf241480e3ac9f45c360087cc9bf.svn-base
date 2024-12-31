package iih.nm.nhr.nhrsched.refs;

import iih.bd.bc.udi.pub.INmNurDictCodeConst;
import iih.nm.Utils.NmEnvContextUtil;
import iih.nm.nhr.nhrsched.d.NhrSchedDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 人员排班参照 ，用于替班申请筛选数据
 * 
 * @author lijm
 */
public class NhrSchedRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldName() {
		return new String[] { "班次", "日期" };
	}

	@Override
	public String[] getShowFieldCode() {

		return new String[] { NhrSchedDO.NAME_NHR_SI, NhrSchedDO.DT_SCHED_DATE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NhrSchedDO.ID_NHR_SI, NhrSchedDO.ID_NUR, NhrSchedDO.ID_NHR_SCHED };
	}

	@Override
	public String getPkFieldCode() {
		return NhrSchedDO.ID_NHR_SCHED;
	}

	@Override
	public String getRefCodeField() {
		return NhrSchedDO.ID_NHR_SCHED;
	}

	@Override
	public String getRefNameField() {
		return NhrSchedDO.NAME_NHR_SI;
	}

	@Override
	public String getRefSql() {

		StringBuffer refSql = new StringBuffer();
		refSql.append("	SELECT                                                                                                         ");
		refSql.append("		nm_nhr_sched.name_nhr_si,                                                                                  ");
		refSql.append("		nm_nhr_sched.dt_sched_date,                                                                                ");
		refSql.append("		nm_nhr_sched.id_nhr_si,                                                                                    ");
		refSql.append("		nm_nhr_sched.id_nur,                                                                                       ");
		refSql.append("		nm_nhr_sched.id_nhr_sched,                                                                                 ");
		refSql.append("		nm_nhr_sched.id_dep_nur                                                                                    ");
		refSql.append("	FROM                                                                                                           ");
		refSql.append("		(                                                                                                          ");
		refSql.append("			SELECT                                                                                                 ");
		refSql.append("				sch.name_nhr_si,                                                                                   ");
		refSql.append("				sch.dt_sched_date,                                                                                 ");
		refSql.append("				sch.id_nhr_si,                                                                                     ");
		refSql.append("				sch.id_nur,                                                                                        ");
		refSql.append("				sch.id_nhr_sched,                                                                                  ");
		refSql.append("				sch.id_dep_nur                                                                                     ");
		refSql.append("			FROM                                                                                                   ");
		refSql.append("				nm_nhr_sched sch                                                                                   ");
		refSql.append("			INNER JOIN nm_nhr_sched_week schweek ON sch.id_nhr_sched_week = schweek.id_nhr_sched_week              ");
		//refSql.append(String.format(" WHERE schweek.sd_status = '%s'", INmNurDictCodeConst.SD_SCHED_STATES_AGREE));
		//refSql.append(String.format(" and %s ", NmEnvContextUtil.processEnvContext(new NhrSchedDO(), "sch")));
		//refSql.append("		) nm_nhr_sched   where 1=1  
		refSql.append(String.format(" where %s ", NmEnvContextUtil.processEnvContext(new NhrSchedDO(), "sch")));
		refSql.append("		) nm_nhr_sched   where 1=1   ");
		refSql.append(buildWherePart());
		refSql.append(BuildOrderPart());
		return refSql.toString();
	}

	@Override
	public String getTableName() {
		return new NhrSchedDO().getTableName();
	}

	/**
	 * 构建wheret条件
	 * 
	 * @return
	 */
	private String buildWherePart() {
		StringBuffer wherePart = new StringBuffer();
		if (this.getWherePart().size() > 0) {
			for (String sqlPart : this.getWherePart()) {
				wherePart.append(" And ").append(sqlPart).append(" ");
			}
		}
		return wherePart.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder orderPart = new StringBuilder();
		if (this.getOrderPart().size() < 1) {
			orderPart.append("order by dt_sched_date ASC");
		} else {
			for (String order : this.getOrderPart()) {
				orderPart.append(order);
			}
		}
		return orderPart.toString();
	}
}
