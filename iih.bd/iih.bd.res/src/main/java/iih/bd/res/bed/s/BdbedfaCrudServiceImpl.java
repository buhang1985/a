package iih.bd.res.bed.s;

import iih.bd.res.bed.d.Bdbedfa;
import iih.bd.res.bed.d.desc.BdbedfaDesc;
import iih.bd.res.bed.i.IBdbedfaCudService;
import iih.bd.res.bed.i.IBdbedfaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 床位管理主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IBdbedfaCudService.class, IBdbedfaRService.class }, binding = Binding.JSONRPC)
public class BdbedfaCrudServiceImpl extends BaseDOService<Bdbedfa> implements IBdbedfaCudService, IBdbedfaRService {

	public BdbedfaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BdbedfaDesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(Bdbedfa[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
