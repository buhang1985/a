package iih.sc.scp.s.task.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

import com.google.common.util.concurrent.Service;
import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDORService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import iih.sc.scbd.screleaserule.d.ScReleaseRuleItmDO;
import iih.sc.scbd.screleaserule.d.ScaptrlsruleDO;
import iih.sc.sch.dto.d.SchReleaseTaskDTO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.i.IScSchOptsrvDOCudService;
import iih.sc.sch.scsch.i.IScSchOptsrvDORService;
import iih.sc.sch.scsch.i.IScschMDOCudService;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksCudService;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.s.ep.ScReleaseRuleTaskEP;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据号源释放规则释放排班资源定时任务BP
 * @author yzh
 * @date 2018年8月21日 15:32:11
 */
public class ReleaseSchResAccordingToRulesBP {

	private static final String FIX = "1";//固定时间
	private static final String RELATIVE ="2";//相对时间
	/**
	 * 患者类型 01
	 */
	private static final String PAT_SCH_PROP_TP_ID = "@@@@Z8100000000NJ3DD";//释放患者类型01
	/**
	 * 服务类别明细类型 02
	 */
	private static final String SRV_KINDITM_SCH_PROP_TP_ID = "@@@@Z8100000000NJ3DE";//释放号位服务类别明细类型 02(医技)
	/**
	 * 号位指定渠道类型 03
	 */
	private static final String TICK_CHL_SCH_PROP_TP_ID = "@@@@Z8100000000NJ3DF";//释放号位指定渠道类型 03
	/**
	 * 是否保留指定号位 04
	 */
	private static final String TICK_SCH_PROP_TP_ID = "@@@@Z8100000000NJ3DG";//释放保留指定号位 04
	/**
	 * 添加备用服务
	 */
	private static final String SCSRV_SCH_PROP_TP_ID = "@@@@Z7100000000XOYO4";//添加备用服务(医技)
	/**
	 * 添加号位指定类别
	 */
	private static final String TICK_KINDITM_SCH_PROP_TP_ID = "@@@@Z8100000000Y1KDG";//添加号位指定类别
	/**
	 * 根据号源释放规则释放排班资源定时任务
	 * @author yzh
	 * @date 2018年8月21日 15:32:21
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException {
		// 设置上下文组织
		Context.get().setOrgId((String) map.get("id_org"));
		String sd_sctp = (String) map.get("sd_sctp");
		String[] sd_sctps = null;
		if(!StringUtil.isEmpty(sd_sctp)){
			sd_sctps = sd_sctp.split(",");
		}
		//取出所有配置有号源释放规则的排班
		SchReleaseTaskDTO[] releaseSchs = this.getAllReleaseSch(sd_sctps);
		//获取排班释放规则id集合
		List<String> releaseRuleIdList = this.getIdReleaseRuleList(releaseSchs);
		//获取排班id集合
		//List<String> idSchList = this.getIdSchList(releaseSchs);
		//获取排班释放规则明细map
		FMap releaseRuleItmMap = this.getScReleaseRuleItmByCond(releaseRuleIdList);
		//获取排班对应号段
		//FMap scTickMap = this.getScSchTickByCond(idSchList);
		//获取排班对应号位
		//FMap scTicksMap = this.getScSchTicksByCond(idSchList);
		// 循环排班根据每个排班的号源释放规则进行资源释放
		this.mainTaskProcess(releaseSchs, releaseRuleItmMap);
	}
	/**
	 * 主业务处理
	 * @param releaseSchs
	 * @param releaseRuleItmMap
	 * @exception Bizexception
	 */
	@SuppressWarnings("unchecked")
	private void mainTaskProcess(SchReleaseTaskDTO[] releaseSchs,FMap releaseRuleItmMap)throws BizException{
		if(!ArrayUtil.isEmpty(releaseSchs) && !org.apache.commons.collections.MapUtils.isEmpty(releaseRuleItmMap)){
			//需要设置就诊类型list 01
			List<String> schEnIDList = new ArrayList<String>();
			//号位明细设置list 02
			List<String> schScSchtickKinditmList = new ArrayList<String>();
			//号段明细设置list 02
			List<String> schScSchticksKinditmList = new ArrayList<String>();
			// 根据类别明细释放号位 02
			Map<String[],List<String>> scTickKinditmMap = new HashMap<String[],List<String>>();
			// 根据类别明细释放号段 02 
			Map<String[],List<String>> scTicksKinditmMap = new HashMap<String[],List<String>>();
			//渠道设置list 03
			List<String> schScchlList = new ArrayList<String>();
			//保留号位开放list 04
			List<String> schQuecnList = new ArrayList<String>();
			//存放需要开放号位的排班 04
			List<SchReleaseTaskDTO> schQuecnPolnoList = new ArrayList<SchReleaseTaskDTO>();
			//存放需要添加备用服务的排班 05
			List<String> schOptsrvAllList = new ArrayList<String>();
			//根据规则上的排班服务释放到相应排班上
			Map<String[],List<String>> schOptsrvMap = new HashMap<String[],List<String>>();
			//需要释放号段号位类别明细的排班
			List<String> schAllKinditmList = new ArrayList<String>();
			//需要释放号段类别明细的排班
			//List<String> schTicksKinditmList = new ArrayList<String>();
			//根据规则上的服务类别明细释放到相应排班的号位和号段上
			Map<String[],List<String>> schTickKinditmMap = new HashMap<String[],List<String>>();
			//循环排班处理
			for (SchReleaseTaskDTO schReleaseTaskDTO : releaseSchs) {
				if(releaseRuleItmMap.containsKey(schReleaseTaskDTO.getId_release_rule())){
					List<ScReleaseRuleItmDO> itmList = (List<ScReleaseRuleItmDO>) releaseRuleItmMap.get(schReleaseTaskDTO.getId_release_rule());
					//循环号源释放规则明细
					for (ScReleaseRuleItmDO scReleaseRuleItmDO : itmList) {
						//校验排班是否在号源释放期间内
						if(this.checkDsch(schReleaseTaskDTO.getT_b_acpt(), schReleaseTaskDTO.getD_sch(),schReleaseTaskDTO.getId_sctp(), scReleaseRuleItmDO)){
							if(PAT_SCH_PROP_TP_ID.equals(scReleaseRuleItmDO.getId_sch_prop_tp())){//患者类型
								if(schReleaseTaskDTO.getFg_setentp().booleanValue()){
									schEnIDList.add(schReleaseTaskDTO.getId_sch());
								}
							}else if(SRV_KINDITM_SCH_PROP_TP_ID.equals(scReleaseRuleItmDO.getId_sch_prop_tp()) && IScDictCodeConst.ID_SCTP_MT.equals(schReleaseTaskDTO.getId_sctp())){//服务类别明细
								if (StringUtil.isEmpty(scReleaseRuleItmDO.getIds_scsrvkinditm())){
									if(IScDictCodeConst.SD_TICKMD_TICK.equals(schReleaseTaskDTO.getSd_tickmd())){
										schScSchtickKinditmList.add(schReleaseTaskDTO.getId_sch());
									}else{
										schScSchticksKinditmList.add(schReleaseTaskDTO.getId_sch());
									}
								}else{
									if(IScDictCodeConst.SD_TICKMD_TICK.equals(schReleaseTaskDTO.getSd_tickmd())){
										if (!scTickKinditmMap.containsKey(scReleaseRuleItmDO.getIds_scsrvkinditm().split(","))) {
											List<String> schticklist = new ArrayList<String>();
											schticklist.add(schReleaseTaskDTO.getId_sch());
											scTickKinditmMap.put(scReleaseRuleItmDO.getIds_scsrvkinditm().split(","), schticklist);
										}else{
											List<String> schticklist = scTickKinditmMap.get(scReleaseRuleItmDO.getIds_scsrvkinditm().split(","));
											schticklist.add(schReleaseTaskDTO.getId_sch());
										}
									}else{
										if (!scTicksKinditmMap.containsKey(scReleaseRuleItmDO.getIds_scsrvkinditm().split(","))) {
											List<String> schtickslist = new ArrayList<String>();
											schtickslist.add(schReleaseTaskDTO.getId_sch());
											scTicksKinditmMap.put(scReleaseRuleItmDO.getIds_scsrvkinditm().split(","), schtickslist);
										}else{
											List<String> schtickslist = scTicksKinditmMap.get(scReleaseRuleItmDO.getIds_scsrvkinditm().split(","));
											schtickslist.add(schReleaseTaskDTO.getId_sch());
										}
									}
								}
							}else if(TICK_CHL_SCH_PROP_TP_ID.equals(scReleaseRuleItmDO.getId_sch_prop_tp())){//号位指定渠道
								schScchlList.add(schReleaseTaskDTO.getId_sch());
							}else if(TICK_SCH_PROP_TP_ID.equals(scReleaseRuleItmDO.getId_sch_prop_tp())){//是否保留指定号位
								if(schReleaseTaskDTO.getFg_auto_release().booleanValue() && (schReleaseTaskDTO.getQuan_total_appt()<schReleaseTaskDTO.getQuan_total())){
									schQuecnList.add(schReleaseTaskDTO.getId_sch());
									schQuecnPolnoList.add(schReleaseTaskDTO);
								}
							}else if(SCSRV_SCH_PROP_TP_ID.equals(scReleaseRuleItmDO.getId_sch_prop_tp()) && IScDictCodeConst.ID_SCTP_MT.equals(schReleaseTaskDTO.getId_sctp())){//添加备用排班服务
								schOptsrvAllList.add(schReleaseTaskDTO.getId_sch());
								if(!schOptsrvMap.containsKey(scReleaseRuleItmDO.getIds_scsrv().split(","))){
									List<String> schOptsrvList = new ArrayList<String>();
									schOptsrvList.add(schReleaseTaskDTO.getId_sch());
									schOptsrvMap.put(scReleaseRuleItmDO.getIds_scsrv().split(","), schOptsrvList);
								}else{
									List<String> schOptsrvList = schOptsrvMap.get(scReleaseRuleItmDO.getIds_scsrv().split(","));
									schOptsrvList.add(schReleaseTaskDTO.getId_sch());
								}
							}else if (TICK_KINDITM_SCH_PROP_TP_ID.equals(scReleaseRuleItmDO.getId_sch_prop_tp()) && IScDictCodeConst.ID_SCTP_MT.equals(schReleaseTaskDTO.getId_sctp())) {//添加排班上号位号段的类别明细
								schAllKinditmList.add(schReleaseTaskDTO.getId_sch());
								if (!schTickKinditmMap.containsKey(scReleaseRuleItmDO.getIds_scsrvkinditm().split(","))) {
									List<String> schList = new ArrayList<String>();
									schList.add(schReleaseTaskDTO.getId_sch());
									schTickKinditmMap.put(scReleaseRuleItmDO.getIds_scsrvkinditm().split(","), schList);
								}else{
									List<String> schList = schTickKinditmMap.get(scReleaseRuleItmDO.getIds_scsrvkinditm().split(","));
									schList.add(schReleaseTaskDTO.getId_sch());
								}
							}
						}
					}
				}
			}
			//更新排班fg_setentp
			if(!ListUtil.isEmpty(schEnIDList)){
				this.updSchEntp(schEnIDList);
			}
			//置空排班号位的排班类别明细
			if(!ListUtil.isEmpty(schScSchtickKinditmList)){
				this.updScTickKinditm(schScSchtickKinditmList);
			}
			//置空排班号段的排班类别明细
			if(!ListUtil.isEmpty(schScSchticksKinditmList)){
				this.updScTicksKinditm(schScSchticksKinditmList);
			}
			//置空排班号位的排班类别明细(指定类别明细)
			if(!MapUtils.isEmpty(scTickKinditmMap)){
				this.updScTickKinditm(scTickKinditmMap);
			}
			//置空排班号段的排班类别明细(指定类别明细)
			if(!MapUtils.isEmpty(scTicksKinditmMap)){
				this.updScTicksKinditm(scTicksKinditmMap);
			}
			//置空号位渠道
			if(!ListUtil.isEmpty(schScchlList)){
				this.updScChl(schScchlList);
			}
			//放开排班保留号位
			if(!ListUtil.isEmpty(schQuecnList)){
				this.updQuecnApptAndUseScope(schQuecnList);
				this.updQuecnPolno(schQuecnPolnoList,schQuecnList);
			}
			//释放备用排班服务到排班上
			if (!MapUtils.isEmpty(schOptsrvMap)) {
				this.updSchScSrv(schOptsrvMap,schOptsrvAllList);
			}
			//释放类别明细到符合要求的号段号位上
			if (!MapUtils.isEmpty(schTickKinditmMap)) {
				this.updSchKindItm(schTickKinditmMap,schAllKinditmList);
			}
		}
	}

	/**
	 * 释放号位后更新号源池的开放数 根据科室参数里的主号源池号来释放
	 * @param schQuecnPolnoList
	 * @param schQuecnList
	 */
	private void updQuecnPolno(List<SchReleaseTaskDTO> schQuecnPolnoList,List<String> schQuecnList) throws BizException{
		if(ListUtil.isEmpty(schQuecnPolnoList)) return;
		//1.获取排班数据
		IScschMDORService iscschmdorservice = ServiceFinder.find(IScschMDORService.class);
		ScSchDO[] schs = iscschmdorservice.findByBIds(schQuecnList.toArray(new String[0]), FBoolean.FALSE);
		Map<String,List<BaseDO>> schMap = ScAppUtils.extractObjMapFromObjs(ScSchDO.ID_SCH,schs);
		List<ScSchDO> updSchs = new ArrayList<ScSchDO>();
		//2.计算并更新主号源池开放数
		for (SchReleaseTaskDTO schReleaseTaskDTO : schQuecnPolnoList) {
			String id_sch = schReleaseTaskDTO.getId_sch();
			if(schMap.containsKey(id_sch)){
				ScSchDO sch = (ScSchDO) schMap.get(id_sch).get(0);
				int count = 0;
				Integer mainPolno = schReleaseTaskDTO.getPolno_maj()==null?0:schReleaseTaskDTO.getPolno_maj();
				for (int i = 0; i < 10; i++) {
					if(i == mainPolno){
						continue;
					}
					count += (Integer)sch.getAttrVal(String.format("Quan%s_appt", i));
				}
				Integer appt = sch.getQuan_total()-count;
				sch.setAttrVal(String.format("Quan%s_appt", mainPolno), appt);
				sch.setStatus(DOStatus.UPDATED);
				updSchs.add(sch);
			}
		}
		if(!ListUtil.isEmpty(updSchs)){
			IScschMDOCudService iscschmdocudservice = ServiceFinder.find(IScschMDOCudService.class);
			iscschmdocudservice.save(updSchs.toArray(new ScSchDO[0]));
		}
	}
	/**
	 * 释放号段预约数
	 * @param schQuecnList
	 * @throws BizException
	 */
	private void updQuecnApptAndUseScope(List<String> schQuecnList)throws BizException{
		String condition = ScSqlUtils.getInSqlByIds(ScSchDO.ID_SCH, schQuecnList);
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append("update sc_tick set eu_usescope = 1 where eu_usescope = 2 and fg_active='Y' and ");
		sql.append(condition);
		dafacade.execUpdate(sql.toString());
		sql.delete(0, sql.length());
		sql.append("update sc_ticks set quecn_appt=quecn where ");
		sql.append(condition);
		dafacade.execUpdate(sql.toString());
		sql.delete(0, sql.length());
		sql.append("update sc_sch set quan_total_appt=quan_total where ");
		sql.append(condition);
		dafacade.execUpdate(sql.toString());
	}
	/**
	 * 释放号位渠道
	 * @param schScchlList
	 * @throws BizException
	 */
	private void updScChl(List<String> schScchlList)throws BizException{
		String condition = ScSqlUtils.getInSqlByIds(ScSchDO.ID_SCH, schScchlList);
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append(" update sc_tick set ids_scchl = null,polno = null where ");//清空号位上的渠道和号源池
		sql.append(condition);
		dafacade.execUpdate(sql.toString());
	}
	/**
	 * 更新sc_ticks.ids_kinditm
	 * @param schScStickKinditmList
	 * @throws BizException
	 */
	private void updScTicksKinditm(List<String> schSchticksKinditmList)throws BizException{
		String condition = ScSqlUtils.getInSqlByIds(ScSchTicksDO.ID_SCH, schSchticksKinditmList);
		StringBuffer sql = new StringBuffer();
		sql.append(" update sc_ticks set ids_kinditm = null where ");
		sql.append(condition);
		DAFacade dafacade = new DAFacade();
		dafacade.execUpdate(sql.toString());
	}
	/**
	 * 释放备用排班服务到排班上
	 * @param schOptsrvMap
	 * @throws BizException
	 */
	private void updSchScSrv(Map<String[],List<String>> schOptsrvMap,List<String> schOptsrvAllList) throws BizException{
		String schCondition = ScSqlUtils.getInSqlByIds(ScSchTickDO.ID_SCH, schOptsrvAllList);
		DAFacade dafacade = new DAFacade();
		StringBuilder sqlQry = new StringBuilder();
		sqlQry.append("select id_schoptsrv,id_sch,id_scsrv from sc_sch_optsrv where 1=2 ");
		if (!StringUtil.isEmpty(schCondition)) {
			sqlQry.append("or ").append(schCondition);
		}
		List<ScSchOptsrvDO> optsrvs = (List<ScSchOptsrvDO>) dafacade.execQuery(sqlQry.toString(), new BeanListHandler(ScSchOptsrvDO.class));
		Map<String,List<ScSchOptsrvDO>> optsrvMap = new HashMap<String,List<ScSchOptsrvDO>>();
		//排班备用服务分组
		for (ScSchOptsrvDO scSchOptsrvDO : optsrvs) {
			if(!optsrvMap.containsKey(scSchOptsrvDO.getId_sch())){
				List<ScSchOptsrvDO> list = new ArrayList<ScSchOptsrvDO>();
				list.add(scSchOptsrvDO);
				optsrvMap.put(scSchOptsrvDO.getId_sch(), list);
			}else{
				List<ScSchOptsrvDO> list = optsrvMap.get(scSchOptsrvDO.getId_sch());
				list.add(scSchOptsrvDO);
			}
		}
		List<ScSchOptsrvDO> result = new ArrayList<ScSchOptsrvDO>();
		for (Map.Entry<String[],List<String>> entry : schOptsrvMap.entrySet()) {
			//规则中的要添加的排班服务
			String[] scsrvs = entry.getKey();
			//要释放的排班服务对应的排班集合
			List<String> list = entry.getValue();
			for (String id_sch : list) {
				if(optsrvMap.containsKey(id_sch)){
					//排班已有的备用排班服务
					List<ScSchOptsrvDO> optsrvlist = optsrvMap.get(id_sch);
					if(ListUtil.isEmpty(optsrvlist)){
						for (String scsrv : scsrvs) {
							ScSchOptsrvDO optsrvDO = new ScSchOptsrvDO();
							optsrvDO.setStatus(DOStatus.NEW);
							optsrvDO.setId_sch(id_sch);
							optsrvDO.setId_scsrv(scsrv);
							result.add(optsrvDO);
						}
					}else{
						for (String scsrv : scsrvs) {
							//判断要释放的排班服务是否已经存在于排班的备用排班服务中
							if(!optsrvlist.contains(scsrv)){
								ScSchOptsrvDO optsrvDO = new ScSchOptsrvDO();
								optsrvDO.setStatus(DOStatus.NEW);
								optsrvDO.setId_sch(id_sch);
								optsrvDO.setId_scsrv(scsrv);
								result.add(optsrvDO);
							}
						}
					}
					
				}else{
					for (String scsrv : scsrvs) {
						ScSchOptsrvDO optsrvDO = new ScSchOptsrvDO();
						optsrvDO.setStatus(DOStatus.NEW);
						optsrvDO.setId_sch(id_sch);
						optsrvDO.setId_scsrv(scsrv);
						result.add(optsrvDO);
					}
				}
			}
		}
		if(!ListUtil.isEmpty(result)){
			IScSchOptsrvDOCudService iscschoptsrvdocudservice = ServiceFinder.find(IScSchOptsrvDOCudService.class);
			iscschoptsrvdocudservice.save(result.toArray(new ScSchOptsrvDO[0]));
		}
	}

	/**
	 * 为指定排班的号位号段增加类别明细
	 * @param schTickKinditmMap
	 * @param schList
	 * @throws BizException
	 */
	private void updSchKindItm(Map<String[],List<String>> schTickKinditmMap,List<String> schList) throws BizException{
		String schCondition = ScSqlUtils.getInSqlByIds(ScSchTickDO.ID_SCH, schList);
		DAFacade dafacade = new DAFacade();
		StringBuilder sqlQry = new StringBuilder();
		sqlQry.append("select * from sc_ticks where 1=2 ");
		if (!StringUtil.isEmpty(schCondition)) {
			sqlQry.append("or ").append(schCondition);
		}
		List<ScSchTicksDO> ticksList = (List<ScSchTicksDO>) dafacade.execQuery(sqlQry.toString(), new BeanListHandler(ScSchTicksDO.class));
		sqlQry.delete(0, sqlQry.length());
		sqlQry.append("select * from sc_tick where 1=2 ");
		if (!StringUtil.isEmpty(schCondition)) {
			sqlQry.append("or ").append(schCondition);
		}
		List<ScSchTickDO> tickList = (List<ScSchTickDO>) dafacade.execQuery(sqlQry.toString(), new BeanListHandler(ScSchTickDO.class));
		//号段根据idsch分组
		Map<String,List<ScSchTicksDO>> ticksMap = new HashMap<String,List<ScSchTicksDO>>();
		//号位根据idsch分组
		Map<String,List<ScSchTickDO>> tickMap = new HashMap<String,List<ScSchTickDO>>();
		//号段根据idsch分组
		for (ScSchTicksDO scSchTicksDO : ticksList) {
			if(!ticksMap.containsKey(scSchTicksDO.getId_sch())){
				List<ScSchTicksDO> list = new ArrayList<ScSchTicksDO>();
				list.add(scSchTicksDO);
				ticksMap.put(scSchTicksDO.getId_sch(), list);
			}else{
				List<ScSchTicksDO> list = ticksMap.get(scSchTicksDO.getId_sch());
				list.add(scSchTicksDO);
			}
		}
		//号位根据idsch分组
		for (ScSchTickDO scSchTickDO : tickList) {
			if(!tickMap.containsKey(scSchTickDO.getId_sch())){
				List<ScSchTickDO> list = new ArrayList<ScSchTickDO>();
				list.add(scSchTickDO);
				tickMap.put(scSchTickDO.getId_sch(), list);
			}else{
				List<ScSchTickDO> list = tickMap.get(scSchTickDO.getId_sch());
				list.add(scSchTickDO);
			}
		}
		//需要更新的号段数据
		List<ScSchTicksDO> ticksResult = new ArrayList<ScSchTicksDO>();
		//需要更新的号位数据
		List<ScSchTickDO> tickResult = new ArrayList<ScSchTickDO>();
		for (Map.Entry<String[],List<String>> entry : schTickKinditmMap.entrySet()) {
			//规则中的要添加的服务类别明细
			String[] id_kinditms = entry.getKey();
			//要释放的排班服务对应的排班集合
			List<String> list = entry.getValue();
			for (String id_sch : list) {
				if(ticksMap.containsKey(id_sch)){
					List<ScSchTicksDO> ticks_list = ticksMap.get(id_sch);
					this.handleTicksKinditm(ticks_list, id_kinditms,ticksResult);
				}
				if (tickMap.containsKey(id_sch)) {
					List<ScSchTickDO> tick_list = tickMap.get(id_sch);
					this.handleTickKinditm(tick_list, id_kinditms,tickResult);
				}
			}
		}
		if (!ListUtil.isEmpty(ticksResult)) {
			IScticksCudService isctickscudservice = ServiceFinder.find(IScticksCudService.class);
			isctickscudservice.save(ticksResult.toArray(new ScSchTicksDO[0]));
		}
		if (!ListUtil.isEmpty(tickResult)) {
			ISctickCudService isctickcudservice = ServiceFinder.find(ISctickCudService.class);
			isctickcudservice.save(tickResult.toArray(new ScSchTickDO[0]));
		}
	}
	/**
	 * 处理号段上的类别明细
	 * @param ticksList
	 * @param id_kinditms
	 */
	private void handleTicksKinditm(List<ScSchTicksDO> ticksList,String[] id_kinditms,List<ScSchTicksDO> ticksResult){
		if(ArrayUtil.isEmpty(id_kinditms)) return;
		for (ScSchTicksDO scSchTicksDO : ticksList) {
			String idsKinditm = scSchTicksDO.getIds_kinditm();
			if(!StringUtil.isEmpty(idsKinditm)){
				Map<String,String> tempMap = new HashMap<String,String>(); 
				String[] idsKindtms = idsKinditm.split(",");
				for (String id_kinditm : idsKindtms) {
					if(!tempMap.containsKey(id_kinditm)){
						tempMap.put(id_kinditm, "");
					}
				}
				for (String id_kinditm : id_kinditms) {
					if(!tempMap.containsKey(id_kinditm)){
						tempMap.put(id_kinditm, "");
					}
				}
				int uniqueNums = tempMap.size();
			    String[] uniqueArray = new String[uniqueNums];
			    for(String key : tempMap.keySet()){
			        uniqueArray[--uniqueNums] = key;
			    }
			    String ids_kinditm = "";
				for (String id_kinditm : uniqueArray) {
					ids_kinditm = ids_kinditm + id_kinditm + ",";
				}
				scSchTicksDO.setIds_kinditm(ids_kinditm.substring(0, ids_kinditm.length()-1));
				scSchTicksDO.setStatus(DOStatus.UPDATED);
				ticksResult.add(scSchTicksDO);
			}else{
				String ids_kinditm = "";
				for (String id_kinditm : id_kinditms) {
					ids_kinditm = ids_kinditm + id_kinditm + ",";
				}
				scSchTicksDO.setIds_kinditm(ids_kinditm.substring(0, ids_kinditm.length()-1));
				scSchTicksDO.setStatus(DOStatus.UPDATED);
				ticksResult.add(scSchTicksDO);
			}
		}
	}
	/**
	 * 处理号位上的类别明细
	 * @param tickList
	 * @param id_kinditms
	 */
	private void handleTickKinditm(List<ScSchTickDO> tickList,String[] id_kinditms,List<ScSchTickDO> tickResult){
		if(ArrayUtil.isEmpty(id_kinditms)) return;
		for (ScSchTickDO scSchTickDO : tickList) {
			String idsKinditm = scSchTickDO.getIds_kinditm();
			if(!StringUtil.isEmpty(idsKinditm)){
				Map<String,String> tempMap = new HashMap<String,String>(); 
				String[] idsKindtms = idsKinditm.split(",");
				for (String id_kinditm : idsKindtms) {
					if(!tempMap.containsKey(id_kinditm)){
						tempMap.put(id_kinditm, "");
					}
				}
				for (String id_kinditm : id_kinditms) {
					if(!tempMap.containsKey(id_kinditm)){
						tempMap.put(id_kinditm, "");
					}
				}
				int uniqueNums = tempMap.size();
			    String[] uniqueArray = new String[uniqueNums];
			    for(String key : tempMap.keySet()){
			        uniqueArray[--uniqueNums] = key;
			    }
			    String ids_kinditm = "";
				for (String id_kinditm : uniqueArray) {
					ids_kinditm = ids_kinditm + id_kinditm + ",";
				}
				scSchTickDO.setIds_kinditm(ids_kinditm.substring(0, ids_kinditm.length()-1));
				scSchTickDO.setStatus(DOStatus.UPDATED);
				tickResult.add(scSchTickDO);
			}else{
				String ids_kinditm = "";
				for (String id_kinditm : id_kinditms) {
					ids_kinditm = ids_kinditm + id_kinditm + ",";
				}
				scSchTickDO.setIds_kinditm(ids_kinditm.substring(0, ids_kinditm.length()-1));
				scSchTickDO.setStatus(DOStatus.UPDATED);
				tickResult.add(scSchTickDO);
			}
		}
	
	}
	/**
	 * 更新sc_tick.ids_kinditm
	 * @param scTickKinditmMap
	 * @throws BizException
	 */
	private void updScTickKinditm(Map<String[],List<String>> scTickKinditmMap)throws BizException{
		List<String> idSchList = new ArrayList<String>();
		for (Map.Entry<String[],List<String>> entry : scTickKinditmMap.entrySet()) {
			String[] key = entry.getKey();
			List<String> list = entry.getValue();
			idSchList.addAll(list);
		}
		String condition = ScSqlUtils.getInSqlByIds(ScSchTickDO.ID_SCH, idSchList);
		ISctickRService isctickrservice = ServiceFinder.find(ISctickRService.class);
		ScSchTickDO[] tickarr = isctickrservice.find(condition, null, FBoolean.FALSE);
		//需要被清空的号位集合
		List<String> tickEmptyList = new ArrayList<String>();
		//需要被清空某一明细的号位集合
		Map<String[],List<String>> tickMap = new HashMap<String[],List<String>>();
		for (Map.Entry<String[],List<String>> entry : scTickKinditmMap.entrySet()) {
			String[] key = entry.getKey();//要释放的明细数组
			List<String> list = entry.getValue();
			List<String> idticklist = new ArrayList<String>();
			for (ScSchTickDO tick : tickarr) {
				String id_sch = tick.getId_sch();
				if (list.contains(id_sch)) {
					if (!StringUtil.isEmpty(tick.getIds_kinditm())) {
						//String[] tickKindItm = tick.getIds_kinditm().split(",");
						//if(isHasArray(key, tickKindItm)){
						//	tickEmptyList.add(tick.getId_tick());
						//}
						idticklist.add(tick.getId_tick());
						
					}
				}
			}
			if(tickMap.containsKey(key)){
				tickMap.get(key).addAll(idticklist);
			}else{
				tickMap.put(key, idticklist);
			}
		}
		StringBuffer sql = new StringBuffer();
		//condition = ScSqlUtils.getInSqlByIds(ScSchTickDO.ID_TICK, idticklist);
		//sql.append(" update sc_tick set ids_kinditm = null where ");
		//sql.append(condition);
		DAFacade dafacade = new DAFacade();
		//dafacade.execUpdate(sql.toString());
		if(!MapUtils.isEmpty(tickMap)){
			for (Map.Entry<String[],List<String>> entry : tickMap.entrySet()) {
				String[] key = entry.getKey();//要释放的明细数组
				List<String> list = entry.getValue();
				if(!ListUtil.isEmpty(list)){
					for (String id_kinditm : key) {
						condition = ScSqlUtils.getInSqlByIds(ScSchTickDO.ID_TICK, list);
						sql.delete(0, sql.length());
						//将指定明细释放
						sql.append(" update sc_tick set ids_kinditm = replace(ids_kinditm,'")
						.append(id_kinditm).append("','') where ")
						.append(condition);
						dafacade.execUpdate(sql.toString());		
						sql.delete(0, sql.length());
						//将,,替换为''
						sql.append(" update sc_tick set ids_kinditm = replace(ids_kinditm,',,',',') where ")
						.append(condition);
						dafacade.execUpdate(sql.toString());
						sql.delete(0, sql.length());
						//将首位字符为,的替换为''
						sql.append(" update sc_tick set ids_kinditm =substr(ids_kinditm,2,length(ids_kinditm)-1)  where substr(ids_kinditm,0,1)=',' and ")
						.append(condition);
						dafacade.execUpdate(sql.toString());
						sql.delete(0, sql.length());
						//将末位字符为,的替换为''
						sql.append(" update sc_tick set ids_kinditm =substr(ids_kinditm,1,length(ids_kinditm)-1)  where substr(ids_kinditm,length(ids_kinditm),1)=',' and ")
						.append(condition);
						dafacade.execUpdate(sql.toString());
					}
				}
			}
		}
	}
	/**
	 * 更新sc_tick.ids_kinditm
	 * @param scTicksKinditmMap
	 * @throws BizException
	 */
	private void updScTicksKinditm(Map<String[],List<String>> scTicksKinditmMap)throws BizException{
		List<String> idSchList = new ArrayList<String>();
		for (Map.Entry<String[],List<String>> entry : scTicksKinditmMap.entrySet()) {
			String[] key = entry.getKey();
			List<String> list = entry.getValue();
			idSchList.addAll(list);
		}
		String condition = ScSqlUtils.getInSqlByIds(ScSchTicksDO.ID_SCH, idSchList);
		IScticksRService iscticksrservice = ServiceFinder.find(IScticksRService.class);
		ScSchTicksDO[] ticksarr = iscticksrservice.find(condition, null, FBoolean.FALSE);
		List<String> ticksEmptyList = new ArrayList<String>();
		Map<String[],List<String>> ticksMap = new HashMap<String[],List<String>>();
		for (Map.Entry<String[],List<String>> entry : scTicksKinditmMap.entrySet()) {
			String[] key = entry.getKey();
			List<String> list = entry.getValue();
			List<String> idtickslist = new ArrayList<String>();
			for (ScSchTicksDO ticks : ticksarr) {
				String id_sch = ticks.getId_sch();
				if (list.contains(id_sch)) {
					if (!StringUtil.isEmpty(ticks.getIds_kinditm())) {
						//String[] ticksKindItm = ticks.getIds_kinditm().split(",");
						//if(isHasArray(key, ticksKindItm)){
						//	ticksList.add(ticks.getId_ticks());
						//}
						idtickslist.add(ticks.getId_ticks());
					}
				}
			}
			if(ticksMap.containsKey(key)){
				ticksMap.get(key).addAll(idtickslist);
			}else{
				ticksMap.put(key, idtickslist);
			}
		}
		StringBuffer sql = new StringBuffer();
		//condition = ScSqlUtils.getInSqlByIds(ScSchTicksDO.ID_TICKS, idtickslist);
		//sql.append(" update sc_ticks set ids_kinditm = null where ");
		//sql.append(condition);
		DAFacade dafacade = new DAFacade();
		//dafacade.execUpdate(sql.toString());
		if(!MapUtils.isEmpty(ticksMap)){
			for (Map.Entry<String[],List<String>> entry : ticksMap.entrySet()) {
				String[] key = entry.getKey();//要释放的明细数组
				List<String> list = entry.getValue();
				if(!ListUtil.isEmpty(list)){
					for (String id_kinditm : key) {
						condition = ScSqlUtils.getInSqlByIds(ScSchTicksDO.ID_TICKS, list);
						sql.delete(0, sql.length());
						//将指定明细释放
						sql.append(" update sc_ticks set ids_kinditm = replace(ids_kinditm,'")
						.append(id_kinditm).append("','') where ")
						.append(condition);
						dafacade.execUpdate(sql.toString());		
						sql.delete(0, sql.length());
						//将,,替换为''
						sql.append(" update sc_ticks set ids_kinditm = replace(ids_kinditm,',,',',') where ")
						.append(condition);
						dafacade.execUpdate(sql.toString());
						sql.delete(0, sql.length());
						//将首位字符为,的替换为''
						sql.append(" update sc_ticks set ids_kinditm =substr(ids_kinditm,2,length(ids_kinditm)-1)  where substr(ids_kinditm,0,1)=',' and ")
						.append(condition);
						dafacade.execUpdate(sql.toString());
						sql.delete(0, sql.length());
						//将末位字符为,的替换为''
						sql.append(" update sc_ticks set ids_kinditm =substr(ids_kinditm,1,length(ids_kinditm)-1)  where substr(ids_kinditm,length(ids_kinditm),1)=',' and ")
						.append(condition);
						dafacade.execUpdate(sql.toString());
					}
				}
			}
		}
	}
	/**
	 * 更新sc_tick.ids_kinditm
	 * @param schScStickKinditmList
	 * @throws BizException
	 */
	private void updScTickKinditm(List<String> schScStickKinditmList)throws BizException{
		String condition = ScSqlUtils.getInSqlByIds(ScSchTickDO.ID_SCH, schScStickKinditmList);
		StringBuffer sql = new StringBuffer();
		sql.append(" update sc_tick set ids_kinditm = null where ");
		sql.append(condition);
		DAFacade dafacade = new DAFacade();
		dafacade.execUpdate(sql.toString());
	}
	/**
	 * 更新sc_sch.fg_setentp
	 * @param schEnIDList
	 * @throws DAException
	 */
	private void updSchEntp(List<String> schEnIDList) throws DAException{
		String condition = ScSqlUtils.getInSqlByIds(ScSchDO.ID_SCH, schEnIDList);
		StringBuffer sql = new StringBuffer();
		sql.append("update sc_sch set fg_setentp ='N' where ");
		sql.append(condition);
		DAFacade dafacade = new DAFacade();
		dafacade.execUpdate(sql.toString());
	}
	
	/**
	 * 获取排班释放规则id集合
	 * @param releaseSchs
	 * @return
	 */
	private List<String> getIdReleaseRuleList(SchReleaseTaskDTO[] releaseSchs){
		List<String> result = new ArrayList<String>();
		if(!ArrayUtil.isEmpty(releaseSchs)){
			for (SchReleaseTaskDTO schReleaseTaskDTO : releaseSchs) {
				result.add(schReleaseTaskDTO.getId_release_rule());
			}
		}
		return result;
	}
	/**
	 * 获取排班id集合
	 * @param releaseSchs
	 * @return
	 */
	private List<String> getIdSchList(SchReleaseTaskDTO[] releaseSchs){
		List<String> result = new ArrayList<String>();
		if(!ArrayUtil.isEmpty(releaseSchs)){
			for (SchReleaseTaskDTO schReleaseTaskDTO : releaseSchs) {
				result.add(schReleaseTaskDTO.getId_sch());
			}
		}
		return result;
	}
	/**
	 * 获取所有符合规则的排班
	 * @author yzh
	 * @return
	 * @throws BizException
	 */
	private SchReleaseTaskDTO[] getAllReleaseSch(String[] sd_sctps) throws BizException{
		DAFacade dafacade = new DAFacade();
		String qrySql = this.getSchReleaseQrySql(sd_sctps);
		String today = ScAppUtils.getServerDate().toString();
		SqlParam param = new SqlParam();
		if(sd_sctps != null && sd_sctps.length > 0){
			for (String sd_sctp : sd_sctps) {
				param.addParam(sd_sctp);
			}
		}
		param.addParam(today);
		param.addParam(today);
		List<SchReleaseTaskDTO> result = (List<SchReleaseTaskDTO>) dafacade.execQuery(qrySql, param, new BeanListHandler(SchReleaseTaskDTO.class));
		if(!ListUtil.isEmpty(result)){
			return result.toArray(new SchReleaseTaskDTO[0]);
		}
		return null;
	}
	/**
	 * 获取查询符合规则排班的sql
	 * @author yzh
	 * @return
	 */
	private String getSchReleaseQrySql(String[] sd_sctps){
		StringBuffer qry = new StringBuffer();
		qry.append("select sch.id_sch,sch.fg_setentp,sch.fg_auto_release,sch.d_sch,sch.id_sctp,")
		.append("sch.t_b_acpt,sch.sd_tickmd,sch.quan_total_appt,sch.quan_total,rl.id_release_rule,dep.polno_maj ")
		.append("from sc_pl pl ")
		.append("inner join sc_sch sch on pl.id_scpl = sch.id_scpl ")
		.append("inner join sc_release_rule rl on pl.id_release_rule = rl.id_release_rule ")
		.append("left join sc_dep_param dep on pl.id_depparam = dep.id_deptparam ")
		.append("where pl.sd_sctp in (");
		if(sd_sctps != null && sd_sctps.length > 0){
			for (int i = 0; i < sd_sctps.length; i++) {
				if(i == sd_sctps.length -1){
					qry.append("?)");
				}else{
					qry.append("?,");
				}
			}
		}else{
			qry.append("'03','04')");
		}
		qry.append("and (to_date(sch.d_sch,'yyyy-MM-dd') - (rl.max_num_day+14)) <= to_date(?,'yyyy-MM-dd') ")
		.append("and to_date(sch.d_sch,'yyyy-MM-dd') >= to_date(?,'yyyy-MM-dd') ");
		
		return qry.toString();
	}
	/**
	 * 获取排班释放规则明细并分组
	 * @author yzh
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	private FMap getScReleaseRuleItmByCond(List<String> ids) throws BizException{
		String condition = ScSqlUtils.getInSqlByIds(ScReleaseRuleItmDO.ID_RELEASE_RULE, ids);
		ScReleaseRuleItmDO[] schReleaseItms  = new ScReleaseRuleTaskEP().getScReleaseRuleItmByCond(condition, ScReleaseRuleItmDO.ID_RELEASE_RULE);  
		if(!ArrayUtil.isEmpty(schReleaseItms)){
			FMap map = new FMap();
			for (ScReleaseRuleItmDO scReleaseRuleItmDO : schReleaseItms) {
				if(!map.containsKey(scReleaseRuleItmDO.getId_release_rule())){
					List<ScReleaseRuleItmDO> list = new ArrayList<ScReleaseRuleItmDO>();
					list.add(scReleaseRuleItmDO);
					map.put(scReleaseRuleItmDO.getId_release_rule(), list);
				}else{
					List<ScReleaseRuleItmDO> list = (List<ScReleaseRuleItmDO>) map.get(scReleaseRuleItmDO.getId_release_rule());
					list.add(scReleaseRuleItmDO);
				}
			}
			return map;
		}
		return null;
	}
	/**
	 * 根据排班获取排班对应号段
	 * @param idSchList
	 * @return
	 * @throws BizException
	 */
	private FMap getScSchTickByCond(List<String> idSchList) throws BizException{
		String condition = ScSqlUtils.getInSqlByIds(ScSchTickDO.ID_SCH, idSchList);
		ScSchTickDO[] sctick = new ScReleaseRuleTaskEP().getScSchTickByCond(condition, null);
		if(!ArrayUtil.isEmpty(sctick)){
			FMap map = new FMap();
			for (ScSchTickDO scSchTickDO : sctick) {
				if(!map.containsKey(scSchTickDO.getId_sch())){
					List<ScSchTickDO> list = new ArrayList<ScSchTickDO>();
					list.add(scSchTickDO);
					map.put(scSchTickDO.getId_sch(), list);
				}else{
					List<ScSchTickDO> list = (List<ScSchTickDO>) map.get(scSchTickDO.getId_sch());
					list.add(scSchTickDO);
				}
			}
			return map;
		}
		return null;
	}
	/**
	 * 根据排班id获取排班对应号位
	 * @param idSchList
	 * @return
	 * @throws BizException
	 */
	private FMap getScSchTicksByCond(List<String> idSchList) throws BizException{
		String condition = ScSqlUtils.getInSqlByIds(ScSchTicksDO.ID_SCH, idSchList);
		ScSchTicksDO[] scticks = new ScReleaseRuleTaskEP().getScSchTicksByCond(condition, null);
		if(!ArrayUtil.isEmpty(scticks)){
			FMap map = new FMap();
			for (ScSchTicksDO scSchTicksDO : scticks) {
				if(!map.containsKey(scSchTicksDO.getId_sch())){
					List<ScSchTicksDO> list = new ArrayList<ScSchTicksDO>();
					list.add(scSchTicksDO);
					map.put(scSchTicksDO.getId_sch(), list);
				}else{
					List<ScSchTicksDO> list = (List<ScSchTicksDO>) map.get(scSchTicksDO.getId_sch());
					list.add(scSchTicksDO);
				}
			}
			return map;
		}
		return null;
	}
	/**
	 * 判断一个数组是否包含另一个
	 * @param src
	 * @param target
	 * @return
	 */
	private boolean isHasArray(String[] src,String[] target){
		List<String> srcList = Arrays.asList(src);
		List<String> targetList = Arrays.asList(target);
		return srcList.containsAll(targetList);
//		Set<String> bSet = new HashSet(Arrays.asList(src));  // b 集合
//		int bSize = bSet.size();
//		bSet.addAll(Arrays.asList(target));  // a补充到b
//		return bSet.size() == bSize;
	}
	/**
	 * 判断排班是否在号源释放期间内
	 * @param t_b_acpt
	 * @param d_sch
	 * @param scReleaseRuleItmDO
	 * @return
	 * @throws BizException 
	 */
	private boolean checkDsch(FTime t_b_acpt,FDate d_sch,String id_sctp,ScReleaseRuleItmDO scReleaseRuleItmDO) throws BizException{
		FDateTime nowDateTime = ScAppUtils.getServerDateTime();
		WorkCalendDateDO[] workCaleDates = this.getWorkCalendDate(nowDateTime,id_sctp);
		FDate nowDate = ScAppUtils.getServerDate();
		FBoolean fg_holiday_excl = scReleaseRuleItmDO.getFg_holiday_excl();
		if (scReleaseRuleItmDO.getSd_release_period_tp().equals(FIX)) {
			FDateTime dt = new FDateTime();
			FDate d_sch_temp = d_sch;
			if (fg_holiday_excl.booleanValue()) {
				int num_day = scReleaseRuleItmDO.getNum_day();
				for (int i = 0; i <= num_day; i++) {
					if (i == 0) {
						d_sch_temp = this.filterHoliday(d_sch_temp, workCaleDates, false);
					} else {
						d_sch_temp = d_sch_temp.getDateBefore(1);
						d_sch_temp = this.filterHoliday(d_sch_temp, workCaleDates, false);
					}
				}
				dt = new FDateTime(d_sch_temp,
						new FTime(scReleaseRuleItmDO.getNum_hour() >= 10 ? scReleaseRuleItmDO.getNum_hour() + ":00:00"
								: "0" + scReleaseRuleItmDO.getNum_hour() + ":00:00"));
			}else{
				dt = new FDateTime(
						d_sch.getDateBefore(scReleaseRuleItmDO.getNum_day()),
						new FTime(scReleaseRuleItmDO.getNum_hour() >= 10
								? scReleaseRuleItmDO.getNum_hour() + ":00:00"
								: "0" + scReleaseRuleItmDO.getNum_hour() + ":00:00"));
			}
			if (dt.compareTo(nowDateTime) <= 0 && d_sch.compareTo(nowDate) >= 0) {
				return true;
			}
		}else if(scReleaseRuleItmDO.getSd_release_period_tp().equals(RELATIVE)){
			FDateTime dt = new FDateTime();
			if (fg_holiday_excl.booleanValue()) {
				FDate d_sch_temp = d_sch;
				int num_day = scReleaseRuleItmDO.getNum_day();
				int num_hour = scReleaseRuleItmDO.getNum_hour();
				for (int i = 0; i <= num_day; i++) {
					if (i == 0) {
						d_sch_temp = this.filterHoliday(d_sch_temp, workCaleDates, false);
					} else {
						d_sch_temp = d_sch_temp.getDateBefore(1);
						d_sch_temp = this.filterHoliday(d_sch_temp, workCaleDates, false);
					}
				}
				FDateTime dt_temp = new FDateTime(d_sch_temp,t_b_acpt);
				dt_temp = dt_temp.addSeconds(-1*num_hour);
				FTime t_b_acpt_temp = dt_temp.getUFTime();
				d_sch_temp =  this.filterHoliday(dt_temp.getBeginDate(), workCaleDates, false);
				dt = new FDateTime(d_sch_temp,t_b_acpt_temp);
			}else{
				FDateTime dt_temp = new FDateTime(d_sch,t_b_acpt);
				dt = dt_temp.getDateTimeBefore(scReleaseRuleItmDO.getNum_day()).addSeconds(-1*(scReleaseRuleItmDO.getNum_hour()*60*60));
			}
			if(dt.compareTo(nowDateTime)<=0 && d_sch.compareTo(nowDate)>=0){
				return true;
			}
		}
		return false;
	}
	/**
	 * 判断一个日期是否节假日 是的话顺延
	 * @param dt
	 * @param workCaleDates
	 * @return
	 */
	private FDate filterHoliday(FDate dt, WorkCalendDateDO[] workCaleDates,boolean isIncrease ) {
		if (!ArrayUtil.isEmpty(workCaleDates)) {
			FDate dt_point = dt.asBegin();
			if(isIncrease){
				for (int i = 0; i < workCaleDates.length; i++) {
					WorkCalendDateDO workCalendDateDO = workCaleDates[i];
					FDate workDate = workCalendDateDO.getCalendardate().asBegin();
					if (dt_point.compareTo(workDate) == 0) {
						if (workCalendDateDO.getDateworktype() == 0) {
							return workDate;
						} else {
							if (i + 1 < workCaleDates.length) {
								dt_point = workCaleDates[i + 1].getCalendardate().asBegin();
							} else {
								return workDate;
							}
						}
					}
				}
			}else{
				for (int i = workCaleDates.length-1; i >= 0; i--) {
					WorkCalendDateDO workCalendDateDO = workCaleDates[i];
					FDate workDate = workCalendDateDO.getCalendardate().asBegin();
					if (dt_point.compareTo(workDate) == 0) {
						if (workCalendDateDO.getDateworktype() == 0) {
							return workDate;
						} else {
							if (i - 1 >= 0) {
								dt_point = workCaleDates[i - 1].getCalendardate().asBegin();
							} else {
								return workDate;
							}
						}
					}
				}
			}
		}
		return dt;
	}
	/**
	 * 获取工作日历日期信息
	 * @param scaptrlsruledo
	 * @return
	 * @throws BizException 
	 * @author yzh
	 */
	private WorkCalendDateDO[] getWorkCalendDate(FDateTime dt,String id_sctp) throws BizException{
		ISchedulecaRService ischedulecarservice = ServiceFinder.find(ISchedulecaRService.class);
		ScheduleCADO[] sccas = ischedulecarservice.find("id_sctp='"+id_sctp+"'", null, FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(sccas)) {
			// 获取工作日历   
			IWorkCalendDateDORService iworkcalenddatedorservice = ServiceFinder.find(IWorkCalendDateDORService.class);
			String id_cal = sccas[0].getId_cal();
			String sql = this.getSql(dt, id_cal);
			WorkCalendDateDO[] workCaleDates = iworkcalenddatedorservice.find(sql, WorkCalendDateDO.CALENDARDATE, FBoolean.FALSE);
			return workCaleDates;
		}
		return null;
	}
	
	private String getSql(FDateTime dt,String id_cal){
		StringBuffer sql = new StringBuffer();
		sql.append("id_workcalendar='")
		.append(id_cal).append("'")
		.append(" and calendardate>='")
		.append(dt.getDateTimeBefore(30).getDate().toLocalString())
		.append("' and calendardate <='")
		.append(dt.getDateTimeAfter(30).getDate().toLocalString())
		.append("'");
		return sql.toString();
	}
}
