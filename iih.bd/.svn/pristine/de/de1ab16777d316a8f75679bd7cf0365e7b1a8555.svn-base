package iih.bd.srv.s.bp.event;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.srv.iemsg.d.IESgOpDictDTO;
import iih.bd.srv.s.bp.iemsg.SetIEMsgInfo4SgOpDictBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

public class ReceiveSgOpDictInsertEvent4IeBP implements IBusinessListener {

	/**
	 * 手术与操作字典
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {

		if (event != null && IBdSrvIEEventConst.EVENT_IE_SGOP.equals(event.getSourceID())
				&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))
			this.exec((FArrayList2) event.getUserObject());
	}

	/**
	 * 逻辑处理
	 * 
	 * @param bizUserObj
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void exec(FArrayList2 bizUserObj) throws BizException {

		if (bizUserObj != null) {
			SetIEMsgInfo4SgOpDictBP bp = new SetIEMsgInfo4SgOpDictBP();
			bp.exec((IESgOpDictDTO[]) bizUserObj.toArray(new IESgOpDictDTO[bizUserObj.size()]));
		}
	}
}
