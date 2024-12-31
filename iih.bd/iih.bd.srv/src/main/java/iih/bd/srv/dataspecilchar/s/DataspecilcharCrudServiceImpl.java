package iih.bd.srv.dataspecilchar.s;

import iih.bd.srv.dataspecilchar.d.DataSpecilCharDO;
import iih.bd.srv.dataspecilchar.d.desc.DataSpecilCharDODesc;
import iih.bd.srv.dataspecilchar.i.IDataspecilcharCudService;
import iih.bd.srv.dataspecilchar.i.IDataspecilcharRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 特殊字符AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IDataspecilcharCudService.class,
		IDataspecilcharRService.class }, binding = Binding.JSONRPC)
public class DataspecilcharCrudServiceImpl extends BaseDOService<DataSpecilCharDO>
		implements IDataspecilcharCudService, IDataspecilcharRService {
	public DataspecilcharCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DataSpecilCharDODesc.class), IAppFwTempTbl.tmp_iaw_03.name());
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
	protected Validator[] getUpdateValidator(DataSpecilCharDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
