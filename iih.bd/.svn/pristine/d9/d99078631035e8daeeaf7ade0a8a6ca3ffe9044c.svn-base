package iih.bd.pp.singlediamt.s;
import iih.bd.pp.singlediamt.d.SingleDiDepAmtDO;
import iih.bd.pp.singlediamt.d.desc.SingleDiDepAmtDODesc;
import iih.bd.pp.singlediamt.i.ISingleDiDepAmtDOCudService;
import iih.bd.pp.singlediamt.i.ISingleDiDepAmtDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医保计划单病种控费主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISingleDiDepAmtDOCudService.class,ISingleDiDepAmtDORService.class}, binding=Binding.JSONRPC)
public class SingleDiDepAmtDOCrudServiceImpl extends BaseDOService<SingleDiDepAmtDO> implements ISingleDiDepAmtDOCudService,ISingleDiDepAmtDORService {

    public SingleDiDepAmtDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SingleDiDepAmtDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

