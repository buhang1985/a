package iih.bd.srv.qcconreject.s;
import iih.bd.srv.qcconreject.d.QcconrejectitemDO;
import iih.bd.srv.qcconreject.d.desc.QcconrejectitemDODesc;
import iih.bd.srv.qcconreject.i.IQcconrejectitemDOCudService;
import iih.bd.srv.qcconreject.i.IQcconrejectitemDORService;
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
@Service(serviceInterfaces={IQcconrejectitemDOCudService.class,IQcconrejectitemDORService.class}, binding=Binding.JSONRPC)
public class QcconrejectitemDOCrudServiceImpl extends BaseDOService<QcconrejectitemDO> implements IQcconrejectitemDOCudService,IQcconrejectitemDORService {

    public QcconrejectitemDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QcconrejectitemDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

