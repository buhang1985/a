package iih.ci.ord.s.external.provide.bp.bl;

import java.util.List;

import iih.mi.biz.dto.d.OepDetailsParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医保智能审核，查询医嘱数据
 * @author zhangwq
 *
 */
public class GetOrdItelliVerifyBP {
	public FArrayList exec(String[] id_ors) throws DAException{
		StringBuilder sb = new StringBuilder();
		for(String id_or : id_ors){
			sb.append(",'"+id_or+"'");
		}
		if(sb.length()>0){
			String idstrs = sb.toString();
			idstrs = idstrs.substring(2, sb.length()-1);
			SqlParam param = new SqlParam();
			param.addParam(idstrs);
			List<OepDetailsParamDTO> rstlist = (List<OepDetailsParamDTO>) new DAFacade().execQuery(sql(), param,new BeanListHandler(OepDetailsParamDTO.class));
			FArrayList flist = new FArrayList();
			if(rstlist!=null && rstlist.size()>0){
				flist.addAll(rstlist);
			}
			return flist;
		}
		return null;
	}
	private String sql(){
		String sql = "select " +
		"ci.code_or as Presno, " + 
		"srv.name as Hpitemname, " + 
		"case when substr(ci.sd_srvtp,0,4)='0101' then '11' " + 
		"     when substr(ci.sd_srvtp,0,4)='0102' then '12' " + 
		"     when substr(ci.sd_srvtp,0,4)='0103' then '13' " + 
		"     when ci.sd_srvtp='140101' then '14' " + 
		"     when substr(ci.sd_srvtp,0,2)='02' then '21' " + 
		"     when substr(ci.sd_srvtp,0,2)='04' then '24' " + 
		"     when substr(ci.sd_srvtp,0,2)='03' then '25' " + 
		"     when ci.sd_srvtp='140102' then '26' " + 
		"     when substr(ci.sd_srvtp,0,2)='07' then '93' " + 
		"     else '31' end as Feetp_code, " + 
		"srv.pri as Price, " + 
		"srv.quan_total_medu as Quan, " + 
		"srv.quan_total_medu*srv.pri as Amt, " + 
		"case when substr(srv.sd_srvtp,0,2) = '01' then mmunit.name " + 
		"  else unit.name end as Unit, " + 
		"  unit.name as Dosage_unit," +
		"    bm.spec as Spec, " + 
		"    dosage.name as Dose, " + 
		"    ci.dt_sign as Createdate, " + 
		"    psn.name as Operatorname, " + 
		"    dep.name as Depname, " + 
		"    psn.code as Doctorcode, " + 
		"    srv.quan_medu as Doseage, " + 
		"    ci.days_or as days," +
	    "    srv.sd_srvtp as His_sdsrvtp," +
		"    bdsrv.code as Hisitemcode," +
	    "    freq.name as Freq," +
		"    route.name as Usage " +
		" from ci_or_srv srv " + 
		"left join ci_or_srv_mm mm " + 
		"on srv.id_orsrv = mm.id_orsrv " + 
		"left join ci_order ci " + 
		"on srv.id_or = ci.id_or " + 
		"left join bd_measdoc unit " + 
		"on unit.id_measdoc = srv.id_medu " + 
		"left join bd_measdoc mmunit " + 
		"on mmunit.id_measdoc = mm.id_pgku_cur " + 
		"left join bd_mm bm on bm.id_mm=mm.id_mm " + 
		"left join bd_srv_drug drug " + 
		"on drug.id_srv = srv.id_srv " + 
		"left join bd_udidoc dosage " + 
		"on dosage.id_udidoc = drug.id_dosage " + 
		"left join bd_psndoc psn " + 
		"on psn.id_psndoc = ci.id_emp_sign " + 
		"left join bd_dep dep ON dep.id_dep = ci.id_dep_sign " + 
		"left join bd_srv bdsrv on bdsrv.id_srv = srv.id_srv " +
		"left join bd_freq freq on freq.id_freq = ci.id_freq " +
		"left join bd_route route on route.id_route = ci.id_route " +
		" where ci.id_or in (?)";
		return sql;
	}
}
