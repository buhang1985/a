package iih.en.pv.s.bp.ip.ws;

import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceHeadTailDTO;
import iih.bl.inc.i.IBlIncOutQryService;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.appoint.result.InvoiceBean;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.i.IScAptOpDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 获取发票信息
 * @author fanlq
 *
 */
public class GetInvoiceInfoBP {
	/***
	 * 获取发票信息
	 * @param id_apt
	 * @param code_pat
	 * @return
	 * @throws BizException
	 */
	public InvoiceBean exec(String id_apt) throws BizException{
		IScAptOpDORService aptOpRService = ServiceFinder.find(IScAptOpDORService.class);
		ScAptOpDO[] aptOpDOs = aptOpRService.find("id_apt = '"+id_apt+"'", null, FBoolean.TRUE);
		String id_ent = null;
		if(aptOpDOs != null && aptOpDOs.length > 0){
			id_ent = aptOpDOs[0].getId_en();
		}
		if(EnValidator.isEmpty(id_ent)) return new InvoiceBean();
		IBlIncOutQryService service = ServiceFinder.find(IBlIncOutQryService.class);
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = service.getOpIncInfoByEntId(id_ent);
		if(blIncItmVsTypeDTOs != null && blIncItmVsTypeDTOs.length > 0){
			InvoiceBean bean = getInvoiceBean(blIncItmVsTypeDTOs[0]);
			return bean;
		}
		return new InvoiceBean();
	}
	/***
	 * 重新组装发票信息
	 * @param blIncItmVsTypeDTO
	 * @return
	 */
	private InvoiceBean getInvoiceBean(BlIncItmVsTypeDTO blIncItmVsTypeDTO){
		InvoiceBean bean = new InvoiceBean();
		BlInvoiceHeadTailDTO taildto = blIncItmVsTypeDTO.getBlInvoiceHeadTailDTO();
		if(taildto != null){
			bean.setPatCode(taildto.getPatcode());
			bean.setAmt_ratio(taildto.getAmt_ratio() == null ? null:taildto.getAmt_ratio().toString());
			bean.setPay_tp(taildto.getPay_tp());
			bean.setCode_st(taildto.getCode_st());
			bean.setPayee_emp_name(taildto.getPayee_emp_name());
			bean.setAmt_grzhzf(taildto.getAmt_grzhzf() == null ? null:taildto.getAmt_grzhzf().toString());
			bean.setEu_sttp(taildto.getEu_sttp());
			bean.setInc_emp_name(taildto.getInc_emp_name());
			bean.setEu_direct(taildto.getEu_direct() == null ? null:taildto.getEu_direct().toString());
			bean.setDatetime_print(taildto.getDatetime_print() == null ? null:taildto.getDatetime_print().toString());
			bean.setSex(taildto.getSex());
			bean.setAmt(taildto.getAmt().toString());
			bean.setDep_name(taildto.getDep_name());
			bean.setPripat_name(taildto.getPripat_name());
			bean.setHospital_type(taildto.getHospital_type());
			bean.setIncno(taildto.getIncno());
			bean.setAmt_free(taildto.getAmt_free() == null ? null:taildto.getAmt_free().toString());
			bean.setFg_hp(taildto.getFg_hp() == null ? null:taildto.getFg_hp().toString());
			bean.setAmt_hp(taildto.getAmt_hp() == null ? null:taildto.getAmt_hp().toString());
			bean.setPatname(taildto.getPatname());
			bean.setId_stoep(taildto.getId_stoep());
			bean.setId_pat(taildto.getId_pat());
			bean.setDatetime_st(taildto.getDatetime_st() == null ? null:taildto.getDatetime_st().toString());
			bean.setAmt_std(taildto.getAmt_std() == null ? null:taildto.getAmt_std().toString());
			bean.setAmt_pat(taildto.getAmt_pat() == null ? null:taildto.getAmt_pat().toString());
		}
		return bean;
	}
}
