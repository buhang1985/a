package iih.en.pv.s.bp.op.ws;

import iih.bl.st.blstoep.d.BlStOepDO;
import iih.en.pv.appoint.result.InvoiceBean;
import iih.en.pv.appoint.s.bp.GetStOepInfoBP;
import iih.en.pv.outpatient.dto.d.PayForAptDTO;
import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.en.pv.s.bp.ip.ws.GetInvoiceInfoBP;
import iih.sc.apt.i.IScAptOutCmdService;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预约付费
 * @author  liubin
 *
 */
public class PayForAptNewBP {
	/**
	 * 付费
	 * 
	 * @param aptId 预约ID
	 * @param patCode 患者编码
	 * @param chlType 渠道类型
	 * @param orderNo 订单号
	 * @param payType 1支付宝，2微信, 3预付费, 4银行卡 6-医保账户
	 * @param accNo 账号
	 * @param patCardNo 患者卡号(预付费时有值)
	 * @param parCardPwd 患者卡密码(预付费时有值)
	 * @param money 金额
	 * @param oprCode 操作员编码
	 * @param patHpTp 患者医保类型，(0普通， 1-医保持卡,2-医保不持卡)
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public ResultBean exec(final String aptId, final String patCode, final String chlType, final String orderNo, final String payType, final String accNo,
			final String patCardNo, final String parCardPwd, final String money, final String oprCode, final String patHpTp,final String hpPriceData,final String patHpNO,final String hpPatInfXml,final String insurPriceDivideXml) throws BizException{
		ResultBean resultDto = new ResultBean();
		resultDto.setFlag("0");
		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation() {
				@Override
				public Object doInTransaction(TransactionStatus paramTransactionStatus) {
					try {
						new SetPsnDocContextBP().exec(oprCode);;
						IScAptOutCmdService service = ServiceFinder.find(IScAptOutCmdService.class);
						String errorMsg = service.payForAptNew(aptId, patCode, chlType, orderNo, payType, accNo, patCardNo, parCardPwd, money, oprCode, patHpTp,hpPriceData, patHpNO,hpPatInfXml, insurPriceDivideXml);
						} catch (BizException e) {
							throw new BizRuntimeException(e.getMessage(), e);
						}
						return null;
					}
				});
		} catch (BizRuntimeException ex) {
			ex.printStackTrace();
			resultDto.setFlag("1");
			resultDto.setMsg(ex.getMessage());
		}
		return resultDto;
	}
	
	
	/**
	 * 付费
	 * 
	 * @param aptId 预约ID
	 * @param patCode 患者编码
	 * @param chlType 渠道类型
	 * @param orderNo 订单号
	 * @param payType 1支付宝，2微信, 3预付费, 4银行卡 6-医保账户
	 * @param accNo 账号
	 * @param patCardNo 患者卡号(预付费时有值)
	 * @param parCardPwd 患者卡密码(预付费时有值)
	 * @param money 金额
	 * @param oprCode 操作员编码
	 * @param patHpTp 患者医保类型，(0普通， 1-医保持卡,2-医保不持卡)
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public ResultBean exec(final PayForAptDTO payForAptDTO) throws BizException{		
		ResultBean resultDto = new ResultBean();
		resultDto.setFlag("0");
		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation() {
				@Override
				public Object doInTransaction(TransactionStatus paramTransactionStatus) {
					try {
						new SetPsnDocContextBP().exec(payForAptDTO.getOprCode());;
						IScAptOutCmdService service = ServiceFinder.find(IScAptOutCmdService.class);
						String errorMsg = service.payForAptNew2( payForAptDTO.getAptId(),payForAptDTO.getPatCode(), payForAptDTO.getChlType(),payForAptDTO.getOrderNo(), payForAptDTO.getPayType(), payForAptDTO.getAccNo(), payForAptDTO.getPatCardNo(),
								payForAptDTO.getParCardPwd(), payForAptDTO.getMoney(), payForAptDTO.getOprCode(),
								payForAptDTO.getPatHpTp(),payForAptDTO.getHpPriceData(), payForAptDTO.getPatHpNO(),payForAptDTO.getHpPatInfXml(),payForAptDTO.getInsurPriceDivideXml(),payForAptDTO.getDt_st(),payForAptDTO.getBusiness_code(),payForAptDTO.getFg_printInvoice());
						} catch (BizException e) {
							throw new BizRuntimeException(e.getMessage(), e);
						}
						return null;
					}
				});
		} catch (BizRuntimeException ex) {
			ex.printStackTrace();
			resultDto.setFlag("1");
			resultDto.setMsg(ex.getMessage());
		}
		//获取发票信息
		if(FBoolean.TRUE.equals(FBoolean.valueOf(payForAptDTO.getFg_printInvoice()))){
			InvoiceBean invoice = new GetInvoiceInfoBP().exec(payForAptDTO.getAptId());
			resultDto.setInvoice(invoice);
		}
		//设置结算信息
		this.setStInfo(resultDto, payForAptDTO.getAptId());
		return resultDto;
	}
	/**
	 * 设置结算信息
	 * 
	 * @param resultDto
	 * @param aptId
	 * @throws BizException
	 */
	private void setStInfo(ResultBean resultDto, String aptId) throws BizException{
		GetStOepInfoBP bp = new GetStOepInfoBP();
		BlStOepDO st = bp.queryByAptId(aptId);
		if(st == null)
			return;
		resultDto.setId_stoep(st.getId_stoep());
		resultDto.setCode_st(st.getCode_st());
		resultDto.setDt_st(st.getDt_st()==null? null : st.getDt_st().toString());
	}
}
