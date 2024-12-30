package iih.sc.sch.sclock.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.sch.sclock.d.desc.ScSchLockDODesc;
import iih.sc.sch.sclock.d.ScSchLockDO;
import iih.sc.sch.sclock.i.IScschlockdoCudService;
import iih.sc.sch.sclock.i.IScschlockdoRService;


/**
 * 号位锁定表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScschlockdoCudService.class,IScschlockdoRService.class}, binding=Binding.JSONRPC)
public class ScschlockdoCrudServiceImpl extends BaseDOService<ScSchLockDO> implements IScschlockdoCudService,IScschlockdoRService {
    public ScschlockdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSchLockDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
