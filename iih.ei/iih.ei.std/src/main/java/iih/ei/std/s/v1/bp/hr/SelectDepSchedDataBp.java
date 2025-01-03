package iih.ei.std.s.v1.bp.hr;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import iih.ei.std.d.v1.hr.depscheddata.d.SchedDataInfoDTO;
import iih.ei.std.d.v1.hr.depscheddata.d.WeekSchedInfoResultDTO;
import iih.hr.hsc.hscschedweek.d.HscSchedDO;
import iih.hr.hsc.hscschedweek.d.HscSchedWeekDO;
import iih.hr.hsc.hscschedweek.d.HscschedweekAggDO;
import iih.hr.hsc.hscschedweek.i.IHscschedweekRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 查询给定科室下对应周排班数据
 * 
 * @author Lijm
 *
 */
public class SelectDepSchedDataBp {

	public WeekSchedInfoResultDTO exec(String id_dep, FDate dt_monday) throws BizException {
		// 1.参数校验
		if (!vertifyParam(id_dep, dt_monday)) {
			return null;
		}
		// 2.数据查询
		return qryData(id_dep, dt_monday);
	}

	private Boolean vertifyParam(String id_dep, FDate dt_monday) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_dep)) {
			throw new BizException("科室排班查询入参[科室Id]为空！");
		} else if (dt_monday == null) {
			throw new BizException("科室排班查询入参[周一日期]为空！");
		}
		return true;
	}

	private WeekSchedInfoResultDTO qryData(String id_dep, FDate dt_monday) throws BizException {
		IHscschedweekRService r_srv = ServiceFinder.find(IHscschedweekRService.class);
		String wherePart = String.format("id_dep='%s' and dt_monday='%s' ", id_dep, dt_monday.toString());
		HscschedweekAggDO[] weekAggDos = r_srv.find(wherePart, null, FBoolean.FALSE);
		if (weekAggDos == null || weekAggDos.length == 0) {
			return null;
		} else if (weekAggDos.length > 1) {
			throw new BizException("当前科室" + dt_monday.toString() + "存在多条排班数据，请联系管理员！");
		} else {
			HscSchedWeekDO schedWeekDO = weekAggDos[0].getParentDO();
			HscSchedDO[] schedDos = weekAggDos[0].getHscSchedDO();
			WeekSchedInfoResultDTO result = new WeekSchedInfoResultDTO();
			for (String key : result.getAttrNames()) {
				key = key.substring(0,1).toUpperCase() + key.substring(1);
				if ("Hscscheds".equals(key)) {
					continue;
				}
				result.setAttrVal(key, schedWeekDO.getAttrVal(key));
			}
			if (schedDos != null && schedDos.length > 0) {
				FArrayList list = new FArrayList();
				for (HscSchedDO schedDo : schedDos) {
					SchedDataInfoDTO schedData = new SchedDataInfoDTO();
					for (String key : schedData.getAttrNames()) {
						key = key.substring(0,1).toUpperCase() + key.substring(1);
						if ("Shortname_hsc_si".equals(key)) {
							schedData.setAttrVal(key, schedDo.getCtrl1());
							continue;
						}
						schedData.setAttrVal(key, schedDo.getAttrVal(key));
					}
					list.add(schedData);
				}
				result.setHscscheds(list);
			}
			return result;
		}
	}
}
