package iih.bd.srv.mrtplvt.s;
import iih.bd.srv.mrtplvt.d.MrtplVtItmDO;
import iih.bd.srv.mrtplvt.d.desc.MrtplVtItmDODesc;
import iih.bd.srv.mrtplvt.i.IMrtplVtItmDOCudService;
import iih.bd.srv.mrtplvt.i.IMrtplVtItmDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 生命体征测量主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplVtItmDOCudService.class,IMrtplVtItmDORService.class}, binding=Binding.JSONRPC)
public class MrtplVtItmDOCrudServiceImpl extends BaseDOService<MrtplVtItmDO> implements IMrtplVtItmDOCudService,IMrtplVtItmDORService {

    public MrtplVtItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrtplVtItmDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

