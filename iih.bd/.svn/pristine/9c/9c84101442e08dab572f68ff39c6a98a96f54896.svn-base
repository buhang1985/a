package iih.bd.srv.emrtpl.s;
import iih.bd.srv.emrtpl.d.MrTplRelDO;
import iih.bd.srv.emrtpl.d.desc.MrTplRelDODesc;
import iih.bd.srv.emrtpl.i.IMrTplRelDOCudService;
import iih.bd.srv.emrtpl.i.IMrTplRelDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗记录模板主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrTplRelDOCudService.class,IMrTplRelDORService.class}, binding=Binding.JSONRPC)
public class MrTplRelDOCrudServiceImpl extends BaseDOService<MrTplRelDO> implements IMrTplRelDOCudService,IMrTplRelDORService {

    public MrTplRelDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrTplRelDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

