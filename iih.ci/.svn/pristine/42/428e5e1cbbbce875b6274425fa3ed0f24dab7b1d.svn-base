package iih.ci.mr.s;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeTypeConst;
import iih.ci.mr.cideathcert.d.CideathcertDO;
import iih.ci.mr.cideathpatdto.d.CiDeathPatDTO;
import iih.ci.mr.d.CiMrDeathDTO;
import iih.ci.mr.i.ICiMrDeathService;
import iih.ci.rcm.i.ICiRcmParamService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;

@Service(serviceInterfaces = {ICiMrDeathService.class }, binding = Binding.JSONRPC)
public class CiMrDeathDTOServiceImpl extends PagingServiceImpl<CiDeathPatDTO> implements ICiMrDeathService {
	
	@Override
	public CiMrDeathDTO getCiMrDeathDTO(String id_Pat) throws BizException {
		DAFacade daf = new DAFacade();

    	String sql ="select '' as doc_version,'' as id_interface,'' as sign_no, "
    			+ " '' as id_doc,'' as doc_title,case ee.code_entp when '10' then '02' else '01' end id_moudle, "
    			+ " pp.code as id_pat,ee.code as id_ent,eei.times_ip as count_ent, ee.code_entp code_entp,be.name name_entp, "
    			+ " pp.name as name_pat,cm.age_pat as age_pat,pp.sd_sex as id_sex,bu1.name as name_sex,pp.dt_birth as birth_date, "
    			+ " bd1.code id_dept,bd1.name name_dept,bd2.name name_lession,eei.name_bed bed_no,cm.createdtime as record_date, "
    			+ " su1.code as id_doctor,su1.name as name_doctor,'' as id_hospital,'' as name_hospital, "
    			+ " cm.modifiedtime as modify_date,su2.code as id_modify_doctor,su2.name as name_modify_doctor, "
    			+ " cm.verifiedtime as verify_date,su3.code as id_verify_doctor,su3.name as name_verify_doctor, "
    			+ " cm.death_time as death_date, "
    			+ " decode(ee.dt_end , null , trunc(sysdate)-trunc(to_date(ee.dt_acpt,'yyyy-mm-dd hh24:mi:ss')) , trunc(to_date(ee.dt_end,'yyyy-mm-dd hh24:mi:ss'))-trunc(to_date(ee.dt_acpt,'yyyy-mm-dd hh24:mi:ss'))) as inhos_days, "
    			+ " cm.diag_icdname as diag_pathology,'' as mr_general,'' as treatment_process,'' as rescue_process, "
    			+ " cm.death_reason as death_reason "
    			+ " from ci_mr_death_cert cm "
    			+ " left join pi_pat pp on cm.id_pat = pp.id_pat "
    			+ " left join en_ent ee on pp.id_pat=ee.id_pat "
    			+ " left join en_ent_ip eei on ee.id_ent = eei.id_ent "
    			+ " left join bd_entp be on ee.code_entp=be.code "
    			+ " left join bd_udidoc bu1 on bu1.id_udidoclist ='"+ICiMrDictCodeTypeConst.ID_UDIDOCLIST_SEX+"' and bu1.code = pp.sd_sex "
    			+ " left join bd_dep bd1 on ee.id_dep_phy = bd1.id_dep "
    			+ " left join bd_dep bd2 on ee.id_dep_nur = bd2.id_dep "
    			+ " left join sys_user su1 on cm.createdby = su1.id_user "
    			+ " left join sys_user su2 on cm.modifiedby = su2.id_user "
    			+ " left join sys_user su3 on cm.verifiedby = su3.id_user "
    			+ " where pp.id_pat='"+id_Pat+"' ";
    	
       @SuppressWarnings("unchecked")
       List<CiMrDeathDTO> listMr = (List<CiMrDeathDTO>) daf.execQuery(sql, new BeanListHandler(CiMrDeathDTO.class));
      if(listMr.isEmpty())
    	  return null;
      else
    	  return listMr.get(0);
	}

	/**
	 * 获取死亡报卡编码
	 */
	@Override
	public int getCiMrDeathCode(String id_org) throws BizException {
		
		
		ICiRcmParamService paramService = ServiceFinder.find(ICiRcmParamService.class);
		String prefixCode = paramService.getSysParaPrefixCode(id_org);
		DAFacade daf = new DAFacade();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select * from ci_mr_death_cert t ");
				sb.append("where t.id_org = '"+id_org+"' and ");
				sb.append("t.cert_status = '"+ICiMrDictCodeConst.ID_CONTAGION_STATUS_INVALID+"' ");
				sb.append( "and t.prefixcode = '"+prefixCode+"' ");
				sb.append("and t.serialnumber not in ");
				sb.append( "(select serialnumber from ci_mr_death_cert ");
				sb.append( "where prefixcode = '"+prefixCode+"' ");
				sb.append( "and cert_status <> '"+ICiMrDictCodeConst.ID_CONTAGION_STATUS_INVALID+"' ");
				sb.append( "and id_org='"+id_org+"') order by t.prefixcode");
				
		@SuppressWarnings("unchecked")
		List<CideathcertDO> listDeath = (List<CideathcertDO>) daf.execQuery(sb.toString(), new BeanListHandler(CideathcertDO.class));
		if(listDeath !=null && listDeath.size()>0)
		{
			return listDeath.get(0).getSerialnumber();
		}
		
				
		int result = 1;
		
		String sql ="select count(*) from ci_mr_death_cert where id_org = '"+id_org+"' and prefixcode ='"+prefixCode+"'";
		
		int countCiMr = (int)daf.execQuery(sql, new ColumnHandler());
		
		if(countCiMr<=0)
		{
			return result;
		}
		
    	sql ="select max(serialnumber) ss from ci_mr_death_cert where id_org = '"+id_org+"' and prefixcode ='"+prefixCode+"'";
    	
    	if(daf.execQuery(sql, new ColumnHandler())!=null){
    		countCiMr = (int) daf.execQuery(sql, new ColumnHandler());
    		result = countCiMr +1;
    	}
   
		return result;
	}

	@Override
	public Boolean isExistHealthNumber(String id_org, String healthNumber)
			throws BizException {
		
		DAFacade daf = new DAFacade();
		String sql ="select count(*) from ci_mr_death_cert where id_org = '"+id_org+"' and healthnumber ='"+healthNumber+"' and CERT_STATUS <> '"+ICiMrDictCodeConst.ID_CONTAGION_STATUS_INVALID+"'";
		
		int countCiMr = (int) daf.execQuery(sql, new ColumnHandler());
		
		if(countCiMr<=0)
		{
			return false;
		}
		return true;
	}

	@Override
	public PagingRtnData<CiDeathPatDTO> getCiDeathPatDtoList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo)
			throws BizException {
		DAFacade daf = new DAFacade();
	    IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
    	StringBuilder sql = new StringBuilder();
				sql.append("select pi_pat.id_pat,pi_pat.barcode_chis as code_pat,");
				sql.append("pi_pat.name as name_pat,bd_udidocsex.name as name_sex,");
				sql.append("pi_pat.id_idtp,bd_udidocidtp.name as name_idtp,");
				sql.append("pi_pat.id_code,pi_pat.dt_birth as birth_pat,");
				sql.append("pi_pat.mob as tel,ci_mr_death_cert.cert_status,");
				sql.append("bd_udidoccert.name as cert_statu_name,");
				sql.append("ci_mr_death_cert.id_death_cert as id_cert");
				sql.append(" from pi_pat pi_pat"); 
				sql.append(" left join ci_mr_death_cert ci_mr_death_cert"); 
				sql.append(" on ci_mr_death_cert.id_pat = pi_pat.id_pat");
				sql.append(" left join bd_udidoc bd_udidocidtp"); 
				sql.append(" on bd_udidocidtp.id_udidoc = pi_pat.id_idtp");
				sql.append(" left join bd_udidoc bd_udidocsex"); 
				sql.append(" on bd_udidocsex.id_udidoc=pi_pat.id_sex");
				sql.append(" left join bd_udidoc bd_udidoccert"); 
				sql.append(" on bd_udidoccert.id_udidoc=ci_mr_death_cert.cert_status");
				
				if (qryRootNodeDTO!=null){
					sql.append(" WHERE "); 
				     sql.append(service.getQueryStringWithoutDesc(qryRootNodeDTO));
				}
				
				sql.append(" order by pi_pat.createdtime desc"); 
			    
	   String sqlStr=sql.toString();
	   PagingRtnData<CiDeathPatDTO> pagingRtnData = super.findByPageInfo(new CiDeathPatDTO(), paginationInfo, sqlStr, "", null);
       return pagingRtnData;
	}
	
}
