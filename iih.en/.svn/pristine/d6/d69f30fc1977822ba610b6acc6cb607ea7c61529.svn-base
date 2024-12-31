package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.en.comm.ep.EnPatTpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.EntPatListTp;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取就诊患者所属类别
 * 
 * @author liubin
 *
 */
public class GetEntPatTpBP {
	/**
	 * 获取就诊所属类别
	 * @param entId 就诊id
	 * @param depId 科室id
	 * @param empId 医生id
	 * @return
	 * @throws BizException
	 */
	public String exec(String entId,String depId,String empId) throws BizException{
		if(EnValidator.isEmpty(entId)||EnValidator.isEmpty(depId)||EnValidator.isEmpty(empId)){
			return EntPatListTp.OTHERPAT;
		}
		PatiVisitDO pvDO = getPvDO(entId);
		if(pvDO==null){
			return EntPatListTp.OTHERPAT;
		}
		if(FBoolean.FALSE.equals(pvDO.getFg_ip())){
			//出院患者
			return EntPatListTp.LVHOSPAT;
		}else if(empId.equals(pvDO.getId_emp_phy())){
			//我的患者
			return EntPatListTp.PERSONALPAT;
		}else if(FBoolean.TRUE.equals(isWorkGroupPat(empId, pvDO.getId_wg_phy()))){
			//医疗组患者
			return EntPatListTp.WORKGROUPPAT;
		}else if(depId.equals(pvDO.getId_dep_phy())){
			//科室患者
			return EntPatListTp.DEPPAT;
		}else if(isEnAuthPat(entId)){
			//授权患者
			return EntPatListTp.ENAUTHPAT;
		}else if(FBoolean.TRUE.equals(isCrossShareDepPat(entId, depId))){
			//跨科处置患者
			return EntPatListTp.CROSSDEPTPAT;
		}
		return EntPatListTp.OTHERPAT;
	}
	
	/**
	 * 获取就诊信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO getPvDO(String entId) throws BizException{
		String whereStr = String.format("ID_ENT = '%s' AND FG_CANC = '%s' ",entId, "N");
		PatiVisitDO[] pvDOs = new PvEP().getPvByWhereStrWithOutRef(whereStr, null);
		if(!EnValidator.isEmpty(pvDOs)){
			return pvDOs[0];
		}
		return null;
	}
	
	/**
	 * 是否是授权患者
	 * @param idEnt
	 * @return
	 * @throws BizException
	 */
	private boolean isEnAuthPat(String idEnt) throws BizException{
		EnPatTpEP ep = new EnPatTpEP();
		return !EnValidator.isEmpty(ep.searchEnAuthPats(idEnt));
	}
	
	/**
	 * 判断医生是否在医疗组当中
	 * 
	 * @param empId
	 * @param wgId
	 * @return
	 * @throws BizException 
	 */
	private FBoolean isWorkGroupPat(String empId, String wgId) throws BizException{
		if(EnValidator.isEmpty(empId)||EnValidator.isEmpty(wgId)){
			return FBoolean.FALSE;
		}
		String sql = "SELECT EW.ID_EMPWG FROM BD_EMP_WG EW WHERE EW.ID_WG = ? AND EW.ID_EMP = ? ";
		SqlParam param = new SqlParam();
		param.addParam(wgId);
		param.addParam(empId);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list)){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
	/**
	 * 判断是否是跨科共管患者
	 * 
	 * @param entId
	 * @param depId
	 * @return
	 * @throws BizException
	 */
	private FBoolean isCrossShareDepPat(String depId, String nurId) throws BizException{
		if(!EnParamUtils.isShareDep(depId))
			return FBoolean.FALSE;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT COUNT(1) ");
		sqlBuilder.append("FROM BD_DEPL_DEP DEP1 ");
		sqlBuilder.append("INNER JOIN BD_DEPL DEPL ON DEP1.ID_DEPL = DEPL.ID_DEPL AND DEPL.SD_DEPTLTP = ? AND DEPL.ACTIVESTATE = ? ");
		sqlBuilder.append("INNER JOIN BD_DEPL_DEP DEP2 ON DEPL.ID_DEPL = DEP2.ID_DEPL AND DEP2.SD_DEPLROLE LIKE ? ");
		sqlBuilder.append("WHERE DEP1.SD_DEPLROLE LIKE ? ");
		sqlBuilder.append("AND DEP1.ID_DEP = ? ");
		sqlBuilder.append("AND DEP2.ID_DEP = ? ");
		SqlParam param = new SqlParam();
		param.addParam(IBdResDictCodeConst.SD_DEPLTP_DEPNUR);
		param.addParam(ActiveStateEnum.ACTIVE);
		param.addParam(IBdResDictCodeConst.SD_DEPROlE_NUR + "%");
		param.addParam(IBdResDictCodeConst.SD_DEPROLE_DEP + "%");
		param.addParam(depId);
		param.addParam(nurId);
		Integer count = (Integer) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		if(count != null && count > 0){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
}
