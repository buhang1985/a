package iih.bl.pay.i;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import iih.bl.pay.dto.d.BlIpRegisKnotsPayDTO;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.dto.d.BlPayPatQyDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.st.payment.d.BlIpPrePayPatDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 收付款查询服务
 * 
 * @author yankan
 * @since 2017-06-15
 *
 */
public interface IBlPayQryService {

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
	public abstract BlPrePayPatDO getReprintPrepayInfo(String patId, String repCode) throws BizException;

	/**
	 * 获取第三方支付记录信息
	 * 
	 * @param patId患者编号
	 * @param pmId支付项目
	 * @return
	 * @throws BizException
	 */
	public abstract BlPayPatItemDTO[] getPayPatListByIdPatPm(String patId, String pmId) throws BizException;

	/**
	 * 查询已缴费卡押金记录(用于退卡押金)
	 * 
	 * @param patId
	 * @param patCardId
	 * @return
	 * @throws BizException
	 */
	public abstract BlPrepayDTO getCardDeposit(String patId, String patCardId) throws BizException;

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
	public abstract BlPrePayPatDO getRegroCheckPreInfo(String paypatId, String repCode) throws BizException;

	/**
	 * 查询最近一次票据记录(批量)
	 * @param prepayIds 预交金ids
	 * @return 票据记录
	 * @throws BizException
	 */
	public abstract BlPrepayPatRcptDO[] findLastRcptByPrepayIds(String[] prepayIds) throws BizException;
	/**
	 * 
	 * @Title: getKnotsPayDtos @Description:查询患者历次住院结算后的结转押金 @param: @param
	 * id_pat @param: @return @param: @throws BizException @return:
	 * BlIpRegisKnotsPayDTO[] @author: xy.zhou @throws
	 */
	public abstract BlIpRegisKnotsPayDTO[] getKnotsPayDtos(String id_pat, String entId) throws BizException;

	/**
	 * 根据价格分类获取病例本费
	 * @param pripatId
	 * @return
	 * @throws BizException
	 */
	public abstract FDouble getMedrecordAmt(String patId) throws BizException;
	
	/**
	 * 查询患者预交金充值记录
	 * @param strEnt
	 * @param strPat
	 * @param strEnttp
	 * @return
	 * @throws BizException
	 */
	public abstract BlPayPatQyDTO[] getPayItmList(String strPat ,String strEnttp) throws BizException;
	
	/**
	 * 查询出院患者可用预交金（新）返回dto
	 * @param entId
	 * @return
	 * @throws BizException
	 * @date 2018年8月10日
	 * @author wq.li
	 */
	public abstract BlIpPrePayPatDTO[] getCanUsePrepayForIpPayNew(String entId) throws BizException;

	/**
	 * 获取是否存在退结转预交金数据
	 * @param idSt
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean getBExistsRePreCarry(String idSt) throws BizException;
}
