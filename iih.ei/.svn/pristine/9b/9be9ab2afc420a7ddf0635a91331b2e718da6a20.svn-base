package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.SqlUtils;
import iih.ei.std.d.v1.en.enstate.d.CodeEntsParamDTO;
import iih.ei.std.d.v1.en.entbeddto.d.EntBedDTO;
import iih.ei.std.d.v1.en.entbeddto.d.EntBedItemsDTO;
import iih.ei.std.d.v1.en.entbeddto.d.EntBedResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIpEntBedInfoBP extends IIHServiceBaseBP<CodeEntsParamDTO, EntBedResultDTO> {

	@Override
	protected void checkParam(CodeEntsParamDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(param.getCode_ents())) {
			throw new BizException("就诊编码不能为空");
		}
	}

	@Override
	protected EntBedResultDTO process(CodeEntsParamDTO param) throws BizException {
		GetIpInfoUtilsBP getIpInfoUtilsBP = new GetIpInfoUtilsBP();
		String[] entIds = getIpInfoUtilsBP.getEntIds(param.getCode_ents().split(","));
		EntBedDTO[] ipInfoDTOs = getIpDetailInfo(entIds);
		EntBedItemsDTO[] ipInfoItemsDTOs = getEntBedInfo(entIds);
		return assemly(ipInfoDTOs, ipInfoItemsDTOs);
	}
	
	@SuppressWarnings("unchecked")
	protected EntBedDTO[] getIpDetailInfo(String[] entIds) throws DAException {
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
		List<EntBedDTO> results = (List<EntBedDTO>) new DAFacade().execQuery(sqlsb.toString(), param,
				new BeanListHandler(EntBedDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new EntBedDTO[0]);
	}
	
	/**
	 * 查询就诊床位详细信息
	 * 
	 * @param list
	 * @param entIds
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private EntBedItemsDTO[] getEntBedInfo(String[] entIds) throws BizException {
		if(ArrayUtil.isEmpty(entIds))
    		return null;
		SqlParam param = new SqlParam();
    	StringBuilder entbedsql = new StringBuilder();
    	entbedsql.append(" SELECT ");
    	//entbedsql.append(" ");//编号
    	entbedsql.append(" BED.ID_ENT,");//就诊id
    	entbedsql.append(" BB.CODE AS CODE_BED,");//床位编码
    	entbedsql.append(" BB.NAME AS NAME_BED, ");//床位名称
    	entbedsql.append(" DEP.CODE AS CODE_DEP_NUR,");//所属病区编码
    	entbedsql.append(" DEP.NAME AS NAME_DEP_NUR,");//所属病区名称
    	entbedsql.append(" SD_USETYPE , ");//占用类型编码
    	entbedsql.append(" DOC.NAME AS NAME_USETYPE, ");//占用类型名称
    	entbedsql.append(" BED.DT_B AS DT_B, ");//开始时间
    	entbedsql.append(" BED.DT_E AS DT_E, ");//结束时间
    	entbedsql.append(" BED.DT_CHG_BILL AS DT_CHG_BILL");//最近收费时间
    	entbedsql.append(" FROM EN_ENT_BED BED ");
    	entbedsql.append(" INNER JOIN BD_DEP DEP ON DEP.ID_DEP = BED.ID_DEP_WRD ");
    	entbedsql.append(" INNER JOIN BD_BED BB ON BB.ID_BED = BED.ID_BED ");
    	entbedsql.append(" LEFT JOIN BD_UDIDOC DOC ON DOC.ID_UDIDOC = BED.ID_USETYPE ");
    	entbedsql.append(" WHERE ").append(SqlUtils.getInSqlByIds(" BED.ID_ENT ", entIds));
		List<EntBedItemsDTO> results = (List<EntBedItemsDTO>) new DAFacade().execQuery(entbedsql.toString(), param, new BeanListHandler(EntBedItemsDTO.class));
        return ListUtil.isEmpty(results) ? null : results.toArray(new EntBedItemsDTO[0]);

	}
	
	private EntBedResultDTO assemly(EntBedDTO[] ipDetailInfos, EntBedItemsDTO[] ipInfoItems) {
		EntBedResultDTO result = new EntBedResultDTO();
		if (!ArrayUtil.isEmpty(ipDetailInfos)) {
			for (EntBedDTO ipDetailInfo : ipDetailInfos) {
				if (!ArrayUtil.isEmpty(ipInfoItems)) {
					List<EntBedItemsDTO> ipItemsDTO2 = new ArrayList<EntBedItemsDTO>();
					for (EntBedItemsDTO ipInfoItemsDTO : ipInfoItems) {
						if (ipDetailInfo.getId_ent().equals(ipInfoItemsDTO.getId_ent())) {
							ipItemsDTO2.add(ipInfoItemsDTO);
						}
					}
					ipDetailInfo.setItems(ArrayListUtil.ConvertToFArrayList(ipItemsDTO2));
				}

			}
			result.setEntbeddto(ArrayListUtil.ConvertToFArrayList(ipDetailInfos));
		}
		return result;
	}
	
}
