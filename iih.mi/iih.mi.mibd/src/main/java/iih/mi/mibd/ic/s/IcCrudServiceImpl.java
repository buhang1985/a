package iih.mi.mibd.ic.s;

import iih.mi.mibd.ic.d.IcDO;
import iih.mi.mibd.ic.d.desc.IcDODesc;
import iih.mi.mibd.ic.i.IIcCudService;
import iih.mi.mibd.ic.i.IIcRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 医保平台_险种AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IIcCudService.class, IIcRService.class }, binding = Binding.JSONRPC)
public class IcCrudServiceImpl extends BaseDOService<IcDO> implements IIcCudService, IIcRService {
	public IcCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(IcDODesc.class), IAppFwTempTbl.tmp_iaw_25.name());
	}
}
