package iih.mi.mc.s.bp;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.srv.bddsdef.d.BdDsDefDO;
import iih.bd.srv.bddsdef.i.IBddsdefRService;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.bl.hp.blhppatspec.d.BlHpPatSpecDO;
import iih.mi.itf2.util.MiParamUtil;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;
/***
 * 获取特殊病患者的病种信息
 * @author fanlq
 * @date: 2020年6月19日 下午3:12:22
 */
public class GetMiMcSpecInfoBP {
	private int orderMode;
	/***
	 * @Description:获取特殊病患者的病种信息
	 * @param hpId
	 * @param hpNo
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public String exec(String hpId,String hpNo,String patId) throws BizException{
		if(StringUtil.isEmpty(patId)){
			return null;
		}
		List<MiMcPatSpecDiDO> miSpecList = getSqlByPatId(patId);
		if(miSpecList == null || miSpecList.size() <= 0 || miSpecList.get(0) == null){
			if(StringUtil.isEmpty(hpId) || StringUtil.isEmpty(hpNo)){
				return null;
			}
			miSpecList = getSqlByHpNo(hpId,hpNo);
		}
		this.orderMode = MiParamUtil.MHIR0001();// 0：采用病种模式；1:诊断模式
		if(miSpecList != null && miSpecList.size() > 0 && miSpecList.get(0) != null){
			//0：采用病种模式
			if(this.orderMode == 0 && !StringUtils.isNullOrEmpty(miSpecList.get(0).getId_dsdef())){
				IBddsdefRService service = ServiceFinder.find(IBddsdefRService.class);
				BdDsDefDO dsDef = service.findById(miSpecList.get(0).getId_dsdef());
				return dsDef != null ? dsDef.getName():null;
			}else 
			//1:诊断模式
			if(!StringUtils.isNullOrEmpty(miSpecList.get(0).getId_didef())){
				IDiagdefMDORService service = ServiceFinder.find(IDiagdefMDORService.class);
				DiagDefDO diDef = service.findById(miSpecList.get(0).getId_didef());
				return diDef != null ? diDef.getName():null;
			}
		}
		return null;
	}
	
	/***
	 * @Description:通过患者id获取患者特病信息
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private List<MiMcPatSpecDiDO> getSqlByPatId(String patId) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DI.ID_DSDEF,DI.ID_DIDEF FROM MI_MC_PAT_SPEC_DI DI ");
		sql.append("WHERE DI.ID_MIMCPATSPEC " );
		sql.append("IN ( " );
		sql.append("SELECT PATSPEC.ID_MIMCPATSPEC " );
		sql.append("FROM MI_MC_PAT_SPEC PATSPEC " );
		sql.append("WHERE PATSPEC.ID_PAT = ? " );
		// 添加组织条件
		String orgSql = EnvContextUtil.processEnvContext("", new BlHpPatSpecDO(), "PATSPEC");
		if (!StringUtil.isEmpty(orgSql)) {
			sql.append("AND " + orgSql);
		}
		sql.append(") " );
		sql.append("AND DI.DT_B <= ? " );
		sql.append("AND DI.DT_E >= ? ");
		SqlParam param = new SqlParam();
		param.addParam(patId);
		String now = AppUtils.getServerDateTime().toString();
		param.addParam(now);
		param.addParam(now);
		return (List<MiMcPatSpecDiDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(MiMcPatSpecDiDO.class));
	}
	/***
	 * @Description:通过医保号获取患者特病信息
	 * @param hpId
	 * @param hpNo
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private List<MiMcPatSpecDiDO> getSqlByHpNo(String hpId,String hpNo) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT DI.ID_DSDEF,DI.ID_DIDEF FROM MI_MC_PAT_SPEC_DI DI ");
		sql.append("WHERE DI.ID_MIMCPATSPEC " );
		sql.append("IN ( " );
		sql.append("SELECT PATSPEC.ID_MIMCPATSPEC " );
		sql.append("FROM MI_MC_PAT_SPEC PATSPEC " );
		sql.append("WHERE PATSPEC.ID_HP = ? " );
		sql.append("AND SUBSTR(PATSPEC.NO_HP,1,9)  = ? " );
		// 添加组织条件
		String orgSql = EnvContextUtil.processEnvContext("", new BlHpPatSpecDO(), "PATSPEC");
		if (!StringUtil.isEmpty(orgSql)) {
			sql.append("AND " + orgSql);
		}
		sql.append(") " );
		sql.append("AND DI.DT_B <= ? " );
		sql.append("AND DI.DT_E >= ? ");
		SqlParam param = new SqlParam();
		param.addParam(hpId);
		param.addParam(StringUtils.isNullOrEmpty(hpNo) ? hpNo.length() > 9 ? hpNo.substring(0, 9) : hpNo : null);
		String now = AppUtils.getServerDateTime().toString();
		param.addParam(now);
		param.addParam(now);
		return (List<MiMcPatSpecDiDO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(MiMcPatSpecDiDO.class));
	}
}
