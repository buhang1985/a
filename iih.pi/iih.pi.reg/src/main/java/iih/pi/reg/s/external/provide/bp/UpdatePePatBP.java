package iih.pi.reg.s.external.provide.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.pi.reg.dto.d.PiPatPeDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiAddrDOCudService;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.s.bp.util.GetUdidocDOUtil;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 更新体检患者信息
 * 
 * @author houll 2018/11/28
 *
 */
public class UpdatePePatBP {

	/**
	 * 更新体检患者信息
	 * 
	 * @param aggDos
	 * @throws BizException
	 */
	public PatiAggDO[] exec(PiPatPeDTO[] piPatPeDTOs) throws BizException {

		if (piPatPeDTOs == null || piPatPeDTOs.length <= 0) {
			throw new BizException("入参为空");
		}

		StringBuilder sb = new StringBuilder();
		List<String> patList=new ArrayList<String>();
		for (PiPatPeDTO agg : piPatPeDTOs) {
			String patId=agg.getId_pat();
			if(StringUtil.isEmpty(patId)){
				continue;
			}
			patList.add(patId);
		}
		if (!ListUtil.isEmpty(patList)) {
			sb.append(SqlUtils.getInSqlByIds("a0.id_pat", patList));
		} else {
			sb.append(" 1 = 2 ");
		}
		
		IPatiRService patRService = ServiceFinder.find(IPatiRService.class);
		PatiAggDO[] patiAggDOs2 = patRService.find(sb.toString(), "", FBoolean.FALSE);
		List<PatiAggDO> patDOList = new ArrayList<PatiAggDO>();

		if (patiAggDOs2 != null && patiAggDOs2.length > 0) {
			for (PatiAggDO patiAggDO : patiAggDOs2) {
				PatDO patDO = patiAggDO.getParentDO();
				String idpat = patDO.getId_pat();

				for (PiPatPeDTO aggDo : piPatPeDTOs) {

					String patId = aggDo.getId_pat();
					if (idpat.equals(patId)) {

						patDO.setName(aggDo.getName());
						patDO.setPycode(CnToPy.getPyFirstCode(patDO.getName()));//拼音码
						patDO.setWbcode(CnToWB.getWBCode(patDO.getName()));// 五笔码
						patDO.setFg_realname(FBoolean.TRUE);

						// 证件类型
						UdidocDO idtpDoc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_IDTP, aggDo.getSd_idtp());
						if (idtpDoc != null) {
							patDO.setId_idtp(idtpDoc.getId_udidoc());
							patDO.setSd_idtp(idtpDoc.getCode());
						} else {
							patDO.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
							patDO.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
						}
						patDO.setId_code(aggDo.getIdcode());

						UdidocDO sexDoc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_SEX_CODE, aggDo.getSd_sex());
						if (sexDoc != null) {
							patDO.setId_sex(sexDoc.getId_udidoc());
							patDO.setSd_sex(sexDoc.getCode());
						}

						patDO.setDt_birth(new FDate(aggDo.getDt_birth()));
						patDO.setMob(aggDo.getMob());

						PatiAggDO patAggDO = new PatiAggDO();
						
						patAggDO.setParentDO(patDO);
						patDO.setStatus(DOStatus.UPDATED);
						patDOList.add(patAggDO);
					}
				}
			}
			this.setPatNowAddr(piPatPeDTOs);
			this.setPatNstiveAddr(piPatPeDTOs);
			PatiAggDO[] patArr = patDOList.toArray(new PatiAggDO[patDOList.size()]);
			IPatiCudService patCService = ServiceFinder.find(IPatiCudService.class);
			return patCService.save(patArr);
		} else {
			throw new BizException("未查询到修改患者的his注册信息");
		}
	}

	/***
	 * 设置患者现住址
	 * @param piPatPeDTOs
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private void setPatNowAddr(PiPatPeDTO[] piPatPeDTOs) throws BizException{
		Map<String,Map<String,String>> nowAddrMap = this.getNowAddr(piPatPeDTOs);
		if(nowAddrMap == null || nowAddrMap.isEmpty())
			return;
		for(PiPatPeDTO dto:piPatPeDTOs){
			PatiAddrDO addrDo = this.getAddress(dto.getId_pat(),IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			//修改患者现住址
			Map<String,String> map = nowAddrMap.get(addrDo.getId_pat());
			if(map == null || map.isEmpty()){
				return;
			}
			if(addrDo != null){
				addrDo.setStreet(map.get(!StringUtils.isNullOrEmpty(map.get("Live_street")) ? map.get("Live_street") : map.get("Live_street")));
				addrDo.setZip(map.get("Live_postcode"));
				addrDo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
				addrDo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
				addrDo.setDs(DOStatus.UPDATED);
			}else{
				//新增一条现住址地址
				addrDo = new PatiAddrDO();
				addrDo.setStreet(map.get(!StringUtils.isNullOrEmpty(map.get("Live_street")) ? map.get("Live_street") : map.get("Live_street")));
				addrDo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
				addrDo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
				addrDo.setZip(map.get("Live_postcode"));
				addrDo.setDs(DOStatus.NEW);
			}
			this.saveAddress(addrDo);
		}
	}
	/***
	 * 设置患者户籍地址
	 * 
	 * @param piPatPeDTOs
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private void setPatNstiveAddr(PiPatPeDTO[] piPatPeDTOs) throws BizException{
		Map<String,Map<String,String>> nativeAddrMap = this.getNativeAddr(piPatPeDTOs);
		if(nativeAddrMap == null || nativeAddrMap.isEmpty())
			return;
		for(PiPatPeDTO dto:piPatPeDTOs){
			PatiAddrDO addrDo = this.getAddress(dto.getId_pat(),IPiDictCodeConst.SD_ADDR_TYPE_CENCUS);
			//修改患者户籍住址
			Map<String,String> map = nativeAddrMap.get(addrDo.getId_pat());
			if(map == null || map.isEmpty()){
				return;
			}
			if(addrDo != null){
				addrDo.setStreet(!StringUtils.isNullOrEmpty(map.get("Native_street")) ? map.get("Native_street") : map.get("Native_address"));
				addrDo.setZip(map.get("Native_postcode"));
				addrDo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS);
				addrDo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS);
				addrDo.setDs(DOStatus.UPDATED);
			}else{
				//新增一条户籍住址地址
				addrDo = new PatiAddrDO();
				addrDo.setStreet(!StringUtils.isNullOrEmpty(map.get("Native_street")) ? map.get("Native_street") : map.get("Native_address"));
				addrDo.setZip(map.get("Native_postcode"));
				addrDo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS);
				addrDo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS);
				addrDo.setDs(DOStatus.NEW);
			}
			this.saveAddress(addrDo);
		}
	}
	/**
	 * 取患者对应的地址
	 * 
	 * @param regionCode
	 * @return
	 * @throws BizException
	 */
	private PatiAddrDO getAddress(String id_pat,String sd_addrtp) throws BizException {
		IPatiAddrDORService service = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] patiAddrDOs = service.find("id_pat = '"+id_pat+"' and SD_ADDRTP = '"+sd_addrtp+"'", null, FBoolean.FALSE);
		return patiAddrDOs != null&& patiAddrDOs.length >0 ? patiAddrDOs[0]: null;
	}
	/**
	 * 保存患者对应的地址
	 * 
	 * @param regionCode
	 * @return
	 * @throws BizException
	 */
	private PatiAddrDO[] saveAddress(PatiAddrDO addrDo) throws BizException {
		IPatiAddrDOCudService service = ServiceFinder.find(IPatiAddrDOCudService.class);
		return service.save(new PatiAddrDO[]{addrDo});
	}

	/***
	 * 获取患者现住址信息
	 * 
	 * @param piPatPeDTOs
	 * @return
	 */
	private Map<String,	Map<String,String>> getNowAddr(PiPatPeDTO[] piPatPeDTOs){
		Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();
		Map<String,String> adddrmap = new HashMap<String,String>();
		for(PiPatPeDTO dto : piPatPeDTOs){
			if(!StringUtils.isNullOrEmpty(dto.getId_pat())){
				if(!StringUtils.isNullOrEmpty(dto.getLive_street())){
					adddrmap.put("Live_street", dto.getLive_street());
				}
				if(!StringUtils.isNullOrEmpty(dto.getLive_address())){
					adddrmap.put("Live_address", dto.getLive_address());
				}
				if(!StringUtils.isNullOrEmpty(dto.getLive_postcode())){
					adddrmap.put("Live_postcode", dto.getLive_postcode());
				}
				if(adddrmap != null && adddrmap.size() > 0){
					map.put(dto.getId_pat(), adddrmap);
				}
			}
		}
		return map;
	}
	/***
	 * 获取患者户籍地址信息
	 * 
	 * @param piPatPeDTOs
	 * @return
	 */
	private Map<String,	Map<String,String>> getNativeAddr(PiPatPeDTO[] piPatPeDTOs){
		Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();
		Map<String,String> adddrmap = new HashMap<String,String>();
		for(PiPatPeDTO dto : piPatPeDTOs){
			if(!StringUtils.isNullOrEmpty(dto.getId_pat())){
				if(!StringUtils.isNullOrEmpty(dto.getNative_street())){
					adddrmap.put("Native_street", dto.getNative_street());
				}
				if(!StringUtils.isNullOrEmpty(dto.getNative_address())){
					adddrmap.put("Native_address", dto.getNative_address());
				}
				if(!StringUtils.isNullOrEmpty(dto.getNative_postcode())){
					adddrmap.put("Native_postcode", dto.getNative_postcode());
				}
				if(adddrmap != null && adddrmap.size() > 0){
					map.put(dto.getId_pat(), adddrmap);
				}
			}
		}
		return map;
	}
}
