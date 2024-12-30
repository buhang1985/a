package iih.sc.apt.s.bp.oral;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.apt.dto.d.AptOralDTO;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.scapt.d.AptExChlDO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IAptexchlCudService;
import iih.sc.apt.scapt.i.IAptexchlRService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 口腔预约更换患者BP
 * 
 * @author zhengcm
 * @date 2017-05-19 13:52:11
 *
 */
public class ChangeOralAptPatBP {

	/**
	 * 口腔预约更换患者
	 *
	 * @param aptDTO 口腔预约DTO
	 * @param newPatId 新患者ID
	 * @return 更新后的口腔预约DTO
	 * @throws BizException
	 * @author zhengcm
	 */
	public AptOralDTO exec(AptOralDTO aptDTO, String newPatId) throws BizException {

		// 1、检查参数
		ScValidator.validateParam("aptDTO", aptDTO);
		ScValidator.validateParam("newPatId", newPatId);

		// 检查排班渠道（非本科渠道不允许修改）
		new CheckOralChlBP().check(aptDTO.getId_scchl());

		// 2、预约DO
		ScAptDO aptDO = new AptEP().getById(aptDTO.getId_apt());

		// 4、排班计划
		ScPlanDO planDO = new OralAptEP().getScPlan(aptDTO.getId_scpl());

		// 5、患者DO
		PatDO oldPatDO = this.getPatDOById(aptDTO.getId_pat());
		PatDO newPatDO = this.getPatDOById(newPatId);

		// 6、检查患者的实名认证情况
		this.checkPatRealname(oldPatDO, newPatDO);

		// 7、检查预约状态是否处于预约
		this.checkAptStatus(aptDO);

		// 8、预约规则校验
		this.validateRegRule(newPatId, aptDTO.getId_sch(), planDO.getId_scres(), planDO.getId_dep(), aptDTO.getD_sch(),
				planDO.getId_scsrv(), aptDTO.getId_dayslot());

		// 9、更换预约患者
		this.changeAptInfo(aptDO, newPatId);

		// 10、更换预约外部渠道的患者信息
		this.changeAptExChlInfo(aptDTO.getId_apt(), newPatDO.getCode());

		// 11、如果患者没有其他就诊记录和预约记录，调用PI接口把患者状态改为无效
		this.changePatStatus(aptDTO);

		// 12、更新返回数据
		this.setReturnData(aptDTO, newPatDO);

		// 13、设置当前患者是否有不良记录
		this.setPatBbr(aptDTO);

		return aptDTO;
	}

	/**
	 * 更换预约的患者
	 *
	 * @param aptDO
	 * @param id_pat
	 * @throws BizException
	 * @author zhengcm
	 */
	private void changeAptInfo(ScAptDO aptDO, String id_pat) throws BizException {
		if (null == aptDO || StringUtil.isEmptyWithTrim(id_pat)) {
			return;
		}
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO.setId_pat(id_pat);
		new AptEP().save(aptDO);
	}

	/**
	 * 更换预约外部渠道的患者
	 *
	 * @param id_apt
	 * @param code_pat
	 * @throws BizException
	 * @author zhengcm
	 */
	private void changeAptExChlInfo(String id_apt, String code_pat) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_apt) || StringUtil.isEmptyWithTrim(code_pat)) {
			return;
		}
		// 预约外部渠道查询服务
		IAptexchlRService qryService = ServiceFinder.find(IAptexchlRService.class);
		String cond = String.format("id_apt = '%s'", id_apt);
		AptExChlDO[] exChlDOs = qryService.find(cond, null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(exChlDOs)) {
			return;
		}
		for (AptExChlDO chlDO : exChlDOs) {
			chlDO.setStatus(DOStatus.UPDATED);
			chlDO.setCode_apt(code_pat);
		}
		// 预约外部渠道维护服务
		IAptexchlCudService cmdService = ServiceFinder.find(IAptexchlCudService.class);
		cmdService.update(exChlDOs);
	}

	/**
	 * 如果患者没有其他就诊记录和预约记录，调用PI接口把患者状态改为无效
	 *
	 * @param aptDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void changePatStatus(AptOralDTO aptDTO) throws BizException {
		// 查询该患者的其他预约记录
		String cond = String.format("id_pat = '%s'", aptDTO.getId_pat());
		ScAptDO[] aptDOs = new AptEP().getByWhere(cond);
		// 查询该患者的就诊记录
		IPativisitRService pvRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] entDOs = pvRService.find(cond, null, FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(aptDOs) || !ArrayUtil.isEmpty(entDOs)) {
			return;
		}
		// 调用PI接口把患者状态改为无效
		PatDO patDO = this.getPatDOById(aptDTO.getId_pat());
		if (patDO == null) {
			return;
		}
		patDO.setStatus(DOStatus.UPDATED);
		patDO.setFg_invd(FBoolean.TRUE);
		this.savePatInfo(patDO);
	}

	/**
	 * 检查当前预约患者和更换的新患者的实名认证情况
	 *
	 * @param oldDO
	 * @param newDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void checkPatRealname(PatDO oldDO, PatDO newDO) throws BizException {
		if (oldDO.getFg_realname().booleanValue()) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_ALREADY_REALNAME);
		}
		if (!newDO.getFg_realname().booleanValue()) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_NOT_REALNAME);
		}
	}

	/**
	 * 检查预约状态是否处于预约
	 *
	 * @param aptDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void checkAptStatus(ScAptDO aptDO) throws BizException {
		if (null == aptDO) {
			return;
		}
		if (!StringUtil.isEmptyWithTrim(aptDO.getSd_status())
				&& !aptDO.getSd_status().equals(IScDictCodeConst.SD_APTSTATUS_ORDER)) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_CANNOT_CHANGE_PAT);
		}
	}

	/**
	 * 根据主键获取患者DO
	 *
	 * @param id_pat
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private PatDO getPatDOById(String id_pat) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_pat)) {
			return null;
		}
		// 患者查询服务
		IPatiMDORService qryService = ServiceFinder.find(IPatiMDORService.class);
		return qryService.findById(id_pat);
	}

	/**
	 * 更新患者信息
	 *
	 * @param patDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void savePatInfo(PatDO patDO) throws BizException {
		if (null == patDO) {
			return;
		}
		// 患者维护服务
		IPatiMDOCudService cmdService = ServiceFinder.find(IPatiMDOCudService.class);
		cmdService.update(new PatDO[] { patDO });
	}

	/**
	 * 设置返回数据
	 *
	 * @param aptDTO
	 * @param newPatDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void setReturnData(AptOralDTO aptDTO, PatDO newPatDO) throws BizException {
		if (aptDTO == null || newPatDO == null) {
			return;
		}
		aptDTO.setId_pat(newPatDO.getId_pat());
		aptDTO.setName_pat(newPatDO.getName());
		aptDTO.setTel_pat(newPatDO.getMob());
		aptDTO.setFg_realname(newPatDO.getFg_realname());
	}

	/**
	 * 设置新患者的不良记录信息
	 *
	 * @param aptDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void setPatBbr(AptOralDTO aptDTO) throws BizException {
		if (null == aptDTO) {
			return;
		}
		List<AptOralDTO> list = new ArrayList<AptOralDTO>();
		list.add(aptDTO);
		new OralAptPatBbrProccessBP().exec(list);
	}

	/**
	 * 校验挂号规则
	 *
	 * @param id_pat
	 * @param id_sch
	 * @param id_scres
	 * @param id_dep
	 * @param d_sch
	 * @param id_scsrv
	 * @param id_dayslot
	 * @throws BizException
	 * @author zhengcm
	 */
	private void validateRegRule(String id_pat, String id_sch, String id_scres, String id_dep, FDate d_sch,
			String id_scsrv, String id_dayslot) throws BizException {
		RegRuleDTO regRule = new RegRuleDTO();
		regRule.setId_pat(id_pat);
		regRule.setId_sch(id_sch);
		regRule.setId_scres(id_scres);
		regRule.setId_dept(id_dep);
		regRule.setRegdate(d_sch.toStdString());
		regRule.setId_scsrv(id_scsrv);
		regRule.setId_dayslot(id_dayslot);
		IEnOutQryService enOutQryService = ServiceFinder.find(IEnOutQryService.class);
		ResultDTO resultDTO = enOutQryService.isPermitRegByMvel(regRule);
		if (FBoolean.FALSE.equals(resultDTO.getFlag())) {
			throw new BizException(resultDTO.getMsg());
		}
	}
}
