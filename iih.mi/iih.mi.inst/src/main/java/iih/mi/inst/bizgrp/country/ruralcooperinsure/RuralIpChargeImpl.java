package iih.mi.inst.bizgrp.country.ruralcooperinsure;

import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.inst.bizbase.IpChargeBaseImpl;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.bp.RuralBackHpPropDataSaveBp;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.bp.RuralGetPropDataBp;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.bp.RuralHpPayPropArDataSaveBp;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.bp.RuralHpPropDataSaveBp;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.bp.RuralPayBackPropDataSaveBp;
import iih.mi.inst.bizgrp.country.ruralcooperinsure.bp.RuralUpdateTmpPropDataBp;
import iih.mi.itf.bizgrpitf.IpChargeItf;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

public class RuralIpChargeImpl extends IpChargeBaseImpl implements IpChargeItf {

	/**新农合保存医保的分摊数据
	 * @return 分摊保存数据
	 * @throws BizException
	 */
	@Override
	public FArrayList saveHpPropTmpData(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException {
		RuralHpPropDataSaveBp handlerBp=new RuralHpPropDataSaveBp();
		return handlerBp.exec(hpPayRtnValDto,hisPropertyDTO);
	}
	/**新农合保存医保分摊的红冲数据
	 * @return
	 * @throws BizException
	 */
	public FArrayList saveBackHpPropTmpData(HisPropertyRefHpDTO hisPropertyDTO) throws BizException{
		RuralBackHpPropDataSaveBp handlerBp=new RuralBackHpPropDataSaveBp();
		return handlerBp.exec(hisPropertyDTO);
	}
	
	/** 新农合获取医保分摊数据
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 * @Date 2018-04-23
	 * @author yangyang
	 */
	public FArrayList getHpPropDataTmp(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		RuralGetPropDataBp handlerBp=new RuralGetPropDataBp();
		return handlerBp.exec(hisPropertyDTO);
	}
	
	/** 新农合保存收付款分摊信息（常规流程）
	 * @return 保存得分摊结果
	 * @throws BizException
	 * @date 2018-04-26
	 */
	public FArrayList savePayPropData(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException{
		RuralHpPayPropArDataSaveBp handlerBp=new RuralHpPayPropArDataSaveBp();
		return handlerBp.exec(hpPayRtnValDto, hisPropertyDTO);
	}
	
	public FArrayList saveBackPayPropData(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		RuralPayBackPropDataSaveBp handlerBp=new RuralPayBackPropDataSaveBp();
		return handlerBp.exec(hpPayRtnValDto, hisPropertyDTO);
	}
	/**
	 * 更新新农合前置医保分摊关联his主键
	 */
	@Override
	public FArrayList updateTmpPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException {
		RuralUpdateTmpPropDataBp handlerBp=new RuralUpdateTmpPropDataBp();
		return handlerBp.exec(hisPropertyDTO);
	}
}
