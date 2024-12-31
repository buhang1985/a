package iih.bd.fc.s.bp.wfexdept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.base.define.StringObjectMap;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.qry.GetWfSql;
import iih.bd.fc.s.bp.qry.getUdidocDOSql;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.d.WfDO;
import iih.bd.fc.wf.d.WfSrvtpDO;
import iih.bd.fc.wf.i.IWfRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 
 * @author xuxing
 * @version 2016-11-22增加执行流向过滤
 */
public class GetOrExDepInitialBp {

	/**
	 * 根据初始就诊类型，服务类型，获取流向集合
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public HashMap<OrWfExDeptParamDTO, List<WfAggDO>> exec(OrWfExDeptParamDTO[] params) throws BizException {

		// 1、取医疗服务字典
		StringObjectMap srvtpMap = getSrvtpDoc();

		// 2、获取全部的流向信息
		WfAggDO[] allWfAggs = getWfAgg();

		// 3、获取指定就诊类型下的全部流向信息
		WfAggDO[] wfAggs = getWfInfoByCodeEntp(allWfAggs, params);

		// 4、根据流向参数，匹配定义态的医嘱流向并分组
		HashMap<OrWfExDeptParamDTO, List<WfAggDO>> reMap = getWfAggMapInfo(wfAggs, params, srvtpMap);

		return reMap;
	}

	/**
	 * 取医疗服务字典
	 * 
	 * @return
	 * @throws BizException
	 */
	private StringObjectMap getSrvtpDoc() throws BizException {
		StringObjectMap sdSrvtpMap;

		getUdidocDOSql SqlUdi = new getUdidocDOSql(new String[0]);
		UdidocDO[] udidoc = (UdidocDO[]) AppFwUtil.getDORstWithDao(SqlUdi, UdidocDO.class);
		sdSrvtpMap = new StringObjectMap();
		if (udidoc != null && udidoc.length > 0) {
			for (UdidocDO doc : udidoc) {
				if (!sdSrvtpMap.containsKey(doc.getCode())) {
					sdSrvtpMap.put(doc.getCode(), doc.getInnercode());
				}
			}
		}

		return sdSrvtpMap;
	}

	/**
	 * 获取全部的流向信息
	 * 
	 * @return
	 * @throws BizException
	 */
	private WfAggDO[] getWfAgg() throws BizException {

		IWfRService findService = ServiceFinder.find(IWfRService.class);
		WfAggDO[] aggDos = findService.find("1=1", "", FBoolean.FALSE);

		return aggDos;
	}

	/**
	 * 获取指定就诊类型/流向下的全部流向信息
	 * 
	 * @param aggDos
	 * @param params
	 * @return
	 */
	private WfAggDO[] getWfInfoByCodeEntp(WfAggDO[] aggDos, OrWfExDeptParamDTO[] params) {
		String code_entp = "";
		for (OrWfExDeptParamDTO param : params) {
			if (!StringUtil.isEmptyWithTrim(code_entp))
				break;
			code_entp = param.getCode_entp();
		}
		List<WfAggDO> reList = new ArrayList<WfAggDO>();
		for (WfAggDO agg : aggDos) {
			WfDO parentDO = agg.getParentDO();
			if (parentDO == null || StringUtil.isEmptyWithTrim(parentDO.getCode_entp()))
				continue;
			if (code_entp.equals(parentDO.getCode_entp()))
				reList.add(agg);
		}
		return reList.toArray(new WfAggDO[0]);
	}

	/**
	 * 根据流向参数，匹配定义态的医嘱流向并分组
	 * 
	 * @param aggDos
	 * @param params
	 * @param srvtpMap
	 * @return
	 */
	private HashMap<OrWfExDeptParamDTO, List<WfAggDO>> getWfAggMapInfo(WfAggDO[] aggDos, OrWfExDeptParamDTO[] params,
			StringObjectMap srvtpMap) {
		HashMap<OrWfExDeptParamDTO, List<WfAggDO>> reMap = new HashMap<OrWfExDeptParamDTO, List<WfAggDO>>();
		for (OrWfExDeptParamDTO param : params) {
			List<WfAggDO> listAgg = getWfByParam(aggDos, param, srvtpMap);
			reMap.put(param, listAgg);
		}
		return reMap;
	}

	/**
	 * 获取单个参数下的流向集合
	 * 
	 * @param aggs
	 * @param param
	 * @param srvtpMap
	 * @return
	 */
	private List<WfAggDO> getWfByParam(WfAggDO[] aggs, OrWfExDeptParamDTO param, StringObjectMap srvtpMap) {
		List<WfAggDO> reList = new ArrayList<WfAggDO>();
		if (StringUtil.isEmptyWithTrim(param.getSd_srvtp()))
			return null;
		// 业务台的服务类型内码
		String paramInnerCode = srvtpMap.get(param.getSd_srvtp()).toString();
		for (WfAggDO agg : aggs) {
			if (EnumFlow.NULL != param.getEu_wftp()) {
				// 入参请求的非全部，需要匹配执行流向类型
				if (agg.getParentDO().getEu_wftp() != param.getEu_wftp())
					continue;
			}
			for (WfSrvtpDO wfSrvtp : agg.getWfSrvtpDO()) {
				// 定义态的服务类型内码
				String defInnerCode = srvtpMap.get(wfSrvtp.getSd_srvtp()).toString();
				if (StringUtil.isEmptyWithTrim(defInnerCode))
					continue;
				// 比如定义态01 业务态0101 匹配成功
				if (paramInnerCode.startsWith(defInnerCode))
					reList.add(agg);
			}
		}
		return reList;
	}

	/**
	 * 获取流向主DO
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private WfDO[] getWfDOS(OrWfExDeptParamDTO[] params) throws BizException {
		String[] sdSrvtps = getSdsrvtps(params);
		String[] innerCodes = getInnerCodes(sdSrvtps);
		GetWfSql Sql = new GetWfSql(params[0].getCode_entp(), innerCodes, params[0].getEu_wftp());
		WfDO[] wfDOS = (WfDO[]) AppFwUtil.getDORstWithDao(Sql, WfDO.class);
		return wfDOS;
	}

	/**
	 * 获取医疗服务编码集合
	 * 
	 * @param params
	 * @return
	 */
	private String[] getSdsrvtps(OrWfExDeptParamDTO[] params) {
		List<String> listCode = new ArrayList<String>();
		for (OrWfExDeptParamDTO param : params) {
			if (!listCode.contains(param.getSd_srvtp()))
				listCode.add(param.getSd_srvtp());
		}
		return listCode.toArray(new String[listCode.size()]);
	}

	/**
	 * 获取服务类型对应的内码集合
	 * 
	 * @param sdSrvtps
	 * @return
	 * @throws BizException
	 */
	private String[] getInnerCodes(String[] sdSrvtps) throws BizException {
		getUdidocDOSql SqlUdi = new getUdidocDOSql(sdSrvtps);
		UdidocDO[] udidoc = (UdidocDO[]) AppFwUtil.getDORstWithDao(SqlUdi, UdidocDO.class);
		List<String> listInnerCode = new ArrayList<String>();
		if (udidoc != null && udidoc.length > 0) {
			for (UdidocDO doc : udidoc) {
				if (!listInnerCode.contains(doc.getInnercode())) {
					listInnerCode.add(doc.getInnercode());
				}
			}
		}
		return listInnerCode.toArray(new String[listInnerCode.size()]);
	}

	/**
	 * 获取流向AggDO
	 * 
	 * @param wfDOS
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private WfAggDO[] getAggDOS(WfDO[] wfDOS) throws BizException {
		if (wfDOS != null && wfDOS.length > 0) {
			IWfRService findService = ServiceFinder.find(IWfRService.class);
			List<String> listWfIds = new ArrayList<String>();
			for (WfDO wf : wfDOS) {
				if (!listWfIds.contains(wf.getId_wf())) {
					listWfIds.add(wf.getId_wf());
				}
			}
			return findService.findByIds(listWfIds.toArray(new String[listWfIds.size()]), FBoolean.FALSE);
		}
		return null;
	}
}
