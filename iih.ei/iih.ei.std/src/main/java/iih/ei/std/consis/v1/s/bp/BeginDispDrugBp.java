package iih.ei.std.consis.v1.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.founder.i.IHisService;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQueSiteQryService;
import iih.bd.utils.WsXmlUtils;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ei.std.consis.v1.d.PrescBeginDispParamBean;
import iih.ei.std.consis.v1.d.PrescBeginDispParamBeanList;
import iih.mp.dg.ws.log.utils.WebServiceLog;
import iih.mp.dg.ws.op.d.BeginDispDrugParamDTO;
import iih.mp.dg.ws.op.d.BeginDispDrugResultDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 开始发药基础业务逻辑
 * 
 * @author hao_wu 2018-11-22
 *
 */
public class BeginDispDrugBp extends BaseCallWsBp {

	public BeginDispDrugResultDTO[] exec(BeginDispDrugParamDTO paramDto) {

		BeginDispDrugResultDTO[] resultDtos = null;

		try {
			String wsParamStr = getCallWsParam(paramDto);
			String wsResultStr = callWebService(wsParamStr);
			resultDtos = getResultDto(paramDto, wsResultStr);
		} catch (Exception e) {
			writeLog(e);
		}
		return resultDtos;
	}

	@Override
	protected String callWebService(String paramXml) throws BizException {

		WebServiceLog log = new WebServiceLog(IHisService.class.getName());
		String resultXml = null;
		try {
			log.begin(paramXml);
			IHisService hisService = ServiceFinder.find(IHisService.class);
			resultXml = hisService.hisTransData(paramXml);
			log.end(resultXml);
		} catch (Exception e) {
			log.end(e);
		}

		return resultXml;
	}

	/**
	 * 获取调用WebService参数
	 * 
	 * @param paramDto
	 * @return
	 * @throws BizException
	 */
	protected String getCallWsParam(BeginDispDrugParamDTO paramDto) throws BizException {
		String winNo = findQueSiteCode();

		PrescBeginDispParamBeanList paramBeanList = getParamBeanList(winNo, paramDto.getPresIds());
		String paramXml = WsXmlUtils.serialize(paramBeanList);
		paramXml = paramXml.substring(56);
		return paramXml;
	}

	/**
	 * 获取结果DTO
	 * 
	 * @param paramDto
	 * @param wsResultStr
	 * @return
	 */
	protected BeginDispDrugResultDTO[] getResultDto(BeginDispDrugParamDTO paramDto, String wsResultStr) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取表头入参
	 * 
	 * @param paramBean
	 * @return
	 * @throws BizException
	 */
	protected PrescBeginDispParamBeanList getParamBeanList(String queSiteCode, String[] presIds) throws BizException {
		PrescBeginDispParamBeanList prescBeanList = new PrescBeginDispParamBeanList();
		prescBeanList.setOpsystem("HIS");
		prescBeanList.setOptype("202");
		prescBeanList.setOpwinid(queSiteCode);
		prescBeanList.setOpip("");
		// 终端操作员编码 姓名
		PsnDocDO psnDocDo = getOpreratInfo();
		if (psnDocDo != null) {
			prescBeanList.setOpmanno(psnDocDo.getCode());
			prescBeanList.setOpmanname(psnDocDo.getName());
		} else {
			prescBeanList.setOpmanno("");
			prescBeanList.setOpmanname("");
		}
		PrescBeginDispParamBean[] paramBeans = getParamBeans(presIds);
		prescBeanList.set_prescDispBeans(paramBeans);
		return prescBeanList;
	}

	/**
	 * 获取操作员编码和姓名
	 * 
	 * @throws BizException
	 */
	protected PsnDocDO getOpreratInfo() throws BizException {
		DAFacade daFacade = new DAFacade();
		PsnDocDO psnDocDO = (PsnDocDO) daFacade.findByPK(PsnDocDO.class, Context.get().getStuffId());
		return psnDocDO;
	}

	/**
	 * 获得入参主信息
	 * 
	 * @param paramBean
	 * @return
	 * @throws BizException
	 */
	protected PrescBeginDispParamBean[] getParamBeans(String[] presIds) throws BizException {

		CiPresDO[] presDos = this.findPresDoByIds(presIds);

		List<PrescBeginDispParamBean> prescBeans = new ArrayList<PrescBeginDispParamBean>();
		for (CiPresDO presDo : presDos) {
			PrescBeginDispParamBean paramBean = new PrescBeginDispParamBean();
			// TODO:DT_OR
			FDateTime dt_or = presDo.getDt_entry();
			String depCode = getDepCode();
			paramBean.setDispensary(depCode);
			paramBean.setPresc_date(dt_or.toString());
			paramBean.setPresc_no(presDo.getId_pres());
			paramBean.setInvoice_no("");
			prescBeans.add(paramBean);
		}
		return prescBeans.toArray(new PrescBeginDispParamBean[0]);
	}

	/**
	 * 根据处方主键集合查询处方信息
	 * 
	 * @param presIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected CiPresDO[] findPresDoByIds(String[] presIds) throws BizException {
		DAFacade daFacade = new DAFacade();
		ArrayList<CiPresDO> presList = (ArrayList<CiPresDO>) daFacade.findByPKs(CiPresDO.class, presIds);
		if (presList == null || presList.size() <= 0) {
			String msg = String.format("根据处方主键集合查询处方信息失败，未查询到处方信息,处方主键:%s.", StringUtils.join(presIds, ','));
			throw new BizException(msg);
		}
		return presList.toArray(new CiPresDO[0]);
	}

	/**
	 * 获取科室编码
	 * 
	 * @return
	 * @throws BizException
	 */
	protected String getDepCode() throws BizException {
		DAFacade daFacade = new DAFacade();
		DeptDO deptDO = (DeptDO) daFacade.findByPK(DeptDO.class, Context.get().getDeptId());
		return deptDO.getCode();
	}

	/**
	 * 查询当前发药窗口编码
	 * 
	 * @return
	 * @throws BizException
	 */
	protected String findQueSiteCode() throws BizException {
		IQueSiteQryService queSiteQryService = ServiceFinder.find(IQueSiteQryService.class);
		QueSiteDO currentWin = queSiteQryService.findCurrWinByDepId(Context.get().getDeptId());
		return currentWin.getCode();
	}
}
