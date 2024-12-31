package iih.bd.fc.s.bp.orwfcfg.match;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.deptflow.FlowEntryBp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * @Description:医嘱流向处理
 * @author: xu_xing@founder.com.cn
 * @version：2019年5月6日 上午8:41:11 创建
 */
public class OrWfCfgFlowEntryBp {

	/**
	 * 单个流向匹配
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public OrWfExDeptDTO[] singleMatch(OrWfExDeptParamDTO param) throws BizException {
		String ver_orwf = this.getMatchVer();
		if ("1".equals(ver_orwf)) {
			//1.0版本流向
			FlowEntryBp bp = new FlowEntryBp();
			OrWfExDeptParamDTO[] res = bp.exec(new OrWfExDeptParamDTO[] { param });
			if (res == null || res.length < 1)
				return null;
			OrWfExDeptDTO[] rtns = getWfRes(res[0]);
			return rtns;
		} else {
			//2.0版本流向
			WfFlowEntryBp bp = new WfFlowEntryBp();
			OrWfExDeptParamDTO[] res = bp.exec(new OrWfExDeptParamDTO[] { param });
			if (res == null || res.length < 1)
				return null;
			OrWfExDeptDTO[] rtns = getWfRes(res[0]);
			return rtns;
		}
	}

	/**
	 * 批量流向匹配
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	public OrWfExDeptParamDTO[] batchMatch(OrWfExDeptParamDTO[] params) throws BizException {
		String ver_orwf = this.getMatchVer();
		if ("1".equals(ver_orwf)) {
			//1.0版本流向
			FlowEntryBp bp = new FlowEntryBp();
			OrWfExDeptParamDTO[] rtns = bp.exec(params);
			return rtns;
		} else {
			//2.0版本流向
			WfFlowEntryBp bp = new WfFlowEntryBp();
			OrWfExDeptParamDTO[] rtns = bp.exec(params);
			return rtns;
		}
	}

	/**
	 * 获取流向版本
	 * @return
	 * @throws BizException
	 */
	private String getMatchVer() throws BizException {
		return ParamsetQryUtil.getParaString(Context.get().getOrgId(), "BDFC0001");
	}

	/**
	 * 获取流向结果
	 * @param rtn
	 * @return
	 */
	private OrWfExDeptDTO[] getWfRes(OrWfExDeptParamDTO rtn) {
		List<OrWfExDeptDTO> reList = new ArrayList<OrWfExDeptDTO>();
		if (rtn == null)
			return null;
		FArrayList arrays = rtn.getRes();
		if (arrays == null || arrays.size() < 1)
			return null;
		for (Object object : arrays) {
			OrWfExDeptDTO res = (OrWfExDeptDTO) object;
			reList.add(res);
		}
		return reList.toArray(new OrWfExDeptDTO[0]);
	}
}
