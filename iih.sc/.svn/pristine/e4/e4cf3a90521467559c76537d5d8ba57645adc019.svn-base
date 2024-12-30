package iih.sc.apt.s.ep;

import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.i.IMporInternalService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.i.IScaptapplCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDOCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.apt.scaptappl.i.IScaptapplRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医技预约EP
 * 
 * @author zhengcm
 * @date 2017-08-08 14:09:20
 *
 */
public class MtAptEP {

	/**
	 * 根据预约申请ID获取预约申请DO
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt_appl 预约申请ID
	 * @return 预约申请DO
	 * @throws BizException
	 */
	public ScAptApplDO getAptApplById(String id_apt_appl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_apt_appl)) {
			return null;
		}
		// 预约申请查询服务
		IScaptapplMDORService applQryService = ServiceFinder.find(IScaptapplMDORService.class);
		return applQryService.findById(id_apt_appl);
	}

	/**
	 * 根据条件查询预约申请
	 *
	 * @author zhengcm
	 * 
	 * @param cond 查询条件
	 * @return 预约申请DO数组
	 * @throws BizException
	 */
	public ScAptApplDO[] getAptApplByCond(String cond) throws BizException {
		if (StringUtil.isEmptyWithTrim(cond)) {
			return null;
		}
		// 预约申请查询服务
		IScaptapplMDORService applQryService = ServiceFinder.find(IScaptapplMDORService.class);
		return applQryService.find(cond, null, FBoolean.FALSE);
	}

	/**
	 * 保存预约申请
	 *
	 * @author zhengcm
	 * 
	 * @param aptApplDOs 预约申请DO数组
	 * @return 保存后的预约申请DO数组
	 * @throws BizException
	 */
	public ScAptApplDO[] saveAptAppl(ScAptApplDO[] aptApplDOs) throws BizException {
		if (ArrayUtil.isEmpty(aptApplDOs)) {
			return null;
		}
		// 预约申请维护服务
		IScaptapplMDOCudService applCmdService = ServiceFinder.find(IScaptapplMDOCudService.class);
		return applCmdService.save(aptApplDOs);
	}

	/**
	 * 根据就诊ID获取就诊DO
	 *
	 * @author zhengcm
	 * 
	 * @param id_ent 就诊ID
	 * @return 就诊DO
	 * @throws BizException
	 */
	public PatiVisitDO getEntById(String id_ent) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_ent)) {
			return null;
		}
		// 就诊对外查询服务
		IEnOutQryService enOutQryService = ServiceFinder.find(IEnOutQryService.class);
		return enOutQryService.getEnInfo(id_ent);
	}

	/**
	 * 根据就诊ID批量查询就诊DO
	 *
	 * @author zhengcm
	 * 
	 * @param ids_ent 就诊ID数组
	 * @return 就诊DO数组
	 * @throws BizException
	 */
	public PatiVisitDO[] getEntByIds(String[] ids_ent) throws BizException {
		if (ArrayUtil.isEmpty(ids_ent)) {
			return null;
		}
		// 就诊对外查询服务
		IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		return qryService.getEnInfoList(ids_ent);
	}

	/**
	 * 根据患者ID查询患者DO
	 *
	 * @author zhengcm
	 * 
	 * @param id_pat 患者ID
	 * @return 患者DO
	 * @throws BizException
	 */
	public PatDO getPatById(String id_pat) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_pat)) {
			return null;
		}
		IPatiMDORService qryService = ServiceFinder.find(IPatiMDORService.class);
		return qryService.findById(id_pat);
	}
	
}
