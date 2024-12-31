package iih.nm.nom.wardprint.qry;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @Description:护理质量监控查询
 * @author:zhongcl@founder.com.cn
 * @version:2019年2月23日下午5:53:12
 */
public class GetNomQualityMonthQry implements ITransQry {

	private String dt_begin;
	private String dt_end;
	private List<String> id_dep_mps;
	private FBoolean is_ward;
	
	


	public GetNomQualityMonthQry(String dt_begin, String dt_end, List<String> id_dep_mps, FBoolean is_ward) {
		super();
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.id_dep_mps = id_dep_mps;
		this.is_ward = is_ward;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param=new SqlParam();
		param.addParam(dt_begin);
		param.addParam(dt_end);
	    if(CollectionUtils.isNotEmpty(this.id_dep_mps)){
	    	List<Object> params=param.getParameters();
	    	params.addAll(this.id_dep_mps);
	    }
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql=new StringBuilder();
		sql.append(" select                                        "); 
		sql.append(" sum(fall_randinspect ) as fall_randinspect ,  "); 
		sql.append(" sum(fall_eval        ) as fall_eval        ,  "); 
		sql.append(" sum(press_randinspect) as press_randinspect,  "); 
		sql.append(" sum(press_eval       ) as press_eval       ,  "); 
		sql.append(" sum(press            ) as press            ,  "); 
		sql.append(" sum(fall             ) as fall             ,  "); 
		sql.append(" sum(infu             ) as infu             ,  "); 
		sql.append(" sum(infu_react       ) as infu_react       ,  "); 
		sql.append(" sum(transfusion      ) as transfusion      ,  "); 
		sql.append(" sum(transfu_react    ) as transfu_react    ,  "); 
		sql.append(" sum(adverse_event    ) as adverse_event    ,  "); 
		sql.append(" sum(adverse_eventi   ) as adverse_eventi   ,  "); 
		sql.append(" sum(adverse_eventii  ) as adverse_eventii  ,  "); 
		sql.append(" sum(adverse_eventiii ) as adverse_eventiii ,  "); 
		sql.append(" sum(adverse_eventiv  ) as adverse_eventiv  ,  "); 
		sql.append(" sum(imp_delivery     ) as imp_delivery     ,  "); 
		sql.append(" sum(imp_qualified    ) as imp_qualified    ,  "); 
		sql.append(" sum(emergency        ) as emergency        ,  "); 
		sql.append(" sum(com_emergency    ) as com_emergency    ,  "); 
		sql.append(" sum(operation        ) as operation        ,  "); 
		sql.append(" sum(operat_qualified ) as operat_qualified ,  "); 
		sql.append(" sum(proce_specif     ) as proce_specif     ,  "); 
		sql.append(" sum(proce_qualified  ) as proce_qualified  ,  "); 
		sql.append(" sum(health_edu_item  ) as health_edu_item  ,  "); 
		sql.append(" sum(known_health_edu ) as known_health_edu ,  "); 
		sql.append(" sum(nur_specif       ) as nur_specif       ,  "); 
		sql.append(" sum(nur_specif_truth ) as nur_specif_truth    "); 
		sql.append(" from nom_nur_quality quality                  "); 
		sql.append(" where 1 = 1                                   "); 
		sql.append(" and substr(quality.check_month,1,7)>=?        "); 
		sql.append(" and substr(quality.check_month,1,7)<=?        "); 
		if(CollectionUtils.isNotEmpty(this.id_dep_mps)){
	     String str_id_deps="";
	     for (String id_dep : id_dep_mps) {
			str_id_deps+=StringUtils.isBlank(str_id_deps)? "?":","+" ?";
		}
		sql.append(" and quality.id_dep_nur in ("+str_id_deps+ ")"  ); 
		}
		if(!is_ward.booleanValue()){
		sql.append(" and quality.fg_comfirm='Y'                      ");
		}
		return sql.toString();
	}
}
