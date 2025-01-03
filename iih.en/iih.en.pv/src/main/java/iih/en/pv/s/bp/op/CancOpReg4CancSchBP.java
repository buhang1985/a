package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.i.IDayslotMDORService;
import iih.bd.res.dayslot.i.IDayslotQryService;
import iih.bl.cg.dto.en.opaccount.d.BlCgReplaceEntDTO;
import iih.bl.cg.i.IBlCgForEnService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.event.OpCancRegEvent;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.i.IScAptOutQryService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊排班停诊改约和替诊时退号BP
 * 
 * @author zhengcm
 * @date 2017-11-20 13:40:48
 *
 */
public class CancOpReg4CancSchBP {
	/**
	 * 门诊排班停诊改约和替诊时退号
	 * 
	 * @param oldAptId
	 * @param aptDTO
	 * @param regInfo
	 * @throws BizException
	 */
	public String exec(String oldAptId, OpAptDTO aptDTO, RegInfoDTO regInfo) throws BizException {
		// 1.可退号检验（Ent）
		PvEP pvEP = new PvEP();
		PatiVisitDO pvDO = pvEP.getPvById(aptDTO.getId_ent());
		this.validatePv(pvDO);

		// 2、可退号检验（EntOp）
		OpEP opEP = new OpEP();
		OutpatientDO opDO = opEP.getOpByEntId(aptDTO.getId_ent());
		this.validateOp(opDO);

		// 3.更新就诊数据和就诊队列信息
		new CancEntBP().cancEnt(pvDO.getId_ent());

		String id_ent = null;
		// 4.退费服务，只要支付了，就需要退费，包括挂号、预约
		if (!EnValidator.isEmpty(opDO.getId_cg())) {
			// 生成新的就诊数据
			id_ent = this.copyCreateEntInfo(oldAptId, pvDO, opDO, aptDTO, regInfo);
			// 调用费用接口：费用转移
			//TODO 调用新的费用转移接口传入新旧就诊id
			this.transferFee(aptDTO.getId_ent(), id_ent);
			//String id_cg = this.transferFee(opDO.getId_cg(), id_ent);
			// 更新就诊OP,已结算
			//this.updateEntOpCg(id_ent, id_cg);
		}

		// 5.释放号源
		this.revokeTick(oldAptId, this.getApt(oldAptId).getId_tick());

		// 6、如果是预约，需要将预约取消,预约生成就诊后，需要修改预约，否则还能取号
		this.cancApt(oldAptId);

		// 7、事件触发通知集成平台 ，正在测试，暂时吃了异常不影响挂号
		try {
			this.invokeOpCancelRegEvent(pvDO.getId_ent());
		} catch (Exception ex) {
			// xap.mw.runtime.msys.logging.
		}
		return id_ent;
	}

	/**
	 * 取消预约
	 * 
	 * @author zhengcm
	 * @date 2017-11-24 09:55:56
	 *
	 * @param id_apt
	 * @throws BizException
	 */
	private void cancApt(String id_apt) throws BizException {
		if (!EnValidator.isEmpty(id_apt)) {
			IScAptOutCmdService aptCmdService = ServiceFinder.find(IScAptOutCmdService.class);
			aptCmdService.setAptToCancle(id_apt);
		}
	}

	/**
	 * 释放号源
	 * 
	 * @author zhengcm
	 * @date 2017-11-24 09:52:51
	 *
	 * @param id_apt
	 * @param id_tick
	 * @throws BizException
	 */
	private void revokeTick(String id_apt, String id_tick) throws BizException {
		IScschMDORService service = ServiceFinder.find(IScschMDORService.class);
		ScSchDO scSchDO = service.findById(this.getApt(id_apt).getId_sch());
		if(scSchDO.getFg_transed().booleanValue()){
			throw new BizException("相关号位数据转移到sc_tickb表中，无法进行退号处理");
		}
		// 判断是否需要补号
		IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		String supplyTicketType = qryService.getSupplyTicketType(null, id_apt);
		// 退号
		IScSchOutCmdService schService = ServiceFinder.find(IScSchOutCmdService.class);
		schService.revokeTick(id_tick, supplyTicketType);
	}

	/**
	 * 费用转移
	 * @author yzh
	 * @date 2019年11月18日15:05:47
	 *
	 * @param id_ent_old 旧就诊id
	 * @param id_ent_new 新就诊ID
	 * @throws BizException
	 */
	private void transferFee(String id_ent_old, String id_ent_new) throws BizException {
		if (EnValidator.isEmpty(id_ent_old) || EnValidator.isEmpty(id_ent_new)) {
			return;
		}
		BlCgReplaceEntDTO blCgREntDTO = new BlCgReplaceEntDTO();
		blCgREntDTO.setId_ent_old(id_ent_old);
		blCgREntDTO.setId_ent_new(id_ent_new);
		IBlCgForEnService blCgForEnService = ServiceFinder.find(IBlCgForEnService.class);
		blCgForEnService.updateCgWhenReplaceEnt(blCgREntDTO);
	}

	/**
	 * 更新门诊就诊结算
	 * 
	 * @author zhengcm
	 * @date 2017-11-24 09:36:31
	 *
	 * @param id_ent
	 * @param id_cg
	 * @throws BizException
	 */
	private void updateEntOpCg(String id_ent, String id_cg) throws BizException {
		if (EnValidator.isEmpty(id_ent) || EnValidator.isEmpty(id_cg)) {
			return;
		}
		// 更新就诊
		IEnOutCmdService ent4AptService = ServiceFinder.find(IEnOutCmdService.class);
		// 已结算，更新OP
		ent4AptService.settleEnt(id_ent, id_cg, FBoolean.TRUE);
	}

	/**
	 * 复制保存新就诊数据
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 14:16:56
	 *
	 * @param oldAptId
	 * @param oldEntDO
	 * @param aptDTO
	 * @param regInfo
	 * @return
	 * @throws BizException
	 */
	private String copyCreateEntInfo(String oldAptId, PatiVisitDO oldEntDO, OutpatientDO oldEntOpDO, OpAptDTO aptDTO,
			RegInfoDTO regInfo) throws BizException {
		// 原预约
		ScAptDO oldAptDO = this.getApt(oldAptId);

		// 新预约
		ScAptDO newAptDO = this.getApt(aptDTO.getId_apt());

		// 1、保存ent
		PatiVisitDO newEntDO = this.copyCreateEnt(oldEntDO, newAptDO);

		// 2、保存op
		this.copyCreateEntOp(oldEntOpDO, newEntDO, aptDTO, oldAptDO, newAptDO);

		// 3、保存hp
		this.copyCreateEntHp(aptDTO.getId_ent(), newEntDO);

		// 4、保存entque,读取参数sc_op_aptNeedCfm，如果为FALSE,则插入队列
		this.createEntQue(newEntDO, regInfo);

		return newEntDO.getId_ent();
	}

	/**
	 * 复制新增就诊数据
	 * 
	 * @author zhengcm
	 * @date 2017-11-27 09:28:56
	 *
	 * @param oldEntDO 原始就诊DO
	 * @param newAptDO 新预约DO
	 * @return 新就诊DO
	 * @throws BizException
	 */
	private PatiVisitDO copyCreateEnt(PatiVisitDO oldEntDO, ScAptDO newAptDO) throws BizException {
		oldEntDO.setStatus(DOStatus.NEW);
		oldEntDO.setId_ent(null);
		oldEntDO.setCode(EnCodeUtils.createEntCode());
		if(newAptDO.getDt_b() != null){
			oldEntDO.setDt_entry(new FDateTime(newAptDO.getDt_b().getBeginDate().toString() + " 00:00:00"));
		}
		oldEntDO.setId_emp_entry(EnContextUtils.getPsnId());
		oldEntDO.setDt_insert(EnAppUtils.getServerDateTime()); // 插入时间
		PatiVisitDO newEntDO = new PvEP().savePv(oldEntDO);
		return newEntDO;
	}

	/**
	 * 复制新增门诊就诊DO
	 * 
	 * @author zhengcm
	 * @date 2017-11-27 09:29:36
	 *
	 * @param oldEntOpDO 原始就诊门诊DO
	 * @param newEntDO 新就诊DO
	 * @param aptDTO 预约DTO
	 * @param oldAptDO 原始预约DO
	 * @param newAptDO 新预约DO
	 * @throws BizException
	 */
	private void copyCreateEntOp(OutpatientDO oldEntOpDO, PatiVisitDO newEntDO, OpAptDTO aptDTO, ScAptDO oldAptDO,
			ScAptDO newAptDO) throws BizException {
		OpEP opEP = new OpEP();
		OutpatientDO newEntOpDO = oldEntOpDO;
		newEntOpDO.setStatus(DOStatus.NEW);
		newEntOpDO.setId_outpatient(null);
		newEntOpDO.setId_ent(newEntDO.getId_ent());
		newEntOpDO.setId_scsrv(oldAptDO.getId_scsrv());
		newEntOpDO.setId_schapt(aptDTO.getId_apt());
		newEntOpDO.setId_dateslot(newAptDO.getId_dateslot());
		newEntOpDO.setId_sch(aptDTO.getId_sch());
		newEntOpDO.setId_tick(aptDTO.getId_tick());
		newEntOpDO.setId_ticks(aptDTO.getId_ticks());
		newEntOpDO.setId_emp_operator(EnContextUtils.getPsnId());// 操作员;
		int hours = EnParamUtils.getOpValidHours(newEntDO.getId_dep_phy());
		//获取午别
		IDayslotMDORService serv = ServiceFinder.find(IDayslotMDORService.class);
		DaysLotDO daysLot = serv.findById(aptDTO.getId_dayslot());
		if(daysLot == null || daysLot.getTime_begin() == null || daysLot.getTime_end() == null)
			throw new BizException("日期分组配置错误！");
		FDateTime validDtBegin = this.getValidTimeBegin(aptDTO.getId_dayslot(), aptDTO.getDt_b().getDate());
		FDateTime validDtEndSch = EnAppUtils.getFDateTime(daysLot.getTime_begin().after(daysLot.getTime_end()) ? newEntDO.getDt_entry().getDate().getDateAfter(1) : newEntDO.getDt_entry().getDate(), daysLot.getTime_end());
		FDateTime endTime = new FDateTime();
		if(hours == 0){
			endTime = EnAppUtils.getFDateTime(validDtEndSch.getDate(), new FTime("23:59:59"));
		}else{
			endTime = validDtBegin.addSeconds(hours * 3600);
		}
		newEntOpDO.setDt_valid_b(validDtBegin);
		newEntOpDO.setDt_valid_e(endTime);
		opEP.save(newEntOpDO);
	}

	/**
	 * 复制新增就诊医保
	 * 
	 * @author zhengcm
	 * @date 2017-11-27 09:30:19
	 *
	 * @param oldEntId 原始就诊ID
	 * @param newEntDO 新就诊DO
	 * @throws BizException
	 */
	private void copyCreateEntHp(String oldEntId, PatiVisitDO newEntDO) throws BizException {
		EntHpEP entHpBP = new EntHpEP();
		EntHpDO[] entHpDOs = entHpBP.getEntHpList(oldEntId);
		if (!EnValidator.isEmpty(entHpDOs)) {
			List<EntHpDO> entHpDOList = new ArrayList<EntHpDO>();
			for (EntHpDO hpDO : entHpDOs) {
				hpDO.setStatus(DOStatus.NEW);
				hpDO.setId_enthp(null);
				hpDO.setId_ent(newEntDO.getId_ent());
				entHpDOList.add(hpDO);
			}
			entHpBP.save(entHpDOList.toArray(new EntHpDO[0]));
		}
	}

	/**
	 * 创建新就诊队列
	 * 
	 * @author zhengcm
	 * @date 2017-11-27 09:30:56
	 *
	 * @param newEntDO 新就诊DO
	 * @param regInfo
	 * @throws BizException
	 */
	private void createEntQue(PatiVisitDO newEntDO, RegInfoDTO regInfo) throws BizException {
		if (!EnParamUtils.getAptNeedCfm()) {
			JoinOpQueBP joinQueBP = new JoinOpQueBP();
			joinQueBP.exec(newEntDO, regInfo);
		}
	}

	/**
	 * 触发门诊退号事件
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void invokeOpCancelRegEvent(String entId) throws BizException {
		GetOpReg4EsBP getOpReg4EsBP = new GetOpReg4EsBP();
		OpReg4EsDTO reg4EsDTO = getOpReg4EsBP.createOpReg4EsDTO(entId);
		// 2、触发事件
		OpCancRegEvent opCancelregEvent = new OpCancRegEvent();
		opCancelregEvent.invoke(reg4EsDTO);
	}

	/**
	 * 验证
	 * 
	 * @param pvDO
	 * @throws BizException
	 */
	private void validatePv(PatiVisitDO pvDO) throws BizException {
		if (pvDO == null) {
			throw new BizException(IEnMsgConst.ERROR_OP_PVINFO_NOT_EXISTS);
		}
		if (pvDO.getFg_canc().equals(FBoolean.TRUE)) {
			throw new BizException(IEnMsgConst.ERROR_OP_REG_HAS_CANCED);
		}
	}

	/**
	 * 验证门诊信息
	 * 
	 * @param opDO
	 * @throws BizException
	 */
	private void validateOp(OutpatientDO opDO) throws BizException {
		if (opDO == null) {
			throw new BizException(IEnMsgConst.ERROR_OP_OPINFO_NOT_EXISTS);
		}
		// 非预约或挂号状态，不能退号
		if (!opDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_OP_ORDER)
				&& !opDO.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER)) {
			throw new BizException(IEnMsgConst.ERROR_OP_ACPT_CANNOT_CANC);
		}
	}

	/**
	 * 获取预约DO
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 15:56:53
	 *
	 * @param id_apt
	 * @return
	 * @throws BizException
	 */
	private ScAptDO getApt(String id_apt) throws BizException {
		if (EnValidator.isEmpty(id_apt)) {
			return null;
		}
		IScAptOutQryService qryService = ServiceFinder.find(IScAptOutQryService.class);
		return qryService.getAptById(id_apt);
	}

	/**
	 * 获取有效期开始时间，取午别的开始时间 如果是挂的10点号，8点也能接诊，有效期开始时间应该是午别开始时间
	 * 
	 * @param daslotId 日期分组ID
	 * @param regDate 挂号日期
	 * @return
	 * @throws BizException
	 */
	private FDateTime getValidTimeBegin(String daslotId, FDate regDate) throws BizException {
		// 1、获取午别的开始时间
		IDayslotQryService dayslotQryService = ServiceFinder.find(IDayslotQryService.class);
		FTime startTime = dayslotQryService.getDayslotStartTime(daslotId);
		if (startTime == null)
			throw new BizException(IEnMsgConst.ERROR_DAYSLOT_STARTTIME_NODEFINED);
		// 2、有效期开始时间取挂号日期+午别开始时间
		FDateTime validDtBegin = EnAppUtils.getFDateTime(regDate, startTime);
		return validDtBegin;
	}

}
