package iih.bd.srv.oth.s;
import iih.bd.srv.oth.d.SrvDescCfgDO;
import iih.bd.srv.oth.d.desc.SrvDescCfgDODesc;
import iih.bd.srv.oth.i.ISrvdesccfgdoCudService;
import iih.bd.srv.oth.i.ISrvdesccfgdoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvdesccfgdoCudService.class,ISrvdesccfgdoRService.class}, binding=Binding.JSONRPC)
public class SrvdesccfgdoCrudServiceImpl extends BaseDOService<SrvDescCfgDO> implements ISrvdesccfgdoCudService,ISrvdesccfgdoRService {

    public SrvdesccfgdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvDescCfgDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}

