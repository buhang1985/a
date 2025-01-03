package iih.ei.std.s.v1.bp.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoAllListDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoAllResultDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoListDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoParamDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoResultDTO;
import iih.ei.std.d.v1.utils.EiAppUtils;
import iih.ei.std.d.v1.utils.EiValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;

public class GetIpInfoUtilsBP {

	
	public IpInfoResultDTO getResults(IpInfoListDTO[] ipInfoListDTOs ) throws BizException {
		// 1.查询住院信息
		IpInfoListDTO[] ipRegInfos = getIpInfoListDTOList(ipInfoListDTOs);
		// 2.补充某些字段
		IpInfoListDTO[] listDTOs = aseemly(ipRegInfos);
		IpInfoResultDTO resultDTO = new IpInfoResultDTO();
		resultDTO.setIpinfolist(ArrayListUtil.ConvertToFArrayList(listDTOs));
		return resultDTO;
	}

	public IpInfoAllResultDTO getResultsAll(IpInfoListDTO[] ipInfoListDTOs, IpInfoParamDTO infoParamDTO) throws BizException {
		// 1.查询住院信息
		IpInfoAllListDTO[] allListDTOs = getIpInfoAll(ipInfoListDTOs, infoParamDTO);
		// 2.补充某些字段
		IpInfoAllListDTO[] listDTOs = aseemlyAll(allListDTOs);
		IpInfoAllResultDTO resultDTO = new IpInfoAllResultDTO();
		resultDTO.setIpinfoalllistdto(ArrayListUtil.ConvertToFArrayList(listDTOs));
		return resultDTO;
	}

	/**
	 * 查询住院和急诊留观患者id_ent
	 * 
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	public void getSqlAndParam(IpInfoParamDTO inParam, StringBuilder sqlSb, SqlParam param) throws BizException {
		sqlSb.append(" SELECT ENT.ID_ENT ");
		sqlSb.append(" FROM EN_ENT ENT ");
		sqlSb.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT ");
		sqlSb.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT ");
		sqlSb.append(" LEFT JOIN BD_DEP DEP_NURDISC ON DEP_NURDISC.ID_DEP = ENT.ID_DEP_NUR ");
		sqlSb.append(" LEFT JOIN BD_DEP DEP_PHYDISC ON DEP_PHYDISC.ID_DEP = ENT.ID_DEP_PHY ");
		sqlSb.append(" WHERE 1=1  ");
		if(!StringUtil.isEmpty(inParam.getSd_status())){
			if(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT.equals(inParam.getSd_status())){
				sqlSb.append(" AND ENT.FG_CANC = ? ");
				param.addParam(FBoolean.TRUE);
			}else{
				sqlSb.append(" AND ENT.FG_CANC = ? ");
				param.addParam(FBoolean.FALSE);
			}
		}
		
		// 科室编码
		if (!StringUtil.isEmptyWithTrim(inParam.getCode_dep())) {
			sqlSb.append(" AND DEP_PHYDISC.CODE = ? ");
			param.addParam(inParam.getCode_dep());
		}
		// 住院病区编码
		if (!StringUtil.isEmptyWithTrim(inParam.getCode_nur())) {
			sqlSb.append(" AND DEP_NURDISC.CODE = ? ");
			param.addParam(inParam.getCode_nur());
		}
		// 住院开始时间
		if (inParam.getDate_b_in() != null) {
			sqlSb.append(" AND ENT.DT_ACPT >= ? ");
			param.addParam(inParam.getDate_b_in());
		}
		// 住院结束时间
		if (inParam.getDate_e_in() != null) {
			sqlSb.append(" AND ENT.DT_ACPT < ? ");
			param.addParam(inParam.getDate_e_in().getDateAfter(1));
		}
		// 出院开始时间
		if (inParam.getDate_b_out() != null) {
			sqlSb.append(" AND ENT.DT_END >= ? ");
			param.addParam(inParam.getDate_b_out());
		}
		// 出院结束时间
		if (inParam.getDate_e_out() != null) {
			sqlSb.append(" AND ENT.DT_END < ? ");
			param.addParam(inParam.getDate_e_out().getDateAfter(1));
		}
		//时间戳条件判断
		if (inParam.getDate_b_update() != null && inParam.getDate_e_update() != null) {
			sqlSb.append(" AND ((ENT.SV >= ? AND ENT.SV <= ?) OR (IP.SV >= ? AND IP.SV <= ?)) ");
			param.addParam(inParam.getDate_b_update());
			param.addParam(inParam.getDate_e_update().getDateAfter(1));
			param.addParam(inParam.getDate_b_update());
			param.addParam(inParam.getDate_e_update().getDateAfter(1));
		}else if (inParam.getDate_b_update() != null) {
			sqlSb.append(" AND (ENT.SV >= ? OR IP.SV >= ?) ");
			param.addParam(inParam.getDate_b_update());
			param.addParam(inParam.getDate_b_update());
		}else if (inParam.getDate_e_update() != null) {
			sqlSb.append(" AND (ENT.SV <= ? OR IP.SV <= ?) ");
			param.addParam(inParam.getDate_e_update().getDateAfter(1));
			param.addParam(inParam.getDate_e_update().getDateAfter(1));
		}
		if (!StringUtil.isEmptyWithTrim(inParam.getSd_status())) {
			if (IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN.equals(inParam.getSd_status())) { // 入院登记  // zhangpp  // 2019.09.23																			
				sqlSb.append(" AND IP.SD_STATUS = ? ");
				// 入院登记
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);
			}
			if (IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN.equals(inParam.getSd_status())) { // 入科																			
				sqlSb.append(" AND IP.SD_STATUS = ? ");
				// 入科
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN);
			}
			if (IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT.equals(inParam.getSd_status())) { // 出院																			
				sqlSb.append(" AND IP.SD_STATUS = ? ");
				// 出院
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
			}
			if (IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT.equals(inParam.getSd_status())) { // 退院																			
				sqlSb.append(" AND IP.SD_STATUS = ? ");
				// 退院
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT);
			}
		}
		// 住院号
		if (!StringUtil.isEmptyWithTrim(inParam.getCode_amr_ip())) {
			String sql = SqlUtils.getInSqlByIdsSplit(" AND IP.CODE_AMR_IP ", inParam.getCode_amr_ip().trim());
			sqlSb.append(sql);
		}
		// 患者编码
		if (!StringUtil.isEmptyWithTrim(inParam.getCode_pat())) {
			String sql = SqlUtils.getInSqlByIdsSplit(" AND PAT.CODE ", inParam.getCode_pat().trim());
			sqlSb.append(sql);
		}
		// 就诊次数
		if (inParam.getTimes_ip() != null) {
			sqlSb.append(" AND IP.TIMES_IP = ? ");
			param.addParam(inParam.getTimes_ip());
		}
	}

	/**
	 * 查询住院和急诊留观详细信息
	 * 
	 * @param list
	 * @param entIds
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private IpInfoListDTO[] getIpInfoListDTOList(IpInfoListDTO[] ipInfoListDTOs) throws BizException {
		if (ArrayUtil.isEmpty(ipInfoListDTOs))
			return null;
		StringBuilder sqlSBuilder = this.getSql();
		SqlParam param = new SqlParam();
		sqlSBuilder.append(" WHERE ").append(SqlUtils.getInSqlByIds(" ENT.ID_ENT ", EiAppUtils.getKeyPropArrayFromDO("Id_ent", ipInfoListDTOs)));
		List<IpInfoListDTO> results = (List<IpInfoListDTO>) new DAFacade().execQuery(sqlSBuilder.toString(), param,
				new BeanListHandler(IpInfoListDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new IpInfoListDTO[0]);
	}

	/**
	 * 获取sql字段
	 * 
	 * @return
	 */
	private StringBuilder getSql() {
		StringBuilder sqlSBuilder = new StringBuilder();
		sqlSBuilder.append(" SELECT ");
		sqlSBuilder.append(" PAT.CODE AS CODE_PAT,");// 患者编码
		sqlSBuilder.append(" ENT.CODE CODE_ENT,");// 就诊编码
		sqlSBuilder.append(" ENT.ID_ENT AS ID_ENT,");// 就诊id
		sqlSBuilder.append(" ENT.ID_PAT AS ID_PAT,");// 患者id
		sqlSBuilder.append(" ENT.ID_DEP_PHY AS ID_DEP_PHY,");// 科室ID
		sqlSBuilder.append(" ENT.ID_DEP_NUR AS ID_DEP_NUR,");// 病区ID
		sqlSBuilder.append(" ENT.ID_EMP_PHY AS ID_EMP_PHY,");// 责任医生ID
		sqlSBuilder.append(" ENT.ID_EMP_NUR AS ID_EMP_NUR,");// 责任护士ID
		sqlSBuilder.append(" IP.ID_DEP_PHYADM AS ID_DEP_PHYADM,");// 入院科室
		sqlSBuilder.append(" IP.ID_DEP_NURADM AS ID_DEP_NURADM,");// 入院病区
		sqlSBuilder.append(" IP.CODE_AMR_IP AS CODE_AMR_IP,");// 住院号
		sqlSBuilder.append(" IP.TIMES_IP AS TIMES_IP,");// 住院次数
		// 住院天数
		sqlSBuilder.append(" PAT.NAME AS NAME_PAT,");// 姓名
		// 黑名单标志
		sqlSBuilder.append(" PAT.SD_SEX,");// 性别
		sqlSBuilder.append(" PAT.DT_BIRTH AS DT_BIRTH_DATE,");// 出生日期
		sqlSBuilder.append(" PAT.MOB ,");// 电话
		sqlSBuilder.append(" CA.CODE AS SD_PATCA,");// 患者分类编码
		sqlSBuilder.append(" CA.NAME AS NAME_PATCA,");// 患者分类名称
		sqlSBuilder.append(" PRI_PAT.CODE AS SD_PRIPAT,");// 价格分类编码
		sqlSBuilder.append(" PRI_PAT.NAME AS NAME_PRIPAT,");// 价格分类名称
		sqlSBuilder.append(" HP.CODE AS CODE_HP,");// 医保编码
		sqlSBuilder.append(" HP.NAME AS NAME_HP,");// 医保名称
		sqlSBuilder.append(" ENHP.NO_HP, ");// 医保卡号
		sqlSBuilder.append(" IP.NAME_BED AS NAME_BED,");// 床号
		sqlSBuilder.append(" ENT.DT_ENTRY AS DT_ENTRY,");// 入院登记时间
		sqlSBuilder.append(" ENT.DT_ACPT,");// 住院日期
		sqlSBuilder.append(" ENT.DT_END,");// 出院日期
		sqlSBuilder.append(" IP.SD_LEVEL_NUR AS SD_LEVEL_NUR,");// 护理级别
		sqlSBuilder.append(" ENT.ADDR_PAT,");// 家庭住址
		sqlSBuilder.append(" PAT.SD_IDTP AS ID_TYPE,");// 证件类型
		sqlSBuilder.append(" PAT.ID_CODE AS CODE_ID,");// 证件号
		sqlSBuilder.append(" IP.SD_STATUS AS SD_STATUS,");// 就诊状态
		sqlSBuilder.append(" ENT.FG_ST,");// 结算标识
		sqlSBuilder.append(" IP.FG_MOBAPP AS FG_MOBAPP,");// 开通手机app标志
		sqlSBuilder.append(" ENT.CODE_ENTP AS CODE_ENTP,");// 就诊类型
		sqlSBuilder.append(" DI.CODE AS CODE_DIAG_OP,");// 门诊诊断编码
		sqlSBuilder.append(" DI.NAME AS NAME_DIAG_OP,");// 门诊诊断
		sqlSBuilder.append(" CASE WHEN ENT.SV > IP.SV THEN ENT.SV ELSE IP.SV END UPDATE_TIME ");//更新时间
		sqlSBuilder.append(" FROM EN_ENT ENT");
		sqlSBuilder.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
		sqlSBuilder.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT");
		sqlSBuilder.append(" LEFT JOIN  PI_PAT_CA CA ON CA.ID_PATCA = ENT.ID_PATCA");
		sqlSBuilder.append(" LEFT JOIN BD_PRI_PAT PRI_PAT ON PRI_PAT.ID_PRIPAT = ENT.ID_PRIPAT");
		sqlSBuilder.append(" LEFT JOIN BD_HP HP ON HP.ID_HP = ENT.ID_HP ");
		sqlSBuilder.append(" LEFT JOIN EN_ENT_HP ENHP ON ENHP.ID_ENT = ENT.ID_ENT AND ENHP.FG_MAJ = 'Y' ");
		sqlSBuilder.append(" LEFT JOIN BD_DI_DEF DI ON IP.ID_DIAG_OP = DI.ID_DIDEF ");
		return sqlSBuilder;
	}

	/**
	 * 查询所有住院信息
	 * 
	 * @param entIds
	 * @return
	 * @throws DAException
	 */
	protected IpInfoAllListDTO[] getIpInfoAll(IpInfoListDTO[] ipInfoListDTOs, IpInfoParamDTO infoParamDTO) throws DAException {
		if (ArrayUtil.isEmpty(ipInfoListDTOs))
			return null;
		SqlParam param = new SqlParam();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT PAT.ID_MARRY,");// 婚姻id 
		sql.append(" ENT.ID_ENT,");// 就诊id
		sql.append(" PAT.DT_BIRTH_HMS DT_BIRTH_HMS,");// -- 出生日期时分秒
		sql.append(" ENT.CODE CODE_ENT,");// 就诊编码
		sql.append(" PAT.ID_NATION,");// 民族id
		sql.append(" PAT.ID_COUNTRY,");// 国籍id 
		sql.append(" PAT.ID_SRCREGIONTP,");// 户籍类型id 
		sql.append(" PAT.ID_OCCU,");// 职业id 
		sql.append(" PAT.WORKUNIT WORKUNIT,");// 工作单位
		sql.append(" PAT.ID_EDUC,");// 文化程度
		sql.append(" PAT.BARCODE_CHIS BARCODE_CHIS,");// 条码号
		sql.append(" ENT.SD_ADMDIV_ADDR SD_ADMDIV_ADDR,");// 现住址区县码
		sql.append(" CRET.CODE SD_PATCRET,");// 信用分类编码
		sql.append(" CRET.NAME NAME_PATCRET,");// 信用分类名称
		sql.append(" IP.ID_DEP_PHYDISC ID_DEP_OUT,");// 出院科室id
		sql.append(" IP.ID_DEP_NURDISC ID_DEP_NUR_OUT,");// 出院病区id
		sql.append(" IP.SD_LEVEL_DISE PATIENT_STATUS,");// 病情等级
		sql.append(" IP.SD_LEVEL_NUTR SD_LEVEL_NUTR,");// 营养等级
		sql.append(" IP.SD_REFERALSRC SD_REFERALSRC,");// 来院方式
		sql.append(" IP.SD_GOWHERE SD_GOWHERE,");// 离院转归
		sql.append(" IP.FG_SURG FG_SURG,");// 是否手术标识
		sql.append(" IP.FG_NEWBORN FG_NEWBORN,");// 新生儿标识
		sql.append(" IP.DT_DEATH DT_DEATH,");// 死亡时间
		sql.append(" IP.FG_INCP FG_INCP,");// 是否在临床路径中
		sql.append(" IP.EU_INCP EU_INCP,");// 临床路径状态
		sql.append(" IP.ID_EMP_OPAPPLY ID_EMP_PHY_OP,");// 入院门诊医生id
		sql.append(" CO.NAME CONT_NAME,");// 主要联系人姓名
		sql.append(" CO.CONTTEL CONT_TEL,");// 主要联系人电话
		sql.append(" ACC.AMT_CRED AMT_CRET,");// 信用额度
		sql.append(" ACC.AMT_PREPAY AMT_PREPAY,");// 就诊预交金
		sql.append(" ACC.AMT_UNCG AMT_UNCG,");// 就诊未结算费用
		sql.append(" ACC.AMT_OWELIMIT AMT_OWELIMIT,");// 欠费下限
		sql.append(" ACC.AMT_HP AMT_HP,");// 可报销医保额度
		sql.append(" ACC.FG_FREEZE FG_FREEZE, ");// 封帐标志

		sql.append(" PAT.CODE AS CODE_PAT,");// 患者编码
		sql.append(" ENT.CODE CODE_ENT,");// 就诊编码
		sql.append(" ENT.ID_ENT AS ID_ENT,");// 就诊id
		sql.append(" ENT.ID_PAT AS ID_PAT,");// 患者id
		sql.append(" ENT.ID_DEP_PHY AS ID_DEP_PHY,");// 科室ID
		sql.append(" ENT.ID_DEP_NUR AS ID_DEP_NUR,");// 病区ID
		sql.append(" ENT.ID_EMP_PHY AS ID_EMP_PHY,");// 责任医生ID
		sql.append(" ENT.ID_EMP_NUR AS ID_EMP_NUR,");// 责任护士ID
		sql.append(" IP.ID_DEP_PHYADM AS ID_DEP_PHYADM,");// 入院科室
		sql.append(" IP.ID_DEP_NURADM AS ID_DEP_NURADM,");// 入院病区
		sql.append(" IP.CODE_AMR_IP AS CODE_AMR_IP,");// 住院号
		sql.append(" IP.TIMES_IP AS TIMES_IP,");// 住院次数
		// 住院天数
		sql.append(" PAT.NAME AS NAME_PAT,");// 姓名
		// 黑名单标志
		sql.append(" PAT.SD_SEX,");// 性别
		sql.append(" PAT.DT_BIRTH AS DT_BIRTH_DATE,");// 出生日期
		sql.append(" PAT.MOB ,");// 电话
		sql.append(" CA.CODE AS SD_PATCA,");// 患者分类编码
		sql.append(" CA.NAME AS NAME_PATCA,");// 患者分类名称
		sql.append(" PRI_PAT.CODE AS SD_PRIPAT,");// 价格分类编码
		sql.append(" PRI_PAT.NAME AS NAME_PRIPAT,");// 价格分类名称
		sql.append(" HP.CODE AS CODE_HP,");// 医保编码
		sql.append(" HP.NAME AS NAME_HP,");// 医保名称
		sql.append(" ENHP.NO_HP, ");// 医保卡号
		sql.append(" IP.NAME_BED AS NAME_BED,");// 床号
		sql.append(" ENT.DT_ENTRY AS DT_ENTRY,");// 入院登记时间
		sql.append(" ENT.DT_ACPT,");// 住院日期
		sql.append(" ENT.DT_END,");// 出院日期
		sql.append(" IP.SD_LEVEL_NUR AS SD_LEVEL_NUR,");// 护理级别
		sql.append(" ENT.ADDR_PAT,");// 家庭住址
		sql.append(" PAT.SD_IDTP AS ID_TYPE,");// 证件类型
		sql.append(" PAT.ID_CODE AS CODE_ID,");// 证件号
		sql.append(" IP.SD_STATUS AS SD_STATUS,");// 就诊状态
		sql.append(" ENT.FG_ST,");// 结算标识
		sql.append(" IP.FG_MOBAPP AS FG_MOBAPP,");// 开通手机app标志
		sql.append(" ENT.CODE_ENTP AS CODE_ENTP,");// 就诊类型
		sql.append(" DI.CODE AS CODE_DIAG_OP,");// 门诊诊断编码
		sql.append(" DI.NAME AS NAME_DIAG_OP,");// 门诊诊断
		if (infoParamDTO.getDate_e_update() != null) {
			sql.append(" CASE WHEN ENT.SV > ? THEN IP.SV ");
			sql.append(" WHEN IP.SV > ? THEN ENT.SV ");
			sql.append(" WHEN ENT.SV <= ? AND IP.SV <= ? AND ENT.SV > IP.SV THEN ENT.SV ");
			sql.append(" ELSE IP.SV END UPDATE_TIME ");
			param.addParam(infoParamDTO.getDate_e_update().getDateAfter(1));
			param.addParam(infoParamDTO.getDate_e_update().getDateAfter(1));
			param.addParam(infoParamDTO.getDate_e_update().getDateAfter(1));
			param.addParam(infoParamDTO.getDate_e_update().getDateAfter(1));
		}else{
			sql.append(" CASE WHEN ENT.SV > IP.SV THEN ENT.SV ELSE IP.SV END UPDATE_TIME ");//更新时间
		}
		sql.append(" FROM EN_ENT ENT");
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
		sql.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT");
		sql.append(" LEFT JOIN PI_PAT_CRET CRET ON CRET.ID_PATCRET = PAT.ID_PATCRETTP");
		sql.append(" LEFT JOIN BD_DI_DEF DI ON IP.ID_DIAG_OP = DI.ID_DIDEF");
		sql.append(" LEFT JOIN EN_ENT_CONT CO ON CO.ID_ENT = ENT.ID_ENT AND CO.EU_ENTCONTTP = '1'");
		sql.append(" LEFT JOIN EN_ENT_ACC ACC ON ACC.ID_ENT = ENT.ID_ENT");

		sql.append(" LEFT JOIN PI_PAT_CA CA ON CA.ID_PATCA = ENT.ID_PATCA");
		sql.append(" LEFT JOIN BD_PRI_PAT PRI_PAT ON PRI_PAT.ID_PRIPAT = ENT.ID_PRIPAT");
		sql.append(" LEFT JOIN BD_HP HP ON HP.ID_HP = ENT.ID_HP ");
		sql.append(" LEFT JOIN EN_ENT_HP ENHP ON ENHP.ID_ENT = ENT.ID_ENT AND ENHP.FG_MAJ = 'Y' ");
		sql.append(" WHERE ").append(SqlUtils.getInSqlByIds(" ENT.ID_ENT ", EiAppUtils.getKeyPropArrayFromDO("Id_ent", ipInfoListDTOs)));
		@SuppressWarnings("unchecked")
		List<IpInfoAllListDTO> results = (List<IpInfoAllListDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(IpInfoAllListDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new IpInfoAllListDTO[0]);
	}

	private IpInfoListDTO[] aseemly(IpInfoListDTO[] ipInfoDTOs) throws BizException {
		if(ArrayUtil.isEmpty(ipInfoDTOs)){
			return null;
		}
		Map<String, IpInfoListDTO> bbrMap = assemlyBbrMap(ipInfoDTOs, null);
		Map<String, DeptDO> depMap = assemlyDeptMap(ipInfoDTOs, null);
		Map<String, PsnDocDO> empMap = assemlyEmpMap(ipInfoDTOs, null);
		CalculateHosDaysBP daysBP = new CalculateHosDaysBP();
		FDateTime curDate = AppUtils.getServerDateTime();
		for (IpInfoListDTO dto : ipInfoDTOs) {
			// 住院天数
			FDateTime dt_end = dto.getDt_end() == null ? curDate : dto.getDt_end();
			dto.setTotal_days(daysBP.calculate(dto.getDt_acpt(), dt_end, FBoolean.FALSE));
			// 黑名单标准
			if (bbrMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_pat())
					&& bbrMap.containsKey(dto.getId_pat())) {
				IpInfoListDTO bbr = bbrMap.get(dto.getId_pat());
				dto.setFlag_black(
						bbr.getCount_bbr() != null && bbr.getCount_bbr() > 0 ? FBoolean.TRUE : FBoolean.FALSE);
			} else {
				dto.setFlag_black(FBoolean.FALSE);
			}
			// 入院科室
			if (depMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_dep_phyadm())
					&& depMap.containsKey(dto.getId_dep_phyadm())) {
				DeptDO dept = depMap.get(dto.getId_dep_phyadm());
				// 科室code
				dto.setCode_dep_adm(dept.getCode());
				// 科室名称
				dto.setName_dep_adm(dept.getName());
			}
			// 入院病区
			if (depMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_dep_nuradm())
					&& depMap.containsKey(dto.getId_dep_nuradm())) {
				DeptDO dept = depMap.get(dto.getId_dep_nuradm());
				// 科室code
				dto.setCode_dep_nur_adm(dept.getCode());
				// 科室名称
				dto.setName_dep_nur_adm(dept.getName());
			}
			// 当前科室
			if (depMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_dep_phy())
					&& depMap.containsKey(dto.getId_dep_phy())) {
				DeptDO dept = depMap.get(dto.getId_dep_phy());
				// 科室code
				dto.setCode_dep(dept.getCode());
				// 科室名称
				dto.setName_dep(dept.getName());
			}
			// 当前病区
			if (depMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_dep_nur())
					&& depMap.containsKey(dto.getId_dep_nur())) {
				DeptDO dept = depMap.get(dto.getId_dep_nur());
				// 科室code
				dto.setCode_dep_nur(dept.getCode());
				// 科室名称
				dto.setName_dep_nur(dept.getName());
			}
			if (empMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_emp_phy())
					&& empMap.containsKey(dto.getId_emp_phy())) {
				PsnDocDO emp = empMap.get(dto.getId_emp_phy());
				// 责任医生
				dto.setCode_emp_phy(emp.getCode());
				dto.setName_emp_phy(emp.getName());
			}
			if (empMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_emp_phy())
					&& empMap.containsKey(dto.getId_emp_nur())) {
				PsnDocDO emp = empMap.get(dto.getId_emp_nur());
				// 责任护士
				dto.setCode_emp_nur(emp.getCode());
				dto.setName_emp_nur(emp.getName());
			}
		}
		return ipInfoDTOs;
	}

	private IpInfoAllListDTO[] aseemlyAll(IpInfoAllListDTO[] ipInfoAllListDTOs) throws BizException {
		if (ArrayUtil.isEmpty(ipInfoAllListDTOs))
			return null;
		// 黑名单标准
		Map<String, IpInfoListDTO> bbrMap = assemlyBbrMap(null, ipInfoAllListDTOs);
		// 组装科室病区信息
		Map<String, DeptDO> depMap = assemlyDeptMap(null, ipInfoAllListDTOs);
		// 组装医生护士信息
		Map<String, PsnDocDO> empMap = assemlyEmpMap(null, ipInfoAllListDTOs);
		// 组装自定义档案基本信息
		Map<String, UdidocDO> udiMap = assemlyUdMap(ipInfoAllListDTOs);
		// 组装国籍信息
		Map<String, CountryZoneDO> countryMap = this.getCountry(ipInfoAllListDTOs);
		CalculateHosDaysBP daysBP = new CalculateHosDaysBP();
		FDateTime curDate = AppUtils.getServerDateTime();
		for (IpInfoAllListDTO dto : ipInfoAllListDTOs) {
			// 住院天数
			FDateTime dt_end = dto.getDt_end() == null ? curDate : dto.getDt_end();
			dto.setTotal_days(daysBP.calculate(dto.getDt_acpt(), dt_end, FBoolean.FALSE));
			// 黑名单标准
			if (bbrMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_pat())
					&& bbrMap.containsKey(dto.getId_pat())) {
				IpInfoListDTO bbr = bbrMap.get(dto.getId_pat());
				dto.setFlag_black(
						bbr.getCount_bbr() != null && bbr.getCount_bbr() > 0 ? FBoolean.TRUE : FBoolean.FALSE);
			} else {
				dto.setFlag_black(FBoolean.FALSE);
			}
			// 入院科室
			if (depMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_dep_phyadm())
					&& depMap.containsKey(dto.getId_dep_phyadm())) {
				DeptDO dept = depMap.get(dto.getId_dep_phyadm());
				// 科室code
				dto.setCode_dep_adm(dept.getCode());
				// 科室名称
				dto.setName_dep_adm(dept.getName());
			}
			// 入院病区
			if (depMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_dep_nuradm())
					&& depMap.containsKey(dto.getId_dep_nuradm())) {
				DeptDO dept = depMap.get(dto.getId_dep_nuradm());
				// 科室code
				dto.setCode_dep_nur_adm(dept.getCode());
				// 科室名称
				dto.setName_dep_nur_adm(dept.getName());
			}
			// 当前科室
			if (depMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_dep_phy())
					&& depMap.containsKey(dto.getId_dep_phy())) {
				DeptDO dept = depMap.get(dto.getId_dep_phy());
				// 科室code
				dto.setCode_dep(dept.getCode());
				// 科室名称
				dto.setName_dep(dept.getName());
			}
			// 当前病区
			if (depMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_dep_nur())
					&& depMap.containsKey(dto.getId_dep_nur())) {
				DeptDO dept = depMap.get(dto.getId_dep_nur());
				// 科室code
				dto.setCode_dep_nur(dept.getCode());
				// 科室名称
				dto.setName_dep_nur(dept.getName());
			}
			if (empMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_emp_phy())
					&& empMap.containsKey(dto.getId_emp_phy())) {
				PsnDocDO emp = empMap.get(dto.getId_emp_phy());
				// 责任医生
				dto.setCode_emp_phy(emp.getCode());
				dto.setName_emp_phy(emp.getName());
			}
			if (empMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_emp_phy())
					&& empMap.containsKey(dto.getId_emp_nur())) {
				PsnDocDO emp = empMap.get(dto.getId_emp_nur());
				// 责任护士
				dto.setCode_emp_nur(emp.getCode());
				dto.setName_emp_nur(emp.getName());
			}

			if (udiMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_marry())
					&& udiMap.containsKey(dto.getId_marry())) {
				UdidocDO udi = udiMap.get(dto.getId_marry());
				// 婚姻
				dto.setCode_mari_pat(udi.getCode());
			}
			if (udiMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_nation())
					&& udiMap.containsKey(dto.getId_nation())) {
				UdidocDO udi = udiMap.get(dto.getId_nation());
				// 民族
				dto.setSd_nation(udi.getCode());
				dto.setName_nation(udi.getName());
			}
			if (countryMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_country())
					&& countryMap.containsKey(dto.getId_country())) {
				CountryZoneDO countryZoneDO = countryMap.get(dto.getId_country());
				// 国籍
				dto.setSd_country(countryZoneDO.getCode());
				dto.setName_country(countryZoneDO.getName());
			}
			if (udiMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_srcregiontp())
					&& udiMap.containsKey(dto.getId_srcregiontp())) {
				UdidocDO udi = udiMap.get(dto.getId_srcregiontp());
				// 户籍
				dto.setSd_srcregiontp(udi.getCode());
				dto.setName_srcregiontp(udi.getName());
			}
			if (udiMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_occu())
					&& udiMap.containsKey(dto.getId_occu())) {
				UdidocDO udi = udiMap.get(dto.getId_occu());
				// 职业
				dto.setSd_occu(udi.getCode());
				dto.setName_occu(udi.getName());
			}
			if (udiMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_educ())
					&& udiMap.containsKey(dto.getId_educ())) {
				UdidocDO udi = udiMap.get(dto.getId_educ());
				// 文化程度
				dto.setSd_educ(udi.getCode());
				dto.setName_educ(udi.getName());
			}

			if (empMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_emp_phy_op())
					&& empMap.containsKey(dto.getId_emp_phy_op())) {
				PsnDocDO emp = empMap.get(dto.getId_emp_phy_op());
				// 入院门诊医生
				dto.setCode_emp_opapply(emp.getCode());
				dto.setName_emp_opapply(emp.getName());
			}
			// 出院科室
			if (depMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_dep_out())
					&& depMap.containsKey(dto.getId_dep_out())) {
				DeptDO dept = depMap.get(dto.getId_dep_out());
				// 科室code
				dto.setCode_dep_disc(dept.getCode());
				// 科室名称
				dto.setName_dep_disc(dept.getName());
			}
			// 出院病区
			if (depMap != null && EiValidator.isNotEmptyIgnoreBlank(dto.getId_dep_nur_out())
					&& depMap.containsKey(dto.getId_dep_nur_out())) {
				DeptDO dept = depMap.get(dto.getId_dep_nur_out());
				// 病区code
				dto.setCode_dep_nur_disc(dept.getCode());
				// 病区名称
				dto.setName_dep_nur_disc(dept.getName());
			}
		}
		return ipInfoAllListDTOs;
	}

	/**
	 * 组装科室信息
	 * 
	 * @param ipRegInfos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, DeptDO> assemlyDeptMap(IpInfoListDTO[] ipRegInfos, IpInfoAllListDTO[] ipRegAllInfos)
			throws BizException {
		Map<String, DeptDO> map = new HashMap<String, DeptDO>();
		// 入院科室
		String[] id_dep_phyadms = EiAppUtils.getKeyPropArrayFromDO("Id_dep_phyadm",
				ipRegInfos != null ? ipRegInfos : ipRegAllInfos);
		// 入院病区
		String[] id_dep_nuradms = EiAppUtils.getKeyPropArrayFromDO("Id_dep_nuradm",
				ipRegInfos != null ? ipRegInfos : ipRegAllInfos);
		// 当前科室
		String[] Id_dep_phys = EiAppUtils.getKeyPropArrayFromDO("Id_dep_phy",
				ipRegInfos != null ? ipRegInfos : ipRegAllInfos);
		// 当前病区
		String[] Id_dep_nurs = EiAppUtils.getKeyPropArrayFromDO("Id_dep_nur",
				ipRegInfos != null ? ipRegInfos : ipRegAllInfos);
		// 出院科室
		String[] id_dep_phydiscs = EiAppUtils.getKeyPropArrayFromDO("Id_dep_out", ipRegAllInfos);
		// 出院病区
		String[] id_dep_nurdiscs = EiAppUtils.getKeyPropArrayFromDO("Id_dep_nur_out", ipRegAllInfos);

		Set<String> set = new HashSet<String>();
		if (!ArrayUtil.isEmpty(id_dep_phyadms))
			set.addAll(Arrays.asList(id_dep_phyadms));
		if (!ArrayUtil.isEmpty(id_dep_nuradms))
			set.addAll(Arrays.asList(id_dep_nuradms));
		if (!ArrayUtil.isEmpty(Id_dep_phys))
			set.addAll(Arrays.asList(Id_dep_phys));
		if (!ArrayUtil.isEmpty(Id_dep_nurs))
			set.addAll(Arrays.asList(Id_dep_nurs));
		if (!ArrayUtil.isEmpty(id_dep_phydiscs))
			set.addAll(Arrays.asList(id_dep_phydiscs));
		if (!ArrayUtil.isEmpty(id_dep_nurdiscs))
			set.addAll(Arrays.asList(id_dep_nurdiscs));
		if (set.isEmpty())
			return map;

		List<DeptDO> list = (List<DeptDO>) new DAFacade().findByPKs(DeptDO.class, set.toArray(new String[0]));
		if (!ListUtil.isEmpty(list)) {
			return MapUtils.convertListToMap(list, DeptDO.ID_DEP);
		}
		return map;
	}

	/**
	 * 组装人员信息
	 * 
	 * @param ipRegInfos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, PsnDocDO> assemlyEmpMap(IpInfoListDTO[] ipRegInfos, IpInfoAllListDTO[] ipRegAllInfos)
			throws BizException {
		Map<String, PsnDocDO> map = new HashMap<String, PsnDocDO>();
		// 责任医生
		String[] phyIds = EiAppUtils.getKeyPropArrayFromDO("Id_emp_phy",
				ipRegInfos != null ? ipRegInfos : ipRegAllInfos);
		// 责任护士
		String[] nurIds = EiAppUtils.getKeyPropArrayFromDO("Id_emp_nur",
				ipRegInfos != null ? ipRegInfos : ipRegAllInfos);
		// 入院门诊医生
		String[] phyOpIds = EiAppUtils.getKeyPropArrayFromDO("Id_emp_phy_op", ipRegAllInfos);
		Set<String> set = new HashSet<String>();
		if (!ArrayUtil.isEmpty(phyIds))
			set.addAll(Arrays.asList(phyIds));
		if (!ArrayUtil.isEmpty(nurIds))
			set.addAll(Arrays.asList(nurIds));
		if (!ArrayUtil.isEmpty(phyOpIds))
			set.addAll(Arrays.asList(phyOpIds));
		if (set.isEmpty())
			return map;
		List<PsnDocDO> list = (List<PsnDocDO>) new DAFacade().findByPKs(PsnDocDO.class, set.toArray(new String[0]));
		if (!ListUtil.isEmpty(list)) {
			return MapUtils.convertListToMap(list, PsnDocDO.ID_PSNDOC);
		}
		return map;
	}

	/**
	 * 组装自定义档案基本信息
	 * 
	 * @param ipRegInfos
	 * @param ipRegAllInfos
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, UdidocDO> assemlyUdMap(IpInfoAllListDTO[] ipRegAllInfos) throws DAException {
		Map<String, UdidocDO> map = new HashMap<String, UdidocDO>();
		// 婚姻
		String[] marryIds = EiAppUtils.getKeyPropArrayFromDO("Id_marry", ipRegAllInfos);
		// 民族
		String[] nationIds = EiAppUtils.getKeyPropArrayFromDO("Id_nation", ipRegAllInfos);
		// 户籍
		String[] srcregiontpIds = EiAppUtils.getKeyPropArrayFromDO("Id_srcregiontp", ipRegAllInfos);
		// 职业
		String[] occuIds = EiAppUtils.getKeyPropArrayFromDO("Id_occu", ipRegAllInfos);
		// 文化
		String[] educIds = EiAppUtils.getKeyPropArrayFromDO("Id_educ", ipRegAllInfos);
		Set<String> set = new HashSet<String>();
		if (!ArrayUtil.isEmpty(marryIds))
			set.addAll(Arrays.asList(marryIds));
		if (!ArrayUtil.isEmpty(nationIds))
			set.addAll(Arrays.asList(nationIds));
		if (!ArrayUtil.isEmpty(srcregiontpIds))
			set.addAll(Arrays.asList(srcregiontpIds));
		if (!ArrayUtil.isEmpty(occuIds))
			set.addAll(Arrays.asList(occuIds));
		if (!ArrayUtil.isEmpty(educIds))
			set.addAll(Arrays.asList(educIds));
		if (set.isEmpty())
			return map;
		List<UdidocDO> list = (List<UdidocDO>) new DAFacade().findByPKs(UdidocDO.class, set.toArray(new String[0]));
		if (!ListUtil.isEmpty(list)) {
			return MapUtils.convertListToMap(list, UdidocDO.ID_UDIDOC);
		}
		return map;
	}

	/**
	 * 组装黑名单map
	 * 
	 * @param ipRegInfos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, IpInfoListDTO> assemlyBbrMap(IpInfoListDTO[] ipRegInfos, IpInfoAllListDTO[] ipInfoAllListDTOs)
			throws BizException {
		Map<String, IpInfoListDTO> map = new HashMap<String, IpInfoListDTO>();
		String[] patIds = EiAppUtils.getKeyPropArrayFromDO("Id_pat",
				ipRegInfos == null ? ipInfoAllListDTOs : ipRegInfos);
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT BBR.ID_PAT,COUNT(BBR.ID_PAT) AS COUNT_BBR ");
		sqlBuilder.append(" FROM PI_PAT_BBR BBR WHERE BBR.FG_ACTIVE = 'Y' ");
		if(!ArrayUtil.isEmpty(patIds)){
			sqlBuilder.append(SqlUtils.getInSqlByIds(" AND BBR.ID_PAT ", patIds));
		}
		sqlBuilder.append(" GROUP BY BBR.ID_PAT ");
		List<IpInfoListDTO> list = (List<IpInfoListDTO>) new DAFacade().execQuery(sqlBuilder.toString(),
				new BeanListHandler(IpInfoListDTO.class));
		if (!ListUtil.isEmpty(list))
			return MapUtils.convertListToMap(list, "Id_pat");
		return map;
	}
	
	/**
	 * 查询住院患者id_ent
	 * 
	 * @param inParam
	 * @return
	 * @throws BizException
	 */
	protected String[] getEntIds(String[] codeEnts) throws BizException {
		if (ArrayUtil.isEmpty(codeEnts))
			return null;
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().findByAttrValStrings(PatiVisitDO.class,
				PatiVisitDO.CODE, codeEnts, new String[] { PatiVisitDO.ID_ENT, PatiVisitDO.CODE });
		return EiAppUtils.getKeyPropArrayFromDO(PatiVisitDO.ID_ENT,
				ListUtil.isEmpty(list) ? null : list.toArray(new PatiVisitDO[0]));
	}
	
	/**
	 * 获取国籍信息
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private Map<String, CountryZoneDO> getCountry(IpInfoAllListDTO[] ipInfoAllListDTOs) throws BizException{
		if (ArrayUtil.isEmpty(ipInfoAllListDTOs)) return null;
		String[] countryIds = EiAppUtils.getKeyPropArrayFromDO("Id_country", ipInfoAllListDTOs);
		if (ArrayUtil.isEmpty(countryIds)) return null;
		Map<String, CountryZoneDO> map = new HashMap<String, CountryZoneDO>();
		ICountryzoneRService serv = ServiceFinder.find(ICountryzoneRService.class);
		CountryZoneDO[] countries = serv.findByIds(countryIds, FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(countries)) {
			return MapUtils.convertArrayToMap(countries, CountryZoneDO.ID_COUNTRYZONE);
		}
		return map;
	}

}
