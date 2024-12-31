package iih.ci.rcm.nosoinfection.s;

import iih.ci.rcm.infecoutbreakdetailreportdto.d.InfecOutbreakDetailReportDTO;
import iih.ci.rcm.nosoinfection.i.IInfecOutbreakDetailReportService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 医院感染暴发详情查询服务
 * @author LJL
 *
 */
@Service(serviceInterfaces = {IInfecOutbreakDetailReportService.class}, binding = Binding.JSONRPC)
public class InfecOutbreakDetailReportServiceImpl  extends PagingServiceImpl<InfecOutbreakDetailReportDTO> implements IInfecOutbreakDetailReportService {

	public PagingRtnData<InfecOutbreakDetailReportDTO> getInfecOutbreakDetailList(PaginationInfo paginationInfo,String[] ids) throws BizException {
		PagingRtnData<InfecOutbreakDetailReportDTO> pagingRtnData =new PagingRtnData<InfecOutbreakDetailReportDTO>();
		if(ids==null || ids.length==0){
			return pagingRtnData;
		}
		
		String str="";
		for(int i=0;i<ids.length;i++){
			if(i<ids.length-1){
				str+="'"+ids[i]+"',";
			}else{
				str+="'"+ids[i]+"'";
			}	
		}
		StringBuilder sql = new StringBuilder();
		String strsql = "";
		sql.append("       SELECT  cri.id_hospitalreport as Id_infeoutdetailredto,\n");
		sql.append("       cri.id_ent as id_ent,\n");
		sql.append("       cri.fill_in_date   as  investigatetime,\n"); // 调查表时间
		sql.append("       cri.sd_pat as sd_pat,\n");  // 病人编码
		sql.append("       cri.name_pat as name_pat ,\n");  // 病人姓名
		sql.append("       cri.name_sex as name_sex,\n");  // 病人性别
		sql.append("       cri.pat_age as age,\n"); // 年龄
		sql.append("       eei.code_amr_ip as code_amr_ip,\n");  // 病历号
	//	sql.append("       cri.name_bed  as name_bed,\n");  // 床位号
		sql.append("       cri.name_dept as name_dept,\n");  // 科别
		sql.append("       cri.admission_date as dt_acpt,\n");  // 入院日期
		sql.append("       cri.discharge_date as dt_end,\n"); // 出院日期
	//	sql.append("       cri.times_ip as times_ip,\n");  // 住院次数
		sql.append("       cri.in_hospital_days as days \n");  // 住院天数
		sql.append("       from CI_MR_HOS_REPORT cri\n");
		sql.append("       left join en_ent_ip eei\n");
		sql.append("       on cri.id_ent = eei.id_ent\n");
		sql.append("       where cri.id_hospitalreport in (" + str + ")" );
		//sql.append("       order by sv desc " );
		strsql = sql.toString();
	    pagingRtnData = super.findByPageInfo(new InfecOutbreakDetailReportDTO(), paginationInfo, strsql, "", null);

		return pagingRtnData;
	}
}
