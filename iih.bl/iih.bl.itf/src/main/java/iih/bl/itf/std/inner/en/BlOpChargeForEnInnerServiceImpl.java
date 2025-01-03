package iih.bl.itf.std.inner.en;

import iih.bl.itf.dto.regincinfo.d.RegIncDTO;
import iih.bl.itf.std.inner.en.bp.BlIsClinicRetNoBP;
import iih.bl.itf.std.inner.en.bp.BlOpChargeForEnRegPayBP;
import iih.bl.itf.std.inner.en.bp.BlOpChargeForEnRegPricingBP;
import iih.bl.itf.std.inner.en.bp.BlOpRegIncNoBP;
import iih.bl.itf.std.inner.en.bp.GetRegCgStatusBP;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPayDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPayRltDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPricingDTO;
import iih.bl.itf.std.inner.en.opregcharge.d.BlOpRegPricingRltDTO;
import xap.mw.core.data.BizException;

/**
 * 对就诊提供对外接口处理挂号收费业务
 * @author ly 2019/07/24
 *
 */
public class BlOpChargeForEnInnerServiceImpl implements IBlOpChargeForEnInnerService{

	/**
	 * 挂号划价
	 * @param dto 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/24
	 */
	@Override
	public BlOpRegPricingRltDTO regPricing(BlOpRegPricingDTO dto) throws BizException {
		BlOpChargeForEnRegPricingBP bp = new BlOpChargeForEnRegPricingBP();
		return bp.exec(dto);
	}

	/**
	 * 挂号收付款
	 * @param dto 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/24
	 */
	@Override
	public BlOpRegPayRltDTO regPay(BlOpRegPayDTO dto) throws BizException {
		BlOpChargeForEnRegPayBP bp = new BlOpChargeForEnRegPayBP();
		return bp.exec(dto);
	}

	/**
	 * 是否允许诊间退号
	 * @return
	 * @throws BizException
	 */
	@Override
	public Boolean isClinicRetNo(String entId) throws BizException {
		BlIsClinicRetNoBP bp = new BlIsClinicRetNoBP();
		return bp.exec(entId);
	}

	/**
	 * 获得有效就诊挂号的发票号接口
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegIncDTO getRegIncInfo(String entId) throws BizException {
		BlOpRegIncNoBP bp= new BlOpRegIncNoBP();
		return bp.exec(entId);
	}
	
	

	/**
	 * 挂号费记账状态
	 * @return
	 * @throws BizException
	 */
	@Override
	public int getRegCgStatus(String entId) throws BizException {
		GetRegCgStatusBP bp = new GetRegCgStatusBP();
		return bp.exec(entId);
	}
}
