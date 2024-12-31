package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.SVCheckUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlCgFuncConst;
import iih.bl.comm.IBlConst;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.comm.IBlImplicitParamKeyConst;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSetDTO;
import iih.bl.st.s.bp.oepcharge.util.BlOepChargeDataUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.lock.PKLock;

/**
 * 
 * 门诊划价
 * @author ly 2018/12/04
 *
 */
public class BlOepChargePricingBP {

	private static final String LOCK_KEY = "pricing_lock_";
	
	/**
	 * 门诊划价(新逻辑)
	 * 支持记账与未记账数据同时划价
	 * 与原逻辑不同点：不生成发票数据
	 * @param dtos 待划价数据
	 * @return 划价结果
	 * @throws BizException
	 */
	public BlOepChargePricingRltDTO[] exec(BlOepChargePricingDTO[] dtos, BlOepChargeSetDTO chargeSet) throws BizException{
		
		// 入参校验
		this.validate(dtos, chargeSet);
		if(!StringUtil.isEmpty(chargeSet.getId_emp_charge())){
			Context.get().setStuffId(chargeSet.getId_emp_charge());
		}
		
		String lockKey = LOCK_KEY + chargeSet.getId_pat();
		boolean lock = PKLock.getInstance().addDynamicLock(lockKey, 0);
		if(!lock){
			throw new BizException("当前患者正在划价，请刷新重试");
		}
		
		String stId = new DBUtil().getOIDs(1)[0];//结算id
		
		//分组记账与非记账数据
		List<String> chargedList = new ArrayList<String>();
		List<BlOepChargePricingDTO> unChargeList = new ArrayList<BlOepChargePricingDTO>();
		for (BlOepChargePricingDTO pricingDto : dtos) {
			if(StringUtil.isEmpty(pricingDto.getId_cgitmoep())){
				unChargeList.add(pricingDto);
			}else{
				chargedList.add(pricingDto.getId_cgitmoep());
			}
		}
		
		//非记账数据调用划价逻辑
		List<BlCgItmOepDO> cgItmList = new ArrayList<BlCgItmOepDO>();
		if(unChargeList.size() > 0){
			BlCgItmOepDO[] cgItmDos = this.pricing(unChargeList, stId, chargeSet);
			cgItmList.addAll(Arrays.asList(cgItmDos));
		}
		
		//更新记账数据结算标识
		if(chargedList.size() > 0){
			BlCgItmOepDO[] cgItmDos = this.updateChargedSt(chargedList, stId);
			cgItmList.addAll(Arrays.asList(cgItmDos));
		}
		
		//生成结算数据
		BlStOepDO newStDO = this.createStData(cgItmList, chargeSet, stId);
		
		//设置流程数据
		Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_PRICING_CG, cgItmList);
		Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_PRICING_ST, newStDO);
		
		//设置返回值
		Map<String,BlCgItmOepDO> cgItmMap = (Map<String,BlCgItmOepDO>)MapUtils.convertListToMap(cgItmList, BlCgItmOepDO.ID_CGITMOEP);
		BlOepChargePricingRltDTO[] rltDtos = new BlOepChargePricingRltDTO[dtos.length];
		for (int i = 0; i < dtos.length; i++) {
			BlOepChargePricingDTO pricingDto = dtos[i];
			BlCgItmOepDO itmDO = cgItmMap.get(pricingDto.getId_cgitmoep());
			
			BlOepChargePricingRltDTO rltDto = new BlOepChargePricingRltDTO();
			rltDto.setId_cgitmoep(itmDO.getId_cgitmoep());
			rltDto.setId_orsrv(itmDO.getId_orsrv());
			rltDto.setId_srv(itmDO.getId_srv());
			rltDto.setId_stoep(itmDO.getId_stoep());
			rltDto.setPrice_ratio(itmDO.getPrice_ratio());
			rltDto.setPrice_std(itmDO.getPrice());
			rltDto.setQuan(itmDO.getQuan());
			rltDto.setAmt(itmDO.getAmt());
			rltDto.setAmt_std(itmDO.getAmt_std());
			rltDto.setAmt_ratio(itmDO.getAmt_ratio());
			rltDto.setAmt_pat(itmDO.getAmt_pat());
			rltDto.setAmt_hp(itmDO.getAmt_hp());
			rltDto.setCode_inccaitm(itmDO.getCode_inccaitm());
			rltDto.setName_inccaitm(itmDO.getName_inccaitm());
			rltDto.setCode_apply(itmDO.getCode_apply());
			
			rltDtos[i] = rltDto;
		}
		
		return rltDtos;
	}

	/**
	 * 入参校验
	 * @param dtos
	 * @param chargeSet
	 * @throws BizException
	 */
	private void validate(BlOepChargePricingDTO[] dtos, BlOepChargeSetDTO chargeSet) throws BizException{
		
		if(ArrayUtil.isEmpty(dtos) || chargeSet == null){
			throw new BizException("门诊划价:入参为空");
		}
		
		if(StringUtil.isEmpty(chargeSet.getId_pat())){
			throw new BizException("门诊划价:收费配置患者id为空");
		}
		
		Map<String, FDateTime> orSvMap = new HashMap<String, FDateTime>();
		for (BlOepChargePricingDTO dto : dtos) {
			
			if(StringUtil.isEmpty(dto.getId_pat())){
				throw new BizException("门诊划价:明细数据患者id为空");
			}
			
			if(!chargeSet.getId_pat().equals(dto.getId_pat())){
				throw new BizException("门诊划价:明细数据存在多患者");
			}
			
			if(!StringUtil.isEmpty(dto.getId_or()) && dto.getSv_or() != null){
				orSvMap.put(dto.getId_or(), dto.getSv_or());
			}
		}
		
		//校验sv
		if(orSvMap.size() > 0){
			boolean checkSv = SVCheckUtils.checkSv(orSvMap, new CiOrderDO());
			if(!checkSv){
				throw new BizException("医嘱数据已经被他人修改，请重新调入");
			}
		}
	}
	
	/**
	 * 未记账待划价数据有效性校验
	 * @param unChargeList
	 * @throws BizException
	 */
	private void unChargeEffeValidate(List<BlOepChargePricingDTO> unChargeList) throws BizException{
		
		List<String> orsrvList = new ArrayList<String>();
		for (BlOepChargePricingDTO dto : unChargeList) {
			if(!StringUtil.isEmpty(dto.getId_orsrv())){
				orsrvList.add(dto.getId_orsrv());
			}
		}
		
		if(orsrvList.size() == 0)
			return;
		
		String sql = "select count(1) from bl_cg_itm_oep where " + SqlUtils.getInSqlByIds("id_orsrv", orsrvList.toArray(new String[0]));
		
		DAFacade daf = new DAFacade();
		Integer cnt = (Integer)daf.execQuery(sql, new ColumnHandler());
		
		if(cnt > 0){
			throw new BizException("门诊划价:重复划价");
		}
	}
	
	/**
	 * 已记账待划价数据有效性校验
	 * @param chargedList
	 * @throws BizException
	 */
	private void chargeEffeValidate(List<BlCgItmOepDO> chargedList) throws BizException{
		
		for (BlCgItmOepDO itmDO : chargedList) {
			if(FBoolean.TRUE.equals(itmDO.getFg_susp())){
				throw new BizException("门诊划价:重复划价");
			}
		}
	}
	
	/**
	 * 未记账数据记账
	 * @param unChargeList
	 * @param stId
	 * @param chargeSet
	 * @return
	 * @throws BizException
	 */
	private BlCgItmOepDO[] pricing(List<BlOepChargePricingDTO> unChargeList, String stId, BlOepChargeSetDTO chargeSet) throws BizException{
		
		this.unChargeEffeValidate(unChargeList);
		
		BlCgOpAccountSetDTO accSet = new BlCgOpAccountSetDTO();
		accSet.setDt_cg(BlFlowContextUtil.getNowTime());
		accSet.setFg_price_cal(chargeSet.getFg_calprice());
		accSet.setFg_reserve(FBoolean.TRUE);
		accSet.setFg_exception(FBoolean.TRUE);
		accSet.setFg_updateor(FBoolean.FALSE);
		Object objSrcFunc = Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_SRCFUNC);
		String srcFunc = objSrcFunc == null ? IBlCgFuncConst.FUNC_OPBL_OPFEECOLLECT : objSrcFunc.toString();
		accSet.setSrcfunc_des(srcFunc);
		accSet.setEu_oepcgmode(OepCgModeEnum.SUSP_CG);
		accSet.setId_stoep(stId);
		accSet.setFg_pricing(FBoolean.TRUE);
		if(chargeSet.getEu_srctp() == null){
			accSet.setEu_srctp(FeeOriginEnum.ORDERS_FEE);
		}else{
			accSet.setEu_srctp(chargeSet.getEu_srctp());
		}
		
		
		List<BlCgAccountDTO> accDtoList = new ArrayList<BlCgAccountDTO>();
		for (BlOepChargePricingDTO chargeDto : unChargeList) {
			BlCgAccountDTO accDto = new BlCgAccountDTO();
			accDto.setId_pat(chargeDto.getId_pat());
			accDto.setId_ent(chargeDto.getId_ent());
			accDto.setId_or(chargeDto.getId_or());
			accDto.setId_orsrv(chargeDto.getId_orsrv());
			accDto.setId_srv(chargeDto.getId_srv());
			accDto.setId_mm(chargeDto.getId_mm());
			accDto.setFg_mm(chargeDto.getFg_mm());
			accDto.setId_unit_srv(chargeDto.getSrvu());
			accDto.setId_pkgu_cur(chargeDto.getSrvu());
			accDto.setQuan(chargeDto.getQuan());
			accDto.setPrice_std(chargeDto.getPrice());
			accDto.setPrice_ratio(chargeDto.getPrice_ratio());
			accDto.setRatio_pripat(chargeDto.getRatio_pripat());
			accDto.setEu_direct(BookRtnDirectEnum.CHARGES);
			accDto.setId_dep_or(chargeDto.getId_dep_or());
			accDto.setId_emp_or(chargeDto.getId_emp_or());
			accDto.setId_dep_mp(chargeDto.getId_dep_mp());
			accDto.setId_dep_wh(chargeDto.getId_dep_wh());
			accDto.setFg_addfee(chargeDto.getFg_addfee());
			accDto.setId_pripat(chargeDto.getId_pripat());
			accDto.setAttrVal(IBlImplicitParamKeyConst.BL_PECODE, chargeDto.getPecode());
			if (StringUtils.isNotEmpty(chargeSet.getId_hp())) {
				accDto.setId_hp(chargeSet.getId_hp());
			}
			accDtoList.add(accDto);
		}
		
		IBlCgAccountService accountService = ServiceFinder.find(IBlCgAccountService.class);
		BlCgAccountRltDTO accRlt = accountService.keepAccountForOp(accDtoList.toArray(new BlCgAccountDTO[0]), accSet);
		
		List<BlCgItmOepDO> cgItmList = new ArrayList<BlCgItmOepDO>();
		for (int i = 0; i < accRlt.getCglist().size(); i++) {
			BlcgoepAggDO cgAggDO = (BlcgoepAggDO)accRlt.getCglist().get(i);
			cgItmList.addAll(Arrays.asList(cgAggDO.getBlCgItmOepDO()));
		}
		
		//回写记账id TODO
		for (int i = 0; i < unChargeList.size(); i++) {
			unChargeList.get(i).setId_cgitmoep(cgItmList.get(i).getId_cgitmoep());
		}
		
		return cgItmList.toArray(new BlCgItmOepDO[0]);
	}

	/**
	 * 更新记账明细结算状态
	 * @param chargedList
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlCgItmOepDO[] updateChargedSt(List<String> chargedList, String stId) throws BizException{
	
		IBlCgItmOepDOCudService cudService = ServiceFinder.find(IBlCgItmOepDOCudService.class);
		List<BlCgItmOepDO> itmList = (List<BlCgItmOepDO>)new DAFacade().findByPKs(BlCgItmOepDO.class, chargedList.toArray(new String[0]));
		
		this.chargeEffeValidate(itmList);
		
		for (BlCgItmOepDO itmDO : itmList) {
			itmDO.setId_stoep(stId);
			itmDO.setFg_st(FBoolean.TRUE);
			itmDO.setDt_st(BlFlowContextUtil.getNowTime());
			itmDO.setFg_susp(FBoolean.TRUE);
			itmDO.setStatus(DOStatus.UPDATED);
		}
		
		return cudService.update(itmList.toArray(new BlCgItmOepDO[0]));
	}

	/**
	 * 新建结算数据
	 * @param cgItmList
	 * @param chargeSet
	 * @param stId
	 * @throws BizException
	 */
	private BlStOepDO createStData(List<BlCgItmOepDO> cgItmList, BlOepChargeSetDTO chargeSet, String stId) throws BizException{
		
		BlCgItmOepDO itmOepDO = null;//选择一条有就诊的数据
		for (BlCgItmOepDO itm : cgItmList) {
			if(!StringUtil.isEmpty(itm.getId_ent())){
				itmOepDO = itm;
				break;
			}
		}
		if(itmOepDO == null){
			itmOepDO = cgItmList.get(0);
		}
		
		//计算金额
		Set<String> pecodeSet = new HashSet<String>();
		FDouble amtStd = FDouble.ZERO_DBL;
		FDouble amtRatio = FDouble.ZERO_DBL;
		for (BlCgItmOepDO cgItmDO : cgItmList) {
			amtStd = amtStd.add(cgItmDO.getPrice().multiply(cgItmDO.getQuan(),IBlConst.PRECISION_AMOUNT));
			amtRatio = amtRatio.add(cgItmDO.getPrice_ratio().multiply(cgItmDO.getQuan(),IBlConst.PRECISION_AMOUNT));
			if(!StringUtil.isEmpty(cgItmDO.getPecode())){
				pecodeSet.add(cgItmDO.getPecode());
			}
		}
		
		BlStOepDO stDO = new BlStOepDO();
		stDO.setId_stoep(stId);
		stDO.setId_org(Context.get().getOrgId());
		stDO.setId_grp(Context.get().getGroupId());
		stDO.setId_pat(itmOepDO.getId_pat());
		stDO.setId_ent(itmOepDO.getId_ent());
		stDO.setId_enttp(itmOepDO.getId_enttp());
		stDO.setCode_enttp(itmOepDO.getCode_enttp());
		if(!StringUtil.isEmpty(chargeSet.getCode_st())){
			stDO.setCode_st(chargeSet.getCode_st());
		}else{
			stDO.setCode_st(BlCodeUtils.generateOepStCode());
		}
		stDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		stDO.setEu_sttp(BlOepChargeDataUtil.getStType(cgItmList.toArray(new BlCgItmOepDO[0])));
		stDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		stDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		stDO.setAmt(amtRatio);
		stDO.setAmt_pat(amtRatio);
		stDO.setAmt_std(amtStd);
		stDO.setAmt_hp(FDouble.ZERO_DBL);
		stDO.setAmt_ratio(amtRatio);
		stDO.setDt_st(BlFlowContextUtil.getNowTime());
		stDO.setId_dep_st(Context.get().getDeptId());
		stDO.setId_emp_st(Context.get().getStuffId());
		stDO.setFg_cc(FBoolean.FALSE);
		stDO.setFg_canc(FBoolean.FALSE);
		stDO.setFg_arclear(FBoolean.TRUE);
		stDO.setId_hp(chargeSet.getId_hp());
		stDO.setId_patca(chargeSet.getId_patca());
		stDO.setId_hpsttp(chargeSet.getId_hpsttp());
		stDO.setSd_hpsttp(chargeSet.getSd_hpsttp());
		stDO.setId_medkind(chargeSet.getId_medkind());
		if(pecodeSet.size() > 0){
			String pecode = "";
			for (String str : pecodeSet) {
				pecode += str + ",";
			}
			
			pecode = pecode.substring(0, pecode.length() - 1);
			stDO.setPecode(pecode);
		}
		
		stDO.setStatus(DOStatus.NEW);
		
		IBlstoepCudService stService = ServiceFinder.find(IBlstoepCudService.class);
		BlStOepDO newStDO = stService.insert(new BlStOepDO[] { stDO })[0];
		return newStDO;
	}
}
