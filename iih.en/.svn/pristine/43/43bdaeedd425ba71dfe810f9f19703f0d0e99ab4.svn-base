package iih.en.pv.s.bp.ip;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.dto.d.BalanceDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取团检账户信息
 * @author ly 2018/06/04
 *
 */
public class GetPeCmpyBalanceBP {

	/**
	 * 获取团检账户信息
	 * 信用额度= 账户的信用额度
	 * 账户余额=就诊预交金-消费金额
	 * 可用余额= 账户的信用额度 + 预交金-消费金额	 
	 * @param peCmpyId 团检id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public BalanceDTO exec(String peCmpyId) throws BizException{
		
		if(EnValidator.isEmpty(peCmpyId))
			return null;
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select acc.id_pecmpy,");
		sqlSb.append("nvl(acc.amt_prepay,0) amt_prepay,");
		sqlSb.append("nvl(acc.amt_cred,0) amt_cred,");
		sqlSb.append("nvl(acc.amt_uncg,0) amt_uncg,");
		sqlSb.append("nvl(acc.amt_hp,0) amt_hp,");
		sqlSb.append("nvl(acc.amt_prepay,0) - nvl(acc.amt_uncg,0) amt_bal,");
		sqlSb.append("nvl(acc.amt_prepay,0) + nvl(acc.amt_cred,0) - nvl(acc.amt_uncg,0) available ");
		sqlSb.append("from en_pe_cmpy_acc acc ");
		sqlSb.append("where acc.id_pecmpy = ? ");
		
		SqlParam param = new SqlParam();
		param.addParam(peCmpyId);
		
		List<BalanceDTO> result =(List<BalanceDTO>)new DAFacade().execQuery(
				sqlSb.toString(), param, new BeanListHandler(BalanceDTO.class));
        
        if(EnValidator.isEmpty(result))
        	return null;

		return result.get(0);
	} 
}
