package iih.en.pv.s.bp.ip.qry;

import iih.bd.base.utils.SqlUtils;
import iih.en.comm.IEnConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.PeStatusEnum;
import iih.en.pv.inpatient.d.desc.EnPeCmpyDODesc;
import iih.en.pv.inpatient.dto.d.EnPeCmpyDTO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询团检单位信息
 * 
 * @author Sarah
 *
 */
public class GetEnPeComyInfoBP {

    /**
     * 查询团检单位信息
     * 
     * @param qryDTO
     * @return
     * @throws BizException
     */
    public EnPeCmpyDTO[] exec(EnPeCmpyDTO qryDTO) throws BizException {
        // 如果参数是空 直接返回空
        if (qryDTO == null) {
            return null;
        }
        return this.getEnPeCmpyDTOs(qryDTO);
    }
    

    /**
     * 获取团检记录
     * @return
     * @throws DAException 
     */
    @SuppressWarnings("unchecked")
    private EnPeCmpyDTO[] getEnPeCmpyDTOs(EnPeCmpyDTO qryDTO) throws DAException {
        //获取sql
        StringBuilder sqlSb = this.getSql();
        //sql条件
        SqlParam param = new SqlParam();
        sqlSb.append(" CMPY.FG_ACTIVE = ?");
        param.addParam(FBoolean.TRUE);
        if (qryDTO.getDt_b_query() != null ) {
            String dt_b = qryDTO.getDt_b_query().toString();
            sqlSb.append(" AND CMPY.DT_B >= ?");
            param.addParam(dt_b);
            
        }
        if (qryDTO.getDt_e_query() !=  null) {
            String dt_e = qryDTO.getDt_e_query().toString();
            sqlSb.append(" AND CMPY.DT_B <= ?");
            param.addParam(dt_e);
        }
        if (!EnValidator.isEmpty(qryDTO.getId_cust_cmpy())) {
            sqlSb.append(" AND CMPY.ID_CUST_CMPY = ?");
            param.addParam(qryDTO.getId_cust_cmpy());
        }
        if (qryDTO.getFg_ip() == FBoolean.TRUE || qryDTO.getFg_out() == FBoolean.TRUE) {
            List<String> idList = new ArrayList<String>();
            if (qryDTO.getFg_ip() == FBoolean.TRUE) {
               idList.add(PeStatusEnum.STATUS_PE_INHOS); 
            }
            if (qryDTO.getFg_out() == FBoolean.TRUE) {
                idList.add(PeStatusEnum.STATUS_PE_OUTHOS);                 
            }
            String inString = SqlUtils.getInSqlByIds("CMPY.EU_STATUS",idList);
            sqlSb.append(" AND ");
            sqlSb.append(inString);
        }
        sqlSb.append(" ORDER BY CMPY.SV DESC");
        List<EnPeCmpyDTO> patEntInfos = (List<EnPeCmpyDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnPeCmpyDTO.class));
        //查询体检人数
        this.setDtoCount(patEntInfos);
        //设置团检状态
        //this.setEustates(patEntInfos);
        return patEntInfos.toArray(new EnPeCmpyDTO[patEntInfos.size()]);
    }

    /**
     * 设置团检单位状态
     * @param patEntInfos
     */
    private void setEustates(List<EnPeCmpyDTO> patEntInfos) {
        for (EnPeCmpyDTO enPeCmpyDTO : patEntInfos) {
            if (PeStatusEnum.STATUS_PE_INHOS.equals(enPeCmpyDTO.getEu_status())) {
                enPeCmpyDTO.setEu_status(IEnConst.STATUS_PE_INHOS);
            }
            if (PeStatusEnum.STATUS_PE_OUTHOS.equals(enPeCmpyDTO.getEu_status())) {
                enPeCmpyDTO.setEu_status(IEnConst.STATUS_PE_OUTHOS);
            }
        }
    }
    
    /**
     * 封装到团检人数
     * @param list
     * @return
     * @throws DAException 
     */
    private List<EnPeCmpyDTO> setDtoCount(List<EnPeCmpyDTO> list) throws DAException {
        for (EnPeCmpyDTO dto : list) {
            this.setTimesCount(dto);
        }
        return list;
    }

    /**
     * 设置体检人数
     * @param dto
     * @throws DAException
     */
    private void setTimesCount(EnPeCmpyDTO dto) throws DAException {
        //获取团检人数
        Integer count = this.getCount(dto.getId_pecmpy());
        dto.setTimes_count(count.toString());
    }
    
    /**
     * 根据团检单位id查询 团检人数
     * @param Idpecmpy
     * @return
     * @throws DAException
     */
    @SuppressWarnings("unchecked")
    private int getCount(String Idpecmpy) throws DAException {
        //获取sql
        StringBuilder sqlSb = this.getCountSql();
        //sql条件
        SqlParam param = new SqlParam();
        sqlSb.append(" WHERE ITM.ID_PECMPY = ?");
        param.addParam(Idpecmpy);
        Map<String, Integer> map = (Map<String, Integer>) new DAFacade().execQuery(sqlSb.toString(), param, new MapHandler());
        if (map.size() != 0) {
            return map.get("count");
        }
        return 0;
    }
    
    /**
     * 获取查询记录数的SQL
     * @return
     */
    private StringBuilder getCountSql() {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" COUNT(ITM.ID_PECMPYITM) COUNT");
        sqlSb.append(" FROM EN_PE_CMPY_ITM ITM");
        return sqlSb;
    }
    
    /**
     * 获取sql
     * @return
     */
    private StringBuilder getSql() {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" CMPY.ID_PECMPY,");//团检记录id
        sqlSb.append(" CMPY.NO_CONTRACT,");//团检编码
        sqlSb.append(" CMPY.TIMES_PE,");//体检次数
        sqlSb.append(" CMPY.DT_B,");//入院时间
        sqlSb.append(" CMPY.DT_E,");//出院时间
        sqlSb.append(" CMPY.EU_STATUS,");//团检状态
        sqlSb.append(" CMPY.ID_CUST_CMPY,");//体检单位id
        sqlSb.append(" CUST.NAME AS NAME_CUST");//体检单位
        sqlSb.append(" FROM EN_PE_CMPY CMPY");//团检记录表
        sqlSb.append(" LEFT JOIN BD_CUST CUST ON CUST.ID_CUST = CMPY.ID_CUST_CMPY");
        sqlSb.append(" WHERE 1=1");
        return sqlSb;
    }

    /**
     * 设置分页查询条件
     * @param qryDTO
     * @param param
     * @return
     */
    private String getPageSql(EnPeCmpyDTO qryDTO,SqlParam param) {
        //获取sql
        StringBuilder sqlSb = this.getSql();
        sqlSb.append(" AND CMPY.FG_ACTIVE = ?");
        param.addParam(FBoolean.TRUE);
        if (qryDTO.getDt_b_query() != null ) {
            String dt_b = qryDTO.getDt_b_query().toString() + " 00:00:00";
            sqlSb.append(" AND CMPY.DT_B >= ?");
            param.addParam(dt_b);
            
        }
        if (qryDTO.getDt_e_query() !=  null) {
            String dt_e = qryDTO.getDt_e_query().toString()  + " 23:59:59";
            sqlSb.append(" AND CMPY.DT_B <= ?");
            param.addParam(dt_e);
        }
        if (!EnValidator.isEmpty(qryDTO.getId_cust_cmpy())) {
            sqlSb.append(" AND CMPY.ID_CUST_CMPY = ?");
            param.addParam(qryDTO.getId_cust_cmpy());
        }
        if (qryDTO.getFg_ip() == FBoolean.TRUE || qryDTO.getFg_out() == FBoolean.TRUE) {
            List<String> idList = new ArrayList<String>();
            if (qryDTO.getFg_ip() == FBoolean.TRUE) {
               idList.add(PeStatusEnum.STATUS_PE_INHOS); 
            }
            if (qryDTO.getFg_out() == FBoolean.TRUE) {
                idList.add(PeStatusEnum.STATUS_PE_OUTHOS);                 
            }
            String inString = SqlUtils.getInSqlByIds("CMPY.EU_STATUS",idList);
            sqlSb.append(" AND ");
            sqlSb.append(inString);
        }
        sqlSb.append(" AND "+ScGroupControlUtils.getGroupControlFitler(new EnPeCmpyDODesc(), "CMPY"));
        sqlSb.append(" ORDER BY CMPY.NO_CONTRACT DESC");
        return sqlSb.toString();
    }

    /**
     * 查询分页
     * @param qryDto
     * @param pageInfo
     * @return
     * @throws BizException
     */
    public PagingRtnData<EnPeCmpyDTO> pageexec(EnPeCmpyDTO qryDto, PaginationInfo pageInfo) throws BizException {
        PagingRtnData<EnPeCmpyDTO> page = new PagingRtnData<EnPeCmpyDTO>();
        PagingServiceImpl<EnPeCmpyDTO> service =new PagingServiceImpl<EnPeCmpyDTO>();
        SqlParam param = new SqlParam();
        String sql = this.getPageSql(qryDto, param);
        page = service.findByPageInfo(new EnPeCmpyDTO(), pageInfo, sql, "",param);
        this.set1count(page);
        
        return page;
    }
    
    /**
     * 设置团检人数
     * @param page
     * @return
     * @throws DAException
     */
    private PagingRtnData<EnPeCmpyDTO> set1count(PagingRtnData<EnPeCmpyDTO> page) throws DAException{
        FArrayList list = page.getPageData();
        for (Object object : list) {
            EnPeCmpyDTO dto = (EnPeCmpyDTO)object;
            dto.setTimes_count(this.getCount(dto.getId_pecmpy())+"");
            String times_count = dto.getTimes_count();
        }
        return null;
    }
}
