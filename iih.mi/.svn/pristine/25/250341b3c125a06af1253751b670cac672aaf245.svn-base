package iih.mi.mibd.srvfac.s;

import iih.mi.mibd.srvfac.d.SrvfacDO;
import iih.mi.mibd.srvfac.d.desc.SrvfacDODesc;
import iih.mi.mibd.srvfac.i.ISrvfacCudService;
import iih.mi.mibd.srvfac.i.ISrvfacRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 医保平台_服务设施AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { ISrvfacCudService.class, ISrvfacRService.class }, binding = Binding.JSONRPC)
public class SrvfacCrudServiceImpl extends BaseDOService<SrvfacDO> implements ISrvfacCudService, ISrvfacRService {
	public SrvfacCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(SrvfacDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}
}
