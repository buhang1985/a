package iih.nm.nom.wardprint.qry;

import org.apache.commons.lang3.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetNomQualityDataQry implements ITransQry{

	private String id_dep_nur;
	private String dt_begin;
	private String dt_end;
	private boolean isWard;
	
	public GetNomQualityDataQry(String id_dep_nur, String dt_begin, String dt_end,boolean isWard) {
		this.id_dep_nur = id_dep_nur;
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.isWard=isWard;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param=new SqlParam();
		param.addParam(this.dt_begin);
		param.addParam(this.dt_end);
		if(StringUtils.isNotBlank(id_dep_nur))
		param.addParam(id_dep_nur);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql=new StringBuilder();
		sql.append(" select                                                              "); 
		sql.append(" min(quality.check_begintime ) as check_begintime,                   "); 
		sql.append(" quality.check_endtime as check_endtime,                             "); 
		sql.append(" sum(fall_randinspect ) as fall_randinspect ,                        "); 
		sql.append(" sum(fall_eval        ) as fall_eval        ,                        "); 
		sql.append(" sum(press_randinspect) as press_randinspect,                        "); 
		sql.append(" sum(press_eval       ) as press_eval       ,                        "); 
		sql.append(" sum(press            ) as press            ,                        "); 
		sql.append(" sum(fall             ) as fall             ,                        "); 
		sql.append(" sum(infu             ) as infu             ,                        "); 
		sql.append(" sum(infu_react       ) as infu_react       ,                        "); 
		sql.append(" sum(transfusion      ) as transfusion      ,                        "); 
		sql.append(" sum(transfu_react    ) as transfu_react    ,                        "); 
		sql.append(" sum(adverse_event    ) as adverse_event    ,                        "); 
		sql.append(" sum(adverse_eventi   ) as adverse_eventi   ,                        "); 
		sql.append(" sum(adverse_eventii  ) as adverse_eventii  ,                        "); 
		sql.append(" sum(adverse_eventiii ) as adverse_eventiii ,                        "); 
		sql.append(" sum(adverse_eventiv  ) as adverse_eventiv  ,                        "); 
		sql.append(" sum(imp_delivery     ) as imp_delivery     ,                        "); 
		sql.append(" sum(imp_qualified    ) as imp_qualified    ,                        "); 
		sql.append(" sum(emergency        ) as emergency        ,                        "); 
		sql.append(" sum(com_emergency    ) as com_emergency    ,                        "); 
		sql.append(" sum(operation        ) as operation        ,                        "); 
		sql.append(" sum(operat_qualified ) as operat_qualified ,                        "); 
		sql.append(" sum(proce_specif     ) as proce_specif     ,                        "); 
		sql.append(" sum(proce_qualified  ) as proce_qualified  ,                        "); 
		sql.append(" sum(health_edu_item  ) as health_edu_item  ,                        "); 
		sql.append(" sum(known_health_edu ) as known_health_edu ,                        "); 
		sql.append(" sum(nur_specif       ) as nur_specif       ,                        "); 
		sql.append(" sum(nur_specif_truth ) as nur_specif_truth                          "); 
		sql.append(" from nom_nur_quality quality                                        "); 
		sql.append(" where 1 = 1                                                         "); 
		sql.append(" and quality.check_begintime>=?                                      "); 
		sql.append(" and quality.check_endtime<=?                                         "); 
		if(!isWard)
		sql.append(" and quality.fg_comfirm='Y'                                           ");
		if(StringUtils.isNotBlank(id_dep_nur))
		sql.append(" and quality.id_dep_nur=?                     "); 
		sql.append(" group by quality.check_endtime order by quality.check_endtime desc  "); 
		return sql.toString();
	}

}
