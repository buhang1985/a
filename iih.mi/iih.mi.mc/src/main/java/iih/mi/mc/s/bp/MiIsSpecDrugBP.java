package iih.mi.mc.s.bp;

import iih.bd.base.utils.CollectionUtils;
import iih.bd.srv.bddsdef.d.BdDsDefDO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.mi.itf2.util.MiParamUtil;
import iih.mi.mc.dto.d.MiMcSpecDrugLimitDTO;
import iih.mi.mc.dto.mimcspecdrug.d.MiMcDefDTO;
import iih.mi.mc.dto.mimcspecdrug.d.MiMcSpecDrugInDTO;
import iih.mi.mc.dto.mimcspecdrug.d.MiMcSpecDrugOutDTO;
import iih.mi.mc.mimcspec.s.bp.qry.GetSpecPatDrugListQry;
import iih.mi.mc.s.util.MiBaseInfoUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sie.common.utils.StringUtils;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 特殊病药品判断
 * 
 * @author liming06
 *
 */
public class MiIsSpecDrugBP {
	private int orderMode;

	/**
	 * 特殊病药品判断
	 * 
	 * @param miMcSpecDrugInDTO
	 * @return
	 * @throws BizException
	 */
	public MiMcSpecDrugOutDTO[] exec(MiMcSpecDrugInDTO miMcSpecDrugInDTO) throws BizException {
		List<MiMcSpecDrugOutDTO> miMcSpecDrugOutDTOList = new ArrayList<MiMcSpecDrugOutDTO>();
		this.orderMode = MiParamUtil.MHIR0001();// 0：采用病种模式；1:诊断模式
		// 1.入参校验
		validData(miMcSpecDrugInDTO);
		// 2.组织返回值
		miMcSpecDrugOutDTOList = this.getSpecDrug(miMcSpecDrugInDTO);
		return miMcSpecDrugOutDTOList.toArray(new MiMcSpecDrugOutDTO[] {});
	}

	/**
	 * 参数校验
	 * 
	 * @param miMcSpecDrugInDTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void validData(MiMcSpecDrugInDTO miMcSpecDrugInDTO) throws BizException {
		if (miMcSpecDrugInDTO == null) {
			throw new BizException("入参为空！");
		}
		if (StringUtils.isEmpty(miMcSpecDrugInDTO.getId_ent())) {
			throw new BizException("入参就诊id为空！");
		}
		if (StringUtils.isEmpty(miMcSpecDrugInDTO.getId_hp())) {
			throw new BizException("入参医保id为空！");
		}
		if (this.orderMode == 0) {
			// 0：采用病种模式
			if (MapUtils.isEmpty(miMcSpecDrugInDTO.getMmdsdefs())) {
				throw new BizException("入参诊断id为空！");
			}
		} else {
			// 1:诊断模式
			if (ListUtil.isEmpty(miMcSpecDrugInDTO.getId_didefs())) {
				throw new BizException("入参诊断id为空！");
			}
			if (ListUtil.isEmpty(miMcSpecDrugInDTO.getId_mms())) {
				throw new BizException("入参物品id为空！");
			}
		}
	}

	/**
	 * 组织返回数据
	 * @param miMcSpecDrugInDTO
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private List<MiMcSpecDrugOutDTO> getSpecDrug(MiMcSpecDrugInDTO miMcSpecDrugInDTO) throws BizException {
		String idEnt = miMcSpecDrugInDTO.getId_ent();
		String idHp = miMcSpecDrugInDTO.getId_hp();
		String[] idMms = this.getIdMMs(miMcSpecDrugInDTO);
		//1.返回值初始化dtolist
		List<MiMcSpecDrugOutDTO> miMcSpecDrugOutDTOList = this.setDtoDefaultValue(idMms);
		//2.物品诊断（病种）map
		HashMap<String, List<String>> idmmsMap = new HashMap<String, List<String>>();
		//3.获取特殊病数据集
		GetSpecPatDrugListQry qry = new GetSpecPatDrugListQry(idEnt, idHp, null, idMms);
		List<MiMcSpecDrugLimitDTO> specPatDrugLst = (List<MiMcSpecDrugLimitDTO>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null),
				new BeanListHandler(MiMcSpecDrugLimitDTO.class));

		if (!ListUtil.isEmpty(specPatDrugLst)) {
			if (this.orderMode == 0) {
				// 0：采用病种模式
				for (MiMcSpecDrugLimitDTO dto : specPatDrugLst) {
					List<String> dsdefList = new ArrayList<String>();
					if(StringUtils.isEmpty(dto.getId_dsdef()))
						continue;
					if (idmmsMap.containsKey(dto.getId_mm())) {
						dsdefList = idmmsMap.get(dto.getId_mm());
						if (!dsdefList.contains(dto.getId_dsdef())) {
							dsdefList.add(dto.getId_dsdef());
						}
					} else {
						dsdefList.add(dto.getId_dsdef());
					}
					idmmsMap.put(dto.getId_mm(), dsdefList);
				}
			} else {
				// 1:诊断模式
				for (MiMcSpecDrugLimitDTO dto : specPatDrugLst) {
					List<String> didefList = new ArrayList<String>();
					if(StringUtils.isEmpty(dto.getId_didef()))
						continue;
					if (idmmsMap.containsKey(dto.getId_mm())) {
						didefList = idmmsMap.get(dto.getId_mm());
						if (!didefList.contains(dto.getId_didef())) {
							didefList.add(dto.getId_didef());
						}
					} else {
						didefList.add(dto.getId_didef());
					}
					idmmsMap.put(dto.getId_mm(), didefList);
				}
			}
		}
		// 为返回值组织数据
		for (MiMcSpecDrugOutDTO dto : miMcSpecDrugOutDTOList) {
			String idMm = dto.getId_mm();
			if (idmmsMap.containsKey(idMm)) {
				if (this.orderMode == 0) {
					// 0：采用病种模式
					FMap mmDsfMap = miMcSpecDrugInDTO.getMmdsdefs();
					String idDsf = (String) mmDsfMap.get(idMm);
					List<String> idDsfList = idmmsMap.get(idMm);
					if (idDsfList.contains(idDsf)) {
						dto.setFg_specjudge(FBoolean.TRUE);
					}
				} else {
					// 1:诊断模式
					FArrayList idDifParam = miMcSpecDrugInDTO.getId_didefs();
					List<String> idDifList = idmmsMap.get(idMm);
					for (Object obj : idDifParam) {
						String idDif = (String) obj;
						if (idDifList.contains(idDif)) {
							dto.setFg_specjudge(FBoolean.TRUE);
						}
					}
				}
				dto.setFg_specdrug(FBoolean.TRUE);
				dto.setDeflist(this.convertMMOfDefList(idmmsMap.get(idMm).toArray(new String[]{})));
			}
		}
		return miMcSpecDrugOutDTOList;
	}

	/**
	 * 获取物品id信息
	 * 
	 * @param miMcSpecDrugInDTO
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String[] getIdMMs(MiMcSpecDrugInDTO miMcSpecDrugInDTO) {
		List<String> idmmList = new ArrayList<String>();
		if (this.orderMode == 0) {
			// 0：采用病种模式
			FMap mmDsfMap = miMcSpecDrugInDTO.getMmdsdefs();
			for (Object obj : mmDsfMap.keySet()) {
				String idMm = (String) obj;
				idmmList.add(idMm);
			}
		} else {
			// 1:诊断模式
			idmmList = miMcSpecDrugInDTO.getId_mms();
		}
		return idmmList.toArray(new String[] {});
	}

	/**
	 * 为返回DTO设置默认值
	 * 
	 * @param idMMs
	 * @return
	 */
	private List<MiMcSpecDrugOutDTO> setDtoDefaultValue(String[] idMMs) {
		List<MiMcSpecDrugOutDTO> miMcSpecDrugOutDTOList = new ArrayList<MiMcSpecDrugOutDTO>();
		if (ArrayUtil.isEmpty(idMMs)) {
			return miMcSpecDrugOutDTOList;
		}
		for (String idmm : idMMs) {
			MiMcSpecDrugOutDTO dto = new MiMcSpecDrugOutDTO();
			dto.setId_mm(idmm);
			dto.setFg_specdrug(FBoolean.FALSE);
			dto.setFg_specjudge(FBoolean.FALSE);
			miMcSpecDrugOutDTOList.add(dto);
		}
		return miMcSpecDrugOutDTOList;
	}
	
	/**
	 * 返回病种（诊断）详细信息
	 * @param idDef
	 * @param defMap
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private FArrayList convertMMOfDefList(String[] idDefArr) throws BizException{
		if(ArrayUtils.isEmpty(idDefArr)){
			return null;
		}
		//2.查询病种（诊断）信息
		HashMap<String,MiMcDefDTO> defMap=this.getDefInfo(idDefArr);
		
		FArrayList defList= new FArrayList();
		for(String idDef : idDefArr){
			if(defMap.containsKey(idDef)){
				defList.add(defMap.get(idDef));
			}
		}
		return defList;
	}
	
	/**
	 * 获取病种（诊断）信息
	 * @return
	 * @throws BizException 
	 */
	private HashMap<String,MiMcDefDTO> getDefInfo(String[] idDefArr) throws BizException{
		HashMap<String,MiMcDefDTO> defMap= new HashMap<String,MiMcDefDTO>();
		if (this.orderMode == 0) {
			// 0：采用病种模式
			BdDsDefDO[] dsDefArr=MiBaseInfoUtil.getDsDefInfo(idDefArr);
			if(ArrayUtils.isNotEmpty(dsDefArr)){
				for(BdDsDefDO defDO :dsDefArr){
					MiMcDefDTO dto= new MiMcDefDTO();
					dto.setId_def(defDO.getId_dsdef());
					dto.setCode_def(defDO.getCode());
					dto.setName_def(defDO.getName());
					defMap.put(defDO.getId_dsdef(), dto);
				}
			}
		}else{
			DiagDefDO[] diDefArr=MiBaseInfoUtil.getDiDefInfo(idDefArr);
			if(ArrayUtils.isNotEmpty(diDefArr)){
				for(DiagDefDO defDO :diDefArr){
					MiMcDefDTO dto= new MiMcDefDTO();
					dto.setId_def(defDO.getId_didef());
					dto.setCode_def(defDO.getCode());
					dto.setName_def(defDO.getName());
					defMap.put(defDO.getId_didef(), dto);
				}
			}
		}
		return defMap;
	}
}
