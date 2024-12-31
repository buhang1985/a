package iih.bl.cg.task;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.extritf.d.EuSendStatus;
import iih.bl.cg.extritf.d.RefundInfoDO;
import iih.bl.cg.extritf.i.IRefundinfoRService;
import iih.bl.cg.i.IBlCgCmdService;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.itf.payplatform.d.BlOrdReqDTO;
import iih.pmp.pay.udi.PmpPayConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * IIH退费任务（调用IIH退费接口）
 * @author liming06
 *
 */
public class ResendIIHRefundInfoTask implements IBackgroundWorkPlugin {
	/**
	 * 执行任务
	 * @param ctx 上下文
	 * @author liming06
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext ctx) throws BizException {
		//1.查询所有支付终端类型为窗口，支付方式为支付宝或者微信并且发送状态为失败的数据
		RefundInfoDO[] refundInfoDOArr=this.getSendFailInfo();
		//2.调用发送失败数据重新发送
		if(ArrayUtils.isNotEmpty(refundInfoDOArr)){
			IBlCgCmdService iBlCgCmdService = ServiceFinder.find(IBlCgCmdService.class);
			for(RefundInfoDO retfundInfo :refundInfoDOArr){
				BlOrdReqDTO blOrdReqDTO=setBlOrdReqDTO(retfundInfo);
				iBlCgCmdService.sendIIHRefundMsg(blOrdReqDTO);
				BLTaskLogger.info("患者：【"+ retfundInfo.getId_pat()+"】退费信息："+ retfundInfo.serializeJson());
			}
		}
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}
	
	/**
	 * 查询所有支付终端类型为窗口并且发送状态为失败的数据(主要是退支付方式为支付宝或者微信的数据)
	 * @throws BizException 
	 */
	private RefundInfoDO[] getSendFailInfo() throws BizException{
		IRefundinfoRService refundinfoRService= ServiceFinder.find(IRefundinfoRService.class);
		String whereStr= "ID_PTTP='"+IBlDictCodeConst.ID_PTTP_WINDOW+"'"+
							" and Eu_sendstatus in('" +EuSendStatus.FAIL+"','"+ EuSendStatus.UNSENT +"')";
		RefundInfoDO[] refundInfoDOArr=refundinfoRService.find(whereStr, "", FBoolean.FALSE);
		return refundInfoDOArr;
	}
	/**
	 * 组织退费入参
	 * @param retfundInfo
	 * @return
	 * @throws BizException
	 */
	private BlOrdReqDTO setBlOrdReqDTO(RefundInfoDO retfundInfo) throws BizException{
        BlOrdReqDTO blOrdReqDTO = new BlOrdReqDTO();
        blOrdReqDTO.setOrd_no(retfundInfo.getPaymodenode());//原收费订单号
        blOrdReqDTO.setRefund_req_no(BlCodeUtils.generateThirdOrdNo());
        blOrdReqDTO.setSubject("门诊退费" + retfundInfo.getAmt() + "元");
        blOrdReqDTO.setAmt(retfundInfo.getAmt()); 
        blOrdReqDTO.setEu_direct(BookRtnDirectEnum.REFUND);
        blOrdReqDTO.setId_psndoc(retfundInfo.getId_emp_operator());
        blOrdReqDTO.setSd_chl(PmpPayConst.YLT_CHANNEL_CODE);
        blOrdReqDTO.setTradetype(null);
        blOrdReqDTO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP); 
        blOrdReqDTO.setFg_refund(FBoolean.TRUE);
        blOrdReqDTO.setId_bizscene(IBlDictCodeConst.ID_BIZSCENE_OEP_REFUND);
        blOrdReqDTO.setSd_bizscene(IBlDictCodeConst.SD_BIZSCENE_OEP_REFUND);
        return blOrdReqDTO;
	}
}
