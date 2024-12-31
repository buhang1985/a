package iih.ei.std.s.v1.bp.hr;

import java.util.HashMap;

import org.apache.commons.lang.ArrayUtils;

import iih.ei.std.d.v1.hr.depscheddata.d.SchedDataInfoDTO;
import iih.ei.std.d.v1.hr.depscheddata.d.WeekSchedInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.hr.hsc.hscschedweek.d.HscSchedDO;
import iih.hr.hsc.hscschedweek.d.HscSchedWeekDO;
import iih.hr.hsc.hscschedweek.d.HscschedweekAggDO;
import iih.hr.hsc.hscschedweek.i.IHscschedweekCudService;
import iih.hr.hsc.hscschedweek.i.IHscschedweekRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class DepSchedBp extends IIHServiceBaseBP<WeekSchedInfoResultDTO, WeekSchedInfoResultDTO> {
	@Override
	protected void checkParam(WeekSchedInfoResultDTO param) throws BizException {
		if (param == null) {
			throw new BizException("科室排班入参为空！");
		} else if (StringUtil.isEmptyWithTrim(param.getId_dep())) {
			throw new BizException("科室排班[科室Id]为空！");
		} else if (param.getDt_monday() == null) {
			throw new BizException("科室排班参[周一日期]为空！");
		} else if (FDate.getDaysBetween(param.getDt_monday(), new FDate()) > 7){
			throw new BizException("历史周排班数据不可修改！");
		}
	}

	@Override
	protected WeekSchedInfoResultDTO process(WeekSchedInfoResultDTO param) throws BizException {
		
		// 1.处理参数
		param = deptCodeTransToDeptId(param);
		
		HashMap<String,String> psnMap = getCurrentDepPsn(param.getId_dep());
		
		// 2.检查给定科室下给定周排班数据并删除
		vertifyAndDel(param);

		// 3.写入排班数据
		saveSchedData(param,psnMap);

		// 4.查询并返回
		SelectDepSchedDataBp bp = new SelectDepSchedDataBp();
		return bp.exec(param.getId_dep(), param.getDt_monday());
	}

	/**
	 * 处理科室编码 —> 科室 ID
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private WeekSchedInfoResultDTO deptCodeTransToDeptId(WeekSchedInfoResultDTO param) throws BizException {
		IDeptRService deptRService = ServiceFinder.find(IDeptRService.class);
		if(param.getHscscheds() != null && param.getHscscheds().size() > 0){
			SchedDataInfoDTO schedDataInfoDo = (SchedDataInfoDTO) param.getHscscheds().get(0);
			param.setId_dep(schedDataInfoDo.getId_dep());
		}
		DeptDO[] deptDos = deptRService.findByAttrValString(DeptDO.CODE, param.getId_dep());
		if(ArrayUtils.isEmpty(deptDos)) {
			throw new BizException("获取排班科室信息失败！");
		}
		param.setId_dep(deptDos[0].getId_dep());
		return param;
	}
	
	/**
	 * 获取当前科室人员
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	private HashMap<String,String> getCurrentDepPsn(String id_dep) throws BizException {
		IPsndocMDORService psndocMDORService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psndocDos = psndocMDORService.findByAttrValString(PsnDocDO.ID_DEP, id_dep);
		HashMap<String,String> psnMap = new HashMap<String,String>(64);
		if(ArrayUtils.isNotEmpty(psndocDos)) {
			for (PsnDocDO psnDocDO : psndocDos) {
				psnMap.put(psnDocDO.getCode(), psnDocDO.getId_psndoc());
			}
		}
		return psnMap;
	}
	
	/**
	 * 检查给定科室下给定周排班数据并删除
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void vertifyAndDel(WeekSchedInfoResultDTO param) throws BizException {
		IHscschedweekRService weekR_srv = ServiceFinder.find(IHscschedweekRService.class);
		String wherePart = String.format("id_dep='%s' and dt_monday='%s' ", param.getId_dep(), param.getDt_monday().toString());
		HscschedweekAggDO[] weekAggDos = weekR_srv.find(wherePart, null, FBoolean.FALSE);
		if (weekAggDos == null || weekAggDos.length == 0) {
			return;
		}
		IHscschedweekCudService week_cud = ServiceFinder.find(IHscschedweekCudService.class);
		week_cud.delete(weekAggDos);
	}

	private void saveSchedData(WeekSchedInfoResultDTO param, HashMap<String,String> psnMap) throws BizException {
		HscschedweekAggDO weekAggDo = new HscschedweekAggDO();
		HscSchedWeekDO schedWeekDO = new HscSchedWeekDO();
		for (String key : param.getAttrNames()) {
			key = key.substring(0,1).toUpperCase() + key.substring(1);
			if ("Hscscheds".equals(key)) {
				continue;
			}
			schedWeekDO.setAttrVal(key, param.getAttrVal(key));
			schedWeekDO.setAttrVal("Id_hsc_sched_week", null);
			weekAggDo.setParentDO(schedWeekDO);
		}
		if (param.getHscscheds() != null && param.getHscscheds().size() > 0) {
			HscSchedDO[] schedDos = new HscSchedDO[param.getHscscheds().size()];
			HscSchedDO hscSchedDo = null;
			for (int i = 0; i < param.getHscscheds().size(); i++) {
				SchedDataInfoDTO data = (SchedDataInfoDTO) param.getHscscheds().get(i);
				hscSchedDo = new HscSchedDO();
				for (String key : data.getAttrNames()) {
					key = key.substring(0,1).toUpperCase() + key.substring(1);
					if ("Shortname_hsc_si".equals(key)) {
						hscSchedDo.setAttrVal("Ctrl1", data.getAttrVal(key));
						continue;
					}
					hscSchedDo.setAttrVal(key, data.getAttrVal(key));				
				}
				hscSchedDo.setAttrVal("Id_dep", param.getAttrVal("Id_dep"));
				hscSchedDo.setId_hsc_sched(null);
				hscSchedDo.setAttrVal(" Id_hsc_sched_week", null);
				hscSchedDo.setId_psndoc(psnMap.get(data.getId_psndoc()));
				schedDos[i] = hscSchedDo;
			}
			weekAggDo.setHscSchedDO(schedDos);
		}

		IHscschedweekCudService week_cud = ServiceFinder.find(IHscschedweekCudService.class);
		week_cud.insert(new HscschedweekAggDO[] { weekAggDo });
	}
}
