/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.thirdopen.i;

import iih.ci.mr.thirdopen.pkuih.d.PkuOperationRecDTO;

/**
 * 〈扼要描述〉
 * 国际医院 webservice主服务
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public interface IMrWebServiceForPkuihMainService {

	public abstract PkuOperationRecDTO[] getPkuOperationRecDTOList(String code_entp,String code_pat,String code_amr_ip,String times_ip);
	
	/**
	 *  获取示踪接口病案状态
	 * @param codeAmrAndTimes
	 * @param userId
	 * @param messName
	 * @return
	 */
	public abstract Boolean getPkuTracerStatus(String codeAmrAndTimes,String userId,String messName);
}
