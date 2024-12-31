package iih.ci.mrqc.mrterminalqc.s;

import iih.bd.srv.dto.d.MrDTO;
import iih.ci.mrqc.itmdto.d.ItmDTO;
import iih.ci.mrqc.mrterminalqc.bp.MrTerminalQcQryBP;
import iih.ci.mrqc.mrterminalqc.bp.MrTerminalQcRecordQryBp;
import iih.ci.mrqc.mrterminalqc.bp.MrTerminalQcSaveBP;
import iih.ci.mrqc.mrterminalqc.i.IMrTerminalQcMaintainService;
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

@Service(serviceInterfaces = { IMrTerminalQcMaintainService.class }, binding = Binding.JSONRPC)
public class MrTerminalQcMaintainServiceImpl implements IMrTerminalQcMaintainService{
	/**
	 * 获取终末评分项目列表
	 * @param sd_qctype
	 * @return
	 * @throws BizException
	 */
	@Override
	public ItmDTO[] getMrQcTerminalScoreItmList(QaPatListDTO qaPatDto) throws BizException {
		// TODO Auto-generated method stub
		MrTerminalQcQryBP qryBp=new MrTerminalQcQryBP();
		return qryBp.getMrQcTerminalScoreItmList(qaPatDto);
	}
    /**
     * 保存终末评分
     * @return
     * @throws BizException
     */
	@Override
	public boolean saveMrQcTerminalScoreItmList(ItmDTO[] itmDtoArr, QaPatListDTO qaPatListDto) throws BizException {
		// TODO Auto-generated method stub
		MrTerminalQcSaveBP saveBp=new MrTerminalQcSaveBP();
		return saveBp.saveMrQcTerminalScoreItmList(itmDtoArr, qaPatListDto);
	}
	/**
	 * 获取终末质控记录
	 */
	@Override
	public QaRecordDTO[] getMrQcTerminalScoreQryRecordList(QaPatListDTO qaPatListDto) throws BizException {
		MrTerminalQcRecordQryBp qry = new MrTerminalQcRecordQryBp();
		return qry.getMrQcTerminalScoreQryRecordList(qaPatListDto);
	}
	/**
	 * 获取终末质控项目列表
	 * @param sd_qctype
	 * @return
	 * @throws BizException
	 */
	@Override
	public ItmDTO[] getMrQcTerminalItmList(QaPatListDTO qaPatDto) throws BizException {
		// TODO Auto-generated method stub
		MrTerminalQcQryBP qryBp=new MrTerminalQcQryBP();
		return qryBp.getMrQcTerminalItmList(qaPatDto);
	}
    /**
     * 保存终末质控缺陷
     * @return
     * @throws BizException
     */
	@Override
	public boolean saveMrQcTerminalItmList(ItmDTO itmDto,QaPatListDTO qaPatListDto, MrDTO mrDto) throws BizException {
		// TODO Auto-generated method stub
		MrTerminalQcSaveBP saveBp=new MrTerminalQcSaveBP();
		return saveBp.saveMrQcTerminalItmList(itmDto, qaPatListDto, mrDto);
	}
    /**
     * 获取患者终末待整改缺陷列表
     * @param id_ent
     * @param cqf_submit_user
     * @return
     * @throws BizException
     */
	@Override
	public QaFltDTO[] getMrTerminalQcNeedDefectFltList(String id_ent, String cqf_submit_user) throws BizException {
		MrTerminalQcQryBP qryBp=new MrTerminalQcQryBP();
		return qryBp.getMrTerminalQcNeedDefectFltList(id_ent, cqf_submit_user);
	}
    /**
     * 删除终末质控缺陷
     * @return
     * @throws BizException
     */
	@Override
	public boolean deleteMrQcTerminalDefectFlt(String id_qaflt) throws BizException {
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
     * 保存终末质控缺陷
     * @param qaPatListDto
     * @param qaFltDtos
     * @return
     * @throws BizException
     */
	@Override
	public String saveMrTerminalQcNoticeAndFlt(QaPatListDTO qaPatListDto, QaFltDTO[] qaFltDtos,int deadDays,String des) throws BizException {
		// TODO Auto-generated method stub
		MrTerminalQcSaveBP saveBp=new MrTerminalQcSaveBP();
		return saveBp.saveMrTerminalQcNoticeAndFlt(qaPatListDto, qaFltDtos,deadDays,des);
	}
    /**
     * 获取终末质控记录
     * @param qaPatListDto
     * @return
     * @throws BizException
     */
	@Override
	public QaRecordDTO[] getMrTerminalQcQryRecordList(QaPatListDTO qaPatListDto) throws BizException {
		MrTerminalQcQryBP qryBp=new MrTerminalQcQryBP();
		return qryBp.getMrTerminalQcQryRecordList(qaPatListDto);
	}
    /**
     * 根据通知id 获取 缺陷
     * @param id_revision
     * @return
     * @throws BizException
     */
	@Override
	public QaFltDTO[] getMrTerminalQcDefectFltListByIdRevision(String id_revision) throws BizException {
		// TODO Auto-generated method stub
		MrTerminalQcQryBP qryBp=new MrTerminalQcQryBP();
		return qryBp.getMrTerminalQcDefectFltListByIdRevision(id_revision);
	}
}
