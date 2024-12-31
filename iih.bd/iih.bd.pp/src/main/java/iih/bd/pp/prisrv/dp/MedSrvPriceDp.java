package iih.bd.pp.prisrv.dp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.accountsrv.i.IAccountsrvExtCudService;
import iih.bd.pp.accountsrvrel.d.MedsrvAccountRelDTO;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.incca.i.IInccaitmrelCudService;
import iih.bd.pp.incca.i.IInccaitmrelRService;
import iih.bd.pp.listener.d.MedSrvEventDTO;
import iih.bd.pp.listener.event.BdPpEvent;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.prisrv.d.PriSrvDO;
import iih.bd.pp.prisrv.i.IPrisrvCudService;
import iih.bd.pp.prisrv.i.IPrisrvRService;
import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompCudService;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompRService;
import iih.bd.pp.prisrvsetfix.d.PriSrvSetFixDO;
import iih.bd.pp.prisrvsetfix.i.IPrisrvsetfixCudService;
import iih.bd.pp.prisrvsetfix.i.IPrisrvsetfixRService;
import iih.bd.pp.prisrvsetmu.d.PriSrvSetMuDO;
import iih.bd.pp.prisrvsetmu.i.IPrisrvsetmuCudService;
import iih.bd.pp.prisrvsetmu.i.IPrisrvsetmuRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvOpDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDOCudService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/* *
 * 服务价格维护
 * @author weijia
 * */
public class MedSrvPriceDp {

	/**
	 * 添加医疗服务和服务定价
	 */
	public MedSrvDO saveMedSrvPrice(MedSrvDO medSrvDO, PriSrvDO[] priSrvDOArr) throws BizException {

		// int status = medSrvDO.getStatus();
		// if (DOStatus.NEW == status) {
		// 移至前台初始化，后台不该介入数据初始化
		// medSrvDO.setId_grp(Context.get().getGroupId());
		// medSrvDO.setId_org(Context.get().getOrgId());
		// if (medSrvDO.getSrvtp_code() != null) {
		// medSrvDO.setSd_srvtp(medSrvDO.getSrvtp_code());
		// }
		// medSrvDO.setQuan_med(new FDouble(1));
		// medSrvDO.setFg_or(FBoolean.FALSE);
		// medSrvDO.setFg_mm(FBoolean.FALSE);
		// medSrvDO.setFg_bl(FBoolean.TRUE);
		// medSrvDO.setFg_set(FBoolean.FALSE);
		// medSrvDO.setFg_active(FBoolean.TRUE);
		// }

		IMedsrvMDOCudService srvService = ServiceFinder.find(IMedsrvMDOCudService.class);

		FDouble price = this.getSrvPrice(priSrvDOArr);
		medSrvDO.setPri(price);
		MedSrvDO[] medSrvDOArr = srvService.save(new MedSrvDO[] { medSrvDO });

		if (medSrvDOArr == null || medSrvDOArr.length == 0) {
			throw new BizException("医疗服务保存失败！");
		}

		saveSrvSug(medSrvDOArr);

		GenerateIncCaItmRel(medSrvDO);

		updateSrvAccRel(medSrvDO);

		if (priSrvDOArr != null && priSrvDOArr.length > 0) {
			IPrisrvCudService priService = ServiceFinder.find(IPrisrvCudService.class);
			Integer count = 0;
			for (PriSrvDO priSrvDO : priSrvDOArr) {
				priSrvDO.setId_srv(medSrvDOArr[0].getId_srv());
				if (priSrvDO.getDt_e() == null || priSrvDO.getDt_e().equals(new FDateTime("2099-12-31 23:59:59"))) {
					count++;
				}
				if (priSrvDO.getDt_e() == null) {
					priSrvDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
				}
			}
			if (count >= 2) {
				throw new BizException("服务" + medSrvDO.getName() + "有且只能有一条本服务定价数据的结束时间为空或2099-12-31 23:59:59");
			}
			priService.save(priSrvDOArr);
		}

		FireIEMessage(medSrvDO);

		return medSrvDOArr[0];
	}

	/**
	 * 如果保存的医疗服务是手术类型，则生成子表数据
	 * 
	 * @param medSrvDOArr
	 * @throws BizException
	 */
	private void saveSrvSug(MedSrvDO[] medSrvDOArr) throws BizException {
		if (ArrayUtils.isEmpty(medSrvDOArr)) {
			return;
		}

		String[] medSrvIds = getMedSrvIds(medSrvDOArr);
		if (ArrayUtils.isEmpty(medSrvIds)) {
			return;
		}
		IMedsrvRService medsrvRService = ServiceFinder.find(IMedsrvRService.class);
		MedsrvAggDO[] medSrvAggs = medsrvRService.findByIds(medSrvIds, FBoolean.FALSE);

		ArrayList<MedSrvOpDO> medSrvOpList = new ArrayList<MedSrvOpDO>();
		for (MedsrvAggDO medSrvAggDO : medSrvAggs) {
			MedSrvDO medSrvDo = medSrvAggDO.getParentDO();
			MedSrvOpDO[] medSrvOps = medSrvAggDO.getMedSrvOpDO();
			if (medSrvDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)
					&& (medSrvOps == null || medSrvOps.length <= 0)) {
				MedSrvOpDO medSrvOp = new MedSrvOpDO();
				medSrvOp.setId_grp(Context.get().getGroupId());
				medSrvOp.setId_org(Context.get().getOrgId());
				medSrvOp.setId_srv(medSrvDo.getId_srv());
				medSrvOpList.add(medSrvOp);
			}
		}

		if (medSrvOpList.size() > 0) {
			IMedSrvOpDOCudService medSrvOpDOCudService = ServiceFinder.find(IMedSrvOpDOCudService.class);
			medSrvOpDOCudService.insert(medSrvOpList.toArray(new MedSrvOpDO[0]));
		}
	}

	/**
	 * 获取医疗服务主键集合
	 * 
	 * @param medSrvDOArr
	 * @return
	 */
	private String[] getMedSrvIds(MedSrvDO[] medSrvDOArr) {
		ArrayList<String> medSrvIdList = new ArrayList<String>();
		for (MedSrvDO medSrvDO : medSrvDOArr) {
			if (StringUtils.isNotEmpty(medSrvDO.getId_srv()) && !medSrvIdList.contains(medSrvDO.getId_srv())) {
				medSrvIdList.add(medSrvDO.getId_srv());
			}
		}
		return medSrvIdList.toArray(new String[0]);
	}

	/**
	 * 更新服务与核算项目关系
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void updateSrvAccRel(MedSrvDO medSrvDO) throws BizException {
		MedsrvAccountRelDTO srvAccRelDto = new MedsrvAccountRelDTO();
		srvAccRelDto.setId_srv(medSrvDO.getId_srv());
		srvAccRelDto.setId_account(medSrvDO.getId_account_gy());
		srvAccRelDto.setId_account_op(medSrvDO.getId_account_mz());
		srvAccRelDto.setId_account_ip(medSrvDO.getId_account_zy());

		IAccountsrvExtCudService accountsrvExtCudService = ServiceFinder.find(IAccountsrvExtCudService.class);
		accountsrvExtCudService.updateMedsrvAccountRel(new MedsrvAccountRelDTO[] { srvAccRelDto });
	}

	/**
	 * 生成票据分类项目对照
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void GenerateIncCaItmRel(MedSrvDO medSrvDO) throws BizException {
		IInccaitmrelCudService relCudSer = ServiceFinder.find(IInccaitmrelCudService.class);
		IInccaitmrelRService relRSer = ServiceFinder.find(IInccaitmrelRService.class);
		String ipinccaitm = medSrvDO.getIncca_ip();
		String opinccaitm = medSrvDO.getIncca_op();

		if (DOStatus.NEW == medSrvDO.getStatus()) { // 新增服务
			// *****************************************************
			// 将新增服务保存后生成的主键id_srv回写到票据分类项目对照表中
			IncCaItmRelDO[] incCaItmRelDOs = new IncCaItmRelDO[2];
			incCaItmRelDOs[0] = new IncCaItmRelDO();
			incCaItmRelDOs[0].setId_grp(Context.get().getGroupId());
			incCaItmRelDOs[0].setId_org(Context.get().getOrgId());
			incCaItmRelDOs[0].setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
			incCaItmRelDOs[0].setSd_incca(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);
			incCaItmRelDOs[0].setId_inccaitm(medSrvDO.getIncca_op());
			incCaItmRelDOs[0].setId_srv(medSrvDO.getId_srv());
			incCaItmRelDOs[0].setStatus(DOStatus.NEW);

			incCaItmRelDOs[1] = new IncCaItmRelDO();
			incCaItmRelDOs[1].setId_grp(Context.get().getGroupId());
			incCaItmRelDOs[1].setId_org(Context.get().getOrgId());
			incCaItmRelDOs[1].setId_incca(IBdInccaCodeConst.ID_INHOS_INVOICE);
			incCaItmRelDOs[1].setSd_incca(IBdInccaCodeConst.CODE_INHOS_INVOICE);
			incCaItmRelDOs[1].setId_inccaitm(medSrvDO.getIncca_ip());
			incCaItmRelDOs[1].setId_srv(medSrvDO.getId_srv());
			incCaItmRelDOs[1].setStatus(DOStatus.NEW);
			relCudSer.save(incCaItmRelDOs);
			// *****************************************************
		} else { // 编辑服务时
			// *******************************************************************************
			// 编辑服务时，在保存服务之前，比较服务从前台界面上带过来的票据对照关系与数据库中存储的服务的对照关系相同不相同，若不同，则删除原来维护的对照关系，将修改后的再插入到对照表中。
			// 查询：调用轻量级的服务,查询服务原来维护的票据分类项目
			IncCaItmRelDO[] opQryList = relRSer.find(" id_srv='" + medSrvDO.getId_srv() + "' and id_incca='"
					+ IBdInccaCodeConst.ID_OUTPATIENT_INVOICE + "'", " sv desc ", FBoolean.FALSE);
			IncCaItmRelDO[] ipQryList = relRSer.find(
					" id_srv='" + medSrvDO.getId_srv() + "' and id_incca='" + IBdInccaCodeConst.ID_INHOS_INVOICE + "'",
					" sv desc ", FBoolean.FALSE);
			ArrayList<IncCaItmRelDO> delList_ip = new ArrayList<>();
			// 待删除的门诊对照关系数据集合
			ArrayList<IncCaItmRelDO> delList_op = new ArrayList<>();
			// 待删除的住院对照关系数据集合
			ArrayList<IncCaItmRelDO> newList = new ArrayList<>(); // 将要新插入的对照关系数据集
			// 1、先判断门诊票据项目的有没有维护数据, 表示服务还未维护票据分类项目，则新增2条票据分类项目对照关系数据插入到数据库中
			if (opQryList == null || opQryList.length == 0) {
				IncCaItmRelDO op_newrelDO = new IncCaItmRelDO();
				op_newrelDO.setId_grp(Context.get().getGroupId());
				op_newrelDO.setId_org(Context.get().getOrgId());
				op_newrelDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);// 门诊
				op_newrelDO.setSd_incca(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);// 门诊
				op_newrelDO.setId_inccaitm(opinccaitm);
				op_newrelDO.setId_srv(medSrvDO.getId_srv());
				op_newrelDO.setStatus(DOStatus.NEW);
				relCudSer.save(new IncCaItmRelDO[] { op_newrelDO });
			} else { // 原来服务维护的有门诊票据分类项目，则和前台传过来的数据做比较；如果修改了则删除旧数据，并插入新数据
				for (IncCaItmRelDO qryDO : opQryList) {
					if (qryDO.getId_incca().equals(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE)) {
						// 门诊发票类型
						if (!opinccaitm.equals(qryDO.getId_inccaitm())) {
							qryDO.setStatus(DOStatus.DELETED);
							delList_op.add(qryDO);
						}
					}
				}
				if (delList_op != null && delList_op.size() > 0) {
					// 只有需要删除的，才说明有修改的部分，则需要将原来的删掉并插入新的
					IncCaItmRelDO opRelDO = new IncCaItmRelDO(); // 插入新数据
					opRelDO.setId_grp(Context.get().getGroupId());
					opRelDO.setId_org(Context.get().getOrgId());
					opRelDO.setId_srv(medSrvDO.getId_srv());
					opRelDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);// 门诊
					opRelDO.setSd_incca(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);// 门诊
					opRelDO.setId_inccaitm(opinccaitm);
					opRelDO.setStatus(DOStatus.NEW);
					newList.add(opRelDO);
				}
			}
			// 2、再判断住院票据项目的有没有维护数据
			if (ipQryList == null || ipQryList.length == 0) {
				IncCaItmRelDO ip_newRelDO = new IncCaItmRelDO();
				ip_newRelDO.setId_grp(Context.get().getGroupId());
				ip_newRelDO.setId_org(Context.get().getOrgId());
				ip_newRelDO.setId_incca(IBdInccaCodeConst.ID_INHOS_INVOICE); // 住院
				ip_newRelDO.setSd_incca(IBdInccaCodeConst.CODE_INHOS_INVOICE); // 住院
				ip_newRelDO.setId_inccaitm(ipinccaitm);
				ip_newRelDO.setId_srv(medSrvDO.getId_srv());
				ip_newRelDO.setStatus(DOStatus.NEW);
				relCudSer.save(new IncCaItmRelDO[] { ip_newRelDO });
			} else { // 住院票据项目对象有对照，则做比较，如果修改了 ，先删除，再插入
				for (IncCaItmRelDO qryDO : ipQryList) {
					if (qryDO.getId_incca().equals(IBdInccaCodeConst.ID_INHOS_INVOICE)) {
						if (!ipinccaitm.equals(qryDO.getId_inccaitm())) {
							qryDO.setStatus(DOStatus.DELETED);
							delList_ip.add(qryDO);
						}
					}
				}
				if (delList_ip != null && delList_ip.size() > 0) {
					// 只有待删除列表不为空，说明需要删除旧的，插入新的数据；如果待删除列表为空，表示数据未变化则不用处理
					IncCaItmRelDO ipRelDO = new IncCaItmRelDO();
					ipRelDO.setId_grp(Context.get().getGroupId());
					ipRelDO.setId_org(Context.get().getOrgId());
					ipRelDO.setId_srv(medSrvDO.getId_srv());
					ipRelDO.setId_incca(IBdInccaCodeConst.ID_INHOS_INVOICE);// 住院
					ipRelDO.setSd_incca(IBdInccaCodeConst.CODE_INHOS_INVOICE);// 住院
					ipRelDO.setId_inccaitm(ipinccaitm);
					ipRelDO.setStatus(DOStatus.NEW);
					newList.add(ipRelDO);
				}
			}
			relCudSer.delete(delList_ip.toArray(new IncCaItmRelDO[] {}));
			relCudSer.delete(delList_op.toArray(new IncCaItmRelDO[] {}));
			relCudSer.save(newList.toArray(new IncCaItmRelDO[] {}));
		}
		// **********************************************************************************
	}

	/**
	 * 发送IE事件
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void FireIEMessage(MedSrvDO medSrvDO) throws BizException {
		// 发送事件
		MedSrvEventDTO medSrvEventDTO = this.getMedSrvDTO(medSrvDO);
		BdPpEvent bdPpEvent = new BdPpEvent();
		if (DOStatus.NEW == medSrvDO.getStatus()) {
			bdPpEvent.invokePriSrv(medSrvEventDTO, IEventType.TYPE_INSERT_AFTER);
		} else if (DOStatus.UPDATED == medSrvDO.getStatus()) {
			bdPpEvent.invokePriSrv(medSrvEventDTO, IEventType.TYPE_UPDATE_AFTER);
		}
	}

	/**
	 * 修改本服务定价模服务的计价数据
	 */
	public PriSrvDO[] saveSrvPriInfo(PriSrvDO[] dos) throws BizException {
		if (dos == null || dos.length == 0)
			return new PriSrvDO[] {};
		String id_srv = dos[0].getId_srv();
		// 获取对应服务
		IMedsrvMDORService rservice = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO medSrvDO = rservice.findById(id_srv);
		if (medSrvDO == null) {
			throw new BizException("对应的服务不存在！");
		}
		IPrisrvCudService service = ServiceFinder.find(IPrisrvCudService.class);
		if (dos.length == 1 && dos[0].getStatus() == DOStatus.UPDATED) {
			TimeZone currentTimeZone = Calendar.getInstance().getTimeZone();
			String dt_e = dos[0].getDt_e().toString(currentTimeZone, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			if (!"2099-12-31 23:59:59".equals(dt_e)) {
				throw new BizException("服务" + medSrvDO.getName() + "有且只能有一条本服务定价数据的结束时间为空或2099-12-31 23:59:59");
			}
		} else {
			Integer count = 0;
			for (PriSrvDO priSrvDO : dos) {
				if (DOStatus.DELETED == priSrvDO.getStatus())
					continue;
				if (priSrvDO.getDt_e() == null || priSrvDO.getDt_e().equals(new FDateTime("2099-12-31 23:59:59"))) {
					count++;
				}
				if (priSrvDO.getDt_e() == null) {
					priSrvDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
				}
			}
			if (count >= 2) {
				throw new BizException("服务" + medSrvDO.getName() + "有且只能有一条本服务定价数据的结束时间为空或2099-12-31 23:59:59");
			}
		}
		PriSrvDO[] priSrvDOArr = service.save(dos);
		// 获取服务当前价格
		// IPriCalService pservice = ServiceFinder.find(IPriCalService.class);
		// FDouble price = pservice.CalSingleSrvStdPrice_NameTip(id_srv, null);
		FDouble price = this.getSrvPrice(priSrvDOArr);
		// 修改服务中价格字段
		IMedsrvMDOCudService cservice = ServiceFinder.find(IMedsrvMDOCudService.class);
		medSrvDO.setPri(price);
		medSrvDO.setStatus(DOStatus.UPDATED);
		cservice.save(new MedSrvDO[] { medSrvDO });

		// 发送事件
		MedSrvEventDTO medSrvEventDTO = this.getMedSrvDTO(medSrvDO);
		BdPpEvent bdPpEvent = new BdPpEvent();
		bdPpEvent.invokePriSrv(medSrvEventDTO, IEventType.TYPE_UPDATE_AFTER);

		return priSrvDOArr;
	}

	/**
	 * 获取当前服务价格
	 */
	public FDouble getSrvPrice(PriSrvDO[] priSrvDOArr) {
		// 获取当前服务器时间
		TimeService timeService = new TimeServiceImpl();
		FDateTime dateTime = timeService.getUFDateTime();
		PriSrvDO priSrv = null;
		for (PriSrvDO priSrvDO : priSrvDOArr) {
			if (priSrvDO.getDt_e() == null) {
				priSrvDO.setDt_e(new FDateTime("2099-12-31 23:59:59"));
			}
			if (priSrv == null) {
				priSrv = priSrvDO;
			} else if (dateTime.after(priSrvDO.getDt_b()) && dateTime.before(priSrvDO.getDt_e())) {
				if (priSrvDO.getDt_e().before(priSrv.getDt_e())) {
					priSrv = priSrvDO;
				}
			}
		}
		if (priSrv == null) {
			return new FDouble(0);
		}
		return priSrv.getPrice();
	}

	/**
	 * 删除服务，并删除其对应价表数据，删除对应的票据分类项目对照关系数据
	 * 
	 * @throws BizException
	 */
	public FBoolean deleteMedSrvAndPrice(MedSrvDO medSrvDO) throws BizException {
		// 应该先删除引用服务的其他表的数据，再删除服务
		IPrisrvRService pService = ServiceFinder.find(IPrisrvRService.class);
		IPrisrvCudService rService = ServiceFinder.find(IPrisrvCudService.class);
		PriSrvDO[] priSrvDOArr = pService.find(" id_srv = '" + medSrvDO.getId_srv() + "'", null, FBoolean.FALSE);
		if (priSrvDOArr != null && priSrvDOArr.length > 0) {
			// rService.delete(priSrvDOArr);
			rService.logicDelete(priSrvDOArr);
		}

		// 同时删除该服务的票据分类项目对照关系
		IInccaitmrelCudService relCudSer = ServiceFinder.find(IInccaitmrelCudService.class);
		IInccaitmrelRService relRSer = ServiceFinder.find(IInccaitmrelRService.class);
		IncCaItmRelDO[] inccaItmRelDOs = relRSer.find(" id_srv='" + medSrvDO.getId_srv() + "'", "", FBoolean.FALSE);
		if (inccaItmRelDOs != null && inccaItmRelDOs.length > 0) {
			// relCudSer.delete(inccaItmRelDOs);
			relCudSer.logicDelete(inccaItmRelDOs);
		}

		// IMedsrvMDOCudService srvService =
		// ServiceFinder.find(IMedsrvMDOCudService.class);
		// srvService.delete(new MedSrvDO[]{medSrvDO});
		IMedsrvCudService medCudSer = ServiceFinder.find(IMedsrvCudService.class);
		IMedsrvRService medRSer = ServiceFinder.find(IMedsrvRService.class);
		MedsrvAggDO msAggDO = medRSer.findById(medSrvDO.getId_srv());
		// medCudSer.delete(new MedsrvAggDO[]{msAggDO});
		medCudSer.logicDelete(new MedsrvAggDO[] { msAggDO });

		// 发送事件
		MedSrvEventDTO medSrvEventDTO = this.getMedSrvDTO(medSrvDO);
		BdPpEvent bdPpEvent = new BdPpEvent();
		bdPpEvent.invokePriSrv(medSrvEventDTO, IEventType.TYPE_DELETE_AFTER);

		return FBoolean.TRUE;
	}

	/**
	 * 费用对照保存修改
	 * 
	 * @param <T>
	 */
	@SuppressWarnings("unchecked")
	public <T> MedSrvDO saveMedSrvPriSetInfo(MedSrvDO medSrvDO, FArrayList list) throws BizException {
		IMedsrvMDORService rservice = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO srvDO = rservice.findById(medSrvDO.getId_srv());
		if (!medSrvDO.getId_primd().equals(srvDO.getId_primd())
				|| !medSrvDO.getFg_active().equals(srvDO.getFg_active())) {
			if ((IBdPrimdCodeConst.ID_PRI_SRVSET_MU).equals(srvDO.getId_primd())) {
				IPrisrvsetmuRService murService = ServiceFinder.find(IPrisrvsetmuRService.class);
				PriSrvSetMuDO[] muSetDOArr = murService.find(" a0.id_srvset = '" + srvDO.getId_srv() + "'", "",
						FBoolean.FALSE);
				IPrisrvsetmuCudService mucService = ServiceFinder.find(IPrisrvsetmuCudService.class);
				mucService.delete(muSetDOArr);
			} else if ((IBdPrimdCodeConst.ID_PRI_SRVSET_FIX).equals(srvDO.getId_primd())) {
				IPrisrvsetfixRService fixrService = ServiceFinder.find(IPrisrvsetfixRService.class);
				PriSrvSetFixDO[] fixSetDOArr = fixrService.find(" a0.id_srvset = '" + srvDO.getId_srv() + "'", "",
						FBoolean.FALSE);
				IPrisrvsetfixCudService fixcService = ServiceFinder.find(IPrisrvsetfixCudService.class);
				fixcService.delete(fixSetDOArr);
			} else if ((IBdPrimdCodeConst.ID_PRI_SRV_COMP).equals(srvDO.getId_primd())) {
				IPrisrvcompRService corService = ServiceFinder.find(IPrisrvcompRService.class);
				PriSrvCompDO[] compSetDOArr = corService.find(" a0.id_srv = '" + srvDO.getId_srv() + "'", "",
						FBoolean.FALSE);
				IPrisrvcompCudService cocService = ServiceFinder.find(IPrisrvcompCudService.class);
				cocService.delete(compSetDOArr);
			}
			IMedsrvMDOCudService srvService = ServiceFinder.find(IMedsrvMDOCudService.class);
			medSrvDO.setStatus(DOStatus.UPDATED);
			MedSrvDO[] medSrvDOArr = srvService.save(new MedSrvDO[] { medSrvDO });
			medSrvDO = medSrvDOArr[0];
		}
		if (list == null) {
			return medSrvDO;
		}
		List<T> objList = new ArrayList<T>();
		for (Object obj : list) {
			objList.add((T) obj);
		}
		if ((IBdPrimdCodeConst.ID_PRI_SRVSET_MU).equals(medSrvDO.getId_primd())) {
			IPrisrvsetmuCudService mucService = ServiceFinder.find(IPrisrvsetmuCudService.class);
			mucService.save(objList.toArray(new PriSrvSetMuDO[] {}));
		} else if ((IBdPrimdCodeConst.ID_PRI_SRVSET_FIX).equals(medSrvDO.getId_primd())) {
			IPrisrvsetfixCudService fixcService = ServiceFinder.find(IPrisrvsetfixCudService.class);
			fixcService.save(objList.toArray(new PriSrvSetFixDO[] {}));
		} else if ((IBdPrimdCodeConst.ID_PRI_SRV_COMP).equals(medSrvDO.getId_primd())) {
			IPrisrvcompCudService cocService = ServiceFinder.find(IPrisrvcompCudService.class);
			cocService.save(objList.toArray(new PriSrvCompDO[] {}));
		}
		return medSrvDO;
	}

	/**
	 * 由服务主键id_srv查找得到服务的票据分类项目对照关系
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public IncCaItmRelDO[] findInccaItmNameByIdsrv(String id_srv, String id_incca) throws BizException {
		// TODO Auto-generated method stub
		IInccaitmrelRService relRSer = ServiceFinder.find(IInccaitmrelRService.class);
		IncCaItmRelDO[] incItmRels = relRSer
				.find(" id_srv='" + id_srv + "'  and id_incca='" + id_incca + "'  and ds=0 ", "", FBoolean.FALSE);
		return incItmRels;
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
		medSrvEventDTO.setPri(medSrvDO.getPri());
		medSrvEventDTO.setFg_active(medSrvDO.getFg_active());
		medSrvEventDTO.setFg_or(medSrvDO.getFg_or());
		medSrvEventDTO.setFg_mm(medSrvDO.getFg_mm());
		medSrvEventDTO.setFg_bl(medSrvDO.getFg_bl());

		return medSrvEventDTO;
	}
}
