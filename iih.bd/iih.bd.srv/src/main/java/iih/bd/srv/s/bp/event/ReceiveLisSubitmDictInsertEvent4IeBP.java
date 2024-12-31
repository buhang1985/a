package iih.bd.srv.s.bp.event;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.srv.iemsg.d.IELisSubitmDictDTO;
import iih.bd.srv.s.bp.iemsg.SetIEMsgInfo4LisSubitmDictBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

public class ReceiveLisSubitmDictInsertEvent4IeBP implements IBusinessListener {

	/**
	 * 检验子项目字典
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {

		if (event != null && IBdSrvIEEventConst.EVENT_IE_LISSUBITM.equals(event.getSourceID())
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
			SetIEMsgInfo4LisSubitmDictBP bp = new SetIEMsgInfo4LisSubitmDictBP();
			bp.exec((IELisSubitmDictDTO[]) bizUserObj.toArray(new IELisSubitmDictDTO[bizUserObj.size()]));
		}
	}

}
