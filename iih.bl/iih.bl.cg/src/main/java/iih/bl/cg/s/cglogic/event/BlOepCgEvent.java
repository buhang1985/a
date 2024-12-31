package iih.bl.cg.s.cglogic.event;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOepEventDTO;
import iih.bl.cg.dto.cglogic.d.BlCgOpAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
/**
 * 门诊记账事件
 * @author zhangxin
 * @date 2019年8月2日
 */
public class BlOepCgEvent {
	/**
	 * 门诊记账事件
	 * @param 
	 * @throws BizException
	 */
	public static void invokeAccount(BlCgAccountRltDTO blCgAccountRltDto,BlCgOpAccountSetDTO accSetDto) throws BizException{
		BlCgOepEventDTO cgOepDto = new BlCgOepEventDTO();
		//记账明细
		cgOepDto.setCglist(blCgAccountRltDto.getCglist());
		//记账模式
		cgOepDto.setEu_oepcgmode(accSetDto.getEu_oepcgmode());
		//是否成功
		cgOepDto.setFg_success(blCgAccountRltDto.getFg_success());
		BusinessEvent event = new BusinessEvent(
				IBlEventConst.EVENT_SOURCE_OP_CG,
				IBlEventConst.EVENT_TYPE_OPCG_CHARGE, cgOepDto);
		EventDispatcher.fireEvent(event);
	}
	/**
	 * 门诊退记账事件
	 * @param blCgAccountRltDto
	 * @param accSetDto
	 * @throws BizException
	 */
	public static void invokeCancAccount(BlCgAccountRltDTO blCgAccountRltDto,BlCgRefundAccountSetDTO accSetDto) throws BizException{
		BlCgOepEventDTO cgOepDto = new BlCgOepEventDTO();
		//记账明细
		cgOepDto.setCglist(blCgAccountRltDto.getCglist());
		//记账模式
		cgOepDto.setEu_oepcgmode(accSetDto.getEu_rfdmode());
		//是否成功
		cgOepDto.setFg_success(blCgAccountRltDto.getFg_success());
		BusinessEvent event = new BusinessEvent(
				IBlEventConst.EVENT_SOURCE_OP_CG,
				IBlEventConst.EVENT_TYPE_OPCG_CANC_CHARGE, cgOepDto);
		EventDispatcher.fireEvent(event);
	}
}
