package iih.bd.srv.qcconreject.s;
import iih.bd.srv.qcconreject.d.QcconrejectconDO;
import iih.bd.srv.qcconreject.d.desc.QcconrejectconDODesc;
import iih.bd.srv.qcconreject.i.IQcconrejectconDOCudService;
import iih.bd.srv.qcconreject.i.IQcconrejectconDORService;
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
@Service(serviceInterfaces={IQcconrejectconDOCudService.class,IQcconrejectconDORService.class}, binding=Binding.JSONRPC)
public class QcconrejectconDOCrudServiceImpl extends BaseDOService<QcconrejectconDO> implements IQcconrejectconDOCudService,IQcconrejectconDORService {

    public QcconrejectconDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QcconrejectconDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

