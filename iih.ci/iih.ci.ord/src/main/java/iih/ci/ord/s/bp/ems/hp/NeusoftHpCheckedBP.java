package iih.ci.ord.s.bp.ems.hp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.service.i.IPpQueService;
import iih.ci.mi.common.utils.MiEnContextUtil;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 东软医保校验
 * @author zhangwq
 *
 */
public class NeusoftHpCheckedBP {
	/**
	 * 查询医保目录时，非药品的服务id
	 */
	private List<String> idSrvs = new ArrayList<String>();
	/**
	 * 查询医保目录时，物品的id
	 */
	private List<String> idMms = new ArrayList<String>();
	
	public void execChecked(CiEnContextDTO context,List<CiOrAggAndRelDatum> ciorAggDatumList) throws BizException{
		//为什么取默认的医保计划，因为当患者有医保计划时，id_hp_default就是患者的医保计划；当患者无医保计划，id_hp_default为默认的医保计划
		String id_hp = context.getId_hp_default();
		if(CiOrdUtils.isEmpty(id_hp)){
			id_hp = context.getId_hp();
		}
		if(CiOrdUtils.isEmpty(id_hp)){
			id_hp = getDefaultHp(context.getId_hp());
		}
		if(CiOrdUtils.isEmpty(id_hp)){
			return;
		}
		//获得查询医保计划的id_srv和id_mm集合
		getHpsrvtpKey(ciorAggDatumList);
		//查询服务医保目录
		Map<String, HPSrvorcaDO> hpSrvcaMap = CiOrdUtils.getHPSrvorcaMap(id_hp,idSrvs,idMms);
		for (CiOrAggAndRelDatum ciOrAggAndRel : ciorAggDatumList) {
			CiorderAggDO ciordAgg = ciOrAggAndRel.getOraggdo();
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
						//患者是医保就诊
						if(MiEnContextUtil.isHpPat(context)){
							ordSrv.setFg_selfpay(FBoolean.FALSE);
						}else{
							ordSrv.setFg_selfpay(FBoolean.TRUE);
						}
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
	}
	/**
	 * 获得查询医保目录的主键
	 */
	private void getHpsrvtpKey(List<CiOrAggAndRelDatum> ciorAggDatumList){
		for (CiOrAggAndRelDatum ciOrAggAndRel : ciorAggDatumList) {
			CiorderAggDO ciordAgg = ciOrAggAndRel.getOraggdo();
			for (OrdSrvDO ordSrv : ciordAgg.getOrdSrvDO()) {
				if (FBoolean.TRUE.equals(ordSrv.getFg_mm())) {
					idMms.add(ordSrv.getId_mm());
				} else {
					idSrvs.add(ordSrv.getId_srv());
				}
			}
		}
	}
	/**
	 * 获取默认的医保计划
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private String getDefaultHp(String id_ent) throws BizException{
		IPpQueService service = ServiceFinder.find(IPpQueService.class);
		FMap hpMap = service.getHpIdForHpCatalog(new String[]{id_ent});
		String id_hp = null;
		if(hpMap!=null){
			id_hp = (String)hpMap.get(id_ent);
		}
		return id_hp;
	}
}
