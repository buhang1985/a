package iih.bd.fc.wf.s;
import iih.bd.fc.wf.d.WfSrvtpDO;
import iih.bd.fc.wf.d.desc.WfSrvtpDODesc;
import iih.bd.fc.wf.i.IWfSrvtpDOCudService;
import iih.bd.fc.wf.i.IWfSrvtpDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 流程配置_医嘱流向主实体CRUD服务实现
 */
@Service(serviceInterfaces={IWfSrvtpDOCudService.class,IWfSrvtpDORService.class}, binding=Binding.JSONRPC)
public class WfSrvtpDOCrudServiceImpl extends BaseDOService<WfSrvtpDO> implements IWfSrvtpDOCudService,IWfSrvtpDORService {

    public WfSrvtpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(WfSrvtpDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

