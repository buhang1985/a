package iih.en.pv.s.bp.ip.ws;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.utils.WsXmlUtils;
import iih.en.comm.IEnConst;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.ws.bean.request.GetIpInfoRequestBean;
import iih.en.pv.s.bp.ip.ws.param.GetIpInfoParam;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院信息抽象类
 * 
 * @author liubin
 *
 */
public abstract class AbstractGetIpInfoBaseBP {
	/**
	 * 根据科室查询住院患者信息
	 * 
	 * @param requestXML
	 * @return
	 */
    public abstract String exec(String requestXML);
    /**
     * 组装入参和参数校验
     * 
     * @param requestParam
     * @return
     */
    protected abstract GetIpInfoParam assemlyInParam(GetIpInfoRequestBean requestParam) throws BizException;
    /**
     * 记录入参日志
     * 
     * @param requestXML
     */
    protected void log(String requestXML){}
    /**
     * 解析入参Xml
     * 
     * @param requestXML
     * @return
     */
    protected GetIpInfoRequestBean deSerializeRequestXml(String requestXML){
    	return WsXmlUtils.deSerializeBaseDO(requestXML, GetIpInfoRequestBean.class);
    }
    /**
     * 查询住院和急诊留观患者id_ent
     * 
     * @param inParam
     * @return
     * @throws BizException 
     */
    protected String[] getEntIds(GetIpInfoParam inParam) throws BizException {
        StringBuilder sqlSb = new StringBuilder();
        SqlParam param  = new SqlParam();
        sqlSb.append(" SELECT ENT.ID_ENT ");
        sqlSb.append(" FROM EN_ENT ENT ");
        sqlSb.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT ");
        sqlSb.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT ");
        sqlSb.append(" LEFT JOIN BD_DEP DEP_NURDISC ON DEP_NURDISC.ID_DEP = ENT.ID_DEP_NUR ");
        sqlSb.append(" LEFT JOIN BD_DEP DEP_PHYDISC ON DEP_PHYDISC.ID_DEP = ENT.ID_DEP_PHY ");
        sqlSb.append(" WHERE ENT.FG_CANC = ? ");
        param.addParam(FBoolean.FALSE);
        //科室编码
        if(!EnValidator.isEmpty(inParam.getCode_dep())) {
            sqlSb.append(" AND DEP_PHYDISC.CODE = ? ");
            param.addParam(inParam.getCode_dep());
        }
        //住院病区编码
        if(!EnValidator.isEmpty(inParam.getCode_nur())) {
            sqlSb.append(" AND DEP_NURDISC.CODE = ? ");
            param.addParam(inParam.getCode_nur());
        }
        //住院开始时间
        if(inParam.getDt_acpt_b()  != null ) {
            sqlSb.append(" AND ENT.DT_ACPT >= ? ");
            param.addParam(inParam.getDt_acpt_b());
        }
        //住院结束时间
        if(inParam.getDt_acpt_e()  != null ) {
            sqlSb.append(" AND ENT.DT_ACPT < ? ");
            param.addParam(inParam.getDt_acpt_e().getDateAfter(1));
        }
        //出院开始时间
        if(inParam.getDt_end_b() != null ) {
            sqlSb.append(" AND ENT.DT_END >= ? ");
            param.addParam(inParam.getDt_end_b());
        }
        //出院结束时间
        if(inParam.getDt_end_e() != null ) {
            sqlSb.append(" AND ENT.DT_END < ? ");
            param.addParam(inParam.getDt_end_e().getDateAfter(1));
        }
        if(!EnValidator.isEmpty(inParam.getIpCodes())){
        	if(inParam.getIpCodes().length > 1){
        		sqlSb.append(EnSqlUtils.getInSqlByIds(" AND IP.CODE_AMR_IP ", inParam.getIpCodes()));
        	}else{
        		sqlSb.append(" AND IP.CODE_AMR_IP = ? ");
        		param.addParam(inParam.getIpCodes()[0]);
        	}
        }
        if(!EnValidator.isEmpty(inParam.getPatCodes())){
        	if(inParam.getPatCodes().length > 1){
        		sqlSb.append(EnSqlUtils.getInSqlByIds(" AND PAT.CODE ", inParam.getPatCodes()));
        	}else{
        		sqlSb.append(" AND PAT.CODE = ? ");
        		param.addParam(inParam.getPatCodes()[0]);
        	}
        }
        if(inParam.getTimes_ent() != null){
        	sqlSb.append(" AND IP.TIMES_IP = ? ");
    		param.addParam(inParam.getTimes_ent());
        }
		if (!EnValidator.isEmpty(inParam.getStatus())) {
			if (IEnConst.STATUS_HOSPITALIN.equals(inParam.getStatus())) {// 入院登记和在院
				sqlSb.append(" AND IP.SD_STATUS IN( ?,?) ");
				// 住院登记后
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);
				// 入科
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN);
			}
			if (IEnConst.STATUS_INHOS.equals(inParam.getStatus())) {// 查询在院状态的患者信息
				sqlSb.append(" AND IP.SD_STATUS = ? ");
				// 入科
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN);
			}
			if (IEnConst.STATUS_OUTHOS.equals(inParam.getStatus())) { // 查询出院状态的患者信息
				sqlSb.append(" AND IP.SD_STATUS = ? ");
				// 出院
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
			}
			if(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN.equals(inParam.getStatus())){ //入院登记 zhangpp 2019.09.23
				sqlSb.append(" AND IP.SD_STATUS = ? ");
				//入院登记
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);
			}
		}
        @SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sqlSb.toString(), param,new ColumnListHandler());
        return EnValidator.isEmpty(list) ? null : list.toArray(new String[list.size()]);
    }
  
}
