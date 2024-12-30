package iih.sc.apt.s.task.bp;

import java.util.List;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.comm.ScParamUtils;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author renzhi
 *
 */
public class CancelReservationBP {

    /**
     * 需要执行的逻辑
     */
    public void exec()throws BizException {
        //获取医技排班计划科室
        List<ScPlanDO> list = this.getDepId();
        updateData(list);
    }

    /**
     * 依次修改 各个科室的符合条件的数据
     * @throws BizException
     */
    private void updateData(List<ScPlanDO> list) throws BizException {
       // iih.sc.comm.ScParamUtils.getMaxDaysAptCfm(String)
        //调用ScParamUtils.getMaxDaysAptCfm(""); 传科室id 获取科室天数 
        for (ScPlanDO scPlanDO : list) {
            //获取科室id
            String id_dep = scPlanDO.getId_dep();
            int day = 0;
            //判断科室id 是否为空或者null
            if ( !StringUtil.isEmptyWithTrim(id_dep)) {
                //获取配置的科室取消预约的参数
                day = ScParamUtils.getMaxDaysAptCfm(id_dep);
                if (day > 0 ) {
                    this.updateDepData(id_dep,day);
                }
            }
        }
    }
    
    /**
     * 修改指定科室 预约超过指定天数 没有预约确认的记录  ScAptDO
     * 
     * @param id_dep
     * @param day
     * @throws BizException 
     */
    private void updateDepData(String id_dep, int day) throws BizException {       
        List<MtAppDTO> list = this.getScAptDOs(id_dep,day);
        if (ListUtil.isEmpty(list)) {
            return;
        }else {
            //调用方法 修改数据 并把修改后的数据 存放在数组中 便于后续更新数据库中的数据
            MtAppDTO[] dtos = list.toArray(new MtAppDTO[list.size()]);
            this.cancelMtApt(dtos);
        }
    }
    
    /**
     * 调用接口方法 取消预约
     * @param dtos
     * @throws BizException 
     */
    private void cancelMtApt(MtAppDTO[] dtos) throws BizException {
        IScAptCmdService service = ServiceFinder.find(IScAptCmdService.class);
        for (MtAppDTO mtAppDTO : dtos) {
            service.cancelMtApt(mtAppDTO);
        }
    }
    
    
    /**
     * 判断是否可以修改
     * 
     * @param dt_appt 预约日期
     * @param day 几天后取消预约
     * @return
     */
    private boolean isUpdate(FDateTime dt_appt , int day) {
        if ( dt_appt == null) {
            return false;
        }
        
        FDate date = new FDate();
        int daysAfter = date.getDaysAfter(dt_appt.getDate());
        return daysAfter>=day;
    }
    
    
    /**
     * 获取指定科室的预约记录
     * @param id_dep
     * @param day
     * @return
     * @throws BizException 
     */
    @SuppressWarnings("unchecked")
    private List<MtAppDTO> getScAptDOs(String id_dep, int day) throws BizException{
        SqlParam param = new SqlParam();
        StringBuilder sql = this.getDataSql(param,day);
        if(StringUtil.isEmptyWithTrim(id_dep)) {
            return null;
        }
        sql.append("  AND APT.ID_DEP_APPT  = ? ");
        param.addParam(id_dep);
        List<MtAppDTO> list =(List<MtAppDTO>) new DAFacade().execQuery(sql.toString(), param,  new BeanListHandler(MtAppDTO.class));
        return list;
    }
    
    /**
     * 获取要修改的科室的记录
     * @param param
     * @return
     */
    private StringBuilder getDataSql(SqlParam param,int day) {
        StringBuilder Sql = new  StringBuilder();
        Sql.append(" SELECT ");
        Sql.append(" APT.DT_APPT,");
        Sql.append(" APT.ID_APT,");
        Sql.append(" MT.ID_APTMT,");
        Sql.append(" APPL.ID_OR,");
        Sql.append(" APPL.ID_ENT,");
        Sql.append(" APPL.ID_APTAPPL AS ID_APT_APPL");
        Sql.append(" FROM SC_APT APT");
        Sql.append(" INNER JOIN SC_APT_MT MT ON MT.ID_APT = APT.ID_APT");
        Sql.append(" INNER JOIN SC_APT_APPL APPL ON APPL.ID_APTAPPL = MT.ID_APTAPPL");        
        Sql.append(" INNER  JOIN ( SELECT APT.ID_APT ,TO_NUMBER( to_date( SUBSTR(  APT.DT_APPT, 0, 10),'yyyy-MM-dd ') -  to_date(SUBSTR( to_char(sysdate,'yyyy-MM-dd'), 0, 10),'yyyy-MM-dd ') ) AS D FROM SC_APT APT) APTDAY ON APTDAY.ID_APT = APT.ID_APT ");
        Sql.append(" WHERE ");
        Sql.append(" MT.FG_NEEDCFM = ?");
        param.addParam(FBoolean.TRUE);
        Sql.append(" AND MT.FG_APTCFM = ? ");
        param.addParam(FBoolean.FALSE);
        Sql.append(" AND APT.FG_CANC = ? ");
        param.addParam(FBoolean.FALSE);
        Sql.append(" AND APTDAY.D < ? ");
        param.addParam(day);
        Sql.append(" AND APT.SD_STATUS IN (0, 1)");    
        return Sql;
    }
    
    
    /**
     * 获取有排除计划的医技科室
     * 
     * @return
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
    private List<ScPlanDO> getDepId() throws BizException {
        String sql = this.getSql();
        List<ScPlanDO> list = (List<ScPlanDO>)new DAFacade().execQuery( sql,  new BeanListHandler(ScPlanDO.class));
        return list;
    }
    
    /**]
     * 获取SQL
     * SELECT DISTINCT SCPL.ID_DEP FROM SC_PL SCPL WHERE SCPL.SD_SCTP = '03'
     * @return      
     */
    private String getSql() {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append(" DISTINCT SCPL.ID_DEP");
        sql.append(" FROM SC_PL SCPL");
        sql.append(" WHERE SCPL.SD_SCTP = '03'");
        return sql.toString();
    }
}
