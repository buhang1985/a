package iih.nm.nhr.nmnhrschedrp.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import iih.nm.com.i.flow.ExecuHandleListener;
import iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpDO;

public class NhrSchedRpHandleListener extends ExecuHandleListener {

	private static final long serialVersionUID = 1L;

	// @Override
	// public void handle(Object obj, String id_task) throws BizException {
	//
	// if (obj == null)
	// return;
	//
	// // if (obj instanceof NhrSchedRpDO) {
	// // NhrSchedRpDO schedRpDo = (NhrSchedRpDO) obj;
	// // schedRpDo.setId_task(id_task);
	// // schedRpDo.setStatus(DOStatus.UPDATED);
	// // INmnhrschedrpCudService schedrp_cud =
	// ServiceFinder.find(INmnhrschedrpCudService.class);
	// // schedrp_cud.save(new NhrSchedRpDO[] { schedRpDo });
	// // }
	// }
}
