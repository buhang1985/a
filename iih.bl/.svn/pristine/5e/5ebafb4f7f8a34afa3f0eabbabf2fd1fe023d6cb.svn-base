package iih.bl.hp.bp;

import iih.bd.base.utils.FBooleanUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据就诊编号获取医嘱 及 医嘱下服务 与 服务下物品
 * 
 * @author Administrator
 *
 */
public class GetCiorderDTOByEntBP {

	/**
	 *  获取就诊下医嘱信息
	 * @param entid 就诊编号
	 * @param orderMap 设置医嘱MAP
	 * @param orsrvMap 设置医嘱下服务MAP
	 * @param ormmMap 设置服务下MAP
	 * @return
	 * @throws BizException
	 */
	public void exec(String entid,
			HashMap<String, CiOrderDO> orderMap,
			HashMap<String, OrdSrvDO> orsrvMap,
			HashMap<String, OrdSrvMmDO> ormmMap) throws BizException {
		//医嘱编号集合
		List<String> idorList = new ArrayList<String>();
		//医嘱服务
		ICiorderMDORService orService = ServiceFinder.find(ICiorderMDORService.class);
		//获取就诊下医嘱信息
		CiOrderDO[] orderDOs = orService.findByAttrValString(CiOrderDO.ID_EN,
				entid);
		//如果医嘱为空返回
		if(orderDOs==null)
			return ;

		//循环医嘱信息  并填充医嘱主键集合
		for (CiOrderDO ciOrderDO : orderDOs) {
			//只校验签署医嘱FBooleanUtils.isTrue(ciOrderDO.getFg_sign())
			//只校验作废标志：未作废的医嘱 并且是未收费和未退费
			if(!FBooleanUtils.isTrue(ciOrderDO.getFg_canc())&&("0").equals(ciOrderDO.getSd_su_bl()))
			{
				orderMap.put(ciOrderDO.getId_or(), ciOrderDO);
				idorList.add(ciOrderDO.getId_or());
			}
		}
		if(idorList.size()<=0){
			return;
		}
		List<String> idorsrvList = setOrdSrvMapByIdOrs(orsrvMap,
				idorList.toArray(new String[idorList.size()]));
		if(idorsrvList.size()>0)
		{
			setOrdSrvMMMapByIdOrSrv(ormmMap,
					idorsrvList.toArray(new String[idorsrvList.size()]));
		}

	}
	/**
	 * 设置服务项目MAP 通过医嘱编号
	 * @param orsrvMap 服务项目map
	 * @param idors 医嘱编号集合
	 * @return
	 * @throws BizException
	 */
	private List<String> setOrdSrvMapByIdOrs(HashMap<String, OrdSrvDO> orsrvMap, String[] idors)
					throws BizException {

		List<String> idorsrvList = new ArrayList<String>();

		IOrdSrvDORService srvService = ServiceFinder
				.find(IOrdSrvDORService.class);

		OrdSrvDO[] ordSrvDOs = srvService.findByAttrValStrings(OrdSrvDO.ID_OR,
				idors);

		for (OrdSrvDO ordSrvDO : ordSrvDOs) {
			//不统计自费服务项目 和记账状态：已退费的数据 并且是未收费和未退费
			if((FBoolean.FALSE).equals(ordSrvDO.getFg_selfpay()) &&
					("0").equals(ordSrvDO.getSd_su_bl()) ){
				orsrvMap.put(ordSrvDO.getId_orsrv(), ordSrvDO);
				idorsrvList.add(ordSrvDO.getId_orsrv());
			}
		}

		return idorsrvList;
	}

	/**
	 * 通过服务项目编号 获取服务项目下 物品 填充物品MAP
	 * @param ormmMap
	 * @param idorsrvs
	 * @throws BizException
	 */
	private void setOrdSrvMMMapByIdOrSrv(HashMap<String, OrdSrvMmDO> ormmMap,
			String[] idorsrvs) throws BizException {

		IOrdsrvmmRService srvmmService = ServiceFinder
				.find(IOrdsrvmmRService.class);

		OrdSrvMmDO[] ordSrvDOs = srvmmService.findByAttrValStrings(
				OrdSrvMmDO.ID_ORSRV, idorsrvs);
		if(ordSrvDOs !=null){
			for (OrdSrvMmDO ordSrvDO : ordSrvDOs) {
				ormmMap.put(ordSrvDO.getId_orsrv(), ordSrvDO);
			}
		}
	}
}
