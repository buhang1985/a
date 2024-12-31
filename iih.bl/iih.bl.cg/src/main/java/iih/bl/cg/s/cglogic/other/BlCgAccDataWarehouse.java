package iih.bl.cg.s.cglogic.other;

import iih.bd.base.utils.MapUtils;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.bdprewarn.d.BdPreWarnDO;
import iih.bd.pp.dto.prisrvcompratio.d.BdPriSrvCompRatioDTO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.dto.cglogic.d.BlCgApplyDTO;
import iih.bl.params.BlParams;
import iih.bl.st.blauditip.d.BlAuditIp;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.d.EnPeCmpyACCDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import iih.pi.reg.pat.d.PatDO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 记账相关数据仓库
 * 
 * @author ly 2018/06/26
 *
 */
public class BlCgAccDataWarehouse {

	// 患者数据
	private List<PatDO> patList;
	
	// 患者数据map型 key:id_pat
	private Map<String, PatDO> patMap;

	// 就诊数据
	private List<PatiVisitDO> enList;

	// 就诊数据map型 key:id_ent
	private Map<String, PatiVisitDO> enMap;
	
	// 就诊新生儿记录
	private List<NewbornDO> nbList;
	
	// 就诊新生儿记录型 key:id_ent 婴儿就诊
	private Map<String, NewbornDO> nbMap;

	// 患者账户数据
	private List<PiPatAccDO> patAccList;
	
	// 患者账户数据 key:id_pat
	private Map<String, PiPatAccDO> patAccMap;
	
	// 患者账户余额数据
	private List<PatRelAmountInfoDTO> patBalanceList;

	// 患者账户余额数据 key:id_pat
	private Map<String, PatRelAmountInfoDTO> patBalanceMap;
	
	// 账户数据
	private List<EnAccountDO> accList;

	// 账户数据map型 key:id_ent
	private Map<String, EnAccountDO> accMap;

	// 账户金额数据
	private List<BalanceDTO> balanceList;

	// 账户金额map型 key:id_ent
	private Map<String, BalanceDTO> balanceMap;

	// 团检账户
	private List<EnPeCmpyACCDO> peaccList;
	
	// 团检账户map型 key:id_pecmpy
	private Map<String, EnPeCmpyACCDO> peaccMap;

	// 团检账户金额数据
	private List<BalanceDTO> pebalanceList;
	
	// 团检账户金额数据map型 key:id_pecmpy
	private Map<String, BalanceDTO> pebalanceMap;
	
	// 就诊团检关系
	private Map<String,String> entPeMap;

	// 医嘱数据
	private List<CiOrderDO> orList;

	// 医嘱数据map型 key:id_or
	private Map<String, CiOrderDO> orMap;

	// 医嘱服务数据
	private List<OrdSrvDO> orsrvList;

	// 医嘱服务数据map型 key:id_orsrv
	private Map<String, OrdSrvDO> orsrvMap;

	// 医嘱服务药品数据
	private List<OrdSrvMmDO> orsrvmmList;
	
	// 医嘱服务药品map型 key:id_orsrv
	private Map<String, OrdSrvMmDO> orsrvmmMap;
		
	// 医疗服务
	private List<MedSrvDO> srvList;

	// 医疗服务数据map型 key:id_srv
	private Map<String, MedSrvDO> srvMap;
	
	// 物品数据
	private List<MeterialDO> mmList;

	// 物品数据map型 key:id_mm
	private Map<String, MeterialDO> mmMap;

	// 住院费用审核
	private List<BlAuditIp> auditList;

	// 住院费用审核map key:id_ent
	private Map<String, BlAuditIp> auditMap;
	
	// 票据分类项目对照
	private List<IncCaItmRelDO> caItmRelList;

	// 票据分类项目对照 key:id_srv
	private Map<String, IncCaItmRelDO> caItmRelMap;
	
	// 门诊挂号票据分类项目(门诊挂号流程专用)
	private List<IncCaItmRelDO> caItmRelRegList;
	
	// 门诊挂号票据分类项目(门诊挂号流程专用) key:id_srv
	private Map<String, IncCaItmRelDO> caItmRelRegMap;

	// 个人消费金额 key:id_ent
	private Map<String, FDouble> personalConsumeMap;
	
	// 个人团体消费金额 key:id_ent
	private Map<String, FDouble> groupConsumeMap;
	
	// 就诊医保数据
	private List<EntHpDO> entHpList;
	
	// 就诊医保map型 key:id_ent
	private Map<String,EntHpDO> entHpMap;
	
	// 对照map key:hpid+srvid+mmid value:对照数据
	private Map<String,ThreeDirCompInfoDTO> hpCompMap;

	// 单据信息 key:id_key(id_or 或者 id_orsrv)
	private Map<String, BlCgApplyDTO> applyMap;
	
	// 组合计价特殊比例数据 key(id_srv+id_srv_bl)
	private Map<String, BdPriSrvCompRatioDTO> compRatioMap;
	
	// 婴儿使用母亲账户 参数BLSTIP0026
	private FBoolean fgBabyUseMomAcc;
	
	// 住院审核期间，是否允许修改费用明细 参数BLSTIP0022
	private FBoolean fgCanAccWhenAudit;
	
	// 门诊计价模式  参数BLSTOEP0016
	private String oepCgMode;

	// 退记账模式-->0:负数冲账 1:红冲剩余记正数
	private String refundMode;
	
	// 预交金控制策略
	private BdPreWarnDO[] warnDos;
	
	// 门诊挂号打印的发票分类 参数BLINC0026
	private String regInccaCode;
	
	// 是否允许使用0元价格BLCG0040
	private FBoolean fgZeroCg;

	/**
	 * 构造
	 */
	public BlCgAccDataWarehouse() {
		this.patMap = new HashMap<String, PatDO>();
		this.enMap = new HashMap<String, PatiVisitDO>();
		this.nbMap = new HashMap<String, NewbornDO>();
		this.patAccMap = new HashMap<String, PiPatAccDO>();
		this.patBalanceMap = new HashMap<String, PatRelAmountInfoDTO>();
		this.accMap = new HashMap<String, EnAccountDO>();
		this.balanceMap = new HashMap<String, BalanceDTO>();
		this.peaccMap = new HashMap<String, EnPeCmpyACCDO>();
		this.pebalanceMap = new HashMap<String, BalanceDTO>();
		this.entPeMap = new HashMap<String,String>();
		this.orMap = new HashMap<String, CiOrderDO>();
		this.orsrvMap = new HashMap<String, OrdSrvDO>();
		this.orsrvmmMap = new HashMap<String, OrdSrvMmDO>();
		this.srvMap = new HashMap<String,MedSrvDO>();
		this.mmMap = new HashMap<String, MeterialDO>();
		this.auditMap = new HashMap<String, BlAuditIp>();
		this.personalConsumeMap = new HashMap<String, FDouble>();
		this.groupConsumeMap = new HashMap<String, FDouble>();
		this.entHpMap = new HashMap<String, EntHpDO>();
		this.hpCompMap = new HashMap<String, ThreeDirCompInfoDTO>();
		this.applyMap = new HashMap<String, BlCgApplyDTO>();
		this.compRatioMap = new HashMap<String, BdPriSrvCompRatioDTO>();
		this.refundMode = "0";
	}

	/**
	 * 加载门诊参数
	 */
	public void loadOepParam(){
		this.oepCgMode = BlParams.BLSTOEP0016();
		this.regInccaCode = BlParams.BLINC0026();
		this.fgZeroCg = BlParams.BLCG0040();
	}
	
	/**
	 * 加载住院参数
	 */
	public void loadIpParam(){
		this.refundMode = BlParams.BLCG0029();
		this.fgBabyUseMomAcc = BlParams.BLSTIP0026();
		this.fgCanAccWhenAudit = BlParams.BLSTIP0022();
		this.fgZeroCg = BlParams.BLCG0040();
	}
	
	/**
	 * 处理母婴账户数据
	 */
	public void handleMomBabyAcc() {
		if(!FBoolean.TRUE.equals(this.fgBabyUseMomAcc))
			return;
		
		if(ListUtil.isEmpty(nbList))
			return;
		
		for (NewbornDO nbDO : nbList) {
		
			//替换母亲账户,可用额度,审核数据
			EnAccountDO momAccDO = this.accMap.get(nbDO.getId_ent_mom());
			BalanceDTO balanceDto = this.balanceMap.get(nbDO.getId_ent_mom());
			BlAuditIp auditDO = this.auditMap.get(nbDO.getId_ent_mom());
			
			if(momAccDO != null){
				this.accMap.put(nbDO.getId_ent_bb(), momAccDO);
			}
			if(balanceDto != null){
				this.balanceMap.put(nbDO.getId_ent_bb(), balanceDto);
			}
			if(auditDO != null){
				this.auditMap.put(nbDO.getId_ent_bb(), auditDO);
			}
		}
	}
	
    /**
     * 统计消费金额
     * @param entId 就诊id
     * @param amt 金额
     * @param fgUtitPay 是否单位支付
     */
	public void countConsume(String entId, FDouble amt, FBoolean fgUtitPay) {
		
		if(FBoolean.TRUE.equals(fgUtitPay)){	
			FDouble old = this.groupConsumeMap.get(entId);
			this.groupConsumeMap.put(entId, old== null ? amt : old.add(amt));
		}else{
			FDouble old = this.personalConsumeMap.get(entId);
			this.personalConsumeMap.put(entId, old== null ? amt : old.add(amt));
		}
	}
	
	/**
	 * 加载对照数据
	 * @param hpId
	 * @param compDtos
	 */
	public void loadHpCompData(String hpId, ThreeDirCompInfoDTO[] compDtos){
		
		for (ThreeDirCompInfoDTO compDto : compDtos) {
			String key = hpId + (StringUtil.isEmpty(compDto.getId_drug()) ? 
					compDto.getId_srv() : compDto.getId_drug());
			
			this.hpCompMap.put(key, compDto);
		}
	}
	
	/** ↓↓↓↓↓ getter setter ↓↓↓↓↓ **/

	/**
	 * @return the patList
	 */
	public List<PatDO> getPatList() {
		return patList;
	}

	/**
	 * @param patList
	 *            the patList to set
	 */
	public void setPatList(List<PatDO> patList) {
		this.patList = patList;
		if (ListUtil.isEmpty(this.patList)) {
			this.patMap = new HashMap<String, PatDO>();
		} else {
			this.patMap = (Map<String, PatDO>) MapUtils.convertListToMap(
					this.patList, PatDO.ID_PAT);
		}
	}
	
	/**
	 * @return the enList
	 */
	public List<PatiVisitDO> getEnList() {
		return enList;
	}

	/**
	 * @param enList
	 *            the enList to set
	 */
	public void setEnList(List<PatiVisitDO> enList) {
		this.enList = enList;
		if (ListUtil.isEmpty(this.enList)) {
			this.enMap = new HashMap<String, PatiVisitDO>();
		} else {
			this.enMap = (Map<String, PatiVisitDO>) MapUtils.convertListToMap(
					this.enList, PatiVisitDO.ID_ENT);
		}
	}
	
	/**
	 * @return the nbList
	 */
	public List<NewbornDO> getNbList() {
		return nbList;
	}

	/**
	 * @param nbList the nbList to set
	 */
	public void setNbList(List<NewbornDO> nbList) {
		this.nbList = nbList;
		if (ListUtil.isEmpty(this.nbList)) {
			this.nbMap = new HashMap<String, NewbornDO>();
		} else {
			this.nbMap = (Map<String, NewbornDO>) MapUtils.convertListToMap(
					this.nbList, NewbornDO.ID_ENT_BB);
		}
	}

	
	/**
	 * @return the patAccList
	 */
	public List<PiPatAccDO> getPatAccList() {
		return patAccList;
	}

	/**
	 * @param patAccList
	 */
	public void setPatAccList(List<PiPatAccDO> patAccList) {
		this.patAccList = patAccList;
		if (ListUtil.isEmpty(this.patAccList)) {
			this.patAccMap = new HashMap<String, PiPatAccDO>();
		} else {
			this.patAccMap = (Map<String, PiPatAccDO>) MapUtils.convertListToMap(
					this.patAccList, PiPatAccDO.ID_PAT);
		}
	}
	
	/**
	 * @return the patBalanceList
	 */
	public List<PatRelAmountInfoDTO> getPatBalanceList() {
		return patBalanceList;
	}

	/**
	 * @param patBalanceList
	 */
	public void setPatBalanceList(List<PatRelAmountInfoDTO> patBalanceList) {
		this.patBalanceList = patBalanceList;
		if (ListUtil.isEmpty(this.patBalanceList)) {
			this.patBalanceMap = new HashMap<String, PatRelAmountInfoDTO>();
		} else {
			this.patBalanceMap = (Map<String, PatRelAmountInfoDTO>) MapUtils.convertListToMap(
					this.patBalanceList, PatDO.ID_PAT);
		}
	}

	/**
	 * @return the accList
	 */
	public List<EnAccountDO> getAccList() {
		return accList;
	}

	/**
	 * @param accList
	 *            the accList to set
	 */
	public void setAccList(List<EnAccountDO> accList) {
		this.accList = accList;
		if (ListUtil.isEmpty(this.accList)) {
			this.accMap = new HashMap<String, EnAccountDO>();
		} else {
			this.accMap = (Map<String, EnAccountDO>) MapUtils.convertListToMap(
					this.accList, EnAccountDO.ID_ENT);
		}
	}

	/**
	 * @return the balanceList
	 */
	public List<BalanceDTO> getBalanceList() {
		return balanceList;
	}

	/**
	 * @param balanceList
	 *            the balanceList to set
	 */
	public void setBalanceList(List<BalanceDTO> balanceList) {
		this.balanceList = balanceList;
		if (ListUtil.isEmpty(this.balanceList)) {
			this.balanceMap = new HashMap<String, BalanceDTO>();
		} else {
			this.balanceMap = (Map<String, BalanceDTO>) MapUtils.convertListToMap(
					this.balanceList, "Id_ent");
		}
	}

	/**
	 * @return the peaccList
	 */
	public List<EnPeCmpyACCDO> getPeaccList() {
		return peaccList;
	}

	/**
	 * @param peaccList
	 *            the peaccList to set
	 */
	public void setPeaccList(List<EnPeCmpyACCDO> peaccList) {
		this.peaccList = peaccList;
		if (ListUtil.isEmpty(this.peaccList)) {
			this.peaccMap = new HashMap<String, EnPeCmpyACCDO>();
		} else {
			this.peaccMap = (Map<String, EnPeCmpyACCDO>) MapUtils.convertListToMap(
					this.peaccList, EnPeCmpyACCDO.ID_PECMPY);
		}
	}

	/**
	 * @return the pebalanceList
	 */
	public List<BalanceDTO> getPebalanceList() {
		return pebalanceList;
	}

	/**
	 * @param pebalanceList
	 *            the pebalanceList to set
	 */
	public void setPebalanceList(List<BalanceDTO> pebalanceList) {
		this.pebalanceList = pebalanceList;
		if (ListUtil.isEmpty(this.pebalanceList)) {
			this.pebalanceMap = new HashMap<String, BalanceDTO>();
		} else {
			this.pebalanceMap = (Map<String, BalanceDTO>) MapUtils.convertListToMap(
					this.pebalanceList, "Id_pecmpy");
		}
	}

	/**
	 * @return the orList
	 */
	public List<CiOrderDO> getOrList() {
		return orList;
	}

	/**
	 * @param orList
	 *            the orList to set
	 */
	public void setOrList(List<CiOrderDO> orList) {
		this.orList = orList;
		if (ListUtil.isEmpty(this.orList)) {
			this.orMap = new HashMap<String, CiOrderDO>();
		} else {
			this.orMap = (Map<String, CiOrderDO>) MapUtils.convertListToMap(
					this.orList, CiOrderDO.ID_OR);
		}
	}

	/**
	 * @return the orsrvList
	 */
	public List<OrdSrvDO> getOrsrvList() {
		return orsrvList;
	}

	/**
	 * @param orsrvList
	 *            the orsrvList to set
	 */
	public void setOrsrvList(List<OrdSrvDO> orsrvList) {
		this.orsrvList = orsrvList;
		if (ListUtil.isEmpty(this.orsrvList)) {
			this.orsrvMap = new HashMap<String, OrdSrvDO>();
		} else {
			this.orsrvMap = (Map<String, OrdSrvDO>) MapUtils.convertListToMap(
					this.orsrvList, OrdSrvDO.ID_ORSRV);
		}
	}

	/**
	 * @return the orsrvmmList
	 */
	public List<OrdSrvMmDO> getOrsrvmmList() {
		return orsrvmmList;
	}

	/**
	 * @param orsrvmmList the orsrvmmList to set
	 */
	public void setOrsrvmmList(List<OrdSrvMmDO> orsrvmmList) {
		this.orsrvmmList = orsrvmmList;
		if (ListUtil.isEmpty(this.orsrvmmList)) {
			this.orsrvmmMap = new HashMap<String, OrdSrvMmDO>();
		} else {
			this.orsrvmmMap = (Map<String, OrdSrvMmDO>) MapUtils.convertListToMap(
					this.orsrvmmList, OrdSrvMmDO.ID_ORSRV);
		}
	}
	
	/**
	 * @return the srvList
	 */
	public List<MedSrvDO> getSrvList() {
		return srvList;
	}

	/**
	 * @param srvList
	 *            the srvList to set
	 */
	public void setSrvList(List<MedSrvDO> srvList) {
		this.srvList = srvList;
		if (ListUtil.isEmpty(this.srvList)) {
			this.srvMap = new HashMap<String, MedSrvDO>();
		} else {
			this.srvMap = (Map<String, MedSrvDO>) MapUtils.convertListToMap(
					this.srvList, MedSrvDO.ID_SRV);
		}
	}

	/**
	 * @return the mmList
	 */
	public List<MeterialDO> getMmList() {
		return mmList;
	}

	/**
	 * @param mmList
	 *            the mmList to set
	 */
	public void setMmList(List<MeterialDO> mmList) {
		this.mmList = mmList;
		if (ListUtil.isEmpty(this.mmList)) {
			this.mmMap = new HashMap<String, MeterialDO>();
		} else {
			this.mmMap = (Map<String, MeterialDO>) MapUtils.convertListToMap(
					this.mmList, MeterialDO.ID_MM);
		}
	}

	/**
	 * @return the auditList
	 */
	public List<BlAuditIp> getAuditList() {
		return auditList;
	}

	/**
	 * @param auditList
	 *            the auditList to set
	 */
	public void setAuditList(List<BlAuditIp> auditList) {
		this.auditList = auditList;
		if (ListUtil.isEmpty(this.auditList)) {
			this.auditMap = new HashMap<String, BlAuditIp>();
		} else {
			this.auditMap = (Map<String, BlAuditIp>) MapUtils.convertListToMap(
					this.auditList, BlAuditIp.ID_ENT);
		}
	}
	
	/**
	 * @return the caItmRelList
	 */
	public List<IncCaItmRelDO> getCaItmRelList() {
		return caItmRelList;
	}

	/**
	 * @param caItmRelList the caItmRelList to set
	 */
	public void setCaItmRelList(List<IncCaItmRelDO> caItmRelList) {
		this.caItmRelList = caItmRelList;
		if (ListUtil.isEmpty(this.caItmRelList)) {
			this.caItmRelMap = new HashMap<String, IncCaItmRelDO>();
		} else {
			this.caItmRelMap = (Map<String, IncCaItmRelDO>) MapUtils.convertListToMap(
					this.caItmRelList, IncCaItmRelDO.ID_SRV);
		}
	}
	
	/**
	 * @return the caItmRelRegList
	 */
	public List<IncCaItmRelDO> getCaItmRelRegList() {
		return caItmRelRegList;
	}

	/**
	 * 
	 * @param caItmRelRegList the caItmRelRegList to set
	 */
	public void setCaItmRelRegList(List<IncCaItmRelDO> caItmRelRegList) {
		this.caItmRelRegList = caItmRelRegList;
		if(ListUtil.isEmpty(this.caItmRelRegList)){
			this.caItmRelRegMap = new HashMap<String, IncCaItmRelDO>();
		}else{
			this.caItmRelRegMap = (Map<String, IncCaItmRelDO>)MapUtils.convertListToMap(
					this.caItmRelRegList, IncCaItmRelDO.ID_SRV);
		}
	}
	
	/**
	 * @return the entHpList
	 */
	public List<EntHpDO> getEntHpList() {
		return entHpList;
	}

	/**
	 * @param entHpList the entHpList to set
	 */
	public void setEntHpList(List<EntHpDO> entHpList) {
		this.entHpList = entHpList;
		if (ListUtil.isEmpty(this.entHpList)) {
			this.entHpMap = new HashMap<String, EntHpDO>();
		} else {
			this.entHpMap = (Map<String, EntHpDO>) MapUtils.convertListToMap(
					this.entHpList, EntHpDO.ID_ENT);
		}
		
	}

	/**
	 * @return the fgCombineBabyAndMom
	 */
	public FBoolean getFgCombineMomBaby() {
		return fgBabyUseMomAcc;
	}
	
	/**
	 * @return the patMap
	 */
	public Map<String, PatDO> getPatMap() {
		return patMap;
	}
	
	/**
	 * @return the enMap
	 */
	public Map<String, PatiVisitDO> getEnMap() {
		return enMap;
	}

	/**
	 * @return the nbMap
	 */
	public Map<String, NewbornDO> getNbMap() {
		return nbMap;
	}
	
	/**
	 * @return the entPeMap
	 */
	public Map<String, String> getEntPeMap() {
		return entPeMap;
	}

	/**
	 * @param entPeMap the entPeMap to set
	 */
	public void setEntPeMap(Map<String, String> entPeMap) {
		if(entPeMap == null){
			this.entPeMap = new HashMap<String,String>();
		}else{
			this.entPeMap = entPeMap;
		}
	}
	
	/**
	 * @return the patAccMap
	 */
	public Map<String, PiPatAccDO> getPatAccMap() {
		return patAccMap;
	}
	
	/**
	 * @return the patBalanceMap
	 */
	public Map<String, PatRelAmountInfoDTO> getPatBalanceMap() {
		return patBalanceMap;
	}
	
	/**
	 * @return the accMap
	 */
	public Map<String, EnAccountDO> getAccMap() {
		return accMap;
	}
	
	/**
	 * @return the peaccMap
	 */
	public Map<String, EnPeCmpyACCDO> getPeaccMap() {
		return peaccMap;
	}

	/**
	 * @return the pebalanceMap
	 */
	public Map<String, BalanceDTO> getPebalanceMap() {
		return pebalanceMap;
	}

	/**
	 * @return the balanceMap
	 */
	public Map<String, BalanceDTO> getBalanceMap() {
		return balanceMap;
	}
	
	/**
	 * @return the orMap
	 */
	public Map<String, CiOrderDO> getOrMap() {
		return orMap;
	}

	/**
	 * @return the orsrvMap
	 */
	public Map<String, OrdSrvDO> getOrsrvMap() {
		return orsrvMap;
	}
	
	/**
	 * @return the orsrvmmMap
	 */
	public Map<String, OrdSrvMmDO> getOrsrvmmMap() {
		return orsrvmmMap;
	}

	/**
	 * @return the srvMap
	 */
	public Map<String, MedSrvDO> getSrvMap() {
		return srvMap;
	}

	/**
	 * @return the mmMap
	 */
	public Map<String, MeterialDO> getMmMap() {
		return mmMap;
	}

	/**
	 * @return the auditMap
	 */
	public Map<String, BlAuditIp> getAuditMap() {
		return auditMap;
	}
	
	/**
	 * @return the caItmRelMap
	 */
	public Map<String, IncCaItmRelDO> getCaItmRelMap() {
		return caItmRelMap;
	}
	
	/**
	 * @return the caItmRelRegMap
	 */
	public Map<String, IncCaItmRelDO> getCaItmRelRegMap() {
		return caItmRelRegMap;
	}
	
	/**
	 * @return the personalConsumeMap
	 */
	public Map<String, FDouble> getPersonalConsumeMap() {
		return personalConsumeMap;
	}

	/**
	 * @return the groupConsumeMap
	 */
	public Map<String, FDouble> getGroupConsumeMap() {
		return groupConsumeMap;
	}
	
	/**
	 * @return the entHpMap
	 */
	public Map<String, EntHpDO> getEntHpMap() {
		return entHpMap;
	}
	
	/**
	 * @return the hpCompMap
	 */
	public Map<String, ThreeDirCompInfoDTO> getHpCompMap() {
		return hpCompMap;
	}
	
	/**
	 * add item to applyMap
	 * @param dtos
	 */
	public void addItmToApplyMap(BlCgApplyDTO[] dtos){
		for (BlCgApplyDTO blCgApplyDTO : dtos) {
			this.applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
		}
	}
	
	/**
	 * @return the applyMap
	 */
	public Map<String, BlCgApplyDTO> getApplyMap() {
		return applyMap;
	}
	
	/**
	 * @return the fgCanAccWhenAudit
	 */
	public FBoolean getFgCanAccWhenAudit() {
		return fgCanAccWhenAudit;
	}
	
	/**
	 * @return the refundMode
	 */
	public String getRefundMode() {
		return refundMode;
	}
	
	/**
	 * @return the oepCgMode
	 */
	public String getOepCgMode() {
		return oepCgMode;
	}
	
	/**
	 * @return warnDos
	 */
	public BdPreWarnDO[] getWarnDos() {
		return warnDos;
	}

	/**
	 * @param warnDos
	 */
	public void setWarnDos(BdPreWarnDO[] warnDos) {
		this.warnDos = warnDos;
	}
	
	/**
	 * @return the regInccaCode
	 */
	public String getRegInccaCode() {
		return regInccaCode;
	}
	
	/**
	 * @return the fgZeroCg
	 */
	public FBoolean getFgZeroCg() {
		return fgZeroCg;
	}

	/**
	 * @return compRatioMap
	 */
	public Map<String, BdPriSrvCompRatioDTO> getCompRatioMap() {
		return compRatioMap;
	}

	/**
	 * @param compRatioList
	 */
	public void setCompRatioMap(List<BdPriSrvCompRatioDTO> compRatioList) {
		if(ListUtil.isEmpty(compRatioList))
			return;
		
		for (BdPriSrvCompRatioDTO compRatioDto : compRatioList) {
			String key = compRatioDto.getId_srv() + compRatioDto.getId_srv_bl();
			this.compRatioMap.put(key, compRatioDto);
		}
	}
}
