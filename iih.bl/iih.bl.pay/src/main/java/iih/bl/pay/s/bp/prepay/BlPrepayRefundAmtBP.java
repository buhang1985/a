package iih.bl.pay.s.bp.prepay;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import iih.bd.base.exception.ArgumentNullException;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.dto.prepay.d.BlPrepayCDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.s.bp.util.PrepayAssembleUtil;

/**
 * 
 * 预交金退消费(直接金额消费)
 * @author ly 2018/12/21
 *
 */
public class BlPrepayRefundAmtBP  extends BlPrepayBaseBP{
	
	public BlPrepayRefundAmtBP(BlPrepaySetDTO setDto) {
		super(setDto);
	}
	
	/**
	 * 预交金退消费(直接金额消费)
	 * @param dto 消费数据
	 * @param setDto 配置数据
	 * @return 预交金DO
	 * @throws BizException
	 */
	public BlPrePayPatDO exec(BlPrepayCDTO dto) throws BizException { 
		
		this.validate(dto);
		
		super.analysisAccType(dto.getId_pat(), dto.getId_ent(), dto.getId_pecmpy());
		
		BlPrePayPatDO prepayDO = PrepayAssembleUtil.assembleAmtConsume(dto, this.accType, BookRtnDirectEnum.CHARGE);
		prepayDO = cudService.insert(new BlPrePayPatDO[]{prepayDO})[0];
		
		if(FBoolean.TRUE.equals(this.setDto.getFg_accupdate())){
			super.chargeAcc(prepayDO.getAmt().multiply(prepayDO.getEu_direct()));
		}
		
		return prepayDO;
	}
	
	/**
	 * 校验
	 * @param dto
	 * @throws BizException
	 */
	private void validate(BlPrepayCDTO dto) throws BizException{
		
		if(dto == null){
			throw new ArgumentNullException("预交金消费", "消费数据");
		}
		
		if(StringUtil.isEmpty(dto.getId_pat()) 
				&& StringUtil.isEmpty(dto.getId_ent()) 
				&& StringUtil.isEmpty(dto.getId_pecmpy())){
			throw new BizException("预交金消费:确定类型的字段至少一个需要有值:患者id,就诊id,团检id");
		}
		
		if(dto.getAmt() == null || dto.getAmt().compareTo(FDouble.ZERO_DBL) <= 0){
			throw new BizException("预交金消费:消费金额不能小于等于0");
		}
	}
}
