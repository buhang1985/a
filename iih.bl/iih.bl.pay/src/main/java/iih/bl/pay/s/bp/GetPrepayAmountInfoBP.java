package iih.bl.pay.s.bp;

import iih.bd.base.utils.MapUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bl.comm.dto.d.BlPrepayWarnHitDTO;
import iih.bl.comm.util.BlAccountUtil;
import iih.bl.comm.util.BlPrepayWarnUtil;
import iih.bl.et.etaccountdto.d.ETAccountDTO;
import iih.bl.params.BlParams;
import iih.bl.pay.dto.account.d.BlAccountDTO;
import iih.bl.pay.dto.prepayamount.d.BlPrepayAmountDTO;
import iih.bl.pay.dto.prepayamount.d.BlPrepayCondDTO;
import iih.bl.pay.i.IBlPayOutQryService;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 获取预交金余额
 * @author ly 2019/03/01
 *
 */
public class GetPrepayAmountInfoBP {

	/**
	 * 补充预交金金额条件dto属性
	 */
	private static final String ID_DEP_PHY = "Id_dep_phy";
	private static final String ID_DEP_NUR = "Id_dep_nur";
	private static final String ID_HPPATCA = "Id_hppatca";
	
	/**
	 * 获取预交金余额
	 * @param condDtos 条件
	 * @return 预交金余额
	 * @throws BizException
	 */
	public BlPrepayAmountDTO[] exec(BlPrepayCondDTO[] condDtos) throws BizException{
		
		if(ArrayUtil.isEmpty(condDtos))
			return null;
		
		this.validate(condDtos);
		
		//分组
		Map<String,List<BlPrepayCondDTO>> prepayMap = new HashMap<String,List<BlPrepayCondDTO>>();
		for (BlPrepayCondDTO condDto : condDtos) {
			
			List<BlPrepayCondDTO> prepayCondList = null;
			if(prepayMap.containsKey(condDto.getCode_entp())){
				prepayCondList = prepayMap.get(condDto.getCode_entp());
			}else{
				prepayCondList = new ArrayList<BlPrepayCondDTO>();
				prepayMap.put(condDto.getCode_entp(), prepayCondList);
			}
			prepayCondList.add(condDto);
		}
		
		//处理门诊
		BlPrepayAmountDTO[] opAmtDtos = this.handleOp(prepayMap.get(IBdFcDictCodeConst.SD_CODE_ENTP_OP));
		
		//处理急诊流水
		BlPrepayAmountDTO[] etFlowAmtDtos = this.handleEtFlow(prepayMap.get(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW));
		
		//处理急诊抢救
		BlPrepayAmountDTO[] etFstaidAmtDtos = this.handleEtFstaid(prepayMap.get(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID));
	
		//处理住院
		BlPrepayAmountDTO[] ipAmtDtos = this.handleIp(prepayMap.get(IBdFcDictCodeConst.SD_CODE_ENTP_IP));
		
		//处理留观
		BlPrepayAmountDTO[] etObsAmtDtos = this.handleEtObs(prepayMap.get(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS));
		

		List<BlPrepayAmountDTO> rlt = new ArrayList<BlPrepayAmountDTO>();
		if(!ArrayUtil.isEmpty(opAmtDtos)){
			rlt.addAll(Arrays.asList(opAmtDtos));
		}
		if(!ArrayUtil.isEmpty(etFlowAmtDtos)){
			rlt.addAll(Arrays.asList(etFlowAmtDtos));
		}
		if(!ArrayUtil.isEmpty(etFstaidAmtDtos)){
			rlt.addAll(Arrays.asList(etFstaidAmtDtos));
		}
		
		if(!ArrayUtil.isEmpty(ipAmtDtos)){
			rlt.addAll(Arrays.asList(ipAmtDtos));
		}
		if(!ArrayUtil.isEmpty(etObsAmtDtos)){
			rlt.addAll(Arrays.asList(etObsAmtDtos));
		}
		
		if(rlt.size() == 0)
			return null;
		
		return rlt.toArray(new BlPrepayAmountDTO[0]);
	}
	
	/**
	 * 入参校验
	 * @param condDtos
	 * @throws BizException
	 */
	private void validate(BlPrepayCondDTO[] condDtos) throws BizException{
		
		for (BlPrepayCondDTO condDto : condDtos) {
			
			if(condDto == null){
				throw new BizException("获取预交金可用余额:入参为空");
			}
				
			if(StringUtil.isEmpty(condDto.getCode_entp())){
				throw new BizException("获取预交金可用余额:就诊类型为空");
			}
			
			if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(condDto.getCode_entp()) &&
					StringUtil.isEmpty(condDto.getId_pat())){
				throw new BizException("获取预交金可用余额:就诊类型为门诊时患者id不能为空");
			}
			if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(condDto.getCode_entp()) &&
					StringUtil.isEmpty(condDto.getId_pat())){
				throw new BizException("获取预交金可用余额:就诊类型为急诊流水时患者id不能为空");
			}
			if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(condDto.getCode_entp()) &&
					StringUtil.isEmpty(condDto.getId_pat())){
				throw new BizException("获取预交金可用余额:就诊类型为急诊抢救时患者id不能为空");
			}
			
			if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(condDto.getCode_entp()) &&
					StringUtil.isEmpty(condDto.getId_ent())){
				throw new BizException("获取预交金可用余额:就诊类型为住院时就诊id不能为空");
			}
			
			if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(condDto.getCode_entp())
					&& StringUtil.isEmpty(condDto.getId_ent())) {
				throw new BizException("获取预交金可用余额:就诊类型为留观时就诊id不能为空");
			}
			
			/*if(StringUtil.isEmpty(condDto.getId_patca())){
				throw new BizException("获取预交金可用余额:患者分类id不能为空");
			}*/
		}
	}

	/**
	 * 处理门诊预交金控制
	 * @param prepayList
	 * @return
	 * @throws BizException
	 */
	private BlPrepayAmountDTO[] handleOp(List<BlPrepayCondDTO> prepayList) throws BizException{
		
		// TODO
		return null;
	}
	
	/**
	 * 处理急诊流水预交金控制
	 * @param prepayList
	 * @return
	 * @throws BizException
	 */
	private BlPrepayAmountDTO[] handleEtFlow(List<BlPrepayCondDTO> prepayList) throws BizException{
		return null;
	}
	
	
	/**
	 * 处理急诊抢救预交金控制
	 * @param prepayList
	 * @return
	 * @throws BizException
	 */
	private BlPrepayAmountDTO[] handleEtFstaid(List<BlPrepayCondDTO> prepayList) throws BizException{
		return null;
	}
	
	/**
	 * 处理急诊留观预交金控制
	 * @param prepayList
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlPrepayAmountDTO[] handleEtObs(List<BlPrepayCondDTO> prepayList) throws BizException {
		if(prepayList == null){
			return null;
		}
		
		List<String> entIdList = new ArrayList<String>();

		for (BlPrepayCondDTO condDto : prepayList) {
			entIdList.add(condDto.getId_ent());
		}

		// 获取留观数据
		DAFacade daf = new DAFacade();
		List<PatiVisitDO> entList = (List<PatiVisitDO>) daf.findByPKs(PatiVisitDO.class,
				entIdList.toArray(new String[0]),
				new String[] { PatiVisitDO.ID_ENT, PatiVisitDO.ID_PAT,PatiVisitDO.ID_DEP_PHY,PatiVisitDO.ID_DEP_NUR, PatiVisitDO.ID_PATCA });

		List<EntHpDO> entHpList = (List<EntHpDO>)daf.findByAttrValStrings(EntHpDO.class, EntHpDO.ID_ENT, entIdList.toArray(new String[0]), 
				new String[]{EntHpDO.ID_ENT,EntHpDO.ID_HPPATCA, EntHpDO.FG_MAJ});
		
		Map<String, EntHpDO> entHpMap = new HashMap<String, EntHpDO>();
		if(!ListUtil.isEmpty(entHpList)){
			
			for (EntHpDO entHpDO : entHpList) {
				if(FBoolean.TRUE.equals(entHpDO.getFg_maj())){
					entHpMap.put(entHpDO.getId_ent(), entHpDO);
				}
			}
		}
		
		for (PatiVisitDO enDO : entList) {
			for (BlPrepayCondDTO condDto : prepayList) {
				if (enDO.getId_ent().equals(condDto.getId_ent())) {
					condDto.setAttrVal(ID_DEP_PHY, enDO.getId_dep_phy());
					condDto.setAttrVal(ID_DEP_NUR, enDO.getId_dep_nur());
					condDto.setId_patca(enDO.getId_patca());
					
					EntHpDO entHpDO = entHpMap.get(condDto.getId_ent());
					if(entHpDO != null){
						condDto.setAttrVal(ID_HPPATCA, entHpDO.getId_hppatca());
					}
					
					break;
				}
			}
		}

		// 查询预交金配置数据
		BdPreWarnDO[] preWarnDos = BlPrepayWarnUtil.getPreWarnSetting(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);

		IBlPayOutQryService payService = ServiceFinder.find(IBlPayOutQryService.class);
		Map<String, ETAccountDTO> balMap = payService.getETAccountByEnts(entList.toArray(new PatiVisitDO[0]));

		List<BlPrepayAmountDTO> rlt = new ArrayList<BlPrepayAmountDTO>();
		for (BlPrepayCondDTO preCondDto : prepayList) {
			BlPrepayAmountDTO preAmountDto = new BlPrepayAmountDTO();
			preAmountDto.setId_ent(preCondDto.getId_ent());
			preAmountDto.setId_pat(preCondDto.getId_pat());

			ETAccountDTO etAccDto = balMap.get(preCondDto.getId_ent());

			BlAccountDTO accDto = new BlAccountDTO();
			accDto.setId_pk(etAccDto.getId_ent());
			accDto.setAmt_prepay(etAccDto.getAmt_prepay());
			accDto.setAmt_cred(etAccDto.getCred());
			accDto.setAmt_uncg(etAccDto.getAcc_lock());
			accDto.setAmt_bal(accDto.getAmt_prepay().sub(accDto.getAmt_uncg()));
			accDto.setAmt_available(etAccDto.getAmt_bal());

			BlPrepayWarnHitDTO hitDto = new BlPrepayWarnHitDTO();
			hitDto.SetDepId((String) preCondDto.getAttrVal(ID_DEP_PHY));
			hitDto.SetNurId((String) preCondDto.getAttrVal(ID_DEP_NUR));
			hitDto.SetPatcaId(preCondDto.getId_patca());
			hitDto.SetHppatcaId((String) preCondDto.getAttrVal(ID_HPPATCA));
			BdPreWarnDO warnDO = BlPrepayWarnUtil.hitPreWarnSetting(preWarnDos, hitDto);

			preAmountDto.setAmt_prepay(accDto.getAmt_prepay());
			preAmountDto.setAmt_bal(accDto.getAmt_bal());
			preAmountDto.setAmt_available_act(accDto.getAmt_available());
			FDouble amtLimit = BlAccountUtil.calcAccBalance(accDto, warnDO);
			preAmountDto.setAmt_available_check(amtLimit);

			rlt.add(preAmountDto);
		}

		return rlt.toArray(new BlPrepayAmountDTO[0]);
	}
	
	/**
	 * 处理住院预交金控制
	 * @param prepayList
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlPrepayAmountDTO[] handleIp(List<BlPrepayCondDTO> prepayList) throws BizException{
		if(prepayList == null)
		{
			return null;
		}
		
		List<String> entIdList = new ArrayList<String>();
		for (BlPrepayCondDTO condDto : prepayList) {
			entIdList.add(condDto.getId_ent());
			//patcaIdSet.add(condDto.getId_patca());
		}
		
		//获取住院数据
		DAFacade daf = new DAFacade();
		List<PatiVisitDO> entList = (List<PatiVisitDO>) daf.findByPKs(
				PatiVisitDO.class, entIdList.toArray(new String[0]),
				new String[] { PatiVisitDO.ID_ENT, PatiVisitDO.ID_DEP_PHY, PatiVisitDO.ID_DEP_NUR, PatiVisitDO.ID_PATCA });
		
		List<EntHpDO> entHpList = (List<EntHpDO>)daf.findByAttrValStrings(EntHpDO.class, EntHpDO.ID_ENT, entIdList.toArray(new String[0]), 
				new String[]{EntHpDO.ID_ENT,EntHpDO.ID_HPPATCA, EntHpDO.FG_MAJ});
		
		Map<String, EntHpDO> entHpMap = new HashMap<String, EntHpDO>();
		if(!ListUtil.isEmpty(entHpList)){
			
			for (EntHpDO entHpDO : entHpList) {
				if(FBoolean.TRUE.equals(entHpDO.getFg_maj())){
					entHpMap.put(entHpDO.getId_ent(), entHpDO);
				}
			}
		}
		
		for (PatiVisitDO enDO : entList) {
			for (BlPrepayCondDTO condDto : prepayList) {
				if(enDO.getId_ent().equals(condDto.getId_ent())){
					condDto.setAttrVal(ID_DEP_PHY, enDO.getId_dep_phy());
					condDto.setAttrVal(ID_DEP_NUR, enDO.getId_dep_nur());
					condDto.setId_patca(enDO.getId_patca());
					
					EntHpDO entHpDO = entHpMap.get(condDto.getId_ent());
					if(entHpDO != null){
						condDto.setAttrVal(ID_HPPATCA, entHpDO.getId_hppatca());
					}
					break;
				}
			}
		}

		//查询预交金配置数据
		BdPreWarnDO[] preWarnDos = BlPrepayWarnUtil.getPreWarnSetting(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		
		//查询住院账户数据
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		BalanceDTO[] balDtos = enService.getBalanceDTOs(entIdList.toArray(new String[0]));
		
		if(FBoolean.TRUE.equals(BlParams.BLSTIP0026())){
			balDtos = enService.getBalanceDTOsContainBaby(entIdList.toArray(new String[0]));
		}else{
			balDtos = enService.getBalanceDTOs(entIdList.toArray(new String[0]));
		}
		
		Map<String, BalanceDTO> balMap = (Map<String, BalanceDTO>) MapUtils.
				convertArrayToMap(balDtos, "Id_ent");
		
		List<BlPrepayAmountDTO> rlt = new ArrayList<BlPrepayAmountDTO>();
		for (BlPrepayCondDTO preCondDto : prepayList) {
			BlPrepayAmountDTO preAmountDto = new BlPrepayAmountDTO();
			preAmountDto.setId_ent(preCondDto.getId_ent());
			preAmountDto.setId_pat(preCondDto.getId_pat());
			
			BlAccountDTO accDto = BlAccountUtil.convertToBlDto(balMap.get(preCondDto.getId_ent()));
			
			BlPrepayWarnHitDTO hitDto = new BlPrepayWarnHitDTO();
			hitDto.SetDepId((String) preCondDto.getAttrVal(ID_DEP_PHY));
			hitDto.SetNurId((String) preCondDto.getAttrVal(ID_DEP_NUR));
			hitDto.SetPatcaId(preCondDto.getId_patca());
			hitDto.SetHppatcaId((String) preCondDto.getAttrVal(ID_HPPATCA));
			BdPreWarnDO warnDO = BlPrepayWarnUtil.hitPreWarnSetting(preWarnDos, hitDto);
			
			preAmountDto.setAmt_prepay(accDto.getAmt_prepay());
			preAmountDto.setAmt_bal(accDto.getAmt_bal());
			preAmountDto.setAmt_available_act(accDto.getAmt_available());
			FDouble amtLimit = BlAccountUtil.calcAccBalance(accDto, warnDO);
			preAmountDto.setAmt_available_check(amtLimit);
			
			rlt.add(preAmountDto);
		}
		
		return rlt.toArray(new BlPrepayAmountDTO[0]);
	}
}
