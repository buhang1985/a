package iih.en.pv.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.fc.enstate.d.EuPeriodTp;
import iih.bd.fc.enstatetpext.d.BdEnStateTpExtDO;
import iih.en.comm.ep.EntStateEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 设置就诊状况
 * 
 * @author renying
 *
 */
public class SetEntStateBP {
	/**
	 * 设置就诊状况
	 * 
	 * @param entStateDTO 就诊状况DTO
	 * @throws BizException
	 */
	public void exec(EntStateDTO entState) throws BizException {
		exec(new EntStateDTO[] {entState});
	}
	
	/**
	 * 设置就诊状况
	 * 
	 * @param entStateDTO 就诊状况DTO
	 * @throws BizException
	 */
	public void exec(EntStateDTO[] entStates) throws BizException {
		if(EnValidator.isEmpty(entStates))
			return;
		// 1、修改住院表
		this.modifyInpatientStatus(entStates);
		// 2、修改就诊状况
		this.updateEntSates(entStates);
	}
	/**
	 * 修改就诊状况
	 * 
	 * @param entStates
	 * @throws BizException
	 */
	private void updateEntSates(EntStateDTO[] entStates) throws BizException {
		for (EntStateDTO entStateDTO : entStates) {
			if (EnValidator.isEmpty(entStateDTO.getVal())) {
				entStateDTO.setFg_del(FBoolean.TRUE);
			}
		}
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO("Id_ent", entStates);
		if(EnValidator.isEmpty(entIds))
			return;
		String[] entstatetps = EnAppUtils.getKeyPropArrayFromDO("Sd_enstatetp", entStates);
		if(EnValidator.isEmpty(entstatetps))
			return;
		EntStateEP entStateEP = new EntStateEP();
		//1.获取就诊状况类型字典<就诊状况类型, 就诊状况类型定义>
		Map<String, BdEnStateTpExtDO> bdEnStateTpExtMap = entStateEP.getBdEnStateTpExtMap(entstatetps);
		//2.各个患者需要设置的就诊状况
		Map<String, List<EntStateDTO>> newSatesmap = EnFMapUtils.getMapList("Id_ent", entStates);
		//3.患者已有就诊状况<就诊id, <就诊状况类型, 就诊状况>>
		Map<String, Map<String, EntStateDO>> oldSatesMap = entStateEP.getEntStateDOMap(entIds, entstatetps);
		//4.获取就诊id与患者id关系<id_ent, id_pat>
		Map<String, String> entPatMap = getEntPatMap(entIds);
		//5.获取就诊状况值定义<就诊状况类型, <就诊状况值, 就诊状况定义>>
		Map<String, Map<String, BdEnStateDO>> bdstatesMap = entStateEP.getBdEnStateMap(entstatetps);
		//需要保存的DO集合
		List<EntStateDO> saveList = new ArrayList<>();
		for(String newSatesEntId : newSatesmap.keySet()){
			List<EntStateDTO> newSatesList = newSatesmap.get(newSatesEntId);
			for(EntStateDTO entStateDTO : newSatesList){
				if(EnValidator.isEmpty(entStateDTO.getSd_enstatetp()))
					throw new BizException("就诊状况类型不能为空！");
				EntStateDO oldState = getEntStateDO(oldSatesMap, newSatesEntId, entStateDTO.getSd_enstatetp());
				if(FBoolean.TRUE.equals(entStateDTO.getFg_del())){
					if(oldState == null)
						continue;
					oldState.setStatus(DOStatus.DELETED);
				}else{
					BdEnStateTpExtDO bdEnStateTpExt = getBdEnStateTpExtDO(bdEnStateTpExtMap, entStateDTO.getSd_enstatetp());
					BdEnStateDO bdEnStateDO = getBdEnStateDO(bdstatesMap, entStateDTO.getSd_enstatetp(), entStateDTO.getVal());
					if(oldState != null){
						if(FBoolean.TRUE.equals(bdEnStateTpExt.getFg_ent())){
							oldState.setId_ent(entStateDTO.getId_ent());
							oldState.setId_pat(null);
						}
						else{
							oldState.setId_ent(null);
							oldState.setId_pat(entPatMap.get(entStateDTO.getId_ent()));
						}
						if(entStateDTO.getDt_occ() == null){
							if(entStateDTO.getVal() != null && !entStateDTO.getVal().equals(oldState.getVal())){
								oldState.setDt_occ(EnAppUtils.getServerDateTime());
							}
						}else{
							oldState.setDt_occ(entStateDTO.getDt_occ());
						}
						oldState.setVal(entStateDTO.getVal());
						oldState.setStatus(DOStatus.UPDATED);
						oldState.setId_entstatedef(bdEnStateDO.getId_enstate());
						oldState.setId_key_sourse(entStateDTO.getId_key_sourse());
						//设置失效日期
						oldState.setDt_invalid(calcInvalidTime(bdEnStateDO, oldState.getDt_occ()));
					}else{
						oldState = new EntStateDO();
						if(FBoolean.TRUE.equals(bdEnStateTpExt.getFg_ent()))
							oldState.setId_ent(entStateDTO.getId_ent());
						else
							oldState.setId_pat(entPatMap.get(entStateDTO.getId_ent()));
						oldState.setSd_enstatetp(entStateDTO.getSd_enstatetp());
						oldState.setId_enstatetp(bdEnStateTpExt.getId_enstatetp());
						oldState.setVal(entStateDTO.getVal());
						if (entStateDTO.getDt_occ() == null) {
							oldState.setDt_occ(EnAppUtils.getServerDateTime());
						}else{
							oldState.setDt_occ(entStateDTO.getDt_occ());
						}
						oldState.setFg_show(FBoolean.TRUE);
						oldState.setId_entstatedef(bdEnStateDO.getId_enstate());
						oldState.setId_key_sourse(entStateDTO.getId_key_sourse());
						//设置失效日期
						oldState.setDt_invalid(calcInvalidTime(bdEnStateDO, oldState.getDt_occ()));
						oldState.setStatus(DOStatus.NEW);
					}
				}
				saveList.add(oldState);
			}
		}
		entStateEP.save(saveList.toArray(new EntStateDO[0]));
	}

	/**
	 * 修改住院表信息
	 * 
	 * @param inpatientDO
	 * @param sd_enstatetp
	 * @param val
	 * @throws BizException
	 */
	private void modifyInpatientStatus(EntStateDTO[] entStates) throws BizException {
		ArrayList<String> entList = new ArrayList<>();
		for(EntStateDTO entState : entStates){
			if(IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD.equals(entState.getSd_enstatetp())
					|| IBdFcDictCodeConst.SD_ENSTSTATETP_NUR.equals(entState.getSd_enstatetp())
					|| IBdFcDictCodeConst.SD_ENSTSTATETP_DISE.equals(entState.getSd_enstatetp()))
				entList.add(entState.getId_ent());
		}
		if(entList.isEmpty()) 
			return;
		EntStateEP enstateEP = new EntStateEP();
		IpEP ep = new IpEP();
		Map<String, InpatientDO> ipMap = EnFMapUtils.getMap(InpatientDO.ID_ENT, ep.getInpatientDOs(entList));
		for(EntStateDTO entState : entStates){
			if (IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD.equals(entState.getSd_enstatetp())) {
				InpatientDO ip = ipMap.get(entState.getId_ent());
				ip.setStatus(DOStatus.UPDATED);
				if (!EnValidator.isEmpty(entState.getVal())) {
					UdidocDO udi = enstateEP.getStateIdByVal(IEnDictCodeTypeConst.SD_STATUS_NUTR, entState.getVal());
					ip.setSd_level_nutr(udi.getCode());
					ip.setId_level_nutr(udi.getId_udidoc());
				}else{
					ip.setSd_level_nutr(null);
					ip.setId_level_nutr(null);
				}
			}
			if (IBdFcDictCodeConst.SD_ENSTSTATETP_NUR.equals(entState.getSd_enstatetp())) {
				InpatientDO ip = ipMap.get(entState.getId_ent());
				ip.setStatus(DOStatus.UPDATED);
				if(!EnValidator.isEmpty(entState.getVal())) {
					UdidocDO udi = enstateEP.getStateIdByVal(IEnDictCodeTypeConst.SD_STATUS_NUR, entState.getVal());
					ip.setSd_level_nur(udi.getCode());
					ip.setId_level_nur(udi.getId_udidoc());
				}else{
					ip.setSd_level_nur(null);
					ip.setId_level_nur(null);
				}
			}
			if (IBdFcDictCodeConst.SD_ENSTSTATETP_DISE.equals(entState.getSd_enstatetp())){
				InpatientDO ip = ipMap.get(entState.getId_ent());
				ip.setStatus(DOStatus.UPDATED);
				if(!EnValidator.isEmpty(entState.getVal())) {
					UdidocDO udi = enstateEP.getStateIdByVal(IEnDictCodeTypeConst.SD_STATUS_DISE, entState.getVal());
					ip.setSd_level_dise(udi.getCode());
					ip.setId_level_dise(udi.getId_udidoc());
				}else{
					ip.setSd_level_dise(null);
					ip.setId_level_dise(null);
				}
			}
		}
		ep.save(ipMap.values().toArray(new InpatientDO[0]));
	}
	/**
	 * 获取就诊id与患者id关系
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	private Map<String, String> getEntPatMap(String[] entIds) throws BizException{
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().findByPKs(PatiVisitDO.class, entIds, new String[] {PatiVisitDO.ID_ENT, PatiVisitDO.ID_PAT});
		Map<String, String> map = new HashMap<String, String>();
		for(PatiVisitDO pv : list){
			map.put(pv.getId_ent(), pv.getId_pat());
		}
		return map;
	}
	/**
	 * 获取患者就诊状况
	 * 
	 * @param entSatesMap
	 * @param entId
	 * @param entstatetp
	 * @return
	 */
	private EntStateDO getEntStateDO(Map<String, Map<String, EntStateDO>> entSatesMap, String entId, String entstatetp){
		if(entSatesMap == null || !entSatesMap.containsKey(entId))
			return null;
		Map<String, EntStateDO> map = entSatesMap.get(entId);
		if(map == null || !map.containsKey(entstatetp))
			return null;
		return map.get(entstatetp);
	}
	/**
	 * 获取就诊状况类型定义
	 * 
	 * @param bdEnStateTpExtMap
	 * @param entstatetp
	 * @return
	 * @throws BizException
	 */
	private BdEnStateTpExtDO getBdEnStateTpExtDO(Map<String, BdEnStateTpExtDO> bdEnStateTpExtMap, String entstatetp) throws BizException{
		if(bdEnStateTpExtMap == null || !bdEnStateTpExtMap.containsKey(entstatetp))
			throw new BizException(String.format("就诊状况类型维护错误，类型:%s!", entstatetp));
		return bdEnStateTpExtMap.get(entstatetp);
	}
	/**
	 * 获取就诊状况值定义
	 * 
	 * @param bdstatesMap
	 * @param entstatetp
	 * @param val
	 * @return
	 * @throws BizException
	 */
	private BdEnStateDO getBdEnStateDO(Map<String, Map<String, BdEnStateDO>> bdstatesMap, String entstatetp, String val)throws BizException{
		if(bdstatesMap == null || !bdstatesMap.containsKey(entstatetp))
			throw new BizException(String.format("就诊状况值定义错误，类型:%s，值:%s!", entstatetp, val));
		Map<String, BdEnStateDO> map = bdstatesMap.get(entstatetp);
		if(map == null || !map.containsKey(val))
			throw new BizException(String.format("就诊状况值定义错误，类型:%s，值:%s!", entstatetp, val));
		return map.get(val);
	}
	/**
	 * 计算失效日期
	 * 
	 * @param bdState
	 * @param dt_occ
	 * @return
	 */
	private FDateTime calcInvalidTime(BdEnStateDO bdState, FDateTime dt_occ){
		if(bdState == null || dt_occ == null)
			return null;
		if(EnValidator.isEmpty(bdState.getCode_measdoc()) || bdState.getPeriod() == null)
			return null;
		if(!EuPeriodTp.USEINVALIDTIME.equals(bdState.getEu_periodtp()))
			return null;
		int period = bdState.getPeriod();
		switch (bdState.getCode_measdoc()) {
		case IBdFcDictCodeConst.CODE_TIME_DAY:
			return dt_occ.addSeconds(period * 60 * 60 * 24);
		case IBdFcDictCodeConst.CODE_TIME_HOUR:
			return dt_occ.addSeconds(period * 60 * 60);
		case IBdFcDictCodeConst.CODE_TIME_MIN:
			return dt_occ.addSeconds(period * 60);
		case IBdFcDictCodeConst.CODE_TIME_SEC:
			return dt_occ.addSeconds(period);
		}
		return null;
	}
}
