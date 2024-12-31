package iih.hr.hsa.recordstatis;

import iih.hr.common.GetResultbysql;
import iih.hr.hsa.dto.RecordStatisDTO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/***
 * 全院考勤统计
 * 
 * @author lijm
 *
 */
public class GetSchedStatisDataBp {
	public List<RecordStatisDTO> exec(String id_dep, String dt_begin, String dt_end, String sd_psn_inmark) throws Exception {
		// 1.参数校验
		paramIsLegal(dt_begin, dt_end);

		// 2.获取Sql
		String sql = getQrySql(id_dep, dt_begin, dt_end, sd_psn_inmark);

		// 3.数据查询
		List<RecordStatisDTO> schedRecData = QryData(sql);

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
	private List<RecordStatisDTO> QryData(String sql) throws Exception {
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

	/**
	 * 指定科室指定时间段下人员出勤(01)情况
	 * 
	 * @param id_dep
	 * @param dt_begin
	 * @param dt_end
	 * @param sd_psn_inmark
	 * @return
	 * @throws BizException
	 */
	private String getQrySql(String id_dep, String dt_begin, String dt_end, String sd_psn_inmark) throws Exception {
		StringBuffer sb = new StringBuffer();

		sb.append("	select  dep.name depname,                                                                                                                       ");
		sb.append("			psn.id_psndoc,                                                                                                                          ");
		sb.append("			psn.code,                                                                                                                               ");
		sb.append("			psn.name,                                                                                                                               ");
		sb.append("			dep.code depcode,                                                                                                                       ");
		sb.append("			psn.activestate,                                                                                                                       ");
		sb.append("			inwork.total_day_attend,                                                                                                                ");
		sb.append("			vacation.id_hsc_si,                                                                                                                     ");
		sb.append("			vacation.name_hsc_si,                                                                                                                   ");
		sb.append("			vacation.day_vaca                                                                                                                       ");
		sb.append("	from bd_psndoc psn                                                                                                                              ");
		sb.append("	left join bd_dep dep on dep.id_dep=psn.id_dep					                                                                                ");
		sb.append("	left join  (                                                                                                                                    ");
		sb.append("					select id_psndoc, count(id_psndoc) total_day_attend  from hr_hsc_sched hscsched                                                 ");
		sb.append("					inner join  hr_hsc_si hscsi on hscsi.id_hsc_si=hscsched.id_hsc_si and hscsi.sd_sica='02'                                        ");
		sb.append("					where dt_sched_date<= '" + dt_end + "' and dt_sched_date >= '" + dt_begin + "'                                                  ");
		sb.append("					group by id_psndoc                                                                                                              ");
		sb.append("			    ) inwork on inwork.id_psndoc=psn.id_psndoc					                                                                        ");
		sb.append("	left join  (                                                                                                                                    ");
		sb.append("					select hscsched.id_psndoc,hscsched.id_hsc_si,hscsched.name_hsc_si , count(id_psndoc) day_vaca  from hr_hsc_sched hscsched       ");
		sb.append("					inner join  hr_hsc_si hscsi on hscsi.id_hsc_si=hscsched.id_hsc_si and hscsi.sd_sica='01'                                        ");
		sb.append("					where dt_sched_date<= '" + dt_end + "' and dt_sched_date >= '" + dt_begin + "'                                                  ");
		sb.append("					group by hscsched.id_psndoc,hscsched.id_hsc_si,hscsched.name_hsc_si                                                             ");
		sb.append("			    ) vacation on vacation.id_psndoc = psn.id_psndoc                                                                                    ");
		if (StringUtil.isEmptyWithTrim(sd_psn_inmark)) {
			sb.append("  where  1=1     								                  									        								");
		} else {
			sb.append("  where  psn.sd_psn_inmark='" + sd_psn_inmark + "'                   									        								");
		}

		if (!StringUtils.isEmpty(id_dep)) {
			sb.append(" and  dep.id_dep='" + id_dep + "'                                                      														");
		}
		sb.append(" and nvl(psn.isvirtual,'N')='N'");
		sb.append(" 	order by dep.code asc                                                                   													");
		return sb.toString();
	}
}
