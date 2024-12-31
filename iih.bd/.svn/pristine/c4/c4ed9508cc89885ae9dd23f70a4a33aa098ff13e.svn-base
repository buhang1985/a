package iih.bd.fc.sitechangerec.s;
import iih.bd.fc.sitechangerec.d.SiteChangeRecDO;
import iih.bd.fc.sitechangerec.d.desc.SiteChangeRecDODesc;
import iih.bd.fc.sitechangerec.i.ISitechangerecCudService;
import iih.bd.fc.sitechangerec.i.ISitechangerecRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 队列站点变更记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISitechangerecCudService.class,ISitechangerecRService.class}, binding=Binding.JSONRPC)
public class SitechangerecCrudServiceImpl extends BaseDOService<SiteChangeRecDO> implements ISitechangerecCudService,ISitechangerecRService {
    public SitechangerecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SiteChangeRecDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
