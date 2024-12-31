package iih.ci.mr.mrsurdataclassi.i;

import iih.ci.mr.mrsurdataclassi.d.MrSurDataClassiDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

public interface IMrsurdataclassiExtService {
	
	/** 签署手术医嘱，手术资料下自动产生手术分类
	 * @param id_ent 就诊id
	 * @param name  手术名称
	 * @param code  手术编码
	 * @param time  计划手术时间
	 * @return
	 * @throws BizException
	 */
	public abstract MrSurDataClassiDO[] createSurgicalClassification(String id_ent,String name,String code,FDateTime time) throws BizException;


	/** 撤回或作废手术医嘱，手术资料下自动删除手术分类
	 * @param id_ent 就诊id
	 * @param name  手术名称
	 * @param code  手术编码
	 * @param time  计划手术时间
	 * @throws BizException
	 */
	public abstract void deleteSurgicalClassification(String id_ent,String name,String code,FDateTime time) throws BizException;
}
