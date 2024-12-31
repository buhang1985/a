package iih.bd.srv.mrbasetpl.bp;

import iih.bd.srv.basemrtplfs.d.BaseMrTplStreamDO;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 真删除医疗记录基础模板文件流业务逻辑
 * 
 * @author hao_wu
 *
 */
public class RealDeleteFsBp {

	public void exec(EmrBaseTplDO emrBaseTplDO) throws DAException {
		String wherePart = String.format("ID_BASEMRTPL = '%s'", emrBaseTplDO.getId_basemrtpl());
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(BaseMrTplStreamDO.class, wherePart);
	}
}
