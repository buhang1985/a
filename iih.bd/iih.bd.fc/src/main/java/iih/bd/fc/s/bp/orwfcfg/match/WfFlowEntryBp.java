package iih.bd.fc.s.bp.orwfcfg.match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.fc.dto.deptflow.d.SrvtpFlowDTO;
import iih.bd.fc.dto.orwf.d.CfgFlowBas;
import iih.bd.fc.dto.orwf.d.WfCfgDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.common.LogUtils;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.fc.s.bp.orwfcfg.qry.GetWfDetailSql;
import iih.bd.fc.s.bp.orwfcfg.qry.GetWfSrvtpIndexSql;
import iih.bd.fc.wf.d.EnumFlow;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @Description:医嘱流向2.0匹配
 * @author: xu_xing@founder.com.cn
 * @version：2019年4月26日 下午6:17:16 创建
 */
public class WfFlowEntryBp {

	/**
	 * 主入口
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public OrWfExDeptParamDTO[] exec(OrWfExDeptParamDTO[] params) throws BizException {

		LogUtils log = new LogUtils();
		log.setPoint("医嘱流向2.0匹配逻辑");

		//1、基础校验
		validation(params);

		//2、获取服务类型流向
		HashMap<OrWfExDeptParamDTO, List<String>> mapRel = new HashMap<OrWfExDeptParamDTO, List<String>>();
		SrvtpFlowDTO[] srvtpWfs = getSrvtpWf(params, mapRel);
		if (srvtpWfs == null || srvtpWfs.length < 1)
			return null;

		//3、获取流向索引信息
		WfCfgDTO[] wfCfgDtls = getDeptWf(srvtpWfs);

		//4、数据转换
		CfgFlowBas[] flowBas = dataConvert(wfCfgDtls);

		//5、流向匹配
		HashMap<OrWfExDeptParamDTO, List<CfgFlowBas>> matchRtn = wfMatch(flowBas, params, mapRel);

		//6、停开库存校验，组装返回值
		OrWfExDeptParamDTO[] rtns = packageFlow(matchRtn);

		log.setFinishLog();

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
	 * 获取流向索引信息
	 * 
	 * @return
	 * @throws BizException
	 */
	private SrvtpFlowDTO[] getSrvtpWf(OrWfExDeptParamDTO[] params, HashMap<OrWfExDeptParamDTO, List<String>> mapRel) throws BizException {
		GetWfSrvtpIndexSql sql = new GetWfSrvtpIndexSql();
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
			mapRel.put(param, listWf);
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
	private WfCfgDTO[] getDeptWf(SrvtpFlowDTO[] srvtpWfs) throws BizException {
		String[] id_wfs = WfUtils.getAttrVal(srvtpWfs, "Id_wf");
		GetWfDetailSql sql = new GetWfDetailSql(id_wfs);
		return (WfCfgDTO[]) AppFwUtil.getDORstWithDao(sql, WfCfgDTO.class);
	}

	/**
	 * 数据转换
	 * 
	 * @param params
	 * @return
	 */
	private CfgFlowBas[] dataConvert(WfCfgDTO[] wfCfgDtls) {
		CfgDtlConvertBp bp = new CfgDtlConvertBp();
		return bp.exec(wfCfgDtls);
	}

	/**
	 * 流向匹配
	 * 
	 * @param flowBas
	 * @param params
	 * @param mapRel
	 * @return
	 * @throws BizException
	 */
	private HashMap<OrWfExDeptParamDTO, List<CfgFlowBas>> wfMatch(CfgFlowBas[] flowBas, OrWfExDeptParamDTO[] params, HashMap<OrWfExDeptParamDTO, List<String>> mapRel) throws BizException {
		FlowFilterBp bp = new FlowFilterBp();
		return bp.exec(flowBas, params, mapRel);
	}

	/**
	 * 停开库存校验，组装返回值
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptParamDTO[] packageFlow(HashMap<OrWfExDeptParamDTO, List<CfgFlowBas>> params) throws BizException {
		FlowMmWhBp bp = new FlowMmWhBp();
		return bp.exec(params);
	}
}
