package iih.ci.ord.s.external.thirdws;

import iih.ci.ord.i.external.thirdws.IOrdThirdWsService;
import iih.ci.ord.s.external.thirdws.bp.ThirdwsAppUtils;
import iih.ci.ord.s.external.thirdws.diag.EmsDiagManagerBP;
import iih.ci.ord.s.external.thirdws.ip.apbt.IpEmsApbtManageBP;
import iih.ci.ord.s.external.thirdws.ip.apbu.IpEmsApbuManageBP;
import iih.ci.ord.s.external.thirdws.op.apbt.EmsApbtManageBP;
import iih.ci.ord.s.external.thirdws.op.apbu.EmsApbuManageBP;
import iih.ci.ord.s.external.thirdws.op.drugs.EmsDrugManageBP;
import iih.ci.ord.s.external.thirdws.op.lis.EmsLisManageBP;
import iih.ci.ord.s.external.thirdws.op.opr.EmsOprManageBP;
import iih.ci.ord.s.external.thirdws.op.ris.EmsRisManagerBP;
import iih.ci.ord.s.external.thirdws.op.treat.EmsTreatManageBP;
import iih.ci.ord.s.external.thirdws.operation.CancelOrdManageBp;
import iih.ci.ord.s.external.thirdws.operation.EmsBlStatusManagerBp;
import iih.ci.ord.s.external.thirdws.utils.LogUtils;
import iih.ci.ord.s.external.thirdws.utils.RstMsgBP;
import xap.mw.core.data.BizException;


/**
 * 临床作为数据消费方对外接口
 * @author zhangwq
 *
 */
public class OrdThirdWsServiceImpl implements IOrdThirdWsService{

	@Override
	public String opEmsDrugSave(String xmlparam){
		EmsDrugManageBP bp = new EmsDrugManageBP();
		return bp.save(xmlparam);
	}

	@Override
	public String opEmsLisSave(String xmlparam){
		EmsLisManageBP bp = new EmsLisManageBP();
		return	bp.save(xmlparam);
	}

	@Override
	public String opEmsRisSave(String xmlparam) {
		EmsRisManagerBP bp = new EmsRisManagerBP();
		return	bp.save(xmlparam);
	}

	@Override
	public String opEmsOprSave(String xmlparam) {
		EmsOprManageBP bp = new EmsOprManageBP();
		return bp.save(xmlparam);
	}

	@Override
	public String opEmsBtSave(String xmlparam) {
		//备血
		EmsApbtManageBP bp = new EmsApbtManageBP();
		return bp.save(xmlparam);
	}

	@Override
	public String opEmsBuSave(String xmlparam){
		//用血
		EmsApbuManageBP bp= new EmsApbuManageBP();
		return bp.save(xmlparam);
	}

	@Override
	public String opEmsTreatSave(String xmlparam){
		EmsTreatManageBP bp = new EmsTreatManageBP();
		return bp.save(xmlparam);
	}

	@Override
	public String opDiagSave(String xmlparam){
		EmsDiagManagerBP bp = new EmsDiagManagerBP();
		return bp.save(xmlparam);
	}

	@Override
	public String opCancelOrd(String xmlparam){
		CancelOrdManageBp bp= new CancelOrdManageBp();
		return bp.exec(xmlparam);
	}

	@Override
	public String ordBlStatus(String xmlparam){
		EmsBlStatusManagerBp bp = new EmsBlStatusManagerBp();
		return bp.save(xmlparam);
	}

	@Override
	public String ipEmsBtSave(String xmlparam) {
		// TODO Auto-generated method stub
		IpEmsApbtManageBP bp=new IpEmsApbtManageBP();
		return bp.save(xmlparam);
	}
	
	@Override
	public String ipEmsBuSave(String xmlparam){
		//用血
		IpEmsApbuManageBP bp= new IpEmsApbuManageBP();
		return bp.save(xmlparam);
	}

	@Override
	public String getCodeOr(String xmlparam) {
		// TODO Auto-generated method stub
		ThirdwsAppUtils utils=new ThirdwsAppUtils();
		String code=null;
		LogUtils.Logger("外部调用生成医嘱编码：:"+xmlparam);
		try {
			code=utils.getOrdCode();
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtils.Logger(e.getMessage(), e);
			return RstMsgBP.getRstMsg("1", e.getMessage());
		}
		return utils.getRstMsgCodeMsg(code);
	}


}
