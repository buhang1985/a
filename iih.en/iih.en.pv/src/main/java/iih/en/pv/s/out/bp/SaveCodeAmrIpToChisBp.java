package iih.en.pv.s.out.bp;

import iih.bd.res.params.BdResParams;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.pi.reg.pat.d.PatDO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;

public class SaveCodeAmrIpToChisBp {

	private static final String CHIS_QRYMODE = "0";//查询方式
	
	private static final String CHIS_HOSREG = "0";//入院
	private static final String CHIS_DISCHARGE = "1";//退院
	
	public void exec(PatDO patDo, Boolean isHosreg) throws BizException {
		String dataSource = new BdResParams().CHISDB();
		if (EnValidator.isEmpty(dataSource)) {
			throw new BizException("CHIS数据源未定义，请定义数据源或关闭chis功能");
		}

		PersistMgr persistence = null;
		try {
			persistence = (PersistMgr) PersistMgr.getInstance(dataSource);
			PersistSession session = persistence.getPersistSession();

			Connection conn = session.getConnection();
			CallableStatement ps = null;
			try {
				ps = conn.prepareCall("{call proc_iih_getinpatient_no(?,?,?,?)}");
				this.setParam(ps, patDo, isHosreg);
				boolean b = ps.execute();

//				this.logChisUpdateRlt(ps.getResultSet());
				this.dealCallBack(ps.getResultSet(), patDo);
			} finally {
				try {
					if (ps != null){
						ps.close();
					}
				} catch (SQLException e) {
					EnLogUtil.getInstance().logInfo(e.getMessage());
				} finally {
					if (conn != null){
						conn.close();
					}
				}
			}
		} catch (Exception ex) {
			EnLogUtil.getInstance().logInfo("CHIS更新入院申请单失败,原因："+ex.getMessage());
			if (ex instanceof DbException || ex instanceof SQLException) {
				throw new BizException("CHIS更新入院申请单失败,原因:" + ex.getMessage()+ "  chis库连接或者更新异常");
			} else {
				throw new BizException("CHIS更新入院申请单失败,原因:" + ex.getMessage());
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
	 * 设置参数
	 * @param ps
	 * @param aptIpDTO
	 * @throws SQLException 
	 * @throws BizException 
	 */
	private void setParam(CallableStatement ps,PatDO patDo,Boolean isHosreg) throws SQLException, BizException{
		ps.setString(1,patDo.getId_idtp()); //@patient_id
		ps.setString(2,patDo.getId_code()); //times
		ps.setString(3, CHIS_QRYMODE); //visit_times----------
		ps.setString(4, isHosreg ? CHIS_HOSREG : CHIS_DISCHARGE); //clinic_diag_str 门诊诊断
	}
	
	/**
	 * 处理返回值
	 * @param ps
	 * @throws SQLException 
	 */
	private void dealCallBack(ResultSet rs, PatDO patDo) throws BizException, SQLException{
		if(rs!=null){
			while (rs.next()) {
				try {
					String code = rs.getString(1);
					if(!"0".equals(code)){
						String msg = rs.getString(2);
						throw new BizException(msg);
					}
					
				} catch (SQLException SQLException) {
					EnLogUtil.getInstance().logInfo("CHIS更新入院申请单失败!原因：" + SQLException.getMessage());
				}
			}
		}
	}
	
}
