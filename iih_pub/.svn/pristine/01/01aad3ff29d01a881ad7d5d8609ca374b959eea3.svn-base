package iih.bd.base.utils;

import iih.bd.utils.log.BdMmLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.ef.core.EventHandler;
import xap.mw.sf.core.rpc.event.PostRpcEvent;

public class PostRpcEventHandler implements EventHandler<PostRpcEvent> {

	@Override
	public void handleEvent(PostRpcEvent arg0) {
		try {
			TempTableUtils.deleteData();
		} catch (BizException e) {
			BdMmLogUtils.logExAndTitle(e, "删除临时表数据失败");
		}
	}

}
