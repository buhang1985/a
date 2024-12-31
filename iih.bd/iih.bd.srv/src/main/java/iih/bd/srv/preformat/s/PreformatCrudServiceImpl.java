package iih.bd.srv.preformat.s;

import iih.bd.srv.preformat.d.MrPreFormatDO;
import iih.bd.srv.preformat.d.desc.MrPreFormatDODesc;
import iih.bd.srv.preformat.i.IPreformatCudService;
import iih.bd.srv.preformat.i.IPreformatRService;
import iih.bd.srv.preformat.s.bp.FillMrEdInfoBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 处方格式AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IPreformatCudService.class, IPreformatRService.class }, binding = Binding.JSONRPC)
public class PreformatCrudServiceImpl extends BaseDOService<MrPreFormatDO>
		implements IPreformatCudService, IPreformatRService {
	public PreformatCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MrPreFormatDODesc.class), IAppFwTempTbl.tmp_iaw_14.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MrPreFormatDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@SuppressWarnings("unchecked")
	@Override
	public PagingRtnData<MrPreFormatDO> findByPageInfo(PaginationInfo pg, String whereStr, String orderStr)
			throws BizException {
		PagingRtnData<MrPreFormatDO> rtnData = super.findByPageInfo(pg, whereStr, orderStr);
		if (rtnData != null && rtnData.getPageData() != null) {
			FillMrEdInfoBp bp = new FillMrEdInfoBp();
			bp.exec((MrPreFormatDO[]) rtnData.getPageData().toArray(new MrPreFormatDO[0]));
		}
		return rtnData;
	}
}
