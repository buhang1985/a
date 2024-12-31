package iih.pi.acc.account.s;

import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.account.s.bp.ETPatiPrepayUpdateBP;
import iih.pi.acc.account.s.bp.GetEtObsPatiBalanceBP;
import iih.pi.acc.account.s.bp.GetPatRelAmountInfoBP;
import iih.pi.acc.account.s.bp.GetPatiBalanceBP;
import iih.pi.acc.account.s.bp.PatiAccPreAuthorBP;
import iih.pi.acc.account.s.bp.PatiPrepayUpdateBP;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
* 患者账户服务
*/
@Service(serviceInterfaces={IPatAccServiceExt.class}, binding=Binding.JSONRPC)
public class PatAccServiceExtImpl implements IPatAccServiceExt{


	/**
     * 更新患者消费授权额
     * @param patId 患者id
     * @param amt 预交金
     * @return
     * @throws BizException
     */
	@Override
    public PiPatAccDO PatiAccPreAuthor(String patId , FDouble amt) throws BizException {
		PatiAccPreAuthorBP bp = new PatiAccPreAuthorBP();
		return bp.exec(patId, amt);
    }
    
	/**
     * 更新患者预交金金额
     * @param patId
     * @param prepay
     * @return
     * @throws BizException
     */
	@Override
    public PiPatAccDO updatePatPrepay(String patId, FDouble prepay) throws BizException{
		PatiPrepayUpdateBP bp = new PatiPrepayUpdateBP();
		return bp.exec(patId, prepay);
	}
	
	/**
     * 收退预交金后，更新急诊留观（门诊记账）患者预交金金额
     * @param patId
     * @param prepay
     * @return
     * @throws BizException
     */
	public PiPatAccDO updatePatETPrePay(String patId, FDouble prepay) throws BizException{
		ETPatiPrepayUpdateBP bp = new ETPatiPrepayUpdateBP();
		return bp.etPrePay(patId, prepay);
	}
	
	/**
     * 收款后，更新急诊留观（门诊记账）患者预交金金额
     * @param patId
     * @param money
     * @param fg_ip
     * @return
     * @throws BizException
     */
	public PiPatAccDO etPay(String patId, FDouble money, FBoolean fg_ip) throws BizException{
		ETPatiPrepayUpdateBP bp = new ETPatiPrepayUpdateBP();
		return bp.etPay(patId, money, fg_ip);
	}
	
	/**
     * 记账后，更新急诊留观（门诊记账）患者预交金金额
     * @param patId
     * @param money
     * @return
     * @throws BizException
     */
	public PiPatAccDO etCG(String patId, FDouble money) throws BizException{
		ETPatiPrepayUpdateBP bp = new ETPatiPrepayUpdateBP();
		return bp.etCG(patId, money);
	}
	
    /**
	 * 获得门诊账户余额
	 * @param patId
	 * @return
	 */
	@Override
	public FDouble GetOutpPrepaymentAmount(String patId) throws BizException {
		GetPatiBalanceBP bp = new GetPatiBalanceBP();
		return bp.exec(patId);
	}

	/**
	 * 取得患者相关金额信息
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatRelAmountInfoDTO GetPatRelAmountInfo(String patId) throws BizException{
		GetPatRelAmountInfoBP bp = new GetPatRelAmountInfoBP();
		return bp.exec(patId)[0];
	}
	
	/**
	 * 取得患者相关金额信息(批处理)
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	@Override
	public PatRelAmountInfoDTO[] GetPatRelAmountInfos(String[] patIds) throws BizException{
		GetPatRelAmountInfoBP bp = new GetPatRelAmountInfoBP();
		return bp.exec(patIds);
	}

	/**
	 * 获得急诊留观账户余额
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	@Override
	public FDouble GetEtObsOutpPrepaymentAmount(String patId)throws BizException {
		GetEtObsPatiBalanceBP bp = new GetEtObsPatiBalanceBP();
		return bp.exec(patId);
	}

	/**
	 * 更新急诊留观账户锁定金额
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	@Override
	public PiPatAccDO updatePatEtAccLock(String patId, FDouble amt) throws BizException {
		ETPatiPrepayUpdateBP bp = new ETPatiPrepayUpdateBP();
		return bp.updatePatEtAccLock(patId, amt);
	}
}