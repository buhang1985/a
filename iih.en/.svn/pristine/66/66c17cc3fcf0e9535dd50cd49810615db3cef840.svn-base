package iih.en.que.s.bp.op;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCollectionUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.dto.d.OpRegPatDTO;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.s.event.bp.EnOpQueEventBP;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.d.desc.PiPatHpDODesc;
import iih.pi.reg.pat.i.IPiPatHpDORService;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.reg.dto.d.PeriodResDTO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 未挂号分诊
 * 
 * @author liubin
 *
 */
public class NoRegTriageBP {
	/**
	 * 未挂号分诊
	 * 
	 * @param opRegPat
	 * @param queSiteInfo
	 * @return
	 * @throws BizException
	 */
	public String exec(OpRegPatDTO opRegPat, TriageQueSiteDTO queSiteInfo)
			throws BizException {
		this.volidate(opRegPat, queSiteInfo);
		//1.获取号源信息
		RegResDTO regRes = this.getRegRes(opRegPat, queSiteInfo);
		//2.构造挂号信息
		RegInfoDTO regInfo = this.getRegInfoDTO(opRegPat, regRes);
		if(!(EnParamUtils.getAcptPatca().equals(IEnConst.ENOP0017_PAT) &&  !EnParamUtils.isSaveHPAtAcpt())){
			//3.设置医保信息
			this.setHpInfo(opRegPat, regInfo);
		}
		//4.支付信息先记账
		PayInfoDTO payInfo = this.getPayInfoDTO();	
		//5.挂号
		regInfo = this.acptReg(opRegPat.getId_pat(), regInfo, payInfo);	
		//6.分诊
		this.triageToSite(regInfo.getId_ent(), queSiteInfo);
		return regInfo.getId_ent();
	}
	/**
	 * 获取号源信息
	 * 
	 * @return
	 * @throws BizException 
	 */
	private RegResDTO getRegRes(OpRegPatDTO opRegPat, TriageQueSiteDTO queSiteInfo) throws BizException{
		RegResDTO regRes = null;
		if(EnValidator.isEmpty(queSiteInfo.getId_sch())){
			//没有排班
			regRes = assemplyRegRes(queSiteInfo);
		}else{
			//有排班
			regRes = this.getRegResBySchId(queSiteInfo.getId_sch());
		}
		regRes.setId_que(queSiteInfo.getId_que());
		//排班服务处理
		if(FBoolean.TRUE.equals(opRegPat.getFg_freereg())){
			//免挂号费
			String scsrvId = EnParamUtils.GetFreeRegistScSrvId();
			if(EnValidator.isEmpty(scsrvId))
				throw new BizException("免挂号费所使用排班服务[SC0110]未配置！");
			regRes.setId_scsrv(scsrvId);
		}else{
			regRes.setId_scsrv(queSiteInfo.getId_scsrv());
			if(EnValidator.isEmpty(regRes.getId_scsrv()))
				throw new BizException("挂号所使用的排班服务不能为空！");
		}
		return regRes;
	}
	/**
	 * 
	 * 
	 * @param schId
	 * @return
	 * @throws BizException 
	 */
	private RegResDTO getRegResBySchId(String schId) throws BizException{
		IScSchOutQryService schOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
		qryScheme.setIds_sch(EnCollectionUtils.toFArrayList(new String[]{schId}));
		qryScheme.setSd_scchltp(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_WINDOW);
		RegResDTO[] regRess = schOutQryService.getResByScheme(qryScheme);
		if(EnValidator.isEmpty(regRess))
			throw new BizException("没有医院窗口渠道排班，请先进行排班!");
		RegResDTO regRes = regRess[0];
		if(regRes.getRemain() <= 0)
			throw new BizException(String.format("排班（%s）医院窗口渠道号源已用尽, 请先加号！", regRes.getName_scpl()));
		return regRes;
	}
	/**
	 * 组装RegResDTO
	 * 
	 * @param queSiteInfo
	 * @return
	 * @throws BizException 
	 */
	private RegResDTO assemplyRegRes(TriageQueSiteDTO queSiteInfo) throws BizException{
		RegResDTO regres = new RegResDTO();
		DaysLotDO dayslot = this.getCurDayslot();
		regres.setId_dayslot(dayslot.getId_dayslot());
		regres.setId_dep(queSiteInfo.getId_dep());
		regres.setId_emp(queSiteInfo.getId_emp());
		regres.setD_sch(new FDate(dayslot.getDef1()));
		regres.setId_scres(queSiteInfo.getId_scres());
		regres.setId_scsrv(queSiteInfo.getId_scsrv());
		return regres;
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
	private RegInfoDTO getRegInfoDTO(OpRegPatDTO opRegPat, RegResDTO regRes) throws BizException{
		PiPatEP piPatEp = new PiPatEP();
		PatDO patDO = piPatEp.getPatById(opRegPat.getId_pat());
		RegInfoDTO regInfo = new RegInfoDTO();
		regInfo.setRegisted_date(regRes.getD_sch());
		regInfo.setId_dayslot(regRes.getId_dayslot());		
		regInfo.setId_pat(opRegPat.getId_pat());
		regInfo.setName_pat(patDO.getName());
		regInfo.setId_patca(opRegPat.getId_patca());
		regInfo.setId_pripat(opRegPat.getId_pripat());
		regInfo.setId_patcredtp(opRegPat.getId_patcredtp());
		regInfo.setIs_referral(FBoolean.FALSE);//续诊标识
		regInfo.setRegresarray(EnAppUtils.doArray2List(regRes));//绑定挂号资源
		regInfo.setSd_tickmd(regRes.getSd_tickmd());//票号模式
		regInfo.setId_sch(regRes.getId_sch());//排班id
		regInfo.setId_emp_entry(EnContextUtils.getPsnId());//操作员
		regInfo.setEu_regtp(EuRegTp.NOREGTRIAGE);//未挂号分诊
		if(IScDictCodeConst.SD_TICKMD_TICKS.equals(regInfo.getSd_tickmd())){
			IScSchOutQryService ticksService = ServiceFinder.find(IScSchOutQryService.class);
				PeriodResDTO periodRes = ticksService.getRecentAvlTicks(regRes.getId_sch(), IScDictCodeConst.SD_SCCHLTP_HOSPITAL_WINDOW);
				regInfo.setPeriod(periodRes.getPeriod());
				regInfo.setId_ticks(periodRes.getId_ticks());//号段id	
		}
		return regInfo;
	}
	/**
	 * 支付信息先记账
	 * @return
	 */
	private PayInfoDTO getPayInfoDTO(){
		PayInfoDTO payInfo = new PayInfoDTO();
		//payInfo.setPaystyle(IBdPripmCodeConst.CODE_PRI_PM_PAY);//预交金
		payInfo.setFg_acc(FBoolean.TRUE);//只记账
		payInfo.setFg_print(FBoolean.FALSE);
		return payInfo;
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
	private RegInfoDTO acptReg(String patId,RegInfoDTO regInfo, PayInfoDTO payInfo) throws BizException {
		IEnOutCmdService opRegService = ServiceFinder.find(IEnOutCmdService.class);
		RegInfoDTO[] regedInfos = opRegService.regOp(patId, new RegInfoDTO[]{regInfo}, payInfo);
		if(EnValidator.isEmpty(regedInfos)){
			throw new BizException(IEnMsgConst.ERROR_OP_REG_WRONG);
		}
		return regedInfos[0];
	}
	/**
	 * 分诊
	 * 
	 * @param entId
	 * @param queSiteInfo
	 * @throws BizException
	 */
	private void triageToSite(String entId, TriageQueSiteDTO queSiteInfo) throws BizException{
		EnQueEP ep = new EnQueEP();
		EnQueueDO[] enQueues = ep.getEnQueueByEntId(entId, IBdFcDictCodeConst.SD_QUETP_EMP);
		if(!EnValidator.isEmpty(enQueues)){
			EnQueueDO enQueue = enQueues[0];
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setId_que(queSiteInfo.getId_que());
			enQueue.setId_que_site(queSiteInfo.getId_quesite());
			enQueue.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
			if(EnParamUtils.isTriageToEmp())
				enQueue.setId_emp_opreg(queSiteInfo.getId_emp());
			else
				enQueue.setId_emp_opreg(null);
			ep.save(new EnQueueDO[]{enQueue});
			//发送分诊事件
			new EnOpQueEventBP().invokeEnOpQueEvent(queSiteInfo.getId_que(), queSiteInfo.getId_quesite(), enQueue.getCode_entp(), entId, IEnEventConst.EVENT_EN_OP_TRIAGE);
		}
	}
	/**
	 * 设置挂号医保计划
	 * 
	 * @param regInfo
	 * @param pat
	 * @throws BizException 
	 */
	private void setHpInfo(OpRegPatDTO opRegPat, RegInfoDTO regInfo) throws BizException{
		if(EnValidator.isEmpty(regInfo.getId_patca()))
			return;
		//获取pi_pat_ca_hp
		IPatcatehpRService patcatehpRServ = ServiceFinder.find(IPatcatehpRService.class);
		PiPatCaHpDO[] piPatCaHps =  patcatehpRServ.findByAttrValString(PiPatCaHpDO.ID_PATCA, regInfo.getId_patca());
		if(EnValidator.isEmpty(piPatCaHps))
			return;
		PiPatCaHpDO piPatCaHp = piPatCaHps[0];
		if(EnValidator.isEmpty(piPatCaHp.getId_hp()))
			return;
		IPiPatHpDORService piPatHpDORServ = ServiceFinder.find(IPiPatHpDORService.class);
		String whereStr = String.format("%s.id_pat = '%s' and %s.id_hp = '%s' and %s.fg_act = '%s'", 
				PiPatHpDODesc.TABLE_ALIAS_NAME, regInfo.getId_pat(),
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
	 * @param id_pat
	 * @param queSiteInfo
	 * @throws BizException
	 */
	private void volidate(OpRegPatDTO opRegPat, TriageQueSiteDTO queSiteInfo) throws BizException{
		if(opRegPat == null || EnValidator.isEmpty(opRegPat.getId_pat()))
			throw new BizException("患者信息不能为空！");
		if(queSiteInfo == null)
			throw new BizException("医生接诊站点不能为空！");
	}
	/**
     * 获取当前日期分组
     * 
     * @return
     * @throws BizException
     */
	private DaysLotDO getCurDayslot() throws BizException {
		DaysLotDO dayslot = ServiceFinder.find(IScDaysLotService.class)
				.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.TRUE);
		if(dayslot == null)
			throw new BizException("未获取到当前日期分组！");
		return dayslot;
	}
}
