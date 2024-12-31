package iih.bd.mm.supplierprotocol.s;
import iih.bd.mm.supplierprotocol.d.ProtocolGoodsDO;
import iih.bd.mm.supplierprotocol.d.desc.ProtocolGoodsDODesc;
import iih.bd.mm.supplierprotocol.i.IProtocolGoodsDOCudService;
import iih.bd.mm.supplierprotocol.i.IProtocolGoodsDORService;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 供应商关系及协议主实体CRUD服务实现
 */
public class ProtocolGoodsDOCrudServiceImpl extends BaseDOService<ProtocolGoodsDO> implements IProtocolGoodsDOCudService,IProtocolGoodsDORService {

    public ProtocolGoodsDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ProtocolGoodsDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

