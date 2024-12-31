package iih.ei.std.i.v1;

import iih.ei.std.d.v1.ci.apbt.d.EmsApbtEntDTO;
import iih.ei.std.d.v1.ci.apbu.d.EmsApbuEntDTO;
import iih.ei.std.d.v1.ci.cancel.d.EntWsCancelDTO;
import iih.ei.std.d.v1.ci.diag.d.EmsWsDTO;
import iih.ei.std.d.v1.ci.drugs.d.EntWsDrugsDTO;
import iih.ei.std.d.v1.ci.ent.d.ResultDTO;
import iih.ei.std.d.v1.ci.lis.d.EntLisDTO;
import iih.ei.std.d.v1.ci.opr.d.OprInfoParamDTO;
import iih.ei.std.d.v1.ci.opr.d.OprInfoResultDTO;
import iih.ei.std.d.v1.ci.order.ip.d.IpOrderParamDTO;
import iih.ei.std.d.v1.ci.order.ip.d.IpOrderResultDTO;
import iih.ei.std.d.v1.ci.order.op.d.OpOrderParamDTO;
import iih.ei.std.d.v1.ci.order.op.d.OpOrderResultDTO;
import iih.ei.std.d.v1.ci.ris.d.EntWsRisDTO;
import iih.ei.std.d.v1.ci.treat.d.EntWsTreatDTO;
import xap.mw.core.data.BizException;

/**
 * @code IIH临床域标准对外接口
 */
public interface ICiApiService {
	/*************** 门诊回写数据部分 ***************/
	/**
	 * 门诊回写诊疗信息
	 */
	ResultDTO opEmsTreatSave(EntWsTreatDTO entwsdto) throws BizException;
	
	/**
	 * 门诊回写检验信息
	 */
	ResultDTO opEmsLisSave(EntLisDTO entwsdto) throws BizException;
	
	/**
	 * 门诊回写诊断信息
	 */
	ResultDTO opDiagSave(EmsWsDTO entwsdto) throws BizException;

	/**
	 * 门诊回写西药信息
	 */
	ResultDTO opEmsDrugSave(EntWsDrugsDTO entwsdto) throws BizException;
	
	/**
	 * 门诊回写检查信息
	 */
	ResultDTO opEmsRisSave(EntWsRisDTO entwsdto) throws BizException;
		
	/**
	 * 门诊回写备血信息
	 */
	ResultDTO opEmsBtSave(EmsApbtEntDTO entwsdto) throws BizException;
	
	/**
	 * 门诊回写用血信息
	 */
	ResultDTO opEmsBuSave(EmsApbuEntDTO entwsdto) throws BizException;
	

	
	/**
	 * 第三方医嘱作废
	 */
	ResultDTO emsOrdCance(EntWsCancelDTO entwsdto) throws BizException;
	/*************** 查询类 ***************/
	/**
	 * 医嘱查询（门诊模式）
	 * @param param 入参
	 * @return
	 * @throws BizException
	 */
	public OpOrderResultDTO GetOpPatientOrders(OpOrderParamDTO param) throws BizException; 
	
	/*****************************住院回写数据部分**************************/
	/**
	 * 住院回写备血信息
	 */
	ResultDTO ipEmsBtSave(EmsApbtEntDTO entwsdto) throws BizException;
	
	/**
	 * 住院回写用血信息
	 */
	ResultDTO ipEmsBuSave(EmsApbuEntDTO entwsdto) throws BizException;
	
	/**
	 * 医嘱查询（住院模式）
	 * @param param 入参
	 * @return
	 * @throws BizException
	 */
	public IpOrderResultDTO GetIpPatientOrders(IpOrderParamDTO param) throws BizException;
	/**
	 * 手术查询（门诊+住院）
	 * @param param 入参
	 * @return
	 * @throws BizException
	 */
	public OprInfoResultDTO GetOprInfo(OprInfoParamDTO param) throws BizException;
}
