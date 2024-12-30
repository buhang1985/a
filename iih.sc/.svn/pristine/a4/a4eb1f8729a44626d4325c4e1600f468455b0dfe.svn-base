package iih.sc.apt.s.bp.oral;

import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationRService;
import iih.sc.comm.ScParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.paramset.d.ParamSetDO;
import xap.sys.devcfg.paramset.i.IParamsetRService;
import xap.sys.devcfg.paramtmplset.d.ParamTmplSetDO;
import xap.sys.devcfg.paramtmplset.i.IParamtmplsetRService;

/**
 * 获取医技预约告知单打印机BP
 * 
 * @author yzh
 * @date 2019年7月2日13:31:27
 *
 */
public class GetMtNoticePrinterBP {

	/**
	 * 获取医技预约告知单打印机
	 *
	 * @author zhengcm
	 * 
	 * @return
	 * @throws BizException
	 */
	public ParamSetDO exec() throws BizException {
		ParamSetDO result = GetMtNoticePrinter();
		return result;
	}

	/**
	 * 获取口腔预约打印机
	 * 
	 * @return
	 * @throws BizException
	 */
	private ParamSetDO GetMtNoticePrinter() throws BizException {
		String pcId = GetClientPcId();
		ParamSetDO paramSetDO = GetParamSetByPcId(pcId);
		if (paramSetDO == null) {
			paramSetDO = CreateParamSet(pcId);
		}
		return paramSetDO;
	}

	/**
	 * 获取客户计算机ID
	 * 
	 * @return
	 * @throws BizException
	 */
	private String GetClientPcId() throws BizException {
		String pcHostId = Context.get().getClientHost();
		IWorkstationRService workstationRService = ServiceFinder.find(IWorkstationRService.class);
		WorkStationPcDO[] result = workstationRService.findByAttrValString(WorkStationPcDO.PCID, pcHostId);
		if (result == null || result.length <= 0) {
			String msg = String.format("获取计算机信息失败，计算机标识:\"%s\"。", pcHostId);
			throw new BizException(msg);
		}
		return result[0].getId_pc();
	}

	/**
	 * 根据计算机ID获取打印机参数设置
	 * 
	 * @param pcId
	 * @return
	 * @throws BizException
	 */
	private ParamSetDO GetParamSetByPcId(String pcId) throws BizException {
		IParamsetRService paramsetRService = ServiceFinder.find(IParamsetRService.class);
		String wherePart = String.format("paramcode = '%s' and id_instance = '%s'", ScParamUtils.SCPC_PRINTER_MTAPPLY,
				pcId);
		ParamSetDO[] result = paramsetRService.find(wherePart, "", FBoolean.FALSE);
		if (result != null && result.length > 0) {
			return result[0];
		}
		return null;
	}

	/**
	 * 使用参数模板创建参数设置
	 * 
	 * @param pcId
	 * @return
	 * @throws BizException
	 */
	private ParamSetDO CreateParamSet(String pcId) throws BizException {
		ParamTmplSetDO paramTmplSetDO = GetParamTmpl();
		ParamSetDO result = CreateParamSet(pcId, paramTmplSetDO);
		return result;
	}

	/**
	 * 使用计算机Id和参数模板创建参数设置实体
	 * 
	 * @param pcId
	 * @param paramTmplSetDO
	 * @return
	 */
	private ParamSetDO CreateParamSet(String pcId, ParamTmplSetDO paramTmplSetDO) {

		ParamSetDO newparamDo = new ParamSetDO();

		newparamDo.setId_org(Context.get().getOrgId());
		newparamDo.setStatus(DOStatus.NEW);

		newparamDo.setId_paramtmplset(paramTmplSetDO.getId_paramtmplset());
		newparamDo.setParamcode(paramTmplSetDO.getParamcode());
		newparamDo.setParamname(paramTmplSetDO.getParamname());
		newparamDo.setValue(paramTmplSetDO.getDefaultvalue());
		newparamDo.setId_instance(pcId);
		newparamDo.setIseditable(FBoolean.TRUE);
		newparamDo.setIsctldownlevel(FBoolean.FALSE);

		return newparamDo;
	}

	/**
	 * 获取参数模板
	 * 
	 * @return
	 * @throws BizException
	 */
	private ParamTmplSetDO GetParamTmpl() throws BizException {
		IParamtmplsetRService paramtmplsetRService = ServiceFinder.find(IParamtmplsetRService.class);
		ParamTmplSetDO[] result = paramtmplsetRService.findByAttrValString(ParamTmplSetDO.PARAMCODE,
				ScParamUtils.SCPC_PRINTER_MTAPPLY);
		if (result == null || result.length <= 0) {
			String msg = String.format("获取参数模板失败，参数编码:\"%s\"。", ScParamUtils.ENPC_APTNOTE_PRINTER);
			throw new BizException(msg);
		}
		return result[0];
	}

}
