package iih.bd.pp.itmpaynoonline.s;
import iih.bd.pp.itmpaynoonline.d.ItmpaynoonlineDO;
import iih.bd.pp.itmpaynoonline.d.desc.ItmpaynoonlineDODesc;
import iih.bd.pp.itmpaynoonline.i.IItmpaynoonlineCudService;
import iih.bd.pp.itmpaynoonline.i.IItmpaynoonlineRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 非线上收费项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IItmpaynoonlineCudService.class,IItmpaynoonlineRService.class}, binding=Binding.JSONRPC)
public class ItmpaynoonlineCrudServiceImpl extends BaseDOService<ItmpaynoonlineDO> implements IItmpaynoonlineCudService,IItmpaynoonlineRService {
    public ItmpaynoonlineCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ItmpaynoonlineDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}
