package iih.bl.cg.listener;

import java.math.BigDecimal;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.dto.cglogic.d.BlCgOepEventDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.comm.s.bp.BlSendSmsMsgBP;
import iih.bl.comm.util.BlAdivceConvertUtil;
import iih.bl.itf.dto.blsendsmsdto.d.BlSendSmsDTO;
import iih.bl.params.BlParams;
import iih.bl.params.BlSmsConst;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import iih.pi.reg.pat.d.PatDO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 门诊记账短信监听事件新
 * 
 * @author zhangxin
 * @date 2019年8月2日
 */
public class BlCgAccountSmsListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		BusinessUserObj bizUserObj = (BusinessUserObj) arg0.getUserObject();
		String blitf0003 = BlParams.BLITF0003();
		if(StringUtils.isEmpty(blitf0003)){
			return ;
		}
		try {
			// 如果是门诊记账
			if (IBlEventConst.EVENT_TYPE_OPCG_CHARGE.equals(arg0.getEventType())
					&& IBlEventConst.EVENT_SOURCE_OP_CG.equalsIgnoreCase(arg0.getSourceID())
					&&blitf0003.contains(BlSmsConst.BL_OP_ACCOUNT)
					) {
				
				this.SendCgAccountAdive(bizUserObj);
				// 如果是门诊退记账
			} else if (IBlEventConst.EVENT_TYPE_OPCG_CANC_CHARGE.equals(arg0.getEventType())
					&& IBlEventConst.EVENT_SOURCE_OP_CG.equals(arg0.getSourceID())
							&&blitf0003.contains(BlSmsConst.BL_OP_REFUNDACCOUNT)
							) {

				this.SendCgCancAccountAdive(bizUserObj);
			} else {
				return;
			}
		} catch (Exception e) {
			BLThirdItfLogger.error(" 门诊记账短信监听事件新"+e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 门诊记账通知
	 * 
	 * @param bizUserObj
	 * @throws Exception
	 */
	private void SendCgAccountAdive(BusinessUserObj bizUserObj) throws Exception {
		BlCgOepEventDTO eventSourceDTO = (BlCgOepEventDTO) bizUserObj.getUserObj();
		// 如果是预交金记账
		if (OepCgModeEnum.PREPAY_CG.equals(eventSourceDTO.getEu_oepcgmode())
				&& eventSourceDTO.getFg_success().booleanValue()) {
			FArrayList cgList = eventSourceDTO.getCglist();
			if (cgList.size() > 0) {
				boolean trueAccount = BlAdivceConvertUtil.isTrueAccount(cgList);
				if(trueAccount){
					this.SendAdive(cgList,BlSmsConst.BL_OP_ACCOUNT_MSG);
				}
			}
		} else {
			return;
		}

	}
	/**
	 * 门诊退记账通知
	 * 
	 * @param bizUserObj
	 * @throws Exception 
	 */
	private void SendCgCancAccountAdive(BusinessUserObj bizUserObj) throws Exception {
		BlCgOepEventDTO eventSourceDTO = (BlCgOepEventDTO) bizUserObj.getUserObj();
		if(eventSourceDTO.getFg_success().booleanValue()){
			FArrayList cgList = eventSourceDTO.getCglist();
			if (cgList.size() > 0) {
				boolean trueAccount = BlAdivceConvertUtil.isTrueAccount(cgList);
				if(trueAccount){
					SendAdive(cgList,BlSmsConst.BL_OP_REFUNDACCOUNT_MSG);
				}
			}
		}
	}
   /**
    *  发生短信通知
    * @param cgList 记账数据源
    * @param code 短信消息模板
    * @throws BizException
    */
	private void SendAdive(FArrayList cgList,String code) throws BizException {
		@SuppressWarnings("unchecked")
		BlcgoepAggDO[] blcgoepAggDOs =(BlcgoepAggDO[]) cgList.toArray(new BlcgoepAggDO[]{});
		//统计预交金记账金额
		FDouble cgAccAmt = BlAdivceConvertUtil.getOepCgAccAmt(blcgoepAggDOs);
		BlCgOepDO blCgOepDO = blcgoepAggDOs[0].getParentDO();
		//组装发生短信通知
	    this.setBlSendPreSmsDTO(blCgOepDO.getId_pat() ,BlAdivceConvertUtil.getFeeEudirect(blCgOepDO.getEu_direct()), cgAccAmt, blCgOepDO.getDt_cg(), code);
	}

	/**
	 * 设置消息传输dto
	 * @param event
	 * @return
	 * @throws BizException
	 */
	public BlSendSmsDTO setBlSendPreSmsDTO(String id_pat,String Scene_type,FDouble amt,FDateTime dt_pay,String code) throws BizException {
	    BlSendSmsDTO smsDto = new BlSendSmsDTO();
	    smsDto.setName_org(BlAdivceConvertUtil.getOrgName(Context.get().getOrgId()));
	    //获取患者信息
	    PatDO patDo =BlAdivceConvertUtil.getPatData(id_pat);
		//患者姓名
		smsDto.setName_pat(patDo.getName());
		//金额
		smsDto.setAmt(amt.abs());
		//时间
		smsDto.setDt_pay(dt_pay);
		//预交金余额
		IPatAccServiceExt acc =ServiceFinder.find(IPatAccServiceExt.class);
		PatRelAmountInfoDTO patRelAmountInfo = acc.GetPatRelAmountInfo(id_pat);
		FDouble prepayAmount = patRelAmountInfo.getPrepay().sub(patRelAmountInfo.getAcc_lock()).setScale(-2, BigDecimal.ROUND_HALF_UP);
		smsDto.setAccamt(prepayAmount);
		//发生消息通知
		BlSendSmsMsgBP sendSmsBp = new BlSendSmsMsgBP();
		sendSmsBp.exec(patDo.getMob(), code, smsDto);
		return smsDto;
	}
	
	
}
