package iih.ci.ord.s.external.gvchina;

import iih.ci.ord.i.external.gvchina.ICiOrdGvChinaRService;
import iih.ci.ord.i.external.gvchina.meta.GvDrugOrderRstInfo;
import iih.ci.ord.i.external.gvchina.meta.GvEnDiagRstInfo;
import iih.ci.ord.i.external.gvchina.meta.GvLisOrderRstInfo;
import iih.ci.ord.i.external.gvchina.meta.GvRisOrderRstInfo;
import iih.ci.ord.i.external.gvchina.meta.GvSurgeryOrderRstInfo;
import iih.ci.ord.i.external.gvchina.meta.GvTreatOrderRstInfo;
import iih.ci.ord.s.external.gvchina.bp.GetPatEnDiagInfos;
import iih.ci.ord.s.external.gvchina.bp.GetPatOrderDrugInfos;
import iih.ci.ord.s.external.gvchina.bp.GetPatOrderLisInfos;
import iih.ci.ord.s.external.gvchina.bp.GetPatOrderRisInfos;
import iih.ci.ord.s.external.gvchina.bp.GetPatOrderSurgeryInfos;
import iih.ci.ord.s.external.gvchina.bp.GetPatOrderTreatInfos;
import xap.mw.core.data.BizException;

/**
 * 提供给【高视远望接口】实现业务逻辑
 * @author wangqingzhu
 *
 */
public class CiOrdGvChinaRServiceImpl implements ICiOrdGvChinaRService {

	@Override
	public GvDrugOrderRstInfo[] getPatOrderDrugInfos(String code_en,String code_dept) throws BizException {
		// TODO Auto-generated method stub
		return new GetPatOrderDrugInfos().exec(code_en, code_dept);
	}

	@Override
	public GvRisOrderRstInfo[] getPatOrderRisInfos(String code_en,String code_dept) throws BizException {
		// TODO Auto-generated method stub
		return new GetPatOrderRisInfos().exec(code_en, code_dept);
	}

	@Override
	public GvLisOrderRstInfo[] getPatOrderLisInfos(String code_en,String code_dept) throws BizException {
		// TODO Auto-generated method stub
		return new GetPatOrderLisInfos().exec(code_en, code_dept);
	}

	@Override
	public GvSurgeryOrderRstInfo[] getPatOrderSurgeryInfos(String code_en,String code_dept) throws BizException {
		// TODO Auto-generated method stub
		return new GetPatOrderSurgeryInfos().exec(code_en, code_dept);
	}

	@Override
	public GvTreatOrderRstInfo[] getPatOrderTreatInfos(String code_en,String code_dept)  throws BizException{
		// TODO Auto-generated method stub
		return new GetPatOrderTreatInfos().exec(code_en, code_dept);
	}

	@Override
	public GvEnDiagRstInfo[] getPatEnDiagInfos(String code_en,String code_dept) throws BizException {
		// TODO Auto-generated method stub
		return new GetPatEnDiagInfos().exec(code_en, code_dept);
	}

}
