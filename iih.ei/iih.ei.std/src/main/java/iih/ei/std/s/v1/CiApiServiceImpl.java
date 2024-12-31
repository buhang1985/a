package iih.ei.std.s.v1;

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
import iih.ei.std.s.v1.bp.ci.thirdws.ip.IpApbtSaveBP;
import iih.ei.std.s.v1.bp.ci.thirdws.ip.IpApbuSaveBP;
import iih.ei.std.d.v1.ci.order.ip.d.IpOrderResultDTO;
import iih.ei.std.d.v1.ci.order.op.d.OpOrderParamDTO;
import iih.ei.std.d.v1.ci.order.op.d.OpOrderResultDTO;
import iih.ei.std.d.v1.ci.ris.d.EntWsRisDTO;
import iih.ei.std.d.v1.ci.treat.d.EntWsTreatDTO;
import iih.ei.std.i.v1.ICiApiService;
import iih.ei.std.s.v1.bp.ci.thirdws.op.apbt.OpApbtSaveBP;
import iih.ei.std.s.v1.bp.ci.thirdws.op.apbu.OpApbuSaveBP;
import iih.ei.std.s.v1.bp.ci.thirdws.op.diag.OpDiagSaveBP;
import iih.ei.std.s.v1.bp.ci.thirdws.op.drug.OpDrugSaveBP;
import iih.ei.std.s.v1.bp.ci.thirdws.op.lis.OpLisSaveBP;
import iih.ei.std.s.v1.bp.ci.thirdws.op.ris.OpRisSaveBP;
import iih.ei.std.s.v1.bp.ci.thirdws.op.treat.OpTreatSaveBP;
import iih.ei.std.s.v1.bp.ci.thirdws.operation.EmsOrdCancelBP;
import iih.ei.std.s.v1.bp.ci.thirdws.query.IpOrderInfoBP;
import iih.ei.std.s.v1.bp.ci.thirdws.query.OpOrderInfoBP;
import iih.ei.std.s.v1.bp.ci.thirdws.query.OprInfoBP;
import xap.mw.core.data.BizException;

public class CiApiServiceImpl implements ICiApiService {

	/**
	 * 门诊治疗回传
	 */
	public ResultDTO opEmsTreatSave(EntWsTreatDTO entwsdto) throws BizException {
		return new OpTreatSaveBP().exec(entwsdto);
	}

	/**
	 * 门诊西药回传
	 */
	public ResultDTO opEmsDrugSave(EntWsDrugsDTO entwsdto) throws BizException {
		return new OpDrugSaveBP().exec(entwsdto);
	}

	/**
	 * 门诊诊断回传
	 */
	public ResultDTO opDiagSave(EmsWsDTO entwsdto) throws BizException {
		return new OpDiagSaveBP().exec(entwsdto);
	}

	/**
	 * 门诊检验回传
	 */
	public ResultDTO opEmsLisSave(EntLisDTO entwsdto) throws BizException {
		return new OpLisSaveBP().exec(entwsdto);
	}

	/**
	 * 门诊检查回传
	 */
	public ResultDTO opEmsRisSave(EntWsRisDTO entwsdto) throws BizException {
		return new OpRisSaveBP().exec(entwsdto);
	}

	/**
	 * 门诊备血回传
	 */
	public ResultDTO opEmsBtSave(EmsApbtEntDTO entwsdto) throws BizException {
		return new OpApbtSaveBP().exec(entwsdto);
	}

	/**
	 * 门诊回写用血信息
	 */
	public ResultDTO opEmsBuSave(EmsApbuEntDTO entwsdto) throws BizException {
		return new OpApbuSaveBP().exec(entwsdto);
	}
	
	/**
	 * 医嘱作废接口
	 */
	public ResultDTO EmsOrdCance(EntWsCancelDTO entwsdto) throws BizException {
		return new EmsOrdCancelBP().exec(entwsdto);
	}
	/*************** 住院回写数据部分 ***************/
	/**
	 * 住院备血回传
	 */
	public ResultDTO ipEmsBtSave(EmsApbtEntDTO entwsdto) throws BizException {
		return new IpApbtSaveBP().exec(entwsdto);
	}

	/**
	 * 住院用血回传
	 */
	public ResultDTO ipEmsBuSave(EmsApbuEntDTO entwsdto) throws BizException {
		return new IpApbuSaveBP().exec(entwsdto);
	}
	/**
	 * 医嘱作废接口
	 */
	public ResultDTO emsOrdCance(EntWsCancelDTO entwsdto) throws BizException {
		return new EmsOrdCancelBP().exec(entwsdto);
	}
	
	
	/*************** 查询部分 ***************/
	/**
	 * 医嘱查询（门诊模式）接口
	 */
	public OpOrderResultDTO GetOpPatientOrders(OpOrderParamDTO param) throws BizException {
		
		return new OpOrderInfoBP().exec(param);
	}

	/**
	 * 医嘱查询（住院模式）接口
	 */
	public IpOrderResultDTO GetIpPatientOrders(IpOrderParamDTO param) throws BizException {
		
		return new IpOrderInfoBP().exec(param);
	}

	/**
	 * 手术查询接口
	 */
	public OprInfoResultDTO GetOprInfo(OprInfoParamDTO param) throws BizException {
		
		return new OprInfoBP().exec(param);
	}
}
