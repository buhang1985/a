package iih.bl.cg.listener;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.dto.d.OpAcc4EsDTO;
import iih.bl.cg.i.IBlCgCmdService;
import iih.bl.comm.IBlConst;
import iih.bl.comm.IBlMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 门诊记账集成平台监听器
 * 
 * @author yang.lu
 * @since 2017-10-17
 *
 */
public class OpAcc4IpListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、校验事件
		this.validate(event);

		// 2、获取事件的记账ID
		List<String> cgIdList = this.getEsCgIdList(event);

		// 3、调用发送第三方预约检查接口功能
		IBlCgCmdService iBlCgCmdService = ServiceFinder
				.find(IBlCgCmdService.class);
		iBlCgCmdService.sendChisProc(cgIdList, IBlConst.BL_CHARGES);
	}

	/**
	 * 组装记账明细集合
	 * 
	 * @param opRefund4IpEsDTOs
	 * @return
	 */
	private List<String> getEsCgIdList(IBusinessEvent event) {
		List<String> cgIdList = new ArrayList<String>();
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		OpAcc4EsDTO[] opAcc4EsDTOs = (OpAcc4EsDTO[]) bizUserObj.getUserObj();
		for (OpAcc4EsDTO dto : opAcc4EsDTOs) {
			cgIdList.add(dto.getId_cgitmoep());
		}
		return cgIdList;
	}

	/**
	 * 验证事件
	 * 
	 * @param event
	 *            事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IBlEventConst.EVENT_SOURCE_OP_ACC.equalsIgnoreCase(event
				.getSourceID())
				|| !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException(IBlMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}
}
