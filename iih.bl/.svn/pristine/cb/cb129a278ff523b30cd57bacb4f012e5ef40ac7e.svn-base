package iih.bl.cg.listener;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.dto.cglogic.d.BlCgOepEventDTO;
import iih.bl.cg.dto.cglogic.d.OepCgModeEnum;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.comm.s.bp.BlSendWXPublicMsgBP;
import iih.bl.comm.util.BlAdivceConvertUtil;
import iih.bl.itf.std.bean.input.wxpublic.WsParamWxPublic;
import iih.bl.itf.std.bean.input.wxpublic.sub.WsParamWxPublicPatient;
import iih.bl.params.BlParams;
import iih.bl.params.BlSmsConst;
import iih.pi.reg.pat.d.PatDO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 门诊记账公众号消息监听
 * 
 * @author zhangxin
 * @date 2019年11月7日
 */
public class BlCgAccountWXPublicListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		BusinessUserObj bizUserObj = (BusinessUserObj) arg0.getUserObject();
		String blitf0004 = BlParams.BLITF0004();
		if (StringUtils.isEmpty(blitf0004)) {
			return;
		}
		try {
			// 如果是门诊记账
			if (IBlEventConst.EVENT_TYPE_OPCG_CHARGE.equals(arg0.getEventType())
					&& IBlEventConst.EVENT_SOURCE_OP_CG.equalsIgnoreCase(arg0.getSourceID())
					&& blitf0004.contains(BlSmsConst.BL_OP_ACCOUNT)) {

				this.SendCgAccountAdive(bizUserObj);
				// 如果是门诊退记账
			} else if (IBlEventConst.EVENT_TYPE_OPCG_CANC_CHARGE.equals(arg0.getEventType())
					&& IBlEventConst.EVENT_SOURCE_OP_CG.equals(arg0.getSourceID())
					&& blitf0004.contains(BlSmsConst.BL_OP_REFUNDACCOUNT)) {

				this.SendCgCancAccountAdive(bizUserObj);
			} else {
				return;
			}
		} catch (Exception e) {
			BLThirdItfLogger.error("  门诊记账公众号消息监听" + e.getMessage());
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
				//判断是否真实记账
				boolean trueAccount = BlAdivceConvertUtil.isTrueAccount(cgList);
				if (trueAccount) {
					this.SendAdive(cgList, BlSmsConst.BL_OP_ACCOUNT_MSG);
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
		if (eventSourceDTO.getFg_success().booleanValue()) {
			FArrayList cgList = eventSourceDTO.getCglist();
			if (cgList.size() > 0) {
				//判断是否真实记账
				boolean trueAccount = BlAdivceConvertUtil.isTrueAccount(cgList);
				if (trueAccount) {
					SendAdive(cgList, BlSmsConst.BL_OP_REFUNDACCOUNT_MSG);
				}
			}
		}
	}

	/**
	 * 发生短信通知
	 * 
	 * @param cgList
	 *            记账数据源
	 * @param code
	 *            短信消息模板
	 * @throws BizException
	 */
	private void SendAdive(FArrayList cgList, String code) throws BizException {
		@SuppressWarnings("unchecked")
		BlcgoepAggDO[] blcgoepAggDOs = (BlcgoepAggDO[]) cgList.toArray(new BlcgoepAggDO[] {});
		//统计预交金记账金额
		FDouble cgAccAmt = BlAdivceConvertUtil.getOepCgAccAmt(blcgoepAggDOs);
		BlCgOepDO blCgOepDO = blcgoepAggDOs[0].getParentDO();
		// 组装发生短信通知
		this.setBlSendPreSmsDTO(blCgOepDO.getId_pat(),cgAccAmt,
				blCgOepDO.getDt_cg(), code);
	}


	/**
	 * 设置消息传输dto
	 * 
	 * @param event
	 * @return
	 * @throws BizException
	 */
	public FBoolean setBlSendPreSmsDTO(String id_pat, FDouble amt, FDateTime dt_pay, String code)
			throws BizException {

		WsParamWxPublic wsParanWxPublic = new WsParamWxPublic();
		WsParamWxPublicPatient patient = new WsParamWxPublicPatient();
		// 获取患者信息
		PatDO patDo =BlAdivceConvertUtil.getPatData(id_pat);
		// 患者id
		patient.setId_pat(patDo.getId_pat());
		// 患者编码
		patient.setCodepat(patDo.getCode());
		// 患者姓名
		patient.setNamepat(patDo.getName());
		patient.setTemplcode(code);
		List<String> param = new ArrayList<>();
		if(BlSmsConst.BL_OP_ACCOUNT_MSG.equals(code)){
			param.add("门诊预交金消费");
		}else if(BlSmsConst.BL_OP_REFUNDACCOUNT_MSG.equals(code)){
			param.add("门诊预交金消费退还");
		}
		// 金额
		param.add(amt.toString());
		// 时间
		param.add(dt_pay.toStdString());
		wsParanWxPublic.setPatient(patient);
		wsParanWxPublic.setInfo(param);
		// 预交金余额
		BlSendWXPublicMsgBP bp = new BlSendWXPublicMsgBP();
		return bp.exec(wsParanWxPublic);
	}

}
