package iih.pi.reg.s.customer.guoji;

import iih.bd.res.params.BdResParams;
import iih.pi.reg.pat.d.PatiAggDO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;

/**
 * 同步iih患者数据到chis(废弃)
 * @author ly 2017/05/22
 *
 */
public class SyncPatiInfoToChisBP {
	
	/**
	 * 同步iih患者数据到chis
	 * @param pat
	 * @throws BizException
	 */
	public void exec(PatiAggDO pat) throws BizException{
		
		if(pat == null || pat.getParentDO() == null)
			return;
		
		String dataSource = new BdResParams().CHISDB();
		if(StringUtil.isEmpty(dataSource))
			return;
		
		PersistMgr persistence = null;
		try {
			persistence = (PersistMgr) PersistMgr.getInstance(dataSource);
			PersistSession session = persistence.getPersistSession();

			Connection conn = session.getConnection();
			CallableStatement ps = null;
			try {
				ps = conn.prepareCall("call proc_phone_createperson(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				this.setParam(ps, pat);
				ps.execute();
				this.dealCallBack(ps);
			} finally {
				try {
					if (ps != null)
						ps.close();
				} catch (SQLException e) {
					Logger.error(e.getMessage(), e);
				} finally {
					if (conn != null)
						conn.close();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.error(ex.getMessage(), ex);
		} finally {
			if (persistence != null) {
				try {
					persistence.release();
				} catch (Exception e) {
				}
			}
		}
	}	
	
	/**
	 * 设置参数
	 * @param ps
	 * @param pat
	 */
	private void setParam(CallableStatement ps, PatiAggDO pat) {

	}
	
	/**
	 * 处理返回值
	 * @param ps
	 */
	private void dealCallBack(CallableStatement ps){
		
	}
}
