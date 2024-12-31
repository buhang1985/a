package iih.en.pv.s.mvelextmethod;

import java.util.HashMap;
import java.util.Map;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

import com.ymer.designer.scripteditor.MvelExtMethod;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.validator.EnValidator;
import iih.pi.reg.i.IPiRegValidateService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.pub.ScGroupControlUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 门诊挂号规则引擎内置函数（方法）
 * @author WJY
 */
public class OpRegMvelExtMethod implements MvelExtMethod {
	@Override
	public void importMethod(ParserContext paramParserContext) {
		paramParserContext.addImport("getDeptById", MVEL.getStaticMethod(OpRegMvelExtMethod.class, "getDeptById", new Class[] { String.class}));
		paramParserContext.addImport("isPatInHos", MVEL.getStaticMethod(OpRegMvelExtMethod.class, "isPatInHos", new Class[] { String.class }));
		paramParserContext.addImport("countAptDep", MVEL.getStaticMethod(OpRegMvelExtMethod.class, "countAptDep", new Class[] { String.class, String.class, String.class, String.class }));
	}

	@Override
	public String getClazzDesc() {
		return "门诊挂号规则";
	}

	@Override
	public Map<String, String> getMethodParamsDesc() {
		Map<String, String> desclz = new HashMap<String, String>();
		desclz.put("getDeptById", String.class.getName());
		desclz.put("isPatInHos", String.class.getName());
		desclz.put("countAptDep", String.class.getName() + ", " + String.class.getName() + ", " + String.class.getName()+ ", " + String.class.getName());
		return desclz;
	}

	@Override
	public Map<String, String> getReturnTypes() {
		Map<String, String> rtnTypes = new HashMap<String, String>();
		rtnTypes.put("getDeptById", DeptDO.class.getName());
		rtnTypes.put("isPatInHos", FBoolean.class.getName());
		rtnTypes.put("countAptDep", Integer.class.getName());
		return rtnTypes;
	}
	
	/**
	 * 根据ID获取科室信息
	 * @param deptId
	 * @return
	 * @throws BizException 
	 */
	public static DeptDO getDeptById(String deptId) throws BizException{
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		return service.findById(deptId);
	}

	/***
	 * 根据患者id判断患者是否在院
	 * fanlq-2017-10-24
	 * @param patId 
	 * 			-患者id
	 * @return,true 在院；false 不在院;
	 * @throws BizExceptison
	 */
	public static FBoolean isPatInHos(String patId) throws BizException {
		IpEP ipEp = new IpEP();
		FBoolean isIp = ipEp.IsInHos(patId);
		IPatiMDORService patQryService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = patQryService.findById(patId);
		String idCode = null;
		if(null != patDO && patDO.getSd_idtp().equals(IPiDictCodeConst.SD_IDTP_IDENTITY)){
			idCode = patDO.getId_code();
		}
		if (!isIp.booleanValue() && null != idCode) {
			IPiRegValidateService service = ServiceFinder.find(IPiRegValidateService.class);
			isIp = service.checkPatInHosChis(idCode);
		}
		return isIp;
	}
	/**
	 * 患者同一科室同一天预约的数量
	 */
	public static Integer countAptDep(String patId, String regDate, String depId,String dayslotId) throws BizException {
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT COUNT(*) as aptcount FROM SC_APT APT ");
		builder.append("INNER JOIN SC_SCH SCH ON SCH.ID_SCH = APT.ID_SCH ");
		builder.append("INNER JOIN SC_PL PL ON PL.ID_SCPL = SCH.ID_SCPL ");
		builder.append("WHERE APT.ID_PAT= ? ");
		builder.append("AND APT.Dt_b >= ? ");
		builder.append("AND APT.Dt_e <= ? ");
		builder.append("AND PL.ID_DEP = ? ");
		builder.append("AND APT.ID_DATESLOT = ? ");
		builder.append("AND APT.FG_CANC = ? ");
		param.addParam(patId);
		param.addParam(regDate.substring(0, 10) + " 00:00:00");
		param.addParam(regDate.substring(0, 10) + " 23:59:59");
		param.addParam(depId);
		param.addParam(dayslotId);
		param.addParam(FBoolean.FALSE);
		//集团管控
		String orgWhere = ScGroupControlUtils.getGroupControlFitler(new ScAptDO(), "APT");
		if(!EnValidator.isEmpty(orgWhere)){
			builder.append(" AND ").append(orgWhere);
		}
		int count = 0;
		// 查询数据
		@SuppressWarnings("unchecked")
		Map<String, Integer> datas = (Map<String, Integer>) new DAFacade().execQuery(builder.toString(), param, new MapHandler());
		if (null != datas && !datas.isEmpty()) {
			count = datas.get("aptcount");
		}
		return count;
	}
}
