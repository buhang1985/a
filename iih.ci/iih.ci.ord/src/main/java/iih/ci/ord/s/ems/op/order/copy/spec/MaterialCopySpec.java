package iih.ci.ord.s.ems.op.order.copy.spec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import bsh.StringUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 复制时物品规格校验
 * 
 * @author mkp
 *
 */
public class MaterialCopySpec {

    public MaterialCopySpec() {
    }
    
    /**
     * 检查是否有停用、停开的物品
     * 该部分逻辑来自iih.ci.ord.s.bp.ordsrvchangedval.OrdChangedSrvValidateBP
     * 
     * @param ordSrvDOs 
     * @param ciOrderDO 
     * @param materialIdList
     * @return
     * @throws BizException
     */
    public static Map<String, MeterialDO> checkStopMaterial(List<OrdSrvMmDO> srvMmList, OrdSrvDO[] ordSrvDOs, CiOrderDO ciOrderDO) throws BizException {
        if (srvMmList == null || srvMmList.size() == 0) {
            return null;
        }
        
        List<String> srvIds = new ArrayList<>();
        List<String> mmIds = new ArrayList<>();
        
        for (OrdSrvMmDO item : srvMmList) {
            for (OrdSrvDO srvDO : ordSrvDOs) {
                if (item.getId_orsrv().equals(srvDO.getId_orsrv())) {
                    srvIds.add(srvDO.getId_srv());                    
                }
            }
            mmIds.add(item.getId_mm());
        }
        
        MeterialDO[] materialDOs = ServiceFinder.find(IMeterialMDORService.class).findByIds(mmIds.toArray(new String[0]), FBoolean.FALSE);
        MedSrvDO[] srvDOs = ServiceFinder.find(IMedsrvMDORService.class).findByIds(srvIds.toArray(new String[0]), FBoolean.FALSE);
        
        Map<String, MeterialDO> stopMap = new HashMap<>();
        for (OrdSrvMmDO srvMmDO : srvMmList) {
            boolean checkRequired = true;
            for (OrdSrvDO srvDO : ordSrvDOs) {
                if (srvMmDO.getId_orsrv().equals(srvDO.getId_orsrv())) {
                    for (MedSrvDO medSrv : srvDOs) {
                        // 执行绑定不对物品的停开，就诊类型是否匹配，关联物品信息是否正确进行校验
                        if (srvDO.getId_srv().equals(medSrv.getId_srv()) && ICiDictCodeConst.SD_MMBIND_EXECUTE.equals(getSd_mmbindType(ciOrderDO.getCode_entp(), medSrv))) {
                            checkRequired = false;
                        }
                    }
                }
            }

            for (MeterialDO meterialDO : materialDOs) {
                if (checkRequired && srvMmDO.getId_mm().equals(meterialDO.getId_mm()) && (FBoolean.FALSE.equals(meterialDO.getFg_active()) || FBoolean.TRUE.equals(meterialDO.getFg_out()))) {
                    stopMap.put(meterialDO.getId_mm(), meterialDO);
                }
            }
        }
        

        return stopMap;
    }
    
    /**
     *  物品绑定时机编码
     * 
     * @param code_entp
     * @param medsrvDO
     * @return
     */
    private static String getSd_mmbindType(String code_entp, MedSrvDO medsrvDO) {
        String value = "";
        switch (code_entp) {
        case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
            value = medsrvDO.getSd_mmbind_op();
            break;
        case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW:
            value = medsrvDO.getSd_mmbind_er();
            break;
        case IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID:
            value = medsrvDO.getSd_mmbind_er();
            break;
        case IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS:
            value = medsrvDO.getSd_mmbind_er();
            break;
        case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
            value = medsrvDO.getSd_mmbind_ip();
            break;
        case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
            value = medsrvDO.getSd_mmbind_fm();
            break;
        case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
            value = medsrvDO.getSd_mmbind_pe();
            break;

        }

        return value;
    }
    
    /**
     * 
     * 若医嘱中全部药品库存不足（或已停用），则提示医生，不进行自动保存。
     * 若医嘱中部分药品库存不足（或已停用），则将库存充足（可正常使用）部分的药品，正常进行医嘱保存，并弹出具体库存不足（已停用）药品的信息，提醒医生进行医嘱调整。
     * 
     * @param ordSrvMmDOs
     * @param stockCheckWarn
     * @param aggdo
     * @param ordSrvDOs
     * @param noStockList
     * @param refusedMap 
     * @return
     */
    public static boolean filterNoStockItems(OrdSrvMmDO[] ordSrvMmDOs, StringBuilder stockCheckWarn, CiorderAggDO aggdo,
            OrdSrvDO[] ordSrvDOs, List<OrdSrvMmDO> noStockList, Map<String, String> refusedMap, OrderRstDTO orderRstDTO) {
        
        if (noStockList == null || noStockList.size() == 0) {
            return true;
        }

        int size = 0;
        for (OrdSrvMmDO srvMmDO : ordSrvMmDOs) {
            for (OrdSrvDO srvDO : ordSrvDOs) {
                if (srvMmDO.getId_orsrv().equals(srvDO.getId_orsrv())) {
                    srvMmDO.setId_srv(srvDO.getId_srv());
                    if (srvDO.getFg_or().booleanValue()) {
                        ++size;                        
                    }
                }
            }
        }
        
        // 部分有库存则只保存有库存的部分
        List<OrdSrvDO> srvs = new ArrayList<>();
        // 提示信息
        StringBuilder noStockTips = new StringBuilder();
        // 是否需要重设主服务
        boolean needResetMain = false;
        // 重新设置医嘱服务
        for (OrdSrvDO srv : ordSrvDOs) {
            boolean leaveIt = true;
            for (OrdSrvMmDO noStockMm : noStockList) {
                if (srv.getId_orsrv().equals(noStockMm.getId_orsrv())) {
                    // 如果移除的是主服务，重设主服务
                    if (aggdo.getParentDO().getId_srv().equals(srv.getId_srv())) {
                        needResetMain = true;
                    }
                    // 组装提示信息
                    String keyId = CiOrdUtils.getKeyId(noStockMm.getId_mm(), srv.getId_dep_wh(), noStockMm.getId_pgku_cur());
                    String tip = refusedMap.get(keyId);
                    if (tip != null && tip.length() > 0) {
                        noStockTips.append(tip);                        
                    } else {
                        noStockTips.append(String.format("【%s】,已停用/停开", srv.getName())).append(System.lineSeparator());   
                    }
                    leaveIt = false;
                }
            }
            if (leaveIt){
                srvs.add(srv);
            }
        }
        
        // 如果全部都没有库存，不保存
        if (size == noStockList.size()) {
            setErrorInfo(orderRstDTO, noStockTips.append(String.format("医嘱【%s】中全部项目均库存不足（停用），无法开立，请切换至医疗单调整或联系相关科室维护处理！", aggdo.getParentDO().getName_or())).toString());
            return false;  
        } else {
            // 重设主服务，选择医嘱服务
            if (needResetMain) {
                for (OrdSrvDO srvDO : srvs) {
                    if (srvDO.getFg_or().booleanValue()) {
                        aggdo.getParentDO().setId_srv(srvs.get(0).getId_srv());
                        break;
                    }
                }
            }
            aggdo.setOrdSrvDO(srvs.toArray(new OrdSrvDO[0]));
            stockCheckWarn.append(noStockTips.append(String.format("其余项目正常开立，请打开医疗单调整或联系相关科室维护处理！\r\n")));            
        }
   
        return true;
    }
    
    /**
     *添加错误提示信息
     */
    protected static void setErrorInfo(OrderRstDTO orderRstDTO, String errorInfo){
        String messageInfo = orderRstDTO.getMessageInfo();
        messageInfo=((StringUtils.isEmpty(messageInfo)||"null".equals(messageInfo)?"":messageInfo)+errorInfo);
        orderRstDTO.setMessageInfo(messageInfo);
        orderRstDTO.setIsSuccess(FBoolean.FALSE);
    }
}