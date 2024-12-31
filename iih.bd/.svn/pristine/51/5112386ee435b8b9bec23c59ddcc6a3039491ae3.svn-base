package iih.bd.srv.s.bp.event;

import iih.bd.srv.iemsg.d.IESrvLisRelDictDTO;
import iih.bd.srv.s.bp.iemsg.SetIEMsgInfo4SrvLisRelBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

public class ReceiveSrvLisRelationEvent4IeBP implements IBusinessListener {

	private static String SourceID="iih.bd.srv.iemsg.d.IESrvLisRelDictDTO";
	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		// 1、验证
		if (!validation(arg0)) {
			return;
		}
		// 2、取参数
		FArrayList2 bizUserObj = (FArrayList2) arg0.getUserObject();
		// 3、逻辑处理
				this.exec(bizUserObj);
	}

	/**
	 * 验证
	 * 
	 * @param arg0
	 * @return
	 */
	private boolean validation(IBusinessEvent arg0) {

		if (SourceID.equals(arg0.getSourceID()) && IEventType.TYPE_UPDATE_AFTER.equals(arg0.getEventType())) {
			return true;
		}

		return false;
	}

	/**
	 * 逻辑处理
	 * 
	 * @param bizUserObj
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void exec(FArrayList2 bizUserObj) throws BizException {

		SetIEMsgInfo4SrvLisRelBP bp = new SetIEMsgInfo4SrvLisRelBP();
		bp.exec((IESrvLisRelDictDTO[]) bizUserObj.toArray(new IESrvLisRelDictDTO[bizUserObj.size()]));
	}


}
