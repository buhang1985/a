package iih.bd.srv.oth.s;
import iih.bd.srv.oth.d.MedSrvWordFreqDO;
import iih.bd.srv.oth.d.desc.MedSrvWordFreqDODesc;
import iih.bd.srv.oth.i.IOthCudService;
import iih.bd.srv.oth.i.IOthRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务词频统计AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOthCudService.class,IOthRService.class}, binding=Binding.JSONRPC)
public class OthCrudServiceImpl extends BaseDOService<MedSrvWordFreqDO> implements IOthCudService,IOthRService {

    public OthCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvWordFreqDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
}

