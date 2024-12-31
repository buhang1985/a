package iih.bl.itf.std.inner.en.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.comm.util.BlDataUtil;
import iih.bl.hp.hpentcodeoep.d.HpEntCodeOepDO;
import iih.bl.hp.hpentcodeoep.i.IHpentcodeoepCudService;
import iih.bl.hp.hptranactoep.d.HpTransactOepDO;
import iih.bl.hp.hptranactoep.i.IHptranactoepCudService;
import iih.bl.hp.hptransactah.d.EuTransStatus;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPayDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPayRltDTO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.bl.st.dto.blpayoep.d.BlPayOepDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.biz.dto.d.CommonPropDataDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePaySelfInParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePaySelfOutParamDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 挂号收付款
 * @author ly 2019/07/25
 *
 */
public class BlOpChargeForEnRegPayBP {

	private Map<String, PriPmDO> pmMap;
	
	private BlStOepDO stOepDO;
	
	private BlCgItmOepDO[] cgItms;
	
	private PatiVisitDO entDO;
	
	/**
	 * 挂号收付款
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public BlOpRegPayRltDTO exec(BlOpRegPayDTO dto) throws BizException {
		
		this.validate(dto);
		
		this.loadPm();
		this.loadCgData(dto.getId_stoep());
		this.loadEntData(dto.getId_ent());
		
		// 门诊收付款接口
		BlPayOepDTO payoepDto = new BlPayOepDTO();
		List<BlPayOepPmDTO> pmList = new ArrayList<BlPayOepPmDTO>();
		
		if(!StringUtil.isEmpty(dto.getSd_pm())){
			BlPayOepPmDTO payOepPmDto = this.getPaymentDto(dto.getSd_pm(), dto.getAmt(), dto.getBankno(), dto.getPaymodenode());
			pmList.add(payOepPmDto);
		}
		
		if(!StringUtil.isEmpty(dto.getId_hp())){
			
			InsureContext insContext = new InsureContext();
			insContext.setIdHp(dto.getId_hp());
			InsureFacade insFacade = new InsureFacade(insContext);
			
			OepSettleRtnValDTO hpstData = this.dealHp(dto,insFacade);
			if(hpstData != null){
				this.analysisHp(payoepDto, pmList, hpstData, insFacade);
			}
			payoepDto.setId_hp(dto.getId_hp());
		}
		
		payoepDto.setId_pat(dto.getId_pat());
		payoepDto.setId_st(dto.getId_stoep());
		payoepDto.setSd_pttp(dto.getSd_pttp());
		payoepDto.setFg_print(dto.getFg_printinc());
		payoepDto.setAmt_pay(FDouble.ZERO_DBL);
		payoepDto.setId_patca(this.entDO.getId_patca());
		for (BlPayOepPmDTO blPayOepPmDTO : pmList) {
			payoepDto.setAmt_pay(payoepDto.getAmt_pay().add(blPayOepPmDTO.getAmt()));
		}
		
		//更新记账数据
		this.updateCgData(dto.getId_stoep());
				
		//更新结算数据
		this.updateStData(dto.getId_stoep());
				
		IBlOepChargeCmdService oepPaymentservice = ServiceFinder.find(IBlOepChargeCmdService.class);
		oepPaymentservice.oepPayment(payoepDto, pmList.toArray(new BlPayOepPmDTO[0]), null);

		BlOpRegPayRltDTO rlt = this.setPayRlt();
		
		return rlt;
	}

	/**
	 * 参数校验
	 * @param dto
	 * @throws BizException
	 */
	private void validate(BlOpRegPayDTO dto) throws BizException {
		
		if(StringUtil.isEmpty(dto.getId_pat())){
			throw new ArgumentNullException("挂号收付款", "患者id");
		}
		
		if(StringUtil.isEmpty(dto.getId_ent())){
			throw new ArgumentNullException("挂号收付款", "就诊id");
		}
		
		if(StringUtil.isEmpty(dto.getId_stoep())){
			throw new ArgumentNullException("挂号收付款", "结算id");
		}
		
		if(dto.getFg_printinc() == null){
			dto.setFg_printinc(FBoolean.FALSE);
		}
	}
	
	/**
	 * 加载支付方式
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void loadPm() throws BizException {
		this.pmMap = new HashMap<String, PriPmDO>();
		DAFacade daf = new DAFacade();

		List<PriPmDO> pmList = (List<PriPmDO>) daf.findByCond(PriPmDO.class, "ds = 0");
		if(ListUtil.isEmpty(pmList))
			return;
		
		for (PriPmDO priPmDO : pmList) {
			this.pmMap.put(priPmDO.getCode(), priPmDO);
		}
	}

	/**
	 * 加载费用数据
	 * @param stId
	 */
	private void loadCgData(String stId) throws BizException {
		
		IBlstoepRService stService = ServiceFinder.find(IBlstoepRService.class);
		this.stOepDO = stService.findById(stId);
		
		if(this.stOepDO == null){
			throw new BizException("未查询到对应结算数据：" + stId);
		}
		
		IBlCgItmOepDORService cgService = ServiceFinder.find(IBlCgItmOepDORService.class);
		this.cgItms = cgService.findByAttrValString(BlCgItmOepDO.ID_STOEP, stId);
	}
	
	/**
	 * 加载就诊数据
	 * @param entId
	 * @throws DAException 
	 */
	private void loadEntData(String entId) throws BizException {
		
		DAFacade daf = new DAFacade();
		this.entDO = (PatiVisitDO)daf.findByPK(PatiVisitDO.class, entId);
		if(this.entDO == null){
			throw new BizException("未查询到对应就诊数据：" + entId);
		}
	}
	
	/**
	 * 处理医保
	 * @param dto
	 * @param insFacade
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OepSettleRtnValDTO dealHp(BlOpRegPayDTO dto,InsureFacade insFacade) throws BizException {
		
		MiOepChargePaySelfInParamDTO inParam = new MiOepChargePaySelfInParamDTO();
		inParam.setId_pat(dto.getId_pat());
		
		
		FArrayList stFList = new FArrayList();
		FArrayList cgFList = new FArrayList();
		
		stFList.add(this.stOepDO);
		cgFList.addAll(Arrays.asList(this.cgItms));
		inParam.setStinfo(stFList);
		inParam.setCgtiminfo(cgFList);
		
		inParam.setStr_hpcard(dto.getHpcardinfo());
		inParam.setStr_hpregisterrtn(dto.getHpregisterrtninfo());
		inParam.setStr_detailuploadrtn(dto.getHpdetailuploadrtninfo());
		inParam.setStr_hpstrtn(dto.getHpstrtninfo());
		
		ResultOutParamDTO<MiOepChargePaySelfOutParamDTO> rlt = insFacade.oepPaySelf(inParam);
		
		if(FBoolean.FALSE.equals(rlt.getFg_deal())){
			return null;
		}
		
		if(FBoolean.FALSE.equals(rlt.getFg_HpSuccess())){
			throw new BizException("医保付款处理失败："+ rlt.getErrorMsg());
		}
		
		if(ListUtil.isEmpty(rlt.getData().getOldpropdata())){
			throw new BizException("医保付款处理返回值设值为空");
		}
		
		OepSettleRtnValDTO rltData = (OepSettleRtnValDTO)rlt.getData().getOldpropdata().get(0);
		
		//保存医保登记信息
		IHpentcodeoepCudService entCodeService = ServiceFinder.find(IHpentcodeoepCudService.class);
		HpEntCodeOepDO entCodeDO = new HpEntCodeOepDO();
		entCodeDO.setId_pat(this.entDO.getId_pat());
		entCodeDO.setId_ent(this.entDO.getId_ent());
		entCodeDO.setCode_ent(this.entDO.getCode());
			
		entCodeDO.setHp_ent_serialno(this.stOepDO.getCode_st());
		entCodeDO.setFg_active(FBoolean.TRUE);
		entCodeDO.setCode_his(null);
		entCodeDO.setFg_lock(FBoolean.FALSE);
		entCodeDO.setDt_reg(new FDateTime());
		//entCodeDO.setNo_hp(No_hp); TODO
		entCodeDO.setId_org(Context.get().getOrgId());
		entCodeDO.setId_grp(Context.get().getGroupId());
		entCodeDO.setId_hp(dto.getId_hp());
		entCodeDO.setEu_direct(1);
		entCodeDO.setEu_exstatus("01");
		entCodeDO.setRead_card_info(inParam.getStr_hpcard());
		entCodeDO.setRegist_info(inParam.getStr_hpregisterrtn());
		entCodeDO.setId_patca(this.stOepDO.getId_patca());
		entCodeDO.setCode_st(this.stOepDO.getCode_st());
		entCodeService.insert(new HpEntCodeOepDO[] { entCodeDO });
		
		//保存医保交易信息
		IHptranactoepCudService hpTransService = ServiceFinder.find(IHptranactoepCudService.class);
		HpTransactOepDO transDO = new HpTransactOepDO();
		transDO.setId_grp(Context.get().getGroupId());
		transDO.setId_org(Context.get().getOrgId());
		transDO.setBusiness_code(null);//TODO
		if(entDO != null){
			transDO.setCode_entp(entDO.getCode_entp());
			transDO.setEnt_code(entDO.getCode());
			transDO.setId_ent(entDO.getId_ent());
		}
		transDO.setHp_ent_serial_no(this.stOepDO.getCode_st());
		transDO.setDt_transact(new FDateTime());
		transDO.setId_emp_opr(Context.get().getStuffId());
		transDO.setCode_his(null);
		transDO.setCode_hp(rlt.getCenterTradeNo());
		transDO.setFg_cancel(FBoolean.FALSE);
		transDO.setEu_direct(1);
		transDO.setId_pat(this.entDO.getId_pat());
		transDO.setStatus_trans(EuTransStatus.SETTLED);
		transDO.setSrcfunc_des("selfpay");
		//transDO.setInputinfo(Inputinfo); //TODO
		transDO.setCode_medkind(rltData.getCode_medkind());
		transDO.setOutputinfo(inParam.getStr_hpstrtn());
		hpTransService.insert(new HpTransactOepDO[] { transDO });
		
		return rltData;
	}
	
	/**
	 * 解析医保
	 * @param payoepDto
	 * @param pmList
	 * @param hpstData
	 * @param insFacade
	 */
	@SuppressWarnings("unchecked")
	private void analysisHp(BlPayOepDTO payoepDto, List<BlPayOepPmDTO> pmList, OepSettleRtnValDTO hpstData, InsureFacade insFacade)  throws BizException {

		//添加医保账户和医保基金支付方式
		CommonPropDataDTO propDto = insFacade.hpFormulaCalculateOep(hpstData);
		
		if(propDto.getAmt_hpact() != null && propDto.getAmt_hpact().compareTo(FDouble.ZERO_DBL) > 0){
			BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_INSUR, propDto.getAmt_hpact(), null, null);
			pmList.add(payOepPmDto);
		}
		
		if(propDto.getAmt_psn() != null && propDto.getAmt_psn().compareTo(FDouble.ZERO_DBL) > 0){
			BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT, propDto.getAmt_psn(), null, null);
			pmList.add(payOepPmDto);
		}
		
		if(propDto.getAmt_hosbear() != null && propDto.getAmt_hosbear().compareTo(FDouble.ZERO_DBL) > 0){
			BlPayOepPmDTO payOepPmDto = this.getPaymentDto(IBdPripmCodeConst.CODE_PRI_PM_HPPROFITLOSS, propDto.getAmt_hosbear(), null, null);
			pmList.add(payOepPmDto);
		}
		
		//payoepDto.setId_hp(dto.getId_hp());
		payoepDto.setAmt_all(this.stOepDO.getAmt_ratio());
		payoepDto.setAmt_hpall(propDto.getAmt_all());
		payoepDto.setAmt_hp(propDto.getAmt_hpact());
		payoepDto.setAmt_psnacc(propDto.getAmt_psn());
		payoepDto.setAmt_cash(propDto.getAmt_cash());
		payoepDto.setAmt_hosbear(propDto.getAmt_hosbear());
		
		FArrayList stRtnList = new FArrayList();
		stRtnList.add(hpstData);
		payoepDto.setOldpropdata(stRtnList);
	}
	
	/**
	 * 设置支付方式
	 * @param codePm
	 * @param amt
	 * @return
	 */
	private BlPayOepPmDTO getPaymentDto(String codePm, FDouble amt,String bankno,String paymodenode) throws BizException {
		
		// 查询付款方式
		PriPmDO pmDO = this.pmMap.get(codePm);
		if(pmDO == null){
			throw new BizException("未查询到支付方式信息");
		}
		
		BlPayOepPmDTO payOepPmDto = new BlPayOepPmDTO();
		payOepPmDto.setId_pm(pmDO.getId_pm());
		payOepPmDto.setSd_pm(pmDO.getCode());
		payOepPmDto.setAmt(amt);
		payOepPmDto.setBankno(bankno);
		payOepPmDto.setPaymodenode(paymodenode);
		payOepPmDto.setEu_direct(1);
		payOepPmDto.setFg_charge(FBoolean.FALSE);
		
		return payOepPmDto;
	}

	/**
	 * 更新结算数据
	 * @param entId
	 * @throws BizException
	 */
	private void updateStData(String stId) throws BizException {
		
		IBlstoepRService stService = ServiceFinder.find(IBlstoepRService.class);
		IBlstoepCudService stCudService = ServiceFinder.find(IBlstoepCudService.class);
		this.stOepDO = stService.findById(stId);
		this.stOepDO.setId_ent(this.entDO.getId_ent());
		this.stOepDO.setId_enttp(this.entDO.getId_entp());
		this.stOepDO.setCode_enttp(this.entDO.getCode_entp());
		this.stOepDO = stCudService.update(new BlStOepDO[] { this.stOepDO })[0];
	}
	
	/**
	 * 更新记账数据
	 * @param stId
	 */
	private void updateCgData(String stId) throws BizException {
		
		IBlCgItmOepDORService cgService = ServiceFinder.find(IBlCgItmOepDORService.class);
		IBlCgItmOepDOCudService cgCudService = ServiceFinder.find(IBlCgItmOepDOCudService.class);
		this.cgItms = cgService.findByAttrValString(BlCgItmOepDO.ID_STOEP, stId);

		for (BlCgItmOepDO cgItmDO : cgItms) {
			cgItmDO.setId_ent(this.entDO.getId_ent());
			cgItmDO.setId_enttp(this.entDO.getId_entp());
			cgItmDO.setCode_enttp(this.entDO.getCode_entp());
			cgItmDO.setId_dep_phy(this.entDO.getId_dep_phy());
			cgItmDO.setId_dep_mp(this.entDO.getId_dep_phy());
			cgItmDO.setId_dep_or(this.entDO.getId_dep_phy());
			cgItmDO.setId_emp_phy(this.entDO.getId_emp_phy());
		}
		this.cgItms = cgCudService.update(this.cgItms);
	}

	/**
	 * 设置返回值
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlOpRegPayRltDTO setPayRlt() throws BizException {
		
		BlOpRegPayRltDTO payRltDto = new BlOpRegPayRltDTO();
		payRltDto.setId_stoep(this.stOepDO.getId_stoep());
		
		BlcgoepAggDO[] cgAggDos = BlDataUtil.getOepCgAggDataByItm(this.cgItms);
		
		FArrayList cgFList = new FArrayList();
		FArrayList stFList = new FArrayList();
		
		cgFList.addAll(Arrays.asList(cgAggDos));
		stFList.add(this.stOepDO);
		
		payRltDto.setCgdetail(cgFList);
		payRltDto.setStdetail(stFList);
		
		return payRltDto;
	}
}
