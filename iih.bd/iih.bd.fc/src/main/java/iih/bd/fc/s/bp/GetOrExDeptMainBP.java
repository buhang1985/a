package iih.bd.fc.s.bp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.wfexdept.GetOrExDepAfterFilterBp;
import iih.bd.fc.s.bp.wfexdept.GetOrExDepInitialBp;
import iih.bd.fc.s.bp.wfexdept.GetOrExDepResultBp;
import iih.bd.fc.s.bp.wfexdept.GetOrExDepValidationBp;
import iih.bd.fc.wf.d.WfAggDO;
import iih.bd.fc.wf.d.WfDepDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.mp.nr.i.IMpNrLogService;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获得医嘱流向的执行科室列表操作BP （含执行科室、物品的取药或发药库房执行科室）
 *
 * @author xuxing
 * @version 2016-07-27开发完成
 */
public class GetOrExDeptMainBP {
	/**
	 * 获得医嘱流向的执行科室列表 （含执行科室、物品的取药或发药库房执行科室）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OrWfExDeptDTO[] exec(OrWfExDeptParamDTO param) throws BizException {

		// 1、有效性判断
		GetOrExDepValidationBp bp = new GetOrExDepValidationBp();
		if (!bp.exec(new OrWfExDeptParamDTO[] { param }))
			return null;

		// 2、根就诊类型 服务类型获取流向集合
		WfAggDO[] wfAggDOS = getIniWfCollection(param);

		// 3、获取过滤后的流向科室集合
		List<WfDepDO> listWfDepts = getFilterDeptDOS(wfAggDOS, param);

		// 4、获取流向结果
		OrWfExDeptDTO[] rtn = getWfResultDept(listWfDepts, param);

		// 5、执行科室匹配情况日志
		// logWrite(param, rtn);

		return rtn;
	}

	private HashMap<String, Integer> mapEuFlow;

	/**
	 * 根就诊类型 服务类型获取流向集合
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private WfAggDO[] getIniWfCollection(OrWfExDeptParamDTO param) throws BizException {
		GetOrExDepInitialBp bp = new GetOrExDepInitialBp();
		HashMap<OrWfExDeptParamDTO, List<WfAggDO>> map = bp.exec(new OrWfExDeptParamDTO[] { param });
		if (map.containsKey(param)) {
			List<WfAggDO> list = map.get(param);
			if (list != null && list.size() > 0) {
				setEuFlow(list);
				return list.toArray(new WfAggDO[0]);
			}
		}
		return null;
	}

	/**
	 * 记录执行流向类型
	 * 
	 * @param list
	 */
	private void setEuFlow(List<WfAggDO> list) {
		if (mapEuFlow == null)
			mapEuFlow = new HashMap<String, Integer>();// 记录流向的类型
		for (WfAggDO wfAggDO : list) {
			mapEuFlow.put(wfAggDO.getParentDO().getId_wf(), wfAggDO.getParentDO().getEu_wftp());
		}
	}

	/**
	 * 获取过滤后的刘流向科室集合
	 * 
	 * @param aggDOS
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private List<WfDepDO> getFilterDeptDOS(WfAggDO[] aggDOS, OrWfExDeptParamDTO param) throws BizException {
		GetOrExDepAfterFilterBp bp = new GetOrExDepAfterFilterBp();
		return bp.exec(aggDOS, param);
	}

	/**
	 * 获取医嘱流向结果
	 * 
	 * @param listWfDepts
	 * @param wfAggDOS
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptDTO[] getWfResultDept(List<WfDepDO> listWfDepts, OrWfExDeptParamDTO param) throws BizException {
		GetOrExDepResultBp bp = new GetOrExDepResultBp();
		return bp.exec(listWfDepts, param, this.mapEuFlow);
	}

	/**
	 * 执行科室匹配情况日志
	 * 
	 * @param param
	 * @param rtn
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private void logWrite(OrWfExDeptParamDTO param, OrWfExDeptDTO[] rtn) throws BizException {
		if (rtn != null && rtn.length > 0) {
			IMedsrvMDORService findService = ServiceFinder.find(IMedsrvMDORService.class);
			MedSrvDO srvDO = findService.findById(param.getId_srv());
			String nameDept = "";
			for (OrWfExDeptDTO DTO : rtn) {
				nameDept += (nameDept.length() == 0 ? "" : "、") + DTO.getName_dept();
			}
			IMpNrLogService service = ServiceFinder.find(IMpNrLogService.class);
			service.log("【" + getNow() + "】 就诊类型【" + param.getCode_entp() + "】 服务【" + srvDO.getName() + "/" + param.getSd_srvtp() + "】 匹配执行科室：" + nameDept, Level.INFO);
		}
	}

	/**
	 * 获取系统时间戳
	 * 
	 * @return
	 */
	public String getNow() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		return format.format(date);
	}
}
