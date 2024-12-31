package iih.en.que.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.pp.hp.d.HPDO;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.OpEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.PayPmItemDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.que.dto.d.ReceptionQueDTO;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.d.desc.PiPatHpDODesc;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatHpDORService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.EuRegSchTp;
import iih.sc.sch.reg.dto.d.PeriodResDTO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 挂号接诊
 * 
 * @author liubin
 */
public class RegAndAcptBP {
	
	/**
	 * 挂号接诊 
	 * 
	 * @param opRegPat
	 * 		患者信息
	 * @param queSite
	 * 		医生出诊站点
	 * @param regRes
	 * 		挂号资源
	 * @return
	 * @throws BizException
	 */
	public ReceptionQueDTO exec(OpRegPatDTO opRegPat, QueSiteDO queSite, RegResDTO regRes, String reason,PayPmItemDTO[] payPmItemDTOs) throws BizException {
		return exec( opRegPat,  queSite,  regRes,  reason, payPmItemDTOs,null);
	}
	
	/**
	 * 挂号接诊 包含开始时间
	 * 
	 * @param opRegPat
	 * 		患者信息
	 * @param queSite
	 * 		医生出诊站点
	 * @param regRes
	 * 		挂号资源
	 * @return
	 * @throws BizException
	 */
	public ReceptionQueDTO exec2(OpRegPatDTO opRegPat, QueSiteDO queSite, RegResDTO regRes, String reason,PayPmItemDTO[] payPmItemDTOs,FDateTime dt_b) throws BizException {
		return exec( opRegPat,  queSite,  regRes,  reason, payPmItemDTOs,dt_b);
	}
	
	/**
	 * 挂号接诊
	 * 
	 * @param opRegPat
	 * 		患者信息
	 * @param queSite
	 * 		医生出诊站点
	 * @param regRes
	 * 		挂号资源
	 * @return
	 * @throws BizException
	 */
	public ReceptionQueDTO exec(OpRegPatDTO opRegPat, QueSiteDO queSite, RegResDTO regRes, String reason,PayPmItemDTO[] payPmItemDTOs,FDateTime dt_b) throws BizException {
		this.volidate(opRegPat, queSite, regRes);
		
		FDateTime curTime = EnAppUtils.getServerDateTime();
		//1.构造挂号信息
		RegInfoDTO regInfo = this.getRegInfoDTO(opRegPat, regRes, curTime);
		//2.支付信息先记账
		PayInfoDTO payInfo = this.getPayInfoDTO(payPmItemDTOs);	
		//3.挂号
		regInfo = this.acptReg(opRegPat.getId_pat(), regInfo, payInfo,dt_b);	
		//4.挂号后将fg_cg置为true
		this.updateCgValue(regInfo);
		//5.得到接诊DTO
		ReceptionQueDTO receptionQue = this.getReceptionQueDTO(regInfo.getId_ent());
		//6.接诊
		this.recept(receptionQue.getId_ent(), queSite, regRes.getId_dayslot(), reason, regRes);
		return receptionQue;
	}
	/**
	 * 构造挂号信息
	 * 
	 * @param patId
	 * @param regRes
	 * @param curTime
	 * @return
	 * @throws BizException
	 */
	private RegInfoDTO getRegInfoDTO(OpRegPatDTO opRegPat, RegResDTO regRes, FDateTime curTime) throws BizException{
		//判断一天是否只收一次挂号费,当天挂号费记帐
		this.regResPro(opRegPat.getId_pat(), regRes);
		RegInfoDTO regInfo = new RegInfoDTO();
		IPatiMDORService patService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = patService.findById(opRegPat.getId_pat());
		regInfo.setRegisted_date(regRes.getD_sch());
		regInfo.setId_dayslot(regRes.getId_dayslot());		
		regInfo.setId_pat(opRegPat.getId_pat());
		regInfo.setName_pat(patDO.getName());
		regInfo.setId_patca(opRegPat.getId_patca());
		regInfo.setId_pripat(opRegPat.getId_pripat());
		if(EnValidator.isEmpty(regInfo.getId_patca()))
			regInfo.setId_patca(patDO.getId_paticate());
		if(EnValidator.isEmpty(regInfo.getId_pripat()))
			regInfo.setId_pripat(patDO.getId_patpritp());
		regInfo.setId_patcredtp(patDO.getId_patcrettp());
		if(!(EnParamUtils.getAcptPatca().equals(IEnConst.ENOP0017_PAT) &&  !EnParamUtils.isSaveHPAtAcpt())){
			this.setHpInfo(regInfo, opRegPat);
		}	
		regInfo.setIs_referral(FBoolean.FALSE);//续诊标识
		regInfo.setRegresarray(EnAppUtils.doArray2List(regRes));//绑定挂号资源
		regInfo.setSd_tickmd(regRes.getSd_tickmd());//票号模式
		regInfo.setId_sch(regRes.getId_sch());//排班id
		regInfo.setId_emp_entry(EnContextUtils.getPsnId());//操作员
		regInfo.setEu_regtp(EuRegTp.CONSULTINGROOM);//医生诊间挂号
		regInfo.setId_scsrv(regRes.getId_scsrv());
		if(EuRegSchTp.FREEREGSCH.equals(regRes.getEu_regrestp()))
			regInfo.setEu_regtp(EuRegTp.FREENOSCH);//免挂号费非排班挂号
		else if(EuRegSchTp.HISTORYSCH.equals(regRes.getEu_regrestp())){
			//使用历史排班挂号，先加号，再挂号
			ScSchTickDO tick = this.addTick(regRes);
			regInfo.setId_tick(tick.getId_tick());
			regInfo.setId_ticks(tick.getId_ticks());
		} else if(EuRegSchTp.NORMAL.equals(regRes.getEu_regrestp())){
			if(IScDictCodeConst.SD_TICKMD_TICKS.equals(regInfo.getSd_tickmd())){
				IScSchOutQryService ticksService = ServiceFinder.find(IScSchOutQryService.class);
					PeriodResDTO periodRes = ticksService.getRecentAvlTicks(regRes.getId_sch(), IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM_DEPT);
					regInfo.setPeriod(periodRes.getPeriod());
					regInfo.setId_ticks(periodRes.getId_ticks());//号段id	
			}
		}
		regInfo.setPricedinfo(regRes.getPricedinfo());
		return regInfo;
	}
	/**
	 * 支付信息先记账
	 * @return
	 * @throws BizException 
	 */
	private PayInfoDTO getPayInfoDTO(PayPmItemDTO[] payPmItemDTOs) throws BizException{
		PayInfoDTO payInfo = new PayInfoDTO();
		//payInfo.setPaystyle(IBdPripmCodeConst.CODE_PRI_PM_PAY);//预交金
		payInfo.setFg_acc(FBoolean.TRUE);//只记账
		payInfo.setFg_print(FBoolean.FALSE);
		payInfo.setSd_pttp(this.setPttp(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM_DEPT));
		if(payPmItemDTOs != null){
			payInfo.setPaypmitem(EnAppUtils.doArray2List(payPmItemDTOs));
		}
		return payInfo;
	}	
	/**
	 * 支付信息记账，结算标志fg_cg置为true,fanlq-2017-11-20
	 * @param entid 就诊id
	 * @throws BizException
	 */
	private void updateCgValue(RegInfoDTO regInfo) throws BizException{	
		 OpEP opEp = new OpEP();
		 opEp.updateOpFgCg(regInfo.getId_ent(), FBoolean.TRUE);
	}
	/**
	 * 挂号
	 * 
	 * @param patId
	 * @param regInfo
	 * @param payInfo
	 * @return
	 * @throws BizException
	 */
	private RegInfoDTO acptReg(String patId,RegInfoDTO regInfo, PayInfoDTO payInfo,FDateTime dt_b) throws BizException {
		IEnOutCmdService opRegService = ServiceFinder.find(IEnOutCmdService.class);
		RegInfoDTO[] regedInfos = opRegService.regOp2(patId, new RegInfoDTO[]{regInfo}, payInfo,dt_b);
		if(EnValidator.isEmpty(regedInfos)){
			throw new BizException(IEnMsgConst.ERROR_OP_REG_WRONG);
		}
		return regedInfos[0];
	}
	/**
	 * 
	 * @param entId
	 * @return
	 * @throws BizException 
	 */
	private ReceptionQueDTO getReceptionQueDTO(String entId) throws BizException{
		GetAcptEntBP bp = new GetAcptEntBP();
		List<ReceptionQueDTO> list = bp.getAcptEnt(entId);
		if(EnValidator.isEmpty(list)){
			throw new BizException(IEnMsgConst.ERROR_OP_REG_WRONG);
		}
		return list.get(0);
	}
	/**
	 * 接诊
	 * 
	 * @param entQueId
	 * @param queSite
	 * @param dayslotId
	 * @param reason
	 * @return
	 * @throws BizException
	 */
	private FBoolean recept(String entId, QueSiteDO queSite, String dayslotId, String reason,RegResDTO regRes) throws BizException{
		ReceiveBP bp = new ReceiveBP();
		return bp.exec(entId, queSite, dayslotId,regRes, reason);
	}
	/**
	 * 设置挂号医保计划
	 * 
	 * @param regInfo
	 * @param pat
	 * @throws BizException 
	 */
	private void setHpInfo(RegInfoDTO regInfo, OpRegPatDTO opRegPat) throws BizException{
		if(EnValidator.isEmpty(opRegPat.getId_patca()))
			return;
		//获取pi_pat_ca_hp
		IPatcatehpRService patcatehpRServ = ServiceFinder.find(IPatcatehpRService.class);
		PiPatCaHpDO[] piPatCaHps =  patcatehpRServ.findByAttrValString(PiPatCaHpDO.ID_PATCA, opRegPat.getId_patca());
		if(EnValidator.isEmpty(piPatCaHps))
			return;
		PiPatCaHpDO piPatCaHp = piPatCaHps[0];
		if(EnValidator.isEmpty(piPatCaHp.getId_hp()))
			return;
		IPiPatHpDORService piPatHpDORServ = ServiceFinder.find(IPiPatHpDORService.class);
		String whereStr = String.format("%s.id_pat = '%s' and %s.id_hp = '%s' and %s.fg_act = '%s'", 
				PiPatHpDODesc.TABLE_ALIAS_NAME, opRegPat.getId_pat(),
				PiPatHpDODesc.TABLE_ALIAS_NAME, piPatCaHp.getId_hp(),
				PiPatHpDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		PiPatHpDO[] piPatHps = piPatHpDORServ.find(whereStr, null, FBoolean.FALSE);
		if(EnValidator.isEmpty(piPatHps))
			throw new BizException(String.format("患者分类为%s，患者未注册正确的医保计划[%s]！", opRegPat.getName_patca(), piPatCaHp.getName_hp()));
		HPDO hpDO = this.getHpDO(piPatCaHp.getId_hp());
		if(hpDO == null)
			throw new BizException(String.format("患者分类为%s，查询医保计划[%s]信息失败！", opRegPat.getName_patca(), piPatCaHp.getName_hp()));
		if(FBoolean.TRUE.equals(hpDO.getFg_reqhpcode()) && EnValidator.isEmpty(piPatHps[0].getNo_hp()))
			throw new BizException(String.format("患者分类为%s，医保计划[%s]医保号不能为空，请到患者注册维护后重试！", opRegPat.getName_patca(), piPatCaHp.getName_hp()));
		regInfo.setFg_hp_card(piPatCaHp.getFg_hp_card());
		regInfo.setFg_settlebycard(piPatCaHp.getFg_hp_card());
		regInfo.setFg_hpsettle(piPatCaHp.getFg_fundpay());
		regInfo.setId_hp(piPatCaHp.getId_hp());
		regInfo.setNo_hp(piPatHps[0].getNo_hp());
		regInfo.setName_hp(piPatCaHp.getName_hp());
		regInfo.setId_hpkind(piPatCaHp.getId_hpkind());
		regInfo.setCode_hpkind(piPatCaHp.getCode_hpkind());
	}
	/**
	 * 获取医保计划
	 * 
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	private HPDO getHpDO(String hpId) throws BizException {
		if (EnValidator.isEmpty(hpId))
			return null;
		HPDO hpDO = (HPDO) new DAFacade()
				.findByPK(HPDO.class, hpId, new String[] { HPDO.ID_HP,
						HPDO.NAME, HPDO.FG_REQHPCODE });
		return hpDO;
	}
	/**
	 * 参数验证
	 * 
	 * @param opRegPat
	 * @param queSite
	 * @param regRes
	 * @throws BizException
	 */
	private void volidate(OpRegPatDTO opRegPat, QueSiteDO queSite, RegResDTO regRes) throws BizException{
		if(opRegPat == null || EnValidator.isEmpty(opRegPat.getId_pat()))
			throw new BizException("患者信息为空");
		EnValidator.validateParam("queSite", queSite);
		EnValidator.validateParam("regRes", regRes);
	}
	
	/**
	 * 无当日排班挂号接诊时加号
	 * 
	 * @param schId 排班ID
	 * @throws BizException
	 */
	private ScSchTickDO addTick(RegResDTO regRes) throws BizException {
		IScSchOutCmdService addTicketService = ServiceFinder.find(IScSchOutCmdService.class);
		ScSchTickDO[] scSchTickDOs = addTicketService.addTick(regRes.getId_sch(), 1, EuAddTickMod.WPB, regRes.getPolcn());
		if (EnValidator.isEmpty(scSchTickDOs)) {
			throw new BizException("无当日排班挂号接诊时加号失败！");
		}
		return scSchTickDOs[0];
	}
	/**
	 * 判断一天是否只收一次挂号费,当天挂号费记帐
	 * 
	 * @author liubin
	 * 
	 * @param patId
	 * @param regRes
	 * @throws BizException
	 */
	private void regResPro(String patId, RegResDTO regRes) throws BizException{
		//判断一天是否只收一次挂号费,当天挂号费记过帐
		if(EnParamUtils.IsUnregChagOne() 
				&& hasChargedRegisterCost(patId) && !EnParamUtils.isOpinregSt(regRes.getId_dep())){
			//免挂号费
			String scsrvId = EnParamUtils.GetFreeRegistScSrvId();
			if(EnValidator.isEmpty(scsrvId))
				throw new BizException("免挂号费所使用排班服务[SC0110]未配置！");
			regRes.setId_scsrv(scsrvId);
		}
	}
	/**
	 * 是否收取过挂号费
	 * 
	 * @author liubin
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private boolean hasChargedRegisterCost(String patId) throws BizException{
		return new GetPriceBP().hasChargedRegisterCost(patId);
	}
	/**
	 * 设置终端类型
	 * 
	 * @param chlTp
	 * @param payDTO
	 * @throws BizException 
	 */
	private String setPttp(String chlTp) throws BizException {
		ISchedulechlMDORService rservice = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO[] schedulechlDOs = rservice.find("code = '"+chlTp+"'", null, FBoolean.FALSE);
		if(schedulechlDOs != null && schedulechlDOs.length == 1){
			SchedulechlDO SchedulechlDO = schedulechlDOs[0];
			String sd_pttp = SchedulechlDO.getSd_pttp();
			if(!EnValidator.isEmpty(sd_pttp)){
				return sd_pttp;
			}else{
				throw new BizException("医院诊间(本科)渠道对应的终端类型未配置，请在渠道定义进行维护！");
			}
		}
		return null;
	}
}
