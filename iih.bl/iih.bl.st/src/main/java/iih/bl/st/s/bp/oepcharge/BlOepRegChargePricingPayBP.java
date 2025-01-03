package iih.bl.st.s.bp.oepcharge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSetDTO;
import iih.bl.st.dto.bloepregcharge.d.BlOepRegChargePricingPayDTO;
import iih.bl.st.dto.bloepregcharge.d.BlOepRegChargePricingPayItmDTO;
import iih.bl.st.dto.bloepregcharge.d.BlOepRegChargePricingPayRltDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepPmDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRltDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/**
 * 门诊挂号划价收费一体化方法
 * @author ly 2019/07/16
 *
 */
public class BlOepRegChargePricingPayBP {

	/**
	 * 加锁key
	 */
	private static final String LOCK_KEY = "oepregpayment_lock_";
	
	/**
	 * 门诊挂号划价收费一体化方法--》暂时只处理单个挂号收费逻辑
	 * @param chargeDto 收费信息
	 * @param chargeItmDtos 费用明细信息
	 * @param payPmDtos 支付方式信息
	 * @return 收费结果
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlOepRegChargePricingPayRltDTO exec(BlOepRegChargePricingPayDTO chargeDto, BlOepRegChargePricingPayItmDTO[] chargeItmDtos, BlPayOepPmDTO[] payPmDtos) throws BizException{
		
		this.validatePayDto(chargeDto);
		
		this.validateDetail(chargeItmDtos);
		
		String entId = chargeItmDtos[0].getId_ent();
		String lockKey = LOCK_KEY + entId;
		boolean lock = PKLock.getInstance().addDynamicLock(lockKey, 0);
		if(!lock){
			throw new BizException("当前患者正在进行挂号收费操作，请稍后重试");
		}
		
		IBlOepChargeCmdService chargeService = ServiceFinder.find(IBlOepChargeCmdService.class);
		
		List<BlOepChargePricingDTO> pricingList = new ArrayList<BlOepChargePricingDTO>();
		for (BlOepRegChargePricingPayItmDTO payItmDto : chargeItmDtos) {
			BlOepChargePricingDTO pricingDto = this.assemblePricingDto(chargeDto, payItmDto);
			pricingList.add(pricingDto);
		}
		
		BlOepChargeSetDTO pricingSet = new BlOepChargeSetDTO();
		pricingSet.setId_pat(chargeDto.getId_pat());
		pricingSet.setId_hp(chargeDto.getId_hp());
		pricingSet.setId_patca(chargeDto.getId_patca());
		pricingSet.setFg_calprice(FBoolean.TRUE);
		pricingSet.setEu_srctp(FeeOriginEnum.ENCOUNTER_FEE);
		pricingSet.setCode_st(chargeDto.getCode_st());
		pricingSet.setId_emp_charge(chargeDto.getId_emp_pay());
		
		BlOepChargePricingRltDTO[] pricingRlt = chargeService.pricing(pricingList.toArray(new BlOepChargePricingDTO[0]), pricingSet);
		
		String stId = pricingRlt[0].getId_stoep();
		//收费
		BlPayOepDTO payoepDto = this.assemblePayDto(chargeDto, stId);
		List<BlPayOepPmDTO> pmList = new ArrayList<BlPayOepPmDTO>();
		pmList.addAll(Arrays.asList(payPmDtos));
		BlPayOepRltDTO payRlt = chargeService.oepPayment(payoepDto, pmList.toArray(new BlPayOepPmDTO[0]), null);
		
		//设置返回值
		BlOepRegChargePricingPayRltDTO rlt = new BlOepRegChargePricingPayRltDTO();
		rlt.setId_pat(chargeDto.getId_pat());
		FArrayList entIdList = new FArrayList();
		entIdList.add(entId);
		rlt.setId_ent(entIdList);
		rlt.setId_st(stId);
		rlt.setId_inc(payRlt.getId_inc());
		rlt.setId_cg(this.findCgHdIdList(stId));
		rlt.setId_hp(payRlt.getId_hp());
		rlt.setId_paypatoep(payRlt.getId_paypatoep());
		return rlt;
	}
	
	/**
	 * 校验收付款数据
	 * @param chargeDto
	 * @throws BizException
	 */
	private void validatePayDto(BlOepRegChargePricingPayDTO chargeDto) throws BizException{
		
		if(StringUtil.isEmpty(chargeDto.getId_pat())){
			throw new BizException("门诊挂号划价收费:患者id为空");
		}
		
		if(StringUtil.isEmpty(chargeDto.getId_patca())){
			throw new BizException("门诊挂号划价收费:患者分类id为空");
		}
		
		if(chargeDto.getAmt_pay() == null){
			throw new BizException("门诊挂号划价收费:付款金额是空");
		}
		
		if(StringUtil.isEmpty(chargeDto.getSd_pttp())){
			throw new BizException("门诊挂号划价收费:终端类型为空");
		}
		
		if(StringUtil.isEmpty(chargeDto.getId_emp_pay())){
			throw new BizException("门诊挂号划价收费:付款人员为空");
		}
	}
	
	/**
	 * 校验明细数据
	 * @param chargeItmDtos
	 * @throws BizException
	 */
	private void validateDetail(BlOepRegChargePricingPayItmDTO[] chargeItmDtos) throws BizException{
	
		for (BlOepRegChargePricingPayItmDTO chargeItm : chargeItmDtos) {
			
			if(StringUtil.isEmpty(chargeItm.getId_ent())){
				throw new BizException("门诊挂号划价收费:就诊id为空");
			}
			
			if(StringUtil.isEmpty(chargeItm.getId_srv())){
				throw new BizException("门诊挂号划价收费:服务id为空");
			}
			
			if(chargeItm.getQuan() == null || chargeItm.getQuan().compareTo(FDouble.ZERO_DBL) <= 0){
				throw new BizException("门诊挂号划价收费:服务数量需要大于0");
			}
		}
	}
	
	/**
	 * 组装划价数据
	 * @param payItmDto
	 * @return
	 */
	private BlOepChargePricingDTO assemblePricingDto(BlOepRegChargePricingPayDTO chargeDto, BlOepRegChargePricingPayItmDTO payItmDto){
		
		BlOepChargePricingDTO pricingDto = new BlOepChargePricingDTO();
		pricingDto.setId_pat(chargeDto.getId_pat());
		pricingDto.setId_ent(payItmDto.getId_ent());
		pricingDto.setFg_or(FBoolean.FALSE);
		pricingDto.setId_srv(payItmDto.getId_srv());
		pricingDto.setEu_direct(BookRtnDirectEnum.CHARGES);
		pricingDto.setQuan(payItmDto.getQuan());
		pricingDto.setPrice(payItmDto.getPrice_std());
		pricingDto.setRatio_pripat(payItmDto.getRatio_pripat());
		pricingDto.setPrice_ratio(payItmDto.getPrice_ratio());
		pricingDto.setId_dep_or(payItmDto.getId_dep_or());
		pricingDto.setId_emp_or(payItmDto.getId_emp_or());
		pricingDto.setId_dep_mp(payItmDto.getId_dep_mp());
		pricingDto.setEu_srctp(FeeOriginEnum.ENCOUNTER_FEE);
		pricingDto.setFg_mm(FBoolean.FALSE);
		pricingDto.setSrcfunc_des(chargeDto.getSrcfunc_des());
		pricingDto.setFg_or(FBoolean.FALSE);
		pricingDto.setDt_or(payItmDto.getDt_or());
		return pricingDto;
	}

	/**
	 * 组织支付数据
	 * @param chargeDto
	 * @param stId
	 * @return
	 */
	private BlPayOepDTO assemblePayDto(BlOepRegChargePricingPayDTO chargeDto,String stId){
		
		BlPayOepDTO payoepDto = new BlPayOepDTO();
		payoepDto.setId_pat(chargeDto.getId_pat());
		payoepDto.setId_patca(chargeDto.getId_patca());
		payoepDto.setId_st(stId);
		payoepDto.setAmt_pay(chargeDto.getAmt_pay());
		payoepDto.setIncno(chargeDto.getIncno());
		payoepDto.setSd_pttp(chargeDto.getSd_pttp());
		payoepDto.setFg_print(chargeDto.getFg_print());
		payoepDto.setId_emp_pay(chargeDto.getId_emp_pay());
		payoepDto.setId_hp(chargeDto.getId_hp());
		payoepDto.setAmt_all(chargeDto.getAmt_all());
		payoepDto.setAmt_hpall(chargeDto.getAmt_hpall());
		payoepDto.setAmt_hp(chargeDto.getAmt_hp());
		payoepDto.setAmt_psnacc(chargeDto.getAmt_psnacc());
		payoepDto.setAmt_cash(chargeDto.getAmt_cash());
		payoepDto.setAmt_diff(chargeDto.getAmt_diff());
		payoepDto.setAmt_hosbear(chargeDto.getAmt_hosbear());
		payoepDto.setCode_business(chargeDto.getCode_business());
		payoepDto.setOldpropdata(chargeDto.getOldpropdata());
		
		return payoepDto;
	}

	/**
	 * 查询记账主表主键
	 * @param idSt
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FArrayList findCgHdIdList(String stId) throws BizException{
		
		String sql = "select distinct id_cgoep from bl_cg_itm_oep where id_stoep = ? ";
		SqlParam param = new SqlParam();
		param.addParam(stId);
		
		DAFacade daf = new DAFacade();
		List<Object> cgIdList = (List<Object>)daf.execQuery(sql, param, new ColumnListHandler());
		
		FArrayList fList = new FArrayList();
		for (Object cgId : cgIdList) {
			fList.add(cgId.toString());
		}
		return fList;
	}
}
