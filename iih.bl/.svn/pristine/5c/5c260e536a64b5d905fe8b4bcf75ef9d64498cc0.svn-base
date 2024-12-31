package iih.bl.pay.s.bp;

import iih.bd.base.utils.MapUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bl.comm.IBlConst;
import iih.bl.comm.dto.d.BlPrepayWarnHitDTO;
import iih.bl.comm.util.BlAccountUtil;
import iih.bl.comm.util.BlPeCmpyUtil;
import iih.bl.comm.util.BlPrepayWarnUtil;
import iih.bl.params.BlParams;
import iih.bl.pay.dto.account.d.BlAccountDTO;
import iih.bl.pay.dto.d.PrePaidAccAmtDTO;
import iih.bl.pay.dto.d.PrePaidDTO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.out.i.IEn4BlQryService;
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
 * 
 * @author yang.lu 2018年6月26日
 *
 */
public class GetAccJugeIpByentIdsBP {

	/**
	 * 批量获取住院及团检预交金金额
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public PrePaidAccAmtDTO[] exec(String[] entIds) throws BizException {

		if (ArrayUtil.isEmpty(entIds)) {
			throw new BizException("无可用就诊编号！");
		}

		List<PrePaidAccAmtDTO> preList = new ArrayList<PrePaidAccAmtDTO>();
		// 获取就诊对应团检MAP
		Map<String, String> entpeMap = BlPeCmpyUtil.getEntsIsPecmpy(entIds);
		// 团检就诊信息
		List<String> pecmpyIdList = new ArrayList<String>();
		// 非团检就诊信息
		List<String> ipEntId = new ArrayList<String>();

		for (Map.Entry<String, String> entry : entpeMap.entrySet()) {
			if(!pecmpyIdList.contains(entry.getValue())){
				pecmpyIdList.add(entry.getValue());
			}	
		}
		
		for (String entId : entIds) {
			if(!entpeMap.containsKey(entId)){
				ipEntId.add(entId);
			}
		}

		// 批量获取住院团检数据
		if (pecmpyIdList.size() != 0) {

			String[] pmpIds = pecmpyIdList.toArray(new String[pecmpyIdList.size()]);
			IEn4BlQryService enService = ServiceFinder.find(IEn4BlQryService.class);
			BalanceDTO[] balDTOs = enService.getPeCmpyBalances(pmpIds);
			
			for (String key : entpeMap.keySet()) {
				
				String pecmpyId = entpeMap.get(key);
				if(StringUtil.isEmpty(pecmpyId))
					continue;
				
				if(balDTOs==null||balDTOs.length==0){
					continue;
				}
				
				for (BalanceDTO balDTO : balDTOs) {
					if(pecmpyId.equals(balDTO.getId_pecmpy())){
						FBoolean isArr = getIsArr(balDTO.getAmt_bal());
						preList.add(createPaidDTO(key,isArr, null, null, IBlConst.ACC_PATTP_PECMPY, balDTO.getAvailable(), balDTO.getAmt_prepay(), balDTO.getAmt_bal()));
						break;
					}
				}
			}
		}
		// 批量获取住院数据
		if (ipEntId.size() != 0) {
			/*IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
			BalanceDTO[] balDTOs = enService.getBalanceDTOs(ipEntId.toArray(new String[ipEntId.size()]));
			for (BalanceDTO balDTO : balDTOs) {
				FBoolean isArr = getIsArr(balDTO.getAmt_bal());
				preList.add(createPaidDTO(balDTO.getId_ent(),isArr, null, null, IBlConst.ACC_PATTP_PAT, balDTO.getAvailable(), balDTO.getAmt_prepay(), balDTO.getAmt_bal()));
			}*/
			
			PrePaidAccAmtDTO[] ipPaidAmtDtos = this.handleIp(ipEntId);
			preList.addAll(Arrays.asList(ipPaidAmtDtos));
		}
		return preList.toArray(new PrePaidAccAmtDTO[preList.size()]);
	}

	/**
	 * 获取是否欠费
	 * @param amtAccusble
	 * @return
	 */
	private FBoolean getIsArr(FDouble amtAccusble) {
		FBoolean isArr = FBoolean.FALSE;
		if (amtAccusble.toDouble() < 0) {
			isArr = FBoolean.TRUE;
		}
		return isArr;
	}

	/**
	 * 创建返回数据
	 * @param arrFg
	 * @param arsSd
	 * @param limit
	 * @param preSd
	 * @param amtAccusble
	 * @param amtAll
	 * @param amtBalance
	 * @return
	 */
	private PrePaidAccAmtDTO createPaidDTO(String id_ent,FBoolean arrFg, String arsSd, FDouble limit, String preSd, FDouble amtAvailable, FDouble amtPrepay, FDouble amtBal) {
		PrePaidAccAmtDTO retDto = new PrePaidAccAmtDTO();
		retDto.setId_ent(id_ent);
		retDto.setFg_arrears(arrFg);
		retDto.setSd_arslv(arsSd);
		retDto.setAmt_limit(limit);
		retDto.setSd_prewarntp(preSd);
		retDto.setAmt_prepay(amtPrepay);
		retDto.setAmt_bal(amtBal);
		retDto.setAmt_available(amtAvailable);
		return retDto;
	}

	/**
	 * 处理住院欠款策略
	 * @param entIdList
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private PrePaidAccAmtDTO[] handleIp(List<String> entIdList) throws BizException {
		
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
		
		//查询预交金配置数据
		BdPreWarnDO[] preWarnDos = BlPrepayWarnUtil.getPreWarnSetting(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		
		List<PrePaidAccAmtDTO> rlt = new ArrayList<PrePaidAccAmtDTO>();
		for (PatiVisitDO enDO : entList) {
			
			PrePaidAccAmtDTO paidAmtDto = new PrePaidAccAmtDTO();
			
			BlAccountDTO accDto = BlAccountUtil.convertToBlDto(balMap.get(enDO.getId_ent()));
			
			BlPrepayWarnHitDTO hitDto = new BlPrepayWarnHitDTO();
			hitDto.SetDepId(enDO.getId_dep_phy());
			hitDto.SetNurId(enDO.getId_dep_nur());
			hitDto.SetPatcaId(enDO.getId_patca());
			
			EntHpDO entHpDO = entHpMap.get(enDO.getId_ent());
			if(entHpDO != null){
				hitDto.SetHppatcaId(entHpDO.getId_hppatca());
			}
			
			BdPreWarnDO warnDO = BlPrepayWarnUtil.hitPreWarnSetting(preWarnDos, hitDto);
			PrePaidDTO paidDto = BlAccountUtil.calcArrearsGrade(accDto, warnDO);
			
			paidAmtDto.setId_ent(enDO.getId_ent());
			paidAmtDto.setFg_arrears(paidDto.getFg_arrears());
			paidAmtDto.setSd_arslv(paidDto.getSd_arslv());
			paidAmtDto.setAmt_limit(paidDto.getAmt_limit());
			paidAmtDto.setAmt_prepay(accDto.getAmt_prepay());
			paidAmtDto.setAmt_bal(accDto.getAmt_bal());
			paidAmtDto.setAmt_available(accDto.getAmt_available());
			rlt.add(paidAmtDto);
		}
		
		return rlt.toArray(new PrePaidAccAmtDTO[0]);
	}
}
