package iih.en.pv.s.bp.ip;

import iih.en.comm.IEnConst;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.pv.enfee.d.EnPeCmpyACCDO;
import iih.en.pv.inpatient.d.EnPeCmpyDO;
import iih.en.pv.inpatient.d.EnpecmpyAggDO;
import iih.en.pv.inpatient.d.PeStatusEnum;
import iih.en.pv.inpatient.dto.d.EnPeCmpyDTO;
import iih.en.pv.inpatient.i.IEnpecmpyMDOCudService;
import iih.en.pv.inpatient.i.IEnpecmpyRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存团检单位信息
 * 
 * @author renying
 *
 */
public class SaveEnPeComyInfoBP {

    /**
     * 保存团检单位信息
     * 
     * @param qryDTO
     * @return
     * @throws BizException
     */
    public void exec(EnPeCmpyDTO qryDTO) throws BizException {
        EnPeCmpyDO[] enPeCmpyDOs = this.saveEnPeCmpyDTO(qryDTO);
        if (enPeCmpyDOs != null && enPeCmpyDOs.length!= 0) {
            //新增团检账户
            this.saveEnPeCmpyACCDO(enPeCmpyDOs[0],qryDTO);
        }
        return;
    }

    /**
     * 保存团检账户
     * @param qryDTO
     * @throws BizException 
     */
    private void saveEnPeCmpyACCDO(EnPeCmpyDO enPeCmpyDO,EnPeCmpyDTO qryDTO) throws BizException {
        SaveEnPeCmpyACCDOBP bp = new SaveEnPeCmpyACCDOBP();
        bp.serviceExec(this.getEnPeCmpyACCDO(enPeCmpyDO ,qryDTO));
        
    }

    /**
     * 设置团检账户
     * @param enPeCmpyDO
     * @param qryDTO
     * @return
     * @throws BizException 
     */
    @SuppressWarnings("unused")
    private EnPeCmpyACCDO getEnPeCmpyACCDO(EnPeCmpyDO enPeCmpyDO,EnPeCmpyDTO qryDTO) throws BizException {
        //创建一个新的团检账号
        EnPeCmpyACCDO accdo = new  EnPeCmpyACCDO();
        //设置集团
        accdo.setId_grp(qryDTO.getId_grp());
        //设置组织
        accdo.setId_org(qryDTO.getId_org());
        //设置团检记录id
        accdo.setId_pecmpy(enPeCmpyDO.getId_pecmpy());
        //设置团检单位
        accdo.setId_cust_cmpy(enPeCmpyDO.getId_cust_cmpy());
        //设置创建人
        accdo.setCreatedby(EnContextUtils.getPsnDoc().getName());
        //设置团检额度
        accdo.setAmt_cred(new FDouble(0));
        //设置就诊预交金
        accdo.setAmt_prepay(new FDouble(0));
        //设置可报销医保额度
        accdo.setAmt_hp(new FDouble(0));
        //设置就诊未结算费用
        accdo.setAmt_uncg(new FDouble(0));
        //设置欠费下限
        accdo.setAmt_owelimit(new FDouble(0));
        //设置创建时间
        accdo.setCreatedtime(new FDateTime());
        //设置后台划价截止日期
        accdo.setDt_backcg(new FDateTime());
        //设置后台划价最后操作日期
        accdo.setDt_backcglastact(new FDateTime());
        //设置最后修改事件
        accdo.setModifiedtime(new FDateTime());
        return accdo;
    }
    
    /**
     * 保存团检单位信息
     * @param qryDTO
     * @throws BizException
     */
    @SuppressWarnings("unused")
    private EnPeCmpyDO[] saveEnPeCmpyDTO(EnPeCmpyDTO qryDTO) throws BizException {
        
        IEnpecmpyMDOCudService doService = ServiceFinder.find(IEnpecmpyMDOCudService.class);
        EnpecmpyAggDO aggDO = this.getEnPeCmpyDO(qryDTO);
        EnPeCmpyDO seldo =  this.setEnPeCmpyDO(qryDTO, aggDO);
        EnPeCmpyDO[] insert = doService.insert( new EnPeCmpyDO[]{seldo});
        return insert;
    }
    
    /**
     * 设置EnPeCmpyDo
     * @param qryDTO
     * @return
     * @throws BizException 
     */
    private EnPeCmpyDO setEnPeCmpyDO(EnPeCmpyDTO qryDTO,EnpecmpyAggDO aggDO) throws BizException {
        EnPeCmpyDO seldo =  new EnPeCmpyDO();
        //设置组织
        seldo.setId_org(qryDTO.getId_org());
        //设置集团
        seldo.setId_grp(qryDTO.getId_grp());
        //设置团检单位id
        seldo.setId_cust_cmpy(qryDTO.getId_cust_cmpy());
        //设置团检编码
        seldo.setNo_contract(EnCodeUtils.EnPeCmpyItmDOCode());
        if (aggDO != null) {
            //设置提交次数
            seldo.setTimes_pe(aggDO.getParentDO().getTimes_pe() + IEnConst.EN_ENT_COUNT_ONE); 
        }else {
            //设置提交次数
            seldo.setTimes_pe(IEnConst.EN_ENT_COUNT_ONE); 
        }
        //设置团检状态
        seldo.setEu_status(PeStatusEnum.STATUS_PE_INHOS); 
        //设置有效标识
        if ("true".equals(qryDTO.getFg_active())) {            
            seldo.setFg_active(FBoolean.TRUE);
        }else {
            seldo.setFg_active(FBoolean.FALSE);
        }
        //设置入院时间
        seldo.setDt_b(qryDTO.getDt_b());
        return seldo;
    }
    
    /**
     * 用于查询体检次数
     * @return
     * @throws BizException 
     */
    private EnpecmpyAggDO getEnPeCmpyDO(EnPeCmpyDTO qryDTO) throws BizException {
        IEnpecmpyRService rService = ServiceFinder.find(IEnpecmpyRService.class);
        EnpecmpyAggDO[] find = rService.find("a0.ID_CUST_CMPY = '" + qryDTO.getId_cust_cmpy() + "'", "times_pe desc", FBoolean.FALSE);
        if (find != null && find.length != 0) {
            return find[0];
        }
        return null;
        
        
    }
    
}
