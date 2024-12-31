package iih.hr.hsa.nmrecordstatis;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import iih.hr.common.GetResultbysql;
import iih.hr.hsa.dto.RecordStatisDTO;

/**
 * 功能描述:获取护理人员全院考勤统计
 * @author guo.xiao
 * @since 2019-03-15
 *
 */
public class GetNmRecordStatisDataBp {
	
	public List<RecordStatisDTO> exec(String id_dep,String dt_begin
			,String dt_end,String sd_psn_inmark) throws Exception{
		 if (validata(dt_begin, dt_end)) {
			return null;
		 }
		 return getResultByCond(id_dep, dt_begin, dt_end, sd_psn_inmark);
		
	}
	
	/**
	 * 参数验证
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 */
	private boolean validata(String dt_begin,String dt_end){
		return (StringUtils.isEmpty(dt_end) || StringUtils.isEmpty(dt_end));
		
	}
	
	private List<RecordStatisDTO> getResultByCond(String id_dep,String dt_begin
			,String dt_end,String sd_psn_inmark) throws Exception{
		GetResultbysql sqlUtils = new GetResultbysql();
		
		//1 查询出当前人员考勤天数(班次类型是出勤和假别)
		@SuppressWarnings("unchecked")
		List<RecordStatisDTO> rsList = (List<RecordStatisDTO>) 
				sqlUtils.getResultListBySql(getQrySql(dt_begin, dt_end, id_dep, sd_psn_inmark),
				RecordStatisDTO.class);
		//2 查询出当前人员出勤的总天数(班次类型是出勤)
		@SuppressWarnings("unchecked")
		List<RecordStatisDTO> rsTotalAttendList = (List<RecordStatisDTO>) 
				sqlUtils.getResultListBySql(getQrySqlForTotalAttend(dt_begin, dt_end, id_dep, sd_psn_inmark),
				RecordStatisDTO.class);
		//3 将2查出的总天数赋值给1中的对应人员
		if (CollectionUtils.isNotEmpty(rsList) && CollectionUtils.isNotEmpty(rsTotalAttendList)) {
			for (RecordStatisDTO recordTotalStatisDTO : rsTotalAttendList) {
				for (RecordStatisDTO recordStatisDTO : rsList) {
					if (recordStatisDTO.getId_nur().equals(recordTotalStatisDTO.getId_nur())) {
						recordStatisDTO.setTotal_day_attend(recordTotalStatisDTO.getTotal_day_attend());
					}
				}
			}
		}
		return rsList;
	}
	
	/**
	 * 通过参数获取人力排班
	 * @param dt_begin
	 * @param dt_end
	 * @param id_dep
	 * @param sd_psn_inmark
	 * @return
	 */
	 private String getQrySql(String dt_begin,String dt_end,
			 String id_dep,String sd_psn_inmark) {
	  		StringBuffer sb = new StringBuffer();
	  		sb.append(" select nmnur.id_nur,nmnur.name,nhrsi.name as name_nhr_si,");
	  		sb.append("nhrsi.id_nhr_si, psndoc.code,count(nhrsi.id_nhr_si) day_vaca,");
	  		sb.append("nhrsi.id_hr_si,hscsi.name as name_hsc_si,");
	  		sb.append(" count(case when nhrsi.id_hr_si = '~' then 1 else null end)");
	  		sb.append(" as day_attend,dep.name depname from nm_nhr_sched sched ");
	  		sb.append("left join nm_nhr_si nhrsi on sched.id_nhr_si = nhrsi.id_nhr_si ");
	  		sb.append("left join hr_hsc_si hscsi on hscsi.id_hsc_si = nhrsi.id_hr_si ");
	  		sb.append("left join nm_nur nmnur on nmnur.id_nur = sched.id_nur ");
	  		sb.append("left join bd_psndoc psndoc on psndoc.id_psndoc = nmnur.id_psndoc ");
	  		sb.append("left join bd_dep dep on sched.id_dep_nur = dep.id_dep ");
	  		sb.append("where 1=1 ");
	  		sb.append("and sched.dt_sched_date between '" + dt_begin + "'");
	  		sb.append("and '" + dt_end + "'");
	  		if (StringUtils.isNotEmpty(id_dep)) {
				sb.append("and dep.id_dep = '"+id_dep+"'");
			}
	  		if (StringUtils.isNotEmpty(sd_psn_inmark)) {
				sb.append(" and psndoc.sd_psn_inmark = '" + sd_psn_inmark + "'");
			}
	  		sb.append("group by nmnur.id_nur,psndoc.code,nmnur.name,nhrsi.name,nhrsi.id_nhr_si,");
	  		sb.append("nhrsi.id_hr_si,hscsi.name,dep.name");
	  		return sb.toString();
	}
	 
	 /**
	  * 通过参数查询人员总出勤天数
	  * @param dt_begin
	  * @param dt_end
	  * @param id_dep
	  * @param sd_psn_inmark
	  * @return
	  */
	 private String getQrySqlForTotalAttend(String dt_begin,String dt_end,
			String id_dep,String sd_psn_inmark) {
	  		StringBuffer sb = new StringBuffer();
	  		String qrySql = getQrySql(dt_begin, dt_end, id_dep, sd_psn_inmark);
	  		sb.append("select id_nur,name,sum(day_attend) as total_day_attend "
	  				+ "from (");
	  		sb.append(qrySql);
	  		sb.append(") group by id_nur,name");
	  		return sb.toString();
	 }

}
