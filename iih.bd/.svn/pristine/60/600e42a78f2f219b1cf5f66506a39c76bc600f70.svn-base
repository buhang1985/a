package iih.bd.srv.mrmtype.s;
import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.bd.srv.mrmtype.d.desc.MrmTypeDODesc;
import iih.bd.srv.mrmtype.i.IMrmtypeMDOCudService;
import iih.bd.srv.mrmtype.i.IMrmtypeMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 病案分类主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrmtypeMDOCudService.class,IMrmtypeMDORService.class}, binding=Binding.JSONRPC)
public class MrmtypeMDOCrudServiceImpl extends BaseDOService<MrmTypeDO> implements IMrmtypeMDOCudService,IMrmtypeMDORService {

    public MrmtypeMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrmTypeDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

