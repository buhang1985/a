package iih.bd.srv.mrbasetpl.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.mrbasetpl.s.bp.qry.FindMrTplCountByBaseTplIdQry;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 根据基础模板主键查询病历模板个数
 * 
 * @author hao_wu 2019-11-25
 *
 */
public class FindMrTplCountByBaseTplIdBp {

	public Integer exec(String baseTplId) throws BizException {
		if (StringUtils.isBlank(baseTplId)) {
			throw new BizException();
		}

		FindMrTplCountByBaseTplIdQry qry = new FindMrTplCountByBaseTplIdQry(baseTplId);
		DAFacade daFacade = new DAFacade();
		Integer mtTplCount = (Integer) daFacade.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null),
				new ColumnHandler());
		return mtTplCount;
	}

}
