package iih.mi.bd.s.bp;

import iih.mi.bd.d.EnTpBaseInfoDTO;
import iih.mi.bd.s.bp.sql.FindEnTpsByCodesSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;

/**
 * 根据HIS就诊类型编码查询医保就诊集合业务逻辑
 * 
 * @author dj.zhang, hao_wu
 *
 */
public class FindEnTpsByCodesBp {

	/**
	 * 执行查询逻辑
	 * 
	 * @param hpId
	 * @param enTpCodes
	 * @return EnTpBaseInfoDTO[]
	 * @throws DAException
	 */
	public EnTpBaseInfoDTO[] exec(String hpId, String[] enTpCodes) throws BizException {
		FindEnTpsByCodesSql sql = new FindEnTpsByCodesSql(hpId, enTpCodes);
		EnTpBaseInfoDTO[] result = (EnTpBaseInfoDTO[]) AppFwUtil.getDORstWithDao(sql, EnTpBaseInfoDTO.class);
		return result;
	}
}
