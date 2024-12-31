package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.SqlUtils;
import iih.ei.std.d.v1.en.enstate.d.CodeEntsParamDTO;
import iih.ei.std.d.v1.en.ipenthpinfodto.d.IpEntHpInfoDTO;
import iih.ei.std.d.v1.en.ipenthpinfodto.d.IpEntHpInfoItemsDTO;
import iih.ei.std.d.v1.en.ipenthpinfodto.d.IpEntHpInfoResultDTO;
import iih.ei.std.d.v1.utils.EiAppUtils;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院患者医保信息
 * @author lilei
 *
 */
public class GetIpEntHpInfoBP extends IIHServiceBaseBP<CodeEntsParamDTO,IpEntHpInfoResultDTO>{

	@Override
	protected void checkParam(CodeEntsParamDTO param) throws BizException {
		if (StringUtil.isEmptyWithTrim(param.getCode_ents())) {
			throw new BizException("就诊编码不能为空");
		}
	}

	@Override
	protected IpEntHpInfoResultDTO process(CodeEntsParamDTO param) throws BizException {
		// 1.查询住院患者id_ent
		GetIpInfoUtilsBP getIpInfoUtilsBP = new GetIpInfoUtilsBP();
		String[] entIds = getIpInfoUtilsBP.getEntIds(param.getCode_ents().split(","));
		IpEntHpInfoDTO[] ipEntHpInfoDTOs = getIpDetailInfo(entIds);
		IpEntHpInfoItemsDTO[] ipEntHpInfoItemsDTOs = getEntHpBeanSql(entIds);
		return assemly(ipEntHpInfoDTOs, ipEntHpInfoItemsDTOs);
	}
	
	@SuppressWarnings("unchecked")
	protected IpEntHpInfoDTO[] getIpDetailInfo(String[] entIds) throws DAException {
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
		List<IpEntHpInfoDTO> results = (List<IpEntHpInfoDTO>) new DAFacade().execQuery(sqlsb.toString(), param,
				new BeanListHandler(IpEntHpInfoDTO.class));
		return ListUtil.isEmpty(results) ? null : results.toArray(new IpEntHpInfoDTO[0]);
	}
	
	/**
     * 查询医保详细信息
     * 
     * @param list
     * @param entIds
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
	private IpEntHpInfoItemsDTO[] getEntHpBeanSql(String[] entIds) throws BizException {
    	if(ArrayUtil.isEmpty(entIds))
    		return null;
    	StringBuilder sqlSBuilder = new StringBuilder();
    	SqlParam param = new SqlParam();
        sqlSBuilder.append(" SELECT ENTHP.ID_ENT AS ID_ENT,");//就诊iD
        sqlSBuilder.append(" ENTHP.SORTNO AS SORTNO,");//医保编号
        sqlSBuilder.append(" UDIDOC.CODE AS SD_HPTP ,");//医保类型
        sqlSBuilder.append(" HP.CODE AS CODE_HP ,");//医保计划编码
        sqlSBuilder.append(" HP.NAME AS NAME_HP ,");//医保计划名称
        sqlSBuilder.append(" ENTHP.NO_HP,");//医保号
        sqlSBuilder.append(" ENTHP.PERSONNO,");//个人编码
        sqlSBuilder.append(" ENTHP.FG_MAJ,");//主医保标识
        sqlSBuilder.append(" ENTHP.FG_HP_CARD,");//持卡结算标识
        sqlSBuilder.append(" ENTHP.FG_FUNDPAY,");//医保基金支付标识
        sqlSBuilder.append(" ENTHP.FG_HPSPCL,");//特病标识
        sqlSBuilder.append(" ENTHP.CODE_HPKIND ,");//险种编码
        sqlSBuilder.append(" ENTHP.CODE_HPPATCA,");//医保身份编码
        sqlSBuilder.append(" ENTHP.CODE_HPAREA,");//医保统筹区
        sqlSBuilder.append(" ENT.CODE_HPMEDKIND AS CODE_HPMEDKIND");//疑似医疗类别编码
        
        sqlSBuilder.append(" FROM EN_ENT_HP ENTHP");
        sqlSBuilder.append(" INNER JOIN BD_HP HP ON HP.ID_HP = ENTHP.ID_HP ");
        sqlSBuilder.append(" LEFT JOIN BD_UDIDOC UDIDOC ON UDIDOC.ID_UDIDOC = HP.ID_HPTP  ");
        sqlSBuilder.append(" LEFT JOIN EN_ENT ENT  ON ENT.ID_ENT = ENTHP.ID_ENT  ");
        sqlSBuilder.append(" WHERE ").append(SqlUtils.getInSqlByIds(" ENTHP.ID_ENT ", entIds));
        List<IpEntHpInfoItemsDTO> results = (List<IpEntHpInfoItemsDTO>) new DAFacade().execQuery(sqlSBuilder.toString(), param, new BeanListHandler(IpEntHpInfoItemsDTO.class));
        return ListUtil.isEmpty(results) ? null : results.toArray(new IpEntHpInfoItemsDTO[0]);
    }
    
    private IpEntHpInfoResultDTO assemly(IpEntHpInfoDTO[] ipDetailInfos, IpEntHpInfoItemsDTO[] ipInfoItems) {
    	IpEntHpInfoResultDTO result = new IpEntHpInfoResultDTO();
		if (!ArrayUtil.isEmpty(ipDetailInfos)) {
			for (IpEntHpInfoDTO ipDetailInfo : ipDetailInfos) {
				if (!ArrayUtil.isEmpty(ipInfoItems)) {
					List<IpEntHpInfoItemsDTO> ipItemsDTO2 = new ArrayList<IpEntHpInfoItemsDTO>();
					for (IpEntHpInfoItemsDTO ipInfoItemsDTO : ipInfoItems) {
						if (ipDetailInfo.getId_ent().equals(ipInfoItemsDTO.getId_ent())) {
							ipItemsDTO2.add(ipInfoItemsDTO);
						}
					}
					ipDetailInfo.setItems(ArrayListUtil.ConvertToFArrayList(ipItemsDTO2));
				}

			}
			result.setIpenthpinfo(ArrayListUtil.ConvertToFArrayList(ipDetailInfos));
		}
		return result;
	}

}
