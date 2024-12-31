package iih.pi.reg.s.customer.guoji;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.res.params.BdResParams;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.s.customer.guoji.util.PiGjLogUtil;
import iih.pi.reg.s.customer.guoji.util.PiPatCaChangeForChisUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.log.Log;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.kernel.exception.DbException;

/**
 * 更新CHIS患者
 * 
 * @author ly 2017/07/07
 *
 */
public class PiPatUpdateChisBP {

	/**
	 * 由CHIS更新患者
	 * 
	 * @param patAgg
	 * @return
	 * @throws BizException
	 */
	public void exec(PatiAggDO patAgg, PatiAggDO oldPatAgg) throws BizException {

		String dataSource = new BdResParams().CHISDB();
		if (StringUtil.isEmpty(dataSource)) {
			throw new BizException("CHIS数据源未定义，请定义数据源或关闭chis建档功能");
		}

		// 对比关键变化点
		if (!this.different(patAgg, oldPatAgg))
			return;

		PersistMgr persistence = null;
		try {
			persistence = (PersistMgr) PersistMgr.getInstance(dataSource);
			PersistSession session = persistence.getPersistSession();

			Connection conn = session.getConnection();
			CallableStatement ps = null;
			try {
				ps = conn.prepareCall("{call IIH_MZ_PatientInfo_update(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				this.setParam(ps, patAgg);
				ps.execute();
				this.dealCallBack(ps.getResultSet(), patAgg.getParentDO().getCode());
			} finally {
				try {
					if (ps != null)
						ps.close();
				} catch (SQLException e) {
					Log.error(e.getMessage());
				} finally {
					if (conn != null)
						conn.close();
				}
			}
		} catch (Exception ex) {
			Log.error(ex.getMessage());
			if (ex instanceof DbException || ex instanceof SQLException) {
				throw new BizException("CHIS更新患者失败,原因:" + ex.getMessage(), IPiPatConst.CHIS_ERROREX_CODE);
			} else {
				throw new BizException("CHIS更新患者失败,原因:" + ex.getMessage());
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
	 * 对比关键点
	 * 
	 * @param patAgg
	 * @param oldPatAgg
	 * @return
	 */
	private boolean different(PatiAggDO patAgg, PatiAggDO oldPatAgg) {
		return true;
	}

	/**
	 * 设置参数
	 * 
	 * @param ps
	 * @param pat
	 * @throws SQLException
	 * @throws BizException
	 */
	private void setParam(CallableStatement ps, PatiAggDO patAgg) throws SQLException, BizException {

		PatDO patDo = patAgg.getParentDO();
		PatiAddrDO addrDo = null;
		if (!ArrayUtil.isEmpty(patAgg.getPatiAddrDO())) {
			for (PatiAddrDO addr : patAgg.getPatiAddrDO()) {
				if (IPiDictCodeConst.SD_ADDR_TYPE_NOW.equals(addr.getSd_addrtp())) {
					addrDo = addr;
					break;
				}
			}
		}

		PiPatHpDO hpDo = null;
		if (!ArrayUtil.isEmpty(patAgg.getPiPatHpDO())) {
			for (PiPatHpDO hp : patAgg.getPiPatHpDO()) {
				if (IPiPatConst.BJ_ID_HP.equals(hp.getId_hp())) {
					hpDo = hp;
					break;
				}
			}
		}

		String guarderPatId = getGuardianPatId(patAgg);
		String patcaCode = PiPatCaChangeForChisUtil.getChisPatCaCode(patDo.getId_paticate());

		// 入参
		ps.setString(1, patDo.getCode()); // @patient_id
		ps.setString(2, patDo.getName()); // @name
		ps.setString(3, IPiDictCodeConst.SD_SEX_UNKNOW.equals(patDo.getSd_sex()) ? IPiDictCodeConst.SD_SEX_UNEXPLAIN
				: patDo.getSd_sex()); // @sex
		ps.setDate(4, Date.valueOf(patDo.getDt_birth().toString())); // @birthday
		ps.setString(5, patDo.getSd_idtp()); // @black_flag
		ps.setString(6, patDo.getId_code()); // @social_no
		ps.setString(7, FBoolean.TRUE.equals(patDo.getFg_realname()) ? "1" : "0"); // @identify_flag
		ps.setString(8, !StringUtil.isEmpty(patDo.getTel()) ? patDo.getTel() : patDo.getMob()); // @home_tel
		// ps.setString(9, patDo.getPaticate_code()); //@response_type
		ps.setString(9, patcaCode);
		ps.setString(10, patDo.getPatpritp_code()); // @charge_grade
		ps.setString(11, patDo.getPycode()); // @py_code
		ps.setString(12, patDo.getBarcode_chis()); // @p_bar_code
		ps.setString(13, patDo.getSd_srcregiontp()); // @home_district
		if (hpDo == null) {
			ps.setString(14, null); // @addition_no1
		} else {
			ps.setString(14, hpDo.getNo_hp()); // @addition_no1
		}
		ps.setString(15, guarderPatId); // @guarder_patient_id

		if (addrDo == null) {
			ps.setString(16, null); // @temp_district
			ps.setString(17, null); // @temp_street
		} else {// TODO
			ps.setString(16, addrDo.getSd_admdiv()); // @temp_district
			ps.setString(17, addrDo.getStreet()); // @temp_street
		}

		// 日志参数
		String[] logArgs = new String[17];
		logArgs[0] = patDo.getCode();
		logArgs[1] = patDo.getName();
		logArgs[2] = IPiDictCodeConst.SD_SEX_UNKNOW.equals(patDo.getSd_sex()) ? IPiDictCodeConst.SD_SEX_UNEXPLAIN
				: patDo.getSd_sex();
		logArgs[3] = patDo.getDt_birth().toString();
		logArgs[4] = patDo.getSd_idtp();
		logArgs[5] = patDo.getId_code();
		logArgs[6] = FBoolean.TRUE.equals(patDo.getFg_realname()) ? "1" : "0";
		logArgs[7] = !StringUtil.isEmpty(patDo.getTel()) ? patDo.getTel() : patDo.getMob();
		logArgs[8] = patcaCode;
		logArgs[9] = patDo.getPatpritp_code();
		logArgs[10] = patDo.getPycode();
		logArgs[11] = patDo.getBarcode_chis();
		logArgs[12] = patDo.getSd_srcregiontp();
		if (hpDo == null) {
			logArgs[13] = "";
		} else {
			logArgs[13] = hpDo.getNo_hp();
		}
		logArgs[14] = guarderPatId;
		if (addrDo == null) {
			logArgs[15] = "";
			logArgs[16] = "";
		} else {
			logArgs[15] = addrDo.getSd_admdiv();
			logArgs[16] = addrDo.getStreet();
		}

		PiGjLogUtil.logChisUpdate(logArgs);
	}

	/**
	 * 处理返回值
	 * 
	 * @param ps
	 * @throws SQLException
	 */
	private void dealCallBack(ResultSet rs, String patCode) throws BizException, SQLException {
		if (rs != null) {
			while (rs.next()) {
				try {
					PiGjLogUtil.logChisUpdateRlt(rs.getString(1), rs.getString(2));
					String code = rs.getString(1);
					if (!"0成功".equals(code)) {
						String msg = rs.getString(2);
						throw new BizException(msg);
					}
				} catch (SQLException SQLException) {
					Log.error("CHIS更新患者失败!原因：" + SQLException.getMessage());
				}
			}
		}
	}

	/**
	 * 获取监护人患者编号
	 * 
	 * @param aggDo
	 * @return
	 */
	private String getGuardianPatId(PatiAggDO aggDo) throws BizException {

		if (ArrayUtil.isEmpty(aggDo.getPiPatContDO()))
			return null;

		for (PiPatContDO gc : aggDo.getPiPatContDO()) {
			if (FBoolean.TRUE.equals(gc.getFg_guardian()) && gc.getStatus() != DOStatus.DELETED) {
				DAFacade daf = new DAFacade();
				String sql = "select code from pi_pat where sd_idtp = ? and id_code = ? and ds = 0;";
				SqlParam param = new SqlParam();
				param.addParam(gc.getSd_cont());
				param.addParam(gc.getContid());

				String id = (String) daf.execQuery(sql, param, new ColumnHandler());

				return id;
			}
		}

		return null;
	}
}
