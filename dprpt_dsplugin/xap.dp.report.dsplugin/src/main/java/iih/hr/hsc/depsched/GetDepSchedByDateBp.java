package iih.hr.hsc.depsched;

import iih.hr.hsc.qry.GetDepPsnByIdSql;
import iih.hr.hsc.qry.GetDepSchedByDateSql;
import iih.nm.nhr.dto.HrPsnDTO;
import iih.nm.nhr.dto.SchedDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

import com.mysql.jdbc.StringUtils;

/**
 * 科室排班--打印预览
 * 
 * @author lijm
 * @Date 2019-6-27 19:44
 */
public class GetDepSchedByDateBp {
	public List<SchedDTO> exec(String dt_monday, String id_dep) throws BizException {
		// 1.参数校验
		paramIsLegal(dt_monday, id_dep);

		// 2.获取科室人员
		List<HrPsnDTO> psnList = getDepPsnList(id_dep);

		// 3.获取指定科室指定周下排班数据
		HashMap<String, HashMap<String, SchedDTO>> depSchedMap = getDepSchedList(dt_monday, id_dep, psnList);

		// 4.人员与排班数据映射组装
		List<SchedDTO> fillWeekSchedList = getDepFillWeekSchedDate(psnList, depSchedMap, dt_monday);

		return fillWeekSchedList;
	}

	private void paramIsLegal(String dt_monday, String id_dep) throws BizException {
		if (StringUtils.isEmptyOrWhitespaceOnly(id_dep)) {
			throw new BizException("科室参数【id_dep】为空，请检查调用参数！");
		}
		if (StringUtils.isEmptyOrWhitespaceOnly(dt_monday)) {
			throw new BizException("日期参数【dt_monday】为空，请检查调用参数！");
		}
	}

	/**
	 * 获取科室下所有人员
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private List<HrPsnDTO> getDepPsnList(String id_dep) throws BizException {
		GetDepPsnByIdSql sql = new GetDepPsnByIdSql(id_dep);
		List<HrPsnDTO> psndocList = (List<HrPsnDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(HrPsnDTO.class));
		return psndocList;
	}

	/**
	 * 获取科室下给定日期的排班数据
	 * 
	 * @param dt_monday
	 * @param id_dep
	 * @param psnList
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private HashMap<String, HashMap<String, SchedDTO>> getDepSchedList(String dt_monday, String id_dep, List<HrPsnDTO> psnList) throws BizException {
		FDate dt_begin = new FDate(dt_monday);
		FDate dt_end = dt_begin.getDateAfter(6);
		GetDepSchedByDateSql sql = new GetDepSchedByDateSql(id_dep, dt_begin.toString(), dt_end.toString());
		List<SchedDTO> psndocList = (List<SchedDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(SchedDTO.class));
		return getDepSchedMap(psndocList, psnList);
	}

	private HashMap<String, HashMap<String, SchedDTO>> getDepSchedMap(List<SchedDTO> schedList, List<HrPsnDTO> psnList) throws BizException {
		HashMap<String, HashMap<String, SchedDTO>> schedMap = new HashMap<String, HashMap<String, SchedDTO>>();
		if (schedList != null && schedList.size() > 0) {
			for (SchedDTO sched : schedList) {
				if (schedMap.get(sched.getId_psndoc()) == null) {
					HashMap<String, SchedDTO> psnSchedMap = new HashMap<String, SchedDTO>();
					psnSchedMap.put(sched.getDt_sched_date().toString(), sched);
					schedMap.put(sched.getId_psndoc(), psnSchedMap);
					if (!IsExist(psnList, sched.getId_psndoc())) {
						HrPsnDTO psn = new HrPsnDTO();
						psn.setId_psndoc(sched.getId_psndoc());
						psn.setName(sched.getName());
						psnList.add(psn);
					}
				} else {
					HashMap<String, SchedDTO> psnSchedMap = schedMap.get(sched.getId_psndoc());
					if (psnSchedMap.containsKey(sched.getDt_sched_date().toString())) {
						psnSchedMap.remove(sched.getDt_sched_date().toString());
						psnSchedMap.put(sched.getDt_sched_date().toString(), sched);
					} else {
						psnSchedMap.put(sched.getDt_sched_date().toString(), sched);
					}
				}
			}
		}
		return schedMap;
	}

	private List<SchedDTO> getDepFillWeekSchedDate(List<HrPsnDTO> psnList, HashMap<String, HashMap<String, SchedDTO>> schedMap, String dt_monday) throws BizException {
		List<SchedDTO> weekSchedList = new ArrayList<SchedDTO>();
		FDate dt_week = new FDate(dt_monday);
		if (psnList != null && psnList.size() > 0) {
			for (HrPsnDTO psndto : psnList) {
				if (schedMap.containsKey(psndto.getId_psndoc())) {
					HashMap<String, SchedDTO> weekschedMap = schedMap.get(psndto.getId_psndoc());
					for (int i = 0; i < 7; i++) {
						String dt = dt_week.getDateAfter(i).toString();
						if (weekschedMap.containsKey(dt)) {
							SchedDTO sched = weekschedMap.get(dt);
							weekSchedList.add(sched);
							sched.setSortno(weekSchedList.indexOf(sched));
						} else {
							SchedDTO sched = new SchedDTO();
							sched.setId_psndoc(psndto.getId_psndoc());
							sched.setName(psndto.getName());
							sched.setDt_sched_date(new FDate(dt));
							weekSchedList.add(sched);
							sched.setSortno(weekSchedList.indexOf(sched));
						}
					}
				} else {
					for (int i = 0; i < 7; i++) {
						String dt = dt_week.getDateAfter(i).toString();
						SchedDTO sched = new SchedDTO();
						sched.setId_psndoc(psndto.getId_psndoc());
						sched.setName(psndto.getName());
						sched.setDt_sched_date(new FDate(dt));
						weekSchedList.add(sched);
						sched.setSortno(weekSchedList.indexOf(sched));
					}
				}
			}
		}
		return weekSchedList;
	}

	private Boolean IsExist(List<HrPsnDTO> psnList, String id_psndoc) throws BizException {
		if (StringUtils.isEmptyOrWhitespaceOnly(id_psndoc))
			return true;
		if (psnList == null || psnList.size() < 1) {
			return false;
		} else {
			for (HrPsnDTO psndto : psnList) {
				if (psndto.getId_psndoc().equals(id_psndoc)) {
					return true;
				}
			}
		}
		return false;
	}
}
