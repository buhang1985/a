package iih.bl.cg.s.cglogic.base;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.springframework.transaction.TransactionStatus;

import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountRltDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.s.cglogic.util.BlCgAccSetInitUtil;
import iih.bl.cg.s.cglogic.validator.BlCgAccParamValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;

/**
 * 记账基类 
 * TODO 写门诊时再提取与住院的公用处理
 * @author ly 2018/06/24
 *
 */
public abstract class BlKeepAccountBaseBP {

	/**
	 * 记账
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	public BlCgAccountRltDTO exec(BlCgAccountDTO[] accDtos,BlCgAccountSetDTO accSetDto) throws BizException{
		
		if(ArrayUtil.isEmpty(accDtos)){
			throw new BizException("记账数据为空");
		}
		
		//初始化配置
		accSetDto = BlCgAccSetInitUtil.init(accSetDto);
		
		//入参校验
		BlCgAccParamValidator validator = new BlCgAccParamValidator(accSetDto);
		for (int i = 0; i < accDtos.length; i++) {
			validator.validateCharge(accDtos[i], i, null);
		}
		
		BlCgAccountRltDTO rlt = new BlCgAccountRltDTO();
		if(FBoolean.TRUE.equals(accSetDto.getFg_exception())){
			rlt = this.keepAccount(accDtos, accSetDto);
		}else{
			rlt = this.keepAccountNewTransaction(accDtos, accSetDto);
		}
		
		return rlt;
	}
	
	/**
	 * 记账逻辑
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	private BlCgAccountRltDTO keepAccount(BlCgAccountDTO[] accDtos,BlCgAccountSetDTO accSetDto) throws BizException{
		
		//可记账判断
		
		if(FBoolean.TRUE.equals(accSetDto.getFg_price_cal())){
			//计算费用
			
			//回写费用
		}
		
		//数据分组
		
		//费用校验
		
		//
		
		//
		
		
		return null;
	}
	
	/**
	 * 记账逻辑(新事务)
	 * @param accDtos
	 * @param accSetDto
	 * @return
	 * @throws BizException
	 */
	private BlCgAccountRltDTO keepAccountNewTransaction(final BlCgAccountDTO[] accDtos,final BlCgAccountSetDTO accSetDto)throws BizException{
		
		BlCgAccountRltDTO rlt = null;
		try {
			rlt = TransactionExecutor.executeNewTransaction(new TransactionalOperation<BlCgAccountRltDTO>() {
						@Override
						public BlCgAccountRltDTO doInTransaction(TransactionStatus status)
								throws InvocationTargetException {
							try {
								return keepAccount(accDtos, accSetDto);
							} catch (Exception e) {
								e.printStackTrace();
								throw new InvocationTargetException(e);
							}
						}
					});
		} catch (Exception e) {
		}

		return rlt;
	}

	/**
	 * 费用校验
	 * @param accDtos
	 * @param accSetDto
	 * @throws BizException
	 */
	protected abstract void validateAcc(BlCgAccountDTO[] accDtos,BlCgAccountSetDTO accSetDto)throws BizException;
	
	/**
	 * 回写账户信息
	 * @param amtMap
	 * @throws BizException
	 */
	protected abstract void writebackAcc(Map<String,FDouble> amtMap) throws BizException;

}
