package iih.ci.ord.s.bp.assi.gj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 初始化映射相关属性
 * 
 * @author HUMS
 *
 */
public class InitMappingCiEmsProperty {

	private CiEnContextDTO envinfo;

	public InitMappingCiEmsProperty(CiEnContextDTO envinfo) {
		this.envinfo = envinfo;
	}

	/**
	 * 获取在院执行标识
	 * @param code_entp 就诊类型不能为空
	 * @param sd_srvtp 服务类型不能为空
	 * @param id_route 用法不能为空
	 * @return 
	 * @throws BizException
	 */
	public FBoolean getFgMpIn(String code_entp,String sd_srvtp,String id_route) throws BizException {
		if(IEnDictCodeConst.SD_DIAGTYPE_HOSPITAL_IN.equals(code_entp)){
			return FBoolean.TRUE;
		}else{
			if(StringUtils.isEmpty(sd_srvtp))
			{
				return FBoolean.TRUE;
			}
			List<String> idRouteList = this.getUsageScope();
			// 西城药品的fg_mp_in 判断逻辑，判断用法id 是否在轻量级中 CIOR0115 是否配置，如果配置返回在院执行标识为True
			if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)
					|| sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {

				// 在轻量级中 CIOR0115 配置用法内，为在院执行
				if (idRouteList.contains(id_route)) {
					return FBoolean.TRUE;
				}

				return FBoolean.FALSE;
			} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) { // 草药时在院执行标识为false
				return FBoolean.FALSE;
			}
		}
		return FBoolean.TRUE;
	}

	/**
	 * 获取药品可成组使用用法范围
	 * 
	 * 注：在该范围内的用法对应的在院执行标记为true
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<String> getUsageScope() throws BizException {

		if (StringUtils.isBlank(envinfo.getId_dep_en())) {
			throw new BizException("当前环境参数中就诊科室为空！");
		}
		
		List<String> usageScopeList =new ArrayList<String>();
		
		String orgId = CiOrdAppUtils.getEnvContext().getOrgId();
		//药品可成组使用用法范围设置
		String usageScope = ParamsetQryUtil.getParaString(orgId,
				ICiOrdNSysParamConst.SYS_PARAM_CiPharmGrpableUsageScope);
	
		if (StringUtils.isNotBlank(usageScope)) {
			usageScopeList.addAll(Arrays.asList(usageScope.split(",")));
		}
		
		return usageScopeList;
	}
}
