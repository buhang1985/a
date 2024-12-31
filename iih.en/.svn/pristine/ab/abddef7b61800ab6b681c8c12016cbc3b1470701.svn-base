package iih.en.ip.s.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.res.params.BdResParams;
import iih.en.comm.ep.DeptEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.apt.dto.d.AptIpDTO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;
import xap.sys.orgfw.dept.d.DeptDO;
/**
 * 更新chis库信息
 * @author Sarah
 *
 */
public class SaveIpntToChisBP {
		
		private static final String CHIS_SCHTYPE_OP = "01";//门诊
		private static final String CHIS_SCHTYPE_EM = "02";//急诊
		private static final String CHIS_SCHTYPE_IP = "03";//住院
		private static final String CHIS_SCHTYPE_PE = "04";//体检
		private static final String CHIS_SCHTYPE_CHANGEHOS = "05";//转院
			
		private static final String CHIS_DISLEV_DYING = "1";//危
		private static final String CHIS_DISLEV_SEVERITY = "4";//重
		private static final String CHIS_DISLEV_ORDINARY = "3";//常规
		private static final String CHIS_DISLEV_CRITICAL = "2";//急
		
		private static final String CHIS_VIP = "1";//是
		private static final String CHIS_NOT_VIP = "0";//否
				
		private static final String CHIS_ADD = "0";//新增
		private static final String CHIS_MOD = "1";//修改
		
		private static final String CHIS_PLAN = "1";//计划
		private static final String CHIS_NOT_PLAN = "0";//非计划

		
	/**
	 * 保存入院申请单到chis
	 * 
	 * @param aptIpDTO
	 * @throws BizException
	 */
	@SuppressWarnings("static-access")
	public void exec(AptIpDTO aptIpDTO,Boolean isUpdate) throws BizException {
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
				ps = conn.prepareCall("{call proc_iih_inpatient_admission_cetrif(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				this.setParam(ps, aptIpDTO,isUpdate);
				ps.execute();

				this.logChisUpdateRlt(ps.getResultSet());
				 this.dealCallBack(ps.getResultSet(),aptIpDTO);
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
	private void setParam(CallableStatement ps,AptIpDTO aptIpDTO,Boolean isUpdate) throws SQLException, BizException{
		OutpatientDO outDO= this.getOpTimes(aptIpDTO.getId_ent());
		Map<String,DeptDO> map = this.getDepInfo(aptIpDTO);
		PatiVisitDO patvisitDO = new PvEP().getPvById(aptIpDTO.getId_ent());

		ps.setString(1,aptIpDTO.getCode_pat()); //@patient_id
		ps.setString(2,outDO.getTimes_op().toString()); //times
		ps.setString(3,patvisitDO.getDt_entry()==null?"":patvisitDO.getDt_entry().toString()); //visit_times----------
		ps.setString(4,aptIpDTO.getName_didef_op()); //clinic_diag_str 门诊诊断
		if(map!=null){
			ps.setString(5,aptIpDTO.getId_dep_op()==null?"":((DeptDO)map.get(aptIpDTO.getId_dep_op())).getCode()); //mz_dept   
			ps.setString(6,aptIpDTO.getId_dep_nur_ip()==null?"":((DeptDO)map.get(aptIpDTO.getId_dep_nur_ip())).getCode()); //admiss_ward
			ps.setString(7,aptIpDTO.getId_dep_phy_ip() ==null ? "":((DeptDO)map.get(aptIpDTO.getId_dep_phy_ip())).getCode()); //admiss_dept
		}
		ps.setString(8,EnContextUtils.getPsnDoc().getCode()); //opera--------
		ps.setString(9,aptIpDTO.getDt_admit_plan()==null? "":aptIpDTO.getDt_admit_plan().toString()); //admiss_date_plan
		ps.setString(10,aptIpDTO.getAmt_deposit()==null? "":aptIpDTO.getAmt_deposit().toString()); //deposit
		ps.setString(11,this.setAdmissType(aptIpDTO)); //in_admiss_type
		ps.setString(12,aptIpDTO.getFg_plan() ==null?CHIS_NOT_PLAN:aptIpDTO.getFg_plan().booleanValue()?CHIS_PLAN:CHIS_NOT_PLAN); //plan_admiss_flag
		ps.setString(13,aptIpDTO.getFg_vip()==null ? CHIS_NOT_VIP:aptIpDTO.getFg_vip().booleanValue()?CHIS_VIP:CHIS_NOT_VIP); //VIP_flag
		ps.setString(14,this.setDisLevel(aptIpDTO)); //admiss_status
		ps.setString(15,isUpdate?CHIS_MOD:CHIS_ADD); //oper_flag	
	}
	/**
	 * 设置住院来院方式
	 * @param aptIpDTO
	 * @return
	 */
	private String setAdmissType(AptIpDTO aptIpDTO){
		if(EnValidator.isEmpty(aptIpDTO.getSd_referalsrc()) ){
			return null;
		}
		switch (aptIpDTO.getSd_referalsrc()){
		case IBdFcDictCodeConst.SD_REFERALSRC_EM:
			return CHIS_SCHTYPE_EM; 
		case IBdFcDictCodeConst.SD_REFERALSRC_OP:
			return CHIS_SCHTYPE_OP; 
			
		case IBdFcDictCodeConst.SD_REFERALSRC_OTHERORG:
			return CHIS_SCHTYPE_CHANGEHOS; 

		case IBdFcDictCodeConst.SD_REFERALSRC_IP:
			return CHIS_SCHTYPE_IP; 
			default :
				return CHIS_SCHTYPE_OP;
		}
	}
	
	/**
	 * 设置病情状况
	 * @param aptIpDTO
	 * @return
	 */
	private String setDisLevel(AptIpDTO aptIpDTO){
		if(EnValidator.isEmpty(aptIpDTO.getSd_level_dise()) ){
			return null;
		}
		switch (aptIpDTO.getSd_level_dise()){
		case IBdFcDictCodeConst.CONDITION_GRADE_DYING:
			return CHIS_DISLEV_DYING; 
		case IBdFcDictCodeConst.CONDITION_GRADE_SEVERITY:
			return CHIS_DISLEV_SEVERITY; 
			
		case IBdFcDictCodeConst.CONDITION_GRADE_ORDINARY:
			return CHIS_DISLEV_ORDINARY; 

			default :
				return CHIS_DISLEV_ORDINARY;
		}
	}
	
	/**
	 * 查找部门
	 * @param pageBedDTO
	 * @throws BizException
	 */
	private Map<String,DeptDO> getDepInfo(AptIpDTO aptIpDTO) throws BizException{
		//1.组装成list 批量查询
		List<String> idlist = new ArrayList<String>();
		if(!EnValidator.isEmpty(aptIpDTO.getId_dep_op())){
			idlist.add(aptIpDTO.getId_dep_op());
		}
		if(!EnValidator.isEmpty(aptIpDTO.getId_dep_nur_ip())){
			idlist.add(aptIpDTO.getId_dep_nur_ip());
		}
		if(!EnValidator.isEmpty(aptIpDTO.getId_dep_phy_ip())){
			idlist.add(aptIpDTO.getId_dep_phy_ip());
		}
		
		if(EnValidator.isEmpty(idlist)){
			return null;
		}
		//2.查询结果返回map
		DeptEP ep = new DeptEP();
		Map<String,DeptDO> map= ep.getDeptMap(idlist);
		if(EnValidator.isEmpty(map)){
			return null;
		}
        return map;				
	}
	/**
	 * 就诊获取就诊次数
	 * @param endId
	 * @return
	 * @throws BizException
	 */
	private OutpatientDO getOpTimes(String endId) throws BizException{
		OpEP opEP = new OpEP();
		return  opEP.getOpByEntId(endId);		
	}
	
	
	/**
	 * chis更新患者返回值日志
	 * @param rs
	 * @throws SQLException
	 */
	public static void logChisUpdateRlt(ResultSet rs){
		try {
			String log = "执行CHIS更新患者存储过程  proc_iih_inpatient_admission_cetrif 返回值: ";
			String format = "'%s','%s'";
			if (rs != null) {
				while (rs.next()) {
					try {
						format = String.format(format, rs.getString(1), rs.getString(2));
					} catch (Exception e) {
					}
				}
			}
			
			log += format;
			EnLogUtil.getInstance().logInfo("CHIS更新入院申请单失败!原因："+log);
		} catch (Exception e) {
			e.printStackTrace();
			EnLogUtil.getInstance().logInfo(e.getMessage());
		}
	}
	/**
	 * 处理返回值
	 * @param ps
	 * @throws SQLException 
	 */
	private void dealCallBack(ResultSet rs,AptIpDTO aptIpDTO) throws BizException, SQLException{
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
