package iih.ci.ord.s.bp.orsms.lis.listener;

import java.util.List;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.mergetube.BaseMergeTubeListener;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 检验合单逻辑
 * @author iih-pc
 *
 */
public class MergeTubeAction {
	public List<CiLisOrSmsIoDTO> megeTube(CiEnContextDTO ctx, List<CiLisOrSmsIoDTO> orsmsiolists) throws BizException{
		FMap2 fmap2 = new FMap2();
		Object[] params = new Object[]{ctx,orsmsiolists,fmap2};
		BDCommonEvent event = new BDCommonEvent(BaseMergeTubeListener.SourceId_LisMerge, IEventType.TYPE_UPDATE_AFTER, params);
		EventDispatcher.fireEvent(event);
		orsmsiolists = (List<CiLisOrSmsIoDTO>)fmap2.get("MergeTube");
		return orsmsiolists;
	}
}
