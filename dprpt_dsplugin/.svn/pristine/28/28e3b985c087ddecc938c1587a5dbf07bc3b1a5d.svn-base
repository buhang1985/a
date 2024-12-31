package iih.mp.dg.intelcabinetdetail;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.jdbc.handler.BeanListHandler;

public class IntelCabinetDetailService {

	public List<IntelCabinetDetailDTO> exec(String id_dep,String date_begin,String date_end,String oporip) throws Exception{
		if("".equals(id_dep) || id_dep.equals(null)||"".equals(oporip) || oporip.equals(null))return null;
		
		if(oporip.equals("01")){
			// 门诊
			List<IntelCabinetDetailDTO> dtolist = this.getIntelCabBy(id_dep,date_begin,date_end);	
			return dtolist;	
		}else if(oporip.equals("02")){
			return null;	// 住院暂时不做
		}
		return null;
	}

	
	private List<IntelCabinetDetailDTO> getIntelCabBy(String id_dep,String date_begin,String date_end) throws Exception {
		StringBuffer sb=new StringBuffer();
		
		sb.append(" select pres.code code_pres, ");
		sb.append(" mm.name          name_mm, ");
		sb.append("  mm.spec, ");
		sb.append("  dt.quan_mp, ");
		sb.append("  pat.name, ");
		sb.append(" pat.code_amr_oep code_mr, ");
		sb.append(" mm.code          code_mm, ");
		sb.append(" op.dt_dp, ");
		sb.append(" ord.code_or ");
		sb.append(" from mp_dg_op_dt dt ");
		sb.append(" join mp_dg_op op on op.id_dgop = dt.id_dgop");
		sb.append(" left join bd_mm mm on mm.id_mm = dt.id_mm");
		sb.append("   left join ci_or_srv srv on srv.id_orsrv = dt.id_orsrv");
		sb.append("    left join ci_pres pres  on pres.id_pres = op.id_pres ");
		sb.append(" left join ci_or_srv_mm srvmm on srvmm.id_orsrv = dt.id_orsrv");
		sb.append("    left join pi_pat pat on pat.id_pat = srv.id_pat ");
		sb.append("    left join ci_order ord on ord.id_or = srv.id_or ");
		sb.append(" where  1=1 ");
		sb.append(" and srvmm.sd_pois in (1,2,3,4) ");
		sb.append(" and op.id_dep_mp = '"+ id_dep +"' ");
		
		if(!StringUtils.isBlank(date_begin) && !"null".equals(date_begin) && !"".equals(date_begin.trim())) {
			sb.append(" and op.dt_dp >= '"+ date_begin +"' ");
		}
		if(!StringUtils.isBlank(date_end) && !"null".equals(date_end) && !"".equals(date_end.trim())) {
			sb.append(" and op.dt_dp <= '"+ date_end +"' ");
		}
		sb.append(" order by pres.code,mm.code,pat.name ");
		return  this.getResultBySql(sb.toString());
	}
	
	@SuppressWarnings("unchecked")
	private List<IntelCabinetDetailDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(IntelCabinetDetailDTO.class);
		List<IntelCabinetDetailDTO> result = (List<IntelCabinetDetailDTO>)beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy();		
		
		return result;
	}
}
