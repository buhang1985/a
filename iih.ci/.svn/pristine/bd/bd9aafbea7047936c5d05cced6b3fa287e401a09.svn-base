package iih.ci.ord.s.external.provide.bp.cdss.repo;

import java.util.List;

import iih.ci.ord.i.external.provide.meta.cdss.PatInfoDTO;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.util.AgeCalcUtil;

/**
 * 患者信息数据服务
 * 
 * @author MaKunPeng
 *
 */
public class PatInfoRepository {

    /**
     * 根据上下文查找患者信息
     * 
     * @param ctx
     * @return
     * @throws BizException 
     */
    public PatInfoDTO findPatInfoByIdEn(String id_en) throws BizException {
        
        PatiVisitDO patiVisitDO = ServiceFinder.find(IPativisitRService.class).findById(id_en);
        if (patiVisitDO == null) {
            throw new BizException("未查询到就诊ID对应的信息");
        }
        SqlParamBuilder sql = null;
        // 判断就诊类型
        switch (patiVisitDO.getCode_entp()) {
        case "00":
            sql = createOpSql(id_en);
            break;
        case "10":
            sql = createIpSql(id_en);
            break;
        default:
            break;
        }
        
        List<PatInfoDTO> rst = sql.Q(PatInfoDTO.class);
        
        if (rst == null || rst.size() == 0) {
            return null;
        }
        
        // 重设部分属性
        PatInfoDTO patInfo = rst.get(0);
        // 年龄
        patInfo.setAge(AgeCalcUtil.getAge(new FDate(patInfo.getDt_birth())));
        
        return patInfo;
    }

    /**
     * 住院患者查询语句
     * @param ctx
     * @return
     */
    private SqlParamBuilder createIpSql(String id_en) {
        SqlParamBuilder sql = new SqlParamBuilder();
        sql.appendSql(" select entp.NAME     name_entp,")
           .appendSql("       entip.TIMES_IP    times_en,")
           .appendSql("       entip.CODE_AMR_IP     code_en,")
           .appendSql("       pat.CODE    pat_id,")
           .appendSql("       pat.NAME pat_name,")
           .appendSql("       pat.SD_SEX    sd_sex,")
           .appendSql("       sex.NAME  sex_name,")
           .appendSql("       pat.DT_BIRTH  dt_birth,")
           .appendSql("       occu.NAME     occupation,")
           .appendSql("       pripat.ID_PRIPAT    pripat_id,")
           .appendSql("       pripat.NAME   pripat_name,")
           .appendSql("       marry.NAME")
           .appendSql(" from en_ent ent")
           .appendSql("         inner join en_ent_ip entip on ent.ID_ENT = entip.ID_ENT")
           .appendSql("         inner join pi_pat pat on ent.ID_PAT = pat.ID_PAT")
           .appendSql("         left join bd_udidoc occu on pat.ID_OCCU = occu.ID_UDIDOC")
           .appendSql("         left join bd_udidoc marry on pat.ID_MARRY = marry.ID_UDIDOC")
           .appendSql("         left join bd_pri_pat pripat on pat.ID_PATPRITP = pripat.ID_PRIPAT")
           .appendSql("         left join bd_udidoc sex on ent.ID_SEX_PAT = sex.ID_UDIDOC")
           .appendSql("         inner join bd_entp entp on ent.ID_ENTP = entp.ID_ENTP")
           .appendSqlParam(" where ent.ID_ENT = ?", id_en);
        
        return sql;
    }

    /**
     * 门诊患者查询语句
     * @param ctx
     * @return
     */
    private SqlParamBuilder createOpSql(String id_en) {
        SqlParamBuilder sql = new SqlParamBuilder();
        sql.appendSql("select entp.NAME     name_entp,")
           .appendSql("       entop.TIMES_OP    times_en,")
           .appendSql("       ent.CODE    code_en,")
           .appendSql("       pat.CODE    pat_id,")
           .appendSql("       pat.NAME pat_name,")
           .appendSql("       pat.SD_SEX    sd_sex,")
           .appendSql("       sex.NAME  sex_name,")
           .appendSql("       pat.DT_BIRTH  dt_birth,")
           .appendSql("       occu.NAME     occupation,")
           .appendSql("       pripat.ID_PRIPAT    pripat_id,")
           .appendSql("       pripat.NAME   pripat_name,")
           .appendSql("       marry.NAME")
           .appendSql("from en_ent ent")
           .appendSql("         inner join en_ent_op entop on ent.ID_ENT = entop.ID_ENT")
           .appendSql("         inner join pi_pat pat on ent.ID_PAT = pat.ID_PAT")
           .appendSql("         left join bd_udidoc occu on pat.ID_OCCU = occu.ID_UDIDOC")
           .appendSql("         left join bd_udidoc marry on pat.ID_MARRY = marry.ID_UDIDOC")
           .appendSql("         left join bd_udidoc sex on ent.ID_SEX_PAT = sex.ID_UDIDOC")
           .appendSql("         left join bd_pri_pat pripat on pat.ID_PATPRITP = pripat.ID_PRIPAT")
           .appendSql("         inner join bd_entp entp on ent.ID_ENTP = entp.ID_ENTP")
           .appendSqlParam("where ent.ID_ENT = ?", id_en);
        
        return sql;
    }
}
