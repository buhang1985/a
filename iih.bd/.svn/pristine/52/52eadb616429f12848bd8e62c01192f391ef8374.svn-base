package iih.bd.srv.srvselfcaitm.s;
import iih.bd.srv.srvselfcaitm.d.SrvSelfCaItmRelDO;
import iih.bd.srv.srvselfcaitm.d.desc.SrvSelfCaItmRelDODesc;
import iih.bd.srv.srvselfcaitm.i.ISrvSelfCaItmRelDOCudService;
import iih.bd.srv.srvselfcaitm.i.ISrvSelfCaItmRelDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 服务自定义分类项目主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISrvSelfCaItmRelDOCudService.class,ISrvSelfCaItmRelDORService.class}, binding=Binding.JSONRPC)
public class SrvSelfCaItmRelDOCrudServiceImpl extends BaseDOService<SrvSelfCaItmRelDO> implements ISrvSelfCaItmRelDOCudService,ISrvSelfCaItmRelDORService {

    public SrvSelfCaItmRelDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvSelfCaItmRelDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

