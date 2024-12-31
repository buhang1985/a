package iih.bd.srv.ortpl.s;
import iih.bd.srv.ortpl.d.RegularOrCaDO;
import iih.bd.srv.ortpl.d.desc.RegularOrCaDODesc;
import iih.bd.srv.ortpl.i.IRegularorcaCudService;
import iih.bd.srv.ortpl.i.IRegularorcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 常规医嘱分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IRegularorcaCudService.class,IRegularorcaRService.class}, binding=Binding.JSONRPC)
public class RegularorcaCrudServiceImpl extends TreeBaseDOService<RegularOrCaDO> implements IRegularorcaCudService,IRegularorcaRService {

    public RegularorcaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(RegularOrCaDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}

