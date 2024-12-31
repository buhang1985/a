package iih.bd.base.task;

import java.util.List;
import java.util.Map;

import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.kernel.exception.DbException;

/**
 * 通用修改拼音码五笔码后台任务
 * 使用者需要定义阈值table_name:表名 id_name:主键
 * 表中需要有name,pycode,wbcode字段
 * @author ly 2017/07/24
 *            2017/09/14 添加截取位数处理(排除bd_srv，bd_di_def)
 *
 */
public class UpdatePyWbCommonTask implements IBackgroundWorkPlugin{

	/**
	 * 不截取位数的表
	 */
	private static final String[] EXCLUDESET = new String[] { "bd_srv", "bd_di_def" };
	
	@SuppressWarnings("unchecked")
	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BizException {
		
		PreAlertObject obj = new PreAlertObject();
//        obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
        
		String tblName = (String)arg0.getKeyMap().get("table_name");
		String idName = (String)arg0.getKeyMap().get("id_name");
		
		if(StringUtil.isEmpty(tblName) || StringUtil.isEmpty(idName))
			return obj;
		
		String sql = "select " + idName + ",name from " + tblName ;
				//+ " where rownum < 10";
		List<Map<String,Object>> rlt = (List<Map<String,Object>>)new DAFacade().
				execQuery(sql, new MapListHandler());
		
		if(ListUtil.isEmpty(rlt))
			return obj;
		
		//判断包含在不截取位数的集合中
		boolean contain = false;
		for (String strTbl : EXCLUDESET) {
			if(tblName.toLowerCase().equals(strTbl)){
				contain = true;
				break;
			}
		}
		
		PersistMgr persist = null;
		PersistSession session = null;
		try {
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			
			for (Map<String, Object> map : rlt) {
				String sql2 = this.getUpdateTemp(tblName, idName);
				String name = (String)map.get("name");
				String pk = (String)map.get(idName);
				
				String pyCode = CnToPy.getPyFirstCode(name, 100);// 拼音码
				String wbCode = CnToWB.getWBCode(name, 100);// 五笔码
				
				SqlParam param = new SqlParam();
				
				//截取8位
				if(!contain){
					pyCode = pyCode.length() > 9 ? pyCode.substring(0, 8) + ".": pyCode;
					wbCode = wbCode.length() > 9 ? wbCode.substring(0, 8) + ".": wbCode;
				}
				
				param.addParam(pyCode);
				param.addParam(wbCode);
				param.addParam(pk);
				
				session.addBatch(sql2, param);
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
	
	private String getUpdateTemp(String tblName,String idName){
		return "update " + tblName + " set pycode = ? ,wbcode = ? where " + idName + " = ?";
	}
}
