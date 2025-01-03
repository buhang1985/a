package iih.ci.ord.s.bp.ordprn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;
import org.eclipse.persistence.jpa.rs.util.ResourceLocalTransactionWrapper;

import com.mysql.jdbc.StringUtils;

import xap.mw.sf.core.util.ServiceFinder;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.ordprn.d.OrdPrintDO;
import iih.ci.ord.ordprn.dto.d.CiOrdSheetParamDTO;
import iih.ci.ord.ordprn.i.IOrdprintCudService;
import iih.ci.ord.ordprn.i.IOrdprintExtService;
import iih.ci.ord.ordprn.i.IOrdprintRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.ordprn.qry.GetOrdInfo8IdorQry;
import iih.mp.nr.i.IMpNrMaintanceService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱单打印数据保存
 * @author Young
 *
 */
public class SaveOrdPrintDOsBP {

	/**
	 * 四种打印场景需要保存打印数据
	 * 1、一般续打：1>已经打印过的医嘱数据（存在于ci_or_prn），是需要补打作废信息或停止信息的数据；
	 *          2>未打印数据（不存在于ci_or_prn），需要创建OrdPrintDO对象（根据fg_chk_canc/fg_chk_stop，判断是否打印作废或停止标识），保存新增数据；
	 * 2、重整打印：1>已经打印过的医嘱数据（存在于ci_or_prn），重整标识fg_reformed置为Y；
	 *          2>重整标记行，重整标记行标识fg_reformrow置为Y，id_or为空；
	 *          3>未打印数据（不存在于ci_or_prn），需要创建OrdPrintDO对象（根据fg_chk_canc/fg_chk_stop，判断是否打印作废或停止标识），保存新增数据。
	 * 3、撤销打印：1>已经打印过的医嘱数据，fg_chk_canc/fg_canc_prn置为Y；
	 * 4、停止打印：1>已经打印过的医嘱数据，fg_chk_stop/fg_stop_prn置为Y；
	 * @param paramDTO
	 * @param saveDatas
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(CiOrdSheetParamDTO paramDTO, OrdPrintDataDTO[] saveDatas) throws BizException {
		FDateTime serverTime = CiOrdAppUtils.getServerDateTime();
		List<OrdPrintDO> prnDOList = new ArrayList<>();
		if ("1".equals(paramDTO.getPrint_mode())) {
			prnDOList = this.saveContinuePrintData(paramDTO, saveDatas, serverTime);
		} else if ("2".equals(paramDTO.getPrint_mode())) {
			prnDOList = this.saveReformPrintData(paramDTO, saveDatas, serverTime);
		} else if ("3".equals(paramDTO.getPrint_mode())) {
			prnDOList = this.saveCancelPrintData(saveDatas);
		} else if ("4".equals(paramDTO.getPrint_mode())) {
			prnDOList = this.saveStopPrintData(saveDatas);
		}
		//调用执行域接口
		OrdPrintUtils.execMPService(prnDOList, FBoolean.TRUE);
		return FBoolean.TRUE;
	}
	
	/**
	 * 保存一般续打医嘱数据
	 * @param paramDTO
	 * @param saveDatas
	 * @param serverTime
	 * @throws BizException
	 */
	private List<OrdPrintDO> saveContinuePrintData(CiOrdSheetParamDTO paramDTO, OrdPrintDataDTO[] saveDatas, FDateTime serverTime) 
			throws BizException {
		// 前台传入打印成功的医嘱数据
		Map<String, OrdPrintDataDTO> mapSaveDatas = new HashMap<String, OrdPrintDataDTO>();
		List<String> idors = new ArrayList<String>();
		for (OrdPrintDataDTO saveData : saveDatas) {
			if (!mapSaveDatas.containsKey(saveData.getId_orsrv_key())) {
				mapSaveDatas.put(saveData.getId_orsrv_key(), saveData);
			}
			if(!StringUtils.isNullOrEmpty(saveData.getId_or()) && !idors.contains(saveData.getId_or())) {
				idors.add(saveData.getId_or());
			}
		}
		// 已打印医嘱ID
		OrdPrintDO[] ordPrintDOs = this.getOrdPrintDOs8Idors(idors.toArray(new String[0]));
		List<String> idors_prned = new ArrayList<String>();
		if (ordPrintDOs != null && ordPrintDOs.length > 0) {
			for (OrdPrintDO ordPrintDO : ordPrintDOs) {
				if (!idors_prned.contains(ordPrintDO.getId_or())) {
					idors_prned.add(ordPrintDO.getId_or());
				}
			}
		}
		// 查询医嘱信息
		GetOrdInfo8IdorQry qry = new GetOrdInfo8IdorQry(idors.toArray(new String[0]));
		OrdPrintDataDTO[] ordPrintDataDTOs = (OrdPrintDataDTO[])AppFwUtil.getDORstWithDao(qry, OrdPrintDataDTO.class);
		OrdPrintDO[] prnDOs = null;
		if (ordPrintDataDTOs != null && ordPrintDataDTOs.length > 0) {
			List<OrdPrintDO> lstNew = new ArrayList<OrdPrintDO>();
			for(OrdPrintDataDTO ordPrintDTO : ordPrintDataDTOs) {
				if (!idors_prned.contains(ordPrintDTO.getId_or())) {
					String id_orsrv_key = ordPrintDTO.getId_or() + "," + ordPrintDTO.getId_srv() + "," + ordPrintDTO.getSortno();
					if(mapSaveDatas.containsKey(id_orsrv_key)) {
						// 新增医嘱单数据创建
						lstNew.add(this.getOrdPrintDONew(paramDTO, mapSaveDatas.get(id_orsrv_key), ordPrintDTO, serverTime));
					}
				}
			}
			
			if (lstNew != null && !lstNew.isEmpty()) {
				// 保存新增医嘱单数据
				prnDOs = ServiceFinder.find(IOrdprintCudService.class).save(lstNew.toArray(new OrdPrintDO[0]));
			}
			
		}
		return Arrays.asList(prnDOs);
	}
	
	/**
	 * 保存重整打印医嘱数据
	 * @param paramDTO
	 * @param saveDatas
	 * @param serverTime
	 * @throws BizException
	 */
	private List<OrdPrintDO> saveReformPrintData(CiOrdSheetParamDTO paramDTO, OrdPrintDataDTO[] saveDatas, FDateTime serverTime) 
			throws BizException {
		// 前台传入打印成功的医嘱数据
		Map<String, OrdPrintDataDTO> mapSaveDatas = new HashMap<String, OrdPrintDataDTO>();
		List<String> idors = new ArrayList<String>();
		for (OrdPrintDataDTO saveData : saveDatas) {
			if (!mapSaveDatas.containsKey(saveData.getId_orsrv_key())) {
				mapSaveDatas.put(saveData.getId_orsrv_key(), saveData);
			}
			if(!StringUtils.isNullOrEmpty(saveData.getId_or()) && !idors.contains(saveData.getId_or())) {
				idors.add(saveData.getId_or());
			}
		}
		// 查询医嘱信息
		GetOrdInfo8IdorQry qry = new GetOrdInfo8IdorQry(idors.toArray(new String[0]));
		OrdPrintDataDTO[] ordPrintDataDTOs = (OrdPrintDataDTO[])AppFwUtil.getDORstWithDao(qry, OrdPrintDataDTO.class);
		OrdPrintDO[] printDOs = null;
		if (ordPrintDataDTOs != null && ordPrintDataDTOs.length > 0) {
			List<OrdPrintDO> lstNew = new ArrayList<OrdPrintDO>();
			for(OrdPrintDataDTO ordPrintDTO : ordPrintDataDTOs) {
				String id_orsrv_key = ordPrintDTO.getId_or() + "," + ordPrintDTO.getId_srv() + "," + ordPrintDTO.getSortno();
				if(mapSaveDatas.containsKey(id_orsrv_key)) {
					// 新增医嘱单数据创建
					lstNew.add(this.getOrdPrintDONew(paramDTO, mapSaveDatas.get(id_orsrv_key), ordPrintDTO, serverTime));
				}
			}
			// 新增医嘱单数据重整标记行创建
			if (mapSaveDatas.containsKey("reformrow_key")) {
				lstNew.add(this.getOrdPrintDOReformrow(paramDTO, mapSaveDatas.get("reformrow_key"), serverTime));
			}
			// 更新以前打印数据的重整标识
			OrdPrintDO[] ordPrintDOs = this.getOrdPrintDOs8Iden(paramDTO.getId_en(), paramDTO.getId_ordsheet());
			if (ordPrintDOs != null && ordPrintDOs.length > 0) {
				for (OrdPrintDO ordPrintDO : ordPrintDOs) {
					ordPrintDO.setFg_reformed(FBoolean.TRUE);
					ordPrintDO.setDt_reform(serverTime);
				}
				new DAFacade().updateDOArray(ordPrintDOs, new String[] { OrdPrintDO.FG_REFORMED, OrdPrintDO.DT_REFORM });
			}
			
			if (lstNew != null && !lstNew.isEmpty()) {
				printDOs = ServiceFinder.find(IOrdprintCudService.class).save(lstNew.toArray(new OrdPrintDO[0]));
			}
		}
		return Arrays.asList(printDOs);
	}
	
	/**
	 * 保存作废打印医嘱数据
	 * @param saveDatas
	 * @throws BizException
	 */
	private List<OrdPrintDO> saveCancelPrintData(OrdPrintDataDTO[] saveDatas)
			throws BizException {
		List<String> idors = new ArrayList<String>();
		for (OrdPrintDataDTO saveData : saveDatas) {
			if(!StringUtils.isNullOrEmpty(saveData.getId_or()) && !idors.contains(saveData.getId_or())) {
				idors.add(saveData.getId_or());
			}
		}
		// 查询医嘱信息
		GetOrdInfo8IdorQry qry = new GetOrdInfo8IdorQry(idors.toArray(new String[0]));
		OrdPrintDataDTO[] ordPrintDataDTOs = (OrdPrintDataDTO[]) AppFwUtil.getDORstWithDao(qry, OrdPrintDataDTO.class);
		Map<String, FBoolean> map = new HashMap<String, FBoolean>();
		if (ordPrintDataDTOs != null && ordPrintDataDTOs.length > 0) {
			for (OrdPrintDataDTO ordPrintDataDTO : ordPrintDataDTOs) {
				if (!map.containsKey(ordPrintDataDTO.getId_or())) {
					map.put(ordPrintDataDTO.getId_or(), ordPrintDataDTO.getFg_chk_canc());
				}
			}
		}
		OrdPrintDO[] ordPrintDOs = this.getOrdPrintDOs8Idors(idors.toArray(new String[0]));
		List<OrdPrintDO> lst = new ArrayList<OrdPrintDO>();
		if (ordPrintDOs != null && ordPrintDOs.length > 0) {
			for(OrdPrintDO ordPrintDO : ordPrintDOs) {
				if(!FBoolean.TRUE.equals(ordPrintDO.getFg_canc_prn()) && map.get(ordPrintDO.getId_or()).isValue()) {
					ordPrintDO.setFg_canc_prn(FBoolean.TRUE);
					lst.add(ordPrintDO);
				}
			}
			if(!lst.isEmpty()) {
				new DAFacade().updateDOArray(lst.toArray(new OrdPrintDO[0]), new String[] { OrdPrintDO.FG_CANC_PRN });
			}
		}
		return lst;
	}
	
	/**
	 * 保存停止打印医嘱数据
	 * @param saveDatas
	 * @throws BizException
	 */
	private List<OrdPrintDO> saveStopPrintData(OrdPrintDataDTO[] saveDatas)
			throws BizException {
		List<String> idors = new ArrayList<String>();
		for (OrdPrintDataDTO saveData : saveDatas) {
			if(!StringUtils.isNullOrEmpty(saveData.getId_or()) && !idors.contains(saveData.getId_or())) {
				idors.add(saveData.getId_or());
			}
		}
		// 查询医嘱信息
		GetOrdInfo8IdorQry qry = new GetOrdInfo8IdorQry(idors.toArray(new String[0]));
		OrdPrintDataDTO[] ordPrintDataDTOs = (OrdPrintDataDTO[]) AppFwUtil.getDORstWithDao(qry, OrdPrintDataDTO.class);
		Map<String, FBoolean> map = new HashMap<String, FBoolean>();
		if (ordPrintDataDTOs != null && ordPrintDataDTOs.length > 0) {
			for (OrdPrintDataDTO ordPrintDataDTO : ordPrintDataDTOs) {
				if (!map.containsKey(ordPrintDataDTO.getId_or())) {
					map.put(ordPrintDataDTO.getId_or(), ordPrintDataDTO.getFg_chk_stop());
				}
			}
		}
		OrdPrintDO[] ordPrintDOs = this.getOrdPrintDOs8Idors(idors.toArray(new String[0]));
		
		OrdPrintDO[] prnDOs = null;
		List<OrdPrintDO> lst = new ArrayList<OrdPrintDO>();
		if (ordPrintDOs != null && ordPrintDOs.length > 0) {
			for(OrdPrintDO ordPrintDO : ordPrintDOs) {
				if(!FBoolean.TRUE.equals(ordPrintDO.getFg_stop_prn()) && map.get(ordPrintDO.getId_or()).isValue()) {
					ordPrintDO.setFg_stop_prn(FBoolean.TRUE);
					lst.add(ordPrintDO);
				}
			}
			if(!lst.isEmpty()) {
				new DAFacade().updateDOArray(lst.toArray(new OrdPrintDO[0]), new String[] { OrdPrintDO.FG_STOP_PRN });
			}
		}
		return lst;
	}
	
	/**
	 * 创建新的医嘱单数据
	 * @param paramDTO
	 * @param saveData
	 * @param ordPrintDTO
	 * @param serverTime
	 * @return
	 */
	private OrdPrintDO getOrdPrintDONew(CiOrdSheetParamDTO paramDTO, OrdPrintDataDTO saveData, OrdPrintDataDTO ordPrintDTO, FDateTime serverTime) {
		OrdPrintDO ordPrintDO = new OrdPrintDO();
		ordPrintDO.setId_ordsheet(paramDTO.getId_ordsheet());
		ordPrintDO.setName_orprn(paramDTO.getName_ordsheet());
		ordPrintDO.setPage_num(saveData.getPage_num());
		ordPrintDO.setRow_num(saveData.getRow_num());
		ordPrintDO.setRow_cnt(saveData.getRow_cnt());
		ordPrintDO.setFg_reformrow(FBoolean.FALSE);
		ordPrintDO.setFg_reformed(FBoolean.FALSE);

		ordPrintDO.setId_grp(saveData.getId_grp());
		ordPrintDO.setId_org(saveData.getId_org());
		ordPrintDO.setId_dep_prn(saveData.getId_dep_prn());
		ordPrintDO.setId_emp_prn(saveData.getId_emp_prn());
		ordPrintDO.setDt_prn(serverTime);
		ordPrintDO.setId_en(paramDTO.getId_en());
		ordPrintDO.setId_pat(paramDTO.getId_pat());
		ordPrintDO.setName_pat_en(paramDTO.getName_pat());
		ordPrintDO.setId_or(saveData.getId_or());
		ordPrintDO.setId_srv(saveData.getId_srv());
		ordPrintDO.setSortno(saveData.getSortno());
		ordPrintDO.setFg_long(paramDTO.getFg_long());
		ordPrintDO.setSd_srvtp(ordPrintDTO.getSd_srvtp());
		ordPrintDO.setFg_chk_canc(ordPrintDTO.getFg_chk_canc());
		ordPrintDO.setFg_canc_prn(ordPrintDTO.getFg_chk_canc());
		ordPrintDO.setFg_chk_stop(ordPrintDTO.getFg_chk_stop());
		ordPrintDO.setFg_stop_prn(ordPrintDTO.getFg_chk_stop());
		ordPrintDO.setFg_skin_prn(ordPrintDTO.getFg_skintest_rst());
		ordPrintDO.setStatus(DOStatus.NEW);
		return ordPrintDO;
	}
	
	/**
	 * 创建重整标记行数据
	 * @param paramDTO
	 * @param saveData_reformrow
	 * @param serverTime
	 * @return
	 */
	private OrdPrintDO getOrdPrintDOReformrow(CiOrdSheetParamDTO paramDTO, OrdPrintDataDTO saveData_reformrow, FDateTime serverTime) {
		OrdPrintDO ordPrintDO = new OrdPrintDO();
		ordPrintDO.setId_ordsheet(paramDTO.getId_ordsheet());
		ordPrintDO.setName_orprn(paramDTO.getName_ordsheet());
		ordPrintDO.setPage_num(saveData_reformrow.getPage_num());
		ordPrintDO.setRow_num(saveData_reformrow.getRow_num());
		ordPrintDO.setRow_cnt(saveData_reformrow.getRow_cnt());
		ordPrintDO.setFg_reformrow(FBoolean.TRUE);
		ordPrintDO.setFg_reformed(FBoolean.FALSE);
		
		ordPrintDO.setId_grp(saveData_reformrow.getId_grp());
		ordPrintDO.setId_org(saveData_reformrow.getId_org());
		ordPrintDO.setId_dep_prn(saveData_reformrow.getId_dep_prn());
		ordPrintDO.setId_emp_prn(saveData_reformrow.getId_emp_prn());
		ordPrintDO.setDt_prn(serverTime);
		ordPrintDO.setId_en(paramDTO.getId_en());
		ordPrintDO.setId_pat(paramDTO.getId_pat());
		ordPrintDO.setName_pat_en(paramDTO.getName_pat());
		ordPrintDO.setFg_long(paramDTO.getFg_long());
		ordPrintDO.setStatus(DOStatus.NEW);
		return ordPrintDO;
	}
	
	/**
	 * 查询已打印的医嘱单数据
	 * @param saveDatas
	 * @return
	 * @throws BizException
	 */
	private OrdPrintDO[] getOrdPrintDOs8Idors(String[] idors)
			throws BizException {
		StringBuilder stridors = new StringBuilder();
		for (String idor : idors) {
			stridors.append(String.format(",'%s'", idor));
		}
		if(!StringUtils.isNullOrEmpty(idors.toString())) {
			OrdPrintDO[] ordPrintDOs = ServiceFinder.find(IOrdprintRService.class)
					.find(String.format("id_or in (%s) and ds<1 and fg_reformed='N'", stridors.substring(1)), "", FBoolean.FALSE);
			return ordPrintDOs;
		}
		return null;
	}
	
	/**
	 * 查询就诊下已打印的医嘱单数据
	 * @param id_en
	 * @param id_ordsheet
	 * @return
	 * @throws BizException
	 */
	private OrdPrintDO[] getOrdPrintDOs8Iden(String id_en, String id_ordsheet)
			throws BizException {
		OrdPrintDO[] ordPrintDOs = ServiceFinder.find(IOrdprintRService.class)
				.find(String.format("id_en='%s' and id_ordsheet='%s' and ds<1 and fg_reformed='N'", id_en, id_ordsheet), "", FBoolean.FALSE);
		return ordPrintDOs;
	}
}
