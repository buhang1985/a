package iih.bd.srv.paragraphtype.s;

import iih.bd.srv.paragraphtype.d.ParagraphTypeDO;
import iih.bd.srv.paragraphtype.d.desc.ParagraphTypeDODesc;
import iih.bd.srv.paragraphtype.i.IParagraphtypeCudService;
import iih.bd.srv.paragraphtype.i.IParagraphtypeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IParagraphtypeCudService.class,
		IParagraphtypeRService.class }, binding = Binding.JSONRPC)
public class ParagraphtypeCrudServiceImpl extends BaseDOService<ParagraphTypeDO>
		implements IParagraphtypeCudService, IParagraphtypeRService {

	public ParagraphtypeCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(ParagraphTypeDODesc.class), IAppFwTempTbl.tmp_iaw_10.name());
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
	protected Validator[] getUpdateValidator(ParagraphTypeDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
