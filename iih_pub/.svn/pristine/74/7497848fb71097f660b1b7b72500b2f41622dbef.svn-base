package iih.ci.ord.i.mergetube;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.mergetube.d.MergeTubeRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 药品医嘱内容拼接基类监听，所有客开医嘱内容，都需要继承这个基类
 * @author zhangwq
 *
 */
public abstract class BaseMergeTubeListener implements IBusinessListener  {
	public static String SourceId_LisMerge = "MergeTubeListener";
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if(!(SourceId_LisMerge.equals(event.getSourceID())&&IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
			return;
		}
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(ArrayUtils.isEmpty(newObjs))return;
		CiEnContextDTO ctx = (CiEnContextDTO)newObjs[0];
		List<CiLisOrSmsIoDTO> orsmsiolists = (List<CiLisOrSmsIoDTO>)newObjs[1];
		FMap2 fmap2 = (FMap2)newObjs[2];
		doYourAction(ctx,orsmsiolists,fmap2);
	}
	/**
	 * 处理自己的业务
	 * @param event
	 * @throws BizException
	 */
	public abstract void doYourAction(CiEnContextDTO ctx, List<CiLisOrSmsIoDTO> orsmsiolists,FMap2 fmap2) throws BizException;
}
