package iih.ci.mi.ord.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.mi.ord.i.meta.OrdMiRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvMiRstDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeRstEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordext.d.HpJudgeEnum;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 更新医嘱医保信息
 * @author HUMS
 *
 */
public class UpdateOrdMiInfoBP {

	public OrdMiRstDTO[] updateOrdMiInfo(OrdMiRstDTO[] OrdMiRsts) throws BizException {
		
		// 医嘱更新字段
		String[] ordFieldNames = new String[] {  CiOrderDO.EU_HPJUDGE , CiOrderDO.EU_ORHP,CiOrderDO.FG_ORHP,CiOrderDO.EU_HPINDICJUDGE};
		// 服务项目更新字段
		String[] orsSrvFiledNames = new String[] { OrdSrvDO.EU_HPJUDGE, OrdSrvDO.EU_ORSRVHP,OrdSrvDO.FG_SELFPAY,OrdSrvDO.EU_HPINDICJUDGE};
		
		// 待更新医保适应症结果的医嘱集合
		List<CiOrderDO> saveOrderList = new ArrayList<CiOrderDO>();
		// 待更新医保适应症结果的服务项目集合
		List<OrdSrvDO> saveOrdSrvList = new ArrayList<OrdSrvDO>();
		
		FBoolean fg_orhp = FBoolean.FALSE;// true 是医保，fasle 是自费，老的医保自费标识
		
		for(OrdMiRstDTO ordMiRst : OrdMiRsts){
			CiOrderDO order = new CiOrderDO();
			
			FArrayList ordSrvMiRstFList = ordMiRst.getOrdSrvMiRstFlist();
			
			for(Object obj : ordSrvMiRstFList){
				
				OrdSrvMiRstDTO ordSrvMiRst = (OrdSrvMiRstDTO)obj;
				OrdSrvDO ordSrv = new OrdSrvDO();
				ordSrv.setId_orsrv(ordSrvMiRst.getId_orsrv());
				ordSrv.setEu_hpjudge(ordSrvMiRst.getEu_hpjudge());
				ordSrv.setEu_orsrvhp(ordSrvMiRst.getEu_orsrvhp());
				
				if(HpJudgeRstEnum.HP.equals(ordSrv.getEu_orsrvhp())){
					ordSrv.setFg_selfpay(FBoolean.FALSE);
					ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.DOCTOR_JUDGE); // 废弃属性。老医保中保存涉及该值
					
					fg_orhp = FBoolean.TRUE;
				}else{
					ordSrv.setFg_selfpay(FBoolean.TRUE);
					ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.DOCTOR_JUDGE);
				}
				
				saveOrdSrvList.add(ordSrv);
			}
			
			order.setId_or(ordMiRst.getId_or());
			order.setEu_orhp(ordMiRst.getEu_orhp());
			order.setEu_hpjudge(ordMiRst.getEu_hpjudge());
			
			order.setFg_orhp(fg_orhp);
			order.setEu_hpindicjudge(HpIndicJudgeRstEnum.DOCTOR_JUDGE);
			
			saveOrderList.add(order);
		}
				
		// 更新医嘱、服务项目的医保属性
		if (saveOrderList.size() > 0) {
			new DAFacade().updateDOArray(saveOrderList.toArray(new CiOrderDO[saveOrderList.size()]), ordFieldNames);
			new DAFacade().updateDOArray(saveOrdSrvList.toArray(new OrdSrvDO[saveOrdSrvList.size()]), orsSrvFiledNames);
			
			// 清空医嘱医保扩展表，重新保存数据
			//String whereStr = " id_orsrv in ( " + idOrSrvBuffer.substring(1) + ")";
			//new DAFacade().deleteByWhere(OrdSrvHpDO.class, whereStr);
			//ordextCudService.insert(ordSrvHpList.toArray(new OrdSrvHpDO[ordSrvHpList.size()]));
		}

		
		return null;
	}

	/**
	 * 根据医嘱id和医嘱服务项目id修改数据
	 * 
	 * @param orIdList 	      医嘱id
	 * @param orsrvIdList 医嘱服务项目id
	 * @return
	 * @throws BizException 
	 */
	public OrdMiRstDTO[] updateOrdMiInfo2Selfpay(String[] orIdList, String[] orsrvIdList) throws BizException {
		// 医嘱更新字段
		String[] ordFieldNames = new String[] {  CiOrderDO.EU_HPJUDGE , CiOrderDO.EU_ORHP,CiOrderDO.FG_ORHP};
		// 服务项目更新字段
		String[] orsSrvFiledNames = new String[] { OrdSrvDO.EU_HPJUDGE, OrdSrvDO.EU_ORSRVHP,OrdSrvDO.FG_SELFPAY};
		
		// 待更新医保适应症结果的医嘱集合
		List<CiOrderDO> saveOrderList = new ArrayList<CiOrderDO>();
		// 待更新医保适应症结果的服务项目集合
		List<OrdSrvDO> saveOrdSrvList = new ArrayList<OrdSrvDO>();
		
		for(String orsrvId : orsrvIdList){
			OrdSrvDO ordSrv = new OrdSrvDO();
			ordSrv.setId_orsrv(orsrvId);
			ordSrv.setEu_orsrvhp(HpJudgeRstEnum.SELFPAY);
			ordSrv.setEu_hpjudge(HpJudgeEnum.DOCTOR_JUDGE);
			ordSrv.setFg_selfpay(FBoolean.TRUE);
			saveOrdSrvList.add(ordSrv);
		}
			
		for(String orId : orIdList){
			CiOrderDO order = new CiOrderDO();
			order.setId_or(orId);
			order.setEu_orhp(HpJudgeRstEnum.SELFPAY);
			order.setEu_hpjudge(HpJudgeEnum.DOCTOR_JUDGE);
			order.setFg_orhp(FBoolean.FALSE);
			saveOrderList.add(order);
		}	
				
		// 更新医嘱、服务项目的医保属性
		if (saveOrderList.size() > 0) {
			new DAFacade().updateDOArray(saveOrderList.toArray(new CiOrderDO[saveOrderList.size()]), ordFieldNames);
			new DAFacade().updateDOArray(saveOrdSrvList.toArray(new OrdSrvDO[saveOrdSrvList.size()]), orsSrvFiledNames);
		}
		return null;
	}
}
