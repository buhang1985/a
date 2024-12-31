package iih.bd.srv.s;

import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.kernel.exception.DbException;

public class SyncDiSrvPyWbCodeTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		PreAlertObject obj = new PreAlertObject();
//		obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
		if (!arg0.getKeyMap().containsKey("table_name")) {
			return obj;
		}
		if (!arg0.getKeyMap().containsKey("pk_id")) {
			return obj;
		}
		int trunSize = 99;
		if (arg0.getKeyMap().containsKey("size")) {
			trunSize = Integer.valueOf(arg0.getKeyMap().get("size").toString());
		}
		String table_name = arg0.getKeyMap().get("table_name").toString();
		String pk_id = arg0.getKeyMap().get("pk_id").toString();
		StringBuffer sb = new StringBuffer();
		if ("bd_srv".equals(table_name)) {
			sb.append("select " + pk_id + ",name from " + table_name
					+ " where sd_srvtp in (select code from bd_udidoc where id_udidoclist = '"
					+ IBdSrvDictCodeTypeConst.ID_SRVTP + "' and ctrl1='Y' and ds = 0 ) and length(name)>8");
		}
		if ("bd_di_def".equals(table_name)) {
			sb.append(" select " + pk_id + ",name from " + table_name + " where length(name)>8");
		}
		List<Map<String, Object>> rlt = (List<Map<String, Object>>) new DAFacade().execQuery(sb.toString(),
				new MapListHandler());

		if (ListUtil.isEmpty(rlt))
			return obj;

		PersistMgr persist = null;
		PersistSession session = null;
		try {
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();

			for (Map<String, Object> map : rlt) {
				String sql = this.getUpdateTemp(table_name, pk_id);
				String name = (String) map.get("name");
				String pk = (String) map.get(pk_id);
				
				String pyCode = CnToPy.getPyFirstCode(name,trunSize);// 拼音码
				String wbCode = CnToWB.getWBCode(name,trunSize);// 五笔码

				SqlParam param = new SqlParam();
				param.addParam(pyCode);
				param.addParam(wbCode);
				param.addParam(pk);

				session.addBatch(sql, param);
			}

			session.execBatch();

		} catch (DbException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
		return obj;
	}

	private String getUpdateTemp(String table_name, String pk_id) {
		return "update " + table_name + " set pycode = ? ,wbcode = ? where " + pk_id + " = ?";
	}

}
