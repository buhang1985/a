package iih.bl.st.blhperror.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.st.blhperror.d.desc.BlHpErrorDODesc;
import iih.bl.st.blhperror.d.BlHpErrorDO;
import iih.bl.st.blhperror.i.IBlhperrorCudService;
import iih.bl.st.blhperror.i.IBlhperrorRService;


/**
 * 医保异常交易记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlhperrorCudService.class,IBlhperrorRService.class}, binding=Binding.JSONRPC)
public class BlhperrorCrudServiceImpl extends BaseDOService<BlHpErrorDO> implements IBlhperrorCudService,IBlhperrorRService {
    public BlhperrorCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlHpErrorDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
}
