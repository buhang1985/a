package iih.bd.srv.emsobsindex.s;
import iih.bd.srv.emsobsindex.d.EmsObsIndexDO;
import iih.bd.srv.emsobsindex.d.desc.EmsObsIndexDODesc;
import iih.bd.srv.emsobsindex.i.IEmsobsindexCudService;
import iih.bd.srv.emsobsindex.i.IEmsobsindexRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗单观测指标定义AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEmsobsindexCudService.class,IEmsobsindexRService.class}, binding=Binding.JSONRPC)
public class EmsobsindexCrudServiceImpl extends BaseDOService<EmsObsIndexDO> implements IEmsobsindexCudService,IEmsobsindexRService {

    public EmsobsindexCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmsObsIndexDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}

