package iih.ci.ord.test.i;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BizException;

/**
 * 自动化流程测试接口
 * @author yzh
 *
 */
public interface ICiWfMainService {

	/**
	 * 保存住院医嘱
	 * @param emstype 保存医嘱类型
	 * @param id_ent 就诊id 由上游就诊域传过来
	 * @param id_emp 用户id
	 * @param id_org 组织id
	 * @param id_dep 部门id
	 * @param id_grp 集团id
	 * @param ent4bannerdto 就诊banner
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO saveIPCiOrder(String emstype,String id_ent,String id_emp,
			String id_org,String id_dep,String id_grp,
			Ent4BannerDTO ent4bannerdto,String[] idsrvs) throws BizException ;
	

	
}
