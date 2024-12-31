package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvRelOeDO;
import iih.bd.srv.medsrv.d.desc.MedSrvRelOeDODesc;
import iih.bd.srv.medsrv.i.IMedSrvRelOeDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvRelOeDORService;
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
@Service(serviceInterfaces={IMedSrvRelOeDOCudService.class,IMedSrvRelOeDORService.class}, binding=Binding.JSONRPC)
public class MedSrvRelOeDOCrudServiceImpl extends BaseDOService<MedSrvRelOeDO> implements IMedSrvRelOeDOCudService,IMedSrvRelOeDORService {

    public MedSrvRelOeDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvRelOeDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

