package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.MapUtils;
import iih.bl.params.BlParamConst;
import iih.bl.params.BlParams;
import iih.bl.st.dto.d.BlPrinterSetDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.cenum.d.DataFromTypeEnum;
import xap.sys.devcfg.paramset.d.ParamSetDO;
import xap.sys.devcfg.paramset.i.IParamsetCudService;
import xap.sys.devcfg.paramset.i.IParamsetRService;
import xap.sys.devcfg.paramtmplset.d.ParamTmplSetDO;
import xap.sys.devcfg.paramtmplset.i.IParamtmplsetRService;

/**
 * 保存费用域打印配置(新)
 * @author ly 2019/09/02
 *
 */
public class BlSavePrinterSetInfoNewBP {

	private final static String[] PRINT_PARAM = new String[] {
			BlParamConst.BLINC0005, BlParamConst.BLINC0004,
			BlParamConst.BLINC0007, BlParamConst.BLINC0006,
			BlParamConst.BLINC0002, BlParamConst.BLINC0003,
			BlParamConst.BLINC0001, BlParamConst.BLINC0008,
			BlParamConst.BLSTIP0003, BlParamConst.BLSTOEP0005,
			"barPrintConfig","PIPAT0090",BlParamConst.BLINC0039,BlParamConst.BLINC0040};
	
	/**
	 * 保存费用域打印配置(新)
	 * @param blPrinterSetDTO
	 * @throws BizException
	 */
	public void exec(BlPrinterSetDTO blPrinterSetDTO) throws BizException{
		
		if(blPrinterSetDTO == null){
			throw new ArgumentNullException("保存打印配置","配置信息");
		}
		
		String pcId = BlParams.getRealPcId(Context.get().getClientHost());
		
		IParamtmplsetRService tmplSevice = ServiceFinder.find(IParamtmplsetRService.class);
		ParamTmplSetDO[] paramTmplSetDos = tmplSevice.findByAttrValStrings(ParamTmplSetDO.PARAMCODE, PRINT_PARAM);
		Map<String,ParamTmplSetDO> tmplMap = MapUtils.convertArrayToMap(paramTmplSetDos, ParamTmplSetDO.PARAMCODE);
		
		IParamsetRService setRService= ServiceFinder.find(IParamsetRService.class);
		IParamsetCudService setCudService= ServiceFinder.find(IParamsetCudService.class);
		StringBuilder bd = new StringBuilder("id_instance = '" + pcId + "' and paramcode in (");
		String douHao = "";
		for (String paramcode : PRINT_PARAM) {
			bd.append(douHao).append("'").append(paramcode).append("'");
			douHao = ",";
		}
		bd.append(")");
		String whereSql = bd.toString();
		ParamSetDO[] paramSetDos = setRService.find(whereSql, null, FBoolean.FALSE);
		Map<String,ParamSetDO> oldParamSetMap = MapUtils.convertArrayToMap(paramSetDos, ParamTmplSetDO.PARAMCODE);
		
		List<ParamSetDO> saveList = new ArrayList<ParamSetDO>();
		//门诊预交金打印机
		ParamSetDO opPrepayPrinter = this.dealData(blPrinterSetDTO.getBl_oep_prepay_printer(), tmplMap.get(BlParamConst.BLINC0005), oldParamSetMap.get(BlParamConst.BLINC0005), pcId);
		if(opPrepayPrinter != null)
			saveList.add(opPrepayPrinter);
		
		//住院预交金打印机
		ParamSetDO ipPrepayPrinter = this.dealData(blPrinterSetDTO.getBl_ip_prepay_printer(), tmplMap.get(BlParamConst.BLINC0004), oldParamSetMap.get(BlParamConst.BLINC0004), pcId);
		if(ipPrepayPrinter != null)
			saveList.add(ipPrepayPrinter);
		
		//门诊发票打印机
		ParamSetDO opIncPrinter = this.dealData(blPrinterSetDTO.getBl_oep_invoice_printer(), tmplMap.get(BlParamConst.BLINC0007), oldParamSetMap.get(BlParamConst.BLINC0007), pcId);
		if(opIncPrinter != null)
			saveList.add(opIncPrinter);
		
		//门诊发票明细打印机
		ParamSetDO opDetailPrinter = this.dealData(blPrinterSetDTO.getBl_oep_itmdetail_printer(), tmplMap.get(BlParamConst.BLINC0006), oldParamSetMap.get(BlParamConst.BLINC0006), pcId);
		if(opDetailPrinter != null)
			saveList.add(opDetailPrinter);
		
		//住院发票打印机
		ParamSetDO ipIncPrinter = this.dealData(blPrinterSetDTO.getBl_ip_invoice_printer(), tmplMap.get(BlParamConst.BLINC0002), oldParamSetMap.get(BlParamConst.BLINC0002), pcId);
		if(ipIncPrinter != null)
			saveList.add(ipIncPrinter);
		
		//住院明细打印机
		ParamSetDO ipDetailPrinter = this.dealData(blPrinterSetDTO.getBl_ip_itmdetail_printer(), tmplMap.get(BlParamConst.BLINC0003), oldParamSetMap.get(BlParamConst.BLINC0003), pcId);
		if(ipDetailPrinter != null)
			saveList.add(ipDetailPrinter);
		
		//结账打印机
		ParamSetDO ccPrinter = this.dealData(blPrinterSetDTO.getBl_cc_priner(), tmplMap.get(BlParamConst.BLINC0001), oldParamSetMap.get(BlParamConst.BLINC0001), pcId);
		if(ccPrinter != null)
			saveList.add(ccPrinter);
		
		//报表打印机
		ParamSetDO reportPrinter = this.dealData(blPrinterSetDTO.getBl_rpt_printer(), tmplMap.get(BlParamConst.BLINC0008), oldParamSetMap.get(BlParamConst.BLINC0008), pcId);
		if(reportPrinter != null)
			saveList.add(reportPrinter);
		
		//患者条码打印机
		ParamSetDO barcodePrinter = this.dealData(blPrinterSetDTO.getBl_patbar_printer(), tmplMap.get("barPrintConfig"), oldParamSetMap.get("barPrintConfig"), pcId);
		if(barcodePrinter != null)
			saveList.add(barcodePrinter);
		
		//患者制卡打印机
		ParamSetDO cardPrinter = this.dealData(blPrinterSetDTO.getBl_patcard_printer(), tmplMap.get("PIPAT0090"), oldParamSetMap.get("PIPAT0090"), pcId);
		if(cardPrinter != null)
			saveList.add(cardPrinter);
		
		//一日费用清单打印机
		ParamSetDO oneDayCostListPrinter = this.dealData(blPrinterSetDTO.getBl_onedaycostlist_printer(), tmplMap.get(BlParamConst.BLINC0039), oldParamSetMap.get(BlParamConst.BLINC0039), pcId);
		if(oneDayCostListPrinter != null)
			saveList.add(oneDayCostListPrinter);
		
		//住院费用清单打印机
		ParamSetDO ipCostListPrinter = this.dealData(blPrinterSetDTO.getBl_ipcostlist_printer(), tmplMap.get(BlParamConst.BLINC0040), oldParamSetMap.get(BlParamConst.BLINC0040), pcId);
		if(ipCostListPrinter != null)
			saveList.add(ipCostListPrinter);
		
		if(saveList.size() > 0){
			setCudService.save(saveList.toArray(new ParamSetDO[0]));
		}
	}
	
	/**
	 * 处理数据
	 * @param value
	 * @param tmplDO
	 * @param setDO
	 * @param instance
	 * @return
	 * @throws BizException
	 */
	private ParamSetDO dealData(String value, ParamTmplSetDO tmplDO, ParamSetDO setDO, String instance) throws BizException {

		if(StringUtil.isEmpty(value)){
			if(setDO != null){
				setDO.setStatus(DOStatus.DELETED);
			}
			return setDO;
		}
		
		if(tmplDO == null)
			return null;
		
		if(setDO == null){
			ParamSetDO paramSetDO = new ParamSetDO();
			paramSetDO.setId_paramtmplset(tmplDO.getId_paramtmplset());
			paramSetDO.setValue(value);
			paramSetDO.setId_org(Context.get().getOrgId());
			paramSetDO.setParamcode(tmplDO.getParamcode());
			paramSetDO.setParamname(tmplDO.getParamname());
			paramSetDO.setIseditable(FBoolean.TRUE);
			paramSetDO.setIsctldownlevel(FBoolean.FALSE);
			paramSetDO.setDatafromtype(DataFromTypeEnum.CURLEVEL);
			paramSetDO.setId_instance(instance);
			paramSetDO.setStatus(DOStatus.NEW);
			return paramSetDO;
		}
		
		setDO.setValue(value);
		setDO.setStatus(DOStatus.UPDATED);
		return setDO;
	}
}
