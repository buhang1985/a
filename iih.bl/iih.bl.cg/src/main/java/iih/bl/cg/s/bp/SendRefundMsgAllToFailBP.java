package iih.bl.cg.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.extritf.d.EuSendStatus;
import iih.bl.cg.extritf.d.RefundInfoDO;
import iih.bl.cg.extritf.i.IRefundinfoCudService;
import iih.bl.cg.extritf.i.IRefundinfoRService;
import xap.mw.core.annotation.Reference;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

import com.founder.ws.back.WsRefundService;

/**
 * 查询未发送成功数据 并调用退费第三方接口 保存当前发送状态
 * 
 * @author yang.lu 2017年6月27日22:09:29
 *
 */
public class SendRefundMsgAllToFailBP {

	// 公共webService
	// 修改调用地址需要在iih.integration模块中external-services\src\main\resources\com\founder\iih\Refund.xml
	@Reference(binding = Binding.WS)
	WsRefundService refundService;

	/**
	 * 将第三方接口失败数据重新发送
	 * 
	 * @throws BizException
	 */
	public void exec() throws BizException {

		IRefundinfoCudService service = ServiceFinder.find(IRefundinfoCudService.class);
		IRefundinfoRService rservice = ServiceFinder.find(IRefundinfoRService.class);

		RefundInfoDO[] refdtosDos = rservice.findByAttrValString(RefundInfoDO.EU_SENDSTATUS, EuSendStatus.FAIL);
		if (refdtosDos == null)
			return;
		ArrayList<RefundInfoDO> saveList = new ArrayList<RefundInfoDO>();

		for (RefundInfoDO retfundInfo : refdtosDos) {
			try {
				String retVal = refundService.refund(retfundInfo.getPaymodenode(), retfundInfo.getEu_refundtype(), retfundInfo.getCode_apt(), retfundInfo.getCode_pat(), retfundInfo.getCode_enttp(),
						retfundInfo.getCode_apply(), retfundInfo.getAmt().toString(), retfundInfo.getTimes_op().toString(), retfundInfo.getCode_st(), retfundInfo.getPaytype(), retfundInfo.getTelno_pat());
				if (retVal.equals("1")) {
					// 成功 添加成功状态
					retfundInfo.setEu_sendstatus(new Integer(EuSendStatus.SUCCESS));
				} else {
					// 失败 添加失败状态
					retfundInfo.setEu_sendstatus(new Integer(EuSendStatus.FAIL));
				}

			} catch (Exception e) {
				retfundInfo.setEu_sendstatus(new Integer(EuSendStatus.FAIL));
				retfundInfo.setNote(e.getMessage());
			}
			retfundInfo.setDt_send(AppUtils.getServerDateTime());
			// 保存第三方接口记录信息
			retfundInfo.setStatus(DOStatus.UPDATED);
			saveList.add(retfundInfo);
		}

		service.save(saveList.toArray(new RefundInfoDO[saveList.size()]));
	}
}
