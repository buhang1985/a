package iih.pi.reg.s.customer.guoji.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import iih.bd.res.params.BdResParams;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;

/**
 * chis建档存储过程基类
 * @author ly 2017/08/23
 *
 */
public abstract class PiPatProcCallBaseBP {

	/**
	 * chis建档
	 * @param patAgg 患者信息
	 * @throws BizException
	 */
	public void exec(PatiAggDO patAgg) throws BizException{
		
		if(patAgg == null || patAgg.getParentDO() == null)
			return;
		
		String dataSource = new BdResParams().CHISDB();
		if(StringUtil.isEmpty(dataSource))
			throw new BizException("chis数据源未定义，请定义数据源或关闭chis建档功能");
		
		PersistMgr persistence = null;
		try {
			persistence = (PersistMgr) PersistMgr.getInstance(dataSource);
			PersistSession session = persistence.getPersistSession();

			Connection conn = session.getConnection();
			CallableStatement ps = null;
			try {
				ps = conn.prepareCall(this.getProcName());
				this.setParam(ps, patAgg);
				ps.execute();
				this.dealCallBack(ps, patAgg);
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
			Logger.error(ex.getMessage(), ex);
			if(ex instanceof DbException || ex instanceof SQLException ){
				throw new BizException("CHIS建档失败,原因:" + ex.getMessage(),IPiPatConst.CHIS_ERROREX_CODE);
			}else{
				throw new BizException("CHIS建档失败,原因:" + ex.getMessage());
			}
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
	 * 获取存储过程调用名
	 * @return
	 */
	protected abstract String getProcName();
	
	/**
	 * 设置调用参数
	 * @param ps
	 * @param patAgg
	 */
	protected abstract void setParam(CallableStatement ps, PatiAggDO patAgg)throws SQLException;
	
	/**
	 * 处理返回值
	 * @param ps
	 * @param patAgg
	 * @throws BizException
	 */
	protected abstract void dealCallBack(CallableStatement ps, PatiAggDO patAgg) throws BizException,SQLException;

	/**
	 * format出生日期
	 * @param pat
	 * @return
	 */
	protected String getBirthDate(PatDO pat) {
		return pat.getDt_birth().toString().replace("-", "");
	}
}
