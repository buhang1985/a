package iih.ci.ord.s.bp;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
/*
 * 医嘱停止或作废时，执行域进行退药处理逻辑操作BP
 */
public class CiOrMpRtnDrug4StopCanc2BP {
	/**
	 * 医嘱停止或作废时，执行域进行退药处理
	 * @param m
	 * @throws BizException
	 */
	public void execCanc(FMap m) throws BizException{
		if(m==null||m.size()==0)return;
		CiOrdAppUtils.getMpDrugOutService().returnMedWhenCancelOrder2(m);
	}
	
	/**
	 * 医嘱停止或作废时，执行域进行退药处理
	 * @param m
	 * @throws BizException
	 */
	public void execStop(FMap m) throws BizException{
		if(m==null||m.size()==0)return;
		CiOrdAppUtils.getMpDrugOutService().returnMedWhenStopOrder2(m);
	}
}
