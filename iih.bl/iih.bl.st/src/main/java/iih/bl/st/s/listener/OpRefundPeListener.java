package iih.bl.st.s.listener;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;
import iih.bl.st.s.bp.oepcharge.BlPeChargeReturnBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

public class OpRefundPeListener  implements IBusinessListener  {

	@Override
	public void doAction(IBusinessEvent paramIBusinessEvent) throws BizException {
		//1.校验事件
		this.validate(paramIBusinessEvent);
		//2.回写体检系统收费状态
		this.setPeChargeState(paramIBusinessEvent);
	}
	
	/**
	 * 验证事件
	 * 
	 * @param event
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IBlEventConst.EVENT_SOURCE_OEP_REFUND.equalsIgnoreCase(event.getSourceID())
				|| !IBlEventConst.EVENT_TYPE_OEP_REFUND.equals(event.getEventType())) {
			throw new BizException(IBlMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}
	/**
	 * 回写体检系统收费状态
	 * 
	 * @param event
	 * @throws BizException
	 */
	private void setPeChargeState(IBusinessEvent event) throws BizException {
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		if (IBlEventConst.EVENT_SOURCE_OEP_REFUND.equalsIgnoreCase(event.getSourceID())) {
			
			BlPayOepRefundEventDTO eventSourceDTO = (BlPayOepRefundEventDTO) bizUserObj.getUserObj();
			//获取结算数据
			BlStOepDO blStOepDO = eventSourceDTO.getRedStData();
			if(blStOepDO!=null&&StringUtils.isNotEmpty(blStOepDO.getPecode())){
				BlcgoepAggDO[] blcgoepAggDOs = eventSourceDTO.getRedCgData();
				BlPeChargeReturnBP bp = new BlPeChargeReturnBP();
				FBoolean flag = bp.exec(blcgoepAggDOs,FBoolean.FALSE);
				//判断是否回写成功
				if(flag.booleanValue()){
					BLThirdItfLogger.info(String.format("体检退费成功 "+blStOepDO.getId_pat()));
				}else{
					throw new BizException("回写体检退费失败");
				}
			}
		}
	}
}