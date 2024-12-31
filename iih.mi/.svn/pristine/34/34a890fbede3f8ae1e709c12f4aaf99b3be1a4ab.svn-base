package iih.mi.biz.ip.ipreg.bp;

import iih.mi.biz.constant.BusinessEventConst;
import iih.mi.biz.mihptransact.d.MihptransactAggDO;
import iih.mi.biz.mihptransact.i.IMihptransactCudService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;

public class IpRegisterBp {

	public FBoolean exec(MihptransactAggDO aggDO) throws BizException
	{		
		//交易日志保存
		IMihptransactCudService service=ServiceFinder.find(IMihptransactCudService.class);
//		MihptransactAggDO[] aggDos=service.save(new MihptransactAggDO[]{aggDO});
		MihptransactAggDO[] aggDos=null;
		EventDispatcher.fireEvent(new BusinessEvent(BusinessEventConst.UPLOADINPREGISTER,
				IEventType.TYPE_INSERT_AFTER,null));
		return FBoolean.TRUE;
	}
}
