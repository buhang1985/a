package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.SqlUtils;
import iih.ei.std.d.v1.en.enstate.d.CodeEntsParamDTO;
import iih.ei.std.d.v1.en.enstate.d.EnStateDTO;
import iih.ei.std.d.v1.en.enstate.d.EnStateItemsDTO;
import iih.ei.std.d.v1.en.enstate.d.EnStateResultDTO;
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
 * 获取住院患者状况值
 * @author lilei
 *
 */
public class GetIpEntStateInfoBP extends IIHServiceBaseBP<CodeEntsParamDTO, EnStateResultDTO> {

	@Override
	protected void checkParam(CodeEntsParamDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(param.getCode_ents())) {
			throw new BizException("就诊编码不能为空");
		}
	}

	@Override
	protected EnStateResultDTO process(CodeEntsParamDTO param) throws BizException {
		GetIpInfoUtilsBP getIpInfoUtilsBP = new GetIpInfoUtilsBP();
		String[] entIds = getIpInfoUtilsBP.getEntIds(param.getCode_ents().split(","));
		EnStateDTO[] ipInfoDTOs = getIpDetailInfo(entIds);
		EnStateItemsDTO[] ipInfoItemsDTOs = getStateInfo(entIds);
		return assemly(ipInfoDTOs, ipInfoItemsDTOs);
	}
	
	@SuppressWarnings("unchecked")
	protected EnStateDTO[] getIpDetailInfo(String[] entIds) throws DAException {
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
		List<EnStateDTO> results = (List<EnStateDTO>) new DAFacade().execQuery(sqlsb.toString(), param,
				new BeanListHandler(EnStateDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new EnStateDTO[0]);
	}
	
	/**
	 * 查询就诊状况详细信息
	 * 
	 * @param list
	 * @param entIds
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private EnStateItemsDTO[] getStateInfo(String[] entIds) throws BizException {
		if (ArrayUtil.isEmpty(entIds))
			return null;
		SqlParam param = new SqlParam();
		StringBuilder statesql = new StringBuilder();		
		statesql.append(" SELECT ");
		statesql.append(" STATE.ID_ENT,");//患者就诊id
		statesql.append(" STATE.SD_ENSTATETP AS SD_ENSTATETP ,");// 就诊状况类型编码
		statesql.append(" DOC.NAME AS NAME_ENSTATETP ,");// 就诊状况类型名称
		statesql.append(" STATE.VAL AS VAL ,");// 就诊状况值
		statesql.append(" BE_STATE.NAME AS NAME,");//就诊状况值名称
		statesql.append(" STATE.DT_OCC AS DT_OCC ");// 发生时间
		statesql.append(" FROM EN_ENT_STATE STATE ");//
		statesql.append(" INNER JOIN BD_UDIDOC DOC ON DOC.ID_UDIDOC = STATE.ID_ENSTATETP ");
		statesql.append("  INNER JOIN BD_EN_STATE BE_STATE ON STATE.ID_ENSTATETP = BE_STATE.ID_ENSTATETP AND BE_STATE.VAL = STATE.VAL" );
		statesql.append(" WHERE ").append(SqlUtils.getInSqlByIds("STATE.ID_ENT", entIds));
		List<EnStateItemsDTO> results = (List<EnStateItemsDTO>) new DAFacade().execQuery(statesql.toString(), param, new BeanListHandler(EnStateItemsDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new EnStateItemsDTO[0]);
	}
	
	private EnStateResultDTO assemly(EnStateDTO[] ipDetailInfos, EnStateItemsDTO[] ipInfoItems) {
		EnStateResultDTO result = new EnStateResultDTO();
		if (!ArrayUtil.isEmpty(ipDetailInfos)) {
			for (EnStateDTO ipDetailInfo : ipDetailInfos) {
				if (!ArrayUtil.isEmpty(ipInfoItems)) {
					List<EnStateItemsDTO> ipItemsDTO2 = new ArrayList<EnStateItemsDTO>();
					for (EnStateItemsDTO ipInfoItemsDTO : ipInfoItems) {
						if (ipDetailInfo.getId_ent().equals(ipInfoItemsDTO.getId_ent())) {
							ipItemsDTO2.add(ipInfoItemsDTO);
						}
					}
					ipDetailInfo.setItems(ArrayListUtil.ConvertToFArrayList(ipItemsDTO2));
				}

			}
			result.setEnstatedto(ArrayListUtil.ConvertToFArrayList(ipDetailInfos));
		}
		return result;
	}

}
