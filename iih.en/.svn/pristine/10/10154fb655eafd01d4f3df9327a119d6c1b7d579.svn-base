package iih.en.pv.s.bp.ip.ws;

import iih.bd.utils.WsXmlUtils;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.out.ws.bean.IpInfoBean;
import iih.en.pv.out.ws.bean.request.GetIpInfoRequestBean;
import iih.en.pv.out.ws.bean.result.IpInfoReturnBean;
import iih.en.pv.s.bp.ip.ws.comm.GetIpInfoUtils;
import iih.en.pv.s.bp.ip.ws.param.GetIpInfoParam;

import java.util.Map;

import xap.mw.core.data.BizException;

/**
 * 查询住院患者基本信息基类
 * 
 * @author liubin
 *
 */
public abstract class AbstractGetIpInfoBP extends AbstractGetIpInfoBaseBP {

	/**
	 * 查询住院患者基本信息
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
    public String exec(String requestXML) {
    	//记录日志
    	log(requestXML);
    	IpInfoReturnBean returnBean = new IpInfoReturnBean();
    	try {
    		//1.解析Xml入参
    		GetIpInfoRequestBean requstParam = deSerializeRequestXml(requestXML);
    		//2.组装入参
    		GetIpInfoParam inParam = assemlyInParam(requstParam);
    		GetIpInfoUtils getIpInfoUtils = new GetIpInfoUtils();
            //3.查询住院患者id_ent
            String[] entIds = this.getEntIds(inParam);  
            //4.查询住院详细信息
            IpRegInfoDTO[] ipRegInfos = getIpInfoUtils.getIpRegInfoDTO(entIds);
            //5.组装返回值数据
            Map<String, IpInfoBean> map = getIpInfoUtils.aseemly(ipRegInfos);
            IpInfoBean[] beans = map.values().toArray(new IpInfoBean[0]);
            //6.组装返回值
            returnBean.setData(beans);
        } catch (BizException e ) {
            returnBean.setException(e);
        }
        return WsXmlUtils.serialize(returnBean);
    }
}
