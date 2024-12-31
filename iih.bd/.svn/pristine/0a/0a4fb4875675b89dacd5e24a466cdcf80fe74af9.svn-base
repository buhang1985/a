package iih.bd.srv.qcmraddrule.s;
import iih.bd.srv.qcmraddrule.d.QcmraddpreruleDO;
import iih.bd.srv.qcmraddrule.d.desc.QcmraddpreruleDODesc;
import iih.bd.srv.qcmraddrule.i.IQcmraddpreruleDOCudService;
import iih.bd.srv.qcmraddrule.i.IQcmraddpreruleDORService;
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
@Service(serviceInterfaces={IQcmraddpreruleDOCudService.class,IQcmraddpreruleDORService.class}, binding=Binding.JSONRPC)
public class QcmraddpreruleDOCrudServiceImpl extends BaseDOService<QcmraddpreruleDO> implements IQcmraddpreruleDOCudService,IQcmraddpreruleDORService {

    public QcmraddpreruleDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QcmraddpreruleDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

