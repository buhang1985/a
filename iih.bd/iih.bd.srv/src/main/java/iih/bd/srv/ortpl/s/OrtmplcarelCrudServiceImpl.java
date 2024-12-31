package iih.bd.srv.ortpl.s;
import iih.bd.srv.ortpl.d.OrTmplCaRelDO;
import iih.bd.srv.ortpl.d.desc.OrTmplCaRelDODesc;
import iih.bd.srv.ortpl.i.IOrtmplcarelCudService;
import iih.bd.srv.ortpl.i.IOrtmplcarelRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医嘱模板与分类关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrtmplcarelCudService.class,IOrtmplcarelRService.class}, binding=Binding.JSONRPC)
public class OrtmplcarelCrudServiceImpl extends BaseDOService<OrTmplCaRelDO> implements IOrtmplcarelCudService,IOrtmplcarelRService {

    public OrtmplcarelCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrTmplCaRelDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
}

