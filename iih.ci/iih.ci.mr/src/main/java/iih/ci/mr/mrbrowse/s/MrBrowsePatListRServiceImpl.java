package iih.ci.mr.mrbrowse.s;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.mrbrowse.i.IMrBrowsePatListRService;
import iih.ci.mr.mrbrowse.s.bp.common.GetOpMrPatListQryBp;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.permfw.pub.EnvContextUtil;

@Service(serviceInterfaces = { IMrBrowsePatListRService.class }, binding = Binding.JSONRPC)
public class MrBrowsePatListRServiceImpl extends PagingServiceImpl<QaPatListDTO> implements IMrBrowsePatListRService{

	@Override
	public PagingRtnData<QaPatListDTO> getQaPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		//限制只有住院患者
 		String sqlwhere = "1=1 and ee.code_entp =  '"+IEnDictCodeConst.SD_ENTP_INPATIENT+"'";
 		 
 		
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		
 		StringBuilder sql = new StringBuilder();
 		sql.append("select ee.id_ent, ");
 		sql.append("       ci_amr.id_enhr as id_amr, " );
 		sql.append("       ee.id_pat as id_pat, " );
 		sql.append("       ee.name_pat as pat_name, " );
 		sql.append("       patient.code as pat_code, " );
 		sql.append("       ee.code as ent_code, " );
 		sql.append("       ee.dt_birth_pat as dt_birth_pat, " );
 		sql.append("       ee.fg_ip as fg_ip, " );
 		sql.append("       (CASE " );
 		sql.append("           WHEN ee.sd_sex_pat = '0' THEN " );
 		sql.append("            '未知的性别' " );
 		sql.append("           WHEN ee.sd_sex_pat = '1' THEN " );
 		sql.append("            '男' " );
 		sql.append("           WHEN ee.sd_sex_pat = '2' THEN " );
 		sql.append("            '女' " );
 		sql.append("           WHEN ee.sd_sex_pat = '9' THEN " );
 		sql.append("            '未说明性别' " );
 		sql.append("       END) as sex_name, " );
 		sql.append("       ci_amr.code_amr_ip as code_amr_ip, " );
 		sql.append("       ee.code_entp as code_entp, " );
 		sql.append("       eei.id_inpatient, " );
 		sql.append("       eei.name_bed as bed_code, " );
 		sql.append("       ee.id_dep_phy as id_dep_phy, " );
 		sql.append("       bd1.name as dep_phy_name, " );
 		sql.append("       bd2.name as name_dep_nur, " );
 		sql.append("       ee.dt_acpt as dt_acpt, " );
 		sql.append("       ee.dt_end as dt_end, " );
 		sql.append("       eed.id_entdi, " );
 		sql.append("       ci_amr.id_enhr, " );
 		sql.append("       ci_amr.inhos_times as times_ip, " );
 		sql.append("       eed.name_didef_dis as name_di, " );
 		sql.append("       ee.id_emp_phy as id_emp_phy, " );
 		sql.append("       eei.id_dep_phydisc as id_dep_phydisc, " );
 		sql.append("       dep.name as dep_phydisc " );
 		sql.append("  from ci_amr ci_amr " );
 		sql.append("  left join en_ent ee " );
 		sql.append("    on ci_amr.id_ent = ee.id_ent " );
 		sql.append("  left join en_ent_ip eei " );
 		sql.append("    on ee.id_ent = eei.id_ent " );
 		sql.append("  left join en_ent_di eed " );
 		sql.append("    on eed.id_ent = ee.id_ent " );
 		sql.append("   and eed.fg_maj = 'Y' " );
 		sql.append("  left join bd_dep bd1 " );
 		sql.append("    on eei.ID_DEP_PHYADM = bd1.id_dep " );
 		sql.append("  left join bd_dep bd2 " );
 		sql.append("    on eei.id_dep_nuradm = bd2.id_dep " );
 		sql.append("  left join bd_dep dep " );
 		sql.append("    on eei.id_dep_phydisc = dep.id_dep " );
 		sql.append("  left join pi_pat patient " );
 		sql.append("    on patient.ID_PAT = ee.ID_PAT ");
 		sql.append(" where " + sqlwhere + " and " + EnvContextUtil.processEnvContext("",new AMrDO(),false));
 		sql.append(" order by case when ee.dt_acpt is null then 0 else 1 end desc, ee.code_entp desc " );
 			
 		String sqlStr=sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = 
				super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}

	public PagingRtnData<QaPatListDTO> getOPMrPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo) throws BizException{
		GetOpMrPatListQryBp bp = new GetOpMrPatListQryBp();
		return bp.exec(qryRootNodeDTO, paginationInfo);
	}
	
}
