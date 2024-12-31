package iih.en.doc.endoc.s;
import iih.en.doc.endoc.d.EntDocFlupDO;
import iih.en.doc.endoc.d.desc.EntDocFlupDODesc;
import iih.en.doc.endoc.i.IEntdocflupCudService;
import iih.en.doc.endoc.i.IEntdocflupRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 随访记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEntdocflupCudService.class,IEntdocflupRService.class}, binding=Binding.JSONRPC)
public class EntdocflupCrudServiceImpl extends BaseDOService<EntDocFlupDO> implements IEntdocflupCudService,IEntdocflupRService {
	public EntdocflupCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EntDocFlupDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
