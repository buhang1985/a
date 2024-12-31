package iih.ei.std.s.v1.bp.en;

import com.mysql.jdbc.StringUtils;

import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceHeadTailDTO;
import iih.bl.inc.i.IBlIncOutQryService;
import iih.ei.std.d.v1.en.getinvoiceinfo.d.GetInvoiceInfoParamDTO;
import iih.ei.std.d.v1.en.getinvoiceinfo.d.GetInvoiceInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.sc.apt.scapt.d.ScAptOpDO;
import iih.sc.apt.scapt.i.IScAptOpDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 获取发票信息
 * @author fanlq
 * @date: 2019年10月12日 下午4:21:04
 */
public class GetInvoiceInfoBP  extends IIHServiceBaseBP<GetInvoiceInfoParamDTO, GetInvoiceInfoResultDTO> {

	@Override
	protected void checkParam(GetInvoiceInfoParamDTO param) throws BizException {
		if(StringUtils.isNullOrEmpty(param.getId_apt()))
			throw new BizException("就诊id不能为空！");
	}

	@Override
	protected GetInvoiceInfoResultDTO process(GetInvoiceInfoParamDTO param) throws BizException {
		//1.获取发票信息
		BlIncItmVsTypeDTO blIncItmVsTypeDTO = getIncInfoByAptId(param.getId_apt());
		//2.组装返回结果
		GetInvoiceInfoResultDTO result = this.wrapResult(blIncItmVsTypeDTO);
		return result;
	}

	/***
	 * 获取发票信息
	 * @param id_apt
	 * @param code_pat
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO getIncInfoByAptId(String id_apt) throws BizException{
		IScAptOpDORService aptOpRService = ServiceFinder.find(IScAptOpDORService.class);
		ScAptOpDO[] aptOpDOs = aptOpRService.find("id_apt = '"+id_apt+"'", null, FBoolean.TRUE);
		String id_ent = null;
		if(aptOpDOs != null && aptOpDOs.length > 0){
			id_ent = aptOpDOs[0].getId_en();
		}
		if(StringUtils.isNullOrEmpty(id_ent)) 
			throw new BizException("预约未缴费，没有发票信息！");
		IBlIncOutQryService service = ServiceFinder.find(IBlIncOutQryService.class);
		BlIncItmVsTypeDTO[] blIncItmVsTypeDTOs = service.getOpIncInfoByEntId(id_ent);
		if(blIncItmVsTypeDTOs != null && blIncItmVsTypeDTOs.length > 0){
			return blIncItmVsTypeDTOs[0];
		}else{
			throw new BizException("未查询到发票信息！就诊id："+id_ent);
		}
	}
	/***
	 * 重新组装发票信息
	 * @param blIncItmVsTypeDTO
	 * @return
	 */
	private GetInvoiceInfoResultDTO wrapResult(BlIncItmVsTypeDTO blIncItmVsTypeDTO){
		GetInvoiceInfoResultDTO bean = new GetInvoiceInfoResultDTO();
		BlInvoiceHeadTailDTO taildto = blIncItmVsTypeDTO.getBlInvoiceHeadTailDTO();
		if(taildto != null){
			bean.setCode_pat(taildto.getPatcode());
			bean.setAmt_ratio(taildto.getAmt_ratio() == null ? null:taildto.getAmt_ratio().toString());
			bean.setCode_paytp(taildto.getPay_tp());
			bean.setCode_st(taildto.getCode_st());
			bean.setName_emp_payee(taildto.getPayee_emp_name());
			bean.setAmt_grzhzf(taildto.getAmt_grzhzf() == null ? null:taildto.getAmt_grzhzf().toString());
			bean.setEu_sttp(taildto.getEu_sttp());
			bean.setName_emp_inc(taildto.getInc_emp_name());
			bean.setEu_direct(taildto.getEu_direct() == null ? null:taildto.getEu_direct().toString());
			bean.setDt_paint(taildto.getDatetime_print() == null ? null:taildto.getDatetime_print().toString());
			bean.setName_sex(taildto.getSex());
			bean.setAmt(taildto.getAmt().toString());
			bean.setName_dep(taildto.getDep_name());
			bean.setName_pripat(taildto.getPripat_name());
			bean.setHospital_type(taildto.getHospital_type());
			bean.setIncno(taildto.getIncno());
			bean.setAmt_free(taildto.getAmt_free() == null ? null:taildto.getAmt_free().toString());
			bean.setFg_hp(taildto.getFg_hp() == null ? null:taildto.getFg_hp().toString());
			bean.setAmt_hp(taildto.getAmt_hp() == null ? null:taildto.getAmt_hp().toString());
			bean.setName_pat(taildto.getPatname());
			bean.setId_stoep(taildto.getId_stoep());
			bean.setId_pat(taildto.getId_pat());
			bean.setDt_st(taildto.getDatetime_st() == null ? null:taildto.getDatetime_st().toString());
			bean.setAmt_std(taildto.getAmt_std() == null ? null:taildto.getAmt_std().toString());
			bean.setAmt_pat(taildto.getAmt_pat() == null ? null:taildto.getAmt_pat().toString());
		}
		return bean;
	}
}
