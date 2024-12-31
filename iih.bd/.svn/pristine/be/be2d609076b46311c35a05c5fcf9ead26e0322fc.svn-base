package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvNurseDO;
import iih.bd.srv.medsrv.d.desc.MedSrvNurseDODesc;
import iih.bd.srv.medsrv.i.IMedSrvNurseDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvNurseDORService;
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
@Service(serviceInterfaces={IMedSrvNurseDOCudService.class,IMedSrvNurseDORService.class}, binding=Binding.JSONRPC)
public class MedSrvNurseDOCrudServiceImpl extends BaseDOService<MedSrvNurseDO> implements IMedSrvNurseDOCudService,IMedSrvNurseDORService {

    public MedSrvNurseDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvNurseDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

