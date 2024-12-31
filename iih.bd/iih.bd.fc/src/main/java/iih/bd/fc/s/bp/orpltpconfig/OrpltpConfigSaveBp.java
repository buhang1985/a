package iih.bd.fc.s.bp.orpltpconfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltp.i.IOrpltpMDORService;
import iih.bd.fc.orpltp.i.IOrpltpStaDOCudService;
import iih.bd.fc.orpltp.i.IOrpltpStaDORService;
import iih.bd.fc.orpltpconfig.d.OrpltpDTO;
import iih.bd.fc.orpltpconfig.d.OrpltpStaDTO;
import iih.bd.fc.orpltpmtpara.d.OrpltpmtParaDO;
import iih.bd.fc.orpltpmtpara.i.IOrpltpmtparaCudService;
import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import iih.bd.fc.orpltpstafunc.i.IOrpltpstafuncCudService;
import iih.bd.fc.orpltpstamsp.d.OrpltpStaMapDO;
import iih.bd.fc.orpltpstamsp.i.IOrpltpstamspCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱闭环配置信息保存
 * 
 * @author xuxing_2017年6月21日15:38:11
 *
 */
public class OrpltpConfigSaveBp {

	/**
	 * 主入口
	 * 
	 * @param orpltpDTO
	 * @param orpltpStaDTO
	 * @return
	 * @throws BizException
	 */
	public void exec(OrpltpDTO orpltpDTO, OrpltpStaDTO[] orpltpStaDTOS,OrpltpStaDO[] staDOs) throws BizException {

		// 1、基础校验
		validation(orpltpDTO, orpltpStaDTOS);

		// 2、获取闭环信息
		OrpltpDO orpltpDO = getOrpltpInfo(orpltpDTO);

		// 3、保存状态集合
		HashMap<String, OrpltpStaDO> staMap = saveOrpltpSta(orpltpDTO);

		// 4、保存闭环匹配参数集合
		saveOrpltpMt(orpltpDTO);

		// 5、保存闭环状态属性
		saveOrpltpStaAttr(orpltpDO, orpltpStaDTOS, staMap);
		
		//6、保存已选闭环状态
		saveOrpltpStaDOs(orpltpDO,staDOs);
	}

	/**
	 * 保存闭环已选闭环状态
	 * @param orpltpStaDTOS
	 * @throws BizException 
	 */
	private void saveOrpltpStaDOs(OrpltpDO orpltpDO,OrpltpStaDO[] staDOs) throws BizException {
		String id_orpltp=orpltpDO.getId_orpltp();
		IOrpltpStaDORService srv1 = ServiceFinder.find(IOrpltpStaDORService.class);
		String sql="id_orpltp='"+id_orpltp+"'";
		OrpltpStaDO[] stas=srv1.find(sql, "", null);
		
		IOrpltpStaDOCudService srv2=ServiceFinder.find(IOrpltpStaDOCudService.class);
		//srv2.save(stas);
		
		//将已选的状态设为启用，并设置父子级关系
		/*if(staDOs!=null&& staDOs.length>0){
		for (int i=0;i<staDOs.length;i++) {
			staDOs[i].setStatus(DOStatus.UPDATED);
			if(i==0){
				
				staDOs[i].setId_next(staDOs[i+1].getId_orpltpsta());//如果为第一个
			}else if(i==staDOs.length-1){
				staDOs[i].setId_pre(staDOs[i-1].getId_orpltpsta());//如果为最后一个
			}else{
				staDOs[i].setId_pre(staDOs[i-1].getId_orpltpsta());;
				staDOs[i].setId_next(staDOs[i+1].getId_orpltpsta());
			}
			staDOs[i].setFg_active(FBoolean.TRUE);
		}
		srv2.save(staDOs);
		}*/
		
		//srv2.delete(stas);
		//清空所有状态的父子级关系  以及状态改为禁用
		for(int i=0;i<stas.length;i++){
			
			stas[i].setId_pre(null);
			stas[i].setId_next(null);
			stas[i].setFg_active(FBoolean.FALSE);
			System.out.println(stas[i].getId_orpltpsta()+"          "+stas[i].getName());
		}
		for(int i=0;i<staDOs.length;i++){
			for(int j=0;j<stas.length;j++){
				
				stas[j].setStatus(DOStatus.UPDATED);
				System.out.println("已选====="+staDOs[i].getId_orpltpsta());
				System.out.println("所有====="+stas[j].getId_orpltpsta());
				if(staDOs[i].getId_orpltpsta().equals(stas[j].getId_orpltpsta())){
					if(i==0){
						stas[j].setId_next(staDOs[i+1].getId_orpltpsta());//如果为第一个
					}else if(i==staDOs.length-1){
						stas[j].setId_pre(staDOs[i-1].getId_orpltpsta());//如果为最后一个
					}else{
						stas[j].setId_pre(staDOs[i-1].getId_orpltpsta());;
						stas[j].setId_next(staDOs[i+1].getId_orpltpsta());
					}
					stas[j].setFg_active(FBoolean.TRUE);
				}
			}
		}
		
		srv2.save(stas);
	}

	/**
	 * 基础校验
	 * 
	 * @param orpltpDTO
	 * @param orpltpStaDTO
	 * @throws BizException
	 */
	private void validation(OrpltpDTO orpltpDTO, OrpltpStaDTO[] orpltpStaDTOS) throws BizException {
		if (orpltpDTO == null) {
			throw new BizException("医嘱闭环配置保存，医嘱闭环配置信息空异常！");
		}
		/*if (orpltpStaDTOS == null || orpltpStaDTOS.length < 1) {
			throw new BizException("医嘱闭环配置保存，医嘱闭环状态配置信息空异常！");
		}*/
	}

	/**
	 * 获取闭环信息
	 * 
	 * @param orpltpDTO
	 * @return
	 * @throws BizException
	 */
	private OrpltpDO getOrpltpInfo(OrpltpDTO orpltpDTO) throws BizException {
		if (!StringUtil.isEmptyWithTrim(orpltpDTO.getId_orpltp())) {
			IOrpltpMDORService findService = ServiceFinder.find(IOrpltpMDORService.class);
			OrpltpDO rtn = findService.findById(orpltpDTO.getId_orpltp());
			if (rtn == null) {
				throw new BizException("获取闭环信息异常！");
			}
			return rtn;
		}
		return null;
	}

	/**
	 * 闭环状态信息保存
	 * 
	 * @param orpltpDTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private HashMap<String, OrpltpStaDO> saveOrpltpSta(OrpltpDTO orpltpDTO) throws BizException {
		HashMap<String, OrpltpStaDO> reMap = new HashMap<String, OrpltpStaDO>();
		if (orpltpDTO.getArray_sta() != null && orpltpDTO.getArray_sta().size() > 0) {
			List<OrpltpStaDO> listParams = new ArrayList<OrpltpStaDO>();
			for (Object obj : orpltpDTO.getArray_sta()) {
				OrpltpStaDO staDO = (OrpltpStaDO) obj;
				listParams.add((OrpltpStaDO) obj);
				reMap.put(staDO.getId_orpltpsta(), staDO);
			}
			IOrpltpStaDOCudService saveService = ServiceFinder.find(IOrpltpStaDOCudService.class);
			OrpltpStaDO[] saved = saveService.save(listParams.toArray(new OrpltpStaDO[listParams.size()]));
			FArrayList savedArray = new FArrayList();
			savedArray.addAll(Arrays.asList(saved));
			orpltpDTO.setArray_sta(savedArray);
		}
		return reMap;
	}

	/**
	 * 闭环匹配参数保存
	 * 
	 * @param orpltpDTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void saveOrpltpMt(OrpltpDTO orpltpDTO) throws BizException {
		if (orpltpDTO.getArray_orpltpmt() != null && orpltpDTO.getArray_orpltpmt().size() > 0) {
			List<OrpltpmtParaDO> listParams = new ArrayList<OrpltpmtParaDO>();
			for (Object obj : orpltpDTO.getArray_orpltpmt()) {
				OrpltpmtParaDO mtParamDO = (OrpltpmtParaDO) obj;
				mtParamDO.setId_orpltp(orpltpDTO.getId_orpltp());
				mtParamDO.setId_grp(Context.get().getGroupId());// 集团
				mtParamDO.setId_org(Context.get().getOrgId());// 组织
				listParams.add(mtParamDO);
			}
			IOrpltpmtparaCudService saveService = ServiceFinder.find(IOrpltpmtparaCudService.class);
			OrpltpmtParaDO[] saved = saveService.save(listParams.toArray(new OrpltpmtParaDO[listParams.size()]));
			FArrayList savedArray = new FArrayList();
			if (saved != null) {
				savedArray.addAll(Arrays.asList(saved));
			}
			orpltpDTO.setArray_orpltpmt(savedArray);
		}
	}

	/**
	 * 闭环状态属性保存
	 * 
	 * @param orpltpStaDTOS
	 * @throws BizException
	 */
	private void saveOrpltpStaAttr(OrpltpDO orpltpDO, OrpltpStaDTO[] orpltpStaDTOS, HashMap<String, OrpltpStaDO> staMap) throws BizException {

		List<OrpltpStaMapDO> toBeSaveMapList = new ArrayList<OrpltpStaMapDO>();
		List<OrpltpStaFuncDO> toBeSaveFuncList = new ArrayList<OrpltpStaFuncDO>();
		for (OrpltpStaDTO staDTO : orpltpStaDTOS) {

			OrpltpStaDO staDO = staMap.get(staDTO.getId_orpltpsta());

			// 取状态对照
			if (staDTO.getArray_stamap() != null && staDTO.getArray_stamap().size() > 0) {
				for (Object obj : staDTO.getArray_stamap()) {
					OrpltpStaMapDO staMapDO = (OrpltpStaMapDO) obj;
					staMapDO.setId_grp(Context.get().getGroupId());// 集团
					staMapDO.setId_org(Context.get().getOrgId());// 组织
					staMapDO.setId_orpltpsta(staDO.getId_orpltpsta());//闭环状态ID
					staMapDO.setCode_orpltpsta(staDO.getCode());//闭环状态
					toBeSaveMapList.add(staMapDO);
				}
			}

			// 取功能对照
			if (staDTO.getArray_func() != null && staDTO.getArray_func().size() > 0) {
				for (Object obj : staDTO.getArray_func()) {
					OrpltpStaFuncDO stafuncDO = (OrpltpStaFuncDO) obj;
					stafuncDO.setId_grp(Context.get().getGroupId());// 集团
					stafuncDO.setId_org(Context.get().getOrgId());// 组织
					stafuncDO.setId_orpltp(orpltpDO.getId_orpltp());// 闭环
					stafuncDO.setSd_orpltp(orpltpDO.getCode());// 闭环ID
					stafuncDO.setId_orpltpsta(staDO.getId_orpltpsta());// 闭环状态ID
					stafuncDO.setSd_orpltpsta(staDO.getCode());// 闭环状态编码
					toBeSaveFuncList.add(stafuncDO);
				}
			}
			
			//
		}

		// 保存状态对照
		if (toBeSaveMapList.size() > 0) {
			saveOrpltpStaMap(toBeSaveMapList);
		}
		// 保存功能对照
		if (toBeSaveFuncList.size() > 0) {
			saveOrpltpStaFunc(toBeSaveFuncList);
		}
	}

	/**
	 * 状态对照保存
	 * 
	 * @param orpltpStaDTO
	 * @throws BizException
	 */
	private void saveOrpltpStaMap(List<OrpltpStaMapDO> listMaps) throws BizException {
		if (listMaps != null && listMaps.size() > 0) {
			IOrpltpstamspCudService saveService = ServiceFinder.find(IOrpltpstamspCudService.class);
			OrpltpStaMapDO[] mapdo = listMaps.toArray(new OrpltpStaMapDO[listMaps.size()]);
			saveService.save(mapdo);
		}
	}

	/**
	 * 功能对照保存
	 * 
	 * @param orpltpStaDTO
	 * @throws BizException
	 */
	private void saveOrpltpStaFunc(List<OrpltpStaFuncDO> listFunc) throws BizException {
		if (listFunc != null && listFunc.size() > 0) {
			IOrpltpstafuncCudService saveService = ServiceFinder.find(IOrpltpstafuncCudService.class);
			saveService.save(listFunc.toArray(new OrpltpStaFuncDO[listFunc.size()]));
		}
	}
}
