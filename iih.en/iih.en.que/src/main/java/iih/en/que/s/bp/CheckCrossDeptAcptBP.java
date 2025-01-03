package iih.en.que.s.bp;

import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.ResultDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 是否可以跨科接诊
 * 
 * @author liubin
 *
 */
public class CheckCrossDeptAcptBP {
	/*
	 * 可被别的科跨科接诊
	 */
	private static final String EN_OP_DEPCTRL_FG_RECED = "1";

	/*
	 * 可跨科接诊别的科的病人
	 */
	private static final String EN_OP_DEPCTRL_FG_RECDEP = "2";
	/*
	 * 禁止跨科接诊
	 */
	private static final String EN_OP_DEPCTRL_FG_NO = "3";
	/**
	 * 是否可以跨科接诊
	 * 
	 * @param regDepId 挂号科室
	 * @param acptDepId 接诊科室
	 * @return
	 * @throws BizException
	 */
	public ResultDTO exec(String regDepId, String acptDepId) throws BizException {
		ResultDTO result = new ResultDTO();
		boolean isBenQueMgr = EnParamUtils.isBenQueMgr();
		//分诊台管理模式不校验跨科接诊-fanlq
		if(isBenQueMgr){
			result.setFlag(FBoolean.TRUE);
			return result;
		}
		if(EnValidator.isEmpty(regDepId) 
				|| EnValidator.isEmpty(regDepId)){
			result.setFlag(FBoolean.FALSE);
			result.setMsg("不允许跨科接诊！");
			return result;
		}
		//患者接诊科室参数
		String crossDeptAcptFlagOfDep = EnParamUtils.getCrossDepAcpt(acptDepId);
		if (EN_OP_DEPCTRL_FG_RECDEP.equals(crossDeptAcptFlagOfDep)) {
			result.setFlag(FBoolean.TRUE);
			return result;
		}
		if(EN_OP_DEPCTRL_FG_NO.equals(crossDeptAcptFlagOfDep)){
			result.setFlag(FBoolean.FALSE);
			result.setMsg("该科室禁止跨科接诊！");
			return result;
		}
		//患者挂号科室参数
		String crossDeptAcptFlagOfReg = EnParamUtils.getCrossDepAcpt(regDepId);
		if (EN_OP_DEPCTRL_FG_RECED.equals(crossDeptAcptFlagOfReg)) {
			result.setFlag(FBoolean.TRUE);
			return result;
		}
		result.setFlag(FBoolean.FALSE);
		Map<String, String> map = this.getDepIdNameMap(new String[]{regDepId, acptDepId});
		if(map!=null&&map.size()>0)
			result.setMsg(String.format("科室[%s]患者不允许被其他科室接诊，科室[%s]不允许接诊其他科室患者！", map.get(regDepId), map.get(acptDepId)));
		else
			result.setMsg("不允许跨科接诊！");
		return result;
	}
	/**
	 * 组装科室（id——name）Map
	 * 
	 * @param depIds
	 * @return
	 * @throws BizException 
	 */
	private Map<String, String> getDepIdNameMap(String[] depIds) throws BizException{
		String sql = "select dep.id_dep, dep.name from bd_dep dep where " + EnSqlUtils.getInSqlByIds("dep.id_dep", depIds);
		@SuppressWarnings("unchecked")
		List<DeptDO> depts = (List<DeptDO>) new DAFacade().execQuery(sql, new BeanListHandler(DeptDO.class));
		if(!EnValidator.isEmpty(depts)){
		    Map<String, String> map = new HashMap<String, String>();
		    for(DeptDO dept : depts)
			    map.put(dept.getId_dep(), dept.getName());
		    return map;
		}
		return null;
	}
}
