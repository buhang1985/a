package iih.bl.cg.s.cglogic.validator;

import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 记账入参校验器
 * @author ly 2018/06/24 
 *
 */
public class BlCgAccParamValidator {

	private static final String ROWMSG = "第%s条数据：%s";
	
	private BlCgAccountSetDTO accSetDto;//记账配置
	private BlCgRefundAccountSetDTO rfdSetDto;//退记账配置
	
	public BlCgAccParamValidator(BlCgAccountSetDTO accSetDto){
		this.accSetDto = accSetDto;
	}
	
	public BlCgAccParamValidator(BlCgOpAccountSetDTO accSetDto){
		//门诊配置转住院配置，使用其中的一些属性
		this.accSetDto = new BlCgAccountSetDTO();
		this.accSetDto.setFg_price_cal(accSetDto.getFg_price_cal());
	}
	
	public BlCgAccParamValidator(BlCgRefundAccountSetDTO rfdSetDto){
		this.rfdSetDto = rfdSetDto;
	}
	
	/**
	 * 记账校验
	 * @param accDto 记账dto
	 * @param num 条数
	 * @throws BizException
	 */
	public void validateCharge(BlCgAccountDTO accDto,int num,FBoolean fgZeroCg) throws BizException{
		
		if(StringUtil.isEmpty(accDto.getId_ent())){
			throw new BizException(String.format(ROWMSG, num, "就诊id为空"));
		}
		
		if(StringUtil.isEmpty(accDto.getId_pat())){
			throw new BizException(String.format(ROWMSG, num, "患者id为空"));
		}
		
		if(StringUtil.isEmpty(accDto.getId_srv())){
			throw new BizException(String.format(ROWMSG, num, "医疗服务id为空"));
		}
		
		if(StringUtil.isEmpty(accDto.getId_or()) && !StringUtil.isEmpty(accDto.getId_orsrv())){
			throw new BizException(String.format(ROWMSG, num, "医嘱服务id有值，医嘱id不能为空"));
		}
		
		if(accDto.getEu_direct() == null || 
				(accDto.getEu_direct() != BookRtnDirectEnum.CHARGES 
				&& accDto.getEu_direct() != BookRtnDirectEnum.REFUND)){
			throw new BizException(String.format(ROWMSG, num, "记账方向不正确"));
		}
		
		if(accDto.getEu_direct() == BookRtnDirectEnum.REFUND){
			throw new BizException(String.format(ROWMSG, num, "记账接口暂不支持记负账，退费请调用退费接口"));
		}
		
		if(FBoolean.TRUE.equals(accDto.getFg_mm())){
			if(StringUtil.isEmpty(accDto.getId_mm())){
				throw new BizException(String.format(ROWMSG, num, "物品管理标识为true时,物品id不能为空"));
			}
			if(StringUtil.isEmpty(accDto.getId_pkgu_cur())){
				throw new BizException(String.format(ROWMSG, num, "物品管理标识为true时,物品单位不能为空"));
			}
			if(accDto.getPrice_std() == null || accDto.getPrice_ratio() == null 
					|| accDto.getRatio_pripat() == null){
				throw new BizException(String.format(ROWMSG, num, "物品管理标识为true时,金额及折扣率不能为空"));
			}
		}/*else{
			if(StringUtil.isEmpty(accDto.getId_unit_srv())){
				throw new BizException(String.format(ROWMSG, num, "物品管理标识为false时,服务单位不能为空"));
			}
		}*/
		
		if (FBoolean.FALSE.equals(this.accSetDto.getFg_price_cal())) {
			
			if (accDto.getPrice_std() == null) {
				throw new BizException(String.format(ROWMSG, num, "标准价不能为空"));
			}

			if (accDto.getPrice_ratio() == null) {
				throw new BizException(String.format(ROWMSG, num, "折扣价不能为空"));
			}

			if (accDto.getRatio_pripat() == null) {
				throw new BizException(String.format(ROWMSG, num, "折扣率不能为空"));
			}
			
			if(!FBoolean.TRUE.equals(accDto.getFg_free()) && FBoolean.FALSE.equals(fgZeroCg)){
				
				if (accDto.getPrice_std().compareTo(FDouble.ZERO_DBL) < 0) {
					throw new BizException(String.format(ROWMSG, num, "标准价不能小于0"));
				}

				if (accDto.getPrice_ratio().compareTo(FDouble.ZERO_DBL) < 0) {
					throw new BizException(String.format(ROWMSG, num, "折扣价不能小于0"));
				}

				if (accDto.getRatio_pripat().compareTo(FDouble.ZERO_DBL) < 0) {
					throw new BizException(String.format(ROWMSG, num, "折扣率不能小于0"));
				}
			}
		}
		
		if(accDto.getQuan() == null){
			throw new BizException(String.format(ROWMSG, num, "数量不能为空"));
		}else if(accDto.getQuan().compareTo(FDouble.ZERO_DBL) <= 0){
			throw new BizException(String.format(ROWMSG, num, "数量不能小于等于0"));
		}
	}
	
	/**
	 * 记账校验(门诊)
	 * @param accDto
	 * @param num
	 * @throws BizException
	 */
	public void validateChargeOep(BlCgAccountDTO accDto,int num,FBoolean fgZeroCg) throws BizException{
		
		if(StringUtil.isEmpty(accDto.getId_pat())){
			throw new BizException(String.format(ROWMSG, num, "患者id为空"));
		}
		
		if(StringUtil.isEmpty(accDto.getId_srv())){
			throw new BizException(String.format(ROWMSG, num, "医疗服务id为空"));
		}
		
		if(StringUtil.isEmpty(accDto.getId_or()) && !StringUtil.isEmpty(accDto.getId_orsrv())){
			throw new BizException(String.format(ROWMSG, num, "医嘱服务id不为空时，医嘱id不能为空"));
		}
		
		if(StringUtil.isEmpty(accDto.getId_orsrv()) && !StringUtil.isEmpty(accDto.getId_or_pr())){
			throw new BizException(String.format(ROWMSG, num, "医嘱执行id不为空时，医嘱服务id不能为空"));
		}
		
		if(accDto.getEu_direct() == null || 
				(accDto.getEu_direct() != BookRtnDirectEnum.CHARGES 
				&& accDto.getEu_direct() != BookRtnDirectEnum.REFUND)){
			throw new BizException(String.format(ROWMSG, num, "记账方向不正确"));
		}
		
		if(accDto.getEu_direct() == BookRtnDirectEnum.REFUND){
			throw new BizException(String.format(ROWMSG, num, "记账接口暂不支持记负账，退费请调用退费接口"));
		}
		
		if(FBoolean.TRUE.equals(accDto.getFg_mm())){
			if(StringUtil.isEmpty(accDto.getId_mm())){
				throw new BizException(String.format(ROWMSG, num, "物品管理标识为true时,物品id不能为空"));
			}
			if(StringUtil.isEmpty(accDto.getId_pkgu_cur())){
				throw new BizException(String.format(ROWMSG, num, "物品管理标识为true时,物品单位不能为空"));
			}
			if(StringUtil.isEmpty(accDto.getId_orsrv())){
				throw new BizException(String.format(ROWMSG, num, "物品管理标识为true时,医嘱服务id不能为空"));
			}
		}
		
		if (FBoolean.FALSE.equals(this.accSetDto.getFg_price_cal())) {
			if (accDto.getPrice_std() == null) {
				throw new BizException(String.format(ROWMSG, num, "标准价不能为空"));
			}

			if (accDto.getPrice_ratio() == null) {
				throw new BizException(String.format(ROWMSG, num, "折扣价不能为空"));
			}

			if (accDto.getRatio_pripat() == null) {
				throw new BizException(String.format(ROWMSG, num, "折扣率不能为空"));
			}
			
			if(!FBoolean.TRUE.equals(accDto.getFg_free()) && FBoolean.FALSE.equals(fgZeroCg)){
				
				if (accDto.getPrice_std().compareTo(FDouble.ZERO_DBL) < 0) {
					throw new BizException(String.format(ROWMSG, num, "标准价不能小于0"));
				}

				if (accDto.getPrice_ratio().compareTo(FDouble.ZERO_DBL) < 0) {
					throw new BizException(String.format(ROWMSG, num, "折扣价不能小于0"));
				}

				if (accDto.getRatio_pripat().compareTo(FDouble.ZERO_DBL) < 0) {
					throw new BizException(String.format(ROWMSG, num, "折扣率不能小于0"));
				}
			}
		}
		
		if(accDto.getQuan() == null){
			throw new BizException(String.format(ROWMSG, num, "数量不能为空"));
		}else if(accDto.getQuan().compareTo(FDouble.ZERO_DBL) <= 0){
			throw new BizException(String.format(ROWMSG, num, "数量不能小于等于0"));
		}
	}
	
	/**
	 * 退记账入参校验
	 * @param rfdDto
	 * @param num
	 * @throws BizException
	 */
	public void validateRefund(BlCgRefundAccountDTO rfdDto,int num) throws BizException{
		
		if (StringUtil.isEmpty(rfdDto.getId_ent())) {
			throw new BizException(String.format(ROWMSG, num, "就诊id为空"));
		}
		
		if(RefundModeEnum.CG_KEY.equals(this.rfdSetDto.getEu_rfdmode()) && StringUtil.isEmpty(rfdDto.getId_cg())){
			throw new BizException(String.format(ROWMSG, num, "记账主键退费模式，记账主键不能为空"));
		}else if(RefundModeEnum.PRSRV_KEY.equals(this.rfdSetDto.getEu_rfdmode()) && StringUtil.isEmpty(rfdDto.getId_or_prsrv())){
			throw new BizException(String.format(ROWMSG, num, "执行计划主键退费模式，执行计划主键不能为空"));
		}else if(RefundModeEnum.ORSRV_KEY.equals(this.rfdSetDto.getEu_rfdmode()) && StringUtil.isEmpty(rfdDto.getId_orsrv())){
			throw new BizException(String.format(ROWMSG, num, "医嘱服务主键退费模式，医嘱服务主键不能为空"));
		}
		
		if(rfdDto.getQuan() == null || FDouble.ZERO_DBL.compareTo(rfdDto.getQuan()) > 0){
			throw new BizException(String.format(ROWMSG, num, "退数量为空或小于0"));
		}
	}
	
	/**
	 * 退记账入参校验(门诊)
	 * @param rfdDto
	 * @param num
	 * @throws BizException
	 */
	public void validateRefundOep(BlCgRefundAccountDTO rfdDto,int num) throws BizException{
		
		if(RefundModeEnum.CG_KEY.equals(this.rfdSetDto.getEu_rfdmode()) && StringUtil.isEmpty(rfdDto.getId_cg())){
			throw new BizException(String.format(ROWMSG, num, "记账主键退费模式，记账主键不能为空"));
		}else if(RefundModeEnum.PRSRV_KEY.equals(this.rfdSetDto.getEu_rfdmode()) && StringUtil.isEmpty(rfdDto.getId_or_prsrv())){
			throw new BizException(String.format(ROWMSG, num, "执行计划主键退费模式，执行计划主键不能为空"));
		}else if(RefundModeEnum.ORSRV_KEY.equals(this.rfdSetDto.getEu_rfdmode()) && StringUtil.isEmpty(rfdDto.getId_orsrv())){
			throw new BizException(String.format(ROWMSG, num, "医嘱服务主键退费模式，医嘱服务主键不能为空"));
		}else if(RefundModeEnum.SUSP_KEY.equals(this.rfdSetDto.getEu_rfdmode()) && StringUtil.isEmpty(rfdDto.getId_cg())){
			throw new BizException(String.format(ROWMSG, num, "挂起主键退费模式，挂起记账主键不能为空"));
		}
		
		if(rfdDto.getQuan() == null || FDouble.ZERO_DBL.compareTo(rfdDto.getQuan()) > 0){
			throw new BizException(String.format(ROWMSG, num, "退数量为空或小于0"));
		}
	}
}
