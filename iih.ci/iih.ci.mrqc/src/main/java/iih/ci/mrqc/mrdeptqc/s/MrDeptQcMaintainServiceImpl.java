package iih.ci.mrqc.mrdeptqc.s;

import iih.bd.srv.dto.d.MrDTO;
import iih.ci.mrqc.itmdto.d.ItmDTO;
import iih.ci.mrqc.mrdeptqc.bp.MrDeptQcQryBP;
import iih.ci.mrqc.mrdeptqc.bp.MrDeptQcSaveBP;
import iih.ci.mrqc.mrdeptqc.i.IMrDeptQcMaintainService;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qaflt.i.IQafltCudService;
import iih.ci.mrqc.qaflt.i.IQafltRService;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qarecorddto.d.QaRecordDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = { IMrDeptQcMaintainService.class }, binding = Binding.JSONRPC)
public class MrDeptQcMaintainServiceImpl implements IMrDeptQcMaintainService{
	/**
	 * 获取科室质控项目列表
	 * @param sd_qctype
	 * @return
	 * @throws BizException
	 */
	@Override
	public ItmDTO[] getMrQcDeptItmList(QaPatListDTO qaPatDto) throws BizException {
		// TODO Auto-generated method stub
		MrDeptQcQryBP qryBp=new MrDeptQcQryBP();
		return qryBp.getMrQcDeptItmList(qaPatDto);
	}
    /**
     * 保存科室质控缺陷
     * @return
     * @throws BizException
     */
	@Override
	public boolean saveMrQcDeptItmList(ItmDTO itmDto,QaPatListDTO qaPatListDto, MrDTO mrDto) throws BizException {
		// TODO Auto-generated method stub
		MrDeptQcSaveBP saveBp=new MrDeptQcSaveBP();
		return saveBp.saveMrQcDeptItmList(itmDto, qaPatListDto, mrDto);
	}
    /**
     * 获取患者科室待整改缺陷列表
     * @param id_ent
     * @param cqf_submit_user
     * @return
     * @throws BizException
     */
	@Override
	public QaFltDTO[] getMrDeptQcNeedDefectFltList(String id_ent, String cqf_submit_user) throws BizException {
		MrDeptQcQryBP qryBp=new MrDeptQcQryBP();
		return qryBp.getMrDeptQcNeedDefectFltList(id_ent, cqf_submit_user);
	}
    /**
     * 删除科室质控缺陷
     * @return
     * @throws BizException
     */
	@Override
	public boolean deleteMrQcDeptDefectFlt(String id_qaflt) throws BizException {
		// TODO Auto-generated method stub
		IQafltRService fltQryService=ServiceFinder.find(IQafltRService.class);
		IQafltCudService fltSaveService =ServiceFinder.find(IQafltCudService.class);
		QaFltDO delDo=fltQryService.findById(id_qaflt);
		if (delDo!=null) {
			fltSaveService.delete(new QaFltDO[]{delDo});
			return true;
		} else {
			return false;
		}
		
	}
    /**
     * 保存科室质控缺陷
     * @param qaPatListDto
     * @param qaFltDtos
     * @return
     * @throws BizException
     */
	@Override
	public String saveMrDeptQcNoticeAndFlt(QaPatListDTO qaPatListDto, QaFltDTO[] qaFltDtos,int deadDays,String des) throws BizException {
		// TODO Auto-generated method stub
		MrDeptQcSaveBP saveBp=new MrDeptQcSaveBP();
		return saveBp.saveMrDeptQcNoticeAndFlt(qaPatListDto, qaFltDtos,deadDays,des);
	}
    /**
     * 获取科室质控记录
     * @param qaPatListDto
     * @return
     * @throws BizException
     */
	@Override
	public QaRecordDTO[] getMrDeptQcQryRecordList(QaPatListDTO qaPatListDto) throws BizException {
		MrDeptQcQryBP qryBp=new MrDeptQcQryBP();
		return qryBp.getMrDeptQcQryRecordList(qaPatListDto);
	}
    /**
     * 根据通知id 获取 缺陷
     * @param id_revision
     * @return
     * @throws BizException
     */
	@Override
	public QaFltDTO[] getMrDeptQcDefectFltListByIdRevision(String id_revision) throws BizException {
		// TODO Auto-generated method stub
		MrDeptQcQryBP qryBp=new MrDeptQcQryBP();
		return qryBp.getMrDeptQcDefectFltListByIdRevision(id_revision);
	}



}
