package iih.ci.ord.nursorder;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.PharmVerifyStatusEnum;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.bp.ems.save.ip.CiOrDtLastBlCal4OpenBP;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.utils.CiOrFgMpInDefaltUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

public class NursOrderTreatUpdateBP {
	private GetTotalTimesBP totalTimesUtils = new GetTotalTimesBP();
	private CalQuantumBP quantumUtils = new CalQuantumBP();
	public EmsRstDTO save(CiEnContextDTO ctx,CiOrderDO order) throws BizException {
		ICiorderRService orderRService = CiOrdAppUtils.getOrAggQryService();
		ICiorderCudService orservice=CiOrdAppUtils.getOrAggService();
		
		CiorderAggDO aggDO = orderRService.findById(order.getId_or());
		
		CiOrderDO sourceOrder = aggDO.getParentDO();
		sourceOrder.setStatus(DOStatus.UPDATED);
		handleOrder(sourceOrder,order);
		handelOrSrv(aggDO.getOrdSrvDO()[0],order);
		
		CiorderAggDO[] szRstOrdAggInfo=orservice.save(new CiorderAggDO[]{aggDO});
		EmsRstDTO rst = new EmsRstDTO();
		FArrayList rstList = new FArrayList();
		rstList.add(szRstOrdAggInfo[0]);
		rst.setDocument(rstList);
		return rst;
	}
	private void handleOrder(CiOrderDO sourceOrder,CiOrderDO order) throws BizException{
		sourceOrder.setStatus(DOStatus.UPDATED);
		sourceOrder.setQuan_medu(order.getQuan_medu());
		sourceOrder.setId_freq(order.getId_freq());
		sourceOrder.setId_route(order.getId_route());
		sourceOrder.setId_routedes(order.getId_routedes());
		sourceOrder.setDt_effe(order.getDt_effe());
		sourceOrder.setDt_end(order.getDt_end());
		sourceOrder.setId_dep_mp(order.getId_dep_mp());
		sourceOrder.setFg_long(order.getFg_long());
		sourceOrder.setDes_or(order.getDes_or());
		sourceOrder.setFg_stop(order.getFg_stop());
		sourceOrder.setDt_last_bl(sourceOrder.getDt_effe());
	}
	private void handelOrSrv(OrdSrvDO srvdo,CiOrderDO order) throws BizException{
		srvdo.setStatus(DOStatus.UPDATED);
		srvdo.setQuan_medu(order.getQuan_medu());
		srvdo.setId_freq(order.getId_freq());
		srvdo.setId_route(order.getId_route());
		srvdo.setId_routedes(order.getId_routedes());
		srvdo.setId_dep_mp(order.getId_dep_mp());
		srvdo.setDt_last_bl(order.getDt_last_bl());
		srvdo.setQuan_total_medu(
				this.quantumUtils.getUnMMQuantum(order.getDt_effe(),srvdo.getId_freq(), order.getDays_or(), srvdo.getQuan_medu()));// 计算服务总量
	}
	private FDateTime getLastDt(String id_freq, FDateTime dt_effe,
			Integer firstdaytimes,FBoolean fg_long) throws BizException {
		CiOrDtLastBlCal4OpenBP bp = new CiOrDtLastBlCal4OpenBP();
		return bp.exec(id_freq, dt_effe, firstdaytimes,fg_long);
	}
}
