package iih.bd.res.bed.s;

import iih.bd.res.bed.d.BedAttrDefDO;
import iih.bd.res.bed.d.desc.BedAttrDefDODesc;
import iih.bd.res.bed.i.IBedattrdefCudService;
import iih.bd.res.bed.i.IBedattrdefRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 床位特征值定义AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IBedattrdefCudService.class, IBedattrdefRService.class }, binding = Binding.JSONRPC)
public class BedattrdefCrudServiceImpl extends BaseDOService<BedAttrDefDO>
		implements IBedattrdefCudService, IBedattrdefRService {

	public BedattrdefCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(BedAttrDefDODesc.class), IAppFwTempTbl.tmp_iaw_23.name());
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
	protected Validator[] getUpdateValidator(BedAttrDefDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
