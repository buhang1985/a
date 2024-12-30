package iih.sc.scp.s.ep;

import iih.sc.comm.ScValidator;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanCudService;
import iih.sc.scp.scplan.i.IScplanRService;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scploptsrv.i.IScploptsrvCudService;
import iih.sc.scp.scploptsrv.i.IScploptsrvRService;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.i.IScpltickCudService;
import iih.sc.scp.scpltick.i.IScpltickRService;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScPlanWeekChlDOCudService;
import iih.sc.scp.scplweek.i.IScPlanWeekChlDORService;
import iih.sc.scp.scplweek.i.IScplweekCudService;
import iih.sc.scp.scplweek.i.IScplweekRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 口腔科排班计划EP
 * 
 * @author zhengcm
 * @date 2016-10-17 11:14:39
 *
 */
public class OralScplEP {

	/**
	 * 根据id查询排班计划
	 *
	 * @param id_scpl
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlanDO getPlanById(String id_scpl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scpl)) {
			return null;
		}
		// 排班计划查询服务
		IScplanRService qryService = ServiceFinder.find(IScplanRService.class);
		return qryService.findById(id_scpl);
	}

	/**
	 * 保存口腔科排班计划
	 *
	 * @param planDOs
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlanDO[] savePlan(ScPlanDO[] planDOs) throws BizException {
		if (ArrayUtil.isEmpty(planDOs)) {
			return null;
		}
		// 排班计划维护服务
		IScplanCudService cmdService = ServiceFinder.find(IScplanCudService.class);
		return cmdService.save(planDOs);
	}

	/**
	 * 删除排班
	 *
	 * @param planDOs
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deletePlan(ScPlanDO[] planDOs) throws BizException {
		if (ArrayUtil.isEmpty(planDOs)) {
			return;
		}
		// 排班计划维护服务
		IScplanCudService cmdService = ServiceFinder.find(IScplanCudService.class);
		cmdService.delete(planDOs);
	}

	/**
	 * 根据条件查询排班周计划聚合DO
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScplweekAggDO[] getPlanWeekAggByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		// 排班周计划查询服务
		IScplweekRService qryService = ServiceFinder.find(IScplweekRService.class);
		return qryService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 保存口腔科排班周计划
	 *
	 * @param planWeekAggDOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScplweekAggDO[] savePlanWeekAgg(ScplweekAggDO[] planWeekAggDOs) throws BizException {
		if (ArrayUtil.isEmpty(planWeekAggDOs)) {
			return null;
		}
		// 排班周计划维护服务
		IScplweekCudService cmdService = ServiceFinder.find(IScplweekCudService.class);
		return cmdService.save(planWeekAggDOs);
	}

	/**
	 * 根据条件查询排班周计划号位
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlanWeekTickDO[] getPlanWeekTickByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		// 排班周计划号位查询服务
		IScpltickRService qryService = ServiceFinder.find(IScpltickRService.class);
		return qryService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 保存口腔科排班周计划号位
	 *
	 * @param planWeekTickDOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlanWeekTickDO[] savePlanWeekTickDO(ScPlanWeekTickDO[] planWeekTickDOs)
			throws BizException {
		if (ArrayUtil.isEmpty(planWeekTickDOs)) {
			return null;
		}
		// 排班周计划号位维护服务
		IScpltickCudService cmdService = ServiceFinder.find(IScpltickCudService.class);
		return cmdService.save(planWeekTickDOs);
	}

	/**
	 * 根据条件删除排班周计划号位
	 *
	 * @param cond
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deletePlanWeekTickByCond(String cond) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return;
		}
		ScPlanWeekTickDO[] planWeekTickDOs = this.getPlanWeekTickByCond(cond, null);
		// 排班周计划维护服务
		IScpltickCudService cmdService = ServiceFinder.find(IScpltickCudService.class);
		cmdService.delete(planWeekTickDOs);
	}

	/**
	 * 删除排班周计划号位
	 *
	 * @param planWeekTickDOs 排班周计划号位DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deletePlanWeekTick(ScPlanWeekTickDO[] planWeekTickDOs) throws BizException {
		if (ArrayUtil.isEmpty(planWeekTickDOs)) {
			return;
		}
		// 排班周计划号位维护服务
		IScpltickCudService cmdService = ServiceFinder.find(IScpltickCudService.class);
		cmdService.delete(planWeekTickDOs);
	}

	/**
	 * 删除排班周计划聚合DO
	 *
	 * @param planWeekAggDOs 排班周计划AggDO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deletePlanWeekAgg(ScplweekAggDO[] planWeekAggDOs) throws BizException {
		if (ArrayUtil.isEmpty(planWeekAggDOs)) {
			return;
		}
		// 排班周计划维护服务
		IScplweekCudService cmdService = ServiceFinder.find(IScplweekCudService.class);
		cmdService.delete(planWeekAggDOs);
	}

	/**
	 * 根据条件查询排班计划备选服务
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlOptSrvDO[] getScplOptSrvByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		// 排班计划备选服务查询服务
		IScploptsrvRService qryService = ServiceFinder.find(IScploptsrvRService.class);
		return qryService.find(cond, order, FBoolean.FALSE);
	}
	/**
	 * 根据排班Id获取备选服务
	 * 
	 * @param plId
	 * @return
	 * @throws BizException 
	 */
	public ScPlOptSrvDO[] getScplOptSrvByPlId(String plId) throws BizException{
		if (StringUtil.isEmptyWithTrim(plId)) {
			return null;
		}
		// 排班计划备选服务查询服务
		IScploptsrvRService qryService = ServiceFinder.find(IScploptsrvRService.class);
		return qryService.findByAttrValString(ScPlOptSrvDO.ID_SCPL, plId);
	}
	/**
	 * 根据计划ID删除排班计划备选服务
	 * @param scplId
	 * @throws BizException
	 */
	public void deleteScplOptSrvByplId(String scplId) throws BizException{
		ScPlOptSrvDO[] plOptSrvs = this.getScplOptSrvByPlId(scplId);
		if(ScValidator.isNullOrEmpty(plOptSrvs))
			return;
		// 排班周计划备选服务维护服务
		IScploptsrvCudService cmdService = ServiceFinder.find(IScploptsrvCudService.class);
		cmdService.delete(plOptSrvs);
	}

	/**
	 * 根据条件删除排班计划备选服务
	 *
	 * @param cond
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deleteScplOptSrvByCond(String cond) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return;
		}
		ScPlOptSrvDO[] plOptSrvs = this.getScplOptSrvByCond(cond, null);
		// 排班周计划备选服务维护服务
		IScploptsrvCudService cmdService = ServiceFinder.find(IScploptsrvCudService.class);
		cmdService.delete(plOptSrvs);
	}

	/**
	 * 保存口腔科排班周计划备选服务
	 *
	 * @param planOptSrvDOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlOptSrvDO[] savePlanOptSrvDO(ScPlOptSrvDO[] planOptSrvDOs) throws BizException {
		if (ArrayUtil.isEmpty(planOptSrvDOs)) {
			return null;
		}
		// 排班周计划备选服务维护服务
		IScploptsrvCudService cmdService = ServiceFinder.find(IScploptsrvCudService.class);
		return cmdService.save(planOptSrvDOs);
	}

	/**
	 * 删除排班计划备选服务
	 *
	 * @param planOptSrvDOs 排班计划备选服务DO数组
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deletePlanOptSrv(ScPlOptSrvDO[] planOptSrvDOs) throws BizException {
		if (ArrayUtil.isEmpty(planOptSrvDOs)) {
			return;
		}
		// 排班计划备选服务维护服务
		IScploptsrvCudService cmdService = ServiceFinder.find(IScploptsrvCudService.class);
		cmdService.delete(planOptSrvDOs);
	}

	/**
	 * 根据条件删除排班周计划渠道
	 *
	 * @param cond
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deletePlanWeekChlByCond(String cond) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return;
		}
		// 排班周计划渠道查询服务
		IScPlanWeekChlDORService qryService = ServiceFinder.find(IScPlanWeekChlDORService.class);
		ScPlanWeekChlDO[] chlDOs = qryService.find(cond, null, FBoolean.FALSE);
		// 排班周计划渠道维护服务
		IScPlanWeekChlDOCudService cmdService = ServiceFinder
				.find(IScPlanWeekChlDOCudService.class);
		cmdService.delete(chlDOs);
	}
	/**
	 * 删除渠道
	 * @param Id_scplweeks
	 * @throws BizException
	 */
	public void deletePlanWeekChlByPlWeekId(String[] Id_scplweeks) throws BizException{
		if(ScValidator.isNullOrEmpty(Id_scplweeks))
			return;
		// 排班周计划渠道查询服务
		IScPlanWeekChlDORService qryService = ServiceFinder.find(IScPlanWeekChlDORService.class);
		ScPlanWeekChlDO[] chlDOs = qryService.findByAttrValStrings(ScPlanWeekChlDO.ID_SCPLWEEK, Id_scplweeks);
		// 排班周计划渠道维护服务
		IScPlanWeekChlDOCudService cmdService = ServiceFinder.find(IScPlanWeekChlDOCudService.class);
		cmdService.delete(chlDOs);
	}
}
