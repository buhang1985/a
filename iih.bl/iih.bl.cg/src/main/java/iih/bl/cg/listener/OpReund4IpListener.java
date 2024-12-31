package iih.bl.cg.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.dto.d.OpRefund4EsDTO;
import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.bl.cg.event.OpRefund4IpEvent;
import iih.bl.cg.i.IBlCgCmdService;
import iih.bl.cg.listener.qry.GetOpFund4IpEsDTOsByIdstoepQry;
import iih.bl.comm.IBlConst;
import iih.bl.comm.IBlMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 门诊退费集成平台监听器
 * 
 * @author yankan
 * @since 2017-07-03
 * @author yang.lu 2017-07-03
 */
public class OpReund4IpListener implements IBusinessListener {
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
		OpRefund4EsDTO eventSourceDTO = (OpRefund4EsDTO) bizUserObj.getUserObj();
		if (eventSourceDTO == null || StringUtil.isEmpty(eventSourceDTO.getId_st())) {
			Logger.error(IBlMsgConst.ERROR_EVENT_SOURCE_IS_NULL);
			return;
		}

		// 3.发送集成平台事件OpRefund4IpEvent
		OpRefund4IpEvent ipEvent = new OpRefund4IpEvent();

		OpRefund4IpEsDTO[] opRefund4IpEsDTOs = assembleIpEsDTO(eventSourceDTO.getId_st());

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
	 * @param id_stoep
	 * @return
	 * @throws BizException
	 */
	private OpRefund4IpEsDTO[] assembleIpEsDTO(String id_stoep) throws BizException {
		OpRefund4IpEsDTO[] esList = (OpRefund4IpEsDTO[]) AppFwUtil.getDORstWithDao(new GetOpFund4IpEsDTOsByIdstoepQry(id_stoep), OpRefund4IpEsDTO.class);
		// 1.获取全退重收的数据
		Map<String, FDouble> itmmap = new HashMap<String, FDouble>();
		// 2.根据id_or与id_orsrv作为连个主键 将 重收与全退的数据数量合并
		for (OpRefund4IpEsDTO opRefund4IpEsDTO : esList) {
			if (itmmap.containsKey(opRefund4IpEsDTO.getId_or() + "_" + opRefund4IpEsDTO.getId_orsrv())) {
				FDouble val = itmmap.get(opRefund4IpEsDTO.getId_or() + "_" + opRefund4IpEsDTO.getId_orsrv()).add(opRefund4IpEsDTO.getQuan());
				itmmap.remove(opRefund4IpEsDTO.getId_or() + "_" + opRefund4IpEsDTO.getId_orsrv());
				itmmap.put(opRefund4IpEsDTO.getId_or() + "_" + opRefund4IpEsDTO.getId_orsrv(), val);
			} else {
				itmmap.put(opRefund4IpEsDTO.getId_or() + "_" + opRefund4IpEsDTO.getId_orsrv(), opRefund4IpEsDTO.getQuan());
			}
		}
		ArrayList<OpRefund4IpEsDTO> retList = new ArrayList<OpRefund4IpEsDTO>();

		for (Map.Entry<String, FDouble> entry : itmmap.entrySet()) {
			// 3判断当数量不等于0的数据为退的数据，将此类数据作为返回数据
			if (!FDouble.ZERO_DBL.equals(entry.getValue())) {
				for (OpRefund4IpEsDTO opRefund4IpEsDTO : esList) {
					if (entry.getKey().equals(opRefund4IpEsDTO.getId_or() + "_" + opRefund4IpEsDTO.getId_orsrv())) {
						opRefund4IpEsDTO.setQuan(entry.getValue().multiply(-1));
						retList.add(opRefund4IpEsDTO);
					}
				}
			}
		}
		return retList.toArray(new OpRefund4IpEsDTO[retList.size()]);
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