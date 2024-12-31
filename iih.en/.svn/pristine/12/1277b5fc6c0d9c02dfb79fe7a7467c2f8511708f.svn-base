package iih.en.pv.s.bp.ip.ws;

import iih.bd.utils.WsXmlUtils;
import iih.bd.webservice.BaseWsResult;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.s.bp.ip.ws.bean.BedInfoBean;
import iih.en.pv.s.bp.ip.ws.bean.GetBedInfoParamBean;
import iih.en.pv.s.bp.ip.ws.bean.GetBedInfoReturnBean;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author renzhi
 *
 */
public class GetBedInfoBP {

    public String exec(String inputParam)  {
        GetBedInfoReturnBean resultBean = new GetBedInfoReturnBean();
        try {
            final GetBedInfoParamBean inputBean = WsXmlUtils.deSerializeBaseDO(inputParam, GetBedInfoParamBean.class);
            BedInfoBean[] bedInfoBeans = this.bpexec(inputBean.getNurCode());
            resultBean.setData(bedInfoBeans);
        } catch (BizException e) {
            BaseWsResult resultBeanErr = new BaseWsResult();
            resultBeanErr.setException(e);
            return WsXmlUtils.serialize(resultBeanErr);
        }
        return WsXmlUtils.serialize(resultBean);
    }
    
    /**
     * 获取 床位信息数据
     * @param nurCode
     * @return
     * @throws BizException
     */
    private BedInfoBean[] bpexec(String nurCode) throws BizException {
        List<BedInfoBean> list = this.getData(nurCode);
        if ( !EnValidator.isEmpty(list)) {
            BedInfoBean[] array = list.toArray(new BedInfoBean[list.size()]);
            return array;
        }
        return null;
    }
    
    /**
     * 根据科室编码查询床位信息
     * @param nurCode
     * @return
     */
    @SuppressWarnings("unchecked")
    private List<BedInfoBean> getData(String nurCode) throws BizException  {
       String[] nurCodes = nurCode.split(",");
       SqlParam param = new SqlParam();
       String sql = this.getSql(nurCodes,param);
       List<BedInfoBean> list = (List<BedInfoBean>) new DAFacade().execQuery(sql, param, new BeanListHandler(BedInfoBean.class));
       if ( !EnValidator.isEmpty(list)) {
           return list;
       }
       return null;
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
        sql.append(" BED.SD_BEDSU AS STATUS");
        sql.append(" FROM BD_BED BED");
        sql.append(" INNER JOIN BD_DEP DEP ON DEP.ID_DEP = BED.ID_DEP_BELONG");
        sql.append(" WHERE BED.FG_ACT = ? ");
        param.addParam(FBoolean.TRUE);
        if ( !EnValidator.isEmpty(nurCodes)) {
            String inSqlByIds = EnSqlUtils.getInSqlByIds("DEP.CODE", nurCodes);
            if ( !EnValidator.isEmpty(inSqlByIds)) {
                sql.append(" AND  ");
                sql.append(inSqlByIds);
            }
        }
        return sql.toString();
    }

}
