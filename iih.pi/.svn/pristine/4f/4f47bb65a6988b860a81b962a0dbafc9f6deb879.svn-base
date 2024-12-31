package iih.pi.acc.account.s.bp;

import iih.pi.acc.account.s.bp.help.PatiAccValidateBP;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDouble;

/**
 * 获得门诊账户余额处理
 * @author ly
 *
 */
public class GetPatiBalanceBP {

	/**
	 *  获得门诊账户余额
	 * @param patId 患者id
	 * @return
	 * @throws BizException
	 */
	public FDouble exec(String patId) throws BizException{
		
		//账户校验
    	new PatiAccValidateBP().exec(patId);
    	
    	//取得金额数据
    	GetPatRelAmountInfoBP amountBp = new GetPatRelAmountInfoBP();
    	PatRelAmountInfoDTO[] infos = amountBp.exec(patId);
    	
    	if(ArrayUtil.isEmpty(infos))
    		return FDouble.ZERO_DBL;
    	
    	//预交金 + 信用额 + 患者门诊信用额度 - 消费授权
    	return infos[0].getMoney_canuse();
	}
}
