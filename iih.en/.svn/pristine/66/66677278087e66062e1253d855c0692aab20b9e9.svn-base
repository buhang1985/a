package iih.en.pv.s.listener.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.SetEntStateBP;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.i.IPiPatAlDORService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 设置过敏就诊状况
 * 
 * @author liubin
 *
 */
public class SetAllergyStateBP {
	/**
	 * 过敏就诊状况
	 * 
	 * @param patIds
	 * @throws BizException
	 */
	public void exec(String[] patIds) throws BizException {
		if (EnValidator.isEmpty(patIds))
			return;
		Map<String, String[]> map = getPvs(patIds);
		if (map == null || map.isEmpty())
			return;
		List<EntStateDTO> stateList = new LinkedList<>();
		patIds = map.keySet().toArray(new String[0]);
		Map<String, String> alsMap  = getAls(patIds);
		for(String patId : patIds){
			String[] entIds = map.get(patId);
			if(EnValidator.isEmpty(entIds))
				continue;
			for(String entId : entIds){
				String sdDeg = alsMap.get(patId);
				EntStateDTO alEntState = new EntStateDTO();
				alEntState.setId_ent(entId);
				alEntState.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTATE_ALLERGY);
				if(EnValidator.isEmpty(sdDeg)){
					alEntState.setFg_del(FBoolean.TRUE);
				}else{
					alEntState.setVal(sdDeg);
				}
				alEntState.setDt_occ(EnAppUtils.getServerDateTime());
				stateList.add(alEntState);
			}
		}
		//保存就诊状况
		if(stateList.size() > 0){
			SetEntStateBP setEntStateBP = new SetEntStateBP();
			setEntStateBP.exec(stateList.toArray(new EntStateDTO[0]));
		}
	}

	/**
	 * 获取患者对应的过敏信息<患者id, 过敏级别>
	 * 
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	private Map<String, String> getAls(String[] patIds) throws BizException {
		Map<String, String> map = new HashMap<String, String>();
		for (String patId : patIds)
			map.put(patId, null);
		IPiPatAlDORService serv = ServiceFinder.find(IPiPatAlDORService.class);
		PiPatAlDO[] als = serv.findByAttrValStrings(PiPatAlDO.ID_PAT, patIds);
		if (!EnValidator.isEmpty(als)) {
			for (PiPatAlDO al : als) {
				if (EnValidator.isEmpty(al.getId_pat()))
					continue;
				map.put(al.getId_pat(),
						getScDeg(
								map.get(al.getId_pat()),
								EnValidator.isEmpty(al.getSd_aldeg()) ? IPiDictCodeConst.SD_ALDEG_GENARAL
										: al.getSd_aldeg()));
			}
		}
		return map;
	}
	/**
	 * 获取过敏程度
	 * 
	 * @param oldDeg
	 * @param newDeg
	 * @return
	 */
	private String getScDeg(String oldDeg, String newDeg) {
		if (EnValidator.isEmpty(oldDeg))
			return newDeg;
		if(IPiDictCodeConst.SD_ALDEG_GENARAL.equals(oldDeg))
			return newDeg;
		if(IPiDictCodeConst.SD_ALDEG_MODERATE.equals(oldDeg)){
			return IPiDictCodeConst.SD_ALDEG_SERIOUS.equals(newDeg) ? newDeg : oldDeg;
		}
		if(IPiDictCodeConst.SD_ALDEG_SERIOUS.equals(oldDeg))
			return oldDeg;
		return IPiDictCodeConst.SD_ALDEG_GENARAL;
	}

	/**
	 * 获取患者对应的就诊信息<患者id, 就诊id集合>
	 * 
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	private Map<String, String[]> getPvs(String[] patIds) throws BizException {
		String sql = "CODE_ENTP = ? AND FG_IP = 'Y' ";
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		sql += EnSqlUtils.getInSqlByIds(" AND ID_PAT ", patIds);
		Map<String, String[]> map = new HashMap<String, String[]>();
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().findByCond(
				PatiVisitDO.class, sql, param);
		if (!EnValidator.isEmpty(list)) {
			Map<String, List<PatiVisitDO>> entMap = EnFMapUtils.getMapList(
					PatiVisitDO.ID_PAT, list.toArray(new PatiVisitDO[0]));
			for (String key : entMap.keySet()) {
				List<PatiVisitDO> entList = entMap.get(key);
				if (EnValidator.isEmpty(entList))
					continue;
				String[] entIds = EnAppUtils
						.getKeyPropArrayFromDO(PatiVisitDO.ID_ENT,
								entList.toArray(new PatiVisitDO[0]));
				if (EnValidator.isEmpty(entIds))
					continue;
				map.put(key, entIds);
			}
		}
		return map;
	}
}
