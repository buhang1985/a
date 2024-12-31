package iih.bl.cc.i;

import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blccdto.d.BlPayPatIpDTO;
import iih.bl.cc.blccdto.d.BlpayOepPatDTO;
import xap.lui.core.dataset.PaginationInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 结账查询服务
 * @author yankan
 * @since 2017-06-15
 *
 */
public interface IBlCcQryService {
	/**
	 * 判断是否可以取消结账
	 * */
	public FBoolean checkBlccCancel(BlCcDO blccDO) throws BizException;
	/**
	 * 结账数据预览
	 * */
	public abstract BlccAggDO[] previewChechOut(String id_user,String id_org,String sd_cctp,FDateTime end_time) throws BizException;
	
	/**
	 * 住院结账预览时获取住院结算收付款明细信息(分页)（包括结账后查询）
	 * @param map   where条件集合(id_user,end_time,id_cc)	 
	 * @param pageInfo
	 * @author Liwq
	 * @throws BizException
	 * */
	public PagingRtnData<BlPayPatIpDTO> findBlPaypatIpDTOPageInfo(FMap map, PaginationInfo pageInfo) throws BizException;
	
	/**
	 * 通过结账查询界面的选中的一条数据BlccDO的主键id找到一条结账所对应的住院结账类型的住院收付款明细，用于显示结账历史查询的收付款明细界面显示用，用于修改需求后的显示用。
	 * @param id_cc 结账表主键
	 * @return
	 * @throws BizException
	 * 结账已废弃
	 */
	public abstract BlPayPatIpDTO[]  getBlPaypatIpDtosByIdcc(String id_cc,String id_emp_pay) throws BizException;
	
	/**
	 * 门诊结账预览时获取门诊结算收付款明细信息（分页）（包括结账后查询）
	 * @param map where条件集合（id_user,end_time,id_cc）
	 * @param pageInfo
	 * @author Liwq
	 * @throws BizException
	 * */
	public PagingRtnData<BlpayOepPatDTO> findBlPaypatOepDtosPageInfo(FMap map, PaginationInfo pageInfo) throws BizException;
	/**
	 * 查询结账 门诊收付款明细合计
	 * @param id_cc
	 * @return
	 * @throws BizException
	 * @author LIM
	 */
	public FDouble getBlPaypatOepDtosTotalAmt(FMap map) throws BizException;
	/**
	 * 结账后打印时，检验数据有效性（防止取消结账后，打印已取消的结账数据）
	 * @param id_cc
	 * @return
	 * @throws BizException
	 * @author Liwq
	 */
	
	public FBoolean checkDataValidity_Print(String id_cc) throws BizException;	
	

}