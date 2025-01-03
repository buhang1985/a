package iih.mp.mpbd.i;

import iih.bd.srv.mrtplvs.d.BdMrtplVsItmDO;
import iih.bd.srv.mrtplvst.d.BdMrtplVstDO;
import iih.mp.mpbd.dto.hdvdeftree.d.HdvDefTreeDTO;
import iih.mp.mpbd.dto.patrol.d.PatrolCondDTO;
import iih.mp.mpbd.dto.patrol.d.PatrolDTO;
import iih.mp.mpbd.dto.patvstagttreedto.d.PatVsTagtTreeDTO;
import iih.mp.mpbd.dto.tcstyleparam.d.TcStyleDTO;
import iih.mp.mpbd.dto.vstmatch.d.VstmatchparanDTO;
import iih.mp.mpbd.prnca.d.PrncaAggDO;
import iih.mp.mpbd.tcstyle.d.TcstyDepDO;
import iih.mp.mpbd.tcstyle.d.TcstyleDO;
import iih.mp.nr.dto.orderview.d.OrderViewDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.mdm.dto.thirdmdm.d.MdmThirdDTO;
import xap.sys.tool.authorization.d.AuthorizationDO;

public interface IMpBdQueryService {

	/**
	 * 体征模板匹配规则
	 * 
	 * @param vstmatchparanDTO体征模板匹配参数
	 * @return
	 * @throws BizException
	 */
	public abstract BdMrtplVstDO[] getMrtplVsts(VstmatchparanDTO vstmatchparanDTO) throws BizException;

	/**
	 * 根据科室id获取体温单样式
	 * 
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public abstract TcstyleDO getTcstyleInfo(TcStyleDTO param) throws BizException;

	/**
	 * 获取体温单适应科室最大编号
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract TcstyDepDO getTcstyDepMaxSortNo() throws BizException;

	/**
	 * 获取执行第三方指定的主数据信息
	 * 
	 * @param id_mdmca
	 * @param id_thrdprt
	 * @return
	 * @throws BizException
	 */
	public abstract MdmThirdDTO[] getMdmThirdList(String id_mdmca, String id_thrdprt) throws BizException;

	/**
	 * 初始化病区打印配置信息
	 * 
	 * @param sd_prnca_type
	 * @return
	 * @throws BizException
	 */
	public abstract PrncaAggDO[] initWardPrntSet(String sd_prnca_type) throws BizException;

	/**
	 * 查询生命体征项属性
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public abstract BdMrtplVsItmDO[] getVsItmDOs(String id_org) throws BizException;

	/**
	 * 查询护士巡房记录
	 * 
	 * @param condDto
	 * @return
	 * @throws BizException
	 */
	public abstract PatrolDTO[] getPatrolRecords(PatrolCondDTO condDto) throws BizException;

	/**
	 * 免密授权按病区查询用户信息
	 * 
	 * @throws BizException
	 */
	public AuthorizationDO[] getUserInfoByDep(String id_dep) throws BizException;

	/**
	 * 查询体征指标对照功能节点
	 * 
	 * @return
	 * @throws BizException
	 */
	public PatVsTagtTreeDTO[] getTreeInfo() throws BizException;

	/**
	 * 查询班次定义信息
	 * 
	 * @return
	 * @throws BizException
	 */
	public HdvDefTreeDTO[] getHdvDefDept() throws BizException;
	
	/**
	 * 医嘱查看
	 * 
	 * @param id_ent
	 * @throws BizException
	 */
	public abstract OrderViewDTO[] getOrderView(String id_ent) throws BizException;
	
	/**
	 * 查询患者指标时间点
	 * 
	 * @param codes
	 * @return
	 * @throws BizException
	 */
	public abstract String[] getVsTagtTimes(FDateTime dt_date, String id_ent, String[] codes) throws BizException;
}
