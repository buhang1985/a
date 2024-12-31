package iih.ci.ord.s.bp.ordprn;

import iih.ci.ord.ordprn.d.OrdPrintDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 删除已打印医嘱（逻辑删除）
 * @author Young
 *
 */
public class OrdPrintDODeleteBP {

	public void exec(OrdPrintDO[] printDos) throws BizException {

		this.delete(printDos);
	}
	
	private void delete(OrdPrintDO[] printDos) throws BizException {
		
//		new DAFacade().deleteDOs(printDos);
		new DAFacade().updateDOs(printDos);
	}
}
