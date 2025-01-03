package iih.sc.scbd.s;

import iih.sc.comm.ScParamUtils;
import iih.sc.scbd.dto.d.ScPrtCfgQryDTO;
import iih.sc.scbd.dto.d.ScPrtTmplDTO;
import iih.sc.scbd.i.IScBdOutQryService;
import iih.sc.scbd.s.bp.BatchGetChlByTpBP;
import iih.sc.scbd.s.bp.GetChlByTpBP;
import iih.sc.scbd.s.bp.GetDeptParamsBP;
import iih.sc.scbd.s.bp.GetScPrtTmplBp;
import iih.sc.scbd.s.bp.GetScRuleTpBp;
import iih.sc.scbd.s.bp.GetSchSrvRelBP;
import iih.sc.scbd.s.bp.GetSrvTpBP;
import iih.sc.scbd.s.ep.ChlEP;
import iih.sc.scbd.s.ep.SrvEp;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 排班基础数据对外查询服务
 * 
 * @author yank
 *
 */
@Service(serviceInterfaces = { IScBdOutQryService.class }, binding = Binding.JSONRPC)
public class ScBdOutQryServiceImpl implements IScBdOutQryService {
	/**
	 * 获取诊疗类型
	 * 
	 * @param scSrvId 排班服务id
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getSrvTp(String scSrvId) throws BizException {
		GetSrvTpBP getBP = new GetSrvTpBP();
		return getBP.exec(scSrvId);
	}

	/**
	 * 获取渠道
	 * 
	 * @param chlTp 渠道类型编码
	 * @return 预约渠道集合
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public SchedulechlDO[] getChlByTp(String chlTp) throws BizException {
		GetChlByTpBP getChlBP = new GetChlByTpBP();
		return getChlBP.exec(chlTp);
	}

	/**
	 * 获取渠道
	 * 
	 * @param chlTps 渠道类型编码集合
	 * @return 预约渠道集合
	 * @throws BizException
	 * @author yank
	 */
	@Override
	public SchedulechlDO[] batchGetChlByTpBP(String[] chlTps) throws BizException {
		BatchGetChlByTpBP getBP = new BatchGetChlByTpBP();
		return getBP.exec(chlTps);
	}

	/**
	 * 根据排班渠道ID获取排班渠道DO
	 * 
	 * @author zhengcm
	 * @date 2017-11-20 11:00:26
	 *
	 * @param id_scchl
	 * @return
	 * @throws BizException
	 */
	@Override
	public SchedulechlDO getChlById(String id_scchl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scchl)) {
			return null;
		}
		ChlEP ep = new ChlEP();
		return ep.getChlById(id_scchl);
	}

	/**
	 * 获取预约规则类型
	 * 
	 * @param id_scrule 预约规则id
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getScRuleTpBp(String id_scrule) throws BizException {
		GetScRuleTpBp bp = new GetScRuleTpBp();
		return bp.exec(id_scrule);
	}

	/**
	 * 根据医疗服务id 求所对应的 排班服务ids
	 * 
	 * @param id_srv
	 * @throws BizException
	 */
	@Override
	public String getScSrvIdsByBdSrv(String id_srv) throws BizException {
		return new SrvEp().getScSrvIdsByBdSrv(id_srv);
	}

	/**
	 * 获取科室参数
	 *
	 * @param id_dept 科室id
	 * @param sd_sctp 排班类型编码
	 * @return 科室参数AggDO
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public ScdeptparamAggDO[] getDeptParamList(String id_dept, String sd_sctp) throws BizException {
		return new GetDeptParamsBP().exec(id_dept, sd_sctp);
	}
	/**
	 * 根据服务编码获取子服务的do数组
	 * 
	 * @param srvCode
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScheduleSrvRelDO[] getSchSrvRelBP(String srvCode) throws BizException {
		GetSchSrvRelBP srvBP = new GetSchSrvRelBP();
		return srvBP.exec(srvCode);
	}
	/**
     * 获取非门诊排班的排班服务id
     * 
     * @return
     * @throws BizException
     */
	@Override
	public String getScsrvIdsNoOpSch() throws BizException {
		return ScParamUtils.getScSrvIdsNoOpSch();
	}


	/**
	 * 根据id查询排班服务
	 *
	 * @param id_scsrv
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	@Override
	public ScheduleSrvDO getScSrvById(String id_scsrv) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scsrv)) {
			return null;
		}
		ISchedulesrvMDORService schedulesrvMDORService = ServiceFinder.find(ISchedulesrvMDORService.class);
		return schedulesrvMDORService.findById(id_scsrv);
	}

	/**
	 * 根据打印模板项目配置信息查询 打印模板
	 * @param qryDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScPrtTmplDTO getScPrtTmplDTO(ScPrtCfgQryDTO qryDTO) throws BizException {
		GetScPrtTmplBp bp = new GetScPrtTmplBp();
		return bp.getScPrtTmplDTOByCfg(qryDTO);
	}
	
}
