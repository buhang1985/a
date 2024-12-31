package iih.bd.srv.mrbasetpl.bp;

import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 假删除医疗记录基础模板文件流业务逻辑
 * 
 * @author hao_wu
 *
 */
public class LogicDeleteFsBp {
	public void exec(EmrBaseTplDO emrBaseTplDO) throws DAException {
		String sql = String.format("UPDATE BD_BASE_MRTPL_FS SET DS = 1 WHERE ID_BASEMRTPL = '%s'",
				emrBaseTplDO.getId_basemrtpl());
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql);
	}
}
