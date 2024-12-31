package iih.bl.itf.std.inner.en.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.comm.util.BlDataUtil;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPricingDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPricingItmDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPricingRltDTO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSetDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePricingSelfInParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePricingSelfOutParamDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 挂号划价
 * @author ly 2019/07/24
 *
 */
public class BlOpChargeForEnRegPricingBP {

	/**
	 * 挂号划价
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlOpRegPricingRltDTO exec(BlOpRegPricingDTO dto) throws BizException {
		
		this.validate(dto);
		
		BlOpRegPricingRltDTO priRltDto = new BlOpRegPricingRltDTO();
		
		//取消挂起数据  TODO	
		IBlOepChargeCmdService chargeService = ServiceFinder.find(IBlOepChargeCmdService.class);
		chargeService.cancelPricingByPatId(dto.getId_pat());
		//划价
		this.oepPricing(dto);

		List<BlCgItmOepDO> cgList = (List<BlCgItmOepDO>)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_PRICING_CG);
		BlStOepDO stDO = (BlStOepDO)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_PRICING_ST);
		
		//处理医保
		if(!StringUtil.isEmpty(dto.getId_hp())){
			MiOepChargePricingSelfOutParamDTO hpData = this.dealHp(dto, stDO, cgList);
			if(hpData != null){
				priRltDto.setHpregisterinfo(hpData.getStr_hpregister());
				priRltDto.setHpdetailuploadinfo(hpData.getStr_detailupload());
				priRltDto.setHpprestinfo(hpData.getStr_hpprest());
			}
		}
		
		//设置返回值
		this.setRtnData(priRltDto, stDO, cgList);
		
		return priRltDto;
	}
	
	/**
	 * 参数校验
	 * @param dto
	 * @throws BizException
	 */
	private void validate(BlOpRegPricingDTO dto) throws BizException {
	
		if(StringUtil.isEmpty(dto.getId_pat())){
			throw new ArgumentNullException("挂号划价", "患者id");
		}
			
		if(StringUtil.isEmpty(dto.getId_patca())){
			throw new ArgumentNullException("挂号划价", "患者分类id");
		}
		
		if(StringUtil.isEmpty(dto.getId_pripat())){
			throw new ArgumentNullException("挂号划价", "患者价格分类id");
		}
	
		if(dto.getDetail() == null || dto.getDetail().size() <= 0){
			throw new ArgumentNullException("挂号划价", "明细数据");
		}
		
		for (int i = 0; i < dto.getDetail().size(); i++) {
			
			BlOpRegPricingItmDTO pricingItm = (BlOpRegPricingItmDTO)dto.getDetail().get(i);
			
			if(StringUtil.isEmpty(pricingItm.getId_srv())){
				throw new ArgumentNullException("挂号划价", "明细数据-服务id");
			}
			
			if(pricingItm.getQuan() == null){
				throw new ArgumentNullException("挂号划价", "明细数据-数量");
			}
			
			if(pricingItm.getQuan().compareTo(FDouble.ZERO_DBL) <= 0){
				throw new BizException("挂号划价:明细数据数量小于0");
			}
		}
	}
	
	/**
	 * 划价处理
	 * @param dto
	 * @throws BizException
	 */
	private void oepPricing(BlOpRegPricingDTO dto) throws BizException {
		
		//划价
		BlOepChargeSetDTO chargeSet = new BlOepChargeSetDTO();
		chargeSet.setId_pat(dto.getId_pat());
		chargeSet.setId_patca(dto.getId_patca());
		chargeSet.setId_hp(dto.getId_hp());
		chargeSet.setEu_srctp(FeeOriginEnum.ENCOUNTER_FEE);
		
		List<BlOepChargePricingDTO> pricingList = new ArrayList<BlOepChargePricingDTO>();
		for (int i = 0; i < dto.getDetail().size(); i++) {
			
			BlOpRegPricingItmDTO pricingItm = (BlOpRegPricingItmDTO)dto.getDetail().get(i);
			
			BlOepChargePricingDTO pricingDto = new BlOepChargePricingDTO();
			pricingDto.setId_pat(dto.getId_pat());
			pricingDto.setId_paticate(dto.getId_patca());
			pricingDto.setId_pripat(dto.getId_pripat());
			pricingDto.setId_srv(pricingItm.getId_srv());
			pricingDto.setQuan(pricingItm.getQuan());
			if(!StringUtil.isEmpty(pricingItm.getId_dep_or())){
				pricingDto.setId_dep_or(pricingItm.getId_dep_or());
			}else{
				pricingDto.setId_dep_or(Context.get().getDeptId());
			}
			if(!StringUtil.isEmpty(pricingItm.getId_emp_or())){
				pricingDto.setId_emp_or(pricingItm.getId_emp_or());
			}else{
				pricingDto.setId_emp_or(Context.get().getStuffId());
			}
			
			pricingDto.setId_dep_mp(pricingItm.getId_dep_or());
			pricingDto.setEu_direct(BookRtnDirectEnum.CHARGES);
			pricingDto.setEu_srctp(FeeOriginEnum.ENCOUNTER_FEE);
			
			pricingList.add(pricingDto);
		}
		
		//划价
		IBlOepChargeCmdService chargeService = ServiceFinder.find(IBlOepChargeCmdService.class);
		chargeService.pricing(pricingList.toArray(new BlOepChargePricingDTO[0]), chargeSet);
	}
	
	/**
	 * 处理医保
	 * @param dto
	 * @param stDO
	 * @param cgList
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MiOepChargePricingSelfOutParamDTO dealHp(BlOpRegPricingDTO dto, BlStOepDO stDO, List<BlCgItmOepDO> cgList) throws BizException {
		
		MiOepChargePricingSelfInParamDTO inParam = new MiOepChargePricingSelfInParamDTO();
		inParam.setId_pat(dto.getId_pat());
		inParam.setStr_hpcard(dto.getHpcardinfo());
		
		FArrayList cgFList = new FArrayList();
		FArrayList stFList = new FArrayList();		
		cgFList.addAll(cgList);
		stFList.add(stDO);

		inParam.setCgtiminfo(cgFList);
		inParam.setStinfo(stFList);
		
		InsureContext insContext = new InsureContext();
		insContext.setIdHp(dto.getId_hp());
		
		InsureFacade insFacade = new InsureFacade(insContext);
		ResultOutParamDTO<MiOepChargePricingSelfOutParamDTO> rlt = insFacade.oepPricingSelf(inParam);
		
		if(FBoolean.FALSE.equals(rlt.getFg_deal()))
			return null;
		
		if(FBoolean.FALSE.equals(rlt.getFg_HpSuccess())){
			throw new BizException("医保划价处理失败："+ rlt.getErrorMsg());
		}
		
		return rlt.getData();
	}

	/**
	 * 设置返回值
	 * @param priRltDto
	 * @param stDO
	 * @param cgList
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setRtnData(BlOpRegPricingRltDTO priRltDto,BlStOepDO stDO,List<BlCgItmOepDO> cgList) throws BizException {
		
		priRltDto.setId_stoep(stDO.getId_stoep());
		priRltDto.setCode_st(stDO.getCode_st());
		priRltDto.setAmt(stDO.getAmt_ratio());
		
		BlcgoepAggDO[] cgAggDos = BlDataUtil.getOepCgAggDataByItm(cgList.toArray(new BlCgItmOepDO[0]));
		
		FArrayList cgFList = new FArrayList();
		FArrayList stFList = new FArrayList();
		
		cgFList.addAll(Arrays.asList(cgAggDos));
		stFList.add(stDO);
		
		priRltDto.setCgdetail(cgFList);
		priRltDto.setStdetail(stFList);
	}
}
