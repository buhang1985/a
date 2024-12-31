package iih.bd.srv.notice.s;

import iih.bd.srv.notice.d.NoticeCaDO;
import iih.bd.srv.notice.d.desc.NoticeCaDODesc;
import iih.bd.srv.notice.i.INoticecaCudService;
import iih.bd.srv.notice.i.INoticecaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 临床注意事项AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { INoticecaCudService.class, INoticecaRService.class }, binding = Binding.JSONRPC)
public class NoticecaCrudServiceImpl extends TreeBaseDOService<NoticeCaDO>
		implements INoticecaCudService, INoticecaRService {
	public NoticecaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(NoticeCaDODesc.class), IAppFwTempTbl.tmp_iaw_07.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(NoticeCaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
