package iih.en.pv.s.bp.ip;

import iih.en.comm.bp.BatchGetBalanceBP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import xap.mw.core.data.BizException;

/**
 * 查询就诊账户余额
 * @author yank
 *
 */
public class GetBalanceBP {
	/**
	 * 查询就诊账户余额
	 * 信用额度=患者信用分类的就诊信用额度+就诊账户的信用额度
	 * 账户余额=就诊预交金-消费金额
	 * 可用余额=患者信用分类的就诊信用额度+就诊账户的信用额度 + 预交金-消费金额	 
	 * @param entId 就诊id
	 * @return DTO包含：患者预交金总金额、患者信用度总额、未结算费用总额、患者可用费用余额
	 * @throws BizException
	 * @author yank
	 */
	public BalanceDTO exec(String entId) throws BizException{
		BalanceDTO[] balDTOs = this.exec(new String[]{entId});
		if(EnValidator.isEmpty(balDTOs)) 
			return null;
		return balDTOs[0];
	}
	/**
	 * 查询就诊账户余额
	 * 信用额度=患者信用分类的就诊信用额度+就诊账户的信用额度
	 * 账户余额=就诊预交金-消费金额
	 * 可用余额=患者信用分类的就诊信用额度+就诊账户的信用额度 + 预交金-消费金额	 
	 * @param entIds 就诊id集合
	 * @return DTO包含：患者预交金总金额、患者信用度总额、未结算费用总额、患者可用费用余额
	 * @throws BizException
	 * @author yank
	 */
	public BalanceDTO[] exec(String[] entIds) throws BizException{
		if(EnValidator.isEmpty(entIds))
			return null;
		BatchGetBalanceBP getBlListBP = new BatchGetBalanceBP();
		return getBlListBP.exec(entIds);
	} 
}
