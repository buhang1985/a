package iih.bd.srv.medvalidate.s;
import iih.bd.srv.medvalidate.d.BDErrorInfoItemDO;
import iih.bd.srv.medvalidate.d.desc.BDErrorInfoItemDODesc;
import iih.bd.srv.medvalidate.i.IBDErrorInfoItemDOCudService;
import iih.bd.srv.medvalidate.i.IBDErrorInfoItemDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 基础数据服务校验主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBDErrorInfoItemDOCudService.class,IBDErrorInfoItemDORService.class}, binding=Binding.JSONRPC)
public class BDErrorInfoItemDOCrudServiceImpl extends BaseDOService<BDErrorInfoItemDO> implements IBDErrorInfoItemDOCudService,IBDErrorInfoItemDORService {

    public BDErrorInfoItemDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BDErrorInfoItemDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

