package iih.bl.cg.blprinterset;

import java.util.List;

import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bl.params.BlParams;
import iih.bl.st.dto.d.BlPrinterSetDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;

public class QryPrinterSetInfoBp {
	
	/**
	 * 查询获得所设置的打印机名称
	 * @param printerType
	 * @return
	 * @throws BizException
	 */
	public BlPrinterSetDTO execQryPrinterSetInfo(String printerType) throws BizException
	{
		BlPrinterSetDTO  blPrinterSetDTO = this.getBlPrinterSetDTO();
		return blPrinterSetDTO;
	}
	
	/**
	 *  查询获得客户机打印机设置
	 * @return 打印机设置DTO
	 * @throws BizException
	 */
	private BlPrinterSetDTO getBlPrinterSetDTO()  throws BizException
	{
		String id_pc="";
		String clientHost = xap.mw.core.data.Context.get().getClientHost();//活动pcid
		BlPrinterSetDTO blPrinterSetDTO=new BlPrinterSetDTO();
		DAFacade dafacade=new DAFacade();
		@SuppressWarnings("unchecked")
		List<WorkStationPcDO> workStationPcDOList = (List<WorkStationPcDO>)dafacade.findByCond(WorkStationPcDO.class, " pcid='"+clientHost+"'",new String[]{"id_pc"}); 
		if(workStationPcDOList == null || workStationPcDOList.size() == 0) return null;
		
			id_pc=workStationPcDOList.toArray(new WorkStationPcDO[0])[0].getId_pc();
			blPrinterSetDTO.setBl_ip_invoice_printer(BlParams.getIpIncPrinter());//住院发票
			blPrinterSetDTO.setBl_ip_itmdetail_printer(BlParams.getIpIncItmPrinter()); //住院发票明细
			blPrinterSetDTO.setBl_oep_invoice_printer(BlParams.getOepIncPrinter());//门诊发票
			blPrinterSetDTO.setBl_oep_reg_invoice_printer(BlParams.getOepRegPrinter());//门诊挂号发票
		    blPrinterSetDTO.setBl_oep_itmdetail_printer(BlParams.getOepItmIncPrinter());//门诊发票明细
			blPrinterSetDTO.setBl_rpt_printer(BlParams.getReportPrinter());//报表
			blPrinterSetDTO.setBl_cc_priner(BlParams.getCcIncPrinter());//结账
			blPrinterSetDTO.setBl_ip_prepay_printer(BlParams.getIpPrepayIncPrinter());//住院预交金
			blPrinterSetDTO.setBl_oep_prepay_printer(BlParams.getOepPrepayIncPrinter());//门诊预交金
			blPrinterSetDTO.setBl_st_ip_windowno(BlParams.BLSTIP0003());  //住院结算窗口号
			blPrinterSetDTO.setBl_st_oep_windowno(BlParams.BLSTOEP0005());//闷着结算窗口号
			
			blPrinterSetDTO.setBl_hp_oep_specialill_out_dir(BlParams.getHpOepSpeillOutDir());//
			blPrinterSetDTO.setBl_hp_oep_specialill_in_dir(BlParams.getHpOepSpeillInDir());//
			blPrinterSetDTO.setBl_hp_oep_fee_out_dir(BlParams.getHpOepFeeOutDir());//
			blPrinterSetDTO.setBl_hp_reginfo_out_dir(BlParams.getHpOepReginfoOutDir());//
			
		    return blPrinterSetDTO;
	}
	

}
