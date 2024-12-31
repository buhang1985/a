package iih.ci.mr.resumeprint.bp;

import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class MrResumePrintBp extends PagingServiceImpl<PatiVisitDO>{

	/**
	 * 门诊病历补打-查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<PatiVisitDO> getMrResumePrintQryList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		StringBuilder sb=new StringBuilder();
		StringBuilder sql=new StringBuilder();
		sql.append(" 1=1");
 		if (qryRootNodeDTO!=null){
 			sql.append("  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
 		sb.append(" select  en_ent.code as code,");
 		sb.append("         en_ent.id_ent as id_ent,");
 		sb.append("         en_ent.code_entp as code_entp,");
 		sb.append("         en_ent.name_pat as name_pat,  ");
 		sb.append("       (CASE WHEN en_ent.sd_sex_pat= '0'\n");
 		sb.append("         THEN  '未知的性别'\n"); 
 		sb.append("        WHEN en_ent.sd_sex_pat= '1'\n"); 
 		sb.append("          THEN  '男'\n"); 
 		sb.append("        WHEN en_ent.sd_sex_pat= '2'\n"); 
 		sb.append("          THEN  '女'\n"); 
 		sb.append("        WHEN en_ent.sd_sex_pat= '9'\n"); 
 		sb.append("         THEN  '未说明性别'\n"); 
 		sb.append("       end) as Name_sex,");
 		sb.append("         en_ent.dt_birth_pat as dt_birth_pat,  ");
 		sb.append("         bd.name as Name_dep_phy,  ");
 		sb.append("         card.code as def10,  ");
 		sb.append("         en_ent.dt_acpt as dt_acpt,  ");
 		sb.append("         en_ent.telno_pat as telno_pat,  ");
 		sb.append("         area.name as Name_addr,  ");
 		sb.append("         en_ent.addr_pat as addr_pat  ");
 		sb.append(" from  en_ent  en_ent");
 		sb.append(" left join pi_pat         pi_pat  on    pi_pat.id_pat=en_ent.id_pat ");
 		sb.append(" left join pi_pat_card    card    on    card.id_pat=en_ent.id_pat ");
 		sb.append(" left join bd_dep         bd      on    bd.id_dep=en_ent.id_dep_phy ");
 		sb.append(" left join bd_adminarea   area    on    area.id_adminarea=en_ent.id_admdiv_addr ");
 		sb.append(" where  "+sql.toString());
 		PagingRtnData<PatiVisitDO> pagingRtnData = super.findByPageInfo(
				new PatiVisitDO(), paginationInfo, sb.toString(), " en_ent.sv desc", null);
		return pagingRtnData;
 	}
}
