package iih.en.pv.out.i;

import iih.en.pv.dto.d.IpBasicDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 就诊对外公共查询接口
 * （对各个域对外接口继承此接口，此接口不进行注册，不对外开放）
 * 
 * @author liubin
 *
 */
public interface IEn4CommQryService {
	/**
	 * 或者患者住院基本信息
	 * 
	 * @param idEnts
	 * @return
	 * @throws BizException
	 */
	public abstract IpBasicDTO[] getIpBasicInfos(String[] idEnts) throws BizException;
	/**
	 * 患者是否有对应就诊状况
	 * 
	 * @param entId 
	 * 			就诊id
	 * @param sd_enstatetp
	 * 			就诊状况类型  (iih.bd.bc.udi.pub.IBdFcDictCodeConst.SD_ENSTATE_XXX)
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean entHasState(String entId, String sd_enstatetp) throws BizException;
	/**
	 * 患者是否有对应标签
	 * 
	 * @param entId
	 * 			就诊id
	 * @param sd_tagtp
	 * 			标签类型（iih.bd.bc.udi.pub.IBdFcDictCodeConst.SD_TAGTP_XXX）
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean entHasTag(String entId, String sd_tagtp) throws BizException;
}
