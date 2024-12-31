package iih.bd.srv.emrtpl.s;

import iih.bd.bc.udi.pub.ISuMrptlConst;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.d.desc.EmrTplDODesc;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import iih.bd.srv.emrtpl.i.IEmrtplMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.utils.QryConditionUtil;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.tmpl.qryscheme.operators.NotLikeOperator;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryFilterNodeDTO;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗记录模板主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IEmrtplMDOCudService.class, IEmrtplMDORService.class }, binding = Binding.JSONRPC)
public class EmrtplMDOCrudServiceImpl extends BaseDOService<EmrTplDO>
		implements IEmrtplMDOCudService, IEmrtplMDORService {

	public EmrtplMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EmrTplDODesc.class), IAppFwTempTbl.tmp_iaw_08.name());
	}

	@Override
	public EmrTplDO[] findByQCond(QryRootNodeDTO qryRootNodeDTO, String orderStr, FBoolean isLazy) throws BizException {
		// 先用工具类构造一个查询条件，参数依次为do 全路径类名、do的属性名、操作符，查询值
		QryFilterNodeDTO aQryFilterNodeDTO1 = QryConditionUtil.createQryCond(EmrTplDO.class.getName(),
				EmrTplDO.SD_SU_MRPTL, NotLikeOperator.getInstance(), ISuMrptlConst.SD_SUMRPTL_NEW);
		QryFilterNodeDTO aQryFilterNodeDTO2 = QryConditionUtil.createQryCond(EmrTplDO.class.getName(),
				EmrTplDO.SD_SU_MRPTL, NotLikeOperator.getInstance(), "0");
		// 将新构造的查询条件加入到查询根条件
		qryRootNodeDTO = QryConditionUtil.appendQryCond(qryRootNodeDTO, aQryFilterNodeDTO1);
		qryRootNodeDTO = QryConditionUtil.appendQryCond(qryRootNodeDTO, aQryFilterNodeDTO2);
		return super.findByQCond(qryRootNodeDTO, orderStr, isLazy);
	}

	@Override
	public PagingRtnData<EmrTplDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		// 先用工具类构造一个查询条件，参数依次为do 全路径类名、do的属性名、操作符，查询值
		QryFilterNodeDTO aQryFilterNodeDTO1 = QryConditionUtil.createQryCond(EmrTplDO.class.getName(),
				EmrTplDO.SD_SU_MRPTL, NotLikeOperator.getInstance(), ISuMrptlConst.SD_SUMRPTL_NEW);
		QryFilterNodeDTO aQryFilterNodeDTO2 = QryConditionUtil.createQryCond(EmrTplDO.class.getName(),
				EmrTplDO.SD_SU_MRPTL, NotLikeOperator.getInstance(), "0");
		// 将新构造的查询条件加入到查询根条件
		qryRootNodeDTO = QryConditionUtil.appendQryCond(qryRootNodeDTO, aQryFilterNodeDTO1);
		qryRootNodeDTO = QryConditionUtil.appendQryCond(qryRootNodeDTO, aQryFilterNodeDTO2);
		PagingRtnData<EmrTplDO> result = super.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
		return result;
	}
	
	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrTplDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
