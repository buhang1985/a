package iih.ci.rcm.nosoinfection.s;

import iih.ci.rcm.msinjurydto.d.MsInjuryDTO;
import iih.ci.rcm.nosoinfection.i.IMsInjuryService;
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
 * 医疗锐器伤数据查询服务
 * @author LJL
 *
 */
@Service(serviceInterfaces = {IMsInjuryService.class}, binding = Binding.JSONRPC)
public class MsInjuryServiceImpl extends PagingServiceImpl<MsInjuryDTO> implements IMsInjuryService{

	public PagingRtnData<MsInjuryDTO> getMsInjuryList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
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
		sql.append("       cri.id_msinjury as id_msinjurydto,\n");
		sql.append("       cri.investtime as investtime ,\n"); // 调查表时间
		sql.append("       cri.name_pat as name_pat , \n");   // 姓名
		sql.append("       cri.name_sex as name_sex ,\n"); // 性别
		sql.append("       cri.worke_age as worke_age ,\n"); // 工龄
		sql.append("       cri.name_work as name_work ,\n"); // 工作类别
		sql.append("       cri.injury_time as injury_time ,\n"); // 受伤时间
		sql.append("       cri.is_vaccinated_hbv as is_vaccinated_hbv ,\n"); // 被刺伤前是否接受过乙肝疫苗
		sql.append("       cri.name_time_vah as name_time_vah ,\n"); // 注射时间
		//sql.append("       cri.injury_time as injury_time ,\n"); // 受伤时间
		sql.append("       cri.name_dam_loc as name_dam_loc ,\n"); // 伤害发生地点
		sql.append("       cri.name_sharp as name_sharp ,\n"); // 导致伤害发生的物品种类
		sql.append("       cri.name_dam_reason as name_dam_reason ,\n"); // 伤害发生的原因
		sql.append("       cri.initial_user as initial_user ,\n"); // 受伤者是锐器的最初使用者
		sql.append("       cri.name_sharp_purpose as name_sharp_purpose ,\n"); // 锐器最初是用于什么目的
		sql.append("       cri.name_misoperation as name_misoperation ,\n");// 伤害的发生有无不正确操作
		sql.append("       cri.name_sharp_blood as name_sharp_blood ,\n");// 是否被血污染的锐器物刺伤
		sql.append("       cri.blood_borne_diseases as blood_borne_diseases ,\n");// 受伤前是否知道病人有无血液传播的疾病
		sql.append("       cri.patient_related as patient_related ,\n");// 受伤是否与病人有关
		sql.append("       cri.name_pat_hbv as name_pat_hbv ,\n");// 如果受伤与病人有关病人有无乙肝
		sql.append("       cri.hbsag_positive as hbsag_positive ,\n");// 乙肝表面抗原阳性
		sql.append("       cri.name_pat_hcv as name_pat_hcv ,\n");// 如果受伤与病人有关病人有无丙肝
		sql.append("       cri.name_pat_aids as name_pat_aids ,\n");// 如果受伤与病人有关病人有无艾糍病
		sql.append("       cri.name_oper_step as name_oper_step ,\n");// 伤害发生的操作环节
		sql.append("       cri.name_wound_treat as name_wound_treat ,\n");// 受伤后伤口如何处理
		sql.append("       cri.name_glove as name_glove ,\n");// 如果受伤部位是手锐器穿透了
		sql.append("       cri.name_severity_injury as name_severity_injury ,\n");// 受伤程度
		sql.append("       cri.name_sharp_user_handedness as name_sharp_user_handedness ,\n");// 锐器使用者是
		sql.append("       cri.staff_lab_examfee as staff_lab_examfee ,\n");// 员工实验室检查费
		sql.append("       cri.pat_lab_examfee as pat_lab_examfee ,\n");// 病人实验室检查费
		sql.append("       cri.staff_treatfee as staff_treatfee ,\n");// 员工治疗费
		sql.append("       cri.pat_treatfee as pat_treatfee ,\n");// 病人治疗费
		sql.append("       cri.other_expense as other_expense ,\n");// 其它费用
		sql.append("       cri.total_cost as total_cost ,\n");// 总费用
		sql.append("       cri.days_off_num as days_off_num ,\n");// 离岗天数
		sql.append("       cri.victim_process as victim_process \n");// 受害发生的过程
		sql.append("       from ci_rcm_msin cri\n");
		sql.append("       where " + sqlwhere + "" );
		//sql.append("       order by sv desc " );

		strsql = sql.toString();
		PagingRtnData<MsInjuryDTO> pagingRtnData = super.findByPageInfo(new MsInjuryDTO(), paginationInfo, strsql, "", null);

		return pagingRtnData;
	}	
}
