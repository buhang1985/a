package iih.sc.sch.s.ep;

import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.i.IScDeptParamDsDORService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.SchOcpResDO;
import iih.sc.sch.scsch.d.ScschAggDO;
import iih.sc.sch.scsch.i.IScSchChlDOCudService;
import iih.sc.sch.scsch.i.IScSchChlDORService;
import iih.sc.sch.scsch.i.ISchocpresCudService;
import iih.sc.sch.scsch.i.ISchocpresRService;
import iih.sc.sch.scsch.i.IScschCudService;
import iih.sc.sch.scsch.i.IScschMDOCudService;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.i.IScpltickRService;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekMDORService;
import iih.sc.scp.scplweek.i.IScplweekRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 口腔科排班EP
 * 
 * @author zhengcm
 * @date 2016-10-17 10:00:59
 *
 */
public class OralSchEP {

	/**
	 * 根据条件查询排班科室参数
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScDeptParamDsDO[] getScDeptParamDsByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmpty(cond)) {
			return null;
		}
		// 排班科室参数时段设置查询服务
		IScDeptParamDsDORService deptParamQryService = ServiceFinder
				.find(IScDeptParamDsDORService.class);
		return deptParamQryService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 根据条件查询排班
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchDO[] getSchByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		// 排班查询服务
		IScschMDORService schQryService = ServiceFinder.find(IScschMDORService.class);
		return schQryService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 根据条件删除排班
	 *
	 * @param cond
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deleteSchByCond(String cond) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return;
		}
		// 排班维护服务
		IScschMDOCudService schCmdService = ServiceFinder.find(IScschMDOCudService.class);
		ScSchDO[] schDOs = this.getSchByCond(cond, null);
		schCmdService.delete(schDOs);
	}

	/**
	 * 新增排班聚合DO
	 *
	 * @param schAggDOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScschAggDO[] insertSch(ScschAggDO[] schAggDOs) throws BizException {
		if (ArrayUtil.isEmpty(schAggDOs)) {
			return null;
		}
		// 排班维护服务
		IScschCudService cmdService = ServiceFinder.find(IScschCudService.class);
		return cmdService.insert(schAggDOs);
	}

	/**
	 * 更新排班
	 *
	 * @param schDOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchDO[] updateSch(ScSchDO[] schDOs) throws BizException {
		if (ArrayUtil.isEmpty(schDOs)) {
			return null;
		}
		// 排班维护服务
		IScschMDOCudService schCmdService = ServiceFinder.find(IScschMDOCudService.class);
		return schCmdService.update(schDOs);
	}

	/**
	 * 根据条件查询排班号位
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTickDO[] getSchTickByCond(String cond, String order, SqlParamDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		// 排班号位查询服务
		ISctickRService tickQryService = ServiceFinder.find(ISctickRService.class);
		if(param != null){
			return tickQryService.find2(cond, param, order, FBoolean.FALSE);
		}
		return tickQryService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 根据条件删除排班号位
	 *
	 * @param cond
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deleteSchTickByCond(String cond) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return;
		}
		// 排班号位维护服务
		ISctickCudService tickCmdService = ServiceFinder.find(ISctickCudService.class);
		ScSchTickDO[] schTickDOs = this.getSchTickByCond(cond, null, null);
		tickCmdService.delete(schTickDOs);
	}

	/**
	 * 新增排班号位
	 *
	 * @param tickDOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTickDO[] insertSchTick(ScSchTickDO[] tickDOs) throws BizException {
		if (ArrayUtil.isEmpty(tickDOs)) {
			return null;
		}
		// 排班号位维护服务
		ISctickCudService cmdService = ServiceFinder.find(ISctickCudService.class);
		return cmdService.insert(tickDOs);
	}

	/**
	 * 更新排班号位
	 *
	 * @param tickDOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchTickDO[] updateSchTick(ScSchTickDO[] tickDOs) throws BizException {
		if (ArrayUtil.isEmpty(tickDOs)) {
			return null;
		}
		// 排班号位维护服务
		ISctickCudService cmdService = ServiceFinder.find(ISctickCudService.class);
		return cmdService.update(tickDOs);
	}

	/**
	 * 根据条件查询排班渠道
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
		IScSchChlDORService chlQryService = ServiceFinder.find(IScSchChlDORService.class);
		return chlQryService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 根据条件删除排班渠道
	 *
	 * @param cond
	 * @throws BizException
	 * @author zhengcm
	 */
	public void deleteSchChlByCond(String cond) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return;
		}
		// 排班渠道维护服务
		IScSchChlDOCudService chlCmdService = ServiceFinder.find(IScSchChlDOCudService.class);
		ScSchChlDO[] schChlDOs = this.getSchChlByCond(cond, null);
		chlCmdService.delete(schChlDOs);
	}

	/**
	 * 保存排班渠道
	 *
	 * @param chlDOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScSchChlDO[] saveSchChl(ScSchChlDO[] chlDOs) throws BizException {
		if (ArrayUtil.isEmpty(chlDOs)) {
			return null;
		}
		// 排班渠道维护服务
		IScSchChlDOCudService cmdService = ServiceFinder.find(IScSchChlDOCudService.class);
		return cmdService.save(chlDOs);
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
	 * 根据条件查询排班周计划
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public ScPlanWeekDO[] getPlanWeekByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		// 排班周计划查询服务
		IScplweekMDORService qryService = ServiceFinder.find(IScplweekMDORService.class);
		return qryService.find(cond, order, FBoolean.FALSE);
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
	 * 根据条件查询排班资源占用
	 *
	 * @param cond
	 * @param order
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public SchOcpResDO[] getSchOcpResByCond(String cond, String order) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		ISchocpresRService qryService = ServiceFinder.find(ISchocpresRService.class);
		return qryService.find(cond, order, FBoolean.FALSE);
	}

	/**
	 * 保存排班资源占用
	 *
	 * @param ocpResDOs
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public SchOcpResDO[] saveSchOcpRes(SchOcpResDO[] ocpResDOs) throws BizException {
		if (ArrayUtil.isEmpty(ocpResDOs)) {
			return null;
		}
		ISchocpresCudService cmdService = ServiceFinder.find(ISchocpresCudService.class);
		return cmdService.save(ocpResDOs);
	}
}
