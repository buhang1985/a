package iih.bd.srv.mrtplvt.s;
import iih.bd.srv.mrtplvt.d.MrtplVtDO;
import iih.bd.srv.mrtplvt.d.desc.MrtplVtDODesc;
import iih.bd.srv.mrtplvt.i.IMrtplvtMDOCudService;
import iih.bd.srv.mrtplvt.i.IMrtplvtMDORService;
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
@Service(serviceInterfaces={IMrtplvtMDOCudService.class,IMrtplvtMDORService.class}, binding=Binding.JSONRPC)
public class MrtplvtMDOCrudServiceImpl extends BaseDOService<MrtplVtDO> implements IMrtplvtMDOCudService,IMrtplvtMDORService {

    public MrtplvtMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrtplVtDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

