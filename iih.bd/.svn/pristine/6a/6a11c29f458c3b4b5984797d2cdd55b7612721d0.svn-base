package iih.bd.srv.mrelement.s;
import iih.bd.srv.mrelement.d.MrEleValDO;
import iih.bd.srv.mrelement.d.desc.MrEleValDODesc;
import iih.bd.srv.mrelement.i.IMrEleValDOCudService;
import iih.bd.srv.mrelement.i.IMrEleValDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 组件主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrEleValDOCudService.class,IMrEleValDORService.class}, binding=Binding.JSONRPC)
public class MrEleValDOCrudServiceImpl extends BaseDOService<MrEleValDO> implements IMrEleValDOCudService,IMrEleValDORService {

    public MrEleValDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrEleValDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

