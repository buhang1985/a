package iih.ci.rcm.nosoinfection.s;

import iih.ci.rcm.liqexpcontactdto.d.LiqExpContactDTO;
import iih.ci.rcm.nosoinfection.i.ILiqExpContactService;
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
 * 液体血液暴露接触数据查询
 * @author LJL
 *
 */
@Service(serviceInterfaces = {ILiqExpContactService.class}, binding = Binding.JSONRPC)
public class LiqExpContactServiceImpl extends  PagingServiceImpl<LiqExpContactDTO> implements ILiqExpContactService{

	public PagingRtnData<LiqExpContactDTO> getLiqExpContactList(QryRootNodeDTO qryRootNodeDTO,
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
		sql.append("       cri.id_liqexpcon as id_liqexpcontact,\n");
		sql.append("       cri.investtime   as  investtime,\n"); // 调查表时间
		sql.append("       cri.name_pat as name_pat ,\n");   // 姓名
		sql.append("       cri.name_sex as name_sex ,\n");   // 姓别
		sql.append("       cri.workage as workage ,\n");   // 工龄
		sql.append("       cri.injury_time as injury_time ,\n");   // 受伤时间
		sql.append("       cri.name_work_type as name_work_type ,\n");   // 工作类别
		sql.append("       cri.name_exposure_loc as name_exposure_loc ,\n");   // 暴露发生地点
		sql.append("       cri.name_know_pat_info as name_know_pat_info ,\n");   // 是否知道病人源情况
		sql.append("       cri.name_bodyfluid as name_bodyfluid ,\n");   // 血液或血制品 ----其它体液
		sql.append("       cri.other_bodyfluid_instruction as other_bodyfluid_instruction ,\n");   // 其它体液说明
		sql.append("       cri.name_blood_cont as name_blood_cont ,\n");   // 体液是否受血液污染
		sql.append("       cri.name_exposed_area as name_exposed_area ,\n");   //完整的皮肤 ----其暴露部位
		sql.append("       cri.other_exposed_area_instr as other_exposed_area_instr ,\n");   // 其它暴露部位的说明
		sql.append("       cri.name_blood_bodyfluid as name_blood_bodyfluid ,\n");   // 接触没有保护的皮肤---浸透衣服
		sql.append("       cri.name_protect_appliance as name_protect_appliance ,\n");   // 单层乳胶---实验室工作服
		sql.append("       cri.other_work_clothes_instr as other_work_clothes_instr ,\n");   // 其它工作服的说明
		sql.append("       cri.other_protect_tool_instr as other_protect_tool_instr ,\n");   // 其它保护工具的说明	
		sql.append("       cri.name_expos_reason as name_expos_reason ,\n");   // 造成暴露接触的原因
		sql.append("       cri.equip_type_manu as equip_type_manu ,\n");   // 如果是设备故障请详细说明设备类型和生产厂商	
		sql.append("       cri.name_time_cont as name_time_cont ,\n");   // 血液或体液接触皮肤或粘膜多长时间
		sql.append("       cri.name_quant_cont as name_quant_cont ,\n");   // 大约有多少血液或体液接触皮肤和粘膜名称
		sql.append("       cri.name_max_area as name_max_area ,\n");   // 暴露量最大的区域
		sql.append("       cri.name_mid_area as name_mid_area ,\n");   // 暴露量中等的区域名称
		sql.append("       cri.name_min_area as name_min_area ,\n");   // 暴露量最小的区域名称
		sql.append("       cri.exposure_situation as exposure_situation ,\n");   // 请描述引起暴露的情况
		sql.append("       cri.name_opt_avoid as name_opt_avoid ,\n");   // 是否有其它任何的选择来预防此事件发生
		sql.append("       cri.explain_opt_avoid as explain_opt_avoid ,\n");   // 预防此事件发生说明
		sql.append("       cri.medical_staff_lab_exam_fee as medical_staff_lab_exam_fee ,\n");   // 医务人员实验室检查费用
		sql.append("       cri.pat_exam_cost as pat_exam_cost ,\n");   // 病人实验室检查费用
		sql.append("       cri.preve_treatment_fee as preve_treatment_fee ,\n");   // 医务人员预防性治疗费
		sql.append("       cri.pat_treatment_fee as pat_treatment_fee ,\n");   // 病人预防性治疗费
		sql.append("       cri.service_cost as service_cost ,\n");   // 服务费用
		sql.append("       cri.other_cost as other_cost ,\n");   // 其它费用
		sql.append("       cri.name_report as name_report ,\n");   // 该事故是否已经向主管部门报告
		sql.append("       cri.days_off_num as days_off_num ,\n");   // 离岗天数
		sql.append("       cri.restrict_worke_day as restrict_worke_day \n");   // 限制工作天数	
		//sql.append("       cri.restrict_worke_day as  ,\n");   // 操作者
		sql.append("       from ci_rcm_liqexpcon cri\n");
		sql.append("       where " + sqlwhere + "" );
		//sql.append("       order by sv desc " );

		strsql = sql.toString();
		PagingRtnData<LiqExpContactDTO> pagingRtnData = super.findByPageInfo(new LiqExpContactDTO(), paginationInfo, strsql, "", null);

		return pagingRtnData;
	}

	
}
