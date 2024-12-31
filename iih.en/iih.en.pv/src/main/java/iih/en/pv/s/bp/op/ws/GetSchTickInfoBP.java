package iih.en.pv.s.bp.op.ws;

import iih.bd.base.utils.SqlUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.SchTickInfoDTO;
import iih.en.pv.s.bp.op.ws.ep.WsEp;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.sctick.d.EuUseScope;
import iih.sc.sch.sctick.d.EuUseState;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据排班ID获取号位信息
 * 
 * @author renying
 *
 */
public class GetSchTickInfoBP {
	
	/**
	 * 根据排班ID获取号位信息
	 * @param schIds
	 * @param chlType
	 * @param ticksIds 号段ids
	 * @param ctrl1
	 * @param ctrl2
	 * @param ctrl3
	 * @param ctrl4
	 * @param ctrl5
	 * @return
	 * @throws BizException
	 */
    public SchTickInfoDTO[] exec(String[] schIds, String chlType,String[] ticksIds, String ctrl1, String ctrl2, String ctrl3, String ctrl4, String ctrl5) throws BizException {
        // 1.记录输入参数日志
        EnLogUtil.getInstance().logInfo("方法：GetSchTickInfoBP参数为:schIds:" + schIds);
        // 2.校验不可为空参数
        if (EnValidator.isEmpty(schIds) && EnValidator.isEmpty(ticksIds[0]))
            return null;
        //3.查找渠道id
        String chlId = null;
        if(!EnValidator.isEmpty(chlType)){
        	chlId = this.getChlId(chlType);
        }
        //4，查询排班对应的号位数据
        SchTickInfoDTO[] tickInfos = this.GetSchTickInfoDTOs(schIds,ticksIds);       
        //5.设置号位的使用状态
        this.setfg_apptable(tickInfos,chlId);
        return tickInfos;
    }
    /**
     * 查询排班对应的号位数据
     * @param schIds
     * @return
     * @throws BizException
     */
    private  SchTickInfoDTO[] GetSchTickInfoDTOs(String[] schIds,String[] ticksIds) throws BizException{
    	StringBuilder sqlSb = new StringBuilder();
        SqlParam param = new SqlParam();
        sqlSb.append(" SELECT TICK.ID_TICK,TICK.ID_TICKS,TICK.T_B,TICK.T_E,TICK.QUENO CODE,TICK.IDS_SCCHL, TICK.ID_SCH SCHID,");
        sqlSb.append(" TICK.EU_USED,TICK.EU_USESCOPE ");
        sqlSb.append(" FROM SC_TICK TICK");
        sqlSb.append(" WHERE ");
        String str = SqlUtils.getInSqlByIds("TICK.ID_SCH", schIds);
        sqlSb.append(str);
        if(!EnValidator.isEmpty(ticksIds) && !EnValidator.isEmpty(ticksIds[0])){
        	sqlSb.append(" AND " + SqlUtils.getInSqlByIds("TICK.ID_TICKS", ticksIds));
        }
        sqlSb.append(" AND TICK.FG_ACTIVE ='Y' ORDER BY TICK.QUENO");
        @SuppressWarnings("unchecked")
        List<SchTickInfoDTO> schTickInfoDTOs = (List<SchTickInfoDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(SchTickInfoDTO.class));
        if (EnValidator.isEmpty(schTickInfoDTOs)) {
            return null;
        }           
        return schTickInfoDTOs.toArray(new SchTickInfoDTO[0] );  
          
    }
    /**
     * 获取渠道ID
     * @param chlType
     * @return
     * @throws BizException
     */
    private String  getChlId(String chlType ) throws BizException
    {
		ISchedulechlMDORService rServiceFinder = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO[] chlDOs = rServiceFinder.findByAttrValString("Code",chlType);
		if (EnValidator.isEmpty(chlDOs)) {
			throw new BizException("未获取到编码为 " + chlType + "的渠道");
		}
		return chlDOs[0].getId_scchl();
    }
    /**
     * 设置号位可用状态
     * @param schInfos
     * @param chlType
     */
    private void setfg_apptable(SchTickInfoDTO[] schInfos, String chlId){
    	for(SchTickInfoDTO schTickInfo :schInfos ){
    		if(EuUseState.WY.equals(schTickInfo.getEu_used())&& EuUseScope.APT.equals(schTickInfo.getEu_usescope())){    			
    			schTickInfo.setFg_apptable(WsEp.STATUS_TICK_USE);
    		}else{
    			schTickInfo.setFg_apptable(WsEp.STATUS_TICK_UNUSE);
    		}
    		if(WsEp.STATUS_TICK_USE.equals(schTickInfo.getFg_apptable())){
    			if(!EnValidator.isEmpty(schTickInfo.getIds_scchl())&&!EnValidator.isEmpty(chlId)&& !schTickInfo.getIds_scchl().contains(chlId)){
    				schTickInfo.setFg_apptable(WsEp.STATUS_TICK_UNUSE);
    			}
    		}
    		
    	}
    }  
  
}
