package iih.ci.preop.imp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 预住院申请导入预住院医嘱接口
 * 
 * @author mkp
 *
 */
public interface ICiPreOPImpOrderMainService {

    /**
     * 导入门诊预住院申请为预住院医嘱
     * 
     * @param id_en_op
     *            门诊就诊号
     * @param id_en_pre
     *            预住院就诊号
     * @param id_dep_oper
     *            操作科室
     * @param id_emp_oper
     *            操作人员
     * @param dt_oper
     *            操作时间
     * @return
     * @throws BizException
     */
    CiPreOPImpRst importApplyItem(String id_en_op, String id_en_pre, String id_dep_oper, String id_emp_oper,
            FDateTime dt_oper) throws BizException;

    /**
     * 根据治疗方案Id导入
     * 
     * @param id_en_pre
     * @param tsOrIds
     * @return
     * @throws BizException
     */
    CiPreOPImpRst importApplyItemByTsIds(String id_en_pre, String[] tsOrIds) throws BizException;
    
    /**
     * 列表加载
     * @param ctx
     * @param param
     * @return
     * @throws BizException
     */
    OrderRstDTO load(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException;
}
