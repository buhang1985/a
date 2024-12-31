package iih.cssd.dpp.i;

import java.util.List;

import iih.cssd.dpbd.instr.d.CssdiNSTRDO;
import iih.cssd.dpbd.pkg.d.CssdPkgDO;
import iih.cssd.dpp.dfp.d.CssdDfpDO;
import iih.cssd.dpp.dfprel.d.CssddfprelDO;
import iih.cssd.dpp.dto.dfpbatch.d.DfpBatchAddDTO;
import iih.cssd.dpp.dto.dfploseeffedto.d.DfpLoseEffeDTO;
import iih.cssd.dpp.dto.dfprecalldto.d.DfpReCallCondDTO;
import iih.cssd.dpp.dto.dfprecalldto.d.DfpRecallDTO;
import iih.cssd.dpp.dto.stz.d.RelDTO;
import iih.cssd.dpp.dto.stz.d.StzResultDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface ICssdDppQueryService {
	
	/**
	 * 获取消毒包使用频率
	 * @return
	 * @throws BizException
	 */
	public abstract CssdPkgDO[] getFreqDfp() throws BizException;
	
	/**
	 * 获取请领生产明细
	 * @return
	 * @throws BizException
	 */
	public abstract DfpBatchAddDTO[] getAppPkgs(String[] id_dfp_apps) throws BizException;
	
	/**
	 * 获取回收生产明细
	 * @return
	 * @throws BizException
	 */
	public abstract DfpBatchAddDTO[] getRecPkgs() throws BizException;
	
	/**
	 * 查询待录入结果的灭菌测试包
	 * 
	 * @author fengjj
	 * @return
	 * @throws BizException
	 */
	public abstract StzResultDTO[] getPkgUnResultList() throws BizException;

	/**
	 * 查询灭菌登记的篮子和消毒包集合
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract RelDTO[] queryBasketAndDfps(String[] no_bar) throws BizException;

	/**
	 * 获取灭菌批次号
	 * 
	 * @return
	 * @throws BizException
	 */
	public Integer getSztBatchNum() throws BizException;

	/**
	 * 获取清洗批次号
	 * 
	 * @return
	 * @throws BizException
	 */
	public Integer getClnBatchNum() throws BizException;

	/**
	 * 获取清洗架下所有子信息（包括清洗篮，清洗包）
	 * 
	 * @author fengjj
	 * @param id_instr
	 * @param 是否已登记
	 *            true：已登记;false:未登记
	 * @return
	 * @throws BizException
	 */
	public abstract RelDTO[] getClnChildInfosOfRack(String id_instr, boolean fg_reg) throws BizException;

	/**
	 * 消毒未合格  重新将车所有信息保存  原来记录不删除 
	 * @param no_bar
	 * @return
	 * @throws BizException
	 */
	public abstract RelDTO getCarDTOInfo(String no_bar,String id_parent) throws BizException;

	/**
	 * 
	* @Title: queryRelsById 
	* @Description: 根据父id,获取子关系 
	* @author zhy
	* @date 2019年7月8日 上午10:36:40 
	* @param @param id_dfp_rel
	* @param @return
	* @param @throws BizException 设定文件 
	* @return CssddfprelDO[] 返回类型 
	* @throws
	 */
	public abstract CssddfprelDO[] queryRelsByFu_Id(String id_dfp_rel) throws BizException;
	
	/**
	 * 
	* @Title: queryByInstr 
	* @Description: 根据装载篮获取与其绑定的有效的消毒包
	* @date 2019年7月23日 上午9:42:30 
	* @param @param instr
	* @param @return
	* @param @throws BizException 设定文件 
	* @return CssdDfpDO[] 返回类型 
	* @throws
	 */
	public abstract CssdDfpDO[] queryDfpByInstr(CssdiNSTRDO instr) throws BizException;

	/**
	 * 消毒包过期提醒
	 * @throws BizException
	 */
	public abstract List<DfpLoseEffeDTO>  WarnDfpLoseEffe() throws BizException;
	
	/**
	 * 消毒包撤回查询
	 * @author xiongchi 
     * @version：2019年12月17日 
	 * @throws BizException
	 */
	public  abstract PagingRtnData<DfpRecallDTO> queryRecallData(DfpReCallCondDTO param, PaginationInfo pg) throws BizException ;
}
