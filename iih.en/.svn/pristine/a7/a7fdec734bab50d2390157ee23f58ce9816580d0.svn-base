package iih.en.pv.s.bp.ip.ws;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.utils.WsXmlUtils;
import iih.bd.webservice.BaseWsResult;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.s.bp.ip.ws.bean.GetCancIpInfoBean;
import iih.en.pv.s.bp.ip.ws.bean.GetCancIpInfoParamBean;
import iih.en.pv.s.bp.ip.ws.bean.GetCancIpInfoReturnBean;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetCancIpInfoBP {
    
    /**
     * 
     * @param inputParam
     * @return
     */
    public String exec(String inputParam) {
        GetCancIpInfoReturnBean returnBean = new GetCancIpInfoReturnBean();
        try {
            final GetCancIpInfoParamBean inputBean = WsXmlUtils.deSerializeBaseDO(inputParam, GetCancIpInfoParamBean.class);
            GetCancIpInfoBean[] data = bpexec(inputBean.getDt_begin_canc());
            returnBean.setData(data);
        } catch (BizException e) {
            BaseWsResult resultBeanErr = new BaseWsResult();
            resultBeanErr.setException(e);
            return WsXmlUtils.serialize(resultBeanErr);
        }
        return WsXmlUtils.serialize(returnBean); 
    }

    /**
     * 查询
     * @param dt
     * @return
     * @throws BizException
     */
    private GetCancIpInfoBean[] bpexec(String dt) throws BizException {
        GetCancIpInfoBean[] data = this.getData(dt);
        return data;
    }
    
    /**
     * 获取返回信息
     * @param inputParam
     * @return
     * @throws BizException 
     */
    private GetCancIpInfoBean[] getData(String dt) throws BizException {
        FDateTime dtime = null;
        if ( !EnValidator.isEmpty(dt)) {
            try {
                 dtime = new FDateTime(dt);
            } catch (Exception e) {
                throw new BizException("时间格式不正确,正确格式为 2018-01-01 18:12:00");
            }
        }
        //获取数据
        List<GetCancIpInfoBean> list = this.getQueryData(dtime);
        if ( !EnValidator.isEmpty(list)) {
            GetCancIpInfoBean[] array = list.toArray(new GetCancIpInfoBean[list.size()]);
            return array;
        }
        return null;
    }

    /**
     * 执行sql 查询数据
     * @param dt
     * @return
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
    private List<GetCancIpInfoBean> getQueryData(FDateTime dtime)throws BizException {
        SqlParam param = new SqlParam();
        String sql = this.getSql(param, dtime);
        List<GetCancIpInfoBean> list = (List<GetCancIpInfoBean>) new DAFacade().execQuery( sql, param, new BeanListHandler(GetCancIpInfoBean.class));
        if ( !EnValidator.isEmpty(list)) {
            return list;
        }
        return null;
    }
    
    /**
     * 获取sql 封装查询条件
     * @param param
     * @param dt
     * @return
     */
    private String getSql(SqlParam param,FDateTime dtime) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT");
        sql.append(" IP.CODE_AMR_IP AS IPCODE,");
        sql.append(" IP.TIMES_IP,");
        sql.append(" ENT.DT_CANC,");
        sql.append(" PAT.CODE AS PATCODE, ");
        sql.append(" CASE WHEN ENT.SV > IP.SV THEN ENT.SV ELSE IP.SV END UPDATE_TIME ");//更新时间
        sql.append(" FROM EN_ENT ENT");
        sql.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT");
        sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
        sql.append(" WHERE ENT.CODE_ENTP = ?");
        param.addParam(IEnDictCodeConst.SD_ENTP_INPATIENT);//就诊类型为10
        sql.append(" AND ENT.FG_CANC = ?");
        param.addParam(FBoolean.TRUE);
        if (dtime != null ) {
            sql.append(" AND ENT.DT_CANC >= ?");
            param.addParam(dtime);
        }
        return sql.toString();
    }
}
