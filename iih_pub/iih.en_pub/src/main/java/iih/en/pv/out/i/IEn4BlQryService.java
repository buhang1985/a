package iih.en.pv.out.i;

import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.out.bl.d.EnMomBabyInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 为费用提供查询接口
 * 
 * @author jizb
 *
 */
public interface IEn4BlQryService extends IEn4CommQryService{

	/**
	 * 已转病区未出院的患者查询接口
	 * 
	 * @param idOldNur 原病区id
	 * @return
	 * @throws BizException
	 */
	TransDepPatDTO[] getTransDepPatInfo(String idOldNur) throws BizException;
	/**
	 * 获取团检账户金额
	 * @param peCmpyId 团检记录id
	 * @return 账户金额信息
	 * @throws BizException
	 * @author ly 2018/06/04
	 */
	public BalanceDTO getPeCmpyBalance(String peCmpyId) throws BizException;
	
	/**
	 * 获取团检账户金额(批量)
	 * @param peCmpyIds 团检记录id数组
	 * @return 账户金额信息
	 * @throws BizException
	 * @author ly 2018/06/26
	 */
	public BalanceDTO[] getPeCmpyBalances(String[] peCmpyIds) throws BizException;
	/**
	 * 获取母婴就诊数据接口
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 * @author lb
	 */
	public EnMomBabyInfoDTO[] getMomBabyInfos(String[] entIds) throws BizException;
}
