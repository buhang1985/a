package iih.sc.sch.s.bp.op;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.i.IEnOutQryService;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.i.IScAptOutQryService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.dto.d.SchCancDTO;
import iih.sc.sch.s.ep.SchChlEP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.SchPlEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.scp.scplan.d.ScPlanDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊排班改约BP
 * 
 * @author zhengcm
 * @date 2017-11-17 16:13:57
 *
 */
public class OpSchChangeAptBP {

	/**
	 * 门诊排班改约
	 * 
	 * @author zhengcm
	 * @date 2017-11-17 16:15:11
	 *
	 * @param datas
	 * @param id_sch
	 * @throws BizException
	 */
	public void exec(SchCancDTO[] datas, String id_sch) throws BizException {
		// 校验参数
		ScValidator.validateParam("datas", datas);
		ScValidator.validateParam("id_sch", id_sch);

		// 检查是否有挂号数据
		this.checkIsHasRegDatas(datas);

		// 检查预约状态：不能对已经取号和取消的预约记录进行改约
		this.checkAptStatus(datas);

		// 目标排班
		ScSchDO schDO = new SchEP().getById(id_sch);
		if (null == schDO) {
			throw new BizException("没有找到目标排班！");
		}

		// 检查目标排班
		if (!schDO.getFg_active().booleanValue()) {
			throw new BizException("目标排班已停诊，不允许改约或替诊！");
		}

		// 目标排班计划
		ScPlanDO planDO = new SchPlEP().getScPl(schDO.getId_scpl());
		if (null == planDO) {
			throw new BizException("没有找到目标排班对应的排班计划！");
		}

		// 目标排班的排班渠道
		ScSchChlDO[] chlDOs = new SchChlEP().getSchChlBySchId(id_sch);
		if (ArrayUtil.isEmpty(chlDOs)) {
			throw new BizException("没有找到目标排班的任何排班渠道！");
		}

		// 校验目标排班午别是否过时
		this.validateSchDayslot(planDO, schDO);

		// 执行改约
		for (SchCancDTO data : datas) {
			// 检查是否已缴费的持卡社保
			this.checkIsHpCardst(data);

			// 检查目标排班是否有对应的渠道并获取号源池号
			int plocn = this.getSchChlPolcn(data, chlDOs);

			// 检查目标排班对应的号源池是否有对应的号源
			this.checkSchPlocn(schDO, plocn);

			// 检查当前预约是否已缴费且与目标排班的排班服务不一致
			this.checkPaymentApt(data, planDO);

			// 保存新预约
			ScAptDO newAptDO = this.saveOpApt(data, schDO, planDO, plocn);

			// 原预约退约
			this.cancOpApt(data, schDO, newAptDO);

			// 更新新预约到原预约
			this.rewriteAptCancto(data.getId_apt(), newAptDO.getId_apt());
		}

	}

	/**
	 * 检查是否有挂号数据
	 * 
	 * @author zhengcm
	 * @date 2017-12-01 15:37:37
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void checkIsHasRegDatas(SchCancDTO[] datas) throws BizException {
		if (ArrayUtil.isEmpty(datas)) {
			return;
		}
		for (SchCancDTO data : datas) {
			if (StringUtil.isEmptyWithTrim(data.getSd_status())) {
				throw new BizException("存在挂号数据，不允许改约或替诊！请检查！");
			}
		}
	}

	/**
	 * 检查预约状态：不能对已经取号和取消的预约记录进行改约
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 09:04:21
	 *
	 * @param datas
	 * @throws BizException
	 */
	private void checkAptStatus(SchCancDTO[] datas) throws BizException {
		List<String> ids = new ArrayList<String>();
		for (SchCancDTO data : datas) {
			String aptId = data.getId_apt();
			if (!StringUtil.isEmptyWithTrim(aptId) && !ids.contains(aptId)) {
				ids.add(aptId);
			}
		}
		IScAptOutQryService aptOutQryService = ServiceFinder.find(IScAptOutQryService.class);
		ScAptDO[] aptDOs = aptOutQryService.getAptByIds(ids);
		if (ArrayUtil.isEmpty(aptDOs)) {
			return;
		}
		for (ScAptDO aptDO : aptDOs) {
			if (aptDO.getSd_status().equals(IScDictCodeConst.SD_APTSTATUS_FINISH)) {
				throw new BizException("存在已取号的预约，不允许改约或替诊！请检查！");
			}
			if (aptDO.getSd_status().equals(IScDictCodeConst.SD_APTSTATUS_CANCEL)) {
				throw new BizException("存在已取消的预约，不允许改约或替诊！请检查！");
			}
		}
	}

	/**
	 * 校验就诊是否持卡社保
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 09:42:25
	 *
	 * @param dto
	 * @throws BizException
	 */
	private void checkIsHpCardst(SchCancDTO dto) throws BizException {
		if (null == dto) {
			return;
		}
		ScAptDO aptDO = this.getAptById(dto.getId_apt());
		if (null != aptDO.getFg_payment() && aptDO.getFg_payment().booleanValue()) {
			IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
			FBoolean isHpCardst = qryService.isHpCardst(dto.getId_ent());
			if (isHpCardst.booleanValue()) {
				throw new BizException("存在就诊医保为持卡社保的已缴费预约，不允许改约或替诊！");
			}
		}
	}

	/**
	 * 检查目标排班指定渠道并获取号源池号
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 10:51:04
	 *
	 * @param data
	 * @param chlDOs
	 * @return
	 * @throws BizException
	 */
	private int getSchChlPolcn(SchCancDTO data, ScSchChlDO[] chlDOs) throws BizException {
		int plocn = 0;
		boolean hasTheChl = false;
		for (ScSchChlDO chlDO : chlDOs) {
			if (chlDO.getId_scchl().equals(data.getId_scchl())) {
				hasTheChl = true;
				// 对应渠道关闭时取0号源池
				if (chlDO.getFg_active() != null && chlDO.getFg_active().booleanValue()) {
					plocn = chlDO.getScpolcn();
				}
			}
		}
		if (!hasTheChl) {
			IScBdOutQryService qryService = ServiceFinder.find(IScBdOutQryService.class);
			SchedulechlDO chlDO = qryService.getChlById(data.getId_scchl());
			throw new BizException("目标排班没有" + chlDO.getName() + "渠道！");
		}
		return plocn;
	}

	/**
	 * 检查排班的号源池号源
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 11:17:17
	 *
	 * @param schDO
	 * @param plocn
	 * @throws BizException
	 */
	private void checkSchPlocn(ScSchDO schDO, int plocn) throws BizException {
		int quanX_appt = (Integer) schDO.getAttrVal("Quan" + plocn + "_appt");
		int quanX_used = (Integer) schDO.getAttrVal("Quan" + plocn + "_used");
		if (quanX_used >= quanX_appt) {
			throw new BizException("目标排班的号源池" + plocn + "无号源！");
		}
	}

	/**
	 * 检查对于已收费的预约改约时需要相同的排班服务
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 11:25:18
	 *
	 * @param data
	 * @param schDO
	 * @throws BizException
	 */
	private void checkPaymentApt(SchCancDTO data, ScPlanDO planDO) throws BizException {
		IScAptOutQryService aptOutQryService = ServiceFinder.find(IScAptOutQryService.class);
		ScAptDO aptDO = aptOutQryService.getAptById(data.getId_apt());
		if (null != aptDO && aptDO.getFg_payment().booleanValue() && !aptDO.getId_scsrv().equals(planDO.getId_scsrv())) {
			throw new BizException("不可以对已缴费的预约改约或替诊为不同号别！");
		}
	}

	/**
	 * 根据预约ID获取预约DO
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 14:46:25
	 *
	 * @param id_apt
	 * @return
	 * @throws BizException
	 */
	private ScAptDO getAptById(String id_apt) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_apt)) {
			return null;
		}
		IScAptOutQryService aptOutQryService = ServiceFinder.find(IScAptOutQryService.class);
		ScAptDO aptDO = aptOutQryService.getAptById(id_apt);
		return aptDO;
	}

	/**
	 * 保存预约
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 15:47:28
	 *
	 * @param aptDO
	 * @return
	 * @throws BizException
	 */
	private ScAptDO saveApt(ScAptDO aptDO) throws BizException {
		IScAptOutCmdService aptOutCmdService = ServiceFinder.find(IScAptOutCmdService.class);
		return aptOutCmdService.saveApt(aptDO);
	}

	/**
	 * 退约
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 11:47:27
	 *
	 * @param data
	 * @throws BizException
	 */
	private void cancOpApt(SchCancDTO data, ScSchDO schDO, ScAptDO aptDO) throws BizException {
		OpAptDTO aptDTO = new OpAptDTO();
		aptDTO.setId_apt(aptDO.getId_apt());
		aptDTO.setId_sch(schDO.getId_sch());
		aptDTO.setId_ent(data.getId_ent());
		aptDTO.setId_dayslot(schDO.getId_dayslot());
		aptDTO.setId_tick(aptDO.getId_tick());
		aptDTO.setId_ticks(aptDO.getId_ticks());
		aptDTO.setDt_b(aptDO.getDt_b());
		aptDTO.setDt_e(aptDO.getDt_e());
		IScAptOutCmdService cmdService = ServiceFinder.find(IScAptOutCmdService.class);
		cmdService.cancOpApt4CancSch(data.getId_apt(), aptDTO, IScDictCodeConst.SC_CHANGE_APT_OPERATE);
	}

	/**
	 * 门诊预约
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 15:01:36
	 *
	 * @param data
	 * @param schDO
	 * @param planDO
	 * @param plocn
	 * @return
	 * @throws BizException
	 */
	private ScAptDO saveOpApt(SchCancDTO data, ScSchDO schDO, ScPlanDO planDO, int plocn) throws BizException {
		// 原预约
		ScAptDO aptDO = this.getAptById(data.getId_apt());
		// 临时取消原预约（避免改约同日期同一号源时的校验）
		String id_status = aptDO.getId_status();
		String sd_status = aptDO.getSd_status();
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO.setFg_canc(FBoolean.TRUE);
		aptDO.setId_status(IScDictCodeConst.ID_APTSTATUS_CANCEL);
		aptDO.setSd_status(IScDictCodeConst.SD_APTSTATUS_CANCEL);
		aptDO = this.saveApt(aptDO);

		// 保存新预约
		MtResDTO resDTO = new MtResDTO();
		resDTO.setId_sch(schDO.getId_sch());
		resDTO.setId_scchl(data.getId_scchl());
		resDTO.setId_scpl(planDO.getId_scpl());
		resDTO.setId_res(planDO.getId_scres());
		resDTO.setId_scsrv(planDO.getId_scsrv());
		resDTO.setD_sch(schDO.getD_sch());
		resDTO.setId_dayslot(schDO.getId_dayslot());
		//resDTO.setId_scsrv(aptDO.getId_scsrv());
		resDTO.setScpolcn(plocn);
		resDTO.setId_dep(planDO.getId_dep());
		IScAptOutCmdService aptService = ServiceFinder.find(IScAptOutCmdService.class);
		resDTO = aptService.saveOpApt(resDTO, aptDO.getId_pat(),IScDictCodeConst.SC_CHANGE_APT_OPERATE);

		// 还原原预约状态
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO.setFg_canc(FBoolean.FALSE);
		aptDO.setId_status(id_status);
		aptDO.setSd_status(sd_status);
		aptDO = this.saveApt(aptDO);

		// 更新新预约
		ScAptDO newAptDO = this.getAptById(resDTO.getId_apt());
		newAptDO.setStatus(DOStatus.UPDATED);
		//newAptDO.setId_scsrv(aptDO.getId_scsrv());//应该获取新服务  不应该使用旧服务   所以注释掉
		newAptDO.setId_status(aptDO.getId_status());
		newAptDO.setSd_status(aptDO.getSd_status());
		newAptDO.setFg_payment(aptDO.getFg_payment());
		newAptDO.setFg_bill(aptDO.getFg_bill());
		this.saveApt(newAptDO);

		return newAptDO;
	}

	/**
	 * 回写改约ID
	 * 
	 * @author zhengcm
	 * @date 2017-11-28 11:41:14
	 *
	 * @param oldAptId
	 * @param newAptId
	 * @throws BizException
	 */
	private void rewriteAptCancto(String oldAptId, String newAptId) throws BizException {
		ScAptDO aptDO = this.getAptById(oldAptId);
		aptDO.setStatus(DOStatus.UPDATED);
		aptDO.setId_scapt_cancto(newAptId);
		this.saveApt(aptDO);
	}

	/**
	 * 校验当前排班午别是否过时
	 * 
	 * @author zhengcm
	 * @date 2017-11-27 14:07:58
	 *
	 * @param planDO
	 * @param schDO
	 * @throws BizException
	 */
	private void validateSchDayslot(ScPlanDO planDO, ScSchDO schDO) throws BizException {
		// 当前科室可预约的午别(只校验当前日期的排班)
		List<String> dayslotIdList = new GetDeptCanAptDayslotBP().exec(planDO.getId_dep(), schDO.getD_sch());
		if (ListUtil.isEmpty(dayslotIdList)) {
			return;
		}
		if (!dayslotIdList.contains(schDO.getId_dayslot())) {
			throw new BizException("当前排班午别已过时，不可改约或替诊！");
		}
	}

}
