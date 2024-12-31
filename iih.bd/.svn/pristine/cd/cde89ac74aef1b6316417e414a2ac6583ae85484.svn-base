package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvRelOfDO;
import iih.bd.srv.medsrv.d.desc.MedSrvRelOfDODesc;
import iih.bd.srv.medsrv.i.IMedSrvRelOfDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvRelOfDORService;
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
@Service(serviceInterfaces={IMedSrvRelOfDOCudService.class,IMedSrvRelOfDORService.class}, binding=Binding.JSONRPC)
public class MedSrvRelOfDOCrudServiceImpl extends BaseDOService<MedSrvRelOfDO> implements IMedSrvRelOfDOCudService,IMedSrvRelOfDORService {

    public MedSrvRelOfDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvRelOfDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

