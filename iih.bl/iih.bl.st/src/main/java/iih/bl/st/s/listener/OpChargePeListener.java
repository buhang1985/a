package iih.bl.st.s.listener;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.blpayoep.d.BlPayOepEventDTO;
import iih.bl.st.s.bp.oepcharge.BlPeChargeReturnBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
/**
 * 体检收费监听
 * @author zhangxin
 * @date 2018年12月15日
 *
 */
public class OpChargePeListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		//1.校验事件
		this.validate(arg0);
		//2.回写体检系统收费状态
		this.setPeChargeState(arg0);
	}
	/**
	 * 验证事件
	 * 
	 * @param event
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IBlEventConst.EVENT_SOURCE_OEP_CHARGE.equalsIgnoreCase(event.getSourceID())
				|| !IBlEventConst.EVENT_TYPE_OEP_CHARGE.equals(event.getEventType())) {
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
		if (IBlEventConst.EVENT_SOURCE_OEP_CHARGE.equalsIgnoreCase(event.getSourceID())) {
			// 此类只监听门诊收费的
			BlPayOepEventDTO eventSourceDTO = (BlPayOepEventDTO) bizUserObj.getUserObj();
			//获取结算数据
			BlStOepDO blStOepDO = eventSourceDTO.getStData();
			if(blStOepDO!=null&&StringUtils.isNotEmpty(blStOepDO.getPecode())){
				BlcgoepAggDO[] blcgoepAggDOs = eventSourceDTO.getCgData();
				BlPeChargeReturnBP bp = new BlPeChargeReturnBP();
				FBoolean flag = bp.exec(blcgoepAggDOs,FBoolean.TRUE);
				//判断是否回写成功
				if(flag.booleanValue()){
					BLThirdItfLogger.info(String.format("体检收费成功 "+blStOepDO.getId_pat()));
				}else{
					throw new BizException("回写体检收费信息失败");
				}
			}
			
		}

	}
	
	
}
