package iih.pi.acc.account.s.bp;

import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.s.AccountMDOCrudServiceImpl;
import iih.pi.acc.account.s.bp.help.PatiAccValidateBP;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;

/**
 * 更新患者消费授权额处理
 * @author ly
 *
 */
public class PatiAccPreAuthorBP {

	/**
	 * 更新患者消费授权额
	 * @param patId 患者id
	 * @param amt 金额
	 * @return
	 * @throws BizException
	 */
	public PiPatAccDO exec(String patId , FDouble amt) throws BizException {
		
		//账户校验
		PiPatAccDO piPatAccDo =  new PatiAccValidateBP().exec(patId);
    	
		if(amt == null)
			return piPatAccDo;
		
		//患者可用额度取得
		GetPatRelAmountInfoBP amountBp = new GetPatRelAmountInfoBP();
    	PatRelAmountInfoDTO[] infos = amountBp.exec(patId);
    	
    	FDouble canuse = FDouble.ZERO_DBL;
    	
    	if(!ArrayUtil.isEmpty(infos)){
    		//预交金 + 信用额 + 患者门诊信用额度 - 消费授权
    		canuse = infos[0].getMoney_canuse();
    	}
    		
    	//剩余预交金
    	//FDouble leftAmt = piPatAccDo.getPrepay().add( piPatAccDo.getCred()).sub(piPatAccDo.getAcc_lock().toDouble());
    	if(canuse.compareTo(amt)<0){
    		throw new DAException("患者账户预授权余额不足，剩余:"+canuse.setScale(-2, FDouble.ROUND_CEILING));
    	}
    	
    	FDouble accLock = piPatAccDo.getAcc_lock().add(amt);
    	if(FDouble.ZERO_DBL.compareTo(accLock) > 0){
    		throw new DAException("患者账户消费授权额度不能小于0，原始额度:" + piPatAccDo.getAcc_lock().setScale(-2, FDouble.ROUND_CEILING) + 
    				"  本次更新额度:" + amt.setScale(-2, FDouble.ROUND_CEILING));
    	}
    	
    	piPatAccDo.setAcc_lock(accLock);
    	piPatAccDo.setStatus(DOStatus.UPDATED);
    	
    	AccountMDOCrudServiceImpl service = new AccountMDOCrudServiceImpl();
    	
    	return service.update(piPatAccDo)[0];	
	}
}
