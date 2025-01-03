package iih.bl.comm.i;

import iih.bl.cg.dto.calpri.d.BlCalSrvPriDTO;
import iih.bl.cg.dto.calpri.d.BlCalSrvPriRltDTO;
import iih.bl.inc.dto.blprintset.d.BlPrintSetDTO;
import iih.bl.pay.dto.d.BlBannerDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 费用域通用服务
 * @author ly 2018/06/19
 *
 */
public interface IBlCommService {

	/**
	 * 查询费用域打印配置
	 * @param printType 打印类型
	 * @return 打印机配置
	 * @throws BizException
	 */
	public abstract BlPrintSetDTO findBlPrintSetInfo(String printType) throws BizException;

	/**
	 * 计算医疗服务价格（药品暂不处理）
	 * @param dtos 待计算服务
	 * @return 计价结果
	 * @throws BizException
	 * @author ly 2018/12/04
	 */
	public abstract BlCalSrvPriRltDTO[] calSrvPrice(BlCalSrvPriDTO[] dtos) throws BizException;
	
	/**
	 * 创建指定数量的主键
	 * @param num 数量
	 * @return 主键
	 * @throws BizException
	 * @author ly 2019/07/10
	 */
	public abstract String[] createPks(Integer num) throws BizException;

	/**
	 * 生成门诊结算编码
	 * @return
	 * @throws BizException
	 * @author ly 2019/08/02
	 */
	public abstract String createStCodeOep() throws BizException;
	
	/**
	 * 生成门诊预交金编号
	 * @throws BizException
	 * @author ly 2019/09/11
	 */
	public abstract String generateOpPrepayCode() throws BizException;
	
	/**
	 * 生成住院预交金编号
	 * @throws BizException
	 * @author ly 2019/09/11
	 */
	public abstract String generateIpPrepayCode() throws BizException;
	
	/**
	 * 
	 * @param mobiles
	 * @param message
	 * @param noticecode
	 * @return
	 * @throws BizException
	 */
	public abstract int sendSMSMessage(String  mobile, String message, String noticecode) throws BizException;
	
    /**
	 * 
	 * 根据Banner输入值查找对应就诊信息(急诊留观)
	 * @param qryType 检索类型
	 * @param inputValue 检索值
	 * @param selectCondition 检索条件
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<BlBannerDTO> findBannerDtoInfoET(String qryType, String inputValue,String[] selectCondition, PaginationInfo pageInfo) throws BizException;
	
	/**
	 * 获取消息内容
	 * @param noticecode
	 * @param variable
	 * @return
	 * @throws BizException
	 */
	public abstract String getMsgContext(String noticecode ,FMap2 variable) throws BizException;
}
