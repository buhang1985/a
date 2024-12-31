package iih.ci.ord.doctorstationprinter.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.doctorstationprinter.d.desc.DoctorstationprinterDODesc;
import iih.ci.ord.doctorstationprinter.d.DoctorstationprinterDO;
import iih.ci.ord.doctorstationprinter.i.IDoctorstationprinterCudService;
import iih.ci.ord.doctorstationprinter.i.IDoctorstationprinterRService;


/**
 * 医生站打印机设置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDoctorstationprinterCudService.class,IDoctorstationprinterRService.class}, binding=Binding.JSONRPC)
public class DoctorstationprinterCrudServiceImpl extends BaseDOService<DoctorstationprinterDO> implements IDoctorstationprinterCudService,IDoctorstationprinterRService {
    public DoctorstationprinterCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DoctorstationprinterDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
}
