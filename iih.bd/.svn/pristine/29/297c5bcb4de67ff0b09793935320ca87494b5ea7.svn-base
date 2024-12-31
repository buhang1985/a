package iih.bd.pp.incca.s;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.d.desc.IncCaItmRelDODesc;
import iih.bd.pp.incca.i.IInccaitmrelCudService;
import iih.bd.pp.incca.i.IInccaitmrelRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 票据分类项目对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IInccaitmrelCudService.class,IInccaitmrelRService.class}, binding=Binding.JSONRPC)
public class InccaitmrelCrudServiceImpl extends BaseDOService<IncCaItmRelDO> implements IInccaitmrelCudService,IInccaitmrelRService {

    public InccaitmrelCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(IncCaItmRelDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}

