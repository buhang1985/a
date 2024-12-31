package iih.ci.ord.s.external.thirdws.op.base;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.external.thirdws.apbu.d.EmsapbuentDTO;
import iih.ci.ord.i.external.thirdws.base.EmsCommonOrdDTO;
import iih.ci.ord.i.external.thirdws.base.EmsRstDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ConvertDTOs2XmlUtils;
import iih.ci.ord.s.external.thirdws.base.IEmsAssemble;
import iih.ci.ord.s.external.thirdws.base.IEmsSaveBP;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
/**
 * 保存动作
 * @author zhangwq
 *
 */
public class OpBaseSaveAction  implements IEmsSaveBP,IEmsAssemble{
	private EntWsDTO dataSource;
	private PatiVisitDO entdo;
	private OutpatientDO entopdo;
	private EntHpDO entHpdo;
	@Override
	public CiOrderDO assembleOrder(EmsCommonOrdDTO orddto) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdSrvDO assembleSrv(BaseDTO srvdto) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(EntWsDTO entwsdto) throws BizException {
		entdo = getEntDO(entwsdto.getCode_en());
		if(entdo == null){
			throw new BizException("传入的患者就诊信息不存在");
		}
		entopdo = getEnEntOpDO(entdo.getId_ent());
		if(entdo == null){
			throw new BizException("传入的患者门诊信息不存在");
		}
		this.entHpdo = this.getEntHpDO(entdo.getId_ent());
		return null;
	}
	/**
	 * 服务信息 
	 * @param srv_code
	 * @return
	 * @throws BizException
	 */
	public MedSrvDO getSrvDO(String srv_code) throws BizException{
		IMedsrvMDORService service = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] ordSrvDOs = service.findByAttrValString(MedSrvDO.CODE,srv_code);
		if(ordSrvDOs!=null && ordSrvDOs.length>0){
			MedSrvDO ordSrvDO = ordSrvDOs[0];
			return ordSrvDO;
		}
		return null;
	}
	/**
	 * @code 科室code 查id和name
	 * @param code_dep
	 * @return
	 * @throws BizException
	 */
	public DeptDO getDep(String code_dep) throws BizException {
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptDOs = service.findByAttrValString(DeptDO.CODE, code_dep);
		if(deptDOs!=null && deptDOs.length>0) {
			return deptDOs[0];
		}
		return null;
	}
	/**
	 * 就诊信息
	 * @param en_code
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO getEntDO(String en_code) throws BizException{
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] entdos = service.findByAttrValString(PatiVisitDO.CODE,en_code);
		if(entdos!=null && entdos.length>0){
			PatiVisitDO entdo = entdos[0];
			return entdo;
		}
		return null;
	}
	/**
	 * 获得门诊就诊信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private OutpatientDO getEnEntOpDO(String id_ent) throws BizException{
		IOutpatientRService service = ServiceFinder.find(IOutpatientRService.class);
		OutpatientDO[] entiopdos = service.findByAttrValString(OutpatientDO.ID_ENT, id_ent);
		if(entiopdos!=null && entiopdos.length>0){
			return entiopdos[0];
		}
		return null;
	}
	/**
	 * 查询医保计划
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private EntHpDO getEntHpDO(String id_ent) throws BizException{
		IEnthpRService service = ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] enthps = service.findByAttrValString(EntHpDO.ID_ENT,id_ent);
		if(enthps!=null && enthps.length>0){
			return enthps[0];
		}
		return new EntHpDO();
	}
	public EntWsDTO getDataSource() {
		return dataSource;
	}

	public void setDataSource(EntWsDTO dataSource) {
		this.dataSource = dataSource;
	}

	public PatiVisitDO getEntdo() {
		return entdo;
	}

	public void setEntdo(PatiVisitDO entdo) {
		this.entdo = entdo;
	}

	public OutpatientDO getEntopdo() {
		return entopdo;
	}

	public void setEntopdo(OutpatientDO entopdo) {
		this.entopdo = entopdo;
	}

	public EntHpDO getEntHpdo() {
		return entHpdo;
	}

	public void setEntHpdo(EntHpDO entHpdo) {
		this.entHpdo = entHpdo;
	}
	public String rstMsg(EmsRstDTO rstdto) throws BizException {
		ConvertDTOs2XmlUtils utils = new ConvertDTOs2XmlUtils();
		return utils.exec(new EmsRstDTO[]{rstdto}, "root", "");
	}
}
