package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.EnPeCmpyItmDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetEntid {

    /**
     * 用于获取团检单位制定的就诊id
     * @throws BizException 
     * 
     */
    @SuppressWarnings("unchecked")
    public EnPeCmpyItmDO[] getEnPeCmpyItmDOS(String Idpecmpy) throws BizException {
        StringBuilder sqlSb = this.getEntIdSql();
        // sql条件
        SqlParam param = new SqlParam();
        if (!EnValidator.isEmpty(Idpecmpy)) {
            sqlSb.append(" WHERE ITM.ID_PECMPY = ?");
            param.addParam(Idpecmpy);
            List<EnPeCmpyItmDO> enPeCmpyItmDOs = (List<EnPeCmpyItmDO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnPeCmpyItmDO.class));
            return enPeCmpyItmDOs.toArray(new EnPeCmpyItmDO[enPeCmpyItmDOs.size()]);
        }
        return null;
    }
    
    /**
     * 拼接查询团检记录明细的sql
     * 
     * @return
     */
    private StringBuilder getEntIdSql() {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" ITM.ID_ENT,");
        sqlSb.append(" ITM.ID_PECMPYITM");
        sqlSb.append(" FROM EN_PE_CMPY_ITM ITM");
        return sqlSb;
    }
}
