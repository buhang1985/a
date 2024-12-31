package iih.mi.mibd.prestp.s;

import iih.mi.mibd.prestp.d.PrestpDO;
import iih.mi.mibd.prestp.d.desc.PrestpDODesc;
import iih.mi.mibd.prestp.i.IPrestpCudService;
import iih.mi.mibd.prestp.i.IPrestpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 医保平台_处方类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPrestpCudService.class, IPrestpRService.class }, binding = Binding.JSONRPC)
public class PrestpCrudServiceImpl extends BaseDOService<PrestpDO> implements IPrestpCudService, IPrestpRService {
	public PrestpCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(PrestpDODesc.class), IAppFwTempTbl.tmp_iaw_17.name());
	}
}
