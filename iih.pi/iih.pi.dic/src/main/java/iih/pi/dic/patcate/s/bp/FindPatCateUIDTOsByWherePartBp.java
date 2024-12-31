package iih.pi.dic.patcate.s.bp;

import java.util.ArrayList;

import iih.pi.dic.patcate.d.PatCateUIDTO;
import iih.pi.dic.patcate.s.bp.sql.FindPatCateUIDTOsByWherePartSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据查询条件查询患者分类UIDTO列表
 * 
 * @author dj.zhang
 *
 */
public class FindPatCateUIDTOsByWherePartBp {

	/**
	 * 执行逻辑
	 * 
	 * @param whereStr
	 * @param orderStr
	 * @return
	 * @throws BizException
	 */
	public PatCateUIDTO[] exec(String whereStr, String orderStr) throws BizException {
		FindPatCateUIDTOsByWherePartSql sql = new FindPatCateUIDTOsByWherePartSql(whereStr, orderStr);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<PatCateUIDTO> result = (ArrayList<PatCateUIDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(PatCateUIDTO.class));
		if (result == null) {
			return null;
		}
		return result.toArray(new PatCateUIDTO[0]);
	}

}
