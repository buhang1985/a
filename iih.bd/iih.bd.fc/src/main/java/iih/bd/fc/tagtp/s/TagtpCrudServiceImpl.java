package iih.bd.fc.tagtp.s;
import iih.bd.fc.tagtp.d.BdTagTpDO;
import iih.bd.fc.tagtp.d.desc.BdTagTpDODesc;
import iih.bd.fc.tagtp.i.ITagtpCudService;
import iih.bd.fc.tagtp.i.ITagtpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;


/**
 * 标签AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ITagtpCudService.class,ITagtpRService.class}, binding=Binding.JSONRPC)
public class TagtpCrudServiceImpl extends BaseDOService<BdTagTpDO> implements ITagtpCudService,ITagtpRService {
    public TagtpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdTagTpDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
