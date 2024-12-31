package iih.bd.pp.task.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.modifypriplan.s.bp.ModifyPriceByPlanIdsBp;
import iih.bd.utils.BdPpParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.permfw.user.d.UserDO;

/**
 * 调价任务业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ModifyPriceTaskBP {

	/**
	 * 任务启动参数_用户主键
	 */
	private final String USERID = "UserId";

	/**
	 * 执行调价
	 * 
	 * @throws BizException
	 */
	public void exec(BgWorkingContext bgwc) throws BizException {
		// 1.检查任务参数
		checkParam(bgwc);

		// 2.初始化执行用户
		initContext(bgwc);

		// 3.修改价格
		modifyPrice();
	}

	/**
	 * 修改价格
	 * 
	 * @throws BizException
	 */
	private void modifyPrice() throws BizException {
		// 设置后台调价标识
		BdPpParamUtils.setBgTaskModifyPriFlag(Boolean.TRUE);

		ModifyPriceByPlanIdsBp bp = new ModifyPriceByPlanIdsBp();
		bp.exec(null, AppUtils.getServerDateTime());
	}

	/**
	 * 使用后台任务参数初始化上下文
	 * 
	 * @param bgwc
	 * @throws BizException
	 */
	private void initContext(BgWorkingContext bgwc) throws BizException {
		String userId = bgwc.getKeyMap().get(this.USERID).toString();
		Context.get().setUserId(userId);

		initContextByUser(userId);
	}

	/**
	 * 使用用户Id初始化上下文
	 * 
	 * @param userId
	 * @throws BizException
	 */
	private void initContextByUser(String userId) throws BizException {
		UserDO user = GetUserById(userId);
		Context.get().setGroupId(user.getId_group());
		Context.get().setOrgId(user.getId_org());
	}

	/**
	 * 使用用户主键获取用户信息
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	private UserDO GetUserById(String userId) throws BizException {
		DAFacade daFacade = new DAFacade();
		UserDO userDo = (UserDO) daFacade.findByPK(UserDO.class, userId);
		if (userDo == null) {
			String msg = String.format("获取用户信息失败，用户主键:%s。", userId);
			throw new BizException(msg);
		}
		return userDo;
	}

	/**
	 * 初始化任务参数
	 * 
	 * @param bgwc
	 * @throws BizException
	 */
	private void checkParam(BgWorkingContext bgwc) throws BizException {
		checkParam(bgwc, this.USERID);
	}

	/**
	 * 检查参数
	 * 
	 * @param bgwc
	 * @param paramCode
	 * @throws BizException
	 */
	private void checkParam(BgWorkingContext bgwc, String paramCode) throws BizException {
		if (bgwc.getKeyMap() == null || !bgwc.getKeyMap().containsKey(paramCode)) {
			String msg = String.format("参数\"%s\"不允许为空。", paramCode);
			throw new BizException(msg);
		}
	}

}
