package iih.ci.ord.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;

/**
 * 更新医嘱排序号
 * 
 * @author HUMS
 *
 */
public class UpdateCiOrderSortnoBP {

	/**
	 * 更新医嘱排序字段
	 * 
	 * @param idOrMap key= id_or value= sortno
	 * @return 是否排序成功
	 * @throws BizException 
	 */
	public FBoolean exec(FMap idOrMap) throws BizException {

		if (idOrMap == null)
			return FBoolean.FALSE;

		PersistMgr persist = null;
		PersistSession session = null;
		try {
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();

			int preSortNo = 0;
			for (String id_or : idOrMap.keySet()) {

				Object sortNoObj = idOrMap.get(id_or);
				int sortno = 999;

				if (sortNoObj != null) {
					sortno = Integer.parseInt(sortNoObj.toString());
				}

				if (preSortNo == sortno) {
					sortno--;
				}
				preSortNo = sortno;

				String sql = "update ci_order  set sortno = '" + sortno + "' where id_or =  '" + id_or + "'";
				session.addBatch(sql);
			}
			session.execBatch();
		} catch (DbException e) {
			Logger.error(e.getMessage(), e);
			throw new BizException(e.getMessage());

		} finally {
			if (session != null)
				session.closeAll();
			if (persist != null)
				persist.release();
		}

		return FBoolean.TRUE;
	}
}
