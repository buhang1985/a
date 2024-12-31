package iih.bd.pp.hpsrvorca.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.bdhpsrvctr.d.BdHpSrvctrDO;
import iih.bd.pp.bdhpsrvctr.i.IBdhpsrvctrCudService;
import iih.bd.pp.bdhpsrvctr.i.IBdhpsrvctrRService;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.d.HpmmreltpEnum;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bd.pp.hpsrvorca.bp.sql.HpSrvctrSql;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import iih.bd.pp.hpsrvorca.d.ImportDTO;
import iih.bd.pp.hpsrvorca.d.ImportResultEnum;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaCudService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

public class HpSrvOrCaBp {

	/**
	 * 获取服务医保对照信息
	 */
	@SuppressWarnings("unchecked")
	public HPSrvorcaDO[] getHpSrvOrCaInfo() throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select s.id_srv,s.code as srv_code,s.name as srv_name, h.code, h.name, s.id_unit_med as id_unid, d.name as measdoc_name, h.pri_max, u.name as hpsrvtp_name, h.name_ca, h.des,");
		sql.append("s.sd_srvtp,s.fg_bl ");
		sql.append("from bd_srv s ");
		sql.append("left join bd_hp_srvorca h on s.id_srv = h.id_srv  ");
		sql.append("left join bd_measdoc d on s.id_unit_med = d.id_measdoc ");
		sql.append("left join bd_udidoc u on h.id_hpsrvtp = u.id_udidoc ");
		sql.append("where s.fg_mm = 'N' and s.fg_bl = 'Y' ");
		sql.append("union  ");
		sql.append(
				"select s.id_srv,s.code as srv_code,s.name as srv_name, h.code, h.name, m.id_unit_pkgbase, d.name as measdoc_name, h.pri_max, u.name as hpsrvtp_name, h.name_ca, h.des,");
		sql.append("s.sd_srvtp,s.fg_bl ");
		sql.append("from bd_srv s ");
		sql.append("left join bd_hp_srvorca h on s.id_srv = h.id_srv ");
		// 不要bd_srv_rel_mm这个表了
		// sql.append("left join bd_srv_rel_mm r on s.id_srv = r.id_srv ");
		sql.append("left join bd_mm m on s.id_srv = m.id_srv  ");
		sql.append("left join bd_measdoc d on m.id_unit_pkgbase = d.id_measdoc ");
		sql.append("left join bd_udidoc u on h.id_hpsrvtp = u.id_udidoc ");
		sql.append("where s.fg_mm = 'Y' and s.fg_bl = 'Y';");

		List<HPSrvorcaDO> list = (List<HPSrvorcaDO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(HPSrvorcaDO.class));
		return list.toArray(new HPSrvorcaDO[] {});
	}

	/**
	 * 保存医保目录对照数据
	 * 
	 * @param hpSrvOrCaDOArr
	 * @throws BizException
	 */
	public FBoolean saveHpSrvOrCaInfo(HPSrvorcaDO[] hpSrvOrCaDOArr) throws BizException {
		try {
			// 清空关系表
			String trunsql = "DELETE FROM BD_HP_SRVORCA";
			new DAFacade().execUpdate(trunsql);

			// 保存医保目录对照数据
			if (hpSrvOrCaDOArr != null && hpSrvOrCaDOArr.length > 0) {
				IHpsrvorcaCudService service = ServiceFinder.find(IHpsrvorcaCudService.class);
				service.save(hpSrvOrCaDOArr);
			}
		} catch (BizException e) {
			throw new BizException("保存医保目录对照数据失败！");
		}

		return FBoolean.TRUE;
	}

	public ImportDTO[] ImportHPSrvorca(String id_hp, String importData, Boolean fg_drug) throws BizException {
		// HPSrvorcaDO[] hpSrvorcaDoList = getHpSrvorcaDoList(fg_drug);

		ArrayList<ImportDTO> importResult = new ArrayList<ImportDTO>();

		// 查询北京医保计划对应的医保物品对照类型
		// 暂时北京医保用ID进行查询
		int eu_hpmmRelTp = GetEuHpMmRelTp(id_hp);

		// 导入信息转换为DO
		String[] tokens = importData.split("\n|\r");
		ImportDTOAdapter adapter = new ImportDTOAdapter();
		HpSrvOrCaRepeatDataValidateBp repeatDataValidateBp = new HpSrvOrCaRepeatDataValidateBp();
		HashMap<String, ImportDTO> importDataHashMap = new HashMap<String, ImportDTO>();
		for (String token : tokens) {
			if (StringUtils.isBlank(token))
				continue;
			ImportDTO importDTO = adapter.GetImportDTO(token, fg_drug, eu_hpmmRelTp);

			// 进行数据对照
			// comparisonHPSrvorca(importDTO, hpSrvorcaDoList);
			repeatDataValidateBp.exec(importDataHashMap, importDTO);
			importResult.add(importDTO);
		}

		// 填充其他信息
		completionImportDTOList(importResult, id_hp, fg_drug);

		return importResult.toArray(new ImportDTO[] {});
	}

	/**
	 * 获取物品列表
	 * 
	 * @param fg_drug
	 *            药品导入标识
	 * @param eu_hpmmRelTp
	 *            医保物品对照类型
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private HashMap<String, MeterialDO> getMaterialMapByCode() throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(
				" SELECT BD_MM.ID_MM, BD_MM.ID_SRV, BD_MM.CODE, BD_MM.NAME, BD_MM.SPEC, BD_MM.ID_UNIT_PKGBASE, BD_MM.PRICE, BD_SRV.CODE AS SRV_CODE,");
		sql.append(
				" BD_SRV.NAME AS SRV_NAME, BD_SRV.ID_UNIT_MED AS SRV_ID_UNIT_MED, BD_MEASDOC.CODE AS PKGBASE_CODE, BD_MEASDOC.NAME AS PKGBASE_NAME");
		sql.append(" FROM BD_MM ");
		sql.append(" LEFT JOIN BD_SRV ");
		sql.append(" ON BD_MM.ID_SRV = BD_SRV.ID_SRV ");
		sql.append(" LEFT JOIN BD_MEASDOC ");
		sql.append(" ON BD_MEASDOC.ID_MEASDOC = BD_MM.ID_UNIT_PKGBASE ");
		sql.append(String.format(" where bd_mm.id_grp = '%s' ", Context.get().getGroupId()));
		sql.append(String.format(" and bd_mm.id_org = '%s' ", Context.get().getOrgId()));

		List<MeterialDO> list = (List<MeterialDO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(MeterialDO.class));

		HashMap<String, MeterialDO> materialMap = new HashMap<String, MeterialDO>();
		if (list != null && list.size() > 0) {
			for (MeterialDO meterialDO : list) {
				materialMap.put(meterialDO.getCode(), meterialDO);
			}
		}

		return materialMap;
	}

	/**
	 * 获取医保物品对照类型
	 * 
	 * @param idhp
	 *            医保计划
	 * @return
	 * @throws BizException
	 */
	private int GetEuHpMmRelTp(String id_hp) throws BizException {
		IHpMDORService hpMdoRService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpdo = hpMdoRService.findById(id_hp);
		if (hpdo == null)
			throw new BizException(String.format("医保计划为空.\n医保计划Id:%s。", id_hp));
		if (hpdo.getEu_hpmmreltp() == null) {
			return HpmmreltpEnum.BD_SRV_CODE_TYPE;
		}
		return hpdo.getEu_hpmmreltp();
	}

	/**
	 * 补全导入的医保目录对照信息 设置关联字段
	 * 
	 * @param diffDataList
	 *            差异列表
	 * @param fg_drug
	 *            药品标识
	 * @throws BizException
	 */
	private void completionImportDTOList(ArrayList<ImportDTO> importDtoList, String id_hp, Boolean fg_drug)
			throws BizException {
		HashMap<String, MedSrvDO> medSrvMapByCode = getMedSrvMapByCode();
		UdidocDO[] udidocDOList = getHpsrvtpList();
		HashMap<String, MeterialDO> materialMapByCode = null;
		if (fg_drug) {
			// 查询物品信息
			materialMapByCode = getMaterialMapByCode();
		}
		for (ImportDTO importDTO : importDtoList) {
			completionHPSrvorcaDO(importDTO, id_hp, fg_drug, udidocDOList, medSrvMapByCode, materialMapByCode);
		}
	}

	/**
	 * 补充对照信息中的药品信息
	 * 
	 * @param importDTO
	 * @param meterialDOArray
	 * @param udidocDOList
	 */
	private void CompletionHPSrvorcaDO_Meterial(ImportDTO importDTO, HashMap<String, MeterialDO> materialMapByCode) {
		HPSrvorcaDO hpSrvorcaDO = GetHpSrvorcaDO(importDTO);
		if (hpSrvorcaDO == null) {
			return;
		}

		if (!materialMapByCode.containsKey(hpSrvorcaDO.getHis_code())) {
			importDTO.setResult(ImportResultEnum.MMNOTFOUND);
			return;
		}

		MeterialDO meterialDO = materialMapByCode.get(hpSrvorcaDO.getHis_code());
		hpSrvorcaDO.setId_mm(meterialDO.getId_mm());
		hpSrvorcaDO.setHis_code(meterialDO.getCode());
		hpSrvorcaDO.setHis_name(meterialDO.getName());
		hpSrvorcaDO.setId_srv(meterialDO.getId_srv());
	}

	/**
	 * 补充对照信息中的服务信息
	 * 
	 * @param importDTO
	 * @param medSrvDOList
	 * @param udidocDOList
	 */
	private void CompletionHPSrvorcaDO_MedSrv(ImportDTO importDTO, HashMap<String, MedSrvDO> medSrvMapByCode) {
		HPSrvorcaDO hpSrvorcaDO = GetHpSrvorcaDO(importDTO);
		if (hpSrvorcaDO == null) {
			return;
		}

		if (!medSrvMapByCode.containsKey(hpSrvorcaDO.getHis_code())) {
			importDTO.setResult(ImportResultEnum.SRVNOTFOUND);
			return;
		}

		MedSrvDO medSrvDO = medSrvMapByCode.get(hpSrvorcaDO.getHis_code());
		hpSrvorcaDO.setId_srv(medSrvDO.getId_srv());
		hpSrvorcaDO.setHis_code(medSrvDO.getCode());
		hpSrvorcaDO.setHis_name(medSrvDO.getName());
	}

	/**
	 * 补全导入的医保目录对照信息 设置关联字段
	 * 
	 * @param importDTO
	 *            导入的医保目录对照信息
	 * @param fg_drug
	 *            药品标识
	 * @param medSrvDOList
	 *            医疗服务列表
	 * @param udidocDOList
	 *            医保计划目录类型
	 */
	private void completionHPSrvorcaDO(ImportDTO importDTO, String id_hp, Boolean fg_drug, UdidocDO[] udidocDOList,
			HashMap<String, MedSrvDO> medSrvMapByCode, HashMap<String, MeterialDO> materialMapByCode) {
		// if (importDTO.getResult() != null
		// && importDTO.getResult() != ImportResultEnum.DIFF) {
		// return;
		// }
		if (importDTO.getResult() != null && importDTO.getResult() == ImportResultEnum.IMPORTDATAERROR) {
			// 导入数据错误时，没有进行数据适配，不需要进行数据补全
			return;
		}

		if (fg_drug) {
			CompletionHPSrvorcaDO_Meterial(importDTO, materialMapByCode);
		} else {
			CompletionHPSrvorcaDO_MedSrv(importDTO, medSrvMapByCode);
		}
		CompletionHPSrvorcaDO_HpSrvTp(importDTO, udidocDOList);
		CompletionHPSrvorcaDO_IdHp(importDTO, id_hp);
	}

	/**
	 * 补全医保计划ID
	 * 
	 * @param importDTO
	 * @param id_hp
	 */
	private void CompletionHPSrvorcaDO_IdHp(ImportDTO importDTO, String id_hp) {
		HPSrvorcaDO hpSrvorcaDO = GetHpSrvorcaDO(importDTO);
		if (hpSrvorcaDO == null) {
			return;
		}
		hpSrvorcaDO.setId_hp(id_hp);
	}

	/**
	 * 补充医保目录对照中的通用医保计划目录类型
	 * 
	 * @param importDTO
	 * @param udidocDOList
	 */
	private void CompletionHPSrvorcaDO_HpSrvTp(ImportDTO importDTO, UdidocDO[] udidocDOList) {
		HPSrvorcaDO hpSrvorcaDO = GetHpSrvorcaDO(importDTO);
		if (hpSrvorcaDO == null) {
			return;
		}
		UdidocDO udidocDO = findByUdidocCode(udidocDOList, hpSrvorcaDO.getSd_hpsrvtp());
		if (udidocDO == null) {
			importDTO.setResult(ImportResultEnum.HPSRVTPNOTFOUND);
			return;
		}
		hpSrvorcaDO.setId_hpsrvtp(udidocDO.getId_udidoc());
		hpSrvorcaDO.setSd_hpsrvtp(udidocDO.getCode());
		hpSrvorcaDO.setHpsrvtp_name(udidocDO.getName());
	}

	/**
	 * 从ImportDto中获取对照信息
	 * 
	 * @param importDTO
	 * @return
	 */
	private HPSrvorcaDO GetHpSrvorcaDO(ImportDTO importDTO) {
		FArrayList arrayList = importDTO.getHpsrvorca();
		if (arrayList == null || arrayList.size() <= 0) {
			return null;
		}
		HPSrvorcaDO hpSrvorcaDO = (HPSrvorcaDO) arrayList.get(0);
		return hpSrvorcaDO;
	}

	/**
	 * 根据通用医保计划目录类型编码查找医保计划目录类型
	 * 
	 * @param udidocDOList
	 *            医保计划目录类型列表
	 * @param sd_hpsrvtp
	 *            医保计划目录类型编码
	 * @return
	 */
	private UdidocDO findByUdidocCode(UdidocDO[] udidocDOList, String sd_hpsrvtp) {
		for (UdidocDO udidocDO : udidocDOList) {
			if (udidocDO.getCode().equals(sd_hpsrvtp)) {
				return udidocDO;
			}
		}
		return null;
	}

	/**
	 * 获取通用医保目录计划类型
	 * 
	 * @return 通用医保目录计划类型列表
	 * @throws BizException
	 */
	private UdidocDO[] getHpsrvtpList() throws BizException {
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] hpsrvtpList = udidocServiceExt.findByUdidoclistCode(IBdPpCodeTypeConst.SD_HPSRVTP);
		return hpsrvtpList;
	}

	/**
	 * 获取医疗服务列表
	 * 
	 * @param fg_drug
	 *            药品标识
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, MedSrvDO> getMedSrvMapByCode() throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select s.id_srv,s.code,s.name,s.id_srvca,s.sd_srvtp,s.id_unit_med,d.name as med_name ");
		sql.append("from bd_srv s ");
		sql.append("left join bd_measdoc d on s.id_unit_med = d.id_measdoc ");
		// sql.append(String.format("where s.id_grp = '%s' and s.id_org = '%s'",
		// Context.get().getGroupId(),Context.get().getOrgId()));
		@SuppressWarnings("unchecked")
		List<MedSrvDO> list = (List<MedSrvDO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(MedSrvDO.class));

		HashMap<String, MedSrvDO> medSrvMap = new HashMap<String, MedSrvDO>();
		if (list != null && list.size() > 0) {
			for (MedSrvDO medSrvDO : list) {
				medSrvMap.put(medSrvDO.getCode(), medSrvDO);
			}
		}

		return medSrvMap;
	}

	/**
	 * 获取医保目录对照数据列表
	 * 
	 * @param fg_drug
	 *            药品标识
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private HPSrvorcaDO[] getHpSrvorcaDoList(Boolean fg_drug) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select s.id_srv,s.code as srv_code,s.name as srv_name, h.code, h.name  ");
		sql.append(", s.id_unit_med as id_unid, d.name as measdoc_name, h.pri_max, u.name as hpsrvtp_name ");
		sql.append(", h.name_ca, h.des, s.sd_srvtp,s.fg_bl, h.sd_hpsrvtp, h.code_ca ");
		sql.append("from bd_hp_srvorca h ");
		sql.append("left join bd_srv s on s.id_srv = h.id_srv  ");
		sql.append("left join bd_measdoc d on s.id_unit_med = d.id_measdoc ");
		sql.append("left join bd_udidoc u on h.id_hpsrvtp = u.id_udidoc ");
		sql.append("where s.fg_mm = 'N' and s.fg_bl = 'Y' ");
		sql.append("union  ");
		sql.append("select s.id_srv,s.code as srv_code,s.name as srv_name, h.code, h.name ");
		sql.append(", m.id_unit_pkgbase, d.name as measdoc_name, h.pri_max, u.name as hpsrvtp_name ");
		sql.append(", h.name_ca, h.des, s.sd_srvtp,s.fg_bl, h.sd_hpsrvtp, h.code_ca ");
		sql.append("from bd_hp_srvorca h ");
		sql.append("left join bd_srv s on s.id_srv = h.id_srv ");
		sql.append("left join bd_mm m on s.id_srv = m.id_srv  ");
		sql.append("left join bd_measdoc d on m.id_unit_pkgbase = d.id_measdoc ");
		sql.append("left join bd_udidoc u on h.id_hpsrvtp = u.id_udidoc ");
		sql.append("where s.fg_mm = 'Y' and s.fg_bl = 'Y';");
		List<HPSrvorcaDO> list = (List<HPSrvorcaDO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(HPSrvorcaDO.class));
		return list.toArray(new HPSrvorcaDO[] {});
	}

	/**
	 * 导出医保目录对照数据
	 * 
	 * @param fg_drug
	 * @return
	 * @throws BizException
	 */
	public String ExportHPSrvorca(Boolean fg_drug) throws BizException {
		HPSrvorcaDO[] exportDataList;
		if (fg_drug) {
			ExportDrugsInfoBp exportDrugsInfoBp = new ExportDrugsInfoBp();
			exportDataList = exportDrugsInfoBp.exec();
		} else {
			ExportMedicalInfoBp exportMedicalInfoBp = new ExportMedicalInfoBp();
			exportDataList = exportMedicalInfoBp.exec();
		}
		String fileData = serializationExportDataList(exportDataList, fg_drug);
		return fileData;
	}

	/**
	 * 序列化医保计划对照信息
	 * 
	 * @param exportDataList
	 * @param fg_drug
	 * @return
	 */
	private String serializationExportDataList(HPSrvorcaDO[] exportDataList, Boolean fg_drug) {
		StringBuilder stringBuilder = new StringBuilder();
		HPSrvorcaDOAdapter adapter = new HPSrvorcaDOAdapter();
		for (HPSrvorcaDO hpSrvorcaDO : exportDataList) {
			String seriaString = adapter.serialization(hpSrvorcaDO, fg_drug);
			stringBuilder.append(seriaString);
			stringBuilder.append("\r\n");
		}
		return stringBuilder.toString();
	}

	/**
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public PagingRtnData<HPSrvorcaDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereStr = qrySQLGeneratorService.getQueryStringWithDOName(qryRootNodeDTO, HPSrvorcaDO.class.getName());
		int pageSize = pg.getPageSize();
		int pageIndex = pg.getPageIndex();

		StringBuffer baseSql = new StringBuffer();

		baseSql.append("(SELECT H.id_grp,H.id_org,H.ID_HPSRVORCA,H.ID_HP,H.ID_SRV,  H.ID_MM, ");
		baseSql.append(
				" M.CODE AS HIS_CODE,  M.NAME AS HIS_NAME,  H.CODE, H.NAME, H.CODE_DOSAGE, D.NAME  AS MM_UNIT_PKGBASE,  M.PRICE AS MM_PRICE, ");
		baseSql.append(" U.NAME  AS HPSRVTP_NAME,  H.CODE_CA,  H.DES, H.ID_HPSRVTP,H.SV ");
		baseSql.append(" FROM BD_HP_SRVORCA H ");
		baseSql.append(" LEFT JOIN BD_MM M ");
		baseSql.append(" ON H.ID_MM = M.ID_MM ");
		baseSql.append(" LEFT JOIN BD_MEASDOC D ");
		baseSql.append(" ON M.ID_UNIT_PKGBASE = D.ID_MEASDOC ");
		baseSql.append(" LEFT JOIN BD_UDIDOC U ");
		baseSql.append(" ON H.ID_HPSRVTP = U.ID_UDIDOC ");
		baseSql.append(" WHERE H.ID_MM  IS NOT NULL ");
		baseSql.append(" AND H.ID_MM <> '~' ");
		baseSql.append("UNION  ");
		baseSql.append(
				" SELECT H.id_grp,H.id_org,H.ID_HPSRVORCA,H.ID_HP,H.ID_SRV,  H.ID_MM,  S.CODE AS HIS_CODE,  S.NAME AS HIS_NAME, ");
		baseSql.append(" H.CODE,  H.NAME, H.CODE_DOSAGE, NULL   AS MM_UNIT_PKGBASE,  NULL   AS MM_PRICE, ");
		baseSql.append(" U.NAME AS HPSRVTP_NAME,  H.CODE_CA,  H.DES, H.ID_HPSRVTP,H.SV ");
		baseSql.append(" FROM BD_HP_SRVORCA H ");
		baseSql.append(" LEFT JOIN BD_SRV S ");
		baseSql.append(" ON S.ID_SRV = H.ID_SRV ");
		baseSql.append(" LEFT JOIN BD_UDIDOC U ");
		baseSql.append(" ON H.ID_HPSRVTP = U.ID_UDIDOC ");
		baseSql.append(" WHERE H.ID_MM  IS NULL ");
		baseSql.append(" OR H.ID_MM = '~') ");

		StringBuffer sql = new StringBuffer();
		sql.append("( select * from ( ");
		sql.append("select rownum as rowno,a0.* from ");
		sql.append(baseSql);
		sql.append(String.format(" a0 where 1 = 1 %s and rownum <= %s ) T2",
				whereStr == null ? "" : String.format("and %s", whereStr), (pageIndex + 1) * pageSize));
		sql.append(String.format(" where T2.rowno >= %s )", pageIndex * pageSize + 1));

		List<HPSrvorcaDO> list = (List<HPSrvorcaDO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(HPSrvorcaDO.class));

		FArrayList pageData = new FArrayList();
		pageData.addAll(list);

		sql = new StringBuffer();
		sql.append("select count(*) as rowcount from ( select * from  ");
		sql.append(baseSql);
		sql.append(String.format(" a0 where 1 = 1 %s ) ", whereStr == null ? "" : String.format("and %s", whereStr)));
		int dataCount = (int) new DAFacade().execQuery(sql.toString(), new ColumnHandler("rowcount"));
		pg.setPageCount(dataCount / pageSize);
		pg.setRecordsCount(dataCount);
		PagingRtnData<HPSrvorcaDO> pagingRtnData = new PagingRtnData<HPSrvorcaDO>();
		pagingRtnData.setPageData(pageData);
		pagingRtnData.setPagingInfo(pg);
		return pagingRtnData;
	}

	/**
	 * 保存医保目录对照信息
	 * 
	 * @param hpSrvOrCaDOArr
	 * @param fg_drug
	 * @return
	 * @throws BizException
	 */
	public FBoolean SaveHPSrvorca(HPSrvorcaDO[] hpSrvOrCaDOArr, Boolean fg_drug) throws BizException {
		ClearHPSrvorcaData(fg_drug);
		for (HPSrvorcaDO hpSrvorcaDO : hpSrvOrCaDOArr) {
			hpSrvorcaDO.setId_hp(IBdPpCodeTypeConst.ID_HP_BJ_BASIC_MEDICAL_INSUR);
			hpSrvorcaDO.setStatus(DOStatus.NEW);
			hpSrvorcaDO.setEu_status(HpStatusEnum.REVIEW);
			if (fg_drug) {
				hpSrvorcaDO.setEu_hpsrvtp(HpSrvTpEnum.DRUG);
			} else {
				hpSrvorcaDO.setEu_hpsrvtp(HpSrvTpEnum.ZL);
			}
			if (hpSrvorcaDO.getDt_b() == null) {
				hpSrvorcaDO.setDt_b(new FDateTime("1900-01-01 00:00:00"));
			}
			if (hpSrvorcaDO.getDt_e() == null) {
				hpSrvorcaDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
			}
		}
		DAFacade daFacade = new DAFacade();
		daFacade.insertDOs(hpSrvOrCaDOArr);

		if (hpSrvOrCaDOArr != null && hpSrvOrCaDOArr.length > 0) {
			return SaveHPSrvCtr(hpSrvOrCaDOArr[0].getId_hp(), fg_drug ? HpSrvTpEnum.DRUG : HpSrvTpEnum.ZL);
		}

		return FBoolean.TRUE;
	}

	/**
	 * 保存付款策略表bd_hp_srvctr
	 * 
	 * @param id_hp
	 * @param eu_hpsrvtp
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FBoolean SaveHPSrvCtr(String id_hp, Integer eu_hpsrvtp) throws BizException {
		DAFacade daFacade = new DAFacade();
		HpSrvctrSql hpSrvctrSql = new HpSrvctrSql(id_hp, eu_hpsrvtp);
		ArrayList<HPSrvorcaDO> hpSrvorcaDOList = (ArrayList<HPSrvorcaDO>) daFacade.execQuery(hpSrvctrSql.getQrySQLStr(),
				hpSrvctrSql.getQryParameter(null), new BeanListHandler(HPSrvorcaDO.class));
		HPSrvorcaDO[] result = hpSrvorcaDOList.toArray(new HPSrvorcaDO[0]);
		if (result == null)
			return FBoolean.FALSE;
		// 对保存的医保目录对照数据生成医保计划_控制策略数据，,一条医保对照数据生成一条控制策略数据
		BuildHpSrvCtlBySrvOrCaBp buildHpSrvCtlBySrvOrCaBp = new BuildHpSrvCtlBySrvOrCaBp();
		buildHpSrvCtlBySrvOrCaBp.exec(result);
		return FBoolean.TRUE;
	}

	/**
	 * 清除旧的医保计划_控制策略数据
	 * 
	 * @throws DAException
	 */
	@SuppressWarnings("unused")
	private void ClearHpSrvctrData() throws DAException {
		StringBuilder sb = new StringBuilder();
		sb.append(" delete from bd_hp_srvctr    ");
		new DAFacade().execUpdate(sb.toString());
	}

	/**
	 * 清理旧的对照数据
	 * 
	 * @param fg_drug
	 *            药品标志
	 * @throws DAException
	 */
	private void ClearHPSrvorcaData(Boolean fg_drug) throws DAException {
		StringBuilder sql = new StringBuilder();
		if (fg_drug) {
			sql.append(String.format(
					"delete from bd_hp_srvorca where id_grp = '%s' and id_org = '%s' and (id_mm is not null and id_mm <> '~')",
					Context.get().getGroupId(), Context.get().getOrgId()));
		} else {
			sql.append(String.format(
					"delete from bd_hp_srvorca where id_grp = '%s' and id_org = '%s' and (id_mm is null or id_mm = '~')",
					Context.get().getGroupId(), Context.get().getOrgId()));
		}
		new DAFacade().execUpdate(sql.toString());

	}

	/**
	 * 删除所勾选的医保目录对照数据，同时删除其相应的医保计划_控制策略数据
	 * 
	 * @param selectedDOArr
	 * @return
	 */
	public FBoolean deleteHPSrvorcasDataAndHpSrvctrsData(HPSrvorcaDO[] selectedDOArr) throws BizException {
		List<BdHpSrvctrDO> toBeDeleteList = new ArrayList<BdHpSrvctrDO>();
		IBdhpsrvctrRService ctrSer = ServiceFinder.find(IBdhpsrvctrRService.class);
		for (HPSrvorcaDO itm : selectedDOArr) {
			BdHpSrvctrDO[] ctrDOArr = ctrSer.find(
					" a0.id_hp='" + itm.getId_hp() + "'  and a0.id_srv='" + itm.getId_srv() + "'", "", FBoolean.FALSE);
			if (ctrDOArr != null && ctrDOArr.length > 0) {
				for (BdHpSrvctrDO ctrItm : ctrDOArr) {
					toBeDeleteList.add(ctrItm);
				}
			}
		}
		IBdhpsrvctrCudService ctrCudSer = ServiceFinder.find(IBdhpsrvctrCudService.class);
		ctrCudSer.delete(toBeDeleteList.toArray(new BdHpSrvctrDO[0]));

		IHpsrvorcaCudService hpsrvorcaCudService = ServiceFinder.find(IHpsrvorcaCudService.class);
		hpsrvorcaCudService.delete(selectedDOArr);
		return FBoolean.TRUE;
	}
}
