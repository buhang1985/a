package iih.pi.acc.account.s.bp;

import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.s.AccountMDOCrudServiceImpl;
import iih.pi.acc.account.s.bp.help.PatiAccValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;

/**
 * 更新患者预交金金额处理
 * @author ly
 *
 */
public class PatiPrepayUpdateBP {

	/**
	 * 更新患者预交金金额
	 * @param patId 患者id
	 * @param prepay 预交金
	 * @return
	 * @throws BizException
	 */
	public PiPatAccDO exec(String patId, FDouble prepay) throws BizException{
		
		if(prepay == null){
			throw new BizException("参数预交金不能为空");
		}
		
		//账户校验
    	PiPatAccDO piPatAccDo =  new PatiAccValidateBP().exec(patId);
    	piPatAccDo.setPrepay(prepay.add(piPatAccDo.getPrepay() == null ? FDouble.ZERO_DBL
				: piPatAccDo.getPrepay()));
    	
    	if(prepay.compareTo(FDouble.ZERO_DBL) < 0 && 
				piPatAccDo.getPrepay().compareTo(FDouble.ZERO_DBL) < 0){
			throw new BizException("账户中预交金不足以本次扣费操作");
		}
    	
    	piPatAccDo.setStatus(DOStatus.UPDATED);
		
    	AccountMDOCrudServiceImpl service = new AccountMDOCrudServiceImpl();
		PiPatAccDO[] result = service.update(new PiPatAccDO[]{piPatAccDo});
		
		return result[0];
	}
}
