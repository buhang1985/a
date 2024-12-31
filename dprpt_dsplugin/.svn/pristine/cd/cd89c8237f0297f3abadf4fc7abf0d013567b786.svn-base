package iih.mp.dg.intelcabinetsum;


import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.jdbc.handler.BeanListHandler;

public class IntelCabinetSumService {

	public List<IntelCabinetSumDTO> exec(String id_dep,String date_begin,String date_end,String oporip) throws Exception{
		if("".equals(id_dep) || id_dep.equals(null)||"".equals(oporip) || oporip.equals(null))return null;
		
		if(oporip.equals("01")){
			// 门诊
			List<IntelCabinetSumDTO> dtolist = this.getIntelCabBy(id_dep,date_begin,date_end);
			if(dtolist == null)return null;		
			return dtolist;	
		}else if(oporip.equals("02")){
			return null;	// 住院暂时不做
		}
		return null;
	}

	private List<IntelCabinetSumDTO> getIntelCabBy(String id_dep,String date_begin,String date_end) throws Exception {
		StringBuffer sb=new StringBuffer();
		
		sb.append(" select mm.name name_mm, ");
		sb.append(" mm.spec, ");
		sb.append("  mm.code code_mm, ");
		sb.append("  sum(dt.quan_mp) quan_mp, ");
		sb.append("  sum(dt.quan_bk) quan_bk, ");
		sb.append(" sum(nvl(dt.quan_mp, 0) + nvl(dt.quan_bk, 0)) sum ");
		sb.append(" from mp_dg_op_dt dt ");
		sb.append(" join mp_dg_op op on op.id_dgop = dt.id_dgop");
		sb.append(" left join bd_mm mm on mm.id_mm = dt.id_mm");
		sb.append(" left join ci_or_srv_mm srvmm on srvmm.id_orsrv = dt.id_orsrv");
		sb.append("  left join bd_dep dep on dep.id_dep = op.id_dep_mp ");
		sb.append(" where  1=1 ");
		sb.append(" and srvmm.sd_pois in (1,2,3,4) ");
		sb.append(" and op.id_dep_mp = '"+ id_dep +"' ");
		
		if(!StringUtils.isBlank(date_begin) && !"null".equals(date_begin) && !"".equals(date_begin.trim())) {
			sb.append(" and substr(op.dt_dp,0,10) >= '"+ date_begin +"' ");
		}
		if(!StringUtils.isBlank(date_end) && !"null".equals(date_end) && !"".equals(date_end.trim())) {
			sb.append(" and substr(op.dt_dp,0,10) <= '"+ date_end +"' ");
		}		
		sb.append(" group by mm.name, mm.spec, mm.code ");
		sb.append(" order by mm.code ");
		return  this.getResultBySql(sb.toString());
	}
	
	@SuppressWarnings("unchecked")
	private List<IntelCabinetSumDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(IntelCabinetSumDTO.class);
		List<IntelCabinetSumDTO> result = (List<IntelCabinetSumDTO>)beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy();		
		
		return result;
	}
	
}
