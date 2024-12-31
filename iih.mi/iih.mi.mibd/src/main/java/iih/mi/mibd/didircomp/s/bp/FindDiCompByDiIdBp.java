package iih.mi.mibd.didircomp.s.bp;

import java.util.ArrayList;
import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.didircomp.d.DiDirCompDTO;
import iih.mi.mibd.didircomp.s.bp.sql.FindDiCompsql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @ClassName: FindDiCompByDiIdBp
 * @Description: TODO
 * @author: dj.zhang
 * @date: 2018年2月6日 下午5:46:56
 */
public class FindDiCompByDiIdBp {

	public DiDirCompDTO[] exec(String misId, String[] diIds) throws BizException {
		
		String wherePart = SqlUtils.getInSqlByIds("BD_DI_DEF.ID_DIDEF", diIds);
		FindDiCompsql sql = new FindDiCompsql(misId,wherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<DiDirCompDTO> result = (ArrayList<DiDirCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(DiDirCompDTO.class));
		if(result == null){
			return null;
		}
		return result.toArray(new DiDirCompDTO[0]);
	}

}
