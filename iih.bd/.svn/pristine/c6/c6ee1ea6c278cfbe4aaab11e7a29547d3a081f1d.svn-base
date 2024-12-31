package iih.bd.mhi.operatorupload.s;
import iih.bd.mhi.operatorupload.d.OperatorUploadDO;
import iih.bd.mhi.operatorupload.d.desc.OperatorUploadDODesc;
import iih.bd.mhi.operatorupload.i.IOperatoruploadCudService;
import iih.bd.mhi.operatorupload.i.IOperatoruploadRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医院操作员上传AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOperatoruploadCudService.class,IOperatoruploadRService.class}, binding=Binding.JSONRPC)
public class OperatoruploadCrudServiceImpl extends BaseDOService<OperatorUploadDO> implements IOperatoruploadCudService,IOperatoruploadRService {
    public OperatoruploadCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OperatorUploadDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}
