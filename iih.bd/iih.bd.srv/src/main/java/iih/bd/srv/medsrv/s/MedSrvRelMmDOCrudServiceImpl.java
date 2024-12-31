package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvRelMmDO;
import iih.bd.srv.medsrv.d.desc.MedSrvRelMmDODesc;
import iih.bd.srv.medsrv.i.IMedSrvRelMmDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvRelMmDORService;
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
@Service(serviceInterfaces={IMedSrvRelMmDOCudService.class,IMedSrvRelMmDORService.class}, binding=Binding.JSONRPC)
public class MedSrvRelMmDOCrudServiceImpl extends BaseDOService<MedSrvRelMmDO> implements IMedSrvRelMmDOCudService,IMedSrvRelMmDORService {

    public MedSrvRelMmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvRelMmDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

