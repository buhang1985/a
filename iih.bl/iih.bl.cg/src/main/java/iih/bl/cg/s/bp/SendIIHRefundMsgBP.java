package iih.bl.cg.s.bp;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bl.comm.s.bp.BlThirdPayBP;
import iih.bl.itf.payplatform.d.BlOrdReqDTO;
import iih.bl.itf.trdtrans.d.BlThirdTransRcdDO;
import iih.bl.itf.trdtrans.d.TransStateEnum;
import iih.bl.itf.trdtrans.i.ITrdtransrcdRService;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 调用iih退费平台退费
 * 
 * @author liming
 *
 */
public class SendIIHRefundMsgBP {
	/**
	 * 调用iih退费平台
	 * 第三交易记录id 必传
	 * @param retfundInfo
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(BlOrdReqDTO blOrdReqDTO) throws BizException {
		// 1.校验参数
		if (blOrdReqDTO == null) {
			throw new BizException("退费交易信息不能为空！");
		}
		// 2.退费
		BlThirdPayBP bp = new BlThirdPayBP();
		FBoolean refundSucess = FBoolean.FALSE;
		// 2.1查询第三方交易日志id
		//String id_transrcd = this.getThirdIdByOrdNo(blOrdReqDTO.getOrd_no());
		String id_transrcd =blOrdReqDTO.getId_transrcd();
	    if (StringUtils.isNotEmpty(id_transrcd)) {
			// 2.2先查询此笔交易是否成功，如果不成功再去调用退费
			String status = bp.refundQuery(blOrdReqDTO);
			if (status != null && TradeStatusEnum.REFUND_SUCCESS.toString().equals(status)) {
				upDateThirdState(id_transrcd,bp);
				return FBoolean.TRUE;
			}
			// 2.3调用接口退费
			refundSucess = bp.execRefund(blOrdReqDTO, id_transrcd);
			if(refundSucess.booleanValue()){
				upDateThirdState(id_transrcd,bp);
			}
		}
		return refundSucess;
	}
    private void upDateThirdState(String id_transrcd,BlThirdPayBP bp) throws BizException{
    	BlThirdTransRcdDO blThirdTransRcdDO =new BlThirdTransRcdDO();
		blThirdTransRcdDO.setEu_status((int)TransStateEnum.TRDSUCCESS);
		bp.updateThirdTradeLog(id_transrcd, blThirdTransRcdDO);
    }
	/**
	 * 根据外部订单号查询对应的主键id
	 * 
	 * @param ordNo
	 * @return
	 * @throws BizException
	 */
	public String getThirdIdByOrdNo(String ordNo) throws BizException {
		// 查询收款交易日志id
		ITrdtransrcdRService trdtransrcdRService = ServiceFinder.find(ITrdtransrcdRService.class);
		BlThirdTransRcdDO[] blThirdTransRcdDO = trdtransrcdRService.findByAttrValString(BlThirdTransRcdDO.ORDER_NO,
				ordNo);
		String Id_transrcd = null;
		if (!ArrayUtils.isEmpty(blThirdTransRcdDO)) {
			BlThirdTransRcdDO tradsDo = blThirdTransRcdDO[0];
			Id_transrcd = tradsDo.getId_transrcd();
			// 如果是 收费 单边 则直接返回 id
			if (tradsDo.getEu_direct().equals((int) PayDirectEnum.CHARGE)
					&& blThirdTransRcdDO[0].getEu_status().equals((int) TransStateEnum.TRDSUCCESS)) {
				return Id_transrcd;
			}
			// 查询 退费 交易记录id
			if (!StringUtils.isEmpty(Id_transrcd)) {
				BlThirdTransRcdDO[] blThirdTransRcdDORefu = trdtransrcdRService
						.findByAttrValString(BlThirdTransRcdDO.ID_PAR, Id_transrcd);
				if (!ArrayUtils.isEmpty(blThirdTransRcdDORefu)) {
					return blThirdTransRcdDORefu[0].getId_transrcd();
				}
			}
		}
		return null;
	}
}
