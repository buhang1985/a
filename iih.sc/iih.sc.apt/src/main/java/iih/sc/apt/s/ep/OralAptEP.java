package iih.sc.apt.s.ep;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.fc.entp.i.IEntpRService;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.pi.reg.pattag.d.PatTagDO;
import iih.pi.reg.pattag.i.IPattagCudService;
import iih.pi.reg.pattag.i.IPattagRService;
import iih.sc.apt.scapt.d.AptOpOralDO;
import iih.sc.apt.scapt.i.IAptoporalCudService;
import iih.sc.apt.scapt.i.IAptoporalRService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamRService;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvMDORService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScschAggDO;
import iih.sc.sch.scsch.i.IScSchChlDORService;
import iih.sc.sch.scsch.i.IScschMDOCudService;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.scsch.i.IScschRService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scploptsrv.i.IScploptsrvRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 口腔预约EP
 * 
 * @author zhengcm
 * @date 2016-09-30 16:54:26
 *
 */
public class OralAptEP {

	/**
	 * 根据条件查询口腔门诊预约
	 *
	 * @param where
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public AptOpOralDO[] findAptOpOralByWhere(String where) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		// 口腔科门诊预约查询服务
		IAptoporalRService qryService = ServiceFinder.find(IAptoporalRService.class);
		return qryService.find(where, null, FBoolean.FALSE);
	}

	/**
	 * 根据id查询口腔门诊预约
	 *
	 * @param id_aptoporal
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public AptOpOralDO findAptOpOralById(String id_aptoporal) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_aptoporal)) {
			return null;
		}
		// 口腔科门诊预约查询服务
		IAptoporalRService qryService = ServiceFinder.find(IAptoporalRService.class);
		return qryService.findById(id_aptoporal);
	}

	/**
	 * 保存口腔门诊预约
	 *
	 * @param oralAptDOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public AptOpOralDO[] saveAptOpOral(AptOpOralDO[] oralAptDOs) throws BizException {
		if (ArrayUtil.isEmpty(oralAptDOs)) {
			return null;
		}
		// 口腔门诊预约维护服务
		IAptoporalCudService cmdService = ServiceFinder.find(IAptoporalCudService.class);
		return cmdService.save(oralAptDOs);
	}

	/**
	 * 根据id获取排班
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchDO getSch(String id_sch) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_sch)) {
			return null;
		}
		// 排班查询服务
		IScschMDORService schQryService = ServiceFinder.find(IScschMDORService.class);
		return schQryService.findById(id_sch);
	}

	/**
	 * 根据条件查询排班
	 *
	 * @param where
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchDO[] getSchByWhere(String where) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		// 排班查询服务
		IScschMDORService schQryService = ServiceFinder.find(IScschMDORService.class);
		return schQryService.find(where, null, FBoolean.FALSE);
	}

	/**
	 * 保存排班
	 *
	 * @param schDO
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchDO saveSch(ScSchDO schDO) throws BizException {
		if (null == schDO) {
			return null;
		}
		// 排班维护服务
		IScschMDOCudService schCmdService = ServiceFinder.find(IScschMDOCudService.class);
		return schCmdService.save(new ScSchDO[] { schDO })[0];
	}

	/**
	 * 更新排班
	 * 
	 * @author zhengcm
	 * @date 2018-01-15 14:43:44
	 *
	 * @param schDOs
	 * @return
	 * @throws BizException
	 */
	public ScSchDO[] batchSaveSch(ScSchDO[] schDOs) throws BizException {
		if (ArrayUtil.isEmpty(schDOs)) {
			return null;
		}
		// 排班维护服务
		IScschMDOCudService schCmdService = ServiceFinder.find(IScschMDOCudService.class);
		return schCmdService.save(schDOs);
	}

	/**
	 * 获取排班计划
	 *
	 * @param id_scpl
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlanDO getScPlan(String id_scpl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scpl)) {
			return null;
		}
		// 排班计划查询服务
		IScplanRService qryService = ServiceFinder.find(IScplanRService.class);
		return qryService.findById(id_scpl);
	}
	/**
	 * 获取排班计划候选服务
	 * @param id_scpl
	 * @author yzh
	 * @return
	 */
	public ScPlOptSrvDO[] getScPlOptSrv(String id_scpl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scpl)) {
			return null;
		}
		IScploptsrvRService iscploptsrvrservice = ServiceFinder.find(IScploptsrvRService.class);
		return iscploptsrvrservice.find("id_scpl='"+id_scpl+"'", null, FBoolean.FALSE);
	}
	/**
	 * 根据条件查询排班计划
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlanDO[] getScPlanByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		// 排班计划查询服务
		IScplanRService qryService = ServiceFinder.find(IScplanRService.class);
		return qryService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 获取排班资源
	 *
	 * @param id_scres
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScheduleResDO getScRes(String id_scres) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scres)) {
			return null;
		}
		// 排班资源查询服务
		IScheduleresRService qryService = ServiceFinder.find(IScheduleresRService.class);
		return qryService.findById(id_scres);
	}

	/**
	 * 根据条件查询排班资源
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScheduleResDO[] getScResByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		// 排班资源查询服务
		IScheduleresRService qryService = ServiceFinder.find(IScheduleresRService.class);
		return qryService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 根据id查询排班服务
	 *
	 * @param id_scsrv
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScheduleSrvDO getScSrvById(String id_scsrv) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scsrv)) {
			return null;
		}
		ISchedulesrvMDORService schedulesrvMDORService = ServiceFinder.find(ISchedulesrvMDORService.class);
		return schedulesrvMDORService.findById(id_scsrv);
	}

	/**
	 * 根据条件获取排班号位
	 *
	 * @param where
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTickDO[] getSchTickByWhere(String whereStr,SqlParamDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(whereStr)) {
			return null;
		}
		// 排班号位查询服务
		ISctickRService schTickQryService = ServiceFinder.find(ISctickRService.class);
		return schTickQryService.find2(whereStr, param, ScSchTickDO.QUENO, FBoolean.FALSE);
	}
	/**
	 * 根据条件获取排班号位
	 *
	 * @param where
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTickDO[] getSchTickByWhereStr(String whereStr) throws BizException {
		if (StringUtil.isEmptyWithTrim(whereStr)) {
			return null;
		}
		// 排班号位查询服务
		ISctickRService schTickQryService = ServiceFinder.find(ISctickRService.class);
		return schTickQryService.find(whereStr, ScSchTickDO.QUENO, FBoolean.FALSE);
	}
	/**
	 * 根据条件获取排班号段
	 *
	 * @param where
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTicksDO[] getSchTicksByWhere(String where, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		// 排班号段查询服务
		IScticksRService schTicksQryService = ServiceFinder.find(IScticksRService.class);
		return schTicksQryService.find(where, order, FBoolean.FALSE);
	}

	/**
	 * 根据id获取排班号位
	 *
	 * @param id_tick
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTickDO getSchTickById(String id_tick) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_tick)) {
			return null;
		}
		// 排班号位查询服务
		ISctickRService schTickQryService = ServiceFinder.find(ISctickRService.class);
		return schTickQryService.findById(id_tick);
	}

	/**
	 * 更新排班号位
	 *
	 * @param tickDO 排班号位DO
	 * @return 更新后的排班DO
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTickDO saveSchTick(ScSchTickDO tickDO) throws BizException {
		if (null == tickDO) {
			return tickDO;
		}
		// 排班号位查询服务
		ISctickCudService cmdService = ServiceFinder.find(ISctickCudService.class);
		return cmdService.save(new ScSchTickDO[] { tickDO })[0];
	}

	/**
	 * 更新排班号位
	 * 
	 * @author zhengcm
	 * @date 2018-01-15 14:42:53
	 *
	 * @param tickDOs
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO[] batchSaveSchTick(ScSchTickDO[] tickDOs) throws BizException {
		if (ArrayUtil.isEmpty(tickDOs)) {
			return null;
		}
		// 排班号位查询服务
		ISctickCudService cmdService = ServiceFinder.find(ISctickCudService.class);
		return cmdService.save(tickDOs);
	}
	/**
	 * 根据条件获取排班渠道
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchChlDO[] getSchChlByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		// 排班渠道查询服务
		IScSchChlDORService schChlQryService = ServiceFinder.find(IScSchChlDORService.class);
		return schChlQryService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 根据条件获取排班渠道
	 *
	 * @param cond
	 * @param order
	 * @param code_scchl 渠道编码
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchChlDO[] getSchChlByCond(String cond, String order, String idEnttp,FBoolean fg_setentp,String code_scchl,ScSchDO schDO ) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		
		//诊间渠道需要过滤科室和人员号源池
		if(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM.equals(code_scchl))
		{
			cond += "and (ids_dep_spec is null or ids_dep_spec like '%"+ScContextUtils.getDeptId()+"%' )"
							+ " and (ids_emp_spec is null or ids_emp_spec like '%"+ScContextUtils.getPsnId()+"%' )";
		}
		
		// 排班渠道查询服务
		IScSchChlDORService schChlQryService = ServiceFinder.find(IScSchChlDORService.class);
		ScSchChlDO[] schChlDOs = schChlQryService.find(cond, order, FBoolean.FALSE);
		//第三放没有传就诊类型,不进行就诊类型过滤
		if(StringUtil.isEmpty(idEnttp))
		{
			return schChlDOs;
		}
		if(ArrayUtil.isEmpty(schChlDOs)){
			return null;
		}else{
			if(!fg_setentp.booleanValue()){
				return schChlDOs;
			}else{
				Boolean isCanUsed = false;//判断符合就诊类型的号源池可预约数是否大于0
				// 根据就诊类型过滤渠道号源池
				List<ScSchChlDO> result = new ArrayList<ScSchChlDO>();
				for (ScSchChlDO scSchChlDO : schChlDOs) {
					if(scSchChlDO.getId_entp().contains(idEnttp)){
						if(!isCanUsed)
						{
							//计算是否存在可用号位
							Integer apptCount = (Integer)schDO.getAttrVal("Quan"+scSchChlDO.getScpolcn()+"_appt") ;
							Integer usedCount = (Integer)schDO.getAttrVal("Quan"+scSchChlDO.getScpolcn()+"_used") ;
							isCanUsed = (apptCount - usedCount)>0;
						}
						result.add(scSchChlDO);
					}
				}
				if(ListUtil.isEmpty(result)){
					throw new BizException(IScMsgConst.SC_APT_NOT_FIND_ENTP_CHL);
				}
				if(!isCanUsed)
				{
					IEntpRService entpRService = ServiceFinder.find(IEntpRService.class);
					EnTypeDO enTypeDO = entpRService.findById(idEnttp);
					throw new BizException(enTypeDO.getName() + "类型号源不足！");
				}
				return (ScSchChlDO[])result.toArray(new ScSchChlDO[result.size()]);
			}
		}
	}

	public ScSchChlDO getSchChl(String id_sch, String id_scchl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_sch) || StringUtil.isEmptyWithTrim(id_scchl)) {
			return null;
		}
		String where = String.format("id_sch = '%s' and id_scchl = '%s'", id_sch, id_scchl);
		// 排班渠道查询服务
		IScSchChlDORService schChlQryService = ServiceFinder.find(IScSchChlDORService.class);
		ScSchChlDO[] chlDOs = schChlQryService.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(chlDOs)) {
			return null;
		}
		return chlDOs[0];
	}
	public ScSchChlDO[] getSchByChl(String id_sch, String id_scchl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_sch) || StringUtil.isEmptyWithTrim(id_scchl)) {
			return null;
		}
		String where = String.format("id_sch = '%s' and id_scchl = '%s'", id_sch, id_scchl);
		// 排班渠道查询服务
		IScSchChlDORService schChlQryService = ServiceFinder.find(IScSchChlDORService.class);
		ScSchChlDO[] chlDOs = schChlQryService.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(chlDOs)) {
			return null;
		}
		return chlDOs;
	}
	/**
	 * 根据id获取日期分组
	 *
	 * @param id_dayslot
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public DaysLotDO getDayslot(String id_dayslot) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_dayslot)) {
			return null;
		}
		// 日期分组查询服务
		IDayslotMDORService dayslotQryService = ServiceFinder.find(IDayslotMDORService.class);
		return dayslotQryService.findById(id_dayslot);
	}

	/**
	 * 根据条件获取患者标签
	 *
	 * @param where 查询条件
	 * @return 患者标签DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public PatTagDO[] getPatTagByWhere(String where) throws BizException {
		if (StringUtil.isEmptyWithTrim(where)) {
			return null;
		}
		// 患者标签查询服务
		IPattagRService qryService = ServiceFinder.find(IPattagRService.class);
		return qryService.find(where, null, FBoolean.FALSE);
	}

	/**
	 * 保存患者标签
	 *
	 * @param patTagDOs 患者标签DO数组
	 * @return 保存后的患者标签DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public PatTagDO[] savePatTag(PatTagDO[] patTagDOs) throws BizException {
		if (ArrayUtil.isEmpty(patTagDOs)) {
			return null;
		}
		// 患者标签维护服务
		IPattagCudService cmdService = ServiceFinder.find(IPattagCudService.class);
		return cmdService.save(patTagDOs);
	}

	/**
	 * 根据科室id查询科室参数聚合DO
	 *
	 * @param deptId
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScdeptparamAggDO getDeptParamAggByDeptId(String deptId, String sd_sctp) throws BizException {
		if (StringUtil.isEmptyWithTrim(deptId) || StringUtil.isEmptyWithTrim(sd_sctp)) {
			return null;
		}
		IScdeptparamRService qryService = ServiceFinder.find(IScdeptparamRService.class);
		String where = String.format("id_dep = '%s' and sd_sctp = '%s'", deptId, sd_sctp);
		ScdeptparamAggDO[] aggDOs = qryService.find(where, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(aggDOs)) {
			return null;
		}
		return aggDOs[0];
	}

	/**
	 * 根据查询条件查询排班
	 *
	 * @param cond
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScschAggDO[] getSchAggDOs(String cond) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		IScschRService qryService = ServiceFinder.find(IScschRService.class);
		return qryService.find(cond, null, FBoolean.FALSE);
	}

	/**
	 * 计算排班对应渠道的号源剩余数量
	 *
	 * @param aggDO
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public int calSchQuanCanUse(ScschAggDO aggDO, String id_scchl) throws BizException {
		int canUse = 0;
		if (null == aggDO || StringUtil.isEmptyWithTrim(id_scchl)) {
			return canUse;
		}
		ScSchDO schDO = aggDO.getParentDO();
		ScSchChlDO[] chlDOs = (ScSchChlDO[]) aggDO.getChildren(ScSchChlDO.class);
		if (ArrayUtil.isEmpty(chlDOs)) {
			return canUse;
		}
		for (ScSchChlDO chlDO : chlDOs) {
			if (!StringUtil.isEmptyWithTrim(chlDO.getId_scchl()) && chlDO.getId_scchl().equals(id_scchl)) {
				int quanNo = chlDO.getScpolcn();
				int quan_appt = (Integer) schDO.getAttrVal("Quan" + quanNo + "_appt");
				int quan_used = (Integer) schDO.getAttrVal("Quan" + quanNo + "_used");
				canUse = quan_appt - quan_used;
				break;
			}
		}
		return canUse;
	}

}
