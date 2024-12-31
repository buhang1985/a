package iih.ci.rcm.nosoinfection.s;

import iih.ci.rcm.casesurvedto.d.CaseSurveDTO;
import iih.ci.rcm.nosoinfection.i.IPatientRServiceExt;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = {IPatientRServiceExt.class}, binding = Binding.JSONRPC)
public class PatientRServiceExtImpl extends PagingServiceImpl<CaseSurveDTO> implements IPatientRServiceExt{

	public PagingRtnData<CaseSurveDTO> getPatiVisitDOList(PaginationInfo paginationInfo, QryRootNodeDTO qryRootNodeDTO,
			String depId) throws BizException {

				StringBuilder sql = new StringBuilder();
		 		sql.append("       SELECT ee.id_ent as id_ent,\n");
		 		sql.append("       ee.id_pat as id_pat,\n");
		 		sql.append("       ee.name_pat as name_pat,\n");
		 	//	sql.append("       ee.code as ent_code,\n");
		 		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
		 		sql.append("       cas.id_case as id_case\n");
		 	/*	sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
		 		sql.append("          THEN  '未知的性别'\n" );
		 		sql.append("        WHEN ee.sd_sex_pat= '1'\n" );
		 		sql.append("          THEN  '男'\n" );
		 		sql.append("        WHEN ee.sd_sex_pat= '2'\n" );
		 		sql.append("          THEN  '女'\n" ); 
		 		sql.append("        WHEN ee.sd_sex_pat= '9'\n" );
		 		sql.append("          THEN  '未说明性别'\n" ); 
		 		sql.append("       end) as sex_name,");*/
		 	//	sql.append("       ee.id_dep_phy as id_dep_phy\n");
		 		sql.append("       from en_ent ee\n");
		 		sql.append("       left join ci_rcm_casesur cas\n");
		 		sql.append("       on cas.id_ent=ee.id_ent\n");
		 		sql.append("       where ee.id_dep_phy='"+depId+"'\n");
		 		
		 				
		 		String sqlStr=sql.toString();
				PagingRtnData<CaseSurveDTO> pagingRtnData = super.findByPageInfo(new CaseSurveDTO(), paginationInfo, sqlStr, "", null);
				return pagingRtnData;
	}
}
