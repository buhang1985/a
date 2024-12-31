package iih.ci.rcm.nosoinfection.s;

import iih.ci.rcm.infectionpre.d.InfectionpreDTO;
import iih.ci.rcm.nosoinfection.i.INosoInfectionServiceExt;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 医院感染现患率查询服务
 * @author LJL
 *
 */
@Service(serviceInterfaces = {INosoInfectionServiceExt.class}, binding = Binding.JSONRPC)
public class NosoInfectionServiceExtImpl  extends PagingServiceImpl<InfectionpreDTO> implements INosoInfectionServiceExt {

	public PagingRtnData<InfectionpreDTO> getInfectionRateList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo)
			throws BizException {
		
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}

		StringBuilder sql = new StringBuilder();
		String strsql = "";
		sql.append("       SELECT cri.id_ent,\n");
		sql.append("       cri.id_mmratehospitalinfection as id_hosinfectionrate,\n");
		sql.append("       cri.investtime,\n");
		sql.append("       cri.code_pat,\n");
		sql.append("       cri.code_amr_ip,\n");
		sql.append("       cri.name_pat,\n");
		sql.append("       cri.name_sex,\n");
		sql.append("       cri.age,\n");
		sql.append("       ee.dt_acpt  as  dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n"); 
		sql.append("       cri.name_dep_phy,\n");
		sql.append("       cri.modifiedtime as modifytime,\n");
		sql.append("       cri.id_psn as investigator,\n");
		sql.append("       cri.noso_infection,\n");
		sql.append("       cri.name_hbsag_positive as hbsag_positive,\n");
		sql.append("       cri.name_hcv_positive as hcv_positive,\n");
		sql.append("       cri.name_hiv_positive as hiv_positive,\n");
		sql.append("       cri.antibiotics_use,\n");
		sql.append("       cri.intravenous,\n");
		sql.append("       cri.diarrhoea,\n");
		sql.append("       cri.name_purpose as name_purpose,\n");
		sql.append("       cri.name_combined_use as name_com_medi,\n");
		sql.append("       cri.bact_culture,\n");
		sql.append("       cri.arte_intubation,\n");
		sql.append("       cri.urin_intubatton,\n");
		sql.append("       cri.ventilator_use,\n");
		sql.append("       cri.operation,\n");
		sql.append("       cri.pre_use_antibiotic,\n");
		sql.append("       cri.name_surg_incision,\n");
		sql.append("       cri.surg_pharmacy \n");
		sql.append("       from ci_rcm_infectrate cri\n");
		sql.append("       left join ci_rcm_infectsite cris\n");
		sql.append("       on cri.id_mmratehospitalinfection = cris.id_mmratehospitalinfection\n");
		sql.append("       left join en_ent ee\n");
		sql.append("       on ee.id_ent = cri.id_ent\n");
		sql.append("       where " + sqlwhere + "" );
		//sql.append("       order by sv desc " );

		strsql = sql.toString();
		PagingRtnData<InfectionpreDTO> pagingRtnData = super.findByPageInfo(new InfectionpreDTO(), paginationInfo, strsql, "", null);

		return pagingRtnData;
	}
}
