package iih.bl.cg.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.extritf.d.EuSendStatus;
import iih.bl.cg.extritf.d.RefundInfoDO;
import iih.bl.cg.extritf.i.IRefundinfoCudService;
import xap.mw.core.annotation.Reference;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

import com.founder.ws.back.WsRefundService;

/**
 * 发送第三方退费时间并记录数据是否发送成功
 * 
 * @author yang.lu 2017年6月27日22:09:29
 *
 */
public class SendRefundMsgBP {

	/**
	 * 发送信息退费消息
	 * 
	 * @param id_stoep
	 *            退费单据编号
	 * @return
	 * @throws BizException
	 */
	public void exec(RefundInfoDO retfundInfo, WsRefundService refundService) throws BizException {

		if(StringUtil.isEmptyWithTrim(retfundInfo.getPaymodenode()))
			return;
		try {
			String retVal = refundService.refund(retfundInfo.getPaymodenode(), retfundInfo.getEu_refundtype(), retfundInfo.getCode_apt(), retfundInfo.getCode_pat(), retfundInfo.getCode_enttp(), retfundInfo.getCode_apply(), retfundInfo.getAmt().toString(), retfundInfo.getTimes_op().toString(), retfundInfo.getCode_st(), retfundInfo.getPaytype(), retfundInfo.getTelno_pat());
			if (retVal.equals("1")) {
				// 成功 添加成功状态
				retfundInfo.setDt_send(AppUtils.getServerDateTime());
				retfundInfo.setEu_sendstatus(new Integer(EuSendStatus.SUCCESS));
			} else {
				// 失败 添加失败状态
				retfundInfo.setEu_sendstatus(new Integer(EuSendStatus.FAIL));
				retfundInfo.setNote("返回结果：" + retVal);
			}
		} catch (Exception e) {
			// TODO: handle exception
			retfundInfo.setEu_sendstatus(new Integer(EuSendStatus.FAIL));
			retfundInfo.setNote(e.getMessage());
		}
		IRefundinfoCudService service = ServiceFinder.find(IRefundinfoCudService.class);

		RefundInfoDO[] saveDo = null;
		// 保存第三方接口记录信息
		if (!StringUtil.isEmptyWithTrim(retfundInfo.getId_interfacerefundinfo())) {
			retfundInfo.setStatus(DOStatus.UPDATED);
			saveDo = service.update((new RefundInfoDO[] { retfundInfo }));
		} else {
			retfundInfo.setStatus(DOStatus.NEW);
			saveDo = service.insert((new RefundInfoDO[] { retfundInfo }));
		}

	}
}
