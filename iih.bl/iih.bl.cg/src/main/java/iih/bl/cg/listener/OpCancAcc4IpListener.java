package iih.bl.cg.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.dto.d.OpCancAcc4EsDTO;
import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.bl.cg.event.OpRefund4IpEvent;
import iih.bl.cg.i.IBlCgCmdService;
import iih.bl.cg.listener.qry.GetOpFund4IpEsDTOsByIdsQry;
import iih.bl.comm.IBlConst;
import iih.bl.comm.IBlMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 门诊取消记账集成平台监听器
 * 
 * @author yankan
 * @since 2017-07-03
 *
 */
public class OpCancAcc4IpListener implements IBusinessListener {
	/**
	 * 执行
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
		OpCancAcc4EsDTO[] eventSourceDTO = (OpCancAcc4EsDTO[]) bizUserObj.getUserObj();
		if (eventSourceDTO == null) {
			Logger.error(IBlMsgConst.ERROR_EVENT_SOURCE_IS_NULL);
			return;
		}

		// 3.发送集成平台事件OpRefund4IpEvent
		OpRefund4IpEvent ipEvent = new OpRefund4IpEvent();

		OpRefund4IpEsDTO[] opRefund4IpEsDTOs = assembleIpEsDTO(eventSourceDTO);

		ipEvent.invoke(opRefund4IpEsDTOs);
		

		// 4、获取事件的记账ID
		List<String> cgIdList = this.getEsCgIdList(opRefund4IpEsDTOs);

		// 5、调用发送第三方预约检查接口功能
		IBlCgCmdService iBlCgCmdService = ServiceFinder.find(IBlCgCmdService.class);
		iBlCgCmdService.sendChisProc(cgIdList, IBlConst.BL_REFUND);
	}

	/**
	 * 组装记账明细集合
	 * @param opRefund4IpEsDTOs
	 * @return
	 */
	private List<String> getEsCgIdList(OpRefund4IpEsDTO[] opRefund4IpEsDTOs){
		List<String> cgIdList=new ArrayList<String>();
		for (OpRefund4IpEsDTO dto : opRefund4IpEsDTOs) {
			cgIdList.add(dto.getId_cgitm());
		}
		return cgIdList;
	}
	/**
	 * 组装发送消息集合对象
	 * 
	 * @param esDTOs
	 * @return
	 * @throws BizException
	 */
	private OpRefund4IpEsDTO[] assembleIpEsDTO(OpCancAcc4EsDTO[] esDTOs) throws BizException {
		List<String> iditmoepList = new ArrayList<String>();
		Map<String, String> map = new HashMap<String, String>();
		for (OpCancAcc4EsDTO esDTO : esDTOs) {
			iditmoepList.add(esDTO.getId_cgitm());
			map.put(esDTO.getId_cgitm(), esDTO.getSd_prestp());
		}
		if (iditmoepList.size() != 0) {
			OpRefund4IpEsDTO[] ipEsDTOs = (OpRefund4IpEsDTO[]) AppFwUtil.getDORstWithDao(new GetOpFund4IpEsDTOsByIdsQry(iditmoepList.toArray(new String[iditmoepList.size()])), OpRefund4IpEsDTO.class);

			for (OpRefund4IpEsDTO opRefund4IpEsDTO : ipEsDTOs) {
				opRefund4IpEsDTO.setSd_prestp(map.get(opRefund4IpEsDTO.getId_cgitm()));
			}
			return ipEsDTOs;
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
		if (!IBlEventConst.EVENT_SOURCE_OP_CANC_ACC.equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException(IBlMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}
}
