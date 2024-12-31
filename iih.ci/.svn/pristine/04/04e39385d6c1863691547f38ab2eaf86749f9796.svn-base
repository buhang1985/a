package iih.ci.ord.s.ems.utils;

import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 服务匹配医疗单工具类
 * @author zhangwq
 *
 */
public class SrvMatchEmsUtils {
	private IEmsManagementService emsManagementService;
	public SrvMatchEmsUtils(){
		emsManagementService = ServiceFinder.find(IEmsManagementService.class);
	}
	/**
	 * 匹配医疗单
	 * @param ctx
	 * @param id_srv
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	public SrvMatchEmsRstDTO matchEms(CiEnContextDTO ctx, String id_srv, String sd_srvtp) throws BizException {
		// 调用匹配医疗单算法服务
		FMap rstMap = emsManagementService
				.medSrvMatchEms(new SrvMatchEmsParamDTO[] { srvMatchEmsParamFrom(ctx, id_srv, sd_srvtp) });

		// 进行匹配结果有效性验证
		if (null != rstMap && rstMap.size() > 0) {
			// 根据服务id获取医疗单匹配信息
			return (SrvMatchEmsRstDTO) rstMap.get(id_srv);
		}
		return null;
	}
	/**
	 * 匹配医疗单
	 * @param code_entp
	 * @param id_emp_or
	 * @param id_dep_or
	 * @param id_srv
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	public SrvMatchEmsRstDTO matchEms(String code_entp,String id_emp_or,String id_dep_or,String id_srv,String sd_srvtp) throws BizException{
		// 调用匹配医疗单算法服务
		FMap rstMap = emsManagementService
				.medSrvMatchEms(new SrvMatchEmsParamDTO[] { srvMatchEmsParamFrom(code_entp,id_emp_or,id_dep_or, id_srv, sd_srvtp) });

		// 进行匹配结果有效性验证
		if (null != rstMap && rstMap.size() > 0) {
			// 根据服务id获取医疗单匹配信息
			return (SrvMatchEmsRstDTO) rstMap.get(id_srv);
		}
		return null;
	}
	/**
	 * 组建医疗单匹配数据结构
	 * 
	 * @param ctx
	 * @param id_srv
	 * @param sd_srvtp
	 * @return
	 */
	private SrvMatchEmsParamDTO srvMatchEmsParamFrom(CiEnContextDTO ctx, String id_srv, String sd_srvtp) {
		SrvMatchEmsParamDTO srvMatchEmsParamDTO = new SrvMatchEmsParamDTO();
		srvMatchEmsParamDTO.setId_srv(id_srv);
		srvMatchEmsParamDTO.setCode_entp(ctx.getCode_entp());
		srvMatchEmsParamDTO.setId_emp(ctx.getId_emp_or());
		srvMatchEmsParamDTO.setId_dept(ctx.getId_dep_or());
		srvMatchEmsParamDTO.setId_org(ctx.getId_org());
		srvMatchEmsParamDTO.setId_grp(ctx.getId_grp());
		srvMatchEmsParamDTO.setSd_srvtp(sd_srvtp);
		srvMatchEmsParamDTO.setDt_or(CiOrdAppUtils.getServerDateTime());
		srvMatchEmsParamDTO.setEmsappmode(1);
		return srvMatchEmsParamDTO;
	}
	/**
	 * 组建医疗单匹配数据结构
	 * @param code_entp
	 * @param id_emp_or
	 * @param id_dep_or
	 * @param id_srv
	 * @param sd_srvtp
	 * @return
	 */
	private SrvMatchEmsParamDTO srvMatchEmsParamFrom(String code_entp,String id_emp_or,String id_dep_or,String id_srv,String sd_srvtp) {
		SrvMatchEmsParamDTO srvMatchEmsParamDTO = new SrvMatchEmsParamDTO();
		srvMatchEmsParamDTO.setId_srv(id_srv);
		srvMatchEmsParamDTO.setCode_entp(code_entp);
		srvMatchEmsParamDTO.setId_emp(id_emp_or);
		srvMatchEmsParamDTO.setId_dept(id_dep_or);
		srvMatchEmsParamDTO.setId_org(Context.get().getOrgId());
		srvMatchEmsParamDTO.setId_grp(Context.get().getGroupId());
		srvMatchEmsParamDTO.setSd_srvtp(sd_srvtp);
		srvMatchEmsParamDTO.setDt_or(CiOrdAppUtils.getServerDateTime());
		srvMatchEmsParamDTO.setEmsappmode(1);
		return srvMatchEmsParamDTO;
	}
}
