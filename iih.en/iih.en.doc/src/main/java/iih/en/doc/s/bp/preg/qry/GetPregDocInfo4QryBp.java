package iih.en.doc.s.bp.preg.qry;

import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IScDictCodeTypeConst;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.validator.EnValidator;
import iih.en.doc.pregdoc.d.DocStatusEnum;
import iih.en.doc.pregdoc.dto.d.PregDocInfoDTO;
import iih.en.doc.pregdoc.dto.d.PregDocQryDTO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 根据查询条件查询建档信息
 * 
 * @author jizhenbo
 *
 */
public class GetPregDocInfo4QryBp {

    /**
     * 根据查询条件查询建档信息
     * 
     * @param qryDTO
     *            查询条件
     * @return 建档信息集合
     * @throws BizException
     */
    public PregDocInfoDTO[] exec(PregDocQryDTO qryDTO, String idPat) throws BizException {
        // 参数检查
        if (qryDTO == null && idPat == null) {
            return null;
        }
        PregDocInfoDTO[] results = getPregDocInfos(qryDTO, idPat);
        if (results == null || results.length <= 0) {
            return null;
        }
        // 设置自定义档案的值
        this.setUdidocList(results);
        return results;
    }
    
    /**
     * 获取Sql
     * @return
     */
    private StringBuilder getSql() {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT PAT.CODE CODE_PAT,"); // 患者编码
        sqlSb.append(" DOC.ID_ENTDOC,"); // 建档id 任志 2018年2月27号17:51
        sqlSb.append(" DOC.ID_PAT,"); // 患者id 任志 2018年2月28号14:35
        sqlSb.append(" DOC.NAME_PAT,"); // 姓名
        sqlSb.append(" PREG.ID_PREGDOC,"); // 产科建档id
        sqlSb.append(" PREG.D_EXPECT,"); // 预产期
        sqlSb.append(" PREG.DT_DOC,"); // 建档时间
        sqlSb.append(" ENOP.DT_ACPT DT_ACPT_OP,"); // 就诊时间
        sqlSb.append(" ENOP.SD_STATUS,"); // 就诊状态
        sqlSb.append(" APT.DT_B DT_APPT,"); // 预约时间
        sqlSb.append(" APT.SD_STATUS SD_STATUS_APT,"); // 预约状态
        sqlSb.append(" ENIP.DT_ENTRY DT_ACPT_IP,"); // 入院时间
        sqlSb.append(" DEP.NAME NAME_DEP_PHY,"); // 入院科室
        sqlSb.append(" STAT.ID_PREGDOCSTAT,"); // 产妇状态表id 任志 2018年2月27号17:50
        sqlSb.append(" STAT.FG_HYPERT,"); // 高血压标识
        sqlSb.append(" STAT.FG_DIAB_PREG,"); // 糖尿病妊娠
        sqlSb.append(" STAT.FG_PREG_DIAB,"); // 妊娠糖尿病
        sqlSb.append(" STAT.WEIT_DOC,"); // 建档体重
        sqlSb.append(" STAT.FG_HAVE_BORN,"); // 已分娩
        sqlSb.append(" STAT.WEIT_BORN,"); // 分娩体重
        sqlSb.append(" STAT.MINS_BORN,"); // 分娩时长
        sqlSb.append(" STAT.VOL_OUT_BLOOD,"); // 产后出血量
        sqlSb.append(" STAT.FG_PREMATURE,"); // 早产标志
        sqlSb.append(" STAT.TIMES_BORN,"); // 胎次
        sqlSb.append(" STAT.TIMES_PREG"); // 孕次
        sqlSb.append(" FROM EN_DOC DOC"); // 就诊档案表
        sqlSb.append(" INNER JOIN EN_DOC_PREG PREG  ON DOC.ID_ENTDOC = PREG.ID_ENTDOC"); // 产科建档表
        sqlSb.append(" INNER JOIN EN_DOC_PREG_STAT STAT ON DOC.ID_ENTDOC = STAT.ID_ENTDOC"); // 产妇状况表
        sqlSb.append(" INNER JOIN PI_PAT PAT ON  DOC.ID_PAT = PAT.ID_PAT"); // 患者基本信息表
        sqlSb.append(" LEFT JOIN EN_ENT ENOP ON STAT.ID_ENT_LAST_OP =ENOP.ID_ENT"); // 患者就诊表
        sqlSb.append(" LEFT JOIN SC_APT APT ON STAT.ID_APT_LAST = APT.ID_APT"); // 预约申请表
        sqlSb.append(" LEFT JOIN EN_ENT ENIP ON STAT.ID_ENT_LAST_IP = ENIP.ID_ENT"); // 患者就诊表
        sqlSb.append(" LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = ENIP.ID_DEP_PHY"); // 部门表
        sqlSb.append(" WHERE 1 = 1");
        return sqlSb;
    }

    /**
     * 查询数据
     * 
     * @param qryDTO
     *            查询条件
     * @return
     * @throws BizException
     */
    private PregDocInfoDTO[] getPregDocInfos(PregDocQryDTO qryDTO, String idPat) throws BizException {
        //获取sql
        StringBuilder sqlSb = this.getSql();
        SqlParam param = new SqlParam();
        this.setparam(qryDTO, idPat, sqlSb, param);
        @SuppressWarnings("unchecked")
        List<PregDocInfoDTO> list = (List<PregDocInfoDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(PregDocInfoDTO.class));
        if (EnValidator.isEmpty(list)) {
            return null;
        }

        return list.toArray(new PregDocInfoDTO[] {});
    }
    
    /**
     * 拼接查询条件
     * @param qryDTO
     * @param idPat
     * @param sqlSb
     * @param param
     */
    private void setparam(PregDocQryDTO qryDTO, String idPat,StringBuilder sqlSb,SqlParam param) {
        if (idPat != null) {
            sqlSb.append(" AND  DOC.ID_PAT = ?");
            param.addParam(idPat);
        }
        if (qryDTO != null) {
            // 预约时间
            if (FBoolean.TRUE == qryDTO.getFg_dt_appt()) {
                if (qryDTO.getDt_appt_b() != null) {
                    sqlSb.append(" AND  APT.DT_B >= ?");
                    param.addParam(qryDTO.getDt_appt_b());
                }
                if (qryDTO.getDt_appt_e() != null) {
                    sqlSb.append(" AND  APT.DT_B < ?");
                    param.addParam(qryDTO.getDt_appt_e().getDateAfter(1));
                }
            }

            // 建档时间
            if (FBoolean.TRUE == qryDTO.getFg_dt_doc()) {
                if (qryDTO.getDt_doc_b() != null) {
                    sqlSb.append(" AND PREG.DT_DOC >= ?");
                    param.addParam(qryDTO.getDt_doc_b());
                }
                if (qryDTO.getDt_doc_e() != null) {
                    sqlSb.append(" AND PREG.DT_DOC < ?");
                    param.addParam(qryDTO.getDt_doc_e().getDateAfter(1));
                }
            }

            // 预产期时间
            if (FBoolean.TRUE == qryDTO.getFg_check_except()) {
                if (qryDTO.getD_except_b() != null) {
                    sqlSb.append(" AND PREG.D_EXPECT >= ?");
                    param.addParam(qryDTO.getD_except_b());
                }
                if (qryDTO.getD_except_e() != null) {
                    sqlSb.append(" AND PREG.D_EXPECT <= ?");
                    param.addParam(qryDTO.getD_except_e().getDateAfter(1));
                }
            }

            // 体征信息
            if (FBoolean.TRUE == qryDTO.getFg_sign()) {
                if (FBoolean.TRUE == qryDTO.getFg_hypert()) {
                    sqlSb.append(" AND STAT.FG_HYPERT = 1");
                }
                if (FBoolean.TRUE == qryDTO.getFg_diab_preg()) {
                    sqlSb.append(" AND STAT.FG_DIAB_PREG = 1");
                }
                if (FBoolean.TRUE == qryDTO.getFg_preg_diab()) {
                    sqlSb.append(" AND STAT.FG_PREG_DIAB = 1");
                }
                if (FBoolean.TRUE == qryDTO.getFg_have_born()) {
                    sqlSb.append(" AND STAT.FG_HAVE_BORN = 1");
                }
                if (FBoolean.TRUE == qryDTO.getFg_premature()) {
                    sqlSb.append(" AND STAT.FG_PREMATURE = 1");
                }
            }

            // 建档状态
            if (FBoolean.TRUE == qryDTO.getFg_stat()) {
                int count = 0;
                if (FBoolean.TRUE == qryDTO.getFg_appt()) {
                    param.addParam(DocStatusEnum.EU_STATUS_APPT);
                    count++;
                }
                if (FBoolean.TRUE == qryDTO.getFg_reg()) {
                    param.addParam(DocStatusEnum.EU_STATUS_REG);
                    count++;
                }
                if (FBoolean.TRUE == qryDTO.getFg_fin()) {
                    param.addParam(DocStatusEnum.EU_STATUS_FIN);
                    count++;
                }
                if (FBoolean.TRUE == qryDTO.getFg_canc()) {
                    param.addParam(DocStatusEnum.EU_STATUS_CANC);
                    count++;
                }
                if (count > 0) {
                    sqlSb.append(" AND PREG.EU_STATUS IN (");
                    for (int i = 0; i < count; i++) {
                        if (i == count - 1) {
                            sqlSb.append("?");
                        } else {
                            sqlSb.append("?,");
                        }
                    }
                    sqlSb.append(")");
                }
            }

            // 胎次
            if (FBoolean.TRUE == qryDTO.getFg_times_born()) {
                if (qryDTO.getTimes_born_b() != null) {
                    sqlSb.append(" AND STAT.TIMES_BORN >= ?");
                    param.addParam(qryDTO.getTimes_born_b());
                }
                if (qryDTO.getTimes_born_e() != null) {
                    sqlSb.append(" AND STAT.TIMES_BORN <= ?");
                    param.addParam(qryDTO.getTimes_born_e());
                }
            }

            // 孕次
            if (FBoolean.TRUE == qryDTO.getFg_times_preg()) {
                if (qryDTO.getTimes_preg_b() != null) {
                    sqlSb.append(" AND STAT.TIMES_PREG >= ?");
                    param.addParam(qryDTO.getTimes_preg_b());
                }
                if (qryDTO.getTimes_preg_e() != null) {
                    sqlSb.append(" AND STAT.TIMES_PREG <= ?");
                    param.addParam(qryDTO.getTimes_preg_e());
                }
            }
        }
    }

    /**
     * 设置自定义档案的值
     * 
     * @param pregDocDTO
     * @throws BizException
     */
    private void setUdidocList(PregDocInfoDTO[] pregDocInfoDTOs) throws BizException {
        UdiDocEP docEp = new UdiDocEP();
        Map<String, UdidocDO> map = docEp.getUdiDocsByCode(IEnDictCodeTypeConst.SD_STATUS);
        Map<String, UdidocDO> mapApt = docEp.getUdiDocsByCode(IScDictCodeTypeConst.SD_STATUS_TP);
        if (!EnValidator.isEmpty(map) && !EnValidator.isEmpty(mapApt)) {
            for (PregDocInfoDTO pregDocInfoDTO : pregDocInfoDTOs) {
                // 就诊状态
                if (map.get(pregDocInfoDTO.getSd_status()) != null) {
                    pregDocInfoDTO.setName_status_en(map.get(pregDocInfoDTO.getSd_status()).getName());
                }
                // 预约状态
                if (mapApt.get(pregDocInfoDTO.getSd_status_apt()) != null) {
                    pregDocInfoDTO.setName_status_apt(mapApt.get(pregDocInfoDTO.getSd_status_apt()).getName());
                }
            }
        }
        if (EnValidator.isEmpty(map) && !EnValidator.isEmpty(mapApt)) {
            for (PregDocInfoDTO pregDocInfoDTO : pregDocInfoDTOs) {
                // 预约状态
                if (mapApt.get(pregDocInfoDTO.getSd_status_apt()) != null) {
                    pregDocInfoDTO.setName_status_apt(mapApt.get(pregDocInfoDTO.getSd_status_apt()).getName());
                }
            }
        }
        if (!EnValidator.isEmpty(map) && EnValidator.isEmpty(mapApt)) {
            for (PregDocInfoDTO pregDocInfoDTO : pregDocInfoDTOs) {
                // 就诊状态
                if (map.get(pregDocInfoDTO.getSd_status_apt()) != null) {
                    pregDocInfoDTO.setName_status_apt(map.get(pregDocInfoDTO.getSd_status_apt()).getName());
                }
            }
        }
    }

    /**
     * 分页执行查询
     * @param qryDTO
     * @param pageInfo
     * @param idPat
     * @return
     * @throws BizException 
     */
    public PagingRtnData<PregDocInfoDTO> pageExec(PregDocQryDTO qryDTO, PaginationInfo pageInfo) throws BizException {
        if (qryDTO == null) {
            return null;
        }
        PagingRtnData<PregDocInfoDTO> page = new PagingRtnData<PregDocInfoDTO>();
        //查询Banner
        if (qryDTO.getId_pat() != null) {
            page = queryBanner(qryDTO,pageInfo);
        }else {
            //查询方案
            page = this.getPageInfo(qryDTO, pageInfo, null);  
        }
        return page;
    }
    
    /**
     * 根据Banner查询数据
     * @return
     * @throws BizException 
     */
    private PagingRtnData<PregDocInfoDTO> queryBanner(PregDocQryDTO qryDTO,PaginationInfo pageInfo) throws BizException{
        StringBuilder sqlSb = this.getSql();
        SqlParam param = new SqlParam();
        sqlSb.append(" AND DOC.ID_PAT = ?");
        param.addParam(qryDTO.getId_pat());
        return this.getRtnData(pageInfo, sqlSb.toString(), param);
    }
    
    /**
     * 封装分页条件
     * @param qryDTO
     * @param pageInfo
     * @param idPat
     * @return
     * @throws BizException
     */
    private PagingRtnData<PregDocInfoDTO> getPageInfo(PregDocQryDTO qryDTO, PaginationInfo pageInfo, String idPat) throws BizException {
        StringBuilder sqlSb = this.getSql();
        SqlParam param = new SqlParam();
        this.setparam(qryDTO, idPat, sqlSb, param);
        PagingRtnData<PregDocInfoDTO> ret = this.getRtnData(pageInfo, sqlSb.toString(), param);
        if (ret != null) {
            return ret;
        }
        return null;
    }

    /**
     * 查询数据封装数据
     * @param pageInfo
     * @param sql
     * @param param
     * @return
     * @throws BizException
     */
    private PagingRtnData<PregDocInfoDTO> getRtnData(PaginationInfo pageInfo, String sql, SqlParam param) throws BizException {
        PagingServiceImpl<PregDocInfoDTO> pageQryService = new PagingServiceImpl<PregDocInfoDTO>();
        return pageQryService.findByPageInfo(new PregDocInfoDTO(), pageInfo, sql, null, param);
    }
}
