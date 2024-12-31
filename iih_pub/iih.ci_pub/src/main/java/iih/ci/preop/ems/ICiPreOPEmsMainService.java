package iih.ci.preop.ems;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import xap.mw.core.data.BizException;

/**
 * 门诊预住院申请医疗单主服务接口
 * @author wangqingzhu
 *
 */
public interface ICiPreOPEmsMainService {
	
	/**
	 * 获取医疗单开单类型
	 * @return
	 * @throws BizException
	 */
	public abstract EmsRstDTO getFilterSrvtp4Ref() throws BizException;

	/**
	 * 门诊预住院申请医疗单创建接口
	 * @param ctx
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract EmsRstDTO create(CiEnContextDTO ctx, EmsCrtDTO arg) throws BizException;
	
	/**
	 * 门诊预住院申请医疗单加载接口
	 * @param ctx
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract EmsRstDTO load(CiEnContextDTO ctx, EmsLoadDTO arg) throws BizException;
	
	/**
	 * 门诊预住院申请医疗单保存接口
	 * @param ctx
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract EmsRstDTO save(CiEnContextDTO ctx, EmsSaveDTO arg) throws BizException;
	
}
