package iih.sc.apt.s.bp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.params.BdResParams;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.ChisMtApplyDTO;
import iih.sc.apt.scaptappl.d.EuAptmd;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.i.IScaptapplMDOCudService;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.comm.ScCodeUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

public class GetNeedAptObsApplBP {

	/**
	 * 获取chis患者申请单数据并插入iih.sc申请表中
	 * 
	 * @param dtos
	 * @param id_apt
	 * @throws BizException
	 */
	public void exec(String id_pat) throws BizException {
		ScLogUtil.getInstance().logError("1.进入方法GetNeedAptObsApplBP.exec(),参数-->id_pat:"+id_pat);
		//获取医技预约同步chis申请单参数
		if(!ScParamUtils.getscMtSyncChis().booleanValue()) return;
		ScLogUtil.getInstance().logError("2.进入方法GetNeedAptObsApplBP.exec(),开始获取患者信息");
		PatDO patDO = this.getPatInfo(id_pat);
		//1007706
		if(validate(patDO)){
			//1. 开始执行
			this.execSql(patDO);
		}
		ScLogUtil.getInstance().logError("3.结束方法GetNeedAptObsApplBP.exec()");
	}
	
	/**
	 *chis数据库连接查询
	 * @return
	 * @throws BizException
	 */
	private FBoolean execSql(PatDO patDO) throws BizException{
		ScLogUtil.getInstance().logError("1.进入方法GetNeedAptObsApplBP.execSql(),患者:"+patDO.getName()+"信息校验通过开始同步患者chis申请单");
		//1. 获取数据源
		String dataSource = new BdResParams().CHISDB();
		if(StringUtil.isEmpty(dataSource)){
			throw new BizException("chis数据源未定义，请定义数据源或关闭chis同步功能！");
		}
		PersistMgr persistence = null;
		try {
			persistence = (PersistMgr) PersistMgr.getInstance(dataSource);
			PersistSession session = persistence.getPersistSession();
			Connection conn = session.getConnection();
			//2. 获取chis查询sql
			String sql = this.getQrySql(patDO);
			PreparedStatement ps = conn.prepareStatement(sql); 
			ResultSet rs = null;
			try{
				//3. 执行sql查询
				rs =  ps.executeQuery();
				List<ChisMtApplyDTO> dataList = new ArrayList<ChisMtApplyDTO>();
				List<String> code_dep_list = new ArrayList<String>();
				List<String> code_emp_list = new ArrayList<String>();
				List<String> code_srv_list = new ArrayList<String>();
				//4. 拼装chis过来的数据dto
				this.assemblyChisData(rs, dataList,code_dep_list,code_emp_list,code_srv_list);
				//5. 存入chis数据到sc
				this.addChisApplyData(dataList, patDO,code_dep_list,code_emp_list,code_srv_list);
			}catch (SQLException e) {
				ScLogUtil.getInstance().logError(e.getMessage());
				throw new BizException("获取患者chis申请单失败,数据查询失败,原因:" + e.getMessage());			
			}finally {
				//6. 关闭连接
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			
		}catch(Exception ex) {
			ScLogUtil.getInstance().logError(ex.getMessage());
			throw new BizException("获取患者chis申请单失败,原因:" + ex.getMessage());
		}finally{
			if(persistence != null){
				try{
					//7. 释放
					persistence.release();
				}catch(Exception e){
					throw e;
				}
			}
		}
		ScLogUtil.getInstance().logError("2.结束方法GetNeedAptObsApplBP.execSql()");
		return FBoolean.TRUE;
	}
	/**
	 * 获取查询sql
	 * @return
	 */
	private String getQrySql(PatDO patDO){
		
		StringBuffer sqlQry = new StringBuffer();
		sqlQry.append(" select inpatient_no,apply_serial,")
		.append(" patient_id,code_entp,code_ordsrv,name_ordsrv,")
		.append(" code_dep_appl,name_dep_appl,code_dep_exec,name_dep_exec,")
		.append(" code_emp_appl,name_emp_appl,dt_order,fg_urgent,times")
		.append(" from")
		.append(" getNeedAptObsAppl")
		.append(" where 1=2 ");
		if(!StringUtil.isEmpty(patDO.getCode_amr_ip())){
			sqlQry.append(" or inpatient_no='").append(patDO.getCode_amr_ip()).append("'");
		}
		if (!StringUtil.isEmpty(patDO.getBarcode_chis())) {
			sqlQry.append(" or inpatient_no='").append(patDO.getBarcode_chis()).append("'");
		}
		return sqlQry.toString();
	}
	/**
	 * 获取患者门诊 和住院号
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatInfo(String id_pat) throws BizException{
		StringBuffer sqlQry = new StringBuffer();
		sqlQry.append("select * from pi_pat where id_pat = ?");
		SqlParam param = new SqlParam();
		param.addParam(id_pat);
		DAFacade dafacade = new DAFacade();
		List<PatDO> pats = (List<PatDO>) dafacade.execQuery(sqlQry.toString(), param, new BeanListHandler(PatDO.class));
		if (!ListUtil.isEmpty(pats)) {
			return pats.get(0);
		}
		return null;
	}
	/**
	 * 校验患者数据
	 * @param patDO
	 * @return
	 */
	private boolean validate(PatDO patDO){
		if (patDO == null) {
			return false;
		}
		if(StringUtil.isEmpty(patDO.getCode_amr_ip()) && StringUtil.isEmpty(patDO.getBarcode_chis())){
			return false;
		}
		return true;
	}
	
	/**
	 * 将chis数据写入SC_APT_APPL
	 * @param dataList
	 * @throws BizException
	 */
	private void addChisApplyData(List<ChisMtApplyDTO> dataList,PatDO pat,List<String> code_dep_list,List<String> code_emp_list,List<String> code_srv_list) throws BizException{
		if (ListUtil.isEmpty(dataList)) {
			return;
		}
		Map<String,DeptDO> deptMap = new HashMap<String,DeptDO>();
		Map<String,PsnDocDO> psndocMap = new HashMap<String,PsnDocDO>();
		Map<String,MedSrvDO> srvMap = new HashMap<String,MedSrvDO>();
		//1. 根据code 获取部门 psndoc 和 bd_srv信息
		this.getDeptAndPsndoc(deptMap, psndocMap,srvMap, code_dep_list, code_emp_list,code_srv_list);
		List<ScAptApplDO> scApplList = new ArrayList<ScAptApplDO>();
		//2. 组装sc_apt_appl数据
		this.assemblyScData(scApplList, dataList, pat,deptMap,psndocMap,srvMap);
		//3. 去除已经存在于sc_apt_appl中的数据
		List<ScAptApplDO> result = this.duplicateApplData(pat.getId_pat(), scApplList);
		//4. 保存
		if(!ListUtil.isEmpty(result)){
		IScaptapplMDOCudService iscaptapplmdocudservice = ServiceFinder.find(IScaptapplMDOCudService.class);
		iscaptapplmdocudservice.save(result.toArray(new ScAptApplDO[0]));
	}
	}
	/**
	 * 拼装chis数据
	 * @param rs
	 * @param dataList
	 * @throws BizException
	 */
	private void assemblyChisData(ResultSet rs,List<ChisMtApplyDTO> dataList,List<String> code_dep_list,List<String> code_emp_list,List<String> code_srv_list) throws BizException{
		try {
			while(rs.next()){
				ChisMtApplyDTO dto = new ChisMtApplyDTO();
				String code_entp = getTrimString(rs.getString("code_entp"));
				if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)){
					dto.setInpaitentno(getTrimString(rs.getString("inpatient_no")));
					dto.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
					dto.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
				}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)){
					dto.setPbarcode(getTrimString(rs.getString("inpatient_no")));
					dto.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
					dto.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
				}else if(IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp)){
					dto.setPbarcode(getTrimString(rs.getString("inpatient_no")));
					dto.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
					dto.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
				}else if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)){
					dto.setPbarcode(getTrimString(rs.getString("inpatient_no")));
					dto.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
					dto.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
				}
				//dto.setCode_entp(code_entp);
				dto.setApplyno(getTrimString(rs.getString("apply_serial")));
				dto.setCode_dep_appl(getTrimString(rs.getString("code_dep_appl")));
				dto.setCode_dep_exec(getTrimString(rs.getString("code_dep_exec")));
				dto.setCode_emp_appl(getTrimString(rs.getString("code_emp_appl")));
				dto.setCode_ordsrv(getTrimString(rs.getString("code_ordsrv")));
				if (!StringUtil.isEmpty(rs.getString("dt_order"))) {
					String dt_order_str = getTrimString(rs.getString("dt_order"));
					if (dt_order_str.contains(".")) {//2019-03-20 11:01:01
					dto.setDt_order(new FDateTime(dt_order_str.substring(0, dt_order_str.indexOf("."))));
				}else{
					dto.setDt_order(new FDateTime(dt_order_str));
				}
				}
				dto.setTimes(rs.getInt("times"));
				dto.setFg_urgent(new FBoolean(rs.getString("fg_urgent")));
				dto.setName_dep_appl(getTrimString(rs.getString("name_dep_appl")));
				dto.setName_dep_exec(getTrimString(rs.getString("name_dep_exec")));
				dto.setName_emp_appl(getTrimString(rs.getString("name_emp_appl")));
				dto.setName_ordsrv(getTrimString(rs.getString("name_ordsrv")));
				dto.setPatientno(getTrimString(rs.getString("patient_id")));
				code_dep_list.add(getTrimString(rs.getString("code_dep_appl")));
				code_dep_list.add(getTrimString(rs.getString("code_dep_exec")));
				code_emp_list.add(getTrimString(rs.getString("code_emp_appl")));
				code_srv_list.add(getTrimString(rs.getString("code_ordsrv")));
				dataList.add(dto);
			}
		} catch (Exception e) {
			ScLogUtil.getInstance().logError(e.getMessage());
			throw new BizException("拼装chis申请单失败,原因:" + e.getMessage());
		}
	}
	/**
	 * 拼装sc申请表数据
	 * @param scApplList
	 * @param dataList
	 * @throws BizException
	 */ 
	private void assemblyScData(List<ScAptApplDO> scApplList,List<ChisMtApplyDTO> dataList,PatDO pat,Map<String,DeptDO> deptMap,Map<String,PsnDocDO> psndocMap,Map<String,MedSrvDO> srvMap) throws BizException{
		for (ChisMtApplyDTO chisMtApplyDTO : dataList) {
			ScAptApplDO applDO = new ScAptApplDO();
			applDO.setApplyno(chisMtApplyDTO.getApplyno());
			applDO.setCode_emp(chisMtApplyDTO.getCode_emp_appl());
			if(!StringUtil.isEmpty(applDO.getCode_emp())){
				if(psndocMap.containsKey(applDO.getCode_emp())){
			applDO.setId_emp_appl(psndocMap.get(applDO.getCode_emp()).getId_psndoc());
				}
			}
			//申请单表添加就诊次数
			applDO.setTimes(chisMtApplyDTO.getTimes().toString());
			applDO.setCode_entp(chisMtApplyDTO.getCode_entp());
			applDO.setContent_or(chisMtApplyDTO.getName_ordsrv());
			applDO.setDt_effe_or(chisMtApplyDTO.getDt_order());
			applDO.setFg_urgent(chisMtApplyDTO.getFg_urgent());
			applDO.setName_emp(chisMtApplyDTO.getName_emp_appl());
			if(!StringUtil.isEmpty(chisMtApplyDTO.getCode_dep_exec())){
				if(deptMap.containsKey(chisMtApplyDTO.getCode_dep_exec())){
			applDO.setId_dep_mp(deptMap.get(chisMtApplyDTO.getCode_dep_exec()).getId_dep());
				}
			}
			if(!StringUtil.isEmpty(chisMtApplyDTO.getCode_dep_appl())){
				if(deptMap.containsKey(chisMtApplyDTO.getCode_dep_appl())){
			applDO.setId_dep_appl(deptMap.get(chisMtApplyDTO.getCode_dep_appl()).getId_dep());
				}
			}
			applDO.setCode_entp(chisMtApplyDTO.getCode_entp());
			applDO.setId_entp(chisMtApplyDTO.getId_entp());
			applDO.setId_grp(ScContextUtils.getGrpId());
			applDO.setId_org(ScContextUtils.getOrgId());
			applDO.setFg_comfirm(FBoolean.FALSE);
			applDO.setFg_canc(FBoolean.FALSE);
			if(!StringUtil.isEmpty(chisMtApplyDTO.getCode_ordsrv())){
				if(srvMap.containsKey(chisMtApplyDTO.getCode_ordsrv())){
			applDO.setId_srv(srvMap.get(chisMtApplyDTO.getCode_ordsrv()).getId_srv());
				}
			}
			applDO.setSd_sctp(IScDictCodeConst.SD_SCTP_MT);
			applDO.setId_pi(pat.getId_pat());
			applDO.setSd_sys_from(IScDictCodeConst.SD_SYS_FROM_CHIS);//来源是chis
			applDO.setSd_aptmd(EuAptmd.MANUAL.toString());//无iih申请单
			applDO.setFg_bl(FBoolean.TRUE);
			applDO.setStatus(DOStatus.NEW);
			applDO.setId_sex(pat.getId_sex());
			applDO.setSd_sex(pat.getSd_sex());
			applDO.setD_pi(pat.getDt_birth());
			applDO.setPiname(pat.getName());
			applDO.setPimobile(pat.getMob());
			if(chisMtApplyDTO.getDt_order() != null){
				applDO.setD_b(chisMtApplyDTO.getDt_order().getBeginDate());
			}
			applDO.setCode(this.createScAptApplCode(IScDictCodeConst.SD_SCTP_MT));
			applDO.setName(chisMtApplyDTO.getName_ordsrv());
			scApplList.add(applDO);
		}
	}
	/**
	 * 去除重复的申请单数据
	 * @param id_pat
	 * @param scApplList
	 * @throws BizException 
	 */
	private List<ScAptApplDO> duplicateApplData(String id_pat,List<ScAptApplDO> scApplList) throws BizException{
		IScaptapplMDORService iscaptapplmdorservice = ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO[] appls = iscaptapplmdorservice.find("id_pi = '"+id_pat+"'", null, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(appls)) {
			return scApplList;
		}
		List<ScAptApplDO> result = new ArrayList<ScAptApplDO>();
		for (ScAptApplDO scAptApplDO : scApplList) {
			String applyNo = scAptApplDO.getApplyno();
			boolean check = true;
			for (ScAptApplDO appl : appls) {
				if (!StringUtil.isEmpty(appl.getApplyno()) && appl.getApplyno().equals(applyNo)) {
					check = false;
					break;
				}
			}
			if (check) {
				result.add(scAptApplDO);
			}
		}
		return result;
	}
	/**
	 * 根据code获取部门和医生信息
	 * @param deptMap
	 * @param psndocMap
	 * @param id_dep_list
	 * @param id_emp_list
	 * @throws BizException
	 */
	private void getDeptAndPsndoc(Map<String,DeptDO> deptMap,Map<String,PsnDocDO> psndocMap,Map<String,MedSrvDO> srvMap,List<String> code_dep_list,List<String> code_emp_list,List<String> code_srv_list) throws BizException{
		String depCond = ScSqlUtils.getInSqlByIds(DeptDO.CODE, code_dep_list);
		String psnCond = ScSqlUtils.getInSqlByIds(PsnDocDO.CODE, code_emp_list);
		String srvCond = ScSqlUtils.getInSqlByIds(MedSrvDO.CODE, code_srv_list);
		IDeptRService ideptrservice = ServiceFinder.find(IDeptRService.class);
		DeptDO[] depts = ideptrservice.find(depCond, null, FBoolean.FALSE);
		IPsndocMDORService ipsndocmdorservice = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] psndocs = ipsndocmdorservice.find(psnCond, null, FBoolean.FALSE);
		IMedsrvMDORService imedsrvmdorservice = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] srvs = imedsrvmdorservice.find(srvCond, null, FBoolean.FALSE);
		for (DeptDO deptDO : depts) {
			if(!deptMap.containsKey(deptDO.getCode())){
				deptMap.put(deptDO.getCode(), deptDO);
			}
		}
		for (PsnDocDO psnDocDO : psndocs) {
			if(!psndocMap.containsKey(psnDocDO.getCode())){
				psndocMap.put(psnDocDO.getCode(), psnDocDO);
			}
		}
		for (MedSrvDO medSrvDO : srvs) {
			if(!srvMap.containsKey(medSrvDO.getCode())){
				srvMap.put(medSrvDO.getCode(), medSrvDO);
			}
		}
	}
	
	/**
	 * 创建预约申请编码
	 *
	 * @author zhengcm
	 * 
	 * @param sd_sctp 就诊类型编码
	 * @return 编码
	 * @throws BizException
	 */
	private String createScAptApplCode(String sd_sctp) throws BizException {
		//FIXME 更换为ScCodeUtils中的创建code方法 2019年3月25日 20:52:39 yzh
		String code = ScCodeUtils.createScApplCode();
		if (!StringUtil.isEmptyWithTrim(sd_sctp)) {
			code = code.substring(0, 3) + sd_sctp + code.substring(3);
		}
		return code;
	}
	/**
	 * 去除字符串空格
	 * 
	 * @param str
	 * @return
	 */
	private String getTrimString(String str){
		if(str == null)
			return null;
		return str.trim();
	}
}
