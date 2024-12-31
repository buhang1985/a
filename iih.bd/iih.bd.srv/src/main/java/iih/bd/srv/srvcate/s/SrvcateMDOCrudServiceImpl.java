package iih.bd.srv.srvcate.s;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.bd.srv.srvcate.d.desc.SrvCateDODesc;
import iih.bd.srv.srvcate.i.ISrvcateMDOCudService;
import iih.bd.srv.srvcate.i.ISrvcateMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务基本分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvcateMDOCudService.class,ISrvcateMDORService.class}, binding=Binding.JSONRPC)
public class SrvcateMDOCrudServiceImpl extends BaseDOService<SrvCateDO> implements ISrvcateMDOCudService,ISrvcateMDORService {

    public SrvcateMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvCateDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

