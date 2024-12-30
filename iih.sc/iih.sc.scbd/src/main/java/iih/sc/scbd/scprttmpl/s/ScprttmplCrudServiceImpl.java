package iih.sc.scbd.scprttmpl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.scprttmpl.d.desc.ScPrtTmplDODesc;
import iih.sc.scbd.scprttmpl.d.ScPrtTmplDO;
import iih.sc.scbd.scprttmpl.i.IScprttmplCudService;
import iih.sc.scbd.scprttmpl.i.IScprttmplRService;


/**
 * 预约打印模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScprttmplCudService.class,IScprttmplRService.class}, binding=Binding.JSONRPC)
public class ScprttmplCrudServiceImpl extends BaseDOService<ScPrtTmplDO> implements IScprttmplCudService,IScprttmplRService {
    public ScprttmplCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPrtTmplDODesc.class),IAppFwTempTbl.tmp_iaw_03.name());
    }
}
