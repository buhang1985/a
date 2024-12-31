package iih.ci.mr.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class VitalSignsSql implements ITransQry {

	private String Id_ent;
	private String BeginDate;
	private String EndDate;

	public VitalSignsSql(String id_ent, String beginDate, String endDate) {
		Id_ent = id_ent;
		BeginDate = beginDate;
		EndDate = endDate;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam = new SqlParam();
		rtnParam.addParam(Id_ent);
		rtnParam.addParam(Id_ent);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return GetSqlStr();
	}

	public String GetSqlStr() {
		String SqlStr = "select "
				+ " tempTable.id_ent, "
				+ " tempTable.dt_vt, "
				+ " max(case tempTable.name when '体温' then tempTable.value when null then '0' end) as temperature, "
				+ " max(case tempTable.name when '脉搏' then tempTable.value when null then '0' end) as pulse, "
				+ " max(case tempTable.name when '心率' then tempTable.value when null then '0' end) as heartrate, "
				+ " max(case tempTable.name when '呼吸' then tempTable.value when null then '0' end) as breathing, "
				+ " max(case tempTable.name when '收缩压' then tempTable.value when null then '0' end) as systolicbloodpressure, "
				+ " max(case tempTable.name when '舒张压' then tempTable.value when null then '0' end) as diastolicbloodpressure "
				+ " from "
				+ " ( "
				+ "   ( "
				+ "     select  "
				+ "     mr.id_ent, "
				+ "     vt.dt_vt, "
				+ "     (case when itm.valcount=2 then '收缩压' else itm.name end) as name, "
				+ "     itm.value "
				+ "    from ci_mr_vt_itm itm "
				+ "     left join ci_mr_vt vt on itm.id_mrvt=vt.id_mrvt "
				+ "     left join ci_mr mr on vt.id_mr=mr.id_mr  "
				+ "     where id_ent=? "
				+ "  ) "
				+ "  union "
				+ "  ( "
				+ "     select  "
				+ "    mr.id_ent, "
				+ "    vt.dt_vt, "
				+ "     '舒张压' as name, "
				+ "    value1 as value "
				+ "     from ci_mr_vt_itm itm "
				+ "     left join ci_mr_vt vt on itm.id_mrvt=vt.id_mrvt "
				+ "     left join ci_mr mr on vt.id_mr=mr.id_mr  "
				+ "     where id_ent=? and itm.valcount=2 "
				+ "  ) "
				+ " ) tempTable where 1=1 ";
		
		if (!StringUtils.isBlank(BeginDate)&&!StringUtils.isBlank(EndDate))
		{
			SqlStr+=" and tempTable.dt_vt >= '"+BeginDate+"' and tempTable.dt_vt <= '"+EndDate+"' ";
		}
		return SqlStr+" group by tempTable.dt_vt,tempTable.id_ent order by tempTable.dt_vt desc";

	}
}
