package iih.ci.rcm.nosoinfection.s;

import iih.ci.rcm.infectioncasedto.d.InfectionCaseDTO;
import iih.ci.rcm.nosoinfection.i.IInfectionCaseService;
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
 * 院感病例查询服务
 * @author LJL
 *
 */
@Service(serviceInterfaces = {IInfectionCaseService.class}, binding = Binding.JSONRPC)
public class InfectionCaseServiceImpl  extends PagingServiceImpl<InfectionCaseDTO> implements IInfectionCaseService {

	public PagingRtnData<InfectionCaseDTO> getInfectionCaseList(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		
		    IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
			
			String sqlwhere = "1=1";
			if (qryRootNodeDTO != null) {
				sqlwhere += "  AND "
						+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
			}

		StringBuilder sql = new StringBuilder();
		String strsql = "";
		sql.append("       SELECT cri.id_ent,\n");
		sql.append("       cri.id_hospitalreport as id_infecase,\n");
		sql.append("       cri.fill_in_date   as  investigatetime,\n"); // 调查表时间
		sql.append("       cri.name_stage,\n");   // 状态
		sql.append("       cri.fill_in_person  as investigator,\n");   // 调查者
		sql.append("       cri.name_survey_mth as name_survey_mth,\n"); // 调查方式
		sql.append("       cri.sd_pat as code_pat,\n");  // 病人编码
		sql.append("       cri.name_pat as name_pat ,\n");  // 病人姓名
		sql.append("       cri.name_sex as name_sex,\n");  // 病人性别
		sql.append("       cri.pat_age as age,\n"); // 年龄
		sql.append("       ee.code_amr_ip as code_amr_ip,\n");  // 病历号
		sql.append("       cri.name_bed  as name_bed,\n");  // 床位号
		sql.append("       cri.name_dept as name_dept,\n");  // 科别
		sql.append("       cri.admission_date as dt_acpt,\n");  // 入院日期
		sql.append("       cri.discharge_date as dt_end,\n"); // 出院日期
		sql.append("       cri.times_ip as times_ip,\n");  // 住院次数
		sql.append("       cri.in_hospital_days as in_hospital_days,\n");  // 住院天数
		sql.append("       cri.modifiedtime  as modifiedtime,\n");  // 最新修改时间
		sql.append("       cri.name_disease_outcome as name_disease_outcome,\n");  // 疾病转归
		sql.append("       cri.name_rela_with_death as name_rela_with_death,\n");  // 与死亡的关系
		sql.append("       cri.infectious_disease as infectious_disease,\n"); // 疾病病程
		sql.append("       cri.diagnosis_basis as diagnosis_basis,\n");  // 诊断依据
		sql.append("       cri.is_surgery as is_surgery,\n");  // 手术
		sql.append("       cri.is_etiol_examination as is_etiol_examination,\n");   // 病原学检验
		sql.append("       cri.is_use_antibiotics as is_use_antibiotics\n");   // 抗菌用药
		sql.append("       from CI_MR_HOS_REPORT cri\n");
		sql.append("       left join en_ent_ip ee\n");
		sql.append("       on ee.id_ent=cri.id_ent \n");
		sql.append("       where " + sqlwhere + " and cri.ds='0' " );
		//sql.append("       order by sv desc " );

		strsql = sql.toString();
		PagingRtnData<InfectionCaseDTO> pagingRtnData = super.findByPageInfo(new InfectionCaseDTO(), paginationInfo, strsql, "", null);

		return pagingRtnData;
	}
}
