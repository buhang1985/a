package iih.en.pv.s.bp.op;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.fc.queben.d.QueBenDO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceDetailsDTO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BdQueBenEP;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.OpRegEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCollectionUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.i.IEnErCmdService;
import iih.en.pv.dto.d.OpReg4EsDTO;
import iih.en.pv.dto.d.ResultDTO;
import iih.en.pv.i.IEnOpQryService;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.OpRegPiContDTO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.en.pv.outpatient.i.IOutpatientCudService;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.op.st.AccountBP;
import iih.en.pv.s.bp.op.st.ManyPayPmSettleBP;
import iih.en.pv.s.bp.op.st.SettleBP;
import iih.en.pv.s.bp.op.st.SettleNewBP;
import iih.en.pv.s.event.OpRegEvent;
import iih.en.que.dto.d.OpQue4EsDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.sch.dto.d.LockResultDTO;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/**
 * 门急诊挂号BP
 * 
 * @author yank
 */
public class OpRegBP {
	/**
	 * 挂号 每个号单独结算
	 * 
	 * @param patDO 患者DO
	 * @param regInfo 挂号信息
	 * @param payInfoDTO 支付信息
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO exec(PatDO patDO, RegInfoDTO regInfo, PayInfoDTO payInfoDTO,FDateTime dt_b) throws BizException {
		FArrayList array = regInfo.getRegresarray();
		if (array == null || array.size() <= 0) {
			throw new BizException(IEnMsgConst.ERROR_OP_REG_REGINFO_IS_NULL);
		}
		//0.限制，同一患者不能同时进行多次挂号
		this.addPatLock(patDO);
		
		//1.验证挂号信息
		this.validateRegInfo(regInfo);
		
		//2.调用规则引擎
		this.validateRegRule(patDO, regInfo);
		
		//3.挂号信息赋值patId
		regInfo.setId_pat(patDO.getId_pat());
		regInfo.setPat_code(patDO.getCode());

		//校验是否已存在当前号源的挂号记录，如果有，修改为过期
		//查en_ent_op表的id_sch下的所有的dt_valid_e，如果时间大于当前时间，改为当前时间
		this.updateRegDate(regInfo.getId_sch());
		
		//4.保存ent
		PvEP pvEP = new PvEP();
		PatiVisitDO pvDO = pvEP.savePv(patDO, regInfo, payInfoDTO);
		regInfo.setId_ent(pvDO.getId_ent());// 赋值id_ent
		
		//5.保存hp
		new EntHpEP().saveEntHp(regInfo);
		
		//6.保存就诊联系人
		if(regInfo.getMore()!=null && regInfo.getMore().size()>0) {
			OpRegPiContDTO regPiCont = (OpRegPiContDTO) regInfo.getMore().get(0);
			EntContEP entContEP = new EntContEP();
			entContEP.saveEntCont(pvDO.getId_ent(), regPiCont);
		}
		
		//7.结算
		this.settle(patDO, regInfo, payInfoDTO);

		//8.占用号源
		this.occupyTick(regInfo);
		
		//9.创建op
		OpEP opEP = new OpEP();
		OutpatientDO opDO = null;
		if(EnValidator.isEmpty(dt_b)){
			 opDO = opEP.createOpDO(regInfo);
		}else {
			 opDO = opEP.createOutpatientDO(regInfo, dt_b);
		}
		
		opDO.setCode_amr_oep(patDO.getCode_amr_oep());// 住院档案号
		FBoolean isSettled = FBoolean.TRUE.equals(payInfoDTO.getFg_acc()) ? FBoolean.FALSE : FBoolean.TRUE;
		opDO.setFg_cg(isSettled);// 已结算标识
		opDO.setStatus(DOStatus.NEW);
		opEP.save(opDO);

		//10.保存entque
		JoinOpQueBP joinQueBP = new JoinOpQueBP();
		joinQueBP.exec(pvDO, regInfo);
		
		//11.保存en_ent_op_reg
		new OpRegEP().saveOpReg(regInfo);
		
		//12.急诊挂号处理
		this.handleErRegist(regInfo);
		
		//12.事件触发通知集成平台 ，正在测试，暂时吃了异常不影响挂号
		this.invokeOpRegEvent(pvDO.getId_ent());
		
		//13.记录就诊事件EN_ENT_EVT
		new EnEvtHandle().insertOpRegistEvt(pvDO.getId_ent(), regInfo);
		
		//发送签到事件
		this.SendOpSignEvent(pvDO.getId_ent());		
		return regInfo;		
	}
	/**
	 * 验证挂号信息
	 * 
	 * 暂时不加限制，是否已经挂过相同的号，允许用户可以重复挂一个号。暂时只是前端控制
	 * @param regInfo
	 * @throws BizException
	 */
	private void validateRegInfo(RegInfoDTO regInfo) throws BizException{
		if(!EuRegTp.CONSULTINGROOM.equals(regInfo.getEu_regtp()) 
				&& !EuRegTp.FREENOSCH.equals(regInfo.getEu_regtp())
				&& !EuRegTp.NOREGTRIAGE.equals(regInfo.getEu_regtp())){
			//2、是否已过停止挂号时间
			IScSchOutQryService schQryService = ServiceFinder.find(IScSchOutQryService.class);
			if(FBoolean.TRUE.equals(schQryService.isAfterEndRegTime(regInfo.getId_sch()))){
				throw new BizException(IEnMsgConst.ERROR_OP_REG_AFTER_END_REGTIME);
			}
		}
	}
	/**
	 * 占用号源
	 * 
	 * @param regInfo 挂号信息
	 * @throws BizException
	 */
	private void occupyTick(RegInfoDTO regInfo) throws BizException {
		RegResDTO regRes = (RegResDTO) regInfo.getRegresarray().get(0);
		//免挂号费非排班挂号
		if(EuRegTp.FREENOSCH.equals(regInfo.getEu_regtp())){
			regInfo.setTickno(0);
			return;
		}
		//未挂号分诊
		//未挂号分诊时
		if(EnValidator.isEmpty(regInfo.getId_sch())){
			//无排班
			Integer maxTickNo = this.getMaxTicketNo(regRes.getId_que(), regRes.getId_dayslot(), regRes.getD_sch());
			maxTickNo++;
			regInfo.setTickno(maxTickNo);
			return;
		}
		ScSchTickDO tickDO = null;
		IScSchOutCmdService schService = ServiceFinder.find(IScSchOutCmdService.class);
		if(!EnValidator.isEmpty(regInfo.getId_schlock())){
			//使用号源
			IScSchOutCmdService service = ServiceFinder.find(IScSchOutCmdService.class);
			LockResultDTO result = service.useLockSchOp(regInfo.getId_schlock(),regInfo.getId_pat(), regInfo.getId_ent());
			tickDO = result.getSctick();
		}else{
			if (!EnValidator.isEmpty(regInfo.getId_tick())) {
				// 指定号位挂号
				tickDO = schService.occupyTick(regInfo.getId_tick(), regRes.getPolcn());
			} else {
				tickDO = schService.occupyTickBySch(regInfo.getId_sch(), regRes.getPolcn(), regInfo.getId_ticks(), regRes.getId_scchl());
			}
		}
		if (tickDO == null) {
			throw new BizException(IEnMsgConst.ERROR_OP_REG_NO_AVAILABLE_TICK);
		}
		regInfo.setId_tick(tickDO.getId_tick());// 号位
		regInfo.setId_ticks(tickDO.getId_ticks());// 号段
		regInfo.setTickno(tickDO.getQueno());// 票号
	}

	/**
	 * 结算
	 * 
	 * @param patDO
	 * @param regInfo
	 * @param payInfoDTO
	 * @return
	 * @throws BizException
	 */
	private void settle(PatDO patDO, RegInfoDTO regInfo, PayInfoDTO payInfoDTO) throws BizException {
		if(EuRegTp.NOREGTRIAGE.equals(regInfo.getEu_regtp()))
			return;
		String id_cg = null;
		//划价结算一体，新结算接口
		if(payInfoDTO.getPaypmitem() != null){
			id_cg = new ManyPayPmSettleBP().exec(patDO, regInfo, payInfoDTO);
			if(EnValidator.isEmpty(id_cg)){
				throw new BizException(IEnMsgConst.ERROR_OP_REG_SETTLE_FAILED_CGID_IS_NULL);
			}
			regInfo.setId_cg(id_cg);
			return;
		}
		if (FBoolean.TRUE.equals(payInfoDTO.getFg_newprice())) {
			// 新结算方式，前台医保划价
			SettleNewBP settleBP = new SettleNewBP();
			if (FBoolean.TRUE.equals(payInfoDTO.getFg_acc())) {
				throw new BizException(IEnMsgConst.ERROR_OP_REG_NEWPRICE_CANNOT_ACCOUNT);// 只记账，按旧的后台划价方式处理
			} else {
				BlIncItmVsTypeDTO[] incItms = settleBP.settle(patDO.getId_pat(), regInfo, payInfoDTO,
						EnContextUtils.getPsnId());
				if (!EnValidator.isEmpty(incItms)) {
					BlInvoiceDetailsDTO invDTO  = (BlInvoiceDetailsDTO)incItms[0].getBlInvoiceDetailsDTO().get(0);					
					id_cg = invDTO.getId_cgoep();
					FArrayList invoiceInfo = EnCollectionUtils.toFArrayList(incItms);
					regInfo.setInvoiceinfo(invoiceInfo);
				}
			}
		} else {
			// 旧结算方式，后台划价结算
			SettleBP settleBP = new SettleBP();
			if (FBoolean.TRUE.equals(payInfoDTO.getFg_acc())) {
				AccountBP accountBP = new AccountBP();
				id_cg = accountBP.exec(regInfo);// 只记账
			} else {
				String empId = EnContextUtils.getPsnId();// 操作员id
				BlIncItmVsTypeDTO[] incItms = settleBP.settle(patDO.getId_pat(), regInfo, payInfoDTO, empId);
				BlInvoiceDetailsDTO invDTO  = (BlInvoiceDetailsDTO)incItms[0].getBlInvoiceDetailsDTO().get(0);					
				id_cg = invDTO.getId_cgoep();
			}
		}
		if(EnValidator.isEmpty(id_cg)){
			throw new BizException(IEnMsgConst.ERROR_OP_REG_SETTLE_FAILED_CGID_IS_NULL);
		}
		regInfo.setId_cg(id_cg);;
	}
	
	/**
	 * 校验挂号规则
	 * @param aptDTO 预约DTO
	 * @param schDO 排班DO
	 * @param regResDTO 预约资源DTO
	 * @throws BizException
	 */
	private void validateRegRule(PatDO pat, RegInfoDTO regInfo) throws BizException{
		RegResDTO regRes = (RegResDTO) regInfo.getRegresarray().get(0);
		RegRuleDTO regRule = new RegRuleDTO();
		regRule.setId_pat(pat.getId_pat());
		regRule.setId_sch(regRes.getId_sch());
		regRule.setId_scres(regRes.getId_scres());
		regRule.setId_dept(regRes.getId_dep());
		regRule.setRegdate(regRes.getD_sch() == null ? null : regRes.getD_sch().toStdString());
		regRule.setId_scsrv(regRes.getId_scsrv());
		regRule.setId_dayslot(regRes.getId_dayslot());
		regRule.setId_patca(regInfo.getId_patca());
		if(EnValidator.isEmpty(regRule.getId_patca()))
			regRule.setId_patca(pat.getId_paticate());
		regRule.setDt_birth(pat.getDt_birth() == null ? null : pat.getDt_birth().toStdString());
		regRule.setId_hp(regInfo.getId_hp());
		regRule.setId_sex(pat.getId_sex());
		regRule.setId_que(regRes.getId_que());
		IEnOpQryService serv = ServiceFinder.find(IEnOpQryService.class);
		ResultDTO resultDTO = serv.isPermitRegByMvel(regRule);
		if(resultDTO != null && FBoolean.FALSE.equals(resultDTO.getFlag())){
			throw new BizException(resultDTO.getMsg());
		}		
	}
	/**
	 * 获取最大票号
	 * 
	 * @param queId
	 * @param dayslotId
	 * @param date
	 * @return
	 * @throws DAException 
	 */
	private Integer getMaxTicketNo(String queId, String dayslotId, FDate date) throws DAException{
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT MAX(OP.TICKETNO) FROM EN_ENT_OP OP ");
		builder.append("INNER JOIN EN_ENT_QUE  EQ ON OP.ID_ENT = EQ.ID_ENT ");
		builder.append("WHERE OP.ID_DATESLOT = ? ");
		builder.append("AND EQ.ID_QUE = ? ");
		builder.append("AND EQ.DT_REGIST = ? ");
		SqlParam param = new SqlParam();
		param.addParam(dayslotId);
		param.addParam(queId);
		param.addParam(date);
		Integer  ticketNo  = (Integer) new DAFacade().execQuery(builder.toString(),param, new ColumnHandler());
		return ticketNo == null ? 0 : ticketNo;
	}
	/**
	 * 触发门诊挂号事件
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void invokeOpRegEvent(String entId) throws BizException{
		GetOpReg4EsBP getOpReg4EsBP = new GetOpReg4EsBP();
		OpReg4EsDTO reg4EsDTO = getOpReg4EsBP.createOpReg4EsDTO(entId);
		//2、触发事件
		OpRegEvent opregEvent = new OpRegEvent();
		opregEvent.invoke(reg4EsDTO);
	}
	/**
	 * 校验是否已存在当前号源的挂号记录
	 * @param id_sch
	 * @throws BizException
	 */
	private void updateRegDate(String id_sch) throws BizException{
		if (EnValidator.isEmpty(id_sch)) {
			return;
		}
		IOutpatientCudService serCud = ServiceFinder.find(IOutpatientCudService.class);
		IOutpatientRService serR = ServiceFinder.find(IOutpatientRService.class);
		String whereStr = " id_sch = ' "+ id_sch +"' ";
		OutpatientDO[] outpatientDOs = serR.find(whereStr, "dt_valid_e", FBoolean.FALSE);
		if (EnValidator.isEmpty(outpatientDOs)) {
			return;
		}
		for (OutpatientDO outpatientDO : outpatientDOs) {
			if (outpatientDO.getDt_valid_e() != null && outpatientDO.getDt_valid_e().after(EnAppUtils.getServerDateTime())) {
				outpatientDO.setDt_valid_e(EnAppUtils.getServerDateTime());
			}
		}
		serCud.update(outpatientDOs);
	}
	
	/**
	 * 急诊挂号处理
	 * 
	 * @param regInfo
	 * @throws BizException
	 */
	private void handleErRegist(RegInfoDTO regInfo) throws BizException{
		IEnErCmdService serv = ServiceFinder.find(IEnErCmdService.class);
		serv.handleErRegist(regInfo);
	}
	/***
	 * @Description:发送患者签到事件
	 * @param eventSourceDTO
	 * @throws BizException
	 */
	private void SendOpSignEvent(String id_ent) throws BizException{
		QueBenDO queBenDO = new BdQueBenEP().getQueBenByEntId(id_ent);
		if(queBenDO != null && !EnValidator.isEmpty(queBenDO.getId_queben()) && EnParamUtils.isRegAutoSign(queBenDO.getId_queben())){
			OpQue4EsDTO opQue4EsDTO = new OpQue4EsDTO();
			opQue4EsDTO.setId_ent(id_ent);
			BusinessEvent opRegEvent = new BusinessEvent(IEnEventConst.EVENT_SOURCE_EN_OP_QUE, IEnEventConst.EVENT_EN_OP_SIGNIN,
					opQue4EsDTO);
			Logger.info("发送患者到诊事件: " + opQue4EsDTO);
			EventDispatcher.fireEvent(opRegEvent);
		}
	}
	/**
	 * 限制，同一患者不能同时进行多次挂号
	 * 
	 * @param patDo
	 * @throws BizException
	 */
	private void addPatLock(PatDO patDo) throws BizException {
		String key = "KEY_OP_REGIST_" + patDo.getId_pat();
		boolean isLock = PKLock.getInstance().addDynamicLock(key);
		if(!isLock)
			throw new BizException(String.format("患者[%s %s]正在进行挂号，请稍后重试！", patDo.getCode(), patDo.getName()));
	}
}
