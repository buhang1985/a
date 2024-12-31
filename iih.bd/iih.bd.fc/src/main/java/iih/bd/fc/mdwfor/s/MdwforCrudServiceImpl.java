package iih.bd.fc.mdwfor.s;
import iih.bd.fc.mdwfor.d.MdWfOrDO;
import iih.bd.fc.mdwfor.d.desc.MdWfOrDODesc;
import iih.bd.fc.mdwfor.i.IMdwforCudService;
import iih.bd.fc.mdwfor.i.IMdwforRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医嘱流向开立参数AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMdwforCudService.class,IMdwforRService.class}, binding=Binding.JSONRPC)
public class MdwforCrudServiceImpl extends BaseDOService<MdWfOrDO> implements IMdwforCudService,IMdwforRService {

    public MdwforCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MdWfOrDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}

