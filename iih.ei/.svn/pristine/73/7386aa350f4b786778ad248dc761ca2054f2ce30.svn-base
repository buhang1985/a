package iih.ei.std.consis.v1.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.founder.i.IHisService;

import iih.bd.base.utils.SqlUtils;
import iih.bd.utils.CommDAFacade;
import iih.bd.utils.WsXmlUtils;
import iih.ei.std.consis.v1.d.PrescInforParamBean;
import iih.ei.std.consis.v1.d.PrescInforParamBeanDetail;
import iih.ei.std.consis.v1.d.PrescInforParamBeanList;
import iih.ei.std.consis.v1.d.PrescInforParamBeanTransf;
import iih.ei.std.consis.v1.d.PrescInforResultBean;
import iih.ei.std.consis.v1.s.bp.qry.FindPrescListQry;
import iih.ei.std.consis.v1.s.bp.qry.FindQueSiteIdByWinNoQry;
import iih.mp.dg.ws.log.utils.WebServiceLog;
import iih.mp.dg.ws.op.d.GetWinNoParamDTO;
import iih.mp.dg.ws.op.d.GetWinNoResultDTO;
import iih.mp.dg.ws.op.d.WsResult;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 获取窗口号基础业务逻辑
 * 
 * @author hao_wu 2018-11-22
 *
 */
public class GetWinNoBp extends BaseCallWsBp {

	protected static String NOTSKIPSIGNOPERACODE = "201"; // 状态码

	protected static String RETURNCODE = "1"; // 返回状态码为1，代表成功

	public GetWinNoResultDTO exec(GetWinNoParamDTO paramDto) {
		GetWinNoResultDTO resultDto;

		try {
			String wsParamStr = getCallWsParam(paramDto);
			String wsResultStr = callWebService(wsParamStr);
			resultDto = getResultDto(paramDto, wsResultStr);
		} catch (Exception e) {
			resultDto = new GetWinNoResultDTO();
			resultDto.setEu_Result(WsResult.ERR);
			resultDto.setMsg_Err(e.getMessage());
			writeLog(e);
		}
		return resultDto;
	}

	/**
	 * 获取调用Ws的参数字符串
	 * 
	 * @param paramDto
	 * @return
	 * @throws BizException
	 */
	protected String getCallWsParam(GetWinNoParamDTO paramDto) throws BizException {
		PrescInforParamBeanList paramBeanList = getParamBeanList(paramDto);
		String paramString = WsXmlUtils.serialize(paramBeanList);
		String paramStringReal = paramString.substring(56);
		return paramStringReal;
	}

	/**
	 * 解析Ws结果，组装结果DTO
	 * 
	 * @param wsResultStr
	 * @return
	 * @throws BizException
	 */
	protected GetWinNoResultDTO getResultDto(GetWinNoParamDTO paramDto, String wsResultStr) throws BizException {
		PrescInforResultBean resultBean = WsXmlUtils.deSerializeBaseDO(wsResultStr, PrescInforResultBean.class);
		if (!GetWinNoBp.RETURNCODE.equals(resultBean.getRetcode())) {
			throw new BizException(resultBean.getRetmsg());
		}
		String winNo = resultBean.getRetmsg();

		String winId = findQueSiteIdByWinNo(winNo, Context.get().getDeptId());

		GetWinNoResultDTO resultDto = getResultDto(paramDto.getId_Pat(), winId);

		return resultDto;
	}

	/**
	 * 调用Web服务
	 * 
	 * @param paramStr
	 * @return
	 */
	protected String callWebService(String paramStr) {

		String param = paramStr;

		WebServiceLog log = new WebServiceLog(IHisService.class.getName());
		String result = null;
		try {
			log.begin(paramStr);
			// 调用摆药机接口
			IHisService hisService = ServiceFinder.find(IHisService.class);
			result = hisService.hisTransData(paramStr);
			log.end(result);
		} catch (Exception e) {
			log.end(e);
			// 调用第三方摆药机异常处理
			result = callWSErrorHandle(param);
		}
		return result;
	}

	private String callWSErrorHandle(String param) {
		WebServiceLog log = new WebServiceLog(IHisService.class.getName());
		String result = null;
		// 设置超时时间
		long beginTime = System.currentTimeMillis();
		// 循环调用第三方接口5次，每次调用前判断超时时间
		for (int i = 0; i < 5; i++) {
			long endTime = System.currentTimeMillis();
			if ((endTime - beginTime) / 1000 > 10) {
				// 当时间超时，则结束
				break;
			}
			try {
				log.begin(param);
				IHisService hisService = ServiceFinder.find(IHisService.class);
				result = hisService.hisTransData(param);
				log.end(result);
			} catch (Exception e) {
				log.end(e);
			}
			//当 5次之内有调用成功，则结束
			if (result != null) {
				return result;
			}
		}
		return result;
	}

	/**
	 * 使用患者主键和窗口主键构建结果DTO
	 * 
	 * @param patId
	 * @param winId
	 * @return
	 */
	protected GetWinNoResultDTO getResultDto(String patId, String winId) {
		GetWinNoResultDTO resultDto = new GetWinNoResultDTO();
		resultDto.setEu_Result(WsResult.SUCC);
		resultDto.setId_Pat(patId);
		resultDto.setId_QueSite(winId);
		return resultDto;
	}

	/**
	 * 根据窗口和科室主键查询站点主键
	 * 
	 * @param winNo
	 * @return
	 * @throws BizException
	 */
	protected String findQueSiteIdByWinNo(String winNo, String depId) throws BizException {
		FindQueSiteIdByWinNoQry qry = new FindQueSiteIdByWinNoQry(winNo, depId);
		DAFacade daFacade = new DAFacade();
		String siteId = (String) daFacade.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new ColumnHandler());
		if (StringUtils.isEmpty(siteId)) {
			String msg = String.format("返回窗口号在IIH中不存在,窗口号:%s,科室主键:%s.", winNo, depId);
			throw new BizException(msg);
		}
		return siteId;
	}

	/**
	 * 设置入参表头
	 * 
	 * @param paramBean
	 * @return
	 * @throws BizException
	 */
	protected PrescInforParamBeanList getParamBeanList(GetWinNoParamDTO paramDto) throws BizException {
		PrescInforParamBeanList prescBeanList = new PrescInforParamBeanList();
		prescBeanList.setOpsystem("HIS");
		prescBeanList.setOptype(GetWinNoBp.NOTSKIPSIGNOPERACODE);
		prescBeanList.setOpwinid("");
		prescBeanList.setOpip("");
		// 终端操作员编码 姓名
		PsnDocDO checkInMachine = getOpreratInfo();
		if (checkInMachine != null) {
			prescBeanList.setOpmanno(checkInMachine.getCode());
			prescBeanList.setOpmanname(checkInMachine.getName());
		} else {
			prescBeanList.setOpmanno("");
			prescBeanList.setOpmanname("");
		}
		// 获取处方主信息和药品明细信息
		List<PrescInforParamBean> presAndDrugParamBeans = getPresAndDrugParamBeans(paramDto);
		prescBeanList.set_prescBeans(presAndDrugParamBeans.toArray(new PrescInforParamBean[0]));
		return prescBeanList;
	}

	/**
	 * 获取操作员(签到机)编码和姓名
	 * 
	 * @throws BizException
	 */
	protected PsnDocDO getOpreratInfo() throws BizException {
		String userId = Context.get().getStuffId();
		IPsndocRService psndocRService = ServiceFinder.find(IPsndocRService.class);
		PsndocAggDO psndocAggDO = psndocRService.findById(userId);
		PsnDocDO checkInMachine = (PsnDocDO) psndocAggDO.getParent();
		return checkInMachine;
	}

	/**
	 * 获取处方主信息
	 * 
	 * @param paramBean1
	 * @return
	 * @throws BizException
	 */
	protected List<PrescInforParamBean> getPresAndDrugParamBeans(GetWinNoParamDTO paramDto) throws BizException {
		String inSqlByIds = SqlUtils.getInSqlByIds("PRES.ID_PRES", paramDto.getPresIds());
		FindPrescListQry qry = new FindPrescListQry(inSqlByIds, Context.get().getDeptId(), paramDto.getCode_EnCard());
		// 处方和药品数据集 需要处理
		PrescInforParamBeanTransf[] presAndDrugInfo = CommDAFacade.execQuery(qry, PrescInforParamBeanTransf.class);
		// 获得处方集合
		Map<String, PrescInforParamBeanTransf> paramBeanTransfMap = getparamBeanTransfMap(presAndDrugInfo);
		List<PrescInforParamBean> prescBeans = getPrescBeans(paramBeanTransfMap);
		// 获得药品明细
		setDrugBeanDetails(presAndDrugInfo, prescBeans);
		// 设置处方金额
		setPresCostTotal(prescBeans);
		return prescBeans;
	}

	/**
	 * 设置处方金额
	 * 
	 * @param prescBeans
	 */
	protected void setPresCostTotal(List<PrescInforParamBean> prescBeans) {
		FDouble costTotal;
		for (PrescInforParamBean prescInfor : prescBeans) {
			costTotal = new FDouble();
			PrescInforParamBeanDetail[] drugDetails = prescInfor.get_prescBeanDetails();
			for (PrescInforParamBeanDetail drugDetail : drugDetails) {
				costTotal = costTotal.add(new FDouble(drugDetail.getCosts()).multiply(drugDetail.getQuantity()));
			}
			prescInfor.setCosts(costTotal.toDouble());
			prescInfor.setPayments(costTotal.toDouble());
		}

	}

	/**
	 * 设置药品明细
	 * 
	 * @param execQuery
	 * @param prescBeans
	 * @throws BizException
	 */
	protected void setDrugBeanDetails(PrescInforParamBeanTransf[] presAndDrugInfo, List<PrescInforParamBean> prescBeans)
			throws BizException {
		for (PrescInforParamBean prescBean : prescBeans) {
			List<PrescInforParamBeanDetail> drugBeanDetails = new ArrayList<PrescInforParamBeanDetail>();
			for (PrescInforParamBeanTransf PrescTransf : presAndDrugInfo) {
				PrescInforParamBeanDetail drugBeanDetail = new PrescInforParamBeanDetail();
				if (prescBean.getPresc_no().equals(PrescTransf.getPresc_no())) {
					drugBeanDetail.setPresc_no(PrescTransf.getPresc_no());
					drugBeanDetail.setItem_no(PrescTransf.getItem_no());
					drugBeanDetail.setDrug_code(PrescTransf.getDrug_code());
					drugBeanDetail.setDrug_name(PrescTransf.getDrug_name());
					drugBeanDetail.setQuantity(PrescTransf.getQuantity());
					drugBeanDetail.setUnit(PrescTransf.getUnit());
					drugBeanDetail.setDrug_spec(PrescTransf.getDrug_spec());
					drugBeanDetail.setAdministration(PrescTransf.getAdministration());
					drugBeanDetail.setFrequency(PrescTransf.getFrequency());
					drugBeanDetail.setCosts(PrescTransf.getCosts_detail());// 两个价格同一个
					drugBeanDetail.setPayments(PrescTransf.getCosts_detail());
					drugBeanDetail.setDosage(PrescTransf.getDosage());
					drugBeanDetail.setDosage_units(PrescTransf.getDosage_units());
					drugBeanDetail.setAdvice_code("");
					drugBeanDetail.setFirm_id("");
					drugBeanDetail.setFirm_name("");
					drugBeanDetail.setPackage_spec("");
					drugBeanDetail.setPackage_units("");
					drugBeanDetail.setAdditionusage("");
					drugBeanDetail.setRcpt_remark("");
					drugBeanDetails.add(drugBeanDetail);

				}
			}
			prescBean.set_prescBeanDetails(drugBeanDetails.toArray(new PrescInforParamBeanDetail[0]));
		}
	}

	/**
	 * 获取处方集合
	 * 
	 * @param paramBeanTransfMap
	 * @return
	 */
	protected List<PrescInforParamBean> getPrescBeans(Map<String, PrescInforParamBeanTransf> paramBeanTransfMap) {
		List<PrescInforParamBean> prescBeans = new ArrayList<PrescInforParamBean>();
		for (Entry<String, PrescInforParamBeanTransf> entry : paramBeanTransfMap.entrySet()) {
			PrescInforParamBeanTransf presAndDrugInfo = entry.getValue();
			PrescInforParamBean presInfo = new PrescInforParamBean();
			presInfo.setPresc_date(presAndDrugInfo.getPresc_date());
			presInfo.setPresc_no(presAndDrugInfo.getPresc_no());
			presInfo.setDispensary(presAndDrugInfo.getDispensary());
			presInfo.setPatient_id(presAndDrugInfo.getPatient_id());
			presInfo.setPatient_name(presAndDrugInfo.getPatient_name());
			presInfo.setDate_of_birth(presAndDrugInfo.getDate_of_birth());
			presInfo.setSex(presAndDrugInfo.getSex());
			presInfo.setOrdered_by(presAndDrugInfo.getOrdered_by());
			presInfo.setOrdered_by_name(presAndDrugInfo.getOrdered_by_name());
			presInfo.setPrescribed_by(presAndDrugInfo.getPrescribed_by());
			if (presAndDrugInfo.getRepetition() == null) {
				presInfo.setRepetition(0);
			} else {
				presInfo.setRepetition(Integer.parseInt(presAndDrugInfo.getRepetition()));
			}
			presInfo.setDispense_pri(Integer.parseInt(presAndDrugInfo.getDispense_pri()));
			presInfo.setInvoice_no("");
			presInfo.setPatient_type("00");
			presInfo.setPresc_identity("");
			presInfo.setCharge_type("");
			presInfo.setPresc_attr("");
			presInfo.setPresc_info("");
			presInfo.setRcpt_info(presAndDrugInfo.getRcpt_info());
			presInfo.setRcpt_remark("");
			presInfo.setEntered_by("");
			prescBeans.add(presInfo);
		}
		return prescBeans;
	}

	/**
	 * 处方编码为key，把处方数据集抽取出来
	 * 
	 * @param presAndDrugInfo
	 * @return
	 * @throws BizException
	 */
	protected Map<String, PrescInforParamBeanTransf> getparamBeanTransfMap(PrescInforParamBeanTransf[] presAndDrugInfo)
			throws BizException {
		Map<String, PrescInforParamBeanTransf> paramBeanTransfMap = new HashMap<String, PrescInforParamBeanTransf>();
		for (PrescInforParamBeanTransf prescTransf : presAndDrugInfo) {
			paramBeanTransfMap.put(prescTransf.getPresc_no(), prescTransf);
		}
		return paramBeanTransfMap;
	}
}
