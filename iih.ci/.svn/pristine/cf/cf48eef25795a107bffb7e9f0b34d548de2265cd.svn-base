package iih.ci.mrqc.mrprocessqc.s;

import iih.bd.srv.dto.d.MrDTO;
import iih.ci.mrqc.itmdto.d.ItmDTO;
import iih.ci.mrqc.mrprocessqc.bp.MrProcessQcQryBP;
import iih.ci.mrqc.mrprocessqc.bp.MrProcessQcSaveBP;
import iih.ci.mrqc.mrprocessqc.i.IMrProcessQcMaintainService;
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

@Service(serviceInterfaces = { IMrProcessQcMaintainService.class }, binding = Binding.JSONRPC)
public class MrProcessQcMaintainServiceImpl implements IMrProcessQcMaintainService{
	/**
	 * 获取环节质控项目列表
	 * @param sd_qctype
	 * @return
	 * @throws BizException
	 */
	@Override
	public ItmDTO[] getMrQcProcessItmList(QaPatListDTO qaPatDto) throws BizException {
		// TODO Auto-generated method stub
		MrProcessQcQryBP qryBp=new MrProcessQcQryBP();
		return qryBp.getMrQcProcessItmList(qaPatDto);
	}
    /**
     * 保存环节质控缺陷
     * @return
     * @throws BizException
     */
	@Override
	public boolean saveMrQcProcessItmList(ItmDTO itmDto,QaPatListDTO qaPatListDto, MrDTO mrDto) throws BizException {
		// TODO Auto-generated method stub
		MrProcessQcSaveBP saveBp=new MrProcessQcSaveBP();
		return saveBp.saveMrQcProcessItmList(itmDto, qaPatListDto, mrDto);
	}
    /**
     * 获取患者环节待整改缺陷列表
     * @param id_ent
     * @param cqf_submit_user
     * @return
     * @throws BizException
     */
	@Override
	public QaFltDTO[] getMrProcessQcNeedDefectFltList(String id_ent, String cqf_submit_user) throws BizException {
		MrProcessQcQryBP qryBp=new MrProcessQcQryBP();
		return qryBp.getMrProcessQcNeedDefectFltList(id_ent, cqf_submit_user);
	}
    /**
     * 删除环节质控缺陷
     * @return
     * @throws BizException
     */
	@Override
	public boolean deleteMrQcProcessDefectFlt(String id_qaflt) throws BizException {
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
     * 保存环节质控缺陷
     * @param qaPatListDto
     * @param qaFltDtos
     * @return
     * @throws BizException
     */
	@Override
	public String saveMrProcessQcNoticeAndFlt(QaPatListDTO qaPatListDto, QaFltDTO[] qaFltDtos,int deadDays,String des) throws BizException {
		// TODO Auto-generated method stub
		MrProcessQcSaveBP saveBp=new MrProcessQcSaveBP();
		return saveBp.saveMrProcessQcNoticeAndFlt(qaPatListDto, qaFltDtos,deadDays,des);
	}
    /**
     * 获取环节质控记录
     * @param qaPatListDto
     * @return
     * @throws BizException
     */
	@Override
	public QaRecordDTO[] getMrProcessQcQryRecordList(QaPatListDTO qaPatListDto) throws BizException {
		MrProcessQcQryBP qryBp=new MrProcessQcQryBP();
		return qryBp.getMrProcessQcQryRecordList(qaPatListDto);
	}
    /**
     * 根据通知id 获取 缺陷
     * @param id_revision
     * @return
     * @throws BizException
     */
	@Override
	public QaFltDTO[] getMrProcessQcDefectFltListByIdRevision(String id_revision) throws BizException {
		// TODO Auto-generated method stub
		MrProcessQcQryBP qryBp=new MrProcessQcQryBP();
		return qryBp.getMrProcessQcDefectFltListByIdRevision(id_revision);
	}



}
