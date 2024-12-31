package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvRelMrDO;
import iih.bd.srv.medsrv.d.desc.MedSrvRelMrDODesc;
import iih.bd.srv.medsrv.i.IMedSrvRelMrDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvRelMrDORService;
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
@Service(serviceInterfaces={IMedSrvRelMrDOCudService.class,IMedSrvRelMrDORService.class}, binding=Binding.JSONRPC)
public class MedSrvRelMrDOCrudServiceImpl extends BaseDOService<MedSrvRelMrDO> implements IMedSrvRelMrDOCudService,IMedSrvRelMrDORService {

    public MedSrvRelMrDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvRelMrDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

