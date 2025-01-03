package iih.nm.nhr.wardprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.nm.nhr.dto.NmNhrSchedDTO;
import iih.nm.nhr.dto.SiGrpPsnDTO;
import iih.nm.nhr.dto.SigrpDTO;
import iih.nm.nhr.wardprint.qry.GetDepSchedDataQry;
import iih.nm.nhr.wardprint.qry.GetSchedSigrpPsnQry;
import iih.nm.nhr.wardprint.qry.GetSchedSigrpQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 护理管理 排班考勤
 * @author 王鹏
 *
 */
public class GetDepWeekSchedDataBp {
	// 科室id
	private String id_dep;
	// 周一日期
	private String dt_monday;
	
	public GetDepWeekSchedDataBp(String id_dep,String dt_monday) {
		this.id_dep = id_dep;
		this.dt_monday = dt_monday;
	}
	
	public List<SigrpDTO> exec() throws BizException{
		// 1.参数校验
		validateParam();
		// 2.获取人员排班分组
		List<SigrpDTO> sigrpList = getSchedSigrpInfo();
		return sigrpList;
	}
	
	private void validateParam() throws BizException{
		if(StringUtils.isBlank(id_dep)) {
			throw new BizException("获取科室失败！");
		}
		if(StringUtils.isBlank(dt_monday)) {
			throw new BizException("获取周一日期失败！");
		}
	}
	
	/**
	 * 获取排班分组
	 * @return
	 * @throws DAException
	 */
	private List<SigrpDTO> getSchedSigrpInfo() throws BizException{
		GetSchedSigrpQry qrysql = new GetSchedSigrpQry(id_dep,dt_monday);
		List<SigrpDTO> sigrpList = (List<SigrpDTO>) new DAFacade().execQuery(qrysql.getQrySQLStr(), qrysql.getQryParameter(null), new BeanListHandler(SigrpDTO.class));	
		String[] nhrSigrpIds = new String[sigrpList.size()];
		for(int i = 0; i < sigrpList.size(); i++) {
			String id_nhr_sigrp = sigrpList.get(i).getId_nhr_sigrp();
			nhrSigrpIds[i] = id_nhr_sigrp;
		}
		HashMap<String,List<SiGrpPsnDTO>> sigrpPsnMap = getSchedSigrpPsnInfo(nhrSigrpIds);
		for(int i = 0; i < sigrpList.size(); i++) {
			String id_nhr_sigrp = sigrpList.get(i).getId_nhr_sigrp();
			if(sigrpPsnMap.containsKey(id_nhr_sigrp)) {
				sigrpList.get(i).setGrpPsnList(sigrpPsnMap.get(id_nhr_sigrp));
			}else {
				sigrpList.remove(i);
			}
		}
		return sigrpList;
	}
	
	/**
	 * 获取排班分组人员
	 * @param nhrSigrpIds
	 * @return
	 * @throws DAException
	 */
	private HashMap<String,List<SiGrpPsnDTO>> getSchedSigrpPsnInfo(String[] nhrSigrpIds) throws BizException{
		GetSchedSigrpPsnQry qrysql = new GetSchedSigrpPsnQry(nhrSigrpIds);
		List<SiGrpPsnDTO> sigrpPsnList = (List<SiGrpPsnDTO>) new DAFacade().execQuery(qrysql.getQrySQLStr(), qrysql.getQryParameter(null), new BeanListHandler(SiGrpPsnDTO.class));	
		// 人员排班数据
		HashMap<String,HashMap<String,NmNhrSchedDTO>> psnSchedMap = getSchedInfo();
		// 分组人员
		HashMap<String,List<SiGrpPsnDTO>> sigrpPsnMap = new HashMap<String,List<SiGrpPsnDTO>>(64);
		List<NmNhrSchedDTO> schedList = null;
		List<SiGrpPsnDTO> grpPsnList = null;
		for (SiGrpPsnDTO siGrpPsnDTO : sigrpPsnList) {
			String id_nur = siGrpPsnDTO.getId_nur();
			schedList = new ArrayList<NmNhrSchedDTO>();
			double workHourTotal = 0;
			// 该人员本周是否排班
			if(psnSchedMap.containsKey(id_nur)) {
				HashMap<String,NmNhrSchedDTO> dateSchedMap = psnSchedMap.get(id_nur);
				for(int i = 0; i < 7 ;i ++) {
					String date = new FDate(dt_monday).getDateAfter(i).toString();
					// 当天是否排班
					if(!dateSchedMap.containsKey(date)) {
						schedList.add(i,new NmNhrSchedDTO());
					}else {
						schedList.add(i, dateSchedMap.get(date));
						workHourTotal = workHourTotal + dateSchedMap.get(date).getDur_chk_ca();
					}
				}
			}else {
				for(int i = 0; i < 7 ;i ++) {
					schedList.add(i,new NmNhrSchedDTO());
				}
			}
			siGrpPsnDTO.setSchedList(schedList);
			siGrpPsnDTO.setWorkHourTotal(workHourTotal);
			String id_nhr_sigrp = siGrpPsnDTO.getId_nhr_sigrp();
			// 人员添加到指定分组
			if(!sigrpPsnMap.containsKey(id_nhr_sigrp)) {
				grpPsnList = new ArrayList<SiGrpPsnDTO>();
				grpPsnList.add(siGrpPsnDTO);
				sigrpPsnMap.put(id_nhr_sigrp, grpPsnList);
			}else {
				sigrpPsnMap.get(id_nhr_sigrp).add(siGrpPsnDTO);
			}
		}
		return sigrpPsnMap;
	}
	
	/**
	 * 获取指定科室周排班数据
	 * @return
	 * @throws DAException
	 */
	private HashMap<String,HashMap<String,NmNhrSchedDTO>> getSchedInfo() throws BizException{
		FDate dt_begin = new FDate(dt_monday);
		FDate dt_end = dt_begin.getDateAfter(6);
		GetDepSchedDataQry sql = new GetDepSchedDataQry(id_dep, dt_begin.toString(), dt_end.toString());
		List<NmNhrSchedDTO> schedList = (List<NmNhrSchedDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(NmNhrSchedDTO.class));
		// 人员排班 K：id_nur V:dateSchedMap
		HashMap<String,HashMap<String,NmNhrSchedDTO>> psnSchedMap = new HashMap<String,HashMap<String,NmNhrSchedDTO>>();
		// 人员排班 K:日期  V:排班数据
		HashMap<String,NmNhrSchedDTO> dateSchedMap = null;
		for (NmNhrSchedDTO schedDTO : schedList) {
			if(!psnSchedMap.containsKey(schedDTO.getId_nur())) {
				dateSchedMap = new HashMap<String,NmNhrSchedDTO>();
				dateSchedMap.put(schedDTO.getDt_sched_date(),schedDTO);
				psnSchedMap.put(schedDTO.getId_nur(), dateSchedMap);
			}else {
				psnSchedMap.get(schedDTO.getId_nur()).put(schedDTO.getDt_sched_date(),schedDTO);
			}
		}
		return psnSchedMap;
	}
}
