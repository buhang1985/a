package iih.bd.fc.s;

import iih.bd.fc.i.IBdFcMaintainService;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltpconfig.d.OrpltpDTO;
import iih.bd.fc.orpltpconfig.d.OrpltpStaDTO;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import iih.bd.fc.orpltpstamsp.d.OrpltpStaMapDO;
import iih.bd.fc.orpltpstasdto.d.OrpltpStasDTO;
import iih.bd.fc.orwf.d.OrwfAggDO;
import iih.bd.fc.orwf.s.bp.OrWfCfgDeleteBp;
import iih.bd.fc.orwf.s.bp.OrWfCfgSaveBp;
import iih.bd.fc.s.bp.orpltpconfig.OrpltpConfigSaveBp;
import iih.bd.fc.s.bp.orpltpconfig.SaveOrpltpBp;
import iih.bd.fc.s.bp.orpltpconfig.SaveOrpltpConfigBp;
import iih.bd.fc.s.bp.orpltpconfig.SaveOrpltpRecBp;
import iih.bd.fc.s.bp.orpltpmatch.SaveOrpltpMatchBp;
import iih.bd.fc.s.bp.orpltpmatch.UpOrpltpMatchGradeBp;
import iih.bd.fc.s.bp.orwfcfg.upgrade.OrWfUpGradeBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IBdFcMaintainService.class }, binding = Binding.JSONRPC)
public class BdFcMaintainServiceImpl implements IBdFcMaintainService {

    /**
     * 医嘱闭环配置保存
     */
    @Override
    public void orpltpConfigSave(OrpltpDTO orpltpDTO, OrpltpStaDTO[] orpltpStaDTOS, OrpltpStaDO[] staDOs) throws BizException {
	OrpltpConfigSaveBp bp = new OrpltpConfigSaveBp();
	bp.exec(orpltpDTO, orpltpStaDTOS, staDOs);
    }

    /**
     * 医嘱闭环类型配置保存
     */
    @Override
    public void saveOrpltp(OrpltpDO para) throws BizException {
	SaveOrpltpBp bp = new SaveOrpltpBp();
	bp.exec(para);
    }

    /**
     * 医嘱闭环状态信息配置保存
     */
    @Override
    public OrpltpStasDTO saveOrpltpRec(OrpltpStaDO para, OrpltpStaFuncDO[] param, OrpltpStaMapDO[] paramo) throws BizException {
	SaveOrpltpRecBp bp = new SaveOrpltpRecBp();
	return bp.exec(para, param, paramo);
    }

    /**
     * 医嘱闭环流程配置保存
     */
    @Override
    public OrpltpStaDO[] saveOrpltpConfig(String id_orpltp, OrpltpStaDO[] params) throws BizException {
	SaveOrpltpConfigBp bp = new SaveOrpltpConfigBp();
	return bp.exec(id_orpltp, params);
    }

    /**
     * 医嘱闭环匹配保存逻辑
     */
    @Override
    public OrpltpMatchDO[] saveOrpltpMatch(OrpltpMatchDO[] params) throws BizException {
	SaveOrpltpMatchBp orpltpMatchBp = new SaveOrpltpMatchBp();
	return orpltpMatchBp.exec(params);
    }

    /**
     * 流向数据转换
     */
    @Override
    public void orWfUpGrade() throws BizException {
	OrWfUpGradeBp bp = new OrWfUpGradeBp();
	bp.exec();
    }

    /**
     * 医嘱流向配置保存
     */
    @Override
    public OrwfAggDO[] orWfCfgSave(OrwfAggDO[] params) throws BizException {
	OrWfCfgSaveBp bp = new OrWfCfgSaveBp();
	return bp.exec(params);
    }

    /**
     * 医嘱流向配置删除
     */
    @Override
    public void orWfCfgDelete(String[] id_wfs) throws BizException {
	OrWfCfgDeleteBp bp = new OrWfCfgDeleteBp();
	bp.exec(id_wfs);
    }

    /**
     * 闭环匹配升级
     */
    @Override
    public void orpltpMatchGrade() throws BizException {
	UpOrpltpMatchGradeBp bp = new UpOrpltpMatchGradeBp();
	bp.exec();
    }
}
