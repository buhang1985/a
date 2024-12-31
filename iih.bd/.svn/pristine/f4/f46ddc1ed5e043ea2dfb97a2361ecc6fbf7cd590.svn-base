package iih.bd.fc.entpwf.s.bp;
import iih.bd.fc.entpwf.d.BdEntpWfDO;
import iih.bd.fc.entpwf.d.desc.BdEntpWfDODesc;
import iih.bd.fc.entpwf.i.IEntpwfCudService;
import iih.bd.fc.entpwf.i.IEntpwfRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊流程定义AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEntpwfCudService.class,IEntpwfRService.class}, binding=Binding.JSONRPC)
public class EntpwfCrudServiceImpl extends TreeBaseDOService<BdEntpWfDO> implements IEntpwfCudService,IEntpwfRService {

    public EntpwfCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdEntpWfDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}

