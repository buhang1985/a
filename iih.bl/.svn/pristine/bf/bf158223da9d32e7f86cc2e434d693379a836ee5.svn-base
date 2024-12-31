package iih.bl.hp.s.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.hp.dto.d.AccountCheckDTO;
import iih.bl.hp.i.IBlHpQryService;
import iih.bl.hp.rural.dto.d.RuralPersonInfoDTO;
import iih.bl.inc.dto.d.BlIncissOepDTO;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.en.pv.enhpreferral.d.EnHpReferralDO;
import iih.en.pv.enhpreferral.i.IEnhpreferralRService;
import iih.mi.biz.dto.d.InpInvoiceInParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 
* @author xy.zhou 
* @date 2018年4月11日
* @Description 拼装发票登记入参
 */
public class GetUploadInpInvoiceBp {
	/**
	 * 
	* @Description:拼装发票登记入参
	* @param @param strIdEmpIss
	* @param @param entId
	* @param @return
	* @param @throws BizException    
	* @return InpInvoiceInParamDTO    
	* @throws
	 */
	public InpInvoiceInParamDTO[] exec(String strIdEmpIss,String entId) throws BizException {
		
		BlIncissOepDTO blIncissOepDTO = getBlIncissOepDTO(strIdEmpIss);
		IBlHpQryService iBlHpQryService=ServiceFinder.find(IBlHpQryService.class);
		RuralPersonInfoDTO rDto=iBlHpQryService.getRuralPersonInfo(entId);
		InpInvoiceInParamDTO[] inParamDTOs = getBlCgIpDOs(entId);
		for (InpInvoiceInParamDTO inpInvoiceInParamDTO : inParamDTOs) {
			inpInvoiceInParamDTO.setInvoiceno(blIncissOepDTO.getIncno_cur());//发票号
			if (rDto!=null) {
				inpInvoiceInParamDTO.setInpno(rDto.getHp_serialno());//住院流水号
			}
			inpInvoiceInParamDTO.setHpfeetp_code("09");//医保费用编码
		}
		return inParamDTOs;
	}
	/**
	 * 
	* @Description: 获取发票领用信息
	* @param @param strIdEmpIss
	* @param @return
	* @param @throws BizException    
	* @return BlIncissOepDTO    
	* @throws
	 */
	private BlIncissOepDTO getBlIncissOepDTO(String strIdEmpIss) throws BizException{
		IBLInvoiceService service = ServiceFinder.find(IBLInvoiceService.class);
		return service.getIncissOepDtoByEmp(strIdEmpIss,IBdPpCodeTypeConst.SD_INHOS_INVOICE);
	}
	/**
	 * 
	* @Description: 通过住院记账获取账单项信息
	* @param @param entId
	* @param @return
	* @param @throws BizException    
	* @return InpInvoiceInParamDTO[]    
	* @throws
	 */
	private InpInvoiceInParamDTO [] getBlCgIpDOs(String entId)throws BizException{
		StringBuilder sqBuilder=new StringBuilder();
		sqBuilder.append("select name_inccaitm feetp_name, "
				+ "code_inccaitm hisfeetp_code, "
				+ "sum(amt_ratio*eu_direct) amt  "
				+ "from bl_cg_ip where id_ent=? and fg_st ='N' "
				+ "group by code_inccaitm,name_inccaitm");
		SqlParam param=new SqlParam();
		param.addParam(entId);
		
		@SuppressWarnings("unchecked")
	    List<InpInvoiceInParamDTO> list = (List<InpInvoiceInParamDTO>) new DAFacade().execQuery(sqBuilder.toString(), param, new BeanListHandler(InpInvoiceInParamDTO.class));
		return  list.toArray(new InpInvoiceInParamDTO[0]);
	}
}
