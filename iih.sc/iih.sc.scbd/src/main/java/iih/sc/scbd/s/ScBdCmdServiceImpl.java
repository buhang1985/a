package iih.sc.scbd.s;

import iih.sc.scbd.bdsrv.s.bp.SaveScBdSrvBP;
import iih.sc.scbd.dto.d.ScBdSrvDTO;
import iih.sc.scbd.i.IScBdCmdService;
import iih.sc.scbd.log.s.bp.CreateLogBP;
import iih.sc.scbd.s.bp.DelScDeptParamBP;
import iih.sc.scbd.s.bp.GetScSrvRelArrBP;
import iih.sc.scbd.s.bp.SaveScDeptParamBP;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;

/**
 * 排班基础数据命令服务
 * @author yank
 *
 */
@Service(serviceInterfaces={IScBdCmdService.class}, binding=Binding.JSONRPC)
public class ScBdCmdServiceImpl implements IScBdCmdService{
	/**
	 * 创建日志
	 * @param newDOs DO对象集合
	 * @param origDOs 原始DO对象集合
	 * @param operTp 操作类型,参考枚举：EuOperTp
	 * @throws BizException
	 */
	@Override
	public void createLog(BaseDO[] newDOs,BaseDO[] origDOs,String operTp, String empId) throws BizException{
		CreateLogBP createBP = new CreateLogBP();
		createBP.exec(newDOs, origDOs, operTp, empId);
	}
	/**
	 * 保存排班参数
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
	@Override
	public ScdeptparamAggDO saveScDeptParam(ScdeptparamAggDO aggdo) throws BizException{
		SaveScDeptParamBP saveBp  = new SaveScDeptParamBP();
		return saveBp.exec(aggdo);
    }
	
	/**
	 * 
	 * 
     * @param scBdSrvDTOs
     * @throws BizException
	 */
	@Override
	public void saveScBdSrvDto(ScBdSrvDTO[] scBdSrvDTOs, ScBdSrvDTO[] delDtos, String id_org, String id_grp) throws BizException {
		SaveScBdSrvBP bp = new SaveScBdSrvBP();
		bp.exec(scBdSrvDTOs, delDtos,id_org,id_grp);
	}
	
	/**
	 * 删除排班服务
	 */
	@Override
	public void delScDeptParam(ScdeptparamAggDO aggdo) throws BizException {
		DelScDeptParamBP bp = new DelScDeptParamBP();
		bp.exec(aggdo);
	}
	
	/**
	 * 获取排班资源对照数据
	 */
	@Override
	public ScheduleSrvRelDO[] getScSrvRelArr(String[] idScSrvRelArr) throws BizException {
		GetScSrvRelArrBP bp = new GetScSrvRelArrBP();
		return bp.exec(idScSrvRelArr);
	}
}
