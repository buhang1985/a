package iih.en.pv.s.bp.ip.ws;

import iih.bd.utils.WsXmlUtils;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.ws.bean.IpDetailInfoBean;
import iih.en.pv.out.ws.bean.request.GetIpDetailInfoRequestBean;
import iih.en.pv.out.ws.bean.result.IpDetailInfoReturnBean;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院详细信息抽象类
 * 
 * @author liubin
 *
 */
public abstract class AbstractGetIpDetailInfoBP<T> {
	/**
	 * 根据科室查询住院患者信息
	 * 
	 * @param requestXML
	 * @return
	 */
    public String exec(String requestXML){
    	//记录日志
    	log(requestXML);
    	IpDetailInfoReturnBean<T> returnBean = new IpDetailInfoReturnBean<T>();
    	try {
    		//1.解析Xml入参
    		GetIpDetailInfoRequestBean requstParam = deSerializeRequestXml(requestXML);
    		//1.组装入参
    		String[] codeEnt = assemlyInParam(requstParam);
            //2.查询住院患者id_ent
            String[] entIds = this.getEntIds(codeEnt);
            Set<IpDetailInfoBean<T>> hashSet = null;
            //4.组装返回数据
            if(!EnValidator.isEmpty(entIds))
            	hashSet = this.assemlyDetail(entIds);
            if(hashSet == null)
            	hashSet = new HashSet<IpDetailInfoBean<T>>();
            //5.组装返回值
            returnBean.setData(hashSet);
        } catch (BizException e ) {
            returnBean.setException(e);
        }
        return WsXmlUtils.serialize(returnBean);
    }

    /**
     * 查找明细信息
     * 
     * @param entIds
     * @return
     * @throws BizException
     */
    protected abstract Set<IpDetailInfoBean<T>> assemlyDetail(String[] entIds)throws BizException;
    /**
     * 组装入参和参数校验
     * 
     * @param requestParam
     * @return
     */
    protected String[] assemlyInParam(GetIpDetailInfoRequestBean requestParam) throws BizException{
    	if(requestParam == null)
    		throw new BizException("入参解析错误！");
    	if(EnValidator.isEmpty(requestParam.getCodes_ent()))
    		throw new BizException("就诊编码不能为空！");
    	return requestParam.getCodes_ent().split(",");
    }
    
    @SuppressWarnings("unchecked")
	protected  List<IpDetailInfoBean<T>> getIpDetailInfoBeanInfo(String[] entIds) throws DAException {
    	if(EnValidator.isEmpty(entIds))
    		return null;
  		StringBuilder sqlsb= new StringBuilder();
  		SqlParam param = new SqlParam();
          sqlsb.append(" SELECT");
          sqlsb.append(" PAT.CODE AS PATCODE,");//病人编码
          sqlsb.append(" ENT.CODE AS CODE_ENT,");//就诊编码
          sqlsb.append(" IP.CODE_AMR_IP AS CODE_AMR_IP,");//住院号
          sqlsb.append(" IP.TIMES_IP AS TIMES_IP,");//住院次数
          sqlsb.append(" ENT.ID_ENT AS ID_ENT, ");//就诊id
          sqlsb.append(" CASE WHEN ENT.SV > IP.SV THEN ENT.SV ELSE IP.SV END UPDATE_TIME ");//更新时间
          sqlsb.append(" FROM EN_ENT ENT");
          sqlsb.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT");
          sqlsb.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
          sqlsb.append(" WHERE ").append(EnSqlUtils.getInSqlByIds("ENT.ID_ENT", entIds));
          List<IpDetailInfoBean<T>> results = (List<IpDetailInfoBean<T>>) new DAFacade().execQuery(sqlsb.toString(), param, new BeanListHandler(IpDetailInfoBean.class));
  		  return results;
  	}

    
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
    protected GetIpDetailInfoRequestBean deSerializeRequestXml(String requestXML){
    	return WsXmlUtils.deSerializeBaseDO(requestXML, GetIpDetailInfoRequestBean.class);
    }
    /**
     * 查询住院患者id_ent
     * 
     * @param inParam
     * @return
     * @throws BizException 
     */
    protected String[] getEntIds(String[] codeEnts) throws BizException {
    	if(EnValidator.isEmpty(codeEnts))
    		return null;
        List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().findByAttrValStrings(PatiVisitDO.class, PatiVisitDO.CODE, codeEnts, new String[]{PatiVisitDO.ID_ENT, PatiVisitDO.CODE});
        return EnAppUtils.getKeyPropArrayFromDO(PatiVisitDO.ID_ENT, EnValidator.isEmpty(list) ? null : list.toArray(new PatiVisitDO[0]));
    }
    
    
    
}
