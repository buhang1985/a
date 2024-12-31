package iih.pi.dic.external.s.bp;

import iih.pi.dic.external.d.PatCateBaseDTO;
import iih.pi.dic.external.s.bp.sql.FindPatcateByIdSql;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;

/**
 * 查询患者分类信息
 * 
 * @author dj.zhang
 *
 */
public class FindPatcateByIdBp {

	public PatCateBaseDTO exec(String patId) throws DAException {
		FindPatcateByIdSql sql = new FindPatcateByIdSql(patId);
		DAFacade daFacade = new DAFacade();
		PatCateBaseDTO result = (PatCateBaseDTO) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null),
				new BeanHandler(PatCateBaseDTO.class));

		return result;
	}

}
