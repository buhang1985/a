package iih.ci.ord.s.bp.assi.gj.impl.cimes.op;


import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.assi.gj.impl.cimes.base.OpBaseCopyCalCiEmsProperty;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 设置检查属性
 * @author HUMS
 *
 */
public class OpCopyRisPropertyImpl extends OpBaseCopyCalCiEmsProperty{
	
	private IMedSrvRisDORService imedSrvRisDORService;
	
	public OpCopyRisPropertyImpl(){
		imedSrvRisDORService = (IMedSrvRisDORService) ServiceFinder.find(IMedSrvRisDORService.class);
	}
	@Override
	protected void afterCalcuateCustomProperty(CiEmsDTO ciEms) throws BizException {
		
		super.afterCalcuateCustomProperty(ciEms);
		this.setRisProperty(ciEms);
	}
	
	private void setRisProperty(CiEmsDTO ciEms) throws BizException{
		
		if(FBoolean.TRUE.equals(ciEms.getFg_set())){
			return ;
		}
		
		// 设置床旁执行状态，当诊疗项目中勾选检查项目的是否床旁执行时，ciEms.setFg_mp_bed = true，CopyCommonCiEmsServiceImpl中默认设置为false
		MedSrvRisDO[] medSrvRis = imedSrvRisDORService.findByAttrValString(MedSrvRisDO.ID_SRV, ciEms.getId_srv());
		if(FBoolean.TRUE.equals(medSrvRis[0].getIf_mp_bed())){
			ciEms.setFg_mp_bed(FBoolean.TRUE);
		}
		
		
	}
}
