package iih.bd.fc.s.bp.deptflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.fc.dto.deptflow.d.DeptFlowDTO;
import iih.bd.fc.dto.deptflow.d.SrvtpFlowDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.fc.s.bp.deptflow.qry.GetWfDeptSql;
import iih.bd.fc.s.bp.deptflow.qry.GetWfSrvtpSql;
import iih.bd.fc.wf.d.EnumFlow;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @Description:医嘱流向算法
 * @author: xu_xing@founder.com.cn
 * @version：2019年1月10日 上午10:57:35 创建
 */
public class FlowEntryBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public OrWfExDeptParamDTO[] exec(OrWfExDeptParamDTO[] params) throws BizException {

		// 1、基础校验
		if (!validation(params))
			return null;

		// 2、获取服务类型流向
		HashMap<OrWfExDeptParamDTO, List<String>> mapParamAndWfRel = new HashMap<OrWfExDeptParamDTO, List<String>>();
		SrvtpFlowDTO[] srvtpWfs = getSrvtpWf(params, mapParamAndWfRel);
		if (srvtpWfs == null || srvtpWfs.length < 1)
			return null;

		// 3、 获取流向科室信息
		DeptFlowDTO[] deptWfs = getDeptWf(srvtpWfs);

		// 4、流向计算
		HashMap<OrWfExDeptParamDTO, List<DeptFlowDTO>> rtnMap = filterFlow(deptWfs, params, mapParamAndWfRel);

		// 5、物品仓库限制处理，构建返回值
		OrWfExDeptParamDTO[] rtns = pkgWfDeptRtn(rtnMap);

		return rtns;
	}

	/**
	 * 基础校验
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private boolean validation(OrWfExDeptParamDTO[] params) throws BizException {
		if (params != null && params.length > 0) {
			int index = 0;
			for (OrWfExDeptParamDTO param : params) {
				if (param == null)
					return false;
				// 就诊类型
				if (StringUtil.isEmpty(param.getCode_entp()))
					throw new BizException("医嘱流向匹配：参数第【" + index + "】行,就诊类型空异常！");
				// 服务类型
				if (StringUtil.isEmpty(param.getSd_srvtp()))
					throw new BizException("医嘱流向匹配：参数第【" + index + "】行,服务类型空异常！");
				// 服务类型
				if (param.getEu_wftp() == null)
					throw new BizException("医嘱流向匹配：参数第【" + index + "】行,流向类型空异常！");
			}
			return true;
		}
		return false;
	}

	/**
	 * 获取服务类型流向
	 * 
	 * @return
	 * @throws BizException
	 */
	private SrvtpFlowDTO[] getSrvtpWf(OrWfExDeptParamDTO[] params, HashMap<OrWfExDeptParamDTO, List<String>> mapParamAndWfRel) throws BizException {
		GetWfSrvtpSql sql = new GetWfSrvtpSql(params[0].getCode_entp());
		SrvtpFlowDTO[] rtns = (SrvtpFlowDTO[]) AppFwUtil.getDORstWithDao(sql, SrvtpFlowDTO.class);
		if (rtns == null || rtns.length < 1)
			return null;
		List<SrvtpFlowDTO> reList = new ArrayList<SrvtpFlowDTO>();
		for (OrWfExDeptParamDTO param : params) {
			List<String> listWf = new ArrayList<String>();
			for (SrvtpFlowDTO flow : rtns) {
				if (!param.getCode_entp().equals(flow.getCode_entp()))
					continue;
				// 业务请求的流向是全部时，不做流向的过滤
				if (EnumFlow.NULL != param.getEu_wftp()) {
					if (!param.getEu_wftp().equals(flow.getEu_wftp()))
						continue;
				}
				if (StringUtil.isEmptyWithTrim(flow.getSd_srvtp()))
					continue;
				// 服务类型向下兼容，业务态的0101 匹配 定义态的 01
				// 原有通过Innercode变更为直接用服务类型的编码
				if (param.getSd_srvtp().indexOf(flow.getSd_srvtp()) == 0) {
					listWf.add(flow.getId_wf());
					// 已经添加过的不用重复添加
					if (reList.contains(flow)) {
						continue;
					} else {
						reList.add(flow);
					}
				}
			}
			mapParamAndWfRel.put(param, listWf);
		}
		return reList.toArray(new SrvtpFlowDTO[0]);
	}

	/**
	 * 获取流向科室信息
	 * 
	 * @param srvtpWfs
	 * @return
	 * @throws BizException
	 */
	private DeptFlowDTO[] getDeptWf(SrvtpFlowDTO[] srvtpWfs) throws BizException {
		String[] id_wfs = WfUtils.getAttrVal(srvtpWfs, "Id_wf");
		GetWfDeptSql sql = new GetWfDeptSql(id_wfs);
		return (DeptFlowDTO[]) AppFwUtil.getDORstWithDao(sql, DeptFlowDTO.class);
	}

	/**
	 * 流向计算
	 * 
	 * @param flowParams
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private HashMap<OrWfExDeptParamDTO, List<DeptFlowDTO>> filterFlow(DeptFlowDTO[] flowParams, OrWfExDeptParamDTO[] params, HashMap<OrWfExDeptParamDTO, List<String>> mapParamAndWfRel) throws BizException {
		FlowFilterBp bp = new FlowFilterBp();
		return bp.exec(flowParams, params, mapParamAndWfRel);
	}

	/**
	 * 物品仓库限制处理，构建返回值
	 * 
	 * @param flowMap
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptParamDTO[] pkgWfDeptRtn(HashMap<OrWfExDeptParamDTO, List<DeptFlowDTO>> flowMap) throws BizException {
		PkgWfDeptRtnBp bp = new PkgWfDeptRtnBp();
		return bp.exec(flowMap);
	}
}
