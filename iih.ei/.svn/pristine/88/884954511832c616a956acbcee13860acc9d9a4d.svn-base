package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.SqlUtils;
import iih.ei.std.d.v1.en.enstate.d.CodeEntsParamDTO;
import iih.ei.std.d.v1.en.entdeptrans.d.EntDepTransDTO;
import iih.ei.std.d.v1.en.entdeptrans.d.EntDepTransItemsDTO;
import iih.ei.std.d.v1.en.entdeptrans.d.EntDepTransResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院患者转科记录
 * @author lilei
 *
 */
public class GetIpEntDepTransInfoBP extends IIHServiceBaseBP<CodeEntsParamDTO, EntDepTransResultDTO> {

	@Override
	protected void checkParam(CodeEntsParamDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(param.getCode_ents())) {
			throw new BizException("就诊编码不能为空");
		}
	}

	@Override
	protected EntDepTransResultDTO process(CodeEntsParamDTO param) throws BizException {
		GetIpInfoUtilsBP getIpInfoUtilsBP = new GetIpInfoUtilsBP();
		String[] entIds = getIpInfoUtilsBP.getEntIds(param.getCode_ents().split(","));
		EntDepTransDTO[] ipInfoDTOs = getIpDetailInfo(entIds);
		EntDepTransItemsDTO[] ipInfoItemsDTOs = getEntDepTransBeanSql(entIds);
		return assemly(ipInfoDTOs, ipInfoItemsDTOs);
	}

	@SuppressWarnings("unchecked")
	protected EntDepTransDTO[] getIpDetailInfo(String[] entIds) throws DAException {
		if (ArrayUtil.isEmpty(entIds))
			return null;
		StringBuilder sqlsb = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlsb.append(" SELECT");
		sqlsb.append(" PAT.CODE AS CODE_PAT,");// 病人编码
		sqlsb.append(" ENT.CODE AS CODE_ENT,");// 就诊编码
		sqlsb.append(" IP.CODE_AMR_IP AS CODE_AMR_IP,");// 住院号
		sqlsb.append(" IP.TIMES_IP AS TIMES_IP,");// 住院次数
		sqlsb.append(" ENT.ID_ENT AS ID_ENT, ");// 就诊id
		sqlsb.append(" CASE WHEN ENT.SV > IP.SV THEN ENT.SV ELSE IP.SV END UPDATE_TIME ");//更新时间
		sqlsb.append(" FROM EN_ENT ENT");
		sqlsb.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT");
		sqlsb.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
		sqlsb.append(" WHERE ").append(SqlUtils.getInSqlByIds("ENT.ID_ENT", entIds));
		List<EntDepTransDTO> results = (List<EntDepTransDTO>) new DAFacade().execQuery(sqlsb.toString(), param,
				new BeanListHandler(EntDepTransDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new EntDepTransDTO[0]);
	}

	/**
	 * 查询医保详细信息
	 * 
	 * @param list
	 * @param entIds
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private EntDepTransItemsDTO[] getEntDepTransBeanSql(String[] entIds) throws BizException {
		if (ArrayUtil.isEmpty(entIds))
			return null;
		StringBuilder sqlSBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlSBuilder.append(" SELECT TRANS.ID_ENT AS ID_ENT,");// 就诊iD
		sqlSBuilder.append(" DEP.CODE  AS CODE_DEP_FROM,");// 原科室编码
		sqlSBuilder.append(" DEP.NAME  AS NAME_DEP_FROM ,");// 原科室名称
		sqlSBuilder.append(" DEPNUR.CODE AS CODE_NUR_FROM ,");// 原病区编码
		sqlSBuilder.append(" DEPNUR.NAME AS NAME_NUR_FROM ,");// 原病区名称
		sqlSBuilder.append(" DEPBED.CODE AS CODE_BED_FROM,");// 原床位编码
		sqlSBuilder.append(" DEPBED.NAME AS NAME_BED_FROM,");// 原床位名称
		sqlSBuilder.append(" DEPTO.CODE AS CODE_DEP_TO,");// 目标科室编码
		sqlSBuilder.append(" DEPTO.NAME AS NAME_DEP_TO,");// 目标科室名称
		sqlSBuilder.append(" DEPNURTO.CODE AS CODE_NUR_TO,");// 目标病区编码
		sqlSBuilder.append(" DEPNURTO.NAME AS NAME_NUR_TO ,");// 目标病区名称
		sqlSBuilder.append(" DEPBEDTO.CODE AS CODE_BED_TO ,");// 目标床位编码
		sqlSBuilder.append(" DEPBEDTO.NAME AS NAME_BED_TO ,");// 目标床位名称
		sqlSBuilder.append(" TRANS.DT_APPLY,");// 转科申请时间
		sqlSBuilder.append(" TRANS.DT_ACPT,");// 转科接收时间
		sqlSBuilder.append(" PSNDOCFROM.CODE AS CODE_EMP_APPL,");// 申请人操作编码
		sqlSBuilder.append(" PSNDOCFROM.NAME AS NAME_EMP_APPL,");// 申请操作人名称
		sqlSBuilder.append(" PSNDOCTO.CODE AS CODE_EMP_ACPT,");// 接受操作人编码
		sqlSBuilder.append(" PSNDOCTO.NAME AS NAME_EMP_ACPT ");// 接受操作人名称

		sqlSBuilder.append(" FROM EN_DEP_TRANS TRANS ");
		sqlSBuilder.append(" LEFT JOIN BD_DEP DEP ON  DEP.ID_DEP = TRANS.ID_DEP_FROM ");
		sqlSBuilder.append(" LEFT JOIN BD_DEP DEPNUR ON DEPNUR.ID_DEP = TRANS.ID_DEP_NUR_FROM  ");
		sqlSBuilder.append(" LEFT JOIN BD_BED DEPBED ON DEPBED.ID_BED = TRANS.ID_BED_FROM ");

		sqlSBuilder.append(" LEFT JOIN BD_DEP DEPTO ON  DEPTO.ID_DEP = TRANS.ID_DEP_TO  ");
		sqlSBuilder.append(" LEFT JOIN BD_DEP DEPNURTO ON DEPNURTO.ID_DEP = TRANS.ID_DEP_NUR_TO ");
		sqlSBuilder.append(" LEFT JOIN BD_BED DEPBEDTO ON DEPBEDTO.ID_BED = TRANS.ID_BED_TO ");

		sqlSBuilder.append(" LEFT JOIN BD_PSNDOC PSNDOCFROM  ON PSNDOCFROM.ID_PSNDOC = TRANS.ID_EMP_APPL ");
		sqlSBuilder.append(" LEFT JOIN BD_PSNDOC PSNDOCTO  ON PSNDOCTO.ID_PSNDOC = TRANS.ID_EMP_APPL ");
		sqlSBuilder.append(" WHERE ").append(SqlUtils.getInSqlByIds(" TRANS.ID_ENT ", entIds));
		sqlSBuilder.append(" AND TRANS.EU_TRANS = '1' ");
		List<EntDepTransItemsDTO> results = (List<EntDepTransItemsDTO>) new DAFacade().execQuery(sqlSBuilder.toString(),
				param, new BeanListHandler(EntDepTransItemsDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new EntDepTransItemsDTO[0]);
	}

	private EntDepTransResultDTO assemly(EntDepTransDTO[] ipDetailInfos, EntDepTransItemsDTO[] ipInfoItems) {
		EntDepTransResultDTO result = new EntDepTransResultDTO();
		if (!ArrayUtil.isEmpty(ipDetailInfos)) {
			for (EntDepTransDTO ipDetailInfo : ipDetailInfos) {
				if (!ArrayUtil.isEmpty(ipInfoItems)) {
					List<EntDepTransItemsDTO> ipItemsDTO2 = new ArrayList<EntDepTransItemsDTO>();
					for (EntDepTransItemsDTO ipInfoItemsDTO : ipInfoItems) {
						if (ipDetailInfo.getId_ent().equals(ipInfoItemsDTO.getId_ent())) {
							ipItemsDTO2.add(ipInfoItemsDTO);
						}
					}
					ipDetailInfo.setItems(ArrayListUtil.ConvertToFArrayList(ipItemsDTO2));
				}

			}
			result.setEntdeptransdto(ArrayListUtil.ConvertToFArrayList(ipDetailInfos));
		}
		return result;
	}
}
