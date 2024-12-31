package iih.nm.nhr.wardprint;

import iih.nm.nhr.dto.NmPsnInfoDTO;
import iih.nm.nhr.dto.SchedDTO;
import iih.nm.nhr.wardprint.qry.GetGrpPsnByDepAndDtSql;
import iih.nm.nhr.wardprint.qry.GetSchedDataByDepAndDtSql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 护理管理_排班数据报表
 * 
 * @author lijm
 *
 */
public class GetDepSchedDataBp {
	public List<SchedDTO> exec(String dt_monday, String id_dep_nur) throws BizException {
		// 1.参数校验
		paramIsLegal(dt_monday, id_dep_nur);

		// 2.查询给定科室日期人员分组
		List<NmPsnInfoDTO> psnList = getDepPsnList(dt_monday, id_dep_nur);

		// 3.查询给定科室日期排班数据
		HashMap<String, HashMap<String, SchedDTO>> schedMap = getDepSchedData(dt_monday, id_dep_nur);

		// 4.人员与排班数据关联
		List<SchedDTO> schedList = getDepFillWeekSchedDate(psnList, schedMap, dt_monday);

		// 5.返回数据
		return schedList;
	}

	private void paramIsLegal(String dt_monday, String id_dep_nur) throws BizException {
		if (StringUtil.isEmptyWithTrim(dt_monday))
			throw new BizException("参数周一日期【dt_monday】为空，请检查调用后重试！");
		if (StringUtil.isEmptyWithTrim(dt_monday))
			throw new BizException("参数科室id【id_dep_nur】为空，请检查调用后重试！");
	}

	@SuppressWarnings("unchecked")
	private List<NmPsnInfoDTO> getDepPsnList(String dt_monday, String id_dep_nur) throws BizException {
		GetGrpPsnByDepAndDtSql sql = new GetGrpPsnByDepAndDtSql(dt_monday, id_dep_nur);
		List<NmPsnInfoDTO> psndocList = (List<NmPsnInfoDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(NmPsnInfoDTO.class));
		return psndocList;
	}

	@SuppressWarnings("unchecked")
	private HashMap<String, HashMap<String, SchedDTO>> getDepSchedData(String dt_monday, String id_dep_nur) throws BizException {
		FDate dt_begin = new FDate(dt_monday);
		FDate dt_end = dt_begin.getDateAfter(6);
		GetSchedDataByDepAndDtSql sql = new GetSchedDataByDepAndDtSql(id_dep_nur, dt_begin.toString(), dt_end.toString());
		List<SchedDTO> schedList = (List<SchedDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(SchedDTO.class));
		HashMap<String, HashMap<String, SchedDTO>> schedMap = getDepSchedMap(schedList);
		return schedMap;
	}

	private HashMap<String, HashMap<String, SchedDTO>> getDepSchedMap(List<SchedDTO> schedList) throws BizException {
		HashMap<String, HashMap<String, SchedDTO>> schedMap = new HashMap<String, HashMap<String, SchedDTO>>();
		if (schedList != null && schedList.size() > 0) {
			for (SchedDTO sched : schedList) {
				if (schedMap.get(sched.getId_nur()) == null) {
					HashMap<String, SchedDTO> psnSchedMap = new HashMap<String, SchedDTO>();
					psnSchedMap.put(sched.getDt_sched_date().toString(), sched);
					schedMap.put(sched.getId_nur(), psnSchedMap);
				} else {
					HashMap<String, SchedDTO> psnSchedMap = schedMap.get(sched.getId_nur());
					if (psnSchedMap.containsKey(sched.getDt_sched_date().toString())) {
						SchedDTO schedDto = psnSchedMap.get(sched.getDt_sched_date().toString());
						schedDto.setName_nhr_si(schedDto.getName_nhr_si() + "\\" + sched.getName_nhr_si());
					} else {
						psnSchedMap.put(sched.getDt_sched_date().toString(), sched);
					}
				}
			}
		}
		return schedMap;
	}

	private List<SchedDTO> getDepFillWeekSchedDate(List<NmPsnInfoDTO> psnList, HashMap<String, HashMap<String, SchedDTO>> schedMap, String dt_monday) throws BizException {
		List<SchedDTO> weekSchedList = new ArrayList<SchedDTO>();
		FDate dt_week = new FDate(dt_monday);
		if (psnList != null && psnList.size() > 0) {
			for (NmPsnInfoDTO psndto : psnList) {
				if (schedMap.containsKey(psndto.getId_Nur())) {
					HashMap<String, SchedDTO> weekschedMap = schedMap.get(psndto.getId_Nur());
					for (int i = 0; i < 7; i++) {
						String dt = dt_week.getDateAfter(i).toString();
						if (weekschedMap.containsKey(dt)) {
							SchedDTO sched = weekschedMap.get(dt);
							sched.setName(psndto.getName());
							sched.setNamelvl(psndto.getNamelvl());
							weekSchedList.add(sched);
							sched.setSortno(weekSchedList.indexOf(sched));
						} else {
							SchedDTO sched = new SchedDTO();
							sched.setId_nur(psndto.getId_Nur());
							sched.setName(psndto.getName());
							sched.setDt_sched_date(new FDate(dt));
							sched.setNamelvl(psndto.getNamelvl());
							weekSchedList.add(sched);
							sched.setSortno(weekSchedList.indexOf(sched));
						}
					}
				} else {
					for (int i = 0; i < 7; i++) {
						String dt = dt_week.getDateAfter(i).toString();
						SchedDTO sched = new SchedDTO();
						sched.setId_nur(psndto.getId_Nur());
						sched.setName(psndto.getName());
						sched.setNamelvl(psndto.getNamelvl());
						sched.setDt_sched_date(new FDate(dt));
						weekSchedList.add(sched);
						sched.setSortno(weekSchedList.indexOf(sched));
					}
				}
			}
		}
		return weekSchedList;
	}
}
