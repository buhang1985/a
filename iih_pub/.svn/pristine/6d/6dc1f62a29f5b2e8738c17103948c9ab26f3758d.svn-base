package iih.pi.acc.account.i;

import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
* 组件操作接口方法服务
*/
public interface IPatAccServiceExt {

    /**
     * 更新患者消费授权额
     * @param patId 患者id
     * @param amt 授权额
     * @return
     * @throws BizException
     */
    public abstract PiPatAccDO PatiAccPreAuthor(String patId, FDouble amt) throws BizException;
	
    /**
     * 更新患者预交金金额
     * @param patId 患者id
     * @param prepay 预交金
     * @return 更新后患者账户DO
     * @throws BizException 病人账户不存在|账户中预交金不足以本次扣费操作
     */
    public abstract PiPatAccDO updatePatPrepay(String patId, FDouble prepay) throws BizException;
	
	/**
     * 更新留观患者预交金金额
     * @param patId 患者id
     * @param prepay 预交金
     * @return 更新后患者账户DO
     * @throws BizException 病人账户不存在|账户中预交金不足以本次扣费操作
     */
    public abstract PiPatAccDO updatePatETPrePay(String patId, FDouble prepay) throws BizException;
    
	/**
     * 门诊结算更新留观患者预交金金额
     * @param patId 患者id
     * @param prepay 预交金
     * @return 更新后患者账户DO
     * @throws BizException 病人账户不存在|账户中预交金不足以本次扣费操作
     */
	public abstract PiPatAccDO etPay(String patId, FDouble money, FBoolean fg_ip) throws BizException;
	
    /**
     * 更新急诊留观患者锁定金额
     * @param patId 患者id
     * @param amt 授权额
     * @return
     * @throws BizException
     */
    public abstract PiPatAccDO updatePatEtAccLock(String patId, FDouble amt) throws BizException;
    /**
     * 获得门诊账户余额
     * @param patId
     * @return
     * @throws BizException
     */
    public abstract FDouble GetOutpPrepaymentAmount(String patId) throws BizException; 
	
	/**
	 * 取得患者相关金额信息
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public abstract PatRelAmountInfoDTO GetPatRelAmountInfo(String patId) throws BizException;
	
	/**
	 * 取得患者相关金额信息(批处理)
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public abstract PatRelAmountInfoDTO[] GetPatRelAmountInfos(String[] patIds) throws BizException;
	
    /**
     * 获得急诊留观账户余额
     * @param patId
     * @return
     * @throws BizException
     */
    public abstract FDouble GetEtObsOutpPrepaymentAmount(String patId) throws BizException; 

	
}
