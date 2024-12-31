package iih.bd.fc.mdwfmp.s;
import iih.bd.fc.mdwfmp.d.MdWfMpDO;
import iih.bd.fc.mdwfmp.d.desc.MdWfMpDODesc;
import iih.bd.fc.mdwfmp.i.IMdwfmpCudService;
import iih.bd.fc.mdwfmp.i.IMdwfmpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医嘱流向执行参数AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMdwfmpCudService.class,IMdwfmpRService.class}, binding=Binding.JSONRPC)
public class MdwfmpCrudServiceImpl extends BaseDOService<MdWfMpDO> implements IMdwfmpCudService,IMdwfmpRService {

    public MdwfmpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MdWfMpDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
}

