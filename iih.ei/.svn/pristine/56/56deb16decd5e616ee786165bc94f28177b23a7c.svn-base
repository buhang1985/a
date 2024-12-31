package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.SqlUtils;
import iih.ei.std.d.v1.en.enstate.d.CodeEntsParamDTO;
import iih.ei.std.d.v1.en.entcontdto.d.EntContDTO;
import iih.ei.std.d.v1.en.entcontdto.d.EntContItemsDTO;
import iih.ei.std.d.v1.en.entcontdto.d.EntContResultDTO;
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
 * 获取住院患者联系人信息
 * @author lilei
 *
 */
public class GetIpEntContInfoBP extends IIHServiceBaseBP<CodeEntsParamDTO, EntContResultDTO> {

	@Override
	protected void checkParam(CodeEntsParamDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(param.getCode_ents())) {
			throw new BizException("就诊编码不能为空");
		}
	}

	@Override
	protected EntContResultDTO process(CodeEntsParamDTO param) throws BizException {
		GetIpInfoUtilsBP getIpInfoUtilsBP = new GetIpInfoUtilsBP();
		String[] entIds = getIpInfoUtilsBP.getEntIds(param.getCode_ents().split(","));
		EntContDTO[] ipInfoDTOs = getIpDetailInfo(entIds);
		EntContItemsDTO[] ipInfoItemsDTOs = getEntContInfo(entIds);
		return assemly(ipInfoDTOs, ipInfoItemsDTOs);
	}

	@SuppressWarnings("unchecked")
	protected EntContDTO[] getIpDetailInfo(String[] entIds) throws DAException {
		if (ArrayUtil.isEmpty(entIds))
			return null;
		StringBuilder sqlsb = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlsb.append(" SELECT");
		sqlsb.append(" PAT.CODE AS CODE_PAT,");// 病人编码
		sqlsb.append(" ENT.CODE AS CODE_ENT,");// 就诊编码
		sqlsb.append(" IP.CODE_AMR_IP AS CODE_AMR_IP,");// 住院号
		sqlsb.append(" IP.TIMES_IP AS TIMES_IP,");// 住院次数
		sqlsb.append(" CASE WHEN ENT.SV > IP.SV THEN ENT.SV ELSE IP.SV END UPDATE_TIME, ");//更新时间
		sqlsb.append(" ENT.ID_ENT AS ID_ENT ");// 就诊id
		sqlsb.append(" FROM EN_ENT ENT");
		sqlsb.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT");
		sqlsb.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
		sqlsb.append(" WHERE ").append(SqlUtils.getInSqlByIds("ENT.ID_ENT", entIds));
		List<EntContDTO> results = (List<EntContDTO>) new DAFacade().execQuery(sqlsb.toString(), param,
				new BeanListHandler(EntContDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new EntContDTO[0]);
	}

	/**
	 * 查询就诊床位详细信息
	 * 
	 * @param list
	 * @param entIds
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private EntContItemsDTO[] getEntContInfo(String[] entIds) throws BizException {
		if (ArrayUtil.isEmpty(entIds))
			return null;
		StringBuilder entcontsql = new StringBuilder();
		SqlParam param = new SqlParam();
		entcontsql.append(" SELECT ");
		entcontsql.append(" CONT.ID_ENT,");// 就诊id
		entcontsql.append(" CONT.SORTNO AS SORTNO,");// 编号
		entcontsql.append(" CONT.EU_ENTCONTTP AS EU_ENTCONTTP,");// 就诊联系人类型
		entcontsql.append(" CONT.SD_CONTTP AS SD_CONTTP,");// 联系人类型编码
		entcontsql.append(" DOC.NAME AS NAME_CONTTP,");// 联系人类型名称
		entcontsql.append(" CONT.NAME AS NAME,");// 联系人名称
		entcontsql.append(" CONT.CONTTEL AS CONTTEL,");// 联系人电话
		entcontsql.append(" CONT.CONTADDR AS CONTADDR,");// 联系人地址
		entcontsql.append(" CONT.ZIP AS ZIP,");// 联系人邮编
		entcontsql.append(" CONT.SD_IDTP AS SD_IDTP,");// 证件类型
		entcontsql.append(" DOC.NAME AS NAME_IDTP,");// 证件类型名称
		entcontsql.append(" CONT.IDCODE AS IDCODE,");// 证件号
		entcontsql.append(" CONT.PYCODE AS PYCODE,");// 拼音码
		entcontsql.append(" CONT.WBCODE AS WBCODE");// 五笔码
		entcontsql.append(" FROM EN_ENT_CONT CONT ");
		entcontsql.append(" LEFT JOIN BD_UDIDOC DOC ON CONT.ID_CONTTP = DOC.ID_UDIDOC ");
		entcontsql.append(" AND CONT.ID_IDTP = DOC.ID_UDIDOC");
		entcontsql.append(" WHERE ").append(SqlUtils.getInSqlByIds("CONT.ID_ENT", entIds));
		List<EntContItemsDTO> results = (List<EntContItemsDTO>) new DAFacade().execQuery(entcontsql.toString(), param,
				new BeanListHandler(EntContItemsDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new EntContItemsDTO[0]);

	}

	private EntContResultDTO assemly(EntContDTO[] ipDetailInfos, EntContItemsDTO[] ipInfoItems) {
		EntContResultDTO result = new EntContResultDTO();
		if (!ArrayUtil.isEmpty(ipDetailInfos)) {
			for (EntContDTO ipDetailInfo : ipDetailInfos) {
				if (!ArrayUtil.isEmpty(ipInfoItems)) {
					List<EntContItemsDTO> ipItemsDTO2 = new ArrayList<EntContItemsDTO>();
					for (EntContItemsDTO ipInfoItemsDTO : ipInfoItems) {
						if (ipDetailInfo.getId_ent().equals(ipInfoItemsDTO.getId_ent())) {
							ipItemsDTO2.add(ipInfoItemsDTO);
						}
					}
					ipDetailInfo.setItems(ArrayListUtil.ConvertToFArrayList(ipItemsDTO2));
				}

			}
			result.setEntcontdto(ArrayListUtil.ConvertToFArrayList(ipDetailInfos));
		}
		return result;
	}

}
