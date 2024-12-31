package iih.ci.ord.s.bp.assi.gj;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 
 * Copyright © 2018 北大医疗信息技术有限公司 PKU healthcare IT solution Co. Ltd
 * @author 作者 lizheng:
 * @version 创建时间：2018年4月8日 上午11:26:25
 * 
 * 
 * 类说明
 */
public class GetBdMMInfoQry implements ITransQry {
	private String _strIdsrvs = "";
	
	public GetBdMMInfoQry(String strIdsSrv){
		this._strIdsrvs = strIdsSrv;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append(" select Id_srv,bd_mm.Id_freq,bd_mm.Id_route,bd_mm.Id_routedes, ");   
		sb.append(" bd_mm.Id_boil,bd_mm.Id_boildes,bd_mm.Quan_med,bd_mm.Id_unit_med, 'N' Fg_set ,");     
		sb.append(" bd_measdoc.name med_name,bd_freq.name freq_name, bd_route.name route_name,   ");  
		sb.append(" bd_route_des.name  routedes_name,bd_boil.name  boil_name,");     
		sb.append(" bd_boil_des.name  Boildes_name ");    
		sb.append(" from bd_mm ");    
		sb.append(" left join bd_measdoc  on bd_measdoc.id_measdoc = bd_mm.id_unit_med ");     
		sb.append(" left join bd_freq   bd_freq on bd_freq.id_freq = bd_mm.id_freq ");    
		sb.append(" left join bd_route  bd_route on  bd_route.id_route = bd_mm.id_route ");    
		sb.append(" left join bd_route_des  bd_route_des on bd_route_des.id_routedes = bd_mm.id_routedes ");    
		sb.append(" left join bd_boil  bd_boil on bd_boil.id_boil = bd_mm.id_boil  ");   
		sb.append(" left join bd_boil_des  bd_boil_des on bd_boil_des.id_boildes = bd_mm.id_boildes ");    
		sb.append("where bd_mm.id_srv  in ("+this._strIdsrvs+")");
		return sb.toString();
	}

}


 
