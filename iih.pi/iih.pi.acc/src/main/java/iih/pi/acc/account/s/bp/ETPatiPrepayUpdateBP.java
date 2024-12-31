package iih.pi.acc.account.s.bp;

import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.s.AccountMDOCrudServiceImpl;
import iih.pi.acc.account.s.bp.help.PatiAccValidateBP;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAException;

public class ETPatiPrepayUpdateBP {
	/*
	 * 收退留观预交金时候， 更新患者预交金
	 */
	public PiPatAccDO etPrePay(String patId, FDouble money) throws BizException {

		if(!BlParams.BLST0002() .equals(BlParamValueConst.BLST0002_OP))
		{
			throw new BizException("BLST0002 不为 1！");
		}
		
		if (money == null) {
			throw new BizException("参数预交金不能为空");
		}

		// 账户校验
		PiPatAccDO piPatAccDo = new PatiAccValidateBP().exec(patId);
		piPatAccDo.setPrepay_emgstay(
				money.add(piPatAccDo.getPrepay_emgstay() == null ? FDouble.ZERO_DBL : piPatAccDo.getPrepay_emgstay()));

		if (money.compareTo(FDouble.ZERO_DBL) < 0 && piPatAccDo.getPrepay_emgstay().compareTo(FDouble.ZERO_DBL) < 0) {
			throw new BizException("账户中预交金不足以本次扣费操作");
		}

		piPatAccDo.setStatus(DOStatus.UPDATED);

		AccountMDOCrudServiceImpl service = new AccountMDOCrudServiceImpl();
		PiPatAccDO[] result = service.update(new PiPatAccDO[] { piPatAccDo });

		return result[0];
	}

	/*
	 * 付款， 减少患者预交金，减少锁定金额，如果已出观，信用度归零
	 */
	public PiPatAccDO etPay(String patId, FDouble money, FBoolean fg_ip) throws BizException {
		
		if(!BlParams.BLST0002().equals(BlParamValueConst.BLST0002_OP))
		{
			throw new BizException("BLST0002 不为 1！");
		}
		
		// 校验
		if (money == null) {
			throw new BizException("收款参数不能为空");
		}

		PiPatAccDO piPatAccDo = new PatiAccValidateBP().exec(patId);
		if (money.compareTo(FDouble.ZERO_DBL) < 0 && piPatAccDo.getPrepay_emgstay().compareTo(FDouble.ZERO_DBL) < 0) {
			throw new BizException("账户中预交金不足以本次扣费操作");
		}

		// 改动预交金
		piPatAccDo.setPrepay_emgstay(
				(piPatAccDo.getPrepay_emgstay() == null ? FDouble.ZERO_DBL : piPatAccDo.getPrepay_emgstay()).add(money));
		
		// 如果出观，归零信用度
		if (fg_ip == FBoolean.FALSE) {
			piPatAccDo.setCred_emgstay(FDouble.ZERO_DBL);
		}

		piPatAccDo.setStatus(DOStatus.UPDATED);

		AccountMDOCrudServiceImpl service = new AccountMDOCrudServiceImpl();
		PiPatAccDO[] result = service.update(new PiPatAccDO[] { piPatAccDo });

		return result[0];
	}
	
	/*
	 * 记账， 增加锁定金额
	 */
	public PiPatAccDO etCG(String patId, FDouble money) throws BizException {
		
		if(!BlParams.BLST0002().equals(BlParamValueConst.BLST0002_OP))
		{
			throw new BizException("BLST0002 不为 1！");
		}
		
		// 校验
		if (money == null) {
			throw new BizException("记账参数不能为空");
		}

		PiPatAccDO piPatAccDo = new PatiAccValidateBP().exec(patId);
			

		// 增加锁定金额
		piPatAccDo.setAcc_lock_emgstay(
				(piPatAccDo.getAcc_lock_emgstay() == null ? FDouble.ZERO_DBL : piPatAccDo.getAcc_lock_emgstay())
						.add(money));
		piPatAccDo.setStatus(DOStatus.UPDATED);

		AccountMDOCrudServiceImpl service = new AccountMDOCrudServiceImpl();
		PiPatAccDO[] result = service.update(new PiPatAccDO[] { piPatAccDo });

		return result[0];
	}
	
	/**
	 * 更新患者消费授权额
	 * @param patId 患者id
	 * @param amt 金额
	 * @return
	 * @throws BizException
	 */
	public PiPatAccDO updatePatEtAccLock(String patId , FDouble amt) throws BizException {
		
		//账户校验
		PiPatAccDO piPatAccDo =  new PatiAccValidateBP().exec(patId);
    	
		if(amt == null)
			return piPatAccDo;
		
    	FDouble accLockOld = (piPatAccDo.getAcc_lock_emgstay() == null ? new FDouble(0.00) : piPatAccDo.getAcc_lock_emgstay());
    	
    	FDouble accLock = accLockOld.add(amt);
    	if(FDouble.ZERO_DBL.compareTo(accLock) > 0){
    		throw new DAException("患者账户消费授权额度不能小于0，原始额度:" + accLockOld.setScale(-2, FDouble.ROUND_CEILING) + 
    				"  本次更新额度:" + amt.setScale(-2, FDouble.ROUND_CEILING));
    	}
    	
    	piPatAccDo.setAcc_lock_emgstay(accLock);
    	piPatAccDo.setStatus(DOStatus.UPDATED);
    	
    	AccountMDOCrudServiceImpl service = new AccountMDOCrudServiceImpl();
    	
    	return service.update(piPatAccDo)[0];	
	}
}
