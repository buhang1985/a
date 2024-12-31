package iih.pi.overview.s;

import iih.pi.overview.dto.d.PatAlDTO;
import iih.pi.overview.i.IPiOverviewMaintainService;
import iih.pi.overview.s.bp.PiDeletePatAlBp;
import iih.pi.overview.s.bp.PiInsertPatAlBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 患者临床摘要维护服务
 * @author ly
 *
 */
@Service(serviceInterfaces={IPiOverviewMaintainService.class}, binding=Binding.JSONRPC)
public class PiOverviewMaintainServiceImpl implements IPiOverviewMaintainService {

	/**
	 * 插入患者过敏史数据
	 * 相同日期相同的物品不保存
	 * @param dto 过敏史dto
	 * @throws BizException 患者id为空|发生日期为空|物品id为空
	 */
	@Override
	public void insertPatAlData(PatAlDTO[] dtos) throws BizException {
		PiInsertPatAlBp bp = new PiInsertPatAlBp();
		bp.exec(dtos);
	}
	
	/**
	 * 删除患者过敏史数据
	 * 依据条件查询不到数据时不做处理
	 * 目前主要是取消皮试结果时调用该接口
	 * @param dto 过敏史dto
	 * @throws BizException 患者id为空|发生日期为空
	 */
	@Override
	public void deletePatAlData(PatAlDTO dto) throws BizException{
		PiDeletePatAlBp bp = new PiDeletePatAlBp();
		bp.exec(dto);
	}
}
