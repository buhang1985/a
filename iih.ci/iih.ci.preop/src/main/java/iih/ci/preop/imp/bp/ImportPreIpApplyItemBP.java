package iih.ci.preop.imp.bp;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.springframework.transaction.TransactionStatus;

import iih.bd.srv.ems.d.EmsAppModeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.preop.imp.CiPreOPImpRst;
import iih.ci.preop.imp.bp.convert.PreIpApplyOrderAppInfoConvertor;
import iih.ci.preop.imp.bp.convert.PreIpApplyOrderInfoConvertor;
import iih.ci.preop.imp.bp.convert.PreIpApplyOrderPriceInfoConvertor;
import iih.ci.preop.imp.bp.convert.PreIpApplyOrderSrvInfoConvertor;
import iih.ci.preop.imp.bp.record.ImportRecordBP;
import iih.ci.preop.imp.bp.sign.PreIpAfterImportSignBP;
import iih.ci.preop.imp.bp.sign.SignResult;
import iih.ci.preop.imp.dto.TsOrIpOrAggDTO;
import iih.ci.sdk.cache.BDDeptInfoCache;
import iih.ci.sdk.log.OrdBizLogger;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.d.EuMpMdEnum;
import iih.ci.tsip.i.ICitsorderMDOCudService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 导入预住院申请为预住院医嘱业务逻辑实现实体
 * 
 * 
 * @author mkp
 * @version 1.0
 * @date 2020/03/06
 */
public class ImportPreIpApplyItemBP {

    /**
     * 根据患者就诊id导入,就诊域调用
     * 
     * @param id_en_op
     * @param id_en_pre
     * @param id_dep_oper
     * @param id_emp_oper
     * @param dt_oper
     * @return
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
    public CiPreOPImpRst importByEnt(String id_en_op, String id_en_pre, String id_dep_oper, String id_emp_oper,
            FDateTime dt_oper) throws BizException {
        boolean success = false;
        String resultMsg = "";

        // 初始化上下文，用预住院就诊信息构建
        CiEnContextDTO ctx = createCiEnContext(id_en_pre);

        // 查询患者名下所有预住院申请
        StringBuilder sql = new StringBuilder();
        sql.append("select * from ci_ts_or where id_en = ? and fg_canc = 'N' and sd_su_ts_mp = '0' and sd_tstp = '0'");
        SqlParam param = new SqlParam();
        param.addParam(id_en_op);
        List<CiTsOrDO> tsOrDOList = (List<CiTsOrDO>) new DAFacade().execQuery(sql.toString(), param,
                new BeanListHandler(CiTsOrDO.class));

        if (tsOrDOList == null || tsOrDOList.size() < 1) {
            resultMsg = String.format("患者【%s】没有要导入的预住院申请", ctx.getName_pat());
            success = false;
            OrdBizLogger.info(ctx, resultMsg);
            return new CiPreOPImpRst(resultMsg, FBoolean.FALSE);
        }
        CiTsOrDO[] tsOrDOs = tsOrDOList.toArray(new CiTsOrDO[0]);

        try {
            // 执行导入
            ImportResult result = executeImport(ctx, tsOrDOs, id_dep_oper, id_emp_oper, dt_oper, EuMpMdEnum.EN_IMPORT);
            success = true;
            resultMsg = result.getMessage();
        } catch (Exception e) {
            success = false;
            resultMsg = String.format("患者【%s】预住院申请导入异常： %s ", ctx.getName_pat(), e.getMessage());
        }

        OrdBizLogger.info(ctx, resultMsg);

        return new CiPreOPImpRst(resultMsg, new FBoolean(success));
    }

    /**
     * 根据指定的治疗方案ID导入
     * 
     * @param id_en_pre
     * @param tsOrIds
     * @return
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
    public CiPreOPImpRst importByTsIds(String id_en_pre, String[] tsOrIds) throws BizException {
        boolean success = false;
        String resultMsg = "";

        if (tsOrIds == null || tsOrIds.length == 0) {
            return new CiPreOPImpRst("参数为空", FBoolean.FALSE);
        }

        // 初始化上下文，用预住院就诊信息构建
        CiEnContextDTO ctx = createCiEnContext(id_en_pre);

        /*
         * 组装查询语句 查询患者名下的预住院申请
         */
        StringBuilder whereIn = new StringBuilder();
        for (String id_tsor : tsOrIds) {
            String item = "'" + id_tsor + "',";
            whereIn.append(item);
        }

        StringBuilder sql = new StringBuilder();
        sql.append("select * from ci_ts_or where id_tsor in (" + whereIn.substring(0, whereIn.length() - 1)
                + ")  and fg_canc = 'N' and sd_su_ts_mp = '0' and sd_tstp = '0'");

        List<CiTsOrDO> tsOrDOList = (List<CiTsOrDO>) new DAFacade().execQuery(sql.toString(), null,
                new BeanListHandler(CiTsOrDO.class));

        if (tsOrDOList == null || tsOrDOList.size() < 1) {
            success = false;
            resultMsg = String.format("患者【%s】没有要导入的预住院申请", ctx.getName_pat());
            OrdBizLogger.info(ctx, resultMsg);
            return new CiPreOPImpRst(resultMsg, FBoolean.FALSE);
        }

        CiTsOrDO[] tsOrDOs = tsOrDOList.toArray(new CiTsOrDO[0]);

        // 执行导入
        try {
            ImportResult result = executeImport(ctx, tsOrDOs, ctx.getId_psndoc(), Context.get().getDeptId(),
                    ServiceFinder.find(TimeService.class).getUFDateTime(), EuMpMdEnum.APP_IMPORT);
            success = true;
            resultMsg = result.getMessage();
        } catch (Exception e) {
            success = false;
            resultMsg = String.format("患者【%s】预住院申请导入异常： %s ", ctx.getName_pat(), e.getMessage());
        }

        return new CiPreOPImpRst(resultMsg, new FBoolean(success));
    }

    /**
     * 执行导入过程
     * 
     * @param ctx
     * @param tsOrDOs
     * @throws BizException
     */
    private ImportResult executeImport(CiEnContextDTO ctx, CiTsOrDO[] tsOrDOs, String id_dep_oper, String id_emp_oper,
            FDateTime dt_oper, String eu_mpmd) throws BizException {
        boolean signSuccess = true;

        for (CiTsOrDO tsOrder : tsOrDOs) {
            // 导入逻辑主体
            try {
                final CiEnContextDTO _ctx = ctx;
                final CiTsOrDO _tsOrder = tsOrder;
                final String _id_dep_oper = id_dep_oper;
                final String _id_emp_oper = id_emp_oper;
                final FDateTime _dt_oper = dt_oper;
                final String _eu_mpmd = eu_mpmd;
                final ImportRecordBP _recordBP = new ImportRecordBP(_ctx);
                final PreIpAfterImportSignBP _signBp = new PreIpAfterImportSignBP();
                
                // 为保持状态一致，导入、更新、签署，同一事务内执行
                ImportResult singleRst = TransactionExecutor.executeNewTransaction(new TransactionalOperation<ImportResult>() {

                    @Override
                    public ImportResult doInTransaction(TransactionStatus var1) throws InvocationTargetException {
                        try {
                            // 创建医疗单DTO
                            CiEmsDTO emsDTO = createCiEmsDTO(_ctx, _tsOrder);
                            TsOrIpOrAggDTO dto = new TsOrIpOrAggDTO();
                            // 保存
                            CiOrderDO[] savedOrderDO = ServiceFinder.find(ICiOrdMaintainService.class).SaveCiEmsDTO_TL(emsDTO, _ctx);

                            if (savedOrderDO != null) {
                                dto.setId_or(savedOrderDO[0].getId_or());
                                dto.setId_tsor(_tsOrder.getId_tsor());
                                dto.setTsOrDO(_tsOrder);
                                dto.setCiOrderDO(savedOrderDO[0]);
                            }
                            
                            // 更新预住院治疗方案医嘱生成状态
                            updateTsOrdersState(dto);
                            
                            // 形成治疗方案_医嘱生成记录
                            _recordBP.saveImportRecord(dto, _id_dep_oper, _id_emp_oper, _dt_oper, _eu_mpmd);
                            
                            // 自动签署，每次签署一条，不再批量
                            List<TsOrIpOrAggDTO> tsIpAggDTOs = new ArrayList<>();
                            tsIpAggDTOs.add(dto);
                            SignResult singResult = _signBp.exec(_ctx, tsIpAggDTOs);
                            if (singResult != null && !singResult.isSuccess()) {
                                return ImportResult.SIGN_ERROR;
                            }
                            return ImportResult.SUCCESS;
                        } catch (Exception e) {
                        	e.printStackTrace();
                            throw new InvocationTargetException(e);
                        }
                    }
                });
                
                if (ImportResult.SIGN_ERROR.equals(singleRst)) {
                    signSuccess = false;
                }
            } catch (Exception e) {
                String errorInfo = String.format("患者【%s】治疗方案医嘱【%s】 【%s】 导入异常： %s ", ctx.getName_pat(),
                        tsOrder.getCode_or(), tsOrder.getName_or(), e.toString());
                OrdBizLogger.info(ctx, errorInfo);
                throw new BizException(errorInfo, e);
            }
        }
        
        // 如果签署校验未通过，返回提示
        if (!signSuccess) {
            return ImportResult.SIGN_ERROR;
        }
        return ImportResult.SUCCESS;
    }

    /**
     * 更新预住院治疗方案医嘱生成状态 治疗方案导入成功后，Sd_su_ts_mp设为20
     * 
     * @param tsIpDTOs
     * @throws BizException
     */
    private void updateTsOrdersState(List<TsOrIpOrAggDTO> tsIpDTOs) throws BizException {

        List<CiTsOrDO> tsOrders = new ArrayList<>();
        for (TsOrIpOrAggDTO item : tsIpDTOs) {
            CiTsOrDO tsOrDO = item.getTsOrDO();
            tsOrDO.setSd_su_ts_mp("20");
            tsOrDO.setStatus(DOStatus.UPDATED);
            tsOrders.add(tsOrDO);
        }
        ServiceFinder.find(ICitsorderMDOCudService.class).update(tsOrders.toArray(new CiTsOrDO[0]));
    }
    
    /**
     * 更新预住院治疗方案医嘱生成状态
     * @param tsIpDTO
     * @throws BizException
     */
    private void updateTsOrdersState(TsOrIpOrAggDTO tsIpDTO) throws BizException {

        List<CiTsOrDO> tsOrders = new ArrayList<>();

        CiTsOrDO tsOrDO = tsIpDTO.getTsOrDO();
        tsOrDO.setSd_su_ts_mp("20");
        tsOrDO.setStatus(DOStatus.UPDATED);
        tsOrders.add(tsOrDO);

        ServiceFinder.find(ICitsorderMDOCudService.class).update(tsOrders.toArray(new CiTsOrDO[0]));
    }

    /**
     * 初始化上下文
     * 
     * @param id_en_pre
     * @return
     * @throws BizException
     * @throws DAException
     */
    @SuppressWarnings({ "unchecked" })
    private CiEnContextDTO createCiEnContext(String id_en_pre) throws BizException, DAException {
        // 设置预住院上下文信息
        CiEnContextDTO ctx = new CiEnContextDTO();
        // 获取患者当前就诊信息，根据预住院的id_en查询
        PatiVisitDO patiVisitDO = ServiceFinder.find(IPativisitRService.class).findById(id_en_pre);
        InpatientDO[] inpatientDOs = ServiceFinder.find(IInpatientRService.class).findByAttrValString(InpatientDO.ID_ENT, id_en_pre);
        ctx.setId_en(id_en_pre);
        ctx.setId_pat(patiVisitDO.getId_pat());
        ctx.setName_pat(patiVisitDO.getName_pat());
        ctx.setCode_entp(patiVisitDO.getCode_entp());
        ctx.setId_entp(patiVisitDO.getId_entp());
        ctx.setId_dep_en(patiVisitDO.getId_dep_phy());
        ctx.setId_dep_ns(patiVisitDO.getId_dep_nur());
        ctx.setId_dep_or(patiVisitDO.getId_dep_phy());
        ctx.setName_bed(inpatientDOs[0].getName_bed());
        ctx.setName_dep_or(BDDeptInfoCache.GetNameOfBDeptInfo(patiVisitDO.getId_dep_phy()));
        // 根据用户id查询psndoc
        StringBuilder sql = new StringBuilder();
        sql.append(
                "select psn.* from bd_psndoc psn inner join sys_user sysuser on psn.id_psndoc = sysuser.id_psn where sysuser.id_user = '"
                        + Context.get().getUserId() + "'");
        SqlParam param = new SqlParam();
        List<PsnDocDO> psndoc = (List<PsnDocDO>) new DAFacade().execQuery(sql.toString(), param,
                new BeanListHandler(PsnDocDO.class));
        if (psndoc != null && psndoc.size() > 0) {
            ctx.setId_psndoc(psndoc.get(0).getId_psndoc());
            ctx.setName_psndoc(psndoc.get(0).getName());
        }
        ctx.setId_wg_or(patiVisitDO.getId_wg_phy());
        ctx.setId_pripat(patiVisitDO.getId_pripat());
        ctx.setId_emp_or(psndoc.get(0).getId_psndoc());
        // 集团信息
        ctx.setId_grp(Context.get().getGroupId());
        SqlParam grpParam = new SqlParam();
        grpParam.addParam(Context.get().getGroupId());
        StringBuilder grpSql = new StringBuilder("select grp.name name from bd_grp grp where grp.id_grp = ?");
        List<String> name_grp = (List<String>) new DAFacade().execQuery(grpSql.toString(), grpParam,
                new ColumnListHandler<String>("name"));
        if (name_grp != null && name_grp.size() > 0) {
            ctx.setName_grp(name_grp.get(0));
        }
        // 组织信息
        ctx.setId_org(Context.get().getOrgId());
        SqlParam orgParam = new SqlParam();
        orgParam.addParam(Context.get().getGroupId());
        StringBuilder orgSql = new StringBuilder("select org.name name from bd_org org where org.id_org = ?");
        List<String> name_org = (List<String>) new DAFacade().execQuery(orgSql.toString(), orgParam,
                new ColumnListHandler<String>("name"));
        if (name_org != null && name_org.size() > 0) {
            ctx.setName_org(name_org.get(0));
        }
        ctx.setId_hp(patiVisitDO.getId_hp());
        // 医疗单应用模式
        ctx.setEmsappmode(EmsAppModeEnum.IVEMSAPPMODE);
        return ctx;
    }

    /**
     * 创建医疗单DTO
     * 
     * @param ctx
     * 
     * @param tsOrder
     * @return
     * @throws BizException
     */
    private CiEmsDTO createCiEmsDTO(CiEnContextDTO ctx, CiTsOrDO tsOrder) throws BizException {
        // 医疗单主数据创建
        CiEmsDTO ciEmsDTO = new CiEmsDTO();

        ciEmsDTO.setStatus(DOStatus.NEW);

        // 转换医嘱信息
        new PreIpApplyOrderInfoConvertor(ctx).transfer(tsOrder, ciEmsDTO);

        // 转换医嘱服务、物品信息
        new PreIpApplyOrderSrvInfoConvertor(ctx).transfer(tsOrder, ciEmsDTO);

        // 转换申请单信息
        new PreIpApplyOrderAppInfoConvertor(ctx).transfer(tsOrder, ciEmsDTO);

        // 计算价格信息
//        new PreIpApplyOrderPriceInfoConvertor(ctx).transfer(tsOrder, ciEmsDTO);

        return ciEmsDTO;
    }

}
