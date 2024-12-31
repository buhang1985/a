package iih.ci.ord.s.external.provide.bp.cdss.repo;

import java.util.List;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.provide.meta.cdss.PsnInfoDTO;
import iih.ci.sdk.cache.BDDeptInfoCache;
import iih.ci.sdk.database.SqlParamBuilder;
import xap.mw.core.data.BizException;

/**
 * 人员信息数据服务
 * 
 * @author MaKunPeng
 *
 */
public class PsnInfoRepository {
    
    /**
     * 获取PsnInfo
     * 
     * @param id_psn
     * @return
     * @throws BizException
     */
    public PsnInfoDTO findPsnInfoByIdUserAndIdDep(String id_psn) throws BizException {
        SqlParamBuilder sql = new SqlParamBuilder();
        sql.appendSql(" select psn.ID_PSNDOC psn_id,")
        .appendSql(" psn.NAME psn_name,")
        .appendSql(" from bd_psndoc psn ")
        .appendSqlParam("where psn.id_psndoc = ?", id_psn);
        
        List<PsnInfoDTO> rst = sql.Q(PsnInfoDTO.class);
        
        return rst.get(0);
    }
}
