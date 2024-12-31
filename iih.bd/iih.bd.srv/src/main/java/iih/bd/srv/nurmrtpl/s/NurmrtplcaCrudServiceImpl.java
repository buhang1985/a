package iih.bd.srv.nurmrtpl.s;
import iih.bd.srv.nurmrtpl.d.NurMrConTplCaDO;
import iih.bd.srv.nurmrtpl.d.desc.NurMrConTplCaDODesc;
import iih.bd.srv.nurmrtpl.i.INurmrtplcaCudService;
import iih.bd.srv.nurmrtpl.i.INurmrtplcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 护理记录内容模板分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={INurmrtplcaCudService.class,INurmrtplcaRService.class}, binding=Binding.JSONRPC)
public class NurmrtplcaCrudServiceImpl extends BaseDOService<NurMrConTplCaDO> implements INurmrtplcaCudService,INurmrtplcaRService {

    public NurmrtplcaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(NurMrConTplCaDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
}

