package iih.en.pv.enfee.s;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.d.EntAccActDO;
import iih.en.pv.enfee.d.desc.EntAccActDODesc;
import iih.en.pv.enfee.i.IEntAccActDOCudService;
import iih.en.pv.enfee.i.IEntAccActDORService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 患者就诊_就诊账户主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IEntAccActDOCudService.class, IEntAccActDORService.class }, binding = Binding.JSONRPC)
public class EntAccActDOCrudServiceImpl extends BaseDOService<EntAccActDO> implements
		IEntAccActDOCudService, IEntAccActDORService {

	public EntAccActDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(EntAccActDODesc.class), IAppFwTempTbl.tmp_iaw_20
				.name());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	// TODO 需要单写服务，不能在此写实现或覆盖父类实现。yank 2017-02-06
	@Override
	public PagingRtnData<EntAccActDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		PagingRtnData<EntAccActDO> ret = null;
		ret = super.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
		if (ret != null && ret.getPageData() != null && ret.getPageData().size() > 0) {
			FArrayList fa = ret.getPageData();
			Set<String> ids = new HashSet<String>();
			Map<String, String> map = new HashMap<String, String>();
			if (null != fa && fa.size() > 0) {
				for (Object o : fa) {
					EntAccActDO act = (EntAccActDO) o;
					ids.add(act.getId_entacc());
				}
				if (!ids.isEmpty()) {
					String sql = "select acc.id_entacc,pat.name from en_ent_acc acc "
							+ "left join pi_pat pat on acc.id_pat=pat.id_pat "
							+ " where "
							+ EnSqlUtils.getInSqlByIds("acc.id_entacc", ids.toArray(new String[0]));
					FArrayList list = AppFwUtil.getMapListWithDao(sql);
					if (null != list && list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							@SuppressWarnings("unchecked")
							Map<String, Object> obj = (Map<String, Object>) list.get(i);
							map.put(obj.get("id_entacc").toString(), obj.get("name").toString());
						}
					}
				}
			}
			for (Object o : fa) {
				EntAccActDO act = (EntAccActDO) o;
				act.setName_newcret("减少");
				if (new Integer(1).equals(act.getNewcret())) {
					act.setName_newcret("增加");
				}
				if (map.containsKey(act.getId_entacc())) {
					setNote(act, map.get(act.getId_entacc()));
				}
			}
		}
		return ret;
	}

	private void setNote(EntAccActDO act, String patname) {
		if (!EnValidator.isEmpty(act.getNote()) && !EnValidator.isEmpty(patname)) {
			act.setNote(act.getNote() + "@@" + patname);
		} else if (EnValidator.isEmpty(act.getNote())) {
			act.setNote("@name@" + patname);
		} else if (EnValidator.isEmpty(patname)) {
			act.setNote("@note@" + act.getNote());
		}
	}
}
