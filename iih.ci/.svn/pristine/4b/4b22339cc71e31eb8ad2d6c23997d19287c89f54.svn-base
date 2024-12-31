package iih.ci.ord.s.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.ICiorderSrvDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import iih.en.pv.inpatient.dto.d.ChgHp4EsDTO;
import iih.en.pv.inpatient.dto.d.EuChgHpTp;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 住院患者医保计划切换事件监听
 * 
 * @author zhangwq
 *
 */
public class IpHpChgListener implements IBusinessListener {
	/**
	 * 查询医保目录时，非药品的服务id
	 */
	private List<String> idSrvs = new ArrayList<String>();
	/**
	 * 查询医保目录时，物品的id
	 */
	private List<String> idMms = new ArrayList<String>();
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 事件源及事件类型判断
		if (!(event.getSourceID().equals(IEnEventConst.EVENT_SOURCE_EN_IP_CHGHP)
				&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))
			return;
		// 签署诊断的诊断数据及空判断逻辑
		BusinessEvent dbevent = (BusinessEvent) event;
		// 获得诊断主键字符串及空判断逻辑
		ChgHp4EsDTO esdto = (ChgHp4EsDTO)dbevent.getObject();
		//校验
		if(esdto==null||esdto.getId_ent()==null||esdto.getEu_chghp()==null){
			return;
		}
		ICiorderRService ordRService = ServiceFinder.find(ICiorderRService.class);
		CiorderAggDO[] aggdos = ordRService.findByAttrValString(CiOrderDO.ID_EN, esdto.getId_ent());
		if(aggdos == null || aggdos.length == 0){
			return;
		}
		//医保转自费
		if(EuChgHpTp.HPTOSELFPAY.equals(esdto.getEu_chghp())){
			for(CiorderAggDO agg : aggdos){
				OrdSrvDO[] srvs = agg.getOrdSrvDO();
				for(OrdSrvDO srv : srvs){
					srv.setFg_selfpay(FBoolean.TRUE);
				}
				agg.getParentDO().setFg_orhp(FBoolean.FALSE);
			}
		}else{
			//自费转医保
			String id_hp = esdto.getId_hp();
			idSrvs = new ArrayList<String>();
			idMms = new ArrayList<String>();
			//获得查询医保计划的id_srv和id_mm集合
			getHpsrvtpKey(aggdos);
			//查询服务医保目录
			Map<String, HPSrvorcaDO> hpSrvcaMap = CiOrdUtils.getHPSrvorcaMap(id_hp,idSrvs,idMms);
			for(CiorderAggDO ciordAgg : aggdos){
				for (OrdSrvDO ordSrv : ciordAgg.getOrdSrvDO()) {
					//设置医保计划
					ordSrv.setId_hp(id_hp);
					HPSrvorcaDO hpdo = null;
					if (FBoolean.TRUE.equals(ordSrv.getFg_mm())) {
						hpdo = hpSrvcaMap.get(ordSrv.getId_srv()+ordSrv.getId_mm());
					} else {
						hpdo = hpSrvcaMap.get(ordSrv.getId_srv());
					}
					if(hpdo!=null){
						ordSrv.setId_hpsrvtp(hpdo.getId_hpsrvtp());
						ordSrv.setSd_hpsrvtp(hpdo.getSd_hpsrvtp());
						if(StringUtil.isEmpty(hpdo.getId_hpsrvtp())){
							//设置为丙类
							ordSrv.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
							ordSrv.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);
							//自费标识为true
							ordSrv.setFg_selfpay(FBoolean.TRUE);
						}
						//丙类
						else if(IBdPpCodeTypeConst.ID_HP_BJ_THREE.equals(hpdo.getId_hpsrvtp())){
							ordSrv.setFg_selfpay(FBoolean.TRUE);
						}else{
							ordSrv.setFg_selfpay(FBoolean.FALSE);
						}
					}else{
						//设置为丙类
						ordSrv.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
						ordSrv.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);
						//自费标识为true
						ordSrv.setFg_selfpay(FBoolean.TRUE);
					}
				}
			}
			// 设置医嘱表中的保内和保外标志（fg_orhp）,ci_or_srv中有一个是保内的，则医嘱为保内
			CiOrdUtils.SetFgOrHpOfCiOrder(aggdos);
		}
		//更改状态
		ICiorderCudService cudService = ServiceFinder.find(ICiorderCudService.class);
		cudService.update(aggdos);
	}
	/**
	 * 获得查询医保目录的主键
	 */
	private void getHpsrvtpKey(CiorderAggDO[] aggs){
		for (CiorderAggDO ciordAgg : aggs) {
			for (OrdSrvDO ordSrv : ciordAgg.getOrdSrvDO()) {
				if (FBoolean.TRUE.equals(ordSrv.getFg_mm())) {
					idMms.add(ordSrv.getId_mm());
				} else {
					idSrvs.add(ordSrv.getId_srv());
				}
			}
		}
	}
}
