package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.SqlUtils;
import iih.ei.std.d.v1.en.ipentdiinfo.d.IpEntDiInfoDTO;
import iih.ei.std.d.v1.en.opentdiinfodto.d.OpEntDiInfoDTO;
import iih.ei.std.d.v1.en.opentdiinfodto.d.OpEntDiInfoItemDTO;
import iih.ei.std.d.v1.en.opentdiinfodto.d.OpEntDiInfoParamDTO;
import iih.ei.std.d.v1.en.opentdiinfodto.d.OpEntDiInfoResultDTO;
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
 * 根据就诊编码查询患者门诊诊断信息
 * @author li.wm
 *
 */
public class GetOpEntDiInfoBP extends IIHServiceBaseBP<OpEntDiInfoParamDTO, OpEntDiInfoResultDTO> {

	@Override
	protected void checkParam(OpEntDiInfoParamDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(param.getCode_ents())) {
			throw new BizException("就诊编码不能为空");
		}
	}

	@Override
	protected OpEntDiInfoResultDTO process(OpEntDiInfoParamDTO param) throws BizException {
		// 1.查询住院患者id_ent
		GetIpInfoUtilsBP getIpInfoUtilsBP = new GetIpInfoUtilsBP();
		String[] entIds = getIpInfoUtilsBP.getEntIds(param.getCode_ents().split(","));
		OpEntDiInfoDTO[] ipDetailInfo = getIpDetailInfo(entIds);
		OpEntDiInfoItemDTO[] ipEntDiInfoItems = getEntDiBeanSql(entIds);
		return assemly(ipDetailInfo, ipEntDiInfoItems);
	}

	@SuppressWarnings("unchecked")
	protected OpEntDiInfoDTO[] getIpDetailInfo(String[] entIds) throws DAException {
		if (ArrayUtil.isEmpty(entIds))
			return null;
		StringBuilder sqlsb = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlsb.append(" SELECT");
		sqlsb.append(" PAT.CODE AS CODE_PAT,");// 病人编码
		sqlsb.append(" PAT.NAME AS NAME_PAT,");// 病人编码
		sqlsb.append(" ENT.CODE AS CODE_ENT,");// 就诊编码
		sqlsb.append(" OP.TIMES_OP AS TIMES_OP,");// 住院次数
		sqlsb.append(" ENT.ID_ENT AS ID_ENT, ");// 就诊id
		sqlsb.append(" CASE WHEN ENT.SV > OP.SV THEN ENT.SV ELSE OP.SV END UPDATE_TIME ");//更新时间
		sqlsb.append(" FROM EN_ENT ENT");
		sqlsb.append(" INNER JOIN EN_ENT_OP OP ON OP.ID_ENT = ENT.ID_ENT");
		sqlsb.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
		sqlsb.append(" WHERE ").append(SqlUtils.getInSqlByIds("ENT.ID_ENT", entIds));
		List<OpEntDiInfoDTO> results = (List<OpEntDiInfoDTO>) new DAFacade().execQuery(sqlsb.toString(), param,
				new BeanListHandler(OpEntDiInfoDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new OpEntDiInfoDTO[0]);
	}

	/**
	 * 查询诊断详细信息
	 * 
	 * @param list
	 * @param entIds
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private OpEntDiInfoItemDTO[] getEntDiBeanSql(String[] entIds) throws BizException {
		if (ArrayUtil.isEmpty(entIds))
			return null;
		StringBuilder sqlSBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlSBuilder.append(" SELECT ENTDI.ID_ENT AS ID_ENT,");// 就诊iD
		sqlSBuilder.append(" ENTDI.SORTNO AS SORTNO,");// 就诊编号
		sqlSBuilder.append(" UDIDOC.CODE AS SD_CDSYSTP ,");// 诊断学科类型编码
		sqlSBuilder.append(" UDIDOC.NAME AS NAME_CDSYSTP ,");// 诊断学科类型名称
		sqlSBuilder.append(" DIDEF.CODE AS CODE_DIDEF_DIS ,");// 诊断编码
		sqlSBuilder.append(" DIDEF.NAME AS NAME_DIDEF_DIS,");// 诊断名称
		sqlSBuilder.append(" ENTDI.SUPPLEMENT,");// 诊断补充说明
		sqlSBuilder.append(" ENTDI.FG_MAJ,");// 主要诊断标识
		sqlSBuilder.append(" ENTDI.DT_DIAG,");// 诊断时间
		sqlSBuilder.append(" PSNDOC.CODE AS CODE_EMP_PHY,");// 诊断医生编码
		sqlSBuilder.append(" PSNDOC.NAME AS NAME_EMP_PHY,");// 诊断医生名称
		sqlSBuilder.append(" ENTDI.FG_CURED,");// 治愈标识
		sqlSBuilder.append(" DITP.CODE AS SD_DITP,");// 诊断过程编码
		sqlSBuilder.append(" DITP.NAME AS NAME_DITP,");// 诊断过程状态名称
		sqlSBuilder.append(" ENTDI.FG_SUSPDI,");// 疑似诊断表示
		sqlSBuilder.append(" DIDEFSYN.CODE AS CODE_DIDEF_SYN,");// 证候诊断编码
		sqlSBuilder.append(" ENTDI.NAME_DIDEF_SYN,");// 证候诊断名称
		sqlSBuilder.append(" DEP.CODE AS CODE_DEP  ,");// 诊断科室编码
		sqlSBuilder.append(" DEP.NAME AS NAME_DEP,");// 诊断科室名称
		sqlSBuilder.append(" ENTDI.FG_SELF ,");// 自定义标识
		sqlSBuilder.append(" ENTDI.FG_CHRONIC,");// 慢性病标识
		sqlSBuilder.append(" ENTDI.FG_SPECIAL,");// 特种病标识
		sqlSBuilder.append(" INFECTIONTP.CODE AS SD_INFECTIONTP,");// 传染病种类编码
		sqlSBuilder.append(" INFECTIONTP.NAME AS NAME_INFECTIONTP,");// 传染病种类
		sqlSBuilder.append(" ENTDI.FG_UR ");// 上传标识
		sqlSBuilder.append(" FROM EN_ENT_DI ENTDI");
		sqlSBuilder.append(" LEFT JOIN BD_DI_DEP DIDEP  ON  ENTDI.ID_ENT = DIDEP.ID_DEP ");
		sqlSBuilder.append(" LEFT JOIN BD_PSNDOC PSNDOC ON PSNDOC.ID_PSNDOC = ENTDI.ID_EMP_PHY ");
		sqlSBuilder.append(" LEFT JOIN BD_DI_DEF DIDEF ON DIDEF.ID_DIDEF = ENTDI.ID_DIDEF_DIS");
		sqlSBuilder.append(" LEFT JOIN BD_DI_DEF DIDEFSYN ON DIDEFSYN.ID_DIDEF = ENTDI.ID_DIDEF_SYN");
		sqlSBuilder.append(" LEFT JOIN BD_UDIDOC UDIDOC ON UDIDOC.ID_UDIDOC = ENTDI.ID_CDSYSTP ");
		sqlSBuilder.append(" LEFT JOIN BD_UDIDOC DITP ON DITP.ID_UDIDOC = ENTDI.ID_DITP ");
		sqlSBuilder.append(" LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = ENTDI.ID_DEP ");
		sqlSBuilder.append(" LEFT JOIN BD_UDIDOC INFECTIONTP ON INFECTIONTP.ID_UDIDOC = ENTDI.ID_INFECTIONTP ");
		sqlSBuilder.append(" WHERE ").append(SqlUtils.getInSqlByIds(" ENTDI.ID_ENT ", entIds));
		List<OpEntDiInfoItemDTO> results = (List<OpEntDiInfoItemDTO>) new DAFacade().execQuery(sqlSBuilder.toString(),
				param, new BeanListHandler(OpEntDiInfoItemDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new OpEntDiInfoItemDTO[0]);
	}

	private OpEntDiInfoResultDTO assemly(OpEntDiInfoDTO[] ipDetailInfos, OpEntDiInfoItemDTO[] ipEntDiInfoItems) {
		OpEntDiInfoResultDTO result = new OpEntDiInfoResultDTO();
		if (!ArrayUtil.isEmpty(ipDetailInfos)) {
			for (OpEntDiInfoDTO ipDetailInfo : ipDetailInfos) {
				if (!ArrayUtil.isEmpty(ipEntDiInfoItems)) {
					List<OpEntDiInfoItemDTO> ipEntDiInfoItemsDTO2 = new ArrayList<OpEntDiInfoItemDTO>();
					for (OpEntDiInfoItemDTO ipEntDiInfoItemsDTO : ipEntDiInfoItems) {
						if (ipDetailInfo.getId_ent().equals(ipEntDiInfoItemsDTO.getId_ent())) {
							ipEntDiInfoItemsDTO2.add(ipEntDiInfoItemsDTO);
						}
					}
					ipDetailInfo.setItems(ArrayListUtil.ConvertToFArrayList(ipEntDiInfoItemsDTO2));
				}

			}
			result.setOpentdidto(ArrayListUtil.ConvertToFArrayList(ipDetailInfos));
		}
		return result;
	}

}
