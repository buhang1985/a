package iih.bd.fc.quesite.s;

import iih.bd.fc.quesite.bp.GetQueSiteByRoomBP;
import iih.bd.fc.quesite.bp.GetRoomsBP;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQueSiteQryService;
import iih.bd.fc.quesite.s.bp.FindCurrWinByDepIdBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 就诊队列扩展查询服务
 * 
 * @author liubin
 *
 */
@Service(serviceInterfaces = { IQueSiteQryService.class }, binding = Binding.JSONRPC)
public class QueSiteQryServiceImpl implements IQueSiteQryService {

	/**
	 * 根据部门ID获取门诊诊间集合
	 * 
	 * @param depId 部门ID
	 * @return
	 * @throws BizException
	 */
	@Override
	public String[] getRooms(String depId) throws BizException {
		GetRoomsBP bp = new GetRoomsBP();
		return bp.getRooms(depId);
	}

	/**
	 * 根据诊间获取诊椅（即站点）集合
	 * 
	 * @param room 诊间
	 * @return
	 * @throws BizException
	 */
	@Override
	public QueSiteDO[] getQueSiteByRoom(String depId, String room) throws BizException {
		GetQueSiteByRoomBP bp = new GetQueSiteByRoomBP();
		return bp.getQueSiteByRoom(depId, room);
	}

	@Override
	public QueSiteDO findCurrWinByDepId(String depId) throws BizException {
		FindCurrWinByDepIdBp bp = new FindCurrWinByDepIdBp();
		QueSiteDO queSiteDO = bp.exec(depId);
		return queSiteDO;
	}

}
