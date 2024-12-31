package iih.ci.mrqry.mrreport.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class MrClosePatientQruBP extends PagingServiceImpl<QaPatListDTO> {

	/**
	 * 已归档病历打印查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<QaPatListDTO> getClosePatientList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		
		String sqlWhere = " ci_amr.fg_complete = 'Y' and ee.fg_data_transf='Y' ";
		
		if(qryRootNodeDTO != null){
			sqlWhere += " AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ee.id_ent,\n");
 		sql.append("       ci_amr.id_enhr as id_amr,\n");
 		sql.append("       ee.id_pat as id_pat,\n");
 		sql.append("       ee.name_pat as pat_name,\n");
 		sql.append("       ee.code as ent_code,\n");
 		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
 		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
 		sql.append("          THEN  '未知的性别'\n" );
 		sql.append("        WHEN ee.sd_sex_pat= '1'\n" );
 		sql.append("          THEN  '男'\n" );
 		sql.append("        WHEN ee.sd_sex_pat= '2'\n" );
 		sql.append("          THEN  '女'\n" ); 
 		sql.append("        WHEN ee.sd_sex_pat= '9'\n" );
 		sql.append("          THEN  '未说明性别'\n" ); 
 		sql.append("       end) as sex_name,");
 		sql.append("       ci_amr.pat_age as pat_age,\n" );
 		sql.append("       ci_amr.code_amr_ip as hospital_code,\n" );
 		sql.append("       ee.code_entp as code_entp,\n" );
 		sql.append("       eei.id_inpatient,\n" );
 		sql.append("       eei.name_bed as bed_code,\n" );
 		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
 		sql.append("       eei.id_dep_phydisc as id_dep_phydisc,\n");
 		sql.append("       bd1.name as name_dep_phyadm,\n");
 		sql.append("       bd2.name as name_dep_nur,\n");
 		sql.append("       bd3.name as dep_phydisc,\n");
 		sql.append("       psn.name as emp_phy_name,\n");
 		sql.append("       diitm.id_didef_name as name_diag_outhos,\n");
 		sql.append("       ee.dt_acpt as dt_acpt,\n" );
 		sql.append("       ee.dt_end as dt_end,\n");
 		sql.append("       ci_amr.id_enhr,\n");
 		sql.append("       ci_amr.inhos_times as times_ip,\n");	
 		sql.append("       ee.id_emp_phy as id_emp_phy\n" );
 		sql.append("       FROM ci_amr ci_amr\n" );
 		sql.append("       INNER JOIN en_ent ee\n" );
 		sql.append("       ON ci_amr.id_ent = ee.id_ent\n" );
 		sql.append("       INNER JOIN en_ent_ip eei\n" );
 		sql.append("       ON ee.id_ent = eei.id_ent\n" );
 		sql.append("       left join ci_di cidi\n" );
 		sql.append("       ON cidi.id_en = ci_amr.id_ent  AND cidi.sd_ditp = '"+ICiDictCodeConst.SD_OUTHOSPITAL+"'\n" );
 		sql.append("       and cidi.fg_cancel = 'N'\n" );
 		sql.append("       left join ci_di_itm diitm\n" );
 		sql.append("       ON diitm.id_di = cidi.id_di\n" );
 		sql.append("       AND diitm.fg_majdi = 'Y'\n" );
 		sql.append("       left join bd_psndoc psn\n" );
 		sql.append("       ON ee.id_emp_phy = psn.id_psndoc \n" );
 		sql.append("       left JOIN bd_dep bd1\n" );
 		sql.append("       ON eei.ID_DEP_PHYADM = bd1.id_dep \n" ); 
 		sql.append("       left JOIN bd_dep bd2\n" );
 		sql.append("       ON eei.id_dep_nuradm = bd2.id_dep \n" ); 
 		sql.append("       left JOIN bd_dep bd3\n" );
 		sql.append("       ON eei.id_dep_phydisc = bd3.id_dep \n" ); 
 		sql.append("       WHERE "+sqlWhere+" ");
 		sql.append("       order by ee.dt_end" );
 		
 		String sqlStr = sql.toString();
 		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}
}
