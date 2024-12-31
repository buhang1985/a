package iih.mi.bd.miudidoclist.s;
import java.util.Arrays;

import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import iih.mi.bd.miudidoclist.d.desc.MiUdidoclistDODesc;
import iih.mi.bd.miudidoclist.i.IMiudidoclistCudService;
import iih.mi.bd.miudidoclist.i.IMiudidoclistRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医保档案类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMiudidoclistCudService.class,IMiudidoclistRService.class}, binding=Binding.JSONRPC)
public class MiudidoclistCrudServiceImpl extends BaseDOService<MiUdidoclistDO> implements IMiudidoclistCudService,IMiudidoclistRService {
    public MiudidoclistCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiUdidoclistDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { 
   				new BDUniqueRuleValidate(),
   				NullValueValidator.createMDNullValueValidator(new MiUdidoclistDO().getDODesc(), Arrays.asList(MiUdidoclistDO.NAME,MiUdidoclistDO.CODE))
   				};
	}

	@Override
	protected Validator[] getUpdateValidator(MiUdidoclistDO[] oldDOs) {
		return new Validator[] { 
   				new BDUniqueRuleValidate(),
   				NullValueValidator.createMDNullValueValidator(new MiUdidoclistDO().getDODesc(), Arrays.asList(MiUdidoclistDO.NAME,MiUdidoclistDO.CODE))
   				};
	}
	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}


}
