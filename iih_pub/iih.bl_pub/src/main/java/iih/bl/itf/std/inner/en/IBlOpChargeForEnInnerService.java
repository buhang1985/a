package iih.bl.itf.std.inner.en;

import iih.bl.itf.dto.regincinfo.d.RegIncDTO;
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
public interface IBlOpChargeForEnInnerService {

	/**
	 * 挂号划价
	 * @param dto 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/24
	 */
	public abstract BlOpRegPricingRltDTO regPricing(BlOpRegPricingDTO dto) throws BizException;
	
	/**
	 * 挂号收付款
	 * @param dto 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/24
	 */
	public abstract BlOpRegPayRltDTO regPay(BlOpRegPayDTO dto) throws BizException;
	
	/**
	 * 是否允许诊间退号
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean isClinicRetNo(String entId) throws BizException;
	
	/**
	 * 获得有效就诊挂号的发票号接口
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public abstract RegIncDTO getRegIncInfo(String entId)throws BizException;
	
	/**
	 * 挂号费记账状态
	 * @return
	 * @throws BizException
	 */
	public abstract int getRegCgStatus(String entId) throws BizException;
}
