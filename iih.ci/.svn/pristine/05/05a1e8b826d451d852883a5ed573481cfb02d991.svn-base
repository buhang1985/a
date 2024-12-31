package iih.ci.ord.s.bp.orsrvsplit;

import java.util.Arrays;
import java.util.List;

import iih.ci.ord.dto.blexorder.d.OrGenSplitTpEnum;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.OrSrvSplitDTO;
import iih.ci.ord.s.bp.orsrvsplit.firstmp.OrSplitFixBp;
import iih.ci.ord.s.bp.orsrvsplit.firstmp.OrSrvSplitFixBp;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.lock.PKLock;

/**
 * 住院医嘱拆分
 * 
 * @author xuxing
 *
 * @version 2017年9月15日16:29:07_ljm根据医嘱首日执行次数补全医嘱首日必要执行点
 * @version 2017年10月23日10:02:22xuxing_移除服务加锁（拆分入口有医嘱锁足够，实际拆分不会单独拆分医嘱或服务，
 *          此为拆分唯一入口）
 * @version 2018年2月10日17:18:38xuxing_加锁逻辑单独逻辑（简单查询加锁需要的Key）
 * @version 2018年3月15日18:21:54xuxing_首日执行次数逻辑迭代
 * @version 2018年11月3日17:10:18xuxing，移除迭代参数
 * @version xuxing_2019年5月29日14:45:11；拆分增加查询返回结果
 *
 */
public class getOrSplitSqlRsBp {

	/**
	 * 主入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public BaseDTO exec(OrSrvSplitParamDTO param) throws BizException {

		// 1、构建返回值
		OrSrvSplitDTO rtn = new OrSrvSplitDTO();

		if (FBoolean.TRUE.equals(param.getFg_presplit())) {
			if (param.getDt_split_start() == null) {
				throw new BizException("预拆分必须指定开始时间！");
			}
		} else {
			param.setDt_split_start(null);
		}

		// 2、拆分前加锁
		boolean fg_lock = setLockBeforSplit(param);
		if (!fg_lock)
			return rtn;

		// 3、医嘱拆分
		splitOr(param, rtn);

		// 4、服务拆分
		splitOrSrv(param, rtn);

		return rtn;
	}

	/**
	 * 拆分前加锁
	 * 
	 * @param param
	 * @throws BizException
	 */
	private boolean setLockBeforSplit(OrSrvSplitParamDTO param) throws BizException {
		GetIpOrSplitLockKeysBp bp = new GetIpOrSplitLockKeysBp();
		String[] key = bp.exec(param);
		if (key != null && key.length > 0) {
			boolean getLock = PKLock.getInstance().addBatchDynamicLock(key);// 锁定数据
			if (!getLock)
				throw new BizException("医嘱拆解繁忙【获锁失败】，请稍后重试！");
			return getLock;
		}
		return false;
	}

	/**
	 * 拆分医嘱
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void splitOr(OrSrvSplitParamDTO param, OrSrvSplitDTO rtn) throws BizException {

		FArrayList splitOrArry = new FArrayList();
		param.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYOR);// 标记为医嘱拆分

		// 医嘱查询
		FArrayList aryOrArry = new FArrayList();
		GetOrAndSrvSplitSqlRsBP orBp = new GetOrAndSrvSplitSqlRsBP();
		OrSplitOrderDTO[] queryRes = (OrSplitOrderDTO[]) orBp.exec(param);
		if (queryRes != null && queryRes.length > 0)
			aryOrArry.addAll(Arrays.asList(queryRes));
		rtn.setOrqryarray(aryOrArry);

		// 拆分医嘱
		SplitOrAndSrvSplitSqlRsBP orSplitbp = new SplitOrAndSrvSplitSqlRsBP();
		OrSplitOrderDTO[] orSplitRes = (OrSplitOrderDTO[]) orSplitbp.exec(queryRes, param.getDt_split_start(), param.getDt_split_end(), OrGenSplitTpEnum.SPLITBYOR);
		if (orSplitRes != null && orSplitRes.length > 0) {
			splitOrArry.addAll(Arrays.asList(orSplitRes));// 本次拆分集合添加到返回
		}

		// 补齐首日执行
		fixOrSplit(queryRes, orSplitRes, splitOrArry, param);

		rtn.setOrsplitarry(splitOrArry);
	}

	/**
	 * 医嘱首日拆分补齐逻辑
	 * 
	 * @param queryRes
	 * @param orSplitRes
	 * @param splitArry
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void fixOrSplit(OrSplitOrderDTO[] queryRes, OrSplitOrderDTO[] orSplitRes, FArrayList splitArry, OrSrvSplitParamDTO param) throws BizException {
		OrSplitFixBp bp = new OrSplitFixBp();
		List<OrSplitOrderDTO> listAdd = bp.exec(queryRes, orSplitRes, param);
		if (listAdd != null && listAdd.size() > 0)
			splitArry.addAll(listAdd);
	}

	/**
	 * 拆分服务
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void splitOrSrv(OrSrvSplitParamDTO param, OrSrvSplitDTO rtn) throws BizException {

		FArrayList splitSrvArry = new FArrayList();
		param.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYSRVMM);

		// 服务查询
		FArrayList qrySrvArry = new FArrayList();
		GetOrAndSrvSplitSqlRsBP srvBp = new GetOrAndSrvSplitSqlRsBP();
		SrvSplitOrderDTO[] queryRes = (SrvSplitOrderDTO[]) srvBp.exec(param);
		if (queryRes != null && queryRes.length > 0)
			qrySrvArry.addAll(Arrays.asList(queryRes));
		rtn.setSrvqryarray(qrySrvArry);

		// 服务拆分
		SplitOrAndSrvSplitSqlRsBP srvSplitbp = new SplitOrAndSrvSplitSqlRsBP();
		SrvSplitOrderDTO[] srvSplitRes = (SrvSplitOrderDTO[]) srvSplitbp.exec(queryRes, param.getDt_split_start(), param.getDt_split_end(), OrGenSplitTpEnum.SPLITBYSRVMM);
		if (srvSplitRes != null && srvSplitRes.length > 0) {
			splitSrvArry.addAll(Arrays.asList(srvSplitRes));// 本次拆分集合添加到返回
		}

		// 补齐首日执行
		fixOrSrvSplit(queryRes, srvSplitRes, splitSrvArry, param);

		rtn.setSrvsplitarry(splitSrvArry);
	}

	/**
	 * 医嘱首日拆分补齐逻辑
	 * 
	 * @param queryRes
	 * @param orSplitRes
	 * @param splitArry
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void fixOrSrvSplit(SrvSplitOrderDTO[] queryRes, SrvSplitOrderDTO[] orSplitRes, FArrayList srvSplitRes, OrSrvSplitParamDTO param) throws BizException {
		OrSrvSplitFixBp bp = new OrSrvSplitFixBp();
		List<SrvSplitOrderDTO> listAdd = bp.exec(queryRes, orSplitRes, param);
		if (listAdd != null && listAdd.size() > 0)
			srvSplitRes.addAll(listAdd);
	}

	/**
	 * 首日拆分
	 * 
	 * @param params
	 * @param splitArry
	 * @param key
	 * @param dt_last_bl
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private void completeFirstDayPlan(BaseDTO[] queryRes, BaseDTO[] orSplitRes, FArrayList splitArry, String key, String dt_last_bl) throws BizException {
		if (queryRes != null && queryRes.length > 0) {
			OrSrvSplitFirdayMpValidBp bp = new OrSrvSplitFirdayMpValidBp();
			List<BaseDTO> list = bp.exec1(queryRes, orSplitRes, key, dt_last_bl);
			if (list != null && list.size() > 0) {
				splitArry.addAll(list);// 首日补齐的计划
			}
		}
	}
}
