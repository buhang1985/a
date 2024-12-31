package iih.bd.pp.baseprisrv.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.DoUtils;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.i.IInccaitmrelCudService;
import iih.bd.pp.incca.i.IInccaitmrelRService;
import iih.bd.pp.listener.d.MedSrvEventDTO;
import iih.bd.pp.listener.event.BdPpEvent;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvCudService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 删除价表服务
 * 
 * @author hao_wu 2019-8-20
 *
 */
public class DeletePriSrvBp {

	public void exec(PriSrvDO[] dos) throws BizException {
		if (ArrayUtils.isEmpty(dos)) {
			return;
		}
		String[] srvIds = DoUtils.getAttrValArr(dos, PriSrvDO.ID_SRV, String.class);
		IMedsrvRService medsrvRService = ServiceFinder.find(IMedsrvRService.class);
		MedsrvAggDO[] medSrvAggDos = medsrvRService.findByIds(srvIds, FBoolean.FALSE);

		if (ArrayUtils.isEmpty(medSrvAggDos) || medSrvAggDos.length != dos.length) {
			throw new BizException("数据已被他人修改，请刷新重试。");
		}

		// 同时删除该服务的票据分类项目对照关系
		IInccaitmrelCudService relCudSer = ServiceFinder.find(IInccaitmrelCudService.class);
		IInccaitmrelRService relRSer = ServiceFinder.find(IInccaitmrelRService.class);
		IncCaItmRelDO[] inccaItmRelDOs = relRSer.findByAttrValStrings(IncCaItmRelDO.ID_SRV, srvIds);
		if (ArrayUtils.isNotEmpty(inccaItmRelDOs)) {
			relCudSer.logicDelete(inccaItmRelDOs);
		}

		IMedsrvCudService medsrvCudService = ServiceFinder.find(IMedsrvCudService.class);
		medsrvCudService.logicDelete(medSrvAggDos);

		for (MedsrvAggDO medsrvAggDO : medSrvAggDos) {
			MedSrvDO medSrvDO = medsrvAggDO.getParentDO();
			// 发送事件
			MedSrvEventDTO medSrvEventDTO = this.getMedSrvDTO(medSrvDO);
			BdPpEvent bdPpEvent = new BdPpEvent();
			bdPpEvent.invokePriSrv(medSrvEventDTO, IEventType.TYPE_DELETE_AFTER);
		}
	}

	/**
	 * 将医疗服务DO转换为DTO
	 */
	public MedSrvEventDTO getMedSrvDTO(MedSrvDO medSrvDO) {
		MedSrvEventDTO medSrvEventDTO = new MedSrvEventDTO();
		medSrvEventDTO.setId_srv(medSrvDO.getId_srv());
		medSrvEventDTO.setId_grp(medSrvDO.getId_grp());
		medSrvEventDTO.setId_org(medSrvDO.getId_org());
		medSrvEventDTO.setName(medSrvDO.getName());
		medSrvEventDTO.setCode(medSrvDO.getCode());
		medSrvEventDTO.setId_srvtp(medSrvDO.getId_srvtp());
		medSrvEventDTO.setSd_srvtp(medSrvDO.getSd_srvtp());
		medSrvEventDTO.setId_srvca(medSrvDO.getId_srvca());
		medSrvEventDTO.setPycode(medSrvDO.getPycode());
		medSrvEventDTO.setId_unit_med(medSrvDO.getId_unit_med());
		medSrvEventDTO.setQuan_med(medSrvDO.getQuan_med());
		medSrvEventDTO.setId_primd(medSrvDO.getId_primd());
		medSrvEventDTO.setSd_primd(medSrvDO.getSd_primd());
		medSrvEventDTO.setIncca_ip(medSrvDO.getIncca_ip());
		medSrvEventDTO.setIncca_op(medSrvDO.getIncca_op());
		medSrvEventDTO.setPri(null == medSrvDO.getPri() ? FDouble.ZERO_DBL : medSrvDO.getPri());
		medSrvEventDTO.setFg_active(medSrvDO.getFg_active());
		medSrvEventDTO.setFg_or(medSrvDO.getFg_or());
		medSrvEventDTO.setFg_mm(medSrvDO.getFg_mm());
		medSrvEventDTO.setFg_bl(medSrvDO.getFg_bl());

		return medSrvEventDTO;
	}

}
