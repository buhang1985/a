package iih.en.pv.s.bp.ip.ws;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.inpatient.i.IInpatientRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author renzhi
 *
 */
public class PrintIpWristBP {

    /**
     * 修改打印次数并返回修改后的次数
     * @param patCode
     * @param Times_ip
     * @return 
     * @throws BizException
     */
    public int exec(String patCode, String Times_ip) throws BizException {
        EnValidator.validateParam("患者编码", patCode);
        EnValidator.validateParam("住院次数", Times_ip);
        return this.updatedata(patCode, Times_ip);
    }
    
    /**
     * 修改指定住院记录的打印次数
     * @param patCode
     * @param Times_ip
     * @throws BizException 
     */
    private int updatedata(String patCode, String Times_ip) throws BizException {
        InpatientDO inpatientDO = this.getupdate(patCode, Times_ip);
        if (inpatientDO == null ) {
            throw new BizException("没有查询到要修改的患者!!");
        }
        //查询服务
        IInpatientCudService cmdservice = ServiceFinder.find(IInpatientCudService.class);
        cmdservice.update(new InpatientDO[]{inpatientDO});
        return inpatientDO.getTimes_print();
    }
    
    /**
     * 获取要修改的数据
     * @param patCode
     * @param Times_ip
     * @return
     * @throws BizException
     */
    private InpatientDO getupdate(String patCode, String Times_ip) throws BizException {
         InpatientDO inpatientDO = this.getInpatientDO(patCode, Times_ip);
         if(inpatientDO == null) {
             return null;
         }
         //获取打印次数
         Integer times_print = inpatientDO.getTimes_print();
         //判断打印次数是不是null
         if ( times_print != null) {
             inpatientDO.setTimes_print(times_print+1);
         }else {
             inpatientDO.setTimes_print(1);
         }
         //设置为更新状态
         inpatientDO.setStatus(DOStatus.UPDATED);
         
         return inpatientDO;
    }
    
    /**
     * 查询指定患者code和指定住院次数的住院记录
     * @param patCode
     * @param Times_ip
     * @return
     * @throws BizException
     */
    private InpatientDO getInpatientDO(String patCode, String Times_ip) throws BizException {
        //查询服务
        IInpatientRService Rservice = ServiceFinder.find(IInpatientRService.class);
        //获取住院属性的id
        String id = this.getipid(patCode, Times_ip);
        if (EnValidator.isEmpty(id)) {
            return null;
        }
        InpatientDO findById = Rservice.findById(id);
        return findById;
    }
    
    /**
     * 获取住院记录id
     * @param patCode
     * @param Times_ip
     * @return
     * @throws DAException
     */
    @SuppressWarnings("unchecked")
    private String getipid(String patCode, String Times_ip) throws DAException {
        SqlParam param = new SqlParam();
        String sql = this.getSql(param, patCode, Times_ip);
        List<InpatientDO> list = (List<InpatientDO>)new DAFacade().execQuery(sql, param, new BeanListHandler(InpatientDO.class));
        if (EnValidator.isEmpty(list)) {
            return null;
        }
        return list.get(0).getId_inpatient();
    }
    
    /**
     * 查询sql
     * @param param
     * @param patCode
     * @param Times_ip
     * @return
     */
    private String getSql(SqlParam param,String patCode, String Times_ip) {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" IP.ID_INPATIENT,");
        sqlSb.append(" IP.TIMES_PRINT");
        sqlSb.append(" FROM EN_ENT ENT");
        sqlSb.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT");
        sqlSb.append(" INNER JOIN PI_PAT PAT  ON PAT.ID_PAT = ENT.ID_PAT");
        sqlSb.append(" WHERE");
        sqlSb.append(" PAT.CODE = ? ");
        param.addParam(patCode);
        sqlSb.append(" AND IP.TIMES_IP = ?");
        param.addParam(Times_ip);
        return sqlSb.toString();
    }
    
    
}
