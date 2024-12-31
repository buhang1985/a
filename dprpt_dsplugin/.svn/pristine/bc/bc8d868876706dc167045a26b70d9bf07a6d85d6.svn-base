package iih.hr.hsa.nmrecordstatis;

import iih.hr.common.GetResultbysql;
import iih.hr.hsa.dto.RecordStatisDTO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.utils.StringUtil;

/**
 * 人力管理_全院获取排班考勤情况（护理管理排班信息）
 * 
 * @author lijm
 *
 */
public class GetNmSchedStatisDataBp {
	public List<RecordStatisDTO> exec(String id_dep, String dt_begin, String dt_end, String sd_psn_inmark) throws Exception {
		// 1.参数校验
		paramIsLegal(dt_begin, dt_end);

		// 2.获取查询sql
		String sql = getQrySql(id_dep, dt_begin, dt_end, sd_psn_inmark);

		// 3.查询数据
		List<RecordStatisDTO> schedRecData = qryData(sql);

		// 4.返回数据
		return schedRecData;
	}

	private void paramIsLegal(String dt_begin, String dt_end) throws Exception {
		if (StringUtils.isEmpty(dt_begin)) {
			throw new Exception("参数开始日期【dt_begin】为空，请检查调用参数后重试！");
		}
		if (StringUtils.isEmpty(dt_end)) {
			throw new Exception("参数开始日期【dt_end】为空，请检查调用参数后重试！");
		}
	}

	@SuppressWarnings("unchecked")
	private List<RecordStatisDTO> qryData(String sql) throws Exception {
		GetResultbysql sqlUtils = new GetResultbysql();
		List<RecordStatisDTO> schedRecData = (List<RecordStatisDTO>) sqlUtils.getResultListBySql(sql, RecordStatisDTO.class);

		if (schedRecData == null || schedRecData.size() == 0)
			return null;
		List<RecordStatisDTO> resData = new ArrayList<RecordStatisDTO>();
		for (RecordStatisDTO recDto : schedRecData) {
			// 过滤停用人员以及虚拟人员（ljm：2019-8-22 15:13:11）
			if (recDto.getActivestate() == 2 || !(StringUtils.isEmpty(recDto.getId_hsc_si()) && recDto.getTotal_day_attend() == 0)) {
				resData.add(recDto);
			}
		}
		return resData;
	}

	private String getQrySql(String id_dep, String dt_begin, String dt_end, String sd_psn_inmark) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("	select dep.code depcode,                                                                                              ");
		sb.append("		dep.name depname,                                                                                                 ");
		sb.append("		psn.id_psndoc,                                                                                                    ");
		sb.append("		psn.code,                                                                                                         ");
		sb.append("		psn.name,                                                                                                         ");
		sb.append("		psn.activestate,                                                                                                  ");
		sb.append("		vacation.id_hsc_si,                                                                                               ");
		sb.append("		inwork.total_day_attend,                                                                                          ");
		sb.append("		vacation.day_vaca                                                                                                 ");
		sb.append("	from nm_nur nur                                                                                                       ");
		sb.append("	left join bd_psndoc psn on psn.id_psndoc=nur.id_psndoc                                                                ");
		sb.append("	left join bd_dep dep on dep.id_dep=psn.id_dep                                                                         ");
		sb.append("	left join (                                                                                                           ");
		sb.append("				select id_nur,count(id_nur) total_day_attend from nm_nhr_sched sched                                      ");
		sb.append("				where sched.id_nhr_si in                                                                                  ");
		sb.append("							(                                                                                             ");
		sb.append("							select nhrsi.id_nhr_si from nm_nhr_si nhrsi                                                   ");
		sb.append("							inner join hr_hsc_si hscsi on hscsi.id_hsc_si=nhrsi.id_hr_si and hscsi.sd_sica='02'           ");
		sb.append("							)                                                                                             ");
		sb.append("				and sched.dt_sched_date<='" + dt_end + "' and sched.dt_sched_date>='" + dt_begin + "'                     ");
		sb.append("				group by id_nur                                                                                           ");
		sb.append("			) inwork on inwork.id_nur=nur.id_nur                                                                          ");
		sb.append("	left join (                                                                                                           ");
		sb.append("				select id_nur,hscsi.id_hsc_si,hscsi.name name_hsc_si,count(id_nur) day_vaca from nm_nhr_sched sched       ");
		sb.append("				inner join nm_nhr_si nhrsi on nhrsi.id_nhr_si=sched.id_nhr_si                                             ");
		sb.append("				inner join hr_hsc_si hscsi on hscsi.id_hsc_si=nhrsi.id_hr_si and hscsi.sd_sica='01'                       ");
		sb.append("				where sched.dt_sched_date<='" + dt_end + "' and sched.dt_sched_date>='" + dt_begin + "'                   ");
		sb.append("				group by sched.id_nur,hscsi.id_hsc_si,hscsi.name                                                          ");
		sb.append("			)vacation on vacation.id_nur=nur.id_nur                                                                       ");
		if (StringUtil.isEmptyWithTrim(sd_psn_inmark)) {
			sb.append("  where  1=1                   									           	  ");
		} else {
			sb.append("  where  psn.sd_psn_inmark='" + sd_psn_inmark + "'                   									           	  ");
		}
		if (!StringUtils.isEmpty(id_dep)) {
			sb.append(" and  dep.id_dep='" + id_dep + "'                                                      					          ");
		}
		sb.append("  order by dep.code asc                                                                                                ");
		return sb.toString();
	}
}
