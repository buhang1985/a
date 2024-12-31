package iih.en.pv.s.bp;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.d.EntAccActDO;
import iih.en.pv.enfee.i.IEntAccActDORService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class GetAccAdjListBP {
	/**
	 * 信用度调整记录查询
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EntAccActDO> exec(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		PagingRtnData<EntAccActDO> ret = null;
		IEntAccActDORService doService =ServiceFinder.find(IEntAccActDORService.class);
		ret = doService.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
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
