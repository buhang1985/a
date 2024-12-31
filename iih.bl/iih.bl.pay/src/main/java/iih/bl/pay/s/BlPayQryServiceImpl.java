package iih.bl.pay.s;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import iih.bl.pay.dto.d.BlIpRegisKnotsPayDTO;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.dto.d.BlPayPatQyDTO;
import iih.bl.pay.i.IBlPayQryService;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.s.bp.BlPayGetReprintPrepayInfoBP;
import iih.bl.pay.s.bp.BlPayPatQyBp;
import iih.bl.pay.s.bp.GetPayPatListByIdPatPmBP;
import iih.bl.pay.s.bp.ip.GetBlIpRegisKnotsPayDTOBp;
import iih.bl.pay.s.bp.ip.GetCanUsePrepayForIpPayNewBP;
import iih.bl.pay.s.bp.ip.GetRePreCarryBP;
import iih.bl.pay.s.bp.op.GetCardDepositRecordBP;
import iih.bl.pay.s.bp.op.GetMedrecordAmtBP;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import iih.bl.st.payment.d.BlIpPrePayPatDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 收付款查询服务
 * @author yankan
 * @since 2017-06-15
 *
 */
@Service(serviceInterfaces={IBlPayQryService.class}, binding=Binding.JSONRPC)
public class BlPayQryServiceImpl  implements IBlPayQryService{

	/**
	 * 获取重打预交金患者信息
	 * 
	 * @param patId
	 *            患者id
	 * @param repCode
	 *            预交金收据编号
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlPrePayPatDO getReprintPrepayInfo(String patId, String repCode) throws BizException {
		BlPayGetReprintPrepayInfoBP bp = new BlPayGetReprintPrepayInfoBP();
		return bp.exec(patId, repCode,null);
	}
	
	/**
	 * 获取第三方支付记录信息
	 * 
	 * @param patId患者编号
	 * @param pmId支付项目
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlPayPatItemDTO[] getPayPatListByIdPatPm(String patId, String pmId) throws BizException {
		GetPayPatListByIdPatPmBP bp = new GetPayPatListByIdPatPmBP();
		return bp.exec(patId, pmId);
	}
	
	/**
	 * 查询已缴费卡押金记录(用于退卡押金)
	 * 
	 * @param patId
	 * @param patCardId
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlPrepayDTO getCardDeposit(String patId, String patCardId) throws BizException{
		GetCardDepositRecordBP bp = new GetCardDepositRecordBP();
		return bp.exec(patId, patCardId);
	}
	
	/**
	 * 获取团检重打预交金记录信息
	 * 
	 * @param paypatId
	 *            团检预交金记录ID
	 * @param repCode
	 *            团检预交金收据编号
	 * @return
	 * @throws BizException
	 */
	@Override
	public BlPrePayPatDO getRegroCheckPreInfo(String paypatId, String repCode) throws BizException {
		BlPayGetReprintPrepayInfoBP bp = new BlPayGetReprintPrepayInfoBP();
		return bp.exec(null, repCode, paypatId);
	}
	
	/**
	 * 查询最近一次票据记录(批量)
	 * 
	 * @param prepayIds
	 *            预交金ids
	 * @return 票据记录
	 * @throws BizException
	 */
	@Override
	public BlPrepayPatRcptDO[] findLastRcptByPrepayIds(String[] prepayIds) throws BizException {
		PrepayPatRcptEP bp = new PrepayPatRcptEP();
		return bp.findLastRcptByPrepayIds(prepayIds);
	}
	
	/**
	 * 
	 * @Description: 查询患者历次住院结算后的结转押金
	 * @author: xy.zhou
	 */
	public BlIpRegisKnotsPayDTO[] getKnotsPayDtos(String id_pat, String entId) throws BizException {
		GetBlIpRegisKnotsPayDTOBp bp = new GetBlIpRegisKnotsPayDTOBp();
		return bp.exec(id_pat, entId);
	}
	
	/**
	 * 根据价格分类获取病例本费
	 * @param pripatId
	 * @return
	 * @throws BizException
	 */
	public FDouble getMedrecordAmt(String patId) throws BizException{
		GetMedrecordAmtBP bp =new GetMedrecordAmtBP();
		return bp.exec(patId);
	}
    
	/**
	 * 查询患者预交金充值记录
	 * @param strEnt
	 * @param strPat
	 * @param strEnttp
	 * @return
	 * @throws BizException
	 */
	public BlPayPatQyDTO[] getPayItmList( String strPat, String strEnttp) throws BizException {
		BlPayPatQyBp bp = new BlPayPatQyBp();
		return bp.getPayItmList(strPat ,strEnttp);
	}
	
	/**
	 * 查询出院患者可用预交金（新）返回dto
	 * @param entId
	 * @return
	 * @throws BizException
	 * @date 2018年8月10日
	 * @author wq.li
	 */
	public BlIpPrePayPatDTO[] getCanUsePrepayForIpPayNew(String entId) throws BizException{
		GetCanUsePrepayForIpPayNewBP bp=new GetCanUsePrepayForIpPayNewBP();
		return bp.exec(entId);
	}
	
	/**
	 * 获取是否存在退结转预交金数据
	 * @param idSt
	 * @return
	 * @throws BizException
	 */
	public FBoolean getBExistsRePreCarry(String idSt) throws BizException{
		GetRePreCarryBP bp = new GetRePreCarryBP();
		return bp.exec(idSt);
	}
}
