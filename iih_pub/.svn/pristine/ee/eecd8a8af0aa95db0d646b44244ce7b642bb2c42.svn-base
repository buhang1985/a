package iih.sc.scbd.i;

import iih.sc.scbd.dto.d.ScBdSrvDTO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;

/**
 * 排班基础数据命令服务
 * @author yank
 *
 */
public interface IScBdCmdService {
	/**
	 * 创建日志
	 * @param newDOs DO对象集合
	 * @param origDOs 原始DO对象集合
	 * @param operTp 操作类型,参考枚举：EuOperTp
	 * @throws BizException
	 */
	void createLog(BaseDO[] newDOs,BaseDO[] origDOs,String operTp, String empId) throws BizException;
	
	/**
	 * 保存排班参数
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
    ScdeptparamAggDO saveScDeptParam(ScdeptparamAggDO aggdo) throws BizException;
    
    /**
     * 
     * 
     * @param scBdSrvDTOs
     * @throws BizException
     */
    void saveScBdSrvDto(ScBdSrvDTO[] saveDtos, ScBdSrvDTO[] delDtos, String id_org, String id_grp) throws BizException;
    
    /***
     * 删除排班参数
     * @author yzh
     * @param aggdo
     * @throws BizException
     */
    void delScDeptParam(ScdeptparamAggDO aggdo) throws BizException;
    
    /**
     * 通过排班资源对照id获取排班资源对照集合
     * @author yzh
     * @param idScSrvRelArr
     * @return
     * @throws BizException
     */
    ScheduleSrvRelDO[] getScSrvRelArr(String[] idScSrvRelArr) throws BizException;
    
    
}
