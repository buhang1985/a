package iih.bl.comm.s;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.dto.calpri.d.BlCalSrvPriDTO;
import iih.bl.cg.dto.calpri.d.BlCalSrvPriRltDTO;
import iih.bl.comm.i.IBlCommService;
import iih.bl.comm.s.bp.BLCalSrvPriceBP;
import iih.bl.comm.s.bp.BlCreatePksBP;
import iih.bl.comm.s.bp.BlCreateStCodeBP;
import iih.bl.comm.s.bp.BlFindPrintSetBP;
import iih.bl.comm.s.bp.GetEtBannerInfoBp;
import iih.bl.comm.s.bp.SendSMSMessageBP;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.inc.dto.blprintset.d.BlPrintSetDTO;
import iih.bl.pay.dto.d.BlBannerDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.message.message.i.IGenerateMessageExtdService;
/**
 * 费用域通用服务
 * @author ly 2018/06/19
 *
 */
@Service(serviceInterfaces = { IBlCommService.class }, binding = Binding.JSONRPC)
public class BlCommServiceImpl implements IBlCommService {

	/**
	 * 查询费用域打印配置
	 * @param printType 打印类型
	 * @return 打印机配置
	 * @throws BizException
	 */
	@Override
	public BlPrintSetDTO findBlPrintSetInfo(String printType) throws BizException{
		BlFindPrintSetBP bp = new BlFindPrintSetBP();
		return bp.exec(printType);
	}
	
	/**
	 * 计算医疗服务价格（药品暂不处理）
	 * @param dtos 待计算服务
	 * @return 计价结果
	 * @throws BizException
	 * @author ly 2018/12/04
	 */
	@Override
	public BlCalSrvPriRltDTO[] calSrvPrice(BlCalSrvPriDTO[] dtos) throws BizException{
		BLCalSrvPriceBP bp = new BLCalSrvPriceBP();
		return bp.exec(dtos);
	}
	
	/**
	 * 创建指定数量的主键
	 * @param num 数量
	 * @return 主键
	 * @throws BizException
	 * @author ly 2019/07/10
	 */
	@Override
	public String[] createPks(Integer num) throws BizException{
		BlCreatePksBP bp = new BlCreatePksBP();
		return bp.exec(num);
	}
	
	/**
	 * 生成门诊结算编码
	 * @return
	 * @throws BizException
	 * @author ly 2019/08/02
	 */
	@Override
	public String createStCodeOep() throws BizException{
		BlCreateStCodeBP bp = new BlCreateStCodeBP();
		return bp.createStOepCode();
	}
	
	
	/**
	 * 生成门诊预交金编号
	 * @throws BizException
	 * @author ly 2019/09/11
	 */
	@Override
	public String generateOpPrepayCode() throws BizException{
		String code = BlCodeUtils.generateOpPrepayCode();
		return code;
	}
	
	/**
	 * 生成住院预交金编号
	 * @throws BizException
	 * @author ly 2019/09/11
	 */
	public String generateIpPrepayCode() throws BizException{
		String code = BlCodeUtils.generateIpPrepayCode();
		return code;
	}
	
	/**
	 * 发送短信
	 */
	@Override
	public int sendSMSMessage(String mobiles, String message, String noticecode) throws BizException {
		SendSMSMessageBP bp = new SendSMSMessageBP();
		return bp.exec(mobiles,message,noticecode);
	}
	
	/**
	 * 
	 * 根据Banner输入值查找对应就诊信息(急诊留观)
	 * @param qryType 检索类型
	 * @param inputValue 检索值
	 * @param selectCondition 检索条件
	 * @return
	 * @throws BizException
	 */
	@Override
	public PagingRtnData<BlBannerDTO> findBannerDtoInfoET(String qryType, String inputValue,String[] selectCondition, PaginationInfo pageInfo) throws BizException {
		GetEtBannerInfoBp bp = new GetEtBannerInfoBp();
		return bp.exec(qryType, inputValue, selectCondition, IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS,pageInfo);
	}

	/**
	 * 获取消息内容
	 */
	@Override
	public String getMsgContext(String noticecode, FMap2 map) throws BizException {
		IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
		Map<String,Object> variable = new HashMap<String, Object>();
		variable.putAll(map);
		return msgService.getContext(noticecode, variable);
	}

}
