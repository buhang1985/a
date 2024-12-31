package iih.mp.dg.printmanage;



import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.handler.BeanListHandler;

public class MpActionMesPrintService {

	public List<MpActionMesOrDTO> exec(String id_or) throws Exception{
		if("".equals(id_or) || id_or.equals(null))return null;
  
		List<MpActionMesOrDTO> dtolist = this.getMpActionMesOr(id_or);
		this.setPatAge(dtolist);
		return dtolist;	
	}
	
	
	
	private void setPatAge(List<MpActionMesOrDTO> dtolist) {
		for(MpActionMesOrDTO ordto : dtolist)
		{
			ordto.setAge(AgeCalcUtil.getAge(ordto.getDt_birth()));			
		}		
	}



	private List<MpActionMesOrDTO> getMpActionMesOr(String id_or) throws Exception {
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select srv.id_orsrv, ");
		strSql.append(" srv.name name_orsrv, ");
		strSql.append(" srv.fg_self fg_byo, ");
		strSql.append(" srv.id_route, ");
		strSql.append(" srv.id_or, ");
		strSql.append(" ps.code id_en, ");
		strSql.append(" ps.name, ");
		strSql.append(" ps.dt_birth, ");
		strSql.append(" udi.name sex_name, ");
		strSql.append(" to_char(srv.quan_medu,'fm9999990.0999') || unitmed.name single_med, ");
		strSql.append(" srvmm.id_mm, ");
		strSql.append("  mm.name name_mm, ");
		strSql.append(" mm.spec, ");
		strSql.append(" route.name name_route ");
		strSql.append(" from ci_or_srv srv ");
		strSql.append(" left join ci_pres pres on pres.id_pres = srv.id_pres ");
		strSql.append(" left join ci_or_srv_mm srvmm  on srvmm.id_orsrv = srv.id_orsrv ");
		strSql.append(" left join bd_mm mm on mm.id_mm = srvmm.id_mm ");
		strSql.append(" left join en_ent ent on ent.id_ent = srv.id_en ");
		strSql.append(" left join bd_freq freq on freq.id_freq = srv.id_freq ");
		strSql.append(" left join bd_measdoc unitmed on unitmed.id_measdoc = srv.id_medu ");
		strSql.append(" left join bd_route route on route.id_route = srv.id_route ");
		strSql.append(" left join pi_pat ps on ps.id_pat = srv.id_pat ");
		strSql.append(" left join bd_udidoc udi on udi.id_udidoc = ps.id_sex ");
		strSql.append(" where 1 = 1 ");
		if(!StringUtils.isBlank(id_or) && !"null".equals(id_or) && !"".equals(id_or.trim())) {
			strSql.append(" and srv.id_or = '"+ id_or +"' ");
		}
		strSql.append(" and srv.fg_mm = 'Y' ");			
		
		return this.getResultBySql(strSql.toString());
	}



	@SuppressWarnings("unchecked")
	private List<MpActionMesOrDTO> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(MpActionMesOrDTO.class);
		List<MpActionMesOrDTO> result = (List<MpActionMesOrDTO>)beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy();
		
		if(result == null || result.size() <= 0) {
			return null;
		}
		
		return result;
	}
}
