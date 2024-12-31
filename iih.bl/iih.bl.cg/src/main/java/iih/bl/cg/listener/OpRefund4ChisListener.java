package iih.bl.cg.listener;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.dto.d.OpRefund4EsDTO;
import iih.bl.cg.i.IBlCgCmdService;
import iih.bl.comm.IBlConst;
import iih.bl.comm.IBlMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 门诊退费接口监听器
 * 
 * @author yankan
 * @author yanglu
 *
 */
public class OpRefund4ChisListener implements IBusinessListener {
	/**
	 * 监听
	 * 
	 * @param event
	 *            事件
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、校验事件
		this.validate(event);

		// 2、获取事件源
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		OpRefund4EsDTO eventSourceDTO = (OpRefund4EsDTO) bizUserObj.getUserObj();
		if (eventSourceDTO == null) {
			Logger.error(IBlMsgConst.ERROR_EVENT_SOURCE_IS_NULL);
			return;
		}

		// 3、调用发送第三方退费接口功能
		IBlCgCmdService iBlCgCmdService = ServiceFinder.find(IBlCgCmdService.class);
		iBlCgCmdService.sendRefundMsgByStId(eventSourceDTO.getId_st());

		// 4、获取事件的记账ID
		List<String> cgIdList = this.getEsCgIdList(eventSourceDTO.getId_st());

		// 5、调用发送第三方预约检查接口功能
		if (cgIdList != null && cgIdList.size() > 0)
			iBlCgCmdService.sendChisProc(cgIdList, IBlConst.BL_REFUND);

	}

	/**
	 * 组装记账明细集合
	 * 
	 * @param opRefund4IpEsDTOs
	 * @return
	 * @throws BizException
	 */
	private List<String> getEsCgIdList(String idSt) throws BizException {
		List<String> cgIdList = new ArrayList<String>();
		BlCgItmOepDO[] cgList = GetBlCgItmOepDOById_stoep(idSt);
		if (cgList != null) {
			for (BlCgItmOepDO dto : cgList) {
				cgIdList.add(dto.getId_cgitmoep());
			}
		}
		return cgIdList;
	}

	/**
	 * 
	 * 通过结算编号获取明细记账信息
	 * 
	 * @param id_stoep
	 *            结算编号
	 * @return
	 * @throws BizException
	 */
	private BlCgItmOepDO[] GetBlCgItmOepDOById_stoep(String id_stoep) throws BizException {
		IBlCgItmOepDORService service = ServiceFinder.find(IBlCgItmOepDORService.class);
		String sqlWhere = " id_stoep='" + id_stoep + "'  AND id_cgitmoep not in (SELECT ID_PAR FROM BL_CG_ITM_OEP WHERE ID_STOEP in (SELECT ID_STOEP FROM BL_ST_OEP WHERE ID_PAR='" + id_stoep + "' AND BL_ST_OEP.EU_DIRECT='1'))";
		BlCgItmOepDO[] aggs = service.find(sqlWhere, "", FBoolean.FALSE);
		if (aggs != null && aggs.length == 1) {
			return aggs;
		}
		return null;
	}

	/**
	 * 验证事件
	 * 
	 * @param event
	 *            事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IBlEventConst.EVENT_SOURCE_OP_REFUND.equalsIgnoreCase(event.getSourceID()) || !IBlEventConst.EVENT_TYPE_BL_OP_REFUND.equals(event.getEventType())) {
			throw new BizException(IBlMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}
}
