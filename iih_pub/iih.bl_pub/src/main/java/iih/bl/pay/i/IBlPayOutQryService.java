package iih.bl.pay.i;

import java.util.Map;

import iih.bl.et.etaccountdto.d.ETAccountDTO;
import iih.bl.pay.blcontrolciorder.d.ArrearsControlOrderInParamDTO;
import iih.bl.pay.blcontrolciorder.d.ArrearsControlOrderOutParamDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.blspclpatamt.d.BlSpclPatAmtDTO;
import iih.bl.pay.dto.d.BlPayPmDTO;
import iih.bl.pay.dto.d.PrePaidAccAmtDTO;
import iih.bl.pay.dto.prepayamount.d.BlPrepayAmountDTO;
import iih.bl.pay.dto.prepayamount.d.BlPrepayCondDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;

/**
 * 收付款对外查询服务
 * @author yankan
 * @since 2017-07-06
 *
 */
public interface IBlPayOutQryService {
	/**
	 * 根据门诊记账ID获取付款信息
	 * 
	 * (使用方：就诊领域使用)
	 * @param cgId 门诊记账ID
	 * @return 付款信息集合
	 * @throws BizException
	 * @author yankan
	 */
	public abstract BlPayPmDTO[] getOpRegPayDetailBP(String cgId) throws BizException;

	/**
	 * 查询患者卡交费押金
	 * 
	 * @param patcardIds 患者卡id
	 * @param euCardCgMod 卡计费类型
	 * @return
	 * @throws BizException
	 * @author ly 2018/05/21
	 */
	public abstract BlSpclPatAmtDTO[] getPatCardAmt(String[] patcardIds, String euCardCgMod) throws BizException;

	/**
	 * 欠费判断接口
	 * @param codeEnTp
	 * @param entId
	 * @param patId
	 * @param patCaTpId
	 * @return
	 * @throws BizException
	 */
	public abstract PrePaidAccAmtDTO getAccJudge(BlPrepayCondDTO condDto) throws BizException;
	
	/**
	 * 欠费控制是否可开立医嘱（费用）
	 * @author zhang.hw
	 * @date 2019年10月9日
	 * @param list
	 * @return
	 * @throws BizException
	 */
	public abstract ArrearsControlOrderOutParamDTO[] getArrearsControl(ArrearsControlOrderInParamDTO[] list) throws BizException;
	
	/**
	 * 批量获取住院欠费控制数据          
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public abstract PrePaidAccAmtDTO[] getAccJugeIpByentIds(String[] entIds) throws BizException;
	
	/**
	 * 急诊欠费判断接口
	 * @param codeEnTp
	 * @param entId
	 * @param patId
	 * @param patCaTpId
	 * @return
	 * @throws BizException
	 */
	public abstract PrePaidAccAmtDTO getETAccJudge(String codeEnTp,String entId,String patId,String patCaTpId) throws BizException;
	
	/**
	 * 获取预交金余额
	 * @param condDtos 检索条件
	 * @return 预交金余额信息
	 * @throws BizException
	 * @author ly 2019/03/01
	 */
	public abstract BlPrepayAmountDTO[] getPrepayAmountInfo(BlPrepayCondDTO[] condDtos) throws BizException;

	/**
	 * 查询本次住院结算的预交金信息
	 * @param stId
	 * @return
	 * @throws BizException
	 * @author wq.li 2019-4-28
	 */
	public abstract BlPrePayPatDO[] getPrepayInfoByIpStId(String stId) throws BizException;
	
	/**
	 * 得到急诊留观患者的账户信息
	 * @param codeEnTp
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public abstract ETAccountDTO getETAccount(String codeEnTp,String entId) throws BizException;
	
	/**
	 * 得到许多急诊留观患者的账户信息(批量查询)
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public abstract Map<String,ETAccountDTO> getETAccountByEnts(PatiVisitDO[] entDos) throws BizException;
	
}
