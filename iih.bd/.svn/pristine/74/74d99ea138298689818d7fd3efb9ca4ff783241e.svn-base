package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvDietDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDietDODesc;
import iih.bd.srv.medsrv.i.IMedSrvDietDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvDietDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMedSrvDietDOCudService.class,IMedSrvDietDORService.class}, binding=Binding.JSONRPC)
public class MedSrvDietDOCrudServiceImpl extends BaseDOService<MedSrvDietDO> implements IMedSrvDietDOCudService,IMedSrvDietDORService {

    public MedSrvDietDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvDietDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

