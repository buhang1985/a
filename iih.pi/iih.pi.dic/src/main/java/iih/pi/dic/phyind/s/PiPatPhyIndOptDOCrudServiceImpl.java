package iih.pi.dic.phyind.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.dic.phyind.d.desc.PiPatPhyIndOptDODesc;
import iih.pi.dic.phyind.d.PiPatPhyIndOptDO;
import iih.pi.dic.phyind.i.IPiPatPhyIndOptDOCudService;
import iih.pi.dic.phyind.i.IPiPatPhyIndOptDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者生理指标主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatPhyIndOptDOCudService.class,IPiPatPhyIndOptDORService.class}, binding=Binding.JSONRPC)
public class PiPatPhyIndOptDOCrudServiceImpl extends BaseDOService<PiPatPhyIndOptDO> implements IPiPatPhyIndOptDOCudService,IPiPatPhyIndOptDORService {

    public PiPatPhyIndOptDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatPhyIndOptDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

