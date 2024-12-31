package iih.ci.rcm.nosoinfection.s;

import iih.ci.rcm.casesurvedto.d.CaseSurveDTO;
import iih.ci.rcm.nosoinfection.i.ICaseMonitorService;
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
 * ICU病例监测查询服务
 * @author LJL
 *
 */
@Service(serviceInterfaces = {ICaseMonitorService.class}, binding = Binding.JSONRPC)
public class CaseMonitorServiceImpl  extends PagingServiceImpl<CaseSurveDTO> implements ICaseMonitorService{

	public PagingRtnData<CaseSurveDTO> getCaseSurveList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		// TODO
		StringBuilder sql = new StringBuilder();
		String strsql = "";
		sql.append("       SELECT  distinct cri.id_ent,\n");
		sql.append("       cri.id_case as id_case,\n");
		sql.append("       cmr.fill_in_date   as  investtime,\n"); // 调查表时间
		sql.append("       cmr.sd_pat as id_pat ,\n");   // 病人编码
		sql.append("       cmr.name_pat as name_pat ,\n");   // 病人编码
		sql.append("       ee.code_amr_ip as code_amr_ip ,\n");   // 住院号
		sql.append("       cmr.times_ip as times_ip ,\n");   // 性别
		sql.append("       cmr.name_sex as name_sex ,\n");   // 年龄
		sql.append("       cmr.pat_age as pat_age ,\n");   // 入院日期
		sql.append("       cmr.admission_date as dt_acpt ,\n");   // 出院日期
		sql.append("       cmr.discharge_date as dt_end  ,\n");   // 住院天数
		sql.append("       cmr.in_hospital_days as in_hospital_days ,\n");   // 床号
		sql.append("       cmr.id_bed as id_bed  ,\n");   // 床号
		sql.append("       cmr.name_bed as name_bed  ,\n");   // 科别
		sql.append("       cmr.name_dept as name_dept ,\n");   // 最后修改时间
		sql.append("       cmr.modifiedtime as modifiedtime ,\n");   // 调查者
		sql.append("       cmr.is_late as is_late  ,\n");   // 漏报 
		sql.append("       cmr.name_survey_mth as name_survey_mth  ,\n");   // 调查方式 
		sql.append("       cmr.fill_in_person as id_psn  ,\n");   // 调查方式 
		sql.append("       crc.is_infection as is_infection,\n");   // 是否感染 
		//sql.append("       cri.is_infection as  ,\n");   // 填报情况  Dto也没有
		//sql.append("       cri.is_infection as  ,\n");   // 上次入ICU时间   Dto也没有
		//sql.append("       cri.is_infection as  ,\n");   // 上次出ICU科别   Dto也没有
		sql.append("       cri.entry_icu_date as entry_icu_date ,\n");   // 入ICU日期
		sql.append("       dep1.name as change_into_category,\n");   // 转入科别
		sql.append("       cri.out_icu_date as out_icu_date ,\n");   // 出ICU日期
		sql.append("       dep2.name as roll_out_category ,\n");   // 转出科别
		sql.append("       cri.into_category_day as entry_icu_time ,\n");   // 入ICU时间---天数的意思		
		//sql.append("       cri.roll_out_category as  ,\n");   // 系统症状  Dto也没有
		//sql.append("       cri.roll_out_category as  ,\n");   // 系局部症状  Dto也没有
		sql.append("       cri.airway_1d as airway_1d ,\n");   // 气道1d
		sql.append("       cri.mech_vent_1d as mech_vent_1d ,\n");   // 机械通气1d		
		sql.append("       cri.cen_ven_cath_1d as cen_ven_cath_1d ,\n");   // 中心静脉导管1d		
		sql.append("       cri.ureter_1d as ureter_1d ,\n");   // 尿管1d
		sql.append("       cri.arte_cath_1d as arte_cath_1d ,\n");   // 动脉置管1d		
		sql.append("       cri.other_device_1d as other_device_1d ,\n");   // 其它装置1d
		sql.append("       cri.airway_2d as airway_2d ,\n");   // 气道2d
		sql.append("       cri.mech_vent_2d as mech_vent_2d ,\n");   // 机械通气2d		
		sql.append("       cri.cen_ven_cath_2d as cen_ven_cath_2d ,\n");   // 中心静脉导管2d	
		sql.append("       cri.ureter_2d as ureter_2d ,\n");   // 尿管2d
		sql.append("       cri.arte_cath_2d as arte_cath_2d ,\n");   // 动脉置管2d
		sql.append("       cri.other_device_2d as other_device_2d \n");   // 其它装置2d
		sql.append("       from ci_rcm_casesur cri\n");
		sql.append("       left join CI_MR_HOS_REPORT cmr\n");
		sql.append("       on cri.id_hospitalreport = cmr.id_hospitalreport\n");
		sql.append("       left join en_ent_ip ee\n");
		sql.append("       on ee.id_ent=cri.id_ent\n");
		sql.append("       left join bd_dep dep1\n");
		sql.append("       on dep1.id_dep=cri.change_into_category\n");
		sql.append("       left join bd_dep dep2\n");
		sql.append("       on dep2.id_dep=cri.roll_out_category\n");
		sql.append("       left join ci_rcm_cath crc\n");
		sql.append("       on crc.id_case=cri.id_case\n");
		sql.append("       where " + sqlwhere + "" );
		//sql.append("       order by sv desc " );

		strsql = sql.toString();
		PagingRtnData<CaseSurveDTO> pagingRtnData = super.findByPageInfo(new CaseSurveDTO(), paginationInfo, strsql, "", null);

		return pagingRtnData;
	}
}
