package iih.en.pv.s.bp.ip;

import iih.bd.base.utils.SqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.dto.d.BalanceDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取团检账户金额(批量)
 * @author ly 2018/06/26
 *
 */
public class GetPeCmpyBalancesBP {

	/**
	 * 获取团检账户金额(批量)
	 * @param peCmpyIds 团检id数组
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BalanceDTO[] exec(String[] peCmpyIds) throws BizException{
		
		if (EnValidator.isEmpty(peCmpyIds))
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

		String whereSql = SqlUtils.getInSqlByIds("acc.id_pecmpy", peCmpyIds);
		sqlSb.append("where " + whereSql);

		List<BalanceDTO> result = (List<BalanceDTO>) new DAFacade().execQuery(
				sqlSb.toString(), new BeanListHandler(BalanceDTO.class));

		if (EnValidator.isEmpty(result))
			return null;

		return result.toArray(new BalanceDTO[0]);
	}
	
}
