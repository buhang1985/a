package iih.en.que.board.s;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.d.desc.EnBrdCallDODesc;
import iih.en.que.board.i.IEbbrdcalldoCudService;
import iih.en.que.board.i.IEbbrdcalldoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 大屏叫号信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEbbrdcalldoCudService.class,IEbbrdcalldoRService.class}, binding=Binding.JSONRPC)
public class EbbrdcalldoCrudServiceImpl extends BaseDOService<EnBrdCallDO> implements IEbbrdcalldoCudService,IEbbrdcalldoRService {
    public EbbrdcalldoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnBrdCallDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
