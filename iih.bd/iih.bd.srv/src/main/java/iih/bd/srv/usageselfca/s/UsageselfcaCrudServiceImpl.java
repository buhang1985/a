package iih.bd.srv.usageselfca.s;
import iih.bd.srv.usageselfca.d.UsageSlefCateDO;
import iih.bd.srv.usageselfca.d.desc.UsageSlefCateDODesc;
import iih.bd.srv.usageselfca.i.IUsageselfcaCudService;
import iih.bd.srv.usageselfca.i.IUsageselfcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IUsageselfcaCudService.class,IUsageselfcaRService.class}, binding=Binding.JSONRPC)
public class UsageselfcaCrudServiceImpl extends BaseDOService<UsageSlefCateDO> implements IUsageselfcaCudService,IUsageselfcaRService {

    public UsageselfcaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(UsageSlefCateDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}

