package iih.bl.cg.blcgoep.s.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.dto.accsrvrelat.d.AccSrvRelatDTO;
import iih.bd.pp.i.IBdPpQryService;
import iih.bd.pp.i.external.provide.IBdPpBlQryService;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.params.BlParams;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 门诊记账表插入前规则
 * 1.处理核算项目分类赋值
 * 2.账单项赋值
 * @author ly 2018/05/14
 *         ly 2018/09/22补充开单科室，开单人
 *         ly 2018/10/30补充记账科室，记账人
 *         ly 2018/11/02账单项处理
 *         ly 2018/11/07补充就诊科室
 *         ly 2019/11/04添加票号票据号相关处理
 *
 */
public class BlCgOepItemInsertBefRule implements IRule<BlcgoepAggDO> {

	@Override
	public void process(BlcgoepAggDO... aggDos) throws BizException {
		
		int itmNum = 0;
		List<String> incSrvIdList = new ArrayList<String>();//有账单信息则不再获取
		List<String> accSrvIdList = new ArrayList<String>();//有核算信息则不再获取
		List<String> entIdList = new ArrayList<String>();
		for (BlcgoepAggDO aggDO : aggDos) {
			BlCgOepDO cgOep =aggDO.getParentDO();
			for (BlCgItmOepDO itm : aggDO.getBlCgItmOepDO()) {
				if(cgOep.getEu_direct() == 1 && StringUtil.isEmpty(itm.getCode_cg_itm())){					
					itmNum++;
				}				
				//设置开单科室开单人
				if(StringUtil.isEmpty(itm.getId_dep_or())){
					itm.setId_dep_or(Context.get().getDeptId());
				}
				if(StringUtil.isEmpty(itm.getId_emp_or())){
					itm.setId_emp_or(Context.get().getStuffId());
				}
				
				if(StringUtil.isEmpty(itm.getCode_inccaitm()) && !incSrvIdList.contains(itm.getId_srv())){
					incSrvIdList.add(itm.getId_srv());
				}
				
				if(StringUtil.isEmpty(itm.getCode_account()) && !accSrvIdList.contains(itm.getId_srv())){
					accSrvIdList.add(itm.getId_srv());
				}
				
				if(!StringUtil.isEmpty(itm.getId_ent()) && !entIdList.contains(itm.getId_ent())){
					entIdList.add(itm.getId_ent());
				}
			}
			
			BlCgOepDO cgOepDO = aggDO.getParentDO();
			if(StringUtil.isEmpty(cgOepDO.getId_dep_cg())){
				cgOepDO.setId_dep_cg(Context.get().getDeptId());
			}
			if(StringUtil.isEmpty(cgOepDO.getId_emp_cg())){
				cgOepDO.setId_emp_cg(Context.get().getStuffId());
			}
		}
		
		//取得账单关系
		Map<String,IncCaItmRelDO> incMap = this.getIncItmRelat(incSrvIdList.toArray(new String[0]),IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE);
		//取得核算关系
		Map<String,AccSrvRelatDTO> relMap = this.getAcSrvRelat(accSrvIdList.toArray(new String[0]));
		
		Map<String,PatiVisitDO> entMap = this.getEnData(entIdList.toArray(new String[0]));
		
		//挂号票据账单关系
		Map<String,IncCaItmRelDO> incRegMap = new HashMap<String,IncCaItmRelDO>();
		
		String regInccaCode = BlParams.BLINC0026();
		if(IBdPpCodeTypeConst.SD_OUTREGISTER_INVIOCE.equals(regInccaCode)){
			
			Set<String> regSrvSet = new HashSet<String>();
			for (BlcgoepAggDO aggDO : aggDos) {
				for (BlCgItmOepDO itm : aggDO.getBlCgItmOepDO()) {
						if(StringUtil.isEmpty(itm.getCode_inccaitm()) && FeeOriginEnum.ENCOUNTER_FEE.equals(itm.getEu_srctp())){
							regSrvSet.add(itm.getId_srv());
						}
				}
			}
			if(regSrvSet.size() > 0){
				incRegMap = this.getIncItmRelat(regSrvSet.toArray(new String[0]), IBdPpCodeTypeConst.SD_OUTREGISTER_INVIOCE);
			}
		}
		
		GetCodeByCustomization rule = new GetCodeByCustomization();
		String[] cgItmCodes = null;
		if(itmNum > 0){
			cgItmCodes = rule.GetCgItmOepCodes(itmNum);
		}
		boolean isNotEmpTy = cgItmCodes != null && cgItmCodes.length > 0;
		for (BlcgoepAggDO aggDO : aggDos) {
			BlCgOepDO cgOep =aggDO.getParentDO();
			for (BlCgItmOepDO itm : aggDO.getBlCgItmOepDO()) {
				
				if(isNotEmpTy && cgOep.getEu_direct() == 1 && StringUtil.isEmpty(itm.getCode_cg_itm())){					
					itm.setCode_cg_itm(cgItmCodes[--itmNum]);
				}
				
				
				if(StringUtil.isEmpty(itm.getCode_inccaitm())){
					
					if(IBdPpCodeTypeConst.SD_OUTREGISTER_INVIOCE.equals(regInccaCode) && 
							FeeOriginEnum.ENCOUNTER_FEE.equals(itm.getEu_srctp())){
						IncCaItmRelDO incRelDO = incRegMap.get(itm.getId_srv());
						if(incRelDO != null){
							itm.setCode_inccaitm(incRelDO.getInccaitm_code());
							itm.setName_inccaitm(incRelDO.getInccaitm_name());
						}
					}else{
						IncCaItmRelDO incRelDO = incMap.get(itm.getId_srv());
						if(incRelDO != null){
							itm.setCode_inccaitm(incRelDO.getInccaitm_code());
							itm.setName_inccaitm(incRelDO.getInccaitm_name());
						}
					}
				}
				
				if(StringUtil.isEmpty(itm.getCode_account())){
					AccSrvRelatDTO accRelDto = relMap.get(itm.getId_srv());
					if(accRelDto != null){
						itm.setCode_account(accRelDto.getCode_acc());
						itm.setName_account(accRelDto.getName_acc());
					}
				}
				
				if(!StringUtil.isEmpty(itm.getId_ent())){
					PatiVisitDO entDO = entMap.get(itm.getId_ent());
					if(entDO != null){
						itm.setId_dep_phy(entDO.getId_dep_phy());
						itm.setId_emp_phy(entDO.getId_emp_phy());
					}
				}
			}
		}
	}
	
	/**
	 * 取得核算关系
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	private Map<String,AccSrvRelatDTO> getAcSrvRelat(String[] srvIds) throws BizException {
		
		Map<String,AccSrvRelatDTO> map = new HashMap<String,AccSrvRelatDTO>();
		if(ArrayUtil.isEmpty(srvIds))
			return map;
		
		IBdPpQryService ppQryService = ServiceFinder.find(IBdPpQryService.class);
		AccSrvRelatDTO[] relDtos = ppQryService.getAccSrvRelat(srvIds, IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		if(ArrayUtil.isEmpty(relDtos)){
			return map;
		}
		
		for (AccSrvRelatDTO dto : relDtos) {
			map.put(dto.getId_srv(), dto);
		}
		
		return map;
	}
	
	/**
	 * 获取票据分类对照
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	private Map<String, IncCaItmRelDO> getIncItmRelat(String[] srvIds,String inccaCode) throws BizException {
		
		Map<String,IncCaItmRelDO> map = new HashMap<String,IncCaItmRelDO>();
		if(ArrayUtil.isEmpty(srvIds))
			return map;
		
		IBdPpBlQryService rService = ServiceFinder.find(IBdPpBlQryService.class);
		IncCaItmRelDO[] dos = rService.findCaItmRelBySrv(inccaCode, srvIds);
	
		if(ArrayUtil.isEmpty(dos)){
			return map;
		}
		
		for (IncCaItmRelDO itmDO : dos) {
			map.put(itmDO.getId_srv(), itmDO);
		}
		
		return map;
	}

	/**
	 * 获取就诊数据
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, PatiVisitDO> getEnData(String[] entIds) throws BizException {
		
		Map<String, PatiVisitDO> map = new HashMap<String, PatiVisitDO>();
		if(ArrayUtil.isEmpty(entIds))
			return map;
		
		DAFacade daf = new DAFacade();
		List<PatiVisitDO> rlt = (List<PatiVisitDO>)daf.findByPKs(PatiVisitDO.class, entIds, new String[] {
				PatiVisitDO.ID_ENT, PatiVisitDO.ID_EMP_PHY, PatiVisitDO.ID_DEP_PHY });
		
		for (PatiVisitDO patiVisitDO : rlt) {
			map.put(patiVisitDO.getId_ent(), patiVisitDO);
		}
		
		return map;
	}
}
