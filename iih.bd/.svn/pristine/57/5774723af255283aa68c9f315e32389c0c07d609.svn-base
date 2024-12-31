package iih.bd.srv.mrmtype.s;
import iih.bd.srv.mrmtype.d.MrmTypeMrtpDO;
import iih.bd.srv.mrmtype.d.desc.MrmTypeMrtpDODesc;
import iih.bd.srv.mrmtype.i.IMrmTypeMrtpDOCudService;
import iih.bd.srv.mrmtype.i.IMrmTypeMrtpDORService;
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
@Service(serviceInterfaces={IMrmTypeMrtpDOCudService.class,IMrmTypeMrtpDORService.class}, binding=Binding.JSONRPC)
public class MrmTypeMrtpDOCrudServiceImpl extends BaseDOService<MrmTypeMrtpDO> implements IMrmTypeMrtpDOCudService,IMrmTypeMrtpDORService {

    public MrmTypeMrtpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrmTypeMrtpDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

