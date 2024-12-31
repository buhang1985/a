package iih.ci.mi.ord.i;

import iih.ci.mi.ord.i.meta.OrdMiRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医保数据更新接口
 * @author HUMS
 *
 */
public interface ICiMiOrdCudService {

	public OrdMiRstDTO[] updateOrdMiInfo(OrdMiRstDTO[] OrdMiRsts) throws BizException;
	
	/**
	 * 更新指定医嘱为自费医嘱
	 * 
	 * @param orIdList		医嘱id集合
	 * @param orsrvIdList	医嘱服务项目id集合
	 * @return
	 * @throws BizException
	 */
	public OrdMiRstDTO[] updateOrdMiInfo2Selfpay(String[] orIdList, String[] orsrvIdList) throws BizException;
}
