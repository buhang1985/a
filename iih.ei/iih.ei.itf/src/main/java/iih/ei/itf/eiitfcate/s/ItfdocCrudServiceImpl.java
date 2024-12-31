package iih.ei.itf.eiitfcate.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ei.itf.eiitfcate.d.desc.ItfDocTaskDODesc;
import iih.ei.itf.eiitfcate.d.ItfDocTaskDO;
import iih.ei.itf.eiitfcate.i.IItfdocCudService;
import iih.ei.itf.eiitfcate.i.IItfdocRService;
import iih.ei.itf.eiitfcate.s.rule.DelFileByTaskRule;

/**
 * 接口文档AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IItfdocCudService.class, IItfdocRService.class }, binding = Binding.JSONRPC)
public class ItfdocCrudServiceImpl extends BaseDOService<ItfDocTaskDO> implements IItfdocCudService, IItfdocRService {
	public ItfdocCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ItfDocTaskDODesc.class), IAppFwTempTbl.tmp_iaw_08.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteAfterRule(AroundProcesser<ItfDocTaskDO> processor) {
		super.addRealDeleteAfterRule(processor);
		processor.addAfterRule(new DelFileByTaskRule());
	}
}
