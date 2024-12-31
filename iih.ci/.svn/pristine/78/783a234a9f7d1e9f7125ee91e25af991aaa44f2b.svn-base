package iih.ci.mi.external.obtain.mi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.ci.mi.srv.i.meta.HpsrvtpQryParamDTO;
import iih.ci.mi.srv.i.meta.HpsrvtpQryRstDTO;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.mi.bd.i.IMiBdDirCompQryService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取医保目录类型
 * 
 * @author HUMS
 *
 */
public class HpsrvtpQryBP {

	private IMiBdDirCompQryService miBdDirCompQryService;

	public HpsrvtpQryBP() {

		miBdDirCompQryService = (IMiBdDirCompQryService) ServiceFinder.find(IMiBdDirCompQryService.class);

	}

	/**
	 * 获取医保目录类型集合<br>
	 * 存在多套医保计划
	 * 
	 * @param id_hp 医保计划id
	 * @param hpsrvtpParamList 获取医保计划的服务、服务信息
	 * @return 服务或物品对应的医保目录map集合
	 * @throws BizException
	 */
	
	public Map<String, HpsrvtpQryRstDTO> getHpsrvtpRstMap(String id_hp, List<HpsrvtpQryParamDTO> hpsrvtpParamList) throws BizException {

		List<String> idSrvList = new ArrayList<String>();
		List<String> idMmList = new ArrayList<String>();

		for (HpsrvtpQryParamDTO param : hpsrvtpParamList) {
			if (FBoolean.TRUE.equals(param.getFg_mm())) {
				idMmList.add(param.getId_mm());
			} else {
				idSrvList.add(param.getId_srv());
			}
		}

		// TODO 返回医保目录结果集合，自定义服务时hpsrvtpParamList 为空
		Map<String, HpsrvtpQryRstDTO> hpsrvtpRstMap = new HashMap<String, HpsrvtpQryRstDTO>();
		if (hpsrvtpParamList == null) {
			return hpsrvtpRstMap;
		}

		ThreeDirCompInfoDTO[] dirInfos = miBdDirCompQryService.findThreeDirCompByHisSrvIdsAndDrugIds(id_hp,
				idSrvList.toArray(new String[idSrvList.size()]), idMmList.toArray(new String[idMmList.size()]));
		
		for (ThreeDirCompInfoDTO dirInfo : dirInfos) {
			
			HpsrvtpQryRstDTO hpsrvtpQryRst = new HpsrvtpQryRstDTO();
			
			if(StringUtils.isEmpty(dirInfo.getId_drug())){
				hpsrvtpQryRst.setId_srv(dirInfo.getId_srv());
				hpsrvtpQryRst.setCode_srv(dirInfo.getCode());
			}else{
				hpsrvtpQryRst.setId_srv(dirInfo.getId_srv());
				hpsrvtpQryRst.setId_mm(dirInfo.getId_drug());
				hpsrvtpQryRst.setCode_mm(dirInfo.getCode());	
			}

			hpsrvtpQryRst.setId_hp(id_hp);
			//hpsrvtpQryRst.setId_hpsrvtp(dirInfo.getId_hpsrvtp());
			hpsrvtpQryRst.setSd_hpsrvtp(dirInfo.getSd_hpsrvtp());
			//hpsrvtpQryRst.setName_hpsrvtp(dirInfo.getName_hpsrvtp());
			hpsrvtpRstMap.put(hpsrvtpQryRst.getKey(), hpsrvtpQryRst);
		}
		
		for (HpsrvtpQryParamDTO param : hpsrvtpParamList) {

			if (hpsrvtpRstMap.containsKey(param.getKey())) {
				continue;
			}
			
			HpsrvtpQryRstDTO hpsrvtpQryRst = new HpsrvtpQryRstDTO();
			hpsrvtpQryRst.setId_srv(param.getId_srv());
			hpsrvtpQryRst.setId_mm(param.getId_mm());

			hpsrvtpQryRst.setId_hp(id_hp);
			hpsrvtpQryRst.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
			hpsrvtpQryRst.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);
			hpsrvtpQryRst.setName_hpsrvtp("丙");
			hpsrvtpRstMap.put(hpsrvtpQryRst.getKey(), hpsrvtpQryRst);

		}
		return hpsrvtpRstMap;
	}

	/*public Map<String, HpsrvtpQryRstDTO> getHpsrvtpRstMap2(String id_hp, List<HpsrvtpQryParamDTO> hpsrvtpParamList) throws DAException {

		SqlParam sqlParam = new SqlParam();

		StringBuffer idSrvParamBuffer = new StringBuffer();
		StringBuffer idMmParamBuffer = new StringBuffer();

		List<String> idMmList = new ArrayList<String>();
		List<String> idSrvList = new ArrayList<String>();
		sqlParam.addParam(id_hp);

		Map<String, HpsrvtpQryParamDTO> hpsrtpQryParamMap = new HashMap<String, HpsrvtpQryParamDTO>();
		// TODO 返回医保目录结果集合，自定义服务时hpsrvtpParamList 为空
		Map<String, HpsrvtpQryRstDTO> hpsrvtpRstMap = new HashMap<String, HpsrvtpQryRstDTO>();

		if (hpsrvtpParamList == null) {
			return hpsrvtpRstMap;
		}

		for (HpsrvtpQryParamDTO param : hpsrvtpParamList) {

			if (StringUtils.isNotEmpty(param.getId_mm())) {
				idMmList.add(param.getId_mm());
				idMmParamBuffer.append(",?");

			} else {
				idSrvList.add(param.getId_srv());
				idSrvParamBuffer.append(",?");

			}

			hpsrtpQryParamMap.put(param.getKey(), param);
		}

		StringBuffer buffer = new StringBuffer();
		buffer.append("select id_hp,id_srv,id_mm,id_hpsrvtp,sd_hpsrvtp,doc.name as name_hpsrvtp");
		buffer.append(" from bd_hp_srvorca hpca,bd_udidoc doc");
		buffer.append(" where hpca.id_hpsrvtp = doc.id_udidoc and id_hp = ? and ( ");
		if (idSrvParamBuffer.length() > 0) {
			buffer.append("id_srv in (").append(idSrvParamBuffer.substring(1)).append(")");
			for (String id_srv : idSrvList) {
				sqlParam.addParam(id_srv);
			}
		}

		if (idSrvParamBuffer.length() > 0 && idMmParamBuffer.length() > 0) {
			buffer.append(" or ");
		}

		if (idMmParamBuffer.length() > 0) {
			buffer.append("id_mm in (").append(idMmParamBuffer.substring(1)).append(")");
			for (String id_mm : idMmList) {
				sqlParam.addParam(id_mm);
			}
		}
		buffer.append(")");

		DAFacade dafacade = new DAFacade();
		List<HpsrvtpQryRstDTO> hpsrvtpQryRstList = (List<HpsrvtpQryRstDTO>) dafacade.execQuery(buffer.toString(), sqlParam,
				new BeanListHandler(HpsrvtpQryRstDTO.class));

		for (HpsrvtpQryRstDTO hpsrvtpQryRst : hpsrvtpQryRstList) {
			hpsrvtpRstMap.put(hpsrvtpQryRst.getKey(), hpsrvtpQryRst);
		}

		for (HpsrvtpQryParamDTO param : hpsrvtpParamList) {

			if (hpsrvtpRstMap.containsKey(param.getKey())) {
				continue;
			}

			HpsrvtpQryRstDTO hpsrvtpQryRst = new HpsrvtpQryRstDTO();
			hpsrvtpQryRst.setId_srv(param.getId_srv());
			hpsrvtpQryRst.setId_mm(param.getId_mm());

			hpsrvtpQryRst.setId_hp(id_hp);
			hpsrvtpQryRst.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
			hpsrvtpQryRst.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);
			hpsrvtpQryRst.setName_hpsrvtp("丙");
			hpsrvtpRstMap.put(hpsrvtpQryRst.getKey(), hpsrvtpQryRst);
		}

		return hpsrvtpRstMap;
	}*/

	/**
	 * 根据医保计划，服务id，物品id获取医保目录类型集合
	 * 
	 * @param id_hp 医保计划id
	 * @param idSrvList 服务id集合
	 * @param idMmList 物品id集合
	 * @return 医保目录类型map key值为“id_srv+id_mm”
	 * @throws BizException
	 */
	/*private static Map<String, HPSrvorcaDO> getHPSrvorcaMap(String id_hp, List<String> idSrvList, List<String> idMmList) throws BizException {

		StringBuffer whereBuffer = new StringBuffer();
		StringBuffer idSrvBuffer = new StringBuffer();
		StringBuffer idMmBuffer = new StringBuffer();

		Map<String, HPSrvorcaDO> hpSrvcaMap = new HashMap<String, HPSrvorcaDO>();
		if (idSrvList.size() == 0 && idMmList.size() == 0) {
			return hpSrvcaMap;
		}

		if (idSrvList.size() > 0) {

			for (String idSrv : idSrvList) {
				idSrvBuffer.append(",'" + idSrv + "'");
			}
			whereBuffer.append(" id_srv in (").append(idSrvBuffer.substring(1)).append(")");
		}

		if (idMmList.size() > 0) {

			if (whereBuffer.length() > 0) {
				whereBuffer.append(" or ");
			}

			for (String idMm : idMmList) {
				idMmBuffer.append(",'" + idMm + "'");
			}
			whereBuffer.append(" id_mm in (").append(idMmBuffer.substring(1)).append(")");
		}

		whereBuffer.insert(0, "id_hp = '" + id_hp + "' and ");

		HPSrvorcaDO[] hpSrvorcas = CiOrdAppUtils.getIHpExtService().find(whereBuffer.toString(), "", FBoolean.FALSE);

		for (HPSrvorcaDO hpSrvorca : hpSrvorcas) {

			String key = hpSrvorca.getId_srv() + hpSrvorca.getId_mm();
			hpSrvcaMap.put(key, hpSrvorca);
		}

		return hpSrvcaMap;
	}*/
}
