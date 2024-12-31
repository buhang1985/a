package iih.ci.preip.imp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 预住院医嘱导入为正式住院医嘱服务接口定义
 * 
 * @author wangqingzhu
 *
 */
public interface ICiPreIPImpOrderMainService {

    /**
     * 预住院医嘱导入成正式医嘱接口定义
     * 
     * @param id_en
     *            就诊ID
     * @param dt_acpt
     *            入科时间
     * @param dt_oper
     *            操作时间
     * @param id_dep_oper
     *            操作科室
     * @param id_emp_oper
     *            操作人员
     * @return
     * @throws BizException
     */
    public abstract CiPreIPImpRst importOrders(String id_en, FDateTime dt_acpt, FDateTime dt_oper, String id_dep_oper,
            String id_emp_oper) throws BizException;
}
