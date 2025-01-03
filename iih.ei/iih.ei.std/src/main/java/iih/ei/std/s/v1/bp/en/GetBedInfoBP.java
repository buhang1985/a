package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.bedinfo.d.BedInfoDTO;
import iih.ei.std.d.v1.en.bedinfo.d.BedInfoParamDTO;
import iih.ei.std.d.v1.en.bedinfo.d.BedInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取病区床位列表
 * @author lilei
 *
 */
public class GetBedInfoBP extends IIHServiceBaseBP<BedInfoParamDTO, BedInfoResultDTO> {

	@Override
	protected void checkParam(BedInfoParamDTO param) throws BizException {
	}

	@Override
	protected BedInfoResultDTO process(BedInfoParamDTO param) throws BizException {
		BedInfoDTO[] data = getData(param);
		BedInfoResultDTO bedInfoResultDTO = new BedInfoResultDTO();
		bedInfoResultDTO.setBedinfodto(ArrayListUtil.ConvertToFArrayList(data));
		return bedInfoResultDTO;
	}
	
	/**
     * 根据科室编码查询床位信息
     * @param nurCode
     * @return
     */
    @SuppressWarnings("unchecked")
    private BedInfoDTO[] getData(BedInfoParamDTO param) throws BizException  {
    	String[] nurCodes = null;
    	if(!StringUtil.isEmptyWithTrim(param.getCode_nur())){
    		nurCodes = param.getCode_nur().split(",");
    	}
       SqlParam sqlParam = new SqlParam();
       String sql = this.getSql(nurCodes,sqlParam);
       PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
	   List<BedInfoDTO> results = this.findPagingData(pageInfoDto,sql, sqlParam, BedInfoDTO.class);
       return ListUtil.isEmpty(results) ? null : results.toArray(new BedInfoDTO[0]);
    }
    
    /**
     * 获取sql
     * @param nurCode
     * @return
     */
    private String getSql(String[] nurCodes,SqlParam param) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT");
        sql.append(" BED.ID_DEP_BELONG AS ID_DEP,");
        sql.append(" DEP.CODE AS CODE_DEP,");
        sql.append(" DEP.NAME AS NAME_DEP,");
        sql.append(" BED.CODE AS CODE_BED,");
        sql.append(" BED.NAME AS NAME_BED,");
        sql.append(" BED.SD_BEDSU AS SD_STATUS");
        sql.append(" FROM BD_BED BED");
        sql.append(" INNER JOIN BD_DEP DEP ON DEP.ID_DEP = BED.ID_DEP_BELONG");
        sql.append(" WHERE BED.FG_ACT = ? AND BED.SD_BEDSU IN (?, ?, ?, ?, ?)");
        param.addParam(FBoolean.TRUE);
        param.addParam(IBdResDictCodeConst.SD_BEDSU_EMPTY);
        param.addParam(IBdResDictCodeConst.SD_BEDSU_USEDBYPATIENT);
        param.addParam(IBdResDictCodeConst.SD_BEDSU_RENT);
        param.addParam(IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN);
        param.addParam(IBdResDictCodeConst.SD_BEDSU_CLEAN);
        if ( !ArrayUtil.isEmpty(nurCodes)) {
            String inSqlByIds = SqlUtils.getInSqlByIds("DEP.CODE", nurCodes);
            if ( !StringUtil.isEmptyWithTrim(inSqlByIds)) {
                sql.append(" AND  ");
                sql.append(inSqlByIds);
            }
        }
        return sql.toString();
    }
}
