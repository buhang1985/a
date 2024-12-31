package iih.ci.preop.imp.bp.record;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.preop.imp.dto.TsOrIpOrAggDTO;
import iih.ci.tsip.d.CiTsOrMpDO;
import iih.ci.tsip.i.ICitsormpCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 生成治疗方案导入记录
 * 
 * @author mkp
 *
 */
public class ImportRecordBP {
    private CiEnContextDTO ctx;


    public ImportRecordBP(CiEnContextDTO ctx) {
        super();
        this.ctx = ctx;
    }


    public void saveImportRecord(List<TsOrIpOrAggDTO> tsIpAggDTOs, String id_dep_oper, String id_emp_oper,
            FDateTime dt_oper, String eu_mpmd) throws BizException {
        List<CiTsOrMpDO> records = new ArrayList<>();
        
        if (tsIpAggDTOs == null) {
            return;
        }
        
        for (TsOrIpOrAggDTO item : tsIpAggDTOs) {
            CiTsOrMpDO tsOrMpDO = new CiTsOrMpDO();
            String id_tsormp = new DBUtil().getOIDs(1)[0];
            tsOrMpDO.setId_tsormp(id_tsormp);
            tsOrMpDO.setId_tsor(item.getTsOrDO().getId_tsor());
            tsOrMpDO.setId_or(item.getId_or());
            tsOrMpDO.setId_org_mp(ctx.getId_org());
            tsOrMpDO.setId_dep_mp(id_dep_oper);
            tsOrMpDO.setId_emp_mp(id_emp_oper);
            tsOrMpDO.setDt_mp(dt_oper);
            tsOrMpDO.setEu_mpmd(eu_mpmd);
            tsOrMpDO.setStatus(DOStatus.NEW);
            
            records.add(tsOrMpDO);
        }
        
        ServiceFinder.find(ICitsormpCudService.class).save(records.toArray(new CiTsOrMpDO[0]));
    }
    
    public void saveImportRecord(TsOrIpOrAggDTO tsIpAggDTO, String id_dep_oper, String id_emp_oper,
            FDateTime dt_oper, String eu_mpmd) throws BizException {
        List<CiTsOrMpDO> records = new ArrayList<>();
        
        if (tsIpAggDTO == null) {
            return;
        }
        
        CiTsOrMpDO tsOrMpDO = new CiTsOrMpDO();
        String id_tsormp = new DBUtil().getOIDs(1)[0];
        tsOrMpDO.setId_tsormp(id_tsormp);
        tsOrMpDO.setId_tsor(tsIpAggDTO.getTsOrDO().getId_tsor());
        tsOrMpDO.setId_or(tsIpAggDTO.getId_or());
        tsOrMpDO.setId_org_mp(ctx.getId_org());
        tsOrMpDO.setId_dep_mp(id_dep_oper);
        tsOrMpDO.setId_emp_mp(id_emp_oper);
        tsOrMpDO.setDt_mp(dt_oper);
        tsOrMpDO.setEu_mpmd(eu_mpmd);
        tsOrMpDO.setStatus(DOStatus.NEW);
        
        records.add(tsOrMpDO);
        
        ServiceFinder.find(ICitsormpCudService.class).save(records.toArray(new CiTsOrMpDO[0]));
    }
}
