package iih.ci.mb.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.validator.ParamValidator;
import iih.bd.bc.udi.pub.IMpNsDictCodeTypeConst;
import iih.ci.mb.bp.qry.GetPatOrderInfoSql;
import iih.ci.mb.i.ArrayOfDCDoctorAdvice;
import iih.ci.mb.i.DCDoctorAdvice;
import iih.ci.mb.i.GetDoctorAdviceOfPatientHRResponse;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 获取患者医嘱列表
 * 
 * @author yankan
 * @since 2018-03-22
 *
 */
public class GetPatIpOrdListBP {

	/**
	 * 主入口
	 * 
	 * @param id_pat
	 * @param times_ip
	 * @return
	 * @throws BizException
	 */
	public GetDoctorAdviceOfPatientHRResponse exec(String entId) throws BizException {
		ParamValidator.validateNotNull("就诊ID", entId);

		// 1、查询数据
		List<DCDoctorAdvice> list = queryData(entId);

		// 2.查询医嘱状态字典参照
		Map<String, String> map = getOrderStatusColor();
		// 3.设置医嘱状态及色值
		handleStatus(list, map);

		// 4、组装返回数据
		GetDoctorAdviceOfPatientHRResponse response = wrapResponse(list);
		return response;
	}

	/**
	 * 查询数据
	 * 
	 * @param entId
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private List<DCDoctorAdvice> queryData(String entId) throws DAException {
		GetPatOrderInfoSql sql = new GetPatOrderInfoSql(entId);
		return (List<DCDoctorAdvice>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(DCDoctorAdvice.class));
	}

	/**
	 * 查询医嘱状态字典返回编码与扩展字段的映射
	 * 
	 * @return
	 * @throws BizException
	 */
	private Map<String, String> getOrderStatusColor() throws BizException {
		Map<String, String> map = new HashMap<String, String>();
		GetUdidocByTypeCodeBP getUdidocBP = new GetUdidocByTypeCodeBP();
		Map<String,UdidocDO> udidocMap= getUdidocBP.exec(IMpNsDictCodeTypeConst.SD_MB_ORDERSTATUS);
		for (UdidocDO udidocDO : udidocMap.values()) {
			map.put(udidocDO.getCode(), udidocDO.getCtrl1());
		}
		//医嘱状态补齐
		Map<String,UdidocDO> udidocMap1= getUdidocBP.exec("CI.OR.0505");
		for (UdidocDO udidocDO : udidocMap1.values()) {
			if(!map.containsKey(udidocDO.getCode()))
			{
				String color="22ac38";
				switch(udidocDO.getCode())
				{
				case "0":
					color="22ac38";
					break;
				case "30":
					color="0066ff";
					break;
				case "40":
					color="535353";
					break;
				default:
					color="535353";
					
				}
				map.put(udidocDO.getCode(), color);
			}
		}
		return map;
	}

	/**
	 * 状态转换
	 * 
	 * @param list
	 * @param map
	 */
	private void handleStatus(List<DCDoctorAdvice> list, Map<String, String> map) {
		if (list != null && list.size() > 0) {
			CalOrderStatusBp bp = new CalOrderStatusBp();
			bp.initStatusList();
			for (DCDoctorAdvice param : list) {
				if(param.getStateString()=="执行中")
					param.setColorValue(map.get("30"));
				else
					param.setColorValue(map.get(param.getState()));
			}
		}
	}

	/**
	 * 组装返回数据
	 * 
	 * @param list
	 * @return
	 */
	private GetDoctorAdviceOfPatientHRResponse wrapResponse(List<DCDoctorAdvice> list) {
		GetDoctorAdviceOfPatientHRResponse rtn = new GetDoctorAdviceOfPatientHRResponse();
		ArrayOfDCDoctorAdvice ors = new ArrayOfDCDoctorAdvice();
		ors.setDCDoctorAdvice(list.toArray(new DCDoctorAdvice[list.size()]));
		rtn.setGetDoctorAdviceOfPatientHRResult(ors);
		return rtn;
	}
}
