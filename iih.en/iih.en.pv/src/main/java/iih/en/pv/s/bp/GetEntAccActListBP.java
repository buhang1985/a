package iih.en.pv.s.bp;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.d.EntAccActDO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取就在账户操作明细集合
 * 
 * @author zcm
 *
 */
public class GetEntAccActListBP {
	/**
	 * 获取就在账户操作明细集合
	 * 
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 * @author zcm
	 */
	public PagingRtnData<EntAccActDO> exec(PaginationInfo pg, String entId) throws BizException {
		if (EnValidator.isEmpty(entId)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("select act.*,doc.name as emp_name,psn.name as name_emp_guarant,psn.code as code_emp_guarant ");
		sb.append("from ");
		sb.append("en_ent_acc_act act ");
		sb.append("inner join en_ent_acc acc on acc.id_entacc = act.id_entacc ");
		sb.append("inner join bd_psndoc doc on doc.id_psndoc = act.id_emp ");
		sb.append("left outer join bd_psndoc psn on psn.id_psndoc = act.id_emp_guarant ");
		sb.append("where ");
		sb.append("acc.id_ent = ? ");
		sb.append("order by act.sv desc");
		SqlParam params = new SqlParam();
		params.addParam(entId);
		PagingRtnData<EntAccActDO> ret = this.getRtnData(pg, sb.toString(), params);
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

	/**
	 * 查询数据
	 *
	 * @param pg
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private PagingRtnData<EntAccActDO> getRtnData(PaginationInfo pg, String sql, SqlParam param)
			throws BizException {
		PagingServiceImpl<EntAccActDO> pageQryService = new PagingServiceImpl<EntAccActDO>();
		return pageQryService.findByPageInfo(new EntAccActDO(), pg, sql, null, param);
	}

	/**
	 * 设置备注
	 *
	 * @param act
	 * @param patname
	 * @author zhengcm
	 */
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
