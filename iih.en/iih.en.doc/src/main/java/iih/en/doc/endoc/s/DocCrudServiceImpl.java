package iih.en.doc.endoc.s;
import iih.en.doc.endoc.d.EntDocDO;
import iih.en.doc.endoc.d.desc.EntDocDODesc;
import iih.en.doc.endoc.i.IDocCudService;
import iih.en.doc.endoc.i.IDocRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊建档AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDocCudService.class,IDocRService.class}, binding=Binding.JSONRPC)
public class DocCrudServiceImpl extends BaseDOService<EntDocDO> implements IDocCudService,IDocRService {
    public DocCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EntDocDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
