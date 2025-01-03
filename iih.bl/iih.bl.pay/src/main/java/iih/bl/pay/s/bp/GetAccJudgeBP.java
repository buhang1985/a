package iih.bl.pay.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.bdprewarn.d.ControlModelEnum;
import iih.bd.pp.dto.d.PriceReqDTO;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.ICalcPriceService;
import iih.bl.comm.IBlConst;
import iih.bl.comm.dto.d.BlPrepayWarnHitDTO;
import iih.bl.comm.util.BlAccountUtil;
import iih.bl.comm.util.BlPeCmpyUtil;
import iih.bl.comm.util.BlPrepayWarnUtil;
import iih.bl.et.etaccountdto.d.ETAccountDTO;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import iih.bl.pay.dto.account.d.BlAccountDTO;
import iih.bl.pay.dto.d.PrePaidAccAmtDTO;
import iih.bl.pay.dto.d.PrePaidDTO;
import iih.bl.pay.dto.prepayamount.d.BlPrepayCondDTO;
import iih.bl.pay.prewarnunit.d.BlPrewarnUnitDO;
import iih.bl.pay.prewarnunit.i.IPrewarnunitRService;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.i.INewbornRService;
import iih.en.pv.out.i.IEn4BlQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 欠费判断接口
 * 
 * @author yang.lu 2018年6月24日
 *         ly 2018/07/11 重构
 */
public class GetAccJudgeBP {
	
	/**
	 * 欠费控制时是否算新开医嘱
	 */
	public FBoolean blprepay0023;
	/**
	 * 婴儿是否使用母亲账户
	 */
	public FBoolean blstip0026;
	/**
	 * 允许开单的医嘱费用
	 */
	public FDouble amt_over;
	
	/**
	 * 返回给医嘱的预交金控制策略信息
	 */
	private BdPreWarnDO _preWarnDO;
	
	/**
	 * 返回给医嘱的住院预交金余额信息
	 */
	private BalanceDTO _balDTO;
	
	public GetAccJudgeBP(){
		blprepay0023 = BlParams.BLPREPAY0023();
		blstip0026 = BlParams.BLSTIP0026();
		amt_over = FDouble.ZERO_DBL;
	}

	/**
	 * 欠费判断接口
	 * @param codeEntp
	 * @param entId
	 * @param patId
	 * @param patCaTp
	 * @return
	 * @throws BizException
	 */
	public PrePaidAccAmtDTO exec(BlPrepayCondDTO condDto) throws BizException {
		boolean isPreIp = IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(condDto.getCode_entp());
		if (!IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(condDto.getCode_entp()) && !IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(condDto.getCode_entp())
				&& !isPreIp) {
			throw new BizException("接口支持门诊与住院预交金查询！");
		}
		
		PatiVisitDO enDO = this.getEntData(condDto.getId_ent());
		if (enDO == null && (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(condDto.getCode_entp()) || isPreIp)) {
			throw new BizException("未获取到患者就诊数据！");
		}
		
		//医嘱下只有部分收费项目是否允许开
		if (FBoolean.TRUE.equals(blprepay0023)) {
			//获取允许开单的医嘱费用
			this.getAmtOver(condDto);
		}
		
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(condDto.getCode_entp()) || isPreIp) {
				
			String pecmpyId = BlPeCmpyUtil.isPecmpy(condDto.getId_ent());
			// 判断是否有团检
			if (!StringUtil.isEmpty(pecmpyId)) {
				// 返回团检控制预交金策略
				return getPecmpyPre(condDto.getId_pat(), condDto.getId_ent(), pecmpyId);
			} else {
				// 返回住院控制预交金策略
				//return getIpPre(condDto.getId_ent(), enDO);	第一个入参错误，应为患者分类ID
				return getIpPre(condDto.getId_patca(), enDO);
			}
		} else {
			// 返回门诊控制预交金策略
			return getOepPre(condDto.getId_pat(), condDto.getId_patca(), condDto.getCode_entp(), enDO);
		}
	}
	
	/**
	 * 获取允许开单的医嘱费用
	 * @author zhang.hw
	 * @date 2019年10月11日
	 * @param condDto
	 * @return
	 */
	private void getAmtOver(BlPrepayCondDTO condDto) throws BizException {
		//接诊的时候未开立医嘱，跳过此步骤
		if (condDto.getId_srvs()==null||condDto.getId_srvs().size()==0) {
			return;
		}
		List<PriceReqDTO> list = new ArrayList<PriceReqDTO>();
		
		for(int i=0;i<condDto.getId_srvs().size();i++){
			PriceReqDTO dto = new PriceReqDTO();
			dto.setId_srv((String)condDto.getId_srvs().get(i));
			list.add(dto);
		}
		ICalcPriceService icalcService = ServiceFinder.find(ICalcPriceService.class);
		Map<String, PriceResultDTO> map = icalcService.calcPrice(list.toArray(new PriceReqDTO[list.size()]));
		for(int i=0;i<condDto.getId_srvs().size();i++){
			PriceResultDTO priceResultDTO = map.get((String)condDto.getId_srvs().get(i));
			amt_over = amt_over.add(priceResultDTO.getPrice_std());
		}
	}

	/**
	 * 获取就诊数据
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getEntData(String entId)  throws BizException {
		
		if(StringUtil.isEmpty(entId))
			return null;
		
		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		return entService.findById(entId);
	}

	/**
	 * 获取门诊预交金策略
	 * @param patId
	 * @param patCaTp
	 * @param codeEntp
	 * @param enDO
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private PrePaidAccAmtDTO getOepPre(String patId, String patCaTp,String codeEntp, PatiVisitDO enDO) throws BizException {
		// 获取门诊预交金
		IPatAccServiceExt patAccService = ServiceFinder.find(IPatAccServiceExt.class);
		PatRelAmountInfoDTO balDTO = patAccService.GetPatRelAmountInfo(patId);
		
		String depId = null;
		String entId = null;
		if(enDO != null){
			depId = enDO.getId_dep_phy();
			entId = enDO.getId_ent();
		}
		
		// 获取警告策略
		BdPreWarnDO[] preWarnDos = BlPrepayWarnUtil.getPreWarnSetting(enDO.getCode_entp());
		BlPrepayWarnHitDTO hitDto = new BlPrepayWarnHitDTO();
		hitDto.SetDepId(enDO.getId_dep_phy());
		hitDto.SetNurId(enDO.getId_dep_nur());
		hitDto.SetPatcaId(enDO.getId_patca());
		
		DAFacade daf = new DAFacade();
		List<EntHpDO> entHpList = (List<EntHpDO>)daf.findByAttrValString(EntHpDO.class, EntHpDO.ID_ENT, enDO.getId_ent(), 
				new String[]{EntHpDO.ID_ENT,EntHpDO.ID_HPPATCA, EntHpDO.FG_MAJ});
		if(!ListUtil.isEmpty(entHpList)){
			for (EntHpDO entHpDO : entHpList) {
				if(FBoolean.TRUE.equals(entHpDO.getFg_maj())){
					hitDto.SetHppatcaId(entHpDO.getId_hppatca());
				}
			}
		}
		_preWarnDO = BlPrepayWarnUtil.hitPreWarnSetting(preWarnDos, hitDto);
		
		if(_preWarnDO == null){
			return this.createDefaultPreAccDTO(IBlConst.ACC_PATTP_PAT,
					balDTO.getPrepay(), balDTO.getPrepay().sub(balDTO.getAcc_lock()),
					balDTO.getMoney_canuse(), patId, entId,balDTO.getCred_total());
		}
		
		//PrePaidAccAmtDTO controlRlt = this.getControlInfo(_preWarnDO, balDTO.getPrepay(), balDTO.getPrepay().sub(balDTO.getAcc_lock()),balDTO.getMoney_canuse(),balDTO.getCred_total());
		BlAccountDTO accDto = new BlAccountDTO();
		accDto.setAmt_available(balDTO.getMoney_canuse());
		accDto.setAmt_prepay(balDTO.getPrepay());
		accDto.setAmt_cred(balDTO.getCred_total());
		PrePaidDTO prepaiDto = BlAccountUtil.calcArrearsGrade(accDto, _preWarnDO);
		
		return this.createPreAccDTO(prepaiDto.getFg_arrears(),
				prepaiDto.getSd_arslv(), prepaiDto.getAmt_limit(),
				IBlConst.ACC_PATTP_PAT, balDTO.getPrepay(), balDTO.getPrepay().sub(balDTO.getAcc_lock()),
				balDTO.getMoney_canuse(), patId, entId,balDTO.getCred_total());
	}

	/**
	 * 返回住院控制规则
	 * @param patCaTp
	 * @param enDO
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private PrePaidAccAmtDTO getIpPre(String patCaTp, PatiVisitDO enDO) throws BizException {
		//判断是不是婴儿患者	 获取当前住院预交金
		INewbornRService cmdService = ServiceFinder.find(INewbornRService.class);
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO[] borns = cmdService.find("Id_ent_bb IN (SELECT ID_ENT FROM EN_ENT_IP WHERE FG_NEWBORN = 'Y' AND ID_ENT = '"+enDO.getId_ent()+"' )",null,FBoolean.FALSE );
		if (borns!=null && borns.length>0 && FBoolean.TRUE.equals(this.blstip0026)) {
			_balDTO = enService.getBalanceDTO(borns[0].getId_ent_mom());
		}else {
			_balDTO = enService.getBalanceDTO(enDO.getId_ent());
		}
		
		// 获取警告策略
		BdPreWarnDO[] preWarnDos = BlPrepayWarnUtil.getPreWarnSetting(enDO.getCode_entp());
		BlPrepayWarnHitDTO hitDto = new BlPrepayWarnHitDTO();
		hitDto.SetDepId(enDO.getId_dep_phy());
		hitDto.SetNurId(enDO.getId_dep_nur());
		hitDto.SetPatcaId(enDO.getId_patca());
		
		DAFacade daf = new DAFacade();
		List<EntHpDO> entHpList = (List<EntHpDO>)daf.findByAttrValString(EntHpDO.class, EntHpDO.ID_ENT, enDO.getId_ent(), 
				new String[]{EntHpDO.ID_ENT,EntHpDO.ID_HPPATCA, EntHpDO.FG_MAJ});
		if(!ListUtil.isEmpty(entHpList)){
			for (EntHpDO entHpDO : entHpList) {
				if(FBoolean.TRUE.equals(entHpDO.getFg_maj())){
					hitDto.SetHppatcaId(entHpDO.getId_hppatca());
				}
			}
		}
		_preWarnDO = BlPrepayWarnUtil.hitPreWarnSetting(preWarnDos, hitDto);
		
		//IBdPpQryService ppQryService = ServiceFinder.find(IBdPpQryService.class);
		//_preWarnDO = ppQryService.getPreWarnInfo(enDO.getId_dep_phy(), patCaTp, enDO.getCode_entp());
		
		if (_preWarnDO == null) {
			return this.createDefaultPreAccDTO(IBlConst.ACC_PATTP_PAT,
					_balDTO.getAmt_prepay(), _balDTO.getAmt_bal(),
					_balDTO.getAvailable(), enDO.getId_pat(),
					enDO.getId_ent(),_balDTO.getAmt_cred());
		}
		// 例如，自费患者，[0，10000)区间为警告提醒，[-2000，0)区间为部分控制，<-2000为完全控制。患者可用费用余额为-2100，则控制等级为完全控制。
		//PrePaidAccAmtDTO controlRlt = this.getControlInfo(preWarnDO, balDTO.getAmt_prepay(), balDTO.getAmt_bal());
		//PrePaidAccAmtDTO controlRlt = this.getControlInfo(_preWarnDO, _balDTO.getAmt_prepay(), _balDTO.getAmt_bal(),_balDTO.getAvailable(),_balDTO.getAmt_cred());
		
		BlAccountDTO accDto = new BlAccountDTO();
		accDto.setAmt_available(_balDTO.getAvailable());
		accDto.setAmt_prepay(_balDTO.getAmt_prepay());
		accDto.setAmt_cred(_balDTO.getAmt_cred());
		PrePaidDTO prepaiDto = BlAccountUtil.calcArrearsGrade(accDto, _preWarnDO);
		
		return this.createPreAccDTO(prepaiDto.getFg_arrears(),
				prepaiDto.getSd_arslv(), prepaiDto.getAmt_limit(),
				IBlConst.ACC_PATTP_PAT, _balDTO.getAmt_prepay(),
				_balDTO.getAmt_bal(), _balDTO.getAvailable(), enDO.getId_pat(),
				enDO.getId_ent(),_balDTO.getAmt_cred());
	}

	/**
	 * 获取住院或门诊校验对象
	 * 
	 * 获取判断模式 分为金额控制和押金等额比例两种控制模式
	 * @param preWarnDO
	 * @param amtPrepay 
	 * @param amtBal
	 * @return
	 */
/*	private PrePaidAccAmtDTO getControlInfo(BdPreWarnDO preWarnDO, FDouble amtPrepay, FDouble amtBal,FDouble amt_available,FDouble amt_cred) {

		FBoolean isArr = FBoolean.FALSE;
		if (FDouble.ZERO_DBL.compareTo(amtBal) > 0) {
			isArr = FBoolean.TRUE;
		}
		
		PrePaidAccAmtDTO paidDto = new PrePaidAccAmtDTO();
		paidDto.setFg_arrears(isArr);
		//增加了预交金比例， by lim 2018-11-30
//		FDouble value = ControlModelEnum.AMOUNTCONT.equals(preWarnDO.getEu_control()) ? 
//				amtBal : amtBal.div(amtPrepay.doubleValue()==0 ? amtPrepay=new FDouble(1):amtPrepay);
		FDouble value=this.getControlValue(preWarnDO.getEu_control(),amtPrepay,amtBal,amt_available,amt_cred);
		
		if (preWarnDO.getF_control() != null && value.compareTo(preWarnDO.getF_control()) < 0) {
			// 可用余额<完全控制:完全控制，则控制等级：3；
			paidDto.setSd_arslv(IBlConst.ACC_PREWARN_FCONTROL);
			if (ControlModelEnum.AMOUNTCONT.equals(preWarnDO.getEu_control())) {
			paidDto.setAmt_limit(preWarnDO.getF_control());
			}else {
				paidDto.setAmt_limit(value);
			}
		} else if (preWarnDO.getP_control() != null && value.compareTo(preWarnDO.getP_control()) < 0) {
			// 可用余额<部分控制:部分控制，则控制等级：2；
			paidDto.setSd_arslv(IBlConst.ACC_PREWARN_PCONTROL);
			if (ControlModelEnum.AMOUNTCONT.equals(preWarnDO.getEu_control())) {
			paidDto.setAmt_limit(preWarnDO.getP_control());
			}else {
				paidDto.setAmt_limit(value);
			}
		} else if (preWarnDO.getLimit() != null && value.compareTo(preWarnDO.getLimit()) < 0) {
			// 可用余额<警告值：部分控制，则控制等级：1；
			paidDto.setSd_arslv(IBlConst.ACC_PREWARN_LIMIT);
			if (ControlModelEnum.AMOUNTCONT.equals(preWarnDO.getEu_control())) {
			paidDto.setAmt_limit(preWarnDO.getLimit());
			}else {
				paidDto.setAmt_limit(value);
			}
		} else { // 可用余额>警告值，则控制等级：0；
			paidDto.setSd_arslv(IBlConst.ACC_PREWARN_NONE);
			if (ControlModelEnum.AMOUNTCONT.equals(preWarnDO.getEu_control())) {
			paidDto.setAmt_limit(preWarnDO.getLimit());
			}else {
				paidDto.setAmt_limit(value);
		}
		}
		
		return paidDto;
	}*/
	
	/**
	 * 根据控制方式返回对应的值
	 * @param ctrType 控制方式
	 * @param amtPrepay 预交金金额
	 * @param amtBal 预交金余额
	 * @param amt_available 预交金可用余额（包含信用额度）
	 * @param amt_cred 信用额度
	 * @return
	 */
	private FDouble getControlValue(String ctrType,FDouble amtPrepay, FDouble amtBal,FDouble amt_available,FDouble amt_cred){
		FDouble value= new FDouble();
		switch (ctrType){
			case ControlModelEnum.AMOUNTCONT://金额控制
				value=amt_available;
				break;	
			case ControlModelEnum.DEPEQUALPRO://押金等额比例
				//赋值警告值
				this._preWarnDO.setLimit(this._preWarnDO.getLimit().multiply(amtPrepay));
				//赋值部分控制值
				this._preWarnDO.setP_control(this._preWarnDO.getP_control().multiply(amtPrepay));
				//赋值完全控制值
				this._preWarnDO.setF_control(this._preWarnDO.getF_control().multiply(amtPrepay));
				if (amtBal.getDouble()<=this._preWarnDO.getLimit().getDouble()) {
					if (amt_available.getDouble()<0) {
						value = this._preWarnDO.getLimit().add(amtBal.abs());
					}else {
						value = this._preWarnDO.getLimit();
					}
				}
				//value=amtBal.div(amtPrepay.doubleValue()==0 ? amtPrepay=new FDouble(1):amtPrepay);
				break;	
			case ControlModelEnum.PRESCALE://预交金比例
				//赋值警告值
				this._preWarnDO.setLimit(this._preWarnDO.getLimit().multiply(amtPrepay.add(amt_cred)));
				//赋值部分控制值
				this._preWarnDO.setP_control(this._preWarnDO.getP_control().multiply(amtPrepay.add(amt_cred)));
				//赋值完全控制值
				this._preWarnDO.setF_control(this._preWarnDO.getF_control().multiply(amtPrepay.add(amt_cred)));
				if (amtBal.getDouble()<=this._preWarnDO.getLimit().getDouble()) {
					if (amt_available.getDouble()<0) {
						value = this._preWarnDO.getLimit().add(amtBal.abs());
					}else {
						value = this._preWarnDO.getLimit();
					}
				}
				//value=amt_available.div(amtPrepay.add(amt_cred).doubleValue()==0 ? amtPrepay=new FDouble(1):amtPrepay.add(amt_cred));
				break;	
		}
		if (FBoolean.TRUE.equals(blprepay0023)) {
			value = value.add(amt_over);
		}
		return value.abs().setScale(2, BigDecimal.ROUND_UP);
	}
	/**
	 * 获取团检控制规则
	 * @param patId
	 * @param entId
	 * @param pecmpyId
	 * @return
	 * @throws BizException
	 */
	private PrePaidAccAmtDTO getPecmpyPre(String patId, String entId, String pecmpyId) throws BizException {
		// 获得个人的团检消费总金额
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT nvl(SUM(EU_DIRECT * AMT_RATIO),0) FROM BL_CG_IP WHERE nvl(fg_research,'N')='N' and FG_PAY_UNIT='Y' AND FG_ST='N'");
		sql.append(" AND ID_ENT='" + entId + "' ");
		Object veObject =  new DAFacade().execQuery(sql.toString(), new ColumnHandler());
		FDouble petAccAmt=(FDouble)FTypeManager.convert2FType(FType.FDouble,veObject);
		if (FBoolean.TRUE.equals(blprepay0023)) {
			petAccAmt = petAccAmt.add(amt_over);
		}
		// 获取团检预交金控制
		IPrewarnunitRService preService = ServiceFinder.find(IPrewarnunitRService.class);
		BlPrewarnUnitDO preUnitDO = preService.findById(pecmpyId);

		IEn4BlQryService enService = ServiceFinder.find(IEn4BlQryService.class);
		BalanceDTO balDTO = enService.getPeCmpyBalance(pecmpyId);

		if (preUnitDO == null) {
			return this.createDefaultPreAccDTO("", new FDouble(0),new FDouble(0),new FDouble(0), patId, entId,new FDouble(0));
			//throw new BizException("未获取到团检的控制策略信息！");
		}
		
		// 个人消费金额超个人下限
		if (petAccAmt.compareTo(preUnitDO.getPat_limit().abs()) > 0) {
			return this.createPreAccDTO(FBoolean.TRUE,
					IBlConst.ACC_PREWARN_LIMIT, preUnitDO.getPat_limit(),
					IBlConst.ACC_PATTP_PECMPYPAT, balDTO.getAmt_prepay(),
					balDTO.getAmt_bal(), balDTO.getAvailable(), patId, entId,balDTO.getAmt_cred());
		}

		// 团体欠费超下限
		if (balDTO.getAmt_bal().compareTo(preUnitDO.getUnit_limit()) < 0) {
			return this.createPreAccDTO(FBoolean.TRUE,
					IBlConst.ACC_PREWARN_LIMIT, preUnitDO.getUnit_limit(),
					IBlConst.ACC_PATTP_PECMPY, balDTO.getAmt_prepay(),
					balDTO.getAmt_bal(), balDTO.getAvailable(), patId, entId,balDTO.getAmt_cred());
		}
		
		return this.createDefaultPreAccDTO(IBlConst.ACC_PATTP_PECMPY,
				balDTO.getAmt_prepay(), balDTO.getAmt_bal(),
				balDTO.getAvailable(), patId, entId,balDTO.getAmt_cred());
	}


	/**
	 * 创建返回值
	 * @param sdPrewarntp
	 * @param amtPrepay
	 * @param amtBal
	 * @param amtAvailable
	 * @param patId
	 * @param entId
	 * @return
	 */
	private PrePaidAccAmtDTO createPreAccDTO(FBoolean fgArrears,
			String sdArsLv, FDouble amtLimit, String sdPrewarntp,
			FDouble amtPrepay, FDouble amtBal, FDouble amtAvailable,
			String patId, String entId,FDouble amt_cred) {
		PrePaidAccAmtDTO retDto = new PrePaidAccAmtDTO();
		retDto.setFg_arrears(fgArrears);
		retDto.setSd_arslv(sdArsLv);
		retDto.setAmt_limit(amtLimit);
		retDto.setSd_prewarntp(sdPrewarntp);
		retDto.setAmt_prepay(amtPrepay);
		retDto.setAmt_bal(amtBal);
		retDto.setAmt_available(amtAvailable);
		retDto.setId_pat(patId);
		retDto.setId_ent(entId);
		retDto.setFg_isdeduct(blprepay0023);
		if (_preWarnDO!=null) {
			//给返回参数赋值
			getPreWarnNewDO(_preWarnDO,amtAvailable,amtPrepay,amt_cred);
			FArrayList fArrayList1 = new FArrayList();
			fArrayList1.add(_preWarnDO);
			retDto.setPrewarns(fArrayList1);
		}
		if (_balDTO!=null) {
			FArrayList fArrayList2 = new FArrayList();
			fArrayList2.add(_balDTO);
			retDto.setBalancedtos(fArrayList2);
		}
		return retDto;
	}
	
	private void getPreWarnNewDO(BdPreWarnDO _preWarnDO2,FDouble amtAvailable,FDouble amtPrepay,FDouble amt_cred) {
		switch (_preWarnDO2.getEu_control()){
		case ControlModelEnum.AMOUNTCONT://金额控制
			break;	
		case ControlModelEnum.DEPEQUALPRO://押金等额比例
			//赋值警告值
			this._preWarnDO.setLimit(this._preWarnDO.getLimit().multiply(amtPrepay));
			//赋值部分控制值
			this._preWarnDO.setP_control(this._preWarnDO.getP_control().multiply(amtPrepay));
			//赋值完全控制值
			this._preWarnDO.setF_control(this._preWarnDO.getF_control().multiply(amtPrepay));
			break;	
		case ControlModelEnum.PRESCALE://预交金比例
			//赋值警告值
			this._preWarnDO.setLimit(this._preWarnDO.getLimit().multiply(amtPrepay.add(amt_cred)));
			//赋值部分控制值
			this._preWarnDO.setP_control(this._preWarnDO.getP_control().multiply(amtPrepay.add(amt_cred)));
			//赋值完全控制值
			this._preWarnDO.setF_control(this._preWarnDO.getF_control().multiply(amtPrepay.add(amt_cred)));
			break;	
	}
	}

	/**
	 * 默认返回值
	 * @param sdPrewarntp
	 * @param amtPrepay
	 * @param amtBal
	 * @param amtAvailable
	 * @param patId
	 * @param entId
	 * @return
	 */
	private PrePaidAccAmtDTO createDefaultPreAccDTO(String sdPrewarntp,
			FDouble amtPrepay, FDouble amtBal, FDouble amtAvailable,
			String patId, String entId,FDouble amt_cred){
		return this.createPreAccDTO(FBoolean.FALSE, IBlConst.ACC_PREWARN_NONE,
				FDouble.ZERO_DBL, sdPrewarntp, amtPrepay, amtBal, amtAvailable,
				patId, entId,amt_cred);
	}
	
	/**
	 * 急诊欠费判断接口
	 * @param codeEntp
	 * @param entId
	 * @param patId
	 * @param patCaTp
	 * @return
	 * @throws BizException
	 */
	public PrePaidAccAmtDTO getETAccJudge(String codeEntp, String entId, String patId, String patCaTp) throws BizException {

		if (!IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(codeEntp)) {
			throw new BizException("接口支持急诊留观预交金查询！");
}
		
		PatiVisitDO enDO = this.getEntData(entId);
		if (enDO == null && IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(codeEntp)) {
			throw new BizException("未获取到患者就诊数据！");
		}

		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(codeEntp)) {
				
			// 返回住院控制预交金策略
			if(BlParams.BLST0002().equals(BlParamValueConst.BLST0002_OP))
			{
				return getOepPre(patId, patCaTp, codeEntp, enDO);
			}
			else if(BlParams.BLST0002().equals(BlParamValueConst.BLST0002_IP))
			{
				return getIpPre(patCaTp, enDO);
			}
			else
			{
				throw new BizException("请配置正确的BLST0002参数！");
			}
		} 
		throw new BizException("当前患者就诊类型编码不是急诊留观就诊类型编码！");
	}
	
	/**
	 * 得到急诊留观患者的账户信息
	 * @param codeEntp
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public ETAccountDTO getETAccount(String codeEntp, String entId) throws BizException
	{
		if (!IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(codeEntp)) {
			throw new BizException("接口支持急诊留观预交金查询！");
}
		
		PatiVisitDO enDO = this.getEntData(entId);
		if (enDO == null && IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(codeEntp)) {
			throw new BizException("未获取到患者就诊数据！");
		}
		
		if (BlParams.BLST0002().equals(BlParamValueConst.BLST0002_OP)) {
			return getOepETAccount(enDO);
		} else if (BlParams.BLST0002().equals(BlParamValueConst.BLST0002_IP)) {
			return getIpETAccount(entId);
		} else {
			throw new BizException("请配置正确的BLST0002参数！");
		}
	}
	
	
	/**
	 * 得到许多急诊留观患者的账户信息(批量查询)
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public Map<String,ETAccountDTO> getETAccountByEnts(PatiVisitDO[] entDos) throws BizException{
		
		if (BlParams.BLST0002().equals(BlParamValueConst.BLST0002_OP)) {
			return getOepETAccounts(entDos);
		} else if (BlParams.BLST0002().equals(BlParamValueConst.BLST0002_IP)) {
			return getIpETAccounts(entDos);
		} else {
			throw new BizException("请配置正确的BLST0002参数！");
		}
	}
	
	private ETAccountDTO getOepETAccount(PatiVisitDO enDO) throws BizException
	{
		// 获取门诊预交金
		IPatAccServiceExt patAccService = ServiceFinder.find(IPatAccServiceExt.class);
		PatRelAmountInfoDTO balDTO = patAccService.GetPatRelAmountInfo(enDO.getId_pat());
		ETAccountDTO temp = new ETAccountDTO();
		temp.setId_ent(enDO.getId_ent());
		temp.setAmt_prepay(balDTO.getPrepay_emgstay());
		temp.setAmt_bal(balDTO.getMoney_canuse_emgstay());
		temp.setCred(balDTO.getCred_total_emgstay());
		temp.setAcc_lock(balDTO.getAcc_lock_emgstay());
		return  temp;
	}
	
	private ETAccountDTO getIpETAccount(String entId) throws BizException
	{
		// 获取当前住院预交金
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		BalanceDTO balDTO = enService.getBalanceDTO(entId);
		
		ETAccountDTO temp = new ETAccountDTO();
		temp.setId_ent(entId);
		temp.setAmt_prepay(balDTO.getAmt_prepay());
		temp.setAmt_bal(balDTO.getAmt_bal());
		temp.setCred(balDTO.getAmt_cred());
		temp.setAcc_lock(balDTO.getAmt_uncg());
		return  temp;
	}
	
	private Map<String,ETAccountDTO> getOepETAccounts(PatiVisitDO[] enDO) throws BizException
	{
		String[] strIdPats = new String[enDO.length];
		Map<String, String> patEnt = new HashMap<String, String>();
		for (int i = 0; i < enDO.length; i++) {
			strIdPats[i] = enDO[i].getId_pat();
			patEnt.put(enDO[i].getId_pat(), enDO[i].getId_ent());
		}

		// 获取门诊预交金
		IPatAccServiceExt patAccService = ServiceFinder.find(IPatAccServiceExt.class);
		PatRelAmountInfoDTO[] balDTO = patAccService.GetPatRelAmountInfos(strIdPats);
		Map<String, ETAccountDTO> accountMap = new HashMap<String, ETAccountDTO>();
		for (int i = 0; i < balDTO.length; i++) {
			ETAccountDTO temp = new ETAccountDTO();
			String strIdEnt = patEnt.get(balDTO[i].getId_pat());
			temp.setId_ent(strIdEnt);
			temp.setAmt_prepay(balDTO[i].getPrepay_emgstay());
			temp.setAmt_bal(balDTO[i].getMoney_canuse_emgstay());
			temp.setCred(balDTO[i].getCred_total_emgstay());
			temp.setAcc_lock(balDTO[i].getAcc_lock_emgstay());
			accountMap.put(strIdEnt, temp);
		}

		return accountMap;
	}
	
	private Map<String,ETAccountDTO> getIpETAccounts(PatiVisitDO[] enDO) throws BizException
	{
		String[] strIdEnts = new String[enDO.length];
		for(int i= 0; i< enDO.length; i++)
		{
			strIdEnts[i] = enDO[i].getId_ent();
		}
		
		// 获取当前住院预交金
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		BalanceDTO[] balDTO = enService.getBalanceDTOs(strIdEnts);
		
		Map<String,ETAccountDTO> accountMap = new HashMap<String,ETAccountDTO>();
		for(int i= 0; i<balDTO.length; i++)
		{
			ETAccountDTO temp = new ETAccountDTO();
			temp.setId_ent(enDO[i].getId_ent());
			temp.setAmt_prepay(balDTO[i].getAmt_prepay());
			temp.setAmt_bal(balDTO[i].getAmt_bal());
			temp.setCred(balDTO[i].getAmt_cred());
			temp.setAcc_lock(balDTO[i].getAmt_uncg());
			accountMap.put(enDO[i].getId_ent(), temp);
		}
		
		return  accountMap;
	}
}
