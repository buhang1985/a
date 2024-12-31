package iih.bd.srv.diagdef.s;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.srv.diagdef.d.DiagCompDO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.DiagdefAggDO;
import iih.bd.srv.diagdef.d.desc.DiagDefDODesc;
import iih.bd.srv.diagdef.i.IDiagdefCudService;
import iih.bd.srv.diagdef.i.IDiagdefRService;
import iih.bd.srv.diagdef.validator.DiaDefUnicValidate;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.AggNullValueValidator;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗服务_疾病诊断定义AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IDiagdefCudService.class, IDiagdefRService.class }, binding = Binding.JSONRPC)
public class DiagdefCrudServiceImpl extends BaseAggService<DiagdefAggDO, DiagDefDO>
		implements IDiagdefCudService, IDiagdefRService {

	public DiagdefCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(DiagDefDODesc.class), IAppFwTempTbl.tmp_iaw_18.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		Map<IDODesc, List<String>> m = new HashMap<>();
		m.put(new DiagDefDO().getDODesc(), Arrays.asList(DiagDefDO.NAME, DiagDefDO.CODE));
		m.put(new DiagCompDO().getDODesc(), Arrays.asList(DiagCompDO.ID_DISTD_COMP));
		return new Validator[] { new BDUniqueRuleValidate(), new DiaDefUnicValidate(),
				AggNullValueValidator.createMDNullValueValidator(new DiagdefAggDO().getAggDesc(), m)

		};

	}

	@Override
	protected Validator[] getUpdateValidator(DiagdefAggDO[] oldDOs) {

		Map<IDODesc, List<String>> m = new HashMap<>();
		m.put(new DiagDefDO().getDODesc(), Arrays.asList(DiagDefDO.NAME, DiagDefDO.CODE));
		m.put(new DiagCompDO().getDODesc(), Arrays.asList(DiagCompDO.ID_DISTD_COMP));

		return new Validator[] { new DiaDefUnicValidate(), new BDUniqueRuleValidate(),
				AggNullValueValidator.createMDNullValueValidator(new DiagdefAggDO().getAggDesc(), m) };
	}

}
